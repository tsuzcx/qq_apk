import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.business.sougou.HightlightHotWordText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.lang.ref.WeakReference;

public class abtg
  implements ActionSheet.OnButtonClickListener
{
  public abtg(HightlightHotWordText paramHightlightHotWordText, Context paramContext, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      do
      {
        return;
        paramView = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouHightlightHotWordText.b + this.jdField_a_of_type_ComTencentMobileqqBusinessSougouHightlightHotWordText.jdField_a_of_type_JavaLangString;
      } while ((TextUtils.isEmpty(paramView)) || ((!paramView.startsWith("http://")) && (!paramView.startsWith("https://"))));
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      if ((this.jdField_a_of_type_ComTencentMobileqqBusinessSougouHightlightHotWordText.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouHightlightHotWordText.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
        ReportController.b((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqBusinessSougouHightlightHotWordText.jdField_a_of_type_JavaLangRefWeakReference.get(), "P_CliOper", "aio_search", "", "aio_hotword", "search_hotword", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqBusinessSougouHightlightHotWordText.jdField_a_of_type_JavaLangString, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abtg
 * JD-Core Version:    0.7.0.1
 */