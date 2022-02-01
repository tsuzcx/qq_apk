import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewGroup.LayoutParams;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.widget.NewStyleDropdownView;

public class alrw
  implements TextWatcher
{
  public alrw(LoginView paramLoginView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    LoginView.c(this.a);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (paramCharSequence.length() > 0) {
      if (this.a.b != null)
      {
        localObject = (alsl)this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
        if ((localObject != null) && (((alsl)localObject).getCount() != 0)) {
          break label139;
        }
        localObject = (RelativeLayout.LayoutParams)this.a.b.getLayoutParams();
        paramInt1 = (int)(15.0F * LoginView.a(this.a) + 0.5F);
        if (((RelativeLayout.LayoutParams)localObject).rightMargin != paramInt1)
        {
          ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt1;
          this.a.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        this.a.b.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramCharSequence.length() <= 4) {
        break label237;
      }
      this.a.b(paramCharSequence.toString());
      return;
      label139:
      localObject = (RelativeLayout.LayoutParams)this.a.b.getLayoutParams();
      paramInt1 = (int)(40.0F * LoginView.a(this.a) + 0.5F);
      if (((RelativeLayout.LayoutParams)localObject).rightMargin == paramInt1) {
        break;
      }
      ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt1;
      this.a.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break;
      if ((this.a.b != null) && (this.a.b.isShown())) {
        this.a.b.setVisibility(8);
      }
    }
    label237:
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alrw
 * JD-Core Version:    0.7.0.1
 */