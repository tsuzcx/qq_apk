package com.tencent.soter.core.c;

import android.util.Base64;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
{
  public String psl = "";
  public String signature = "";
  public int uid = -1;
  long wOW = -1L;
  private String wOX = "";
  public String wOY = "";
  private ArrayList<String> wOZ = null;
  
  public i(String paramString1, String paramString2)
  {
    this.wOY = paramString1;
    try
    {
      paramString1 = new JSONObject(paramString1);
      this.wOW = paramString1.optLong("counter");
      this.uid = paramString1.optInt("uid");
      this.psl = paramString1.optString("cpu_id");
      this.wOX = paramString1.optString("pub_key");
      this.signature = paramString2;
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        d.e("Soter.SoterPubKeyModel", "soter: pub key model failed", new Object[0]);
      }
    }
  }
  
  public i(Certificate[] paramArrayOfCertificate)
  {
    ArrayList localArrayList;
    JSONArray localJSONArray;
    if (paramArrayOfCertificate != null) {
      try
      {
        localArrayList = new ArrayList();
        localJSONArray = new JSONArray();
        int i = 0;
        for (;;)
        {
          if (i >= paramArrayOfCertificate.length) {
            break label182;
          }
          Object localObject = paramArrayOfCertificate[i];
          Base64.encodeToString(((Certificate)localObject).getEncoded(), 2);
          String str = a.a((Certificate)localObject);
          if (i == 0) {
            localObject = (X509Certificate)localObject;
          }
          try
          {
            a.a((X509Certificate)localObject, this);
            localJSONArray.put(str);
            localArrayList.add(str);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              d.e("Soter.SoterPubKeyModel", "soter: loadDeviceInfo from attestationCert failed" + localException.getStackTrace(), new Object[0]);
            }
          }
        }
        return;
      }
      catch (Exception paramArrayOfCertificate)
      {
        d.e("Soter.SoterPubKeyModel", "soter: pub key model failed", new Object[0]);
      }
    }
    label182:
    this.wOZ = localArrayList;
    paramArrayOfCertificate = new JSONObject();
    paramArrayOfCertificate.put("certs", localJSONArray);
    this.wOY = paramArrayOfCertificate.toString();
  }
  
  public final String toString()
  {
    return "SoterPubKeyModel{counter=" + this.wOW + ", uid=" + this.uid + ", cpu_id='" + this.psl + '\'' + ", pub_key_in_x509='" + this.wOX + '\'' + ", rawJson='" + this.wOY + '\'' + ", signature='" + this.signature + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.core.c.i
 * JD-Core Version:    0.7.0.1
 */