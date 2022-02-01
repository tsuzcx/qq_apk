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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ailh
  implements View.OnClickListener
{
  ailh(ailg paramailg, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ailg.a(this.jdField_a_of_type_Ailg, 2);
    ailg.a(this.jdField_a_of_type_Ailg).a();
    bcst.b(ailg.a(this.jdField_a_of_type_Ailg), "P_CliOper", "Safe_AntiFraud", ailg.a(this.jdField_a_of_type_Ailg).a, "banner", "userclick", this.jdField_a_of_type_Int, 0, "", "", "", "");
    Object localObject1 = (Bundle)bgke.a().a("SecWarningCfg", "BannerURL", 146, this.jdField_a_of_type_Int);
    if (localObject1 != null) {}
    for (localObject1 = ((Bundle)localObject1).getString("BannerURL");; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "https://jubao.qq.com/cn/jubao?appname=KQQ&subapp=$SUBAPP$&jubaotype=uin&system=$SYSTEM$&eviluin=$EVILUIN$&impeachuin=$USERUIN$";
      }
      if (this.jdField_a_of_type_Int == 1) {}
      for (localObject1 = ((String)localObject2).replace("$SUBAPP$", "notice");; localObject1 = ((String)localObject2).replace("$SUBAPP$", "tips"))
      {
        localObject1 = ((String)localObject1).replace("$SYSTEM$", "android").replace("$EVILUIN$", ailg.a(this.jdField_a_of_type_Ailg).a).replace("$USERUIN$", ailg.a(this.jdField_a_of_type_Ailg).getAccount());
        localObject2 = BaseActivity.sTopActivity;
        Intent localIntent = new Intent((Context)localObject2, QQBrowserDelegationActivity.class);
        localIntent.putExtra("injectrecommend", true);
        localIntent.putExtra("url", (String)localObject1);
        ((Context)localObject2).startActivity(localIntent);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailh
 * JD-Core Version:    0.7.0.1
 */