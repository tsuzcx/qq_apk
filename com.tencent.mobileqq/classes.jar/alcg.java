import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class alcg
  extends ayxp
{
  alcd jdField_a_of_type_Alcd;
  alcf jdField_a_of_type_Alcf;
  
  public alcg(QQAppInterface paramQQAppInterface, alcf paramalcf, alcd paramalcd)
  {
    super(paramQQAppInterface, paramalcf.b);
    this.jdField_a_of_type_Alcf = paramalcf;
    this.jdField_a_of_type_Alcd = paramalcd;
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
    alcd.a(this.jdField_a_of_type_Alcd, this.jdField_a_of_type_Alcf);
  }
  
  public String toString()
  {
    return "[DownloadTask] mInfo=" + this.jdField_a_of_type_Alcf + ", mDownloader=" + this.jdField_a_of_type_Alcd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alcg
 * JD-Core Version:    0.7.0.1
 */