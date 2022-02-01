import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PokeAndEmoPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XPanelContainer;

public class ahqm
  implements ahqf<PokeAndEmoPanel>
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private PokeAndEmoPanel jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel;
  
  ahqm(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel = ((PokeAndEmoPanel)View.inflate(paramContext, 2131558641, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo);
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
  
  public void a(XPanelContainer paramXPanelContainer)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.panelicons.setShowRed(23, false);
    ahcw.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.showPokePanel();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp().reportClickEvent("CliOper", "0X8007F20");
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqm
 * JD-Core Version:    0.7.0.1
 */