import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopFeedParserHelper;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import java.util.List;
import org.json.JSONObject;

class ajje
  implements Runnable
{
  ajje(ajjd paramajjd, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Object localObject = TroopFeedParserHelper.a(this.jdField_a_of_type_OrgJsonJSONObject, "" + this.jdField_a_of_type_Ajjd.a.jdField_a_of_type_JavaLangLong, this.jdField_a_of_type_Ajjd.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    List localList = (List)localObject[0];
    localObject = (List)localObject[1];
    ((List)localObject).addAll(this.jdField_a_of_type_Ajjd.a.jdField_a_of_type_JavaUtilList);
    Message localMessage = this.jdField_a_of_type_Ajjd.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
    localMessage.obj = this.jdField_a_of_type_Ajjd.a.a(localList, (List)localObject);
    this.jdField_a_of_type_Ajjd.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajje
 * JD-Core Version:    0.7.0.1
 */