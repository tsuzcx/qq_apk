import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class acrm
  implements Runnable
{
  acrm(acrk paramacrk, long paramLong, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Acrk.a.d();
    QfileBaseLocalFileTabView.b(this.jdField_a_of_type_Acrk.a).a().a(this.jdField_a_of_type_Long);
    if (!this.jdField_a_of_type_Boolean)
    {
      FileManagerUtil.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      return;
    }
    FileManagerUtil.a(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acrm
 * JD-Core Version:    0.7.0.1
 */