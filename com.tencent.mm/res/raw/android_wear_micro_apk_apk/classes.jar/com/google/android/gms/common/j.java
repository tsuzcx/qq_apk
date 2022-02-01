package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.a.a;
import com.google.android.gms.common.internal.ao;
import com.google.android.gms.common.internal.ap;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class j
  extends ap
{
  private int Nd;
  
  protected j(byte[] paramArrayOfByte)
  {
    Object localObject = paramArrayOfByte;
    int n;
    int m;
    if (paramArrayOfByte.length != 25)
    {
      n = paramArrayOfByte.length;
      m = paramArrayOfByte.length;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0) && (m > 0) && (m + 0 <= paramArrayOfByte.length)) {
        break label172;
      }
    }
    for (localObject = null;; localObject = ((StringBuilder)localObject).toString())
    {
      localObject = String.valueOf(localObject);
      Log.wtf("GoogleCertificates", String.valueOf(localObject).length() + 51 + "Cert hash data has incorrect length (" + n + "):\n" + (String)localObject, new Exception());
      localObject = Arrays.copyOfRange(paramArrayOfByte, 0, 25);
      if (localObject.length == 25) {
        bool = true;
      }
      int i = localObject.length;
      com.google.android.gms.common.internal.d.b(bool, 55 + "cert hash data has incorrect length. length=" + i);
      this.Nd = Arrays.hashCode((byte[])localObject);
      return;
      label172:
      localObject = new StringBuilder((m + 16 - 1) / 16 * 57);
      int j = 0;
      int k = m;
      i = 0;
      if (k > 0)
      {
        if (i == 0) {
          if (m < 65536) {
            ((StringBuilder)localObject).append(String.format("%04X:", new Object[] { Integer.valueOf(j) }));
          }
        }
        for (;;)
        {
          ((StringBuilder)localObject).append(String.format(" %02X", new Object[] { Integer.valueOf(paramArrayOfByte[j] & 0xFF) }));
          k -= 1;
          i += 1;
          if ((i == 16) || (k == 0))
          {
            ((StringBuilder)localObject).append('\n');
            i = 0;
          }
          j += 1;
          break;
          ((StringBuilder)localObject).append(String.format("%08X:", new Object[] { Integer.valueOf(j) }));
          continue;
          if (i == 8) {
            ((StringBuilder)localObject).append(" -");
          }
        }
      }
    }
  }
  
  protected static byte[] o(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("ISO-8859-1");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof ao))) {
      return false;
    }
    try
    {
      paramObject = (ao)paramObject;
      if (paramObject.hN() != hashCode()) {
        return false;
      }
      paramObject = paramObject.hM();
      if (paramObject == null) {
        return false;
      }
      paramObject = (byte[])com.google.android.gms.a.d.a(paramObject);
      boolean bool = Arrays.equals(getBytes(), paramObject);
      return bool;
    }
    catch (RemoteException paramObject)
    {
      Log.e("GoogleCertificates", "Failed to get Google certificates from remote", paramObject);
    }
    return false;
  }
  
  abstract byte[] getBytes();
  
  public final a hM()
  {
    return com.google.android.gms.a.d.F(getBytes());
  }
  
  public final int hN()
  {
    return hashCode();
  }
  
  public int hashCode()
  {
    return this.Nd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.j
 * JD-Core Version:    0.7.0.1
 */