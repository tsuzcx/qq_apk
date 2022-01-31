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

public class afrl
  extends BaseBubbleBuilder
  implements aels, aenl
{
  private aeou jdField_a_of_type_Aeou = new aeou();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private beiq jdField_a_of_type_Beiq = new afrn(this);
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private View.OnClickListener b;
  protected long c;
  
  public afrl(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new afrm(this);
    this.jdField_a_of_type_Aeou.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new axiu(this);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder1, SpannableStringBuilder paramSpannableStringBuilder2, List<MessageRecord> paramList)
  {
    if (paramSpannableStringBuilder1.length() > 0)
    {
      MessageRecord localMessageRecord = ayvw.a(-1000);
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
    aeyb.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 2);
    Object localObject;
    int i;
    if (ajsx.a().c())
    {
      localObject = ajsx.a().a();
      if (localObject != null) {
        if (((CharSequence)localObject).length() != ajsx.a().a())
        {
          i = 1;
          if (i != 0) {
            break label224;
          }
          localObject = ajsx.a().b();
        }
      }
    }
    label65:
    label224:
    for (;;)
    {
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText((CharSequence)localObject);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
      if (i != 0) {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramChatMessage.isMultiMsg) {
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D65", "0X8009D65", 3, 0, "3", "", "", "");
        }
        return;
        i = 0;
        break;
        i = 0;
        break;
        localObject = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
        i = 1;
        break label65;
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
      }
    }
  }
  
  private void a(ArrayList<bchd> paramArrayList, ArrayList<TextView> paramArrayList1, MessageRecord paramMessageRecord)
  {
    if (!bchc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
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
        localObject2 = (bchd)paramArrayList.get(i);
        if ((localObject2 == null) || (((bchd)localObject2).jdField_b_of_type_Int == -1))
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
          localStringBuilder.append(((bchd)localObject2).b());
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
      localTextView.setTag(2131366463, "school_troop_span");
      k = j;
      localObject2 = localObject1;
      break label138;
      if (((bchd)localObject2).jdField_b_of_type_Int < localObject1.jdField_b_of_type_Int)
      {
        localObject1 = localObject2;
        j = i;
        continue;
        if (localObject1 != null)
        {
          localObject2 = new bchd();
          ((bchd)localObject2).jdField_a_of_type_Long = paramMessageRecord.uniseq;
          ((bchd)localObject2).jdField_a_of_type_Int = localObject1.jdField_a_of_type_Int;
          ((bchd)localObject2).jdField_a_of_type_JavaLangString = localObject1.jdField_a_of_type_JavaLangString;
          ((bchd)localObject2).jdField_b_of_type_JavaLangString = localObject1.jdField_b_of_type_JavaLangString;
          ((bchd)localObject2).jdField_b_of_type_Int = localObject1.jdField_b_of_type_Int;
          ((bchd)localObject2).a(localStringBuilder.toString());
          ((bchd)localObject2).c = localObject1.c;
          ((bchd)localObject2).d = localObject1.d;
          ((Spannable)((TextView)paramArrayList1.get(j)).getText()).setSpan(new bche(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (bchd)localObject2), ((bchd)localObject2).c, ((bchd)localObject2).d, 17);
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
  
  private boolean a(afrp paramafrp)
  {
    return (paramafrp.jdField_b_of_type_AndroidWidgetTextView != null) && (paramafrp.jdField_a_of_type_AndroidWidgetTextView != null) && (paramafrp.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (paramafrp.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null);
  }
  
  private void b(ChatMessage paramChatMessage, String paramString)
  {
    aeyb.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 3);
    Object localObject1;
    int i;
    if (ajsx.a().c())
    {
      localObject1 = ajsx.a().a();
      if (localObject1 != null) {
        if (((String)localObject1).length() == ajsx.a().a())
        {
          i = 1;
          if (i != 0) {
            break label556;
          }
          localObject1 = ajsx.a().b();
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
        localObject2 = bdiv.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
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
            ((auat)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a.put(Long.valueOf(paramChatMessage.uniseq), paramChatMessage);
            localBundle.putString("forward_text", (String)localObject1);
            localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
            localObject1 = new Intent();
            ((Intent)localObject1).putExtras(localBundle);
            arum.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, 21);
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005637", "0X8005637", 0, 0, "", "", "", "");
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
            if (i == 0) {
              break label527;
            }
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
            if (paramChatMessage.isMultiMsg) {
              azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 9, 0, "9", "", "", "");
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
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      }
    }
  }
  
  private void c(ChatMessage paramChatMessage, String paramString)
  {
    aeyb.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 4);
    String str;
    int i;
    if (ajsx.a().c())
    {
      str = ajsx.a().a();
      if (str != null) {
        if (str.length() == ajsx.a().a())
        {
          i = 1;
          if (i != 0) {
            break label290;
          }
          str = ajsx.a().b();
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
        biqt.b(paramChatMessage).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, 0, paramChatMessage.istroop);
        label115:
        birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
        if (i == 0) {
          break label261;
        }
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAC", 4, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramChatMessage.isMultiMsg) {
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 9, 0, "9", "", "", "");
        }
        return;
        i = 0;
        break;
        i = 0;
        break;
        str = null;
        i = 1;
        break label63;
        birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramChatMessage.istroop);
        biqt.a(null, str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        break label115;
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 4, 0, "", "", "", "");
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public aels a(View paramView)
  {
    if (a(paramView)) {
      return this;
    }
    return null;
  }
  
  public aelt a()
  {
    return new afrp(this);
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    afrp localafrp = (afrp)paramaelt;
    if (paramaelt.b == null) {
      paramaelt.b = new StringBuilder();
    }
    Object localObject1 = (bckx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    if (QLog.isColorLevel()) {
      QLog.i("MixedMsgItemBuilder", 1, "getBubbleView: check is need refresh[" + localafrp.jdField_a_of_type_Boolean + "]");
    }
    if ((!e) && (afrp.a(localafrp) != null) && (afrp.a(localafrp) == paramChatMessage.uniseq) && (!localafrp.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info"))))
    {
      if (((bckx)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage))
      {
        localafrp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return paramView;
      }
      localafrp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return paramView;
    }
    Object localObject2;
    Object localObject3;
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      paramBaseChatItemLayout = (MessageForMixedMsg)paramChatMessage;
      if (e)
      {
        if (bdec.a(paramChatMessage.issend)) {
          paramaelt.b.append("发出");
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
            paramaelt.b.append("图片");
          }
          localObject3 = (MessageForPic)localObject3;
          if (((MessageForPic)localObject3).time != 0L) {
            continue;
          }
          MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject3, paramBaseChatItemLayout);
          continue;
          paramaelt.b.append("发来");
          break;
        }
        if ((localObject3 instanceof MessageForReplyText))
        {
          if (((MessageForReplyText)localObject3).time == 0L) {
            MessageForMixedMsg.copyBaseInfoFromMixedToNormal((MessageRecord)localObject3, paramBaseChatItemLayout);
          }
        }
        else if (e) {
          paramaelt.b.append(baiy.b(((MessageRecord)localObject3).msg));
        }
      }
      label379:
      paramBaseChatItemLayout = a(paramaelt, (MixedMsgLinearLayout)paramView, paramBaseChatItemLayout.msgElemList, paramaeov, paramBaseChatItemLayout);
      afrp.a((afrp)paramaelt, paramChatMessage.uniseq);
      if (((bckx)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
        localafrp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      }
    }
    for (;;)
    {
      paramaelt = aenj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramaelt != null) {
        paramaelt.a(paramBaseChatItemLayout, this);
      }
      if (paramBaseChatItemLayout != null) {
        paramBaseChatItemLayout.setTag(localafrp);
      }
      paramView = paramBaseChatItemLayout;
      if (localafrp.jdField_a_of_type_Ajta == null) {
        break;
      }
      localafrp.jdField_a_of_type_Ajta.b(paramChatMessage);
      return paramBaseChatItemLayout;
      localafrp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      continue;
      paramBaseChatItemLayout = paramView;
      if ((paramChatMessage instanceof MessageForLongMsg))
      {
        localObject3 = (MessageForLongMsg)paramChatMessage;
        if (e) {
          paramaelt.b.append("说");
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
            paramView = a(paramaelt, (MixedMsgLinearLayout)paramView, (List)localObject2, paramaeov, paramChatMessage);
            afrp.a((afrp)paramaelt, paramChatMessage.uniseq);
            paramBaseChatItemLayout = paramView;
            if (e)
            {
              paramaelt.b.append(baiy.e(((SpannableStringBuilder)localObject1).toString()));
              paramBaseChatItemLayout = paramView;
            }
          }
        }
      }
    }
  }
  
  public bdkz a(bdkz parambdkz, ChatMessage paramChatMessage, aemk paramaemk)
  {
    int i = 0;
    parambdkz.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691289));
    if ((paramChatMessage instanceof MessageForMixedMsg)) {
      if (((MessageForMixedMsg)paramChatMessage).canSelectable()) {
        break label126;
      }
    }
    for (;;)
    {
      if (i != 0) {
        parambdkz.a(2131364910, this.jdField_a_of_type_AndroidContentContext.getString(2131719134), 2130838670);
      }
      parambdkz.a(2131366750, this.jdField_a_of_type_AndroidContentContext.getString(2131692835), 2130838677);
      if (aekt.a(5) == 1) {
        parambdkz.a(2131366015, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838676);
      }
      return parambdkz;
      if ((!(paramChatMessage instanceof MessageForLongMsg)) || (((MessageForLongMsg)paramChatMessage).canSelectable())) {
        label126:
        i = 1;
      }
    }
  }
  
  public MixedMsgLinearLayout a(aelt paramaelt, MixedMsgLinearLayout paramMixedMsgLinearLayout, List<MessageRecord> paramList, aeov paramaeov, MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList1 = new ArrayList(paramList);
    paramList = paramMixedMsgLinearLayout;
    if (paramMixedMsgLinearLayout == null)
    {
      paramList = new MixedMsgLinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramList.setId(2131364171);
      paramList.setOrientation(1);
      paramList.setFocusable(false);
      paramList.setClickable(true);
      paramList.setMinimumHeight(aekt.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramList.setPadding(2131296294, 2131296296, 2131296293, 2131296295);
      paramMixedMsgLinearLayout = new RelativeLayout.LayoutParams(-2, -2);
      paramMixedMsgLinearLayout.addRule(1, 2131367808);
      paramMixedMsgLinearLayout.addRule(3, 2131377567);
      paramMixedMsgLinearLayout.leftMargin = aekt.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramMixedMsgLinearLayout.rightMargin = aekt.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramList.setLayoutParams(paramMixedMsgLinearLayout);
      paramList.jdField_a_of_type_Beiq = this.jdField_a_of_type_Beiq;
      afrp.a((afrp)paramaelt, paramList);
      ((afrp)paramaelt).jdField_a_of_type_Ajta = new ajta();
      ((afrp)paramaelt).jdField_a_of_type_Ajta.a(paramList);
      ((afrp)paramaelt).jdField_a_of_type_Ajta.a(paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
    }
    ((afrp)paramaelt).e = -1;
    ((afrp)paramaelt).jdField_a_of_type_Boolean = false;
    paramList.a(localArrayList1, (afrp)paramaelt);
    if (bchc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {}
    for (paramMixedMsgLinearLayout = (bchc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262);; paramMixedMsgLinearLayout = null)
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
              ((ViewGroup)localObject2).setId(2131364199);
              ((ViewGroup)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).setOnTouchListener(paramaeov);
              ((ViewGroup)localObject2).setOnLongClickListener(paramaeov);
              ((ViewGroup)localObject2).findViewById(2131370758).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).findViewById(2131368816).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).findViewById(2131377773).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
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
              afus.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ViewGroup)localObject2, ((MessageForReplyText)localObject3).mSourceMsgInfo, this.jdField_a_of_type_Aeou.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((MessageForReplyText)localObject3).istroop, (MessageRecord)localObject1, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
              localObject1 = ((ViewGroup)localObject2).findViewById(2131377773);
              if (localObject1 == null) {
                break label1238;
              }
              localObject1 = ((View)localObject1).getTag(2131364186);
              if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
                break label1238;
              }
              bool = ((Boolean)localObject1).booleanValue();
              ((afrp)paramaelt).jdField_a_of_type_Boolean = bool;
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
          localView.setOnTouchListener(paramaeov);
          localView.setOnLongClickListener(paramaeov);
          break;
          label761:
          ((TextView)localObject4).setVisibility(8);
          break label537;
          if ((localObject1 instanceof MessageForText))
          {
            localObject2 = (AnimationTextView)localView;
            ((AnimationTextView)localObject2).setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
            baiy.a((TextView)localObject2);
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
              if (!bckx.b(paramMessageRecord)) {
                break;
              }
              bckx.a((TextView)localObject2, (MessageRecord)localObject1);
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
            localObject4 = afsf.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localObject1, (ChatThumbView)localObject2, (int[])localObject3);
            ((ChatThumbView)localObject2).setTag(2131364185, localObject1);
            ((ChatThumbView)localObject2).setImageDrawable((Drawable)localObject4);
            String str = ((URLDrawable)localObject4).getURL().getProtocol();
            URL localURL = baul.a((awfj)localObject1, 65537);
            if (afsf.a(this.jdField_a_of_type_AndroidContentContext, bilx.a(((MessageForPic)localObject1).imageType), str.equals("chatthumb"), localObject3[0], localObject3[1], localURL))
            {
              ((URLDrawable)localObject4).setWatermarkDrawable(afsf.a(), aekt.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
        paramList.setOnTouchListener(paramaeov);
        paramList.setOnLongClickListener(paramaeov);
        paramList.b = this.jdField_a_of_type_Beiq;
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
    acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 6, 0, "", "", "", "");
    return;
    super.d(paramChatMessage);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 7, 0, "", "", "", "");
    return;
    a(paramChatMessage, str1);
    return;
    b(paramChatMessage, str1);
    return;
    c(paramChatMessage, str1);
    return;
    super.a(paramChatMessage);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 5, 0, "", "", "", "");
    return;
    ajsx.a().a(paramChatMessage);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 2, 0, "", "", "", "");
    return;
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 3, 0, "", "", "", "");
    b(paramChatMessage);
  }
  
  public void a(aelt paramaelt, View paramView, ChatMessage paramChatMessage, ansf paramansf)
  {
    afrp localafrp = (afrp)paramaelt;
    if ((localafrp.e != -1) && (a(localafrp)))
    {
      localafrp.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      if ((paramansf.jdField_a_of_type_Int == 0) || (!paramansf.a()) || (azib.b()))
      {
        paramView = paramView.getResources();
        if (paramChatMessage.isSend())
        {
          paramaelt = paramView.getColorStateList(2131166923);
          localafrp.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaelt);
          localafrp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaelt);
          localafrp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaelt);
          localafrp.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaelt);
          if (!paramChatMessage.isSend()) {
            break label206;
          }
        }
        label206:
        for (paramaelt = paramView.getColorStateList(2131166922);; paramaelt = paramView.getColorStateList(2131166921))
        {
          localafrp.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramaelt);
          localafrp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaelt);
          localafrp.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaelt);
          ImmersiveUtils.a(localafrp.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
          ImmersiveUtils.a(localafrp.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
          ImmersiveUtils.a(localafrp.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
          return;
          paramaelt = paramView.getColorStateList(2131166919);
          break;
        }
      }
      if (paramansf.jdField_b_of_type_Int == 0)
      {
        localafrp.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localafrp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localafrp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        localafrp.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        if (paramansf.c != 0) {
          break label404;
        }
        paramaelt = paramView.getResources().getColorStateList(2131166921);
        localafrp.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramaelt);
        localafrp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaelt);
        localafrp.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaelt);
      }
      for (;;)
      {
        ImmersiveUtils.a(localafrp.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
        ImmersiveUtils.a(localafrp.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        ImmersiveUtils.a(localafrp.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        return;
        localafrp.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramansf.jdField_b_of_type_Int);
        localafrp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramansf.jdField_b_of_type_Int);
        localafrp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramansf.jdField_b_of_type_Int);
        localafrp.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramansf.jdField_b_of_type_Int);
        break;
        label404:
        localafrp.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramansf.c);
        localafrp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramansf.c);
        localafrp.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramansf.c);
      }
    }
    if ((paramansf.jdField_a_of_type_Int == 0) || (!paramansf.a()) || (azib.b()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramaelt = paramView.getColorStateList(2131166923);
        if (!paramChatMessage.isSend()) {
          break label525;
        }
      }
      label525:
      for (paramView = paramView.getColorStateList(2131166922);; paramView = paramView.getColorStateList(2131166921))
      {
        afrp.a(localafrp).a(paramaelt, paramView);
        return;
        paramaelt = paramView.getColorStateList(2131166919);
        break;
      }
    }
    paramaelt = ColorStateList.valueOf(-16777216);
    paramView = paramView.getResources().getColorStateList(2131166921);
    if (paramansf.jdField_b_of_type_Int != 0) {
      paramaelt = ColorStateList.valueOf(paramansf.jdField_b_of_type_Int);
    }
    if (paramansf.c != 0) {
      paramView = ColorStateList.valueOf(paramansf.c);
    }
    afrp.a(localafrp).a(paramaelt, paramView);
  }
  
  public void a(aelt paramaelt, ChatMessage paramChatMessage)
  {
    paramaelt = (afrp)paramaelt;
    if (afrp.a(paramaelt) != null) {
      afrp.a(paramaelt).a(gj.a(paramChatMessage));
    }
    if ((paramaelt.e != -1) && (a(paramaelt)))
    {
      paramChatMessage = gj.a("");
      paramaelt.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
      paramaelt.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
      paramaelt.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
      paramaelt.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
    }
  }
  
  public void a(View paramView)
  {
    paramView = (afrp)aekt.a(paramView);
    if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
    {
      paramView = (MessageForMixedMsg)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        bhpy localbhpy = (bhpy)bhql.a(this.jdField_a_of_type_AndroidContentContext, null);
        localbhpy.a(2131690042, 5);
        localbhpy.c(2131690648);
        localbhpy.a(new afro(this, paramView, localbhpy));
        localbhpy.show();
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
  
  public void a(View paramView, baoj parambaoj, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2003) {}
    label68:
    label585:
    label593:
    for (;;)
    {
      return;
      Object localObject1 = (afrp)aekt.a(paramView);
      paramView = null;
      Object localObject2;
      if ((((afrp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
      {
        paramView = (MessageForMixedMsg)((afrp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if ((afrp.a((afrp)localObject1) != null) && (paramView != null) && (paramView.msgElemList != null)) {
          for (paramView = paramView.msgElemList.iterator(); paramView.hasNext(); paramView = (MessageForPic)localObject2)
          {
            localObject2 = (MessageRecord)paramView.next();
            if ((localObject2 == null) || (((MessageRecord)localObject2).uniseq != parambaoj.b) || (!(localObject2 instanceof MessageForPic)) || (((MessageForPic)localObject2).subMsgId != parambaoj.c)) {
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
          paramInt2 = afrp.a((afrp)localObject1).getChildCount();
          paramInt1 = 0;
          label232:
          Object localObject3;
          Object localObject4;
          if (paramInt1 < paramInt2)
          {
            parambaoj = afrp.a((afrp)localObject1).getChildAt(paramInt1);
            if ((parambaoj instanceof ChatThumbView))
            {
              localObject2 = ((ChatThumbView)parambaoj).getTag(2131364185);
              if (((localObject2 instanceof MessageForPic)) && (((MessageForPic)localObject2).uniseq == paramView.uniseq) && (((MessageForPic)localObject2).subMsgId == paramView.subMsgId))
              {
                parambaoj = (ChatThumbView)parambaoj;
                if (parambaoj == null) {
                  break label577;
                }
                localObject1 = new int[2];
                tmp243_241 = localObject1;
                tmp243_241[0] = 0;
                tmp247_243 = tmp243_241;
                tmp247_243[1] = 0;
                tmp247_243;
                localObject2 = afsf.a(this.jdField_a_of_type_AndroidContentContext, paramView, parambaoj, (int[])localObject1);
                localObject3 = ((URLDrawable)localObject2).getURL().getProtocol();
                localObject4 = baul.a(paramView, 65537);
                boolean bool = afsf.a(this.jdField_a_of_type_AndroidContentContext, bilx.a(paramView.imageType), ((String)localObject3).equals("chatthumb"), localObject1[0], localObject1[1], (URL)localObject4);
                parambaoj.setImageDrawable((Drawable)localObject2);
                if (!bool) {
                  break label567;
                }
                ((URLDrawable)localObject2).setWatermarkDrawable(afsf.a(), aekt.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                ((URLDrawable)localObject2).setWatermarkVisibility(0);
                return;
                if (!(((afrp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForLongMsg)) {
                  break label585;
                }
                localObject2 = (MessageForLongMsg)((afrp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
                if (((MessageRecord)localObject3).uniseq != parambaoj.b) {
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
                  if (((localObject4 instanceof MessageForPic)) && (((MessageForPic)localObject4).subMsgId == parambaoj.c))
                  {
                    paramView = (MessageForPic)localObject4;
                    break label478;
                    paramInt1 += 1;
                    break label153;
                    ((URLDrawable)localObject2).setWatermarkVisibility(4);
                    return;
                    parambaoj = null;
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
    paramView = (afrp)paramView.getTag();
    int i = BaseChatItemLayout.g;
    if (paramChatMessage.isSend())
    {
      afrp.a(paramView).setPadding(afyl.f, i, afyl.e, afyl.d);
      return;
    }
    afrp.a(paramView).setPadding(afyl.e, i, afyl.f, afyl.d);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Object localObject = (afrp)aekt.a(paramView);
    if ((!paramBoolean) && ((paramView instanceof ChatThumbView))) {
      ((ChatThumbView)paramView).a(paramView, true);
    }
    localObject = afrp.a((afrp)localObject).getBackground();
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
  
  public bdlb[] a(View paramView)
  {
    paramView = (afrp)aekt.a(paramView);
    ChatMessage localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    bdkz localbdkz = new bdkz();
    if (localChatMessage != null)
    {
      if (!localChatMessage.isMultiMsg) {
        break label45;
      }
      a(localbdkz, localChatMessage, null);
    }
    for (;;)
    {
      return localbdkz.a();
      label45:
      b(localbdkz, localChatMessage, paramView);
    }
  }
  
  public bdkz b(bdkz parambdkz, ChatMessage paramChatMessage, aemk paramaemk)
  {
    parambdkz.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691289));
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
        parambdkz.a(2131364910, this.jdField_a_of_type_AndroidContentContext.getString(2131719134), 2130838670);
      }
      parambdkz.a(2131366750, this.jdField_a_of_type_AndroidContentContext.getString(2131692835), 2130838677);
      a(paramChatMessage, parambdkz);
      a(parambdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramaemk.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      a(parambdkz, paramChatMessage);
      if (aekt.a(5) == 1) {
        parambdkz.a(2131366015, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838676);
      }
      b(paramChatMessage, parambdkz);
      super.c(parambdkz, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambdkz, this.jdField_a_of_type_AndroidContentContext);
      return parambdkz;
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
 * Qualified Name:     afrl
 * JD-Core Version:    0.7.0.1
 */