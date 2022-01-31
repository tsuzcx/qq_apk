import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.search.BusinessSearchEntryModel;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.model.BusinessSearchEntryDataModel.SearchEntry;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class ahvd
  implements View.OnClickListener
{
  public ahvd(BusinessSearchEntryModel paramBusinessSearchEntryModel, View paramView1, BusinessSearchEntryDataModel.SearchEntry paramSearchEntry, View paramView2, String paramString, List paramList) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (((this.jdField_a_of_type_AndroidViewView.getTag() instanceof Long)) && (l - ((Long)this.jdField_a_of_type_AndroidViewView.getTag()).longValue() < 400L)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setTag(Long.valueOf(l));
    String str;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelBusinessSearchEntryDataModel$SearchEntry.jdField_c_of_type_JavaLangString))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqSearchModelBusinessSearchEntryDataModel$SearchEntry.jdField_c_of_type_JavaLangString;
      if ((str.startsWith("http://")) || (str.startsWith("https://")))
      {
        paramView = new Intent(BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel), QQBrowserActivity.class);
        paramView.putExtra("url", str);
        BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel).startActivity(paramView);
      }
    }
    for (;;)
    {
      if (this.b.getVisibility() == 0)
      {
        this.b.setVisibility(8);
        SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqSearchModelBusinessSearchEntryDataModel$SearchEntry.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      SearchUtils.a("home_page", "clk_entry", new String[] { this.jdField_a_of_type_ComTencentMobileqqSearchModelBusinessSearchEntryDataModel$SearchEntry.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel.a), String.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      return;
      if ((BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel) instanceof BaseActivity))
      {
        paramView = JumpParser.a(((BaseActivity)paramView.getContext()).app, BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel), str);
        if (paramView != null) {
          paramView.b();
        } else {
          BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel).startActivity(new Intent(BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel), JumpActivity.class).setData(Uri.parse(str)));
        }
      }
      else
      {
        BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel).startActivity(new Intent(BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel), JumpActivity.class).setData(Uri.parse(str)));
        continue;
        int i = this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel.a;
        if (this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel.a == 3) {
          i = 21;
        }
        ActiveEntitySearchActivity.a(BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel), this.jdField_a_of_type_ComTencentMobileqqSearchModelBusinessSearchEntryDataModel$SearchEntry.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSearchModelBusinessSearchEntryDataModel$SearchEntry.jdField_a_of_type_ArrayOfLong, i);
        if (!NetworkUtil.g(BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel))) {
          QQToast.a(BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel), 0, BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel).getResources().getString(2131438890), 0).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahvd
 * JD-Core Version:    0.7.0.1
 */