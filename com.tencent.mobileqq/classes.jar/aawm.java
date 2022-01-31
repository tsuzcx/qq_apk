import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.QLog;

class aawm
  extends ajjh
{
  aawm(aawl paramaawl) {}
  
  protected void onGetHeadInfo(boolean paramBoolean, Setting paramSetting)
  {
    if ((paramSetting == null) || (!this.a.b.equals(paramSetting.uin))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.Avatar", 2, "onGetHeadInfo: uin=" + paramSetting.uin);
      }
    } while ((!this.a.jdField_a_of_type_Boolean) || (paramSetting.url == null) || (paramSetting.url.length() <= 0));
    this.a.a(paramSetting.uin, paramSetting.bFaceFlags, paramSetting.url);
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (!this.a.b.equals(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Avatar", 2, "onUpdateCustomHead: uin=" + paramString);
    }
    this.a.b(this.a.jdField_a_of_type_Aawp);
    if (paramBoolean)
    {
      this.a.a(this.a.jdField_a_of_type_Aawp, false);
      this.a.c(this.a.jdField_a_of_type_Aawp);
      return;
    }
    this.a.jdField_a_of_type_Aawp.a = 2;
    this.a.c(this.a.jdField_a_of_type_Aawp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aawm
 * JD-Core Version:    0.7.0.1
 */