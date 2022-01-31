import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.ar.ARRelationShipAIOMsg;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ARRelationShip;
import com.tencent.mobileqq.arcard.ARCardShareHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import mqq.app.MobileQQ;

class aamh
  implements Runnable
{
  aamh(aamg paramaamg) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_Aamf.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.setClass(this.a.jdField_a_of_type_Aamf.a.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
    localIntent.putExtra("pluginName", "web_share");
    Object localObject = this.a.jdField_a_of_type_Aamf.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.mARRelationShipAIOMsg.b;
    if (!((String)localObject).isEmpty()) {
      localIntent.putExtra("struct_share_key_source_icon", (String)localObject);
    }
    localIntent.putExtra("app_name", this.a.jdField_a_of_type_Aamf.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.mARRelationShipAIOMsg.a);
    String str2 = this.a.jdField_a_of_type_Aamf.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.mARRelationShipAIOMsg.c;
    localIntent.putExtra("struct_share_key_source_action", str2);
    String str1 = this.a.jdField_a_of_type_Aamf.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.mARRelationShipAIOMsg.e;
    localObject = str1;
    if (str2.compareTo("web") == 0)
    {
      localObject = str1;
      if (str1.isEmpty()) {
        localObject = ARCardShareHelper.a(this.a.jdField_a_of_type_Aamf.a, this.a.jdField_a_of_type_Int);
      }
    }
    localIntent.putExtra("struct_share_key_source_url", (String)localObject);
    localObject = this.a.jdField_a_of_type_Aamf.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.mARRelationShipAIOMsg.d;
    if (!((String)localObject).isEmpty()) {
      localIntent.putExtra("struct_share_key_source_action_data", (String)localObject);
    }
    localIntent.putExtra("detail_url", ARCardShareHelper.a(this.a.jdField_a_of_type_Aamf.a, this.a.jdField_a_of_type_Int));
    localIntent.putExtra("title", ARCardShareHelper.a(this.a.jdField_a_of_type_Aamf.a));
    localIntent.putExtra("desc", this.a.jdField_a_of_type_Aamf.a.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.i);
    localIntent.putExtra("struct_share_key_content_action", "web");
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("image_url_remote", this.a.jdField_a_of_type_Aamf.a.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.k);
    localIntent.putExtra("new_share_service_id", "83");
    localIntent.putExtra("shareQQType", 13);
    localIntent.putExtra("flag", 0);
    localIntent.putExtra("req_share_id", 0);
    localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getProcessName());
    localIntent.putExtra("k_back", true);
    localIntent.putExtra("brief_key", "[分享]" + ARCardShareHelper.a(this.a.jdField_a_of_type_Aamf.a));
    localObject = StructMsgFactory.a(localIntent.getExtras());
    ((AbsStructMsg)localObject).mMsgServiceID = 83;
    localIntent.putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject).getBytes());
    if (this.a.jdField_a_of_type_Aamf.a.jdField_a_of_type_Boolean) {
      ReportController.b(null, "dc00898", "", "", "0X8008F1B", "0X8008F1B", 1, 0, "", "", "", "");
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Aamf.a.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 21);
      return;
      ReportController.b(null, "dc00898", "", "", "0X8008F27", "0X8008F27", 1, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamh
 * JD-Core Version:    0.7.0.1
 */