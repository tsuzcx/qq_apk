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
import org.json.JSONObject;

public class ahgl
  extends ahkf
{
  protected static Drawable a;
  protected afzq a;
  protected ahgw a;
  private View.OnClickListener c;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e1e1e5"));
  }
  
  public ahgl(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Ahgw = new ahgw(null);
    this.jdField_a_of_type_Afzq = new ahgm(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new ahgq(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new baks(this);
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
  
  private static ahgt a(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean)
  {
    int j = bdzx.c(paramBoolean);
    int i = bdzx.d(paramBoolean);
    ahgt localahgt = new ahgt();
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
      localahgt.jdField_a_of_type_Int = paramInt1;
      localahgt.jdField_b_of_type_Int = paramInt2;
      localahgt.jdField_a_of_type_Float = f1;
      localahgt.jdField_b_of_type_Float = paramFloat;
      return localahgt;
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
  
  private static ahgt a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt)
  {
    ahgt localahgt = new ahgt();
    Object localObject3 = null;
    boolean bool = bley.a(paramMessageForPic.imageType);
    URL localURL2;
    Object localObject1;
    if ((paramMessageForPic.imageType == 3) || (paramMessageForPic.imageType == 2000))
    {
      ahdu.f();
      if (ahdu.h)
      {
        localURL2 = bdzx.a(paramMessageForPic, 1, null);
        localObject1 = bdsh.a(localURL2.toString());
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
          localahgt.jdField_a_of_type_Boolean = true;
          localahgt.jdField_a_of_type_AndroidGraphicsRect = localObject3;
          localahgt.jdField_a_of_type_JavaNetURL = ((URL)localObject1);
        }
      }
    }
    for (;;)
    {
      localObject4 = localObject1;
      if (localObject1 == null) {
        localObject1 = bdzx.a(paramMessageForPic, 65537, null);
      }
      try
      {
        localObject4 = new URL(((URL)localObject1).toString());
        localObject1 = localObject4;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        int k;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ReplyTextItemBuilder", 2, "group emo new URL error!");
          }
          localMalformedURLException.printStackTrace();
        }
        paramContext = bdsh.a((String)localObject1);
        if (paramContext == null) {
          break label657;
        }
        if (localObject3 == null) {
          break label539;
        }
        int j = localObject3.width();
        int i = localObject3.height();
        paramContext = a(j, i, f * 12.0F, bool);
        j = paramContext.jdField_a_of_type_Int;
        i = paramContext.jdField_b_of_type_Int;
        float f = paramContext.jdField_b_of_type_Float;
        j = (j * k + 80) / 160;
        i = (i * k + 80) / 160;
        if (localObject3 == null) {
          break label522;
        }
        if (localObject3.width() >= j) {
          break label632;
        }
        f = localObject3.width() / j;
        while (paramArrayOfInt != null)
        {
          for (;;)
          {
            paramArrayOfInt[0] = j;
            paramArrayOfInt[1] = i;
            return localahgt;
            paramMessageForPic = new BitmapFactory.Options();
            paramMessageForPic.inJustDecodeBounds = true;
            try
            {
              bgmo.a(paramContext.getAbsolutePath(), paramMessageForPic);
              j = paramMessageForPic.outWidth;
              i = paramMessageForPic.outHeight;
              int m = bdzx.a(paramContext.getAbsolutePath());
              if ((m != 90) && (m != 270)) {
                break;
              }
              j = paramMessageForPic.outHeight;
              i = paramMessageForPic.outWidth;
            }
            catch (Throwable paramChatThumbView)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("ReplyTextItemBuilder", 2, "getThumbDrawable", paramChatThumbView);
                }
              }
            }
          }
          if (localObject3.height() < i) {
            f = localObject3.height() / i;
          }
        }
        i = paramMessageForPic.thumbWidth;
        j = paramMessageForPic.thumbHeight;
        if ((i <= 0) || (j <= 0)) {
          break label752;
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
          return localahgt;
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
        paramContext = bdzx.a((URL)localObject4, 0, 0, null, null, true, 12.0F * f);
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt[0] = paramContext.getIntrinsicWidth();
          paramArrayOfInt[1] = paramContext.getIntrinsicHeight();
          if (QLog.isColorLevel()) {
            QLog.d("ReplyTextItemBuilder", 2, "getNoRoundThumbDrawableAbsDownloader cache:" + paramArrayOfInt[0] + "," + paramArrayOfInt[1]);
          }
        }
        return localahgt;
      }
      label522:
      label539:
      label632:
      Object localObject2;
      label657:
      label752:
      URL localURL1 = null;
      break;
      localURL1 = null;
      localObject3 = null;
    }
  }
  
  private static ahgu a(MessageForMixedMsg paramMessageForMixedMsg)
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
        return new ahgu((MessageForPic)localObject1, (String)localObject3, i, bool1);
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
      localBitmap1 = bggl.a(BaseApplicationImpl.getContext().getResources(), 2130840846);
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
  
  private View a(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext, ahgv paramahgv, MessageForReplyText paramMessageForReplyText, afzq paramafzq, boolean paramBoolean)
  {
    paramahgv.e = 0;
    Object localObject2 = this.jdField_a_of_type_Ahgw.a(0);
    Object localObject1 = localObject2;
    int j;
    int i;
    if (localObject2 == null)
    {
      localObject1 = new SelectableLinearLayout(paramContext);
      ((LinearLayout)localObject1).setOrientation(1);
      Object localObject3 = a(paramContext);
      paramahgv.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject3);
      paramahgv.c = ((TextView)((ViewGroup)localObject3).findViewById(2131378696));
      paramahgv.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject3).findViewById(2131371539));
      paramahgv.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject3).findViewById(2131367053));
      paramahgv.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject3).findViewById(2131371338));
      paramahgv.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject3).findViewById(2131371355));
      ((ViewGroup)localObject3).setId(2131364407);
      bdol.a(paramahgv.jdField_a_of_type_ComEtrumpMixlayoutETTextView);
      bdol.a(paramahgv.jdField_b_of_type_ComEtrumpMixlayoutETTextView);
      localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
      paramahgv.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)localObject3).findViewById(2131369181));
      paramahgv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      paramahgv.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anni.a(2131712182));
      localObject3 = new ETTextView(paramContext);
      bdol.a((TextView)localObject3);
      ((ETTextView)localObject3).setTextColor(paramContext.getResources().getColorStateList(2131167004));
      ((ETTextView)localObject3).setLinkTextColor(paramContext.getResources().getColorStateList(2131166998));
      ((ETTextView)localObject3).setEditableFactory(bdod.a);
      ((ETTextView)localObject3).setSpannableFactory(bdnt.a);
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
      ((LinearLayout)localObject1).addView(paramahgv.jdField_a_of_type_AndroidViewViewGroup, (ViewGroup.LayoutParams)localObject2);
      ((ETTextView)localObject3).setId(2131364382);
      paramahgv.d = ((TextView)localObject3);
      localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout.LayoutParams)localObject2).topMargin = afur.a(8.0F, paramContext.getResources());
      ((LinearLayout)localObject1).addView(paramahgv.d, (ViewGroup.LayoutParams)localObject2);
    }
    paramahgv.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131371539));
    paramahgv.c = ((TextView)((View)localObject1).findViewById(2131378696));
    paramahgv.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131367053));
    paramahgv.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((View)localObject1).findViewById(2131371338));
    paramahgv.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((View)localObject1).findViewById(2131371355));
    paramahgv.d = ((ETTextView)((View)localObject1).findViewById(2131364382));
    paramahgv.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((View)localObject1).findViewById(2131364407));
    paramahgv.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369181));
    paramahgv.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anni.a(2131712179));
    paramahgv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    paramahgv.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838251));
    if (paramMessageForReplyText.getSourceMsgInfo() != null) {}
    for (paramContext = Long.toString(paramMessageForReplyText.getSourceMsgInfo().mSourceMsgSenderUin);; paramContext = "")
    {
      paramContext = go.a(paramContext);
      paramahgv.c.setTypeface(paramContext);
      paramahgv.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramContext);
      paramahgv.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramContext);
      paramahgv.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramContext);
      paramahgv.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramContext);
      if (!TextUtils.isEmpty(paramMessageForReplyText.getExtInfoFromExtStr("sens_msg_ctrl_info")))
      {
        paramContext = ((ETTextView)paramahgv.d).getETLayout();
        if (paramContext != null) {
          paramContext.a = (paramMessageForReplyText.uniseq + 1L);
        }
      }
      ((ETTextView)paramahgv.d).setFont(0, paramMessageForReplyText.uniseq);
      i = ((ETTextView)paramahgv.d).mMaxWidth;
      j = BaseChatItemLayout.e;
      paramahgv.d.setMaxWidth(j);
      paramahgv.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      if (i != j) {
        ((ETTextView)paramahgv.d).mMsgId = 0L;
      }
      paramahgv.d.setText(paramMessageForReplyText.sb);
      if (AppSetting.c) {
        paramahgv.d.setContentDescription(bdol.e(paramMessageForReplyText.sb.toString()));
      }
      super.a(paramahgv.d, paramMessageForReplyText);
      a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramahgv.jdField_a_of_type_AndroidViewViewGroup, paramMessageForReplyText.mSourceMsgInfo, paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, paramMessageForReplyText, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      paramahgv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)((View)localObject1).findViewById(2131378666));
      paramahgv.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramahgv.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramahgv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject1).setOnTouchListener(paramafzq);
      ((View)localObject1).setOnLongClickListener(paramafzq);
      paramahgv.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramafzq);
      paramahgv.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramafzq);
      paramahgv.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnTouchListener(this.jdField_a_of_type_Afzq);
      paramahgv.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnLongClickListener(this.jdField_a_of_type_Afzq);
      paramahgv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnTouchListener(this.jdField_a_of_type_Afzq);
      paramahgv.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnLongClickListener(this.jdField_a_of_type_Afzq);
      paramahgv.d.setOnTouchListener(paramafzq);
      paramahgv.d.setOnLongClickListener(paramafzq);
      paramahgv.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((paramahgv.d instanceof AnimationTextView)) {
        ((AnimationTextView)paramahgv.d).onDoubleClick = this.jdField_a_of_type_Bhud;
      }
      if ((paramahgv.jdField_a_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
        paramahgv.jdField_a_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Bhud;
      }
      if (paramahgv.jdField_a_of_type_Alqf == null) {
        paramahgv.jdField_a_of_type_Alqf = new alqf();
      }
      if ((localObject1 instanceof alqr))
      {
        paramahgv.jdField_a_of_type_Alqf.a((alqr)localObject1);
        paramahgv.jdField_a_of_type_Alqf.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
      }
      paramahgv.jdField_a_of_type_Alqf.b(paramMessageForReplyText);
      return localObject1;
    }
  }
  
  public static final RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131560651, null);
    Object localObject = (TextView)localRelativeLayout.findViewById(2131371539);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167004));
    ImmersiveUtils.a((View)localObject, 0.9F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(bdod.a);
    ((TextView)localObject).setSpannableFactory(bdnt.a);
    localObject = (TextView)localRelativeLayout.findViewById(2131378696);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167004));
    ImmersiveUtils.a((View)localObject, 0.9F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(bdod.a);
    ((TextView)localObject).setSpannableFactory(bdnt.a);
    localObject = (TextView)localRelativeLayout.findViewById(2131367053);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167004));
    ImmersiveUtils.a((View)localObject, 0.5F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(bdod.a);
    ((TextView)localObject).setSpannableFactory(bdnt.a);
    ((ImageView)localRelativeLayout.findViewById(2131369181)).setColorFilter(null);
    localObject = (ETTextView)localRelativeLayout.findViewById(2131371338);
    ((ETTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167004));
    ((ETTextView)localObject).setLinkTextColor(paramContext.getResources().getColorStateList(2131166998));
    ImmersiveUtils.a((View)localObject, 0.9F);
    ((ETTextView)localObject).setTextSize(1, 13.0F);
    ((ETTextView)localObject).setEditableFactory(bdod.a);
    ((ETTextView)localObject).setSpannableFactory(bdnt.a);
    ((ETTextView)localObject).setLineSpacing(afur.a(2.0F, paramContext.getResources()), 1.0F);
    localObject = (ETTextView)localRelativeLayout.findViewById(2131371355);
    ((ETTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167004));
    ((ETTextView)localObject).setLinkTextColor(paramContext.getResources().getColorStateList(2131166998));
    ((ETTextView)localObject).setTextSize(1, 13.0F);
    ((ETTextView)localObject).setEditableFactory(bdod.a);
    ((ETTextView)localObject).setSpannableFactory(bdnt.a);
    ((ETTextView)localObject).setLineSpacing(afur.a(2.0F, paramContext.getResources()), 1.0F);
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
        paramContext = bdzx.a(paramURL, j, i, new arnj(j, i), bdzx.a(), true, f1);
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
          bgmo.a(paramFile.getAbsolutePath(), paramContext);
          j = paramContext.outWidth;
          i = paramContext.outHeight;
          int m = bdzx.a(paramFile.getAbsolutePath());
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
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt, ahgt paramahgt)
  {
    boolean bool1 = bley.a(paramMessageForPic.imageType);
    boolean bool2 = paramahgt.jdField_a_of_type_Boolean;
    URL localURL = paramahgt.jdField_a_of_type_JavaNetURL;
    Rect localRect = paramahgt.jdField_a_of_type_AndroidGraphicsRect;
    Object localObject = localURL;
    if (localURL == null) {
      paramahgt = bdzx.a(paramMessageForPic, 65537, null);
    }
    try
    {
      localObject = new URL(paramahgt.toString());
      paramahgt = (ahgt)localObject;
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
        paramahgt = bdsh.a(paramahgt);
        if (paramahgt == null) {
          break;
        }
        paramContext = a(paramContext, paramChatThumbView, paramArrayOfInt, localMalformedURLException, localRect, paramahgt, bool1);
      }
      if (bdzx.a(paramContext)) {
        break label506;
      }
    }
    localObject = paramahgt;
    if (QLog.isColorLevel())
    {
      QLog.d("ReplyTextItemBuilder", 2, "getThumbDrawable,using thumb,uniseq:" + paramMessageForPic.uniseq + " url:" + paramahgt);
      localObject = paramahgt;
    }
    paramahgt = ((URL)localObject).toString();
    int j = paramContext.getResources().getDisplayMetrics().densityDpi;
    if (paramChatThumbView != null) {
      paramChatThumbView.jdField_a_of_type_Boolean = false;
    }
    f = j / 160.0F;
    if (BaseApplicationImpl.sImageCache.get(paramahgt) != null)
    {
      paramContext = bdzx.a((URL)localObject, 0, 0, null, null, true, 12.0F * f);
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
    paramChatThumbView.mLoadingDrawable = bdzx.b();
    paramChatThumbView.mFailedDrawable = bdzx.a();
    paramChatThumbView.mPlayGifImage = bool2;
    paramChatThumbView.mGifRoundCorner = 12.0F;
    paramChatThumbView.mImgType = paramMessageForPic.imageType;
    if (paramArrayOfInt != null)
    {
      paramArrayOfInt[0] = paramChatThumbView.mRequestWidth;
      paramArrayOfInt[1] = paramChatThumbView.mRequestHeight;
    }
    paramChatThumbView.mLoadingDrawable = paramContext.getResources().getDrawable(2130843803);
    paramContext = URLDrawable.getDrawable(localMalformedURLException, paramChatThumbView);
    if (QLog.isColorLevel()) {
      QLog.d("ReplyTextItemBuilder", 2, "getNoRoundThumbDrawableautoDownload:" + paramChatThumbView.mRequestWidth + "," + paramChatThumbView.mRequestHeight);
    }
    if ((ayxo.jdField_b_of_type_Boolean) || (i != 0)) {
      paramContext.setAutoDownload(true);
    }
    for (;;)
    {
      paramContext.setProgressDrawable(new bhzg(a(), 0, false));
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
    if (atvo.a(paramMessageRecord)) {
      paramQQAppInterface = atvo.a((ChatMessage)paramMessageRecord);
    }
    return paramQQAppInterface;
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
  
  private static final void a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    BubbleImageView localBubbleImageView = (BubbleImageView)paramViewGroup.findViewById(2131378666);
    int i = paramViewGroup.findViewById(2131371539).getPaddingLeft();
    localBubbleImageView.setRadius(0.0F);
    localBubbleImageView.setAdjustViewBounds(true);
    localBubbleImageView.d(false);
    localBubbleImageView.setShowEdge(true);
    if ((paramMessageRecord2 instanceof MessageForShortVideo)) {
      localBubbleImageView.setContentDescription(anni.a(2131712181));
    }
    Object localObject;
    for (;;)
    {
      localObject = paramViewGroup.findViewById(2131368317);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = bggq.a(paramContext, 25.0F);
      ((View)localObject).setLayoutParams(localLayoutParams);
      i = Build.VERSION.SDK_INT;
      if ((i == 19) || (i == 18)) {
        localBubbleImageView.e = true;
      }
      localObject = (ETTextView)paramViewGroup.findViewById(2131371355);
      paramViewGroup = (ETTextView)paramViewGroup.findViewById(2131371338);
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
      localBubbleImageView.setContentDescription(anni.a(2131712174));
    }
    if ((paramBoolean2) || (a(paramString)) || (paramSourceMsgInfo.mSourceSummaryFlag != 1))
    {
      c(paramContext, paramQQAppInterface, localBubbleImageView, paramMessageRecord1, new ahgn(paramViewGroup, (ETTextView)localObject, paramSourceMsgInfo, localBubbleImageView, paramInt, paramString, paramMessageRecord1, paramContext));
      return;
    }
    localBubbleImageView.setVisibility(8);
    b(paramViewGroup, (TextView)localObject, paramInt, paramString, null);
    a(paramContext, paramQQAppInterface, localBubbleImageView, paramMessageRecord1, paramSourceMsgInfo, (ETTextView)localObject, paramViewGroup, paramInt, paramString);
  }
  
  public static final void a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean, SessionInfo paramSessionInfo)
  {
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForReplyText)) && (QLog.isColorLevel())) {
      QLog.d("SendMsgBtn", 2, "ReplyItemBuilder reply:" + paramMessageRecord + " sourceMsg=" + ((MessageForReplyText)paramMessageRecord).getSourceMessage());
    }
    String str2 = bgsu.a(paramContext, 3, paramSourceMsgInfo.mSourceMsgTime * 1000L).toString();
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(2131371539);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(2131378696);
    boolean bool1;
    Object localObject2;
    Object localObject1;
    label149:
    String str1;
    int i;
    if ((paramBoolean) || (a(paramSourceMsgInfo.mSourceMsgText)))
    {
      bool1 = true;
      localObject2 = paramSourceMsgInfo.mSourceMsgText;
      if (TextUtils.isEmpty(paramSourceMsgInfo.mAnonymousNickName)) {
        break label533;
      }
      localObject1 = paramSourceMsgInfo.mAnonymousNickName;
      str1 = null;
      if (paramSourceMsgInfo.mSourceSummaryFlag != 1) {
        break label729;
      }
      str1 = paramSourceMsgInfo.mSourceMsgText;
      localObject2 = a(paramQQAppInterface, paramString, paramInt, paramMessageRecord, paramSourceMsgInfo);
      if (!(localObject2 instanceof MessageForPic)) {
        break label1597;
      }
      paramString = str1;
      if (anlk.a((MessageRecord)localObject2))
      {
        if (str1 == null) {
          break label718;
        }
        paramInt = str1.indexOf('[');
        if (paramInt < 0) {
          break label718;
        }
        i = str1.indexOf(']');
        if (i <= paramInt) {
          break label718;
        }
        paramString = str1.substring(paramInt, i + 1);
      }
      label247:
      paramBoolean = true;
      paramInt = 0;
    }
    for (;;)
    {
      str1 = paramString;
      paramString = (String)localObject2;
      label276:
      label313:
      Object localObject4;
      Object localObject3;
      long l;
      if ((paramMessageRecord instanceof MessageForReplyText))
      {
        localObject2 = (MessageForReplyText)paramMessageRecord;
        boolean bool2 = MessageForReplyText.needHideLocate((MessageForReplyText)localObject2);
        if (!(paramMessageRecord instanceof MessageForReplyText)) {
          break label1569;
        }
        localObject2 = (MessageForReplyText)paramMessageRecord;
        if (((MessageForReplyText)localObject2).getSourceMessage() == null) {
          break label1569;
        }
        localObject2 = ((MessageForReplyText)localObject2).getSourceMessage();
        localObject4 = (TextView)paramViewGroup.findViewById(2131367053);
        localObject3 = (ImageView)paramViewGroup.findViewById(2131369181);
        if (!a(paramSourceMsgInfo, paramSessionInfo, paramQQAppInterface)) {
          break label1372;
        }
        paramSessionInfo = null;
        paramString = paramSessionInfo;
        if ((paramMessageRecord instanceof MessageForReplyText))
        {
          paramString = paramSessionInfo;
          if (((MessageForReplyText)paramMessageRecord).isBarrageMsg)
          {
            l = ((MessageForReplyText)paramMessageRecord).barrageTimeLocation;
            if (!(localObject2 instanceof MessageForShortVideo)) {
              break label1207;
            }
            paramString = aqgv.a(paramContext, (int)(l / 1000L));
          }
        }
        label408:
        if (paramString == null) {
          break label1356;
        }
        ((TextView)localObject4).setText(paramString);
        ((TextView)localObject4).setVisibility(0);
        label426:
        if (!bool2) {
          break label1366;
        }
        i = 4;
        label434:
        ((ImageView)localObject3).setVisibility(i);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localTextView1.setTag(2131378258, localObject1);
          localTextView1.setTag(2131378259, Long.valueOf(paramSourceMsgInfo.mSourceMsgSenderUin));
          localTextView1.setText((CharSequence)localObject1);
          localTextView2.setText(" " + str2);
        }
        a(paramContext, paramQQAppInterface, paramViewGroup, paramSourceMsgInfo, paramMessageRecord, (MessageRecord)localObject2, paramBoolean, paramInt, str1, bool1);
        return;
        bool1 = false;
        break;
        label533:
        if (paramSourceMsgInfo.mSourceMsgSenderUin == 50000000L)
        {
          localObject1 = a(paramQQAppInterface, paramString, paramInt, paramMessageRecord, paramSourceMsgInfo);
          if (localObject1 != null)
          {
            localObject1 = bfre.a((MessageRecord)localObject1);
            if (localObject1 != null) {
              paramSourceMsgInfo.mAnonymousNickName = ((bfrf)localObject1).c;
            }
          }
          localObject1 = "";
          break label149;
        }
        localObject1 = localTextView1.getTag(2131378259);
        if ((localObject1 == null) || (((Long)localObject1).longValue() != paramSourceMsgInfo.mSourceMsgSenderUin))
        {
          ThreadManager.excute(new ReplyTextItemBuilder.9(paramQQAppInterface, paramInt, paramString, paramSourceMsgInfo, localTextView1, localTextView2, str2), 64, null, true);
          localObject1 = "";
          break label149;
        }
        localTextView1.setText(new bdnf((String)localTextView1.getTag(2131378258), 16).a());
        localTextView2.setText(" " + str2);
        localObject1 = "";
        break label149;
        label718:
        paramString = anni.a(2131712176);
        break label247;
        label729:
        localObject3 = a(paramQQAppInterface, paramString, paramInt, paramMessageRecord, paramSourceMsgInfo);
        if ((localObject3 instanceof MessageForFile))
        {
          if (((MessageForFile)localObject3).fileName == null) {
            break label1576;
          }
          paramString = ((MessageForFile)localObject3).getSummaryMsg();
          paramSourceMsgInfo.mSourceMsgText = paramString;
          paramSourceMsgInfo.mSourceSummaryFlag = 1;
          paramBoolean = false;
          paramInt = 1;
        }
      }
      for (;;)
      {
        str1 = paramString;
        if (paramString == null) {
          str1 = paramSourceMsgInfo.mSourceMsgText;
        }
        paramString = str1;
        if (localObject3 != null)
        {
          paramString = str1;
          if (((MessageRecord)localObject3).shmsgseq == paramMessageRecord.shmsgseq) {
            paramString = (String)localObject2;
          }
        }
        str1 = paramString;
        paramString = (String)localObject3;
        break;
        if ((localObject3 instanceof MessageForTroopFile))
        {
          paramString = str1;
          if (((MessageForTroopFile)localObject3).fileName != null) {
            paramString = ((MessageForTroopFile)localObject3).getSummaryMsg();
          }
          str1 = paramString;
          if (TextUtils.isEmpty(paramString))
          {
            localObject4 = bfsj.a(paramQQAppInterface, (MessageForTroopFile)localObject3);
            str1 = paramString;
            if (localObject4 != null) {
              str1 = ((bety)localObject4).g;
            }
          }
          paramString = str1;
          if (TextUtils.isEmpty(str1))
          {
            str1 = ((MessageRecord)localObject3).getExtInfoFromExtStr("_m_ForwardFileName");
            paramString = str1;
            if (!TextUtils.isEmpty(str1)) {
              paramString = anni.a(2131705352) + str1;
            }
          }
          if (!TextUtils.isEmpty(paramString))
          {
            paramSourceMsgInfo.mSourceMsgText = paramString;
            paramSourceMsgInfo.mSourceSummaryFlag = 1;
            paramBoolean = false;
            paramInt = 1;
          }
        }
        else
        {
          if (((localObject3 instanceof MessageForPic)) && (bool1))
          {
            if ((paramMessageRecord instanceof argw))
            {
              paramString = null;
              paramBoolean = true;
              paramInt = 0;
            }
          }
          else if (localObject3 != null)
          {
            for (;;)
            {
              try
              {
                if (!((ChatMessage)localObject3).mIsParsed) {
                  ((ChatMessage)localObject3).parse();
                }
                if (!(localObject3 instanceof MessageForReplyText)) {
                  continue;
                }
                if (((MessageForReplyText)localObject3).sb != null) {
                  continue;
                }
                QLog.e("ReplyTextItemBuilder", 2, "MessageForReplyText.sb is null");
                if (((MessageRecord)localObject3).msg == null) {
                  continue;
                }
                paramString = ((MessageRecord)localObject3).msg;
              }
              catch (Throwable localThrowable)
              {
                paramString = "";
                QLog.e("ReplyTextItemBuilder", 2, new Object[] { "msg.getSummaryMsg error, msg type=", localObject3.getClass().getName(), localThrowable });
                continue;
              }
              paramSourceMsgInfo.mSourceMsgText = paramString;
              paramSourceMsgInfo.mSourceSummaryFlag = 1;
              paramInt = 1;
              paramBoolean = false;
              break;
              paramString = "";
              continue;
              paramString = ((MessageForReplyText)localObject3).getSummaryMsg();
              continue;
              paramString = ((ChatMessage)localObject3).getSummaryMsg();
            }
            localObject2 = null;
            break label276;
            label1207:
            paramString = paramSessionInfo;
            if (!atvo.a((MessageRecord)localObject2)) {
              break label408;
            }
            Object localObject5 = a(paramQQAppInterface, (MessageRecord)localObject2);
            if ((localObject5 instanceof MessageForFile))
            {
              paramString = paramQQAppInterface.a().a(((MessageRecord)localObject5).uniseq, ((MessageRecord)localObject5).frienduin, ((MessageRecord)localObject5).istroop);
              if ((paramString == null) || (atvo.a(paramString.fileName) != 2)) {
                break label1563;
              }
            }
            label1563:
            for (paramString = aqgv.a(paramContext, (int)(l / 1000L));; paramString = null)
            {
              break;
              paramString = paramSessionInfo;
              if (!(localObject5 instanceof MessageForTroopFile)) {
                break;
              }
              localObject5 = bfsj.a(paramQQAppInterface, (MessageForTroopFile)localObject5);
              paramString = paramSessionInfo;
              if (localObject5 == null) {
                break;
              }
              paramString = paramSessionInfo;
              if (atvo.a(((bety)localObject5).g) != 2) {
                break;
              }
              paramString = aqgv.a(paramContext, (int)(l / 1000L));
              break;
              label1356:
              ((TextView)localObject4).setVisibility(8);
              break label426;
              label1366:
              i = 0;
              break label434;
              label1372:
              paramString = paramContext.getString(2131698212);
              if (!TextUtils.isEmpty(paramSourceMsgInfo.mSourceMsgTroopName))
              {
                localObject5 = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramSourceMsgInfo.mSourceMsgToUin + "");
                paramSessionInfo = paramSourceMsgInfo.mSourceMsgTroopName;
                paramString = paramSessionInfo;
                if (localObject5 != null)
                {
                  paramString = paramSessionInfo;
                  if (!TextUtils.isEmpty(((TroopInfo)localObject5).getTroopName())) {
                    paramString = ((TroopInfo)localObject5).getTroopName();
                  }
                }
                paramString = paramContext.getString(2131698211) + paramString;
              }
              ((TextView)localObject4).setText(paramString);
              ((TextView)localObject4).setVisibility(0);
              paramString = ((FragmentActivity)paramContext).getChatFragment();
              if ((paramString != null) && ((paramString.a() instanceof aicv))) {}
              for (i = 1;; i = 0)
              {
                if (i != 0) {}
                for (i = 4;; i = 0)
                {
                  ((ImageView)localObject3).setVisibility(i);
                  break;
                }
              }
            }
            label1569:
            localObject2 = paramString;
            break label313;
          }
          label1576:
          paramString = null;
          paramBoolean = false;
          paramInt = 1;
          continue;
        }
        paramBoolean = false;
        paramInt = 1;
      }
      label1597:
      paramInt = 1;
      paramBoolean = false;
      paramString = localThrowable;
    }
  }
  
  protected static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, ahgx paramahgx)
  {
    ThreadManager.post(new ReplyTextItemBuilder.3(paramMessageRecord, paramQQAppInterface, paramahgx, paramContext, paramChatThumbView), 8, null, true);
  }
  
  public static final void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if ((paramMessageRecord1 instanceof argw)) {}
    for (Object localObject = (argw)paramMessageRecord1;; localObject = null)
    {
      boolean bool;
      if ((paramMessageRecord2 instanceof MessageForPic))
      {
        paramMessageRecord1 = (MessageForPic)paramMessageRecord2;
        bool = bley.a(paramMessageRecord1.imageType);
        if (!bool)
        {
          paramContext = ahdu.a(paramContext, paramMessageRecord1, paramChatThumbView);
          if (paramContext != null)
          {
            paramQQAppInterface = (RelativeLayout.LayoutParams)paramChatThumbView.getLayoutParams();
            paramQQAppInterface.width = paramContext.getCurrent().getIntrinsicWidth();
            paramQQAppInterface.height = paramContext.getCurrent().getIntrinsicHeight();
            paramChatThumbView.setLayoutParams(paramQQAppInterface);
            paramChatThumbView.setImageDrawable(paramContext.mutate());
          }
          paramChatThumbView.setTag(2131364393, paramMessageRecord1);
        }
      }
      label282:
      label304:
      label327:
      label462:
      label475:
      label484:
      label493:
      label499:
      label506:
      do
      {
        return;
        paramMessageRecord2 = new int[2];
        tmp111_109 = paramMessageRecord2;
        tmp111_109[0] = 0;
        tmp115_111 = tmp111_109;
        tmp115_111[1] = 0;
        tmp115_111;
        paramQQAppInterface = bdzx.a(paramMessageRecord1, 65537);
        try
        {
          paramQQAppInterface = new URL(paramQQAppInterface.toString());
          if (paramQQAppInterface == null)
          {
            paramChatThumbView.setImageDrawable(ahlz.a(2, 200, 200));
            return;
          }
        }
        catch (MalformedURLException paramQQAppInterface)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ReplyTextItemBuilder", 2, "group emo new URL error!");
            }
            paramQQAppInterface.printStackTrace();
            paramQQAppInterface = null;
          }
          paramQQAppInterface = a(paramContext, paramMessageRecord1, paramChatThumbView, paramMessageRecord2);
          paramContext = a(paramContext, paramMessageRecord1, paramChatThumbView, new int[] { 0, 0 }, paramQQAppInterface);
          paramChatThumbView.setTag(2131364393, paramMessageRecord1);
          if (paramMessageRecord2[0] <= 0) {
            break label462;
          }
        }
        int j;
        int n;
        int i1;
        int i2;
        int k;
        int m;
        if (paramMessageRecord2[1] > 0)
        {
          paramQQAppInterface = (RelativeLayout.LayoutParams)paramChatThumbView.getLayoutParams();
          j = bdzx.a(bool);
          n = Math.min(bdzx.b(bool), 80);
          if (paramMessageRecord2[0] <= j) {
            break label475;
          }
          i = j;
          if (paramMessageRecord2[1] <= j) {
            break label484;
          }
          i1 = afur.a(95.0F, paramChatThumbView.getResources());
          if (i <= j) {
            break label493;
          }
          i2 = 0;
          if ((i2 != 0) || (i <= i1)) {
            break label506;
          }
          if (i1 >= n) {
            break label499;
          }
          k = n;
          m = paramMessageRecord2[1] * k / paramMessageRecord2[0];
        }
        do
        {
          do
          {
            paramQQAppInterface.width = k;
            paramQQAppInterface.height = m;
            if (localObject != null)
            {
              if (((argw)localObject).getSourceMsgInfo() != null)
              {
                ((argw)localObject).getSourceMsgInfo().replyPicWidth = k;
                ((argw)localObject).getSourceMsgInfo().replyPicHeight = m;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ReplyTextItemBuilder", 2, "set size :" + paramMessageRecord2[0] + "," + paramMessageRecord2[1] + " real:" + k + "," + m);
              }
            }
            paramChatThumbView.setImageDrawable(paramContext.mutate());
            a(paramContext);
            return;
            i = paramMessageRecord2[0];
            break;
            j = paramMessageRecord2[1];
            break label282;
            i2 = 1;
            break label304;
            k = i1;
            break label327;
            k = i;
            m = j;
          } while (i2 == 0);
          k = i;
          m = j;
        } while (j <= i1);
        if (i1 < n) {}
        for (int i = n;; i = i1)
        {
          k = paramMessageRecord2[0] * i / paramMessageRecord2[1];
          m = i;
          break;
        }
        if (!atvo.a(paramMessageRecord2)) {
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
        paramContext = (MessageForShortVideo)paramMessageRecord2;
        paramMessageRecord2 = ShortVideoUtils.a(paramContext.thumbMD5, "jpg");
        if (!bgmg.b(paramMessageRecord2)) {}
        for (;;)
        {
          try
          {
            paramMessageRecord2 = bcec.a(2, 2);
            localObject = paramContext.getDownloadInfo(paramMessageRecord2.jdField_b_of_type_Int);
            ((bcef)localObject).i = ShortVideoUtils.a(paramContext.thumbMD5, "jpg");
            ((bcef)localObject).a(paramContext.istroop, 1);
            paramMessageRecord2.a((bcef)localObject);
            paramMessageRecord2.a(new ahgo(paramContext, paramMessageRecord1, paramQQAppInterface, paramChatThumbView));
            bcec.a(paramMessageRecord2, paramQQAppInterface);
            paramContext = (ImageView)((ViewGroup)paramChatThumbView.getParent()).findViewById(2131368164);
            if (paramContext == null) {
              break;
            }
            paramContext.setImageResource(2130844345);
            paramContext.setVisibility(0);
            return;
          }
          catch (Exception paramContext)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ReplyTextItemBuilder", 2, "no appRuntime");
            continue;
          }
          b(paramContext.thumbWidth, paramContext.thumbHeight, paramMessageRecord2, paramChatThumbView);
        }
      }
      if ((localObject != null) && (((argw)localObject).getSourceMsgInfo() != null) && (((argw)localObject).getSourceMsgInfo().replyPicWidth != 0))
      {
        paramChatThumbView.setImageDrawable(ahlz.a(2, 200, 200));
        return;
      }
      paramChatThumbView.setVisibility(8);
      return;
    }
  }
  
  protected static void a(Context paramContext, QQAppInterface paramQQAppInterface, BubbleImageView paramBubbleImageView, MessageRecord paramMessageRecord, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, ETTextView paramETTextView1, ETTextView paramETTextView2, int paramInt, String paramString)
  {
    paramSourceMsgInfo = new ahgp(paramSourceMsgInfo, paramBubbleImageView, paramETTextView2, paramETTextView1, paramInt, paramString, paramMessageRecord);
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
    Object localObject = paramChatThumbView.findViewById(2131378663);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramChatThumbView.findViewById(2131365128);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramChatThumbView.findViewById(2131365291);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (ImageView)paramChatThumbView.findViewById(2131368164);
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
    if ((bdzx.b() instanceof SkinnableBitmapDrawable))
    {
      localBitmap = ((SkinnableBitmapDrawable)bdzx.b()).getBitmap();
      paramChatThumbView.setImageDrawable(new arnh(paramContext.getResources(), localBitmap, paramSourceMsgInfo.replyPicWidth, paramSourceMsgInfo.replyPicHeight, -921103));
      return;
    }
    if ((bdzx.b() instanceof BitmapDrawable))
    {
      localBitmap = ((BitmapDrawable)bdzx.b()).getBitmap();
      paramChatThumbView.setImageDrawable(new arnh(paramContext.getResources(), localBitmap, paramSourceMsgInfo.replyPicWidth, paramSourceMsgInfo.replyPicHeight, -921103));
      return;
    }
    paramChatThumbView.setImageDrawable(bdzx.b());
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
    paramInt2 = afur.a(120.0F, ((Context)localObject).getResources());
    int i = afur.a(80.0F, ((Context)localObject).getResources());
    if (paramInt1 <= 0) {
      if (paramBoolean) {
        paramInt1 = afur.a(60.0F, ((Context)localObject).getResources());
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
          paramInt1 = afur.a(120.0F, ((Context)localObject).getResources());
          break;
          paramChatThumbView.setVisibility(8);
          ((ViewGroup)localObject).setVisibility(0);
          paramChatThumbView = (AsyncImageView)((ViewGroup)localObject).findViewById(2131378663);
          if (paramChatThumbView != null) {
            paramChatThumbView.setVisibility(8);
          }
          paramChatThumbView = ((ViewGroup)localObject).findViewById(2131365291);
          if (paramChatThumbView != null)
          {
            ViewGroup.LayoutParams localLayoutParams = paramChatThumbView.getLayoutParams();
            localLayoutParams.width = paramInt1;
            localLayoutParams.height = i;
            paramChatThumbView.setLayoutParams(localLayoutParams);
            paramChatThumbView.setVisibility(0);
            paramChatThumbView.getBackground().setAlpha(26);
          }
          paramChatThumbView = ((ViewGroup)localObject).findViewById(2131365128);
          if (paramChatThumbView != null) {
            paramChatThumbView.setVisibility(8);
          }
          paramChatThumbView = (ImageView)((ViewGroup)localObject).findViewById(2131368164);
        } while (paramChatThumbView == null);
        paramChatThumbView.setVisibility(0);
        if (paramBoolean)
        {
          paramChatThumbView.setImageResource(2130844345);
          return;
        }
        paramChatThumbView.setImageResource(2130844344);
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
        paramString = localViewGroup.findViewById(2131365128);
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
      paramChatThumbView = localViewGroup.findViewById(2131365291);
      if (paramChatThumbView != null) {
        paramChatThumbView.setVisibility(8);
      }
      paramChatThumbView = (ImageView)localViewGroup.findViewById(2131368164);
    } while (paramChatThumbView == null);
    if (paramBoolean)
    {
      paramChatThumbView.setImageResource(2130844345);
      paramChatThumbView.setVisibility(0);
      return;
    }
    paramChatThumbView.setVisibility(8);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, TextView paramTextView, MessageRecord paramMessageRecord, String paramString)
  {
    int i;
    if (atvo.a(paramMessageRecord))
    {
      paramMessageRecord = a(paramQQAppInterface, paramMessageRecord);
      if ((paramMessageRecord instanceof MessageForFile))
      {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "handleReplyTextStyle, sourceMsg uniseq[" + paramMessageRecord.uniseq + "]");
        paramMessageRecord = paramQQAppInterface.a().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if ((paramMessageRecord == null) || (paramMessageRecord.status == 16)) {
          break label750;
        }
        i = atvo.a(atvo.a(paramMessageRecord.fileName), 1);
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
        i = afur.a(15.0F, paramContext.getResources());
        int j = afur.a(4.0F, paramContext.getResources());
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
        paramMessageRecord = bfsj.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord);
        if (paramMessageRecord == null) {
          break label750;
        }
        i = atvo.a(atvo.a(paramMessageRecord.g), 1);
        if (Build.VERSION.SDK_INT >= 21) {}
        for (paramQQAppInterface = paramContext.getDrawable(i);; paramQQAppInterface = paramContext.getResources().getDrawable(i))
        {
          paramTextView.setText(paramMessageRecord.g);
          break;
        }
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          if ((!ambv.a(paramMessageRecord)) || (c(paramMessageRecord))) {
            break label745;
          }
          label336:
          URLDrawable.URLDrawableOptions localURLDrawableOptions;
          if (Build.VERSION.SDK_INT >= 21)
          {
            paramString = paramContext.getDrawable(2130844304);
            paramQQAppInterface = paramString;
            if (((MessageForStructing)paramMessageRecord).structingMsg != null)
            {
              paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg.mMsgUrl;
              paramQQAppInterface = bdjg.f(paramMessageRecord);
              i = afur.a(15.0F, paramContext.getResources());
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
            paramString = paramContext.getResources().getDrawable(2130844304);
            break label336;
            label458:
            paramQQAppInterface = paramString;
            if (!TextUtils.isEmpty(paramMessageRecord))
            {
              paramQQAppInterface = paramString;
              if (paramMessageRecord.contains(bdjg.c))
              {
                paramQQAppInterface = URLDrawable.getDrawable(bdjg.d, localURLDrawableOptions);
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
              if ((paramMessageRecord == null) || (!aqnw.a().a(paramMessageRecord.appName, paramMessageRecord.appView))) {
                break label745;
              }
              if (Build.VERSION.SDK_INT < 21) {
                break label691;
              }
              paramQQAppInterface = paramContext.getDrawable(2130844304);
              paramMessageRecord = aqnw.a().a(new JSONObject(paramMessageRecord.toAppXml())).get("kArkMsgReplyIcon").toString();
              i = afur.a(15.0F, paramContext.getResources());
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
          paramQQAppInterface = paramContext.getResources().getDrawable(2130844304);
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
  
  private static void a(QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord)
  {
    QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg, sourceMsg uniseq[" + paramMessageRecord.uniseq + "]");
    FileManagerEntity localFileManagerEntity = paramQQAppInterface.a().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
    boolean bool;
    if (localFileManagerEntity != null)
    {
      int i = atvo.a(localFileManagerEntity.fileName);
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
      if (!bgmg.b((String)localObject2)) {
        localObject1 = localFileManagerEntity.strLargeThumPath;
      }
      localObject2 = localObject1;
      if (!bgmg.b((String)localObject1))
      {
        if (!bool) {
          break label503;
        }
        if (localFileManagerEntity.peerType != 3000) {
          break label490;
        }
        paramQQAppInterface = paramQQAppInterface.a().b(localFileManagerEntity);
        localObject2 = paramQQAppInterface;
        if (!bgmg.b(paramQQAppInterface))
        {
          if ((localFileManagerEntity.imgWidth <= 0) || (localFileManagerEntity.imgHeight <= 0)) {
            break label540;
          }
          localObject1 = atwg.a(localFileManagerEntity.imgWidth, localFileManagerEntity.imgHeight, "");
          if (QLog.isDebugVersion()) {
            QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle offline file set default. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + ((atwh)localObject1).jdField_a_of_type_Int + "]");
          }
          a(paramChatThumbView, bool, ((atwh)localObject1).jdField_a_of_type_Int, ((atwh)localObject1).jdField_b_of_type_Int);
        }
      }
      for (localObject2 = paramQQAppInterface;; localObject2 = paramQQAppInterface)
      {
        if (!bgmg.b((String)localObject2)) {
          break label552;
        }
        if ((localFileManagerEntity.imgWidth <= 0) || (localFileManagerEntity.imgHeight <= 0)) {
          break label554;
        }
        paramQQAppInterface = atwg.a(localFileManagerEntity.imgWidth, localFileManagerEntity.imgHeight, (String)localObject2);
        if (QLog.isDebugVersion()) {
          QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle offline file set thumb. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + paramQQAppInterface.jdField_a_of_type_Int + "]");
        }
        a(paramChatThumbView, bool, paramQQAppInterface.jdField_a_of_type_Int, paramQQAppInterface.jdField_b_of_type_Int, (String)localObject2);
        return;
        label490:
        paramQQAppInterface = paramQQAppInterface.a().a(localFileManagerEntity);
        break;
        label503:
        if (atwg.b(localFileManagerEntity))
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
      bcst.b(paramQQAppInterface, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
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
              i = aqnw.a(paramMessageRecord.appName, paramMessageRecord.appView);
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
  
  private static boolean a(QQAppInterface paramQQAppInterface, MessageForTroopFile paramMessageForTroopFile)
  {
    boolean bool2 = false;
    paramQQAppInterface = bfsj.a(paramQQAppInterface, paramMessageForTroopFile);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      int i = atvo.a(paramQQAppInterface.g);
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
      int i = atvo.a(paramQQAppInterface.fileName);
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
    if (paramSourceMsgInfo.mSourceMsgToUin <= 0L)
    {
      paramSourceMsgInfo.mSourceMsgToUin = a(paramQQAppInterface, paramSessionInfo, paramSourceMsgInfo.mSourceMsgSenderUin);
      return true;
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 3000) {
      return str1.equals(paramSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      if (str1.equals(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
        return true;
      }
      paramSourceMsgInfo = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
      return (paramSourceMsgInfo != null) && (str1.equals(paramSourceMsgInfo.troopcode));
    }
    if ((str2.equals(paramSessionInfo.jdField_a_of_type_JavaLangString)) && (str1.equals(paramQQAppInterface.getCurrentAccountUin()))) {
      return true;
    }
    return (str1.equals(paramSessionInfo.jdField_a_of_type_JavaLangString)) && (str2.equals(paramQQAppInterface.getCurrentAccountUin()));
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.indexOf(anni.a(2131712178)) == -1) {
      return false;
    }
    return true;
  }
  
  private static MessageRecord b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, StringBuilder paramStringBuilder)
  {
    int k = 0;
    if ((paramMessageRecord1 == null) || (paramMessageRecord2 == null))
    {
      paramQQAppInterface = null;
      return paramQQAppInterface;
    }
    Object localObject;
    MessageRecord localMessageRecord;
    if ((paramMessageRecord2 instanceof MessageForMixedMsg))
    {
      localObject = (MessageForMixedMsg)paramMessageRecord2;
      if (((MessageForMixedMsg)localObject).msgElemList == null) {
        break label412;
      }
      localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject).msgElemList.get(0);
      if ((localMessageRecord instanceof MessageForPic))
      {
        i = 1;
        while (i < ((MessageForMixedMsg)localObject).msgElemList.size())
        {
          localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject).msgElemList.get(i);
          if (((localMessageRecord instanceof MessageForText)) && (!TextUtils.isEmpty(localMessageRecord.msg)))
          {
            paramStringBuilder.append(localMessageRecord.msg);
            i += 1;
          }
          else
          {
            return null;
          }
        }
      }
    }
    label152:
    label412:
    for (int i = 1;; i = 0)
    {
      int m = 1;
      localObject = paramMessageRecord2;
      int j = i;
      i = m;
      for (;;)
      {
        if (i < 10)
        {
          localMessageRecord = paramQQAppInterface.a().c(paramMessageRecord1.frienduin, paramMessageRecord1.istroop, paramMessageRecord2.shmsgseq + i);
          if ((localMessageRecord != null) && (localMessageRecord.isLongMsg()) && ((localMessageRecord instanceof MessageForText))) {
            if (!TextUtils.isEmpty(localMessageRecord.msg)) {
              paramStringBuilder.append(localMessageRecord.msg);
            }
          }
          for (;;)
          {
            if (localMessageRecord != null)
            {
              if (localMessageRecord.isLongMsg()) {
                break label403;
              }
              return localObject;
              if (!(localMessageRecord instanceof MessageForText)) {
                break label412;
              }
              return null;
              if (((paramMessageRecord2 instanceof MessageForText)) && (!TextUtils.isEmpty(paramMessageRecord2.msg))) {
                paramStringBuilder.append(paramMessageRecord2.msg);
              }
              i = 1;
              localObject = null;
              j = 0;
              break label152;
              if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForMixedMsg)) && (localMessageRecord.isLongMsg()))
              {
                paramQQAppInterface = (MessageForMixedMsg)localMessageRecord;
                if (paramQQAppInterface.msgElemList != null)
                {
                  i = k;
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
                paramQQAppInterface = localMessageRecord;
                if (j == 0) {
                  break;
                }
              }
            }
          }
        }
        return localObject;
        i += 1;
      }
    }
  }
  
  private static void b(int paramInt1, int paramInt2, String paramString, ImageView paramImageView)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      paramString = ahhm.a(paramString, 55, 95, afur.a(2.0F, paramImageView.getContext().getResources()));
    }
    while ((paramString == null) || (paramString.getCurrent() == null))
    {
      paramImageView.setVisibility(8);
      return;
      if (paramInt1 > paramInt2)
      {
        paramInt1 = (int)(Float.valueOf(paramInt1).floatValue() / 95);
        paramString = ahhm.a(paramString, 95, (int)(Float.valueOf(paramInt2).floatValue() / paramInt1), afur.a(2.0F, paramImageView.getContext().getResources()));
      }
      else
      {
        paramInt2 = (int)(Float.valueOf(paramInt2).floatValue() / 95);
        paramString = ahhm.a(paramString, (int)(Float.valueOf(paramInt1).floatValue() / paramInt2), 95, afur.a(2.0F, paramImageView.getContext().getResources()));
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
    localLayoutParams.width = paramString.getCurrent().getIntrinsicWidth();
    localLayoutParams.height = paramString.getCurrent().getIntrinsicHeight();
    paramImageView.setLayoutParams(localLayoutParams);
    paramImageView.setImageDrawable(paramString);
  }
  
  protected static void b(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, ahgx paramahgx)
  {
    ThreadManager.post(new ReplyTextItemBuilder.4(paramMessageRecord, paramQQAppInterface, paramahgx, paramContext, paramChatThumbView), 8, null, true);
  }
  
  private static void b(TextView paramTextView1, TextView paramTextView2, int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = bgwv.a(str, paramMessageRecord, ChatTextSizeSettingActivity.b() - 2, 7);
    switch (paramInt)
    {
    default: 
      paramTextView1.setVisibility(0);
      paramTextView1.setText(paramString);
      if (AppSetting.c) {
        paramTextView1.setContentDescription(bdol.e(str));
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
        paramTextView1.setContentDescription(bdol.e(str));
      }
      paramTextView2.setVisibility(8);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText(paramString);
    if (AppSetting.c) {
      paramTextView2.setContentDescription(bdol.e(str));
    }
    paramTextView1.setVisibility(8);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramMessageRecord;
    localMessageForTroopFile.doParse();
    bety localbety = bfsj.a(paramQQAppInterface, localMessageForTroopFile);
    if (localbety == null)
    {
      a(paramChatThumbView, false, 0, 0);
      return;
    }
    int k = atvo.a(localbety.g);
    if ((localbety == null) || (localbety.jdField_b_of_type_Int == 12))
    {
      if (k == 2) {}
      for (bool = true;; bool = false)
      {
        a(paramChatThumbView, bool, 0, 0);
        return;
      }
    }
    if (bgmg.b(localbety.d)) {}
    for (String str = localbety.d; bgmg.b(str); str = localbety.c)
    {
      if (k == 2) {
        bool = true;
      }
      paramQQAppInterface = atwg.a(localMessageForTroopFile.width, localMessageForTroopFile.height, str);
      if (QLog.isDebugVersion()) {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle troop file set thumb. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + paramQQAppInterface.jdField_a_of_type_Int + "]");
      }
      a(paramChatThumbView, bool, paramQQAppInterface.jdField_a_of_type_Int, paramQQAppInterface.jdField_b_of_type_Int, str);
      return;
    }
    paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(localMessageForTroopFile.frienduin));
    int j = 383;
    int i = j;
    if (atwg.b(localMessageForTroopFile.width, localMessageForTroopFile.height))
    {
      i = j;
      if (!atwl.b(localbety.c)) {
        i = 640;
      }
    }
    if (localbety.jdField_b_of_type_Int != 12)
    {
      if (localbety.a != null)
      {
        paramQQAppInterface.a(localbety.a, i);
        paramChatThumbView.setTag(2131364394, new Boolean(true));
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
      paramQQAppInterface = atwg.a(localMessageForTroopFile.width, localMessageForTroopFile.height, "");
      if (QLog.isDebugVersion()) {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle troop file set default. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + paramQQAppInterface.jdField_a_of_type_Int + "]");
      }
      a(paramChatThumbView, bool, paramQQAppInterface.jdField_a_of_type_Int, paramQQAppInterface.jdField_b_of_type_Int);
      return;
      paramQQAppInterface.a(localbety.e, localbety.g, localbety.h, i);
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
      if (anlk.a(paramMessageRecord1))
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
        paramBubbleImageView.setTag(2131364394, null);
        paramSourceMsgInfo = (ViewGroup)paramBubbleImageView.getParent();
        if (paramSourceMsgInfo != null) {
          paramSourceMsgInfo.setVisibility(0);
        }
        paramBubbleImageView.setVisibility(0);
        a(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord2, paramString2);
        label87:
        b(paramETTextView1, paramETTextView2, i, (String)localObject1, paramMessageRecord1);
        a(paramQQAppInterface, paramContext, paramETTextView1, paramMessageRecord1, (String)localObject1);
        paramMessageRecord1 = afur.a(paramETTextView1);
        if ((paramMessageRecord1 != null) && ((paramMessageRecord1 instanceof ahgv))) {
          ((ahgv)paramMessageRecord1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramBubbleImageView;
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
          bool1 = ((ahgu)localObject1).jdField_a_of_type_Boolean;
          i = ((ahgu)localObject1).jdField_a_of_type_Int;
          paramString1 = ((ahgu)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
          localObject1 = ((ahgu)localObject1).jdField_a_of_type_JavaLangString;
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
        if (!atvo.a(paramMessageRecord1)) {
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
  
  protected static void c(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, ahgx paramahgx)
  {
    ThreadManager.post(new ReplyTextItemBuilder.5(paramMessageRecord, paramQQAppInterface, paramahgx, paramContext, paramChatThumbView), 8, null, true);
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
  
  public afwq a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (ahgv)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  public afwr a()
  {
    return new ahgv(this);
  }
  
  public View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (paramView != null)
    {
      localahgv = (ahgv)paramView.getTag();
      if (localahgv != null) {
        this.jdField_a_of_type_Ahgw.a(localahgv.e, paramView);
      }
    }
    ahgv localahgv = (ahgv)paramafwr;
    int i;
    if (localMessageForReplyText.mSourceMsgInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ReplyTextItemBuilder", 2, "text.mSourceMsgInfo为null, text:" + localMessageForReplyText.toString());
      }
      localahgv.e = -1;
      paramafwr = this.jdField_a_of_type_Ahgw.a(-1);
      if (paramafwr != null) {
        break label643;
      }
      paramafwr = new LinearLayout(localContext);
      paramafwr.setOrientation(1);
      paramView = new ETTextView(localContext);
      paramView.setTextColor(localContext.getResources().getColorStateList(2131167004));
      paramView.setLinkTextColor(localContext.getResources().getColorStateList(2131166998));
      paramView.setEditableFactory(bdod.a);
      paramView.setSpannableFactory(bdnt.a);
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
      paramView.setId(2131364382);
      localahgv.d = paramView;
      paramView = new LinearLayout.LayoutParams(-2, -2);
      paramView.topMargin = afur.a(5.0F, localContext.getResources());
      paramafwr.addView(localahgv.d, paramView);
    }
    label643:
    for (;;)
    {
      ((ETTextView)localahgv.d).setFont(0, paramChatMessage.uniseq);
      localahgv.d.setTypeface(go.a(paramChatMessage));
      localahgv.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      localahgv.d.setText(localMessageForReplyText.sb);
      super.a(localahgv.d, paramChatMessage);
      paramafwr.setOnTouchListener(paramafzq);
      paramafwr.setOnLongClickListener(paramafzq);
      localahgv.d.setOnTouchListener(paramafzq);
      localahgv.d.setOnLongClickListener(paramafzq);
      paramView = paramafwr;
      if ((localahgv.d instanceof AnimationTextView))
      {
        ((AnimationTextView)localahgv.d).onDoubleClick = this.jdField_a_of_type_Bhud;
        paramView = paramafwr;
      }
      if (paramView != null)
      {
        paramView.setTag(localahgv);
        paramView.setPadding(0, 0, 0, 0);
        if ((AppSetting.c) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0))
        {
          paramafwr = bdol.e(paramChatMessage.msg);
          if (!paramChatMessage.isSend()) {
            break label604;
          }
          paramView.setContentDescription(anni.a(2131712175) + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + anni.a(2131712180) + paramafwr);
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
        paramView = a(paramBaseChatItemLayout, localContext, localahgv, localMessageForReplyText, paramafzq, bool);
        break;
      }
      label604:
      paramView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + anni.a(2131712177) + paramafwr);
      return paramView;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ahgw.a();
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
    agjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 3);
    Bundle localBundle = new Bundle();
    localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
    Object localObject = (MessageForReplyText)paramChatMessage;
    if (alqc.a().c())
    {
      paramContext = alqc.a().b();
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
        localObject = (bakq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(340);
        MessageRecord localMessageRecord = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage, ((MessageForReplyText)paramChatMessage).mSourceMsgInfo);
        ((MessageForReplyText)paramChatMessage).setSourceMessageRecord(localMessageRecord);
        ((bakq)localObject).a(paramChatMessage);
      }
      for (;;)
      {
        localBundle.putString("forward_text", paramContext);
        localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramContext = new Intent();
        paramContext.putExtras(localBundle);
        aufz.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
        if (!paramChatMessage.isMultiMsg) {
          break;
        }
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 1, 0, "1", "", "", "");
        return;
        paramContext = ((MessageForReplyText)localObject).msg;
        break label103;
        if (paramContext.length() != alqc.a().a()) {
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
  
  public void a(afwr paramafwr, View paramView, ChatMessage paramChatMessage, apwt paramapwt)
  {
    ahgv localahgv = (ahgv)paramafwr;
    paramafwr = (MessageForReplyText)paramChatMessage;
    if (paramafwr.mSourceMsgInfo == null) {
      return;
    }
    Object localObject = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838251);
    localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
    int i = paramafwr.mSourceMsgInfo.mType;
    if ((paramapwt.jdField_a_of_type_Int == 0) || (!paramapwt.a()) || (bcnj.b()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramafwr = paramView.getColorStateList(2131167008);
        localahgv.d.setTextColor(paramafwr);
        localahgv.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramafwr);
        localahgv.c.setTextColor(paramafwr);
        localahgv.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramafwr);
        localahgv.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramafwr);
        localahgv.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramafwr);
        ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(paramafwr.getDefaultColor(), PorterDuff.Mode.SRC_ATOP));
        localahgv.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        if (!paramChatMessage.isSend()) {
          break label294;
        }
      }
      label294:
      for (paramafwr = paramView.getColorStateList(2131167007);; paramafwr = paramView.getColorStateList(2131167006))
      {
        localahgv.d.setLinkTextColor(paramafwr);
        localahgv.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafwr);
        localahgv.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafwr);
        ImmersiveUtils.a(localahgv.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
        ImmersiveUtils.a(localahgv.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
        ImmersiveUtils.a(localahgv.c, 0.9F);
        ImmersiveUtils.a(localahgv.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        ImmersiveUtils.a(localahgv.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        return;
        paramafwr = paramView.getColorStateList(2131167004);
        break;
      }
    }
    if (paramapwt.jdField_b_of_type_Int == 0)
    {
      localahgv.d.setTextColor(-16777216);
      localahgv.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      localahgv.c.setTextColor(-16777216);
      localahgv.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      localahgv.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      localahgv.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP));
      localahgv.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      label407:
      if (paramapwt.jdField_c_of_type_Int != 0) {
        break label749;
      }
      paramafwr = paramView.getResources().getColorStateList(2131167006);
      localahgv.d.setLinkTextColor(paramafwr);
      localahgv.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafwr);
      localahgv.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafwr);
    }
    for (;;)
    {
      ImmersiveUtils.a(localahgv.c, 0.9F);
      ImmersiveUtils.a(localahgv.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
      ImmersiveUtils.a(localahgv.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
      ImmersiveUtils.a(localahgv.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
      if ((!paramapwt.jdField_b_of_type_Boolean) || (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localahgv.d.getCurrentTextColor(), 10000.0D * localahgv.jdField_a_of_type_Apwt.jdField_a_of_type_Double) != 1)) {
        break;
      }
      paramafwr = (ETTextView)localahgv.d;
      float f2 = paramafwr.getTextSize() * 3.0F / 16.0F;
      float f1 = f2;
      if (f2 > 25.0F) {
        f1 = 25.0F;
      }
      paramafwr.setTextColor(-1);
      paramafwr.setShadowLayer(f1, 0.0F, 0.0F, paramapwt.d);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      localahgv.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localahgv.d.setTextColor(paramapwt.jdField_b_of_type_Int);
      localahgv.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramapwt.jdField_b_of_type_Int);
      localahgv.c.setTextColor(paramapwt.jdField_b_of_type_Int);
      localahgv.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramapwt.jdField_b_of_type_Int);
      localahgv.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramapwt.jdField_b_of_type_Int);
      localahgv.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramapwt.jdField_b_of_type_Int);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(paramapwt.jdField_b_of_type_Int, PorterDuff.Mode.SRC_ATOP));
      localahgv.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      break label407;
      label749:
      localahgv.d.setLinkTextColor(paramapwt.jdField_c_of_type_Int);
      localahgv.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramapwt.jdField_c_of_type_Int);
      localahgv.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramapwt.jdField_c_of_type_Int);
    }
  }
  
  public void a(View paramView)
  {
    if (afur.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForReplyText)afur.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689926);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689927);
    } while (!paramView.isSendFromLocal());
    bglp.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ahgr(this, paramView), new ahgs(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView = (ahgv)paramView.getTag();
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (paramView.jdField_a_of_type_AndroidWidgetTextView == null) {
      QLog.e("ReplyTextItemBuilder", 1, "updateBubblePadding error, holder.mNameETTV=null");
    }
    int i;
    do
    {
      return;
      i = afur.a(1.0F, paramView.jdField_a_of_type_AndroidWidgetTextView.getResources());
    } while (localMessageForReplyText.mSourceMsgInfo == null);
    int j = localMessageForReplyText.mSourceMsgInfo.mType;
    j = BaseChatItemLayout.e - afur.a(16.0F, paramView.jdField_a_of_type_AndroidWidgetTextView.getResources());
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
      f = afur.a(37.0F, paramView.jdField_a_of_type_AndroidWidgetTextView.getResources()) + f;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(i - (int)f);
      paramChatMessage = (String)paramView.jdField_a_of_type_AndroidWidgetTextView.getTag(2131378258);
      paramChatMessage = bdol.a(paramView.jdField_a_of_type_AndroidWidgetTextView, paramChatMessage, i - (int)f);
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, afwr paramafwr, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramafwr, paramInt1, paramInt2);
    paramChatMessage = bgmo.a(paramafwr.a.getBackground());
    if (paramChatMessage == null)
    {
      paramInt1 = 0;
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, new Object[] { "color=", Integer.valueOf(paramInt1), " ", Integer.valueOf((paramInt1 & 0xFF0000) >> 16), " ", Integer.valueOf((paramInt1 & 0xFF00) >> 8), " ", Integer.valueOf(paramInt1 & 0xFF) });
      }
      if (((((paramInt1 & 0xFF0000) >> 16) + ((paramInt1 & 0xFF00) >> 8) + (paramInt1 & 0xFF)) / 3 < 170) && (((paramInt1 != 0) && (paramInt1 != -16777216) && (paramInt1 != -15366474)) || ("2920".equals(ThemeUtil.getCurrentThemeId())))) {
        break label254;
      }
      if ((paramafwr instanceof ahgv)) {
        ((ahgv)paramafwr).jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838249));
      }
    }
    label254:
    while (!(paramafwr instanceof ahgv))
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
    ((ahgv)paramafwr).jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838250));
  }
  
  public void b(afwr paramafwr, ChatMessage paramChatMessage)
  {
    int i = 0;
    if (!(paramafwr instanceof ahgv)) {}
    ahgv localahgv;
    do
    {
      do
      {
        do
        {
          return;
          localahgv = (ahgv)paramafwr;
        } while (!(paramChatMessage instanceof MessageForReplyText));
        paramChatMessage = (MessageForReplyText)paramChatMessage;
        paramafwr = null;
        if (!TextUtils.isEmpty(paramChatMessage.sb)) {
          paramafwr = paramChatMessage.sb;
        }
      } while ((paramafwr == null) || (!(paramafwr instanceof bdnt)));
      paramChatMessage = (bdnt)paramafwr;
      paramafwr = (bdoa[])paramChatMessage.getSpans(0, paramafwr.length(), bdoa.class);
    } while ((paramafwr.length <= 0) || (paramChatMessage.b().length() != 0));
    int j = paramafwr.length;
    while (i < j)
    {
      paramafwr[i].a(bclx.a(26.0F));
      i += 1;
    }
    localahgv.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setText(paramChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgl
 * JD-Core Version:    0.7.0.1
 */