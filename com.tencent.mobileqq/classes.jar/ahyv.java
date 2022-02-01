import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahyv
  implements View.OnClickListener
{
  ahyv(ahyl paramahyl) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    Object localObject1 = paramView.getTag();
    if ((localObject1 == null) || (!(localObject1 instanceof Integer))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject2 = this.a.sessionInfo.curFriendUin;
      switch (((Integer)localObject1).intValue())
      {
      default: 
        break;
      case 1: 
        ChatActivityUtils.a(this.a.app, this.a.mActivity, this.a.sessionInfo.curType, (String)localObject2, this.a.sessionInfo.phoneNum, true);
        break;
      case 2: 
        ChatActivityUtils.a(this.a.app, this.a.mActivity, this.a.sessionInfo.curType, (String)localObject2, this.a.sessionInfo.phoneNum, false);
        break;
      case 3: 
        if (this.a.b.f(this.a.sessionInfo.curFriendUin))
        {
          localObject1 = this.a.mActivity;
          localObject2 = this.a.sessionInfo;
          String str = this.a.app.getApp().getString(2131690676);
          if (this.a.mActivity.getIntent().getStringExtra("param_return_addr") != null) {}
          for (;;)
          {
            ChatActivityUtils.a((Activity)localObject1, (SessionInfo)localObject2, str, bool);
            break;
            bool = false;
          }
        }
        this.a.f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyv
 * JD-Core Version:    0.7.0.1
 */