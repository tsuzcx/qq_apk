package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends m
{
  private int AWW;
  private n.a AWX;
  private boolean cHT;
  
  public n(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(49064);
    this.AWW = 0;
    this.cHT = true;
    this.AWX = null;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.AWW = 1;
    baseRequset(localHashMap1);
    localHashMap1.put("type", com.tencent.mm.compatible.util.q.encode("1"));
    localHashMap1.put("true_name", com.tencent.mm.compatible.util.q.encode(paramString2));
    localHashMap1.put("id_no", com.tencent.mm.compatible.util.q.encode(paramString1));
    localHashMap1.put("id_type", com.tencent.mm.compatible.util.q.encode(String.valueOf(paramInt)));
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(49064);
  }
  
  public n(String paramString1, String paramString2, n.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(49065);
    this.AWW = 0;
    this.cHT = true;
    this.AWX = null;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.cHT = paramBoolean;
    this.AWW = 2;
    baseRequset(localHashMap1);
    localHashMap1.put("type", com.tencent.mm.compatible.util.q.encode("2"));
    localHashMap1.put("crt_sms", com.tencent.mm.compatible.util.q.encode(paramString1));
    localHashMap1.put("reqkey", com.tencent.mm.compatible.util.q.encode(paramString2));
    this.AWX = parama;
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(49065);
  }
  
  public n(String paramString1, String paramString2, String paramString3, n.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(49066);
    this.AWW = 0;
    this.cHT = true;
    this.AWX = null;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.AWW = 4;
    this.AWX = parama;
    this.cHT = paramBoolean;
    baseRequset(localHashMap1);
    localHashMap1.put("type", com.tencent.mm.compatible.util.q.encode("4"));
    localHashMap1.put("id_type", com.tencent.mm.compatible.util.q.encode(paramString1));
    localHashMap1.put("cre_tail", com.tencent.mm.compatible.util.q.encode(paramString2));
    localHashMap1.put("reqkey", com.tencent.mm.compatible.util.q.encode(paramString3));
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(49066);
  }
  
  private static void baseRequset(Map<String, String> paramMap)
  {
    int k = 0;
    AppMethodBeat.i(49063);
    g.RM();
    g.RJ();
    Object localObject3 = p.getString(a.getUin());
    String str1 = com.tencent.mm.compatible.e.q.bP(false);
    byte[] arrayOfByte = new byte[16];
    Object localObject2 = w.dSo().getBytes();
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
    localObject2 = ag.cE((String)localObject3 + str1);
    String str2 = ag.cE((String)localObject3 + (String)localObject2 + new String(arrayOfByte));
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneGendigitalcert", "salt " + new String(arrayOfByte));
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneGendigitalcert", "crt_csr uin: %s: devideid: %s crt: %s", new Object[] { localObject3, str1, str2 });
    localObject3 = b.dSi();
    com.tencent.mm.wallet_core.b.dRI();
    i = k;
    if (com.tencent.mm.wallet_core.b.dRL()) {
      i = 1;
    }
    localObject3 = ((b)localObject3).eY(str2, i);
    try
    {
      paramMap.put("sn_salt", com.tencent.mm.compatible.util.q.encode((String)localObject1));
      paramMap.put("crt_csr", com.tencent.mm.compatible.util.q.encode((String)localObject3));
      paramMap.put("crt_device_id", localObject2);
      paramMap.put("device_os", com.tencent.mm.protocal.d.eQs);
      paramMap.put("device_name", com.tencent.mm.protocal.d.whE);
      AppMethodBeat.o(49063);
      return;
    }
    catch (Exception paramMap)
    {
      AppMethodBeat.o(49063);
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
    return this.cHT;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(49067);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneGendigitalcert", "errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt), paramString });
    for (;;)
    {
      try
      {
        paramString = paramJSONObject.optString("crt_crt");
        paramJSONObject = paramJSONObject.optString("crt_no");
        h.qsU.idkeyStat(414L, 0L, 1L, true);
        boolean bool = b.dSi().importCert(paramJSONObject, paramString);
        ab.avX(paramJSONObject);
        if (bool)
        {
          h.qsU.idkeyStat(414L, 1L, 1L, true);
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt success");
          if (this.AWW == 1)
          {
            h.qsU.e(13731, new Object[] { Integer.valueOf(3) });
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneGendigitalcert", "_crt_crt %s _crt_no %s", new Object[] { ag.cE(paramString), paramJSONObject });
            AppMethodBeat.o(49067);
          }
        }
        else
        {
          h.qsU.idkeyStat(414L, 2L, 1L, true);
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt fail");
          continue;
        }
        if (this.AWW != 2) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NetSceneGendigitalcert", paramString, "", new Object[0]);
        AppMethodBeat.o(49067);
        return;
      }
      h.qsU.e(13731, new Object[] { Integer.valueOf(7) });
    }
  }
  
  public final void onGYNetEnd2(d paramd, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(49068);
    b.dSi().dSj();
    if (paramd.errCode != 0)
    {
      if (this.AWW != 1) {
        break label85;
      }
      h.qsU.e(13731, new Object[] { Integer.valueOf(4) });
    }
    for (;;)
    {
      if ((this.AWX != null) && ((!this.cHT) || (paramd.errCode == 0))) {
        this.AWX.cWd();
      }
      AppMethodBeat.o(49068);
      return;
      label85:
      if (this.AWW == 2) {
        h.qsU.e(13731, new Object[] { Integer.valueOf(8) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.n
 * JD-Core Version:    0.7.0.1
 */