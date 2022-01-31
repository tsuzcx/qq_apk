import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class aexv
  implements View.OnClickListener
{
  aexv(aexu paramaexu, int paramInt) {}
  
  public void onClick(View paramView)
  {
    aexu.a(this.jdField_a_of_type_Aexu, 2);
    aexu.a(this.jdField_a_of_type_Aexu).a();
    axqw.b(aexu.a(this.jdField_a_of_type_Aexu), "P_CliOper", "Safe_AntiFraud", aexu.a(this.jdField_a_of_type_Aexu).a, "banner", "userclick", this.jdField_a_of_type_Int, 0, "", "", "", "");
    paramView = (Bundle)bbbl.a().a("SecWarningCfg", "BannerURL", 146, this.jdField_a_of_type_Int);
    if (paramView != null) {}
    for (paramView = paramView.getString("BannerURL");; paramView = null)
    {
      Object localObject = paramView;
      if (TextUtils.isEmpty(paramView)) {
        localObject = "https://jubao.qq.com/cn/jubao?appname=KQQ&subapp=$SUBAPP$&jubaotype=uin&system=$SYSTEM$&eviluin=$EVILUIN$&impeachuin=$USERUIN$";
      }
      if (this.jdField_a_of_type_Int == 1) {}
      for (paramView = ((String)localObject).replace("$SUBAPP$", "notice");; paramView = ((String)localObject).replace("$SUBAPP$", "tips"))
      {
        paramView = paramView.replace("$SYSTEM$", "android").replace("$EVILUIN$", aexu.a(this.jdField_a_of_type_Aexu).a).replace("$USERUIN$", aexu.a(this.jdField_a_of_type_Aexu).getAccount());
        localObject = BaseActivity.sTopActivity;
        Intent localIntent = new Intent((Context)localObject, QQBrowserDelegationActivity.class);
        localIntent.putExtra("injectrecommend", true);
        localIntent.putExtra("url", paramView);
        ((Context)localObject).startActivity(localIntent);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexv
 * JD-Core Version:    0.7.0.1
 */