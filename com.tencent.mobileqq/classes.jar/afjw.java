import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class afjw
  implements DialogInterface.OnClickListener
{
  public afjw(TroopChatPie paramTroopChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (anca)this.a.app.getBusinessHandler(20);
    if ((NetworkUtil.isNetSupport(this.a.app.getApp().getApplicationContext())) && (paramDialogInterface != null)) {
      if (((TroopManager)this.a.app.getManager(52)).c(this.a.sessionInfo.curFriendUin).isTroopOwner(this.a.app.getCurrentAccountUin())) {
        paramDialogInterface.l(this.a.sessionInfo.curFriendUin);
      }
    }
    for (;;)
    {
      new bcek(this.a.app).a("dc00899").b("Grp_banned").c("Grp_AIO").d("clk_quitgrp").a(new String[] { this.a.sessionInfo.curFriendUin }).a();
      return;
      paramDialogInterface.k(this.a.sessionInfo.curFriendUin);
      continue;
      if (paramDialogInterface != null) {
        QQToast.a(this.a.mActivity, 1, 2131694108, 0).a();
      } else {
        QQToast.a(this.a.mActivity, 1, 2131691945, 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjw
 * JD-Core Version:    0.7.0.1
 */