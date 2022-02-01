import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.qphone.base.util.QLog;

class ahez
  extends apsf
{
  ahez(ahey paramahey) {}
  
  private void a(boolean paramBoolean, String paramString)
  {
    StringBuilder localStringBuilder;
    if ((this.a.mActivity != null) && (!this.a.mActivity.isFinishing()))
    {
      localStringBuilder = new StringBuilder();
      if (!paramBoolean) {}
    }
    else
    {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      localStringBuilder.append("屏蔽失败，请重试。");
      this.a.a(2, localStringBuilder.toString(), 500);
      return;
    }
    localStringBuilder.append("屏蔽失败，").append(paramString);
    this.a.a(2, localStringBuilder.toString(), 500);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (!aprw.a(this.a.app)) {}
    do
    {
      do
      {
        return;
      } while ((!paramString.equals(this.a.sessionInfo.curFriendUin)) || (paramInt1 != this.a.sessionInfo.topicId) || (paramInt2 != this.a.sessionInfo.curType));
      ahey.a(this.a);
    } while (!QLog.isColorLevel());
    QLog.i(this.a.tag, 2, "onCheckHolmesTipsView  frdUin:" + paramString + " type:" + paramInt2 + " topicid:" + paramInt1);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if (!aprw.a(this.a.app)) {
      return;
    }
    if (paramBoolean2) {}
    for (;;)
    {
      String str = Long.toString(paramLong2);
      if ((!str.equals(this.a.sessionInfo.curFriendUin)) || (paramInt1 != this.a.sessionInfo.topicId) || (paramInt2 != this.a.sessionInfo.curType)) {
        break;
      }
      if (paramBoolean1)
      {
        apsj localapsj = this.a.app.getProxyManager().a();
        ConfessConvInfo localConfessConvInfo = localapsj.a(this.a.sessionInfo.curFriendUin, this.a.sessionInfo.curType, this.a.sessionInfo.topicId);
        if ((localConfessConvInfo != null) && ((localConfessConvInfo.holmesCurCount != paramInt3) || (localConfessConvInfo.holmesTolCount != paramInt4))) {
          localapsj.a(str, paramInt2, paramInt1, paramInt3, paramInt4);
        }
        ahey.a(this.a, true);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(this.a.tag, 2, "onGetHolmesProgress " + paramBoolean1 + " frdUin:" + str + " type:" + paramInt2 + " topicid:" + paramInt1 + " curCount:" + paramInt3);
      return;
      paramLong2 = paramLong1;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, ConfessInfo paramConfessInfo)
  {
    String str;
    if ((this.a.sessionInfo != null) && (bftf.a(paramString1, this.a.sessionInfo.curFriendUin)) && (paramInt1 == this.a.sessionInfo.curType) && (paramInt2 == this.a.sessionInfo.topicId)) {
      if (QLog.isColorLevel())
      {
        str = this.a.tag;
        paramInt2 = this.a.sessionInfo.topicId;
        if (paramString2 != null) {
          break label162;
        }
      }
    }
    label162:
    for (paramConfessInfo = "";; paramConfessInfo = paramString2)
    {
      QLog.i(str, 2, String.format("onSetShieldFlag suc:%b frdUin:%s uinType:%d topicId:%d hours:%d msg:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramConfessInfo }));
      this.a.a();
      a(paramBoolean, paramString2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahez
 * JD-Core Version:    0.7.0.1
 */