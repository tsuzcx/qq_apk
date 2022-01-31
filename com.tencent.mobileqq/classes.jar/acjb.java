import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;

public class acjb
  implements View.OnClickListener
{
  public acjb(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363264: 
      if ((ExtendFriendSquareFragment.a(this.a) != null) && (ExtendFriendSquareFragment.a(this.a).isShowing())) {
        ExtendFriendSquareFragment.a(this.a).dismiss();
      }
      if (!ExtendFriendSquareFragment.c(this.a))
      {
        ReportController.b(ExtendFriendSquareFragment.a(this.a), "dc00898", "", "", "0X80092EC", "0X80092EC", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(ExtendFriendSquareFragment.a(this.a), "dc00898", "", "", "0X80092E9", "0X80092E9", 0, 0, "", "", "", "");
      return;
    }
    if (!ExtendFriendSquareFragment.c(this.a)) {
      PublicFragmentActivity.a(this.a.getActivity(), ExtendFriendEditFragment.class, 1031);
    }
    for (;;)
    {
      if ((ExtendFriendSquareFragment.a(this.a) != null) && (ExtendFriendSquareFragment.a(this.a).isShowing())) {
        ExtendFriendSquareFragment.a(this.a).dismiss();
      }
      if (ExtendFriendSquareFragment.c(this.a)) {
        break;
      }
      ReportController.b(ExtendFriendSquareFragment.a(this.a), "dc00898", "", "", "0X80092EB", "0X80092EB", 0, 0, "", "", "", "");
      return;
      paramView = new ProfileActivity.AllInOne(ExtendFriendSquareFragment.a(this.a).c(), 97);
      paramView = ProfileCardUtil.a(new Intent(ExtendFriendSquareFragment.a(this.a), FriendProfileMoreInfoActivity.class), ExtendFriendSquareFragment.a(this.a).c(), ExtendFriendSquareFragment.a(this.a), paramView, null);
      this.a.startActivityForResult(paramView, 2);
    }
    ReportController.b(ExtendFriendSquareFragment.a(this.a), "dc00898", "", "", "0X80092E8", "0X80092E8", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjb
 * JD-Core Version:    0.7.0.1
 */