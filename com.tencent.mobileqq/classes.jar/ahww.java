import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMediaFragment;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class ahww
  implements bhqd
{
  public ahww(ChatHistoryTroopMediaFragment paramChatHistoryTroopMediaFragment, bhpy parambhpy, ArrayList paramArrayList) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_Bhpy.a(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.getActivity().getResources().getString(2131689983))) {
          break label92;
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.a != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.a.h();
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
      label92:
      if (paramView.equals(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.getActivity().getResources().getString(2131693486))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.a(this.jdField_a_of_type_JavaUtilArrayList);
      } else if (paramView.equals(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.getActivity().getResources().getString(2131693498))) {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 20) {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.getActivity(), 2131692849, 0).a();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.b(this.jdField_a_of_type_JavaUtilArrayList);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahww
 * JD-Core Version:    0.7.0.1
 */