import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.DisplayUtil;
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

public class agiy
  extends BaseBubbleBuilder
  implements aeze, afbb
{
  private afcc jdField_a_of_type_Afcc = new afcc();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private bhba jdField_a_of_type_Bhba = new agja(this);
  private ge jdField_a_of_type_Ge;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private View.OnClickListener b;
  protected long c;
  
  public agiy(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new agiz(this);
    this.jdField_a_of_type_Afcc.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new azyg(this);
  }
  
  private MessageRecord a(SpannableStringBuilder paramSpannableStringBuilder1, SpannableStringBuilder paramSpannableStringBuilder2)
  {
    MessageForText localMessageForText = (MessageForText)bbli.a(-1000);
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
    if (android.text.TextUtils.isEmpty(paramCharSequence)) {}
    String str;
    int i;
    label74:
    do
    {
      return paramCharSequence;
      if ((paramCharSequence instanceof QQText)) {}
      for (str = ((QQText)paramCharSequence).mSource;; str = paramCharSequence.toString())
      {
        i = ChatTextSizeSettingActivity.a();
        if (!paramBoolean) {
          break label74;
        }
        if (!str.startsWith("\n")) {
          break;
        }
        return new QQText(str.substring(1), 13, i, paramMessageRecord);
      }
    } while (!str.endsWith("\n"));
    return new QQText(str.substring(0, str.length() - 1), 13, i, paramMessageRecord);
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
          if (!android.text.TextUtils.isEmpty(((MessageForText)localObject1).sb2)) {
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
  
  private List<MessageRecord> a(List<MessageRecord> paramList, aezf paramaezf)
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
        if (!android.text.TextUtils.isEmpty(((MessageForText)localObject).sb)) {
          localSpannableStringBuilder1.append(((MessageForText)localObject).sb);
        }
        if (!android.text.TextUtils.isEmpty(((MessageForText)localObject).sb2)) {
          localSpannableStringBuilder2.append(((MessageForText)localObject).sb2);
        } else if (!android.text.TextUtils.isEmpty(((MessageForText)localObject).sb)) {
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
            if (!android.text.TextUtils.isEmpty(((MessageForText)localMessageRecord).sb)) {
              localSpannableStringBuilder1.append(((MessageForText)localMessageRecord).sb);
            }
            if (!android.text.TextUtils.isEmpty(((MessageForText)localMessageRecord).sb2)) {
              localSpannableStringBuilder2.append(((MessageForText)localMessageRecord).sb2);
            } else if (!android.text.TextUtils.isEmpty(((MessageForText)localMessageRecord).sb)) {
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
        if (!android.text.TextUtils.isEmpty(((MessageForReplyText)localObject).sb))
        {
          localSpannableStringBuilder1.append(((MessageForReplyText)localObject).sb);
          localSpannableStringBuilder2.append(((MessageForReplyText)localObject).sb);
        }
        localArrayList.add(localObject);
      }
    }
    localArrayList.add(a(localSpannableStringBuilder1, localSpannableStringBuilder2));
    a(paramaezf, com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(localSpannableStringBuilder1.toString()));
    return localArrayList;
  }
  
  private void a(aezf paramaezf, String paramString)
  {
    if (paramaezf.jdField_b_of_type_JavaLangStringBuilder == null) {
      paramaezf.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    if (e) {
      paramaezf.jdField_b_of_type_JavaLangStringBuilder.append(paramString);
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
    afnx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 2);
    Object localObject;
    int i;
    if (akxv.a().c())
    {
      localObject = akxv.a().b();
      if (localObject != null) {
        if (((CharSequence)localObject).length() != akxv.a().a())
        {
          i = 1;
          if (i != 0) {
            break label234;
          }
          localObject = akxv.a().c();
        }
      }
    }
    label61:
    label234:
    for (;;)
    {
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText((CharSequence)localObject);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
      if (i != 0) {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramChatMessage.isMultiMsg) {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D65", "0X8009D65", 3, 0, "3", "", "", "");
        }
        return;
        i = 0;
        break;
        i = 0;
        break;
        localObject = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
        i = 1;
        break label61;
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
      }
    }
  }
  
  private void a(gb paramgb, MixedMsgLinearLayout paramMixedMsgLinearLayout)
  {
    if (paramMixedMsgLinearLayout != null)
    {
      paramgb = paramgb.a(10416, 1, false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0);
      if (paramgb != null) {
        paramMixedMsgLinearLayout.a(paramgb.a);
      }
    }
  }
  
  private void a(ArrayList<bezs> paramArrayList, ArrayList<TextView> paramArrayList1, MessageRecord paramMessageRecord)
  {
    if (!bezr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
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
        localObject2 = (bezs)paramArrayList.get(i);
        if ((localObject2 == null) || (((bezs)localObject2).jdField_b_of_type_Int == -1))
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
          localStringBuilder.append(((bezs)localObject2).b());
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
      localTextView.setTag(2131366809, "school_troop_span");
      k = j;
      localObject2 = localObject1;
      break label139;
      if (((bezs)localObject2).jdField_b_of_type_Int < localObject1.jdField_b_of_type_Int)
      {
        localObject1 = localObject2;
        j = i;
        continue;
        if (localObject1 != null)
        {
          localObject2 = new bezs();
          ((bezs)localObject2).jdField_a_of_type_Long = paramMessageRecord.uniseq;
          ((bezs)localObject2).jdField_a_of_type_Int = localObject1.jdField_a_of_type_Int;
          ((bezs)localObject2).jdField_a_of_type_JavaLangString = localObject1.jdField_a_of_type_JavaLangString;
          ((bezs)localObject2).jdField_b_of_type_JavaLangString = localObject1.jdField_b_of_type_JavaLangString;
          ((bezs)localObject2).jdField_b_of_type_Int = localObject1.jdField_b_of_type_Int;
          ((bezs)localObject2).a(localStringBuilder.toString());
          ((bezs)localObject2).c = localObject1.c;
          ((bezs)localObject2).d = localObject1.d;
          ((Spannable)((TextView)paramArrayList1.get(j)).getText()).setSpan(new bezt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (bezs)localObject2), ((bezs)localObject2).c, ((bezs)localObject2).d, 17);
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
  
  private boolean a(agjd paramagjd)
  {
    return (paramagjd.jdField_b_of_type_AndroidWidgetTextView != null) && (paramagjd.jdField_a_of_type_AndroidWidgetTextView != null) && (paramagjd.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (paramagjd.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null);
  }
  
  private void b(ChatMessage paramChatMessage, String paramString)
  {
    afnx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 3);
    Object localObject1;
    int i;
    if (akxv.a().c())
    {
      localObject1 = akxv.a().b();
      if (localObject1 != null) {
        if (((String)localObject1).length() == akxv.a().a())
        {
          i = 1;
          if (i != 0) {
            break label559;
          }
          localObject1 = akxv.a().c();
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
        localObject2 = bfyz.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
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
            ((avsf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a.put(Long.valueOf(paramChatMessage.uniseq), paramChatMessage);
            localBundle.putString("forward_text", (String)localObject1);
            localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
            localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
            localObject1 = new Intent();
            ((Intent)localObject1).putExtras(localBundle);
            atky.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, 21);
            bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005637", "0X8005637", 0, 0, "", "", "", "");
            bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
            if (i == 0) {
              break label527;
            }
            bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
            if (paramChatMessage.isMultiMsg) {
              bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 9, 0, "9", "", "", "");
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
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      }
    }
  }
  
  private void c(ChatMessage paramChatMessage, String paramString)
  {
    afnx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 4);
    String str;
    int i;
    if (akxv.a().c())
    {
      str = akxv.a().b();
      if (str != null) {
        if (str.length() == akxv.a().a())
        {
          i = 1;
          if (i != 0) {
            break label293;
          }
          str = akxv.a().c();
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
        bkov.b(paramChatMessage).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bkpf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, 0, paramChatMessage.istroop);
        label111:
        bkpf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
        if (i == 0) {
          break label261;
        }
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAC", 4, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramChatMessage.isMultiMsg) {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 9, 0, "9", "", "", "");
        }
        return;
        i = 0;
        break;
        i = 0;
        break;
        str = null;
        i = 1;
        break label59;
        bkpf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramChatMessage.istroop);
        bkov.a(null, str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        break label111;
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 4, 0, "", "", "", "");
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public aeze a(View paramView)
  {
    if (a(paramView)) {
      return this;
    }
    return null;
  }
  
  public aezf a()
  {
    return new agjd(this);
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    agjd localagjd = (agjd)paramaezf;
    if (localagjd.jdField_b_of_type_JavaLangStringBuilder == null) {
      localagjd.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    Object localObject2 = (bfdm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    if (QLog.isColorLevel()) {
      QLog.i("MixedMsgItemBuilder", 1, "getBubbleView: check is need refresh[" + localagjd.jdField_a_of_type_Boolean + "]");
    }
    if ((!e) && (agjd.a(localagjd) != null) && (agjd.a(localagjd) == paramChatMessage.uniseq) && (!localagjd.jdField_a_of_type_Boolean) && (android.text.TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info"))))
    {
      if (((bfdm)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
        localagjd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      }
      for (;;)
      {
        paramaezf = paramView;
        if (localagjd != null)
        {
          paramaezf = paramView;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            localagjd.c = super.a(localagjd.c, localagjd, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 21.0F));
            super.a(localagjd.c, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
            paramaezf = paramView;
          }
        }
        return paramaezf;
        localagjd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      }
    }
    Object localObject1;
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      Iterator localIterator;
      if (bfwr.a(paramChatMessage.issend))
      {
        localObject1 = "发出";
        a(paramaezf, (String)localObject1);
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
          a(paramaezf, "图片");
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
          a(paramaezf, com.tencent.mobileqq.text.TextUtils.emoticonToText(((MessageRecord)localObject3).msg));
        }
      }
      label416:
      localObject1 = a(paramaezf, (MixedMsgLinearLayout)paramView, ((MessageForMixedMsg)localObject1).msgElemList, paramafce, (MessageRecord)localObject1);
      agjd.a(localagjd, paramChatMessage.uniseq);
      localagjd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(((bfdm)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    for (;;)
    {
      paramaezf = afaz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramaezf != null) {
        paramaezf.a((View)localObject1, this);
      }
      if (localObject1 != null) {
        ((View)localObject1).setTag(localagjd);
      }
      if (localagjd.jdField_a_of_type_Akxy != null) {
        localagjd.jdField_a_of_type_Akxy.b(paramChatMessage);
      }
      paramaezf = (aezf)localObject1;
      if (localagjd == null) {
        break;
      }
      paramaezf = (aezf)localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
      localagjd.c = super.a(localagjd.c, localagjd, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 21.0F));
      super.a(localagjd.c, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
      return localObject1;
      localObject1 = paramView;
      if ((paramChatMessage instanceof MessageForLongMsg))
      {
        localObject2 = (MessageForLongMsg)paramChatMessage;
        a(paramaezf, "说");
        localObject1 = paramView;
        if (((MessageForLongMsg)localObject2).longMsgFragmentList != null)
        {
          localObject1 = paramView;
          if (!((MessageForLongMsg)localObject2).longMsgFragmentList.isEmpty())
          {
            localObject1 = a(((MessageForLongMsg)localObject2).longMsgFragmentList, localagjd);
            localObject1 = a(paramaezf, (MixedMsgLinearLayout)paramView, (List)localObject1, paramafce, paramChatMessage);
            agjd.a(localagjd, paramChatMessage.uniseq);
          }
        }
      }
    }
  }
  
  public bgaz a(bgaz parambgaz, ChatMessage paramChatMessage, aezy paramaezy)
  {
    int i = 0;
    parambgaz.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691133));
    if ((paramChatMessage instanceof MessageForMixedMsg)) {
      if (((MessageForMixedMsg)paramChatMessage).canSelectable()) {
        break label126;
      }
    }
    for (;;)
    {
      if (i != 0) {
        parambgaz.a(2131365216, this.jdField_a_of_type_AndroidContentContext.getString(2131717629), 2130838964);
      }
      parambgaz.a(2131367094, this.jdField_a_of_type_AndroidContentContext.getString(2131692448), 2130838971);
      if (AIOUtils.getAIOMsgMenuDpcConfig(5) == 1) {
        parambgaz.a(2131366347, this.jdField_a_of_type_AndroidContentContext.getString(2131692036), 2130838970);
      }
      return parambgaz;
      if ((!(paramChatMessage instanceof MessageForLongMsg)) || (((MessageForLongMsg)paramChatMessage).canSelectable())) {
        label126:
        i = 1;
      }
    }
  }
  
  public MixedMsgLinearLayout a(aezf paramaezf, MixedMsgLinearLayout paramMixedMsgLinearLayout, List<MessageRecord> paramList, afce paramafce, MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList1 = new ArrayList(paramList);
    paramList = paramMixedMsgLinearLayout;
    if (paramMixedMsgLinearLayout == null)
    {
      paramList = new MixedMsgLinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramList.setId(2131364441);
      paramList.setOrientation(1);
      paramList.setFocusable(false);
      paramList.setClickable(true);
      paramList.setMinimumHeight(AIOUtils.dp2px(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramList.setPadding(2131296385, 2131296387, 2131296384, 2131296386);
      paramMixedMsgLinearLayout = new RelativeLayout.LayoutParams(-2, -2);
      paramMixedMsgLinearLayout.addRule(1, 2131368236);
      paramMixedMsgLinearLayout.addRule(3, 2131378382);
      paramMixedMsgLinearLayout.leftMargin = AIOUtils.dp2px(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramMixedMsgLinearLayout.rightMargin = AIOUtils.dp2px(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramList.setLayoutParams(paramMixedMsgLinearLayout);
      paramList.jdField_a_of_type_Bhba = this.jdField_a_of_type_Bhba;
      agjd.a((agjd)paramaezf, paramList);
      ((agjd)paramaezf).jdField_a_of_type_Akxy = new akxy();
      ((agjd)paramaezf).jdField_a_of_type_Akxy.a(paramList);
      ((agjd)paramaezf).jdField_a_of_type_Akxy.a(paramaezf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramaezf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
    }
    ((agjd)paramaezf).e = -1;
    ((agjd)paramaezf).jdField_a_of_type_Boolean = false;
    paramList.a(localArrayList1, (agjd)paramaezf);
    if (bezr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {}
    for (paramMixedMsgLinearLayout = (bezr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262);; paramMixedMsgLinearLayout = null)
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
              ((ViewGroup)localObject2).setId(2131364469);
              ((ViewGroup)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).setOnTouchListener(paramafce);
              ((ViewGroup)localObject2).setOnLongClickListener(paramafce);
              ((ViewGroup)localObject2).findViewById(2131371413).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).findViewById(2131369288).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).findViewById(2131378591).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              if (android.text.TextUtils.isEmpty(((MessageForReplyText)localObject3).sb)) {
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
              agmk.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ViewGroup)localObject2, ((MessageForReplyText)localObject3).mSourceMsgInfo, this.jdField_a_of_type_Afcc.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, ((MessageForReplyText)localObject3).istroop, (MessageRecord)localObject1, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
              localObject1 = ((ViewGroup)localObject2).findViewById(2131378591);
              if (localObject1 == null) {
                break label1249;
              }
              localObject1 = ((View)localObject1).getTag(2131364456);
              if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
                break label1249;
              }
              bool = ((Boolean)localObject1).booleanValue();
              ((agjd)paramaezf).jdField_a_of_type_Boolean = bool;
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
          localView.setOnTouchListener(paramafce);
          localView.setOnLongClickListener(paramafce);
          break;
          label767:
          ((TextView)localObject4).setVisibility(8);
          break label544;
          if ((localObject1 instanceof MessageForText))
          {
            localObject2 = (AnimationTextView)localView;
            ((AnimationTextView)localObject2).setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
            com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10((TextView)localObject2);
            ((AnimationTextView)localObject2).setText((CharSequence)localHashMap.get(Integer.valueOf(i)));
            if (paramMixedMsgLinearLayout != null)
            {
              localArrayList2.add(paramMixedMsgLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1));
              localArrayList3.add(localObject2);
            }
            if (!bfdm.b(paramMessageRecord)) {
              break label715;
            }
            bfdm.a((TextView)localObject2, (MessageRecord)localObject1);
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
            localObject4 = agjt.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localObject1, (ChatThumbView)localObject2, (int[])localObject3);
            ((ChatThumbView)localObject2).setTag(2131364455, localObject1);
            ((ChatThumbView)localObject2).setAdjustViewBounds(true);
            ((ChatThumbView)localObject2).setMaxWidth(CommonImgThumbHelper.getImgThumbMaxPx(agjt.a((MessageForPic)localObject1)));
            ((ChatThumbView)localObject2).setMaxHeight(CommonImgThumbHelper.getImgThumbMaxPx(agjt.a((MessageForPic)localObject1)));
            ((ChatThumbView)localObject2).setImageDrawable((Drawable)localObject4);
            String str = ((URLDrawable)localObject4).getURL().getProtocol();
            URL localURL = URLDrawableHelper.getURL((aydz)localObject1, 65537);
            if (agjt.a(this.jdField_a_of_type_AndroidContentContext, bkkh.a(((MessageForPic)localObject1).imageType), str.equals("chatthumb"), localObject3[0], localObject3[1], localURL))
            {
              ((URLDrawable)localObject4).setWatermarkDrawable(agjt.a(), AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPicPreDownloader().a((MessageForPic)localObject1, 2);
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
        paramList.setOnTouchListener(paramafce);
        paramList.setOnLongClickListener(paramafce);
        paramList.b = this.jdField_a_of_type_Bhba;
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
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Ge != null)
    {
      ((gb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).b(this.jdField_a_of_type_Ge);
      this.jdField_a_of_type_Ge = null;
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      str1 = str2;
      if (!android.text.TextUtils.isEmpty(str2)) {}
    }
    for (String str1 = "";; str1 = "") {
      switch (paramInt)
      {
      default: 
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
    }
    acvv.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 6, 0, "", "", "", "");
    return;
    super.d(paramChatMessage);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 7, 0, "", "", "", "");
    return;
    a(paramChatMessage, str1);
    return;
    b(paramChatMessage, str1);
    return;
    c(paramChatMessage, str1);
    return;
    super.a(paramChatMessage);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 5, 0, "", "", "", "");
    return;
    akxv.a().a(paramChatMessage);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 2, 0, "", "", "", "");
    return;
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 3, 0, "", "", "", "");
    b(paramChatMessage);
  }
  
  public void a(aezf paramaezf, View paramView, ChatMessage paramChatMessage, apee paramapee)
  {
    agjd localagjd = (agjd)paramaezf;
    if ((localagjd.e != -1) && (a(localagjd)))
    {
      localagjd.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
      if ((paramapee.jdField_a_of_type_Int == 0) || (!paramapee.a()) || (bbyp.b()))
      {
        paramView = paramView.getResources();
        if (paramChatMessage.isSend())
        {
          paramaezf = paramView.getColorStateList(2131167035);
          localagjd.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaezf);
          localagjd.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaezf);
          localagjd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaezf);
          localagjd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaezf);
          if (!paramChatMessage.isSend()) {
            break label206;
          }
        }
        label206:
        for (paramaezf = paramView.getColorStateList(2131167034);; paramaezf = paramView.getColorStateList(2131167033))
        {
          localagjd.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramaezf);
          localagjd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaezf);
          localagjd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaezf);
          ImmersiveUtils.a(localagjd.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
          ImmersiveUtils.a(localagjd.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
          ImmersiveUtils.a(localagjd.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
          return;
          paramaezf = paramView.getColorStateList(2131167031);
          break;
        }
      }
      if (paramapee.jdField_b_of_type_Int == 0)
      {
        localagjd.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localagjd.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localagjd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        localagjd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        if (paramapee.c != 0) {
          break label404;
        }
        paramaezf = paramView.getResources().getColorStateList(2131167033);
        localagjd.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramaezf);
        localagjd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaezf);
        localagjd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaezf);
      }
      for (;;)
      {
        ImmersiveUtils.a(localagjd.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
        ImmersiveUtils.a(localagjd.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        ImmersiveUtils.a(localagjd.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        return;
        localagjd.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramapee.jdField_b_of_type_Int);
        localagjd.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramapee.jdField_b_of_type_Int);
        localagjd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramapee.jdField_b_of_type_Int);
        localagjd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramapee.jdField_b_of_type_Int);
        break;
        label404:
        localagjd.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramapee.c);
        localagjd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramapee.c);
        localagjd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramapee.c);
      }
    }
    if ((paramapee.jdField_a_of_type_Int == 0) || (!paramapee.a()) || (bbyp.b()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramaezf = paramView.getColorStateList(2131167035);
        if (!paramChatMessage.isSend()) {
          break label525;
        }
      }
      label525:
      for (paramView = paramView.getColorStateList(2131167034);; paramView = paramView.getColorStateList(2131167033))
      {
        agjd.a(localagjd).a(paramaezf, paramView);
        return;
        paramaezf = paramView.getColorStateList(2131167031);
        break;
      }
    }
    paramaezf = ColorStateList.valueOf(-16777216);
    paramView = paramView.getResources().getColorStateList(2131167033);
    if (paramapee.jdField_b_of_type_Int != 0) {
      paramaezf = ColorStateList.valueOf(paramapee.jdField_b_of_type_Int);
    }
    if (paramapee.c != 0) {
      paramView = ColorStateList.valueOf(paramapee.c);
    }
    agjd.a(localagjd).a(paramaezf, paramView);
  }
  
  public void a(aezf paramaezf, ChatMessage paramChatMessage)
  {
    paramaezf = (agjd)paramaezf;
    if ((paramaezf.e != -1) && (a(paramaezf)))
    {
      Typeface localTypeface = gm.a("");
      paramaezf.jdField_b_of_type_AndroidWidgetTextView.setTypeface(localTypeface);
      paramaezf.jdField_a_of_type_AndroidWidgetTextView.setTypeface(localTypeface);
      paramaezf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(localTypeface);
      paramaezf.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(localTypeface);
    }
    if (agjd.a(paramaezf) != null)
    {
      if ((bcoo.a()) && (((Boolean)bfyz.b(BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "key_alphabetic_font_switch_status_", Boolean.valueOf(false))).booleanValue()))
      {
        paramChatMessage = (gb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
        if (this.jdField_a_of_type_Ge != null)
        {
          paramChatMessage.b(this.jdField_a_of_type_Ge);
          this.jdField_a_of_type_Ge = null;
        }
        this.jdField_a_of_type_Ge = new agjb(this, paramChatMessage, paramaezf);
        paramChatMessage.a(this.jdField_a_of_type_Ge);
        a(paramChatMessage, agjd.a(paramaezf));
      }
    }
    else {
      return;
    }
    agjd.a(paramaezf).a(gm.a(paramChatMessage));
  }
  
  public void a(View paramView)
  {
    paramView = (agjd)AIOUtils.getHolder(paramView);
    if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
    {
      paramView = (MessageForMixedMsg)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        bjnw localbjnw = (bjnw)bjon.a(this.jdField_a_of_type_AndroidContentContext, null);
        localbjnw.a(2131689947, 5);
        localbjnw.c(2131690620);
        localbjnw.a(new agjc(this, paramView, localbjnw));
        localbjnw.show();
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
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView = (agjd)paramView.getTag();
    int i = BaseChatItemLayout.h;
    if (paramChatMessage.isSend())
    {
      agjd.a(paramView).setPadding(agqd.f, i, agqd.e, agqd.d);
      return;
    }
    agjd.a(paramView).setPadding(agqd.e, i, agqd.f, agqd.d);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2003) {}
    label68:
    label585:
    label593:
    for (;;)
    {
      return;
      Object localObject1 = (agjd)AIOUtils.getHolder(paramView);
      paramView = null;
      Object localObject2;
      if ((((agjd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
      {
        paramView = (MessageForMixedMsg)((agjd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if ((agjd.a((agjd)localObject1) != null) && (paramView != null) && (paramView.msgElemList != null)) {
          for (paramView = paramView.msgElemList.iterator(); paramView.hasNext(); paramView = (MessageForPic)localObject2)
          {
            localObject2 = (MessageRecord)paramView.next();
            if ((localObject2 == null) || (((MessageRecord)localObject2).uniseq != paramFileMsg.uniseq) || (!(localObject2 instanceof MessageForPic)) || (((MessageForPic)localObject2).subMsgId != paramFileMsg.mSubMsgId)) {
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
          paramInt2 = agjd.a((agjd)localObject1).getChildCount();
          paramInt1 = 0;
          label232:
          Object localObject3;
          Object localObject4;
          if (paramInt1 < paramInt2)
          {
            paramFileMsg = agjd.a((agjd)localObject1).getChildAt(paramInt1);
            if ((paramFileMsg instanceof ChatThumbView))
            {
              localObject2 = ((ChatThumbView)paramFileMsg).getTag(2131364455);
              if (((localObject2 instanceof MessageForPic)) && (((MessageForPic)localObject2).uniseq == paramView.uniseq) && (((MessageForPic)localObject2).subMsgId == paramView.subMsgId))
              {
                paramFileMsg = (ChatThumbView)paramFileMsg;
                if (paramFileMsg == null) {
                  break label577;
                }
                localObject1 = new int[2];
                tmp243_241 = localObject1;
                tmp243_241[0] = 0;
                tmp247_243 = tmp243_241;
                tmp247_243[1] = 0;
                tmp247_243;
                localObject2 = agjt.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramFileMsg, (int[])localObject1);
                localObject3 = ((URLDrawable)localObject2).getURL().getProtocol();
                localObject4 = URLDrawableHelper.getURL(paramView, 65537);
                boolean bool = agjt.a(this.jdField_a_of_type_AndroidContentContext, bkkh.a(paramView.imageType), ((String)localObject3).equals("chatthumb"), localObject1[0], localObject1[1], (URL)localObject4);
                paramFileMsg.setImageDrawable((Drawable)localObject2);
                if (!bool) {
                  break label567;
                }
                ((URLDrawable)localObject2).setWatermarkDrawable(agjt.a(), AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                ((URLDrawable)localObject2).setWatermarkVisibility(0);
                return;
                if (!(((agjd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForLongMsg)) {
                  break label585;
                }
                localObject2 = (MessageForLongMsg)((agjd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
                if (((MessageRecord)localObject3).uniseq != paramFileMsg.uniseq) {
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
                  if (((localObject4 instanceof MessageForPic)) && (((MessageForPic)localObject4).subMsgId == paramFileMsg.mSubMsgId))
                  {
                    paramView = (MessageForPic)localObject4;
                    break label478;
                    paramInt1 += 1;
                    break label153;
                    ((URLDrawable)localObject2).setWatermarkVisibility(4);
                    return;
                    paramFileMsg = null;
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
  
  public void a(View paramView, boolean paramBoolean)
  {
    Object localObject = (agjd)AIOUtils.getHolder(paramView);
    if ((!paramBoolean) && ((paramView instanceof ChatThumbView))) {
      ((ChatThumbView)paramView).a(paramView, true);
    }
    localObject = agjd.a((agjd)localObject).getBackground();
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
  
  public bgbb[] a(View paramView)
  {
    paramView = (agjd)AIOUtils.getHolder(paramView);
    ChatMessage localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    bgaz localbgaz = new bgaz();
    if (localChatMessage != null)
    {
      if (!localChatMessage.isMultiMsg) {
        break label45;
      }
      a(localbgaz, localChatMessage, null);
    }
    for (;;)
    {
      return localbgaz.a();
      label45:
      b(localbgaz, localChatMessage, paramView);
    }
  }
  
  public bgaz b(bgaz parambgaz, ChatMessage paramChatMessage, aezy paramaezy)
  {
    parambgaz.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691133));
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
        parambgaz.a(2131365216, this.jdField_a_of_type_AndroidContentContext.getString(2131717629), 2130838964);
      }
      parambgaz.a(2131367094, this.jdField_a_of_type_AndroidContentContext.getString(2131692448), 2130838971);
      a(paramChatMessage, parambgaz);
      a(parambgaz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramaezy.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      a(parambgaz, paramChatMessage);
      if (AIOUtils.getAIOMsgMenuDpcConfig(5) == 1) {
        parambgaz.a(2131366347, this.jdField_a_of_type_AndroidContentContext.getString(2131692036), 2130838970);
      }
      super.a(parambgaz, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      c(paramChatMessage, parambgaz);
      b(paramChatMessage, parambgaz);
      super.c(parambgaz, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambgaz, this.jdField_a_of_type_AndroidContentContext);
      return parambgaz;
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
 * Qualified Name:     agiy
 * JD-Core Version:    0.7.0.1
 */