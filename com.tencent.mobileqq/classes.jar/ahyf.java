import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class ahyf
  implements Runnable
{
  public ahyf(QQAppInterface paramQQAppInterface, ShortVideoReq paramShortVideoReq) {}
  
  public void run()
  {
    ShortVideoPreDownloader localShortVideoPreDownloader = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localShortVideoPreDownloader.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.contains(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq))
    {
      localShortVideoPreDownloader.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.remove(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq);
      localShortVideoPreDownloader.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
      localShortVideoPreDownloader.a.remove(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.jdField_a_of_type_JavaLangString);
      Logger.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.jdField_a_of_type_Long + ",curHandingNum:" + localShortVideoPreDownloader.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahyf
 * JD-Core Version:    0.7.0.1
 */