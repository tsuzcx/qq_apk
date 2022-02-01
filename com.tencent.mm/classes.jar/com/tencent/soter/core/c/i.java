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
  public String AXb;
  long Mnq;
  private String Mnr;
  public String Mns;
  private ArrayList<String> Mnt;
  public String signature;
  public int uid;
  
  public i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88673);
    this.Mnq = -1L;
    this.uid = -1;
    this.AXb = "";
    this.Mnr = "";
    this.Mns = "";
    this.Mnt = null;
    this.signature = "";
    this.Mns = paramString1;
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
        this.Mnt = new ArrayList();
        int i = 0;
        if (i < localJSONArray.length())
        {
          String str = localJSONArray.getString(i);
          this.Mnt.add(str);
          i += 1;
          continue;
        }
        a((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(((String)this.Mnt.get(0)).getBytes())));
        paramString1.put("cpu_id", this.AXb);
        paramString1.put("uid", this.uid);
        paramString1.put("counter", this.Mnq);
        this.Mns = paramString1.toString();
      }
      catch (Exception paramString1)
      {
        d.e("Soter.SoterPubKeyModel", "soter: pub key model failed", new Object[0]);
        continue;
      }
      this.signature = paramString2;
      AppMethodBeat.o(88673);
      return;
      this.Mnq = paramString1.optLong("counter");
      this.uid = paramString1.optInt("uid");
      this.AXb = paramString1.optString("cpu_id");
      this.Mnr = paramString1.optString("pub_key");
    }
  }
  
  public i(Certificate[] paramArrayOfCertificate)
  {
    AppMethodBeat.i(88674);
    this.Mnq = -1L;
    this.uid = -1;
    this.AXb = "";
    this.Mnr = "";
    this.Mns = "";
    this.Mnt = null;
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
      this.Mnt = localArrayList;
      paramArrayOfCertificate = new JSONObject();
      paramArrayOfCertificate.put("certs", localJSONArray);
      paramArrayOfCertificate.put("cpu_id", this.AXb);
      paramArrayOfCertificate.put("uid", this.uid);
      paramArrayOfCertificate.put("counter", this.Mnq);
      this.Mns = paramArrayOfCertificate.toString();
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
    String str = "SoterPubKeyModel{counter=" + this.Mnq + ", uid=" + this.uid + ", cpu_id='" + this.AXb + '\'' + ", pub_key_in_x509='" + this.Mnr + '\'' + ", rawJson='" + this.Mns + '\'' + ", signature='" + this.signature + '\'' + '}';
    AppMethodBeat.o(88672);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.core.c.i
 * JD-Core Version:    0.7.0.1
 */