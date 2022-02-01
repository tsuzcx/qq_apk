import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class agkh
  implements agin
{
  private int jdField_a_of_type_Int = 0;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  
  public agkh(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public String a()
  {
    String str = null;
    if (this.jdField_a_of_type_Int == 1) {
      str = anvx.a(2131713695);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SpecWordEmotionThinkHelper", 2, " getSpecKeyWord:  mSpecWordType=" + this.jdField_a_of_type_Int);
    }
    return str;
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    b();
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecWordEmotionThinkHelper", 2, " beforeTextChanged:  start=" + paramInt1 + " after=" + paramInt3 + " count=" + paramInt2);
    }
    if ((paramInt2 > paramInt3) || (paramInt3 == 0)) {
      b();
    }
  }
  
  public boolean a()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SpecWordEmotionThinkHelper", 2, " needSendMixMsg:  mSpecWordType=" + this.jdField_a_of_type_Int);
      }
      return bool;
      bool = false;
    }
  }
  
  public int[] a()
  {
    return new int[] { 14, 19 };
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.d("SpecWordEmotionThinkHelper", 2, " clearSpecWordType");
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("SpecWordEmotionThinkHelper", 2, " setSpecWordType:  mSpecWordType=" + this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkh
 * JD-Core Version:    0.7.0.1
 */