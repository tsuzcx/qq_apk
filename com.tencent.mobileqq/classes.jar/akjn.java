import com.tencent.mobileqq.app.RoamSettingManager;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class akjn
  implements Runnable
{
  public akjn(DBUtils paramDBUtils, ArrayList paramArrayList, RoamSettingManager paramRoamSettingManager) {}
  
  public void run()
  {
    QLog.e("DBUtils", 2, "getTroopMsgFilter, saveSettingList.size():" + this.jdField_a_of_type_JavaUtilArrayList.size());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      RoamSetting localRoamSetting = (RoamSetting)localIterator.next();
      this.jdField_a_of_type_ComTencentMobileqqAppRoamSettingManager.a(localRoamSetting);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akjn
 * JD-Core Version:    0.7.0.1
 */