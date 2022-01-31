import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoResult;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ahkf
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  ArrayList b;
  
  public ahkf(BaseShortVideoOprerator paramBaseShortVideoOprerator, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  private int a()
  {
    ArrayList localArrayList = this.b;
    int i = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          if (((ShortVideoResult)localIterator.next()).jdField_a_of_type_Int == -2) {
            i += 1;
          }
        }
        else {
          return i;
        }
      }
      finally {}
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return;
    }
    int i;
    int j;
    label105:
    ShortVideoForwardInfo localShortVideoForwardInfo;
    if (this.jdField_a_of_type_Int + BaseShortVideoOprerator.d < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      i = this.jdField_a_of_type_Int + BaseShortVideoOprerator.d;
      if (QLog.isColorLevel()) {
        QLog.d("BaseShortVideoOprerator", 2, "mInfoList:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " ,uploadStartIndex:" + this.jdField_a_of_type_Int + " ,finishIndex:" + i);
      }
      j = this.jdField_a_of_type_Int;
      if (j >= i) {
        break label515;
      }
      localShortVideoForwardInfo = (ShortVideoForwardInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (localShortVideoForwardInfo.jdField_a_of_type_JavaLangObject == null) {
        break label178;
      }
    }
    label178:
    for (Object localObject = (MessageForShortVideo)localShortVideoForwardInfo.jdField_a_of_type_JavaLangObject;; localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.a(localShortVideoForwardInfo))
    {
      if (localObject != null) {
        break label192;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseShortVideoOprerator", 2, "mr is null");
      }
      j += 1;
      break label105;
      i = this.jdField_a_of_type_JavaUtilArrayList.size();
      break;
    }
    label192:
    this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
    long l = System.currentTimeMillis();
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
    localTransferRequest.c = ((MessageRecord)localObject).frienduin;
    localTransferRequest.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
    if ((((MessageRecord)localObject).istroop == 0) || (((MessageRecord)localObject).istroop == 1008)) {
      localTransferRequest.jdField_b_of_type_Int = 6;
    }
    for (;;)
    {
      localTransferRequest.jdField_a_of_type_JavaLangObject = localShortVideoForwardInfo;
      localTransferRequest.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
      localTransferRequest.jdField_a_of_type_Boolean = true;
      localTransferRequest.e = 1010;
      localTransferRequest.f = localShortVideoForwardInfo.e;
      localTransferRequest.i = (localShortVideoForwardInfo.h + "QQ_&_MoblieQQ_&_QQ" + localShortVideoForwardInfo.i + "QQ_&_MoblieQQ_&_QQ" + localShortVideoForwardInfo.j + "QQ_&_MoblieQQ_&_QQ" + localShortVideoForwardInfo.g);
      localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = new ahkg(this, j);
      localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTransferRequest);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BaseShortVideoOprerator", 2, "MultiForwardShortVideo req" + j + ": " + localTransferRequest.toString() + " ,cost:" + (System.currentTimeMillis() - l));
      break;
      if (((MessageRecord)localObject).istroop == 3000) {
        localTransferRequest.jdField_b_of_type_Int = 17;
      } else if (((MessageRecord)localObject).istroop == 1) {
        localTransferRequest.jdField_b_of_type_Int = 9;
      }
    }
    label515:
    this.jdField_a_of_type_Int += BaseShortVideoOprerator.d;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseShortVideoOprerator", 2, "mInfoList is null");
      }
      return;
    }
    if (this.b == null) {
      this.b = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ShortVideoForwardInfo)localIterator.next();
      localObject = new ShortVideoResult();
      ((ShortVideoResult)localObject).jdField_a_of_type_Int = -2;
      ((ShortVideoResult)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq;
      this.b.add(localObject);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahkf
 * JD-Core Version:    0.7.0.1
 */