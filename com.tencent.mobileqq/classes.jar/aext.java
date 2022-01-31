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

class aext
  implements View.OnClickListener
{
  aext(aexs paramaexs, int paramInt) {}
  
  public void onClick(View paramView)
  {
    aexs.a(this.jdField_a_of_type_Aexs, 2);
    aexs.a(this.jdField_a_of_type_Aexs).a();
    axqy.b(aexs.a(this.jdField_a_of_type_Aexs), "P_CliOper", "Safe_AntiFraud", aexs.a(this.jdField_a_of_type_Aexs).a, "banner", "userclick", this.jdField_a_of_type_Int, 0, "", "", "", "");
    paramView = (Bundle)bbbz.a().a("SecWarningCfg", "BannerURL", 146, this.jdField_a_of_type_Int);
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
        paramView = paramView.replace("$SYSTEM$", "android").replace("$EVILUIN$", aexs.a(this.jdField_a_of_type_Aexs).a).replace("$USERUIN$", aexs.a(this.jdField_a_of_type_Aexs).getAccount());
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
 * Qualified Name:     aext
 * JD-Core Version:    0.7.0.1
 */