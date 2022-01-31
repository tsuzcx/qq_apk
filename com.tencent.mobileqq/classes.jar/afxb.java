import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class afxb
  implements Runnable
{
  public afxb(PicPreDownloader paramPicPreDownloader, int paramInt) {}
  
  public void run()
  {
    int k = 0;
    for (;;)
    {
      int j;
      int i;
      PicReq localPicReq;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.jdField_a_of_type_JavaUtilList.iterator();
        j = 0;
        i = 0;
        if (!localIterator.hasNext()) {
          break label310;
        }
        localPicReq = (PicReq)localIterator.next();
        switch (localPicReq.e)
        {
        case 4: 
          k += 1;
          localPicReq.d = localPicReq.e;
          this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.jdField_a_of_type_JavaUtilMap.put(localPicReq.a.g, Integer.valueOf(localPicReq.d));
          this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.d.add(0, localPicReq);
          localPicReq.d = localPicReq.e;
          this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.jdField_a_of_type_JavaUtilMap.put(localPicReq.a.g, Integer.valueOf(localPicReq.d));
        }
      }
      i += 1;
      localPicReq.d = localPicReq.e;
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.jdField_a_of_type_JavaUtilMap.put(localPicReq.a.g, Integer.valueOf(localPicReq.d));
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.b.add(0, localPicReq);
      continue;
      j += 1;
      localPicReq.d = localPicReq.e;
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.jdField_a_of_type_JavaUtilMap.put(localPicReq.a.g, Integer.valueOf(localPicReq.d));
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.c.add(0, localPicReq);
      continue;
      label310:
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.jdField_a_of_type_JavaUtilList.clear();
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "clearAIORequests(): totalCount=" + this.jdField_a_of_type_Int + " countOfC2C=" + i + " countOfDiscussion=" + j + " countOfGroup=" + k);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afxb
 * JD-Core Version:    0.7.0.1
 */