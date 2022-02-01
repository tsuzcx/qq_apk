import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.TroopEggLottieAnimHelper.1;
import com.tencent.widget.XEditTextEx;

public class agwv
  implements agvc
{
  private BaseChatPie a;
  
  public agwv(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void a()
  {
    if (this.a == null) {}
    String str;
    do
    {
      return;
      str = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("chat_inputBarContent");
    } while ((str == null) || (str.isEmpty()));
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(str);
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
    InputMethodManager localInputMethodManager = (InputMethodManager)this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.showSoftInput(this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx, 1);
    }
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.post(new TroopEggLottieAnimHelper.1(this, str));
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a();
  }
  
  public int[] a()
  {
    return new int[] { 6 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwv
 * JD-Core Version:    0.7.0.1
 */