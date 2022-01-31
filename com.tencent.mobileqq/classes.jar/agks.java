import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.BasePicOprerator;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicStatisticsManager;
import java.io.File;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class agks
  implements Runnable
{
  public agks(BasePicOprerator paramBasePicOprerator, DownCallBack.DownResult paramDownResult) {}
  
  public void run()
  {
    Object localObject;
    PicStatisticsManager localPicStatisticsManager;
    long l;
    if ((this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult != null) && (this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult.b != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult.b);
      if (this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult.jdField_a_of_type_Int == 0)
      {
        localPicStatisticsManager = (PicStatisticsManager)this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(72);
        if (localPicStatisticsManager != null)
        {
          l = localFile.length();
          switch (this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult.c)
          {
          }
        }
      }
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (((PicPreDownloader)localObject).b.contains(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq))
      {
        ((PicPreDownloader)localObject).b.remove(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq);
        ((PicPreDownloader)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
        ((PicPreDownloader)localObject).jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g);
        Logger.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + ",cmd:" + this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_Int + ",curHandingNum:" + ((PicPreDownloader)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
        if ((this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult != null) && (this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult.b != null))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
          if ((localObject != null) && (((MessageForPic)localObject).size == 0L))
          {
            l = new File(this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult.b).length();
            this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageForPic)localObject, l);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
      }
      return;
      localPicStatisticsManager.a(13059, l);
      continue;
      localPicStatisticsManager.a(13060, l);
      localPicStatisticsManager.b((MessageForPic)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agks
 * JD-Core Version:    0.7.0.1
 */