import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.util.PAReportUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.qwallet.PublicQuickPayManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgClickHandler;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ahuj
  implements View.OnClickListener
{
  public ahuj(StructMsgItemButton paramStructMsgItemButton) {}
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.a.jdField_c_of_type_Long < 1000L) {}
    label129:
    label919:
    label922:
    for (;;)
    {
      return;
      this.a.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      Object localObject1 = paramView.getTag();
      if ((localObject1 != null) && (StructMsgItemButton.class.isInstance(localObject1)))
      {
        Object localObject2 = ((ViewGroup)paramView.getParent().getParent()).getTag(2131361855);
        if ((localObject2 != null) && (StructMsgForGeneralShare.class.isInstance(localObject2)))
        {
          StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)localObject2;
          StructMsgItemButton localStructMsgItemButton = (StructMsgItemButton)localObject1;
          Context localContext = paramView.getContext();
          if ((localContext instanceof FragmentActivity))
          {
            localObject1 = ((FragmentActivity)localContext).getChatFragment();
            if (localObject1 != null) {
              localObject1 = ((ChatFragment)localObject1).a();
            }
            for (;;)
            {
              for (;;)
              {
                if (localObject1 == null) {
                  break label922;
                }
                localObject2 = "0";
                if (localStructMsgForGeneralShare.message != null) {
                  localObject2 = localStructMsgForGeneralShare.message.getExtInfoFromExtStr("is_AdArrive_Msg");
                }
                if ("1".equals(localObject2)) {}
                try
                {
                  localObject2 = new JSONObject();
                  ((JSONObject)localObject2).put("puin", localStructMsgForGeneralShare.message.frienduin);
                  ((JSONObject)localObject2).put("type", localStructMsgItemButton.l);
                  ((JSONObject)localObject2).put("index", localStructMsgItemButton.j);
                  ((JSONObject)localObject2).put("name", localStructMsgItemButton.k);
                  ((JSONObject)localObject2).put("net", String.valueOf(HttpUtil.a()));
                  ((JSONObject)localObject2).put("mobile_imei", DeviceInfoUtil.a());
                  ((JSONObject)localObject2).put("obj", "");
                  ((JSONObject)localObject2).put("gdt_cli_data", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_msgClick"));
                  ((JSONObject)localObject2).put("view_id", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_view_id"));
                  PAReportUtil.a((AppInterface)localObject1, localStructMsgForGeneralShare.message.selfuin, ((JSONObject)localObject2).toString(), "" + localStructMsgForGeneralShare.msgId);
                  localObject2 = new StructMsgClickHandler((QQAppInterface)localObject1, paramView, localStructMsgForGeneralShare.message);
                  bool = ((EcShopAssistantManager)((QQAppInterface)localObject1).getManager(87)).a(this.a, (Activity)localContext);
                  if (!bool) {
                    if (localStructMsgItemButton.b()) {
                      if (localStructMsgItemButton.a())
                      {
                        ReportController.b((QQAppInterface)localObject1, "P_CliOper", "Pb_account_lifeservice", localStructMsgForGeneralShare.uin, "0X80061FE", "0X80061FE", 0, 1, 0, "", "", "", "");
                        ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", ((QQAppInterface)localObject1).getAccount(), "wallet", "publicpaymsg.btn.click", 1, 0, localStructMsgForGeneralShare.uin, "", String.valueOf(localStructMsgForGeneralShare.msgId), "");
                        if (TextUtils.isEmpty(this.a.e)) {
                          paramView = this.a.d;
                        }
                      }
                    }
                  }
                }
                catch (JSONException localJSONException)
                {
                  for (;;)
                  {
                    try
                    {
                      paramView = new JSONObject(paramView);
                      VACDReportUtil.a("orderId=" + paramView.optString("orderId"), "qqwallet", "publicpaymsg.pay.click", null, null, 0, null);
                      localObject2 = (PublicQuickPayManager)((QQAppInterface)localObject1).getManager(134);
                      ((PublicQuickPayManager)localObject2).a = localContext;
                      ((PublicQuickPayManager)localObject2).a(localStructMsgForGeneralShare.message.frienduin, paramView, new ahuk(this, localStructMsgForGeneralShare, localContext));
                      if ((bool) && (localStructMsgForGeneralShare.message.istroop == 1008)) {
                        PublicAccountManager.b((QQAppInterface)localObject1, localStructMsgForGeneralShare.uin);
                      }
                      if ((localStructMsgForGeneralShare.message != null) && ((localStructMsgForGeneralShare.message.istroop == 1008) || (localStructMsgForGeneralShare.message.istroop == 1024))) {
                        ((QidianManager)((QQAppInterface)localObject1).getManager(164)).a(localStructMsgItemButton.jdField_c_of_type_JavaLangString, localStructMsgItemButton.e, localStructMsgItemButton.d, localStructMsgItemButton.b, 2, "");
                      }
                      if ((localStructMsgForGeneralShare.message != null) && (QidianManager.a((QQAppInterface)localObject1, localStructMsgForGeneralShare.message))) {
                        ((QidianManager)((QQAppInterface)localObject1).getManager(164)).a(localStructMsgItemButton.d);
                      }
                      if (localStructMsgForGeneralShare.msgId <= 0L) {
                        break;
                      }
                      ThreadManager.getSubThreadHandler().postDelayed(new ahul(this, localStructMsgItemButton, localStructMsgForGeneralShare, (QQAppInterface)localObject1, bool), 0L);
                      return;
                      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
                      if (!(localObject1 instanceof QQAppInterface)) {
                        break label919;
                      }
                      localObject1 = (QQAppInterface)localObject1;
                      break label129;
                      localJSONException = localJSONException;
                      localJSONException.printStackTrace();
                      continue;
                      paramView = this.a.e;
                      continue;
                    }
                    catch (Exception paramView)
                    {
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.e("StructMsgItemButton", 2, "pay error:" + paramView.getMessage());
                      continue;
                    }
                    paramView.setClickable(false);
                    paramView.setOnClickListener(null);
                    paramView.setOnTouchListener(null);
                    paramView.setOnLongClickListener(null);
                    continue;
                    if (localStructMsgForGeneralShare.message != null) {
                      localStructMsgItemButton.b = EcShopAssistantManager.a(localStructMsgForGeneralShare.message.frienduin, localStructMsgItemButton.b, (QQAppInterface)localObject1);
                    }
                    boolean bool = localJSONException.a(localStructMsgItemButton.jdField_c_of_type_JavaLangString, localStructMsgItemButton.b, localStructMsgItemButton.d, localStructMsgItemButton.e, localStructMsgForGeneralShare.msgId);
                  }
                  localObject1 = null;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahuj
 * JD-Core Version:    0.7.0.1
 */