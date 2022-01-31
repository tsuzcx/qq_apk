import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ahzj
{
  int jdField_a_of_type_Int = 0;
  final List<Long> jdField_a_of_type_JavaUtilList = new ArrayList(5);
  
  public ahzj(String paramString)
  {
    try
    {
      paramString = aofo.a(paramString, "troop_member_list_config");
      if (paramString != null)
      {
        Object localObject = new JSONObject(paramString);
        this.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("maxTroopMemberSize");
        localObject = ((JSONObject)localObject).optJSONArray("troopClassIdList");
        while ((localObject != null) && (i < ((JSONArray)localObject).length()))
        {
          this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(((JSONArray)localObject).optLong(i)));
          i += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopMemberAddFrdHelper", 2, String.format("TroopMemberListConfig max: %s, idList: %s, config: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), TextUtils.join(",", this.jdField_a_of_type_JavaUtilList), paramString }));
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzj
 * JD-Core Version:    0.7.0.1
 */