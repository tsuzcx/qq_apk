import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.ContentRecommendModel;
import com.tencent.mobileqq.search.ContentRecommendModel.ContentRecommendListAdapter;
import com.tencent.mobileqq.search.model.ContentRecommendDataModel.ContentRecommendItem;
import com.tencent.mobileqq.search.util.SearchUtils;

public class ahqq
  implements View.OnClickListener
{
  public ahqq(ContentRecommendModel.ContentRecommendListAdapter paramContentRecommendListAdapter, ahqs paramahqs) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Ahqs.a.d))
    {
      SearchUtils.a("home_page", "clk_rec_title", new String[] { this.jdField_a_of_type_Ahqs.a.a, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel$ContentRecommendListAdapter.a.jdField_a_of_type_Int) });
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel$ContentRecommendListAdapter.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_Ahqs.a.d);
      this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel$ContentRecommendListAdapter.a.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahqq
 * JD-Core Version:    0.7.0.1
 */