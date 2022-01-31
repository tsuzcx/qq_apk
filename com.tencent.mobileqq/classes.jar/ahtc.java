import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicJumpActivity;
import cooperation.comic.VipComicReportUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class ahtc
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  
  public ahtc(AbsShareMsg paramAbsShareMsg) {}
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long < 1000L) {}
    AbsShareMsg localAbsShareMsg;
    Context localContext;
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
          localObject1 = paramView.getTag();
        } while ((localObject1 == null) || (!AbsShareMsg.class.isInstance(localObject1)));
        localAbsShareMsg = (AbsShareMsg)localObject1;
        localContext = paramView.getContext();
      } while ((!SplashActivity.class.isInstance(localContext)) && (!ChatActivity.class.isInstance(localContext)));
      if (localContext == null)
      {
        QLog.e("StructMsg", 1, "context is null, never do click, return");
        return;
      }
      localObject1 = ((FragmentActivity)localContext).getChatFragment();
      if (localObject1 == null)
      {
        QLog.e("StructMsg", 1, "context.getChatFragment is null, never do click, return");
        return;
      }
      localQQAppInterface = ((ChatFragment)localObject1).a();
    } while (localQQAppInterface == null);
    Object localObject3 = new ahte(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, localQQAppInterface, paramView);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAction;
    paramView = (View)localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAction.equals("web"))
    {
      paramView = (View)localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl.contains("webcard.mp.qq.com"))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
        paramView = "plugin";
        ((AbsShareMsg)localObject1).mSourceAction = "plugin";
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.source_puin });
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "mSourceOnClickListener sourceAction = " + paramView);
    }
    if ("app".equals(paramView)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData.startsWith("comic_plugin.apk")))
      {
        paramView = new Intent(localContext, VipComicJumpActivity.class);
        paramView.putExtra("options", "{\"from\":28}");
        localContext.startActivity(paramView);
        localObject1 = AIOGallerySceneWithBusiness.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData);
        if ((localObject1 != null) && (localObject1.length >= 8))
        {
          if (!localObject1[7].equals("link")) {
            break label926;
          }
          paramView = localObject1[4];
        }
      }
    }
    for (;;)
    {
      VipComicReportUtils.a(null, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.uin, localContext, "3009", "2", "40059", localObject1[0], new String[] { localObject1[2], localObject1[4], paramView });
      paramView = "";
      label413:
      ReportCenter.a().a(localQQAppInterface.getAccount(), "", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid), "1000", "80", "0", false);
      label443:
      Util.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.uin, "sourceclick", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID, paramView);
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X800567C", "0X800567C", 0, 0, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID + "", "", "", "");
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID + "", "", "", "");
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8007C39", "0X8007C39", 0, 0, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID + "", "", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, "");
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.adverSign == 1) {
        ReportController.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.uin, "0X800631F", "0X800631F", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.msgId, "", "", "");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 114) {
        ThreadManager.post(new ahtd(this, localQQAppInterface), 0, null, false);
      }
      label791:
      label926:
      if (((localAbsShareMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)localAbsShareMsg).mIsPAVideoStructMsg))
      {
        localObject1 = (StructMsgForGeneralShare)localAbsShareMsg;
        localObject3 = ((StructMsgForGeneralShare)localObject1).iterator();
        label751:
        while (((Iterator)localObject3).hasNext())
        {
          paramView = (AbsStructMsgElement)((Iterator)localObject3).next();
          if ((paramView instanceof StructMsgItemLayout5))
          {
            Iterator localIterator = ((StructMsgItemLayout5)paramView).a.iterator();
            String str1;
            String str2;
            while (localIterator.hasNext())
            {
              paramView = (AbsStructMsgElement)localIterator.next();
              if ((paramView instanceof StructMsgItemVideo))
              {
                paramView = (StructMsgItemVideo)paramView;
                if (paramView.a())
                {
                  VideoReporter.a("0X80065FE", ((StructMsgForGeneralShare)localObject1).uinType, VideoReporter.a(paramView.k, ((StructMsgForGeneralShare)localObject1).mSourceName), paramView.w, "");
                  str1 = VideoReporter.a(null, ((StructMsgForGeneralShare)localObject1).source_puin, paramView.w, paramView.B, null);
                  str2 = ((StructMsgForGeneralShare)localObject1).source_puin;
                  if (paramView.B == null) {
                    break label1309;
                  }
                }
              }
            }
            for (paramView = paramView.B;; paramView = "0")
            {
              PublicAccountReportUtils.a(localQQAppInterface, str2, "0x8007410", "0x8007410", 0, 0, "1", "", paramView, str1, false);
              break label791;
              break label751;
              if ((!localObject1[7].equals("scrawl_link")) || (localObject1.length < 9)) {
                break label1428;
              }
              paramView = localObject1[8];
              break;
              if (((ahte)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData))
              {
                paramView = "run";
                break label413;
              }
              if (((ahte)localObject3).a(((FragmentActivity)localContext).getActivity(), this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid, localAbsShareMsg.mSourceName, localAbsShareMsg.mSourceActionData, localAbsShareMsg.mSource_A_ActionData))
              {
                paramView = "setup";
                break label413;
              }
              ((ahte)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl);
              paramView = "setup";
              break label413;
              if ("web".equals(paramView))
              {
                paramView = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl;
                if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 114) {
                  paramView = ((MedalWallMng)localQQAppInterface.getManager(249)).a(true, localQQAppInterface.getCurrentAccountUin(), MedalWallMng.g);
                }
                ((ahte)localObject3).a(paramView);
                paramView = "setup";
                break label443;
              }
              if ("plugin".equals(paramView))
              {
                ((ahte)localObject3).c(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData);
                if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName.equals(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.readInjoy)) {
                  paramView = null;
                }
                try
                {
                  localObject1 = Uri.parse(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl).getQueryParameter("article_id");
                  paramView = (View)localObject1;
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    localException.printStackTrace();
                    continue;
                    PublicAccountReportUtils.a(null, "", "0X8007756", "0X8007756", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl, "", "", false);
                  }
                }
                if (!TextUtils.isEmpty(paramView))
                {
                  PublicAccountReportUtils.a(null, "", "0X8007756", "0X8007756", 0, 0, paramView, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl, "", "", false);
                  paramView = "plugin";
                  break label443;
                }
              }
              ((ahte)localObject3).a(paramView, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData);
              break label443;
            }
          }
        }
      }
      label1309:
      if ((localAbsShareMsg.mMsgServiceID != 81) || (localAbsShareMsg == null) || (TextUtils.isEmpty(localAbsShareMsg.mMsg_A_ActionData))) {
        break;
      }
      Object localObject2 = JumpParser.a(localQQAppInterface, localContext, localAbsShareMsg.mMsg_A_ActionData);
      if (localObject2 == null) {
        break;
      }
      paramView = ((JumpAction)localObject2).a("usertype");
      localObject2 = ((JumpAction)localObject2).a("unionid");
      if ((TextUtils.isEmpty(paramView)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        break;
      }
      int i = 0;
      try
      {
        int j = Integer.parseInt(paramView);
        i = j;
      }
      catch (NumberFormatException paramView)
      {
        label1403:
        break label1403;
      }
      StoryReportor.a("share_uin_obj", "clk_tail", 0, i, new String[] { localObject2 });
      return;
      label1428:
      paramView = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahtc
 * JD-Core Version:    0.7.0.1
 */