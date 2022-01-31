import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.scribble.ScribbleBaseOperator;
import com.tencent.mobileqq.scribble.ScribbleDownloadInfo;
import com.tencent.mobileqq.scribble.ScribbleDownloader;

public class ahbx
  implements Runnable
{
  public ahbx(ScribbleDownloader paramScribbleDownloader, ScribbleDownloadInfo paramScribbleDownloadInfo) {}
  
  public void run()
  {
    ScribbleDownloader.a(this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleDownloader, "dowmthreak", "start download ,uniseq:" + this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleDownloadInfo.a.uniseq);
    new ScribbleBaseOperator(this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleDownloader.a).a(this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleDownloadInfo.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahbx
 * JD-Core Version:    0.7.0.1
 */