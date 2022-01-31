import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.AppInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class aibt
  extends aibi
{
  private boolean a;
  
  public aibt(ForwardSdkShareProcessor paramForwardSdkShareProcessor)
  {
    super(paramForwardSdkShareProcessor);
    this.jdField_a_of_type_JavaLangString = "SendMsgStep";
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "SendMsgStep|process");
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if (!NetworkUtil.g(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_AndroidContentContext))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "SendMsgStep|no network");
      if ((ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor) > 0) || (!ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).get()) || (!ForwardSdkShareProcessor.c(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).get()) || (ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).jdField_a_of_type_Int != 1))
      {
        this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.b(9004, "no network");
        c();
        return;
      }
    }
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    if (localObject != null) {
      this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject, null);
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "14");
    ((Bundle)localObject).putString("intext_2", "" + ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
    ((Bundle)localObject).putString("stringext_1", "" + ForwardSdkShareProcessor.e(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
    ((Bundle)localObject).putString("intext_3", "0");
    ReportCenter.a().a((Bundle)localObject, "", this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    this.jdField_a_of_type_Boolean = true;
    b();
    this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aibt
 * JD-Core Version:    0.7.0.1
 */