import android.content.Intent;
import com.tencent.av.config.ByteBuffer;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class airx
  implements Runnable
{
  public airx(TransFileController paramTransFileController, String paramString, Intent paramIntent, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject1 = new CompressInfo(this.jdField_a_of_type_JavaLangString, 0);
    ((CompressInfo)localObject1).f = 0;
    CompressOperator.a((CompressInfo)localObject1);
    boolean bool;
    Object localObject2;
    int i;
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("PhotoConst.SYNCQZONE", false);
      localObject2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("PhotoConst.SOURCE_FROM");
      if ("FROM_SELECT_PHOTO".equals(localObject2)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.upload_local_photo", 2, ".uploadPhoto(), img_path = " + ((CompressInfo)localObject1).e + ",isSyncQZone=" + bool);
      }
      if (!StringUtil.a(((CompressInfo)localObject1).e))
      {
        localObject2 = new TransferRequest();
        ((TransferRequest)localObject2).jdField_a_of_type_Boolean = true;
        ((TransferRequest)localObject2).i = ((CompressInfo)localObject1).e;
        ((TransferRequest)localObject2).b = 22;
        localObject1 = new ByteBuffer();
        if (!bool) {
          break label304;
        }
      }
      label304:
      for (byte b = 1;; b = 0)
      {
        ((ByteBuffer)localObject1).a(b);
        ((TransferRequest)localObject2).jdField_a_of_type_ArrayOfByte = ((ByteBuffer)localObject1).a();
        ((TransferRequest)localObject2).jdField_a_of_type_ComTencentMobileqqPicUpCallBack = new airy(this, bool);
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a((TransferRequest)localObject2);
        if (bool)
        {
          int j = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.SYNCQZONE_CHECKSTATE", 1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C16", "0X8007C16", j, 0, "", "", "", "");
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C17", "0X8007C17", i, 0, "", "", "", "");
        return;
        if ("FROM_TAKE_PHOTO".equals(localObject2))
        {
          i = 2;
          break;
        }
        i = 3;
        break;
      }
      i = 3;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     airx
 * JD-Core Version:    0.7.0.1
 */