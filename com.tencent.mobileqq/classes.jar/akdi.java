import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMediaFragment;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class akdi
  implements bliz
{
  public akdi(ChatHistoryTroopMediaFragment paramChatHistoryTroopMediaFragment, blir paramblir, ArrayList paramArrayList) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_Blir.a(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.getActivity().getResources().getString(2131689887))) {
          break label92;
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.a != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.a.i();
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Blir.dismiss();
      return;
      label92:
      if (paramView.equals(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.getActivity().getResources().getString(2131692963))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.a(this.jdField_a_of_type_JavaUtilArrayList);
      } else if (paramView.equals(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.getActivity().getResources().getString(2131692969))) {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 20) {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.getActivity(), 2131692409, 0).a();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.b(this.jdField_a_of_type_JavaUtilArrayList);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdi
 * JD-Core Version:    0.7.0.1
 */