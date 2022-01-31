import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor;
import com.tencent.open.data.SharedPrefs;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.TicketManager;
import mqq.observer.SSOAccountObserver;

public class aius
  extends aiuo
{
  private SSOAccountObserver a;
  private AtomicBoolean c = new AtomicBoolean(false);
  
  public aius(ForwardSdkShareProcessor paramForwardSdkShareProcessor)
  {
    super(paramForwardSdkShareProcessor);
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new aiut(this);
    this.jdField_a_of_type_JavaLangString = "GetSKeyStep";
  }
  
  protected boolean a()
  {
    return (this.c.get()) && (!TextUtils.isEmpty(ForwardSdkShareProcessor.f(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor)));
  }
  
  protected void d()
  {
    String str = this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.a.getCurrentAccountUin();
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetSKeyStep|process|account=" + str + ",refresh=" + ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      f();
    }
    for (;;)
    {
      return;
      if (!this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.c())
      {
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, "illegal app = " + this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.a);
        this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.b(9366, "illegal app");
        c();
        return;
      }
      int i;
      if ((!ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor)) && (!SharedPrefs.a(str)))
      {
        str = ((TicketManager)this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.a.getManager(2)).getSkey(str);
        if (!TextUtils.isEmpty(str))
        {
          i = 0;
          ForwardSdkShareProcessor.d(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor, str);
          this.c.set(true);
          b();
        }
      }
      while (i != 0)
      {
        this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.a.ssoGetTicketNoPasswd(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.a.getCurrentAccountUin(), 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
        return;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aius
 * JD-Core Version:    0.7.0.1
 */