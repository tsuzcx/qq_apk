import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.8.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ahhy
  extends arht
{
  ahhy(ahhp paramahhp) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, ariy paramariy, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, String.format("onGetUnLimitFriendInfo() success=%s uinType=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) }));
    }
    if ((paramBoolean) && (paramariy != null)) {
      ThreadManager.getSubThreadHandler().post(new LimitChatPie.8.1(this, paramInt2, paramariy));
    }
  }
  
  protected void a(boolean paramBoolean, arjk paramarjk, int paramInt)
  {
    if ((paramBoolean) && (paramarjk != null))
    {
      VipUtils.a(this.a.app, paramarjk, this.a.mCustomTitleView, this.a.mTitleIconRight, this.a.isJubaoMode);
      ahhp.a(this.a, paramarjk.mNickName);
      this.a.mTitleText.setText(paramarjk.mNickName);
      if ((!TextUtils.isEmpty(paramarjk.mNickName)) && (this.a.sessionInfo != null)) {
        this.a.sessionInfo.curFriendNick = paramarjk.mNickName;
      }
    }
  }
  
  protected void a(boolean paramBoolean, ArrayList<Long> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, String.format("onGetExtendFriendOnlineState success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    ahhp.a(this.a, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhy
 * JD-Core Version:    0.7.0.1
 */