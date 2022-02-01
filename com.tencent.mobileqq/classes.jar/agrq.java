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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class agrq
  extends ahfj
  implements afyl
{
  public static boolean h = true;
  protected awxi a;
  protected final float b;
  boolean f = false;
  boolean g = false;
  
  public agrq(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    e();
    this.b = paramContext.getResources().getDisplayMetrics().density;
    if (this.jdField_a_of_type_Awxi == null) {
      this.jdField_a_of_type_Awxi = ((awxi)paramQQAppInterface.getManager(324));
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
    ((Bundle)localObject).putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
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
    if ((bgjz.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003))
    {
      i = 1;
      if (i != 0) {
        break label616;
      }
    }
    label616:
    for (int i = 65537;; i = 1)
    {
      localObject = bdzx.a(paramMessageForPic, i);
      localIntent.putExtra("forward_urldrawable", true);
      localIntent.putExtra("forward_urldrawable_thumb_url", ((URL)localObject).toString());
      localIntent.putExtra("FORWARD_URL_KEY", paramMessageForPic.localUUID);
      paramContext = ForwardUtils.a(paramContext, paramMessageForPic);
      localIntent.putExtra("forward_urldrawable_big_url", paramContext.getURL().toString());
      localIntent.putExtra("uinname", paramSessionInfo.d);
      localIntent.putExtra("PhotoConst.MY_UIN", paramQQAppInterface.getAccount());
      localIntent.putExtra("PhotoConst.MY_NICK", paramQQAppInterface.getCurrentNickname());
      localIntent.putExtra("is_anonymous", njo.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString));
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1009);
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      localIntent.putExtra("key_confess_topicid", paramSessionInfo.e);
      localIntent.addFlags(603979776);
      localIntent.putExtra("FORWARD_MSG_FOR_PIC", paramMessageForPic);
      if (!bgmg.b(paramMessageForPic.path)) {
        break label622;
      }
      localIntent.putExtra("forward_extra", paramMessageForPic.path);
      localIntent.putExtra("direct_send_if_dataline_forward", true);
      localIntent.putExtra("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
      localIntent.putExtra("BUSI_TYPE", 1009);
      return localIntent;
      i = 0;
      break;
    }
    label622:
    paramQQAppInterface = null;
    paramContext = paramContext.getURL().toString();
    if (bdsh.b(paramContext))
    {
      paramContext = bdsh.a(paramContext);
      paramMessageForPic = paramQQAppInterface;
      if (paramContext != null) {
        paramMessageForPic = paramContext.getAbsolutePath();
      }
    }
    for (;;)
    {
      localIntent.putExtra("forward_extra", paramMessageForPic);
      break;
      paramContext = bdsh.a(bdzx.a(paramMessageForPic, 65537).toString());
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
  
  static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt, agru paramagru)
  {
    return new ayyx(paramMessageForPic).a(paramChatThumbView).a(paramArrayOfInt).a(paramagru).a().a();
  }
  
  private void a(bguz parambguz, agrv paramagrv)
  {
    if (paramagrv.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if ((parambguz instanceof bdsx))
    {
      parambguz = (bdsx)parambguz;
      int i = (int)parambguz.c();
      switch (i)
      {
      default: 
        if (paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
        {
          paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          if (paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
            break label680;
          }
          paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
          ((RelativeLayout)paramagrv.jdField_a_of_type_AndroidViewView).removeView(paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
          paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
        }
        break;
      }
      for (;;)
      {
        if (i == 1003) {
          paramagrv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        paramagrv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        return;
        if ((parambguz.c()) && (!this.f))
        {
          paramagrv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          if (paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
          {
            paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
            paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
            paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
            ((RelativeLayout)paramagrv.jdField_a_of_type_AndroidViewView).removeView(paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
            paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
          }
          paramagrv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        }
        paramagrv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        if (paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) {
          break;
        }
        paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = true;
        return;
        paramagrv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        if (paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
        {
          PicProgressView localPicProgressView = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
          localPicProgressView.setRadius(12.0F, true);
          localPicProgressView.setSharpCornerCor(BubbleImageView.a);
          localPicProgressView.setShowCorner(false);
          localPicProgressView.setCustomSize(1);
          localPicProgressView.setProgressBackgroudColor(2130706432);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(6, 2131372517);
          localLayoutParams.addRule(8, 2131372517);
          localLayoutParams.addRule(5, 2131372517);
          localLayoutParams.addRule(7, 2131372517);
          ((RelativeLayout)paramagrv.jdField_a_of_type_AndroidViewView).addView(localPicProgressView, localLayoutParams);
          paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = localPicProgressView;
        }
        paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(parambguz);
        paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
        if ((paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) && ((1001 == i) || (1002 == i))) {
          paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = false;
        }
        if (i != 1002)
        {
          paramagrv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
          paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(0);
          return;
        }
        paramagrv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a();
        paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setShowProgress(true);
        return;
        label680:
        paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
      }
    }
    if (paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)paramagrv.jdField_a_of_type_AndroidViewView).removeView(paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
    paramagrv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
  }
  
  static void a(QQAppInterface paramQQAppInterface, Context paramContext, View paramView, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramView != null) {
      paramBundle.putParcelable("KEY_THUMBNAL_BOUND", abga.a(paramView));
    }
    paramBundle.putBoolean("is_one_item", paramBoolean);
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      paramBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      paramBundle.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramBundle.putString("extra.GROUP_CODE", paramSessionInfo.b);
      paramBundle.putBoolean("extra.IS_HOT_CHAT", axbp.a(paramChatMessage));
    }
    String str;
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000))
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
      paramView = (awxi)paramQQAppInterface.getManager(324);
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
    paramBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
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
      bley.a(paramContext, paramBundle, paramSessionInfo, ahth.a((MessageForPic)paramChatMessage), -1, i);
      while (QLog.isColorLevel())
      {
        QLog.i("PicItemBuilder", 2, "PicItemBuilder.enterImagePreview()");
        return;
        label382:
        if ((paramChatMessage instanceof MessageForTroopFile))
        {
          paramBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
          bley.a(paramContext, paramBundle, paramSessionInfo, ahth.a((MessageForTroopFile)paramChatMessage, paramQQAppInterface), -1, i);
        }
      }
    }
  }
  
  private void c(MessageForPic paramMessageForPic, agrv paramagrv)
  {
    Object localObject;
    int i;
    if ((this.jdField_a_of_type_Awxi != null) && (paramMessageForPic != null) && (paramagrv != null))
    {
      paramMessageForPic = this.jdField_a_of_type_Awxi.a(paramMessageForPic.getPicDownloadInfo());
      localObject = this.jdField_a_of_type_Awxi.a(paramMessageForPic);
      if ((localObject != null) && (((awxe)localObject).d == 1))
      {
        if (((awxe)localObject).c >= 0) {
          break label318;
        }
        i = 0;
      }
    }
    for (;;)
    {
      if ((i < 100) && (!((awxe)localObject).jdField_a_of_type_Boolean) && (paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) && (((awxe)localObject).jdField_a_of_type_Awxd != null))
      {
        ((awxe)localObject).jdField_a_of_type_Awxd.a(new agrr(this, paramagrv, paramMessageForPic));
        this.jdField_a_of_type_Awxi.a(paramMessageForPic, (awxe)localObject);
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
        ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131372517);
        ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131372517);
        ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131372517);
        ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131372517);
        ((RelativeLayout)paramagrv.jdField_a_of_type_AndroidViewView).addView(paramMessageForPic, (ViewGroup.LayoutParams)localObject);
        paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = paramMessageForPic;
        paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
        paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = false;
        paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(i);
        paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setShowProgress(true);
      }
      return;
      label318:
      if (((awxe)localObject).c > 100) {
        i = 100;
      } else {
        i = ((awxe)localObject).c;
      }
    }
  }
  
  private void f(MessageForPic paramMessageForPic)
  {
    ThreadManager.post(new BasePicItemBuilder.4(this, paramMessageForPic), 5, null, false);
    if (paramMessageForPic.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    ayyh localayyh = new ayyh();
    localayyh.a(paramMessageForPic.path);
    localayyh.d(5);
    localayyh.d(paramMessageForPic.frienduin);
    if (paramMessageForPic.fileSizeFlag == 1) {
      localayyh.c(bdzh.e);
    }
    for (;;)
    {
      localayyh.e(paramMessageForPic.senderuin);
      localayyh.c(paramMessageForPic.selfuin);
      localayyh.e(paramMessageForPic.istroop);
      localayyh.l(paramMessageForPic.getConfessTopicId());
      localayyh.jdField_i_of_type_Int = paramMessageForPic.extLong;
      localayyh.jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
      Object localObject = new ayyi();
      ((ayyi)localObject).jdField_a_of_type_Long = paramMessageForPic.msgseq;
      ((ayyi)localObject).jdField_b_of_type_Long = paramMessageForPic.shmsgseq;
      ((ayyi)localObject).c = paramMessageForPic.msgUid;
      localayyh.a((ayyi)localObject);
      localayyh.b(paramMessageForPic.uniseq);
      ((bauy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPic.uniseq);
      localObject = ayxn.a(4, 5);
      ((ayxx)localObject).a(localayyh.a());
      ((ayxx)localObject).a = paramMessageForPic.picExtraData;
      ayxn.a((ayxx)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      localayyh.c(bdzh.d);
    }
  }
  
  private void g(MessageForPic paramMessageForPic)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.selfuin, paramMessageForPic.uniseq);
    if ((localObject1 != null) && ((localObject1 instanceof bdtc)))
    {
      ((bdtc)localObject1).aN_();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
    if (paramMessageForPic.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    localObject1 = new ayxr();
    Object localObject2 = new ayyh();
    ((ayyh)localObject2).d(1009);
    ((ayyh)localObject2).a(paramMessageForPic.path);
    ((ayyh)localObject2).e(paramMessageForPic.istroop);
    ((ayyh)localObject2).c(paramMessageForPic.selfuin);
    ((ayyh)localObject2).e(paramMessageForPic.senderuin);
    ((ayyh)localObject2).d(paramMessageForPic.frienduin);
    ((ayyh)localObject2).jdField_i_of_type_Int = paramMessageForPic.extLong;
    ((ayyh)localObject2).jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
    ((ayyh)localObject2).c(bdzh.f);
    ((ayyh)localObject2).b(paramMessageForPic.uniseq);
    ((ayxr)localObject1).jdField_a_of_type_Ayyg = ((ayyh)localObject2).a();
    if ((!bgmg.b(paramMessageForPic.path)) && ((paramMessageForPic.picExtraObject instanceof bdxa)))
    {
      localObject2 = (bdxa)paramMessageForPic.picExtraObject;
      ayxq localayxq = new ayxq();
      localayxq.a(1009);
      localayxq.a(paramMessageForPic.selfuin);
      localayxq.b(((bdxa)localObject2).jdField_a_of_type_JavaLangString);
      localayxq.b(((bdxa)localObject2).jdField_a_of_type_Int);
      localayxq.c(((bdxa)localObject2).b);
      localayxq.a(((bdxa)localObject2).jdField_a_of_type_Long);
      localayxq.d(paramMessageForPic.md5);
      localayxq.c(paramMessageForPic.issend);
      ((ayxr)localObject1).jdField_a_of_type_Ayxp = localayxq.a();
    }
    ((bauy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPic.uniseq);
    paramMessageForPic = ayxn.a(3, 1009);
    paramMessageForPic.a((ayxr)localObject1);
    ayxn.a(paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afwq a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (agrv)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  public afwr a()
  {
    return new agrv(this);
  }
  
  public View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    boolean bool1 = true;
    paramBaseChatItemLayout = (MessageForPic)paramChatMessage;
    boolean bool2 = bley.a(paramBaseChatItemLayout.imageType);
    agrv localagrv;
    try
    {
      localagrv = (agrv)paramafwr;
      if (localagrv == null) {
        return paramView;
      }
    }
    catch (Exception paramChatMessage)
    {
      QLog.e("PicItemBuilder", 2, "picitem holer Exception e= " + paramChatMessage);
      throw new ClassCastException("picitem holer Exception e= " + paramChatMessage);
    }
    paramafwr = paramView;
    if (paramView == null)
    {
      paramafwr = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramafwr.setId(2131372517);
      paramView = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      i = Build.VERSION.SDK_INT;
      if ((i == 19) || (i == 18)) {
        paramView.e = true;
      }
      paramView.setId(2131372517);
      paramView.setAdjustViewBounds(true);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(12.0F);
      paramView.d(false);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(15);
      paramafwr.addView(paramView, localLayoutParams);
      localagrv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramView;
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(7, 2131372517);
      localLayoutParams.addRule(8, 2131372517);
      paramafwr.addView(paramView, localLayoutParams);
      localagrv.jdField_a_of_type_AndroidWidgetImageView = paramView;
      paramafwr.setOnClickListener(this);
      super.a(paramafwr, paramafzq);
    }
    paramView = localagrv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
    int i = bdzx.a(bool2);
    int j = bdzx.b(bool2);
    paramView.setMaxWidth(i);
    paramView.setMaxHeight(i);
    paramView.setMinimumWidth(j);
    paramView.setMinimumHeight(j);
    if ((!ahdu.a(paramBaseChatItemLayout)) && (!bool2))
    {
      paramView.setShowEdge(bool1);
      if (e) {
        paramView.setContentDescription(anni.a(2131706918));
      }
      if (paramBaseChatItemLayout.isSendFromLocal()) {
        break label454;
      }
      b(paramBaseChatItemLayout, localagrv, paramafwr, bool2);
      label381:
      if (QLog.isColorLevel()) {
        if ("getview " + localagrv.jdField_a_of_type_Agru == null) {
          break label468;
        }
      }
    }
    label454:
    label468:
    for (paramView = localagrv.jdField_a_of_type_Agru.toString();; paramView = "isDynamic=" + bool2 + "thumbWidth=" + paramBaseChatItemLayout.thumbWidth + "thumbHeight=" + paramBaseChatItemLayout.thumbHeight)
    {
      QLog.d("PicItemBuilder", 2, paramView);
      a(paramChatMessage, paramafwr, this);
      c(paramBaseChatItemLayout, localagrv);
      return paramafwr;
      bool1 = false;
      break;
      a(paramBaseChatItemLayout, localagrv, paramafwr, bool2);
      break label381;
    }
  }
  
  public bguh a(bguh parambguh, ChatMessage paramChatMessage, afxj paramafxj)
  {
    paramChatMessage = (MessageForPic)paramChatMessage;
    paramafxj = (agrv)paramafxj;
    int i = paramafxj.a(paramChatMessage);
    paramafxj.getClass();
    if (i != 1)
    {
      paramafxj.getClass();
      if (i != 2)
      {
        paramafxj.getClass();
        if (i != 4)
        {
          paramafxj.getClass();
          if (i != 5) {
            return parambguh;
          }
        }
      }
    }
    a(parambguh);
    a(parambguh, paramChatMessage);
    b(parambguh);
    return parambguh;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bgnr.a(paramChatMessage.issend)) {
      return anni.a(2131706919);
    }
    return anni.a(2131706920);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForPic localMessageForPic;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForPic)))
    {
      localMessageForPic = (MessageForPic)paramChatMessage;
      if (paramInt == 2131367027) {
        d(localMessageForPic);
      }
    }
    else
    {
      return;
    }
    if (paramInt == 2131362186)
    {
      c(localMessageForPic);
      return;
    }
    if (paramInt == 2131365308)
    {
      j(paramChatMessage);
      return;
    }
    if (paramInt == 2131371422)
    {
      b(localMessageForPic);
      return;
    }
    if (paramInt == 2131376474)
    {
      e(localMessageForPic);
      return;
    }
    if (paramInt == 2131366271)
    {
      a(localMessageForPic);
      return;
    }
    if (paramInt == 2131364126)
    {
      i(paramChatMessage);
      return;
    }
    if (paramInt == 2131364116)
    {
      h(paramChatMessage);
      return;
    }
    if (paramInt == 2131371411)
    {
      super.d(paramChatMessage);
      return;
    }
    if (paramInt == 2131371380)
    {
      super.a(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  void a(agrv paramagrv, boolean paramBoolean, int[] paramArrayOfInt, URL paramURL) {}
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (afur.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForPic)((agrv)afur.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    } while (!paramView.isSendFromLocal());
    bkho localbkho = (bkho)bkif.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbkho.a(2131689926, 5);
    localbkho.c(2131690582);
    localbkho.a(new agrt(this, paramView, localbkho));
    localbkho.show();
  }
  
  public void a(View paramView, bduk parambduk, int paramInt1, int paramInt2)
  {
    agrv localagrv = (agrv)afur.a(paramView);
    if (localagrv == null) {
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
            paramView = (MessageForPic)localagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if ((localagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (paramView == null))
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
            if ((paramInt1 == 2003) && (parambduk.jdField_b_of_type_Int == 65537))
            {
              boolean bool = bley.a(paramView.imageType);
              int i = localagrv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
              int j = localagrv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
              localagrv.jdField_a_of_type_ComTencentImageURLDrawable.getURL().getProtocol();
              URL localURL = bdzx.a(paramView, 65537);
              a(localagrv, bool, new int[] { i, j }, localURL);
            }
          }
        } while (((parambduk.jdField_b_of_type_Int != 1) && (parambduk.jdField_b_of_type_Int != 131075)) || (paramInt1 == 2002) || (paramInt1 == 2001) || (paramView.uniseq != parambduk.jdField_b_of_type_Long));
        bdxz.a(paramView.istroop, paramView.isSendFromLocal(), 65537, String.valueOf(paramView.uniseq), "PicItemBuilder.transf.in", "status:" + paramInt1 + ",retCode" + paramInt2 + "message.uniseq：" + paramView.uniseq + ",file.uniseq:" + parambduk.jdField_b_of_type_Long, null);
        if (paramView.isSendFromLocal())
        {
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.frienduin, paramView.uniseq), localagrv);
          if (paramInt1 == 1005) {
            b();
          }
        }
      } while (paramInt1 != 2003);
      a(paramView, localagrv);
      paramView = ahdu.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localagrv.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localagrv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
      localagrv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
      localagrv.jdField_a_of_type_ComTencentImageURLDrawable = paramView;
    } while (localagrv.jdField_a_of_type_ComTencentImageURLDrawable == null);
    localagrv.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
  }
  
  void a(bguh parambguh)
  {
    if (afur.a(1) == 1) {
      parambguh.a(2131362186, this.jdField_a_of_type_AndroidContentContext.getString(2131692945), 2130838927);
    }
  }
  
  void a(bguh parambguh, MessageForPic paramMessageForPic)
  {
    if (bdzx.a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPic, 65537)) {
      parambguh.a(2131367027, this.jdField_a_of_type_AndroidContentContext.getString(2131692395), 2130838929);
    }
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    bljl.a(paramMessageForPic).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
    bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, 0, paramMessageForPic.istroop);
  }
  
  abstract void a(MessageForPic paramMessageForPic, agrv paramagrv);
  
  protected void a(MessageForPic paramMessageForPic, agrv paramagrv, View paramView, boolean paramBoolean)
  {
    if (paramagrv.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      paramagrv.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
    }
    agru localagru = new agru(paramMessageForPic);
    URL localURL = localagru.a;
    if ((paramagrv.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramagrv.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(localURL)))
    {
      URLDrawable localURLDrawable = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPic, paramagrv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, null, localagru);
      paramagrv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(localURLDrawable);
      paramagrv.jdField_a_of_type_ComTencentImageURLDrawable = localURLDrawable;
      paramagrv.jdField_a_of_type_Agru = localagru;
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PicItemBuilder", 2, "predownloadDynamic pic uniseq=" + paramMessageForPic.uniseq + " url=" + localURL);
        }
        a(paramMessageForPic, paramagrv.jdField_a_of_type_ComTencentImageURLDrawable);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PicItemBuilder", 2, "show send pic uniseq=" + paramMessageForPic.uniseq + " url=" + localURL);
      }
    }
    paramMessageForPic = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq);
    paramagrv.jdField_a_of_type_AndroidViewView = paramView;
    a(paramMessageForPic, paramagrv);
    if (paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) {
      paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = true;
    }
  }
  
  void a(MessageForPic paramMessageForPic, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getStatus() == 1) && ((paramURLDrawable.getCurrDrawable() instanceof GifDrawable))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForPic, 2);
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
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramChatMessage instanceof bdsx))
      {
        long l = ((bdsx)paramChatMessage).c();
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
  
  public bguj[] a(View paramView)
  {
    paramView = (agrv)afur.a(paramView);
    MessageForPic localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    bguh localbguh = new bguh();
    if (localMessageForPic != null)
    {
      if (!localMessageForPic.isMultiMsg) {
        break label48;
      }
      a(localbguh, localMessageForPic, paramView);
    }
    for (;;)
    {
      return localbguh.a();
      label48:
      b(localbguh, localMessageForPic, paramView);
      super.a(localbguh, this.jdField_a_of_type_AndroidContentContext, localMessageForPic, true);
    }
  }
  
  public bguh b(bguh parambguh, ChatMessage paramChatMessage, afxj paramafxj)
  {
    MessageForPic localMessageForPic = (MessageForPic)paramChatMessage;
    paramafxj = (agrv)paramafxj;
    this.f = true;
    int i = paramafxj.a(localMessageForPic);
    paramafxj.getClass();
    if (i == 1)
    {
      a(parambguh);
      b(parambguh, localMessageForPic);
      a(parambguh, localMessageForPic);
      a(localMessageForPic, parambguh);
      a(parambguh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPic);
      a(parambguh, localMessageForPic);
      b(parambguh);
      b(paramChatMessage, parambguh);
      c(parambguh, this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      e(parambguh, this.jdField_a_of_type_AndroidContentContext);
      return parambguh;
      paramafxj.getClass();
      if (i == 2)
      {
        a(parambguh);
        b(parambguh, localMessageForPic);
        a(parambguh, localMessageForPic);
        a(localMessageForPic, parambguh);
        a(parambguh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPic);
        a(parambguh, localMessageForPic);
        b(parambguh);
        b(paramChatMessage, parambguh);
        c(parambguh, this.jdField_a_of_type_AndroidContentContext);
      }
      else
      {
        paramafxj.getClass();
        if (i != 4)
        {
          paramafxj.getClass();
          if (i != 5) {}
        }
        else
        {
          a(parambguh);
          b(parambguh, localMessageForPic);
          a(parambguh, localMessageForPic);
          b(parambguh);
          a(parambguh, localMessageForPic);
          c(parambguh, this.jdField_a_of_type_AndroidContentContext);
          continue;
        }
        paramafxj.getClass();
        if (i == 3)
        {
          parambguh.a(2131364126, this.jdField_a_of_type_AndroidContentContext.getString(2131690640), 2130838918);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            parambguh.a(2131364116, this.jdField_a_of_type_AndroidContentContext.getString(2131690639), 2130838917);
          }
          this.g = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  void b(bguh parambguh)
  {
    if (afur.a(5) == 1) {
      parambguh.a(2131366271, this.jdField_a_of_type_AndroidContentContext.getString(2131691986), 2130838928);
    }
  }
  
  protected void b(bguh parambguh, MessageForPic paramMessageForPic) {}
  
  protected void b(MessageForPic paramMessageForPic)
  {
    super.d(paramMessageForPic);
  }
  
  protected abstract void b(MessageForPic paramMessageForPic, agrv paramagrv);
  
  protected void b(MessageForPic paramMessageForPic, agrv paramagrv, View paramView, boolean paramBoolean)
  {
    if ((paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) && (!this.jdField_a_of_type_Awxi.a(paramMessageForPic)))
    {
      paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
      paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramMessageForPic.frienduin + paramMessageForPic.uniseq);
      paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramMessageForPic.frienduin + paramMessageForPic.uniseq);
      paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)paramagrv.jdField_a_of_type_AndroidViewView).removeView(paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramagrv.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
    Object localObject = new agru(paramMessageForPic);
    URL localURL = ((agru)localObject).a;
    int[] arrayOfInt = new int[2];
    int[] tmp140_138 = arrayOfInt;
    tmp140_138[0] = 0;
    int[] tmp144_140 = tmp140_138;
    tmp144_140[1] = 0;
    tmp144_140;
    if ((paramagrv.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramagrv.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(localURL)))
    {
      if (paramagrv.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        QLog.d("PicItemBuilder", 2, "holder.d=" + paramagrv.jdField_a_of_type_ComTencentImageURLDrawable.getURL() + "==url=" + localURL);
      }
      URLDrawable localURLDrawable = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPic, paramagrv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, arrayOfInt, (agru)localObject);
      paramagrv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(localURLDrawable);
      paramagrv.jdField_a_of_type_ComTencentImageURLDrawable = localURLDrawable;
      paramagrv.jdField_a_of_type_Agru = ((agru)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic, 2);
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
      a(paramagrv, paramBoolean, arrayOfInt, localURL);
      paramagrv.jdField_a_of_type_AndroidViewView = paramView;
      return;
      localObject = paramagrv.jdField_a_of_type_ComTencentImageURLDrawable;
      arrayOfInt[0] = paramagrv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
      arrayOfInt[1] = paramagrv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
    }
  }
  
  public void c(bguh parambguh, Context paramContext)
  {
    super.c(parambguh, paramContext);
  }
  
  protected void c(MessageForPic paramMessageForPic)
  {
    URLDrawable localURLDrawable = bdzx.a(bdzx.a(paramMessageForPic, 1), -1, -1, null, null, false);
    localURLDrawable.setTag(paramMessageForPic);
    ahth.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localURLDrawable, paramMessageForPic.frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998), null, paramMessageForPic.picExtraData);
  }
  
  public void d()
  {
    super.d();
    if (this.g)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.g = false;
    }
    this.f = false;
  }
  
  protected abstract void d(MessageForPic paramMessageForPic);
  
  public void e() {}
  
  protected void e(View paramView)
  {
    Object localObject = (agrv)afur.a(paramView);
    MessageForPic localMessageForPic = (MessageForPic)((agrv)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    paramView = ((agrv)localObject).jdField_a_of_type_ComTencentImageURLDrawable;
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
            if ((bgjw.a()) && (bgjw.b() < 20971520L))
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, anni.a(2131706917), 0).a();
              return;
            }
            localObject = PicDownloadExplicitError.getFailedTip(paramView);
            if (localObject != null)
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, (CharSequence)localObject, 0).a();
              return;
            }
          } while (!bgmg.a(this.jdField_a_of_type_AndroidContentContext));
          paramView.restartDownload();
          return;
        } while (paramView.isDownloadStarted());
        paramView.startDownload();
        return;
      }
      b(localMessageForPic, (agrv)localObject);
      return;
    }
    if (paramView.getStatus() == 2)
    {
      if ((bgjw.a()) && (bgjw.b() < 20971520L))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, anni.a(2131706921), 0).a();
        return;
      }
      String str = PicDownloadExplicitError.getFailedTip(paramView);
      if (str != null)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
        return;
      }
      if (bgmg.a(this.jdField_a_of_type_AndroidContentContext)) {
        paramView.restartDownload();
      }
    }
    b(localMessageForPic, (agrv)localObject);
  }
  
  public void e(bguh parambguh, Context paramContext)
  {
    super.e(parambguh, paramContext);
  }
  
  void e(MessageForPic paramMessageForPic)
  {
    String str = bean.a(paramMessageForPic);
    if (str != null) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
    }
    do
    {
      return;
      if (bgmg.b(paramMessageForPic.path))
      {
        f(paramMessageForPic);
        return;
      }
    } while (paramMessageForPic.picExtraFlag != bdzh.f);
    g(paramMessageForPic);
  }
  
  protected void h(ChatMessage paramChatMessage)
  {
    agrs localagrs = new agrs(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, localagrs);
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800409B", "0X800409B", 0, 0, "", "", "", "");
  }
  
  protected void i(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    b();
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800409A", "0X800409A", 0, 0, "", "", "", "");
  }
  
  protected void j(ChatMessage paramChatMessage)
  {
    adrm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364379) {
      e(paramView);
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrq
 * JD-Core Version:    0.7.0.1
 */