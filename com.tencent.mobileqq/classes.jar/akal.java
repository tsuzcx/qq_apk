import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class akal
  implements ActionSheet.OnButtonClickListener
{
  public akal(SwiftBrowserLongClickHandler paramSwiftBrowserLongClickHandler) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Int);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435466);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    if (paramInt == 0) {
      if (TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) {
        this.a.jdField_b_of_type_Int = 0;
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      this.a.b(this.a.jdField_b_of_type_JavaLangString);
      continue;
      if (paramInt == 1)
      {
        if (TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) {
          this.a.jdField_b_of_type_Int = 1;
        } else {
          this.a.a(this.a.jdField_b_of_type_JavaLangString);
        }
      }
      else if (paramInt == 2)
      {
        if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        this.a.c(this.a.jdField_b_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akal
 * JD-Core Version:    0.7.0.1
 */