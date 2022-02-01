package a.a.a.b;

import com.tencent.secprotocol.ByteData;
import com.tencent.secprotocol.t.ReportLogHelper;
import org.json.JSONObject;

public class e
{
  public void a(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      int i = paramString2.optInt(g.a(29));
      long l = paramString2.optLong(g.a(30));
      paramString2 = paramString2.optString(g.a(31));
      if (i == 0)
      {
        ReportLogHelper.report(3, 0);
        ByteData.getInstance().getCode(0L, 0L, 0L, l, paramString2, null, null, null, paramString1);
        return;
      }
      ReportLogHelper.report(3, 1);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     a.a.a.b.e
 * JD-Core Version:    0.7.0.1
 */