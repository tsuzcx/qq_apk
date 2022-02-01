import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel;

public class agly
  implements agma
{
  private ahrb jdField_a_of_type_Ahrb;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public agly(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private HongBaoPanel a()
  {
    if (this.jdField_a_of_type_Ahrb == null) {
      this.jdField_a_of_type_Ahrb = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    }
    return (HongBaoPanel)this.jdField_a_of_type_Ahrb.b(10);
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
 * Qualified Name:     agly
 * JD-Core Version:    0.7.0.1
 */