import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PokeAndEmoPanel;
import com.tencent.mobileqq.app.QQAppInterface;

public class afrw
  implements afrc
{
  private agxe jdField_a_of_type_Agxe;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public afrw(afqw paramafqw, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
  }
  
  private PokeAndEmoPanel a()
  {
    if (this.jdField_a_of_type_Agxe == null) {
      this.jdField_a_of_type_Agxe = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getPanelManager();
    }
    return (PokeAndEmoPanel)this.jdField_a_of_type_Agxe.a(23);
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
      agkg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), agkg.a);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 9: 
    case 11: 
    case 12: 
    default: 
      return;
    case 8: 
      a();
      return;
    case 10: 
      b();
      return;
    }
    c();
  }
  
  public int[] a()
  {
    return new int[] { 8, 10, 13 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrw
 * JD-Core Version:    0.7.0.1
 */