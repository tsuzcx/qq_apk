package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p
  extends m
{
  private int JFl;
  private a JFm;
  private boolean dwv;
  
  public p(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(72784);
    this.JFl = 0;
    this.dwv = true;
    this.JFm = null;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.JFl = 1;
    baseRequset(localHashMap1);
    localHashMap1.put("type", com.tencent.mm.compatible.util.p.encode("1"));
    if (paramString2 == null) {}
    for (paramString2 = "";; paramString2 = com.tencent.mm.compatible.util.p.encode(paramString2))
    {
      localHashMap1.put("true_name", paramString2);
      localHashMap1.put("id_no", com.tencent.mm.compatible.util.p.encode(paramString1));
      localHashMap1.put("id_type", com.tencent.mm.compatible.util.p.encode(String.valueOf(paramInt)));
      setRequestData(localHashMap1);
      setWXRequestData(localHashMap2);
      AppMethodBeat.o(72784);
      return;
    }
  }
  
  public p(String paramString1, String paramString2, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(72785);
    this.JFl = 0;
    this.dwv = true;
    this.JFm = null;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.dwv = paramBoolean;
    this.JFl = 2;
    baseRequset(localHashMap1);
    localHashMap1.put("type", com.tencent.mm.compatible.util.p.encode("2"));
    localHashMap1.put("crt_sms", com.tencent.mm.compatible.util.p.encode(paramString1));
    localHashMap1.put("reqkey", com.tencent.mm.compatible.util.p.encode(paramString2));
    this.JFm = parama;
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(72785);
  }
  
  public p(String paramString1, String paramString2, String paramString3, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(72786);
    this.JFl = 0;
    this.dwv = true;
    this.JFm = null;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.JFl = 4;
    this.JFm = parama;
    this.dwv = paramBoolean;
    baseRequset(localHashMap1);
    localHashMap1.put("type", com.tencent.mm.compatible.util.p.encode("4"));
    localHashMap1.put("id_type", com.tencent.mm.compatible.util.p.encode(paramString1));
    localHashMap1.put("cre_tail", com.tencent.mm.compatible.util.p.encode(paramString2));
    localHashMap1.put("reqkey", com.tencent.mm.compatible.util.p.encode(paramString3));
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(72786);
  }
  
  private static void baseRequset(Map<String, String> paramMap)
  {
    int k = 0;
    AppMethodBeat.i(72783);
    g.agS();
    g.agP();
    Object localObject3 = com.tencent.mm.b.p.getString(a.getUin());
    String str1 = q.cF(false);
    byte[] arrayOfByte = new byte[16];
    Object localObject2 = y.fAm().getBytes();
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
    localObject2 = ah.dg((String)localObject3 + str1);
    String str2 = ah.dg((String)localObject3 + (String)localObject2 + new String(arrayOfByte));
    ac.i("MicroMsg.NetSceneGendigitalcert", "salt " + new String(arrayOfByte));
    ac.i("MicroMsg.NetSceneGendigitalcert", "crt_csr uin: %s: devideid: %s crt: %s", new Object[] { localObject3, str1, str2 });
    localObject3 = b.fAg();
    com.tencent.mm.wallet_core.b.fzz();
    i = k;
    if (com.tencent.mm.wallet_core.b.fzC()) {
      i = 1;
    }
    localObject3 = ((b)localObject3).gq(str2, i);
    try
    {
      paramMap.put("sn_salt", com.tencent.mm.compatible.util.p.encode((String)localObject1));
      paramMap.put("crt_csr", com.tencent.mm.compatible.util.p.encode((String)localObject3));
      paramMap.put("crt_device_id", localObject2);
      paramMap.put("device_os", d.gMK);
      paramMap.put("device_name", d.DHZ);
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
    return this.dwv;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72787);
    ac.i("MicroMsg.NetSceneGendigitalcert", "errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt), paramString });
    for (;;)
    {
      try
      {
        paramString = paramJSONObject.optString("crt_crt");
        paramJSONObject = paramJSONObject.optString("crt_no");
        h.wUl.idkeyStat(414L, 0L, 1L, true);
        boolean bool = b.fAg().importCert(paramJSONObject, paramString);
        ad.aSD(paramJSONObject);
        if (bool)
        {
          h.wUl.idkeyStat(414L, 1L, 1L, true);
          ac.i("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt success");
          if (this.JFl == 1)
          {
            h.wUl.f(13731, new Object[] { Integer.valueOf(3) });
            ac.i("MicroMsg.NetSceneGendigitalcert", "_crt_crt %s _crt_no %s", new Object[] { ah.dg(paramString), paramJSONObject });
            AppMethodBeat.o(72787);
          }
        }
        else
        {
          h.wUl.idkeyStat(414L, 2L, 1L, true);
          ac.e("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt fail");
          continue;
        }
        if (this.JFl != 2) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.NetSceneGendigitalcert", paramString, "", new Object[0]);
        AppMethodBeat.o(72787);
        return;
      }
      h.wUl.f(13731, new Object[] { Integer.valueOf(7) });
    }
  }
  
  public final void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72788);
    b.fAg().fAh();
    if (parame.errCode != 0)
    {
      if (this.JFl != 1) {
        break label85;
      }
      h.wUl.f(13731, new Object[] { Integer.valueOf(4) });
    }
    for (;;)
    {
      if ((this.JFm != null) && ((!this.dwv) || (parame.errCode == 0))) {
        this.JFm.etT();
      }
      AppMethodBeat.o(72788);
      return;
      label85:
      if (this.JFl == 2) {
        h.wUl.f(13731, new Object[] { Integer.valueOf(8) });
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void etT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.p
 * JD-Core Version:    0.7.0.1
 */