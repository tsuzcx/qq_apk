import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.qidian.data.BmqqAccountType;

class ahys
  extends CardObserver
{
  ahys(ahyl paramahyl) {}
  
  public void onGetAccountType(boolean paramBoolean, BmqqAccountType paramBmqqAccountType)
  {
    super.onGetAccountType(paramBoolean, paramBmqqAccountType);
    ahyl.a(this.a);
    this.a.c();
    if ((this.a.panelicons != null) && (this.a.b.f(this.a.sessionInfo.curFriendUin)) && (!ahyl.a(this.a)))
    {
      ahyl.a(this.a, true);
      this.a.panelicons.a(this.a.app, this.a.sessionInfo, this.a.mActivity.getChatFragment().a);
    }
    if ((paramBmqqAccountType != null) && (paramBmqqAccountType.getUin() != null) && (this.a.sessionInfo != null) && (this.a.sessionInfo.curFriendUin != null) && (paramBmqqAccountType.getUin().equals(this.a.sessionInfo.curFriendUin)) && (paramBmqqAccountType.getAccountType() == 6)) {
      ahyl.b(this.a);
    }
    if ((this.a.sessionInfo != null) && (this.a.sessionInfo.curType == 1024) && ((TextUtils.isEmpty(this.a.sessionInfo.curFriendNick)) || (this.a.sessionInfo.curFriendNick.equals(this.a.sessionInfo.curFriendUin))))
    {
      this.a.sessionInfo.curFriendNick = nwu.b(this.a.app, this.a.sessionInfo.curFriendUin);
      this.a.mTitleText.setText(this.a.sessionInfo.curFriendNick);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahys
 * JD-Core Version:    0.7.0.1
 */