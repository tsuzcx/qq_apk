import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.OldHttpEngine;
import com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class aici
  extends TimerTask
{
  public aici(OldHttpEngine.OldHttpCommunicatorListner paramOldHttpCommunicatorListner, HttpNetReq paramHttpNetReq) {}
  
  public void run()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine$OldHttpCommunicatorListner.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      int i;
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq != null))
      {
        i = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.g;
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.a != 1) {
          break label71;
        }
      }
      for (;;)
      {
        RichMediaUtil.a(i, bool, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.f, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.e, "scheduleRetry", "mIsCancelled is true 2");
        return;
        label71:
        bool = false;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine$OldHttpCommunicatorListner.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine.c(this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine$OldHttpCommunicatorListner.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aici
 * JD-Core Version:    0.7.0.1
 */