import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PokeAndEmoPanel;
import com.tencent.mobileqq.app.QQAppInterface;

public class agvt
  implements agvc
{
  private aiap jdField_a_of_type_Aiap;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public agvt(aguw paramaguw, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  private PokeAndEmoPanel a()
  {
    if (this.jdField_a_of_type_Aiap == null) {
      this.jdField_a_of_type_Aiap = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    }
    return (PokeAndEmoPanel)this.jdField_a_of_type_Aiap.b(23);
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
      ahnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), ahnt.a);
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
 * Qualified Name:     agvt
 * JD-Core Version:    0.7.0.1
 */