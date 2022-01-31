import java.nio.ByteBuffer;
import oicq.wlogin_sdk.tools.MD5;

public class alye
{
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return paramString;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramString.length());
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if ((c == ' ') || (c == '-') || (c == ')') || (c == '(') || (c == '_')) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append(c);
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = paramString1.getBytes();
    byte[] arrayOfByte = paramString2.getBytes();
    if (paramString1.length > 10)
    {
      paramString2 = new byte[10];
      System.arraycopy(paramString1, 0, paramString2, 0, 10);
      paramString1 = paramString2;
    }
    for (;;)
    {
      return MD5.toMD5(ByteBuffer.allocate(paramString1.length + arrayOfByte.length).put(paramString1).put(arrayOfByte).array());
    }
  }
  
  public static String b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (paramString = "#";; paramString = String.valueOf(paramString.charAt(0)).toUpperCase())
    {
      String str = paramString;
      if (!bdnn.b(paramString.charAt(0))) {
        str = "#";
      }
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alye
 * JD-Core Version:    0.7.0.1
 */