import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PokeAndEmoPanel;
import com.tencent.mobileqq.app.QQAppInterface;

public class agjh
  implements agin
{
  private ahqe jdField_a_of_type_Ahqe;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public agjh(agih paramagih, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
  }
  
  private PokeAndEmoPanel a()
  {
    if (this.jdField_a_of_type_Ahqe == null) {
      this.jdField_a_of_type_Ahqe = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getPanelManager();
    }
    return (PokeAndEmoPanel)this.jdField_a_of_type_Ahqe.a(23);
  }
  
  private void a()
  {
    PokeAndEmoPanel localPokeAndEmoPanel = a();
    if (localPokeAndEmoPanel != null) {
      localPokeAndEmoPanel.a();
    }
  }
  
  private void b()
  {
    PokeAndEmoPanel localPokeAndEmoPanel = a();
    if (localPokeAndEmoPanel != null) {
      localPokeAndEmoPanel.c();
    }
  }
  
  private void c()
  {
    PokeAndEmoPanel localPokeAndEmoPanel = a();
    if (localPokeAndEmoPanel != null)
    {
      localPokeAndEmoPanel.b();
      ahcw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), ahcw.a);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 10: 
    case 12: 
    case 13: 
    default: 
      return;
    case 9: 
      a();
      return;
    case 11: 
      b();
      return;
    }
    c();
  }
  
  public int[] a()
  {
    return new int[] { 9, 11, 14 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjh
 * JD-Core Version:    0.7.0.1
 */