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
import android.text.TextUtils;
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
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
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

public class ahpx
  extends ahtp
{
  protected static Drawable a;
  protected agjk a;
  protected ahqj a;
  private View.OnClickListener c;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e1e1e5"));
  }
  
  public ahpx(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Ahqj = new ahqj(null);
    this.jdField_a_of_type_Agjk = new ahpy(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new ahqc(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bbdl(this);
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
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {
      return Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if (paramLong == paramQQAppInterface.getLongAccountUin()) {
      return Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
    }
    return paramQQAppInterface.getLongAccountUin();
  }
  
  private static ahqf a(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean)
  {
    int j = besm.c(paramBoolean);
    int i = besm.d(paramBoolean);
    ahqf localahqf = new ahqf();
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
      localahqf.jdField_a_of_type_Int = paramInt1;
      localahqf.jdField_b_of_type_Int = paramInt2;
      localahqf.jdField_a_of_type_Float = f1;
      localahqf.jdField_b_of_type_Float = paramFloat;
      return localahqf;
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
  
  private static ahqf a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt)
  {
    ahqf localahqf = new ahqf();
    Object localObject3 = null;
    boolean bool = bmgb.a(paramMessageForPic.imageType);
    URL localURL2;
    Object localObject1;
    if ((paramMessageForPic.imageType == 3) || (paramMessageForPic.imageType == 2000))
    {
      ahng.e();
      if (ahng.h)
      {
        localURL2 = beyq.a(paramMessageForPic, 1, null);
        localObject1 = beqz.a(localURL2.toString());
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
          localahqf.jdField_a_of_type_Boolean = true;
          localahqf.jdField_a_of_type_AndroidGraphicsRect = localObject3;
          localahqf.jdField_a_of_type_JavaNetURL = ((URL)localObject1);
        }
      }
    }
    for (;;)
    {
      localObject4 = localObject1;
      if (localObject1 == null) {
        localObject1 = beyq.a(paramMessageForPic, 65537, null);
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
        paramContext = beqz.a((String)localObject1);
        if (paramContext == null) {
          break label430;
        }
        a(paramArrayOfInt, localObject3, bool, k, paramContext, f);
        return localahqf;
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
          return localahqf;
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
        paramContext = beyq.a((URL)localObject4, 0, 0, null, null, true, 12.0F * f);
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt[0] = paramContext.getIntrinsicWidth();
          paramArrayOfInt[1] = paramContext.getIntrinsicHeight();
          if (QLog.isColorLevel()) {
            QLog.d("ReplyTextItemBuilder", 2, "getNoRoundThumbDrawableAbsDownloader cache:" + paramArrayOfInt[0] + "," + paramArrayOfInt[1]);
          }
        }
        return localahqf;
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
  
  private static ahqg a(MessageForMixedMsg paramMessageForMixedMsg)
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
          if (!TextUtils.isEmpty((CharSequence)localObject1))
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
        return new ahqg((MessageForPic)localObject1, (String)localObject3, i, bool1);
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
      localBitmap1 = bhgm.a(BaseApplicationImpl.getContext().getResources(), 2130840856);
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
  
  private View a(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext, ahqh paramahqh, MessageForReplyText paramMessageForReplyText, agjk paramagjk, boolean paramBoolean)
  {
    paramahqh.e = 0;
    Object localObject2 = this.jdField_a_of_type_Ahqj.a(0);
    Object localObject1 = localObject2;
    int j;
    int i;
    if (localObject2 == null)
    {
      localObject1 = new SelectableLinearLayout(paramContext);
      ((LinearLayout)localObject1).setOrientation(1);
      Object localObject3 = a(paramContext);
      paramahqh.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject3);
      paramahqh.c = ((TextView)((ViewGroup)localObject3).findViewById(2131378857));
      paramahqh.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject3).findViewById(2131371647));
      paramahqh.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject3).findViewById(2131367104));
      paramahqh.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject3).findViewById(2131371445));
      paramahqh.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject3).findViewById(2131371462));
      ((ViewGroup)localObject3).setId(2131364451);
      behh.a(paramahqh.jdField_a_of_type_ComEtrumpMixlayoutETTextView);
      behh.a(paramahqh.jdField_b_of_type_ComEtrumpMixlayoutETTextView);
      localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
      paramahqh.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)localObject3).findViewById(2131369272));
      paramahqh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      paramahqh.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131712291));
      localObject3 = new ETTextView(paramContext);
      behh.a((TextView)localObject3);
      ((ETTextView)localObject3).setTextColor(paramContext.getResources().getColorStateList(2131167009));
      ((ETTextView)localObject3).setLinkTextColor(paramContext.getResources().getColorStateList(2131167002));
      ((ETTextView)localObject3).setEditableFactory(begz.a);
      ((ETTextView)localObject3).setSpannableFactory(begp.a);
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
      ((LinearLayout)localObject1).addView(paramahqh.jdField_a_of_type_AndroidViewViewGroup, (ViewGroup.LayoutParams)localObject2);
      ((ETTextView)localObject3).setId(2131364426);
      paramahqh.d = ((TextView)localObject3);
      localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout.LayoutParams)localObject2).topMargin = agej.a(8.0F, paramContext.getResources());
      ((LinearLayout)localObject1).addView(paramahqh.d, (ViewGroup.LayoutParams)localObject2);
    }
    paramahqh.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131371647));
    paramahqh.c = ((TextView)((View)localObject1).findViewById(2131378857));
    paramahqh.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131367104));
    paramahqh.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((View)localObject1).findViewById(2131371445));
    paramahqh.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((View)localObject1).findViewById(2131371462));
    paramahqh.d = ((ETTextView)((View)localObject1).findViewById(2131364426));
    paramahqh.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((View)localObject1).findViewById(2131364451));
    paramahqh.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369272));
    paramahqh.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131712288));
    paramahqh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    paramahqh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838261));
    if (paramMessageForReplyText.getSourceMsgInfo() != null) {}
    for (paramContext = Long.toString(paramMessageForReplyText.getSourceMsgInfo().mSourceMsgSenderUin);; paramContext = "")
    {
      paramContext = go.a(paramContext);
      paramahqh.c.setTypeface(paramContext);
      paramahqh.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramContext);
      paramahqh.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramContext);
      paramahqh.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramContext);
      paramahqh.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramContext);
      if (!TextUtils.isEmpty(paramMessageForReplyText.getExtInfoFromExtStr("sens_msg_ctrl_info")))
      {
        paramContext = ((ETTextView)paramahqh.d).getETLayout();
        if (paramContext != null) {
          paramContext.a = (paramMessageForReplyText.uniseq + 1L);
        }
      }
      ((ETTextView)paramahqh.d).setFont(0, paramMessageForReplyText.uniseq);
      i = ((ETTextView)paramahqh.d).mMaxWidth;
      j = BaseChatItemLayout.e;
      paramahqh.d.setMaxWidth(j);
      paramahqh.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      if (i != j) {
        ((ETTextView)paramahqh.d).mMsgId = 0L;
      }
      paramahqh.d.setText(paramMessageForReplyText.sb);
      if (AppSetting.c) {
        paramahqh.d.setContentDescription(behh.e(paramMessageForReplyText.sb.toString()));
      }
      super.a(paramahqh.d, paramMessageForReplyText);
      a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramahqh.jdField_a_of_type_AndroidViewViewGroup, paramMessageForReplyText.mSourceMsgInfo, paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, paramMessageForReplyText, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      paramahqh.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)((View)localObject1).findViewById(2131378827));
      paramahqh.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramahqh.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramahqh.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject1).setOnTouchListener(paramagjk);
      ((View)localObject1).setOnLongClickListener(paramagjk);
      paramahqh.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramagjk);
      paramahqh.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramagjk);
      paramahqh.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnTouchListener(this.jdField_a_of_type_Agjk);
      paramahqh.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnLongClickListener(this.jdField_a_of_type_Agjk);
      paramahqh.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnTouchListener(this.jdField_a_of_type_Agjk);
      paramahqh.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnLongClickListener(this.jdField_a_of_type_Agjk);
      paramahqh.d.setOnTouchListener(paramagjk);
      paramahqh.d.setOnLongClickListener(paramagjk);
      paramahqh.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((paramahqh.d instanceof AnimationTextView)) {
        ((AnimationTextView)paramahqh.d).onDoubleClick = this.jdField_a_of_type_Biuy;
      }
      if ((paramahqh.jdField_a_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
        paramahqh.jdField_a_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Biuy;
      }
      if (paramahqh.jdField_a_of_type_Ambx == null) {
        paramahqh.jdField_a_of_type_Ambx = new ambx();
      }
      if ((localObject1 instanceof amcj))
      {
        paramahqh.jdField_a_of_type_Ambx.a((amcj)localObject1);
        paramahqh.jdField_a_of_type_Ambx.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
      }
      paramahqh.jdField_a_of_type_Ambx.b(paramMessageForReplyText);
      return localObject1;
    }
  }
  
  public static final RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131560666, null);
    Object localObject = (TextView)localRelativeLayout.findViewById(2131371647);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167009));
    ImmersiveUtils.a((View)localObject, 0.9F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(begz.a);
    ((TextView)localObject).setSpannableFactory(begp.a);
    localObject = (TextView)localRelativeLayout.findViewById(2131378857);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167009));
    ImmersiveUtils.a((View)localObject, 0.9F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(begz.a);
    ((TextView)localObject).setSpannableFactory(begp.a);
    localObject = (TextView)localRelativeLayout.findViewById(2131367104);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167009));
    ImmersiveUtils.a((View)localObject, 0.5F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(begz.a);
    ((TextView)localObject).setSpannableFactory(begp.a);
    ((ImageView)localRelativeLayout.findViewById(2131369272)).setColorFilter(null);
    localObject = (ETTextView)localRelativeLayout.findViewById(2131371445);
    ((ETTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167009));
    ((ETTextView)localObject).setLinkTextColor(paramContext.getResources().getColorStateList(2131167002));
    ImmersiveUtils.a((View)localObject, 0.9F);
    ((ETTextView)localObject).setTextSize(1, 13.0F);
    ((ETTextView)localObject).setEditableFactory(begz.a);
    ((ETTextView)localObject).setSpannableFactory(begp.a);
    ((ETTextView)localObject).setLineSpacing(agej.a(2.0F, paramContext.getResources()), 1.0F);
    localObject = (ETTextView)localRelativeLayout.findViewById(2131371462);
    ((ETTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167009));
    ((ETTextView)localObject).setLinkTextColor(paramContext.getResources().getColorStateList(2131167002));
    ((ETTextView)localObject).setTextSize(1, 13.0F);
    ((ETTextView)localObject).setEditableFactory(begz.a);
    ((ETTextView)localObject).setSpannableFactory(begp.a);
    ((ETTextView)localObject).setLineSpacing(agej.a(2.0F, paramContext.getResources()), 1.0F);
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
        paramContext = beyq.a(paramURL, j, i, new ascz(j, i), beyq.a(), true, f1);
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
          bhmq.a(paramFile.getAbsolutePath(), paramContext);
          j = paramContext.outWidth;
          i = paramContext.outHeight;
          int m = beyq.a(paramFile.getAbsolutePath());
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
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt, ahqf paramahqf)
  {
    boolean bool1 = bmgb.a(paramMessageForPic.imageType);
    boolean bool2 = paramahqf.jdField_a_of_type_Boolean;
    URL localURL = paramahqf.jdField_a_of_type_JavaNetURL;
    Rect localRect = paramahqf.jdField_a_of_type_AndroidGraphicsRect;
    Object localObject = localURL;
    if (localURL == null) {
      paramahqf = beyq.a(paramMessageForPic, 65537, null);
    }
    try
    {
      localObject = new URL(paramahqf.toString());
      paramahqf = (ahqf)localObject;
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
        paramahqf = beqz.a(paramahqf);
        if (paramahqf == null) {
          break;
        }
        paramContext = a(paramContext, paramChatThumbView, paramArrayOfInt, localMalformedURLException, localRect, paramahqf, bool1);
      }
      if (beyq.a(paramContext)) {
        break label506;
      }
    }
    localObject = paramahqf;
    if (QLog.isColorLevel())
    {
      QLog.d("ReplyTextItemBuilder", 2, "getThumbDrawable,using thumb,uniseq:" + paramMessageForPic.uniseq + " url:" + paramahqf);
      localObject = paramahqf;
    }
    paramahqf = ((URL)localObject).toString();
    int j = paramContext.getResources().getDisplayMetrics().densityDpi;
    if (paramChatThumbView != null) {
      paramChatThumbView.jdField_a_of_type_Boolean = false;
    }
    f = j / 160.0F;
    if (BaseApplicationImpl.sImageCache.get(paramahqf) != null)
    {
      paramContext = beyq.a((URL)localObject, 0, 0, null, null, true, 12.0F * f);
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
    paramChatThumbView.mLoadingDrawable = beyq.b();
    paramChatThumbView.mFailedDrawable = beyq.a();
    paramChatThumbView.mPlayGifImage = bool2;
    paramChatThumbView.mGifRoundCorner = 12.0F;
    paramChatThumbView.mImgType = paramMessageForPic.imageType;
    if (paramArrayOfInt != null)
    {
      paramArrayOfInt[0] = paramChatThumbView.mRequestWidth;
      paramArrayOfInt[1] = paramChatThumbView.mRequestHeight;
    }
    paramChatThumbView.mLoadingDrawable = paramContext.getResources().getDrawable(2130843821);
    paramContext = URLDrawable.getDrawable(localMalformedURLException, paramChatThumbView);
    if (QLog.isColorLevel()) {
      QLog.d("ReplyTextItemBuilder", 2, "getNoRoundThumbDrawableautoDownload:" + paramChatThumbView.mRequestWidth + "," + paramChatThumbView.mRequestHeight);
    }
    if ((azqc.jdField_a_of_type_Boolean) || (i != 0)) {
      paramContext.setAutoDownload(true);
    }
    for (;;)
    {
      paramContext.setProgressDrawable(new bjae(a(), 0, false));
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
    if (aunj.a(paramMessageRecord)) {
      paramQQAppInterface = aunj.a((ChatMessage)paramMessageRecord);
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
        localMessageRecord = paramQQAppInterface.a().c(paramMessageRecord1.frienduin, paramMessageRecord1.istroop, paramMessageRecord2.shmsgseq + i);
        if ((localMessageRecord == null) || (!localMessageRecord.isLongMsg()) || (!(localMessageRecord instanceof MessageForText))) {
          break label93;
        }
        if (!TextUtils.isEmpty(localMessageRecord.msg)) {
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
            if ((!(paramMessageRecord1 instanceof MessageForText)) || (TextUtils.isEmpty(paramMessageRecord1.msg))) {
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
    paramQQAppInterface = paramQQAppInterface.a().a(paramString, paramInt);
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
    List localList = paramQQAppInterface.a().a(paramString, paramInt);
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
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForReplyText)) && (((MessageForReplyText)paramMessageRecord).getSourceMessage() != null))
    {
      paramString = ((MessageForReplyText)paramMessageRecord).getSourceMessage();
      return paramString;
    }
    if (paramMessageRecord.isMultiMsg)
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
        localObject1 = aqvy.a(paramContext, (int)(l / 1000L));
      }
    }
    label60:
    do
    {
      return localObject1;
      localObject1 = localObject2;
    } while (!aunj.a(paramMessageRecord2));
    paramMessageRecord1 = a(paramQQAppInterface, paramMessageRecord2);
    if ((paramMessageRecord1 instanceof MessageForFile))
    {
      paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord1.uniseq, paramMessageRecord1.frienduin, paramMessageRecord1.istroop);
      if ((paramQQAppInterface == null) || (aunj.a(paramQQAppInterface.fileName) != 2)) {
        break label188;
      }
    }
    label188:
    for (paramContext = aqvy.a(paramContext, (int)(l / 1000L));; paramContext = null)
    {
      return paramContext;
      localObject1 = localObject2;
      if (!(paramMessageRecord1 instanceof MessageForTroopFile)) {
        break;
      }
      paramQQAppInterface = bgsk.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord1);
      localObject1 = localObject2;
      if (paramQQAppInterface == null) {
        break;
      }
      localObject1 = localObject2;
      if (aunj.a(paramQQAppInterface.g) != 2) {
        break;
      }
      return aqvy.a(paramContext, (int)(l / 1000L));
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
          if (TextUtils.isEmpty(str))
          {
            paramQQAppInterface = bgsk.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord2);
            localObject = str;
            if (paramQQAppInterface != null) {
              localObject = paramQQAppInterface.g;
            }
          }
          paramQQAppInterface = (QQAppInterface)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = paramMessageRecord2.getExtInfoFromExtStr("_m_ForwardFileName");
            paramQQAppInterface = (QQAppInterface)localObject;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              paramQQAppInterface = anzj.a(2131705459) + (String)localObject;
            }
          }
          if (TextUtils.isEmpty(paramQQAppInterface)) {
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
  
  private static void a(Context paramContext, ChatThumbView paramChatThumbView, arwl paramarwl, MessageForPic paramMessageForPic)
  {
    boolean bool = bmgb.a(paramMessageForPic.imageType);
    if (!bool)
    {
      paramContext = ahng.a(paramContext, paramMessageForPic, paramChatThumbView);
      if (paramContext != null)
      {
        paramChatThumbView.setAdjustViewBounds(true);
        paramChatThumbView.setMaxWidth(besm.a(false));
        paramChatThumbView.setMaxHeight(besm.a(false));
        paramChatThumbView.setImageDrawable(paramContext.mutate());
      }
      paramChatThumbView.setTag(2131364437, paramMessageForPic);
      return;
    }
    int[] arrayOfInt = new int[2];
    int[] tmp70_68 = arrayOfInt;
    tmp70_68[0] = 0;
    int[] tmp74_70 = tmp70_68;
    tmp74_70[1] = 0;
    tmp74_70;
    URL localURL = beyq.a(paramMessageForPic, 65537);
    try
    {
      localURL = new URL(localURL.toString());
      if (localURL == null)
      {
        paramChatThumbView.setImageDrawable(ahvj.a(2, 200, 200));
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
        localahqf = null;
      }
      ahqf localahqf = a(paramContext, paramMessageForPic, paramChatThumbView, arrayOfInt);
      paramContext = a(paramContext, paramMessageForPic, paramChatThumbView, new int[] { 0, 0 }, localahqf);
      paramChatThumbView.setTag(2131364437, paramMessageForPic);
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
      j = besm.a(bool);
      n = Math.min(besm.b(bool), 80);
      if (arrayOfInt[0] <= j) {
        break label439;
      }
      i = j;
      if (arrayOfInt[1] <= j) {
        break label448;
      }
      i1 = agej.a(95.0F, paramChatThumbView.getResources());
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
        if (paramarwl != null)
        {
          if (paramarwl.getSourceMsgInfo() != null)
          {
            paramarwl.getSourceMsgInfo().replyPicWidth = k;
            paramarwl.getSourceMsgInfo().replyPicHeight = m;
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
      localObject = (TextView)paramViewGroup.findViewById(2131367104);
      localImageView = (ImageView)paramViewGroup.findViewById(2131369272);
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
    paramViewGroup = paramContext.getString(2131698314);
    if (!TextUtils.isEmpty(paramSourceMsgInfo.mSourceMsgTroopName))
    {
      paramMessageRecord1 = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramSourceMsgInfo.mSourceMsgToUin + "");
      paramViewGroup = paramSourceMsgInfo.mSourceMsgTroopName;
      paramQQAppInterface = paramViewGroup;
      if (paramMessageRecord1 != null)
      {
        paramQQAppInterface = paramViewGroup;
        if (!TextUtils.isEmpty(paramMessageRecord1.getTroopName())) {
          paramQQAppInterface = paramMessageRecord1.getTroopName();
        }
      }
      paramViewGroup = paramContext.getString(2131698313) + paramQQAppInterface;
    }
    ((TextView)localObject).setText(paramViewGroup);
    ((TextView)localObject).setVisibility(0);
    paramContext = ((FragmentActivity)paramContext).getChatFragment();
    if ((paramContext != null) && ((paramContext.a() instanceof aimn))) {}
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
    BubbleImageView localBubbleImageView = (BubbleImageView)paramViewGroup.findViewById(2131378827);
    int i = paramViewGroup.findViewById(2131371647).getPaddingLeft();
    localBubbleImageView.setRadius(0.0F);
    localBubbleImageView.setAdjustViewBounds(true);
    localBubbleImageView.d(false);
    localBubbleImageView.setShowEdge(true);
    if ((paramMessageRecord2 instanceof MessageForShortVideo)) {
      localBubbleImageView.setContentDescription(anzj.a(2131712290));
    }
    Object localObject;
    for (;;)
    {
      localObject = paramViewGroup.findViewById(2131368391);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = bhgr.a(paramContext, 25.0F);
      ((View)localObject).setLayoutParams(localLayoutParams);
      i = Build.VERSION.SDK_INT;
      if ((i == 19) || (i == 18)) {
        localBubbleImageView.e = true;
      }
      localObject = (ETTextView)paramViewGroup.findViewById(2131371462);
      paramViewGroup = (ETTextView)paramViewGroup.findViewById(2131371445);
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
      localBubbleImageView.setContentDescription(anzj.a(2131712283));
    }
    if ((paramBoolean2) || (a(paramString)) || (paramSourceMsgInfo.mSourceSummaryFlag != 1))
    {
      c(paramContext, paramQQAppInterface, localBubbleImageView, paramMessageRecord1, new ahpz(paramViewGroup, (ETTextView)localObject, paramSourceMsgInfo, localBubbleImageView, paramInt, paramString, paramMessageRecord1, paramContext));
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
    String str = bhsw.a(paramContext, 3, paramSourceMsgInfo.mSourceMsgTime * 1000L).toString();
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(2131371647);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(2131378857);
    boolean bool;
    Object localObject2;
    Object localObject1;
    label144:
    MessageRecord localMessageRecord;
    if ((paramBoolean) || (a(paramSourceMsgInfo.mSourceMsgText)))
    {
      bool = true;
      localObject2 = paramSourceMsgInfo.mSourceMsgText;
      if (TextUtils.isEmpty(paramSourceMsgInfo.mAnonymousNickName)) {
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
      if (anxg.a(localMessageRecord))
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
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localTextView1.setTag(2131378415, localObject1);
        localTextView1.setTag(2131378416, Long.valueOf(paramSourceMsgInfo.mSourceMsgSenderUin));
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
          localObject1 = bgrf.a((MessageRecord)localObject1);
          if (localObject1 != null) {
            paramSourceMsgInfo.mAnonymousNickName = ((bgrg)localObject1).c;
          }
        }
        localObject1 = "";
        break label144;
      }
      localObject1 = localTextView1.getTag(2131378416);
      if ((localObject1 == null) || (((Long)localObject1).longValue() != paramSourceMsgInfo.mSourceMsgSenderUin))
      {
        ThreadManager.excute(new ReplyTextItemBuilder.9(paramQQAppInterface, paramInt, paramString, paramSourceMsgInfo, localTextView1, localTextView2, str), 64, null, true);
        localObject1 = "";
        break label144;
      }
      localTextView1.setText(new begb((String)localTextView1.getTag(2131378415), 16).a());
      localTextView2.setText(" " + str);
      localObject1 = "";
      break label144;
      label573:
      paramString = anzj.a(2131712285);
      break label239;
      label584:
      if (((localMessageRecord instanceof MessageForPic)) && (bool) && ((paramMessageRecord instanceof arwl)))
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
  
  protected static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, ahqi paramahqi)
  {
    ThreadManager.post(new ReplyTextItemBuilder.3(paramMessageRecord, paramQQAppInterface, paramahqi, paramContext, paramChatThumbView), 8, null, true);
  }
  
  public static final void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    arwl localarwl = null;
    if ((paramMessageRecord1 instanceof arwl)) {
      localarwl = (arwl)paramMessageRecord1;
    }
    if ((paramMessageRecord2 instanceof MessageForPic)) {
      a(paramContext, paramChatThumbView, localarwl, (MessageForPic)paramMessageRecord2);
    }
    do
    {
      return;
      if (!aunj.a(paramMessageRecord2)) {
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
    if ((localarwl != null) && (localarwl.getSourceMsgInfo() != null) && (localarwl.getSourceMsgInfo().replyPicWidth != 0))
    {
      paramChatThumbView.setImageDrawable(ahvj.a(2, 200, 200));
      return;
    }
    paramChatThumbView.setVisibility(8);
  }
  
  protected static void a(Context paramContext, QQAppInterface paramQQAppInterface, BubbleImageView paramBubbleImageView, MessageRecord paramMessageRecord, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, ETTextView paramETTextView1, ETTextView paramETTextView2, int paramInt, String paramString)
  {
    paramSourceMsgInfo = new ahqb(paramSourceMsgInfo, paramBubbleImageView, paramETTextView2, paramETTextView1, paramInt, paramString, paramMessageRecord);
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
    Object localObject = paramChatThumbView.findViewById(2131378824);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramChatThumbView.findViewById(2131365173);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramChatThumbView.findViewById(2131365335);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (ImageView)paramChatThumbView.findViewById(2131368238);
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
    if ((beyq.b() instanceof SkinnableBitmapDrawable))
    {
      localBitmap = ((SkinnableBitmapDrawable)beyq.b()).getBitmap();
      paramChatThumbView.setImageDrawable(new ascx(paramContext.getResources(), localBitmap, paramSourceMsgInfo.replyPicWidth, paramSourceMsgInfo.replyPicHeight, -921103));
      return;
    }
    if ((beyq.b() instanceof BitmapDrawable))
    {
      localBitmap = ((BitmapDrawable)beyq.b()).getBitmap();
      paramChatThumbView.setImageDrawable(new ascx(paramContext.getResources(), localBitmap, paramSourceMsgInfo.replyPicWidth, paramSourceMsgInfo.replyPicHeight, -921103));
      return;
    }
    paramChatThumbView.setImageDrawable(beyq.b());
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
    paramInt2 = agej.a(120.0F, ((Context)localObject).getResources());
    int i = agej.a(80.0F, ((Context)localObject).getResources());
    if (paramInt1 <= 0) {
      if (paramBoolean) {
        paramInt1 = agej.a(60.0F, ((Context)localObject).getResources());
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
          paramInt1 = agej.a(120.0F, ((Context)localObject).getResources());
          break;
          paramChatThumbView.setVisibility(8);
          ((ViewGroup)localObject).setVisibility(0);
          paramChatThumbView = (AsyncImageView)((ViewGroup)localObject).findViewById(2131378824);
          if (paramChatThumbView != null) {
            paramChatThumbView.setVisibility(8);
          }
          paramChatThumbView = ((ViewGroup)localObject).findViewById(2131365335);
          if (paramChatThumbView != null)
          {
            ViewGroup.LayoutParams localLayoutParams = paramChatThumbView.getLayoutParams();
            localLayoutParams.width = paramInt1;
            localLayoutParams.height = i;
            paramChatThumbView.setLayoutParams(localLayoutParams);
            paramChatThumbView.setVisibility(0);
            paramChatThumbView.getBackground().setAlpha(26);
          }
          paramChatThumbView = ((ViewGroup)localObject).findViewById(2131365173);
          if (paramChatThumbView != null) {
            paramChatThumbView.setVisibility(8);
          }
          paramChatThumbView = (ImageView)((ViewGroup)localObject).findViewById(2131368238);
        } while (paramChatThumbView == null);
        paramChatThumbView.setVisibility(0);
        if (paramBoolean)
        {
          paramChatThumbView.setImageResource(2130844359);
          return;
        }
        paramChatThumbView.setImageResource(2130844358);
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
        paramString = localViewGroup.findViewById(2131365173);
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
      paramChatThumbView = localViewGroup.findViewById(2131365335);
      if (paramChatThumbView != null) {
        paramChatThumbView.setVisibility(8);
      }
      paramChatThumbView = (ImageView)localViewGroup.findViewById(2131368238);
    } while (paramChatThumbView == null);
    if (paramBoolean)
    {
      paramChatThumbView.setImageResource(2130844359);
      paramChatThumbView.setVisibility(0);
      return;
    }
    paramChatThumbView.setVisibility(8);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, TextView paramTextView, MessageRecord paramMessageRecord, String paramString)
  {
    int i;
    if (aunj.a(paramMessageRecord))
    {
      paramMessageRecord = a(paramQQAppInterface, paramMessageRecord);
      if ((paramMessageRecord instanceof MessageForFile))
      {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "handleReplyTextStyle, sourceMsg uniseq[" + paramMessageRecord.uniseq + "]");
        paramMessageRecord = paramQQAppInterface.a().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if ((paramMessageRecord == null) || (paramMessageRecord.status == 16)) {
          break label750;
        }
        i = aunj.a(aunj.a(paramMessageRecord.fileName), 1);
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
        i = agej.a(15.0F, paramContext.getResources());
        int j = agej.a(4.0F, paramContext.getResources());
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
        paramMessageRecord = bgsk.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord);
        if (paramMessageRecord == null) {
          break label750;
        }
        i = aunj.a(aunj.a(paramMessageRecord.g), 1);
        if (Build.VERSION.SDK_INT >= 21) {}
        for (paramQQAppInterface = paramContext.getDrawable(i);; paramQQAppInterface = paramContext.getResources().getDrawable(i))
        {
          paramTextView.setText(paramMessageRecord.g);
          break;
        }
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          if ((!amnp.a(paramMessageRecord)) || (c(paramMessageRecord))) {
            break label745;
          }
          label336:
          URLDrawable.URLDrawableOptions localURLDrawableOptions;
          if (Build.VERSION.SDK_INT >= 21)
          {
            paramString = paramContext.getDrawable(2130844318);
            paramQQAppInterface = paramString;
            if (((MessageForStructing)paramMessageRecord).structingMsg != null)
            {
              paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg.mMsgUrl;
              paramQQAppInterface = becb.f(paramMessageRecord);
              i = agej.a(15.0F, paramContext.getResources());
              localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
              localURLDrawableOptions.mLoadingDrawable = paramString;
              localURLDrawableOptions.mFailedDrawable = paramString;
              localURLDrawableOptions.mRequestWidth = i;
              localURLDrawableOptions.mRequestHeight = i;
              localURLDrawableOptions.mUseAutoScaleParams = false;
              if (TextUtils.isEmpty(paramQQAppInterface)) {
                break label458;
              }
              paramQQAppInterface = URLDrawable.getDrawable(paramQQAppInterface, localURLDrawableOptions);
              paramQQAppInterface.setBounds(0, 0, i, i);
            }
          }
          for (;;)
          {
            break;
            paramString = paramContext.getResources().getDrawable(2130844318);
            break label336;
            label458:
            paramQQAppInterface = paramString;
            if (!TextUtils.isEmpty(paramMessageRecord))
            {
              paramQQAppInterface = paramString;
              if (paramMessageRecord.contains(becb.c))
              {
                paramQQAppInterface = URLDrawable.getDrawable(becb.d, localURLDrawableOptions);
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
              if ((paramMessageRecord == null) || (!ardb.a().a(paramMessageRecord.appName, paramMessageRecord.appView))) {
                break label745;
              }
              if (Build.VERSION.SDK_INT < 21) {
                break label691;
              }
              paramQQAppInterface = paramContext.getDrawable(2130844318);
              paramMessageRecord = ardb.a().a(new JSONObject(paramMessageRecord.toAppXml())).get("kArkMsgReplyIcon").toString();
              i = agej.a(15.0F, paramContext.getResources());
              paramString = URLDrawable.URLDrawableOptions.obtain();
              paramString.mLoadingDrawable = paramQQAppInterface;
              paramString.mFailedDrawable = paramQQAppInterface;
              paramString.mRequestWidth = i;
              paramString.mRequestHeight = i;
              paramString.mUseAutoScaleParams = false;
              if (TextUtils.isEmpty(paramMessageRecord)) {
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
          paramQQAppInterface = paramContext.getResources().getDrawable(2130844318);
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
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!bhmi.b((String)localObject)) {}
    for (;;)
    {
      try
      {
        localObject = bcwu.a(2, 2);
        bcwx localbcwx = paramMessageForShortVideo.getDownloadInfo(((bcxn)localObject).jdField_b_of_type_Int);
        localbcwx.i = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
        localbcwx.a(paramMessageForShortVideo.istroop, 1);
        ((bcxn)localObject).a(localbcwx);
        ((bcxn)localObject).a(new ahqa(paramMessageForShortVideo, paramMessageForReplyText, paramQQAppInterface, paramChatThumbView));
        bcwu.a((bcxn)localObject, paramQQAppInterface);
        paramQQAppInterface = (ImageView)((ViewGroup)paramChatThumbView.getParent()).findViewById(2131368238);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface.setImageResource(2130844359);
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
    FileManagerEntity localFileManagerEntity = paramQQAppInterface.a().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
    boolean bool;
    if (localFileManagerEntity != null)
    {
      int i = aunj.a(localFileManagerEntity.fileName);
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
      if (!bhmi.b((String)localObject2)) {
        localObject1 = localFileManagerEntity.strLargeThumPath;
      }
      localObject2 = localObject1;
      if (!bhmi.b((String)localObject1))
      {
        if (!bool) {
          break label503;
        }
        if (localFileManagerEntity.peerType != 3000) {
          break label490;
        }
        paramQQAppInterface = paramQQAppInterface.a().b(localFileManagerEntity);
        localObject2 = paramQQAppInterface;
        if (!bhmi.b(paramQQAppInterface))
        {
          if ((localFileManagerEntity.imgWidth <= 0) || (localFileManagerEntity.imgHeight <= 0)) {
            break label540;
          }
          localObject1 = auob.a(localFileManagerEntity.imgWidth, localFileManagerEntity.imgHeight, "");
          if (QLog.isDebugVersion()) {
            QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle offline file set default. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + ((auoc)localObject1).jdField_a_of_type_Int + "]");
          }
          a(paramChatThumbView, bool, ((auoc)localObject1).jdField_a_of_type_Int, ((auoc)localObject1).jdField_b_of_type_Int);
        }
      }
      for (localObject2 = paramQQAppInterface;; localObject2 = paramQQAppInterface)
      {
        if (!bhmi.b((String)localObject2)) {
          break label552;
        }
        if ((localFileManagerEntity.imgWidth <= 0) || (localFileManagerEntity.imgHeight <= 0)) {
          break label554;
        }
        paramQQAppInterface = auob.a(localFileManagerEntity.imgWidth, localFileManagerEntity.imgHeight, (String)localObject2);
        if (QLog.isDebugVersion()) {
          QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle offline file set thumb. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + paramQQAppInterface.jdField_a_of_type_Int + "]");
        }
        a(paramChatThumbView, bool, paramQQAppInterface.jdField_a_of_type_Int, paramQQAppInterface.jdField_b_of_type_Int, (String)localObject2);
        return;
        label490:
        paramQQAppInterface = paramQQAppInterface.a().a(localFileManagerEntity);
        break;
        label503:
        if (auob.b(localFileManagerEntity))
        {
          paramQQAppInterface = paramQQAppInterface.a().a(localFileManagerEntity, 7);
          break;
        }
        paramQQAppInterface = paramQQAppInterface.a().a(localFileManagerEntity, 5);
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
      bdll.b(paramQQAppInterface, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
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
              i = ardb.a(paramMessageRecord.appName, paramMessageRecord.appView);
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
        bhmq.a(paramFile.getAbsolutePath(), paramRect);
        j = paramRect.outWidth;
        i = paramRect.outHeight;
        int k = beyq.a(paramFile.getAbsolutePath());
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
    paramQQAppInterface = bgsk.a(paramQQAppInterface, paramMessageForTroopFile);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      int i = aunj.a(paramQQAppInterface.g);
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
    paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      if (paramQQAppInterface.status == 16) {
        break label63;
      }
      int i = aunj.a(paramQQAppInterface.fileName);
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
      QLog.d("ReplyTextItemBuilder", 2, "sendUin= " + paramSourceMsgInfo.mSourceMsgSenderUin + " toUin=" + paramSourceMsgInfo.mSourceMsgToUin + " session curFin=" + paramSessionInfo.jdField_a_of_type_JavaLangString + " type=" + paramSessionInfo.jdField_a_of_type_Int);
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
        if (paramSessionInfo.jdField_a_of_type_Int == 3000) {
          return str1.equals(paramSessionInfo.jdField_a_of_type_JavaLangString);
        }
        if (paramSessionInfo.jdField_a_of_type_Int != 1) {
          break;
        }
      } while (str1.equals(paramSessionInfo.jdField_a_of_type_JavaLangString));
      paramSourceMsgInfo = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if ((paramSourceMsgInfo != null) && (str1.equals(paramSourceMsgInfo.troopcode))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    } while (((str2.equals(paramSessionInfo.jdField_a_of_type_JavaLangString)) && (str1.equals(paramQQAppInterface.getCurrentAccountUin()))) || ((str1.equals(paramSessionInfo.jdField_a_of_type_JavaLangString)) && (str2.equals(paramQQAppInterface.getCurrentAccountUin()))));
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.indexOf(anzj.a(2131712287)) == -1) {
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
          if ((!(localMessageRecord instanceof MessageForText)) || (TextUtils.isEmpty(localMessageRecord.msg))) {
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
      if (((paramMessageRecord2 instanceof MessageForText)) && (!TextUtils.isEmpty(paramMessageRecord2.msg))) {
        paramStringBuilder.append(paramMessageRecord2.msg);
      }
      bool1 = false;
    }
  }
  
  private static void b(int paramInt1, int paramInt2, String paramString, ImageView paramImageView)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      paramString = ahqw.a(paramString, 55, 95, agej.a(2.0F, paramImageView.getContext().getResources()));
    }
    while ((paramString == null) || (paramString.getCurrent() == null))
    {
      paramImageView.setVisibility(8);
      return;
      if (paramInt1 > paramInt2)
      {
        paramInt1 = (int)(Float.valueOf(paramInt1).floatValue() / 95);
        paramString = ahqw.a(paramString, 95, (int)(Float.valueOf(paramInt2).floatValue() / paramInt1), agej.a(2.0F, paramImageView.getContext().getResources()));
      }
      else
      {
        paramInt2 = (int)(Float.valueOf(paramInt2).floatValue() / 95);
        paramString = ahqw.a(paramString, (int)(Float.valueOf(paramInt1).floatValue() / paramInt2), 95, agej.a(2.0F, paramImageView.getContext().getResources()));
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
    localLayoutParams.width = paramString.getCurrent().getIntrinsicWidth();
    localLayoutParams.height = paramString.getCurrent().getIntrinsicHeight();
    paramImageView.setLayoutParams(localLayoutParams);
    paramImageView.setImageDrawable(paramString);
  }
  
  protected static void b(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, ahqi paramahqi)
  {
    ThreadManager.post(new ReplyTextItemBuilder.4(paramMessageRecord, paramQQAppInterface, paramahqi, paramContext, paramChatThumbView), 8, null, true);
  }
  
  private static void b(TextView paramTextView1, TextView paramTextView2, int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = bhwz.a(str, paramMessageRecord, ChatTextSizeSettingActivity.b() - 2, 7);
    switch (paramInt)
    {
    default: 
      paramTextView1.setVisibility(0);
      paramTextView1.setText(paramString);
      if (AppSetting.c) {
        paramTextView1.setContentDescription(behh.e(str));
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
        paramTextView1.setContentDescription(behh.e(str));
      }
      paramTextView2.setVisibility(8);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText(paramString);
    if (AppSetting.c) {
      paramTextView2.setContentDescription(behh.e(str));
    }
    paramTextView1.setVisibility(8);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramMessageRecord;
    localMessageForTroopFile.doParse();
    bftf localbftf = bgsk.a(paramQQAppInterface, localMessageForTroopFile);
    if (localbftf == null)
    {
      a(paramChatThumbView, false, 0, 0);
      return;
    }
    int k = aunj.a(localbftf.g);
    if ((localbftf == null) || (localbftf.jdField_b_of_type_Int == 12))
    {
      if (k == 2) {}
      for (bool = true;; bool = false)
      {
        a(paramChatThumbView, bool, 0, 0);
        return;
      }
    }
    if (bhmi.b(localbftf.d)) {}
    for (String str = localbftf.d; bhmi.b(str); str = localbftf.c)
    {
      if (k == 2) {
        bool = true;
      }
      paramQQAppInterface = auob.a(localMessageForTroopFile.width, localMessageForTroopFile.height, str);
      if (QLog.isDebugVersion()) {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle troop file set thumb. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + paramQQAppInterface.jdField_a_of_type_Int + "]");
      }
      a(paramChatThumbView, bool, paramQQAppInterface.jdField_a_of_type_Int, paramQQAppInterface.jdField_b_of_type_Int, str);
      return;
    }
    paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(localMessageForTroopFile.frienduin));
    int j = 383;
    int i = j;
    if (auob.b(localMessageForTroopFile.width, localMessageForTroopFile.height))
    {
      i = j;
      if (!auog.b(localbftf.c)) {
        i = 640;
      }
    }
    if (localbftf.jdField_b_of_type_Int != 12)
    {
      if (localbftf.a != null)
      {
        paramQQAppInterface.a(localbftf.a, i);
        paramChatThumbView.setTag(2131364438, new Boolean(true));
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
      paramQQAppInterface = auob.a(localMessageForTroopFile.width, localMessageForTroopFile.height, "");
      if (QLog.isDebugVersion()) {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle troop file set default. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + paramQQAppInterface.jdField_a_of_type_Int + "]");
      }
      a(paramChatThumbView, bool, paramQQAppInterface.jdField_a_of_type_Int, paramQQAppInterface.jdField_b_of_type_Int);
      return;
      paramQQAppInterface.a(localbftf.e, localbftf.g, localbftf.h, i);
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
      if (anxg.a(paramMessageRecord1))
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
        paramBubbleImageView.setTag(2131364438, null);
        paramSourceMsgInfo = (ViewGroup)paramBubbleImageView.getParent();
        if (paramSourceMsgInfo != null) {
          paramSourceMsgInfo.setVisibility(0);
        }
        paramBubbleImageView.setVisibility(0);
        a(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord2, paramString2);
        label87:
        b(paramETTextView1, paramETTextView2, i, (String)localObject1, paramMessageRecord1);
        a(paramQQAppInterface, paramContext, paramETTextView1, paramMessageRecord1, (String)localObject1);
        paramMessageRecord1 = agej.a(paramETTextView1);
        if ((paramMessageRecord1 != null) && ((paramMessageRecord1 instanceof ahqh))) {
          ((ahqh)paramMessageRecord1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramBubbleImageView;
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
          bool1 = ((ahqg)localObject1).jdField_a_of_type_Boolean;
          i = ((ahqg)localObject1).jdField_a_of_type_Int;
          paramString1 = ((ahqg)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
          localObject1 = ((ahqg)localObject1).jdField_a_of_type_JavaLangString;
          if (TextUtils.isEmpty(paramString2)) {
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
        if (!aunj.a(paramMessageRecord1)) {
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
  
  protected static void c(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, ahqi paramahqi)
  {
    ThreadManager.post(new ReplyTextItemBuilder.5(paramMessageRecord, paramQQAppInterface, paramahqi, paramContext, paramChatThumbView), 8, null, true);
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
  
  public aggk a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (ahqh)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  public aggl a()
  {
    return new ahqh(this);
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (paramView != null)
    {
      localahqh = (ahqh)paramView.getTag();
      if (localahqh != null) {
        this.jdField_a_of_type_Ahqj.a(localahqh.e, paramView);
      }
    }
    ahqh localahqh = (ahqh)paramaggl;
    int i;
    if (localMessageForReplyText.mSourceMsgInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ReplyTextItemBuilder", 2, "text.mSourceMsgInfo为null, text:" + localMessageForReplyText.toString());
      }
      localahqh.e = -1;
      paramaggl = this.jdField_a_of_type_Ahqj.a(-1);
      if (paramaggl != null) {
        break label643;
      }
      paramaggl = new LinearLayout(localContext);
      paramaggl.setOrientation(1);
      paramView = new ETTextView(localContext);
      paramView.setTextColor(localContext.getResources().getColorStateList(2131167009));
      paramView.setLinkTextColor(localContext.getResources().getColorStateList(2131167002));
      paramView.setEditableFactory(begz.a);
      paramView.setSpannableFactory(begp.a);
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
      paramView.setId(2131364426);
      localahqh.d = paramView;
      paramView = new LinearLayout.LayoutParams(-2, -2);
      paramView.topMargin = agej.a(5.0F, localContext.getResources());
      paramaggl.addView(localahqh.d, paramView);
    }
    label643:
    for (;;)
    {
      ((ETTextView)localahqh.d).setFont(0, paramChatMessage.uniseq);
      localahqh.d.setTypeface(go.a(paramChatMessage));
      localahqh.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      localahqh.d.setText(localMessageForReplyText.sb);
      super.a(localahqh.d, paramChatMessage);
      paramaggl.setOnTouchListener(paramagjk);
      paramaggl.setOnLongClickListener(paramagjk);
      localahqh.d.setOnTouchListener(paramagjk);
      localahqh.d.setOnLongClickListener(paramagjk);
      paramView = paramaggl;
      if ((localahqh.d instanceof AnimationTextView))
      {
        ((AnimationTextView)localahqh.d).onDoubleClick = this.jdField_a_of_type_Biuy;
        paramView = paramaggl;
      }
      if (paramView != null)
      {
        paramView.setTag(localahqh);
        paramView.setPadding(0, 0, 0, 0);
        if ((AppSetting.c) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0))
        {
          paramaggl = behh.e(paramChatMessage.msg);
          if (!paramChatMessage.isSend()) {
            break label604;
          }
          paramView.setContentDescription(anzj.a(2131712284) + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + anzj.a(2131712289) + paramaggl);
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
        paramView = a(paramBaseChatItemLayout, localContext, localahqh, localMessageForReplyText, paramagjk, bool);
        break;
      }
      label604:
      paramView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + anzj.a(2131712286) + paramaggl);
      return paramView;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ahqj.a();
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
    agsd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 3);
    Bundle localBundle = new Bundle();
    localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
    Object localObject = (MessageForReplyText)paramChatMessage;
    if (ambu.a().c())
    {
      paramContext = ambu.a().b();
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
        localObject = (bbdj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(340);
        MessageRecord localMessageRecord = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage, ((MessageForReplyText)paramChatMessage).mSourceMsgInfo);
        ((MessageForReplyText)paramChatMessage).setSourceMessageRecord(localMessageRecord);
        ((bbdj)localObject).a(paramChatMessage);
      }
      for (;;)
      {
        localBundle.putString("forward_text", paramContext);
        localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramContext = new Intent();
        paramContext.putExtras(localBundle);
        auxu.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
        if (!paramChatMessage.isMultiMsg) {
          break;
        }
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 1, 0, "1", "", "", "");
        return;
        paramContext = ((MessageForReplyText)localObject).msg;
        break label103;
        if (paramContext.length() != ambu.a().a()) {
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
  
  public void a(aggl paramaggl, View paramView, ChatMessage paramChatMessage, aqkt paramaqkt)
  {
    ahqh localahqh = (ahqh)paramaggl;
    paramaggl = (MessageForReplyText)paramChatMessage;
    if (paramaggl.mSourceMsgInfo == null) {
      return;
    }
    Object localObject = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838261);
    localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
    int i = paramaggl.mSourceMsgInfo.mType;
    if ((paramaqkt.jdField_a_of_type_Int == 0) || (!paramaqkt.a()) || (bdgb.b()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramaggl = paramView.getColorStateList(2131167013);
        localahqh.d.setTextColor(paramaggl);
        localahqh.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaggl);
        localahqh.c.setTextColor(paramaggl);
        localahqh.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaggl);
        localahqh.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaggl);
        localahqh.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaggl);
        ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(paramaggl.getDefaultColor(), PorterDuff.Mode.SRC_ATOP));
        localahqh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        if (!paramChatMessage.isSend()) {
          break label294;
        }
      }
      label294:
      for (paramaggl = paramView.getColorStateList(2131167012);; paramaggl = paramView.getColorStateList(2131167011))
      {
        localahqh.d.setLinkTextColor(paramaggl);
        localahqh.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaggl);
        localahqh.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaggl);
        ImmersiveUtils.a(localahqh.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
        ImmersiveUtils.a(localahqh.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
        ImmersiveUtils.a(localahqh.c, 0.9F);
        ImmersiveUtils.a(localahqh.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        ImmersiveUtils.a(localahqh.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        return;
        paramaggl = paramView.getColorStateList(2131167009);
        break;
      }
    }
    if (paramaqkt.jdField_b_of_type_Int == 0)
    {
      localahqh.d.setTextColor(-16777216);
      localahqh.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      localahqh.c.setTextColor(-16777216);
      localahqh.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      localahqh.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      localahqh.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP));
      localahqh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      label407:
      if (paramaqkt.jdField_c_of_type_Int != 0) {
        break label749;
      }
      paramaggl = paramView.getResources().getColorStateList(2131167011);
      localahqh.d.setLinkTextColor(paramaggl);
      localahqh.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaggl);
      localahqh.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaggl);
    }
    for (;;)
    {
      ImmersiveUtils.a(localahqh.c, 0.9F);
      ImmersiveUtils.a(localahqh.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
      ImmersiveUtils.a(localahqh.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
      ImmersiveUtils.a(localahqh.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
      if ((!paramaqkt.jdField_b_of_type_Boolean) || (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localahqh.d.getCurrentTextColor(), 10000.0D * localahqh.jdField_a_of_type_Aqkt.jdField_a_of_type_Double) != 1)) {
        break;
      }
      paramaggl = (ETTextView)localahqh.d;
      float f2 = paramaggl.getTextSize() * 3.0F / 16.0F;
      float f1 = f2;
      if (f2 > 25.0F) {
        f1 = 25.0F;
      }
      paramaggl.setTextColor(-1);
      paramaggl.setShadowLayer(f1, 0.0F, 0.0F, paramaqkt.d);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      localahqh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localahqh.d.setTextColor(paramaqkt.jdField_b_of_type_Int);
      localahqh.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaqkt.jdField_b_of_type_Int);
      localahqh.c.setTextColor(paramaqkt.jdField_b_of_type_Int);
      localahqh.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaqkt.jdField_b_of_type_Int);
      localahqh.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaqkt.jdField_b_of_type_Int);
      localahqh.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaqkt.jdField_b_of_type_Int);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(paramaqkt.jdField_b_of_type_Int, PorterDuff.Mode.SRC_ATOP));
      localahqh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      break label407;
      label749:
      localahqh.d.setLinkTextColor(paramaqkt.jdField_c_of_type_Int);
      localahqh.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaqkt.jdField_c_of_type_Int);
      localahqh.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaqkt.jdField_c_of_type_Int);
    }
  }
  
  public void a(View paramView)
  {
    if (agej.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForReplyText)agej.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689933);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689934);
    } while (!paramView.isSendFromLocal());
    bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ahqd(this, paramView), new ahqe(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView = (ahqh)paramView.getTag();
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (paramView.jdField_a_of_type_AndroidWidgetTextView == null) {
      QLog.e("ReplyTextItemBuilder", 1, "updateBubblePadding error, holder.mNameETTV=null");
    }
    int i;
    do
    {
      return;
      i = agej.a(1.0F, paramView.jdField_a_of_type_AndroidWidgetTextView.getResources());
    } while (localMessageForReplyText.mSourceMsgInfo == null);
    int j = localMessageForReplyText.mSourceMsgInfo.mType;
    j = BaseChatItemLayout.e - agej.a(16.0F, paramView.jdField_a_of_type_AndroidWidgetTextView.getResources());
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
      f = agej.a(37.0F, paramView.jdField_a_of_type_AndroidWidgetTextView.getResources()) + f;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(i - (int)f);
      paramChatMessage = (String)paramView.jdField_a_of_type_AndroidWidgetTextView.getTag(2131378415);
      paramChatMessage = behh.a(paramView.jdField_a_of_type_AndroidWidgetTextView, paramChatMessage, i - (int)f);
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aggl paramaggl, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaggl, paramInt1, paramInt2);
    paramChatMessage = bhmq.a(paramaggl.a.getBackground());
    if (paramChatMessage == null)
    {
      paramInt1 = 0;
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, new Object[] { "color=", Integer.valueOf(paramInt1), " ", Integer.valueOf((paramInt1 & 0xFF0000) >> 16), " ", Integer.valueOf((paramInt1 & 0xFF00) >> 8), " ", Integer.valueOf(paramInt1 & 0xFF) });
      }
      if (((((paramInt1 & 0xFF0000) >> 16) + ((paramInt1 & 0xFF00) >> 8) + (paramInt1 & 0xFF)) / 3 < 170) && (((paramInt1 != 0) && (paramInt1 != -16777216) && (paramInt1 != -15366474)) || ("2920".equals(ThemeUtil.getCurrentThemeId())))) {
        break label254;
      }
      if ((paramaggl instanceof ahqh)) {
        ((ahqh)paramaggl).jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838259));
      }
    }
    label254:
    while (!(paramaggl instanceof ahqh))
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
    ((ahqh)paramaggl).jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838260));
  }
  
  public void b(aggl paramaggl, ChatMessage paramChatMessage)
  {
    int i = 0;
    if (!(paramaggl instanceof ahqh)) {}
    ahqh localahqh;
    do
    {
      do
      {
        do
        {
          return;
          localahqh = (ahqh)paramaggl;
        } while (!(paramChatMessage instanceof MessageForReplyText));
        paramChatMessage = (MessageForReplyText)paramChatMessage;
        paramaggl = null;
        if (!TextUtils.isEmpty(paramChatMessage.sb)) {
          paramaggl = paramChatMessage.sb;
        }
      } while ((paramaggl == null) || (!(paramaggl instanceof begp)));
      paramChatMessage = (begp)paramaggl;
      paramaggl = (begw[])paramChatMessage.getSpans(0, paramaggl.length(), begw.class);
    } while ((paramaggl.length <= 0) || (paramChatMessage.b().length() != 0));
    int j = paramaggl.length;
    while (i < j)
    {
      paramaggl[i].a(bdep.a(26.0F));
      i += 1;
    }
    localahqh.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setText(paramChatMessage);
  }
  
  protected boolean d()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpx
 * JD-Core Version:    0.7.0.1
 */