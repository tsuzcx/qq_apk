package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedWriter;
import java.security.cert.X509Certificate;
import org.json.JSONObject;

public final class a
{
  static void a(BufferedWriter paramBufferedWriter, byte[] paramArrayOfByte)
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
    int n = "{".getBytes()[0];
    int i1 = "}".getBytes()[0];
    int i = 0;
    int k = 0;
    int j = 0;
    if (i < paramX509Certificate.length)
    {
      int i2 = paramX509Certificate[i];
      int m;
      if (i2 == n) {
        m = i;
      }
      for (;;)
      {
        i += 1;
        j = m;
        break;
        m = j;
        if (i2 == i1)
        {
          k = i;
          m = j;
        }
      }
    }
    if ((j > 0) && (j < k))
    {
      if (paramX509Certificate[(j - 1)] != k - j + 1) {
        d.w("Soter.CertUtil", "read extension lenght error", new Object[0]);
      }
      i = k - j + 1;
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramX509Certificate, j, arrayOfByte, 0, i);
      paramX509Certificate = new String(arrayOfByte);
      d.i("Soter.CertUtil", "soter: challenge json in attestation certificate ".concat(String.valueOf(paramX509Certificate)), new Object[0]);
      paramX509Certificate = new JSONObject(paramX509Certificate);
      parami.RZY = paramX509Certificate.getString("cpu_id");
      parami.uid = paramX509Certificate.getInt("uid");
      parami.ahxh = paramX509Certificate.getLong("counter");
    }
    AppMethodBeat.o(88644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.core.c.a
 * JD-Core Version:    0.7.0.1
 */