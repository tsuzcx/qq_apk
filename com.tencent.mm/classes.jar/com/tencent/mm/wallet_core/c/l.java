package com.tencent.mm.wallet_core.c;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class l
  extends j
{
  public boolean bZB = true;
  private int wAs = 0;
  private l.a wAt = null;
  
  public l(String paramString1, int paramInt, String paramString2)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.wAs = 1;
    aA(localHashMap1);
    localHashMap1.put("type", com.tencent.mm.compatible.util.q.encode("1"));
    localHashMap1.put("true_name", com.tencent.mm.compatible.util.q.encode(paramString2));
    localHashMap1.put("id_no", com.tencent.mm.compatible.util.q.encode(paramString1));
    localHashMap1.put("id_type", com.tencent.mm.compatible.util.q.encode(String.valueOf(paramInt)));
    D(localHashMap1);
    aC(localHashMap2);
  }
  
  public l(String paramString1, String paramString2, l.a parama, boolean paramBoolean)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.bZB = paramBoolean;
    this.wAs = 2;
    aA(localHashMap1);
    localHashMap1.put("type", com.tencent.mm.compatible.util.q.encode("2"));
    localHashMap1.put("crt_sms", com.tencent.mm.compatible.util.q.encode(paramString1));
    localHashMap1.put("reqkey", com.tencent.mm.compatible.util.q.encode(paramString2));
    this.wAt = parama;
    D(localHashMap1);
    aC(localHashMap2);
  }
  
  public l(String paramString1, String paramString2, String paramString3, l.a parama, boolean paramBoolean)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.wAs = 4;
    this.wAt = parama;
    this.bZB = paramBoolean;
    aA(localHashMap1);
    localHashMap1.put("type", com.tencent.mm.compatible.util.q.encode("4"));
    localHashMap1.put("id_type", com.tencent.mm.compatible.util.q.encode(paramString1));
    localHashMap1.put("cre_tail", com.tencent.mm.compatible.util.q.encode(paramString2));
    localHashMap1.put("reqkey", com.tencent.mm.compatible.util.q.encode(paramString3));
    D(localHashMap1);
    aC(localHashMap2);
  }
  
  private static void aA(Map<String, String> paramMap)
  {
    int k = 1;
    g.DQ();
    g.DN();
    Object localObject3 = o.getString(com.tencent.mm.kernel.a.CK());
    Object localObject4 = com.tencent.mm.compatible.e.q.getDeviceID(ae.getContext());
    byte[] arrayOfByte = new byte[16];
    Object localObject2 = u.cMz().getBytes();
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
    localObject2 = ad.bB((String)localObject3 + (String)localObject4);
    String str = ad.bB((String)localObject3 + (String)localObject2 + new String(arrayOfByte));
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneGendigitalcert", "salt " + new String(arrayOfByte));
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneGendigitalcert", "crt_csr uin: %s: devideid: %s crt: %s", new Object[] { localObject3, localObject4, str });
    localObject3 = a.cMr();
    b.cMj();
    localObject4 = com.tencent.mm.model.c.c.IX().fJ("100369");
    if ((((com.tencent.mm.storage.c)localObject4).isValid()) && ("1".equals(((com.tencent.mm.storage.c)localObject4).ctr().get("open")))) {}
    for (i = 1;; i = 0)
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.TenPaySdkAbTest", "isCertOpen2048 %s", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        i = 1;
        if (i == 0) {
          break label406;
        }
      }
      label406:
      for (i = k;; i = 0)
      {
        localObject3 = ((a)localObject3).dO(str, i);
        try
        {
          paramMap.put("sn_salt", com.tencent.mm.compatible.util.q.encode((String)localObject1));
          paramMap.put("crt_csr", com.tencent.mm.compatible.util.q.encode((String)localObject3));
          paramMap.put("crt_device_id", localObject2);
          paramMap.put("device_os", com.tencent.mm.protocal.d.dOM);
          paramMap.put("device_name", com.tencent.mm.protocal.d.soX);
          return;
        }
        catch (Exception paramMap)
        {
          return;
        }
        i = 0;
        break;
      }
    }
  }
  
  public final int HH()
  {
    return 1580;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneGendigitalcert", "errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt), paramString });
    for (;;)
    {
      try
      {
        paramString = paramJSONObject.optString("crt_crt");
        paramJSONObject = paramJSONObject.optString("crt_no");
        h.nFQ.a(414L, 0L, 1L, true);
        boolean bool = a.cMr().importCert(paramJSONObject, paramString);
        y.afe(paramJSONObject);
        if (bool)
        {
          h.nFQ.a(414L, 1L, 1L, true);
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt success");
          if (this.wAs == 1)
          {
            h.nFQ.f(13731, new Object[] { Integer.valueOf(3) });
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneGendigitalcert", "_crt_crt %s _crt_no %s", new Object[] { ad.bB(paramString), paramJSONObject });
          }
        }
        else
        {
          h.nFQ.a(414L, 2L, 1L, true);
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt fail");
          continue;
        }
        if (this.wAs != 2) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.NetSceneGendigitalcert", paramString, "", new Object[0]);
        return;
      }
      h.nFQ.f(13731, new Object[] { Integer.valueOf(7) });
    }
  }
  
  public final void a(c paramc, JSONObject paramJSONObject)
  {
    a.cMr().cMs();
    if (paramc.errCode != 0)
    {
      if (this.wAs != 1) {
        break label73;
      }
      h.nFQ.f(13731, new Object[] { Integer.valueOf(4) });
    }
    for (;;)
    {
      if ((this.wAt != null) && ((!this.bZB) || (paramc.errCode == 0))) {
        this.wAt.bXc();
      }
      return;
      label73:
      if (this.wAs == 2) {
        h.nFQ.f(13731, new Object[] { Integer.valueOf(8) });
      }
    }
  }
  
  public final int aEC()
  {
    return 1580;
  }
  
  public final boolean bqd()
  {
    return this.bZB;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/gendigitalcert";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.l
 * JD-Core Version:    0.7.0.1
 */