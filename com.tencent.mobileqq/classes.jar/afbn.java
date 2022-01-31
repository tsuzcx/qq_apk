import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class afbn
  implements afal
{
  private int jdField_a_of_type_Int = 0;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public afbn(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public String a()
  {
    String str = null;
    if (this.jdField_a_of_type_Int == 1) {
      str = alpo.a(2131714655);
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
    return new int[] { 11, 16 };
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
 * Qualified Name:     afbn
 * JD-Core Version:    0.7.0.1
 */