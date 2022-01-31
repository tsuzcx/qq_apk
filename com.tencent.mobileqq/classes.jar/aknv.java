import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aknv
  extends axxg
{
  akns jdField_a_of_type_Akns;
  aknu jdField_a_of_type_Aknu;
  
  public aknv(QQAppInterface paramQQAppInterface, aknu paramaknu, akns paramakns)
  {
    super(paramQQAppInterface, paramaknu.b);
    this.jdField_a_of_type_Aknu = paramaknu;
    this.jdField_a_of_type_Akns = paramakns;
  }
  
  protected void realCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceDownload", 2, "DownloadTask realCancel");
    }
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceDownload", 2, "DownloadTask realStart");
    }
    akns.a(this.jdField_a_of_type_Akns, this.jdField_a_of_type_Aknu);
  }
  
  public String toString()
  {
    return "[DownloadTask] mInfo=" + this.jdField_a_of_type_Aknu + ", mDownloader=" + this.jdField_a_of_type_Akns;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aknv
 * JD-Core Version:    0.7.0.1
 */