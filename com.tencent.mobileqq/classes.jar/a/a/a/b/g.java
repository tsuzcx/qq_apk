package a.a.a.b;

import java.util.HashMap;
import java.util.Map;

public class g
{
  public static Map<byte[], String> a = new HashMap();
  
  public static String a(byte[] paramArrayOfByte)
  {
    int i = 0;
    if (a.get(paramArrayOfByte) == null)
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte.length];
      while (i < paramArrayOfByte.length)
      {
        arrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ new byte[] { 69, 16, -45, 32, 78, 91, 23, -99, 0, 0, 0, 0, 0, 0, 0, 0 }[(i % 8)]));
        i += 1;
      }
      a.put(paramArrayOfByte, new String(arrayOfByte));
    }
    return (String)a.get(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     a.a.a.b.g
 * JD-Core Version:    0.7.0.1
 */