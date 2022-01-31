import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;

public class aasr
  implements View.OnClickListener
{
  public aasr(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.getIntent();
    Object localObject = paramView.getStringExtra("key_forward_business_id");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      boolean bool = paramView.hasExtra("file_send_path");
      aasz.a(this.a.app, this.a, paramView, (String)localObject, bool);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Aphp.a().putString("uin", "-1010");
      this.a.jdField_a_of_type_Aphp.B();
      awqx.b(this.a.app, "CliOper", "", "", "friendchoose", "0X800A2D7", ForwardRecentActivity.a(this.a), 0, "", "", "", ForwardRecentActivity.a(this.a));
      paramView = new Bundle();
      paramView.putLong("key_receiver_type", 3L);
      if ("caller_aecamera".equals(this.a.c)) {
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_send_to_info", paramView, null);
      }
      return;
      int j = paramView.getIntExtra("req_type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardEntranceActivity", 2, "-->addQZoneEntry--onClick--req_type = " + j);
      }
      Bundle localBundle = paramView.getExtras();
      localObject = localBundle.getString("image_url_remote");
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = localBundle.getString("image_url");
      }
      localObject = new ArrayList();
      if (!TextUtils.isEmpty(paramView))
      {
        paramView = paramView.split(";");
        int i = 0;
        while (i < paramView.length)
        {
          ((ArrayList)localObject).add(URLDecoder.decode(paramView[i]));
          i += 1;
        }
      }
      localBundle.putStringArrayList("image_url", (ArrayList)localObject);
      localBundle.putString("share_action", "shareToQQ");
      localBundle.putString("jfrom", "login");
      localBundle.putBoolean("thirdPartShare", true);
      com.tencent.mobileqq.app.PhoneContactManagerImp.f = true;
      bfqn.a(this.a.app, this.a, localBundle, null);
      paramView = new bfpl();
      paramView.c = "1";
      paramView.d = "0";
      paramView.b = 4;
      paramView.l = "5";
      paramView.m = "thirdApp";
      paramView.n = "activefeed";
      QZoneClickReport.startReportImediately(this.a.app.getAccount(), paramView);
      paramView = new HashMap();
      paramView.put("source_type", "5");
      paramView.put("source_from", "thirdApp");
      paramView.put("source_to", "activefeed");
      awrn.a(this.a.getApplicationContext()).a(this.a.app.getAccount(), "actQZSourceDataReport", true, 0L, 0L, paramView, null);
      if (this.a.jdField_a_of_type_Boolean)
      {
        bcad.a().a(this.a.app.getAccount(), "", this.a.b, "1000", "33", "0", false);
        if ((this.a.jdField_a_of_type_Aphp instanceof apld))
        {
          paramView = (apld)this.a.jdField_a_of_type_Aphp;
          localObject = new Bundle();
          ((Bundle)localObject).putString("report_type", "102");
          ((Bundle)localObject).putString("act_type", "81");
          ((Bundle)localObject).putString("intext_1", "" + bcaj.a(paramView.c));
          ((Bundle)localObject).putString("intext_2", "" + bcaj.a(-1, ajed.aF));
          ((Bundle)localObject).putString("intext_3", "0");
          bcad.a().a((Bundle)localObject, "", this.a.app.getCurrentAccountUin(), false);
        }
      }
      if ((!this.a.jdField_a_of_type_Boolean) || (j != 5)) {
        this.a.finish();
      } else {
        ForwardRecentActivity.h(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aasr
 * JD-Core Version:    0.7.0.1
 */