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
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ahmm
  extends BaseBubbleBuilder
  implements aggk, agif
{
  private agjj jdField_a_of_type_Agjj = new agjj();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private biuy jdField_a_of_type_Biuy = new ahmo(this);
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private View.OnClickListener b;
  protected long c;
  
  public ahmm(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ahmn(this);
    this.jdField_a_of_type_Agjj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bbdl(this);
  }
  
  private MessageRecord a(SpannableStringBuilder paramSpannableStringBuilder1, SpannableStringBuilder paramSpannableStringBuilder2)
  {
    MessageForText localMessageForText = (MessageForText)bcry.a(-1000);
    if (paramSpannableStringBuilder1.length() > 0)
    {
      localMessageForText.sb = new SpannableStringBuilder(paramSpannableStringBuilder1);
      paramSpannableStringBuilder1.clear();
    }
    if (paramSpannableStringBuilder2.length() > 0)
    {
      localMessageForText.sb2 = new SpannableStringBuilder(paramSpannableStringBuilder2);
      paramSpannableStringBuilder2.clear();
    }
    return localMessageForText;
  }
  
  private CharSequence a(MessageRecord paramMessageRecord, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {}
    String str;
    int i;
    label74:
    do
    {
      return paramCharSequence;
      if ((paramCharSequence instanceof begp)) {}
      for (str = ((begp)paramCharSequence).d;; str = paramCharSequence.toString())
      {
        i = ChatTextSizeSettingActivity.a();
        if (!paramBoolean) {
          break label74;
        }
        if (!str.startsWith("\n")) {
          break;
        }
        return new begp(str.substring(1), 13, i, paramMessageRecord);
      }
    } while (!str.endsWith("\n"));
    return new begp(str.substring(0, str.length() - 1), 13, i, paramMessageRecord);
  }
  
  private HashMap<Integer, CharSequence> a(List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgItemBuilder", 2, "formatTextMessRecordNewLineSymbol, size:" + paramList.size());
    }
    HashMap localHashMap = new HashMap(paramList.size());
    int i = 0;
    if (i < paramList.size())
    {
      if ((paramList.get(i) instanceof MessageForReplyText)) {
        localHashMap.put(Integer.valueOf(i), ((MessageForReplyText)paramList.get(i)).sb);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramList.get(i) instanceof MessageForText))
        {
          localObject1 = (MessageForText)paramList.get(i);
          if (!TextUtils.isEmpty(((MessageForText)localObject1).sb2)) {
            localHashMap.put(Integer.valueOf(i), ((MessageForText)localObject1).sb2);
          } else {
            localHashMap.put(Integer.valueOf(i), ((MessageForText)localObject1).sb);
          }
        }
        else
        {
          localHashMap.put(Integer.valueOf(i), "");
        }
      }
    }
    Object localObject1 = new ArrayList();
    i = 0;
    while (i < paramList.size())
    {
      if ((paramList.get(i) instanceof MessageForPic)) {
        ((List)localObject1).add(Integer.valueOf(i));
      }
      i += 1;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Integer)((Iterator)localObject1).next();
      i = ((Integer)localObject2).intValue() - 1;
      int j = ((Integer)localObject2).intValue() + 1;
      if ((i >= 0) && (i < localHashMap.size()))
      {
        localObject2 = (CharSequence)localHashMap.get(Integer.valueOf(i));
        localHashMap.put(Integer.valueOf(i), a((MessageRecord)paramList.get(i), (CharSequence)localObject2, false));
      }
      if ((j >= 0) && (j < localHashMap.size()))
      {
        localObject2 = (CharSequence)localHashMap.get(Integer.valueOf(j));
        localHashMap.put(Integer.valueOf(j), a((MessageRecord)paramList.get(j), (CharSequence)localObject2, true));
      }
    }
    return localHashMap;
  }
  
  private List<MessageRecord> a(List<MessageRecord> paramList, aggl paramaggl)
  {
    SpannableStringBuilder localSpannableStringBuilder1 = new SpannableStringBuilder();
    SpannableStringBuilder localSpannableStringBuilder2 = new SpannableStringBuilder();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (MessageRecord)paramList.next();
      if ((localObject instanceof MessageForText))
      {
        if (!TextUtils.isEmpty(((MessageForText)localObject).sb)) {
          localSpannableStringBuilder1.append(((MessageForText)localObject).sb);
        }
        if (!TextUtils.isEmpty(((MessageForText)localObject).sb2)) {
          localSpannableStringBuilder2.append(((MessageForText)localObject).sb2);
        } else if (!TextUtils.isEmpty(((MessageForText)localObject).sb)) {
          localSpannableStringBuilder2.append(((MessageForText)localObject).sb);
        }
      }
      else if ((localObject instanceof MessageForPic))
      {
        localArrayList.add(a(localSpannableStringBuilder1, localSpannableStringBuilder2));
        localArrayList.add(localObject);
      }
      else if ((localObject instanceof MessageForMixedMsg))
      {
        localObject = (MessageForMixedMsg)localObject;
        Iterator localIterator = ((MessageForMixedMsg)localObject).msgElemList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if ((localMessageRecord instanceof MessageForPic))
          {
            if (((MessageForPic)localMessageRecord).time == 0L) {
              MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, (MessageForMixedMsg)localObject);
            }
            localArrayList.add(a(localSpannableStringBuilder1, localSpannableStringBuilder2));
            localArrayList.add(localMessageRecord);
          }
          else if ((localMessageRecord instanceof MessageForText))
          {
            if (!TextUtils.isEmpty(((MessageForText)localMessageRecord).sb)) {
              localSpannableStringBuilder1.append(((MessageForText)localMessageRecord).sb);
            }
            if (!TextUtils.isEmpty(((MessageForText)localMessageRecord).sb2)) {
              localSpannableStringBuilder2.append(((MessageForText)localMessageRecord).sb2);
            } else if (!TextUtils.isEmpty(((MessageForText)localMessageRecord).sb)) {
              localSpannableStringBuilder2.append(((MessageForText)localMessageRecord).sb);
            }
          }
          else
          {
            localArrayList.add(localMessageRecord);
          }
        }
      }
      else if ((localObject instanceof MessageForReplyText))
      {
        if (!TextUtils.isEmpty(((MessageForReplyText)localObject).sb))
        {
          localSpannableStringBuilder1.append(((MessageForReplyText)localObject).sb);
          localSpannableStringBuilder2.append(((MessageForReplyText)localObject).sb);
        }
        localArrayList.add(localObject);
      }
    }
    localArrayList.add(a(localSpannableStringBuilder1, localSpannableStringBuilder2));
    a(paramaggl, behh.e(localSpannableStringBuilder1.toString()));
    return localArrayList;
  }
  
  private void a(aggl paramaggl, String paramString)
  {
    if (paramaggl.jdField_b_of_type_JavaLangStringBuilder == null) {
      paramaggl.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    if (e) {
      paramaggl.jdField_b_of_type_JavaLangStringBuilder.append(paramString);
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
    agsd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 2);
    Object localObject;
    int i;
    if (ambu.a().c())
    {
      localObject = ambu.a().b();
      if (localObject != null) {
        if (((CharSequence)localObject).length() != ambu.a().a())
        {
          i = 1;
          if (i != 0) {
            break label234;
          }
          localObject = ambu.a().c();
        }
      }
    }
    label61:
    label234:
    for (;;)
    {
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText((CharSequence)localObject);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
      if (i != 0) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramChatMessage.isMultiMsg) {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D65", "0X8009D65", 3, 0, "3", "", "", "");
        }
        return;
        i = 0;
        break;
        i = 0;
        break;
        localObject = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
        i = 1;
        break label61;
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
      }
    }
  }
  
  private void a(ArrayList<bgqe> paramArrayList, ArrayList<TextView> paramArrayList1, MessageRecord paramMessageRecord)
  {
    if (!bgqd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
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
        localObject2 = (bgqe)paramArrayList.get(i);
        if ((localObject2 == null) || (((bgqe)localObject2).jdField_b_of_type_Int == -1))
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
          label139:
          i += 1;
          j = k;
          localObject1 = localObject2;
        }
        else
        {
          localStringBuilder.append(((bgqe)localObject2).b());
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
      localTextView.setTag(2131366785, "school_troop_span");
      k = j;
      localObject2 = localObject1;
      break label139;
      if (((bgqe)localObject2).jdField_b_of_type_Int < localObject1.jdField_b_of_type_Int)
      {
        localObject1 = localObject2;
        j = i;
        continue;
        if (localObject1 != null)
        {
          localObject2 = new bgqe();
          ((bgqe)localObject2).jdField_a_of_type_Long = paramMessageRecord.uniseq;
          ((bgqe)localObject2).jdField_a_of_type_Int = localObject1.jdField_a_of_type_Int;
          ((bgqe)localObject2).jdField_a_of_type_JavaLangString = localObject1.jdField_a_of_type_JavaLangString;
          ((bgqe)localObject2).jdField_b_of_type_JavaLangString = localObject1.jdField_b_of_type_JavaLangString;
          ((bgqe)localObject2).jdField_b_of_type_Int = localObject1.jdField_b_of_type_Int;
          ((bgqe)localObject2).a(localStringBuilder.toString());
          ((bgqe)localObject2).c = localObject1.c;
          ((bgqe)localObject2).d = localObject1.d;
          ((Spannable)((TextView)paramArrayList1.get(j)).getText()).setSpan(new bgqf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (bgqe)localObject2), ((bgqe)localObject2).c, ((bgqe)localObject2).d, 17);
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
  
  private boolean a(ahmq paramahmq)
  {
    return (paramahmq.jdField_b_of_type_AndroidWidgetTextView != null) && (paramahmq.jdField_a_of_type_AndroidWidgetTextView != null) && (paramahmq.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (paramahmq.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null);
  }
  
  private void b(ChatMessage paramChatMessage, String paramString)
  {
    agsd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 3);
    Object localObject1;
    int i;
    if (ambu.a().c())
    {
      localObject1 = ambu.a().b();
      if (localObject1 != null) {
        if (((String)localObject1).length() == ambu.a().a())
        {
          i = 1;
          if (i != 0) {
            break label559;
          }
          localObject1 = ambu.a().c();
        }
      }
    }
    label515:
    label527:
    label559:
    for (;;)
    {
      label59:
      Bundle localBundle = new Bundle();
      Object localObject2;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext() != null))
      {
        localObject2 = bhsi.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
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
            ((axey)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a.put(Long.valueOf(paramChatMessage.uniseq), paramChatMessage);
            localBundle.putString("forward_text", (String)localObject1);
            localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
            localObject1 = new Intent();
            ((Intent)localObject1).putExtras(localBundle);
            auxu.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, 21);
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005637", "0X8005637", 0, 0, "", "", "", "");
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
            if (i == 0) {
              break label527;
            }
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
            if (paramChatMessage.isMultiMsg) {
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 9, 0, "9", "", "", "");
            }
            return;
            i = 0;
            break;
            i = 0;
            break;
            localObject1 = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString();
            i = 1;
            break label59;
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
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      }
    }
  }
  
  private void c(ChatMessage paramChatMessage, String paramString)
  {
    agsd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 4);
    String str;
    int i;
    if (ambu.a().c())
    {
      str = ambu.a().b();
      if (str != null) {
        if (str.length() == ambu.a().a())
        {
          i = 1;
          if (i != 0) {
            break label293;
          }
          str = ambu.a().c();
        }
      }
    }
    label261:
    label293:
    for (;;)
    {
      label59:
      if ((i != 0) || (str == null))
      {
        bmko.b(paramChatMessage).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, 0, paramChatMessage.istroop);
        label111:
        bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
        if (i == 0) {
          break label261;
        }
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAC", 4, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramChatMessage.isMultiMsg) {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 9, 0, "9", "", "", "");
        }
        return;
        i = 0;
        break;
        i = 0;
        break;
        str = null;
        i = 1;
        break label59;
        bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramChatMessage.istroop);
        bmko.a(null, str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        break label111;
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 4, 0, "", "", "", "");
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public aggk a(View paramView)
  {
    if (a(paramView)) {
      return this;
    }
    return null;
  }
  
  public aggl a()
  {
    return new ahmq(this);
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    ahmq localahmq = (ahmq)paramaggl;
    if (localahmq.jdField_b_of_type_JavaLangStringBuilder == null) {
      localahmq.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    Object localObject2 = (bgty)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    if (QLog.isColorLevel()) {
      QLog.i("MixedMsgItemBuilder", 1, "getBubbleView: check is need refresh[" + localahmq.jdField_a_of_type_Boolean + "]");
    }
    if ((!e) && (ahmq.a(localahmq) != null) && (ahmq.a(localahmq) == paramChatMessage.uniseq) && (!localahmq.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info"))))
    {
      if (((bgty)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
        localahmq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      }
      for (;;)
      {
        paramaggl = paramView;
        if (localahmq != null)
        {
          paramaggl = paramView;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            localahmq.c = super.a(localahmq.c, localahmq, paramBaseChatItemLayout, paramChatMessage, -2, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
            super.a(localahmq.c, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
            paramaggl = paramView;
          }
        }
        return paramaggl;
        localahmq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      }
    }
    Object localObject1;
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      Iterator localIterator;
      if (bhnt.a(paramChatMessage.issend))
      {
        localObject1 = "发出";
        a(paramaggl, (String)localObject1);
        localObject1 = (MessageForMixedMsg)paramChatMessage;
        localIterator = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label416;
        }
        Object localObject3 = (MessageRecord)localIterator.next();
        if ((localObject3 instanceof MessageForPic))
        {
          a(paramaggl, "图片");
          localObject3 = (MessageForPic)localObject3;
          if (((MessageForPic)localObject3).time != 0L) {
            continue;
          }
          MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject3, (MessageForMixedMsg)localObject1);
          continue;
          localObject1 = "发来";
          break;
        }
        if ((localObject3 instanceof MessageForReplyText))
        {
          if (((MessageForReplyText)localObject3).time == 0L) {
            MessageForMixedMsg.copyBaseInfoFromMixedToNormal((MessageRecord)localObject3, (MessageForMixedMsg)localObject1);
          }
        }
        else {
          a(paramaggl, behh.b(((MessageRecord)localObject3).msg));
        }
      }
      label416:
      localObject1 = a(paramaggl, (MixedMsgLinearLayout)paramView, ((MessageForMixedMsg)localObject1).msgElemList, paramagjk, (MessageRecord)localObject1);
      ahmq.a(localahmq, paramChatMessage.uniseq);
      localahmq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(((bgty)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    for (;;)
    {
      paramaggl = agid.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramaggl != null) {
        paramaggl.a((View)localObject1, this);
      }
      if (localObject1 != null) {
        ((View)localObject1).setTag(localahmq);
      }
      if (localahmq.jdField_a_of_type_Ambx != null) {
        localahmq.jdField_a_of_type_Ambx.b(paramChatMessage);
      }
      paramaggl = (aggl)localObject1;
      if (localahmq == null) {
        break;
      }
      paramaggl = (aggl)localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
      localahmq.c = super.a(localahmq.c, localahmq, paramBaseChatItemLayout, paramChatMessage, -2, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
      super.a(localahmq.c, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
      return localObject1;
      localObject1 = paramView;
      if ((paramChatMessage instanceof MessageForLongMsg))
      {
        localObject2 = (MessageForLongMsg)paramChatMessage;
        a(paramaggl, "说");
        localObject1 = paramView;
        if (((MessageForLongMsg)localObject2).longMsgFragmentList != null)
        {
          localObject1 = paramView;
          if (!((MessageForLongMsg)localObject2).longMsgFragmentList.isEmpty())
          {
            localObject1 = a(((MessageForLongMsg)localObject2).longMsgFragmentList, localahmq);
            localObject1 = a(paramaggl, (MixedMsgLinearLayout)paramView, (List)localObject1, paramagjk, paramChatMessage);
            ahmq.a(localahmq, paramChatMessage.uniseq);
          }
        }
      }
    }
  }
  
  public bhuk a(bhuk parambhuk, ChatMessage paramChatMessage, aghd paramaghd)
  {
    int i = 0;
    parambhuk.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691093));
    if ((paramChatMessage instanceof MessageForMixedMsg)) {
      if (((MessageForMixedMsg)paramChatMessage).canSelectable()) {
        break label126;
      }
    }
    for (;;)
    {
      if (i != 0) {
        parambhuk.a(2131365191, this.jdField_a_of_type_AndroidContentContext.getString(2131717397), 2130838932);
      }
      parambhuk.a(2131367078, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838939);
      if (agej.a(5) == 1) {
        parambhuk.a(2131366320, this.jdField_a_of_type_AndroidContentContext.getString(2131691990), 2130838938);
      }
      return parambhuk;
      if ((!(paramChatMessage instanceof MessageForLongMsg)) || (((MessageForLongMsg)paramChatMessage).canSelectable())) {
        label126:
        i = 1;
      }
    }
  }
  
  public MixedMsgLinearLayout a(aggl paramaggl, MixedMsgLinearLayout paramMixedMsgLinearLayout, List<MessageRecord> paramList, agjk paramagjk, MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList1 = new ArrayList(paramList);
    paramList = paramMixedMsgLinearLayout;
    if (paramMixedMsgLinearLayout == null)
    {
      paramList = new MixedMsgLinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramList.setId(2131364423);
      paramList.setOrientation(1);
      paramList.setFocusable(false);
      paramList.setClickable(true);
      paramList.setMinimumHeight(agej.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramList.setPadding(2131296332, 2131296334, 2131296331, 2131296333);
      paramMixedMsgLinearLayout = new RelativeLayout.LayoutParams(-2, -2);
      paramMixedMsgLinearLayout.addRule(1, 2131368212);
      paramMixedMsgLinearLayout.addRule(3, 2131378618);
      paramMixedMsgLinearLayout.leftMargin = agej.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramMixedMsgLinearLayout.rightMargin = agej.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramList.setLayoutParams(paramMixedMsgLinearLayout);
      paramList.jdField_a_of_type_Biuy = this.jdField_a_of_type_Biuy;
      ahmq.a((ahmq)paramaggl, paramList);
      ((ahmq)paramaggl).jdField_a_of_type_Ambx = new ambx();
      ((ahmq)paramaggl).jdField_a_of_type_Ambx.a(paramList);
      ((ahmq)paramaggl).jdField_a_of_type_Ambx.a(paramaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
    }
    ((ahmq)paramaggl).e = -1;
    ((ahmq)paramaggl).jdField_a_of_type_Boolean = false;
    paramList.a(localArrayList1, (ahmq)paramaggl);
    if (bgqd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {}
    for (paramMixedMsgLinearLayout = (bgqd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262);; paramMixedMsgLinearLayout = null)
    {
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      HashMap localHashMap = a(localArrayList1);
      int j = localArrayList1.size();
      int i = 0;
      Object localObject1;
      View localView;
      Object localObject3;
      Object localObject2;
      Object localObject4;
      label544:
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
              ((ViewGroup)localObject2).setId(2131364451);
              ((ViewGroup)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).setOnTouchListener(paramagjk);
              ((ViewGroup)localObject2).setOnLongClickListener(paramagjk);
              ((ViewGroup)localObject2).findViewById(2131371445).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).findViewById(2131369272).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).findViewById(2131378827).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              if (TextUtils.isEmpty(((MessageForReplyText)localObject3).sb)) {
                break label767;
              }
              ((TextView)localObject4).setText(((MessageForReplyText)localObject3).sb);
              ((TextView)localObject4).setVisibility(0);
              if (paramMixedMsgLinearLayout != null)
              {
                localArrayList2.add(paramMixedMsgLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1));
                localArrayList3.add(localObject4);
              }
              localObject1 = (MessageForReplyText)localObject1;
              ahpx.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ViewGroup)localObject2, ((MessageForReplyText)localObject3).mSourceMsgInfo, this.jdField_a_of_type_Agjj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((MessageForReplyText)localObject3).istroop, (MessageRecord)localObject1, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
              localObject1 = ((ViewGroup)localObject2).findViewById(2131378827);
              if (localObject1 == null) {
                break label1249;
              }
              localObject1 = ((View)localObject1).getTag(2131364438);
              if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
                break label1249;
              }
              bool = ((Boolean)localObject1).booleanValue();
              ((ahmq)paramaggl).jdField_a_of_type_Boolean = bool;
            }
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MixedMsgItemBuilder", 1, "getMixedMsgLayout: reply check is need refresh[" + bool + "]");
        }
        label715:
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = BaseChatItemLayout.m;
        if (i == j - 1) {}
        for (((LinearLayout.LayoutParams)localObject1).bottomMargin = BaseChatItemLayout.m;; ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0)
        {
          localView.setOnTouchListener(paramagjk);
          localView.setOnLongClickListener(paramagjk);
          break;
          label767:
          ((TextView)localObject4).setVisibility(8);
          break label544;
          if ((localObject1 instanceof MessageForText))
          {
            localObject2 = (AnimationTextView)localView;
            ((AnimationTextView)localObject2).setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
            behh.a((TextView)localObject2);
            ((AnimationTextView)localObject2).setText((CharSequence)localHashMap.get(Integer.valueOf(i)));
            if (paramMixedMsgLinearLayout != null)
            {
              localArrayList2.add(paramMixedMsgLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1));
              localArrayList3.add(localObject2);
            }
            if (!bgty.b(paramMessageRecord)) {
              break label715;
            }
            bgty.a((TextView)localObject2, (MessageRecord)localObject1);
            break label715;
          }
          if ((localObject1 instanceof MessageForPic))
          {
            localObject1 = (MessageForPic)localObject1;
            localObject2 = (ChatThumbView)localView;
            localObject3 = new int[2];
            Object tmp905_903 = localObject3;
            tmp905_903[0] = 0;
            Object tmp909_905 = tmp905_903;
            tmp909_905[1] = 0;
            tmp909_905;
            localObject4 = ahng.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localObject1, (ChatThumbView)localObject2, (int[])localObject3);
            ((ChatThumbView)localObject2).setTag(2131364437, localObject1);
            ((ChatThumbView)localObject2).setAdjustViewBounds(true);
            ((ChatThumbView)localObject2).setMaxWidth(besm.a(ahng.a((MessageForPic)localObject1)));
            ((ChatThumbView)localObject2).setMaxHeight(besm.a(ahng.a((MessageForPic)localObject1)));
            ((ChatThumbView)localObject2).setImageDrawable((Drawable)localObject4);
            String str = ((URLDrawable)localObject4).getURL().getProtocol();
            URL localURL = beyq.a((azqr)localObject1, 65537);
            if (ahng.a(this.jdField_a_of_type_AndroidContentContext, bmgb.a(((MessageForPic)localObject1).imageType), str.equals("chatthumb"), localObject3[0], localObject3[1], localURL))
            {
              ((URLDrawable)localObject4).setWatermarkDrawable(ahng.a(), agej.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
            break label715;
          }
          QLog.e("MixedMsgItemBuilder", 2, "mixed type not support yet." + localObject1.getClass().getSimpleName());
          break label715;
        }
        a(localArrayList2, localArrayList3, paramMessageRecord);
        paramList.setOnTouchListener(paramagjk);
        paramList.setOnLongClickListener(paramagjk);
        paramList.b = this.jdField_a_of_type_Biuy;
        return paramList;
        label1249:
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
    aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 6, 0, "", "", "", "");
    return;
    super.d(paramChatMessage);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 7, 0, "", "", "", "");
    return;
    a(paramChatMessage, str1);
    return;
    b(paramChatMessage, str1);
    return;
    c(paramChatMessage, str1);
    return;
    super.a(paramChatMessage);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 5, 0, "", "", "", "");
    return;
    ambu.a().a(paramChatMessage);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 2, 0, "", "", "", "");
    return;
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 3, 0, "", "", "", "");
    b(paramChatMessage);
  }
  
  public void a(aggl paramaggl, View paramView, ChatMessage paramChatMessage, aqkt paramaqkt)
  {
    ahmq localahmq = (ahmq)paramaggl;
    if ((localahmq.e != -1) && (a(localahmq)))
    {
      localahmq.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      if ((paramaqkt.jdField_a_of_type_Int == 0) || (!paramaqkt.a()) || (bdgb.b()))
      {
        paramView = paramView.getResources();
        if (paramChatMessage.isSend())
        {
          paramaggl = paramView.getColorStateList(2131167013);
          localahmq.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaggl);
          localahmq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaggl);
          localahmq.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaggl);
          localahmq.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaggl);
          if (!paramChatMessage.isSend()) {
            break label206;
          }
        }
        label206:
        for (paramaggl = paramView.getColorStateList(2131167012);; paramaggl = paramView.getColorStateList(2131167011))
        {
          localahmq.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramaggl);
          localahmq.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaggl);
          localahmq.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaggl);
          ImmersiveUtils.a(localahmq.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
          ImmersiveUtils.a(localahmq.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
          ImmersiveUtils.a(localahmq.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
          return;
          paramaggl = paramView.getColorStateList(2131167009);
          break;
        }
      }
      if (paramaqkt.jdField_b_of_type_Int == 0)
      {
        localahmq.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localahmq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localahmq.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        localahmq.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        if (paramaqkt.c != 0) {
          break label404;
        }
        paramaggl = paramView.getResources().getColorStateList(2131167011);
        localahmq.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramaggl);
        localahmq.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaggl);
        localahmq.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaggl);
      }
      for (;;)
      {
        ImmersiveUtils.a(localahmq.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
        ImmersiveUtils.a(localahmq.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        ImmersiveUtils.a(localahmq.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        return;
        localahmq.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaqkt.jdField_b_of_type_Int);
        localahmq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaqkt.jdField_b_of_type_Int);
        localahmq.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaqkt.jdField_b_of_type_Int);
        localahmq.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaqkt.jdField_b_of_type_Int);
        break;
        label404:
        localahmq.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramaqkt.c);
        localahmq.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaqkt.c);
        localahmq.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaqkt.c);
      }
    }
    if ((paramaqkt.jdField_a_of_type_Int == 0) || (!paramaqkt.a()) || (bdgb.b()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramaggl = paramView.getColorStateList(2131167013);
        if (!paramChatMessage.isSend()) {
          break label525;
        }
      }
      label525:
      for (paramView = paramView.getColorStateList(2131167012);; paramView = paramView.getColorStateList(2131167011))
      {
        ahmq.a(localahmq).a(paramaggl, paramView);
        return;
        paramaggl = paramView.getColorStateList(2131167009);
        break;
      }
    }
    paramaggl = ColorStateList.valueOf(-16777216);
    paramView = paramView.getResources().getColorStateList(2131167011);
    if (paramaqkt.jdField_b_of_type_Int != 0) {
      paramaggl = ColorStateList.valueOf(paramaqkt.jdField_b_of_type_Int);
    }
    if (paramaqkt.c != 0) {
      paramView = ColorStateList.valueOf(paramaqkt.c);
    }
    ahmq.a(localahmq).a(paramaggl, paramView);
  }
  
  public void a(aggl paramaggl, ChatMessage paramChatMessage)
  {
    paramaggl = (ahmq)paramaggl;
    if (ahmq.a(paramaggl) != null) {
      ahmq.a(paramaggl).a(go.a(paramChatMessage));
    }
    if ((paramaggl.e != -1) && (a(paramaggl)))
    {
      paramChatMessage = go.a("");
      paramaggl.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
      paramaggl.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
      paramaggl.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
      paramaggl.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
    }
  }
  
  public void a(View paramView)
  {
    paramView = (ahmq)agej.a(paramView);
    if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
    {
      paramView = (MessageForMixedMsg)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        blir localblir = (blir)blji.a(this.jdField_a_of_type_AndroidContentContext, null);
        localblir.a(2131689933, 5);
        localblir.c(2131690580);
        localblir.a(new ahmp(this, paramView, localblir));
        localblir.show();
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
  
  public void a(View paramView, bete parambete, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2003) {}
    label68:
    label585:
    label593:
    for (;;)
    {
      return;
      Object localObject1 = (ahmq)agej.a(paramView);
      paramView = null;
      Object localObject2;
      if ((((ahmq)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
      {
        paramView = (MessageForMixedMsg)((ahmq)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if ((ahmq.a((ahmq)localObject1) != null) && (paramView != null) && (paramView.msgElemList != null)) {
          for (paramView = paramView.msgElemList.iterator(); paramView.hasNext(); paramView = (MessageForPic)localObject2)
          {
            localObject2 = (MessageRecord)paramView.next();
            if ((localObject2 == null) || (((MessageRecord)localObject2).uniseq != parambete.b) || (!(localObject2 instanceof MessageForPic)) || (((MessageForPic)localObject2).subMsgId != parambete.c)) {
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
          paramInt2 = ahmq.a((ahmq)localObject1).getChildCount();
          paramInt1 = 0;
          label232:
          Object localObject3;
          Object localObject4;
          if (paramInt1 < paramInt2)
          {
            parambete = ahmq.a((ahmq)localObject1).getChildAt(paramInt1);
            if ((parambete instanceof ChatThumbView))
            {
              localObject2 = ((ChatThumbView)parambete).getTag(2131364437);
              if (((localObject2 instanceof MessageForPic)) && (((MessageForPic)localObject2).uniseq == paramView.uniseq) && (((MessageForPic)localObject2).subMsgId == paramView.subMsgId))
              {
                parambete = (ChatThumbView)parambete;
                if (parambete == null) {
                  break label577;
                }
                localObject1 = new int[2];
                tmp243_241 = localObject1;
                tmp243_241[0] = 0;
                tmp247_243 = tmp243_241;
                tmp247_243[1] = 0;
                tmp247_243;
                localObject2 = ahng.a(this.jdField_a_of_type_AndroidContentContext, paramView, parambete, (int[])localObject1);
                localObject3 = ((URLDrawable)localObject2).getURL().getProtocol();
                localObject4 = beyq.a(paramView, 65537);
                boolean bool = ahng.a(this.jdField_a_of_type_AndroidContentContext, bmgb.a(paramView.imageType), ((String)localObject3).equals("chatthumb"), localObject1[0], localObject1[1], (URL)localObject4);
                parambete.setImageDrawable((Drawable)localObject2);
                if (!bool) {
                  break label567;
                }
                ((URLDrawable)localObject2).setWatermarkDrawable(ahng.a(), agej.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                ((URLDrawable)localObject2).setWatermarkVisibility(0);
                return;
                if (!(((ahmq)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForLongMsg)) {
                  break label585;
                }
                localObject2 = (MessageForLongMsg)((ahmq)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
                if (((MessageRecord)localObject3).uniseq != parambete.b) {
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
                  if (((localObject4 instanceof MessageForPic)) && (((MessageForPic)localObject4).subMsgId == parambete.c))
                  {
                    paramView = (MessageForPic)localObject4;
                    break label478;
                    paramInt1 += 1;
                    break label153;
                    ((URLDrawable)localObject2).setWatermarkVisibility(4);
                    return;
                    parambete = null;
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
    paramView = (ahmq)paramView.getTag();
    int i = BaseChatItemLayout.h;
    if (paramChatMessage.isSend())
    {
      ahmq.a(paramView).setPadding(ahtp.f, i, ahtp.e, ahtp.d);
      return;
    }
    ahmq.a(paramView).setPadding(ahtp.e, i, ahtp.f, ahtp.d);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Object localObject = (ahmq)agej.a(paramView);
    if ((!paramBoolean) && ((paramView instanceof ChatThumbView))) {
      ((ChatThumbView)paramView).a(paramView, true);
    }
    localObject = ahmq.a((ahmq)localObject).getBackground();
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
  
  public bhum[] a(View paramView)
  {
    paramView = (ahmq)agej.a(paramView);
    ChatMessage localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    bhuk localbhuk = new bhuk();
    if (localChatMessage != null)
    {
      if (!localChatMessage.isMultiMsg) {
        break label45;
      }
      a(localbhuk, localChatMessage, null);
    }
    for (;;)
    {
      return localbhuk.a();
      label45:
      b(localbhuk, localChatMessage, paramView);
    }
  }
  
  public bhuk b(bhuk parambhuk, ChatMessage paramChatMessage, aghd paramaghd)
  {
    parambhuk.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691093));
    int i;
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      if (((MessageForMixedMsg)paramChatMessage).canSelectable()) {
        break label200;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        parambhuk.a(2131365191, this.jdField_a_of_type_AndroidContentContext.getString(2131717397), 2130838932);
      }
      parambhuk.a(2131367078, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838939);
      a(paramChatMessage, parambhuk);
      a(parambhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramaghd.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      a(parambhuk, paramChatMessage);
      if (agej.a(5) == 1) {
        parambhuk.a(2131366320, this.jdField_a_of_type_AndroidContentContext.getString(2131691990), 2130838938);
      }
      super.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      c(paramChatMessage, parambhuk);
      b(paramChatMessage, parambhuk);
      super.c(parambhuk, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
      return parambhuk;
      if (((paramChatMessage instanceof MessageForLongMsg)) && (!((MessageForLongMsg)paramChatMessage).canSelectable())) {
        i = 0;
      } else {
        label200:
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmm
 * JD-Core Version:    0.7.0.1
 */