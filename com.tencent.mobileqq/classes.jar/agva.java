import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel;

public class agva
  implements agvc
{
  private aiap jdField_a_of_type_Aiap;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public agva(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private HongBaoPanel a()
  {
    if (this.jdField_a_of_type_Aiap == null) {
      this.jdField_a_of_type_Aiap = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    }
    return (HongBaoPanel)this.jdField_a_of_type_Aiap.b(10);
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
 * Qualified Name:     agva
 * JD-Core Version:    0.7.0.1
 */