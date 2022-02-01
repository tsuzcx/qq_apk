import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PokeAndEmoPanel;

public class aiaw
  implements aiaq<PokeAndEmoPanel>
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private PokeAndEmoPanel jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel;
  
  aiaw(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public int a()
  {
    return 23;
  }
  
  public PokeAndEmoPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel;
  }
  
  public PokeAndEmoPanel a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel = ((PokeAndEmoPanel)View.inflate(paramContext, 2131558626, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a);
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 23) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel.a();
    }
    if ((paramInt1 == 23) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel.c();
    }
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiaw
 * JD-Core Version:    0.7.0.1
 */