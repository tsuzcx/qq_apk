import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.widget.QQToast;

public class aisx
  implements TextView.OnEditorActionListener
{
  public aisx(SearchBaseActivity paramSearchBaseActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt != 3)
    {
      bool1 = bool2;
      if (paramKeyEvent != null)
      {
        bool1 = bool2;
        if (paramKeyEvent.getKeyCode() != 66) {}
      }
    }
    else
    {
      paramTextView = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if ((!TextUtils.isEmpty(paramTextView)) && (!TextUtils.isEmpty(paramTextView.trim()))) {
        break label102;
      }
      this.a.a(true, this.a.jdField_a_of_type_AndroidWidgetEditText);
      QQToast.a(this.a.getApplicationContext(), anni.a(2131712379), 0).a();
      bool1 = true;
    }
    return bool1;
    label102:
    if (!TextUtils.isEmpty(paramTextView))
    {
      bbup.a("add_page", "search", "clk_search_all", this.a.h + 1, 0, new String[] { "", "", paramTextView, "" });
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(paramTextView, false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisx
 * JD-Core Version:    0.7.0.1
 */