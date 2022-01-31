import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor;
import com.tencent.mobileqq.transfile.TransferRequest.AppInfo;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.BusinessObserver;

public class aipn
  extends aipl
{
  private int jdField_a_of_type_Int;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new aipo(this);
  private AtomicBoolean c = new AtomicBoolean(false);
  
  public aipn(ForwardSdkShareProcessor paramForwardSdkShareProcessor)
  {
    super(paramForwardSdkShareProcessor);
    this.jdField_a_of_type_JavaLangString = "GetAppInfoStep";
    AtomicBoolean localAtomicBoolean = this.c;
    if (ForwardSdkShareProcessor.a(paramForwardSdkShareProcessor).jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      localAtomicBoolean.set(bool);
      return;
      bool = false;
    }
  }
  
  protected boolean a()
  {
    return this.c.get();
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|process|appId=" + ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor) + ",pkgName=" + ForwardSdkShareProcessor.g(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor) + ",retry=" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor, System.currentTimeMillis());
    switch (ForwardSdkShareProcessor.b(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor))
    {
    default: 
      return;
    case 2: 
      Share.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor), this.jdField_a_of_type_MqqObserverBusinessObserver);
      return;
    }
    long l = ForwardSdkShareProcessor.b(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor) / 1000L;
    String str = AgentActivity.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_AndroidContentContext, ForwardSdkShareProcessor.g(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor), l + "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|process|sign: " + str);
    }
    Share.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor), str, l, this.jdField_a_of_type_MqqObserverBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipn
 * JD-Core Version:    0.7.0.1
 */