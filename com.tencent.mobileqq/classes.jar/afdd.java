import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.1;
import com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class afdd
  implements affa
{
  private afdf jdField_a_of_type_Afdf;
  private ambp jdField_a_of_type_Ambp = new afde(this);
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  afdd(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
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
      this.jdField_a_of_type_Afdf = new afdf(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, null);
      afdf.a(this.jdField_a_of_type_Afdf);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.addObserver(this.jdField_a_of_type_Ambp);
      localObject = new AIOIconChangeByTimeHelper.1(this);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.removeObserver(this.jdField_a_of_type_Ambp);
      localObject = new AIOIconChangeByTimeHelper.2(this);
    }
  }
  
  public int[] a()
  {
    return new int[] { 2, 6, 11 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afdd
 * JD-Core Version:    0.7.0.1
 */