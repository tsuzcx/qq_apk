import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedTouchHandler;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager.NotifyReceiver;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager.ReadInJoyPublicAccountObserver;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.readinjoy.storage.ReadInJoyFeedsMsgRecord;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class aacl
  implements Runnable
{
  public aacl(ReadInJoyManager.NotifyReceiver paramNotifyReceiver, Intent paramIntent) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyManager.a, 2, String.format("receive %s", new Object[] { this.jdField_a_of_type_AndroidContentIntent.getAction() }));
    }
    long l1;
    if (this.jdField_a_of_type_AndroidContentIntent.getAction().equalsIgnoreCase("notify_main_feeds_msg_newfeeds_read"))
    {
      if (ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a) == null) {
        return;
      }
      l1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getLong("config_feeds_newfeeds_leba_max_id", 0L);
      localObject1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).edit();
      ((SharedPreferences.Editor)localObject1).putLong("config_feeds_newfeeds_leba_read_id", l1);
      ReadInJoyHelper.a((SharedPreferences.Editor)localObject1, true);
      ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a);
    }
    label232:
    Object localObject2;
    label292:
    int i;
    int j;
    label1075:
    do
    {
      do
      {
        for (;;)
        {
          localObject1 = new Intent("notify_main_feeds_msg_response");
          BaseApplication.getContext().sendBroadcast((Intent)localObject1);
          return;
          if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_feeds_msg_newcomment_read"))
          {
            l1 = this.jdField_a_of_type_AndroidContentIntent.getExtras().getLong("read_id");
            if (ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a) == null) {
              break;
            }
            long l2 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getLong("config_feeds_newcomment_leba_max_id", 0L);
            long l3 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getLong("config_feeds_newcomment_leba_read_id", 0L);
            if (l1 >= l3) {
              if (l2 <= l1) {
                break label292;
              }
            }
            for (;;)
            {
              localObject1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).edit();
              ((SharedPreferences.Editor)localObject1).putLong("config_feeds_newcomment_leba_read_id", l1);
              ReadInJoyHelper.a((SharedPreferences.Editor)localObject1, true);
              ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a);
              break;
              l1 = l3;
              break label232;
              l1 = l2;
            }
          }
          if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_feeds_msg_publish_fail"))
          {
            localObject1 = new ReadInJoyFeedsMsgRecord();
            ((ReadInJoyFeedsMsgRecord)localObject1).c = 999999;
            ((ReadInJoyFeedsMsgRecord)localObject1).a = this.jdField_a_of_type_AndroidContentIntent.getExtras().getLong("feed_owner");
            ((ReadInJoyFeedsMsgRecord)localObject1).d = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("fail_reason");
            localObject2 = new ArrayList();
            ((List)localObject2).add(localObject1);
            this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a.a((List)localObject2);
          }
          else
          {
            if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_feeds_msg_republish"))
            {
              if (ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a) == null) {
                break;
              }
              l1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getLong("config_feeds_publishfail_leba_max_id", 0L);
              localObject1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).edit();
              ((SharedPreferences.Editor)localObject1).putLong("config_feeds_publishfail_leba_read_id", l1);
              ReadInJoyHelper.a((SharedPreferences.Editor)localObject1, true);
              ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a);
              continue;
            }
            if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_new_channel_clear"))
            {
              if (ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a) == null) {
                break;
              }
              localObject1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).edit();
              ((SharedPreferences.Editor)localObject1).putInt("config_new_channel_notify_flag", -1);
              ReadInJoyHelper.a((SharedPreferences.Editor)localObject1, true);
              ReadInJoyManager.b(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a);
              continue;
            }
            if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_guide_clear"))
            {
              if (ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a) == null) {
                break;
              }
              localObject1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).edit();
              ((SharedPreferences.Editor)localObject1).putInt("config_notify_guide_flag", -1);
              ((SharedPreferences.Editor)localObject1).putLong("config_notify_guide_updated_time", NetConnInfoCenter.getServerTime());
              ((SharedPreferences.Editor)localObject1).putInt("readinjoy_push_channel_article_flag", -1);
              ((SharedPreferences.Editor)localObject1).putLong("readinjoy_push_channel_article_updated_time", NetConnInfoCenter.getServerTime());
              ReadInJoyHelper.a((SharedPreferences.Editor)localObject1, true);
              ReadInJoyManager.b(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a);
              continue;
            }
            if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("config_local_channel_flag"))
            {
              ConfigServlet.d(ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a), ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getCurrentAccountUin());
            }
            else if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("config_follow_uin"))
            {
              i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("follow_uin_position", -1);
              j = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("follow_uin_smooth_dx", 0);
              localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("follow_uin");
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                PublicAccountUtil.a(ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a), ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getApplication().getApplicationContext(), (String)localObject1, new ReadInJoyManager.ReadInJoyPublicAccountObserver(i, j, (String)localObject1));
              }
            }
            else if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("config_update_app_setting"))
            {
              localObject1 = ReadInJoyHelper.a(ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a));
              if ((localObject1 != null) && (((LebaViewItem)localObject1).jdField_a_of_type_Byte != 0))
              {
                ((LebaViewItem)localObject1).jdField_a_of_type_Byte = 0;
                LebaShowListManager.a().a(ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a), ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId, true, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
                localObject2 = (RedTouchHandler)ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).a(31);
                if (localObject2 != null)
                {
                  ((RedTouchHandler)localObject2).a(String.valueOf(((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId), true, NetConnInfoCenter.getServerTimeMillis());
                  ((RedTouchHandler)localObject2).a(1, true, null);
                }
              }
            }
            else if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("readInJoy_video_play_real_time_report"))
            {
              localObject1 = this.jdField_a_of_type_AndroidContentIntent.getExtras();
              if (localObject1 != null) {
                PublicAccountUtil.b(((Bundle)localObject1).getString("VIDEO_REALTIME_REPORT_AID"), ((Bundle)localObject1).getString("VIDEO_REALTIME_REPORT_VID"), ((Bundle)localObject1).getInt("VIDEO_REALTIME_REPORT_RTYPE"), ((Bundle)localObject1).getInt("VIDEO_REALTIME_REPORT_RCODE"));
              }
            }
            else
            {
              if (!this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_share_friend_video")) {
                break label1075;
              }
              ForwardUtils.a((QQAppInterface)ReadInJoyUtils.a(), null, ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getApp(), this.jdField_a_of_type_AndroidContentIntent, null);
            }
          }
        }
      } while (!this.jdField_a_of_type_AndroidContentIntent.getAction().equals("READINJOY_VIDEO_DATA_REPORT_WITH_FANS_INFO"));
      localObject2 = this.jdField_a_of_type_AndroidContentIntent.getExtras();
    } while (localObject2 == null);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      String str1 = ((Bundle)localObject2).getString("VIDEO_REPORT_TOUIN");
      String str2 = ((Bundle)localObject2).getString("VIDEO_REPORT_SUBACTION");
      i = ((Bundle)localObject2).getInt("VIDEO_REPORT_FROM_TYPE");
      j = ((Bundle)localObject2).getInt("VIDEO_REPORT_RESULT");
      PublicAccountReportUtils.c((QQAppInterface)localObject1, str1, str2, ((Bundle)localObject2).getString("VIDEO_REPORT_ACTION_NAME"), i, j, ((Bundle)localObject2).getString("VIDEO_REPORT_R2"), ((Bundle)localObject2).getString("VIDEO_REPORT_R3"), ((Bundle)localObject2).getString("VIDEO_REPORT_R4"), ((Bundle)localObject2).getString("VIDEO_REPORT_R5"), ((Bundle)localObject2).getBoolean("VIDEO_REPORT_SHOULD_ENCODE"));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aacl
 * JD-Core Version:    0.7.0.1
 */