import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.TroopEggLottieAnimHelper.1;
import com.tencent.widget.XEditTextEx;

public class afgk
  implements affa
{
  private aexk jdField_a_of_type_Aexk;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public afgk(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Aexk = new aexk(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("chat_inputBarContent");
    } while ((str == null) || (str.isEmpty()));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(str);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx, 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.post(new TroopEggLottieAnimHelper.1(this, str));
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 5: 
      a();
      return;
    }
    a();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Aexk != null) {
      this.jdField_a_of_type_Aexk.a();
    }
    return true;
  }
  
  public boolean a(Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_Aexk == null) {
      this.jdField_a_of_type_Aexk = new aexk(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
    return this.jdField_a_of_type_Aexk.a(paramVarArgs);
  }
  
  public int[] a()
  {
    return new int[] { 5, 8, 11 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgk
 * JD-Core Version:    0.7.0.1
 */