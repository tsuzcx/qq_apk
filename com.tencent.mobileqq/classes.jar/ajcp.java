import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.qphone.base.util.QLog;

class ajcp
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  ajcp(ajcn paramajcn) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopBarPublishActivity", 2, "compositeVideo: errorCode = " + paramInt);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.a(null, this.a.jdField_a_of_type_Long);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.b = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.c = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.a = ((int)this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDuration);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.a(paramString2, this.a.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcp
 * JD-Core Version:    0.7.0.1
 */