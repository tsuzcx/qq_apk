import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class aaws
{
  public String a;
  public ArrayList<Integer> a;
  public ArrayList<Object> b;
  
  public aaws(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("name")) {
        this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name");
      }
      if (paramJSONObject.has("packageIDs"))
      {
        paramJSONObject = paramJSONObject.optJSONArray("packageIDs");
        int j = paramJSONObject.length();
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        this.b = new ArrayList();
        int i = 0;
        while (i < j)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramJSONObject.getInt(i)));
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGiftAioPanelData", 2, "PersonalTabItemInfo json:", paramJSONObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaws
 * JD-Core Version:    0.7.0.1
 */