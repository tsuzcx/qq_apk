package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private int YVt;
  private a YVu;
  private boolean fVK;
  
  public p(String paramString, int paramInt)
  {
    AppMethodBeat.i(222594);
    this.YVt = 0;
    this.fVK = true;
    this.YVu = null;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.YVt = 1;
    baseRequset(localHashMap1);
    localHashMap1.put("type", com.tencent.mm.compatible.util.q.aT("1"));
    localHashMap1.put("id_no", com.tencent.mm.compatible.util.q.aT(paramString));
    localHashMap1.put("id_type", com.tencent.mm.compatible.util.q.aT(String.valueOf(paramInt)));
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(222594);
  }
  
  public p(String paramString1, String paramString2, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(72785);
    this.YVt = 0;
    this.fVK = true;
    this.YVu = null;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.fVK = paramBoolean;
    this.YVt = 2;
    baseRequset(localHashMap1);
    localHashMap1.put("type", com.tencent.mm.compatible.util.q.aT("2"));
    localHashMap1.put("crt_sms", com.tencent.mm.compatible.util.q.aT(paramString1));
    localHashMap1.put("reqkey", com.tencent.mm.compatible.util.q.aT(paramString2));
    this.YVu = parama;
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(72785);
  }
  
  public p(String paramString1, String paramString2, String paramString3, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(72786);
    this.YVt = 0;
    this.fVK = true;
    this.YVu = null;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.YVt = 4;
    this.YVu = parama;
    this.fVK = paramBoolean;
    baseRequset(localHashMap1);
    localHashMap1.put("type", com.tencent.mm.compatible.util.q.aT("4"));
    localHashMap1.put("id_type", com.tencent.mm.compatible.util.q.aT(paramString1));
    localHashMap1.put("cre_tail", com.tencent.mm.compatible.util.q.aT(paramString2));
    localHashMap1.put("reqkey", com.tencent.mm.compatible.util.q.aT(paramString3));
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(72786);
  }
  
  private static void baseRequset(Map<String, String> paramMap)
  {
    int k = 0;
    AppMethodBeat.i(72783);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE();
    Object localObject3 = com.tencent.mm.b.p.getString(com.tencent.mm.kernel.b.getUin());
    String str1 = com.tencent.mm.compatible.deviceinfo.q.dR(false);
    byte[] arrayOfByte = new byte[16];
    Object localObject2 = y.iiR().getBytes();
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
    localObject3 = b.iiL();
    com.tencent.mm.wallet_core.b.iie();
    i = k;
    if (com.tencent.mm.wallet_core.b.iih()) {
      i = 1;
    }
    localObject3 = ((b)localObject3).ia(str2, i);
    try
    {
      paramMap.put("sn_salt", com.tencent.mm.compatible.util.q.aT((String)localObject1));
      paramMap.put("crt_csr", com.tencent.mm.compatible.util.q.aT((String)localObject3));
      paramMap.put("crt_device_id", localObject2);
      paramMap.put("device_os", d.kQZ);
      paramMap.put("device_name", d.RAz);
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
    return this.fVK;
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
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(414L, 0L, 1L, true);
        boolean bool = b.iiL().importCert(paramJSONObject, paramString);
        ad.bCk(paramJSONObject);
        if (bool)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(414L, 1L, 1L, true);
          Log.i("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt success");
          if (this.YVt == 1)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(13731, new Object[] { Integer.valueOf(3) });
            Log.i("MicroMsg.NetSceneGendigitalcert", "_crt_crt %s _crt_no %s", new Object[] { MD5Util.getMD5String(paramString), paramJSONObject });
            AppMethodBeat.o(72787);
          }
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(414L, 2L, 1L, true);
          Log.e("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt fail");
          continue;
        }
        if (this.YVt != 2) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneGendigitalcert", paramString, "", new Object[0]);
        AppMethodBeat.o(72787);
        return;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(13731, new Object[] { Integer.valueOf(7) });
    }
  }
  
  public final void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72788);
    b.iiL().iiM();
    if (parame.errCode != 0)
    {
      if (this.YVt != 1) {
        break label85;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(13731, new Object[] { Integer.valueOf(4) });
    }
    for (;;)
    {
      if ((this.YVu != null) && ((!this.fVK) || (parame.errCode == 0))) {
        this.YVu.gLU();
      }
      AppMethodBeat.o(72788);
      return;
      label85:
      if (this.YVt == 2) {
        com.tencent.mm.plugin.report.service.h.IzE.a(13731, new Object[] { Integer.valueOf(8) });
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void gLU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.p
 * JD-Core Version:    0.7.0.1
 */