import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.widget.XEditTextEx;

public class aghi
  implements agin
{
  protected aghk a;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  protected boolean a;
  
  public aghi(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.getActivity();
  }
  
  private void a(XEditTextEx paramXEditTextEx)
  {
    this.jdField_a_of_type_Boolean = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694743), "qqsetting_enter_sendmsg_key", false);
    if (this.jdField_a_of_type_Boolean) {
      paramXEditTextEx.setImeOptions(4);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aghk == null) {
        this.jdField_a_of_type_Aghk = new aghk(this, null);
      }
      paramXEditTextEx.setOnEditorActionListener(this.jdField_a_of_type_Aghk);
      paramXEditTextEx.setOnKeyListener(this.jdField_a_of_type_Aghk);
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
    case 21: 
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input);
  }
  
  public int[] a()
  {
    return new int[] { 21, 9 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghi
 * JD-Core Version:    0.7.0.1
 */