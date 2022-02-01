package a.a.a.b;

import com.tencent.secprotocol.ByteData;
import org.json.JSONObject;

public class e
{
  public void a(long paramLong, String paramString1, b paramb, String paramString2)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      int i = paramString2.optInt(f.a(29));
      long l = paramString2.optLong(f.a(30));
      paramString2 = paramString2.optString(f.a(31));
      if (i == 0) {
        ByteData.getInstance().getCode(0L, 0L, paramLong, l, paramString2, paramb.g, paramb.d, null, paramString1);
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     a.a.a.b.e
 * JD-Core Version:    0.7.0.1
 */