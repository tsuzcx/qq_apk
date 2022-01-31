import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMediaFragment;
import java.util.ArrayList;

public class afza
  implements bfoq
{
  public afza(ChatHistoryTroopMediaFragment paramChatHistoryTroopMediaFragment, bfol parambfol, ArrayList paramArrayList) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_Bfol.a(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.getActivity().getResources().getString(2131689936))) {
          break label92;
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.a != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.a.h();
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfol.dismiss();
      return;
      label92:
      if (paramView.equals(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.getActivity().getResources().getString(2131693384))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.a(this.jdField_a_of_type_JavaUtilArrayList);
      } else if (paramView.equals(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.getActivity().getResources().getString(2131693396))) {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 20) {
          bcpw.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.getActivity(), 2131692766, 0).a();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.b(this.jdField_a_of_type_JavaUtilArrayList);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afza
 * JD-Core Version:    0.7.0.1
 */