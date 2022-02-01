package com.tencent.soter.core.c;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i
{
  public String JWA;
  private ArrayList<String> JWB;
  long JWy;
  private String JWz;
  public String signature;
  public int uid;
  public String znE;
  
  public i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88673);
    this.JWy = -1L;
    this.uid = -1;
    this.znE = "";
    this.JWz = "";
    this.JWA = "";
    this.JWB = null;
    this.signature = "";
    this.JWA = paramString1;
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        if (!paramString1.has("certs")) {
          continue;
        }
        JSONArray localJSONArray = paramString1.optJSONArray("certs");
        if (localJSONArray.length() < 2) {
          d.e("Soter.SoterPubKeyModel", "certificates train not enough", new Object[0]);
        }
        d.i("Soter.SoterPubKeyModel", "certs size: [%d]", new Object[] { Integer.valueOf(localJSONArray.length()) });
        this.JWB = new ArrayList();
        int i = 0;
        if (i < localJSONArray.length())
        {
          String str = localJSONArray.getString(i);
          this.JWB.add(str);
          i += 1;
          continue;
        }
        a((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(((String)this.JWB.get(0)).getBytes())));
        paramString1.put("cpu_id", this.znE);
        paramString1.put("uid", this.uid);
        paramString1.put("counter", this.JWy);
        this.JWA = paramString1.toString();
      }
      catch (Exception paramString1)
      {
        d.e("Soter.SoterPubKeyModel", "soter: pub key model failed", new Object[0]);
        continue;
      }
      this.signature = paramString2;
      AppMethodBeat.o(88673);
      return;
      this.JWy = paramString1.optLong("counter");
      this.uid = paramString1.optInt("uid");
      this.znE = paramString1.optString("cpu_id");
      this.JWz = paramString1.optString("pub_key");
    }
  }
  
  public i(Certificate[] paramArrayOfCertificate)
  {
    AppMethodBeat.i(88674);
    this.JWy = -1L;
    this.uid = -1;
    this.znE = "";
    this.JWz = "";
    this.JWA = "";
    this.JWB = null;
    this.signature = "";
    if (paramArrayOfCertificate != null) {}
    try
    {
      ArrayList localArrayList = new ArrayList();
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < paramArrayOfCertificate.length)
      {
        Certificate localCertificate = paramArrayOfCertificate[i];
        Base64.encodeToString(localCertificate.getEncoded(), 2);
        String str = a.a(localCertificate);
        if (i == 0) {
          a((X509Certificate)localCertificate);
        }
        localJSONArray.put(str);
        localArrayList.add(str);
        i += 1;
      }
      this.JWB = localArrayList;
      paramArrayOfCertificate = new JSONObject();
      paramArrayOfCertificate.put("certs", localJSONArray);
      paramArrayOfCertificate.put("cpu_id", this.znE);
      paramArrayOfCertificate.put("uid", this.uid);
      paramArrayOfCertificate.put("counter", this.JWy);
      this.JWA = paramArrayOfCertificate.toString();
      AppMethodBeat.o(88674);
      return;
    }
    catch (Exception paramArrayOfCertificate)
    {
      d.e("Soter.SoterPubKeyModel", "soter: pub key model failed", new Object[0]);
      AppMethodBeat.o(88674);
    }
  }
  
  private void a(X509Certificate paramX509Certificate)
  {
    AppMethodBeat.i(88675);
    try
    {
      a.a(paramX509Certificate, this);
      AppMethodBeat.o(88675);
      return;
    }
    catch (Exception paramX509Certificate)
    {
      d.e("Soter.SoterPubKeyModel", "soter: loadDeviceInfo from attestationCert failed" + paramX509Certificate.getStackTrace(), new Object[0]);
      AppMethodBeat.o(88675);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(88672);
    String str = "SoterPubKeyModel{counter=" + this.JWy + ", uid=" + this.uid + ", cpu_id='" + this.znE + '\'' + ", pub_key_in_x509='" + this.JWz + '\'' + ", rawJson='" + this.JWA + '\'' + ", signature='" + this.signature + '\'' + '}';
    AppMethodBeat.o(88672);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.core.c.i
 * JD-Core Version:    0.7.0.1
 */