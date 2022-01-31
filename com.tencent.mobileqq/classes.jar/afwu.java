import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.Base64;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder.6;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder.7;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class afwu
  extends afyf
  implements aeql, aesa
{
  public static float c;
  public static int c;
  public static long c;
  public static float d;
  static long e;
  public static boolean g;
  public static boolean h = true;
  public static boolean i;
  private auqc a;
  protected final float b;
  protected long d;
  protected final boolean f;
  boolean j = false;
  boolean k = true;
  boolean l = false;
  
  static
  {
    jdField_c_of_type_Int = 100;
    jdField_c_of_type_Long = 1000L;
    jdField_c_of_type_Float = 0.3F;
    d = 1.0F;
    jdField_e_of_type_Long = 1000L;
  }
  
  public afwu(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner, false);
  }
  
  public afwu(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    e();
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.f = paramBoolean;
    if (this.jdField_a_of_type_Auqc == null) {
      this.jdField_a_of_type_Auqc = ((auqc)paramQQAppInterface.getManager(324));
    }
  }
  
  public static Intent a(MessageForPic paramMessageForPic, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext)
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
    int m;
    if ((bdex.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003))
    {
      m = 1;
      if (m != 0) {
        break label694;
      }
      m = 65537;
      label326:
      localObject = bayu.a(paramMessageForPic, m);
      localIntent.putExtra("forward_urldrawable", true);
      localIntent.putExtra("forward_urldrawable_thumb_url", ((URL)localObject).toString());
      localIntent.putExtra("FORWARD_URL_KEY", paramMessageForPic.localUUID);
      localObject = ForwardUtils.a(paramContext, paramMessageForPic);
      localIntent.putExtra("forward_urldrawable_big_url", ((URLDrawable)localObject).getURL().toString());
      localIntent.putExtra("uinname", paramSessionInfo.d);
      localIntent.putExtra("PhotoConst.MY_UIN", paramQQAppInterface.getAccount());
      localIntent.putExtra("PhotoConst.MY_NICK", paramQQAppInterface.getCurrentNickname());
      localIntent.putExtra("is_anonymous", nav.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString));
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1009);
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      localIntent.putExtra("key_confess_topicid", paramSessionInfo.e);
      localIntent.addFlags(603979776);
      localIntent.putExtra("FORWARD_MSG_FOR_PIC", paramMessageForPic);
      if (!bdhb.b(paramMessageForPic.path)) {
        break label700;
      }
      localIntent.putExtra("forward_extra", paramMessageForPic.path);
      localIntent.putExtra("direct_send_if_dataline_forward", true);
      localIntent.putExtra("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
      if (paramMessageForPic.picExtraData != null)
      {
        if (!paramMessageForPic.picExtraData.isCustomFace()) {
          break label790;
        }
        localIntent.putExtra("forward_is_custom_face", true);
        localIntent.putExtra("forward_cutsom_face_type", paramMessageForPic.picExtraData.customFaceType);
        localIntent.putExtra("forward_diy_package_id", paramMessageForPic.picExtraData.emojiPkgId);
        localIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
      }
    }
    for (;;)
    {
      localIntent.putExtra("BUSI_TYPE", 1009);
      return localIntent;
      m = 0;
      break;
      label694:
      m = 1;
      break label326;
      label700:
      paramContext = null;
      paramQQAppInterface = ((URLDrawable)localObject).getURL().toString();
      if (baqn.b(paramQQAppInterface))
      {
        localObject = baqn.a(paramQQAppInterface);
        paramQQAppInterface = paramContext;
        if (localObject != null) {
          paramQQAppInterface = ((File)localObject).getAbsolutePath();
        }
      }
      for (;;)
      {
        localIntent.putExtra("forward_extra", paramQQAppInterface);
        break;
        localObject = baqn.a(bayu.a(paramMessageForPic, 65537).toString());
        paramQQAppInterface = paramContext;
        if (localObject != null)
        {
          paramQQAppInterface = paramContext;
          if (((File)localObject).exists()) {
            paramQQAppInterface = ((File)localObject).getAbsolutePath();
          }
        }
      }
      label790:
      if (paramMessageForPic.picExtraData.isHotPics())
      {
        localIntent.putExtra("HOT_PIC_HAS_EXTRA", true);
        localIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
      }
      else if (paramMessageForPic.picExtraData.isStickerPics())
      {
        localIntent.putExtra("forward_is_sticker", true);
        localIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
        localIntent.putExtra("key_emotion_source_from", paramMessageForPic.picExtraData.from);
        localIntent.putExtra("key_emotion_source_info", paramMessageForPic.picExtraData.source);
        localIntent.putExtra("key_emotion_source_weburl", paramMessageForPic.picExtraData.webUrl);
        localIntent.putExtra("key_emotion_source_iconurl", paramMessageForPic.picExtraData.iconUrl);
        localIntent.putExtra("key_emotion_source_packagename", paramMessageForPic.picExtraData.packageName);
        localIntent.putExtra("key_emotion_source_epid", paramMessageForPic.picExtraData.emojiPkgId);
      }
      else if (paramMessageForPic.picExtraData.isZhitu())
      {
        localIntent.putExtra("forward_is_zhitu", true);
        localIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
      }
      else if (paramMessageForPic.picExtraData.isSelfieFace())
      {
        localIntent.putExtra("forward_is_selfie_face", true);
        localIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
        if (!TextUtils.isEmpty(paramMessageForPic.picExtraData.mTemplateId)) {
          localIntent.putExtra("widgetinfo", paramMessageForPic.picExtraData.mTemplateId);
        }
      }
      else if (!TextUtils.isEmpty(paramMessageForPic.picExtraData.mTemplateId))
      {
        localIntent.putExtra("forward_send_template_pic", true);
        localIntent.putExtra("widgetinfo", paramMessageForPic.picExtraData.mTemplateId);
        localIntent.putExtra("key_camera_material_name", paramMessageForPic.picExtraData.mTemplateName);
      }
    }
  }
  
  public static Bitmap a()
  {
    Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130838098);
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
    boolean bool2 = false;
    paramMessageForPic.checkType();
    boolean bool3 = biqe.a(paramMessageForPic.imageType);
    boolean bool1;
    Object localObject1;
    if (paramMessageForPic.imageType != 3)
    {
      bool1 = bool2;
      if (paramMessageForPic.imageType != 2000) {}
    }
    else
    {
      f();
      bool1 = bool2;
      if (h)
      {
        bool1 = true;
        localObject1 = bayu.a(paramMessageForPic, 1, null);
        if (baqn.a(((URL)localObject1).toString()) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PicItemBuilder", 2, "getThumbDrawable,using GIF_BIG,uniseq:" + paramMessageForPic.uniseq + " url:" + localObject1);
          }
          bool1 = true;
        }
      }
    }
    label830:
    label1475:
    label1609:
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = bayu.a(paramMessageForPic, 65537, null);
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("PicItemBuilder", 2, "getThumbDrawable,using thumb,uniseq:" + paramMessageForPic.uniseq + " url:" + localObject1);
          localObject2 = localObject1;
        }
      }
      Object localObject3 = localObject2.toString();
      localObject1 = paramContext.getResources();
      int i6 = ((Resources)localObject1).getDisplayMetrics().densityDpi;
      if (paramChatThumbView != null) {
        paramChatThumbView.jdField_a_of_type_Boolean = false;
      }
      float f1 = i6 / 160.0F;
      if (BaseApplicationImpl.sImageCache.get(localObject3) != null)
      {
        paramContext = bayu.a(localObject2, 0, 0, null, null, true, 12.0F * f1);
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt[0] = paramContext.getIntrinsicWidth();
          paramArrayOfInt[1] = paramContext.getIntrinsicHeight();
        }
        paramContext.setTag(paramMessageForPic);
        if ((paramContext.getCurrDrawable() instanceof GifDrawable)) {
          ((GifDrawable)paramContext.getCurrDrawable()).mutate();
        }
        return paramContext;
      }
      localObject3 = baqn.a((String)localObject3);
      if (localObject3 != null) {
        if (((paramMessageForPic.imageType != 3) && (paramMessageForPic.imageType != 2000)) || (!GifDrawable.isGifFile((File)localObject3))) {}
      }
      label725:
      label886:
      label1661:
      for (;;)
      {
        int i2;
        int i3;
        int i4;
        try
        {
          paramContext = NativeGifImage.getImageSize((File)localObject3, false);
          if (paramContext == null) {
            break label725;
          }
          n = paramContext.width();
          m = paramContext.height();
          i1 = paramMessageForPic.getThumbWidthHeightDP(bool3).mMinWidth;
          i2 = paramMessageForPic.getThumbWidthHeightDP(bool3).mMinHeight;
          i3 = paramMessageForPic.getThumbWidthHeightDP(bool3).mMaxWidth;
          i4 = paramMessageForPic.getThumbWidthHeightDP(bool3).mMaxHeight;
          f1 = 12.0F * f1;
          if ((n >= i1) && (m >= i2)) {
            break label886;
          }
          if (n >= m) {
            break label830;
          }
          f2 = i1 / n;
          n = (int)(m * f2 + 0.5F);
          m = n;
          if (n > i4) {
            m = i4;
          }
          n = i1;
          f1 = f2 * f1;
          n = (n * i6 + 80) / 160;
          m = (m * i6 + 80) / 160;
          if (paramContext == null) {
            break label1661;
          }
          if (paramContext.width() >= n) {
            break label997;
          }
          f1 *= paramContext.width() / n;
          if (QLog.isColorLevel()) {
            QLog.d("PicItemBuilder", 2, "getThumbDrawable,roundCornor:" + f1 + "  w:" + n + " h:" + m);
          }
          if (paramArrayOfInt != null)
          {
            paramArrayOfInt[0] = n;
            paramArrayOfInt[1] = m;
          }
          paramContext = bayu.b();
          if (!(bayu.b() instanceof SkinnableBitmapDrawable)) {
            break label1023;
          }
          paramContext = new apkn((Resources)localObject1, ((SkinnableBitmapDrawable)bayu.b()).getBitmap(), n, m, -921103);
          paramContext = bayu.a(localObject2, n, m, paramContext, bayu.a(), true, f1);
          paramContext.setProgressDrawable(new berz(bayu.a(), 0, false));
          paramContext.setIgnorePause(true);
          paramContext.setFadeInImage(true);
          if (paramChatThumbView != null) {
            paramChatThumbView.jdField_a_of_type_Boolean = true;
          }
        }
        catch (Throwable paramContext)
        {
          paramContext.printStackTrace();
        }
        paramContext = null;
        continue;
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        try
        {
          bdhj.a(((File)localObject3).getAbsolutePath(), localOptions);
          n = localOptions.outWidth;
          m = localOptions.outHeight;
          i1 = bayu.a(((File)localObject3).getAbsolutePath());
          if ((i1 != 90) && (i1 != 270)) {
            continue;
          }
          n = localOptions.outHeight;
          m = localOptions.outWidth;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("PicItemBuilder", 2, "getThumbDrawable", localThrowable);
            }
          }
        }
        float f2 = i2 / m;
        int n = (int)(n * f2 + 0.5F);
        int m = n;
        if (n > i3) {
          m = i3;
        }
        n = i2;
        int i1 = m;
        m = n;
        n = i1;
        continue;
        if ((n >= i3) || (m >= i4))
        {
          if (n > m)
          {
            f2 = i3 / n;
            if (n <= m) {
              break label985;
            }
          }
          for (float f3 = i2 / m;; f3 = i1 / n)
          {
            f2 = Math.max(f2, f3);
            n = (int)(n * f2 + 0.5F);
            m = (int)(m * f2 + 0.5F);
            break;
            f2 = i4 / m;
            break label919;
          }
          if (paramContext.height() < m)
          {
            f1 *= paramContext.height() / m;
            continue;
            label1023:
            if ((bayu.b() instanceof BitmapDrawable))
            {
              paramContext = new apkn((Resources)localObject1, ((BitmapDrawable)bayu.b()).getBitmap(), n, m, -921103);
              continue;
              int i5;
              if (!bayu.a(paramContext))
              {
                i1 = 1;
                n = paramMessageForPic.getThumbWidthHeightDP(bool3).mMinWidth;
                i2 = paramMessageForPic.getThumbWidthHeightDP(bool3).mMinHeight;
                i3 = paramMessageForPic.getThumbWidthHeightDP(bool3).mMaxWidth;
                m = paramMessageForPic.getThumbWidthHeightDP(bool3).mMaxHeight;
                i4 = paramMessageForPic.thumbWidth;
                i5 = paramMessageForPic.thumbHeight;
                if ((i4 <= 0) || (i5 <= 0)) {
                  break label1553;
                }
                if ((i4 >= n) && (i5 >= i2)) {
                  break label1434;
                }
                if (i4 >= i5) {
                  break label1390;
                }
                i2 = (int)(n / i4 * i5 + 0.5F);
                if (i2 <= m) {
                  break label1383;
                }
                f1 = i6 / 160.0F;
                n = (int)(n * f1 + 0.5F);
                m = (int)(m * f1 + 0.5F);
                paramContext = null;
                paramChatThumbView = URLDrawable.URLDrawableOptions.obtain();
                paramChatThumbView.mRequestWidth = n;
                paramChatThumbView.mRequestHeight = m;
                paramChatThumbView.mLoadingDrawable = bayu.b();
                paramChatThumbView.mFailedDrawable = bayu.a();
                paramChatThumbView.mPlayGifImage = bool1;
                paramChatThumbView.mGifRoundCorner = 12.0F;
                paramChatThumbView.mImgType = paramMessageForPic.imageType;
                if (paramArrayOfInt != null)
                {
                  paramArrayOfInt[0] = n;
                  paramArrayOfInt[1] = m;
                }
                if (!(bayu.b() instanceof SkinnableBitmapDrawable)) {
                  break label1609;
                }
                paramContext = new apkn((Resources)localObject1, ((SkinnableBitmapDrawable)bayu.b()).getBitmap(), n, m, -921103);
                if (paramContext != null) {
                  paramChatThumbView.mLoadingDrawable = paramContext;
                }
                paramContext = URLDrawable.getDrawable(localObject2, paramChatThumbView);
                if ((!awjc.b) && (i1 == 0)) {
                  break label1650;
                }
                paramContext.setAutoDownload(true);
              }
              for (;;)
              {
                paramContext.setProgressDrawable(new berz(bayu.a(), 0, false));
                break;
                i1 = 0;
                break label1074;
                m = i2;
                break label1186;
                n = (int)(i2 / i5 * i4 + 0.5F);
                m = n;
                if (n > i3) {
                  m = i3;
                }
                n = m;
                m = i2;
                break label1186;
                if ((i4 < i3) && (i5 < m))
                {
                  m = i5;
                  n = i4;
                  break label1186;
                }
                if (i4 > i5)
                {
                  f1 = i3 / i4;
                  if (i4 <= i5) {
                    break label1541;
                  }
                }
                for (f2 = i2 / i5;; f2 = n / i4)
                {
                  f1 = Math.max(f1, f2);
                  n = (int)(i4 * f1 + 0.5F);
                  m = (int)(f1 * i5 + 0.5F);
                  break;
                  f1 = m / i5;
                  break label1475;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("PicItemBuilder", 2, "MessageForPic without width/height of thumb, width = " + i4 + ", height = " + i5);
                }
                n = 99;
                m = 99;
                break label1186;
                if (!(bayu.b() instanceof BitmapDrawable)) {
                  break label1326;
                }
                paramContext = new apkn((Resources)localObject1, ((BitmapDrawable)bayu.b()).getBitmap(), n, m, -921103);
                break label1326;
                paramContext.setAutoDownload(false);
              }
            }
            else {}
          }
        }
      }
      label985:
      label997:
      label1383:
      label1390:
      label1650:
      localObject1 = null;
    }
  }
  
  public static URL a(MessageForPic paramMessageForPic)
  {
    URL localURL1;
    if (((paramMessageForPic.imageType == 3) || (paramMessageForPic.imageType == 2000)) && (h))
    {
      localURL1 = bayu.a(paramMessageForPic, 1, null);
      if (baqn.a(localURL1.toString()) == null) {}
    }
    for (;;)
    {
      URL localURL2 = localURL1;
      if (localURL1 == null) {
        localURL2 = bayu.a(paramMessageForPic, 65537, null);
      }
      return localURL2;
      localURL1 = null;
    }
  }
  
  private void a(bdpi parambdpi, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (!paramBoolean1)
    {
      if (paramBoolean2) {
        parambdpi.a(2131362126, this.jdField_a_of_type_AndroidContentContext.getString(2131693477), 2130838676);
      }
      if (paramBoolean3) {
        parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
      }
      if (paramBoolean4) {
        parambdpi.a(2131366017, this.jdField_a_of_type_AndroidContentContext.getString(2131692401), 2130838677);
      }
    }
  }
  
  private void a(bdpz parambdpz, afxa paramafxa)
  {
    if (paramafxa.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if ((parambdpz instanceof barf))
    {
      parambdpz = (barf)parambdpz;
      int m = (int)parambdpz.c();
      switch (m)
      {
      default: 
        if (paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
        {
          paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          if (paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
            break label680;
          }
          paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
          ((RelativeLayout)paramafxa.jdField_a_of_type_AndroidViewView).removeView(paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
          paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
        }
        break;
      }
      for (;;)
      {
        if (m == 1003) {
          paramafxa.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        paramafxa.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        return;
        if ((parambdpz.c()) && (!this.j))
        {
          paramafxa.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          if (paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
          {
            paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
            paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
            paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
            ((RelativeLayout)paramafxa.jdField_a_of_type_AndroidViewView).removeView(paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
            paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
          }
          paramafxa.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        }
        paramafxa.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        if (paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) {
          break;
        }
        paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = true;
        return;
        paramafxa.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        if (paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
        {
          PicProgressView localPicProgressView = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
          localPicProgressView.setRadius(12.0F, true);
          localPicProgressView.setSharpCornerCor(BubbleImageView.a);
          localPicProgressView.setShowCorner(false);
          localPicProgressView.setCustomSize(1);
          localPicProgressView.setProgressBackgroudColor(2130706432);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(6, 2131371945);
          localLayoutParams.addRule(8, 2131371945);
          localLayoutParams.addRule(5, 2131371945);
          localLayoutParams.addRule(7, 2131371945);
          ((RelativeLayout)paramafxa.jdField_a_of_type_AndroidViewView).addView(localPicProgressView, localLayoutParams);
          paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = localPicProgressView;
        }
        paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(parambdpz);
        paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
        if ((paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) && ((1001 == m) || (1002 == m))) {
          paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = false;
        }
        if (m != 1002)
        {
          paramafxa.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
          paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(0);
          return;
        }
        paramafxa.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a();
        paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setShowProgress(true);
        return;
        label680:
        paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
      }
    }
    if (paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)paramafxa.jdField_a_of_type_AndroidViewView).removeView(paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
    paramafxa.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
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
        label85:
        if (paramString4 == null) {
          break label149;
        }
        label90:
        if (paramString2 == null) {
          break label157;
        }
      }
      break;
    }
    for (;;)
    {
      azqs.b(paramQQAppInterface, "dc00898", "", "", paramString3, paramString3, 0, 0, str, paramString4, paramString1, paramString2);
      return;
      paramString1 = "c2c";
      break;
      paramString1 = "group";
      break;
      paramString1 = "discuss";
      break;
      str = "";
      break label85;
      label149:
      paramString4 = "";
      break label90;
      label157:
      paramString2 = "";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, View paramView, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, MessageForReplyText paramMessageForReplyText)
  {
    Bundle localBundle = new Bundle();
    if (paramView != null) {
      localBundle.putParcelable("KEY_THUMBNAL_BOUND", zjc.a(paramView));
    }
    localBundle.putBoolean("is_one_item", paramBoolean1);
    localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean2);
    localBundle.putBoolean(biqe.b, paramBoolean3);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)))
    {
      paramView = ((FragmentActivity)paramContext).getChatFragment();
      if (paramView == null) {
        QLog.d("PicItemBuilder", 1, "enterImagePreview  chatFragment is null.");
      }
    }
    else
    {
      if (paramSessionInfo.jdField_a_of_type_Int == 1)
      {
        localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
        localBundle.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
        localBundle.putString("extra.GROUP_CODE", paramSessionInfo.b);
        localBundle.putBoolean("extra.IS_HOT_CHAT", auud.a(paramChatMessage));
      }
      if ((paramSessionInfo.jdField_a_of_type_Int != 1) && (paramSessionInfo.jdField_a_of_type_Int != 3000)) {
        break label445;
      }
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
      label183:
      if (paramMessageForReplyText == null) {
        break label457;
      }
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
      label201:
      localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
      paramMessageForReplyText = paramChatMessage.selfuin;
      paramView = paramMessageForReplyText;
      if (!paramChatMessage.isMultiMsg) {}
    }
    try
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramView = paramMessageForReplyText;
      if ((localAppRuntime instanceof QQAppInterface)) {
        paramView = localAppRuntime.getAccount();
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        paramView = paramMessageForReplyText;
      }
      paramView = (auqc)paramQQAppInterface.getManager(324);
      paramBoolean1 = paramView.a(paramChatMessage);
      localBundle.putBoolean("extra.IS_SAVING_FILE", paramBoolean1);
      if (!paramBoolean1) {
        break label550;
      }
      paramView = paramView.a(paramView.a(paramChatMessage));
      if ((paramView == null) || (paramView.d != 1)) {
        break label550;
      }
      localBundle.putInt("extra.SAVE_FILE_PROGRESS", paramView.jdField_c_of_type_Int);
      m = -1;
      if ((paramContext instanceof SplashActivity)) {
        break label567;
      }
    }
    paramBoolean1 = avvi.a(paramQQAppInterface.getCurrentAccountUin(), 1);
    localBundle.putBoolean("extra.OCR", paramBoolean1);
    if (paramBoolean1)
    {
      paramMessageForReplyText = avvi.a(paramQQAppInterface.getCurrentAccountUin());
      if (!TextUtils.isEmpty(paramMessageForReplyText)) {
        localBundle.putString("extra.OCR_TEXT", paramMessageForReplyText);
      }
    }
    localBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
    localBundle.putString("uin", paramChatMessage.frienduin);
    paramSessionInfo = new AIOImageProviderService(paramView, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage);
    if ((paramView == null) || (paramChatMessage.frienduin == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("PicItemBuilder", 2, "PicItemBuilder.enterImagePreview() selfUin || pic.frienduin is null");
      }
    }
    label445:
    label457:
    label716:
    for (;;)
    {
      return;
      paramView = paramView.a();
      if (paramView == null)
      {
        QLog.d("PicItemBuilder", 1, "enterImagePreview  BaseChatPie is null.");
        break;
      }
      int m = paramView.f();
      localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", m);
      if (m != 1) {
        break;
      }
      paramView = (InputMethodManager)paramContext.getSystemService("input_method");
      if (paramView == null) {
        break;
      }
      paramView.toggleSoftInput(1, 0);
      break;
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
      break label183;
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramChatMessage.isMultiMsg);
      break label201;
      if ((paramContext instanceof ChatActivity))
      {
        m = 1;
        if (!(paramChatMessage instanceof MessageForPic)) {
          break label680;
        }
        localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        biqe.a(paramContext, localBundle, paramSessionInfo, agjb.a((MessageForPic)paramChatMessage), -1, m);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label716;
        }
        QLog.i("PicItemBuilder", 2, "PicItemBuilder.enterImagePreview()");
        return;
        if (((paramContext instanceof ChatHistoryActivity)) || ((paramContext instanceof ChatHistory)))
        {
          m = 2;
          break;
        }
        if ((paramContext instanceof PublicFragmentActivity))
        {
          if (!(((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment)) {
            break;
          }
          m = 2;
          break;
        }
        if (!(paramContext instanceof MultiForwardActivity)) {
          break;
        }
        m = 5;
        break;
        if ((paramChatMessage instanceof MessageForTroopFile))
        {
          localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
          biqe.a(paramContext, localBundle, paramSessionInfo, agjb.a((MessageForTroopFile)paramChatMessage, paramQQAppInterface), -1, m);
        }
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, BaseChatItemLayout paramBaseChatItemLayout, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, View.OnClickListener paramOnClickListener)
  {
    if ((!(paramMessageRecord instanceof MessageForPic)) || (((MessageForPic)paramMessageRecord).picExtraData == null) || (!((MessageForPic)paramMessageRecord).picExtraData.isSelfieFace()) || (!((apno)paramQQAppInterface.getManager(334)).c())) {
      return;
    }
    paramSessionInfo = paramBaseChatItemLayout.getContext();
    RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseChatItemLayout.findViewById(2131377120);
    paramQQAppInterface = paramQQAppInterface.getApp().getString(2131692048);
    if ((((paramSessionInfo instanceof ChatActivity)) || ((paramSessionInfo instanceof SplashActivity))) && (!(paramSessionInfo instanceof MultiForwardActivity))) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramBaseChatItemLayout, paramMessageRecord, paramOnClickListener, paramSessionInfo, localRelativeLayout, paramQQAppInterface, null, 2130837833, bool);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramQQAppInterface, -2, paramString1, paramString2, paramString3, paramString4);
  }
  
  private void a(MessageForPic paramMessageForPic, Rect paramRect)
  {
    AIOEmotionFragment.a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramRect);
  }
  
  public static void a(MessageForPic paramMessageForPic, String paramString1, String paramString2)
  {
    a(paramMessageForPic, paramString1, paramString2, null);
  }
  
  public static void a(MessageForPic paramMessageForPic, String paramString1, String paramString2, Throwable paramThrowable)
  {
    baws.a(paramMessageForPic.istroop, paramMessageForPic.isSendFromLocal(), 65537, String.valueOf(paramMessageForPic.uniseq), "PicItemBuilder." + paramString1, paramString2, paramThrowable);
  }
  
  private void a(String paramString)
  {
    ((aufn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).b(paramString, new afwx(this, paramString));
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, URL paramURL)
  {
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    boolean bool2 = azqb.a();
    if (!bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("t_gif", 2, "needShowGifTag isbigThumb false");
      }
      return false;
    }
    paramContext = baqn.d(paramURL.toString());
    if ((paramContext != null) && (paramContext.endsWith("_big400"))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("t_gif", 2, "needShowGifTag isgif=" + paramBoolean1 + "isthumb=" + paramBoolean2 + "w=" + paramInt1 + "h=" + paramInt2 + "==100*density=" + 100.0F * f1 + "isbugThumb=" + bool2 + "isthumb400=" + bool1);
      }
      if ((!paramBoolean1) || (!paramBoolean2) || (paramInt1 < 100.0F * f1) || (paramInt2 < f1 * 100.0F) || (!bool2) || (!bool1)) {
        break;
      }
      return true;
    }
  }
  
  private boolean a(bdpi parambdpi, MessageForPic paramMessageForPic, boolean paramBoolean)
  {
    if (!ahbf.a(paramMessageForPic)) {
      return false;
    }
    if ((paramBoolean) && (paramMessageForPic.isSend()) && (paramMessageForPic.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForPic))) {
      a(parambdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForPic);
    }
    a(parambdpi, paramMessageForPic);
    if (!paramMessageForPic.isSend()) {
      parambdpi.a(2131375676, this.jdField_a_of_type_AndroidContentContext.getString(2131721510), 2130847394);
    }
    return true;
  }
  
  public static boolean a(MessageForPic paramMessageForPic)
  {
    boolean bool = false;
    if (paramMessageForPic.checkGif()) {}
    do
    {
      return true;
      if (paramMessageForPic.picExtraData != null)
      {
        paramMessageForPic = paramMessageForPic.picExtraData;
        if ((paramMessageForPic.isCustomFace()) || (paramMessageForPic.isDiyDouTu()) || (paramMessageForPic.isHotPics()) || (paramMessageForPic.isZhitu()) || (paramMessageForPic.isSelfieFace())) {
          bool = true;
        }
        return bool;
      }
    } while (auud.a(paramMessageForPic));
    return false;
  }
  
  private void b(MessageForPic paramMessageForPic)
  {
    ThreadManager.post(new PicItemBuilder.6(this, paramMessageForPic), 5, null, false);
    if (paramMessageForPic.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    awjv localawjv = new awjv();
    localawjv.a(paramMessageForPic.path);
    localawjv.d(5);
    localawjv.d(paramMessageForPic.frienduin);
    if (paramMessageForPic.fileSizeFlag == 1) {
      localawjv.c(baye.e);
    }
    for (;;)
    {
      localawjv.e(paramMessageForPic.senderuin);
      localawjv.c(paramMessageForPic.selfuin);
      localawjv.e(paramMessageForPic.istroop);
      localawjv.l(paramMessageForPic.getConfessTopicId());
      localawjv.jdField_i_of_type_Int = paramMessageForPic.extLong;
      localawjv.jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
      Object localObject = new awjw();
      ((awjw)localObject).jdField_a_of_type_Long = paramMessageForPic.msgseq;
      ((awjw)localObject).jdField_b_of_type_Long = paramMessageForPic.shmsgseq;
      ((awjw)localObject).jdField_c_of_type_Long = paramMessageForPic.msgUid;
      localawjv.a((awjw)localObject);
      localawjv.b(paramMessageForPic.uniseq);
      ((axwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPic.uniseq);
      localObject = awjb.a(4, 5);
      ((awjl)localObject).a(localawjv.a());
      ((awjl)localObject).a = paramMessageForPic.picExtraData;
      awjb.a((awjl)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      localawjv.c(baye.d);
    }
  }
  
  private void b(MessageForPic paramMessageForPic, afxa paramafxa)
  {
    Object localObject;
    int m;
    if ((this.jdField_a_of_type_Auqc != null) && (paramMessageForPic != null) && (paramafxa != null))
    {
      paramMessageForPic = this.jdField_a_of_type_Auqc.a(paramMessageForPic.getPicDownloadInfo());
      localObject = this.jdField_a_of_type_Auqc.a(paramMessageForPic);
      if ((localObject != null) && (((aupy)localObject).d == 1))
      {
        if (((aupy)localObject).jdField_c_of_type_Int >= 0) {
          break label318;
        }
        m = 0;
      }
    }
    for (;;)
    {
      if ((m < 100) && (!((aupy)localObject).jdField_a_of_type_Boolean) && (paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) && (((aupy)localObject).jdField_a_of_type_Aupx != null))
      {
        ((aupy)localObject).jdField_a_of_type_Aupx.a(new afwv(this, paramafxa, paramMessageForPic));
        this.jdField_a_of_type_Auqc.a(paramMessageForPic, (aupy)localObject);
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
        ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131371945);
        ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131371945);
        ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131371945);
        ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131371945);
        ((RelativeLayout)paramafxa.jdField_a_of_type_AndroidViewView).addView(paramMessageForPic, (ViewGroup.LayoutParams)localObject);
        paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = paramMessageForPic;
        paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
        paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = false;
        paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(m);
        paramafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setShowProgress(true);
      }
      return;
      label318:
      if (((aupy)localObject).jdField_c_of_type_Int > 100) {
        m = 100;
      } else {
        m = ((aupy)localObject).jdField_c_of_type_Int;
      }
    }
  }
  
  private boolean b(MessageForPic paramMessageForPic)
  {
    return baqn.a(bayu.a(paramMessageForPic, 1, null).toString()) != null;
  }
  
  private void c(MessageForPic paramMessageForPic)
  {
    ThreadManager.post(new PicItemBuilder.7(this, paramMessageForPic), 5, null, false);
    if (paramMessageForPic.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    awjv localawjv = new awjv();
    localawjv.d(1045);
    localawjv.d(paramMessageForPic.frienduin);
    if (paramMessageForPic.fileSizeFlag == 1) {
      localawjv.c(baye.e);
    }
    for (;;)
    {
      localawjv.e(paramMessageForPic.senderuin);
      localawjv.c(paramMessageForPic.selfuin);
      localawjv.e(paramMessageForPic.istroop);
      localawjv.l(paramMessageForPic.getConfessTopicId());
      localawjv.f(paramMessageForPic.md5);
      localawjv.jdField_i_of_type_Int = paramMessageForPic.extLong;
      localawjv.jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
      localawjv.jdField_i_of_type_Boolean = true;
      Object localObject = new awjw();
      ((awjw)localObject).jdField_a_of_type_Long = paramMessageForPic.msgseq;
      ((awjw)localObject).jdField_b_of_type_Long = paramMessageForPic.shmsgseq;
      ((awjw)localObject).jdField_c_of_type_Long = paramMessageForPic.msgUid;
      localawjv.a((awjw)localObject);
      localObject = paramMessageForPic.getExtInfoFromExtStr(ayzs.t);
      String str2 = paramMessageForPic.getExtInfoFromExtStr(ayzs.s);
      long l1 = 0L;
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          l1 = Long.parseLong((String)localObject);
        }
        if (!TextUtils.isEmpty(paramMessageForPic.thumbMsgUrl))
        {
          localObject = paramMessageForPic.thumbMsgUrl;
          localawjv.a = new PhotoSendParams((String)localObject, paramMessageForPic.md5, "", l1, (int)paramMessageForPic.height, (int)paramMessageForPic.width, str2, 1);
          localObject = awjb.a(4, 1045);
          ((awjl)localObject).a(localawjv.a());
          ((awjl)localObject).a = paramMessageForPic.picExtraData;
          awjb.a((awjl)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
          localawjv.c(baye.d);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PicItemBuilder", 2, "reuploadQzonePhoto exception:", localException);
          }
          l1 = 0L;
          continue;
          String str1 = paramMessageForPic.bigThumbMsgUrl;
        }
      }
    }
  }
  
  private void d(MessageForPic paramMessageForPic)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.selfuin, paramMessageForPic.uniseq);
    if ((localObject1 != null) && ((localObject1 instanceof bark)))
    {
      ((bark)localObject1).aP_();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
    if (paramMessageForPic.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    localObject1 = new awjf();
    Object localObject2 = new awjv();
    ((awjv)localObject2).d(1009);
    ((awjv)localObject2).a(paramMessageForPic.path);
    ((awjv)localObject2).e(paramMessageForPic.istroop);
    ((awjv)localObject2).c(paramMessageForPic.selfuin);
    ((awjv)localObject2).e(paramMessageForPic.senderuin);
    ((awjv)localObject2).d(paramMessageForPic.frienduin);
    ((awjv)localObject2).jdField_i_of_type_Int = paramMessageForPic.extLong;
    ((awjv)localObject2).jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
    ((awjv)localObject2).c(baye.f);
    ((awjv)localObject2).b(paramMessageForPic.uniseq);
    ((awjf)localObject1).jdField_a_of_type_Awju = ((awjv)localObject2).a();
    if ((!bdhb.b(paramMessageForPic.path)) && ((paramMessageForPic.picExtraObject instanceof bavm)))
    {
      localObject2 = (bavm)paramMessageForPic.picExtraObject;
      awje localawje = new awje();
      localawje.a(1009);
      localawje.a(paramMessageForPic.selfuin);
      localawje.b(((bavm)localObject2).jdField_a_of_type_JavaLangString);
      localawje.b(((bavm)localObject2).jdField_a_of_type_Int);
      localawje.c(((bavm)localObject2).b);
      localawje.a(((bavm)localObject2).jdField_a_of_type_Long);
      localawje.d(paramMessageForPic.md5);
      localawje.c(paramMessageForPic.issend);
      ((awjf)localObject1).jdField_a_of_type_Awjd = localawje.a();
    }
    ((axwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPic.uniseq);
    paramMessageForPic = awjb.a(3, 1009);
    paramMessageForPic.a((awjf)localObject1);
    awjb.a(paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public static void f()
  {
    Object localObject;
    if (!g)
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
      g = true;
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
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aeqh a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (afxa)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  public aeqi a()
  {
    return new afxa(this);
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    MessageForPic localMessageForPic = (MessageForPic)paramChatMessage;
    boolean bool2 = biqe.a(localMessageForPic.imageType);
    afxa localafxa;
    try
    {
      localafxa = (afxa)paramaeqi;
      if (localafxa == null) {
        return paramView;
      }
    }
    catch (Exception paramChatMessage)
    {
      QLog.e("PicItemBuilder", 2, "picitem holer Exception e= " + paramChatMessage);
      throw new ClassCastException("picitem holer Exception e= " + paramChatMessage);
    }
    paramaeqi = paramView;
    Object localObject;
    if (paramView == null)
    {
      paramaeqi = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramaeqi.setId(2131371945);
      paramView = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      m = Build.VERSION.SDK_INT;
      if ((m == 19) || (m == 18)) {
        paramView.jdField_e_of_type_Boolean = true;
      }
      paramView.setId(2131371945);
      paramView.setAdjustViewBounds(true);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(12.0F);
      paramView.d(false);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      paramaeqi.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localafxa.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramView;
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131371945);
      ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131371945);
      paramaeqi.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localafxa.jdField_a_of_type_AndroidWidgetImageView = paramView;
      paramaeqi.setOnClickListener(this);
      super.a(paramaeqi, paramaetk);
    }
    paramView = localafxa.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
    int m = bayu.a(bool2);
    int n = bayu.b(bool2);
    paramView.setMaxWidth(m);
    paramView.setMaxHeight(m);
    paramView.setMinimumWidth(n);
    paramView.setMinimumHeight(n);
    boolean bool1;
    label340:
    int[] arrayOfInt;
    if ((!a(localMessageForPic)) && (!bool2))
    {
      bool1 = true;
      paramView.setShowEdge(bool1);
      if (jdField_e_of_type_Boolean) {
        paramView.setContentDescription(alud.a(2131708541));
      }
      a(paramChatMessage, paramaeqi, this);
      if (localMessageForPic.isSendFromLocal()) {
        break label1227;
      }
      if ((localafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) && (!this.jdField_a_of_type_Auqc.a(localMessageForPic)))
      {
        localafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
        localafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(localMessageForPic.frienduin + localMessageForPic.uniseq);
        localafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(localMessageForPic.frienduin + localMessageForPic.uniseq);
        localafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
        ((RelativeLayout)localafxa.jdField_a_of_type_AndroidViewView).removeView(localafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
        localafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
      }
      localObject = a(localMessageForPic);
      arrayOfInt = new int[2];
      int[] tmp520_518 = arrayOfInt;
      tmp520_518[0] = 0;
      int[] tmp524_520 = tmp520_518;
      tmp524_520[1] = 0;
      tmp524_520;
      if ((localafxa.jdField_a_of_type_ComTencentImageURLDrawable != null) && (localafxa.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(tmp520_518))) {
        break label1160;
      }
      if (localafxa.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        QLog.d("tdrawable", 2, "holder.d=" + localafxa.jdField_a_of_type_ComTencentImageURLDrawable.getURL() + "==url=" + tmp520_518);
      }
      paramaetk = a(this.jdField_a_of_type_AndroidContentContext, localMessageForPic, localafxa.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, tmp524_520);
      localafxa.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramaetk);
      localafxa.jdField_a_of_type_ComTencentImageURLDrawable = paramaetk;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic, 2);
      paramView = paramaetk;
      if (QLog.isColorLevel())
      {
        QLog.d("PicItemBuilder", 2, "show receive pic uniseq=" + localMessageForPic.uniseq + " url=" + tmp520_518);
        paramView = paramaetk;
      }
      label708:
      if (paramView == null) {
        QLog.d("tdrawable", 2, "d==null");
      }
      if (paramView == null) {
        break label1205;
      }
      paramView = paramView.getURL().getProtocol();
      if (QLog.isColorLevel()) {
        QLog.d("big_thumb", 2, "getview protocol=" + paramView + "isDynamic=" + bool2 + "thumbWidth=" + localMessageForPic.thumbWidth + "thumbHeight=" + localMessageForPic.thumbHeight);
      }
      long l1 = System.currentTimeMillis();
      if (!a(this.jdField_a_of_type_AndroidContentContext, bool2, paramView.equals("chatthumb"), tmp524_520[0], tmp524_520[1], (URL)tmp520_518)) {
        break label1193;
      }
      localafxa.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkDrawable(a(), aepi.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localafxa.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(0);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("big_thumb", 2, "getview setGifTag  costTime= " + (l2 - l1));
      }
      label928:
      localafxa.jdField_a_of_type_AndroidViewView = paramaeqi;
      label934:
      a(localMessageForPic, localafxa);
      if ((paramBaseChatItemLayout != null) && (!auud.a(localMessageForPic)) && (!localMessageForPic.isMultiMsg))
      {
        paramView = (DuiButtonImageView)paramBaseChatItemLayout.findViewById(2131365502);
        if (((paramChatMessage.extraflag != 32768) || (!paramChatMessage.isSendFromLocal())) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramChatMessage))) {
          break label1470;
        }
        m = 1;
        label1009:
        if ((!paramChatMessage.isDui) || (m != 0) || (!DuiButtonImageView.jdField_a_of_type_Boolean)) {
          break label1736;
        }
        if (!paramChatMessage.isSend()) {
          break label1476;
        }
        if (paramView != null)
        {
          paramView.setVisibility(8);
          paramView.e();
        }
        label1048:
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this);
      if (!((bcpg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
        break label1753;
      }
      localafxa.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    for (;;)
    {
      b(localMessageForPic, localafxa);
      paramView = paramaeqi;
      if (a((MessageForPic)paramChatMessage)) {
        break;
      }
      localafxa.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      return paramaeqi;
      bool1 = false;
      break label340;
      label1160:
      paramView = localafxa.jdField_a_of_type_ComTencentImageURLDrawable;
      tmp524_520[0] = localafxa.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
      tmp524_520[1] = localafxa.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
      break label708;
      label1193:
      localafxa.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
      break label928;
      label1205:
      localafxa.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
      QLog.d("tdrawable", 2, "not isDynamic tag gone");
      break label928;
      label1227:
      if (localafxa.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        localafxa.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
      }
      paramView = a(localMessageForPic);
      if ((localafxa.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!localafxa.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramView)))
      {
        paramaetk = a(this.jdField_a_of_type_AndroidContentContext, localMessageForPic, localafxa.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
        localafxa.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramaetk);
        localafxa.jdField_a_of_type_ComTencentImageURLDrawable = paramaetk;
        if (bool2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PicItemBuilder", 2, "predownloadDynamic pic uniseq=" + localMessageForPic.uniseq + " url=" + paramView);
          }
          a(localMessageForPic, localafxa.jdField_a_of_type_ComTencentImageURLDrawable);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PicItemBuilder", 2, "show send pic uniseq=" + localMessageForPic.uniseq + " url=" + paramView);
        }
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq);
      localafxa.jdField_a_of_type_AndroidViewView = paramaeqi;
      a(paramView, localafxa);
      if (localafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) {
        break label934;
      }
      localafxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = true;
      break label934;
      label1470:
      m = 0;
      break label1009;
      label1476:
      if (paramView == null)
      {
        paramView = new DuiButtonImageView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        paramaetk = new RelativeLayout.LayoutParams(aepi.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        paramaetk.addRule(8, 2131364173);
        paramaetk.addRule(1, 2131364173);
        paramaetk.bottomMargin = (BaseChatItemLayout.h - aepi.a(6.5F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        paramView.setId(2131365502);
        paramBaseChatItemLayout.addView(paramView, paramaetk);
        if (QLog.isColorLevel()) {
          QLog.d("PicItemBuilder", 2, "message.hasPlayedDui = " + paramChatMessage.hasPlayedDui);
        }
        if (QLog.isColorLevel()) {
          QLog.d("[Doutu]CustomFrameAnimationDrawable", 2, " message.isDui = " + paramChatMessage.isDui + ", message.hasPlayedDui = " + paramChatMessage.hasPlayedDui);
        }
        if (paramChatMessage.hasPlayedDui) {
          break label1715;
        }
        paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramView);
      }
      for (;;)
      {
        label1588:
        if (!DuiButtonImageView.jdField_a_of_type_Boolean) {
          break label1722;
        }
        paramView.setOnClickListener(this);
        paramView.setVisibility(0);
        break;
        paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
        break label1588;
        label1715:
        paramView.f();
      }
      label1722:
      paramView.setOnClickListener(null);
      paramView.setVisibility(8);
      break label1048;
      label1736:
      if (paramView == null) {
        break label1048;
      }
      paramView.setVisibility(8);
      paramView.e();
      break label1048;
      label1753:
      localafxa.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
  }
  
  public bdpi a(bdpi parambdpi, ChatMessage paramChatMessage, aeqz paramaeqz)
  {
    paramChatMessage = (MessageForPic)paramChatMessage;
    paramaeqz = (afxa)paramaeqz;
    if (aoiy.a(paramChatMessage)) {}
    boolean bool2;
    boolean bool1;
    label78:
    boolean bool3;
    label89:
    boolean bool4;
    label149:
    label155:
    label161:
    long l1;
    do
    {
      do
      {
        return parambdpi;
      } while (ApolloUtil.a(paramChatMessage));
      bool2 = bayu.a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 65537);
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (paramChatMessage.isSendFromLocal()) {
          bool1 = a(bool2, paramChatMessage);
        }
      }
      if (aepi.a(1) == 1)
      {
        bool2 = true;
        if (aepi.a(5) != 1) {
          break label149;
        }
        bool3 = true;
        if (TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sticker_info"))) {
          break label155;
        }
      }
      for (bool4 = true;; bool4 = false)
      {
        this.j = true;
        if (paramChatMessage.isSendFromLocal()) {
          break label161;
        }
        if (paramaeqz.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) {
          break;
        }
        a(parambdpi, bool4, bool2, bool1, bool3);
        return parambdpi;
        bool2 = false;
        break label78;
        bool3 = false;
        break label89;
      }
      if (paramChatMessage.size > 0L)
      {
        a(parambdpi, bool4, bool2, bool1, bool3);
        return parambdpi;
      }
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if (!(paramChatMessage instanceof barf)) {
        break;
      }
      paramChatMessage = (barf)paramChatMessage;
      l1 = paramChatMessage.c();
    } while ((l1 != 1005L) && (l1 != 1006L) && (l1 != 1004L) && (paramChatMessage.d() != 1003L));
    a(parambdpi, bool4, bool2, bool1, bool3);
    return parambdpi;
    a(parambdpi, bool4, bool2, bool1, bool3);
    return parambdpi;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bdil.a(paramChatMessage.issend)) {
      return alud.a(2131708542);
    }
    return alud.a(2131708543);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForPic)))
    {
      localObject = (MessageForPic)paramChatMessage;
      if (paramInt != 2131366760) {
        break label313;
      }
      paramContext = a((MessageForPic)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
      if ((((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity))) && (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment() != null)) {
        paramContext.putExtra("isBack2Root", ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().j);
      }
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) {
        break label296;
      }
      paramContext.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      paramContext = aepi.a(paramContext, null);
      paramContext.putExtra("key_allow_forward_photo_preview_edit", true);
      paramContext.putExtra("selection_mode", this.jdField_b_of_type_Int);
      aryv.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "3", "", "", "");
      if (((MessageForPic)localObject).isMultiMsg)
      {
        paramInt = 4;
        if (((MessageForPic)localObject).checkGif()) {
          paramInt = 3;
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", paramInt, 0, "" + paramInt, "", "", "");
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForPic)localObject).senderuin, ((MessageForPic)localObject).md5, "0X8009F39", "");
    }
    label296:
    label313:
    label749:
    do
    {
      do
      {
        do
        {
          return;
          paramContext.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
          break;
          if (paramInt == 2131362126)
          {
            paramContext = bayu.a(bayu.a((awjs)localObject, 1), -1, -1, null, null, false);
            paramContext.setTag(localObject);
            agjb.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, ((MessageForPic)localObject).frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914), null, ((MessageForPic)localObject).picExtraData);
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "3", "", "", "");
            if (paramChatMessage.isMultiMsg)
            {
              paramInt = 1;
              if (((MessageForPic)localObject).checkGif()) {
                paramInt = 2;
              }
              azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D68", "0X8009D68", paramInt, 0, "" + paramInt, "", "", "");
            }
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForPic)localObject).senderuin, ((MessageForPic)localObject).md5, "0X8009F38", "");
            return;
          }
          if (paramInt == 2131365071)
          {
            acjm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "3", "", "", "");
            return;
          }
          if (paramInt == 2131370861)
          {
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForPic)localObject).senderuin, ((MessageForPic)localObject).md5, "0X8009F3A", "");
            super.d(paramChatMessage);
            return;
          }
          if (paramInt == 2131375747)
          {
            a((MessageForPic)localObject);
            return;
          }
          if (paramInt != 2131366017) {
            break label749;
          }
          biva.a((awge)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
          bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, 0, paramChatMessage.istroop);
        } while (!paramChatMessage.isMultiMsg);
        paramInt = 4;
        if (((MessageForPic)localObject).checkGif()) {
          paramInt = 3;
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", paramInt, 0, "" + paramInt, "", "", "");
        return;
        if (paramInt == 2131363923)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          b();
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800409A", "0X800409A", 0, 0, "", "", "", "");
          return;
        }
        if (paramInt == 2131363913)
        {
          paramContext = new afwy(this);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramContext);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800409B", "0X800409B", 0, 0, "", "", "", "");
          return;
        }
        if (paramInt == 2131370850)
        {
          super.d(paramChatMessage);
          return;
        }
        if (paramInt == 2131370818)
        {
          super.a(paramChatMessage);
          return;
        }
        if (paramInt != 2131375676) {
          break label1088;
        }
        if (!nav.a(paramChatMessage)) {
          break label1049;
        }
        paramContext = nav.a(paramChatMessage);
        if ((paramContext.jdField_a_of_type_JavaLangString != null) || (paramContext.jdField_a_of_type_Int == 2)) {
          break label977;
        }
      } while (!QLog.isColorLevel());
      QLog.i("PicItemBuilder", 2, "Anonymous report : an_id is null");
      return;
      localObject = paramContext.a();
    } while ((localObject == null) || (paramContext.jdField_a_of_type_Int == 2));
    label977:
    paramContext = URLEncoder.encode(Base64.encodeToString((byte[])localObject, 2));
    nav.a().a(paramChatMessage.frienduin, paramContext, paramChatMessage);
    zdv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), nav.a().a(paramChatMessage.frienduin, paramContext));
    return;
    label1049:
    paramContext = paramChatMessage.senderuin;
    zdv.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, paramContext, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), zdv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), null);
    return;
    label1088:
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (aepi.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForPic)((afxa)aepi.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    } while (!paramView.isSendFromLocal());
    bhuf localbhuf = (bhuf)bhus.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbhuf.a(2131690042, 5);
    localbhuf.c(2131690648);
    localbhuf.a(new afwz(this, paramView, localbhuf));
    localbhuf.show();
  }
  
  public void a(View paramView, bass parambass, int paramInt1, int paramInt2)
  {
    afxa localafxa = (afxa)aepi.a(paramView);
    if (localafxa == null) {
      QLog.e("PicItemBuilder", 2, "handleMessage(): holder is null");
    }
    label212:
    label477:
    label489:
    label509:
    for (;;)
    {
      return;
      try
      {
        paramView = (MessageForPic)localafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if ((localafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (paramView == null))
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
        if ((paramInt1 == 2003) && (parambass.jdField_b_of_type_Int == 65537))
        {
          boolean bool = biqe.a(paramView.imageType);
          int m = localafxa.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
          int n = localafxa.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
          String str = localafxa.jdField_a_of_type_ComTencentImageURLDrawable.getURL().getProtocol();
          URL localURL = bayu.a(paramView, 65537);
          if (!a(this.jdField_a_of_type_AndroidContentContext, bool, str.equals("chatthumb"), m, n, localURL)) {
            break label477;
          }
          localafxa.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkDrawable(a(), aepi.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localafxa.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(0);
        }
      }
      if (((parambass.jdField_b_of_type_Int == 1) || (parambass.jdField_b_of_type_Int == 131075)) && (paramInt1 != 2002) && (paramInt1 != 2001)) {
        if ((paramInt1 != 1001) && (paramInt1 != 1000) && (paramInt1 != 4001) && (paramInt1 != 1002) && (paramInt1 != 1004) && (paramInt1 != 1005)) {
          break label489;
        }
      }
      for (this.k = false;; this.k = true) {
        do
        {
          if (paramView.uniseq != parambass.jdField_b_of_type_Long) {
            break label509;
          }
          a(paramView, "transf.in", "status:" + paramInt1 + ",retCode" + paramInt2 + "message.uniseq：" + paramView.uniseq + ",file.uniseq:" + parambass.jdField_b_of_type_Long);
          if (paramView.isSendFromLocal())
          {
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.frienduin, paramView.uniseq), localafxa);
            if (paramInt1 == 1005) {
              b();
            }
          }
          if (paramInt1 != 2003) {
            break;
          }
          a(paramView, localafxa);
          paramView = a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localafxa.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localafxa.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
          localafxa.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
          localafxa.jdField_a_of_type_ComTencentImageURLDrawable = paramView;
          if (localafxa.jdField_a_of_type_ComTencentImageURLDrawable == null) {
            break;
          }
          localafxa.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
          return;
          localafxa.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
          break label212;
          break;
        } while ((paramInt1 != 1007) && (paramInt1 != 1003));
      }
    }
  }
  
  void a(MessageForPic paramMessageForPic)
  {
    String str = bazl.a(paramMessageForPic);
    if (str != null)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
      return;
    }
    if (bdhb.b(paramMessageForPic.path)) {
      b(paramMessageForPic);
    }
    for (;;)
    {
      b();
      return;
      if (paramMessageForPic.isQzonePic) {
        c(paramMessageForPic);
      } else if (paramMessageForPic.picExtraFlag == baye.f) {
        d(paramMessageForPic);
      }
    }
  }
  
  void a(MessageForPic paramMessageForPic, afxa paramafxa)
  {
    if ((paramMessageForPic.picExtraData != null) && (paramMessageForPic.picExtraData.isDiyDouTu()))
    {
      paramafxa.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (!b(paramMessageForPic))
      {
        paramafxa.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837908);
        paramafxa.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  void a(MessageForPic paramMessageForPic, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getStatus() == 1) && ((paramURLDrawable.getCurrDrawable() instanceof GifDrawable))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForPic, 2);
    }
  }
  
  public boolean a(aeqi paramaeqi)
  {
    return paramaeqi instanceof afxa;
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
      if ((paramChatMessage instanceof barf))
      {
        long l1 = ((barf)paramChatMessage).c();
        if ((l1 == 1005L) || ((l1 == 1006L) && (!this.j)) || (l1 == 1004L)) {}
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
  
  boolean a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    if ((!paramBoolean) && (!paramMessageForPic.getExtInfoFromExtStr("doutu_thumb_md5").equals("")))
    {
      awju localawju = paramMessageForPic.getPicUploadInfo();
      localawju.f = paramMessageForPic.getExtInfoFromExtStr("doutu_thumb_md5");
      return baqn.a(bayu.a(localawju, 65537, null).toString()) != null;
    }
    return paramBoolean;
  }
  
  public bdpk[] a(View paramView)
  {
    paramView = (afxa)aepi.a(paramView);
    MessageForPic localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    bdpi localbdpi = new bdpi();
    if (localMessageForPic != null)
    {
      if (!localMessageForPic.isMultiMsg) {
        break label48;
      }
      a(localbdpi, localMessageForPic, paramView);
    }
    for (;;)
    {
      return localbdpi.a();
      label48:
      b(localbdpi, localMessageForPic, paramView);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "2", "", "", "");
  }
  
  public bdpi b(bdpi parambdpi, ChatMessage paramChatMessage, aeqz paramaeqz)
  {
    MessageForPic localMessageForPic = (MessageForPic)paramChatMessage;
    paramaeqz = (afxa)paramaeqz;
    if (aoiy.a(localMessageForPic)) {}
    while (ApolloUtil.a(localMessageForPic)) {
      return parambdpi;
    }
    boolean bool = bayu.a(this.jdField_a_of_type_AndroidContentContext, localMessageForPic, 65537);
    if ((!bool) && (localMessageForPic.isSendFromLocal())) {
      bool = a(bool, localMessageForPic);
    }
    for (;;)
    {
      int m;
      if (!TextUtils.isEmpty(localMessageForPic.getExtInfoFromExtStr("sticker_info")))
      {
        m = 1;
        this.j = true;
        if (localMessageForPic.isSendFromLocal()) {
          break label289;
        }
        if (paramaeqz.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
        {
          if (m != 0) {
            break label271;
          }
          if (!a(parambdpi, localMessageForPic, true))
          {
            if (aepi.a(1) == 1) {
              parambdpi.a(2131362126, this.jdField_a_of_type_AndroidContentContext.getString(2131693477), 2130838676);
            }
            if (bool) {
              parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
            }
            a(localMessageForPic, parambdpi);
            a(parambdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPic);
            a(parambdpi, localMessageForPic);
            if (aepi.a(5) == 1) {
              parambdpi.a(2131366017, this.jdField_a_of_type_AndroidContentContext.getString(2131692401), 2130838677);
            }
            b(paramChatMessage, parambdpi);
            super.c(parambdpi, this.jdField_a_of_type_AndroidContentContext);
          }
        }
      }
      for (;;)
      {
        if (ahbf.a(localMessageForPic)) {
          break label287;
        }
        super.e(parambdpi, this.jdField_a_of_type_AndroidContentContext);
        return parambdpi;
        m = 0;
        break;
        label271:
        acjm.a(parambdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
      label287:
      break;
      label289:
      if (localMessageForPic.size > 0L) {
        if (m == 0) {
          if (!a(parambdpi, localMessageForPic, true))
          {
            if (aepi.a(1) == 1) {
              parambdpi.a(2131362126, this.jdField_a_of_type_AndroidContentContext.getString(2131693477), 2130838676);
            }
            if (bool) {
              parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
            }
            a(localMessageForPic, parambdpi);
            if ((localMessageForPic.isSend()) && (localMessageForPic.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForPic))) {
              a(parambdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPic);
            }
            a(parambdpi, localMessageForPic);
            if (aepi.a(5) == 1) {
              parambdpi.a(2131366017, this.jdField_a_of_type_AndroidContentContext.getString(2131692401), 2130838677);
            }
            b(paramChatMessage, parambdpi);
            super.c(parambdpi, this.jdField_a_of_type_AndroidContentContext);
          }
        }
      }
      while (!ahbf.a(localMessageForPic))
      {
        super.e(parambdpi, this.jdField_a_of_type_AndroidContentContext);
        return parambdpi;
        acjm.a(parambdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        continue;
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq);
        if ((paramChatMessage instanceof barf))
        {
          paramChatMessage = (barf)paramChatMessage;
          long l1 = paramChatMessage.c();
          if ((l1 == 1005L) || (l1 == 1006L) || (l1 == 1004L) || (paramChatMessage.d() == 1003L))
          {
            if (m == 0)
            {
              if (!a(parambdpi, localMessageForPic, false))
              {
                if (aepi.a(1) == 1) {
                  parambdpi.a(2131362126, this.jdField_a_of_type_AndroidContentContext.getString(2131693477), 2130838676);
                }
                if (bool) {
                  parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
                }
                if (aepi.a(5) == 1) {
                  parambdpi.a(2131366017, this.jdField_a_of_type_AndroidContentContext.getString(2131692401), 2130838677);
                }
                acjm.a(parambdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                super.c(parambdpi, this.jdField_a_of_type_AndroidContentContext);
              }
            }
            else {
              acjm.a(parambdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            }
          }
          else if (m == 0)
          {
            parambdpi.a(2131363923, this.jdField_a_of_type_AndroidContentContext.getString(2131690759), 2130838667);
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              parambdpi.a(2131363913, this.jdField_a_of_type_AndroidContentContext.getString(2131690758), 2130838666);
            }
            this.l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          }
        }
        else if (m == 0)
        {
          if (!a(parambdpi, localMessageForPic, false))
          {
            if (aepi.a(1) == 1) {
              parambdpi.a(2131362126, this.jdField_a_of_type_AndroidContentContext.getString(2131693477), 2130838676);
            }
            if (bool) {
              parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
            }
            if (aepi.a(5) == 1) {
              parambdpi.a(2131366017, this.jdField_a_of_type_AndroidContentContext.getString(2131692401), 2130838677);
            }
            acjm.a(parambdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            super.c(parambdpi, this.jdField_a_of_type_AndroidContentContext);
          }
        }
        else
        {
          acjm.a(parambdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
      }
      break;
    }
  }
  
  public void d()
  {
    super.d();
    if (this.l)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.l = false;
    }
    this.j = false;
  }
  
  public void d(View paramView)
  {
    aepi.n = true;
    if (super.a()) {}
    int m;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return;
          m = paramView.getId();
          if (m != 2131364173) {
            break label613;
          }
          localObject1 = (afxa)aepi.a(paramView);
          paramView = (MessageForPic)((afxa)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          localObject2 = ((afxa)localObject1).jdField_a_of_type_ComTencentImageURLDrawable;
          if (paramView.isSendFromLocal()) {
            break;
          }
          switch (((URLDrawable)localObject2).getStatus())
          {
          default: 
            return;
          }
        } while (((URLDrawable)localObject2).isDownloadStarted());
        ((URLDrawable)localObject2).startDownload();
        return;
        if ((bdeu.a()) && (bdeu.b() < 20971520L))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, alud.a(2131708540), 0).a();
          return;
        }
        paramView = PicDownloadExplicitError.getFailedTip((URLDrawable)localObject2);
        if (paramView != null)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, paramView, 0).a();
          return;
        }
      } while (!bdhb.a(this.jdField_a_of_type_AndroidContentContext));
      ((URLDrawable)localObject2).restartDownload();
      return;
      localObject2 = (amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
        ((amdu)localObject2).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      }
      if ((paramView.picExtraData != null) && (paramView.picExtraData.isDiyDouTu())) {
        if (b(paramView)) {
          a(String.valueOf(paramView.picExtraData.emojiPkgId));
        }
      }
      for (;;)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.senderuin, paramView.md5, "0X8009F37", "");
        return;
        localObject1 = ((afxa)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
        ((BaseChatItemLayout)localObject1).setProgressVisable(false);
        localObject2 = awjb.a(6, 1536, 1);
        ((awjl)localObject2).a(paramView, paramView.getPicDownloadInfo());
        ((awjl)localObject2).a(new afww(this, (BaseChatItemLayout)localObject1));
        awjb.a((awjl)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        continue;
        if (ahbf.b(paramView))
        {
          if (!ahbf.a(paramView)) {
            a(paramView, zjc.a(((afxa)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView));
          }
        }
        else if (a(paramView)) {
          a(paramView, zjc.a(((afxa)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView));
        } else {
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, ((afxa)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, null);
        }
      }
      if (((URLDrawable)localObject2).getStatus() == 2)
      {
        if ((bdeu.a()) && (bdeu.b() < 20971520L))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, alud.a(2131708544), 0).a();
          return;
        }
        String str = PicDownloadExplicitError.getFailedTip((URLDrawable)localObject2);
        if (str != null)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
          return;
        }
        if (bdhb.a(this.jdField_a_of_type_AndroidContentContext)) {
          ((URLDrawable)localObject2).restartDownload();
        }
      }
      if ((paramView.picExtraData != null) && (paramView.picExtraData.isDiyDouTu()))
      {
        a(String.valueOf(paramView.picExtraData.emojiPkgId));
        return;
      }
      if (!ahbf.b(paramView)) {
        break;
      }
    } while (ahbf.a(paramView));
    a(paramView, zjc.a(((afxa)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView));
    return;
    if (a(paramView))
    {
      a(paramView, zjc.a(((afxa)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView));
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, ((afxa)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, null);
    return;
    label613:
    if (m == 2131365502)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicItemBuilder", 2, "[Doutu] Dui Button Clicked.");
      }
      if (QLog.isColorLevel()) {
        QLog.d("PicItemBuilder", 2, "[Doutu] Dui Button Clicked.");
      }
      localObject1 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject1 != null)
      {
        localObject2 = ((ChatFragment)localObject1).a();
        if (localObject2 != null) {
          if ((aepi.a(paramView) instanceof afxa))
          {
            localObject1 = (MessageForPic)((afxa)aepi.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if (localObject1 == null) {
              break label1008;
            }
          }
        }
      }
    }
    label1008:
    for (Object localObject1 = new apjx(((MessageForPic)localObject1).uuid, ((MessageForPic)localObject1).md5, ((MessageForPic)localObject1).groupFileID, ((MessageForPic)localObject1).rawMsgUrl, ((MessageForPic)localObject1).senderuin);; localObject1 = null)
    {
      ((BaseChatPie)localObject2).a().obtainMessage(79, localObject1).sendToTarget();
      for (;;)
      {
        super.onClick(paramView);
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("PicItemBuilder", 2, "[Doutu] curPie is null.");
          continue;
          if (QLog.isColorLevel())
          {
            QLog.d("PicItemBuilder", 2, "[Doutu] chatFragment is null.");
            continue;
            if (m == 2131364201)
            {
              localObject1 = (MessageRecord)paramView.getTag();
              if (localObject1 != null)
              {
                if (((localObject1 instanceof MessageForPic)) && (((MessageForPic)localObject1).picExtraData != null) && (((MessageForPic)localObject1).picExtraData.isSelfieFace()))
                {
                  if ((!((apno)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(334)).c()) || ((!(this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) && (!(this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity))) || ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity))) {
                    break;
                  }
                  paramView = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
                  if ((paramView != null) && (paramView.a != null)) {
                    paramView.a.t(11);
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("PicItemBuilder", 2, "mTemplateId clickViewId：" + ((MessageForPic)localObject1).picExtraData.mTemplateId);
                  }
                  bnld.b((FragmentActivity)this.jdField_a_of_type_AndroidContentContext, ((MessageForPic)localObject1).picExtraData.mTemplateId);
                  return;
                }
                ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(paramView.getContext(), (MessageRecord)localObject1);
              }
            }
          }
        }
      }
    }
  }
  
  public void e() {}
  
  public void onClick(View paramView)
  {
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwu
 * JD-Core Version:    0.7.0.1
 */