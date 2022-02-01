import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.PlusPanel;

public class agmq
  implements agma
{
  private ahrb jdField_a_of_type_Ahrb;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public agmq(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private PlusPanel a()
  {
    if (this.jdField_a_of_type_Ahrb == null) {
      this.jdField_a_of_type_Ahrb = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    }
    return (PlusPanel)this.jdField_a_of_type_Ahrb.b(8);
  }
  
  public void a(int paramInt)
  {
    PlusPanel localPlusPanel = a();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (localPlusPanel == null);
      localPlusPanel.e();
      return;
    } while (localPlusPanel == null);
    localPlusPanel.f();
  }
  
  public int[] a()
  {
    return new int[] { 5, 13 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmq
 * JD-Core Version:    0.7.0.1
 */