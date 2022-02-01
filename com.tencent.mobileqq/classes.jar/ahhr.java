import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahhr
  implements View.OnClickListener
{
  ahhr(ahhp paramahhp) {}
  
  public void onClick(View paramView)
  {
    if (!ahhp.d(this.a)) {
      if (ahhp.a(this.a) == null)
      {
        ahhp.d(this.a);
        QLog.e(this.a.tag, 2, "onClick mExtendFriendUserInfo IS null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((!ahhp.a(this.a).enableQQCall) && (ahhp.a(this.a).tagID != 10000))
      {
        ahhp.d(this.a);
        QLog.e(this.a.tag, 2, "onClick mExtendFriendUserInfo enableQQCall false" + ahhp.a(this.a).tagID);
      }
      else
      {
        com.tencent.mobileqq.activity.aio.AIOUtils.isUserOperatedInAIO = true;
        afcm.a(this.a.app, this.a.mActivity, this.a.sessionInfo, true, null, null);
        if (ahhp.a(this.a) != null) {
          if (ahhp.a(this.a).tagID == 1) {
            bcef.b(this.a.app, "dc00898", "", "", "0X800AD92", "0X800AD92", 1, 0, "", "", "", "");
          } else {
            bcef.b(this.a.app, "dc00898", "", "", "0X800AD92", "0X800AD92", 2, 0, "", "", ahhp.a(this.a).tagName, "");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhr
 * JD-Core Version:    0.7.0.1
 */