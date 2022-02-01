import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahfv
  implements View.OnClickListener
{
  ahfv(ahfp paramahfp) {}
  
  public void onClick(View paramView)
  {
    ahfp.a(this.a);
    if ((ahfp.a(this.a) != null) && (!TextUtils.isEmpty(ahfp.a(this.a))))
    {
      String str = "big_brother_source_key=biz_src_zf_games&platform=qq_m&current_uin=$OPID$&user_openid=$OPID$&launchfrom=sq_gamecenter&gamedata=&platformdata=";
      QQAppInterface localQQAppInterface = this.a.getApp();
      if ((!TextUtils.isEmpty(ahfp.b(this.a))) && (localQQAppInterface != null))
      {
        if (!ahfp.b(this.a).startsWith("&")) {
          str = "big_brother_source_key=biz_src_zf_games&platform=qq_m&current_uin=$OPID$&user_openid=$OPID$&launchfrom=sq_gamecenter&gamedata=&platformdata=" + "&";
        }
        str = str + ahfp.b(this.a);
        new bbkb().a(localQQAppInterface, this.a.getActivity(), ahfp.a(this.a).c, str, ahfp.a(this.a), 536870912);
        ((VasExtensionHandler)localQQAppInterface.getBusinessHandler(71)).a(ahfp.a(this.a).c, localQQAppInterface.getCurrentAccountUin(), 1);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.e(ahfp.b, 1, "gameinfo is null ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfv
 * JD-Core Version:    0.7.0.1
 */