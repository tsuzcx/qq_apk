import android.text.TextUtils;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aeic
  implements Runnable
{
  public aeic(EmoticonManager paramEmoticonManager, List paramList) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a.a();
    for (;;)
    {
      int i;
      try
      {
        localEntityTransaction.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveRecentEmotionToDB:");
        i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i >= 0)
        {
          RecentEmotion localRecentEmotion1 = (RecentEmotion)this.jdField_a_of_type_JavaUtilList.get(i);
          if (localRecentEmotion1 == null) {
            break label364;
          }
          String str1 = localRecentEmotion1.epId;
          String str2 = localRecentEmotion1.eId;
          String str3 = localRecentEmotion1.keyword;
          localStringBuilder.append("emotion=").append(localRecentEmotion1);
          if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
            break label364;
          }
          RecentEmotion localRecentEmotion2 = (RecentEmotion)this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a.a(RecentEmotion.class, "epId=? and eId=? and keyword=?", new String[] { str1, str2, str3 });
          RecentEmotion localRecentEmotion3 = new RecentEmotion();
          localRecentEmotion3.epId = str1;
          localRecentEmotion3.eId = str2;
          localRecentEmotion3.keyword = str3;
          localRecentEmotion3.exposeNum = localRecentEmotion1.exposeNum;
          localRecentEmotion3.setStatus(1000);
          if (localRecentEmotion2 != null) {
            this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a.b(localRecentEmotion2);
          }
          EmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager, localRecentEmotion3);
        }
      }
      catch (Exception localException)
      {
        QLog.e("EmoticonManager", 2, "saveRecentEmotionToDB e = " + localException.getMessage());
        localEntityTransaction.b();
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonManager", 2, "saveRecentEmotionToDB_Time: " + (System.currentTimeMillis() - l));
        }
        return;
        localEntityTransaction.c();
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonManager", 2, localException.toString());
        }
        localEntityTransaction.b();
        continue;
      }
      finally
      {
        localEntityTransaction.b();
      }
      label364:
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeic
 * JD-Core Version:    0.7.0.1
 */