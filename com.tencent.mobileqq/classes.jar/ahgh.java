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

class ahgh
  implements View.OnClickListener
{
  ahgh(ahgg paramahgg, MessageForQzoneFeed paramMessageForQzoneFeed) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl = ahgg.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    Object localObject2 = bkgj.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = (String)((Map)localObject2).get("g");
    }
    if (("110".equals(localObject1)) || ("279".equals(localObject1)) || ("318".equals(localObject1)))
    {
      localObject1 = paramView.getContext();
      blsi localblsi = blsi.a();
      localblsi.a = this.jdField_a_of_type_Ahgg.a.getCurrentAccountUin();
      localblsi.b = this.jdField_a_of_type_Ahgg.a.getCurrentNickname();
      blsb.a((Activity)localObject1, localblsi, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl, "mqqChat.QzoneCard", this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.appId, -1);
      localObject1 = new blrv();
      ((blrv)localObject1).c = "1";
      ((blrv)localObject1).d = "0";
      ((blrv)localObject1).b = 4;
      ((blrv)localObject1).l = "3";
      ((blrv)localObject1).m = "AIO";
      ((blrv)localObject1).n = "detailPage";
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_Ahgg.a.getAccount(), (blrv)localObject1);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("source_type", "3");
      ((HashMap)localObject1).put("source_from", "AIO");
      ((HashMap)localObject1).put("source_to", "detailPage");
      bctj.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_Ahgg.a.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject1, null);
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
      localObject2 = new blrv();
      ((blrv)localObject2).c = "330";
      ((blrv)localObject2).d = "2";
      ((blrv)localObject2).e = ((String)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.isFirstMsgWithNewFriend) {
        ((blrv)localObject2).i = "1";
      }
      ((blrv)localObject2).a = new ArrayList();
      ((blrv)localObject2).a.add(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_Ahgg.a.getAccount(), (blrv)localObject2);
      bcst.b(this.jdField_a_of_type_Ahgg.a, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "2", "", "");
      bcst.b(this.jdField_a_of_type_Ahgg.a, "CliOper", "", "", "0X8006000", "0X8006000", 0, 0, "", "", "", "");
      break;
      this.jdField_a_of_type_Ahgg.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
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
 * Qualified Name:     ahgh
 * JD-Core Version:    0.7.0.1
 */