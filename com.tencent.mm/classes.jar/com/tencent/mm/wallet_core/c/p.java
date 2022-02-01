package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p
  extends m
{
  private int LVe;
  private a LVf;
  private boolean dJV;
  
  public p(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(72784);
    this.LVe = 0;
    this.dJV = true;
    this.LVf = null;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.LVe = 1;
    baseRequset(localHashMap1);
    localHashMap1.put("type", com.tencent.mm.compatible.util.q.encode("1"));
    if (paramString2 == null) {}
    for (paramString2 = "";; paramString2 = com.tencent.mm.compatible.util.q.encode(paramString2))
    {
      localHashMap1.put("true_name", paramString2);
      localHashMap1.put("id_no", com.tencent.mm.compatible.util.q.encode(paramString1));
      localHashMap1.put("id_type", com.tencent.mm.compatible.util.q.encode(String.valueOf(paramInt)));
      setRequestData(localHashMap1);
      setWXRequestData(localHashMap2);
      AppMethodBeat.o(72784);
      return;
    }
  }
  
  public p(String paramString1, String paramString2, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(72785);
    this.LVe = 0;
    this.dJV = true;
    this.LVf = null;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.dJV = paramBoolean;
    this.LVe = 2;
    baseRequset(localHashMap1);
    localHashMap1.put("type", com.tencent.mm.compatible.util.q.encode("2"));
    localHashMap1.put("crt_sms", com.tencent.mm.compatible.util.q.encode(paramString1));
    localHashMap1.put("reqkey", com.tencent.mm.compatible.util.q.encode(paramString2));
    this.LVf = parama;
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(72785);
  }
  
  public p(String paramString1, String paramString2, String paramString3, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(72786);
    this.LVe = 0;
    this.dJV = true;
    this.LVf = null;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.LVe = 4;
    this.LVf = parama;
    this.dJV = paramBoolean;
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
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajP();
    Object localObject3 = com.tencent.mm.b.p.getString(a.getUin());
    String str1 = com.tencent.mm.compatible.deviceinfo.q.cH(false);
    byte[] arrayOfByte = new byte[16];
    Object localObject2 = y.fVS().getBytes();
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
    localObject2 = aj.ej((String)localObject3 + str1);
    String str2 = aj.ej((String)localObject3 + (String)localObject2 + new String(arrayOfByte));
    ae.i("MicroMsg.NetSceneGendigitalcert", "salt " + new String(arrayOfByte));
    ae.i("MicroMsg.NetSceneGendigitalcert", "crt_csr uin: %s: devideid: %s crt: %s", new Object[] { localObject3, str1, str2 });
    localObject3 = b.fVM();
    com.tencent.mm.wallet_core.b.fVf();
    i = k;
    if (com.tencent.mm.wallet_core.b.fVi()) {
      i = 1;
    }
    localObject3 = ((b)localObject3).gW(str2, i);
    try
    {
      paramMap.put("sn_salt", com.tencent.mm.compatible.util.q.encode((String)localObject1));
      paramMap.put("crt_csr", com.tencent.mm.compatible.util.q.encode((String)localObject3));
      paramMap.put("crt_device_id", localObject2);
      paramMap.put("device_os", d.hjv);
      paramMap.put("device_name", d.FFE);
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
    return this.dJV;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72787);
    ae.i("MicroMsg.NetSceneGendigitalcert", "errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt), paramString });
    for (;;)
    {
      try
      {
        paramString = paramJSONObject.optString("crt_crt");
        paramJSONObject = paramJSONObject.optString("crt_no");
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(414L, 0L, 1L, true);
        boolean bool = b.fVM().importCert(paramJSONObject, paramString);
        ad.baf(paramJSONObject);
        if (bool)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(414L, 1L, 1L, true);
          ae.i("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt success");
          if (this.LVe == 1)
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(13731, new Object[] { Integer.valueOf(3) });
            ae.i("MicroMsg.NetSceneGendigitalcert", "_crt_crt %s _crt_no %s", new Object[] { aj.ej(paramString), paramJSONObject });
            AppMethodBeat.o(72787);
          }
        }
        else
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(414L, 2L, 1L, true);
          ae.e("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt fail");
          continue;
        }
        if (this.LVe != 2) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneGendigitalcert", paramString, "", new Object[0]);
        AppMethodBeat.o(72787);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(13731, new Object[] { Integer.valueOf(7) });
    }
  }
  
  public final void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72788);
    b.fVM().fVN();
    if (parame.errCode != 0)
    {
      if (this.LVe != 1) {
        break label85;
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(13731, new Object[] { Integer.valueOf(4) });
    }
    for (;;)
    {
      if ((this.LVf != null) && ((!this.dJV) || (parame.errCode == 0))) {
        this.LVf.eLH();
      }
      AppMethodBeat.o(72788);
      return;
      label85:
      if (this.LVe == 2) {
        com.tencent.mm.plugin.report.service.g.yxI.f(13731, new Object[] { Integer.valueOf(8) });
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void eLH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.p
 * JD-Core Version:    0.7.0.1
 */