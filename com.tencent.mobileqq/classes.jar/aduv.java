import android.text.TextUtils;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class aduv
  implements Runnable
{
  public aduv(EmoticonManager paramEmoticonManager, RecentEmotion paramRecentEmotion) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataRecentEmotion == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "addRecentEmotionToCache key = " + this.jdField_a_of_type_ComTencentMobileqqDataRecentEmotion);
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqDataRecentEmotion.keyword;
    if (TextUtils.isEmpty(str))
    {
      QLog.e("EmoticonManager", 1, "addRecentEmotionToCache keyword empty");
      return;
    }
    RecentEmotion localRecentEmotion = this.jdField_a_of_type_ComTencentMobileqqDataRecentEmotion;
    CopyOnWriteArrayList localCopyOnWriteArrayList = EmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager, str);
    if (localCopyOnWriteArrayList != null)
    {
      int i = localCopyOnWriteArrayList.indexOf(this.jdField_a_of_type_ComTencentMobileqqDataRecentEmotion);
      if (i > -1)
      {
        localRecentEmotion = (RecentEmotion)localCopyOnWriteArrayList.get(i);
        localRecentEmotion.replace(this.jdField_a_of_type_ComTencentMobileqqDataRecentEmotion);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.d.remove(localRecentEmotion);
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.d.add(0, localRecentEmotion);
      return;
      localCopyOnWriteArrayList.add(this.jdField_a_of_type_ComTencentMobileqqDataRecentEmotion);
      continue;
      localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      localCopyOnWriteArrayList.add(this.jdField_a_of_type_ComTencentMobileqqDataRecentEmotion);
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.e.put(str, localCopyOnWriteArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aduv
 * JD-Core Version:    0.7.0.1
 */