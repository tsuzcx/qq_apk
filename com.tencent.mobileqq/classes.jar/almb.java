import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class almb
{
  private List<almk> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public static almb a(String paramString)
  {
    boolean bool = true;
    int i = 0;
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        almb localalmb = new almb();
        paramString = new JSONObject(paramString);
        if (paramString.optInt("msg_box_switch", 0) == 1)
        {
          localalmb.jdField_a_of_type_Boolean = bool;
          paramString = paramString.optJSONArray("msg_box_types");
          if (paramString != null)
          {
            ArrayList localArrayList = new ArrayList();
            if (i < paramString.length())
            {
              JSONObject localJSONObject = paramString.getJSONObject(i);
              localArrayList.add(new almk(localJSONObject.optInt("c2c_type"), localJSONObject.optInt("service_type")));
              i += 1;
              continue;
            }
            localalmb.jdField_a_of_type_JavaUtilList = localArrayList;
          }
          return localalmb;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("TempMsgBoxConfigProcessor", 2, "TempMsgBoxConfigData parse error", paramString);
        return null;
      }
      bool = false;
    }
  }
  
  public List<almk> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     almb
 * JD-Core Version:    0.7.0.1
 */