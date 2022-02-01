import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneClickReport;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;

public class aeoo
  implements View.OnClickListener
{
  public aeoo(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.a.getIntent();
    Object localObject2 = ((Intent)localObject1).getStringExtra("key_forward_business_id");
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      boolean bool = ((Intent)localObject1).hasExtra("file_send_path");
      aeow.a(this.a.app, this.a, (Intent)localObject1, (String)localObject2, bool);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Auxu.a().putString("uin", "-1010");
      this.a.jdField_a_of_type_Auxu.D();
      bdll.b(this.a.app, "CliOper", "", "", "friendchoose", "0X800A2D7", ForwardRecentActivity.a(this.a), 0, "", "", "", ForwardRecentActivity.a(this.a));
      localObject1 = new Bundle();
      ((Bundle)localObject1).putLong("key_receiver_type", 3L);
      if ("caller_aecamera".equals(this.a.c)) {
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_send_to_info", (Bundle)localObject1, null);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int j = ((Intent)localObject1).getIntExtra("req_type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardEntranceActivity", 2, "-->addQZoneEntry--onClick--req_type = " + j);
      }
      Bundle localBundle = ((Intent)localObject1).getExtras();
      localObject2 = localBundle.getString("image_url_remote");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localBundle.getString("image_url");
      }
      localObject2 = new ArrayList();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split(";");
        int i = 0;
        while (i < localObject1.length)
        {
          ((ArrayList)localObject2).add(URLDecoder.decode(localObject1[i]));
          i += 1;
        }
      }
      localBundle.putStringArrayList("image_url", (ArrayList)localObject2);
      localBundle.putString("share_action", "shareToQQ");
      localBundle.putString("jfrom", "login");
      localBundle.putBoolean("thirdPartShare", true);
      com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.f = true;
      bmud.a(this.a.app, this.a, localBundle, null);
      localObject1 = new bmsx();
      ((bmsx)localObject1).c = "1";
      ((bmsx)localObject1).d = "0";
      ((bmsx)localObject1).b = 4;
      ((bmsx)localObject1).l = "5";
      ((bmsx)localObject1).m = "thirdApp";
      ((bmsx)localObject1).n = "activefeed";
      QZoneClickReport.startReportImediately(this.a.app.getAccount(), (bmsx)localObject1);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("source_type", "5");
      ((HashMap)localObject1).put("source_from", "thirdApp");
      ((HashMap)localObject1).put("source_to", "activefeed");
      bdmc.a(this.a.getApplicationContext()).a(this.a.app.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject1, null);
      if (this.a.jdField_a_of_type_Boolean)
      {
        bjqh.a().a(this.a.app.getAccount(), "", this.a.b, "1000", "33", "0", false);
        if ((this.a.jdField_a_of_type_Auxu instanceof ForwardSdkBaseOption))
        {
          localObject1 = (ForwardSdkBaseOption)this.a.jdField_a_of_type_Auxu;
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("report_type", "102");
          ((Bundle)localObject2).putString("act_type", "81");
          ((Bundle)localObject2).putString("intext_1", "" + bjqn.a(((ForwardSdkBaseOption)localObject1).e));
          ((Bundle)localObject2).putString("intext_2", "" + bjqn.a(-1, antf.aG));
          ((Bundle)localObject2).putString("intext_3", "0");
          bjqh.a().a((Bundle)localObject2, "", this.a.app.getCurrentAccountUin(), false);
        }
      }
      if ((!this.a.jdField_a_of_type_Boolean) || (j != 5)) {
        this.a.finish();
      } else {
        ForwardRecentActivity.i(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aeoo
 * JD-Core Version:    0.7.0.1
 */