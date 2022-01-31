import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;

public class ahlj
  implements Runnable
{
  public ahlj(ShortVideoPreDownloader paramShortVideoPreDownloader, ShortVideoReq paramShortVideoReq) {}
  
  public void run()
  {
    ShortVideoPreDownloader.a("consumeShortVideo", "start pre download short video type=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.b + " uniseq=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.jdField_a_of_type_Long + ", uuid=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahlj
 * JD-Core Version:    0.7.0.1
 */