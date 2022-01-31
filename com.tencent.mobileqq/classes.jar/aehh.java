import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.send.SmallVideoSendFragment;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class aehh
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  aehh(aehg paramaehg, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 0)
    {
      QLog.e("PublishActivity", 1, "composite video error! err=" + paramInt + " msg=" + paramString1);
      return;
    }
    paramString1 = QQStoryContext.a().a().createEntityManager();
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mLocalRawVideoDir = paramString2;
    this.jdField_a_of_type_Aehg.a.a.a = paramString2;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.setStatus(1001);
    paramString1.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
    if (!this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mLocalRawVideoDir.equals(SmallVideoSendFragment.a(this.jdField_a_of_type_Aehg.a).j)) {
      FileUtils.a(SmallVideoSendFragment.a(this.jdField_a_of_type_Aehg.a).j, false);
    }
    ThreadManager.getUIHandler().post(new aehi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aehh
 * JD-Core Version:    0.7.0.1
 */