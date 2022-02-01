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

public abstract class ahbe
  extends ahov
  implements agif
{
  public static boolean h = true;
  protected axqb a;
  protected final float b;
  boolean f = false;
  boolean g = false;
  
  public ahbe(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.b = paramContext.getResources().getDisplayMetrics().density;
    if (this.jdField_a_of_type_Axqb == null) {
      this.jdField_a_of_type_Axqb = ((axqb)paramQQAppInterface.getManager(324));
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
    if ((bhka.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003))
    {
      i = 1;
      if (i != 0) {
        break label616;
      }
    }
    label616:
    for (int i = 65537;; i = 1)
    {
      localObject = beyq.a(paramMessageForPic, i);
      localIntent.putExtra("forward_urldrawable", true);
      localIntent.putExtra("forward_urldrawable_thumb_url", ((URL)localObject).toString());
      localIntent.putExtra("FORWARD_URL_KEY", paramMessageForPic.localUUID);
      paramContext = ForwardUtils.a(paramContext, paramMessageForPic);
      localIntent.putExtra("forward_urldrawable_big_url", paramContext.getURL().toString());
      localIntent.putExtra("uinname", paramSessionInfo.d);
      localIntent.putExtra("PhotoConst.MY_UIN", paramQQAppInterface.getAccount());
      localIntent.putExtra("PhotoConst.MY_NICK", paramQQAppInterface.getCurrentNickname());
      localIntent.putExtra("is_anonymous", nlj.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString));
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1009);
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      localIntent.putExtra("key_confess_topicid", paramSessionInfo.e);
      localIntent.addFlags(603979776);
      localIntent.putExtra("FORWARD_MSG_FOR_PIC", paramMessageForPic);
      if (!bhmi.b(paramMessageForPic.path)) {
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
    if (beqz.b(paramContext))
    {
      paramContext = beqz.a(paramContext);
      paramMessageForPic = paramQQAppInterface;
      if (paramContext != null) {
        paramMessageForPic = paramContext.getAbsolutePath();
      }
    }
    for (;;)
    {
      localIntent.putExtra("forward_extra", paramMessageForPic);
      break;
      paramContext = beqz.a(beyq.a(paramMessageForPic, 65537).toString());
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
  
  static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt, ahbi paramahbi)
  {
    return new azrk(paramMessageForPic).a(paramChatThumbView).a(paramArrayOfInt).a(paramahbi).a().a();
  }
  
  private void a(bhvc parambhvc, ahbj paramahbj)
  {
    if (paramahbj.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if ((parambhvc instanceof berp))
    {
      parambhvc = (berp)parambhvc;
      int i = (int)parambhvc.c();
      switch (i)
      {
      default: 
        if (paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
        {
          paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          if (paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
            break label680;
          }
          paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
          ((RelativeLayout)paramahbj.jdField_a_of_type_AndroidViewView).removeView(paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
          paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
        }
        break;
      }
      for (;;)
      {
        if (i == 1003) {
          paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        return;
        if ((parambhvc.c()) && (!this.f))
        {
          paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          if (paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
          {
            paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
            paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
            paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
            ((RelativeLayout)paramahbj.jdField_a_of_type_AndroidViewView).removeView(paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
            paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
          }
          paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        }
        paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        if (paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) {
          break;
        }
        paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = true;
        return;
        paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        if (paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
        {
          PicProgressView localPicProgressView = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
          localPicProgressView.setRadius(12.0F, true);
          localPicProgressView.setSharpCornerCor(BubbleImageView.a);
          localPicProgressView.setShowCorner(false);
          localPicProgressView.setCustomSize(1);
          localPicProgressView.setProgressBackgroudColor(2130706432);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(6, 2131372628);
          localLayoutParams.addRule(8, 2131372628);
          localLayoutParams.addRule(5, 2131372628);
          localLayoutParams.addRule(7, 2131372628);
          ((RelativeLayout)paramahbj.jdField_a_of_type_AndroidViewView).addView(localPicProgressView, localLayoutParams);
          paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = localPicProgressView;
        }
        paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(parambhvc);
        paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
        if ((paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) && ((1001 == i) || (1002 == i))) {
          paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = false;
        }
        if (i != 1002)
        {
          paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
          paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(0);
          return;
        }
        paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a();
        paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setShowProgress(true);
        return;
        label680:
        paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
      }
    }
    if (paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)paramahbj.jdField_a_of_type_AndroidViewView).removeView(paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
    paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
  }
  
  static void a(QQAppInterface paramQQAppInterface, Context paramContext, View paramView, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramView != null) {
      paramBundle.putParcelable("KEY_THUMBNAL_BOUND", abke.a(paramView));
    }
    paramBundle.putBoolean("is_one_item", paramBoolean);
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      paramBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      paramBundle.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramBundle.putString("extra.GROUP_CODE", paramSessionInfo.b);
      paramBundle.putBoolean("extra.IS_HOT_CHAT", axug.a(paramChatMessage));
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
      paramView = (axqb)paramQQAppInterface.getManager(324);
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
      bmgb.a(paramContext, paramBundle, paramSessionInfo, aicv.a((MessageForPic)paramChatMessage), -1, i);
      while (QLog.isColorLevel())
      {
        QLog.i("PicItemBuilder", 2, "PicItemBuilder.enterImagePreview()");
        return;
        label382:
        if ((paramChatMessage instanceof MessageForTroopFile))
        {
          paramBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
          bmgb.a(paramContext, paramBundle, paramSessionInfo, aicv.a((MessageForTroopFile)paramChatMessage, paramQQAppInterface), -1, i);
        }
      }
    }
  }
  
  private void c(MessageForPic paramMessageForPic, ahbj paramahbj)
  {
    Object localObject;
    int i;
    if ((this.jdField_a_of_type_Axqb != null) && (paramMessageForPic != null) && (paramahbj != null))
    {
      paramMessageForPic = this.jdField_a_of_type_Axqb.a(paramMessageForPic.getPicDownloadInfo());
      localObject = this.jdField_a_of_type_Axqb.a(paramMessageForPic);
      if ((localObject != null) && (((axpx)localObject).d == 1))
      {
        if (((axpx)localObject).c >= 0) {
          break label318;
        }
        i = 0;
      }
    }
    for (;;)
    {
      if ((i < 100) && (!((axpx)localObject).jdField_a_of_type_Boolean) && (paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) && (((axpx)localObject).jdField_a_of_type_Axpw != null))
      {
        ((axpx)localObject).jdField_a_of_type_Axpw.a(new ahbf(this, paramahbj, paramMessageForPic));
        this.jdField_a_of_type_Axqb.a(paramMessageForPic, (axpx)localObject);
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
        ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131372628);
        ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131372628);
        ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131372628);
        ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131372628);
        ((RelativeLayout)paramahbj.jdField_a_of_type_AndroidViewView).addView(paramMessageForPic, (ViewGroup.LayoutParams)localObject);
        paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = paramMessageForPic;
        paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
        paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = false;
        paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(i);
        paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setShowProgress(true);
      }
      return;
      label318:
      if (((axpx)localObject).c > 100) {
        i = 100;
      } else {
        i = ((axpx)localObject).c;
      }
    }
  }
  
  private void f(MessageForPic paramMessageForPic)
  {
    ThreadManager.post(new BasePicItemBuilder.4(this, paramMessageForPic), 5, null, false);
    if (paramMessageForPic.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    azqu localazqu = new azqu();
    localazqu.a(paramMessageForPic.path);
    localazqu.d(5);
    localazqu.d(paramMessageForPic.frienduin);
    if (paramMessageForPic.fileSizeFlag == 1) {
      localazqu.c(beya.e);
    }
    for (;;)
    {
      localazqu.e(paramMessageForPic.senderuin);
      localazqu.c(paramMessageForPic.selfuin);
      localazqu.e(paramMessageForPic.istroop);
      localazqu.l(paramMessageForPic.getConfessTopicId());
      localazqu.jdField_i_of_type_Int = paramMessageForPic.extLong;
      localazqu.jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
      Object localObject = new azqv();
      ((azqv)localObject).jdField_a_of_type_Long = paramMessageForPic.msgseq;
      ((azqv)localObject).jdField_b_of_type_Long = paramMessageForPic.shmsgseq;
      ((azqv)localObject).c = paramMessageForPic.msgUid;
      localazqu.a((azqv)localObject);
      localazqu.b(paramMessageForPic.uniseq);
      ((bbnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPic.uniseq);
      localObject = azqb.a(4, 5);
      ((azqk)localObject).a(localazqu.a());
      ((azqk)localObject).a = paramMessageForPic.picExtraData;
      azqb.a((azqk)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      localazqu.c(beya.d);
    }
  }
  
  private void g(MessageForPic paramMessageForPic)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.selfuin, paramMessageForPic.uniseq);
    if ((localObject1 != null) && ((localObject1 instanceof beru)))
    {
      ((beru)localObject1).aN_();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
    if (paramMessageForPic.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    localObject1 = new azqf();
    Object localObject2 = new azqu();
    ((azqu)localObject2).d(1009);
    ((azqu)localObject2).a(paramMessageForPic.path);
    ((azqu)localObject2).e(paramMessageForPic.istroop);
    ((azqu)localObject2).c(paramMessageForPic.selfuin);
    ((azqu)localObject2).e(paramMessageForPic.senderuin);
    ((azqu)localObject2).d(paramMessageForPic.frienduin);
    ((azqu)localObject2).jdField_i_of_type_Int = paramMessageForPic.extLong;
    ((azqu)localObject2).jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
    ((azqu)localObject2).c(beya.f);
    ((azqu)localObject2).b(paramMessageForPic.uniseq);
    ((azqf)localObject1).jdField_a_of_type_Azqt = ((azqu)localObject2).a();
    if ((!bhmi.b(paramMessageForPic.path)) && ((paramMessageForPic.picExtraObject instanceof bevt)))
    {
      localObject2 = (bevt)paramMessageForPic.picExtraObject;
      azqe localazqe = new azqe();
      localazqe.a(1009);
      localazqe.a(paramMessageForPic.selfuin);
      localazqe.b(((bevt)localObject2).jdField_a_of_type_JavaLangString);
      localazqe.b(((bevt)localObject2).jdField_a_of_type_Int);
      localazqe.c(((bevt)localObject2).b);
      localazqe.a(((bevt)localObject2).jdField_a_of_type_Long);
      localazqe.d(paramMessageForPic.md5);
      localazqe.c(paramMessageForPic.issend);
      ((azqf)localObject1).jdField_a_of_type_Azqd = localazqe.a();
    }
    ((bbnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPic.uniseq);
    paramMessageForPic = azqb.a(3, 1009);
    paramMessageForPic.a((azqf)localObject1);
    azqb.a(paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aggk a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (ahbj)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  public aggl a()
  {
    return new ahbj(this);
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    boolean bool2 = true;
    paramBaseChatItemLayout = (MessageForPic)paramChatMessage;
    boolean bool3 = bmgb.a(paramBaseChatItemLayout.imageType);
    ahbj localahbj;
    try
    {
      localahbj = (ahbj)paramaggl;
      if (localahbj == null) {
        return paramView;
      }
    }
    catch (Exception paramChatMessage)
    {
      QLog.e("PicItemBuilder", 2, "picitem holer Exception e= " + paramChatMessage);
      throw new ClassCastException("picitem holer Exception e= " + paramChatMessage);
    }
    paramaggl = paramView;
    int i;
    if (paramView == null)
    {
      paramaggl = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramaggl.setId(2131372628);
      paramView = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      i = Build.VERSION.SDK_INT;
      if ((i == 19) || (i == 18)) {
        paramView.e = true;
      }
      paramView.setId(2131372628);
      paramView.setAdjustViewBounds(true);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(12.0F);
      paramView.d(false);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(15);
      paramaggl.addView(paramView, localLayoutParams);
      localahbj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramView;
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(7, 2131372628);
      localLayoutParams.addRule(8, 2131372628);
      paramaggl.addView(paramView, localLayoutParams);
      localahbj.jdField_a_of_type_AndroidWidgetImageView = paramView;
      paramaggl.setOnClickListener(this);
      super.a(paramaggl, paramagjk);
    }
    paramView = localahbj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
    boolean bool1;
    if (!ahng.a(paramBaseChatItemLayout))
    {
      bool1 = true;
      i = beqw.a(bool3, bool1);
      if (ahng.a(paramBaseChatItemLayout)) {
        break label527;
      }
      bool1 = true;
      label320:
      int j = beqw.b(bool3, bool1);
      paramView.setMaxWidth(i);
      paramView.setMaxHeight(i);
      paramView.setMinimumWidth(j);
      paramView.setMinimumHeight(j);
      if ((ahng.a(paramBaseChatItemLayout)) || (bool3)) {
        break label533;
      }
      bool1 = bool2;
      label370:
      paramView.setShowEdge(bool1);
      if (e) {
        paramView.setContentDescription(anzj.a(2131707027));
      }
      if (paramBaseChatItemLayout.isSendFromLocal()) {
        break label539;
      }
      b(paramBaseChatItemLayout, localahbj, paramaggl, bool3);
      label411:
      if (QLog.isColorLevel())
      {
        paramagjk = new StringBuilder().append("getView ");
        if (localahbj.jdField_a_of_type_Ahbi == null) {
          break label553;
        }
      }
    }
    label527:
    label533:
    label539:
    label553:
    for (paramView = localahbj.jdField_a_of_type_Ahbi.toString();; paramView = "")
    {
      QLog.d("PicItemBuilder", 2, paramView + ", isDynamic=" + bool3 + ", thumbWidth=" + paramBaseChatItemLayout.thumbWidth + ", thumbHeight=" + paramBaseChatItemLayout.thumbHeight);
      a(paramChatMessage, paramaggl, this);
      c(paramBaseChatItemLayout, localahbj);
      return paramaggl;
      bool1 = false;
      break;
      bool1 = false;
      break label320;
      bool1 = false;
      break label370;
      a(paramBaseChatItemLayout, localahbj, paramaggl, bool3);
      break label411;
    }
  }
  
  public bhuk a(bhuk parambhuk, ChatMessage paramChatMessage, aghd paramaghd)
  {
    paramChatMessage = (MessageForPic)paramChatMessage;
    paramaghd = (ahbj)paramaghd;
    int i = paramaghd.a(paramChatMessage);
    paramaghd.getClass();
    if (i != 1)
    {
      paramaghd.getClass();
      if (i != 2)
      {
        paramaghd.getClass();
        if (i != 4)
        {
          paramaghd.getClass();
          if (i != 5) {
            return parambhuk;
          }
        }
      }
    }
    a(parambhuk);
    a(parambhuk, paramChatMessage);
    b(parambhuk);
    return parambhuk;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bhnt.a(paramChatMessage.issend)) {
      return anzj.a(2131707028);
    }
    return anzj.a(2131707029);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForPic localMessageForPic;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForPic)))
    {
      localMessageForPic = (MessageForPic)paramChatMessage;
      if (paramInt == 2131367078) {
        d(localMessageForPic);
      }
    }
    else
    {
      return;
    }
    if (paramInt == 2131362195)
    {
      c(localMessageForPic);
      return;
    }
    if (paramInt == 2131365352)
    {
      j(paramChatMessage);
      return;
    }
    if (paramInt == 2131371530)
    {
      b(localMessageForPic);
      return;
    }
    if (paramInt == 2131376606)
    {
      e(localMessageForPic);
      return;
    }
    if (paramInt == 2131366320)
    {
      a(localMessageForPic);
      return;
    }
    if (paramInt == 2131364167)
    {
      i(paramChatMessage);
      return;
    }
    if (paramInt == 2131364157)
    {
      h(paramChatMessage);
      return;
    }
    if (paramInt == 2131371519)
    {
      super.d(paramChatMessage);
      return;
    }
    if (paramInt == 2131371487)
    {
      super.a(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  void a(ahbj paramahbj, boolean paramBoolean, int[] paramArrayOfInt, URL paramURL) {}
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (agej.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForPic)((ahbj)agej.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    } while (!paramView.isSendFromLocal());
    blir localblir = (blir)blji.a(this.jdField_a_of_type_AndroidContentContext, null);
    localblir.a(2131689933, 5);
    localblir.c(2131690580);
    localblir.a(new ahbh(this, paramView, localblir));
    localblir.show();
  }
  
  public void a(View paramView, bete parambete, int paramInt1, int paramInt2)
  {
    ahbj localahbj = (ahbj)agej.a(paramView);
    if (localahbj == null) {
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
            paramView = (MessageForPic)localahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if ((localahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (paramView == null))
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
            if ((paramInt1 == 2003) && (parambete.jdField_b_of_type_Int == 65537))
            {
              boolean bool = bmgb.a(paramView.imageType);
              int i = localahbj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
              int j = localahbj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
              localahbj.jdField_a_of_type_ComTencentImageURLDrawable.getURL().getProtocol();
              URL localURL = beyq.a(paramView, 65537);
              a(localahbj, bool, new int[] { i, j }, localURL);
            }
          }
        } while (((parambete.jdField_b_of_type_Int != 1) && (parambete.jdField_b_of_type_Int != 131075)) || (paramInt1 == 2002) || (paramInt1 == 2001) || (paramView.uniseq != parambete.jdField_b_of_type_Long));
        bews.a(paramView.istroop, paramView.isSendFromLocal(), 65537, String.valueOf(paramView.uniseq), "PicItemBuilder.transf.in", "status:" + paramInt1 + ",retCode" + paramInt2 + "message.uniseq：" + paramView.uniseq + ",file.uniseq:" + parambete.jdField_b_of_type_Long, null);
        if (paramView.isSendFromLocal())
        {
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.frienduin, paramView.uniseq), localahbj);
          if (paramInt1 == 1005) {
            b();
          }
        }
      } while (paramInt1 != 2003);
      a(paramView, localahbj);
      paramView = ahng.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localahbj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
      localahbj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
      localahbj.jdField_a_of_type_ComTencentImageURLDrawable = paramView;
    } while (localahbj.jdField_a_of_type_ComTencentImageURLDrawable == null);
    localahbj.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
  }
  
  void a(bhuk parambhuk)
  {
    if (agej.a(1) == 1) {
      parambhuk.a(2131362195, this.jdField_a_of_type_AndroidContentContext.getString(2131692954), 2130838937);
    }
  }
  
  void a(bhuk parambhuk, MessageForPic paramMessageForPic)
  {
    if (beyq.a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPic, 65537)) {
      parambhuk.a(2131367078, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838939);
    }
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    bmko.a(paramMessageForPic).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
    bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, 0, paramMessageForPic.istroop);
  }
  
  abstract void a(MessageForPic paramMessageForPic, ahbj paramahbj);
  
  protected void a(MessageForPic paramMessageForPic, ahbj paramahbj, View paramView, boolean paramBoolean)
  {
    if (paramahbj.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      paramahbj.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
    }
    ahbi localahbi = new ahbi(paramMessageForPic);
    URL localURL = localahbi.a;
    if ((paramahbj.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramahbj.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(localURL)))
    {
      URLDrawable localURLDrawable = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPic, paramahbj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, null, localahbi);
      paramahbj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(localURLDrawable);
      paramahbj.jdField_a_of_type_ComTencentImageURLDrawable = localURLDrawable;
      paramahbj.jdField_a_of_type_Ahbi = localahbi;
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PicItemBuilder", 2, "predownloadDynamic pic uniseq=" + paramMessageForPic.uniseq + " url=" + localURL);
        }
        a(paramMessageForPic, paramahbj.jdField_a_of_type_ComTencentImageURLDrawable);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PicItemBuilder", 2, "show send pic uniseq=" + paramMessageForPic.uniseq + " url=" + localURL);
      }
    }
    paramMessageForPic = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq);
    paramahbj.jdField_a_of_type_AndroidViewView = paramView;
    a(paramMessageForPic, paramahbj);
    if (paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) {
      paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = true;
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
      if ((paramChatMessage instanceof berp))
      {
        long l = ((berp)paramChatMessage).c();
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
  
  public bhum[] a(View paramView)
  {
    paramView = (ahbj)agej.a(paramView);
    MessageForPic localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    bhuk localbhuk = new bhuk();
    if (localMessageForPic != null)
    {
      if (!localMessageForPic.isMultiMsg) {
        break label48;
      }
      a(localbhuk, localMessageForPic, paramView);
    }
    for (;;)
    {
      return localbhuk.a();
      label48:
      b(localbhuk, localMessageForPic, paramView);
      super.a(localbhuk, this.jdField_a_of_type_AndroidContentContext, localMessageForPic, true);
    }
  }
  
  public bhuk b(bhuk parambhuk, ChatMessage paramChatMessage, aghd paramaghd)
  {
    MessageForPic localMessageForPic = (MessageForPic)paramChatMessage;
    paramaghd = (ahbj)paramaghd;
    this.f = true;
    int i = paramaghd.a(localMessageForPic);
    paramaghd.getClass();
    if (i == 1)
    {
      a(parambhuk);
      b(parambhuk, localMessageForPic);
      a(parambhuk, localMessageForPic);
      a(localMessageForPic, parambhuk);
      a(parambhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPic);
      a(parambhuk, localMessageForPic);
      b(parambhuk);
      c(paramChatMessage, parambhuk);
      b(paramChatMessage, parambhuk);
      c(parambhuk, this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
      return parambhuk;
      paramaghd.getClass();
      if (i == 2)
      {
        a(parambhuk);
        b(parambhuk, localMessageForPic);
        a(parambhuk, localMessageForPic);
        a(localMessageForPic, parambhuk);
        a(parambhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPic);
        a(parambhuk, localMessageForPic);
        b(parambhuk);
        c(paramChatMessage, parambhuk);
        b(paramChatMessage, parambhuk);
        c(parambhuk, this.jdField_a_of_type_AndroidContentContext);
      }
      else
      {
        paramaghd.getClass();
        if (i != 4)
        {
          paramaghd.getClass();
          if (i != 5) {}
        }
        else
        {
          a(parambhuk);
          b(parambhuk, localMessageForPic);
          a(parambhuk, localMessageForPic);
          b(parambhuk);
          a(parambhuk, localMessageForPic);
          c(parambhuk, this.jdField_a_of_type_AndroidContentContext);
          continue;
        }
        paramaghd.getClass();
        if (i == 3)
        {
          parambhuk.a(2131364167, this.jdField_a_of_type_AndroidContentContext.getString(2131690638), 2130838928);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            parambhuk.a(2131364157, this.jdField_a_of_type_AndroidContentContext.getString(2131690637), 2130838927);
          }
          this.g = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  void b(bhuk parambhuk)
  {
    if (agej.a(5) == 1) {
      parambhuk.a(2131366320, this.jdField_a_of_type_AndroidContentContext.getString(2131691990), 2130838938);
    }
  }
  
  protected void b(bhuk parambhuk, MessageForPic paramMessageForPic) {}
  
  protected void b(MessageForPic paramMessageForPic)
  {
    super.d(paramMessageForPic);
  }
  
  protected abstract void b(MessageForPic paramMessageForPic, ahbj paramahbj);
  
  protected void b(MessageForPic paramMessageForPic, ahbj paramahbj, View paramView, boolean paramBoolean)
  {
    if ((paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) && (!this.jdField_a_of_type_Axqb.a(paramMessageForPic)))
    {
      paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
      paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramMessageForPic.frienduin + paramMessageForPic.uniseq);
      paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramMessageForPic.frienduin + paramMessageForPic.uniseq);
      paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)paramahbj.jdField_a_of_type_AndroidViewView).removeView(paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
    Object localObject = new ahbi(paramMessageForPic);
    URL localURL = ((ahbi)localObject).a;
    int[] arrayOfInt = new int[2];
    int[] tmp140_138 = arrayOfInt;
    tmp140_138[0] = 0;
    int[] tmp144_140 = tmp140_138;
    tmp144_140[1] = 0;
    tmp144_140;
    if ((paramahbj.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramahbj.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(localURL)))
    {
      if (paramahbj.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        QLog.d("PicItemBuilder", 2, "holder.d=" + paramahbj.jdField_a_of_type_ComTencentImageURLDrawable.getURL() + "==url=" + localURL);
      }
      URLDrawable localURLDrawable = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPic, paramahbj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, arrayOfInt, (ahbi)localObject);
      paramahbj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(localURLDrawable);
      paramahbj.jdField_a_of_type_ComTencentImageURLDrawable = localURLDrawable;
      paramahbj.jdField_a_of_type_Ahbi = ((ahbi)localObject);
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
      a(paramahbj, paramBoolean, arrayOfInt, localURL);
      paramahbj.jdField_a_of_type_AndroidViewView = paramView;
      return;
      localObject = paramahbj.jdField_a_of_type_ComTencentImageURLDrawable;
      arrayOfInt[0] = paramahbj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
      arrayOfInt[1] = paramahbj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
    }
  }
  
  public void c(bhuk parambhuk, Context paramContext)
  {
    super.c(parambhuk, paramContext);
  }
  
  protected void c(MessageForPic paramMessageForPic)
  {
    URLDrawable localURLDrawable = beyq.a(beyq.a(paramMessageForPic, 1), -1, -1, null, null, false);
    localURLDrawable.setTag(paramMessageForPic);
    aicv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localURLDrawable, paramMessageForPic.frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011), null, paramMessageForPic.picExtraData);
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
  
  protected void e(View paramView)
  {
    Object localObject = (ahbj)agej.a(paramView);
    MessageForPic localMessageForPic = (MessageForPic)((ahbj)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    paramView = ((ahbj)localObject).jdField_a_of_type_ComTencentImageURLDrawable;
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
            if ((bhjx.a()) && (bhjx.b() < 20971520L))
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, anzj.a(2131707026), 0).a();
              return;
            }
            localObject = PicDownloadExplicitError.getFailedTip(paramView);
            if (localObject != null)
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, (CharSequence)localObject, 0).a();
              return;
            }
          } while (!bhmi.a(this.jdField_a_of_type_AndroidContentContext));
          paramView.restartDownload();
          return;
        } while (paramView.isDownloadStarted());
        paramView.startDownload();
        return;
      }
      b(localMessageForPic, (ahbj)localObject);
      return;
    }
    if (paramView.getStatus() == 2)
    {
      if ((bhjx.a()) && (bhjx.b() < 20971520L))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, anzj.a(2131707030), 0).a();
        return;
      }
      String str = PicDownloadExplicitError.getFailedTip(paramView);
      if (str != null)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
        return;
      }
      if (bhmi.a(this.jdField_a_of_type_AndroidContentContext)) {
        paramView.restartDownload();
      }
    }
    b(localMessageForPic, (ahbj)localObject);
  }
  
  public void e(bhuk parambhuk, Context paramContext)
  {
    super.e(parambhuk, paramContext);
  }
  
  void e(MessageForPic paramMessageForPic)
  {
    String str = bezg.a(paramMessageForPic);
    if (str != null) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
    }
    do
    {
      return;
      if (bhmi.b(paramMessageForPic.path))
      {
        f(paramMessageForPic);
        return;
      }
    } while (paramMessageForPic.picExtraFlag != beya.f);
    g(paramMessageForPic);
  }
  
  protected void h(ChatMessage paramChatMessage)
  {
    ahbg localahbg = new ahbg(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, localahbg);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800409B", "0X800409B", 0, 0, "", "", "", "");
  }
  
  protected void i(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    b();
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800409A", "0X800409A", 0, 0, "", "", "", "");
  }
  
  protected void j(ChatMessage paramChatMessage)
  {
    aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364423) {
      e(paramView);
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbe
 * JD-Core Version:    0.7.0.1
 */