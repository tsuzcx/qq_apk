import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.tribe.fragment.TribeTakeVideoHelper;
import com.tencent.qphone.base.util.QLog;

public final class aixw
  implements aixy
{
  public aixw(Activity paramActivity, Intent paramIntent, PublishParam paramPublishParam, String paramString) {}
  
  public void a()
  {
    QLog.d("tribe_publish_TakeVideoHelper", 4, "generate manifest file success.start publishing.");
    TribeTakeVideoHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam, this.jdField_a_of_type_JavaLangString);
  }
  
  public void b()
  {
    QLog.d("tribe_publish_TakeVideoHelper", 4, "generate manifest file error. let's exit.");
    this.jdField_a_of_type_AndroidAppActivity.finish();
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixw
 * JD-Core Version:    0.7.0.1
 */