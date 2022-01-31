package com.tencent.tencentmap.mapsdk.a;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class ab
{
  private static String a = "fdea30d4-c4f3-11e7-ae5f-6c0b84ab3a9e";
  
  public static final byte[] a(String paramString)
  {
    try
    {
      Mac localMac = Mac.getInstance("HmacSHA256");
      localMac.init(new SecretKeySpec(a.getBytes("UTF-8"), "HmacSHA256"));
      paramString = localMac.doFinal(paramString.getBytes());
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      i.a("sha256Encode failed with error:" + paramString.getMessage());
      return null;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      i.a("sha256Encode failed with error:" + paramString.getMessage());
      return null;
    }
    catch (InvalidKeyException paramString)
    {
      i.a("sha256Encode failed with error:" + paramString.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ab
 * JD-Core Version:    0.7.0.1
 */