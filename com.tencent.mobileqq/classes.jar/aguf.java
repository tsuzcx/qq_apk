import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.widget.XEditTextEx;

public class aguf
  implements agvc
{
  protected aguh a;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  protected boolean a;
  
  public aguf(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.a();
  }
  
  private void a(XEditTextEx paramXEditTextEx)
  {
    this.jdField_a_of_type_Boolean = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694428), "qqsetting_enter_sendmsg_key", false);
    if (this.jdField_a_of_type_Boolean) {
      paramXEditTextEx.setImeOptions(4);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aguh == null) {
        this.jdField_a_of_type_Aguh = new aguh(this, null);
      }
      paramXEditTextEx.setOnEditorActionListener(this.jdField_a_of_type_Aguh);
      paramXEditTextEx.setOnKeyListener(this.jdField_a_of_type_Aguh);
      return;
      paramXEditTextEx.setImeOptions(0);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 20: 
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a);
  }
  
  public int[] a()
  {
    return new int[] { 20, 8 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aguf
 * JD-Core Version:    0.7.0.1
 */