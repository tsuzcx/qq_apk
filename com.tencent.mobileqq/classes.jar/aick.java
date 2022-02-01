import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aick
  implements View.OnClickListener
{
  aick(aici paramaici) {}
  
  public void onClick(View paramView)
  {
    if (!aici.d(this.a)) {
      if (aici.a(this.a) == null)
      {
        aici.d(this.a);
        QLog.e(this.a.tag, 2, "onClick mExtendFriendUserInfo IS null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((!aici.a(this.a).enableQQCall) && (aici.a(this.a).tagID != 10000))
      {
        aici.d(this.a);
        QLog.e(this.a.tag, 2, "onClick mExtendFriendUserInfo enableQQCall false" + aici.a(this.a).tagID);
      }
      else
      {
        com.tencent.mobileqq.activity.aio.AIOUtils.isUserOperatedInAIO = true;
        aftr.a(this.a.app, this.a.mActivity, this.a.sessionInfo, true, null, null);
        if (aici.a(this.a) != null) {
          if (aici.a(this.a).tagID == 1) {
            bdla.b(this.a.app, "dc00898", "", "", "0X800AD92", "0X800AD92", 1, 0, "", "", "", "");
          } else {
            bdla.b(this.a.app, "dc00898", "", "", "0X800AD92", "0X800AD92", 2, 0, "", "", aici.a(this.a).tagName, "");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aick
 * JD-Core Version:    0.7.0.1
 */