package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
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
  private int RtU;
  private a RtV;
  private boolean ebI;
  
  public p(String paramString, int paramInt)
  {
    AppMethodBeat.i(214333);
    this.RtU = 0;
    this.ebI = true;
    this.RtV = null;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.RtU = 1;
    baseRequset(localHashMap1);
    localHashMap1.put("type", com.tencent.mm.compatible.util.q.encode("1"));
    localHashMap1.put("id_no", com.tencent.mm.compatible.util.q.encode(paramString));
    localHashMap1.put("id_type", com.tencent.mm.compatible.util.q.encode(String.valueOf(paramInt)));
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(214333);
  }
  
  public p(String paramString1, String paramString2, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(72785);
    this.RtU = 0;
    this.ebI = true;
    this.RtV = null;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.ebI = paramBoolean;
    this.RtU = 2;
    baseRequset(localHashMap1);
    localHashMap1.put("type", com.tencent.mm.compatible.util.q.encode("2"));
    localHashMap1.put("crt_sms", com.tencent.mm.compatible.util.q.encode(paramString1));
    localHashMap1.put("reqkey", com.tencent.mm.compatible.util.q.encode(paramString2));
    this.RtV = parama;
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(72785);
  }
  
  public p(String paramString1, String paramString2, String paramString3, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(72786);
    this.RtU = 0;
    this.ebI = true;
    this.RtV = null;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.RtU = 4;
    this.RtV = parama;
    this.ebI = paramBoolean;
    baseRequset(localHashMap1);
    localHashMap1.put("type", com.tencent.mm.compatible.util.q.encode("4"));
    localHashMap1.put("id_type", com.tencent.mm.compatible.util.q.encode(paramString1));
    localHashMap1.put("cre_tail", com.tencent.mm.compatible.util.q.encode(paramString2));
    localHashMap1.put("reqkey", com.tencent.mm.compatible.util.q.encode(paramString3));
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(72786);
  }
  
  private static void baseRequset(Map<String, String> paramMap)
  {
    int k = 0;
    AppMethodBeat.i(72783);
    g.aAi();
    g.aAf();
    Object localObject3 = com.tencent.mm.b.p.getString(a.getUin());
    String str1 = com.tencent.mm.compatible.deviceinfo.q.dr(false);
    byte[] arrayOfByte = new byte[16];
    Object localObject2 = y.hhp().getBytes();
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
    localObject3 = b.hhj();
    com.tencent.mm.wallet_core.b.hgC();
    i = k;
    if (com.tencent.mm.wallet_core.b.hgF()) {
      i = 1;
    }
    localObject3 = ((b)localObject3).hr(str2, i);
    try
    {
      paramMap.put("sn_salt", com.tencent.mm.compatible.util.q.encode((String)localObject1));
      paramMap.put("crt_csr", com.tencent.mm.compatible.util.q.encode((String)localObject3));
      paramMap.put("crt_device_id", localObject2);
      paramMap.put("device_os", d.ics);
      paramMap.put("device_name", d.KyL);
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
    return this.ebI;
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
        h.CyF.idkeyStat(414L, 0L, 1L, true);
        boolean bool = b.hhj().importCert(paramJSONObject, paramString);
        ad.bpn(paramJSONObject);
        if (bool)
        {
          h.CyF.idkeyStat(414L, 1L, 1L, true);
          Log.i("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt success");
          if (this.RtU == 1)
          {
            h.CyF.a(13731, new Object[] { Integer.valueOf(3) });
            Log.i("MicroMsg.NetSceneGendigitalcert", "_crt_crt %s _crt_no %s", new Object[] { MD5Util.getMD5String(paramString), paramJSONObject });
            AppMethodBeat.o(72787);
          }
        }
        else
        {
          h.CyF.idkeyStat(414L, 2L, 1L, true);
          Log.e("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt fail");
          continue;
        }
        if (this.RtU != 2) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneGendigitalcert", paramString, "", new Object[0]);
        AppMethodBeat.o(72787);
        return;
      }
      h.CyF.a(13731, new Object[] { Integer.valueOf(7) });
    }
  }
  
  public final void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72788);
    b.hhj().hhk();
    if (parame.errCode != 0)
    {
      if (this.RtU != 1) {
        break label85;
      }
      h.CyF.a(13731, new Object[] { Integer.valueOf(4) });
    }
    for (;;)
    {
      if ((this.RtV != null) && ((!this.ebI) || (parame.errCode == 0))) {
        this.RtV.fTo();
      }
      AppMethodBeat.o(72788);
      return;
      label85:
      if (this.RtU == 2) {
        h.CyF.a(13731, new Object[] { Integer.valueOf(8) });
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void fTo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.p
 * JD-Core Version:    0.7.0.1
 */