import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.1;
import com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class agfn
  implements agin
{
  private agfp jdField_a_of_type_Agfp;
  private aocm jdField_a_of_type_Aocm = new agfo(this);
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  agfn(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public void a(int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (localObject != null) {}
      try
      {
        ((Runnable)localObject).run();
        return;
      }
      catch (Exception localException)
      {
        QLog.e("AIOIconChangeByTimeHelper", 1, localException, new Object[0]);
      }
      this.jdField_a_of_type_Agfp = new agfp(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, null);
      agfp.a(this.jdField_a_of_type_Agfp);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.addObserver(this.jdField_a_of_type_Aocm);
      localObject = new AIOIconChangeByTimeHelper.1(this);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.removeObserver(this.jdField_a_of_type_Aocm);
      localObject = new AIOIconChangeByTimeHelper.2(this);
    }
  }
  
  public int[] a()
  {
    return new int[] { 4, 8, 14 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agfn
 * JD-Core Version:    0.7.0.1
 */