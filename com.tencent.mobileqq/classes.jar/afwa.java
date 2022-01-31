import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class afwa
  extends BaseBubbleBuilder
  implements aeqh, aesa
{
  private aetj jdField_a_of_type_Aetj = new aetj();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private bemz jdField_a_of_type_Bemz = new afwc(this);
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private View.OnClickListener b;
  protected long c;
  
  public afwa(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new afwb(this);
    this.jdField_a_of_type_Aetj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new axnd(this);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder1, SpannableStringBuilder paramSpannableStringBuilder2, List<MessageRecord> paramList)
  {
    if (paramSpannableStringBuilder1.length() > 0)
    {
      MessageRecord localMessageRecord = azaf.a(-1000);
      ((MessageForText)localMessageRecord).sb = new SpannableStringBuilder(paramSpannableStringBuilder1);
      paramSpannableStringBuilder1.clear();
      if (paramSpannableStringBuilder2.length() > 0) {
        ((MessageForText)localMessageRecord).sb2 = new SpannableStringBuilder(paramSpannableStringBuilder2);
      }
      paramSpannableStringBuilder2.clear();
      paramList.add(localMessageRecord);
    }
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    String str;
    if (paramURLDrawable.getStatus() != 1)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      str = paramURLDrawable.getURL().toString();
      if (str != null) {
        break label39;
      }
    }
    label39:
    while (this.jdField_a_of_type_JavaUtilArrayList.contains(str)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(str);
    ThreadManager.executeOnSubThread(new MixedMsgItemBuilder.2(this, str, paramURLDrawable), true);
  }
  
  private void a(ChatMessage paramChatMessage, String paramString)
  {
    afcq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 2);
    Object localObject;
    int i;
    if (ajxm.a().c())
    {
      localObject = ajxm.a().a();
      if (localObject != null) {
        if (((CharSequence)localObject).length() != ajxm.a().a())
        {
          i = 1;
          if (i != 0) {
            break label224;
          }
          localObject = ajxm.a().b();
        }
      }
    }
    label65:
    label224:
    for (;;)
    {
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText((CharSequence)localObject);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
      if (i != 0) {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramChatMessage.isMultiMsg) {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D65", "0X8009D65", 3, 0, "3", "", "", "");
        }
        return;
        i = 0;
        break;
        i = 0;
        break;
        localObject = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
        i = 1;
        break label65;
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
      }
    }
  }
  
  private void a(ArrayList<bclm> paramArrayList, ArrayList<TextView> paramArrayList1, MessageRecord paramMessageRecord)
  {
    if (!bcll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      break label14;
    }
    label14:
    while (paramArrayList1.isEmpty()) {
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = null;
    int j = -1;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int m = paramArrayList1.size();
    TextView localTextView;
    Object localObject2;
    int k;
    for (;;)
    {
      if (i < m)
      {
        localTextView = (TextView)paramArrayList1.get(i);
        localObject2 = (bclm)paramArrayList.get(i);
        if ((localObject2 == null) || (((bclm)localObject2).jdField_b_of_type_Int == -1))
        {
          localStringBuilder.append(localTextView.getText());
          k = j;
          localObject2 = localObject1;
          if (i != m - 1)
          {
            localStringBuilder.append(" ");
            localObject2 = localObject1;
            k = j;
          }
          label138:
          i += 1;
          j = k;
          localObject1 = localObject2;
        }
        else
        {
          localStringBuilder.append(((bclm)localObject2).b());
          if (i != m - 1) {
            localStringBuilder.append(" ");
          }
          if (localObject1 == null)
          {
            localObject1 = localObject2;
            j = i;
          }
        }
      }
    }
    for (;;)
    {
      localTextView.setTag(2131366469, "school_troop_span");
      k = j;
      localObject2 = localObject1;
      break label138;
      if (((bclm)localObject2).jdField_b_of_type_Int < localObject1.jdField_b_of_type_Int)
      {
        localObject1 = localObject2;
        j = i;
        continue;
        if (localObject1 != null)
        {
          localObject2 = new bclm();
          ((bclm)localObject2).jdField_a_of_type_Long = paramMessageRecord.uniseq;
          ((bclm)localObject2).jdField_a_of_type_Int = localObject1.jdField_a_of_type_Int;
          ((bclm)localObject2).jdField_a_of_type_JavaLangString = localObject1.jdField_a_of_type_JavaLangString;
          ((bclm)localObject2).jdField_b_of_type_JavaLangString = localObject1.jdField_b_of_type_JavaLangString;
          ((bclm)localObject2).jdField_b_of_type_Int = localObject1.jdField_b_of_type_Int;
          ((bclm)localObject2).a(localStringBuilder.toString());
          ((bclm)localObject2).c = localObject1.c;
          ((bclm)localObject2).d = localObject1.d;
          ((Spannable)((TextView)paramArrayList1.get(j)).getText()).setSpan(new bcln(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (bclm)localObject2), ((bclm)localObject2).c, ((bclm)localObject2).d, 17);
          if (QLog.isDevelopLevel()) {
            QLog.d("school_troop.MixedMsgItemBuilder", 2, new Object[] { "matchKeywordResults.size: ", Integer.valueOf(paramArrayList.size()), "; detect result: ", localObject2 });
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("school_troop.MixedMsgItemBuilder", 2, " updateSchoolTroopHighlight time cost: " + (System.currentTimeMillis() - l));
        return;
      }
    }
  }
  
  private boolean a(afwe paramafwe)
  {
    return (paramafwe.jdField_b_of_type_AndroidWidgetTextView != null) && (paramafwe.jdField_a_of_type_AndroidWidgetTextView != null) && (paramafwe.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (paramafwe.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null);
  }
  
  private void b(ChatMessage paramChatMessage, String paramString)
  {
    afcq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 3);
    Object localObject1;
    int i;
    if (ajxm.a().c())
    {
      localObject1 = ajxm.a().a();
      if (localObject1 != null) {
        if (((String)localObject1).length() == ajxm.a().a())
        {
          i = 1;
          if (i != 0) {
            break label556;
          }
          localObject1 = ajxm.a().b();
        }
      }
    }
    label515:
    label527:
    label556:
    for (;;)
    {
      label63:
      Bundle localBundle = new Bundle();
      Object localObject2;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext() != null))
      {
        localObject2 = bdne.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
        if ((localObject2 != null) && (((String)localObject2).length() > 0))
        {
          localObject2 = ((String)localObject2).split("\\|");
          if ((localObject2 == null) || (localObject2.length <= 0)) {}
        }
      }
      for (;;)
      {
        try
        {
          int j = Integer.parseInt(localObject2[0]);
          if (QLog.isColorLevel()) {
            QLog.d("MixedMsgItemBuilder", 2, "get mixMsgForward switch From config : configSwitch = " + j);
          }
          if (j == 1)
          {
            j = 1;
            if ((i == 0) || (j == 0)) {
              break label515;
            }
            localBundle.putInt("forward_type", -5);
            localBundle.putLong("FORWARD_MSG_UNISEQ", paramChatMessage.uniseq);
            ((aufc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a.put(Long.valueOf(paramChatMessage.uniseq), paramChatMessage);
            localBundle.putString("forward_text", (String)localObject1);
            localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
            localObject1 = new Intent();
            ((Intent)localObject1).putExtras(localBundle);
            aryv.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, 21);
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005637", "0X8005637", 0, 0, "", "", "", "");
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
            if (i == 0) {
              break label527;
            }
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
            if (paramChatMessage.isMultiMsg) {
              azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 9, 0, "9", "", "", "");
            }
            return;
            i = 0;
            break;
            i = 0;
            break;
            localObject1 = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString();
            i = 1;
            break label63;
          }
          j = 0;
          continue;
          j = 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("MixedMsgItemBuilder", 2, "get mixMsgForward switch from config error", localNumberFormatException);
          }
        }
        continue;
        localBundle.putInt("forward_type", -1);
        continue;
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      }
    }
  }
  
  private void c(ChatMessage paramChatMessage, String paramString)
  {
    afcq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 4);
    String str;
    int i;
    if (ajxm.a().c())
    {
      str = ajxm.a().a();
      if (str != null) {
        if (str.length() == ajxm.a().a())
        {
          i = 1;
          if (i != 0) {
            break label290;
          }
          str = ajxm.a().b();
        }
      }
    }
    label261:
    label290:
    for (;;)
    {
      label63:
      if ((i != 0) || (str == null))
      {
        biva.b(paramChatMessage).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, 0, paramChatMessage.istroop);
        label115:
        bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
        if (i == 0) {
          break label261;
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAC", 4, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramChatMessage.isMultiMsg) {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 9, 0, "9", "", "", "");
        }
        return;
        i = 0;
        break;
        i = 0;
        break;
        str = null;
        i = 1;
        break label63;
        bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramChatMessage.istroop);
        biva.a(null, str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        break label115;
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 4, 0, "", "", "", "");
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public aeqh a(View paramView)
  {
    if (a(paramView)) {
      return this;
    }
    return null;
  }
  
  public aeqi a()
  {
    return new afwe(this);
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    afwe localafwe = (afwe)paramaeqi;
    if (paramaeqi.b == null) {
      paramaeqi.b = new StringBuilder();
    }
    Object localObject1 = (bcpg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    if (QLog.isColorLevel()) {
      QLog.i("MixedMsgItemBuilder", 1, "getBubbleView: check is need refresh[" + localafwe.jdField_a_of_type_Boolean + "]");
    }
    if ((!e) && (afwe.a(localafwe) != null) && (afwe.a(localafwe) == paramChatMessage.uniseq) && (!localafwe.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info"))))
    {
      if (((bcpg)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage))
      {
        localafwe.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return paramView;
      }
      localafwe.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return paramView;
    }
    Object localObject2;
    Object localObject3;
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      paramBaseChatItemLayout = (MessageForMixedMsg)paramChatMessage;
      if (e)
      {
        if (bdil.a(paramChatMessage.issend)) {
          paramaeqi.b.append("发出");
        }
      }
      else {
        localObject2 = paramBaseChatItemLayout.msgElemList.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label379;
        }
        localObject3 = (MessageRecord)((Iterator)localObject2).next();
        if ((localObject3 instanceof MessageForPic))
        {
          if (e) {
            paramaeqi.b.append("图片");
          }
          localObject3 = (MessageForPic)localObject3;
          if (((MessageForPic)localObject3).time != 0L) {
            continue;
          }
          MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject3, paramBaseChatItemLayout);
          continue;
          paramaeqi.b.append("发来");
          break;
        }
        if ((localObject3 instanceof MessageForReplyText))
        {
          if (((MessageForReplyText)localObject3).time == 0L) {
            MessageForMixedMsg.copyBaseInfoFromMixedToNormal((MessageRecord)localObject3, paramBaseChatItemLayout);
          }
        }
        else if (e) {
          paramaeqi.b.append(banh.b(((MessageRecord)localObject3).msg));
        }
      }
      label379:
      paramBaseChatItemLayout = a(paramaeqi, (MixedMsgLinearLayout)paramView, paramBaseChatItemLayout.msgElemList, paramaetk, paramBaseChatItemLayout);
      afwe.a((afwe)paramaeqi, paramChatMessage.uniseq);
      if (((bcpg)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
        localafwe.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      }
    }
    for (;;)
    {
      paramaeqi = aery.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramaeqi != null) {
        paramaeqi.a(paramBaseChatItemLayout, this);
      }
      if (paramBaseChatItemLayout != null) {
        paramBaseChatItemLayout.setTag(localafwe);
      }
      paramView = paramBaseChatItemLayout;
      if (localafwe.jdField_a_of_type_Ajxp == null) {
        break;
      }
      localafwe.jdField_a_of_type_Ajxp.b(paramChatMessage);
      return paramBaseChatItemLayout;
      localafwe.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      continue;
      paramBaseChatItemLayout = paramView;
      if ((paramChatMessage instanceof MessageForLongMsg))
      {
        localObject3 = (MessageForLongMsg)paramChatMessage;
        if (e) {
          paramaeqi.b.append("说");
        }
        localObject2 = new ArrayList();
        paramBaseChatItemLayout = paramView;
        if (((MessageForLongMsg)localObject3).longMsgFragmentList != null)
        {
          paramBaseChatItemLayout = paramView;
          if (!((MessageForLongMsg)localObject3).longMsgFragmentList.isEmpty())
          {
            localObject1 = new SpannableStringBuilder();
            paramBaseChatItemLayout = new SpannableStringBuilder();
            localObject3 = ((MessageForLongMsg)localObject3).longMsgFragmentList.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              Object localObject4 = (MessageRecord)((Iterator)localObject3).next();
              if ((localObject4 instanceof MessageForText))
              {
                if (!TextUtils.isEmpty(((MessageForText)localObject4).sb)) {
                  ((SpannableStringBuilder)localObject1).append(((MessageForText)localObject4).sb);
                }
                if (!TextUtils.isEmpty(((MessageForText)localObject4).sb2)) {
                  paramBaseChatItemLayout.append(((MessageForText)localObject4).sb2);
                } else if (!TextUtils.isEmpty(((MessageForText)localObject4).sb)) {
                  paramBaseChatItemLayout.append(((MessageForText)localObject4).sb);
                }
              }
              else if ((localObject4 instanceof MessageForPic))
              {
                a((SpannableStringBuilder)localObject1, paramBaseChatItemLayout, (List)localObject2);
                ((List)localObject2).add(localObject4);
              }
              else
              {
                if ((localObject4 instanceof MessageForMixedMsg))
                {
                  localObject4 = (MessageForMixedMsg)localObject4;
                  List localList = ((MessageForMixedMsg)localObject4).msgElemList;
                  int j = localList.size();
                  int i = 0;
                  label801:
                  MessageRecord localMessageRecord;
                  if (i < j)
                  {
                    localMessageRecord = (MessageRecord)localList.get(i);
                    if (!(localMessageRecord instanceof MessageForPic)) {
                      break label882;
                    }
                    if (((MessageForPic)localMessageRecord).time == 0L) {
                      MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, (MessageForMixedMsg)localObject4);
                    }
                    a((SpannableStringBuilder)localObject1, paramBaseChatItemLayout, (List)localObject2);
                    ((List)localObject2).add(localMessageRecord);
                  }
                  for (;;)
                  {
                    i += 1;
                    break label801;
                    break;
                    label882:
                    if ((localMessageRecord instanceof MessageForText))
                    {
                      if (!TextUtils.isEmpty(((MessageForText)localMessageRecord).sb)) {
                        ((SpannableStringBuilder)localObject1).append(((MessageForText)localMessageRecord).sb);
                      }
                      if (!TextUtils.isEmpty(((MessageForText)localMessageRecord).sb2)) {
                        paramBaseChatItemLayout.append(((MessageForText)localMessageRecord).sb2);
                      } else if (!TextUtils.isEmpty(((MessageForText)localMessageRecord).sb)) {
                        paramBaseChatItemLayout.append(((MessageForText)localMessageRecord).sb);
                      }
                    }
                    else
                    {
                      ((List)localObject2).add(localMessageRecord);
                    }
                  }
                }
                if ((localObject4 instanceof MessageForReplyText))
                {
                  if (!TextUtils.isEmpty(((MessageForReplyText)localObject4).sb))
                  {
                    ((SpannableStringBuilder)localObject1).append(((MessageForReplyText)localObject4).sb);
                    paramBaseChatItemLayout.append(((MessageForReplyText)localObject4).sb);
                  }
                  ((List)localObject2).add(localObject4);
                }
              }
            }
            a((SpannableStringBuilder)localObject1, paramBaseChatItemLayout, (List)localObject2);
            paramView = a(paramaeqi, (MixedMsgLinearLayout)paramView, (List)localObject2, paramaetk, paramChatMessage);
            afwe.a((afwe)paramaeqi, paramChatMessage.uniseq);
            paramBaseChatItemLayout = paramView;
            if (e)
            {
              paramaeqi.b.append(banh.e(((SpannableStringBuilder)localObject1).toString()));
              paramBaseChatItemLayout = paramView;
            }
          }
        }
      }
    }
  }
  
  public bdpi a(bdpi parambdpi, ChatMessage paramChatMessage, aeqz paramaeqz)
  {
    int i = 0;
    parambdpi.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691290));
    if ((paramChatMessage instanceof MessageForMixedMsg)) {
      if (((MessageForMixedMsg)paramChatMessage).canSelectable()) {
        break label126;
      }
    }
    for (;;)
    {
      if (i != 0) {
        parambdpi.a(2131364912, this.jdField_a_of_type_AndroidContentContext.getString(2131719146), 2130838671);
      }
      parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
      if (aepi.a(5) == 1) {
        parambdpi.a(2131366017, this.jdField_a_of_type_AndroidContentContext.getString(2131692401), 2130838677);
      }
      return parambdpi;
      if ((!(paramChatMessage instanceof MessageForLongMsg)) || (((MessageForLongMsg)paramChatMessage).canSelectable())) {
        label126:
        i = 1;
      }
    }
  }
  
  public MixedMsgLinearLayout a(aeqi paramaeqi, MixedMsgLinearLayout paramMixedMsgLinearLayout, List<MessageRecord> paramList, aetk paramaetk, MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList1 = new ArrayList(paramList);
    paramList = paramMixedMsgLinearLayout;
    if (paramMixedMsgLinearLayout == null)
    {
      paramList = new MixedMsgLinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramList.setId(2131364173);
      paramList.setOrientation(1);
      paramList.setFocusable(false);
      paramList.setClickable(true);
      paramList.setMinimumHeight(aepi.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramList.setPadding(2131296294, 2131296296, 2131296293, 2131296295);
      paramMixedMsgLinearLayout = new RelativeLayout.LayoutParams(-2, -2);
      paramMixedMsgLinearLayout.addRule(1, 2131367819);
      paramMixedMsgLinearLayout.addRule(3, 2131377621);
      paramMixedMsgLinearLayout.leftMargin = aepi.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramMixedMsgLinearLayout.rightMargin = aepi.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramList.setLayoutParams(paramMixedMsgLinearLayout);
      paramList.jdField_a_of_type_Bemz = this.jdField_a_of_type_Bemz;
      afwe.a((afwe)paramaeqi, paramList);
      ((afwe)paramaeqi).jdField_a_of_type_Ajxp = new ajxp();
      ((afwe)paramaeqi).jdField_a_of_type_Ajxp.a(paramList);
      ((afwe)paramaeqi).jdField_a_of_type_Ajxp.a(paramaeqi.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramaeqi.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
    }
    ((afwe)paramaeqi).e = -1;
    ((afwe)paramaeqi).jdField_a_of_type_Boolean = false;
    paramList.a(localArrayList1, (afwe)paramaeqi);
    if (bcll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {}
    for (paramMixedMsgLinearLayout = (bcll)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262);; paramMixedMsgLinearLayout = null)
    {
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int j = localArrayList1.size();
      int i = 0;
      Object localObject1;
      View localView;
      Object localObject3;
      Object localObject2;
      Object localObject4;
      label537:
      boolean bool;
      for (;;)
      {
        if (i < j)
        {
          localObject1 = (MessageRecord)localArrayList1.get(i);
          localView = paramList.getChildAt(i);
          if (localView == null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("MixedMsgItemBuilder", 2, "getMixedMsgLayout,child is null. size = " + j + ",i = " + i);
            }
            i += 1;
          }
          else if ((localObject1 instanceof MessageForReplyText))
          {
            if ((localView instanceof LinearLayout))
            {
              localObject3 = (LinearLayout)localView;
              localObject2 = (ViewGroup)((LinearLayout)localObject3).getChildAt(0);
              localObject4 = (TextView)((LinearLayout)localObject3).getChildAt(1);
              localObject3 = (MessageForReplyText)localObject1;
              ((ViewGroup)localObject2).setId(2131364201);
              ((ViewGroup)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).setOnTouchListener(paramaetk);
              ((ViewGroup)localObject2).setOnLongClickListener(paramaetk);
              ((ViewGroup)localObject2).findViewById(2131370777).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).findViewById(2131368831).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).findViewById(2131377827).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              if (TextUtils.isEmpty(((MessageForReplyText)localObject3).sb)) {
                break label761;
              }
              ((TextView)localObject4).setText(((MessageForReplyText)localObject3).sb);
              ((TextView)localObject4).setVisibility(0);
              if (paramMixedMsgLinearLayout != null)
              {
                localArrayList2.add(paramMixedMsgLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1));
                localArrayList3.add(localObject4);
              }
              localObject1 = (MessageForReplyText)localObject1;
              afzh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ViewGroup)localObject2, ((MessageForReplyText)localObject3).mSourceMsgInfo, this.jdField_a_of_type_Aetj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((MessageForReplyText)localObject3).istroop, (MessageRecord)localObject1, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
              localObject1 = ((ViewGroup)localObject2).findViewById(2131377827);
              if (localObject1 == null) {
                break label1238;
              }
              localObject1 = ((View)localObject1).getTag(2131364188);
              if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
                break label1238;
              }
              bool = ((Boolean)localObject1).booleanValue();
              ((afwe)paramaeqi).jdField_a_of_type_Boolean = bool;
            }
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MixedMsgItemBuilder", 1, "getMixedMsgLayout: reply check is need refresh[" + bool + "]");
        }
        label709:
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = BaseChatItemLayout.l;
        if (i == j - 1) {}
        for (((LinearLayout.LayoutParams)localObject1).bottomMargin = BaseChatItemLayout.l;; ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0)
        {
          localView.setOnTouchListener(paramaetk);
          localView.setOnLongClickListener(paramaetk);
          break;
          label761:
          ((TextView)localObject4).setVisibility(8);
          break label537;
          if ((localObject1 instanceof MessageForText))
          {
            localObject2 = (AnimationTextView)localView;
            ((AnimationTextView)localObject2).setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
            banh.a((TextView)localObject2);
            if (!TextUtils.isEmpty(((MessageForText)localObject1).sb2)) {
              ((AnimationTextView)localObject2).setText(((MessageForText)localObject1).sb2);
            }
            for (;;)
            {
              if (paramMixedMsgLinearLayout != null)
              {
                localArrayList2.add(paramMixedMsgLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1));
                localArrayList3.add(localObject2);
              }
              if (!bcpg.b(paramMessageRecord)) {
                break;
              }
              bcpg.a((TextView)localObject2, (MessageRecord)localObject1);
              break;
              ((AnimationTextView)localObject2).setText(((MessageForText)localObject1).sb);
            }
          }
          if ((localObject1 instanceof MessageForPic))
          {
            localObject1 = (MessageForPic)localObject1;
            localObject2 = (ChatThumbView)localView;
            localObject3 = new int[2];
            Object tmp924_922 = localObject3;
            tmp924_922[0] = 0;
            Object tmp928_924 = tmp924_922;
            tmp928_924[1] = 0;
            tmp928_924;
            localObject4 = afwu.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localObject1, (ChatThumbView)localObject2, (int[])localObject3);
            ((ChatThumbView)localObject2).setTag(2131364187, localObject1);
            ((ChatThumbView)localObject2).setImageDrawable((Drawable)localObject4);
            String str = ((URLDrawable)localObject4).getURL().getProtocol();
            URL localURL = bayu.a((awjs)localObject1, 65537);
            if (afwu.a(this.jdField_a_of_type_AndroidContentContext, biqe.a(((MessageForPic)localObject1).imageType), str.equals("chatthumb"), localObject3[0], localObject3[1], localURL))
            {
              ((URLDrawable)localObject4).setWatermarkDrawable(afwu.a(), aepi.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
              ((URLDrawable)localObject4).setWatermarkVisibility(0);
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MixedMsgItemBuilder", 2, "getMixedMsgLayout,set picmsg, picDrawable " + localObject4 + ",picMsg = " + localObject1);
              }
              ((ChatThumbView)localObject2).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
              a((URLDrawable)localObject4);
              if (((MessageForPic)localObject1).isSendFromLocal()) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageForPic)localObject1, 2);
              break;
              ((URLDrawable)localObject4).setWatermarkVisibility(4);
            }
          }
          if (!QLog.isColorLevel()) {
            break label709;
          }
          QLog.e("MixedMsgItemBuilder", 2, "mixed type not support yet." + localObject1.getClass().getSimpleName());
          break label709;
        }
        a(localArrayList2, localArrayList3, paramMessageRecord);
        paramList.setOnTouchListener(paramaetk);
        paramList.setOnLongClickListener(paramaetk);
        paramList.b = this.jdField_a_of_type_Bemz;
        return paramList;
        label1238:
        bool = false;
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return "";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {}
    }
    for (String str1 = "";; str1 = "") {
      switch (paramInt)
      {
      default: 
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
    }
    acjm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 6, 0, "", "", "", "");
    return;
    super.d(paramChatMessage);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 7, 0, "", "", "", "");
    return;
    a(paramChatMessage, str1);
    return;
    b(paramChatMessage, str1);
    return;
    c(paramChatMessage, str1);
    return;
    super.a(paramChatMessage);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 5, 0, "", "", "", "");
    return;
    ajxm.a().a(paramChatMessage);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 2, 0, "", "", "", "");
    return;
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 3, 0, "", "", "", "");
    b(paramChatMessage);
  }
  
  public void a(aeqi paramaeqi, View paramView, ChatMessage paramChatMessage, anwo paramanwo)
  {
    afwe localafwe = (afwe)paramaeqi;
    if ((localafwe.e != -1) && (a(localafwe)))
    {
      localafwe.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      if ((paramanwo.jdField_a_of_type_Int == 0) || (!paramanwo.a()) || (azmk.b()))
      {
        paramView = paramView.getResources();
        if (paramChatMessage.isSend())
        {
          paramaeqi = paramView.getColorStateList(2131166925);
          localafwe.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaeqi);
          localafwe.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaeqi);
          localafwe.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaeqi);
          localafwe.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaeqi);
          if (!paramChatMessage.isSend()) {
            break label206;
          }
        }
        label206:
        for (paramaeqi = paramView.getColorStateList(2131166924);; paramaeqi = paramView.getColorStateList(2131166923))
        {
          localafwe.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramaeqi);
          localafwe.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaeqi);
          localafwe.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaeqi);
          ImmersiveUtils.a(localafwe.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
          ImmersiveUtils.a(localafwe.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
          ImmersiveUtils.a(localafwe.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
          return;
          paramaeqi = paramView.getColorStateList(2131166921);
          break;
        }
      }
      if (paramanwo.jdField_b_of_type_Int == 0)
      {
        localafwe.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localafwe.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localafwe.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        localafwe.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        if (paramanwo.c != 0) {
          break label404;
        }
        paramaeqi = paramView.getResources().getColorStateList(2131166923);
        localafwe.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramaeqi);
        localafwe.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaeqi);
        localafwe.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaeqi);
      }
      for (;;)
      {
        ImmersiveUtils.a(localafwe.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
        ImmersiveUtils.a(localafwe.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        ImmersiveUtils.a(localafwe.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        return;
        localafwe.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramanwo.jdField_b_of_type_Int);
        localafwe.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramanwo.jdField_b_of_type_Int);
        localafwe.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramanwo.jdField_b_of_type_Int);
        localafwe.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramanwo.jdField_b_of_type_Int);
        break;
        label404:
        localafwe.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramanwo.c);
        localafwe.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramanwo.c);
        localafwe.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramanwo.c);
      }
    }
    if ((paramanwo.jdField_a_of_type_Int == 0) || (!paramanwo.a()) || (azmk.b()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramaeqi = paramView.getColorStateList(2131166925);
        if (!paramChatMessage.isSend()) {
          break label525;
        }
      }
      label525:
      for (paramView = paramView.getColorStateList(2131166924);; paramView = paramView.getColorStateList(2131166923))
      {
        afwe.a(localafwe).a(paramaeqi, paramView);
        return;
        paramaeqi = paramView.getColorStateList(2131166921);
        break;
      }
    }
    paramaeqi = ColorStateList.valueOf(-16777216);
    paramView = paramView.getResources().getColorStateList(2131166923);
    if (paramanwo.jdField_b_of_type_Int != 0) {
      paramaeqi = ColorStateList.valueOf(paramanwo.jdField_b_of_type_Int);
    }
    if (paramanwo.c != 0) {
      paramView = ColorStateList.valueOf(paramanwo.c);
    }
    afwe.a(localafwe).a(paramaeqi, paramView);
  }
  
  public void a(aeqi paramaeqi, ChatMessage paramChatMessage)
  {
    paramaeqi = (afwe)paramaeqi;
    if (afwe.a(paramaeqi) != null) {
      afwe.a(paramaeqi).a(gj.a(paramChatMessage));
    }
    if ((paramaeqi.e != -1) && (a(paramaeqi)))
    {
      paramChatMessage = gj.a("");
      paramaeqi.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
      paramaeqi.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
      paramaeqi.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
      paramaeqi.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
    }
  }
  
  public void a(View paramView)
  {
    paramView = (afwe)aepi.a(paramView);
    if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
    {
      paramView = (MessageForMixedMsg)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        bhuf localbhuf = (bhuf)bhus.a(this.jdField_a_of_type_AndroidContentContext, null);
        localbhuf.a(2131690042, 5);
        localbhuf.c(2131690648);
        localbhuf.a(new afwd(this, paramView, localbhuf));
        localbhuf.show();
      }
    }
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return;
      paramView = paramView.getBackground();
    } while (paramView == null);
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  public void a(View paramView, bass parambass, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2003) {}
    label68:
    label585:
    label593:
    for (;;)
    {
      return;
      Object localObject1 = (afwe)aepi.a(paramView);
      paramView = null;
      Object localObject2;
      if ((((afwe)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
      {
        paramView = (MessageForMixedMsg)((afwe)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if ((afwe.a((afwe)localObject1) != null) && (paramView != null) && (paramView.msgElemList != null)) {
          for (paramView = paramView.msgElemList.iterator(); paramView.hasNext(); paramView = (MessageForPic)localObject2)
          {
            localObject2 = (MessageRecord)paramView.next();
            if ((localObject2 == null) || (((MessageRecord)localObject2).uniseq != parambass.b) || (!(localObject2 instanceof MessageForPic)) || (((MessageForPic)localObject2).subMsgId != parambass.c)) {
              break label68;
            }
          }
        }
      }
      else
      {
        for (;;)
        {
          if (paramView == null) {
            break label593;
          }
          paramInt2 = afwe.a((afwe)localObject1).getChildCount();
          paramInt1 = 0;
          label232:
          Object localObject3;
          Object localObject4;
          if (paramInt1 < paramInt2)
          {
            parambass = afwe.a((afwe)localObject1).getChildAt(paramInt1);
            if ((parambass instanceof ChatThumbView))
            {
              localObject2 = ((ChatThumbView)parambass).getTag(2131364187);
              if (((localObject2 instanceof MessageForPic)) && (((MessageForPic)localObject2).uniseq == paramView.uniseq) && (((MessageForPic)localObject2).subMsgId == paramView.subMsgId))
              {
                parambass = (ChatThumbView)parambass;
                if (parambass == null) {
                  break label577;
                }
                localObject1 = new int[2];
                tmp243_241 = localObject1;
                tmp243_241[0] = 0;
                tmp247_243 = tmp243_241;
                tmp247_243[1] = 0;
                tmp247_243;
                localObject2 = afwu.a(this.jdField_a_of_type_AndroidContentContext, paramView, parambass, (int[])localObject1);
                localObject3 = ((URLDrawable)localObject2).getURL().getProtocol();
                localObject4 = bayu.a(paramView, 65537);
                boolean bool = afwu.a(this.jdField_a_of_type_AndroidContentContext, biqe.a(paramView.imageType), ((String)localObject3).equals("chatthumb"), localObject1[0], localObject1[1], (URL)localObject4);
                parambass.setImageDrawable((Drawable)localObject2);
                if (!bool) {
                  break label567;
                }
                ((URLDrawable)localObject2).setWatermarkDrawable(afwu.a(), aepi.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                ((URLDrawable)localObject2).setWatermarkVisibility(0);
                return;
                if (!(((afwe)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForLongMsg)) {
                  break label585;
                }
                localObject2 = (MessageForLongMsg)((afwe)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
                if ((((MessageForLongMsg)localObject2).longMsgFragmentList == null) || (((MessageForLongMsg)localObject2).longMsgFragmentList.isEmpty())) {
                  break label585;
                }
                localObject2 = ((MessageForLongMsg)localObject2).longMsgFragmentList.iterator();
                do
                {
                  if (!((Iterator)localObject2).hasNext()) {
                    break;
                  }
                  localObject3 = (MessageRecord)((Iterator)localObject2).next();
                } while (localObject3 == null);
                if (((MessageRecord)localObject3).uniseq != parambass.b) {
                  break label579;
                }
                if ((localObject3 instanceof MessageForPic)) {
                  paramView = (MessageForPic)localObject3;
                }
              }
            }
          }
          for (;;)
          {
            label478:
            break label424;
            if ((localObject3 instanceof MessageForMixedMsg))
            {
              localObject3 = ((MessageForMixedMsg)localObject3).msgElemList.iterator();
              for (;;)
              {
                if (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (MessageRecord)((Iterator)localObject3).next();
                  if (((localObject4 instanceof MessageForPic)) && (((MessageForPic)localObject4).subMsgId == parambass.c))
                  {
                    paramView = (MessageForPic)localObject4;
                    break label478;
                    paramInt1 += 1;
                    break label153;
                    ((URLDrawable)localObject2).setWatermarkVisibility(4);
                    return;
                    parambass = null;
                    break label232;
                    break;
                  }
                }
              }
            }
          }
          continue;
          paramView = null;
          continue;
          paramView = null;
        }
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView = (afwe)paramView.getTag();
    int i = BaseChatItemLayout.g;
    if (paramChatMessage.isSend())
    {
      afwe.a(paramView).setPadding(agda.f, i, agda.e, agda.d);
      return;
    }
    afwe.a(paramView).setPadding(agda.e, i, agda.f, agda.d);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Object localObject = (afwe)aepi.a(paramView);
    if ((!paramBoolean) && ((paramView instanceof ChatThumbView))) {
      ((ChatThumbView)paramView).a(paramView, true);
    }
    localObject = afwe.a((afwe)localObject).getBackground();
    if (localObject != null) {
      if (!paramBoolean) {
        break label56;
      }
    }
    label56:
    for (paramView = null;; paramView = jdField_a_of_type_AndroidGraphicsColorFilter)
    {
      ((Drawable)localObject).setColorFilter(paramView);
      ((Drawable)localObject).invalidateSelf();
      return;
    }
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (!paramChatMessage.isSendFromLocal()) {}
    while (paramChatMessage.extraflag != 32768) {
      return false;
    }
    return true;
  }
  
  public bdpk[] a(View paramView)
  {
    paramView = (afwe)aepi.a(paramView);
    ChatMessage localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    bdpi localbdpi = new bdpi();
    if (localChatMessage != null)
    {
      if (!localChatMessage.isMultiMsg) {
        break label45;
      }
      a(localbdpi, localChatMessage, null);
    }
    for (;;)
    {
      return localbdpi.a();
      label45:
      b(localbdpi, localChatMessage, paramView);
    }
  }
  
  public bdpi b(bdpi parambdpi, ChatMessage paramChatMessage, aeqz paramaeqz)
  {
    parambdpi.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691290));
    int i;
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      if (((MessageForMixedMsg)paramChatMessage).canSelectable()) {
        break label184;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        parambdpi.a(2131364912, this.jdField_a_of_type_AndroidContentContext.getString(2131719146), 2130838671);
      }
      parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
      a(paramChatMessage, parambdpi);
      a(parambdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramaeqz.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      a(parambdpi, paramChatMessage);
      if (aepi.a(5) == 1) {
        parambdpi.a(2131366017, this.jdField_a_of_type_AndroidContentContext.getString(2131692401), 2130838677);
      }
      b(paramChatMessage, parambdpi);
      super.c(parambdpi, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambdpi, this.jdField_a_of_type_AndroidContentContext);
      return parambdpi;
      if (((paramChatMessage instanceof MessageForLongMsg)) && (!((MessageForLongMsg)paramChatMessage).canSelectable())) {
        i = 0;
      } else {
        label184:
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwa
 * JD-Core Version:    0.7.0.1
 */