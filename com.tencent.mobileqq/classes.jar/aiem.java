import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class aiem
{
  public Map<Integer, Boolean> a;
  public boolean a;
  
  public aiem()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static aiem a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mini_msg_config", 2, "parse.configData : " + paramArrayOfaogf[0].a);
    }
    localaiem = new aiem();
    try
    {
      paramArrayOfaogf = new JSONObject(paramArrayOfaogf[0].a);
      int i;
      label93:
      int k;
      if (paramArrayOfaogf.optInt("allSwitch") == 1)
      {
        bool = true;
        localaiem.jdField_a_of_type_Boolean = bool;
        paramArrayOfaogf = paramArrayOfaogf.optJSONArray("business");
        int j = paramArrayOfaogf.length();
        i = 0;
        if (i >= j) {
          break label174;
        }
        JSONObject localJSONObject = (JSONObject)paramArrayOfaogf.get(i);
        k = localJSONObject.optInt("id");
        if (localJSONObject.optInt("switch") != 1) {
          break label163;
        }
      }
      label163:
      for (boolean bool = true;; bool = false)
      {
        localaiem.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(k), Boolean.valueOf(bool));
        i += 1;
        break label93;
        bool = false;
        break;
      }
      return localaiem;
    }
    catch (Exception paramArrayOfaogf)
    {
      paramArrayOfaogf.printStackTrace();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("allSwitch = ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",businessSwitch: ");
    if (this.jdField_a_of_type_JavaUtilMap.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        boolean bool = ((Boolean)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).booleanValue();
        localStringBuilder.append(localInteger);
        localStringBuilder.append("=");
        localStringBuilder.append(bool);
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiem
 * JD-Core Version:    0.7.0.1
 */