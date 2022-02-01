package a.a.a.b;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class c
{
  public static final char[] a = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
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
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localObject = localMessageDigest;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        localNoSuchAlgorithmException.printStackTrace();
      }
    }
    return a(localObject.digest(paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     a.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */