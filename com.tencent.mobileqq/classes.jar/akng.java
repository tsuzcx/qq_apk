import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class akng
{
  public static List<aknh> a;
  
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
          aknh localaknh = new aknh();
          localaknh.jdField_a_of_type_Int = localJSONObject.optInt("id");
          Object localObject = localJSONObject.optJSONObject("image");
          if (localObject != null)
          {
            localObject = ((JSONObject)localObject).optString("src");
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              localaknh.jdField_a_of_type_JavaLangString = ("https://gxh.vip.qq.com/xydata" + (String)localObject);
            }
          }
          localaknh.c = localJSONObject.optString("name");
          localaknh.d = localJSONObject.optString("desc");
          localaknh.jdField_b_of_type_JavaLangString = localJSONObject.optString("url");
          localaknh.jdField_a_of_type_Boolean = localJSONObject.optBoolean("isShow", true);
          localaknh.jdField_b_of_type_Int = localJSONObject.optInt("tag", 0);
          localArrayList.add(localaknh);
          j += 1;
        }
        i = paramJSONObject.length();
      }
      a = localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akng
 * JD-Core Version:    0.7.0.1
 */