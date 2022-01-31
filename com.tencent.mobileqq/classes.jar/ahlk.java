import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class ahlk
  implements Runnable
{
  public ahlk(ShortVideoPreDownloader paramShortVideoPreDownloader) {}
  
  public void run()
  {
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    while (localIterator.hasNext())
    {
      ShortVideoReq localShortVideoReq = (ShortVideoReq)localIterator.next();
      ShortVideoBusiManager.a(localShortVideoReq, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localShortVideoReq.a != null) {
        ShortVideoPreDownloader.a("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + localShortVideoReq.a.a);
      }
    }
    this.a.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahlk
 * JD-Core Version:    0.7.0.1
 */