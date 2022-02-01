import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.Ret;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.SignInStatusBase;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.SignInStatusDoneInfo;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StSignInStatusRsp;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StSignInWriteRsp;

class aghf
  extends aofu
{
  aghf(aghe paramaghe) {}
  
  protected void onGetSignInStatus(boolean paramBoolean, String paramString1, String paramString2, Object paramObject, int paramInt)
  {
    boolean bool = true;
    if ((!paramBoolean) || (paramObject == null) || (!(paramObject instanceof oidb_0xeb7.StSignInStatusRsp))) {
      if (QLog.isColorLevel()) {
        QLog.d("ClockInEntryHelper.helper", 2, "onGetSignInStatus failed");
      }
    }
    do
    {
      return;
      paramObject = (oidb_0xeb7.StSignInStatusRsp)paramObject;
      if (paramObject.ret.code.get() == 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    paramString2 = new StringBuilder().append("onGetSignInStatus error code: ").append(paramObject.ret.code.get()).append(" ");
    if (paramObject.ret.msg.has()) {}
    for (paramString1 = paramObject.ret.msg.get();; paramString1 = "")
    {
      QLog.d("ClockInEntryHelper.helper", 2, paramString1);
      return;
    }
    label164:
    long l;
    if (((oidb_0xeb7.SignInStatusBase)paramObject.base.get()).status.get() == 1)
    {
      paramBoolean = true;
      l = NetConnInfoCenter.getServerTime();
      if (QLog.isColorLevel()) {
        QLog.d("ClockInEntryHelper.helper", 2, "onGetSignInStatus hasSignedIn: " + paramBoolean);
      }
      if (aghe.a(this.a).mCustomTitleView.getVisibility() == 0)
      {
        if (aghe.a(this.a)) {
          break label302;
        }
        if (aghe.a(this.a) != null) {
          aghe.a(this.a).setVisibility(8);
        }
      }
    }
    label302:
    label331:
    do
    {
      do
      {
        aghe.a(this.a, aghe.a(this.a).sessionInfo.curFriendUin, l);
        if (!paramBoolean) {
          break;
        }
        aghe.b(this.a, aghe.a(this.a).sessionInfo.curFriendUin, l);
        return;
        paramBoolean = false;
        break label164;
      } while (!paramString1.equals(aghe.a(this.a).sessionInfo.curFriendUin));
      paramString1 = this.a;
      if (paramBoolean) {
        break label395;
      }
      aghe.a(paramString1, bool, aghe.b(this.a), false);
    } while (!paramBoolean);
    paramString1 = aghe.a(this.a).mCustomTitleView;
    if (nty.a().a(aghe.a(this.a).sessionInfo.curFriendUin)) {}
    for (paramInt = 2130850448;; paramInt = 2130850449)
    {
      paramString1.setRight2Icon(paramInt);
      break;
      label395:
      bool = false;
      break label331;
    }
  }
  
  protected void onSetSignInStatus(boolean paramBoolean, String paramString1, String paramString2, Object paramObject)
  {
    if ((!paramBoolean) || (paramObject == null) || (!(paramObject instanceof oidb_0xeb7.StSignInWriteRsp))) {
      if (QLog.isColorLevel()) {
        QLog.d("ClockInEntryHelper.helper", 2, "onSetSignInStatus failed");
      }
    }
    do
    {
      do
      {
        return;
        paramObject = (oidb_0xeb7.StSignInWriteRsp)paramObject;
        if (paramObject.ret.code.get() == 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      paramString2 = new StringBuilder().append("onSetSignInStatus error code: ").append(paramObject.ret.code.get()).append(" ");
      if (paramObject.ret.msg.has()) {}
      for (paramString1 = paramObject.ret.msg.get();; paramString1 = "")
      {
        QLog.d("ClockInEntryHelper.helper", 2, paramString1);
        return;
      }
      paramBoolean = paramObject.doneInfo.has();
      if (QLog.isColorLevel()) {
        QLog.d("ClockInEntryHelper.helper", 2, "onSetSignInStatus isDoneClockin: " + paramBoolean);
      }
    } while (!paramBoolean);
    if ((paramString1.equals(aghe.a(this.a).sessionInfo.curFriendUin)) && (aghe.a(this.a)))
    {
      aghe.a(this.a, false, false, false);
      paramString1 = aghe.a(this.a).mCustomTitleView;
      if (!nty.a().a(aghe.a(this.a).sessionInfo.curFriendUin)) {
        break label293;
      }
    }
    label293:
    for (int i = 2130850448;; i = 2130850449)
    {
      paramString1.setRight2Icon(i);
      long l = NetConnInfoCenter.getServerTime();
      aghe.b(this.a, aghe.a(this.a).sessionInfo.curFriendUin, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghf
 * JD-Core Version:    0.7.0.1
 */