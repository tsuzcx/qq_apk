import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import cooperation.comic.VipComicReportUtils;
import java.io.File;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public final class aina
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.findViewById(2131361855);
    if (localObject1 == null) {}
    do
    {
      return;
      paramView = ((View)localObject1).getTag(2131361855);
    } while (!(paramView instanceof StructMsgForImageShare));
    StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)paramView;
    Context localContext = ((View)localObject1).getContext();
    int i;
    Intent localIntent;
    try
    {
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(localStructMsgForImageShare.currentAccountUin);
      AbsShareMsg.doReport(paramView, localStructMsgForImageShare);
      if (localStructMsgForImageShare.msgId > 0L)
      {
        ReportController.b(paramView, "P_CliOper", "Pb_account_lifeservice", localStructMsgForImageShare.uin, "mp_msg_msgpic_click", "aio_morpic_click", 0, 0, "", "", Long.toString(localStructMsgForImageShare.msgId), "");
        ThreadManager.getSubThreadHandler().postDelayed(new ainb(this, localStructMsgForImageShare, paramView), 0L);
      }
      ReportController.b(null, "CliOper", "", "", "0X800567A", "0X800567A", 0, 0, localStructMsgForImageShare.mMsgServiceID + "", "", "", "");
      ReportController.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
      i = 0;
      localObject2 = localStructMsgForImageShare.getFirstImageElement();
      if (localObject2 == null) {
        break label1002;
      }
      if ((!MsgUtils.b(localStructMsgForImageShare.mIsSend)) && (((StructMsgItemImage)localObject2).a != null))
      {
        paramView = PicItemBuilder.a(localContext, ((StructMsgItemImage)localObject2).a);
        if (paramView != null) {
          if (paramView.getStatus() == 2)
          {
            paramView.restartDownload();
            return;
          }
        }
      }
    }
    catch (AccountNotMatchException paramView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, paramView.getStackTrace().toString());
        }
      }
      if ((paramView.getStatus() == 0) && (!paramView.isDownloadStarted()))
      {
        paramView.startDownload();
        return;
      }
      localIntent = new Intent(localContext, AIOGalleryActivity.class);
      localIntent.putExtra("curType", localStructMsgForImageShare.uinType);
      localIntent.putExtra("_id", localStructMsgForImageShare.uniseq);
      localIntent.putExtra("urlAtServer", ((StructMsgItemImage)localObject2).v);
      localIntent.putExtra("KEY_FILE_ID", ((StructMsgItemImage)localObject2).c);
      localIntent.putExtra("picMD5", ((StructMsgItemImage)localObject2).w);
      localIntent.putExtra("url", ((StructMsgItemImage)localObject2).u);
      localIntent.putExtra("friendUin", localStructMsgForImageShare.uin);
      localIntent.putExtra("KEY_MSG_VERSION_CODE", localStructMsgForImageShare.messageVersion);
      localIntent.putExtra("isSend", localStructMsgForImageShare.mIsSend);
      localIntent.putExtra("KEY_BUSI_TYPE", 1030);
      localIntent.putExtra("IS_FROMOTHER_TERMINAL_KEY", MsgUtils.c(localStructMsgForImageShare.mIsSend));
      localIntent.putExtra("uin", localStructMsgForImageShare.uin);
      if (localStructMsgForImageShare.mIsSend != 1) {
        break label1183;
      }
    }
    paramView = localStructMsgForImageShare.currentAccountUin;
    localIntent.putExtra("KEY_TROOP_CODE", paramView);
    localIntent.putExtra("fileSize", ((StructMsgItemImage)localObject2).d);
    localIntent.putExtra("KEY_TIME", ((StructMsgItemImage)localObject2).e);
    localIntent.putExtra("KEY_SUB_VERSION", 5);
    localIntent.putExtra("KEY_FILE_SIZE_FLAG", 0);
    localIntent.putExtra("uniSeq", localStructMsgForImageShare.uniseq);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", AnimationUtils.a((View)localObject1));
    Object localObject2 = ((StructMsgItemImage)localObject2).a;
    if (localObject2 != null)
    {
      localIntent.addFlags(603979776);
      paramView = ((MessageForPic)localObject2).selfuin;
      if (!((MessageForPic)localObject2).isMultiMsg) {
        break label1435;
      }
    }
    label1435:
    for (;;)
    {
      try
      {
        localObject3 = MobileQQ.sMobileQQ.waitAppRuntime(null);
        localObject1 = paramView;
        if ((localObject3 instanceof QQAppInterface)) {
          localObject1 = ((AppRuntime)localObject3).getAccount();
        }
        paramView = (View)localObject1;
      }
      catch (Exception localException)
      {
        Object localObject3;
        AIOImageData localAIOImageData;
        label1002:
        int j;
        label1183:
        continue;
        if ((!localObject2[7].equals("scrawl_link")) || (localObject2.length < 9)) {
          continue;
        }
        String str = localObject2[8];
        continue;
        if ((localStructMsgForImageShare.mMsgActionData == null) || (!localStructMsgForImageShare.mMsgActionData.startsWith("ScreenShotShare"))) {
          continue;
        }
        localAIOImageData.c = 2;
        localAIOImageData.a = localStructMsgForImageShare.getBytes();
        if ((!MsgUtils.b(((MessageForPic)localObject2).issend)) || (TextUtils.isEmpty(((MessageForPic)localObject2).path)) || (!new File(((MessageForPic)localObject2).path).exists())) {
          continue;
        }
        localAIOImageData.b = ((MessageForPic)localObject2).path;
        continue;
        if (localStructMsgForImageShare.mImageBizType != 2) {
          continue;
        }
        if ((!MsgUtils.b(((MessageForPic)localObject2).issend)) || (TextUtils.isEmpty(((MessageForPic)localObject2).path)) || (!TextUtils.isEmpty(((MessageForPic)localObject2).md5)) || (!new File(((MessageForPic)localObject2).path).exists())) {
          continue;
        }
        localAIOImageData.b = ((MessageForPic)localObject2).path;
        localAIOImageData.c = 4;
        continue;
        paramView.putBoolean("extra.FROM_AIO", true);
        paramView.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((Activity)localContext).getClass().getName());
        continue;
        str = "";
        continue;
      }
      localObject3 = new AIOImageProviderService(paramView, ((MessageForPic)localObject2).frienduin, ((MessageForPic)localObject2).istroop, (ChatMessage)localObject2);
      localAIOImageData = AIOGalleryUtils.a((MessageForPic)localObject2);
      if (localStructMsgForImageShare.message != null) {
        localAIOImageData.h = localStructMsgForImageShare.message.time;
      }
      if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("comic_plugin.apk")))
      {
        localAIOImageData.c = 1;
        localAIOImageData.a = localStructMsgForImageShare.getBytes();
        localObject2 = AIOGallerySceneWithBusiness.a(localStructMsgForImageShare);
        localAIOImageData.e = AIOGallerySceneWithBusiness.a((String[])localObject2);
        if ((localObject2 != null) && (localObject2.length >= 8))
        {
          if (localObject2[7].equals("link"))
          {
            localObject1 = localObject2[4];
            VipComicReportUtils.a(null, paramView, localContext, "3009", "2", "40054", localObject2[0], new String[] { localObject2[2], localObject2[4], localObject1 });
          }
        }
        else
        {
          paramView = new Bundle();
          paramView.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(((AIOImageProviderService)localObject3).asBinder()));
          paramView.putParcelable("extra.EXTRA_CURRENT_IMAGE", localAIOImageData);
          paramView.putInt("forward_source_uin_type", localStructMsgForImageShare.uinType);
          if (((localContext instanceof SplashActivity)) || ((localContext instanceof ChatActivity)))
          {
            if (!(localContext instanceof MultiForwardActivity)) {
              continue;
            }
            localObject1 = ((BaseActivity)localContext).getAppInterface();
            if ((localObject1 instanceof QQAppInterface))
            {
              paramView.putBoolean("extra.FROM_AIO", true);
              paramView.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
              paramView.putString("uin", ((MultiForwardActivity)localContext).getChatFragment().a().a().a);
              localObject2 = paramView.getString("extra.GROUP_UIN");
              if ((localObject2 != null) && (((QQAppInterface)localObject1).b((String)localObject2) == 2)) {
                paramView.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
              }
            }
          }
          localIntent.putExtras(paramView);
          localContext.startActivity(localIntent);
          i = 1;
          j = 0;
          if (i != 0) {
            j = 1;
          }
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", localStructMsgForImageShare.uin, "0X80055C7", "0X80055C7", 0, j, "" + localStructMsgForImageShare.msgId, "" + localStructMsgForImageShare.templateIDForPortal, "", localStructMsgForImageShare.mMsgUrl);
          paramView = new StringBuilder().append("MSGID=").append(Long.toString(localStructMsgForImageShare.msgId)).append(";TEPLATEID=").append(localStructMsgForImageShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(AbsStructMsgElement.a(localStructMsgForImageShare.mMsgUrl));
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", localStructMsgForImageShare.uin, "0X8005D49", "0X8005D49", 0, j, paramView.toString(), "", "", "");
          return;
          paramView = localStructMsgForImageShare.uin;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aina
 * JD-Core Version:    0.7.0.1
 */