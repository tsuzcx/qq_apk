import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.qzone.FeedInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

public class acbm
  implements Runnable
{
  public acbm(FeedsManager paramFeedsManager, FeedInfo paramFeedInfo, String paramString) {}
  
  public void run()
  {
    if (FeedsManager.access$000(this.jdField_a_of_type_ComTencentMobileqqDataFeedsManager) != null)
    {
      boolean bool = FeedsManager.access$000(this.jdField_a_of_type_ComTencentMobileqqDataFeedsManager).a(this.jdField_a_of_type_ComTencentMobileqqDataQzoneFeedInfo);
      if (QLog.isColorLevel()) {
        QLog.e("FeedsManager", 2, "setFeedInfoRead  :" + this.jdField_a_of_type_JavaLangString + " ,success:" + bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acbm
 * JD-Core Version:    0.7.0.1
 */