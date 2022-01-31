import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipSendVideoPb.RspBody;
import com.tencent.mobileqq.arcard.ARCardObserver;
import com.tencent.mobileqq.arcard.ArCardSelectMemberActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aagm
  extends ARCardObserver
{
  public aagm(ArCardSelectMemberActivity paramArCardSelectMemberActivity) {}
  
  public void a(int paramInt, ARRelationShipSendVideoPb.RspBody paramRspBody)
  {
    QLog.i("ArCardSelectMemberActivity", 2, "onSendARRelationShip!");
    int i;
    Intent localIntent;
    if (paramInt == 0)
    {
      if (TextUtils.isEmpty(ArCardSelectMemberActivity.a(this.a))) {
        return;
      }
      if (TextUtils.isEmpty(ArCardSelectMemberActivity.b(this.a))) {
        if (!TextUtils.isEmpty(ArCardSelectMemberActivity.c(this.a)))
        {
          i = 2;
          ReportController.b(null, "dc00898", "", "", "0X8008F21", "0X8008F21", i, 0, ArCardSelectMemberActivity.d(this.a), "", "", "");
          localIntent = new Intent(this.a, SplashActivity.class);
          localIntent.putExtra("tab_index", MainFragment.a);
          localIntent.putExtra("fragment_id", 1);
          localIntent.putExtra("key_gesture_from_jumpactivity", false);
          localIntent.setFlags(335544320);
          this.a.startActivity(localIntent);
          localIntent = new Intent(this.a, QQBrowserActivity.class);
          localIntent.putExtra("url", ArCardSelectMemberActivity.a(this.a));
          this.a.startActivity(localIntent);
          this.a.t();
        }
      }
    }
    for (;;)
    {
      super.a(paramInt, paramRspBody);
      return;
      i = 1;
      break;
      if (ArCardSelectMemberActivity.a(this.a) == 2) {}
      for (i = 2;; i = 1)
      {
        ReportController.b(null, "dc00898", "", "", "0X8008F1D", "0X8008F1D", i, 0, "", "", "", "");
        localIntent = new Intent(this.a, SplashActivity.class);
        localIntent.putExtra("tab_index", MainFragment.a);
        localIntent.putExtra("fragment_id", 1);
        localIntent.putExtra("key_gesture_from_jumpactivity", false);
        localIntent.setFlags(335544320);
        this.a.startActivity(localIntent);
        break;
      }
      if (paramInt == -1)
      {
        QQToast.a(BaseApplicationImpl.getContext(), 1, "发送贺卡超时", 0).a();
        this.a.t();
      }
      else
      {
        this.a.t();
        switch (paramInt)
        {
        default: 
          QQToast.a(BaseApplicationImpl.getContext(), 1, "发送贺卡失败", 0).a();
          break;
        case 16: 
          QQToast.a(BaseApplicationImpl.getContext(), 1, "发送贺卡失败", 0).a();
          break;
        case 17: 
          QQToast.a(BaseApplicationImpl.getContext(), 1, "发送贺卡失败", 0).a();
          break;
        case 18: 
          QQToast.a(BaseApplicationImpl.getContext(), 1, "发送贺卡次数已达到上限", 0).a();
          break;
        case 19: 
          QQToast.a(BaseApplicationImpl.getContext(), 1, "发送贺卡次数已达到上限", 0).a();
          break;
        case 20: 
          QQToast.a(BaseApplicationImpl.getContext(), 1, "发送贺卡失败", 0).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aagm
 * JD-Core Version:    0.7.0.1
 */