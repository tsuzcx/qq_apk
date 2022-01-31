import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class aijv
  implements View.OnClickListener
{
  public aijv(StructMsgItemVideo paramStructMsgItemVideo) {}
  
  public void onClick(View paramView)
  {
    Context localContext = paramView.getContext();
    if (NetworkUtil.a(localContext) == 1)
    {
      StructMsgItemVideo.a(this.a, localContext, paramView);
      if ((localContext instanceof BaseActivity)) {
        ReportController.b(((BaseActivity)localContext).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
      return;
      if (!NetworkUtil.g(localContext))
      {
        QQToast.a(localContext, 2131433009, 0).a();
      }
      else
      {
        Resources localResources = localContext.getResources();
        DialogUtil.a(localContext, 232, "", "当前是非wifi网络，是否使用移动网络播放视频？", localResources.getString(2131433015), localResources.getString(2131433016), new aijw(this, localContext, paramView), new aijx(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijv
 * JD-Core Version:    0.7.0.1
 */