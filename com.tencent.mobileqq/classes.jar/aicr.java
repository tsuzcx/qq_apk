import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.8.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class aicr
  extends aslz
{
  aicr(aici paramaici) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, asne paramasne, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, String.format("onGetUnLimitFriendInfo() success=%s uinType=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) }));
    }
    if ((paramBoolean) && (paramasne != null)) {
      ThreadManager.getSubThreadHandler().post(new LimitChatPie.8.1(this, paramInt2, paramasne));
    }
  }
  
  protected void a(boolean paramBoolean, asnq paramasnq, int paramInt)
  {
    if ((paramBoolean) && (paramasnq != null))
    {
      VipUtils.a(this.a.app, paramasnq, this.a.mCustomTitleView, this.a.mTitleIconRight, this.a.isJubaoMode);
      aici.a(this.a, paramasnq.mNickName);
      this.a.mTitleText.setText(paramasnq.mNickName);
      if ((!TextUtils.isEmpty(paramasnq.mNickName)) && (this.a.sessionInfo != null)) {
        this.a.sessionInfo.curFriendNick = paramasnq.mNickName;
      }
    }
  }
  
  protected void a(boolean paramBoolean, ArrayList<Long> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, String.format("onGetExtendFriendOnlineState success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    aici.a(this.a, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicr
 * JD-Core Version:    0.7.0.1
 */