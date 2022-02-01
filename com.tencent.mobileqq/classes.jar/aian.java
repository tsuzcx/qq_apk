import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aian
  implements View.OnClickListener
{
  aian(aiah paramaiah) {}
  
  public void onClick(View paramView)
  {
    aiah.a(this.a);
    if ((aiah.a(this.a) != null) && (!TextUtils.isEmpty(aiah.a(this.a))))
    {
      String str = "big_brother_source_key=biz_src_zf_games&platform=qq_m&current_uin=$OPID$&user_openid=$OPID$&launchfrom=sq_gamecenter&gamedata=&platformdata=";
      QQAppInterface localQQAppInterface = this.a.getApp();
      if ((!TextUtils.isEmpty(aiah.b(this.a))) && (localQQAppInterface != null))
      {
        if (!aiah.b(this.a).startsWith("&")) {
          str = "big_brother_source_key=biz_src_zf_games&platform=qq_m&current_uin=$OPID$&user_openid=$OPID$&launchfrom=sq_gamecenter&gamedata=&platformdata=" + "&";
        }
        str = str + aiah.b(this.a);
        new bcqt().a(localQQAppInterface, this.a.getActivity(), aiah.a(this.a).c, str, aiah.a(this.a), 536870912);
        ((VasExtensionHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(aiah.a(this.a).c, localQQAppInterface.getCurrentAccountUin(), 1);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.e(aiah.b, 1, "gameinfo is null ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aian
 * JD-Core Version:    0.7.0.1
 */