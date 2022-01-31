import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;

public class ahwd
  implements View.OnClickListener
{
  public ahwd(ActiveEntitySearchActivity paramActiveEntitySearchActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.c();
    this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.a.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(false);
    this.a.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this.a);
    if ((ActiveEntitySearchActivity.a(this.a) == 1) && (!TextUtils.isEmpty(this.a.b)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(this.a.b);
      ActiveEntitySearchActivity.a(this.a, ActiveEntitySearchActivity.a(this.a));
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this.a);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText("");
      ActiveEntitySearchActivity.a(this.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahwd
 * JD-Core Version:    0.7.0.1
 */