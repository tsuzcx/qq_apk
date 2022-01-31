import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;

public class aevf
  implements TextView.OnEditorActionListener
{
  public aevf(SearchBaseActivity paramSearchBaseActivity) {}
  
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
      bbmy.a(this.a.getApplicationContext(), ajjy.a(2131647818), 0).a();
      bool1 = true;
    }
    return bool1;
    label102:
    if (!TextUtils.isEmpty(paramTextView))
    {
      avwf.a("add_page", "search", "clk_search_all", this.a.h + 1, 0, new String[] { "", "", paramTextView, "" });
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(paramTextView, false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aevf
 * JD-Core Version:    0.7.0.1
 */