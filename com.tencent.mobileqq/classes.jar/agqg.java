import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.BasePicItemBuilder.4;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.transfile.AIOImgThumbHelper;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PicFowardDbRecordData;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError;
import com.tencent.mobileqq.transfile.chatpic.PicUploadExplicitError;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class agqg
  extends ahdy
  implements afsn
{
  public static boolean h = true;
  protected axjk a;
  protected final float b;
  boolean f = false;
  boolean g = false;
  
  public agqg(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.b = paramContext.getResources().getDisplayMetrics().density;
    if (this.jdField_a_of_type_Axjk == null) {
      this.jdField_a_of_type_Axjk = ((axjk)paramQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER));
    }
  }
  
  private static int a(Context paramContext)
  {
    int j = 2;
    int i;
    if (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))) {
      i = 1;
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while ((paramContext instanceof ChatHistoryActivity));
        i = j;
      } while ((paramContext instanceof ChatHistory));
      if (!(paramContext instanceof PublicFragmentActivity)) {
        break;
      }
      i = j;
    } while ((((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment));
    while (!(paramContext instanceof MultiForwardActivity)) {
      return -1;
    }
    return 5;
  }
  
  static Intent a(MessageForPic paramMessageForPic, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("forward_type", 1);
    ((Bundle)localObject).putInt("forward_source_uin_type", paramSessionInfo.curType);
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_image_width", paramMessageForPic.width);
    localIntent.putExtra("forward_image_height", paramMessageForPic.height);
    localIntent.putExtra("forward_file_size", paramMessageForPic.size);
    localIntent.putExtra("forward_image_type", paramMessageForPic.imageType);
    localIntent.putExtra("forward_filepath", paramMessageForPic.path);
    localIntent.putExtra("forward_download_image_task_key", paramMessageForPic.frienduin + paramMessageForPic.uniseq + paramMessageForPic.istroop);
    localIntent.putExtra("forward_download_image_org_uin", paramMessageForPic.frienduin);
    localIntent.putExtra("forward_download_image_org_uin_type", paramMessageForPic.istroop);
    localIntent.putExtra("forward_download_image_server_path", paramMessageForPic.uuid);
    localIntent.putExtra("forward_download_image_item_id", paramMessageForPic.uniseq);
    localIntent.putExtra("forward_photo_isSend", paramMessageForPic.issend);
    localIntent.putExtra("forward_photo_sender_uin", paramMessageForPic.senderuin);
    localIntent.putExtra("forward_photo_md5", paramMessageForPic.md5);
    localIntent.putExtra("forward_photo_group_fileid", paramMessageForPic.groupFileID);
    localIntent.putExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", paramMessageForPic.fileSizeFlag);
    if (paramMessageForPic.picExtraData != null) {
      localIntent.putExtra("forward_photo_imagebiz_type", paramMessageForPic.picExtraData.imageBizType);
    }
    localIntent.putExtras((Bundle)localObject);
    if ((bhca.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003))
    {
      i = 1;
      if (i != 0) {
        break label617;
      }
    }
    label617:
    for (int i = 65537;; i = 1)
    {
      localObject = URLDrawableHelper.getURL(paramMessageForPic, i);
      localIntent.putExtra("forward_urldrawable", true);
      localIntent.putExtra("forward_urldrawable_thumb_url", ((URL)localObject).toString());
      localIntent.putExtra("FORWARD_URL_KEY", paramMessageForPic.localUUID);
      paramContext = ForwardUtils.generateForwardImage(paramContext, paramMessageForPic);
      localIntent.putExtra("forward_urldrawable_big_url", paramContext.getURL().toString());
      localIntent.putExtra("uinname", paramSessionInfo.curFriendNick);
      localIntent.putExtra("PhotoConst.MY_UIN", paramQQAppInterface.getAccount());
      localIntent.putExtra("PhotoConst.MY_NICK", paramQQAppInterface.getCurrentNickname());
      localIntent.putExtra("is_anonymous", nty.a().a(paramSessionInfo.curFriendUin));
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1009);
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      localIntent.putExtra("key_confess_topicid", paramSessionInfo.topicId);
      localIntent.addFlags(603979776);
      localIntent.putExtra("FORWARD_MSG_FOR_PIC", paramMessageForPic);
      if (!FileUtils.fileExistsAndNotEmpty(paramMessageForPic.path)) {
        break label623;
      }
      localIntent.putExtra("forward_extra", paramMessageForPic.path);
      localIntent.putExtra("direct_send_if_dataline_forward", true);
      localIntent.putExtra("forward_source_uin_type", paramSessionInfo.curType);
      localIntent.putExtra("BUSI_TYPE", 1009);
      return localIntent;
      i = 0;
      break;
    }
    label623:
    paramQQAppInterface = null;
    paramContext = paramContext.getURL().toString();
    if (AbsDownloader.hasFile(paramContext))
    {
      paramContext = AbsDownloader.getFile(paramContext);
      paramMessageForPic = paramQQAppInterface;
      if (paramContext != null) {
        paramMessageForPic = paramContext.getAbsolutePath();
      }
    }
    for (;;)
    {
      localIntent.putExtra("forward_extra", paramMessageForPic);
      break;
      paramContext = AbsDownloader.getFile(URLDrawableHelper.getURL(paramMessageForPic, 65537).toString());
      paramMessageForPic = paramQQAppInterface;
      if (paramContext != null)
      {
        paramMessageForPic = paramQQAppInterface;
        if (paramContext.exists()) {
          paramMessageForPic = paramContext.getAbsolutePath();
        }
      }
    }
  }
  
  static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt, agqk paramagqk)
  {
    return new azle(paramMessageForPic).a(paramChatThumbView).a(paramArrayOfInt).a(paramagqk).a().a();
  }
  
  static void a(QQAppInterface paramQQAppInterface, Context paramContext, View paramView, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramView != null) {
      paramBundle.putParcelable("KEY_THUMBNAL_BOUND", aavz.a(paramView));
    }
    paramBundle.putBoolean("is_one_item", paramBoolean);
    if (paramSessionInfo.curType == 1)
    {
      paramBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      paramBundle.putString("extra.GROUP_UIN", paramSessionInfo.curFriendUin);
      paramBundle.putString("extra.GROUP_CODE", paramSessionInfo.troopUin);
      paramBundle.putBoolean("extra.IS_HOT_CHAT", axnp.a(paramChatMessage));
    }
    String str;
    if ((paramSessionInfo.curType == 1) || (paramSessionInfo.curType == 3000))
    {
      paramBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
      paramBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
      str = paramChatMessage.selfuin;
      paramView = str;
      if (!paramChatMessage.isMultiMsg) {}
    }
    try
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramView = str;
      if ((localAppRuntime instanceof QQAppInterface)) {
        paramView = localAppRuntime.getAccount();
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        paramView = str;
      }
      paramView = (axjk)paramQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
      paramBoolean = paramView.a(paramChatMessage);
      paramBundle.putBoolean("extra.IS_SAVING_FILE", paramBoolean);
      if (!paramBoolean) {
        break label325;
      }
      paramView = paramView.a(paramView.a(paramChatMessage));
      if ((paramView == null) || (paramView.d != 1)) {
        break label325;
      }
      paramBundle.putInt("extra.SAVE_FILE_PROGRESS", paramView.c);
      label325:
      i = a(paramContext);
      if (!(paramChatMessage instanceof MessageForPic)) {
        break label382;
      }
    }
    paramBundle.putInt("forward_source_uin_type", paramSessionInfo.curType);
    paramBundle.putString("uin", paramChatMessage.frienduin);
    paramSessionInfo = new AIOImageProviderService(paramView, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage);
    if ((paramView == null) || (paramChatMessage.frienduin == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("PicItemBuilder", 2, "PicItemBuilder.enterImagePreview() selfUin || pic.frienduin is null");
      }
    }
    for (;;)
    {
      return;
      paramBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
      break;
      int i;
      paramBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
      blvp.a(paramContext, paramBundle, paramSessionInfo, ahsl.a((MessageForPic)paramChatMessage), -1, i);
      while (QLog.isColorLevel())
      {
        QLog.i("PicItemBuilder", 2, "PicItemBuilder.enterImagePreview()");
        return;
        label382:
        if ((paramChatMessage instanceof MessageForTroopFile))
        {
          paramBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
          blvp.a(paramContext, paramBundle, paramSessionInfo, ahsl.a((MessageForTroopFile)paramChatMessage, paramQQAppInterface), -1, i);
        }
      }
    }
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, agql paramagql)
  {
    if (paramagql.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if ((paramIHttpCommunicatorListener instanceof BaseTransProcessor))
    {
      paramIHttpCommunicatorListener = (BaseTransProcessor)paramIHttpCommunicatorListener;
      int i = (int)paramIHttpCommunicatorListener.getFileStatus();
      switch (i)
      {
      default: 
        if (paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
        {
          paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          if (paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
            break label680;
          }
          paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
          ((RelativeLayout)paramagql.jdField_a_of_type_AndroidViewView).removeView(paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
          paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
        }
        break;
      }
      for (;;)
      {
        if (i == 1003) {
          paramagql.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        paramagql.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        return;
        if ((paramIHttpCommunicatorListener.isRawPic()) && (!this.f))
        {
          paramagql.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          if (paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
          {
            paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
            paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
            paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
            ((RelativeLayout)paramagql.jdField_a_of_type_AndroidViewView).removeView(paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
            paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
          }
          paramagql.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        }
        paramagql.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        if (paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) {
          break;
        }
        paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = true;
        return;
        paramagql.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        if (paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
        {
          PicProgressView localPicProgressView = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
          localPicProgressView.setRadius(12.0F, true);
          localPicProgressView.setSharpCornerCor(BubbleImageView.a);
          localPicProgressView.setShowCorner(false);
          localPicProgressView.setCustomSize(1);
          localPicProgressView.setProgressBackgroudColor(2130706432);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(6, 2131372790);
          localLayoutParams.addRule(8, 2131372790);
          localLayoutParams.addRule(5, 2131372790);
          localLayoutParams.addRule(7, 2131372790);
          ((RelativeLayout)paramagql.jdField_a_of_type_AndroidViewView).addView(localPicProgressView, localLayoutParams);
          paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = localPicProgressView;
        }
        paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(paramIHttpCommunicatorListener);
        paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
        if ((paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) && ((1001 == i) || (1002 == i))) {
          paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = false;
        }
        if (i != 1002)
        {
          paramagql.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
          paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(0);
          return;
        }
        paramagql.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a();
        paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setShowProgress(true);
        return;
        label680:
        paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
      }
    }
    if (paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)paramagql.jdField_a_of_type_AndroidViewView).removeView(paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
    paramagql.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
  }
  
  private void c(MessageForPic paramMessageForPic, agql paramagql)
  {
    Object localObject;
    int i;
    if ((this.jdField_a_of_type_Axjk != null) && (paramMessageForPic != null) && (paramagql != null))
    {
      paramMessageForPic = this.jdField_a_of_type_Axjk.a(paramMessageForPic.getPicDownloadInfo());
      localObject = this.jdField_a_of_type_Axjk.a(paramMessageForPic);
      if ((localObject != null) && (((axjg)localObject).d == 1))
      {
        if (((axjg)localObject).c >= 0) {
          break label318;
        }
        i = 0;
      }
    }
    for (;;)
    {
      if ((i < 100) && (!((axjg)localObject).jdField_a_of_type_Boolean) && (paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) && (((axjg)localObject).jdField_a_of_type_Axjf != null))
      {
        ((axjg)localObject).jdField_a_of_type_Axjf.a(new agqh(this, paramagql, paramMessageForPic));
        this.jdField_a_of_type_Axjk.a(paramMessageForPic, (axjg)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("PicItemBuilder", 2, "show picSaveProgress");
        }
        paramMessageForPic = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
        paramMessageForPic.setRadius(12.0F, true);
        paramMessageForPic.setSharpCornerCor(BubbleImageView.a);
        paramMessageForPic.setShowCorner(false);
        paramMessageForPic.setCustomSize(1);
        paramMessageForPic.setProgressBackgroudColor(2130706432);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131372790);
        ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131372790);
        ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131372790);
        ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131372790);
        ((RelativeLayout)paramagql.jdField_a_of_type_AndroidViewView).addView(paramMessageForPic, (ViewGroup.LayoutParams)localObject);
        paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = paramMessageForPic;
        paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
        paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = false;
        paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(i);
        paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setShowProgress(true);
      }
      return;
      label318:
      if (((axjg)localObject).c > 100) {
        i = 100;
      } else {
        i = ((axjg)localObject).c;
      }
    }
  }
  
  private void f(MessageForPic paramMessageForPic)
  {
    ThreadManager.post(new BasePicItemBuilder.4(this, paramMessageForPic), 5, null, false);
    if (paramMessageForPic.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().removeProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().makeKey(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    azko localazko = new azko();
    localazko.a(paramMessageForPic.path);
    localazko.d(5);
    localazko.d(paramMessageForPic.frienduin);
    if (paramMessageForPic.fileSizeFlag == 1) {
      localazko.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_RAW_PHOTO);
    }
    for (;;)
    {
      localazko.e(paramMessageForPic.senderuin);
      localazko.c(paramMessageForPic.selfuin);
      localazko.e(paramMessageForPic.istroop);
      localazko.l(paramMessageForPic.getConfessTopicId());
      localazko.jdField_i_of_type_Int = paramMessageForPic.extLong;
      localazko.jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
      Object localObject = new azkp();
      ((azkp)localObject).a = paramMessageForPic.msgseq;
      ((azkp)localObject).b = paramMessageForPic.shmsgseq;
      ((azkp)localObject).c = paramMessageForPic.msgUid;
      localazko.a((azkp)localObject);
      localazko.b(paramMessageForPic.uniseq);
      ((bbob)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramMessageForPic.uniseq);
      localObject = azjv.a(4, 5);
      ((azke)localObject).a(localazko.a());
      ((azke)localObject).a = paramMessageForPic.picExtraData;
      azjv.a((azke)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      localazko.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_PHOTO);
    }
  }
  
  private void g(MessageForPic paramMessageForPic)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramMessageForPic.selfuin, paramMessageForPic.uniseq);
    if ((localObject1 != null) && ((localObject1 instanceof BaseUploadProcessor)))
    {
      ((BaseUploadProcessor)localObject1).start();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByUniseq(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
    if (paramMessageForPic.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().removeProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().makeKey(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    localObject1 = new azjz();
    Object localObject2 = new azko();
    ((azko)localObject2).d(1009);
    ((azko)localObject2).a(paramMessageForPic.path);
    ((azko)localObject2).e(paramMessageForPic.istroop);
    ((azko)localObject2).c(paramMessageForPic.selfuin);
    ((azko)localObject2).e(paramMessageForPic.senderuin);
    ((azko)localObject2).d(paramMessageForPic.frienduin);
    ((azko)localObject2).jdField_i_of_type_Int = paramMessageForPic.extLong;
    ((azko)localObject2).jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
    ((azko)localObject2).c(TranDbRecord.PicDbRecord.EXTRA_FLAG_FOWARD_PHOTO);
    ((azko)localObject2).b(paramMessageForPic.uniseq);
    ((azjz)localObject1).jdField_a_of_type_Azkn = ((azko)localObject2).a();
    if ((!FileUtils.fileExistsAndNotEmpty(paramMessageForPic.path)) && ((paramMessageForPic.picExtraObject instanceof PicFowardDbRecordData)))
    {
      localObject2 = (PicFowardDbRecordData)paramMessageForPic.picExtraObject;
      azjy localazjy = new azjy();
      localazjy.a(1009);
      localazjy.a(paramMessageForPic.selfuin);
      localazjy.b(((PicFowardDbRecordData)localObject2).fowardOrgUin);
      localazjy.b(((PicFowardDbRecordData)localObject2).fowardOrgUinType);
      localazjy.c(((PicFowardDbRecordData)localObject2).fowardOrgUrl);
      localazjy.a(((PicFowardDbRecordData)localObject2).fowardOrgId);
      localazjy.d(paramMessageForPic.md5);
      localazjy.c(paramMessageForPic.issend);
      ((azjz)localObject1).jdField_a_of_type_Azjx = localazjy.a();
    }
    ((bbob)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramMessageForPic.uniseq);
    paramMessageForPic = azjv.a(3, 1009);
    paramMessageForPic.a((azjz)localObject1);
    azjv.a(paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afqq a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (agql)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  public afqr a()
  {
    return new agql(this);
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    paramBaseChatItemLayout = (MessageForPic)paramChatMessage;
    boolean bool2 = blvp.a(paramBaseChatItemLayout.imageType);
    agql localagql;
    try
    {
      localagql = (agql)paramafqr;
      if (localagql == null) {
        return paramView;
      }
    }
    catch (Exception paramChatMessage)
    {
      QLog.e("PicItemBuilder", 2, "picitem holer Exception e= " + paramChatMessage);
      throw new ClassCastException("picitem holer Exception e= " + paramChatMessage);
    }
    localagql.jdField_a_of_type_Boolean = bool2;
    paramafqr = paramView;
    int i;
    if (paramView == null)
    {
      paramafqr = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramafqr.setId(2131372790);
      paramView = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      i = Build.VERSION.SDK_INT;
      if ((i == 19) || (i == 18)) {
        paramView.e = true;
      }
      paramView.setId(2131372790);
      paramView.setAdjustViewBounds(true);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(12.0F);
      paramView.d(false);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(15);
      paramafqr.addView(paramView, localLayoutParams);
      localagql.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramView;
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(7, 2131372790);
      localLayoutParams.addRule(8, 2131372790);
      paramafqr.addView(paramView, localLayoutParams);
      localagql.jdField_a_of_type_AndroidWidgetImageView = paramView;
      paramafqr.setOnClickListener(this);
      super.a(paramafqr, paramaftk);
    }
    paramView = localagql.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
    int j = (int)Math.max(paramBaseChatItemLayout.width, paramBaseChatItemLayout.height);
    boolean bool1;
    if (!ahcj.a(paramBaseChatItemLayout))
    {
      bool1 = true;
      i = AIOImgThumbHelper.getAioThumbMaxPx(bool2, bool1, j);
      if (ahcj.a(paramBaseChatItemLayout)) {
        break label572;
      }
      bool1 = true;
      label342:
      j = AIOImgThumbHelper.getAioThumbMinPx(bool2, bool1, j);
      paramView.setMaxWidth(i);
      paramView.setMaxHeight(i);
      paramView.setMinimumWidth(j);
      paramView.setMinimumHeight(j);
      if ((ahcj.a(paramBaseChatItemLayout)) || (bool2)) {
        break label578;
      }
      bool1 = true;
      label393:
      paramView.setShowEdge(bool1);
      if (e) {
        paramView.setContentDescription(anvx.a(2131707606));
      }
      if (paramBaseChatItemLayout.isSendFromLocal()) {
        break label584;
      }
      b(paramBaseChatItemLayout, localagql, paramafqr, bool2);
      label434:
      if (QLog.isColorLevel())
      {
        paramaftk = new StringBuilder().append("getView ");
        if (localagql.jdField_a_of_type_Agqk == null) {
          break label598;
        }
      }
    }
    label572:
    label578:
    label584:
    label598:
    for (paramView = localagql.jdField_a_of_type_Agqk.toString();; paramView = "")
    {
      QLog.d("PicItemBuilder", 2, paramView + ", isDynamic=" + bool2 + ", thumbWidth=" + paramBaseChatItemLayout.thumbWidth + ", thumbHeight=" + paramBaseChatItemLayout.thumbHeight + ", thumbMaxSize=" + i + ", thumbMinSize=" + j);
      a(paramChatMessage, paramafqr, this);
      c(paramBaseChatItemLayout, localagql);
      return paramafqr;
      bool1 = false;
      break;
      bool1 = false;
      break label342;
      bool1 = false;
      break label393;
      a(paramBaseChatItemLayout, localagql, paramafqr, bool2);
      break label434;
    }
  }
  
  public bhjq a(bhjq parambhjq, ChatMessage paramChatMessage, afrk paramafrk)
  {
    paramChatMessage = (MessageForPic)paramChatMessage;
    paramafrk = (agql)paramafrk;
    int i = paramafrk.a(paramChatMessage);
    paramafrk.getClass();
    if (i != 1)
    {
      paramafrk.getClass();
      if (i != 2)
      {
        paramafrk.getClass();
        if (i != 4)
        {
          paramafrk.getClass();
          if (i != 5) {
            return parambhjq;
          }
        }
      }
    }
    a(parambhjq, paramafrk.jdField_a_of_type_Boolean);
    a(parambhjq, paramChatMessage);
    a(parambhjq);
    return parambhjq;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bhfj.a(paramChatMessage.issend)) {
      return anvx.a(2131707607);
    }
    return anvx.a(2131707608);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForPic localMessageForPic;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForPic)))
    {
      localMessageForPic = (MessageForPic)paramChatMessage;
      if (paramInt == 2131367213) {
        d(localMessageForPic);
      }
    }
    else
    {
      return;
    }
    if (paramInt == 2131362198)
    {
      c(localMessageForPic);
      return;
    }
    if (paramInt == 2131365475)
    {
      j(paramChatMessage);
      return;
    }
    if (paramInt == 2131371684)
    {
      b(localMessageForPic);
      return;
    }
    if (paramInt == 2131376627)
    {
      e(localMessageForPic);
      return;
    }
    if (paramInt == 2131366456)
    {
      a(localMessageForPic);
      return;
    }
    if (paramInt == 2131364266)
    {
      i(paramChatMessage);
      return;
    }
    if (paramInt == 2131364254)
    {
      h(paramChatMessage);
      return;
    }
    if (paramInt == 2131371673)
    {
      super.d(paramChatMessage);
      return;
    }
    if (paramInt == 2131371641)
    {
      super.a(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  void a(agql paramagql, boolean paramBoolean, int[] paramArrayOfInt, URL paramURL) {}
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.getMessage(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForPic)((agql)AIOUtils.getHolder(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    } while (!paramView.isSendFromLocal());
    bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbkzi.a(2131689976, 5);
    localbkzi.c(2131690697);
    localbkzi.a(new agqj(this, paramView, localbkzi));
    localbkzi.show();
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    agql localagql = (agql)AIOUtils.getHolder(paramView);
    if (localagql == null) {
      QLog.e("PicItemBuilder", 2, "handleMessage(): holder is null");
    }
    do
    {
      do
      {
        do
        {
          return;
          try
          {
            paramView = (MessageForPic)localagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if ((localagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (paramView == null))
            {
              QLog.e("PicItemBuilder", 2, "handleMessage(): holder.mMessage is null");
              return;
            }
          }
          catch (ClassCastException paramView)
          {
            for (;;)
            {
              QLog.e("PicItemBuilder", 2, "handleMessage(): cast exception", paramView);
              paramView = null;
            }
            if ((paramInt1 == 2003) && (paramFileMsg.fileType == 65537))
            {
              boolean bool = blvp.a(paramView.imageType);
              int i = localagql.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
              int j = localagql.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
              localagql.jdField_a_of_type_ComTencentImageURLDrawable.getURL().getProtocol();
              URL localURL = URLDrawableHelper.getURL(paramView, 65537);
              a(localagql, bool, new int[] { i, j }, localURL);
            }
          }
        } while (((paramFileMsg.fileType != 1) && (paramFileMsg.fileType != 131075)) || (paramInt1 == 2002) || (paramInt1 == 2001) || (paramView.uniseq != paramFileMsg.uniseq));
        RichMediaUtil.logUI(paramView.istroop, paramView.isSendFromLocal(), 65537, String.valueOf(paramView.uniseq), "PicItemBuilder.transf.in", "status:" + paramInt1 + ",retCode" + paramInt2 + "message.uniseq：" + paramView.uniseq + ",file.uniseq:" + paramFileMsg.uniseq, null);
        if (paramView.isSendFromLocal())
        {
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramView.frienduin, paramView.uniseq), localagql);
          if (paramInt1 == 1005) {
            b();
          }
        }
      } while (paramInt1 != 2003);
      a(paramView, localagql);
      paramView = ahcj.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localagql.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localagql.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
      localagql.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
      localagql.jdField_a_of_type_ComTencentImageURLDrawable = paramView;
    } while (localagql.jdField_a_of_type_ComTencentImageURLDrawable == null);
    localagql.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
  }
  
  void a(bhjq parambhjq)
  {
    if (AIOUtils.getAIOMsgMenuDpcConfig(5) == 1) {
      parambhjq.a(2131366456, this.jdField_a_of_type_AndroidContentContext.getString(2131692126), 2130838990);
    }
  }
  
  void a(bhjq parambhjq, MessageForPic paramMessageForPic)
  {
    if (URLDrawableHelper.hasDiskCache(this.jdField_a_of_type_AndroidContentContext, paramMessageForPic, 65537)) {
      parambhjq.a(2131367213, this.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838991);
    }
  }
  
  void a(bhjq parambhjq, boolean paramBoolean)
  {
    boolean bool = true;
    bhjs localbhjs;
    if (AIOUtils.getAIOMsgMenuDpcConfig(1) == 1)
    {
      localbhjs = new bhjs(2131362198, this.jdField_a_of_type_AndroidContentContext.getString(2131693145));
      localbhjs.a(2130838989);
      if (paramBoolean) {
        break label59;
      }
    }
    label59:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localbhjs.a(paramBoolean);
      parambhjq.a(localbhjs);
      return;
    }
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    bmad.a(paramMessageForPic).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    bman.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
    bman.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, 0, paramMessageForPic.istroop);
  }
  
  abstract void a(MessageForPic paramMessageForPic, agql paramagql);
  
  protected void a(MessageForPic paramMessageForPic, agql paramagql, View paramView, boolean paramBoolean)
  {
    if (paramagql.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      paramagql.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
    }
    agqk localagqk = new agqk(paramMessageForPic);
    URL localURL = localagqk.a;
    if ((paramagql.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramagql.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(localURL)))
    {
      URLDrawable localURLDrawable = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPic, paramagql.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, null, localagqk);
      paramagql.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(localURLDrawable);
      paramagql.jdField_a_of_type_ComTencentImageURLDrawable = localURLDrawable;
      paramagql.jdField_a_of_type_Agqk = localagqk;
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PicItemBuilder", 2, "predownloadDynamic pic uniseq=" + paramMessageForPic.uniseq + " url=" + localURL);
        }
        a(paramMessageForPic, paramagql.jdField_a_of_type_ComTencentImageURLDrawable);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PicItemBuilder", 2, "show send pic uniseq=" + paramMessageForPic.uniseq + " url=" + localURL);
      }
    }
    paramMessageForPic = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramMessageForPic.frienduin, paramMessageForPic.uniseq);
    paramagql.jdField_a_of_type_AndroidViewView = paramView;
    a(paramMessageForPic, paramagql);
    if (paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) {
      paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = true;
    }
  }
  
  void a(MessageForPic paramMessageForPic, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getStatus() == 1) && ((paramURLDrawable.getCurrDrawable() instanceof GifDrawable))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPicPreDownloader().b(paramMessageForPic, 2);
    }
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool = true;
    if (paramChatMessage.isMultiMsg) {}
    while (!paramChatMessage.isSendFromLocal()) {
      return false;
    }
    paramChatMessage = (MessageForPic)paramChatMessage;
    if (paramChatMessage.size <= 0L)
    {
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramChatMessage instanceof BaseTransProcessor))
      {
        long l = ((BaseTransProcessor)paramChatMessage).getFileStatus();
        if ((l == 1005L) || ((l == 1006L) && (!this.f)) || (l == 1004L)) {}
        for (bool = true;; bool = false) {
          return bool;
        }
      }
      return true;
    }
    if (paramChatMessage.extraflag == 32768) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public bhjs[] a(View paramView)
  {
    paramView = (agql)AIOUtils.getHolder(paramView);
    MessageForPic localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    bhjq localbhjq = new bhjq();
    if (localMessageForPic != null)
    {
      if (!localMessageForPic.isMultiMsg) {
        break label48;
      }
      a(localbhjq, localMessageForPic, paramView);
    }
    for (;;)
    {
      return localbhjq.a();
      label48:
      b(localbhjq, localMessageForPic, paramView);
      super.a(localbhjq, this.jdField_a_of_type_AndroidContentContext, localMessageForPic, true);
    }
  }
  
  public bhjq b(bhjq parambhjq, ChatMessage paramChatMessage, afrk paramafrk)
  {
    MessageForPic localMessageForPic = (MessageForPic)paramChatMessage;
    paramafrk = (agql)paramafrk;
    this.f = true;
    int i = paramafrk.a(localMessageForPic);
    paramafrk.getClass();
    if (i == 1)
    {
      a(parambhjq, paramafrk.jdField_a_of_type_Boolean);
      b(parambhjq, localMessageForPic);
      a(parambhjq, localMessageForPic);
      a(localMessageForPic, parambhjq);
      a(parambhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, localMessageForPic);
      a(parambhjq, localMessageForPic);
      a(parambhjq);
      c(paramChatMessage, parambhjq);
      b(paramChatMessage, parambhjq);
      c(parambhjq, this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      e(parambhjq, this.jdField_a_of_type_AndroidContentContext);
      return parambhjq;
      paramafrk.getClass();
      if (i == 2)
      {
        a(parambhjq, paramafrk.jdField_a_of_type_Boolean);
        b(parambhjq, localMessageForPic);
        a(parambhjq, localMessageForPic);
        a(localMessageForPic, parambhjq);
        a(parambhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, localMessageForPic);
        a(parambhjq, localMessageForPic);
        a(parambhjq);
        c(paramChatMessage, parambhjq);
        b(paramChatMessage, parambhjq);
        c(parambhjq, this.jdField_a_of_type_AndroidContentContext);
      }
      else
      {
        paramafrk.getClass();
        if (i != 4)
        {
          paramafrk.getClass();
          if (i != 5) {}
        }
        else
        {
          a(parambhjq, paramafrk.jdField_a_of_type_Boolean);
          b(parambhjq, localMessageForPic);
          a(parambhjq, localMessageForPic);
          a(parambhjq);
          a(parambhjq, localMessageForPic);
          c(parambhjq, this.jdField_a_of_type_AndroidContentContext);
          continue;
        }
        paramafrk.getClass();
        if (i == 3)
        {
          parambhjq.a(2131364266, this.jdField_a_of_type_AndroidContentContext.getString(2131690755), 2130838980);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().isMutiSendingPics(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
            parambhjq.a(2131364254, this.jdField_a_of_type_AndroidContentContext.getString(2131690754), 2130838979);
          }
          this.g = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().pauseSendingPics(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
        }
      }
    }
  }
  
  protected void b(bhjq parambhjq, MessageForPic paramMessageForPic) {}
  
  protected void b(MessageForPic paramMessageForPic)
  {
    super.d(paramMessageForPic);
  }
  
  protected abstract void b(MessageForPic paramMessageForPic, agql paramagql);
  
  protected void b(MessageForPic paramMessageForPic, agql paramagql, View paramView, boolean paramBoolean)
  {
    if ((paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) && (!this.jdField_a_of_type_Axjk.a(paramMessageForPic)))
    {
      paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
      paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramMessageForPic.frienduin + paramMessageForPic.uniseq);
      paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramMessageForPic.frienduin + paramMessageForPic.uniseq);
      paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)paramagql.jdField_a_of_type_AndroidViewView).removeView(paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramagql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
    Object localObject = new agqk(paramMessageForPic);
    URL localURL = ((agqk)localObject).a;
    int[] arrayOfInt = new int[2];
    int[] tmp140_138 = arrayOfInt;
    tmp140_138[0] = 0;
    int[] tmp144_140 = tmp140_138;
    tmp144_140[1] = 0;
    tmp144_140;
    if ((paramagql.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramagql.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(localURL)))
    {
      if (paramagql.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        QLog.d("PicItemBuilder", 2, "holder.d=" + paramagql.jdField_a_of_type_ComTencentImageURLDrawable.getURL() + "==url=" + localURL);
      }
      URLDrawable localURLDrawable = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPic, paramagql.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, arrayOfInt, (agqk)localObject);
      paramagql.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(localURLDrawable);
      paramagql.jdField_a_of_type_ComTencentImageURLDrawable = localURLDrawable;
      paramagql.jdField_a_of_type_Agqk = ((agqk)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPicPreDownloader().a(paramMessageForPic, 2);
      localObject = localURLDrawable;
      if (QLog.isColorLevel())
      {
        QLog.d("PicItemBuilder", 2, "show receive pic uniseq=" + paramMessageForPic.uniseq + " url=" + localURL);
        localObject = localURLDrawable;
      }
    }
    for (;;)
    {
      if (localObject == null) {
        QLog.d("PicItemBuilder", 2, "d==null");
      }
      a(paramagql, paramBoolean, arrayOfInt, localURL);
      paramagql.jdField_a_of_type_AndroidViewView = paramView;
      return;
      localObject = paramagql.jdField_a_of_type_ComTencentImageURLDrawable;
      arrayOfInt[0] = paramagql.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
      arrayOfInt[1] = paramagql.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
    }
  }
  
  public void c(bhjq parambhjq, Context paramContext)
  {
    super.c(parambhjq, paramContext);
  }
  
  protected void c(MessageForPic paramMessageForPic)
  {
    URLDrawable localURLDrawable = URLDrawableHelper.getDrawable(URLDrawableHelper.getURL(paramMessageForPic, 1), -1, -1, null, null, false);
    localURLDrawable.setTag(paramMessageForPic);
    ahsl.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localURLDrawable, paramMessageForPic.frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080), null, paramMessageForPic.picExtraData);
  }
  
  public void d()
  {
    super.d();
    if (this.g)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().resumePendingPics(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      this.g = false;
    }
    this.f = false;
  }
  
  protected abstract void d(MessageForPic paramMessageForPic);
  
  protected void e(View paramView)
  {
    Object localObject = (agql)AIOUtils.getHolder(paramView);
    MessageForPic localMessageForPic = (MessageForPic)((agql)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    paramView = ((agql)localObject).jdField_a_of_type_ComTencentImageURLDrawable;
    if (!localMessageForPic.isSendFromLocal())
    {
      switch (paramView.getStatus())
      {
      default: 
      case 2: 
      case 0: 
        do
        {
          do
          {
            return;
            if ((bhbx.a()) && (bhbx.b() < 20971520L))
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, anvx.a(2131707605), 0).a();
              return;
            }
            localObject = PicDownloadExplicitError.getFailedTip(paramView);
            if (localObject != null)
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, (CharSequence)localObject, 0).a();
              return;
            }
          } while (!FileUtils.checkFolder(this.jdField_a_of_type_AndroidContentContext));
          paramView.restartDownload();
          return;
        } while (paramView.isDownloadStarted());
        paramView.startDownload();
        return;
      }
      b(localMessageForPic, (agql)localObject);
      return;
    }
    if (paramView.getStatus() == 2)
    {
      if ((bhbx.a()) && (bhbx.b() < 20971520L))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, anvx.a(2131707609), 0).a();
        return;
      }
      String str = PicDownloadExplicitError.getFailedTip(paramView);
      if (str != null)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
        return;
      }
      if (FileUtils.checkFolder(this.jdField_a_of_type_AndroidContentContext)) {
        paramView.restartDownload();
      }
    }
    b(localMessageForPic, (agql)localObject);
  }
  
  public void e(bhjq parambhjq, Context paramContext)
  {
    super.e(parambhjq, paramContext);
  }
  
  void e(MessageForPic paramMessageForPic)
  {
    String str = PicUploadExplicitError.getFailedTip(paramMessageForPic);
    if (str != null) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
    }
    do
    {
      return;
      if (FileUtils.fileExistsAndNotEmpty(paramMessageForPic.path))
      {
        f(paramMessageForPic);
        return;
      }
    } while (paramMessageForPic.picExtraFlag != TranDbRecord.PicDbRecord.EXTRA_FLAG_FOWARD_PHOTO);
    g(paramMessageForPic);
  }
  
  protected void h(ChatMessage paramChatMessage)
  {
    agqi localagqi = new agqi(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().cancelSendingPics(paramChatMessage.frienduin, localagqi);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800409B", "0X800409B", 0, 0, "", "", "", "");
  }
  
  protected void i(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().cancelSendingPic(paramChatMessage.frienduin, paramChatMessage.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().resumePendingPics(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    b();
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800409A", "0X800409A", 0, 0, "", "", "", "");
  }
  
  protected void j(ChatMessage paramChatMessage)
  {
    admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364522) {
      e(paramView);
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqg
 * JD-Core Version:    0.7.0.1
 */