import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.qphone.base.util.QLog;

public class ahrh
  implements ahrc<PlusPanel>
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private PlusPanel jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel;
  
  ahrh(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public int a()
  {
    return 8;
  }
  
  public PlusPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel;
  }
  
  public PlusPanel a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel = ((PlusPanel)View.inflate(paramContext, 2131558626, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a);
    paramContext = (agju)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(62);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.setAIOLongCaptureCtrlListener(paramContext.a);
    if (QLog.isColorLevel()) {
      QLog.d("OpenPanel", 2, "OpenIconPanel:" + (System.currentTimeMillis() - l));
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrh
 * JD-Core Version:    0.7.0.1
 */