import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ahpt
  implements View.OnClickListener
{
  ahpt(ahps paramahps, MessageForQzoneFeed paramMessageForQzoneFeed) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl = ahps.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    Object localObject2 = blhn.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = (String)((Map)localObject2).get("g");
    }
    if (("110".equals(localObject1)) || ("279".equals(localObject1)) || ("318".equals(localObject1)))
    {
      localObject1 = paramView.getContext();
      bmtk localbmtk = bmtk.a();
      localbmtk.a = this.jdField_a_of_type_Ahps.a.getCurrentAccountUin();
      localbmtk.b = this.jdField_a_of_type_Ahps.a.getCurrentNickname();
      bmtd.a((Activity)localObject1, localbmtk, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl, "mqqChat.QzoneCard", this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.appId, -1);
      localObject1 = new bmsx();
      ((bmsx)localObject1).c = "1";
      ((bmsx)localObject1).d = "0";
      ((bmsx)localObject1).b = 4;
      ((bmsx)localObject1).l = "3";
      ((bmsx)localObject1).m = "AIO";
      ((bmsx)localObject1).n = "detailPage";
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_Ahps.a.getAccount(), (bmsx)localObject1);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("source_type", "3");
      ((HashMap)localObject1).put("source_from", "AIO");
      ((HashMap)localObject1).put("source_to", "detailPage");
      bdmc.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_Ahps.a.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject1, null);
      label278:
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = (String)((Map)localObject2).get("a");
      }
      if (localObject1 != null)
      {
        if (!((String)localObject1).equals("4")) {
          break label474;
        }
        localObject1 = "1";
      }
    }
    for (;;)
    {
      localObject2 = new bmsx();
      ((bmsx)localObject2).c = "330";
      ((bmsx)localObject2).d = "2";
      ((bmsx)localObject2).e = ((String)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.isFirstMsgWithNewFriend) {
        ((bmsx)localObject2).i = "1";
      }
      ((bmsx)localObject2).a = new ArrayList();
      ((bmsx)localObject2).a.add(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_Ahps.a.getAccount(), (bmsx)localObject2);
      bdll.b(this.jdField_a_of_type_Ahps.a, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "2", "", "");
      bdll.b(this.jdField_a_of_type_Ahps.a, "CliOper", "", "", "0X8006000", "0X8006000", 0, 0, "", "", "", "");
      break;
      this.jdField_a_of_type_Ahps.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
      break label278;
      label474:
      if (((String)localObject1).equals("311")) {
        localObject1 = "2";
      } else if (((String)localObject1).equals("2")) {
        localObject1 = "3";
      } else {
        localObject1 = "4";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpt
 * JD-Core Version:    0.7.0.1
 */