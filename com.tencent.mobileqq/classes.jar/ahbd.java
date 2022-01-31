import android.database.Cursor;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ahbd
{
  public int a;
  public long a;
  public String a;
  public JSONObject a;
  public int b;
  public long b;
  protected String b;
  
  protected ahbd(int paramInt1, long paramLong1, int paramInt2, String paramString1, long paramLong2, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  protected static ahbd a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    int i1 = paramCursor.getColumnIndexOrThrow("no");
    int m = paramCursor.getColumnIndexOrThrow("uin");
    int n = paramCursor.getColumnIndexOrThrow("btype");
    int i = paramCursor.getColumnIndexOrThrow("bid");
    int j = paramCursor.getColumnIndexOrThrow("create_time");
    int k = paramCursor.getColumnIndexOrThrow("ext");
    i1 = paramCursor.getInt(i1);
    long l1 = paramCursor.getLong(m);
    m = paramCursor.getInt(n);
    String str = paramCursor.getString(i);
    long l2 = paramCursor.getLong(j);
    paramCursor = paramCursor.getString(k);
    if (QLog.isColorLevel()) {
      QLog.i("NotifyMsgDBHelper", 2, "fromCursorOrThrow bId:" + str + " extJson:" + paramCursor);
    }
    return new ahbd(i1, l1, m, str, l2, paramCursor);
  }
  
  public int a(String paramString, int paramInt)
  {
    a(false);
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
      return paramInt;
    }
    return this.jdField_a_of_type_OrgJsonJSONObject.optInt(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt)
  {
    a(true);
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put(paramString, paramInt);
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(true);
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put(paramString1, paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      paramString1.printStackTrace();
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject != null) {}
    label65:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.length() <= 0)) {
            break label65;
          }
          try
          {
            this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(this.jdField_b_of_type_JavaLangString);
            return;
          }
          catch (JSONException localJSONException)
          {
            if (QLog.isColorLevel())
            {
              localJSONException.printStackTrace();
              return;
            }
          }
          catch (Throwable localThrowable) {}
        }
      } while (!QLog.isColorLevel());
      localThrowable.printStackTrace();
      return;
    } while ((!paramBoolean) || (this.jdField_a_of_type_OrgJsonJSONObject != null));
    this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahbd
 * JD-Core Version:    0.7.0.1
 */