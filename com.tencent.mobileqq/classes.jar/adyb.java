import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class adyb
  implements View.OnClickListener
{
  adyb(adya paramadya, MessageForQzoneFeed paramMessageForQzoneFeed) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl = adya.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl)) {
      return;
    }
    Map localMap = bfnx.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
    Object localObject = null;
    if (localMap != null) {
      localObject = (String)localMap.get("g");
    }
    if (("110".equals(localObject)) || ("279".equals(localObject)) || ("318".equals(localObject)))
    {
      paramView = paramView.getContext();
      localObject = bgyw.a();
      ((bgyw)localObject).a = this.jdField_a_of_type_Adya.a.getCurrentAccountUin();
      ((bgyw)localObject).b = this.jdField_a_of_type_Adya.a.getCurrentNickname();
      bgyp.a((Activity)paramView, (bgyw)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl, "mqqChat.QzoneCard", this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.appId, -1);
      paramView = new bgyj();
      paramView.c = "1";
      paramView.d = "0";
      paramView.b = 4;
      paramView.l = "3";
      paramView.m = "AIO";
      paramView.n = "detailPage";
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_Adya.a.getAccount(), paramView);
      paramView = new HashMap();
      paramView.put("source_type", "3");
      paramView.put("source_from", "AIO");
      paramView.put("source_to", "detailPage");
      axrn.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_Adya.a.getAccount(), "actQZSourceDataReport", true, 0L, 0L, paramView, null);
      paramView = null;
      if (localMap != null) {
        paramView = (String)localMap.get("a");
      }
      if (paramView != null)
      {
        if (!paramView.equals("4")) {
          break label461;
        }
        paramView = "1";
      }
    }
    for (;;)
    {
      localObject = new bgyj();
      ((bgyj)localObject).c = "330";
      ((bgyj)localObject).d = "2";
      ((bgyj)localObject).e = paramView;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.isFirstMsgWithNewFriend) {
        ((bgyj)localObject).i = "1";
      }
      ((bgyj)localObject).a = new ArrayList();
      ((bgyj)localObject).a.add(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_Adya.a.getAccount(), (bgyj)localObject);
      axqy.b(this.jdField_a_of_type_Adya.a, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "2", "", "");
      axqy.b(this.jdField_a_of_type_Adya.a, "CliOper", "", "", "0X8006000", "0X8006000", 0, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_Adya.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
      break;
      label461:
      if (paramView.equals("311")) {
        paramView = "2";
      } else if (paramView.equals("2")) {
        paramView = "3";
      } else {
        paramView = "4";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adyb
 * JD-Core Version:    0.7.0.1
 */