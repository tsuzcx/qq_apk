package a.a.a.b;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class c
{
  public static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar;
    int i;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return null;
      }
      arrayOfChar = new char[paramArrayOfByte.length * 2];
      i = 0;
    }
    try
    {
      while (i < paramArrayOfByte.length)
      {
        int k = paramArrayOfByte[i];
        int j = i * 2;
        arrayOfChar[(j + 1)] = a[(k & 0xF)];
        k = (byte)(k >>> 4);
        arrayOfChar[(j + 0)] = a[(k & 0xF)];
        i += 1;
      }
      return new String(arrayOfChar);
    }
    catch (Exception paramArrayOfByte) {}
    return null;
    return null;
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    Object localObject;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
      localObject = null;
    }
    return a(localObject.digest(paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     a.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */