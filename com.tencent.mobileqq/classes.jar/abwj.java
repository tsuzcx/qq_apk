import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.campuscircle.CampusCircleManager;
import com.tencent.mobileqq.campuscircle.CampusCircleManager.CampusTopicPublisher;
import com.tencent.mobileqq.campuscircle.CampusCircleManager.CampusTopicReq;
import com.tencent.mobileqq.campuscircle.CampusCircleManager.TopicPublishSession;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class abwj
  extends TransProcessorHandler
{
  public abwj(CampusCircleManager.CampusTopicPublisher paramCampusTopicPublisher) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (FileMsg)paramMessage.obj;
    if ((localObject != null) && (((FileMsg)localObject).b == 54))
    {
      if (this.a.a()) {
        break label49;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleManager", 2, "mPhotoUploadHandler.handleMessage(), check wrong");
      }
    }
    for (;;)
    {
      return;
      label49:
      CampusCircleManager.CampusTopicReq localCampusTopicReq = this.a.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.a;
      String str1 = ((FileMsg)localObject).q;
      switch (paramMessage.what)
      {
      }
      while (((paramMessage.what == 1003) || (paramMessage.what == 1005) || (paramMessage.what == 1004)) && (QLog.isColorLevel()))
      {
        paramMessage = new StringBuilder();
        paramMessage.append("mPhotoUploadHandler.handleMessage(), ").append(",").append(str1).append(",").append(localCampusTopicReq.picInfos.size());
        QLog.i("CampusCircleManager", 2, paramMessage.toString());
        return;
        String str2 = ((NearbyPeoplePhotoUploadProcessor)((FileMsg)localObject).a).a;
        localObject = ((NearbyPeoplePhotoUploadProcessor)((FileMsg)localObject).a).b;
        if (QLog.isColorLevel()) {
          QLog.d("CampusCircleManager", 2, "mPhotoUploadHandler.handleMessage(), upload success. photo_url = " + str2 + ",thumb_url=" + (String)localObject);
        }
        if (!TextUtils.isEmpty(str1))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.jdField_a_of_type_JavaUtilSet.remove(str1);
          this.a.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.jdField_a_of_type_JavaUtilHashMap.put(str1, str2);
        }
        if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject)))
        {
          this.a.a(1);
        }
        else
        {
          localCampusTopicReq.updatePicInfo(str2, str1);
          if (localCampusTopicReq.isPicsUrlReady())
          {
            CampusCircleManager.CampusTopicPublisher.a(this.a);
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("CampusCircleManager", 2, "mPhotoUploadHandler.handleMessage(), upload photo cancel.");
            }
            if (!TextUtils.isEmpty(str1))
            {
              this.a.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.jdField_a_of_type_JavaUtilSet.remove(str1);
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("CampusCircleManager", 2, "mPhotoUploadHandler.handleMessage(), upload photo failed.");
              }
              if (!TextUtils.isEmpty(str1)) {
                this.a.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.jdField_a_of_type_JavaUtilSet.remove(str1);
              }
              this.a.a(1);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwj
 * JD-Core Version:    0.7.0.1
 */