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

class aguy
  implements View.OnClickListener
{
  aguy(agux paramagux, int paramInt) {}
  
  public void onClick(View paramView)
  {
    agux.a(this.jdField_a_of_type_Agux, 2);
    agux.a(this.jdField_a_of_type_Agux).a();
    azmj.b(agux.a(this.jdField_a_of_type_Agux), "P_CliOper", "Safe_AntiFraud", agux.a(this.jdField_a_of_type_Agux).a, "banner", "userclick", this.jdField_a_of_type_Int, 0, "", "", "", "");
    paramView = (Bundle)bdat.a().a("SecWarningCfg", "BannerURL", 146, this.jdField_a_of_type_Int);
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
        paramView = paramView.replace("$SYSTEM$", "android").replace("$EVILUIN$", agux.a(this.jdField_a_of_type_Agux).a).replace("$USERUIN$", agux.a(this.jdField_a_of_type_Agux).getAccount());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aguy
 * JD-Core Version:    0.7.0.1
 */