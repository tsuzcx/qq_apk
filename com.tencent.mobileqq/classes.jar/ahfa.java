import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.12;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.3;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.4;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.5;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.9;
import com.tencent.mobileqq.activity.selectable.SelectableLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class ahfa
  extends ahit
{
  protected static Drawable a;
  protected aftk a;
  protected ahfm a;
  private View.OnClickListener c;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e1e1e5"));
  }
  
  public ahfa(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Ahfm = new ahfm(null);
    this.jdField_a_of_type_Aftk = new ahfb(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new ahff(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bbep(this);
  }
  
  private int a(Bitmap paramBitmap)
  {
    int i = 0;
    int j = 0;
    long l1 = 0L;
    if (paramBitmap != null)
    {
      int k = paramBitmap.getWidth() / 2;
      int m = paramBitmap.getHeight();
      long l2 = 0L;
      long l3 = 0L;
      i = j;
      while (i < m)
      {
        j = paramBitmap.getPixel(k, i);
        l3 += Color.red(j);
        l2 += Color.green(j);
        l1 += Color.blue(j);
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, "count r=" + l3 + " g=" + l2 + " b=" + l1 + " height=" + m);
      }
      i = Color.rgb((int)l3 / m, (int)l2 / m, (int)l1 / m);
    }
    return i;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, long paramLong)
  {
    if ((paramSessionInfo.curType == 1) || (paramSessionInfo.curType == 3000)) {
      return Long.parseLong(paramSessionInfo.curFriendUin);
    }
    if (paramLong == paramQQAppInterface.getLongAccountUin()) {
      return Long.parseLong(paramSessionInfo.curFriendUin);
    }
    return paramQQAppInterface.getLongAccountUin();
  }
  
  private static ahfi a(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean)
  {
    int j = CommonImgThumbHelper.getImgThumbMaxDp(paramBoolean);
    int i = CommonImgThumbHelper.getImgThumbMinDp(paramBoolean);
    ahfi localahfi = new ahfi();
    float f1;
    if ((paramInt1 < i) || (paramInt2 < i)) {
      if (paramInt1 < paramInt2)
      {
        f1 = i / paramInt1;
        paramInt1 = (int)(paramInt2 * f1 + 0.5F);
        if (paramInt1 > j)
        {
          paramInt1 = j;
          paramInt2 = paramInt1;
          paramInt1 = i;
          paramFloat *= f1;
        }
      }
    }
    for (;;)
    {
      localahfi.jdField_a_of_type_Int = paramInt1;
      localahfi.jdField_b_of_type_Int = paramInt2;
      localahfi.jdField_a_of_type_Float = f1;
      localahfi.jdField_b_of_type_Float = paramFloat;
      return localahfi;
      break;
      f1 = i / paramInt2;
      paramInt1 = (int)(paramInt1 * f1 + 0.5F);
      if (paramInt1 > j) {
        paramInt1 = j;
      }
      for (;;)
      {
        paramInt2 = i;
        break;
      }
      if ((paramInt1 >= j) || (paramInt2 >= j)) {
        break label160;
      }
      f1 = 0.0F;
    }
    label160:
    if (paramInt1 > paramInt2)
    {
      f1 = j / paramInt1;
      label173:
      if (paramInt1 <= paramInt2) {
        break label229;
      }
    }
    label229:
    for (float f2 = i / paramInt2;; f2 = i / paramInt1)
    {
      f1 = Math.max(f1, f2);
      paramInt1 = (int)(paramInt1 * f1 + 0.5F);
      paramInt2 = (int)(paramInt2 * f1 + 0.5F);
      break;
      f1 = j / paramInt2;
      break label173;
    }
  }
  
  private static ahfi a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt)
  {
    ahfi localahfi = new ahfi();
    Object localObject3 = null;
    boolean bool = blvp.a(paramMessageForPic.imageType);
    URL localURL2;
    Object localObject1;
    if ((paramMessageForPic.imageType == 3) || (paramMessageForPic.imageType == 2000))
    {
      ahcj.e();
      if (ahcj.h)
      {
        localURL2 = URLDrawableHelper.getURL(paramMessageForPic, 1, null);
        localObject1 = AbsDownloader.getFile(localURL2.toString());
        if (localObject1 != null)
        {
          try
          {
            localObject4 = NativeGifImage.getImageSize((File)localObject1, false);
            localObject3 = localObject4;
            localObject1 = localURL2;
          }
          catch (Throwable localThrowable1)
          {
            for (;;)
            {
              Object localObject4;
              label139:
              localObject2 = null;
            }
          }
          try
          {
            if (QLog.isColorLevel())
            {
              QLog.d("ReplyTextItemBuilder", 2, "getThumbDrawable,using GIF_BIG,uniseq:" + paramMessageForPic.uniseq + " url:" + localURL2);
              localObject1 = localURL2;
              localObject3 = localObject4;
            }
          }
          catch (Throwable localThrowable2)
          {
            localObject3 = localMalformedURLException;
            localURL1 = localURL2;
            break label139;
          }
          localahfi.jdField_a_of_type_Boolean = true;
          localahfi.jdField_a_of_type_AndroidGraphicsRect = localObject3;
          localahfi.jdField_a_of_type_JavaNetURL = ((URL)localObject1);
        }
      }
    }
    for (;;)
    {
      localObject4 = localObject1;
      if (localObject1 == null) {
        localObject1 = URLDrawableHelper.getURL(paramMessageForPic, 65537, null);
      }
      try
      {
        localObject4 = new URL(((URL)localObject1).toString());
        localObject1 = localObject4;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        int k;
        float f;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ReplyTextItemBuilder", 2, "group emo new URL error!");
          }
          localMalformedURLException.printStackTrace();
        }
        paramContext = AbsDownloader.getFile((String)localObject1);
        if (paramContext == null) {
          break label430;
        }
        a(paramArrayOfInt, localObject3, bool, k, paramContext, f);
        return localahfi;
        int i = paramMessageForPic.thumbWidth;
        int j = paramMessageForPic.thumbHeight;
        if ((i <= 0) || (j <= 0)) {
          break label525;
        }
        paramContext = a(i, j, 0.0F, bool);
        j = paramContext.jdField_a_of_type_Int;
        for (i = paramContext.jdField_b_of_type_Int;; i = 99)
        {
          f = k / 160.0F;
          j = (int)(j * f + 0.5F);
          i = (int)(i * f + 0.5F);
          if (paramArrayOfInt == null) {
            break;
          }
          paramArrayOfInt[0] = j;
          paramArrayOfInt[1] = i;
          return localahfi;
          if (QLog.isColorLevel()) {
            QLog.d("ReplyTextItemBuilder", 2, "MessageForPic without width/height of thumb, width = " + i + ", height = " + j);
          }
          j = 99;
        }
      }
      localObject4 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("ReplyTextItemBuilder", 2, "getThumbDrawable,using thumb,uniseq:" + paramMessageForPic.uniseq + " url:" + localObject1);
        localObject4 = localObject1;
      }
      localObject1 = ((URL)localObject4).toString();
      k = paramContext.getResources().getDisplayMetrics().densityDpi;
      if (paramChatThumbView != null) {
        paramChatThumbView.jdField_a_of_type_Boolean = false;
      }
      f = k / 160.0F;
      if (BaseApplicationImpl.sImageCache.get(localObject1) != null)
      {
        paramContext = URLDrawableHelper.getDrawable((URL)localObject4, 0, 0, null, null, true, 12.0F * f);
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt[0] = paramContext.getIntrinsicWidth();
          paramArrayOfInt[1] = paramContext.getIntrinsicHeight();
          if (QLog.isColorLevel()) {
            QLog.d("ReplyTextItemBuilder", 2, "getNoRoundThumbDrawableAbsDownloader cache:" + paramArrayOfInt[0] + "," + paramArrayOfInt[1]);
          }
        }
        return localahfi;
      }
      label430:
      Object localObject2;
      label525:
      URL localURL1 = null;
      break;
      localObject3 = null;
      localURL1 = null;
    }
  }
  
  private static ahfj a(MessageForMixedMsg paramMessageForMixedMsg)
  {
    boolean bool2 = true;
    Object localObject2 = null;
    int m = 0;
    Object localObject3 = "";
    int n = 0;
    int j = 0;
    boolean bool1 = false;
    Object localObject4;
    int k;
    int i;
    Object localObject1;
    if (m < paramMessageForMixedMsg.msgElemList.size())
    {
      if (!(paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForText))
      {
        localObject4 = localObject3;
        k = n;
        i = j;
        if (!(paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForReplyText)) {}
      }
      else
      {
        localObject4 = localObject3;
        k = n;
        i = j;
        if (n == 0)
        {
          if (!(paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForText)) {
            break label289;
          }
          localObject4 = (MessageForText)paramMessageForMixedMsg.msgElemList.get(m);
          if (((MessageForText)localObject4).sb == null) {
            break label267;
          }
          localObject1 = ((MessageForText)localObject4).sb.toString();
          localObject4 = localObject1;
          k = n;
          i = j;
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject4 = localObject1;
            k = n;
            i = j;
            if (!((String)localObject1).equals("\n"))
            {
              if (!bool1) {
                break label395;
              }
              i = 2;
              k = 1;
            }
          }
        }
      }
      for (localObject4 = localObject1;; localObject4 = localObject1)
      {
        if ((!(paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForPic)) || (bool1)) {
          break label406;
        }
        localObject1 = (MessageForPic)paramMessageForMixedMsg.msgElemList.get(m);
        MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject1, paramMessageForMixedMsg);
        if (k == 0) {
          break label441;
        }
        localObject3 = localObject4;
        bool1 = bool2;
        label252:
        return new ahfj((MessageForPic)localObject1, (String)localObject3, i, bool1);
        label267:
        localObject1 = localObject3;
        if (((MessageForText)localObject4).msg == null) {
          break;
        }
        localObject1 = ((MessageForText)localObject4).msg;
        break;
        label289:
        localObject1 = localObject3;
        if (!(paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForReplyText)) {
          break;
        }
        localObject1 = localObject3;
        if (((MessageForReplyText)paramMessageForMixedMsg.msgElemList.get(m)).sb == null) {
          break;
        }
        localObject4 = (MessageForReplyText)paramMessageForMixedMsg.msgElemList.get(m);
        if (((MessageForReplyText)localObject4).sb != null)
        {
          localObject1 = ((MessageForReplyText)localObject4).sb.toString();
          break;
        }
        localObject1 = localObject3;
        if (((MessageForReplyText)localObject4).msg == null) {
          break;
        }
        localObject1 = ((MessageForReplyText)localObject4).msg;
        break;
        label395:
        k = 1;
        i = 1;
      }
      label406:
      localObject1 = localObject2;
    }
    for (;;)
    {
      m += 1;
      localObject2 = localObject1;
      localObject3 = localObject4;
      n = k;
      j = i;
      break;
      localObject1 = localObject2;
      i = j;
      break label252;
      label441:
      bool1 = true;
    }
  }
  
  private static Bitmap a()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageHashMap != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageHashMap.get("static://GrayCommonProgress");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = bgyo.a(BaseApplicationImpl.getContext().getResources(), 2130840930);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageHashMap != null)
        {
          BaseApplicationImpl.sImageHashMap.put("static://GrayCommonProgress", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  private View a(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext, ahfk paramahfk, MessageForReplyText paramMessageForReplyText, aftk paramaftk, boolean paramBoolean)
  {
    paramahfk.e = 0;
    Object localObject2 = this.jdField_a_of_type_Ahfm.a(0);
    Object localObject1 = localObject2;
    int j;
    int i;
    if (localObject2 == null)
    {
      localObject1 = new SelectableLinearLayout(paramContext);
      ((LinearLayout)localObject1).setOrientation(1);
      Object localObject3 = a(paramContext);
      paramahfk.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject3);
      paramahfk.c = ((TextView)((ViewGroup)localObject3).findViewById(2131378915));
      paramahfk.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject3).findViewById(2131371803));
      paramahfk.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject3).findViewById(2131367239));
      paramahfk.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject3).findViewById(2131371598));
      paramahfk.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject3).findViewById(2131371616));
      ((ViewGroup)localObject3).setId(2131364550);
      com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10(paramahfk.jdField_a_of_type_ComEtrumpMixlayoutETTextView);
      com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10(paramahfk.jdField_b_of_type_ComEtrumpMixlayoutETTextView);
      localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
      paramahfk.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)localObject3).findViewById(2131369455));
      paramahfk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      paramahfk.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131712870));
      localObject3 = new ETTextView(paramContext);
      com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10((TextView)localObject3);
      ((ETTextView)localObject3).setTextColor(paramContext.getResources().getColorStateList(2131167045));
      ((ETTextView)localObject3).setLinkTextColor(paramContext.getResources().getColorStateList(2131167038));
      ((ETTextView)localObject3).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
      ((ETTextView)localObject3).setSpannableFactory(QQText.SPANNABLE_FACTORY);
      ((ETTextView)localObject3).setMovementMethod(LinkMovementMethod.getInstance());
      j = BaseChatItemLayout.o;
      i = BaseChatItemLayout.p;
      if (paramMessageForReplyText.isSend())
      {
        j = BaseChatItemLayout.p;
        i = BaseChatItemLayout.o;
      }
      ((ETTextView)localObject3).setPadding(j, 0, i, BaseChatItemLayout.n);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = j;
      ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
      ((LinearLayout.LayoutParams)localObject2).topMargin = BaseChatItemLayout.h;
      ((LinearLayout)localObject1).addView(paramahfk.jdField_a_of_type_AndroidViewViewGroup, (ViewGroup.LayoutParams)localObject2);
      ((ETTextView)localObject3).setId(2131364525);
      paramahfk.d = ((TextView)localObject3);
      localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout.LayoutParams)localObject2).topMargin = AIOUtils.dp2px(8.0F, paramContext.getResources());
      ((LinearLayout)localObject1).addView(paramahfk.d, (ViewGroup.LayoutParams)localObject2);
    }
    paramahfk.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131371803));
    paramahfk.c = ((TextView)((View)localObject1).findViewById(2131378915));
    paramahfk.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131367239));
    paramahfk.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((View)localObject1).findViewById(2131371598));
    paramahfk.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((View)localObject1).findViewById(2131371616));
    paramahfk.d = ((ETTextView)((View)localObject1).findViewById(2131364525));
    paramahfk.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((View)localObject1).findViewById(2131364550));
    paramahfk.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369455));
    paramahfk.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131712867));
    paramahfk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    paramahfk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838310));
    if (paramMessageForReplyText.getSourceMsgInfo() != null) {}
    for (paramContext = Long.toString(paramMessageForReplyText.getSourceMsgInfo().mSourceMsgSenderUin);; paramContext = "")
    {
      paramContext = gm.a(paramContext);
      paramahfk.c.setTypeface(paramContext);
      paramahfk.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramContext);
      paramahfk.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramContext);
      paramahfk.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramContext);
      paramahfk.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramContext);
      if (!android.text.TextUtils.isEmpty(paramMessageForReplyText.getExtInfoFromExtStr("sens_msg_ctrl_info")))
      {
        paramContext = ((ETTextView)paramahfk.d).getETLayout();
        if (paramContext != null) {
          paramContext.a = (paramMessageForReplyText.uniseq + 1L);
        }
      }
      ((ETTextView)paramahfk.d).setFont(0, paramMessageForReplyText.uniseq);
      i = ((ETTextView)paramahfk.d).mMaxWidth;
      j = BaseChatItemLayout.e;
      paramahfk.d.setMaxWidth(j);
      paramahfk.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
      if (i != j) {
        ((ETTextView)paramahfk.d).mMsgId = 0L;
      }
      paramahfk.d.setText(paramMessageForReplyText.sb);
      if (AppSetting.c) {
        paramahfk.d.setContentDescription(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramMessageForReplyText.sb.toString()));
      }
      super.a(paramahfk.d, paramMessageForReplyText);
      a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramahfk.jdField_a_of_type_AndroidViewViewGroup, paramMessageForReplyText.mSourceMsgInfo, paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, paramMessageForReplyText, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      paramahfk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)((View)localObject1).findViewById(2131378885));
      paramahfk.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramahfk.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramahfk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject1).setOnTouchListener(paramaftk);
      ((View)localObject1).setOnLongClickListener(paramaftk);
      paramahfk.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramaftk);
      paramahfk.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramaftk);
      paramahfk.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnTouchListener(this.jdField_a_of_type_Aftk);
      paramahfk.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnLongClickListener(this.jdField_a_of_type_Aftk);
      paramahfk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnTouchListener(this.jdField_a_of_type_Aftk);
      paramahfk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnLongClickListener(this.jdField_a_of_type_Aftk);
      paramahfk.d.setOnTouchListener(paramaftk);
      paramahfk.d.setOnLongClickListener(paramaftk);
      paramahfk.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((paramahfk.d instanceof AnimationTextView)) {
        ((AnimationTextView)paramahfk.d).onDoubleClick = this.jdField_a_of_type_Bils;
      }
      if ((paramahfk.jdField_a_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
        paramahfk.jdField_a_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Bils;
      }
      if (paramahfk.jdField_a_of_type_Alvu == null) {
        paramahfk.jdField_a_of_type_Alvu = new alvu();
      }
      if ((localObject1 instanceof alwg))
      {
        paramahfk.jdField_a_of_type_Alvu.a((alwg)localObject1);
        paramahfk.jdField_a_of_type_Alvu.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
      }
      paramahfk.jdField_a_of_type_Alvu.b(paramMessageForReplyText);
      return localObject1;
    }
  }
  
  public static final RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131560730, null);
    Object localObject = (TextView)localRelativeLayout.findViewById(2131371803);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167045));
    ImmersiveUtils.a((View)localObject, 0.9F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((TextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    localObject = (TextView)localRelativeLayout.findViewById(2131378915);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167045));
    ImmersiveUtils.a((View)localObject, 0.9F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((TextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    localObject = (TextView)localRelativeLayout.findViewById(2131367239);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167045));
    ImmersiveUtils.a((View)localObject, 0.5F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((TextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ((ImageView)localRelativeLayout.findViewById(2131369455)).setColorFilter(null);
    localObject = (ETTextView)localRelativeLayout.findViewById(2131371598);
    ((ETTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167045));
    ((ETTextView)localObject).setLinkTextColor(paramContext.getResources().getColorStateList(2131167038));
    ImmersiveUtils.a((View)localObject, 0.9F);
    ((ETTextView)localObject).setTextSize(1, 13.0F);
    ((ETTextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((ETTextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ((ETTextView)localObject).setLineSpacing(AIOUtils.dp2px(2.0F, paramContext.getResources()), 1.0F);
    localObject = (ETTextView)localRelativeLayout.findViewById(2131371616);
    ((ETTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167045));
    ((ETTextView)localObject).setLinkTextColor(paramContext.getResources().getColorStateList(2131167038));
    ((ETTextView)localObject).setTextSize(1, 13.0F);
    ((ETTextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((ETTextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ((ETTextView)localObject).setLineSpacing(AIOUtils.dp2px(2.0F, paramContext.getResources()), 1.0F);
    return localRelativeLayout;
  }
  
  private static URLDrawable.URLDrawableOptions a(MessageForPic paramMessageForPic, int paramInt, boolean paramBoolean)
  {
    int i = 99;
    int j = paramMessageForPic.thumbWidth;
    int k = paramMessageForPic.thumbHeight;
    if ((j > 0) && (k > 0))
    {
      paramMessageForPic = a(j, k, 0.0F, paramBoolean);
      j = paramMessageForPic.jdField_a_of_type_Int;
      i = paramMessageForPic.jdField_b_of_type_Int;
    }
    for (;;)
    {
      float f = paramInt / 160.0F;
      paramInt = (int)(j * f + 0.5F);
      i = (int)(i * f + 0.5F);
      paramMessageForPic = URLDrawable.URLDrawableOptions.obtain();
      paramMessageForPic.mRequestWidth = paramInt;
      paramMessageForPic.mRequestHeight = i;
      return paramMessageForPic;
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, "MessageForPic without width/height of thumb, width = " + j + ", height = " + k);
      }
      j = 99;
    }
  }
  
  public static URLDrawable a(Context paramContext, ChatThumbView paramChatThumbView, int[] paramArrayOfInt, URL paramURL, Rect paramRect, File paramFile, boolean paramBoolean)
  {
    int k = paramContext.getResources().getDisplayMetrics().densityDpi;
    float f1 = k / 160.0F;
    int j;
    int i;
    float f2;
    if (paramRect != null)
    {
      j = paramRect.width();
      i = paramRect.height();
      paramContext = a(j, i, f1 * 12.0F, paramBoolean);
      j = paramContext.jdField_a_of_type_Int;
      i = paramContext.jdField_b_of_type_Int;
      f2 = paramContext.jdField_b_of_type_Float;
      j = (j * k + 80) / 160;
      i = (i * k + 80) / 160;
      f1 = f2;
      if (paramRect != null)
      {
        if (paramRect.width() >= j) {
          break label338;
        }
        f1 = f2 * (paramRect.width() / j);
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt[0] = j;
          paramArrayOfInt[1] = i;
        }
        paramContext = URLDrawableHelper.getDrawable(paramURL, j, i, new asbg(j, i), URLDrawableHelper.getFailedDrawable(), true, f1);
        paramContext.setIgnorePause(true);
        paramContext.setFadeInImage(true);
        if (paramChatThumbView != null) {
          paramChatThumbView.jdField_a_of_type_Boolean = true;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReplyTextItemBuilder", 2, "getNoRoundThumbDrawableAbsDownloader cache:" + j + "," + i);
        }
        return paramContext;
        paramContext = new BitmapFactory.Options();
        paramContext.inJustDecodeBounds = true;
        try
        {
          bheg.a(paramFile.getAbsolutePath(), paramContext);
          j = paramContext.outWidth;
          i = paramContext.outHeight;
          int m = URLDrawableHelper.getExifRotation(paramFile.getAbsolutePath());
          if ((m != 90) && (m != 270)) {
            break;
          }
          j = paramContext.outHeight;
          i = paramContext.outWidth;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ReplyTextItemBuilder", 2, "getThumbDrawable", localThrowable);
            }
          }
        }
      }
      label338:
      f1 = f2;
      if (paramRect.height() < i) {
        f1 = f2 * (paramRect.height() / i);
      }
    }
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt, ahfi paramahfi)
  {
    boolean bool1 = blvp.a(paramMessageForPic.imageType);
    boolean bool2 = paramahfi.jdField_a_of_type_Boolean;
    URL localURL = paramahfi.jdField_a_of_type_JavaNetURL;
    Rect localRect = paramahfi.jdField_a_of_type_AndroidGraphicsRect;
    Object localObject = localURL;
    if (localURL == null) {
      paramahfi = URLDrawableHelper.getURL(paramMessageForPic, 65537, null);
    }
    try
    {
      localObject = new URL(paramahfi.toString());
      paramahfi = (ahfi)localObject;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        float f;
        if (QLog.isColorLevel()) {
          QLog.i("ReplyTextItemBuilder", 2, "group emo new URL error!");
        }
        localMalformedURLException.printStackTrace();
        continue;
        paramahfi = AbsDownloader.getFile(paramahfi);
        if (paramahfi == null) {
          break;
        }
        paramContext = a(paramContext, paramChatThumbView, paramArrayOfInt, localMalformedURLException, localRect, paramahfi, bool1);
      }
      if (URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext)) {
        break label506;
      }
    }
    localObject = paramahfi;
    if (QLog.isColorLevel())
    {
      QLog.d("ReplyTextItemBuilder", 2, "getThumbDrawable,using thumb,uniseq:" + paramMessageForPic.uniseq + " url:" + paramahfi);
      localObject = paramahfi;
    }
    paramahfi = ((URL)localObject).toString();
    int j = paramContext.getResources().getDisplayMetrics().densityDpi;
    if (paramChatThumbView != null) {
      paramChatThumbView.jdField_a_of_type_Boolean = false;
    }
    f = j / 160.0F;
    if (BaseApplicationImpl.sImageCache.get(paramahfi) != null)
    {
      paramContext = URLDrawableHelper.getDrawable((URL)localObject, 0, 0, null, null, true, 12.0F * f);
      if (paramArrayOfInt != null)
      {
        paramArrayOfInt[0] = paramContext.getIntrinsicWidth();
        paramArrayOfInt[1] = paramContext.getIntrinsicHeight();
        if (QLog.isColorLevel()) {
          QLog.d("ReplyTextItemBuilder", 2, "getNoRoundThumbDrawableAbsDownloader cache:" + paramArrayOfInt[0] + "," + paramArrayOfInt[1]);
        }
      }
      paramContext.setTag(paramMessageForPic);
      if ((paramContext.getCurrDrawable() instanceof GifDrawable)) {
        ((GifDrawable)paramContext.getCurrDrawable()).mutate();
      }
      return paramContext;
    }
    int i = 1;
    label340:
    paramChatThumbView = a(paramMessageForPic, j, bool1);
    paramChatThumbView.mLoadingDrawable = URLDrawableHelper.getLoadingDrawable();
    paramChatThumbView.mFailedDrawable = URLDrawableHelper.getFailedDrawable();
    paramChatThumbView.mPlayGifImage = bool2;
    paramChatThumbView.mGifRoundCorner = 12.0F;
    paramChatThumbView.mImgType = paramMessageForPic.imageType;
    if (paramArrayOfInt != null)
    {
      paramArrayOfInt[0] = paramChatThumbView.mRequestWidth;
      paramArrayOfInt[1] = paramChatThumbView.mRequestHeight;
    }
    paramChatThumbView.mLoadingDrawable = paramContext.getResources().getDrawable(2130843922);
    paramContext = URLDrawable.getDrawable(localMalformedURLException, paramChatThumbView);
    if (QLog.isColorLevel()) {
      QLog.d("ReplyTextItemBuilder", 2, "getNoRoundThumbDrawableautoDownload:" + paramChatThumbView.mRequestWidth + "," + paramChatThumbView.mRequestHeight);
    }
    if ((azjw.jdField_a_of_type_Boolean) || (i != 0)) {
      paramContext.setAutoDownload(true);
    }
    for (;;)
    {
      paramContext.setProgressDrawable(new biqx(a(), 0, false));
      break;
      label506:
      i = 0;
      break label340;
      paramContext.setAutoDownload(false);
    }
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = paramMessageRecord;
    if (auea.a(paramMessageRecord)) {
      paramQQAppInterface = auea.a((ChatMessage)paramMessageRecord);
    }
    return paramQQAppInterface;
  }
  
  private static MessageRecord a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, StringBuilder paramStringBuilder, MessageRecord paramMessageRecord3, boolean paramBoolean)
  {
    int i = 1;
    for (;;)
    {
      MessageRecord localMessageRecord;
      if (i < 10)
      {
        localMessageRecord = paramQQAppInterface.getMessageFacade().queryMsgItemByShmsgseq(paramMessageRecord1.frienduin, paramMessageRecord1.istroop, paramMessageRecord2.shmsgseq + i);
        if ((localMessageRecord == null) || (!localMessageRecord.isLongMsg()) || (!(localMessageRecord instanceof MessageForText))) {
          break label93;
        }
        if (!android.text.TextUtils.isEmpty(localMessageRecord.msg)) {
          paramStringBuilder.append(localMessageRecord.msg);
        }
        if ((localMessageRecord != null) && (localMessageRecord.isLongMsg())) {
          break label197;
        }
      }
      label93:
      do
      {
        return paramMessageRecord3;
        if ((!(localMessageRecord instanceof MessageForMixedMsg)) || (!localMessageRecord.isLongMsg())) {
          break;
        }
        paramQQAppInterface = (MessageForMixedMsg)localMessageRecord;
        if (paramQQAppInterface.msgElemList != null)
        {
          i = 0;
          while (i < paramQQAppInterface.msgElemList.size())
          {
            paramMessageRecord1 = (MessageRecord)paramQQAppInterface.msgElemList.get(i);
            if ((!(paramMessageRecord1 instanceof MessageForText)) || (android.text.TextUtils.isEmpty(paramMessageRecord1.msg))) {
              break;
            }
            paramStringBuilder.append(paramMessageRecord1.msg);
            i += 1;
          }
        }
      } while (paramBoolean);
      return localMessageRecord;
      label197:
      i += 1;
    }
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().getAIOList(paramString, paramInt);
    int i = paramQQAppInterface.size();
    paramInt = 0;
    while (paramInt < i)
    {
      paramString = (ChatMessage)paramQQAppInterface.get(paramInt);
      if (paramString.shmsgseq == paramLong)
      {
        if (!paramString.mIsParsed) {
          paramString.parse();
        }
        return paramString;
      }
      paramInt += 1;
    }
    return null;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    List localList = paramQQAppInterface.getMessageFacade().getAIOList(paramString, paramInt);
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      ChatMessage localChatMessage = (ChatMessage)localList.get(i);
      if ((localChatMessage.time == paramLong1) && (localChatMessage.msgUid == paramLong2)) {
        if (!localChatMessage.mIsParsed) {
          localChatMessage.parse();
        }
      }
      do
      {
        return localChatMessage;
        if (!(localChatMessage instanceof MessageForFile)) {
          break;
        }
        MessageForFile localMessageForFile = (MessageForFile)localChatMessage;
        if ((localMessageForFile.originalTime != paramLong1) || (localMessageForFile.originalMsgUid != paramLong2)) {
          break;
        }
      } while (localChatMessage.mIsParsed);
      localChatMessage.parse();
      return localChatMessage;
      i += 1;
    }
    return a(paramQQAppInterface, paramString, paramInt, paramLong3);
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, MessageRecord paramMessageRecord, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if (((paramMessageRecord instanceof MessageForReplyText)) && (((MessageForReplyText)paramMessageRecord).getSourceMessage() != null))
    {
      paramString = ((MessageForReplyText)paramMessageRecord).getSourceMessage();
      return paramString;
    }
    if ((paramMessageRecord == null) || (paramMessageRecord.isMultiMsg))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, "REPLY getMessage  replyTextMsg=" + paramMessageRecord);
      }
      return null;
    }
    if (paramInt == 0) {}
    for (paramQQAppInterface = a(paramQQAppInterface, paramString, paramInt, paramSourceMsgInfo.mSourceMsgTime, paramSourceMsgInfo.origUid, paramSourceMsgInfo.mSourceMsgSeq);; paramQQAppInterface = a(paramQQAppInterface, paramString, paramInt, paramSourceMsgInfo.mSourceMsgSeq))
    {
      paramString = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        break;
      }
      paramString = paramQQAppInterface;
      if (!(paramMessageRecord instanceof MessageForReplyText)) {
        break;
      }
      ((MessageForReplyText)paramMessageRecord).setSourceMessageRecord(paramQQAppInterface);
      return paramQQAppInterface;
    }
  }
  
  @Nullable
  private static String a(Context paramContext, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    long l;
    if ((paramMessageRecord1 instanceof MessageForReplyText))
    {
      localObject1 = localObject2;
      if (((MessageForReplyText)paramMessageRecord1).isBarrageMsg)
      {
        l = ((MessageForReplyText)paramMessageRecord1).barrageTimeLocation;
        if (!(paramMessageRecord2 instanceof MessageForShortVideo)) {
          break label60;
        }
        localObject1 = aqsl.a(paramContext, (int)(l / 1000L));
      }
    }
    label60:
    do
    {
      return localObject1;
      localObject1 = localObject2;
    } while (!auea.a(paramMessageRecord2));
    paramMessageRecord1 = a(paramQQAppInterface, paramMessageRecord2);
    if ((paramMessageRecord1 instanceof MessageForFile))
    {
      paramQQAppInterface = paramQQAppInterface.getFileManagerDataCenter().a(paramMessageRecord1.uniseq, paramMessageRecord1.frienduin, paramMessageRecord1.istroop);
      if ((paramQQAppInterface == null) || (auea.a(paramQQAppInterface.fileName) != 2)) {
        break label188;
      }
    }
    label188:
    for (paramContext = aqsl.a(paramContext, (int)(l / 1000L));; paramContext = null)
    {
      return paramContext;
      localObject1 = localObject2;
      if (!(paramMessageRecord1 instanceof MessageForTroopFile)) {
        break;
      }
      paramQQAppInterface = bgke.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord1);
      localObject1 = localObject2;
      if (paramQQAppInterface == null) {
        break;
      }
      localObject1 = localObject2;
      if (auea.a(paramQQAppInterface.g) != 2) {
        break;
      }
      return aqsl.a(paramContext, (int)(l / 1000L));
    }
  }
  
  @Nullable
  private static String a(QQAppInterface paramQQAppInterface, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, MessageRecord paramMessageRecord1, String paramString, MessageRecord paramMessageRecord2)
  {
    String str = null;
    if ((paramMessageRecord2 instanceof MessageForFile))
    {
      if (((MessageForFile)paramMessageRecord2).fileName == null) {
        break label370;
      }
      paramQQAppInterface = ((MessageForFile)paramMessageRecord2).getSummaryMsg();
      paramSourceMsgInfo.mSourceMsgText = paramQQAppInterface;
      paramSourceMsgInfo.mSourceSummaryFlag = 1;
    }
    label370:
    label375:
    for (;;)
    {
      Object localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        localObject = paramSourceMsgInfo.mSourceMsgText;
      }
      if ((paramMessageRecord2 != null) && (paramMessageRecord2.shmsgseq == paramMessageRecord1.shmsgseq))
      {
        return paramString;
        if ((paramMessageRecord2 instanceof MessageForTroopFile))
        {
          if (((MessageForTroopFile)paramMessageRecord2).fileName != null) {
            str = ((MessageForTroopFile)paramMessageRecord2).getSummaryMsg();
          }
          localObject = str;
          if (android.text.TextUtils.isEmpty(str))
          {
            paramQQAppInterface = bgke.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord2);
            localObject = str;
            if (paramQQAppInterface != null) {
              localObject = paramQQAppInterface.g;
            }
          }
          paramQQAppInterface = (QQAppInterface)localObject;
          if (android.text.TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = paramMessageRecord2.getExtInfoFromExtStr("_m_ForwardFileName");
            paramQQAppInterface = (QQAppInterface)localObject;
            if (!android.text.TextUtils.isEmpty((CharSequence)localObject)) {
              paramQQAppInterface = anvx.a(2131706040) + (String)localObject;
            }
          }
          if (android.text.TextUtils.isEmpty(paramQQAppInterface)) {
            break label375;
          }
          paramSourceMsgInfo.mSourceMsgText = paramQQAppInterface;
          paramSourceMsgInfo.mSourceSummaryFlag = 1;
          continue;
        }
        if (paramMessageRecord2 != null) {
          for (;;)
          {
            try
            {
              if (!((ChatMessage)paramMessageRecord2).mIsParsed) {
                ((ChatMessage)paramMessageRecord2).parse();
              }
              if (!(paramMessageRecord2 instanceof MessageForReplyText)) {
                continue;
              }
              if (((MessageForReplyText)paramMessageRecord2).sb != null) {
                continue;
              }
              QLog.e("ReplyTextItemBuilder", 2, "MessageForReplyText.sb is null");
              if (paramMessageRecord2.msg == null) {
                continue;
              }
              paramQQAppInterface = paramMessageRecord2.msg;
            }
            catch (Throwable localThrowable)
            {
              paramQQAppInterface = "";
              QLog.e("ReplyTextItemBuilder", 2, new Object[] { "msg.getSummaryMsg error, msg type=", paramMessageRecord2.getClass().getName(), localThrowable });
              continue;
            }
            paramSourceMsgInfo.mSourceMsgText = paramQQAppInterface;
            paramSourceMsgInfo.mSourceSummaryFlag = 1;
            break;
            paramQQAppInterface = "";
            continue;
            paramQQAppInterface = ((MessageForReplyText)paramMessageRecord2).getSummaryMsg();
            continue;
            paramQQAppInterface = ((ChatMessage)paramMessageRecord2).getSummaryMsg();
          }
        }
      }
      else
      {
        return localThrowable;
      }
      paramQQAppInterface = null;
    }
  }
  
  private static void a(Context paramContext, ChatThumbView paramChatThumbView, arts paramarts, MessageForPic paramMessageForPic)
  {
    boolean bool = blvp.a(paramMessageForPic.imageType);
    if (!bool)
    {
      paramContext = ahcj.a(paramContext, paramMessageForPic, paramChatThumbView);
      if (paramContext != null)
      {
        paramChatThumbView.setAdjustViewBounds(true);
        paramChatThumbView.setMaxWidth(CommonImgThumbHelper.getImgThumbMaxPx(false));
        paramChatThumbView.setMaxHeight(CommonImgThumbHelper.getImgThumbMaxPx(false));
        paramChatThumbView.setImageDrawable(paramContext.mutate());
      }
      paramChatThumbView.setTag(2131364536, paramMessageForPic);
      return;
    }
    int[] arrayOfInt = new int[2];
    int[] tmp70_68 = arrayOfInt;
    tmp70_68[0] = 0;
    int[] tmp74_70 = tmp70_68;
    tmp74_70[1] = 0;
    tmp74_70;
    URL localURL = URLDrawableHelper.getURL(paramMessageForPic, 65537);
    try
    {
      localURL = new URL(localURL.toString());
      if (localURL == null)
      {
        paramChatThumbView.setImageDrawable(ahkv.a(2, 200, 200));
        return;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ReplyTextItemBuilder", 2, "group emo new URL error!");
        }
        localMalformedURLException.printStackTrace();
        localahfi = null;
      }
      ahfi localahfi = a(paramContext, paramMessageForPic, paramChatThumbView, arrayOfInt);
      paramContext = a(paramContext, paramMessageForPic, paramChatThumbView, new int[] { 0, 0 }, localahfi);
      paramChatThumbView.setTag(2131364536, paramMessageForPic);
      if (arrayOfInt[0] <= 0) {
        break label426;
      }
    }
    int j;
    int n;
    label250:
    int i1;
    int i2;
    label272:
    int k;
    label295:
    int m;
    if (arrayOfInt[1] > 0)
    {
      paramMessageForPic = (RelativeLayout.LayoutParams)paramChatThumbView.getLayoutParams();
      j = CommonImgThumbHelper.getImgThumbMaxPx(bool);
      n = Math.min(CommonImgThumbHelper.getImgThumbMinPx(bool), 80);
      if (arrayOfInt[0] <= j) {
        break label439;
      }
      i = j;
      if (arrayOfInt[1] <= j) {
        break label448;
      }
      i1 = AIOUtils.dp2px(95.0F, paramChatThumbView.getResources());
      if (i <= j) {
        break label457;
      }
      i2 = 0;
      if ((i2 != 0) || (i <= i1)) {
        break label470;
      }
      if (i1 >= n) {
        break label463;
      }
      k = n;
      m = arrayOfInt[1] * k / arrayOfInt[0];
    }
    label426:
    label439:
    label448:
    label457:
    label463:
    label470:
    do
    {
      do
      {
        paramMessageForPic.width = k;
        paramMessageForPic.height = m;
        if (paramarts != null)
        {
          if (paramarts.getSourceMsgInfo() != null)
          {
            paramarts.getSourceMsgInfo().replyPicWidth = k;
            paramarts.getSourceMsgInfo().replyPicHeight = m;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReplyTextItemBuilder", 2, "set size :" + arrayOfInt[0] + "," + arrayOfInt[1] + " real:" + k + "," + m);
          }
        }
        paramChatThumbView.setImageDrawable(paramContext.mutate());
        a(paramContext);
        return;
        i = arrayOfInt[0];
        break;
        j = arrayOfInt[1];
        break label250;
        i2 = 1;
        break label272;
        k = i1;
        break label295;
        k = i;
        m = j;
      } while (i2 == 0);
      k = i;
      m = j;
    } while (j <= i1);
    if (i1 < n) {}
    for (int i = n;; i = i1)
    {
      k = arrayOfInt[0] * i / arrayOfInt[1];
      m = i;
      break;
    }
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, MessageRecord paramMessageRecord1, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord2)
  {
    int j = 4;
    Object localObject;
    ImageView localImageView;
    if ((paramMessageRecord1 instanceof MessageForReplyText))
    {
      localObject = (MessageForReplyText)paramMessageRecord1;
      boolean bool = MessageForReplyText.needHideLocate((MessageForReplyText)localObject);
      localObject = (TextView)paramViewGroup.findViewById(2131367239);
      localImageView = (ImageView)paramViewGroup.findViewById(2131369455);
      if (!a(paramSourceMsgInfo, paramSessionInfo, paramQQAppInterface)) {
        break label123;
      }
      paramContext = a(paramContext, paramQQAppInterface, paramMessageRecord1, paramMessageRecord2);
      if (paramContext == null) {
        break label107;
      }
      ((TextView)localObject).setText(paramContext);
      ((TextView)localObject).setVisibility(0);
      label85:
      if (!bool) {
        break label117;
      }
    }
    label107:
    label117:
    for (int i = 4;; i = 0)
    {
      localImageView.setVisibility(i);
      return;
      localObject = null;
      break;
      ((TextView)localObject).setVisibility(8);
      break label85;
    }
    label123:
    paramViewGroup = paramContext.getString(2131698780);
    if (!android.text.TextUtils.isEmpty(paramSourceMsgInfo.mSourceMsgTroopName))
    {
      paramMessageRecord1 = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramSourceMsgInfo.mSourceMsgToUin + "");
      paramViewGroup = paramSourceMsgInfo.mSourceMsgTroopName;
      paramQQAppInterface = paramViewGroup;
      if (paramMessageRecord1 != null)
      {
        paramQQAppInterface = paramViewGroup;
        if (!android.text.TextUtils.isEmpty(paramMessageRecord1.getTroopName())) {
          paramQQAppInterface = paramMessageRecord1.getTroopName();
        }
      }
      paramViewGroup = paramContext.getString(2131698779) + paramQQAppInterface;
    }
    ((TextView)localObject).setText(paramViewGroup);
    ((TextView)localObject).setVisibility(0);
    paramContext = ((FragmentActivity)paramContext).getChatFragment();
    if ((paramContext != null) && ((paramContext.a() instanceof aict))) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {}
      for (i = j;; i = 0)
      {
        localImageView.setVisibility(i);
        return;
      }
    }
  }
  
  private static final void a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    BubbleImageView localBubbleImageView = (BubbleImageView)paramViewGroup.findViewById(2131378885);
    int i = paramViewGroup.findViewById(2131371803).getPaddingLeft();
    localBubbleImageView.setRadius(0.0F);
    localBubbleImageView.setAdjustViewBounds(true);
    localBubbleImageView.d(false);
    localBubbleImageView.setShowEdge(true);
    if ((paramMessageRecord2 instanceof MessageForShortVideo)) {
      localBubbleImageView.setContentDescription(anvx.a(2131712869));
    }
    Object localObject;
    for (;;)
    {
      localObject = paramViewGroup.findViewById(2131368572);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = DisplayUtil.dip2px(paramContext, 25.0F);
      ((View)localObject).setLayoutParams(localLayoutParams);
      i = Build.VERSION.SDK_INT;
      if ((i == 19) || (i == 18)) {
        localBubbleImageView.e = true;
      }
      localObject = (ETTextView)paramViewGroup.findViewById(2131371616);
      paramViewGroup = (ETTextView)paramViewGroup.findViewById(2131371598);
      if (localBubbleImageView.getDrawable() == null) {
        a(localBubbleImageView, paramContext, paramSourceMsgInfo);
      }
      a(localBubbleImageView, paramMessageRecord1);
      a(paramQQAppInterface, paramContext, paramViewGroup, paramMessageRecord2, paramString);
      if (paramMessageRecord2 == null) {
        break;
      }
      b(paramMessageRecord2, paramSourceMsgInfo, localBubbleImageView, paramViewGroup, (ETTextView)localObject, paramInt, paramString, paramMessageRecord1, paramContext, paramQQAppInterface, null);
      return;
      localBubbleImageView.setContentDescription(anvx.a(2131712862));
    }
    if ((paramBoolean2) || (a(paramString)) || (paramSourceMsgInfo.mSourceSummaryFlag != 1))
    {
      c(paramContext, paramQQAppInterface, localBubbleImageView, paramMessageRecord1, new ahfc(paramViewGroup, (ETTextView)localObject, paramSourceMsgInfo, localBubbleImageView, paramInt, paramString, paramMessageRecord1, paramContext));
      return;
    }
    localBubbleImageView.setVisibility(8);
    b(paramViewGroup, (TextView)localObject, paramInt, paramString, null);
    a(paramContext, paramQQAppInterface, localBubbleImageView, paramMessageRecord1, paramSourceMsgInfo, (ETTextView)localObject, paramViewGroup, paramInt, paramString);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean, SessionInfo paramSessionInfo)
  {
    if (((paramMessageRecord instanceof MessageForReplyText)) && (QLog.isColorLevel())) {
      QLog.d("SendMsgBtn", 2, "ReplyItemBuilder reply:" + paramMessageRecord + " sourceMsg=" + ((MessageForReplyText)paramMessageRecord).getSourceMessage());
    }
    String str = bhid.a(paramContext, 3, paramSourceMsgInfo.mSourceMsgTime * 1000L).toString();
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(2131371803);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(2131378915);
    boolean bool;
    Object localObject2;
    Object localObject1;
    label144:
    MessageRecord localMessageRecord;
    if ((paramBoolean) || (a(paramSourceMsgInfo.mSourceMsgText)))
    {
      bool = true;
      localObject2 = paramSourceMsgInfo.mSourceMsgText;
      if (android.text.TextUtils.isEmpty(paramSourceMsgInfo.mAnonymousNickName)) {
        break label388;
      }
      localObject1 = paramSourceMsgInfo.mAnonymousNickName;
      localMessageRecord = a(paramQQAppInterface, paramString, paramInt, paramMessageRecord, paramSourceMsgInfo);
      if (paramSourceMsgInfo.mSourceSummaryFlag != 1) {
        break label584;
      }
      localObject2 = paramSourceMsgInfo.mSourceMsgText;
      if (!(localMessageRecord instanceof MessageForPic)) {
        break label636;
      }
      paramString = (String)localObject2;
      if (anud.a(localMessageRecord))
      {
        if (localObject2 == null) {
          break label573;
        }
        paramInt = ((String)localObject2).indexOf('[');
        if (paramInt < 0) {
          break label573;
        }
        int i = ((String)localObject2).indexOf(']');
        if (i <= paramInt) {
          break label573;
        }
        paramString = ((String)localObject2).substring(paramInt, i + 1);
      }
      label239:
      paramBoolean = true;
      paramInt = 0;
    }
    for (;;)
    {
      localObject2 = localMessageRecord;
      if ((paramMessageRecord instanceof MessageForReplyText))
      {
        MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramMessageRecord;
        localObject2 = localMessageRecord;
        if (localMessageForReplyText.getSourceMessage() != null) {
          localObject2 = localMessageForReplyText.getSourceMessage();
        }
      }
      a(paramContext, paramQQAppInterface, paramViewGroup, paramSourceMsgInfo, paramMessageRecord, paramSessionInfo, (MessageRecord)localObject2);
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject1))
      {
        localTextView1.setTag(2131378470, localObject1);
        localTextView1.setTag(2131378471, Long.valueOf(paramSourceMsgInfo.mSourceMsgSenderUin));
        localTextView1.setText((CharSequence)localObject1);
        localTextView2.setText(" " + str);
      }
      a(paramContext, paramQQAppInterface, paramViewGroup, paramSourceMsgInfo, paramMessageRecord, (MessageRecord)localObject2, paramBoolean, paramInt, paramString, bool);
      return;
      bool = false;
      break;
      label388:
      if (paramSourceMsgInfo.mSourceMsgSenderUin == 50000000L)
      {
        localObject1 = a(paramQQAppInterface, paramString, paramInt, paramMessageRecord, paramSourceMsgInfo);
        if (localObject1 != null)
        {
          localObject1 = bgiz.a((MessageRecord)localObject1);
          if (localObject1 != null) {
            paramSourceMsgInfo.mAnonymousNickName = ((bgja)localObject1).c;
          }
        }
        localObject1 = "";
        break label144;
      }
      localObject1 = localTextView1.getTag(2131378471);
      if ((localObject1 == null) || (((Long)localObject1).longValue() != paramSourceMsgInfo.mSourceMsgSenderUin))
      {
        ThreadManager.excute(new ReplyTextItemBuilder.9(paramQQAppInterface, paramInt, paramString, paramSourceMsgInfo, localTextView1, localTextView2, str), 64, null, true);
        localObject1 = "";
        break label144;
      }
      localTextView1.setText(new begq((String)localTextView1.getTag(2131378470), 16).a());
      localTextView2.setText(" " + str);
      localObject1 = "";
      break label144;
      label573:
      paramString = anvx.a(2131712864);
      break label239;
      label584:
      if (((localMessageRecord instanceof MessageForPic)) && (bool) && ((paramMessageRecord instanceof arts)))
      {
        paramBoolean = true;
        paramInt = 0;
      }
      for (;;)
      {
        paramString = a(paramQQAppInterface, paramSourceMsgInfo, paramMessageRecord, (String)localObject2, localMessageRecord);
        break;
        paramInt = 1;
        paramBoolean = false;
      }
      label636:
      paramString = (String)localObject2;
      paramInt = 1;
      paramBoolean = false;
    }
  }
  
  protected static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, ahfl paramahfl)
  {
    ThreadManager.post(new ReplyTextItemBuilder.3(paramMessageRecord, paramQQAppInterface, paramahfl, paramContext, paramChatThumbView), 8, null, true);
  }
  
  public static final void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    arts localarts = null;
    if ((paramMessageRecord1 instanceof arts)) {
      localarts = (arts)paramMessageRecord1;
    }
    if ((paramMessageRecord2 instanceof MessageForPic)) {
      a(paramContext, paramChatThumbView, localarts, (MessageForPic)paramMessageRecord2);
    }
    do
    {
      return;
      if (!auea.a(paramMessageRecord2)) {
        break;
      }
      paramContext = a(paramQQAppInterface, paramMessageRecord2);
      if ((paramContext instanceof MessageForTroopFile))
      {
        b(paramQQAppInterface, paramChatThumbView, paramContext);
        return;
      }
    } while (!(paramContext instanceof MessageForFile));
    a(paramQQAppInterface, paramChatThumbView, paramContext);
    return;
    if ((paramMessageRecord2 instanceof MessageForShortVideo))
    {
      a(paramQQAppInterface, paramChatThumbView, (MessageForReplyText)paramMessageRecord1, (MessageForShortVideo)paramMessageRecord2);
      return;
    }
    if ((localarts != null) && (localarts.getSourceMsgInfo() != null) && (localarts.getSourceMsgInfo().replyPicWidth != 0))
    {
      paramChatThumbView.setImageDrawable(ahkv.a(2, 200, 200));
      return;
    }
    paramChatThumbView.setVisibility(8);
  }
  
  protected static void a(Context paramContext, QQAppInterface paramQQAppInterface, BubbleImageView paramBubbleImageView, MessageRecord paramMessageRecord, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, ETTextView paramETTextView1, ETTextView paramETTextView2, int paramInt, String paramString)
  {
    paramSourceMsgInfo = new ahfe(paramSourceMsgInfo, paramBubbleImageView, paramETTextView2, paramETTextView1, paramInt, paramString, paramMessageRecord);
    if (paramMessageRecord.istroop == 0)
    {
      a(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord, paramSourceMsgInfo);
      return;
    }
    b(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord, paramSourceMsgInfo);
  }
  
  private static void a(URLDrawable paramURLDrawable)
  {
    String str = paramURLDrawable.getURL().toString();
    ThreadManager.getSubThreadHandler().post(new ReplyTextItemBuilder.12(str, paramURLDrawable));
  }
  
  public static void a(ChatThumbView paramChatThumbView)
  {
    if (paramChatThumbView == null) {
      return;
    }
    paramChatThumbView.setVisibility(8);
    paramChatThumbView = (ViewGroup)paramChatThumbView.getParent();
    if (paramChatThumbView == null)
    {
      QLog.i("ReplyTextItemBuilder<QFile>", 1, "resetReplyThumbImageView: can not get imageContent");
      return;
    }
    Object localObject = paramChatThumbView.findViewById(2131378882);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramChatThumbView.findViewById(2131365290);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramChatThumbView.findViewById(2131365458);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (ImageView)paramChatThumbView.findViewById(2131368407);
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    paramChatThumbView.setVisibility(8);
  }
  
  private static void a(ChatThumbView paramChatThumbView, Context paramContext, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if (paramSourceMsgInfo.replyPicWidth == 0) {
      return;
    }
    Bitmap localBitmap;
    if ((URLDrawableHelper.getLoadingDrawable() instanceof SkinnableBitmapDrawable))
    {
      localBitmap = ((SkinnableBitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap();
      paramChatThumbView.setImageDrawable(new asbe(paramContext.getResources(), localBitmap, paramSourceMsgInfo.replyPicWidth, paramSourceMsgInfo.replyPicHeight, -921103));
      return;
    }
    if ((URLDrawableHelper.getLoadingDrawable() instanceof BitmapDrawable))
    {
      localBitmap = ((BitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap();
      paramChatThumbView.setImageDrawable(new asbe(paramContext.getResources(), localBitmap, paramSourceMsgInfo.replyPicWidth, paramSourceMsgInfo.replyPicHeight, -921103));
      return;
    }
    paramChatThumbView.setImageDrawable(URLDrawableHelper.getLoadingDrawable());
  }
  
  public static void a(ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord)
  {
    try
    {
      if (paramChatThumbView.getTag() == paramMessageRecord) {
        return;
      }
      paramChatThumbView.setTag(paramMessageRecord);
      a(paramChatThumbView);
      return;
    }
    catch (Exception paramChatThumbView) {}
  }
  
  public static void a(ChatThumbView paramChatThumbView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = paramChatThumbView.getContext();
    paramInt2 = AIOUtils.dp2px(120.0F, ((Context)localObject).getResources());
    int i = AIOUtils.dp2px(80.0F, ((Context)localObject).getResources());
    if (paramInt1 <= 0) {
      if (paramBoolean) {
        paramInt1 = AIOUtils.dp2px(60.0F, ((Context)localObject).getResources());
      }
    }
    for (;;)
    {
      if (paramInt1 > paramInt2) {
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        localObject = (ViewGroup)paramChatThumbView.getParent();
        if (localObject == null) {
          QLog.i("ReplyTextItemBuilder<QFile>", 1, "showDefaultReplyThumb: can not get imageContent");
        }
        do
        {
          return;
          paramInt1 = AIOUtils.dp2px(120.0F, ((Context)localObject).getResources());
          break;
          paramChatThumbView.setVisibility(8);
          ((ViewGroup)localObject).setVisibility(0);
          paramChatThumbView = (AsyncImageView)((ViewGroup)localObject).findViewById(2131378882);
          if (paramChatThumbView != null) {
            paramChatThumbView.setVisibility(8);
          }
          paramChatThumbView = ((ViewGroup)localObject).findViewById(2131365458);
          if (paramChatThumbView != null)
          {
            ViewGroup.LayoutParams localLayoutParams = paramChatThumbView.getLayoutParams();
            localLayoutParams.width = paramInt1;
            localLayoutParams.height = i;
            paramChatThumbView.setLayoutParams(localLayoutParams);
            paramChatThumbView.setVisibility(0);
            paramChatThumbView.getBackground().setAlpha(26);
          }
          paramChatThumbView = ((ViewGroup)localObject).findViewById(2131365290);
          if (paramChatThumbView != null) {
            paramChatThumbView.setVisibility(8);
          }
          paramChatThumbView = (ImageView)((ViewGroup)localObject).findViewById(2131368407);
        } while (paramChatThumbView == null);
        paramChatThumbView.setVisibility(0);
        if (paramBoolean)
        {
          paramChatThumbView.setImageResource(2130844311);
          return;
        }
        paramChatThumbView.setImageResource(2130844310);
        return;
      }
    }
  }
  
  public static void a(ChatThumbView paramChatThumbView, boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    if (paramChatThumbView == null) {}
    do
    {
      return;
      paramChatThumbView.getContext();
      ViewGroup localViewGroup = (ViewGroup)paramChatThumbView.getParent();
      if (localViewGroup == null)
      {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "handleReplyThumbImageView: can not get imageContent");
        return;
      }
      b(paramInt1, paramInt2, paramString, paramChatThumbView);
      if (paramBoolean)
      {
        paramString = localViewGroup.findViewById(2131365290);
        if (paramString != null)
        {
          paramChatThumbView = (RelativeLayout.LayoutParams)paramChatThumbView.getLayoutParams();
          paramString.setVisibility(0);
          ViewGroup.LayoutParams localLayoutParams = paramString.getLayoutParams();
          localLayoutParams.width = paramChatThumbView.width;
          localLayoutParams.height = paramChatThumbView.height;
          paramString.setLayoutParams(paramChatThumbView);
        }
      }
      paramChatThumbView = localViewGroup.findViewById(2131365458);
      if (paramChatThumbView != null) {
        paramChatThumbView.setVisibility(8);
      }
      paramChatThumbView = (ImageView)localViewGroup.findViewById(2131368407);
    } while (paramChatThumbView == null);
    if (paramBoolean)
    {
      paramChatThumbView.setImageResource(2130844311);
      paramChatThumbView.setVisibility(0);
      return;
    }
    paramChatThumbView.setVisibility(8);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, TextView paramTextView, MessageRecord paramMessageRecord, String paramString)
  {
    int i;
    if (auea.a(paramMessageRecord))
    {
      paramMessageRecord = a(paramQQAppInterface, paramMessageRecord);
      if ((paramMessageRecord instanceof MessageForFile))
      {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "handleReplyTextStyle, sourceMsg uniseq[" + paramMessageRecord.uniseq + "]");
        paramMessageRecord = paramQQAppInterface.getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if ((paramMessageRecord == null) || (paramMessageRecord.status == 16)) {
          break label750;
        }
        i = auea.a(auea.a(paramMessageRecord.fileName), 1);
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramQQAppInterface = paramContext.getDrawable(i);
          paramTextView.setText(paramMessageRecord.fileName);
        }
      }
    }
    for (;;)
    {
      if (paramQQAppInterface != null)
      {
        i = AIOUtils.dp2px(15.0F, paramContext.getResources());
        int j = AIOUtils.dp2px(4.0F, paramContext.getResources());
        paramQQAppInterface.setBounds(0, 0, i, i);
        paramTextView.setCompoundDrawables(paramQQAppInterface, null, null, null);
        paramTextView.setGravity(16);
        paramTextView.setCompoundDrawablePadding(j);
        paramTextView.setPadding(0, 0, 0, 0);
        paramTextView.invalidate();
        paramTextView.setMaxLines(1);
        paramTextView.setIncludeFontPadding(false);
        paramTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        return;
        paramQQAppInterface = paramContext.getResources().getDrawable(i);
        break;
        if (!(paramMessageRecord instanceof MessageForTroopFile)) {
          break label750;
        }
        paramMessageRecord = bgke.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord);
        if (paramMessageRecord == null) {
          break label750;
        }
        i = auea.a(auea.a(paramMessageRecord.g), 1);
        if (Build.VERSION.SDK_INT >= 21) {}
        for (paramQQAppInterface = paramContext.getDrawable(i);; paramQQAppInterface = paramContext.getResources().getDrawable(i))
        {
          paramTextView.setText(paramMessageRecord.g);
          break;
        }
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          if ((!amgj.a(paramMessageRecord)) || (c(paramMessageRecord))) {
            break label745;
          }
          label336:
          URLDrawable.URLDrawableOptions localURLDrawableOptions;
          if (Build.VERSION.SDK_INT >= 21)
          {
            paramString = paramContext.getDrawable(2130844270);
            paramQQAppInterface = paramString;
            if (((MessageForStructing)paramMessageRecord).structingMsg != null)
            {
              paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg.mMsgUrl;
              paramQQAppInterface = becr.f(paramMessageRecord);
              i = AIOUtils.dp2px(15.0F, paramContext.getResources());
              localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
              localURLDrawableOptions.mLoadingDrawable = paramString;
              localURLDrawableOptions.mFailedDrawable = paramString;
              localURLDrawableOptions.mRequestWidth = i;
              localURLDrawableOptions.mRequestHeight = i;
              localURLDrawableOptions.mUseAutoScaleParams = false;
              if (android.text.TextUtils.isEmpty(paramQQAppInterface)) {
                break label458;
              }
              paramQQAppInterface = URLDrawable.getDrawable(paramQQAppInterface, localURLDrawableOptions);
              paramQQAppInterface.setBounds(0, 0, i, i);
            }
          }
          for (;;)
          {
            break;
            paramString = paramContext.getResources().getDrawable(2130844270);
            break label336;
            label458:
            paramQQAppInterface = paramString;
            if (!android.text.TextUtils.isEmpty(paramMessageRecord))
            {
              paramQQAppInterface = paramString;
              if (paramMessageRecord.contains(becr.c))
              {
                paramQQAppInterface = URLDrawable.getDrawable(becr.d, localURLDrawableOptions);
                paramQQAppInterface.setBounds(0, 0, i, i);
              }
            }
          }
        }
        if (!(paramMessageRecord instanceof MessageForArkApp)) {
          break label745;
        }
        for (;;)
        {
          try
          {
            for (;;)
            {
              paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
              if ((paramMessageRecord == null) || (!aqzu.a().a(paramMessageRecord.appName, paramMessageRecord.appView))) {
                break label745;
              }
              if (Build.VERSION.SDK_INT < 21) {
                break label691;
              }
              paramQQAppInterface = paramContext.getDrawable(2130844270);
              paramMessageRecord = aqzu.a().a(new JSONObject(paramMessageRecord.toAppXml())).get("kArkMsgReplyIcon").toString();
              i = AIOUtils.dp2px(15.0F, paramContext.getResources());
              paramString = URLDrawable.URLDrawableOptions.obtain();
              paramString.mLoadingDrawable = paramQQAppInterface;
              paramString.mFailedDrawable = paramQQAppInterface;
              paramString.mRequestWidth = i;
              paramString.mRequestHeight = i;
              paramString.mUseAutoScaleParams = false;
              if (android.text.TextUtils.isEmpty(paramMessageRecord)) {
                break;
              }
              paramQQAppInterface = URLDrawable.getDrawable(paramMessageRecord, paramString);
              try
              {
                paramQQAppInterface.setBounds(0, 0, i, i);
              }
              catch (Exception paramMessageRecord) {}
            }
          }
          catch (Exception paramMessageRecord)
          {
            label691:
            paramQQAppInterface = null;
            continue;
          }
          QLog.e("ReplyTextItemBuilder", 1, "handle MessageForArkApp error!" + paramMessageRecord.getMessage());
          break;
          paramQQAppInterface = paramContext.getResources().getDrawable(2130844270);
        }
      }
      paramTextView.setCompoundDrawables(null, null, null, null);
      paramTextView.setPadding(0, 0, 0, 0);
      paramTextView.setCompoundDrawablePadding(0);
      paramTextView.setMaxLines(2147483647);
      paramTextView.setEllipsize(null);
      return;
      label745:
      paramQQAppInterface = null;
      continue;
      label750:
      paramQQAppInterface = null;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageForReplyText paramMessageForReplyText, MessageForShortVideo paramMessageForShortVideo)
  {
    Object localObject = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!FileUtils.fileExistsAndNotEmpty((String)localObject)) {}
    for (;;)
    {
      try
      {
        localObject = bcwz.a(2, 2);
        bcxb localbcxb = paramMessageForShortVideo.getDownloadInfo(((bcxr)localObject).jdField_b_of_type_Int);
        localbcxb.i = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
        localbcxb.a(paramMessageForShortVideo.istroop, 1);
        ((bcxr)localObject).a(localbcxb);
        ((bcxr)localObject).a(new ahfd(paramMessageForShortVideo, paramMessageForReplyText, paramQQAppInterface, paramChatThumbView));
        bcwz.a((bcxr)localObject, paramQQAppInterface);
        paramQQAppInterface = (ImageView)((ViewGroup)paramChatThumbView.getParent()).findViewById(2131368407);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface.setImageResource(2130844311);
          paramQQAppInterface.setVisibility(0);
        }
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReplyTextItemBuilder", 2, "no appRuntime");
        continue;
      }
      b(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight, (String)localObject, paramChatThumbView);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord)
  {
    QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg, sourceMsg uniseq[" + paramMessageRecord.uniseq + "]");
    FileManagerEntity localFileManagerEntity = paramQQAppInterface.getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
    boolean bool;
    if (localFileManagerEntity != null)
    {
      int i = auea.a(localFileManagerEntity.fileName);
      if (i != 2) {
        break label89;
      }
      bool = true;
      if ((i == 2) || (i == 0)) {
        break label95;
      }
    }
    label540:
    label552:
    for (;;)
    {
      return;
      label89:
      bool = false;
      break;
      label95:
      if (localFileManagerEntity.status == 16)
      {
        if (QLog.isDebugVersion()) {
          QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle offline file but is invalid. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "]");
        }
        a(paramChatThumbView, bool, 0, 0);
        return;
      }
      Object localObject2 = localFileManagerEntity.strMiddleThumPath;
      Object localObject1 = localObject2;
      if (!FileUtils.fileExistsAndNotEmpty((String)localObject2)) {
        localObject1 = localFileManagerEntity.strLargeThumPath;
      }
      localObject2 = localObject1;
      if (!FileUtils.fileExistsAndNotEmpty((String)localObject1))
      {
        if (!bool) {
          break label503;
        }
        if (localFileManagerEntity.peerType != 3000) {
          break label490;
        }
        paramQQAppInterface = paramQQAppInterface.getFileManagerEngine().b(localFileManagerEntity);
        localObject2 = paramQQAppInterface;
        if (!FileUtils.fileExistsAndNotEmpty(paramQQAppInterface))
        {
          if ((localFileManagerEntity.imgWidth <= 0) || (localFileManagerEntity.imgHeight <= 0)) {
            break label540;
          }
          localObject1 = aues.a(localFileManagerEntity.imgWidth, localFileManagerEntity.imgHeight, "");
          if (QLog.isDebugVersion()) {
            QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle offline file set default. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + ((auet)localObject1).jdField_a_of_type_Int + "]");
          }
          a(paramChatThumbView, bool, ((auet)localObject1).jdField_a_of_type_Int, ((auet)localObject1).jdField_b_of_type_Int);
        }
      }
      for (localObject2 = paramQQAppInterface;; localObject2 = paramQQAppInterface)
      {
        if (!FileUtils.fileExistsAndNotEmpty((String)localObject2)) {
          break label552;
        }
        if ((localFileManagerEntity.imgWidth <= 0) || (localFileManagerEntity.imgHeight <= 0)) {
          break label554;
        }
        paramQQAppInterface = aues.a(localFileManagerEntity.imgWidth, localFileManagerEntity.imgHeight, (String)localObject2);
        if (QLog.isDebugVersion()) {
          QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle offline file set thumb. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + paramQQAppInterface.jdField_a_of_type_Int + "]");
        }
        a(paramChatThumbView, bool, paramQQAppInterface.jdField_a_of_type_Int, paramQQAppInterface.jdField_b_of_type_Int, (String)localObject2);
        return;
        label490:
        paramQQAppInterface = paramQQAppInterface.getFileManagerEngine().a(localFileManagerEntity);
        break;
        label503:
        if (aues.b(localFileManagerEntity))
        {
          paramQQAppInterface = paramQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 7);
          break;
        }
        paramQQAppInterface = paramQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 5);
        break;
        a(paramChatThumbView, bool, 0, 0);
      }
    }
    label554:
    a(paramChatThumbView, bool, 0, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    int i = 1;
    int j = 8;
    if ((paramMessageRecord == null) && (!"0X800A36B".equals(paramString))) {
      return;
    }
    if ((paramMessageRecord instanceof MessageForText)) {}
    for (;;)
    {
      bdla.b(paramQQAppInterface, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
      return;
      if ((paramMessageRecord instanceof MessageForPic))
      {
        i = 2;
      }
      else if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        i = 3;
      }
      else if (((paramMessageRecord instanceof MessageForVideo)) || ((paramMessageRecord instanceof MessageForShortVideo)))
      {
        i = 4;
      }
      else if (((paramMessageRecord instanceof MessageForFile)) || ((paramMessageRecord instanceof MessageForTroopFile)))
      {
        i = 5;
      }
      else
      {
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          paramMessageRecord = (MessageForStructing)paramMessageRecord;
          i = j;
          if (paramMessageRecord.structingMsg != null) {
            switch (paramMessageRecord.structingMsg.mMsgServiceID)
            {
            default: 
              i = j;
            }
          }
          for (;;)
          {
            break;
            i = 6;
            continue;
            i = 7;
          }
        }
        if ((paramMessageRecord instanceof MessageForArkApp)) {
          try
          {
            paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
            i = j;
            if (paramMessageRecord != null) {
              i = aqzu.a(paramMessageRecord.appName, paramMessageRecord.appView);
            }
          }
          catch (Exception paramMessageRecord)
          {
            QLog.e("ReplyTextItemBuilder", 1, "reportReplyItemEvent error for MessageForArkApp:" + paramMessageRecord.getMessage());
            i = 8;
          }
        } else {
          i = 8;
        }
      }
    }
  }
  
  private static void a(int[] paramArrayOfInt, Rect paramRect, boolean paramBoolean, int paramInt, File paramFile, float paramFloat)
  {
    int j;
    int i;
    if (paramRect != null)
    {
      j = paramRect.width();
      i = paramRect.height();
    }
    for (;;)
    {
      paramRect = a(j, i, 12.0F * paramFloat, paramBoolean);
      j = paramRect.jdField_a_of_type_Int;
      i = paramRect.jdField_b_of_type_Int;
      j = (j * paramInt + 80) / 160;
      paramInt = (i * paramInt + 80) / 160;
      if (paramArrayOfInt != null)
      {
        paramArrayOfInt[0] = j;
        paramArrayOfInt[1] = paramInt;
      }
      return;
      paramRect = new BitmapFactory.Options();
      paramRect.inJustDecodeBounds = true;
      try
      {
        bheg.a(paramFile.getAbsolutePath(), paramRect);
        j = paramRect.outWidth;
        i = paramRect.outHeight;
        int k = URLDrawableHelper.getExifRotation(paramFile.getAbsolutePath());
        if ((k != 90) && (k != 270)) {
          continue;
        }
        j = paramRect.outHeight;
        i = paramRect.outWidth;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ReplyTextItemBuilder", 2, "getThumbDrawable", localThrowable);
          }
        }
      }
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, MessageForTroopFile paramMessageForTroopFile)
  {
    boolean bool2 = false;
    paramQQAppInterface = bgke.a(paramQQAppInterface, paramMessageForTroopFile);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      int i = auea.a(paramQQAppInterface.g);
      if (i != 2)
      {
        bool1 = bool2;
        if (i != 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    paramQQAppInterface = paramQQAppInterface.getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      if (paramQQAppInterface.status == 16) {
        break label63;
      }
      int i = auea.a(paramQQAppInterface.fileName);
      if (i != 2)
      {
        bool1 = bool2;
        if (i != 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    label63:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.i("ReplyTextItemBuilder", 2, "renderReply: handle offline file , but invalid. msgUniseq[" + paramMessageRecord.uniseq + "] msgSeq[" + paramMessageRecord.msgseq + "]");
    return false;
  }
  
  public static boolean a(MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReplyTextItemBuilder", 2, "sendUin= " + paramSourceMsgInfo.mSourceMsgSenderUin + " toUin=" + paramSourceMsgInfo.mSourceMsgToUin + " session curFin=" + paramSessionInfo.curFriendUin + " type=" + paramSessionInfo.curType);
    }
    String str1 = paramSourceMsgInfo.mSourceMsgToUin + "";
    String str2 = paramSourceMsgInfo.mSourceMsgSenderUin + "";
    if (paramSourceMsgInfo.mSourceMsgToUin <= 0L) {
      paramSourceMsgInfo.mSourceMsgToUin = a(paramQQAppInterface, paramSessionInfo, paramSourceMsgInfo.mSourceMsgSenderUin);
    }
    do
    {
      do
      {
        return true;
        if (paramSessionInfo.curType == 3000) {
          return str1.equals(paramSessionInfo.curFriendUin);
        }
        if (paramSessionInfo.curType != 1) {
          break;
        }
      } while (str1.equals(paramSessionInfo.curFriendUin));
      paramSourceMsgInfo = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramSessionInfo.curFriendUin);
      if ((paramSourceMsgInfo != null) && (str1.equals(paramSourceMsgInfo.troopcode))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    } while (((str2.equals(paramSessionInfo.curFriendUin)) && (str1.equals(paramQQAppInterface.getCurrentAccountUin()))) || ((str1.equals(paramSessionInfo.curFriendUin)) && (str2.equals(paramQQAppInterface.getCurrentAccountUin()))));
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {}
    while (paramString.indexOf(anvx.a(2131712866)) == -1) {
      return false;
    }
    return true;
  }
  
  private static MessageRecord b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, StringBuilder paramStringBuilder)
  {
    boolean bool2 = true;
    Object localObject = null;
    if ((paramMessageRecord1 == null) || (paramMessageRecord2 == null)) {}
    MessageRecord localMessageRecord;
    do
    {
      return null;
      if (!(paramMessageRecord2 instanceof MessageForMixedMsg)) {
        break label164;
      }
      localObject = (MessageForMixedMsg)paramMessageRecord2;
      if (((MessageForMixedMsg)localObject).msgElemList == null) {
        break;
      }
      localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject).msgElemList.get(0);
      if ((localMessageRecord instanceof MessageForPic))
      {
        int i = 1;
        for (;;)
        {
          bool1 = bool2;
          if (i >= ((MessageForMixedMsg)localObject).msgElemList.size()) {
            break label149;
          }
          localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject).msgElemList.get(i);
          if ((!(localMessageRecord instanceof MessageForText)) || (android.text.TextUtils.isEmpty(localMessageRecord.msg))) {
            break;
          }
          paramStringBuilder.append(localMessageRecord.msg);
          i += 1;
        }
      }
    } while ((localMessageRecord instanceof MessageForText));
    boolean bool1 = false;
    label149:
    localObject = paramMessageRecord2;
    for (;;)
    {
      return a(paramQQAppInterface, paramMessageRecord1, paramMessageRecord2, paramStringBuilder, (MessageRecord)localObject, bool1);
      label164:
      if (((paramMessageRecord2 instanceof MessageForText)) && (!android.text.TextUtils.isEmpty(paramMessageRecord2.msg))) {
        paramStringBuilder.append(paramMessageRecord2.msg);
      }
      bool1 = false;
    }
  }
  
  private static void b(int paramInt1, int paramInt2, String paramString, ImageView paramImageView)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      paramString = ahfz.a(paramString, 55, 95, AIOUtils.dp2px(2.0F, paramImageView.getContext().getResources()));
    }
    while ((paramString == null) || (paramString.getCurrent() == null))
    {
      paramImageView.setVisibility(8);
      return;
      if (paramInt1 > paramInt2)
      {
        paramInt1 = (int)(Float.valueOf(paramInt1).floatValue() / 95);
        paramString = ahfz.a(paramString, 95, (int)(Float.valueOf(paramInt2).floatValue() / paramInt1), AIOUtils.dp2px(2.0F, paramImageView.getContext().getResources()));
      }
      else
      {
        paramInt2 = (int)(Float.valueOf(paramInt2).floatValue() / 95);
        paramString = ahfz.a(paramString, (int)(Float.valueOf(paramInt1).floatValue() / paramInt2), 95, AIOUtils.dp2px(2.0F, paramImageView.getContext().getResources()));
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
    localLayoutParams.width = paramString.getCurrent().getIntrinsicWidth();
    localLayoutParams.height = paramString.getCurrent().getIntrinsicHeight();
    paramImageView.setLayoutParams(localLayoutParams);
    paramImageView.setImageDrawable(paramString);
  }
  
  protected static void b(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, ahfl paramahfl)
  {
    ThreadManager.post(new ReplyTextItemBuilder.4(paramMessageRecord, paramQQAppInterface, paramahfl, paramContext, paramChatThumbView), 8, null, true);
  }
  
  private static void b(TextView paramTextView1, TextView paramTextView2, int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = bhmb.a(str, paramMessageRecord, ChatTextSizeSettingActivity.b() - 2, 7);
    switch (paramInt)
    {
    default: 
      paramTextView1.setVisibility(0);
      paramTextView1.setText(paramString);
      if (AppSetting.c) {
        paramTextView1.setContentDescription(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(str));
      }
      paramTextView2.setVisibility(8);
      return;
    case 0: 
      paramTextView1.setVisibility(8);
      paramTextView2.setVisibility(8);
      return;
    case 1: 
      paramTextView1.setVisibility(0);
      paramTextView1.setText(paramString);
      if (AppSetting.c) {
        paramTextView1.setContentDescription(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(str));
      }
      paramTextView2.setVisibility(8);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText(paramString);
    if (AppSetting.c) {
      paramTextView2.setContentDescription(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(str));
    }
    paramTextView1.setVisibility(8);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramMessageRecord;
    localMessageForTroopFile.doParse();
    bfjs localbfjs = bgke.a(paramQQAppInterface, localMessageForTroopFile);
    if (localbfjs == null)
    {
      a(paramChatThumbView, false, 0, 0);
      return;
    }
    int k = auea.a(localbfjs.g);
    if ((localbfjs == null) || (localbfjs.jdField_b_of_type_Int == 12))
    {
      if (k == 2) {}
      for (bool = true;; bool = false)
      {
        a(paramChatThumbView, bool, 0, 0);
        return;
      }
    }
    if (FileUtils.fileExistsAndNotEmpty(localbfjs.d)) {}
    for (String str = localbfjs.d; FileUtils.fileExistsAndNotEmpty(str); str = localbfjs.c)
    {
      if (k == 2) {
        bool = true;
      }
      paramQQAppInterface = aues.a(localMessageForTroopFile.width, localMessageForTroopFile.height, str);
      if (QLog.isDebugVersion()) {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle troop file set thumb. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + paramQQAppInterface.jdField_a_of_type_Int + "]");
      }
      a(paramChatThumbView, bool, paramQQAppInterface.jdField_a_of_type_Int, paramQQAppInterface.jdField_b_of_type_Int, str);
      return;
    }
    paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(localMessageForTroopFile.frienduin));
    int j = 383;
    int i = j;
    if (aues.b(localMessageForTroopFile.width, localMessageForTroopFile.height))
    {
      i = j;
      if (!FileUtil.fileExistsAndNotEmpty(localbfjs.c)) {
        i = 640;
      }
    }
    if (localbfjs.jdField_b_of_type_Int != 12)
    {
      if (localbfjs.a != null)
      {
        paramQQAppInterface.a(localbfjs.a, i);
        paramChatThumbView.setTag(2131364537, new Boolean(true));
      }
    }
    else {
      if (k != 2) {
        break label486;
      }
    }
    label486:
    for (bool = true;; bool = false)
    {
      a(paramChatThumbView, bool, 0, 0);
      if ((localMessageForTroopFile.width <= 0) || (localMessageForTroopFile.height <= 0)) {
        break label492;
      }
      paramQQAppInterface = aues.a(localMessageForTroopFile.width, localMessageForTroopFile.height, "");
      if (QLog.isDebugVersion()) {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle troop file set default. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + paramQQAppInterface.jdField_a_of_type_Int + "]");
      }
      a(paramChatThumbView, bool, paramQQAppInterface.jdField_a_of_type_Int, paramQQAppInterface.jdField_b_of_type_Int);
      return;
      paramQQAppInterface.a(localbfjs.e, localbfjs.g, localbfjs.h, i);
      break;
    }
    label492:
    a(paramChatThumbView, bool, 0, 0);
  }
  
  private static void b(MessageRecord paramMessageRecord1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, BubbleImageView paramBubbleImageView, ETTextView paramETTextView1, ETTextView paramETTextView2, int paramInt, String paramString1, MessageRecord paramMessageRecord2, Context paramContext, QQAppInterface paramQQAppInterface, String paramString2)
  {
    boolean bool2 = false;
    Object localObject2 = null;
    int i;
    Object localObject1;
    boolean bool1;
    if ((paramMessageRecord1 instanceof MessageForPic)) {
      if (anud.a(paramMessageRecord1))
      {
        i = 1;
        localObject1 = paramString1;
        bool1 = bool2;
        paramString2 = localObject2;
      }
    }
    for (;;)
    {
      if (bool1)
      {
        paramBubbleImageView.setVisibility(0);
        paramBubbleImageView.setTag(2131364537, null);
        paramSourceMsgInfo = (ViewGroup)paramBubbleImageView.getParent();
        if (paramSourceMsgInfo != null) {
          paramSourceMsgInfo.setVisibility(0);
        }
        paramBubbleImageView.setVisibility(0);
        a(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord2, paramString2);
        label87:
        b(paramETTextView1, paramETTextView2, i, (String)localObject1, paramMessageRecord1);
        a(paramQQAppInterface, paramContext, paramETTextView1, paramMessageRecord1, (String)localObject1);
        paramMessageRecord1 = AIOUtils.getHolder(paramETTextView1);
        if ((paramMessageRecord1 != null) && ((paramMessageRecord1 instanceof ahfk))) {
          ((ahfk)paramMessageRecord1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramBubbleImageView;
        }
        return;
        bool1 = true;
        i = 0;
        paramString2 = paramMessageRecord1;
        localObject1 = paramString1;
        continue;
        if ((paramMessageRecord1 instanceof MessageForShortVideo))
        {
          bool1 = true;
          i = 0;
          paramString2 = paramMessageRecord1;
          localObject1 = paramString1;
        }
        else if ((paramMessageRecord1 instanceof MessageForMixedMsg))
        {
          localObject1 = a((MessageForMixedMsg)paramMessageRecord1);
          bool1 = ((ahfj)localObject1).jdField_a_of_type_Boolean;
          i = ((ahfj)localObject1).jdField_a_of_type_Int;
          paramString1 = ((ahfj)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
          localObject1 = ((ahfj)localObject1).jdField_a_of_type_JavaLangString;
          if (android.text.TextUtils.isEmpty(paramString2)) {
            break label617;
          }
        }
      }
    }
    for (;;)
    {
      if (paramSourceMsgInfo.mSourceSummaryFlag != 1) {
        paramString2 = paramSourceMsgInfo.mSourceMsgText;
      }
      localObject1 = paramString2;
      paramString2 = paramString1;
      break;
      if ((paramMessageRecord1 instanceof MessageForLongMsg))
      {
        paramString2 = localObject2;
        bool1 = bool2;
        i = paramInt;
        localObject1 = paramString1;
        if (paramMessageRecord1.msgtype != -1036) {
          break;
        }
        paramSourceMsgInfo = (MessageForMixedMsg)((MessageForLongMsg)paramMessageRecord1).rebuildLongMsg();
        if (paramSourceMsgInfo == null) {
          break label609;
        }
        paramString1 = a(paramSourceMsgInfo);
        bool1 = paramString1.jdField_a_of_type_Boolean;
        paramInt = paramString1.jdField_a_of_type_Int;
        paramSourceMsgInfo = paramString1.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        paramString1 = paramString1.jdField_a_of_type_JavaLangString;
      }
      for (;;)
      {
        paramString2 = paramSourceMsgInfo;
        i = paramInt;
        localObject1 = paramString1;
        break;
        if ((paramMessageRecord1 instanceof MessageForLongTextMsg))
        {
          paramString2 = (MessageForLongTextMsg)paramMessageRecord1;
          if (paramString2 != null) {}
          for (CharSequence localCharSequence = paramString2.sb;; localCharSequence = null)
          {
            paramString2 = localObject2;
            bool1 = bool2;
            i = paramInt;
            localObject1 = paramString1;
            if (localCharSequence == null) {
              break;
            }
            paramString2 = localObject2;
            bool1 = bool2;
            i = paramInt;
            localObject1 = paramString1;
            if (paramSourceMsgInfo.mSourceMsgText.equals(localCharSequence.toString())) {
              break;
            }
            localObject1 = localCharSequence.toString();
            paramString2 = localObject2;
            bool1 = bool2;
            i = paramInt;
            break;
          }
        }
        paramString2 = localObject2;
        bool1 = bool2;
        i = paramInt;
        localObject1 = paramString1;
        if (!auea.a(paramMessageRecord1)) {
          break;
        }
        paramSourceMsgInfo = a(paramQQAppInterface, paramMessageRecord1);
        if ((paramSourceMsgInfo instanceof MessageForFile))
        {
          paramString2 = localObject2;
          bool1 = bool2;
          i = paramInt;
          localObject1 = paramString1;
          if (!a(paramQQAppInterface, paramSourceMsgInfo)) {
            break;
          }
          bool1 = true;
          i = 0;
          paramString2 = paramMessageRecord1;
          localObject1 = paramString1;
          break;
        }
        paramString2 = localObject2;
        bool1 = bool2;
        i = paramInt;
        localObject1 = paramString1;
        if (!(paramSourceMsgInfo instanceof MessageForTroopFile)) {
          break;
        }
        paramString2 = localObject2;
        bool1 = bool2;
        i = paramInt;
        localObject1 = paramString1;
        if (!a(paramQQAppInterface, (MessageForTroopFile)paramSourceMsgInfo)) {
          break;
        }
        bool1 = true;
        i = 0;
        paramString2 = paramMessageRecord1;
        localObject1 = paramString1;
        break;
        a(paramBubbleImageView);
        break label87;
        label609:
        paramSourceMsgInfo = null;
        bool1 = false;
      }
      label617:
      paramString2 = (String)localObject1;
    }
  }
  
  protected static boolean b(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForFile)) || ((paramMessageRecord instanceof MessageForLongMsg)) || ((paramMessageRecord instanceof MessageForMixedMsg)) || ((paramMessageRecord instanceof MessageForShortVideo)) || ((paramMessageRecord instanceof MessageForStructing)) || ((paramMessageRecord instanceof MessageForTroopFile)) || ((paramMessageRecord instanceof MessageForVideo));
  }
  
  protected static void c(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, ahfl paramahfl)
  {
    ThreadManager.post(new ReplyTextItemBuilder.5(paramMessageRecord, paramQQAppInterface, paramahfl, paramContext, paramChatThumbView), 8, null, true);
  }
  
  public static boolean c(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if (paramMessageRecord.structingMsg == null) {}
    }
    switch (paramMessageRecord.structingMsg.mMsgServiceID)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (localMessageForReplyText.mSourceMsgInfo == null) {
      return super.a(paramChatMessage);
    }
    int i = localMessageForReplyText.mSourceMsgInfo.mType;
    return super.a(paramChatMessage);
  }
  
  public afqq a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (ahfk)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  public afqr a()
  {
    return new ahfk(this);
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (paramView != null)
    {
      localahfk = (ahfk)paramView.getTag();
      if (localahfk != null) {
        this.jdField_a_of_type_Ahfm.a(localahfk.e, paramView);
      }
    }
    ahfk localahfk = (ahfk)paramafqr;
    int i;
    if (localMessageForReplyText.mSourceMsgInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ReplyTextItemBuilder", 2, "text.mSourceMsgInfo为null, text:" + localMessageForReplyText.toString());
      }
      localahfk.e = -1;
      paramafqr = this.jdField_a_of_type_Ahfm.a(-1);
      if (paramafqr != null) {
        break label643;
      }
      paramafqr = new LinearLayout(localContext);
      paramafqr.setOrientation(1);
      paramView = new ETTextView(localContext);
      paramView.setTextColor(localContext.getResources().getColorStateList(2131167045));
      paramView.setLinkTextColor(localContext.getResources().getColorStateList(2131167038));
      paramView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
      paramView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
      paramView.setMaxWidth(BaseChatItemLayout.e);
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      int j = BaseChatItemLayout.o;
      i = BaseChatItemLayout.p;
      if (paramChatMessage.isSend())
      {
        j = BaseChatItemLayout.p;
        i = BaseChatItemLayout.o;
      }
      paramView.setPadding(j, BaseChatItemLayout.m, i, BaseChatItemLayout.n);
      paramView.setId(2131364525);
      localahfk.d = paramView;
      paramView = new LinearLayout.LayoutParams(-2, -2);
      paramView.topMargin = AIOUtils.dp2px(5.0F, localContext.getResources());
      paramafqr.addView(localahfk.d, paramView);
    }
    label643:
    for (;;)
    {
      ((ETTextView)localahfk.d).setFont(0, paramChatMessage.uniseq);
      localahfk.d.setTypeface(gm.a(paramChatMessage));
      localahfk.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
      localahfk.d.setText(localMessageForReplyText.sb);
      super.a(localahfk.d, paramChatMessage);
      paramafqr.setOnTouchListener(paramaftk);
      paramafqr.setOnLongClickListener(paramaftk);
      localahfk.d.setOnTouchListener(paramaftk);
      localahfk.d.setOnLongClickListener(paramaftk);
      paramView = paramafqr;
      if ((localahfk.d instanceof AnimationTextView))
      {
        ((AnimationTextView)localahfk.d).onDoubleClick = this.jdField_a_of_type_Bils;
        paramView = paramafqr;
      }
      if (paramView != null)
      {
        paramView.setTag(localahfk);
        paramView.setPadding(0, 0, 0, 0);
        if ((AppSetting.c) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 0))
        {
          paramafqr = com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramChatMessage.msg);
          if (!paramChatMessage.isSend()) {
            break label604;
          }
          paramView.setContentDescription(anvx.a(2131712863) + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick + anvx.a(2131712868) + paramafqr);
        }
      }
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, "reply type is" + localMessageForReplyText.mSourceMsgInfo.mType);
      }
      i = localMessageForReplyText.mSourceMsgInfo.mType;
      if (localMessageForReplyText.mSourceMsgInfo.oriMsgType == 1) {}
      for (boolean bool = true;; bool = false)
      {
        paramView = a(paramBaseChatItemLayout, localContext, localahfk, localMessageForReplyText, paramaftk, bool);
        break;
      }
      label604:
      paramView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick + anvx.a(2131712865) + paramafqr);
      return paramView;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ahfm.a();
    super.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    agfb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 3);
    Bundle localBundle = new Bundle();
    localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
    Object localObject = (MessageForReplyText)paramChatMessage;
    if (alvr.a().c())
    {
      paramContext = alvr.a().b();
      if (paramContext == null) {
        if (((MessageForReplyText)localObject).sb != null)
        {
          paramContext = ((MessageForReplyText)localObject).sb.toString();
          label103:
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      label105:
      if (paramInt != 0)
      {
        localBundle.putInt("forward_type", -6);
        localBundle.putLong("FORWARD_MSG_UNISEQ", paramChatMessage.uniseq);
        localObject = (bben)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FORWARD_MSG_MANAGER);
        MessageRecord localMessageRecord = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage, ((MessageForReplyText)paramChatMessage).mSourceMsgInfo);
        ((MessageForReplyText)paramChatMessage).setSourceMessageRecord(localMessageRecord);
        ((bben)localObject).a(paramChatMessage);
      }
      for (;;)
      {
        localBundle.putString("forward_text", paramContext);
        localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
        paramContext = new Intent();
        paramContext.putExtras(localBundle);
        aupt.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
        if (!paramChatMessage.isMultiMsg) {
          break;
        }
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 1, 0, "1", "", "", "");
        return;
        paramContext = ((MessageForReplyText)localObject).msg;
        break label103;
        if (paramContext.length() != alvr.a().a()) {
          break label390;
        }
        paramInt = 1;
        break label105;
        if (((MessageForReplyText)localObject).sb != null) {}
        for (paramContext = ((MessageForReplyText)localObject).sb.toString();; paramContext = ((MessageForReplyText)localObject).msg)
        {
          paramInt = 1;
          break;
        }
        localBundle.putInt("forward_type", -1);
      }
      label390:
      paramInt = 0;
    }
  }
  
  public void a(afqr paramafqr, View paramView, ChatMessage paramChatMessage, aqhi paramaqhi)
  {
    ahfk localahfk = (ahfk)paramafqr;
    paramafqr = (MessageForReplyText)paramChatMessage;
    if (paramafqr.mSourceMsgInfo == null) {
      return;
    }
    Object localObject = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838310);
    localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
    int i = paramafqr.mSourceMsgInfo.mType;
    if ((paramaqhi.jdField_a_of_type_Int == 0) || (!paramaqhi.a()) || (bdfk.b()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramafqr = paramView.getColorStateList(2131167049);
        localahfk.d.setTextColor(paramafqr);
        localahfk.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramafqr);
        localahfk.c.setTextColor(paramafqr);
        localahfk.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramafqr);
        localahfk.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramafqr);
        localahfk.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramafqr);
        ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(paramafqr.getDefaultColor(), PorterDuff.Mode.SRC_ATOP));
        localahfk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        if (!paramChatMessage.isSend()) {
          break label294;
        }
      }
      label294:
      for (paramafqr = paramView.getColorStateList(2131167048);; paramafqr = paramView.getColorStateList(2131167047))
      {
        localahfk.d.setLinkTextColor(paramafqr);
        localahfk.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafqr);
        localahfk.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafqr);
        ImmersiveUtils.a(localahfk.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
        ImmersiveUtils.a(localahfk.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
        ImmersiveUtils.a(localahfk.c, 0.9F);
        ImmersiveUtils.a(localahfk.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        ImmersiveUtils.a(localahfk.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        return;
        paramafqr = paramView.getColorStateList(2131167045);
        break;
      }
    }
    if (paramaqhi.jdField_b_of_type_Int == 0)
    {
      localahfk.d.setTextColor(-16777216);
      localahfk.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      localahfk.c.setTextColor(-16777216);
      localahfk.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      localahfk.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      localahfk.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP));
      localahfk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      label407:
      if (paramaqhi.jdField_c_of_type_Int != 0) {
        break label750;
      }
      paramafqr = paramView.getResources().getColorStateList(2131167047);
      localahfk.d.setLinkTextColor(paramafqr);
      localahfk.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafqr);
      localahfk.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafqr);
    }
    for (;;)
    {
      ImmersiveUtils.a(localahfk.c, 0.9F);
      ImmersiveUtils.a(localahfk.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
      ImmersiveUtils.a(localahfk.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
      ImmersiveUtils.a(localahfk.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
      if ((!paramaqhi.jdField_b_of_type_Boolean) || (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localahfk.d.getCurrentTextColor(), 10000.0D * localahfk.jdField_a_of_type_Aqhi.jdField_a_of_type_Double) != 1)) {
        break;
      }
      paramafqr = (ETTextView)localahfk.d;
      float f2 = paramafqr.getTextSize() * 3.0F / 16.0F;
      float f1 = f2;
      if (f2 > 25.0F) {
        f1 = 25.0F;
      }
      paramafqr.setTextColor(-1);
      paramafqr.setShadowLayer(f1, 0.0F, 0.0F, paramaqhi.d);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      localahfk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localahfk.d.setTextColor(paramaqhi.jdField_b_of_type_Int);
      localahfk.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaqhi.jdField_b_of_type_Int);
      localahfk.c.setTextColor(paramaqhi.jdField_b_of_type_Int);
      localahfk.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaqhi.jdField_b_of_type_Int);
      localahfk.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaqhi.jdField_b_of_type_Int);
      localahfk.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaqhi.jdField_b_of_type_Int);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(paramaqhi.jdField_b_of_type_Int, PorterDuff.Mode.SRC_ATOP));
      localahfk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      break label407;
      label750:
      localahfk.d.setLinkTextColor(paramaqhi.jdField_c_of_type_Int);
      localahfk.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaqhi.jdField_c_of_type_Int);
      localahfk.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaqhi.jdField_c_of_type_Int);
    }
  }
  
  public void a(View paramView)
  {
    if (AIOUtils.getMessage(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForReplyText)AIOUtils.getMessage(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689976);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689977);
    } while (!paramView.isSendFromLocal());
    bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ahfg(this, paramView), new ahfh(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView = (ahfk)paramView.getTag();
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (paramView.jdField_a_of_type_AndroidWidgetTextView == null) {
      QLog.e("ReplyTextItemBuilder", 1, "updateBubblePadding error, holder.mNameETTV=null");
    }
    int i;
    do
    {
      return;
      i = AIOUtils.dp2px(1.0F, paramView.jdField_a_of_type_AndroidWidgetTextView.getResources());
    } while (localMessageForReplyText.mSourceMsgInfo == null);
    int j = localMessageForReplyText.mSourceMsgInfo.mType;
    j = BaseChatItemLayout.e - AIOUtils.dp2px(16.0F, paramView.jdField_a_of_type_AndroidWidgetTextView.getResources());
    if (paramChatMessage.isSend())
    {
      paramView.d.setPadding(f, 0, e, d);
      paramChatMessage = (LinearLayout.LayoutParams)paramView.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramChatMessage.leftMargin = f;
      paramChatMessage.rightMargin = (e + i * 2);
      paramChatMessage.topMargin = (jdField_c_of_type_Int + i * 4);
      paramChatMessage.bottomMargin = 0;
      paramView.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramChatMessage);
      i = j - f - e - i * 2;
    }
    for (;;)
    {
      float f = paramView.c.getPaint().measureText(paramView.c.getText().toString());
      f = AIOUtils.dp2px(37.0F, paramView.jdField_a_of_type_AndroidWidgetTextView.getResources()) + f;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(i - (int)f);
      paramChatMessage = (String)paramView.jdField_a_of_type_AndroidWidgetTextView.getTag(2131378470);
      paramChatMessage = com.tencent.mobileqq.text.TextUtils.adjustEllipsizeEndText(paramView.jdField_a_of_type_AndroidWidgetTextView, paramChatMessage, i - (int)f);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramChatMessage);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(i);
      paramView.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setMaxWidth(i);
      paramView.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setMaxWidth(i);
      return;
      paramView.d.setPadding(e, 0, f, d);
      paramChatMessage = (LinearLayout.LayoutParams)paramView.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramChatMessage.leftMargin = (e + i * 2);
      paramChatMessage.rightMargin = e;
      paramChatMessage.topMargin = (i * 4 + jdField_c_of_type_Int);
      paramChatMessage.bottomMargin = 0;
      i = j - e - e;
      paramView.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramChatMessage);
    }
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, afqr paramafqr, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramafqr, paramInt1, paramInt2);
    paramChatMessage = bheg.a(paramafqr.a.getBackground());
    if (paramChatMessage == null)
    {
      paramInt1 = 0;
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, new Object[] { "color=", Integer.valueOf(paramInt1), " ", Integer.valueOf((paramInt1 & 0xFF0000) >> 16), " ", Integer.valueOf((paramInt1 & 0xFF00) >> 8), " ", Integer.valueOf(paramInt1 & 0xFF) });
      }
      if (((((paramInt1 & 0xFF0000) >> 16) + ((paramInt1 & 0xFF00) >> 8) + (paramInt1 & 0xFF)) / 3 < 170) && (((paramInt1 != 0) && (paramInt1 != -16777216) && (paramInt1 != -15366474)) || ("2920".equals(ThemeUtil.getCurrentThemeId())))) {
        break label254;
      }
      if ((paramafqr instanceof ahfk)) {
        ((ahfk)paramafqr).jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838308));
      }
    }
    label254:
    while (!(paramafqr instanceof ahfk))
    {
      return;
      paramInt2 = a(paramChatMessage);
      paramInt1 = paramInt2;
      if (paramChatMessage.isRecycled()) {
        break;
      }
      paramChatMessage.recycle();
      paramInt1 = paramInt2;
      break;
    }
    ((ahfk)paramafqr).jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838309));
  }
  
  public void b(afqr paramafqr, ChatMessage paramChatMessage)
  {
    int i = 0;
    if (!(paramafqr instanceof ahfk)) {}
    ahfk localahfk;
    do
    {
      do
      {
        do
        {
          return;
          localahfk = (ahfk)paramafqr;
        } while (!(paramChatMessage instanceof MessageForReplyText));
        paramChatMessage = (MessageForReplyText)paramChatMessage;
        paramafqr = null;
        if (!android.text.TextUtils.isEmpty(paramChatMessage.sb)) {
          paramafqr = paramChatMessage.sb;
        }
      } while ((paramafqr == null) || (!(paramafqr instanceof QQText)));
      paramChatMessage = (QQText)paramafqr;
      paramafqr = (QQText.EmoticonSpan[])paramChatMessage.getSpans(0, paramafqr.length(), QQText.EmoticonSpan.class);
    } while ((paramafqr.length <= 0) || (paramChatMessage.toPurePlainText().length() != 0));
    int j = paramafqr.length;
    while (i < j)
    {
      paramafqr[i].setSize(ScreenUtil.dip2px(26.0F));
      i += 1;
    }
    localahfk.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setText(paramChatMessage);
  }
  
  protected boolean d()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfa
 * JD-Core Version:    0.7.0.1
 */