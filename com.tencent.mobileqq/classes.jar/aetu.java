import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.widget.ClearableEditText;

public class aetu
  implements View.OnFocusChangeListener
{
  public aetu(RegisterByNicknameAndPwdActivity paramRegisterByNicknameAndPwdActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == RegisterByNicknameAndPwdActivity.a(this.a))
    {
      if (paramBoolean)
      {
        RegisterByNicknameAndPwdActivity.a(this.a).setSelection(RegisterByNicknameAndPwdActivity.a(this.a).getText().length());
        RegisterByNicknameAndPwdActivity.a(this.a).setVisibility(0);
        RegisterByNicknameAndPwdActivity.a(this.a).setVisibility(0);
        RegisterByNicknameAndPwdActivity.b(this.a).setVisibility(0);
      }
    }
    else {
      return;
    }
    RegisterByNicknameAndPwdActivity.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aetu
 * JD-Core Version:    0.7.0.1
 */