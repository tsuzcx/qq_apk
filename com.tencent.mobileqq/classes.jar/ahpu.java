import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.ark.ArkAppManagerPanel;
import com.tencent.widget.XPanelContainer;

public class ahpu
  implements ahqf<ArkAppManagerPanel>
{
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private ArkAppManagerPanel jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel;
  
  public ahpu(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public int a()
  {
    return 30;
  }
  
  public ArkAppManagerPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel;
  }
  
  public ArkAppManagerPanel a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel = ((ArkAppManagerPanel)View.inflate(paramContext, 2131558708, null));
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo);
    return this.jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(XPanelContainer paramXPanelContainer) {}
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpu
 * JD-Core Version:    0.7.0.1
 */