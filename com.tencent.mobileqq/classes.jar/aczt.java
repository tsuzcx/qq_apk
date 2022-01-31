import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class aczt
  implements Runnable
{
  aczt(aczr paramaczr, long paramLong, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aczr.a.d();
    QfileBaseLocalFileTabView.b(this.jdField_a_of_type_Aczr.a).a().a(this.jdField_a_of_type_Long);
    if (!this.jdField_a_of_type_Boolean)
    {
      FileManagerUtil.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      return;
    }
    FileManagerUtil.a(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aczt
 * JD-Core Version:    0.7.0.1
 */