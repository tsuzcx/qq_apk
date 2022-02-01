package com.tencent.soter.core.c;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedWriter;
import java.io.StringWriter;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import org.json.JSONObject;

public class a
{
  static
  {
    AppMethodBeat.i(88645);
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(88645);
      return;
    }
  }
  
  public static String a(Certificate paramCertificate)
  {
    AppMethodBeat.i(88643);
    StringWriter localStringWriter = new StringWriter();
    BufferedWriter localBufferedWriter = new BufferedWriter(localStringWriter);
    localBufferedWriter.write("-----BEGIN " + "CERTIFICATE" + "-----");
    localBufferedWriter.write("\n");
    a(localBufferedWriter, Base64.encode(paramCertificate.getEncoded(), 2));
    localBufferedWriter.write("-----END " + "CERTIFICATE" + "-----");
    localBufferedWriter.write("\n");
    localBufferedWriter.close();
    paramCertificate = localStringWriter.toString();
    AppMethodBeat.o(88643);
    return paramCertificate;
  }
  
  private static void a(BufferedWriter paramBufferedWriter, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88642);
    char[] arrayOfChar = new char[64];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = 0;
      while ((j != 64) && (i + j < paramArrayOfByte.length))
      {
        arrayOfChar[j] = ((char)paramArrayOfByte[(i + j)]);
        j += 1;
      }
      paramBufferedWriter.write(arrayOfChar, 0, j);
      paramBufferedWriter.write("\n");
      i += 64;
    }
    AppMethodBeat.o(88642);
  }
  
  public static void a(X509Certificate paramX509Certificate, i parami)
  {
    AppMethodBeat.i(88644);
    paramX509Certificate = paramX509Certificate.getExtensionValue("1.3.6.1.4.1.11129.2.1.17");
    if ((paramX509Certificate == null) || (paramX509Certificate.length == 0))
    {
      paramX509Certificate = new Exception("Couldn't find the keystore attestation extension data.");
      AppMethodBeat.o(88644);
      throw paramX509Certificate;
    }
    int i1;
    int k;
    int j;
    int i2;
    int m;
    try
    {
      int n = "{".getBytes()[0];
      i1 = "}".getBytes()[0];
      i = 0;
      k = 0;
      j = 0;
      if (i < paramX509Certificate.length)
      {
        i2 = paramX509Certificate[i];
        if (i2 != n) {
          break label271;
        }
        m = i;
        break label261;
      }
      if ((j <= 0) || (j >= k)) {
        break label255;
      }
      if ((!$assertionsDisabled) && (paramX509Certificate[(j - 1)] != k - j + 1))
      {
        paramX509Certificate = new AssertionError();
        AppMethodBeat.o(88644);
        throw paramX509Certificate;
      }
    }
    catch (Exception paramX509Certificate)
    {
      paramX509Certificate = new Exception("Couldn't parse challenge json string in the attestation certificate" + paramX509Certificate.getStackTrace());
      AppMethodBeat.o(88644);
      throw paramX509Certificate;
    }
    int i = k - j + 1;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramX509Certificate, j, arrayOfByte, 0, i);
    paramX509Certificate = new String(arrayOfByte);
    d.i("Soter.CertUtil", "soter: challenge json in attestation certificate ".concat(String.valueOf(paramX509Certificate)), new Object[0]);
    paramX509Certificate = new JSONObject(paramX509Certificate);
    parami.AXb = paramX509Certificate.getString("cpu_id");
    parami.uid = paramX509Certificate.getInt("uid");
    parami.Mnq = paramX509Certificate.getLong("counter");
    label255:
    AppMethodBeat.o(88644);
    return;
    for (;;)
    {
      label261:
      i += 1;
      j = m;
      break;
      label271:
      m = j;
      if (i2 == i1)
      {
        k = i;
        m = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.core.c.a
 * JD-Core Version:    0.7.0.1
 */