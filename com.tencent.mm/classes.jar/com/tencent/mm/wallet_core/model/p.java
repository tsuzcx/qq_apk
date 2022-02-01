package com.tencent.mm.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p
  extends m
{
  private int agTn;
  private a agTo;
  private boolean ibK;
  
  public p(String paramString, int paramInt)
  {
    AppMethodBeat.i(242141);
    this.agTn = 0;
    this.ibK = true;
    this.agTo = null;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.agTn = 1;
    baseRequset(localHashMap1);
    localHashMap1.put("type", r.cg("1"));
    localHashMap1.put("id_no", r.cg(paramString));
    localHashMap1.put("id_type", r.cg(String.valueOf(paramInt)));
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(242141);
  }
  
  public p(String paramString1, String paramString2, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(72785);
    this.agTn = 0;
    this.ibK = true;
    this.agTo = null;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.ibK = paramBoolean;
    this.agTn = 2;
    baseRequset(localHashMap1);
    localHashMap1.put("type", r.cg("2"));
    localHashMap1.put("crt_sms", r.cg(paramString1));
    localHashMap1.put("reqkey", r.cg(paramString2));
    this.agTo = parama;
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(72785);
  }
  
  public p(String paramString1, String paramString2, String paramString3, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(72786);
    this.agTn = 0;
    this.ibK = true;
    this.agTo = null;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.agTn = 4;
    this.agTo = parama;
    this.ibK = paramBoolean;
    baseRequset(localHashMap1);
    localHashMap1.put("type", r.cg("4"));
    localHashMap1.put("id_type", r.cg(paramString1));
    localHashMap1.put("cre_tail", r.cg(paramString2));
    localHashMap1.put("reqkey", r.cg(paramString3));
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(72786);
  }
  
  private static void baseRequset(Map<String, String> paramMap)
  {
    int k = 0;
    AppMethodBeat.i(72783);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC();
    Object localObject3 = com.tencent.mm.b.p.getString(com.tencent.mm.kernel.b.getUin());
    String str1 = q.eD(false);
    byte[] arrayOfByte = new byte[16];
    Object localObject2 = y.jON().getBytes();
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > 0) {}
    }
    else
    {
      localObject1 = System.currentTimeMillis().getBytes();
    }
    int j = 0;
    int i = 0;
    int m;
    do
    {
      arrayOfByte[i] = localObject1[j];
      m = i + 1;
      j += 1;
      i = j;
      if (j >= localObject1.length) {
        i = 0;
      }
      j = i;
      i = m;
    } while (m < 16);
    Object localObject1 = new String(arrayOfByte);
    localObject2 = MD5Util.getMD5String((String)localObject3 + str1);
    String str2 = MD5Util.getMD5String((String)localObject3 + (String)localObject2 + new String(arrayOfByte));
    Log.i("MicroMsg.NetSceneGendigitalcert", "salt " + new String(arrayOfByte));
    Log.i("MicroMsg.NetSceneGendigitalcert", "crt_csr uin: %s: devideid: %s crt: %s", new Object[] { localObject3, str1, str2 });
    localObject3 = b.jOG();
    com.tencent.mm.wallet_core.b.jNX();
    i = k;
    if (com.tencent.mm.wallet_core.b.jOa()) {
      i = 1;
    }
    localObject3 = ((b)localObject3).jm(str2, i);
    try
    {
      paramMap.put("sn_salt", r.cg((String)localObject1));
      paramMap.put("crt_csr", r.cg((String)localObject3));
      paramMap.put("crt_device_id", localObject2);
      paramMap.put("device_os", d.nsC);
      paramMap.put("device_name", d.Yxd);
      AppMethodBeat.o(72783);
      return;
    }
    catch (Exception paramMap)
    {
      AppMethodBeat.o(72783);
    }
  }
  
  public final int getFuncId()
  {
    return 1580;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1580;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/gendigitalcert";
  }
  
  public final boolean isBlock()
  {
    return this.ibK;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72787);
    Log.i("MicroMsg.NetSceneGendigitalcert", "errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt), paramString });
    for (;;)
    {
      try
      {
        paramString = paramJSONObject.optString("crt_crt");
        paramJSONObject = paramJSONObject.optString("crt_no");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(414L, 0L, 1L, true);
        boolean bool = b.jOG().importCert(paramJSONObject, paramString);
        ae.bEF(paramJSONObject);
        if (bool)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(414L, 1L, 1L, true);
          Log.i("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt success");
          if (this.agTn == 1)
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(13731, new Object[] { Integer.valueOf(3) });
            Log.i("MicroMsg.NetSceneGendigitalcert", "_crt_crt %s _crt_no %s", new Object[] { MD5Util.getMD5String(paramString), paramJSONObject });
            AppMethodBeat.o(72787);
          }
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(414L, 2L, 1L, true);
          Log.e("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt fail");
          continue;
        }
        if (this.agTn != 2) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneGendigitalcert", paramString, "", new Object[0]);
        AppMethodBeat.o(72787);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(13731, new Object[] { Integer.valueOf(7) });
    }
  }
  
  public final void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72788);
    b.jOG().jOH();
    if (parame.errCode != 0)
    {
      if (this.agTn != 1) {
        break label85;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(13731, new Object[] { Integer.valueOf(4) });
    }
    for (;;)
    {
      if ((this.agTo != null) && ((!this.ibK) || (parame.errCode == 0))) {
        this.agTo.ilk();
      }
      AppMethodBeat.o(72788);
      return;
      label85:
      if (this.agTn == 2) {
        com.tencent.mm.plugin.report.service.h.OAn.b(13731, new Object[] { Integer.valueOf(8) });
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void ilk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.p
 * JD-Core Version:    0.7.0.1
 */