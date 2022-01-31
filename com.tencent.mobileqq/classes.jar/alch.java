import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class alch
  extends ayxn
{
  alce jdField_a_of_type_Alce;
  alcg jdField_a_of_type_Alcg;
  
  public alch(QQAppInterface paramQQAppInterface, alcg paramalcg, alce paramalce)
  {
    super(paramQQAppInterface, paramalcg.b);
    this.jdField_a_of_type_Alcg = paramalcg;
    this.jdField_a_of_type_Alce = paramalce;
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
    alce.a(this.jdField_a_of_type_Alce, this.jdField_a_of_type_Alcg);
  }
  
  public String toString()
  {
    return "[DownloadTask] mInfo=" + this.jdField_a_of_type_Alcg + ", mDownloader=" + this.jdField_a_of_type_Alce;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alch
 * JD-Core Version:    0.7.0.1
 */