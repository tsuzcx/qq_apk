import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneShareManager;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;

public class adys
  implements View.OnClickListener
{
  public adys(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.a.getIntent();
    Object localObject2 = ((Intent)localObject1).getStringExtra("key_forward_business_id");
    if (this.a.jdField_a_of_type_Aupt.f())
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      boolean bool = ((Intent)localObject1).hasExtra("file_send_path");
      adza.a(this.a.app, this.a, (Intent)localObject1, (String)localObject2, bool);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Aupt.a().putString("uin", "-1010");
      this.a.jdField_a_of_type_Aupt.D();
      bdla.b(this.a.app, "CliOper", "", "", "friendchoose", "0X800A2D7", ForwardRecentActivity.a(this.a), 0, "", "", "", ForwardRecentActivity.a(this.a));
      localObject1 = new Bundle();
      ((Bundle)localObject1).putLong("key_receiver_type", 3L);
      if (!"caller_aecamera".equals(this.a.c)) {
        break;
      }
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_send_to_info", (Bundle)localObject1, null);
      break;
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
      QZoneShareManager.jumpToQzoneShare(this.a.app, this.a, localBundle, null);
      localObject1 = new QZoneClickReport.ReportInfo();
      ((QZoneClickReport.ReportInfo)localObject1).actionType = "1";
      ((QZoneClickReport.ReportInfo)localObject1).subactionType = "0";
      ((QZoneClickReport.ReportInfo)localObject1).tabletype = 4;
      ((QZoneClickReport.ReportInfo)localObject1).sourceType = "5";
      ((QZoneClickReport.ReportInfo)localObject1).sourceFrom = "thirdApp";
      ((QZoneClickReport.ReportInfo)localObject1).sourceTo = "activefeed";
      QZoneClickReport.startReportImediately(this.a.app.getAccount(), (QZoneClickReport.ReportInfo)localObject1);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("source_type", "5");
      ((HashMap)localObject1).put("source_from", "thirdApp");
      ((HashMap)localObject1).put("source_to", "activefeed");
      StatisticCollector.getInstance(this.a.getApplicationContext()).collectPerformance(this.a.app.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject1, null);
      if (this.a.jdField_a_of_type_Boolean)
      {
        bjgx.a().a(this.a.app.getAccount(), "", this.a.b, "1000", "33", "0", false, this.a.jdField_a_of_type_Boolean);
        if ((this.a.jdField_a_of_type_Aupt instanceof ForwardSdkBaseOption))
        {
          localObject1 = (ForwardSdkBaseOption)this.a.jdField_a_of_type_Aupt;
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("report_type", "102");
          ((Bundle)localObject2).putString("act_type", "81");
          ((Bundle)localObject2).putString("intext_1", "" + bjhd.a(((ForwardSdkBaseOption)localObject1).e));
          ((Bundle)localObject2).putString("intext_2", "" + bjhd.a(-1, AppConstants.QZONE_UIN));
          ((Bundle)localObject2).putString("intext_3", "0");
          bjgx.a().a((Bundle)localObject2, "", this.a.app.getCurrentAccountUin(), false, this.a.jdField_a_of_type_Boolean);
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
 * Qualified Name:     adys
 * JD-Core Version:    0.7.0.1
 */