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
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;

public class adyh
  extends aebz
{
  protected static Drawable a;
  protected acxn a;
  protected adyr a;
  private View.OnClickListener c;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e1e1e5"));
  }
  
  public adyh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Adyr = new adyr(null);
    this.jdField_a_of_type_Acxn = new adyi(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new adym(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new avqu(this);
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
  
  private static adyp a(MessageForMixedMsg paramMessageForMixedMsg)
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
        return new adyp((MessageForPic)localObject1, (String)localObject3, i, bool1);
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
  
  private View a(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext, adyq paramadyq, MessageForReplyText paramMessageForReplyText, acxn paramacxn, boolean paramBoolean)
  {
    paramadyq.e = 0;
    Object localObject2 = this.jdField_a_of_type_Adyr.a(0);
    Object localObject1 = localObject2;
    int j;
    int i;
    if (localObject2 == null)
    {
      localObject1 = new SelectableLinearLayout(paramContext);
      ((LinearLayout)localObject1).setOrientation(1);
      Object localObject3 = a(paramContext);
      paramadyq.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject3);
      paramadyq.c = ((TextView)((ViewGroup)localObject3).findViewById(2131377273));
      paramadyq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject3).findViewById(2131370647));
      paramadyq.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject3).findViewById(2131366657));
      paramadyq.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject3).findViewById(2131370453));
      paramadyq.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject3).findViewById(2131370470));
      ((ViewGroup)localObject3).setId(2131364138);
      localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
      paramadyq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)localObject3).findViewById(2131368617));
      paramadyq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      paramadyq.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajyc.a(2131713408));
      localObject3 = new ETTextView(paramContext);
      ((ETTextView)localObject3).setTextColor(paramContext.getResources().getColorStateList(2131166872));
      ((ETTextView)localObject3).setLinkTextColor(paramContext.getResources().getColorStateList(2131166866));
      ((ETTextView)localObject3).setEditableFactory(ayks.a);
      ((ETTextView)localObject3).setSpannableFactory(ayki.a);
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
      ((LinearLayout)localObject1).addView(paramadyq.jdField_a_of_type_AndroidViewViewGroup, (ViewGroup.LayoutParams)localObject2);
      ((ETTextView)localObject3).setId(2131364113);
      paramadyq.d = ((TextView)localObject3);
      localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout.LayoutParams)localObject2).topMargin = actn.a(8.0F, paramContext.getResources());
      ((LinearLayout)localObject1).addView(paramadyq.d, (ViewGroup.LayoutParams)localObject2);
    }
    paramadyq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131370647));
    paramadyq.c = ((TextView)((View)localObject1).findViewById(2131377273));
    paramadyq.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131366657));
    paramadyq.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((View)localObject1).findViewById(2131370453));
    paramadyq.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((View)localObject1).findViewById(2131370470));
    paramadyq.d = ((ETTextView)((View)localObject1).findViewById(2131364113));
    paramadyq.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((View)localObject1).findViewById(2131364138));
    paramadyq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131368617));
    paramadyq.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajyc.a(2131713405));
    paramadyq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    paramadyq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838092));
    if (paramMessageForReplyText.getSourceMsgInfo() != null) {}
    for (paramContext = Long.toString(paramMessageForReplyText.getSourceMsgInfo().mSourceMsgSenderUin);; paramContext = "")
    {
      paramContext = ia.a(paramContext);
      paramadyq.c.setTypeface(paramContext);
      paramadyq.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramContext);
      paramadyq.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramContext);
      paramadyq.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramContext);
      paramadyq.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramContext);
      if (!TextUtils.isEmpty(paramMessageForReplyText.getExtInfoFromExtStr("sens_msg_ctrl_info")))
      {
        paramContext = ((ETTextView)paramadyq.d).getETLayout();
        if (paramContext != null) {
          paramContext.a = (paramMessageForReplyText.uniseq + 1L);
        }
      }
      ((ETTextView)paramadyq.d).setFont(0, paramMessageForReplyText.uniseq);
      i = ((ETTextView)paramadyq.d).mMaxWidth;
      j = BaseChatItemLayout.d;
      paramadyq.d.setMaxWidth(j);
      paramadyq.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      if (i != j) {
        ((ETTextView)paramadyq.d).mMsgId = 0L;
      }
      paramadyq.d.setText(paramMessageForReplyText.sb);
      if (AppSetting.d) {
        paramadyq.d.setContentDescription(ayla.e(paramMessageForReplyText.sb.toString()));
      }
      super.a(paramadyq.d, paramMessageForReplyText);
      a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramadyq.jdField_a_of_type_AndroidViewViewGroup, paramMessageForReplyText.mSourceMsgInfo, paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, paramMessageForReplyText, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      paramadyq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)((View)localObject1).findViewById(2131377246));
      paramadyq.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramadyq.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramadyq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject1).setOnTouchListener(paramacxn);
      ((View)localObject1).setOnLongClickListener(paramacxn);
      paramadyq.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramacxn);
      paramadyq.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramacxn);
      paramadyq.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnTouchListener(this.jdField_a_of_type_Acxn);
      paramadyq.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnLongClickListener(this.jdField_a_of_type_Acxn);
      paramadyq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnTouchListener(this.jdField_a_of_type_Acxn);
      paramadyq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnLongClickListener(this.jdField_a_of_type_Acxn);
      paramadyq.d.setOnTouchListener(paramacxn);
      paramadyq.d.setOnLongClickListener(paramacxn);
      paramadyq.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((paramadyq.d instanceof AnimationTextView)) {
        ((AnimationTextView)paramadyq.d).onDoubleClick = this.jdField_a_of_type_Bcjb;
      }
      if ((paramadyq.jdField_a_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
        paramadyq.jdField_a_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Bcjb;
      }
      if (paramadyq.jdField_a_of_type_Aibs == null) {
        paramadyq.jdField_a_of_type_Aibs = new aibs();
      }
      if ((localObject1 instanceof aice))
      {
        paramadyq.jdField_a_of_type_Aibs.a((aice)localObject1);
        paramadyq.jdField_a_of_type_Aibs.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
      }
      paramadyq.jdField_a_of_type_Aibs.b(paramMessageForReplyText);
      return localObject1;
    }
  }
  
  public static final RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131560391, null);
    Object localObject = (TextView)localRelativeLayout.findViewById(2131370647);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131166872));
    ImmersiveUtils.a((View)localObject, 0.9F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(ayks.a);
    ((TextView)localObject).setSpannableFactory(ayki.a);
    localObject = (TextView)localRelativeLayout.findViewById(2131377273);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131166872));
    ImmersiveUtils.a((View)localObject, 0.9F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(ayks.a);
    ((TextView)localObject).setSpannableFactory(ayki.a);
    localObject = (TextView)localRelativeLayout.findViewById(2131366657);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131166872));
    ImmersiveUtils.a((View)localObject, 0.5F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(ayks.a);
    ((TextView)localObject).setSpannableFactory(ayki.a);
    ((ImageView)localRelativeLayout.findViewById(2131368617)).setColorFilter(null);
    localObject = (ETTextView)localRelativeLayout.findViewById(2131370453);
    ((ETTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131166872));
    ((ETTextView)localObject).setLinkTextColor(paramContext.getResources().getColorStateList(2131166866));
    ImmersiveUtils.a((View)localObject, 0.9F);
    ((ETTextView)localObject).setTextSize(1, 13.0F);
    ((ETTextView)localObject).setEditableFactory(ayks.a);
    ((ETTextView)localObject).setSpannableFactory(ayki.a);
    ((ETTextView)localObject).setLineSpacing(actn.a(2.0F, paramContext.getResources()), 1.0F);
    localObject = (ETTextView)localRelativeLayout.findViewById(2131370470);
    ((ETTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131166872));
    ((ETTextView)localObject).setLinkTextColor(paramContext.getResources().getColorStateList(2131166866));
    ((ETTextView)localObject).setTextSize(1, 13.0F);
    ((ETTextView)localObject).setEditableFactory(ayks.a);
    ((ETTextView)localObject).setSpannableFactory(ayki.a);
    ((ETTextView)localObject).setLineSpacing(actn.a(2.0F, paramContext.getResources()), 1.0F);
    return localRelativeLayout;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = paramMessageRecord;
    if (apue.a(paramMessageRecord)) {
      paramQQAppInterface = apue.a((ChatMessage)paramMessageRecord);
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
    BubbleImageView localBubbleImageView = (BubbleImageView)paramViewGroup.findViewById(2131377246);
    int i = paramViewGroup.findViewById(2131370647).getPaddingLeft();
    localBubbleImageView.setRadius(0.0F);
    localBubbleImageView.setAdjustViewBounds(true);
    localBubbleImageView.d(false);
    localBubbleImageView.setShowEdge(true);
    if ((paramMessageRecord2 instanceof MessageForShortVideo)) {
      localBubbleImageView.setContentDescription(ajyc.a(2131713407));
    }
    Object localObject;
    for (;;)
    {
      localObject = paramViewGroup.findViewById(2131367846);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = bawz.a(paramContext, 25.0F);
      ((View)localObject).setLayoutParams(localLayoutParams);
      i = Build.VERSION.SDK_INT;
      if ((i == 19) || (i == 18)) {
        localBubbleImageView.e = true;
      }
      localObject = (ETTextView)paramViewGroup.findViewById(2131370470);
      paramViewGroup = (ETTextView)paramViewGroup.findViewById(2131370453);
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
      localBubbleImageView.setContentDescription(ajyc.a(2131713400));
    }
    if ((paramBoolean2) || (a(paramString)) || (paramSourceMsgInfo.mSourceSummaryFlag != 1))
    {
      c(paramContext, paramQQAppInterface, localBubbleImageView, paramMessageRecord1, new adyj(paramViewGroup, (ETTextView)localObject, paramSourceMsgInfo, localBubbleImageView, paramInt, paramString, paramMessageRecord1, paramContext));
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
    String str2 = bbkb.a(paramContext, 3, paramSourceMsgInfo.mSourceMsgTime * 1000L).toString();
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(2131370647);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(2131377273);
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
      if (ajwd.a((MessageRecord)localObject2))
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
        localObject4 = (TextView)paramViewGroup.findViewById(2131366657);
        localObject3 = (ImageView)paramViewGroup.findViewById(2131368617);
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
            paramString = amlf.a(paramContext, (int)(l / 1000L));
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
            localObject1 = bajb.a((MessageRecord)localObject1);
            if (localObject1 != null) {
              paramSourceMsgInfo.mAnonymousNickName = ((bajc)localObject1).c;
            }
          }
          localObject1 = "";
          break label147;
        }
        localObject1 = localTextView1.getTag(2131376860);
        if ((localObject1 == null) || (((Long)localObject1).longValue() != paramSourceMsgInfo.mSourceMsgSenderUin))
        {
          ThreadManager.excute(new ReplyTextItemBuilder.9(paramQQAppInterface, paramInt, paramString, paramSourceMsgInfo, localTextView1, localTextView2, str2), 64, null, true);
          localObject1 = "";
          break label147;
        }
        localTextView1.setText(new ayju((String)localTextView1.getTag(2131376859), 16).a());
        localTextView2.setText(" " + str2);
        localObject1 = "";
        break label147;
        label694:
        paramString = ajyc.a(2131713402);
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
            localObject4 = bakj.a(paramQQAppInterface, (MessageForTroopFile)localObject3);
            str1 = paramString;
            if (localObject4 != null) {
              str1 = ((azqt)localObject4).g;
            }
          }
          paramString = str1;
          if (TextUtils.isEmpty(str1))
          {
            str1 = ((MessageRecord)localObject3).getExtInfoFromExtStr("_m_ForwardFileName");
            paramString = str1;
            if (!TextUtils.isEmpty(str1)) {
              paramString = ajyc.a(2131706566) + str1;
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
            if ((paramMessageRecord instanceof anie))
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
            if (!apue.a((MessageRecord)localObject2)) {
              break label405;
            }
            Object localObject5 = a(paramQQAppInterface, (MessageRecord)localObject2);
            if ((localObject5 instanceof MessageForFile))
            {
              paramString = paramQQAppInterface.a().a(((MessageRecord)localObject5).uniseq, ((MessageRecord)localObject5).frienduin, ((MessageRecord)localObject5).istroop);
              if ((paramString == null) || (apue.a(paramString.fileName) != 2)) {
                break label1536;
              }
            }
            label1536:
            for (paramString = amlf.a(paramContext, (int)(l / 1000L));; paramString = null)
            {
              break;
              paramString = paramSessionInfo;
              if (!(localObject5 instanceof MessageForTroopFile)) {
                break;
              }
              localObject5 = bakj.a(paramQQAppInterface, (MessageForTroopFile)localObject5);
              paramString = paramSessionInfo;
              if (localObject5 == null) {
                break;
              }
              paramString = paramSessionInfo;
              if (apue.a(((azqt)localObject5).g) != 2) {
                break;
              }
              paramString = amlf.a(paramContext, (int)(l / 1000L));
              break;
              label1330:
              ((TextView)localObject4).setVisibility(8);
              break label423;
              label1340:
              i = 0;
              break label431;
              label1346:
              paramString = paramContext.getString(2131699350);
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
                paramString = paramContext.getString(2131699349) + paramString;
              }
              ((TextView)localObject4).setText(paramString);
              ((TextView)localObject4).setVisibility(0);
              paramString = ((FragmentActivity)paramContext).getChatFragment();
              if ((paramString != null) && ((paramString.a() instanceof aerb))) {}
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
  
  protected static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, adys paramadys)
  {
    ThreadManager.post(new ReplyTextItemBuilder.3(paramMessageRecord, paramQQAppInterface, paramadys, paramContext, paramChatThumbView), 8, null, true);
  }
  
  public static final void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    Object localObject = null;
    if ((paramMessageRecord1 instanceof anie)) {
      localObject = (anie)paramMessageRecord1;
    }
    if ((paramMessageRecord2 instanceof MessageForPic))
    {
      paramQQAppInterface = (MessageForPic)paramMessageRecord2;
      paramContext = advu.a(paramContext, paramQQAppInterface, paramChatThumbView);
      if (paramContext != null)
      {
        paramMessageRecord1 = (RelativeLayout.LayoutParams)paramChatThumbView.getLayoutParams();
        paramMessageRecord1.width = paramContext.getCurrent().getIntrinsicWidth();
        paramMessageRecord1.height = paramContext.getCurrent().getIntrinsicHeight();
        paramChatThumbView.setLayoutParams(paramMessageRecord1);
        paramChatThumbView.setImageDrawable(paramContext.mutate());
      }
      paramChatThumbView.setTag(2131364124, paramQQAppInterface);
    }
    boolean bool;
    label1161:
    for (;;)
    {
      return;
      if (!apue.a(paramMessageRecord2)) {
        break label1172;
      }
      paramMessageRecord2 = a(paramQQAppInterface, paramMessageRecord2);
      int i;
      if ((paramMessageRecord2 instanceof MessageForTroopFile))
      {
        paramContext = (MessageForTroopFile)paramMessageRecord2;
        paramContext.doParse();
        paramMessageRecord1 = bakj.a(paramQQAppInterface, paramContext);
        if (paramMessageRecord1 == null)
        {
          a(paramChatThumbView, false, 0, 0);
          return;
        }
        int k = apue.a(paramMessageRecord1.g);
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
        if (bbdj.b((String)localObject))
        {
          if (k == 2) {}
          for (bool = true; (paramContext.width > 0) && (paramContext.height > 0); bool = false)
          {
            paramContext = apuw.a(paramContext.width, paramContext.height, (String)localObject);
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
        if (apuw.b(paramContext.width, paramContext.height))
        {
          i = j;
          if (!apvb.b(paramMessageRecord1.c)) {
            i = 640;
          }
        }
        if (paramMessageRecord1.jdField_b_of_type_Int != 12)
        {
          if (paramMessageRecord1.a != null)
          {
            paramQQAppInterface.a(paramMessageRecord1.a, i);
            paramChatThumbView.setTag(2131364125, new Boolean(true));
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
          paramContext = apuw.a(paramContext.width, paramContext.height, "");
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
          i = apue.a(((FileManagerEntity)localObject).fileName);
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
          if (!bbdj.b(paramMessageRecord1)) {
            paramContext = ((FileManagerEntity)localObject).strLargeThumPath;
          }
          paramMessageRecord1 = paramContext;
          if (!bbdj.b(paramContext))
          {
            if (!bool) {
              break label1113;
            }
            if (((FileManagerEntity)localObject).peerType != 3000) {
              break label1100;
            }
            paramContext = paramQQAppInterface.a().b((FileManagerEntity)localObject);
            paramMessageRecord1 = paramContext;
            if (!bbdj.b(paramContext))
            {
              if ((((FileManagerEntity)localObject).imgWidth <= 0) || (((FileManagerEntity)localObject).imgHeight <= 0)) {
                break label1150;
              }
              paramQQAppInterface = apuw.a(((FileManagerEntity)localObject).imgWidth, ((FileManagerEntity)localObject).imgHeight, "");
              if (QLog.isDebugVersion()) {
                QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle offline file set default. msgSeq[" + paramMessageRecord2.msgseq + "] msgUniseq[" + paramMessageRecord2.uniseq + "] width[" + paramQQAppInterface.jdField_a_of_type_Int + "]");
              }
              a(paramChatThumbView, bool, paramQQAppInterface.jdField_a_of_type_Int, paramQQAppInterface.jdField_b_of_type_Int);
            }
          }
          for (paramMessageRecord1 = paramContext;; paramMessageRecord1 = paramContext)
          {
            if (!bbdj.b(paramMessageRecord1)) {
              break label1161;
            }
            if ((((FileManagerEntity)localObject).imgWidth <= 0) || (((FileManagerEntity)localObject).imgHeight <= 0)) {
              break label1163;
            }
            paramContext = apuw.a(((FileManagerEntity)localObject).imgWidth, ((FileManagerEntity)localObject).imgHeight, paramMessageRecord1);
            if (QLog.isDebugVersion()) {
              QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle offline file set thumb. msgSeq[" + paramMessageRecord2.msgseq + "] msgUniseq[" + paramMessageRecord2.uniseq + "] width[" + paramContext.jdField_a_of_type_Int + "]");
            }
            a(paramChatThumbView, bool, paramContext.jdField_a_of_type_Int, paramContext.jdField_b_of_type_Int, paramMessageRecord1);
            return;
            label1100:
            paramContext = paramQQAppInterface.a().a((FileManagerEntity)localObject);
            break;
            label1113:
            if (apuw.b((FileManagerEntity)localObject))
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
      if (!bbdj.b(paramMessageRecord2)) {}
      for (;;)
      {
        try
        {
          paramMessageRecord2 = axdo.a(2, 2);
          localObject = paramContext.getDownloadInfo(paramMessageRecord2.jdField_b_of_type_Int);
          ((axdr)localObject).i = ShortVideoUtils.a(paramContext.thumbMD5, "jpg");
          ((axdr)localObject).a(paramContext.istroop, 1);
          paramMessageRecord2.a((axdr)localObject);
          paramMessageRecord2.a(new adyk(paramContext, paramMessageRecord1, paramQQAppInterface, paramChatThumbView));
          axdo.a(paramMessageRecord2, paramQQAppInterface);
          paramContext = (ImageView)((ViewGroup)paramChatThumbView.getParent()).findViewById(2131367700);
          if (paramContext == null) {
            break;
          }
          paramContext.setImageResource(2130843520);
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
    if ((localObject != null) && (((anie)localObject).getSourceMsgInfo() != null) && (((anie)localObject).getSourceMsgInfo().replyPicWidth != 0))
    {
      paramChatThumbView.setImageDrawable(aedg.a(2, 200, 200));
      return;
    }
    paramChatThumbView.setVisibility(8);
  }
  
  protected static void a(Context paramContext, QQAppInterface paramQQAppInterface, BubbleImageView paramBubbleImageView, MessageRecord paramMessageRecord, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, ETTextView paramETTextView1, ETTextView paramETTextView2, int paramInt, String paramString)
  {
    paramSourceMsgInfo = new adyl(paramSourceMsgInfo, paramBubbleImageView, paramETTextView2, paramETTextView1, paramInt, paramString, paramMessageRecord);
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
    Object localObject = paramChatThumbView.findViewById(2131377243);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramChatThumbView.findViewById(2131364812);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramChatThumbView.findViewById(2131364968);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (ImageView)paramChatThumbView.findViewById(2131367700);
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
    if ((aywk.b() instanceof SkinnableBitmapDrawable))
    {
      localBitmap = ((SkinnableBitmapDrawable)aywk.b()).getBitmap();
      paramChatThumbView.setImageDrawable(new anos(paramContext.getResources(), localBitmap, paramSourceMsgInfo.replyPicWidth, paramSourceMsgInfo.replyPicHeight, -921103));
      return;
    }
    if ((aywk.b() instanceof BitmapDrawable))
    {
      localBitmap = ((BitmapDrawable)aywk.b()).getBitmap();
      paramChatThumbView.setImageDrawable(new anos(paramContext.getResources(), localBitmap, paramSourceMsgInfo.replyPicWidth, paramSourceMsgInfo.replyPicHeight, -921103));
      return;
    }
    paramChatThumbView.setImageDrawable(aywk.b());
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
    paramInt2 = actn.a(120.0F, ((Context)localObject).getResources());
    int i = actn.a(80.0F, ((Context)localObject).getResources());
    if (paramInt1 <= 0) {
      if (paramBoolean) {
        paramInt1 = actn.a(60.0F, ((Context)localObject).getResources());
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
          paramInt1 = actn.a(120.0F, ((Context)localObject).getResources());
          break;
          paramChatThumbView.setVisibility(8);
          ((ViewGroup)localObject).setVisibility(0);
          paramChatThumbView = (AsyncImageView)((ViewGroup)localObject).findViewById(2131377243);
          if (paramChatThumbView != null) {
            paramChatThumbView.setVisibility(8);
          }
          paramChatThumbView = ((ViewGroup)localObject).findViewById(2131364968);
          if (paramChatThumbView != null)
          {
            ViewGroup.LayoutParams localLayoutParams = paramChatThumbView.getLayoutParams();
            localLayoutParams.width = paramInt1;
            localLayoutParams.height = i;
            paramChatThumbView.setLayoutParams(localLayoutParams);
            paramChatThumbView.setVisibility(0);
            paramChatThumbView.getBackground().setAlpha(26);
          }
          paramChatThumbView = ((ViewGroup)localObject).findViewById(2131364812);
          if (paramChatThumbView != null) {
            paramChatThumbView.setVisibility(8);
          }
          paramChatThumbView = (ImageView)((ViewGroup)localObject).findViewById(2131367700);
        } while (paramChatThumbView == null);
        paramChatThumbView.setVisibility(0);
        if (paramBoolean)
        {
          paramChatThumbView.setImageResource(2130843520);
          return;
        }
        paramChatThumbView.setImageResource(2130843519);
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
        paramString = localViewGroup.findViewById(2131364812);
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
      paramChatThumbView = localViewGroup.findViewById(2131364968);
      if (paramChatThumbView != null) {
        paramChatThumbView.setVisibility(8);
      }
      paramChatThumbView = (ImageView)localViewGroup.findViewById(2131367700);
    } while (paramChatThumbView == null);
    if (paramBoolean)
    {
      paramChatThumbView.setImageResource(2130843520);
      paramChatThumbView.setVisibility(0);
      return;
    }
    paramChatThumbView.setVisibility(8);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, TextView paramTextView, MessageRecord paramMessageRecord, String paramString)
  {
    int i;
    if (apue.a(paramMessageRecord))
    {
      paramMessageRecord = a(paramQQAppInterface, paramMessageRecord);
      if ((paramMessageRecord instanceof MessageForFile))
      {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "handleReplyTextStyle, sourceMsg uniseq[" + paramMessageRecord.uniseq + "]");
        paramMessageRecord = paramQQAppInterface.a().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if ((paramMessageRecord == null) || (paramMessageRecord.status == 16)) {
          break label750;
        }
        i = apue.a(apue.a(paramMessageRecord.fileName), 1);
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
        i = actn.a(15.0F, paramContext.getResources());
        int j = actn.a(4.0F, paramContext.getResources());
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
        paramMessageRecord = bakj.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord);
        if (paramMessageRecord == null) {
          break label750;
        }
        i = apue.a(apue.a(paramMessageRecord.g), 1);
        if (Build.VERSION.SDK_INT >= 21) {}
        for (paramQQAppInterface = paramContext.getDrawable(i);; paramQQAppInterface = paramContext.getResources().getDrawable(i))
        {
          paramTextView.setText(paramMessageRecord.g);
          break;
        }
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          if ((!aimf.a(paramMessageRecord)) || (c(paramMessageRecord))) {
            break label745;
          }
          label336:
          URLDrawable.URLDrawableOptions localURLDrawableOptions;
          if (Build.VERSION.SDK_INT >= 21)
          {
            paramString = paramContext.getDrawable(2130843481);
            paramQQAppInterface = paramString;
            if (((MessageForStructing)paramMessageRecord).structingMsg != null)
            {
              paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg.mMsgUrl;
              paramQQAppInterface = ayfv.f(paramMessageRecord);
              i = actn.a(15.0F, paramContext.getResources());
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
            paramString = paramContext.getResources().getDrawable(2130843481);
            break label336;
            label458:
            paramQQAppInterface = paramString;
            if (!TextUtils.isEmpty(paramMessageRecord))
            {
              paramQQAppInterface = paramString;
              if (paramMessageRecord.contains(ayfv.c))
              {
                paramQQAppInterface = URLDrawable.getDrawable(ayfv.d, localURLDrawableOptions);
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
              if ((paramMessageRecord == null) || (!amrs.a().a(paramMessageRecord.appName, paramMessageRecord.appView))) {
                break label745;
              }
              if (Build.VERSION.SDK_INT < 21) {
                break label691;
              }
              paramQQAppInterface = paramContext.getDrawable(2130843481);
              paramMessageRecord = amrs.a().a(new JSONObject(paramMessageRecord.toAppXml())).get("kArkMsgReplyIcon").toString();
              i = actn.a(15.0F, paramContext.getResources());
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
          paramQQAppInterface = paramContext.getResources().getDrawable(2130843481);
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
      axqw.b(paramQQAppInterface, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
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
              i = amrs.a(paramMessageRecord.appName, paramMessageRecord.appView);
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
    while (paramString.indexOf(ajyc.a(2131713404)) == -1) {
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
      paramString = adzh.a(paramString, 55, 95, actn.a(2.0F, paramImageView.getContext().getResources()));
    }
    while ((paramString == null) || (paramString.getCurrent() == null))
    {
      paramImageView.setVisibility(8);
      return;
      if (paramInt1 > paramInt2)
      {
        paramInt1 = (int)(Float.valueOf(paramInt1).floatValue() / 95);
        paramString = adzh.a(paramString, 95, (int)(Float.valueOf(paramInt2).floatValue() / paramInt1), actn.a(2.0F, paramImageView.getContext().getResources()));
      }
      else
      {
        paramInt2 = (int)(Float.valueOf(paramInt2).floatValue() / 95);
        paramString = adzh.a(paramString, (int)(Float.valueOf(paramInt1).floatValue() / paramInt2), 95, actn.a(2.0F, paramImageView.getContext().getResources()));
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
    localLayoutParams.width = paramString.getCurrent().getIntrinsicWidth();
    localLayoutParams.height = paramString.getCurrent().getIntrinsicHeight();
    paramImageView.setLayoutParams(localLayoutParams);
    paramImageView.setImageDrawable(paramString);
  }
  
  protected static void b(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, adys paramadys)
  {
    ThreadManager.post(new ReplyTextItemBuilder.4(paramMessageRecord, paramQQAppInterface, paramadys, paramContext, paramChatThumbView), 8, null, true);
  }
  
  private static void b(TextView paramTextView1, TextView paramTextView2, int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = bboe.a(str, paramMessageRecord, ChatTextSizeSettingActivity.b() - 2, 7);
    switch (paramInt)
    {
    default: 
      paramTextView1.setVisibility(0);
      paramTextView1.setText(paramString);
      if (AppSetting.d) {
        paramTextView1.setContentDescription(ayla.e(str));
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
      if (AppSetting.d) {
        paramTextView1.setContentDescription(ayla.e(str));
      }
      paramTextView2.setVisibility(8);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText(paramString);
    if (AppSetting.d) {
      paramTextView2.setContentDescription(ayla.e(str));
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
      if (ajwd.a(paramMessageRecord1))
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
        paramBubbleImageView.setTag(2131364125, null);
        paramSourceMsgInfo = (ViewGroup)paramBubbleImageView.getParent();
        if (paramSourceMsgInfo != null) {
          paramSourceMsgInfo.setVisibility(0);
        }
        paramBubbleImageView.setVisibility(0);
        a(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord2, paramString2);
        label87:
        b(paramETTextView1, paramETTextView2, i, (String)localObject1, paramMessageRecord1);
        a(paramQQAppInterface, paramContext, paramETTextView1, paramMessageRecord1, (String)localObject1);
        paramMessageRecord1 = actn.a(paramETTextView1);
        if ((paramMessageRecord1 != null) && ((paramMessageRecord1 instanceof adyq))) {
          ((adyq)paramMessageRecord1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramBubbleImageView;
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
          bool1 = ((adyp)localObject1).jdField_a_of_type_Boolean;
          i = ((adyp)localObject1).jdField_a_of_type_Int;
          paramString1 = ((adyp)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
          localObject1 = ((adyp)localObject1).jdField_a_of_type_JavaLangString;
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
        if (!apue.a(paramMessageRecord1)) {
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
            j = apue.a(((FileManagerEntity)localObject2).fileName);
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
        paramSourceMsgInfo = bakj.a(paramQQAppInterface, (MessageForTroopFile)paramSourceMsgInfo);
        paramString2 = localObject3;
        bool1 = bool2;
        i = paramInt;
        localObject1 = paramString1;
        if (paramSourceMsgInfo == null) {
          break;
        }
        int j = apue.a(paramSourceMsgInfo.g);
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
  
  protected static void c(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, adys paramadys)
  {
    ThreadManager.post(new ReplyTextItemBuilder.5(paramMessageRecord, paramQQAppInterface, paramadys, paramContext, paramChatThumbView), 8, null, true);
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
  
  public acum a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (adyq)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  public acun a()
  {
    return new adyq(this);
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (paramView != null)
    {
      localadyq = (adyq)paramView.getTag();
      if (localadyq != null) {
        this.jdField_a_of_type_Adyr.a(localadyq.e, paramView);
      }
    }
    adyq localadyq = (adyq)paramacun;
    int i;
    if (localMessageForReplyText.mSourceMsgInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ReplyTextItemBuilder", 2, "text.mSourceMsgInfo为null, text:" + localMessageForReplyText.toString());
      }
      localadyq.e = -1;
      paramacun = this.jdField_a_of_type_Adyr.a(-1);
      if (paramacun != null) {
        break label643;
      }
      paramacun = new LinearLayout(localContext);
      paramacun.setOrientation(1);
      paramView = new ETTextView(localContext);
      paramView.setTextColor(localContext.getResources().getColorStateList(2131166872));
      paramView.setLinkTextColor(localContext.getResources().getColorStateList(2131166866));
      paramView.setEditableFactory(ayks.a);
      paramView.setSpannableFactory(ayki.a);
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
      paramView.setId(2131364113);
      localadyq.d = paramView;
      paramView = new LinearLayout.LayoutParams(-2, -2);
      paramView.topMargin = actn.a(5.0F, localContext.getResources());
      paramacun.addView(localadyq.d, paramView);
    }
    label643:
    for (;;)
    {
      ((ETTextView)localadyq.d).setFont(0, paramChatMessage.uniseq);
      localadyq.d.setTypeface(ia.a(paramChatMessage));
      localadyq.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      localadyq.d.setText(localMessageForReplyText.sb);
      super.a(localadyq.d, paramChatMessage);
      paramacun.setOnTouchListener(paramacxn);
      paramacun.setOnLongClickListener(paramacxn);
      localadyq.d.setOnTouchListener(paramacxn);
      localadyq.d.setOnLongClickListener(paramacxn);
      paramView = paramacun;
      if ((localadyq.d instanceof AnimationTextView))
      {
        ((AnimationTextView)localadyq.d).onDoubleClick = this.jdField_a_of_type_Bcjb;
        paramView = paramacun;
      }
      if (paramView != null)
      {
        paramView.setTag(localadyq);
        paramView.setPadding(0, 0, 0, 0);
        if ((AppSetting.d) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0))
        {
          paramacun = ayla.e(paramChatMessage.msg);
          if (!paramChatMessage.isSend()) {
            break label604;
          }
          paramView.setContentDescription(ajyc.a(2131713401) + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + ajyc.a(2131713406) + paramacun);
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
        paramView = a(paramBaseChatItemLayout, localContext, localadyq, localMessageForReplyText, paramacxn, bool);
        break;
      }
      label604:
      paramView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + ajyc.a(2131713403) + paramacun);
      return paramView;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Adyr.a();
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
    adgb.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 3);
    Bundle localBundle = new Bundle();
    localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
    Object localObject = (MessageForReplyText)paramChatMessage;
    if (aibp.a().c())
    {
      paramContext = aibp.a().a();
      if (paramContext == null) {
        if (((MessageForReplyText)localObject).sb != null)
        {
          paramContext = ((MessageForReplyText)localObject).sb.toString();
          label107:
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      label109:
      if (paramInt != 0)
      {
        localBundle.putInt("forward_type", -6);
        localBundle.putLong("FORWARD_MSG_UNISEQ", paramChatMessage.uniseq);
        localObject = (avqs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(340);
        MessageRecord localMessageRecord = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage, ((MessageForReplyText)paramChatMessage).mSourceMsgInfo);
        ((MessageForReplyText)paramChatMessage).setSourceMessageRecord(localMessageRecord);
        ((avqs)localObject).a(paramChatMessage);
      }
      for (;;)
      {
        localBundle.putString("forward_text", paramContext);
        localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramContext = new Intent();
        paramContext.putExtras(localBundle);
        aqbc.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
        if (!paramChatMessage.isMultiMsg) {
          break;
        }
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 1, 0, "1", "", "", "");
        return;
        paramContext = ((MessageForReplyText)localObject).msg;
        break label107;
        if (paramContext.length() != aibp.a().a()) {
          break label383;
        }
        paramInt = 1;
        break label109;
        if (((MessageForReplyText)localObject).sb != null) {}
        for (paramContext = ((MessageForReplyText)localObject).sb.toString();; paramContext = ((MessageForReplyText)localObject).msg)
        {
          paramInt = 1;
          break;
        }
        localBundle.putInt("forward_type", -1);
      }
      label383:
      paramInt = 0;
    }
  }
  
  public void a(acun paramacun, View paramView, ChatMessage paramChatMessage, ambh paramambh)
  {
    adyq localadyq = (adyq)paramacun;
    paramacun = (MessageForReplyText)paramChatMessage;
    if (paramacun.mSourceMsgInfo == null) {
      return;
    }
    Object localObject = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838092);
    localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
    int i = paramacun.mSourceMsgInfo.mType;
    if ((paramambh.jdField_a_of_type_Int == 0) || (!paramambh.a()) || (axmt.b()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramacun = paramView.getColorStateList(2131166876);
        localadyq.d.setTextColor(paramacun);
        localadyq.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramacun);
        localadyq.c.setTextColor(paramacun);
        localadyq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramacun);
        localadyq.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramacun);
        localadyq.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramacun);
        ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(paramacun.getDefaultColor(), PorterDuff.Mode.SRC_ATOP));
        localadyq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        if (!paramChatMessage.isSend()) {
          break label295;
        }
      }
      label295:
      for (paramacun = paramView.getColorStateList(2131166875);; paramacun = paramView.getColorStateList(2131166874))
      {
        localadyq.d.setLinkTextColor(paramacun);
        localadyq.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacun);
        localadyq.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacun);
        ImmersiveUtils.a(localadyq.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
        ImmersiveUtils.a(localadyq.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
        ImmersiveUtils.a(localadyq.c, 0.9F);
        ImmersiveUtils.a(localadyq.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        ImmersiveUtils.a(localadyq.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        return;
        paramacun = paramView.getColorStateList(2131166872);
        break;
      }
    }
    if (paramambh.jdField_b_of_type_Int == 0)
    {
      localadyq.d.setTextColor(-16777216);
      localadyq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      localadyq.c.setTextColor(-16777216);
      localadyq.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      localadyq.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      localadyq.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP));
      localadyq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      label408:
      if (paramambh.jdField_c_of_type_Int != 0) {
        break label750;
      }
      paramacun = paramView.getResources().getColorStateList(2131166874);
      localadyq.d.setLinkTextColor(paramacun);
      localadyq.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacun);
      localadyq.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacun);
    }
    for (;;)
    {
      ImmersiveUtils.a(localadyq.c, 0.9F);
      ImmersiveUtils.a(localadyq.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
      ImmersiveUtils.a(localadyq.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
      ImmersiveUtils.a(localadyq.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
      if ((!paramambh.jdField_b_of_type_Boolean) || (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localadyq.d.getCurrentTextColor(), 10000.0D * localadyq.jdField_a_of_type_Ambh.jdField_a_of_type_Double) != 1)) {
        break;
      }
      paramacun = (ETTextView)localadyq.d;
      float f2 = paramacun.getTextSize() * 3.0F / 16.0F;
      float f1 = f2;
      if (f2 > 25.0F) {
        f1 = 25.0F;
      }
      paramacun.setTextColor(-1);
      paramacun.setShadowLayer(f1, 0.0F, 0.0F, paramambh.d);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      localadyq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localadyq.d.setTextColor(paramambh.jdField_b_of_type_Int);
      localadyq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramambh.jdField_b_of_type_Int);
      localadyq.c.setTextColor(paramambh.jdField_b_of_type_Int);
      localadyq.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramambh.jdField_b_of_type_Int);
      localadyq.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramambh.jdField_b_of_type_Int);
      localadyq.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramambh.jdField_b_of_type_Int);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(paramambh.jdField_b_of_type_Int, PorterDuff.Mode.SRC_ATOP));
      localadyq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      break label408;
      label750:
      localadyq.d.setLinkTextColor(paramambh.jdField_c_of_type_Int);
      localadyq.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramambh.jdField_c_of_type_Int);
      localadyq.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramambh.jdField_c_of_type_Int);
    }
  }
  
  public void a(View paramView)
  {
    if (actn.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForReplyText)actn.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689995);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689996);
    } while (!paramView.isSendFromLocal());
    bbcv.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new adyn(this, paramView), new adyo(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView = (adyq)paramView.getTag();
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    int i = actn.a(1.0F, paramView.jdField_a_of_type_AndroidWidgetTextView.getResources());
    if (localMessageForReplyText.mSourceMsgInfo == null) {
      return;
    }
    int j = localMessageForReplyText.mSourceMsgInfo.mType;
    j = BaseChatItemLayout.d - actn.a(16.0F, paramView.jdField_a_of_type_AndroidWidgetTextView.getResources());
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
      f = actn.a(37.0F, paramView.jdField_a_of_type_AndroidWidgetTextView.getResources()) + f;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(i - (int)f);
      paramChatMessage = (String)paramView.jdField_a_of_type_AndroidWidgetTextView.getTag(2131376859);
      paramChatMessage = ayla.a(paramView.jdField_a_of_type_AndroidWidgetTextView, paramChatMessage, i - (int)f);
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acun paramacun, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacun, paramInt1, paramInt2);
    paramChatMessage = bbdr.a(paramacun.a.getBackground());
    if (paramChatMessage == null)
    {
      paramInt1 = 0;
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, new Object[] { "color=", Integer.valueOf(paramInt1), " ", Integer.valueOf((paramInt1 & 0xFF0000) >> 16), " ", Integer.valueOf((paramInt1 & 0xFF00) >> 8), " ", Integer.valueOf(paramInt1 & 0xFF) });
      }
      if (((((paramInt1 & 0xFF0000) >> 16) + ((paramInt1 & 0xFF00) >> 8) + (paramInt1 & 0xFF)) / 3 < 170) && (((paramInt1 != 0) && (paramInt1 != -16777216) && (paramInt1 != -15366474)) || ("2920".equals(ThemeUtil.getCurrentThemeId())))) {
        break label254;
      }
      if ((paramacun instanceof adyq)) {
        ((adyq)paramacun).jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838090));
      }
    }
    label254:
    while (!(paramacun instanceof adyq))
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
    ((adyq)paramacun).jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838091));
  }
  
  public void b(acun paramacun, ChatMessage paramChatMessage)
  {
    int i = 0;
    if (!(paramacun instanceof adyq)) {}
    adyq localadyq;
    do
    {
      do
      {
        do
        {
          return;
          localadyq = (adyq)paramacun;
        } while (!(paramChatMessage instanceof MessageForReplyText));
        paramChatMessage = (MessageForReplyText)paramChatMessage;
        paramacun = null;
        if (!TextUtils.isEmpty(paramChatMessage.sb)) {
          paramacun = paramChatMessage.sb;
        }
      } while ((paramacun == null) || (!(paramacun instanceof ayki)));
      paramChatMessage = (ayki)paramacun;
      paramacun = (aykp[])paramChatMessage.getSpans(0, paramacun.length(), aykp.class);
    } while ((paramacun.length <= 0) || (paramChatMessage.b().length() != 0));
    int j = paramacun.length;
    while (i < j)
    {
      paramacun[i].a(axli.a(26.0F));
      i += 1;
    }
    localadyq.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setText(paramChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adyh
 * JD-Core Version:    0.7.0.1
 */