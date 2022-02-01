import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.Base64;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder.3;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashSet;
import mqq.os.MqqHandler;

public class ahng
  extends ahbe
  implements aggp
{
  public static float c;
  public static int c;
  public static long c;
  public static float d;
  public static boolean i;
  public static boolean j;
  private HashSet<Long> b;
  private long d;
  
  static
  {
    jdField_c_of_type_Int = 100;
    jdField_c_of_type_Long = 1000L;
    jdField_c_of_type_Float = 0.3F;
    jdField_d_of_type_Float = 1.0F;
  }
  
  public ahng(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public static Bitmap a()
  {
    Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130838202);
    if (localDrawable != null)
    {
      if ((localDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)localDrawable).getBitmap();
      }
      if ((localDrawable instanceof SkinnableBitmapDrawable)) {
        return ((SkinnableBitmapDrawable)localDrawable).getBitmap();
      }
    }
    return null;
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic)
  {
    return a(paramContext, paramMessageForPic, null, null);
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView)
  {
    return a(paramContext, paramMessageForPic, paramChatThumbView, null);
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt)
  {
    e();
    return a(paramContext, paramMessageForPic, paramChatThumbView, paramArrayOfInt, null);
  }
  
  public static URL a(MessageForPic paramMessageForPic)
  {
    return new ahbi(paramMessageForPic).a;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString3))) {}
    while (!"2854196312".equals(paramString1)) {
      return;
    }
    paramString1 = "";
    if (paramInt != -2) {}
    String str;
    switch (paramInt)
    {
    default: 
      paramString1 = "other";
      if (paramQQAppInterface.c() != null)
      {
        str = paramQQAppInterface.c();
        label84:
        if (paramString4 == null) {
          break label141;
        }
        label89:
        if (paramString2 == null) {
          break label148;
        }
      }
      break;
    }
    for (;;)
    {
      bdll.b(paramQQAppInterface, "dc00898", "", "", paramString3, paramString3, 0, 0, str, paramString4, paramString1, paramString2);
      return;
      paramString1 = "c2c";
      break;
      paramString1 = "group";
      break;
      paramString1 = "discuss";
      break;
      str = "";
      break label84;
      label141:
      paramString4 = "";
      break label89;
      label148:
      paramString2 = "";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, View paramView, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, MessageForReplyText paramMessageForReplyText)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_one_item", paramBoolean1);
    localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean2);
    localBundle.putBoolean(bmgb.b, paramBoolean3);
    Object localObject;
    if (a(paramContext, paramSessionInfo))
    {
      localObject = ((FragmentActivity)paramContext).getChatFragment();
      if (localObject == null) {
        QLog.d("PicItemBuilder", 1, "enterImagePreview  chatFragment is null.");
      }
    }
    else
    {
      if (paramMessageForReplyText == null) {
        break label220;
      }
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
    }
    for (;;)
    {
      paramBoolean2 = ayxt.a(paramQQAppInterface.getCurrentAccountUin(), 1);
      localBundle.putBoolean("extra.OCR", paramBoolean2);
      if (paramBoolean2)
      {
        paramMessageForReplyText = ayxt.a(paramQQAppInterface.getCurrentAccountUin());
        if (!TextUtils.isEmpty(paramMessageForReplyText)) {
          localBundle.putString("extra.OCR_TEXT", paramMessageForReplyText);
        }
      }
      ahbe.a(paramQQAppInterface, paramContext, paramView, paramChatMessage, paramSessionInfo, paramBoolean1, localBundle);
      return;
      localObject = ((ChatFragment)localObject).a();
      if (localObject == null)
      {
        QLog.d("PicItemBuilder", 1, "enterImagePreview  BaseChatPie is null.");
        break;
      }
      int k = ((BaseChatPie)localObject).g();
      localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", k);
      if (k != 1) {
        break;
      }
      localObject = (InputMethodManager)paramContext.getSystemService("input_method");
      if (localObject == null) {
        break;
      }
      ((InputMethodManager)localObject).toggleSoftInput(1, 0);
      break;
      label220:
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramChatMessage.isMultiMsg);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, BaseChatItemLayout paramBaseChatItemLayout, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, View.OnClickListener paramOnClickListener)
  {
    if ((!b(paramMessageRecord)) || (!((asfy)paramQQAppInterface.getManager(334)).c())) {
      return;
    }
    Context localContext = paramBaseChatItemLayout.getContext();
    a(paramBaseChatItemLayout, paramMessageRecord, paramOnClickListener, localContext, (RelativeLayout)paramBaseChatItemLayout.findViewById(2131378081), paramQQAppInterface.getApp().getString(2131691706), null, 2130837999, a(localContext, paramSessionInfo));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramQQAppInterface, -2, paramString1, paramString2, paramString3, paramString4);
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, ahbj paramahbj)
  {
    if ((paramahbj != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramChatMessage != null))
    {
      paramahbj.c = super.a(paramahbj.c, paramahbj, paramBaseChatItemLayout, paramChatMessage, -2, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
      super.a(paramahbj.c, paramBaseChatItemLayout, Integer.valueOf(2131378081), paramChatMessage, -4, Boolean.valueOf(true));
    }
  }
  
  public static void a(MessageForPic paramMessageForPic, Intent paramIntent)
  {
    if (paramMessageForPic.picExtraData != null)
    {
      if (!paramMessageForPic.picExtraData.isCustomFace()) {
        break label72;
      }
      paramIntent.putExtra("forward_is_custom_face", true);
      paramIntent.putExtra("forward_cutsom_face_type", paramMessageForPic.picExtraData.customFaceType);
      paramIntent.putExtra("forward_diy_package_id", paramMessageForPic.picExtraData.emojiPkgId);
      paramIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
    }
    label72:
    do
    {
      do
      {
        return;
        if (paramMessageForPic.picExtraData.isHotPics())
        {
          paramIntent.putExtra("HOT_PIC_HAS_EXTRA", true);
          paramIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
          return;
        }
        if ((paramMessageForPic.picExtraData.isStickerPics()) || (paramMessageForPic.picExtraData.isStickerAdPic()))
        {
          if (paramMessageForPic.picExtraData.isStickerPics()) {
            paramIntent.putExtra("forward_is_sticker", true);
          }
          for (;;)
          {
            paramIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
            paramIntent.putExtra("key_emotion_source_from", paramMessageForPic.picExtraData.from);
            paramIntent.putExtra("key_emotion_source_info", paramMessageForPic.picExtraData.source);
            paramIntent.putExtra("key_emotion_source_weburl", paramMessageForPic.picExtraData.webUrl);
            paramIntent.putExtra("key_emotion_source_iconurl", paramMessageForPic.picExtraData.iconUrl);
            paramIntent.putExtra("key_emotion_source_packagename", paramMessageForPic.picExtraData.packageName);
            paramIntent.putExtra("key_emotion_source_epid", paramMessageForPic.picExtraData.emojiPkgId);
            return;
            paramIntent.putExtra("forward_is_sticker_ad", true);
            paramIntent.putExtra("quick_send_ad_emo_jump_url", paramMessageForPic.picExtraData.mAdEmoJumpUrl);
            paramIntent.putExtra("quick_send_ad_emo_desc_str", paramMessageForPic.picExtraData.mAdEmoDescStr);
          }
        }
        if (paramMessageForPic.picExtraData.isZhitu())
        {
          paramIntent.putExtra("forward_is_zhitu", true);
          paramIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
          return;
        }
        if (!paramMessageForPic.picExtraData.isSelfieFace()) {
          break;
        }
        paramIntent.putExtra("forward_is_selfie_face", true);
        paramIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
      } while (TextUtils.isEmpty(paramMessageForPic.picExtraData.mTemplateId));
      paramIntent.putExtra("widgetinfo", paramMessageForPic.picExtraData.mTemplateId);
      return;
    } while (TextUtils.isEmpty(paramMessageForPic.picExtraData.mTemplateId));
    paramIntent.putExtra("forward_send_template_pic", true);
    paramIntent.putExtra("widgetinfo", paramMessageForPic.picExtraData.mTemplateId);
    paramIntent.putExtra("key_camera_material_name", paramMessageForPic.picExtraData.mTemplateName);
  }
  
  private void a(MessageForPic paramMessageForPic, Rect paramRect)
  {
    AIOEmotionFragment.a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramRect);
  }
  
  private void a(MessageForPic paramMessageForPic, BaseChatItemLayout paramBaseChatItemLayout)
  {
    DuiButtonImageView localDuiButtonImageView;
    int k;
    if ((paramBaseChatItemLayout != null) && (!axug.a(paramMessageForPic)) && (!paramMessageForPic.isMultiMsg))
    {
      localDuiButtonImageView = (DuiButtonImageView)paramBaseChatItemLayout.findViewById(2131365781);
      if (((paramMessageForPic.extraflag != 32768) || (!paramMessageForPic.isSendFromLocal())) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramMessageForPic))) {
        break label121;
      }
      k = 1;
      if ((!paramMessageForPic.isDui) || (k != 0) || (!DuiButtonImageView.jdField_a_of_type_Boolean)) {
        break label395;
      }
      if (!paramMessageForPic.isSend()) {
        break label126;
      }
      if (localDuiButtonImageView != null)
      {
        localDuiButtonImageView.setVisibility(8);
        localDuiButtonImageView.e();
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageForPic, this);
      return;
      label121:
      k = 0;
      break;
      label126:
      if (localDuiButtonImageView == null)
      {
        localDuiButtonImageView = new DuiButtonImageView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(agej.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localLayoutParams.addRule(8, 2131364423);
        localLayoutParams.addRule(1, 2131364423);
        localLayoutParams.bottomMargin = (BaseChatItemLayout.jdField_i_of_type_Int - agej.a(6.5F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localDuiButtonImageView.setId(2131365781);
        paramBaseChatItemLayout.addView(localDuiButtonImageView, localLayoutParams);
        if (QLog.isColorLevel()) {
          QLog.d("PicItemBuilder", 2, "message.hasPlayedDui = " + paramMessageForPic.hasPlayedDui);
        }
        if (QLog.isColorLevel()) {
          QLog.d("[Doutu]CustomFrameAnimationDrawable", 2, " message.isDui = " + paramMessageForPic.isDui + ", message.hasPlayedDui = " + paramMessageForPic.hasPlayedDui);
        }
        if (paramMessageForPic.hasPlayedDui) {
          break label371;
        }
        paramMessageForPic.hasPlayedDui = DuiButtonImageView.a(localDuiButtonImageView);
      }
      for (;;)
      {
        label241:
        if (!DuiButtonImageView.jdField_a_of_type_Boolean) {
          break label379;
        }
        localDuiButtonImageView.setOnClickListener(this);
        localDuiButtonImageView.setVisibility(0);
        break;
        localDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramMessageForPic;
        break label241;
        label371:
        localDuiButtonImageView.f();
      }
      label379:
      localDuiButtonImageView.setOnClickListener(null);
      localDuiButtonImageView.setVisibility(8);
      continue;
      label395:
      if (localDuiButtonImageView != null)
      {
        localDuiButtonImageView.setVisibility(8);
        localDuiButtonImageView.e();
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    if (!((asfy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(334)).c()) {}
    while (!a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      return;
    }
    ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
    if ((localChatFragment != null) && (localChatFragment.a != null)) {
      localChatFragment.a.t(11);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "mTemplateId clickViewId：" + ((MessageForPic)paramMessageRecord).picExtraData.mTemplateId);
    }
    brdx.b((FragmentActivity)this.jdField_a_of_type_AndroidContentContext, ((MessageForPic)paramMessageRecord).picExtraData.mTemplateId);
  }
  
  private void a(String paramString)
  {
    ((axfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).b(paramString, new ahni(this, paramString));
  }
  
  private static boolean a(Context paramContext, SessionInfo paramSessionInfo)
  {
    return (((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.n);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, URL paramURL)
  {
    float f = paramContext.getResources().getDisplayMetrics().density;
    boolean bool2 = bdku.a();
    if (!bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("t_gif", 2, "needShowGifTag isbigThumb false");
      }
      return false;
    }
    paramContext = beqz.d(paramURL.toString());
    if ((paramContext != null) && (paramContext.endsWith("_big400"))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("t_gif", 2, "needShowGifTag isgif=" + paramBoolean1 + "isthumb=" + paramBoolean2 + "w=" + paramInt1 + "h=" + paramInt2 + "==100*density=" + 100.0F * f + "isbugThumb=" + bool2 + "isthumb400=" + bool1);
      }
      if ((!paramBoolean1) || (!paramBoolean2) || (paramInt1 < 100.0F * f) || (paramInt2 < f * 100.0F) || (!bool2) || (!bool1)) {
        break;
      }
      return true;
    }
  }
  
  public static boolean a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.checkGif()) {}
    do
    {
      return true;
      if (paramMessageForPic.picExtraData != null) {
        return paramMessageForPic.picExtraData.isEmotion();
      }
    } while (axug.a(paramMessageForPic));
    return false;
  }
  
  public static Intent b(MessageForPic paramMessageForPic, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramSessionInfo = ahbe.a(paramMessageForPic, paramSessionInfo, paramQQAppInterface, paramContext);
    a(paramMessageForPic, paramSessionInfo);
    return paramSessionInfo;
  }
  
  private void b(QQAppInterface paramQQAppInterface, BaseChatItemLayout paramBaseChatItemLayout, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, View.OnClickListener paramOnClickListener)
  {
    if (c(paramMessageRecord))
    {
      String str = ((MessageForPic)paramMessageRecord).picExtraData.mAdEmoDescStr;
      a(paramBaseChatItemLayout, paramMessageRecord, paramOnClickListener, paramBaseChatItemLayout.getContext(), (RelativeLayout)paramBaseChatItemLayout.findViewById(2131378081), str, null, -1, true);
      new aitv().a(paramQQAppInterface, paramSessionInfo, (MessageForPic)paramMessageRecord);
    }
  }
  
  private void b(MessageRecord paramMessageRecord)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_d_of_type_Long < 2000L) {
      return;
    }
    this.jdField_d_of_type_Long = l;
    new aitv().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForPic)paramMessageRecord);
    paramMessageRecord = ((MessageForPic)paramMessageRecord).picExtraData.mAdEmoJumpUrl;
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramMessageRecord);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForPic)) && (((MessageForPic)paramMessageRecord).picExtraData != null) && (((MessageForPic)paramMessageRecord).picExtraData.isSelfieFace());
  }
  
  private boolean c(MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord instanceof MessageForPic)) && (((MessageForPic)paramMessageRecord).picExtraData != null) && (((MessageForPic)paramMessageRecord).picExtraData.isStickerAdPic()))
    {
      String str = ((MessageForPic)paramMessageRecord).picExtraData.mAdEmoJumpUrl;
      paramMessageRecord = ((MessageForPic)paramMessageRecord).picExtraData.mAdEmoDescStr;
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramMessageRecord))) {
        return true;
      }
    }
    return false;
  }
  
  public static void e()
  {
    Object localObject;
    if (!jdField_i_of_type_Boolean)
    {
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_gifplay.name());
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 3) {
          h = localObject[0].equals("1");
        }
      }
    }
    try
    {
      jdField_c_of_type_Int = Integer.parseInt(localObject[2]);
      if (jdField_c_of_type_Int < 0) {
        jdField_c_of_type_Int = 100;
      }
      com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = jdField_c_of_type_Int;
      jdField_i_of_type_Boolean = true;
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        jdField_c_of_type_Int = 100;
      }
    }
  }
  
  private void f(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "[Doutu] Dui Button Clicked.");
    }
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "[Doutu] Dui Button Clicked.");
    }
    ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
    if (localChatFragment != null)
    {
      localBaseChatPie = localChatFragment.a();
      if (localBaseChatPie != null)
      {
        localChatFragment = null;
        if ((agej.a(paramView) instanceof ahbj))
        {
          localMessageForPic = (MessageForPic)((ahbj)agej.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          paramView = localChatFragment;
          if (localMessageForPic != null) {
            paramView = new asci(localMessageForPic.uuid, localMessageForPic.md5, localMessageForPic.groupFileID, localMessageForPic.rawMsgUrl, localMessageForPic.senderuin);
          }
          localBaseChatPie.a().obtainMessage(79, paramView).sendToTarget();
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      BaseChatPie localBaseChatPie;
      MessageForPic localMessageForPic;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("PicItemBuilder", 2, "[Doutu] curPie is null.");
      return;
    }
    QLog.d("PicItemBuilder", 2, "[Doutu] chatFragment is null.");
  }
  
  private void f(MessageForPic paramMessageForPic)
  {
    if (this.jdField_b_of_type_JavaUtilHashSet.contains(Long.valueOf(paramMessageForPic.uniseq))) {}
    Object localObject;
    do
    {
      return;
      localObject = arbi.a();
      if (beqw.a().jdField_a_of_type_Boolean)
      {
        beqy.a().a("Expose");
        this.jdField_b_of_type_JavaUtilHashSet.add(Long.valueOf(paramMessageForPic.uniseq));
        return;
      }
    } while ((localObject == null) || (!((arbj)localObject).b));
    int k;
    if (((arbj)localObject).jdField_a_of_type_Double == 0.85D)
    {
      k = 1;
      localObject = "4";
      if (paramMessageForPic.istroop != 0) {
        break label141;
      }
      localObject = "1";
    }
    for (;;)
    {
      bdll.b(null, "dc00898", "", "", "0X800B339", "0X800B339", k, 0, (String)localObject, "", "", "");
      this.jdField_b_of_type_JavaUtilHashSet.add(Long.valueOf(paramMessageForPic.uniseq));
      return;
      k = 2;
      break;
      label141:
      if (adak.a(paramMessageForPic.istroop)) {
        localObject = "2";
      } else if (adak.d(paramMessageForPic.istroop)) {
        localObject = "3";
      }
    }
  }
  
  private void g(View paramView)
  {
    MessageRecord localMessageRecord = (MessageRecord)paramView.getTag();
    if (localMessageRecord == null) {
      return;
    }
    if (b(localMessageRecord))
    {
      a(localMessageRecord);
      return;
    }
    if (c(localMessageRecord))
    {
      b(localMessageRecord);
      return;
    }
    ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(paramView.getContext(), localMessageRecord);
  }
  
  private void g(MessageForPic paramMessageForPic)
  {
    Object localObject = arbi.a();
    if (beqw.a().jdField_a_of_type_Boolean) {
      beqy.a().b("Click");
    }
    while (localObject == null) {
      return;
    }
    int k;
    if (((arbj)localObject).jdField_a_of_type_Double > 0.0D) {
      k = (int)(((arbj)localObject).jdField_a_of_type_Double * 100.0D);
    }
    for (;;)
    {
      localObject = "4";
      if (paramMessageForPic.istroop == 0) {
        localObject = "1";
      }
      for (;;)
      {
        bdll.b(null, "dc00898", "", "", "0X800B2A2", "0X800B2A2", k, 0, (String)localObject, "", "", "");
        return;
        if ((!((arbj)localObject).equals(new arbi().b())) && (((arbj)localObject).jdField_a_of_type_Boolean)) {
          break label151;
        }
        k = 101;
        break;
        if (adak.a(paramMessageForPic.istroop)) {
          localObject = "2";
        } else if (adak.d(paramMessageForPic.istroop)) {
          localObject = "3";
        }
      }
      label151:
      k = 0;
    }
  }
  
  private void h(MessageForPic paramMessageForPic)
  {
    ThreadManager.post(new PicItemBuilder.3(this, paramMessageForPic), 5, null, false);
    if (paramMessageForPic.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    azqu localazqu = new azqu();
    localazqu.d(1045);
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
      localazqu.f(paramMessageForPic.md5);
      localazqu.jdField_i_of_type_Int = paramMessageForPic.extLong;
      localazqu.jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
      localazqu.jdField_i_of_type_Boolean = true;
      Object localObject = new azqv();
      ((azqv)localObject).a = paramMessageForPic.msgseq;
      ((azqv)localObject).b = paramMessageForPic.shmsgseq;
      ((azqv)localObject).jdField_c_of_type_Long = paramMessageForPic.msgUid;
      localazqu.a((azqv)localObject);
      localObject = paramMessageForPic.getExtInfoFromExtStr(bcrn.t);
      String str2 = paramMessageForPic.getExtInfoFromExtStr(bcrn.s);
      long l = 0L;
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          l = Long.parseLong((String)localObject);
        }
        if (!TextUtils.isEmpty(paramMessageForPic.thumbMsgUrl))
        {
          localObject = paramMessageForPic.thumbMsgUrl;
          localazqu.a = new PhotoSendParams((String)localObject, paramMessageForPic.md5, "", l, (int)paramMessageForPic.height, (int)paramMessageForPic.width, str2, 1);
          localObject = azqb.a(4, 1045);
          ((azqk)localObject).a(localazqu.a());
          ((azqk)localObject).a = paramMessageForPic.picExtraData;
          azqb.a((azqk)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
          localazqu.c(beya.d);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PicItemBuilder", 2, "reuploadQzonePhoto exception:", localException);
          }
          l = 0L;
          continue;
          String str1 = paramMessageForPic.bigThumbMsgUrl;
        }
      }
    }
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    paramView = super.a(paramChatMessage, paramaggl, paramView, paramBaseChatItemLayout, paramagjk);
    if (paramaggl == null) {
      return paramView;
    }
    paramaggl = (ahbj)paramaggl;
    paramagjk = (MessageForPic)paramChatMessage;
    c(paramagjk, paramaggl);
    a(paramagjk, paramBaseChatItemLayout);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this);
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this);
    if (((bgty)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
      paramaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    for (;;)
    {
      if (!a((MessageForPic)paramChatMessage)) {
        paramaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      }
      f(paramagjk);
      a(paramChatMessage, paramBaseChatItemLayout, paramaggl);
      return paramView;
      paramaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
  }
  
  public bhuk a(bhuk parambhuk, ChatMessage paramChatMessage, aghd paramaghd)
  {
    MessageForPic localMessageForPic = (MessageForPic)paramChatMessage;
    if (aqyt.a(localMessageForPic)) {}
    for (;;)
    {
      return parambhuk;
      if (!ApolloUtil.a(localMessageForPic))
      {
        if (!TextUtils.isEmpty(localMessageForPic.getExtInfoFromExtStr("sticker_info"))) {}
        for (int k = 1; k == 0; k = 0) {
          return super.a(parambhuk, paramChatMessage, paramaghd);
        }
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131376534)
    {
      l(paramChatMessage);
      return;
    }
    if (paramInt == 2131371486)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicItemBuilder", 4, "picItem related click");
      }
      k(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  void a(ahbj paramahbj, boolean paramBoolean, int[] paramArrayOfInt, URL paramURL)
  {
    Object localObject = paramahbj.jdField_a_of_type_ComTencentImageURLDrawable;
    if (localObject != null)
    {
      localObject = ((URLDrawable)localObject).getURL().getProtocol();
      if (a(this.jdField_a_of_type_AndroidContentContext, paramBoolean, ((String)localObject).equals("chatthumb"), paramArrayOfInt[0], paramArrayOfInt[1], paramURL))
      {
        paramahbj.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkDrawable(a(), agej.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        paramahbj.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(0);
        return;
      }
      paramahbj.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
      return;
    }
    paramahbj.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    super.a(paramMessageForPic);
    if (paramMessageForPic.isMultiMsg)
    {
      int k = 4;
      if (paramMessageForPic.checkGif()) {
        k = 3;
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", k, 0, "" + k, "", "", "");
    }
  }
  
  void a(MessageForPic paramMessageForPic, ahbj paramahbj)
  {
    c(paramMessageForPic, paramahbj);
  }
  
  public boolean a(aggl paramaggl)
  {
    return paramaggl instanceof ahbj;
  }
  
  boolean a(bhuk parambhuk, MessageForPic paramMessageForPic)
  {
    if (!aiyz.a(paramMessageForPic)) {
      return false;
    }
    a(parambhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForPic);
    a(parambhuk, paramMessageForPic);
    if (!paramMessageForPic.isSend()) {
      parambhuk.a(2131376534, this.jdField_a_of_type_AndroidContentContext.getString(2131719416), 2130847872);
    }
    return true;
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "2", "", "", "");
  }
  
  public bhuk b(bhuk parambhuk, ChatMessage paramChatMessage, aghd paramaghd)
  {
    MessageForPic localMessageForPic = (MessageForPic)paramChatMessage;
    paramaghd = (ahbj)paramaghd;
    if (aqyt.a(localMessageForPic)) {}
    do
    {
      do
      {
        return parambhuk;
      } while (ApolloUtil.a(localMessageForPic));
      if (!TextUtils.isEmpty(localMessageForPic.getExtInfoFromExtStr("sticker_info"))) {}
      for (int k = 1; k != 0; k = 0)
      {
        a(parambhuk, localMessageForPic);
        return parambhuk;
      }
    } while (a(parambhuk, localMessageForPic));
    return super.b(parambhuk, paramChatMessage, paramaghd);
  }
  
  protected void b(bhuk parambhuk, MessageForPic paramMessageForPic)
  {
    if ((a(paramMessageForPic)) && (asos.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
    {
      paramMessageForPic = arbk.a();
      if ((paramMessageForPic != null) && (paramMessageForPic.a()))
      {
        parambhuk.a(2131371486, this.jdField_a_of_type_AndroidContentContext.getString(2131717424), 2130838945);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X800B114", "0X800B114", asos.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, "", "", "", "");
      }
    }
  }
  
  protected void b(MessageForPic paramMessageForPic)
  {
    super.b(paramMessageForPic);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.senderuin, paramMessageForPic.md5, "0X8009F3A", "");
  }
  
  protected void b(MessageForPic paramMessageForPic, ahbj paramahbj)
  {
    Object localObject;
    if (!paramMessageForPic.isSendFromLocal())
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.senderuin, paramMessageForPic.md5, "0X8009F37", "");
      localObject = (aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
        ((aoip)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      }
      if ((paramMessageForPic.picExtraData == null) || (!paramMessageForPic.picExtraData.isDiyDouTu())) {
        break label200;
      }
      if (paramahbj.a()) {
        a(String.valueOf(paramMessageForPic.picExtraData.emojiPkgId));
      }
    }
    label200:
    do
    {
      return;
      paramahbj = paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramahbj.setProgressVisable(false);
      localObject = azqb.a(6, 1536, 1);
      ((azqk)localObject).a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
      ((azqk)localObject).a(new ahnh(this, paramahbj));
      azqb.a((azqk)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      if ((paramMessageForPic.picExtraData != null) && (paramMessageForPic.picExtraData.isDiyDouTu()))
      {
        a(String.valueOf(paramMessageForPic.picExtraData.emojiPkgId));
        return;
      }
      if (!aiyz.b(paramMessageForPic)) {
        break;
      }
    } while (aiyz.a(paramMessageForPic));
    a(paramMessageForPic, abke.a(paramahbj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView));
    return;
    if (a(paramMessageForPic))
    {
      new aitv().d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageForPic);
      a(paramMessageForPic, abke.a(paramahbj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView));
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramahbj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, null);
    g(paramMessageForPic);
  }
  
  protected void c(MessageForPic paramMessageForPic)
  {
    super.c(paramMessageForPic);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "3", "", "", "");
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.senderuin, paramMessageForPic.md5, "0X8009F38", "");
    if (paramMessageForPic.isMultiMsg)
    {
      int k = 1;
      if (paramMessageForPic.checkGif()) {
        k = 2;
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D68", "0X8009D68", k, 0, "" + k, "", "", "");
    }
    asos.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramMessageForPic.md5, null);
    new aitv().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageForPic);
  }
  
  void c(MessageForPic paramMessageForPic, ahbj paramahbj)
  {
    if ((paramMessageForPic.picExtraData != null) && (paramMessageForPic.picExtraData.isDiyDouTu()))
    {
      paramahbj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (!paramahbj.a())
      {
        paramahbj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838011);
        paramahbj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  protected void d(MessageForPic paramMessageForPic)
  {
    Intent localIntent = b(paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
    if ((((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity))) && (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment() != null)) {
      localIntent.putExtra("isBack2Root", ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().j);
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity))
    {
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent = agej.a(localIntent, null);
    }
    for (;;)
    {
      localIntent.putExtra("key_allow_forward_photo_preview_edit", true);
      localIntent.putExtra("selection_mode", this.jdField_b_of_type_Int);
      auxu.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "3", "", "", "");
      if (paramMessageForPic.isMultiMsg)
      {
        int k = 4;
        if (paramMessageForPic.checkGif()) {
          k = 3;
        }
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", k, 0, "" + k, "", "", "");
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.senderuin, paramMessageForPic.md5, "0X8009F39", "");
      return;
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
    }
  }
  
  void e(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.isQzonePic) {
      h(paramMessageForPic);
    }
    for (;;)
    {
      b();
      return;
      super.e(paramMessageForPic);
    }
  }
  
  protected void j(ChatMessage paramChatMessage)
  {
    super.j(paramChatMessage);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "3", "", "", "");
  }
  
  protected void k(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForPic)) {}
    label7:
    do
    {
      do
      {
        break label7;
        do
        {
          return;
        } while (!a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
        Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (localObject == null) {
          break;
        }
        localObject = ((ChatFragment)localObject).a();
        if (localObject != null)
        {
          localObject = (agti)((BaseChatPie)localObject).a(72);
          URLDrawable localURLDrawable = a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)paramChatMessage);
          ((agti)localObject).a(paramChatMessage, localURLDrawable);
          QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          String str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          int k = asos.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          String str2 = asos.a((MessageForPic)paramChatMessage);
          if (((MessageForPic)paramChatMessage).md5 == null) {}
          for (localObject = "";; localObject = ((MessageForPic)paramChatMessage).md5)
          {
            bdll.b(localQQAppInterface, "dc00898", "", str1, "0X800B115", "0X800B115", k, 0, str2, "", (String)localObject, asos.b((MessageForPic)paramChatMessage));
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("PicItemBuilder", 2, "[Related_Emotion] url: " + localURLDrawable.getURL().toString());
            return;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("PicItemBuilder", 2, "[Related_Emotion] curPie is null.");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("PicItemBuilder", 2, "[Related_Emotion] chatFragment is null.");
  }
  
  protected void l(ChatMessage paramChatMessage)
  {
    if (nlj.a(paramChatMessage))
    {
      localObject = nlj.a(paramChatMessage);
      if ((((nlk)localObject).jdField_a_of_type_JavaLangString == null) && (((nlk)localObject).jdField_a_of_type_Int != 2)) {
        if (QLog.isColorLevel()) {
          QLog.i("PicItemBuilder", 2, "Anonymous report : an_id is null");
        }
      }
      byte[] arrayOfByte;
      do
      {
        return;
        arrayOfByte = ((nlk)localObject).a();
      } while ((arrayOfByte == null) || (((nlk)localObject).jdField_a_of_type_Int == 2));
      localObject = URLEncoder.encode(Base64.encodeToString(arrayOfByte, 2));
      nlj.a().a(paramChatMessage.frienduin, (String)localObject, paramChatMessage);
      aber.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), nlj.a().a(paramChatMessage.frienduin, (String)localObject));
      return;
    }
    Object localObject = paramChatMessage.senderuin;
    aber.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), aber.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), null);
  }
  
  public void onClick(View paramView)
  {
    agej.n = true;
    if (super.a())
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int k = paramView.getId();
    if (k == 2131365781) {
      f(paramView);
    }
    for (;;)
    {
      super.onClick(paramView);
      break;
      if (k == 2131364451) {
        g(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahng
 * JD-Core Version:    0.7.0.1
 */