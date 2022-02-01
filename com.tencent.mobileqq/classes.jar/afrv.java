import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

public class afrv
  implements afrc
{
  private agxe jdField_a_of_type_Agxe;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  
  public afrv(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private PlusPanel a()
  {
    if (this.jdField_a_of_type_Agxe == null) {
      this.jdField_a_of_type_Agxe = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getPanelManager();
    }
    return (PlusPanel)this.jdField_a_of_type_Agxe.a(8);
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
      localPlusPanel.a();
      return;
    } while (localPlusPanel == null);
    localPlusPanel.b();
  }
  
  public int[] a()
  {
    return new int[] { 5, 13 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrv
 * JD-Core Version:    0.7.0.1
 */