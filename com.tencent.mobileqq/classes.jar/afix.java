import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

class afix
  extends anbn
{
  afix(afiw paramafiw) {}
  
  public void a(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
      } while (!((String)paramList.next()).equals(this.a.sessionInfo.curFriendUin));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a.tag, 2, String.format("be deleted, current uin: %s", new Object[] { this.a.sessionInfo.curFriendUin }));
        }
        this.a.finish();
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, PBRepeatMessageField<oidb_0x5d4.DelResult> paramPBRepeatMessageField)
  {
    if (this.a.mActivity.isFinishing()) {}
    label338:
    label339:
    for (;;)
    {
      return;
      if (this.a.mProgressDialog != null) {
        this.a.mProgressDialog.dismiss();
      }
      if (paramBoolean)
      {
        paramPBRepeatMessageField = paramPBRepeatMessageField.get().iterator();
        paramBoolean = false;
        if (paramPBRepeatMessageField.hasNext())
        {
          if (!String.valueOf(((oidb_0x5d4.DelResult)paramPBRepeatMessageField.next()).uin.get()).equalsIgnoreCase(this.a.sessionInfo.curFriendUin)) {
            break label338;
          }
          paramBoolean = true;
        }
      }
      for (;;)
      {
        break;
        if (!paramBoolean) {
          break label339;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.a.tag, 2, "StrangerObserver : onDelete , result=" + paramBoolean);
        }
        paramPBRepeatMessageField = new ArrayList();
        paramPBRepeatMessageField.add(this.a.sessionInfo.curFriendUin);
        acvv.a(this.a.app, BaseApplication.getContext(), paramPBRepeatMessageField);
        paramPBRepeatMessageField = this.a.app.getProxyManager().a();
        if (paramPBRepeatMessageField != null)
        {
          RecentUser localRecentUser = (RecentUser)paramPBRepeatMessageField.findRecentUserByUin(this.a.sessionInfo.curFriendUin, this.a.sessionInfo.curType);
          if (QLog.isDevelopLevel()) {
            QLog.d(this.a.tag, 4, "StrangerObserver, delete Recent user");
          }
          paramPBRepeatMessageField.delRecentUser(localRecentUser);
        }
        QQToast.a(this.a.mActivity, 2, this.a.mActivity.getResources().getString(2131718526), 0).a();
        if (this.a.isFromManageStranger) {
          this.a.mActivity.setResult(-1);
        }
        this.a.finish();
        return;
        QQToast.a(this.a.mActivity, this.a.mActivity.getResources().getString(2131718524), 0).a();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afix
 * JD-Core Version:    0.7.0.1
 */