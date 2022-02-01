import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aacf
  implements View.OnClickListener
{
  public aacf(ServiceFolderFollowPBHeadView paramServiceFolderFollowPBHeadView) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(ServiceFolderFollowPBHeadView.a(this.a))) {
      zqm.a(ServiceFolderFollowPBHeadView.a(this.a));
    }
    for (;;)
    {
      ServiceFolderFollowPBHeadView.a(this.a).setVisibility(8);
      bdla.b(null, "dc00898", "", "", "auth_page", "msg_exp", 0, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.e(ServiceFolderFollowPBHeadView.a(), 2, "jump error mJumpWebMessageListUrl is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacf
 * JD-Core Version:    0.7.0.1
 */