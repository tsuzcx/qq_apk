import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XPanelContainer;

public class agwv
  implements agxf<HongBaoPanel>
{
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private HongBaoPanel jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public agwv(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
  }
  
  public int a()
  {
    return 10;
  }
  
  public HongBaoPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel;
  }
  
  public HongBaoPanel a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel = ((HongBaoPanel)View.inflate(paramContext, 2131560504, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(XPanelContainer paramXPanelContainer)
  {
    paramXPanelContainer.a(10);
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwv
 * JD-Core Version:    0.7.0.1
 */