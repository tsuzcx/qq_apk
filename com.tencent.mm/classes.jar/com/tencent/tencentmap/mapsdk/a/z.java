package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class z
{
  private static String a = "fdea30d4-c4f3-11e7-ae5f-6c0b84ab3a9e";
  
  public static final byte[] a(String paramString)
  {
    AppMethodBeat.i(150405);
    Object localObject = null;
    try
    {
      Mac localMac = Mac.getInstance("HmacSHA256");
      localMac.init(new SecretKeySpec(a.getBytes("UTF-8"), "HmacSHA256"));
      paramString = localMac.doFinal(paramString.getBytes());
      AppMethodBeat.o(150405);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        h.a("sha256Encode failed with error:" + paramString.getMessage());
        paramString = localObject;
      }
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;)
      {
        h.a("sha256Encode failed with error:" + paramString.getMessage());
        paramString = localObject;
      }
    }
    catch (InvalidKeyException paramString)
    {
      for (;;)
      {
        h.a("sha256Encode failed with error:" + paramString.getMessage());
        paramString = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.z
 * JD-Core Version:    0.7.0.1
 */