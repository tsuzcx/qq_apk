import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class aigv
  implements Runnable
{
  public aigv(TroopAdminList paramTroopAdminList) {}
  
  public void run()
  {
    int i = 0;
    int j = this.a.jdField_a_of_type_ArrayOfJavaLangString.length;
    while (i < j)
    {
      String str = this.a.jdField_a_of_type_ArrayOfJavaLangString[i];
      if (!TextUtils.isEmpty(str))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("uin", str);
        localHashMap.put("nick", ContactUtils.l(this.a.app, str));
        this.a.jdField_a_of_type_JavaUtilList.add(localHashMap);
      }
      i += 1;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.a.app.a(1));
    this.a.addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c(this.a.jdField_a_of_type_ArrayOfJavaLangString);
    this.a.runOnUiThread(new aigw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aigv
 * JD-Core Version:    0.7.0.1
 */