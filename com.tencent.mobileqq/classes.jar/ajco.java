import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.qphone.base.util.QLog;

class ajco
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  ajco(ajcn paramajcn, String paramString1, String paramString2) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    FileUtils.f(this.jdField_a_of_type_JavaLangString);
    if (paramInt != 0)
    {
      QLog.i("tribe_publish_TroopBarPublishActivity", 1, "merge music failed. merge file path:" + this.jdField_a_of_type_JavaLangString + " merge result:" + paramInt);
      this.jdField_a_of_type_Ajcn.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.a(null, this.jdField_a_of_type_Ajcn.jdField_a_of_type_Long);
      return;
    }
    this.jdField_a_of_type_Ajcn.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.a(this.b, this.jdField_a_of_type_Ajcn.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajco
 * JD-Core Version:    0.7.0.1
 */