import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel;
import com.tencent.mobileqq.app.QQAppInterface;

public class ahqt
  implements ahrc<HongBaoPanel>
{
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private HongBaoPanel jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public ahqt(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel = ((HongBaoPanel)View.inflate(paramContext, 2131560479, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqt
 * JD-Core Version:    0.7.0.1
 */