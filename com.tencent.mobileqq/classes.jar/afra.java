import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel;

public class afra
  implements afrc
{
  private agxe jdField_a_of_type_Agxe;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  
  public afra(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private HongBaoPanel a()
  {
    if (this.jdField_a_of_type_Agxe == null) {
      this.jdField_a_of_type_Agxe = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getPanelManager();
    }
    return (HongBaoPanel)this.jdField_a_of_type_Agxe.a(10);
  }
  
  private void a()
  {
    HongBaoPanel localHongBaoPanel = a();
    if (localHongBaoPanel != null) {
      localHongBaoPanel.onDestory();
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a();
  }
  
  public int[] a()
  {
    return new int[] { 13 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afra
 * JD-Core Version:    0.7.0.1
 */