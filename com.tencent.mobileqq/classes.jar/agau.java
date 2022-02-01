import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class agau
  extends anvi
{
  public agau(TroopChatPie paramTroopChatPie) {}
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    int i;
    if (QLog.isColorLevel())
    {
      String str = this.a.tag;
      StringBuilder localStringBuilder = new StringBuilder().append("onSetGenralSettingsTroopFilter: isSuc = ").append(paramBoolean).append(", size = ");
      if (paramMap == null)
      {
        i = 0;
        QLog.d(str, 2, i);
      }
    }
    else
    {
      if ((paramMap != null) && (paramMap.size() != 0)) {
        break label83;
      }
    }
    label83:
    while (!this.a.mActivity.isResume())
    {
      return;
      i = paramMap.size();
      break;
    }
    if (paramBoolean)
    {
      QQToast.a(this.a.app.getApp(), 2, this.a.mActivity.getString(2131719665), 0).b(this.a.mActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.app.getApp(), 1, this.a.mActivity.getString(2131719664), 0).b(this.a.mActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agau
 * JD-Core Version:    0.7.0.1
 */