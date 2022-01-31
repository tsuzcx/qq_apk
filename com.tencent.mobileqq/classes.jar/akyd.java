import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class akyd
{
  public int a;
  public long a;
  public String a;
  public ArrayList<akye> a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  
  public akyd()
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaLangString = "http://www.qq.com";
  }
  
  public static akyd a(JSONObject paramJSONObject)
  {
    localakyd = new akyd();
    try
    {
      if (paramJSONObject.has("preDownload")) {
        localakyd.jdField_a_of_type_Int = paramJSONObject.optInt("preDownload");
      }
      if (paramJSONObject.has("Video360Restart")) {
        localakyd.jdField_b_of_type_Int = paramJSONObject.optInt("Video360Restart");
      }
      int i;
      if (paramJSONObject.has("Video360Repeat"))
      {
        localakyd.jdField_c_of_type_Int = paramJSONObject.optInt("Video360Repeat");
        if (localakyd.jdField_c_of_type_Int > 0) {
          break label440;
        }
        i = 2147483647;
      }
      for (;;)
      {
        localakyd.jdField_c_of_type_Int = i;
        if (paramJSONObject.has("Video360ConnectType")) {
          localakyd.jdField_d_of_type_Int = paramJSONObject.optInt("Video360ConnectType");
        }
        Object localObject1;
        if (paramJSONObject.has("TraversingResource"))
        {
          localObject1 = paramJSONObject.optJSONObject("TraversingResource");
          if (((JSONObject)localObject1).has("TraversingResourceSize")) {
            localakyd.jdField_a_of_type_Long = ((JSONObject)localObject1).optLong("TraversingResourceSize");
          }
          if (((JSONObject)localObject1).has("TraversingResourceUrl")) {
            localakyd.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("TraversingResourceUrl");
          }
          if (((JSONObject)localObject1).has("TraversingResourceMD5")) {
            localakyd.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("TraversingResourceMD5");
          }
        }
        label440:
        if (paramJSONObject.has("FragmentInfos"))
        {
          paramJSONObject = paramJSONObject.optJSONArray("FragmentInfos");
          int k = paramJSONObject.length();
          i = 0;
          label212:
          if (i < k)
          {
            Object localObject2 = paramJSONObject.getJSONObject(i);
            localObject1 = new akye();
            if (((JSONObject)localObject2).has("name")) {
              ((akye)localObject1).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).getString("name");
            }
            if (((JSONObject)localObject2).has("md5")) {
              ((akye)localObject1).jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).getString("md5");
            }
            if (((JSONObject)localObject2).has("url")) {
              ((akye)localObject1).jdField_c_of_type_JavaLangString = ((JSONObject)localObject2).getString("url");
            }
            int j;
            if (((JSONObject)localObject2).has("repeat"))
            {
              ((akye)localObject1).jdField_a_of_type_Int = ((JSONObject)localObject2).optInt("repeat");
              if (((akye)localObject1).jdField_a_of_type_Int <= 0)
              {
                j = 2147483647;
                ((akye)localObject1).jdField_a_of_type_Int = j;
              }
            }
            else
            {
              if (((JSONObject)localObject2).has("triggerType")) {
                ((akye)localObject1).jdField_b_of_type_Int = ((JSONObject)localObject2).optInt("triggerType");
              }
              if (((JSONObject)localObject2).has("trigger"))
              {
                localObject2 = ((JSONObject)localObject2).getString("trigger").split("\\|");
                if (localObject2 != null)
                {
                  j = localObject2.length;
                  if (j != 2) {}
                }
              }
            }
            try
            {
              ((akye)localObject1).jdField_c_of_type_Int = Integer.parseInt(localObject2[0]);
              ((akye)localObject1).jdField_d_of_type_Int = Integer.parseInt(localObject2[1]);
              localakyd.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
              i += 1;
              break label212;
              i = localakyd.jdField_c_of_type_Int;
              continue;
              j = ((akye)localObject1).jdField_a_of_type_Int;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                ((akye)localObject1).jdField_c_of_type_Int = 0;
                ((akye)localObject1).jdField_d_of_type_Int = 0;
                QLog.d("ARTransferDoorConfigInfo", 1, String.format("ARTransferDoorConfigInfo parseJson, numberException\n%s", new Object[] { localNumberFormatException }));
              }
            }
          }
        }
      }
      return localakyd;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("ARTransferDoorConfigInfo", 1, String.format("ARTransferDoorConfigInfo parseJson, Exception\n%s", new Object[] { paramJSONObject }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akyd
 * JD-Core Version:    0.7.0.1
 */