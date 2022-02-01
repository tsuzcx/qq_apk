import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class akgt
{
  public static List<akgu> a;
  
  public static void a(JSONObject paramJSONObject)
  {
    int i = 2;
    if ((paramJSONObject != null) && (paramJSONObject.has("entryList")))
    {
      paramJSONObject = paramJSONObject.optJSONArray("entryList");
      ArrayList localArrayList = new ArrayList();
      if (paramJSONObject.length() > 2) {}
      for (;;)
      {
        int j = 0;
        while (j < i)
        {
          JSONObject localJSONObject = paramJSONObject.optJSONObject(j);
          akgu localakgu = new akgu();
          localakgu.jdField_a_of_type_Int = localJSONObject.optInt("id");
          Object localObject = localJSONObject.optJSONObject("image");
          if (localObject != null)
          {
            localObject = ((JSONObject)localObject).optString("src");
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              localakgu.jdField_a_of_type_JavaLangString = ("https://gxh.vip.qq.com/xydata" + (String)localObject);
            }
          }
          localakgu.c = localJSONObject.optString("name");
          localakgu.d = localJSONObject.optString("desc");
          localakgu.jdField_b_of_type_JavaLangString = localJSONObject.optString("url");
          localakgu.jdField_a_of_type_Boolean = localJSONObject.optBoolean("isShow", true);
          localakgu.jdField_b_of_type_Int = localJSONObject.optInt("tag", 0);
          localArrayList.add(localakgu);
          j += 1;
        }
        i = paramJSONObject.length();
      }
      a = localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akgt
 * JD-Core Version:    0.7.0.1
 */