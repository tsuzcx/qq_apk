import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class afjy
  extends amop
{
  public afjy(TroopChatPie paramTroopChatPie) {}
  
  protected void a(bfcc parambfcc)
  {
    if ((parambfcc.jdField_a_of_type_Int == 2) && (parambfcc.jdField_a_of_type_Bfcf != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("troop_gag", 2, "onTroopGagStatusChange:" + parambfcc.jdField_a_of_type_JavaLangString);
      }
      if ((!TextUtils.isEmpty(this.a.sessionInfo.curFriendUin)) && (!TextUtils.isEmpty(parambfcc.jdField_a_of_type_JavaLangString))) {
        break label76;
      }
    }
    label76:
    while (!this.a.sessionInfo.curFriendUin.equals(parambfcc.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.a.a(parambfcc.jdField_a_of_type_Bfcf, true);
  }
  
  protected void a(Object paramObject)
  {
    if (this.a.listAdapter != null) {
      this.a.listAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      break label7;
    }
    for (;;)
    {
      label7:
      return;
      if (paramString1.equals(this.a.sessionInfo.curFriendUin))
      {
        TroopManager localTroopManager = (TroopManager)this.a.app.getManager(52);
        TroopInfo localTroopInfo = localTroopManager.c(this.a.sessionInfo.curFriendUin);
        if (localTroopInfo == null) {
          break;
        }
        if (!paramBoolean) {
          if (!TextUtils.isEmpty(paramString3)) {
            QQToast.a(BaseApplicationImpl.getContext(), 1, paramString3, 0).a();
          }
        }
        while ((this.a.sessionInfo.curFriendUin.equals(paramString1)) && (localTroopInfo != null))
        {
          this.a.sessionInfo.curFriendNick = localTroopInfo.getTroopName();
          paramString1 = this.a.mActivity.getIntent();
          paramString1.putExtra("uinname", localTroopInfo.getTroopName());
          this.a.updateSession_updateTitle(paramString1);
          return;
          localTroopInfo.troopname = paramString2;
          localTroopInfo.hasSetNewTroopName = true;
          if ((this.a.isActivityResume()) && (localTroopInfo.isNewTroop) && (localTroopInfo.hasSetNewTroopName) && (localTroopInfo.hasSetNewTroopHead))
          {
            localTroopInfo.isNewTroop = false;
            TroopUtils.showGetTroopUinDialog(this.a.app, localTroopInfo, this.a.mActivity, new afjz(this));
          }
          localTroopManager.b(localTroopInfo);
          this.a.r();
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.mActivity.isResume()) {
      return;
    }
    if (paramBoolean1)
    {
      if (paramBoolean2) {}
      for (String str = this.a.mActivity.getString(2131695683);; str = this.a.mActivity.getString(2131695594))
      {
        QQToast.a(this.a.mActivity.getApplicationContext(), 2, str, 1).b(this.a.mActivity.getTitleBarHeight());
        return;
      }
    }
    QQToast.a(this.a.mActivity.getApplicationContext(), 1, 2131695682, 1).b(this.a.mActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjy
 * JD-Core Version:    0.7.0.1
 */