import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.search.OperationSearchEntryModel;
import com.tencent.mobileqq.search.model.OperationSearchEntryDataModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;

public class ahde
  implements View.OnClickListener
{
  public ahde(OperationSearchEntryModel paramOperationSearchEntryModel, OperationSearchEntryDataModel paramOperationSearchEntryDataModel) {}
  
  public void onClick(View paramView)
  {
    SearchUtils.a("home_page", "clk_opera", new String[] { this.jdField_a_of_type_ComTencentMobileqqSearchModelOperationSearchEntryDataModel.a, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqSearchOperationSearchEntryModel.a) });
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelOperationSearchEntryDataModel.e.startsWith("http")) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelOperationSearchEntryDataModel.e.startsWith("https")))
    {
      paramView = new Intent(OperationSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchOperationSearchEntryModel), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqSearchModelOperationSearchEntryDataModel.e);
      OperationSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchOperationSearchEntryModel).startActivity(paramView);
      return;
    }
    if ((OperationSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchOperationSearchEntryModel) instanceof BaseActivity))
    {
      paramView = JumpParser.a(((BaseActivity)paramView.getContext()).app, OperationSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchOperationSearchEntryModel), this.jdField_a_of_type_ComTencentMobileqqSearchModelOperationSearchEntryDataModel.e);
      if (paramView != null)
      {
        paramView.b();
        return;
      }
      OperationSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchOperationSearchEntryModel).startActivity(new Intent(OperationSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchOperationSearchEntryModel), JumpActivity.class).setData(Uri.parse(this.jdField_a_of_type_ComTencentMobileqqSearchModelOperationSearchEntryDataModel.e)));
      return;
    }
    OperationSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchOperationSearchEntryModel).startActivity(new Intent(OperationSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchOperationSearchEntryModel), JumpActivity.class).setData(Uri.parse(this.jdField_a_of_type_ComTencentMobileqqSearchModelOperationSearchEntryDataModel.e)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahde
 * JD-Core Version:    0.7.0.1
 */