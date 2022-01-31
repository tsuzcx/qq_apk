import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
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
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.3;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.4;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.5;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.9;
import com.tencent.mobileqq.activity.selectable.SelectableLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class adni
  extends adra
{
  protected static Drawable a;
  protected acmv a;
  protected adns a;
  private View.OnClickListener c;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e1e1e5"));
  }
  
  public adni(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Adns = new adns(null);
    this.jdField_a_of_type_Acmv = new adnj(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new adnn(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aurl(this);
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
  
  private static adnq a(MessageForMixedMsg paramMessageForMixedMsg)
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
            break label287;
          }
          localObject4 = (MessageForText)paramMessageForMixedMsg.msgElemList.get(m);
          if (((MessageForText)localObject4).sb == null) {
            break label265;
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
                break label393;
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
          break label404;
        }
        localObject1 = (MessageForPic)paramMessageForMixedMsg.msgElemList.get(m);
        MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject1, paramMessageForMixedMsg);
        if (k == 0) {
          break label439;
        }
        localObject3 = localObject4;
        bool1 = bool2;
        label250:
        return new adnq((MessageForPic)localObject1, (String)localObject3, i, bool1);
        label265:
        localObject1 = localObject3;
        if (((MessageForText)localObject4).msg == null) {
          break;
        }
        localObject1 = ((MessageForText)localObject4).msg;
        break;
        label287:
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
        label393:
        k = 1;
        i = 1;
      }
      label404:
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
      break label250;
      label439:
      bool1 = true;
    }
  }
  
  private View a(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext, adnr paramadnr, MessageForReplyText paramMessageForReplyText, acmv paramacmv, boolean paramBoolean)
  {
    paramadnr.e = 0;
    Object localObject2 = this.jdField_a_of_type_Adns.a(0);
    Object localObject1 = localObject2;
    int j;
    int i;
    if (localObject2 == null)
    {
      localObject1 = new SelectableLinearLayout(paramContext);
      ((LinearLayout)localObject1).setOrientation(1);
      Object localObject3 = a(paramContext);
      paramadnr.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject3);
      paramadnr.c = ((TextView)((ViewGroup)localObject3).findViewById(2131311460));
      paramadnr.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject3).findViewById(2131304981));
      paramadnr.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject3).findViewById(2131301046));
      paramadnr.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject3).findViewById(2131304792));
      paramadnr.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject3).findViewById(2131304808));
      ((ViewGroup)localObject3).setId(2131298580);
      localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
      paramadnr.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)localObject3).findViewById(2131302983));
      paramadnr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      paramadnr.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajjy.a(2131647620));
      localObject3 = new ETTextView(paramContext);
      ((ETTextView)localObject3).setTextColor(paramContext.getResources().getColorStateList(2131101278));
      ((ETTextView)localObject3).setLinkTextColor(paramContext.getResources().getColorStateList(2131101272));
      ((ETTextView)localObject3).setEditableFactory(axkn.a);
      ((ETTextView)localObject3).setSpannableFactory(axkd.a);
      ((ETTextView)localObject3).setMovementMethod(LinkMovementMethod.getInstance());
      j = BaseChatItemLayout.n;
      i = BaseChatItemLayout.o;
      if (paramMessageForReplyText.isSend())
      {
        j = BaseChatItemLayout.o;
        i = BaseChatItemLayout.n;
      }
      ((ETTextView)localObject3).setPadding(j, 0, i, BaseChatItemLayout.m);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = j;
      ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
      ((LinearLayout.LayoutParams)localObject2).topMargin = BaseChatItemLayout.g;
      ((LinearLayout)localObject1).addView(paramadnr.jdField_a_of_type_AndroidViewViewGroup, (ViewGroup.LayoutParams)localObject2);
      ((ETTextView)localObject3).setId(2131298555);
      paramadnr.d = ((TextView)localObject3);
      localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout.LayoutParams)localObject2).topMargin = aciy.a(8.0F, paramContext.getResources());
      ((LinearLayout)localObject1).addView(paramadnr.d, (ViewGroup.LayoutParams)localObject2);
    }
    paramadnr.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131304981));
    paramadnr.c = ((TextView)((View)localObject1).findViewById(2131311460));
    paramadnr.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131301046));
    paramadnr.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((View)localObject1).findViewById(2131304792));
    paramadnr.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((View)localObject1).findViewById(2131304808));
    paramadnr.d = ((ETTextView)((View)localObject1).findViewById(2131298555));
    paramadnr.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((View)localObject1).findViewById(2131298580));
    paramadnr.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131302983));
    paramadnr.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajjy.a(2131647617));
    paramadnr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    paramadnr.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838085));
    if (paramMessageForReplyText.getSourceMsgInfo() != null) {}
    for (paramContext = Long.toString(paramMessageForReplyText.getSourceMsgInfo().mSourceMsgSenderUin);; paramContext = "")
    {
      paramContext = gh.a(paramContext);
      paramadnr.c.setTypeface(paramContext);
      paramadnr.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramContext);
      paramadnr.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramContext);
      paramadnr.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramContext);
      paramadnr.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramContext);
      if (!TextUtils.isEmpty(paramMessageForReplyText.getExtInfoFromExtStr("sens_msg_ctrl_info")))
      {
        paramContext = ((ETTextView)paramadnr.d).a();
        if (paramContext != null) {
          paramContext.jdField_a_of_type_Long = (paramMessageForReplyText.uniseq + 1L);
        }
      }
      ((ETTextView)paramadnr.d).setFont(0, paramMessageForReplyText.uniseq);
      i = ((ETTextView)paramadnr.d).jdField_a_of_type_Int;
      j = BaseChatItemLayout.d;
      paramadnr.d.setMaxWidth(j);
      paramadnr.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      if (i != j) {
        ((ETTextView)paramadnr.d).jdField_a_of_type_Long = 0L;
      }
      paramadnr.d.setText(paramMessageForReplyText.sb);
      if (AppSetting.c) {
        paramadnr.d.setContentDescription(axku.e(paramMessageForReplyText.sb.toString()));
      }
      super.a(paramadnr.d, paramMessageForReplyText);
      a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramadnr.jdField_a_of_type_AndroidViewViewGroup, paramMessageForReplyText.mSourceMsgInfo, paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, paramMessageForReplyText, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      paramadnr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)((View)localObject1).findViewById(2131311433));
      paramadnr.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramadnr.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramadnr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject1).setOnTouchListener(paramacmv);
      ((View)localObject1).setOnLongClickListener(paramacmv);
      paramadnr.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramacmv);
      paramadnr.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramacmv);
      paramadnr.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnTouchListener(this.jdField_a_of_type_Acmv);
      paramadnr.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnLongClickListener(this.jdField_a_of_type_Acmv);
      paramadnr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnTouchListener(this.jdField_a_of_type_Acmv);
      paramadnr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnLongClickListener(this.jdField_a_of_type_Acmv);
      paramadnr.d.setOnTouchListener(paramacmv);
      paramadnr.d.setOnLongClickListener(paramacmv);
      paramadnr.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((paramadnr.d instanceof AnimationTextView)) {
        ((AnimationTextView)paramadnr.d).jdField_a_of_type_Bbgb = this.jdField_a_of_type_Bbgb;
      }
      if ((paramadnr.jdField_a_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
        paramadnr.jdField_a_of_type_ComEtrumpMixlayoutETTextView.jdField_a_of_type_Bbgb = this.jdField_a_of_type_Bbgb;
      }
      if (paramadnr.jdField_a_of_type_Ahpa == null) {
        paramadnr.jdField_a_of_type_Ahpa = new ahpa();
      }
      if ((localObject1 instanceof ahpm))
      {
        paramadnr.jdField_a_of_type_Ahpa.a((ahpm)localObject1);
        paramadnr.jdField_a_of_type_Ahpa.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
      }
      paramadnr.jdField_a_of_type_Ahpa.b(paramMessageForReplyText);
      return localObject1;
    }
  }
  
  public static final RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131494819, null);
    Object localObject = (TextView)localRelativeLayout.findViewById(2131304981);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131101278));
    ImmersiveUtils.a((View)localObject, 0.9F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(axkn.a);
    ((TextView)localObject).setSpannableFactory(axkd.a);
    localObject = (TextView)localRelativeLayout.findViewById(2131311460);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131101278));
    ImmersiveUtils.a((View)localObject, 0.9F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(axkn.a);
    ((TextView)localObject).setSpannableFactory(axkd.a);
    localObject = (TextView)localRelativeLayout.findViewById(2131301046);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131101278));
    ImmersiveUtils.a((View)localObject, 0.5F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(axkn.a);
    ((TextView)localObject).setSpannableFactory(axkd.a);
    ((ImageView)localRelativeLayout.findViewById(2131302983)).setColorFilter(null);
    localObject = (ETTextView)localRelativeLayout.findViewById(2131304792);
    ((ETTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131101278));
    ((ETTextView)localObject).setLinkTextColor(paramContext.getResources().getColorStateList(2131101272));
    ImmersiveUtils.a((View)localObject, 0.9F);
    ((ETTextView)localObject).setTextSize(1, 13.0F);
    ((ETTextView)localObject).setEditableFactory(axkn.a);
    ((ETTextView)localObject).setSpannableFactory(axkd.a);
    ((ETTextView)localObject).setLineSpacing(aciy.a(2.0F, paramContext.getResources()), 1.0F);
    localObject = (ETTextView)localRelativeLayout.findViewById(2131304808);
    ((ETTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131101278));
    ((ETTextView)localObject).setLinkTextColor(paramContext.getResources().getColorStateList(2131101272));
    ((ETTextView)localObject).setTextSize(1, 13.0F);
    ((ETTextView)localObject).setEditableFactory(axkn.a);
    ((ETTextView)localObject).setSpannableFactory(axkd.a);
    ((ETTextView)localObject).setLineSpacing(aciy.a(2.0F, paramContext.getResources()), 1.0F);
    return localRelativeLayout;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = paramMessageRecord;
    if (apck.a(paramMessageRecord)) {
      paramQQAppInterface = apck.a((ChatMessage)paramMessageRecord);
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
    BubbleImageView localBubbleImageView = (BubbleImageView)paramViewGroup.findViewById(2131311433);
    int i = paramViewGroup.findViewById(2131304981).getPaddingLeft();
    localBubbleImageView.setRadius(0.0F);
    localBubbleImageView.setAdjustViewBounds(true);
    localBubbleImageView.d(false);
    localBubbleImageView.setShowEdge(true);
    if ((paramMessageRecord2 instanceof MessageForShortVideo)) {
      localBubbleImageView.setContentDescription(ajjy.a(2131647619));
    }
    Object localObject;
    for (;;)
    {
      localObject = paramViewGroup.findViewById(2131302227);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = azvv.a(paramContext, 25.0F);
      ((View)localObject).setLayoutParams(localLayoutParams);
      i = Build.VERSION.SDK_INT;
      if ((i == 19) || (i == 18)) {
        localBubbleImageView.e = true;
      }
      localObject = (ETTextView)paramViewGroup.findViewById(2131304808);
      paramViewGroup = (ETTextView)paramViewGroup.findViewById(2131304792);
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
      localBubbleImageView.setContentDescription(ajjy.a(2131647612));
    }
    if ((paramBoolean2) || (a(paramString)) || (paramSourceMsgInfo.mSourceSummaryFlag != 1))
    {
      c(paramContext, paramQQAppInterface, localBubbleImageView, paramMessageRecord1, new adnk(paramViewGroup, (ETTextView)localObject, paramSourceMsgInfo, localBubbleImageView, paramInt, paramString, paramMessageRecord1, paramContext));
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
    String str2 = baiu.a(paramContext, 3, paramSourceMsgInfo.mSourceMsgTime * 1000L).toString();
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(2131304981);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(2131311460);
    boolean bool1;
    Object localObject2;
    Object localObject1;
    label147:
    String str1;
    int i;
    if ((paramBoolean) || (a(paramSourceMsgInfo.mSourceMsgText)))
    {
      bool1 = true;
      localObject2 = paramSourceMsgInfo.mSourceMsgText;
      if (TextUtils.isEmpty(paramSourceMsgInfo.mAnonymousNickName)) {
        break label512;
      }
      localObject1 = paramSourceMsgInfo.mAnonymousNickName;
      str1 = null;
      if (paramSourceMsgInfo.mSourceSummaryFlag != 1) {
        break label705;
      }
      str1 = paramSourceMsgInfo.mSourceMsgText;
      localObject2 = a(paramQQAppInterface, paramString, paramInt, paramMessageRecord, paramSourceMsgInfo);
      if (!(localObject2 instanceof MessageForPic)) {
        break label1570;
      }
      paramString = str1;
      if (ajhz.a((MessageRecord)localObject2))
      {
        if (str1 == null) {
          break label694;
        }
        paramInt = str1.indexOf('[');
        if (paramInt < 0) {
          break label694;
        }
        i = str1.indexOf(']');
        if (i <= paramInt) {
          break label694;
        }
        paramString = str1.substring(paramInt, i + 1);
      }
      label245:
      paramBoolean = true;
      paramInt = 0;
    }
    for (;;)
    {
      str1 = paramString;
      paramString = (String)localObject2;
      label274:
      label311:
      Object localObject4;
      Object localObject3;
      long l;
      if ((paramMessageRecord instanceof MessageForReplyText))
      {
        localObject2 = (MessageForReplyText)paramMessageRecord;
        boolean bool2 = MessageForReplyText.needHideLocate((MessageForReplyText)localObject2);
        if (!(paramMessageRecord instanceof MessageForReplyText)) {
          break label1542;
        }
        localObject2 = (MessageForReplyText)paramMessageRecord;
        if (((MessageForReplyText)localObject2).getSourceMessage() == null) {
          break label1542;
        }
        localObject2 = ((MessageForReplyText)localObject2).getSourceMessage();
        localObject4 = (TextView)paramViewGroup.findViewById(2131301046);
        localObject3 = (ImageView)paramViewGroup.findViewById(2131302983);
        if (!a(paramSourceMsgInfo, paramSessionInfo, paramQQAppInterface)) {
          break label1346;
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
              break label1181;
            }
            paramString = alvp.a(paramContext, (int)(l / 1000L));
          }
        }
        label405:
        if (paramString == null) {
          break label1330;
        }
        ((TextView)localObject4).setText(paramString);
        ((TextView)localObject4).setVisibility(0);
        label423:
        if (!bool2) {
          break label1340;
        }
        i = 4;
        label431:
        ((ImageView)localObject3).setVisibility(i);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localTextView1.setTag(localObject1);
          localTextView1.setText((CharSequence)localObject1);
          localTextView2.setText(" " + str2);
        }
        a(paramContext, paramQQAppInterface, paramViewGroup, paramSourceMsgInfo, paramMessageRecord, (MessageRecord)localObject2, paramBoolean, paramInt, str1, bool1);
        return;
        bool1 = false;
        break;
        label512:
        if (paramSourceMsgInfo.mSourceMsgSenderUin == 50000000L)
        {
          localObject1 = a(paramQQAppInterface, paramString, paramInt, paramMessageRecord, paramSourceMsgInfo);
          if (localObject1 != null)
          {
            localObject1 = azhy.a((MessageRecord)localObject1);
            if (localObject1 != null) {
              paramSourceMsgInfo.mAnonymousNickName = ((azhz)localObject1).c;
            }
          }
          localObject1 = "";
          break label147;
        }
        localObject1 = localTextView1.getTag(2131311051);
        if ((localObject1 == null) || (((Long)localObject1).longValue() != paramSourceMsgInfo.mSourceMsgSenderUin))
        {
          ThreadManager.excute(new ReplyTextItemBuilder.9(paramQQAppInterface, paramInt, paramString, paramSourceMsgInfo, localTextView1, localTextView2, str2), 64, null, true);
          localObject1 = "";
          break label147;
        }
        localTextView1.setText(new axjq((String)localTextView1.getTag(2131311050), 16).a());
        localTextView2.setText(" " + str2);
        localObject1 = "";
        break label147;
        label694:
        paramString = ajjy.a(2131647614);
        break label245;
        label705:
        localObject3 = a(paramQQAppInterface, paramString, paramInt, paramMessageRecord, paramSourceMsgInfo);
        if ((localObject3 instanceof MessageForFile))
        {
          if (((MessageForFile)localObject3).fileName == null) {
            break label1549;
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
            localObject4 = azjg.a(paramQQAppInterface, (MessageForTroopFile)localObject3);
            str1 = paramString;
            if (localObject4 != null) {
              str1 = ((ayqd)localObject4).g;
            }
          }
          paramString = str1;
          if (TextUtils.isEmpty(str1))
          {
            str1 = ((MessageRecord)localObject3).getExtInfoFromExtStr("_m_ForwardFileName");
            paramString = str1;
            if (!TextUtils.isEmpty(str1)) {
              paramString = ajjy.a(2131640781) + str1;
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
            if ((paramMessageRecord instanceof amrx))
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
            break label274;
            label1181:
            paramString = paramSessionInfo;
            if (!apck.a((MessageRecord)localObject2)) {
              break label405;
            }
            Object localObject5 = a(paramQQAppInterface, (MessageRecord)localObject2);
            if ((localObject5 instanceof MessageForFile))
            {
              paramString = paramQQAppInterface.a().a(((MessageRecord)localObject5).uniseq, ((MessageRecord)localObject5).frienduin, ((MessageRecord)localObject5).istroop);
              if ((paramString == null) || (apck.a(paramString.fileName) != 2)) {
                break label1536;
              }
            }
            label1536:
            for (paramString = alvp.a(paramContext, (int)(l / 1000L));; paramString = null)
            {
              break;
              paramString = paramSessionInfo;
              if (!(localObject5 instanceof MessageForTroopFile)) {
                break;
              }
              localObject5 = azjg.a(paramQQAppInterface, (MessageForTroopFile)localObject5);
              paramString = paramSessionInfo;
              if (localObject5 == null) {
                break;
              }
              paramString = paramSessionInfo;
              if (apck.a(((ayqd)localObject5).g) != 2) {
                break;
              }
              paramString = alvp.a(paramContext, (int)(l / 1000L));
              break;
              label1330:
              ((TextView)localObject4).setVisibility(8);
              break label423;
              label1340:
              i = 0;
              break label431;
              label1346:
              paramString = paramContext.getString(2131633584);
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
                paramString = paramContext.getString(2131633583) + paramString;
              }
              ((TextView)localObject4).setText(paramString);
              ((TextView)localObject4).setVisibility(0);
              paramString = ((FragmentActivity)paramContext).getChatFragment();
              if ((paramString != null) && ((paramString.a() instanceof aege))) {}
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
            label1542:
            localObject2 = paramString;
            break label311;
          }
          label1549:
          paramString = null;
          paramBoolean = false;
          paramInt = 1;
          continue;
        }
        paramBoolean = false;
        paramInt = 1;
      }
      label1570:
      paramInt = 1;
      paramBoolean = false;
      paramString = localThrowable;
    }
  }
  
  protected static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, adnt paramadnt)
  {
    ThreadManager.post(new ReplyTextItemBuilder.3(paramMessageRecord, paramQQAppInterface, paramadnt, paramContext, paramChatThumbView), 8, null, true);
  }
  
  public static final void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    Object localObject = null;
    if ((paramMessageRecord1 instanceof amrx)) {
      localObject = (amrx)paramMessageRecord1;
    }
    if ((paramMessageRecord2 instanceof MessageForPic))
    {
      paramQQAppInterface = (MessageForPic)paramMessageRecord2;
      paramContext = adkt.a(paramContext, paramQQAppInterface, paramChatThumbView);
      if (paramContext != null)
      {
        paramMessageRecord1 = (RelativeLayout.LayoutParams)paramChatThumbView.getLayoutParams();
        paramMessageRecord1.width = paramContext.getCurrent().getIntrinsicWidth();
        paramMessageRecord1.height = paramContext.getCurrent().getIntrinsicHeight();
        paramChatThumbView.setLayoutParams(paramMessageRecord1);
        paramChatThumbView.setImageDrawable(paramContext.mutate());
      }
      paramChatThumbView.setTag(2131298566, paramQQAppInterface);
    }
    boolean bool;
    label1161:
    for (;;)
    {
      return;
      if (!apck.a(paramMessageRecord2)) {
        break label1172;
      }
      paramMessageRecord2 = a(paramQQAppInterface, paramMessageRecord2);
      int i;
      if ((paramMessageRecord2 instanceof MessageForTroopFile))
      {
        paramContext = (MessageForTroopFile)paramMessageRecord2;
        paramContext.doParse();
        paramMessageRecord1 = azjg.a(paramQQAppInterface, paramContext);
        if (paramMessageRecord1 == null)
        {
          a(paramChatThumbView, false, 0, 0);
          return;
        }
        int k = apck.a(paramMessageRecord1.g);
        if ((paramMessageRecord1 == null) || (paramMessageRecord1.jdField_b_of_type_Int == 12))
        {
          if (k == 2) {}
          for (bool = true;; bool = false)
          {
            a(paramChatThumbView, bool, 0, 0);
            return;
          }
        }
        localObject = paramMessageRecord1.d;
        if (bace.b((String)localObject))
        {
          if (k == 2) {}
          for (bool = true; (paramContext.width > 0) && (paramContext.height > 0); bool = false)
          {
            paramContext = apdc.a(paramContext.width, paramContext.height, (String)localObject);
            if (QLog.isDebugVersion()) {
              QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle troop file set thumb. msgSeq[" + paramMessageRecord2.msgseq + "] msgUniseq[" + paramMessageRecord2.uniseq + "] width[" + paramContext.jdField_a_of_type_Int + "]");
            }
            a(paramChatThumbView, bool, paramContext.jdField_a_of_type_Int, paramContext.jdField_b_of_type_Int, (String)localObject);
            return;
          }
          a(paramChatThumbView, bool, 0, 0);
          return;
        }
        paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(paramContext.frienduin));
        int j = 383;
        i = j;
        if (apdc.b(paramContext.width, paramContext.height))
        {
          i = j;
          if (!apdh.b(paramMessageRecord1.c)) {
            i = 640;
          }
        }
        if (paramMessageRecord1.jdField_b_of_type_Int != 12)
        {
          if (paramMessageRecord1.a != null)
          {
            paramQQAppInterface.a(paramMessageRecord1.a, i);
            paramChatThumbView.setTag(2131298567, new Boolean(true));
          }
        }
        else {
          if (k != 2) {
            break label592;
          }
        }
        label592:
        for (bool = true;; bool = false)
        {
          a(paramChatThumbView, bool, 0, 0);
          if ((paramContext.width <= 0) || (paramContext.height <= 0)) {
            break label598;
          }
          paramContext = apdc.a(paramContext.width, paramContext.height, "");
          if (QLog.isDebugVersion()) {
            QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle troop file set default. msgSeq[" + paramMessageRecord2.msgseq + "] msgUniseq[" + paramMessageRecord2.uniseq + "] width[" + paramContext.jdField_a_of_type_Int + "]");
          }
          a(paramChatThumbView, bool, paramContext.jdField_a_of_type_Int, paramContext.jdField_b_of_type_Int);
          return;
          paramQQAppInterface.a(paramMessageRecord1.e, paramMessageRecord1.g, paramMessageRecord1.h, i);
          break;
        }
        label598:
        a(paramChatThumbView, bool, 0, 0);
        return;
      }
      if ((paramMessageRecord2 instanceof MessageForFile))
      {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg, sourceMsg uniseq[" + paramMessageRecord2.uniseq + "]");
        localObject = paramQQAppInterface.a().a(paramMessageRecord2.uniseq, paramMessageRecord2.frienduin, paramMessageRecord2.istroop);
        if (localObject != null)
        {
          i = apck.a(((FileManagerEntity)localObject).fileName);
          if (i == 2) {}
          for (bool = true; (i == 2) || (i == 0); bool = false)
          {
            if (((FileManagerEntity)localObject).status != 16) {
              break label793;
            }
            if (QLog.isDebugVersion()) {
              QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle offline file but is invalid. msgSeq[" + paramMessageRecord2.msgseq + "] msgUniseq[" + paramMessageRecord2.uniseq + "]");
            }
            a(paramChatThumbView, bool, 0, 0);
            return;
          }
          continue;
          label793:
          paramMessageRecord1 = ((FileManagerEntity)localObject).strMiddleThumPath;
          paramContext = paramMessageRecord1;
          if (!bace.b(paramMessageRecord1)) {
            paramContext = ((FileManagerEntity)localObject).strLargeThumPath;
          }
          paramMessageRecord1 = paramContext;
          if (!bace.b(paramContext))
          {
            if (!bool) {
              break label1113;
            }
            if (((FileManagerEntity)localObject).peerType != 3000) {
              break label1100;
            }
            paramContext = paramQQAppInterface.a().b((FileManagerEntity)localObject);
            paramMessageRecord1 = paramContext;
            if (!bace.b(paramContext))
            {
              if ((((FileManagerEntity)localObject).imgWidth <= 0) || (((FileManagerEntity)localObject).imgHeight <= 0)) {
                break label1150;
              }
              paramQQAppInterface = apdc.a(((FileManagerEntity)localObject).imgWidth, ((FileManagerEntity)localObject).imgHeight, "");
              if (QLog.isDebugVersion()) {
                QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle offline file set default. msgSeq[" + paramMessageRecord2.msgseq + "] msgUniseq[" + paramMessageRecord2.uniseq + "] width[" + paramQQAppInterface.jdField_a_of_type_Int + "]");
              }
              a(paramChatThumbView, bool, paramQQAppInterface.jdField_a_of_type_Int, paramQQAppInterface.jdField_b_of_type_Int);
            }
          }
          for (paramMessageRecord1 = paramContext;; paramMessageRecord1 = paramContext)
          {
            if (!bace.b(paramMessageRecord1)) {
              break label1161;
            }
            if ((((FileManagerEntity)localObject).imgWidth <= 0) || (((FileManagerEntity)localObject).imgHeight <= 0)) {
              break label1163;
            }
            paramContext = apdc.a(((FileManagerEntity)localObject).imgWidth, ((FileManagerEntity)localObject).imgHeight, paramMessageRecord1);
            if (QLog.isDebugVersion()) {
              QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle offline file set thumb. msgSeq[" + paramMessageRecord2.msgseq + "] msgUniseq[" + paramMessageRecord2.uniseq + "] width[" + paramContext.jdField_a_of_type_Int + "]");
            }
            a(paramChatThumbView, bool, paramContext.jdField_a_of_type_Int, paramContext.jdField_b_of_type_Int, paramMessageRecord1);
            return;
            label1100:
            paramContext = paramQQAppInterface.a().a((FileManagerEntity)localObject);
            break;
            label1113:
            if (apdc.b((FileManagerEntity)localObject))
            {
              paramContext = paramQQAppInterface.a().a((FileManagerEntity)localObject, 7);
              break;
            }
            paramContext = paramQQAppInterface.a().a((FileManagerEntity)localObject, 5);
            break;
            label1150:
            a(paramChatThumbView, bool, 0, 0);
          }
        }
      }
    }
    label1163:
    a(paramChatThumbView, bool, 0, 0);
    return;
    label1172:
    if ((paramMessageRecord2 instanceof MessageForShortVideo))
    {
      paramContext = (MessageForShortVideo)paramMessageRecord2;
      paramMessageRecord2 = ShortVideoUtils.a(paramContext.thumbMD5, "jpg");
      if (!bace.b(paramMessageRecord2)) {}
      for (;;)
      {
        try
        {
          paramMessageRecord2 = aweg.a(2, 2);
          localObject = paramContext.getDownloadInfo(paramMessageRecord2.jdField_b_of_type_Int);
          ((awej)localObject).i = ShortVideoUtils.a(paramContext.thumbMD5, "jpg");
          ((awej)localObject).a(paramContext.istroop, 1);
          paramMessageRecord2.a((awej)localObject);
          paramMessageRecord2.a(new adnl(paramContext, paramMessageRecord1, paramQQAppInterface, paramChatThumbView));
          aweg.a(paramMessageRecord2, paramQQAppInterface);
          paramContext = (ImageView)((ViewGroup)paramChatThumbView.getParent()).findViewById(2131302082);
          if (paramContext == null) {
            break;
          }
          paramContext.setImageResource(2130843436);
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
    if ((localObject != null) && (((amrx)localObject).getSourceMsgInfo() != null) && (((amrx)localObject).getSourceMsgInfo().replyPicWidth != 0))
    {
      paramChatThumbView.setImageDrawable(adsh.a(2, 200, 200));
      return;
    }
    paramChatThumbView.setVisibility(8);
  }
  
  protected static void a(Context paramContext, QQAppInterface paramQQAppInterface, BubbleImageView paramBubbleImageView, MessageRecord paramMessageRecord, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, ETTextView paramETTextView1, ETTextView paramETTextView2, int paramInt, String paramString)
  {
    paramSourceMsgInfo = new adnm(paramSourceMsgInfo, paramBubbleImageView, paramETTextView2, paramETTextView1, paramInt, paramString, paramMessageRecord);
    if (paramMessageRecord.istroop == 0)
    {
      a(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord, paramSourceMsgInfo);
      return;
    }
    b(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord, paramSourceMsgInfo);
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
    Object localObject = paramChatThumbView.findViewById(2131311430);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramChatThumbView.findViewById(2131299249);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramChatThumbView.findViewById(2131299399);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (ImageView)paramChatThumbView.findViewById(2131302082);
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
    if ((axwd.b() instanceof SkinnableBitmapDrawable))
    {
      localBitmap = ((SkinnableBitmapDrawable)axwd.b()).getBitmap();
      paramChatThumbView.setImageDrawable(new amyk(paramContext.getResources(), localBitmap, paramSourceMsgInfo.replyPicWidth, paramSourceMsgInfo.replyPicHeight, -921103));
      return;
    }
    if ((axwd.b() instanceof BitmapDrawable))
    {
      localBitmap = ((BitmapDrawable)axwd.b()).getBitmap();
      paramChatThumbView.setImageDrawable(new amyk(paramContext.getResources(), localBitmap, paramSourceMsgInfo.replyPicWidth, paramSourceMsgInfo.replyPicHeight, -921103));
      return;
    }
    paramChatThumbView.setImageDrawable(axwd.b());
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
    paramInt2 = aciy.a(120.0F, ((Context)localObject).getResources());
    int i = aciy.a(80.0F, ((Context)localObject).getResources());
    if (paramInt1 <= 0) {
      if (paramBoolean) {
        paramInt1 = aciy.a(60.0F, ((Context)localObject).getResources());
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
          paramInt1 = aciy.a(120.0F, ((Context)localObject).getResources());
          break;
          paramChatThumbView.setVisibility(8);
          ((ViewGroup)localObject).setVisibility(0);
          paramChatThumbView = (AsyncImageView)((ViewGroup)localObject).findViewById(2131311430);
          if (paramChatThumbView != null) {
            paramChatThumbView.setVisibility(8);
          }
          paramChatThumbView = ((ViewGroup)localObject).findViewById(2131299399);
          if (paramChatThumbView != null)
          {
            ViewGroup.LayoutParams localLayoutParams = paramChatThumbView.getLayoutParams();
            localLayoutParams.width = paramInt1;
            localLayoutParams.height = i;
            paramChatThumbView.setLayoutParams(localLayoutParams);
            paramChatThumbView.setVisibility(0);
            paramChatThumbView.getBackground().setAlpha(26);
          }
          paramChatThumbView = ((ViewGroup)localObject).findViewById(2131299249);
          if (paramChatThumbView != null) {
            paramChatThumbView.setVisibility(8);
          }
          paramChatThumbView = (ImageView)((ViewGroup)localObject).findViewById(2131302082);
        } while (paramChatThumbView == null);
        paramChatThumbView.setVisibility(0);
        if (paramBoolean)
        {
          paramChatThumbView.setImageResource(2130843436);
          return;
        }
        paramChatThumbView.setImageResource(2130843435);
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
        paramString = localViewGroup.findViewById(2131299249);
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
      paramChatThumbView = localViewGroup.findViewById(2131299399);
      if (paramChatThumbView != null) {
        paramChatThumbView.setVisibility(8);
      }
      paramChatThumbView = (ImageView)localViewGroup.findViewById(2131302082);
    } while (paramChatThumbView == null);
    if (paramBoolean)
    {
      paramChatThumbView.setImageResource(2130843436);
      paramChatThumbView.setVisibility(0);
      return;
    }
    paramChatThumbView.setVisibility(8);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, TextView paramTextView, MessageRecord paramMessageRecord, String paramString)
  {
    int i;
    if (apck.a(paramMessageRecord))
    {
      paramMessageRecord = a(paramQQAppInterface, paramMessageRecord);
      if ((paramMessageRecord instanceof MessageForFile))
      {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "handleReplyTextStyle, sourceMsg uniseq[" + paramMessageRecord.uniseq + "]");
        paramMessageRecord = paramQQAppInterface.a().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if ((paramMessageRecord == null) || (paramMessageRecord.status == 16)) {
          break label542;
        }
        i = apck.a(apck.a(paramMessageRecord.fileName), 1);
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
        i = aciy.a(15.0F, paramContext.getResources());
        int j = aciy.a(4.0F, paramContext.getResources());
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
          break label542;
        }
        paramMessageRecord = azjg.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord);
        if (paramMessageRecord == null) {
          break label542;
        }
        i = apck.a(apck.a(paramMessageRecord.g), 1);
        if (Build.VERSION.SDK_INT >= 21) {}
        for (paramQQAppInterface = paramContext.getDrawable(i);; paramQQAppInterface = paramContext.getResources().getDrawable(i))
        {
          paramTextView.setText(paramMessageRecord.g);
          break;
        }
        if ((!(paramMessageRecord instanceof MessageForStructing)) || (!ahzm.a(paramMessageRecord)) || (c(paramMessageRecord))) {
          break label537;
        }
        if (Build.VERSION.SDK_INT >= 21) {}
        URLDrawable.URLDrawableOptions localURLDrawableOptions;
        for (paramString = paramContext.getDrawable(2130843397);; paramString = paramContext.getResources().getDrawable(2130843397))
        {
          paramQQAppInterface = paramString;
          if (((MessageForStructing)paramMessageRecord).structingMsg == null) {
            break;
          }
          paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg.mMsgUrl;
          paramQQAppInterface = axfs.f(paramMessageRecord);
          i = aciy.a(15.0F, paramContext.getResources());
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
          break;
        }
        label458:
        paramQQAppInterface = paramString;
        if (TextUtils.isEmpty(paramMessageRecord)) {
          continue;
        }
        paramQQAppInterface = paramString;
        if (!paramMessageRecord.contains(axfs.c)) {
          continue;
        }
        paramQQAppInterface = URLDrawable.getDrawable(axfs.d, localURLDrawableOptions);
        paramQQAppInterface.setBounds(0, 0, i, i);
        continue;
      }
      paramTextView.setCompoundDrawables(null, null, null, null);
      paramTextView.setPadding(0, 0, 0, 0);
      paramTextView.setCompoundDrawablePadding(0);
      paramTextView.setMaxLines(2147483647);
      paramTextView.setEllipsize(null);
      return;
      label537:
      paramQQAppInterface = null;
      continue;
      label542:
      paramQQAppInterface = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    int j = 8;
    if ((paramMessageRecord == null) && (!"0X800A36B".equals(paramString))) {
      return;
    }
    int i;
    if ((paramMessageRecord instanceof MessageForText)) {
      i = 1;
    }
    for (;;)
    {
      awqx.b(paramQQAppInterface, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
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
        i = 8;
      }
    }
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
        if ((paramSessionInfo.jdField_a_of_type_Int != 1) && (paramSessionInfo.jdField_a_of_type_Int != 3000)) {
          break;
        }
      } while (str1.equals(paramSessionInfo.jdField_a_of_type_JavaLangString));
      return false;
    } while (((str2.equals(paramSessionInfo.jdField_a_of_type_JavaLangString)) && (str1.equals(paramQQAppInterface.getCurrentAccountUin()))) || ((str1.equals(paramSessionInfo.jdField_a_of_type_JavaLangString)) && (str2.equals(paramQQAppInterface.getCurrentAccountUin()))));
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.indexOf(ajjy.a(2131647616)) == -1) {
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
      paramString = adoi.a(paramString, 55, 95, aciy.a(2.0F, paramImageView.getContext().getResources()));
    }
    while ((paramString == null) || (paramString.getCurrent() == null))
    {
      paramImageView.setVisibility(8);
      return;
      if (paramInt1 > paramInt2)
      {
        paramInt1 = (int)(Float.valueOf(paramInt1).floatValue() / 95);
        paramString = adoi.a(paramString, 95, (int)(Float.valueOf(paramInt2).floatValue() / paramInt1), aciy.a(2.0F, paramImageView.getContext().getResources()));
      }
      else
      {
        paramInt2 = (int)(Float.valueOf(paramInt2).floatValue() / 95);
        paramString = adoi.a(paramString, (int)(Float.valueOf(paramInt1).floatValue() / paramInt2), 95, aciy.a(2.0F, paramImageView.getContext().getResources()));
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
    localLayoutParams.width = paramString.getCurrent().getIntrinsicWidth();
    localLayoutParams.height = paramString.getCurrent().getIntrinsicHeight();
    paramImageView.setLayoutParams(localLayoutParams);
    paramImageView.setImageDrawable(paramString);
  }
  
  protected static void b(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, adnt paramadnt)
  {
    ThreadManager.post(new ReplyTextItemBuilder.4(paramMessageRecord, paramQQAppInterface, paramadnt, paramContext, paramChatThumbView), 8, null, true);
  }
  
  private static void b(TextView paramTextView1, TextView paramTextView2, int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = bami.a(str, paramMessageRecord, ChatTextSizeSettingActivity.b() - 2, 7);
    switch (paramInt)
    {
    default: 
      paramTextView1.setVisibility(0);
      paramTextView1.setText(paramString);
      if (AppSetting.c) {
        paramTextView1.setContentDescription(axku.e(str));
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
        paramTextView1.setContentDescription(axku.e(str));
      }
      paramTextView2.setVisibility(8);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText(paramString);
    if (AppSetting.c) {
      paramTextView2.setContentDescription(axku.e(str));
    }
    paramTextView1.setVisibility(8);
  }
  
  private static void b(MessageRecord paramMessageRecord1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, BubbleImageView paramBubbleImageView, ETTextView paramETTextView1, ETTextView paramETTextView2, int paramInt, String paramString1, MessageRecord paramMessageRecord2, Context paramContext, QQAppInterface paramQQAppInterface, String paramString2)
  {
    boolean bool2 = false;
    Object localObject3 = null;
    int i;
    Object localObject1;
    boolean bool1;
    if ((paramMessageRecord1 instanceof MessageForPic)) {
      if (ajhz.a(paramMessageRecord1))
      {
        i = 1;
        localObject1 = paramString1;
        bool1 = bool2;
        paramString2 = localObject3;
      }
    }
    for (;;)
    {
      if (bool1)
      {
        paramBubbleImageView.setVisibility(0);
        paramBubbleImageView.setTag(2131298567, null);
        paramSourceMsgInfo = (ViewGroup)paramBubbleImageView.getParent();
        if (paramSourceMsgInfo != null) {
          paramSourceMsgInfo.setVisibility(0);
        }
        paramBubbleImageView.setVisibility(0);
        a(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord2, paramString2);
        label87:
        b(paramETTextView1, paramETTextView2, i, (String)localObject1, paramMessageRecord1);
        a(paramQQAppInterface, paramContext, paramETTextView1, paramMessageRecord1, (String)localObject1);
        paramMessageRecord1 = aciy.a(paramETTextView1);
        if ((paramMessageRecord1 != null) && ((paramMessageRecord1 instanceof adnr))) {
          ((adnr)paramMessageRecord1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramBubbleImageView;
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
          bool1 = ((adnq)localObject1).jdField_a_of_type_Boolean;
          i = ((adnq)localObject1).jdField_a_of_type_Int;
          paramString1 = ((adnq)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
          localObject1 = ((adnq)localObject1).jdField_a_of_type_JavaLangString;
          if (TextUtils.isEmpty(paramString2)) {
            break label809;
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
        paramString2 = localObject3;
        bool1 = bool2;
        i = paramInt;
        localObject1 = paramString1;
        if (paramMessageRecord1.msgtype != -1036) {
          break;
        }
        paramSourceMsgInfo = (MessageForMixedMsg)((MessageForLongMsg)paramMessageRecord1).rebuildLongMsg();
        if (paramSourceMsgInfo == null) {
          break label801;
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
        Object localObject2;
        if ((paramMessageRecord1 instanceof MessageForLongTextMsg))
        {
          paramString2 = (MessageForLongTextMsg)paramMessageRecord1;
          if (paramString2 != null) {}
          for (localObject2 = paramString2.sb;; localObject2 = null)
          {
            paramString2 = localObject3;
            bool1 = bool2;
            i = paramInt;
            localObject1 = paramString1;
            if (localObject2 == null) {
              break;
            }
            paramString2 = localObject3;
            bool1 = bool2;
            i = paramInt;
            localObject1 = paramString1;
            if (paramSourceMsgInfo.mSourceMsgText.equals(((CharSequence)localObject2).toString())) {
              break;
            }
            localObject1 = ((CharSequence)localObject2).toString();
            paramString2 = localObject3;
            bool1 = bool2;
            i = paramInt;
            break;
          }
        }
        paramString2 = localObject3;
        bool1 = bool2;
        i = paramInt;
        localObject1 = paramString1;
        if (!apck.a(paramMessageRecord1)) {
          break;
        }
        paramSourceMsgInfo = a(paramQQAppInterface, paramMessageRecord1);
        if ((paramSourceMsgInfo instanceof MessageForFile))
        {
          localObject2 = paramQQAppInterface.a().a(paramSourceMsgInfo.uniseq, paramSourceMsgInfo.frienduin, paramSourceMsgInfo.istroop);
          paramString2 = localObject3;
          bool1 = bool2;
          i = paramInt;
          localObject1 = paramString1;
          if (localObject2 == null) {
            break;
          }
          if (((FileManagerEntity)localObject2).status != 16)
          {
            j = apck.a(((FileManagerEntity)localObject2).fileName);
            if (j != 2)
            {
              paramString2 = localObject3;
              bool1 = bool2;
              i = paramInt;
              localObject1 = paramString1;
              if (j != 0) {
                break;
              }
            }
            bool1 = true;
            i = 0;
            paramString2 = paramMessageRecord1;
            localObject1 = paramString1;
            break;
          }
          paramString2 = localObject3;
          bool1 = bool2;
          i = paramInt;
          localObject1 = paramString1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("ReplyTextItemBuilder", 2, "renderReply: handle offline file , but invalid. msgUniseq[" + paramSourceMsgInfo.uniseq + "] msgSeq[" + paramSourceMsgInfo.msgseq + "]");
          paramString2 = localObject3;
          bool1 = bool2;
          i = paramInt;
          localObject1 = paramString1;
          break;
        }
        paramString2 = localObject3;
        bool1 = bool2;
        i = paramInt;
        localObject1 = paramString1;
        if (!(paramSourceMsgInfo instanceof MessageForTroopFile)) {
          break;
        }
        paramSourceMsgInfo = azjg.a(paramQQAppInterface, (MessageForTroopFile)paramSourceMsgInfo);
        paramString2 = localObject3;
        bool1 = bool2;
        i = paramInt;
        localObject1 = paramString1;
        if (paramSourceMsgInfo == null) {
          break;
        }
        int j = apck.a(paramSourceMsgInfo.g);
        if (j != 2)
        {
          paramString2 = localObject3;
          bool1 = bool2;
          i = paramInt;
          localObject1 = paramString1;
          if (j != 0) {
            break;
          }
        }
        bool1 = true;
        i = 0;
        paramString2 = paramMessageRecord1;
        localObject1 = paramString1;
        break;
        a(paramBubbleImageView);
        break label87;
        label801:
        paramSourceMsgInfo = null;
        bool1 = false;
      }
      label809:
      paramString2 = (String)localObject1;
    }
  }
  
  protected static boolean b(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForFile)) || ((paramMessageRecord instanceof MessageForLongMsg)) || ((paramMessageRecord instanceof MessageForMixedMsg)) || ((paramMessageRecord instanceof MessageForShortVideo)) || ((paramMessageRecord instanceof MessageForStructing)) || ((paramMessageRecord instanceof MessageForTroopFile)) || ((paramMessageRecord instanceof MessageForVideo));
  }
  
  protected static void c(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, adnt paramadnt)
  {
    ThreadManager.post(new ReplyTextItemBuilder.5(paramMessageRecord, paramQQAppInterface, paramadnt, paramContext, paramChatThumbView), 8, null, true);
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
  
  public acjt a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (adnr)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  public acju a()
  {
    return new adnr(this);
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (paramView != null)
    {
      localadnr = (adnr)paramView.getTag();
      if (localadnr != null) {
        this.jdField_a_of_type_Adns.a(localadnr.e, paramView);
      }
    }
    adnr localadnr = (adnr)paramacju;
    int i;
    if (localMessageForReplyText.mSourceMsgInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ReplyTextItemBuilder", 2, "text.mSourceMsgInfo为null, text:" + localMessageForReplyText.toString());
      }
      localadnr.e = -1;
      paramacju = this.jdField_a_of_type_Adns.a(-1);
      if (paramacju != null) {
        break label643;
      }
      paramacju = new LinearLayout(localContext);
      paramacju.setOrientation(1);
      paramView = new ETTextView(localContext);
      paramView.setTextColor(localContext.getResources().getColorStateList(2131101278));
      paramView.setLinkTextColor(localContext.getResources().getColorStateList(2131101272));
      paramView.setEditableFactory(axkn.a);
      paramView.setSpannableFactory(axkd.a);
      paramView.setMaxWidth(BaseChatItemLayout.d);
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      int j = BaseChatItemLayout.n;
      i = BaseChatItemLayout.o;
      if (paramChatMessage.isSend())
      {
        j = BaseChatItemLayout.o;
        i = BaseChatItemLayout.n;
      }
      paramView.setPadding(j, BaseChatItemLayout.l, i, BaseChatItemLayout.m);
      paramView.setId(2131298555);
      localadnr.d = paramView;
      paramView = new LinearLayout.LayoutParams(-2, -2);
      paramView.topMargin = aciy.a(5.0F, localContext.getResources());
      paramacju.addView(localadnr.d, paramView);
    }
    label643:
    for (;;)
    {
      ((ETTextView)localadnr.d).setFont(0, paramChatMessage.uniseq);
      localadnr.d.setTypeface(gh.a(paramChatMessage));
      localadnr.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      localadnr.d.setText(localMessageForReplyText.sb);
      super.a(localadnr.d, paramChatMessage);
      paramacju.setOnTouchListener(paramacmv);
      paramacju.setOnLongClickListener(paramacmv);
      localadnr.d.setOnTouchListener(paramacmv);
      localadnr.d.setOnLongClickListener(paramacmv);
      paramView = paramacju;
      if ((localadnr.d instanceof AnimationTextView))
      {
        ((AnimationTextView)localadnr.d).jdField_a_of_type_Bbgb = this.jdField_a_of_type_Bbgb;
        paramView = paramacju;
      }
      if (paramView != null)
      {
        paramView.setTag(localadnr);
        paramView.setPadding(0, 0, 0, 0);
        if ((AppSetting.c) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0))
        {
          paramacju = axku.e(paramChatMessage.msg);
          if (!paramChatMessage.isSend()) {
            break label604;
          }
          paramView.setContentDescription(ajjy.a(2131647613) + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + ajjy.a(2131647618) + paramacju);
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
        paramView = a(paramBaseChatItemLayout, localContext, localadnr, localMessageForReplyText, paramacmv, bool);
        break;
      }
      label604:
      paramView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + ajjy.a(2131647615) + paramacju);
      return paramView;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Adns.a();
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
    Bundle localBundle = new Bundle();
    localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
    Object localObject = (MessageForReplyText)paramChatMessage;
    if (ahox.a().c())
    {
      paramContext = ahox.a().a();
      if (paramContext == null) {
        if (((MessageForReplyText)localObject).sb != null)
        {
          paramContext = ((MessageForReplyText)localObject).sb.toString();
          label94:
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      label96:
      if (paramInt != 0)
      {
        localBundle.putInt("forward_type", -6);
        localBundle.putLong("FORWARD_MSG_UNISEQ", paramChatMessage.uniseq);
        localObject = (aurj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(340);
        MessageRecord localMessageRecord = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage, ((MessageForReplyText)paramChatMessage).mSourceMsgInfo);
        ((MessageForReplyText)paramChatMessage).setSourceMessageRecord(localMessageRecord);
        ((aurj)localObject).a(paramChatMessage);
      }
      for (;;)
      {
        localBundle.putString("forward_text", paramContext);
        localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramContext = new Intent();
        paramContext.putExtras(localBundle);
        aphp.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
        if (!paramChatMessage.isMultiMsg) {
          break;
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 1, 0, "1", "", "", "");
        return;
        paramContext = ((MessageForReplyText)localObject).msg;
        break label94;
        if (paramContext.length() != ahox.a().a()) {
          break label370;
        }
        paramInt = 1;
        break label96;
        if (((MessageForReplyText)localObject).sb != null) {}
        for (paramContext = ((MessageForReplyText)localObject).sb.toString();; paramContext = ((MessageForReplyText)localObject).msg)
        {
          paramInt = 1;
          break;
        }
        localBundle.putInt("forward_type", -1);
      }
      label370:
      paramInt = 0;
    }
  }
  
  public void a(acju paramacju, View paramView, ChatMessage paramChatMessage, almt paramalmt)
  {
    adnr localadnr = (adnr)paramacju;
    paramacju = (MessageForReplyText)paramChatMessage;
    if (paramacju.mSourceMsgInfo == null) {
      return;
    }
    Object localObject = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838085);
    localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
    int i = paramacju.mSourceMsgInfo.mType;
    if ((paramalmt.jdField_a_of_type_Int == 0) || (!paramalmt.a()) || (awnu.b()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramacju = paramView.getColorStateList(2131101282);
        localadnr.d.setTextColor(paramacju);
        localadnr.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramacju);
        localadnr.c.setTextColor(paramacju);
        localadnr.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramacju);
        localadnr.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramacju);
        localadnr.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramacju);
        ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(paramacju.getDefaultColor(), PorterDuff.Mode.SRC_ATOP));
        localadnr.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        if (!paramChatMessage.isSend()) {
          break label295;
        }
      }
      label295:
      for (paramacju = paramView.getColorStateList(2131101281);; paramacju = paramView.getColorStateList(2131101280))
      {
        localadnr.d.setLinkTextColor(paramacju);
        localadnr.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacju);
        localadnr.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacju);
        ImmersiveUtils.a(localadnr.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
        ImmersiveUtils.a(localadnr.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
        ImmersiveUtils.a(localadnr.c, 0.9F);
        ImmersiveUtils.a(localadnr.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        ImmersiveUtils.a(localadnr.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        return;
        paramacju = paramView.getColorStateList(2131101278);
        break;
      }
    }
    if (paramalmt.jdField_b_of_type_Int == 0)
    {
      localadnr.d.setTextColor(-16777216);
      localadnr.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      localadnr.c.setTextColor(-16777216);
      localadnr.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      localadnr.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      localadnr.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP));
      localadnr.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      label408:
      if (paramalmt.jdField_c_of_type_Int != 0) {
        break label750;
      }
      paramacju = paramView.getResources().getColorStateList(2131101280);
      localadnr.d.setLinkTextColor(paramacju);
      localadnr.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacju);
      localadnr.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacju);
    }
    for (;;)
    {
      ImmersiveUtils.a(localadnr.c, 0.9F);
      ImmersiveUtils.a(localadnr.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
      ImmersiveUtils.a(localadnr.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
      ImmersiveUtils.a(localadnr.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
      if ((!paramalmt.jdField_b_of_type_Boolean) || (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localadnr.d.getCurrentTextColor(), 10000.0D * localadnr.jdField_a_of_type_Almt.jdField_a_of_type_Double) != 1)) {
        break;
      }
      paramacju = (ETTextView)localadnr.d;
      float f2 = paramacju.getTextSize() * 3.0F / 16.0F;
      float f1 = f2;
      if (f2 > 25.0F) {
        f1 = 25.0F;
      }
      paramacju.setTextColor(-1);
      paramacju.setShadowLayer(f1, 0.0F, 0.0F, paramalmt.d);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      localadnr.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localadnr.d.setTextColor(paramalmt.jdField_b_of_type_Int);
      localadnr.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramalmt.jdField_b_of_type_Int);
      localadnr.c.setTextColor(paramalmt.jdField_b_of_type_Int);
      localadnr.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramalmt.jdField_b_of_type_Int);
      localadnr.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramalmt.jdField_b_of_type_Int);
      localadnr.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramalmt.jdField_b_of_type_Int);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(paramalmt.jdField_b_of_type_Int, PorterDuff.Mode.SRC_ATOP));
      localadnr.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      break label408;
      label750:
      localadnr.d.setLinkTextColor(paramalmt.jdField_c_of_type_Int);
      localadnr.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramalmt.jdField_c_of_type_Int);
      localadnr.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramalmt.jdField_c_of_type_Int);
    }
  }
  
  public void a(View paramView)
  {
    if (aciy.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForReplyText)aciy.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624443);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131624444);
    } while (!paramView.isSendFromLocal());
    babr.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new adno(this, paramView), new adnp(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView = (adnr)paramView.getTag();
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    int i = aciy.a(1.0F, paramView.jdField_a_of_type_AndroidWidgetTextView.getResources());
    if (localMessageForReplyText.mSourceMsgInfo == null) {
      return;
    }
    int j = localMessageForReplyText.mSourceMsgInfo.mType;
    j = BaseChatItemLayout.d - aciy.a(16.0F, paramView.jdField_a_of_type_AndroidWidgetTextView.getResources());
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
      f = aciy.a(37.0F, paramView.jdField_a_of_type_AndroidWidgetTextView.getResources()) + f;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(i - (int)f);
      paramChatMessage = (String)paramView.jdField_a_of_type_AndroidWidgetTextView.getTag(2131311050);
      paramChatMessage = axku.a(paramView.jdField_a_of_type_AndroidWidgetTextView, paramChatMessage, i - (int)f);
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acju paramacju, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacju, paramInt1, paramInt2);
    paramChatMessage = bacm.a(paramacju.a.getBackground());
    if (paramChatMessage == null)
    {
      paramInt1 = 0;
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, new Object[] { "color=", Integer.valueOf(paramInt1), " ", Integer.valueOf((paramInt1 & 0xFF0000) >> 16), " ", Integer.valueOf((paramInt1 & 0xFF00) >> 8), " ", Integer.valueOf(paramInt1 & 0xFF) });
      }
      if (((((paramInt1 & 0xFF0000) >> 16) + ((paramInt1 & 0xFF00) >> 8) + (paramInt1 & 0xFF)) / 3 < 170) && (((paramInt1 != 0) && (paramInt1 != -16777216) && (paramInt1 != -15366474)) || ("2920".equals(ThemeUtil.getCurrentThemeId())))) {
        break label254;
      }
      if ((paramacju instanceof adnr)) {
        ((adnr)paramacju).jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838083));
      }
    }
    label254:
    while (!(paramacju instanceof adnr))
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
    ((adnr)paramacju).jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838084));
  }
  
  public void b(acju paramacju, ChatMessage paramChatMessage)
  {
    int i = 0;
    if (!(paramacju instanceof adnr)) {}
    adnr localadnr;
    do
    {
      do
      {
        do
        {
          return;
          localadnr = (adnr)paramacju;
        } while (!(paramChatMessage instanceof MessageForReplyText));
        paramChatMessage = (MessageForReplyText)paramChatMessage;
        paramacju = null;
        if (!TextUtils.isEmpty(paramChatMessage.sb)) {
          paramacju = paramChatMessage.sb;
        }
      } while ((paramacju == null) || (!(paramacju instanceof axkd)));
      paramChatMessage = (axkd)paramacju;
      paramacju = (axkk[])paramChatMessage.getSpans(0, paramacju.length(), axkk.class);
    } while ((paramacju.length <= 0) || (paramChatMessage.b().length() != 0));
    int j = paramacju.length;
    while (i < j)
    {
      paramacju[i].a(awmc.a(26.0F));
      i += 1;
    }
    localadnr.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setText(paramChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adni
 * JD-Core Version:    0.7.0.1
 */