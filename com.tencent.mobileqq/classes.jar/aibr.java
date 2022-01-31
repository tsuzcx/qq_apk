import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class aibr
  extends aibi
{
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  boolean jdField_a_of_type_Boolean = false;
  private AtomicBoolean c = new AtomicBoolean(false);
  
  public aibr(ForwardSdkShareProcessor paramForwardSdkShareProcessor)
  {
    super(paramForwardSdkShareProcessor);
    this.jdField_a_of_type_JavaLangString = "RichStep";
    g();
  }
  
  protected boolean a()
  {
    return (!this.c.get()) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 2);
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "RichStep|process|neeRich=" + this.c + ",lack=" + ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if (this.c.get())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      ThreadManager.post(new aibs(this), 5, null, true);
      return;
    }
    b();
  }
  
  void g()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    this.c.set(false);
    if ((TextUtils.isEmpty(ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor))) && (TextUtils.isEmpty(ForwardSdkShareProcessor.b(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor)))) {
      ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor, ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor) | 0x1);
    }
    if (TextUtils.isEmpty(ForwardSdkShareProcessor.c(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor))) {
      ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor, ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor) | 0x2);
    }
    if (TextUtils.isEmpty(ForwardSdkShareProcessor.d(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor))) {
      ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor, ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor) | 0x4);
    }
    if (ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor) > 0) {
      this.c.set(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aibr
 * JD-Core Version:    0.7.0.1
 */