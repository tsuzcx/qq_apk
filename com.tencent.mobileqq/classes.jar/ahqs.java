import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.ark.ArkAppManagerPanel;

public class ahqs
  implements ahrc<ArkAppManagerPanel>
{
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private ArkAppManagerPanel jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel;
  
  public ahqs(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
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
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel = ((ArkAppManagerPanel)View.inflate(paramContext, 2131558690, null));
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a);
    return this.jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqs
 * JD-Core Version:    0.7.0.1
 */