import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.HotWordSearchEntryModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.TitleHeaderItem;
import com.tencent.mobileqq.search.util.SearchUtils;

public class ahvq
  implements View.OnClickListener
{
  public ahvq(HotWordSearchEntryModel paramHotWordSearchEntryModel, HotWordSearchEntryDataModel.TitleHeaderItem paramTitleHeaderItem) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem.d))
    {
      SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem.d);
      SearchUtils.a("hot_list", "clk_title", new String[] { String.valueOf(1), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel.jdField_a_of_type_Int) });
      return;
    }
    SearchUtils.a("hot_list", "clk_title", new String[] { String.valueOf(2), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahvq
 * JD-Core Version:    0.7.0.1
 */