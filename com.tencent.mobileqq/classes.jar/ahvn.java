import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.util.PAReportUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAVideo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ahvn
  implements View.OnClickListener
{
  public ahvn(StructMsgItemPAVideo paramStructMsgItemPAVideo) {}
  
  public void onClick(View paramView)
  {
    Context localContext = paramView.getContext();
    Bundle localBundle = new Bundle();
    localBundle.putString("file_send_path", StructMsgItemPAVideo.a(this.a));
    localBundle.putInt("video_play_caller", 2);
    localBundle.putLong("message_click_start", System.currentTimeMillis());
    Object localObject2 = "";
    Object localObject1 = null;
    try
    {
      ChatMessage localChatMessage = AIOUtils.a(paramView);
      localObject1 = localChatMessage;
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        continue;
        paramView = "";
      }
    }
    if (localObject1 != null) {
      localObject2 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick");
    }
    localBundle.putString("ad_gdt", (String)localObject2);
    localObject1 = this.a.a(paramView);
    if (localObject1 == null) {
      if (QLog.isColorLevel()) {
        QLog.d("structmsg.StructMsgItemVideoForPA", 2, "StructMsgForGeneralShare == NULL");
      }
    }
    do
    {
      return;
      localBundle.putString("msg_id", String.valueOf(((StructMsgForGeneralShare)localObject1).msgId));
      paramView = "";
      if ((StructMsgItemPAVideo.b(this.a) == null) || (StructMsgItemPAVideo.b(this.a).equals(""))) {
        break label500;
      }
      localBundle.putString("struct_msg_video_info", StructMsgItemPAVideo.b(this.a));
      localBundle.putString("from_uin", ((StructMsgForGeneralShare)localObject1).currentAccountUin);
      localBundle.putInt("from_uin_type", 1008);
      localBundle.putString("from_session_uin", ((StructMsgForGeneralShare)localObject1).uin);
      try
      {
        localObject2 = new JSONObject(StructMsgItemPAVideo.b(this.a));
        if (localObject2 != null) {
          paramView = ((JSONObject)localObject2).getString("file_uuid");
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramView = "";
        }
      }
      localObject2 = new Intent(localContext, ShortVideoPlayActivity.class);
      ((Intent)localObject2).putExtras(localBundle);
      localContext.startActivity((Intent)localObject2);
      localObject2 = ((FragmentActivity)localContext).getChatFragment().a();
      ReportController.b((QQAppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", "", "0X8005C9A", "0X8005C9A", 0, 1, 0, ((StructMsgForGeneralShare)localObject1).uin, ((StructMsgForGeneralShare)localObject1).currentAccountUin, StructMsgItemPAVideo.a(this.a), paramView);
    } while ((((StructMsgForGeneralShare)localObject1).message == null) || (!"1".equals(((StructMsgForGeneralShare)localObject1).message.getExtInfoFromExtStr("is_AdArrive_Msg"))));
    try
    {
      paramView = new JSONObject();
      paramView.put("puin", ((StructMsgForGeneralShare)localObject1).message.frienduin);
      paramView.put("type", this.a.l);
      paramView.put("index", this.a.j);
      paramView.put("name", this.a.k);
      paramView.put("net", String.valueOf(HttpUtil.a()));
      paramView.put("mobile_imei", DeviceInfoUtil.a());
      paramView.put("obj", "");
      paramView.put("gdt_cli_data", ((StructMsgForGeneralShare)localObject1).message.getExtInfoFromExtStr("gdt_msgClick"));
      paramView.put("view_id", ((StructMsgForGeneralShare)localObject1).message.getExtInfoFromExtStr("gdt_view_id"));
      PAReportUtil.a((AppInterface)localObject2, ((StructMsgForGeneralShare)localObject1).message.selfuin, paramView.toString(), "" + ((StructMsgForGeneralShare)localObject1).msgId);
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahvn
 * JD-Core Version:    0.7.0.1
 */