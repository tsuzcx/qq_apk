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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class ahbp
  extends BaseBubbleBuilder
  implements afqq, afsn
{
  private afti jdField_a_of_type_Afti = new afti();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private bils jdField_a_of_type_Bils = new ahbr(this);
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private View.OnClickListener b;
  protected long c;
  
  public ahbp(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ahbq(this);
    this.jdField_a_of_type_Afti.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bbep(this);
  }
  
  private View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, aftk paramaftk, ahbt paramahbt)
  {
    Object localObject2;
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      if (bhfj.a(paramChatMessage.issend))
      {
        localObject1 = "发出";
        a(paramafqr, (String)localObject1);
        localObject1 = (MessageForMixedMsg)paramChatMessage;
        localObject2 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label164;
        }
        Object localObject3 = (MessageRecord)((Iterator)localObject2).next();
        if ((localObject3 instanceof MessageForPic))
        {
          a(paramafqr, "图片");
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
          a(paramafqr, com.tencent.mobileqq.text.TextUtils.emoticonToText(((MessageRecord)localObject3).msg));
        }
      }
      label164:
      paramafqr = a(paramafqr, (MixedMsgLinearLayout)paramView, ((MessageForMixedMsg)localObject1).msgElemList, paramaftk, (MessageRecord)localObject1);
      ahbt.a(paramahbt, paramChatMessage.uniseq);
      localObject1 = paramafqr;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        paramView = (bgls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
        paramahbt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(paramView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        localObject1 = paramafqr;
      }
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject1 = paramView;
        } while (!(paramChatMessage instanceof MessageForLongMsg));
        localObject2 = (MessageForLongMsg)paramChatMessage;
        a(paramafqr, "说");
        localObject1 = paramView;
      } while (((MessageForLongMsg)localObject2).longMsgFragmentList == null);
      localObject1 = paramView;
    } while (((MessageForLongMsg)localObject2).longMsgFragmentList.isEmpty());
    Object localObject1 = a(((MessageForLongMsg)localObject2).longMsgFragmentList, paramahbt);
    paramafqr = a(paramafqr, (MixedMsgLinearLayout)paramView, (List)localObject1, paramaftk, paramChatMessage);
    ahbt.a(paramahbt, paramChatMessage.uniseq);
    return paramafqr;
  }
  
  private MessageForPic a(FileMsg paramFileMsg, ahbt paramahbt)
  {
    MessageRecord localMessageRecord = null;
    Iterator localIterator = null;
    Object localObject;
    if ((paramahbt.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
    {
      localObject = (MessageForMixedMsg)paramahbt.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((ahbt.a(paramahbt) == null) || (localObject == null) || (((MessageForMixedMsg)localObject).msgElemList == null)) {
        break label310;
      }
      paramahbt = ((MessageForMixedMsg)localObject).msgElemList.iterator();
      do
      {
        if (!paramahbt.hasNext()) {
          break;
        }
        localObject = (MessageRecord)paramahbt.next();
      } while ((localObject == null) || (((MessageRecord)localObject).uniseq != paramFileMsg.uniseq) || (!(localObject instanceof MessageForPic)) || (((MessageForPic)localObject).subMsgId != paramFileMsg.mSubMsgId));
    }
    label310:
    for (paramFileMsg = (MessageForPic)localObject;; paramFileMsg = null)
    {
      localObject = paramFileMsg;
      do
      {
        do
        {
          do
          {
            return localObject;
            localObject = localIterator;
          } while (!(paramahbt.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForLongMsg));
          paramahbt = (MessageForLongMsg)paramahbt.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          localObject = localIterator;
        } while (paramahbt.longMsgFragmentList == null);
        localObject = localIterator;
      } while (paramahbt.longMsgFragmentList.isEmpty());
      localIterator = paramahbt.longMsgFragmentList.iterator();
      paramahbt = localMessageRecord;
      do
      {
        localObject = paramahbt;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (MessageRecord)localIterator.next();
      } while (localObject == null);
      if (((MessageRecord)localObject).uniseq == paramFileMsg.uniseq) {
        if ((localObject instanceof MessageForPic)) {
          paramahbt = (MessageForPic)localObject;
        }
      }
      for (;;)
      {
        break;
        if ((localObject instanceof MessageForMixedMsg))
        {
          localObject = ((MessageForMixedMsg)localObject).msgElemList.iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              localMessageRecord = (MessageRecord)((Iterator)localObject).next();
              if (((localMessageRecord instanceof MessageForPic)) && (((MessageForPic)localMessageRecord).subMsgId == paramFileMsg.mSubMsgId))
              {
                paramahbt = (MessageForPic)localMessageRecord;
                break;
              }
            }
          }
        }
      }
    }
  }
  
  private MessageRecord a(SpannableStringBuilder paramSpannableStringBuilder1, SpannableStringBuilder paramSpannableStringBuilder2)
  {
    MessageForText localMessageForText = (MessageForText)bcsa.a(-1000);
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
  
  private List<MessageRecord> a(List<MessageRecord> paramList, afqr paramafqr)
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
    a(paramafqr, com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(localSpannableStringBuilder1.toString()));
    return localArrayList;
  }
  
  private void a(afqr paramafqr, String paramString)
  {
    if (paramafqr.jdField_b_of_type_JavaLangStringBuilder == null) {
      paramafqr.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    if (e) {
      paramafqr.jdField_b_of_type_JavaLangStringBuilder.append(paramString);
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
    agfb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 2);
    Object localObject;
    int i;
    if (alvr.a().c())
    {
      localObject = alvr.a().b();
      if (localObject != null) {
        if (((CharSequence)localObject).length() != alvr.a().a())
        {
          i = 1;
          if (i != 0) {
            break label255;
          }
          localObject = alvr.a().c();
        }
      }
    }
    label61:
    label255:
    for (;;)
    {
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText((CharSequence)localObject);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
      if (i != 0) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramChatMessage.isMultiMsg) {
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D65", "0X8009D65", 3, 0, "3", "", "", "");
        }
        return;
        i = 0;
        break;
        i = 0;
        break;
        localObject = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
        i = 1;
        break label61;
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
      }
    }
  }
  
  private void a(ArrayList<bghy> paramArrayList, ArrayList<TextView> paramArrayList1, MessageRecord paramMessageRecord)
  {
    if (!bghx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
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
        localObject2 = (bghy)paramArrayList.get(i);
        if ((localObject2 == null) || (((bghy)localObject2).jdField_b_of_type_Int == -1))
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
          localStringBuilder.append(((bghy)localObject2).b());
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
      localTextView.setTag(2131366927, "school_troop_span");
      k = j;
      localObject2 = localObject1;
      break label139;
      if (((bghy)localObject2).jdField_b_of_type_Int < localObject1.jdField_b_of_type_Int)
      {
        localObject1 = localObject2;
        j = i;
        continue;
        if (localObject1 != null)
        {
          localObject2 = new bghy();
          ((bghy)localObject2).jdField_a_of_type_Long = paramMessageRecord.uniseq;
          ((bghy)localObject2).jdField_a_of_type_Int = localObject1.jdField_a_of_type_Int;
          ((bghy)localObject2).jdField_a_of_type_JavaLangString = localObject1.jdField_a_of_type_JavaLangString;
          ((bghy)localObject2).jdField_b_of_type_JavaLangString = localObject1.jdField_b_of_type_JavaLangString;
          ((bghy)localObject2).jdField_b_of_type_Int = localObject1.jdField_b_of_type_Int;
          ((bghy)localObject2).a(localStringBuilder.toString());
          ((bghy)localObject2).c = localObject1.c;
          ((bghy)localObject2).d = localObject1.d;
          ((Spannable)((TextView)paramArrayList1.get(j)).getText()).setSpan(new bghz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (bghy)localObject2), ((bghy)localObject2).c, ((bghy)localObject2).d, 17);
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
  
  private boolean a(ahbt paramahbt)
  {
    return (paramahbt.jdField_c_of_type_AndroidWidgetTextView != null) && (paramahbt.jdField_b_of_type_AndroidWidgetTextView != null) && (paramahbt.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (paramahbt.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null);
  }
  
  private void b(ChatMessage paramChatMessage, String paramString)
  {
    agfb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 3);
    Object localObject1;
    int i;
    if (alvr.a().c())
    {
      localObject1 = alvr.a().b();
      if (localObject1 != null) {
        if (((String)localObject1).length() == alvr.a().a())
        {
          i = 1;
          if (i != 0) {
            break label588;
          }
          localObject1 = alvr.a().c();
        }
      }
    }
    label59:
    label588:
    for (;;)
    {
      Bundle localBundle = new Bundle();
      Object localObject2;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext() != null))
      {
        localObject2 = bhhr.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
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
              break label539;
            }
            localBundle.putInt("forward_type", -5);
            localBundle.putLong("FORWARD_MSG_UNISEQ", paramChatMessage.uniseq);
            ((awyg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).a.put(Long.valueOf(paramChatMessage.uniseq), paramChatMessage);
            localBundle.putString("forward_text", (String)localObject1);
            localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
            localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
            localObject1 = new Intent();
            ((Intent)localObject1).putExtras(localBundle);
            aupt.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, 21);
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005637", "0X8005637", 0, 0, "", "", "", "");
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
            if (i == 0) {
              break label551;
            }
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
            if (paramChatMessage.isMultiMsg) {
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 9, 0, "9", "", "", "");
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
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      }
    }
  }
  
  private void c(ChatMessage paramChatMessage, String paramString)
  {
    agfb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 4);
    String str;
    int i;
    if (alvr.a().c())
    {
      str = alvr.a().b();
      if (str != null) {
        if (str.length() == alvr.a().a())
        {
          i = 1;
          if (i != 0) {
            break label308;
          }
          str = alvr.a().c();
        }
      }
    }
    label271:
    label308:
    for (;;)
    {
      label59:
      if ((i != 0) || (str == null))
      {
        bmad.b(paramChatMessage).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bman.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, 0, paramChatMessage.istroop);
        label111:
        bman.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
        if (i == 0) {
          break label271;
        }
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAC", 4, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramChatMessage.isMultiMsg) {
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 9, 0, "9", "", "", "");
        }
        return;
        i = 0;
        break;
        i = 0;
        break;
        str = null;
        i = 1;
        break label59;
        bman.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramChatMessage.istroop);
        bmad.a(null, str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        break label111;
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 4, 0, "", "", "", "");
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public afqq a(View paramView)
  {
    if (a(paramView)) {
      return this;
    }
    return null;
  }
  
  public afqr a()
  {
    return new ahbt(this);
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    ahbt localahbt = (ahbt)paramafqr;
    if (localahbt.jdField_b_of_type_JavaLangStringBuilder == null) {
      localahbt.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    bgls localbgls = (bgls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    if (QLog.isColorLevel()) {
      QLog.i("MixedMsgItemBuilder", 1, "getBubbleView: check is need refresh[" + localahbt.jdField_a_of_type_Boolean + "]");
    }
    if ((!e) && (ahbt.a(localahbt) != null) && (ahbt.a(localahbt) == paramChatMessage.uniseq) && (!localahbt.jdField_a_of_type_Boolean) && (android.text.TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))) {
      if (localbgls.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage))
      {
        localahbt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        paramafqr = paramView;
        if (localahbt != null)
        {
          paramafqr = paramView;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            localahbt.jdField_c_of_type_AndroidViewView = super.a(localahbt.jdField_c_of_type_AndroidViewView, localahbt, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 21.0F));
            super.a(localahbt.jdField_c_of_type_AndroidViewView, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
            paramafqr = paramView;
          }
        }
      }
    }
    do
    {
      do
      {
        return paramafqr;
        localahbt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        break;
        paramView = a(paramChatMessage, paramafqr, paramView, paramaftk, localahbt);
        paramafqr = afsl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramafqr != null) {
          paramafqr.a(paramView, this);
        }
        if (paramView != null) {
          paramView.setTag(localahbt);
        }
        if (localahbt.jdField_a_of_type_Alvu != null) {
          localahbt.jdField_a_of_type_Alvu.b(paramChatMessage);
        }
        paramafqr = paramView;
      } while (localahbt == null);
      paramafqr = paramView;
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    localahbt.jdField_c_of_type_AndroidViewView = super.a(localahbt.jdField_c_of_type_AndroidViewView, localahbt, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 21.0F));
    super.a(localahbt.jdField_c_of_type_AndroidViewView, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
    return paramView;
  }
  
  public bhjq a(bhjq parambhjq, ChatMessage paramChatMessage, afrk paramafrk)
  {
    int i = 0;
    parambhjq.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691218));
    if ((paramChatMessage instanceof MessageForMixedMsg)) {
      if (((MessageForMixedMsg)paramChatMessage).canSelectable()) {
        break label126;
      }
    }
    for (;;)
    {
      if (i != 0) {
        parambhjq.a(2131365307, this.jdField_a_of_type_AndroidContentContext.getString(2131717996), 2130838984);
      }
      parambhjq.a(2131367213, this.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838991);
      if (AIOUtils.getAIOMsgMenuDpcConfig(5) == 1) {
        parambhjq.a(2131366456, this.jdField_a_of_type_AndroidContentContext.getString(2131692126), 2130838990);
      }
      return parambhjq;
      if ((!(paramChatMessage instanceof MessageForLongMsg)) || (((MessageForLongMsg)paramChatMessage).canSelectable())) {
        label126:
        i = 1;
      }
    }
  }
  
  public MixedMsgLinearLayout a(afqr paramafqr, MixedMsgLinearLayout paramMixedMsgLinearLayout, List<MessageRecord> paramList, aftk paramaftk, MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList1 = new ArrayList(paramList);
    paramList = paramMixedMsgLinearLayout;
    if (paramMixedMsgLinearLayout == null)
    {
      paramList = new MixedMsgLinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramList.setId(2131364522);
      paramList.setOrientation(1);
      paramList.setFocusable(false);
      paramList.setClickable(true);
      paramList.setMinimumHeight(AIOUtils.dp2px(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramList.setPadding(2131296385, 2131296387, 2131296384, 2131296386);
      paramMixedMsgLinearLayout = new RelativeLayout.LayoutParams(-2, -2);
      paramMixedMsgLinearLayout.addRule(1, 2131368381);
      paramMixedMsgLinearLayout.addRule(3, 2131378673);
      paramMixedMsgLinearLayout.leftMargin = AIOUtils.dp2px(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramMixedMsgLinearLayout.rightMargin = AIOUtils.dp2px(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramList.setLayoutParams(paramMixedMsgLinearLayout);
      paramList.jdField_a_of_type_Bils = this.jdField_a_of_type_Bils;
      ahbt.a((ahbt)paramafqr, paramList);
      ((ahbt)paramafqr).jdField_a_of_type_Alvu = new alvu();
      ((ahbt)paramafqr).jdField_a_of_type_Alvu.a(paramList);
      ((ahbt)paramafqr).jdField_a_of_type_Alvu.a(paramafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
    }
    ((ahbt)paramafqr).e = -1;
    ((ahbt)paramafqr).jdField_a_of_type_Boolean = false;
    paramList.a(localArrayList1, (ahbt)paramafqr);
    if (bghx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {}
    for (paramMixedMsgLinearLayout = (bghx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SCHOOL_TROOP_KEYWORD_MANAGER);; paramMixedMsgLinearLayout = null)
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
      label545:
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
              ((ViewGroup)localObject2).setId(2131364550);
              ((ViewGroup)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).setOnTouchListener(paramaftk);
              ((ViewGroup)localObject2).setOnLongClickListener(paramaftk);
              ((ViewGroup)localObject2).findViewById(2131371598).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).findViewById(2131369455).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).findViewById(2131378885).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              if (android.text.TextUtils.isEmpty(((MessageForReplyText)localObject3).sb)) {
                break label769;
              }
              ((TextView)localObject4).setText(((MessageForReplyText)localObject3).sb);
              ((TextView)localObject4).setVisibility(0);
              if (paramMixedMsgLinearLayout != null)
              {
                localArrayList2.add(paramMixedMsgLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1));
                localArrayList3.add(localObject4);
              }
              localObject1 = (MessageForReplyText)localObject1;
              ahfa.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ViewGroup)localObject2, ((MessageForReplyText)localObject3).mSourceMsgInfo, this.jdField_a_of_type_Afti.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, ((MessageForReplyText)localObject3).istroop, (MessageRecord)localObject1, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
              localObject1 = ((ViewGroup)localObject2).findViewById(2131378885);
              if (localObject1 == null) {
                break label1253;
              }
              localObject1 = ((View)localObject1).getTag(2131364537);
              if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
                break label1253;
              }
              bool = ((Boolean)localObject1).booleanValue();
              ((ahbt)paramafqr).jdField_a_of_type_Boolean = bool;
            }
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MixedMsgItemBuilder", 1, "getMixedMsgLayout: reply check is need refresh[" + bool + "]");
        }
        label717:
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = BaseChatItemLayout.m;
        if (i == j - 1) {}
        for (((LinearLayout.LayoutParams)localObject1).bottomMargin = BaseChatItemLayout.m;; ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0)
        {
          localView.setOnTouchListener(paramaftk);
          localView.setOnLongClickListener(paramaftk);
          break;
          label769:
          ((TextView)localObject4).setVisibility(8);
          break label545;
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
            if (!bgls.b(paramMessageRecord)) {
              break label717;
            }
            bgls.a((TextView)localObject2, (MessageRecord)localObject1);
            break label717;
          }
          if ((localObject1 instanceof MessageForPic))
          {
            localObject1 = (MessageForPic)localObject1;
            localObject2 = (ChatThumbView)localView;
            localObject3 = new int[2];
            Object tmp907_905 = localObject3;
            tmp907_905[0] = 0;
            Object tmp911_907 = tmp907_905;
            tmp911_907[1] = 0;
            tmp911_907;
            localObject4 = ahcj.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localObject1, (ChatThumbView)localObject2, (int[])localObject3);
            ((ChatThumbView)localObject2).setTag(2131364536, localObject1);
            ((ChatThumbView)localObject2).setAdjustViewBounds(true);
            ((ChatThumbView)localObject2).setMaxWidth(CommonImgThumbHelper.getImgThumbMaxPx(ahcj.a((MessageForPic)localObject1)));
            ((ChatThumbView)localObject2).setMaxHeight(CommonImgThumbHelper.getImgThumbMaxPx(ahcj.a((MessageForPic)localObject1)));
            ((ChatThumbView)localObject2).setImageDrawable((Drawable)localObject4);
            String str = ((URLDrawable)localObject4).getURL().getProtocol();
            URL localURL = URLDrawableHelper.getURL((azkl)localObject1, 65537);
            if (ahcj.a(this.jdField_a_of_type_AndroidContentContext, blvp.a(((MessageForPic)localObject1).imageType), str.equals("chatthumb"), localObject3[0], localObject3[1], localURL))
            {
              ((URLDrawable)localObject4).setWatermarkDrawable(ahcj.a(), AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
            break label717;
          }
          QLog.e("MixedMsgItemBuilder", 2, "mixed type not support yet." + localObject1.getClass().getSimpleName());
          break label717;
        }
        a(localArrayList2, localArrayList3, paramMessageRecord);
        paramList.setOnTouchListener(paramaftk);
        paramList.setOnLongClickListener(paramaftk);
        paramList.b = this.jdField_a_of_type_Bils;
        return paramList;
        label1253:
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
    admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 6, 0, "", "", "", "");
    return;
    super.d(paramChatMessage);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 7, 0, "", "", "", "");
    return;
    a(paramChatMessage, str1);
    return;
    b(paramChatMessage, str1);
    return;
    c(paramChatMessage, str1);
    return;
    super.a(paramChatMessage);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 5, 0, "", "", "", "");
    return;
    alvr.a().a(paramChatMessage);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 2, 0, "", "", "", "");
    return;
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 3, 0, "", "", "", "");
    b(paramChatMessage);
  }
  
  public void a(afqr paramafqr, View paramView, ChatMessage paramChatMessage, aqhi paramaqhi)
  {
    ahbt localahbt = (ahbt)paramafqr;
    if ((localahbt.e != -1) && (a(localahbt)))
    {
      localahbt.jdField_c_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
      if ((paramaqhi.jdField_a_of_type_Int == 0) || (!paramaqhi.a()) || (bdfk.b()))
      {
        paramView = paramView.getResources();
        if (paramChatMessage.isSend())
        {
          paramafqr = paramView.getColorStateList(2131167049);
          localahbt.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramafqr);
          localahbt.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramafqr);
          localahbt.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramafqr);
          localahbt.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramafqr);
          localahbt.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramafqr);
          if (!paramChatMessage.isSend()) {
            break label226;
          }
        }
        label226:
        for (paramafqr = paramView.getColorStateList(2131167048);; paramafqr = paramView.getColorStateList(2131167047))
        {
          localahbt.jdField_c_of_type_AndroidWidgetTextView.setLinkTextColor(paramafqr);
          localahbt.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafqr);
          localahbt.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafqr);
          ImmersiveUtils.a(localahbt.jdField_b_of_type_AndroidWidgetTextView, 0.9F);
          ImmersiveUtils.a(localahbt.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
          ImmersiveUtils.a(localahbt.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
          ImmersiveUtils.a(localahbt.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
          return;
          paramafqr = paramView.getColorStateList(2131167045);
          break;
        }
      }
      if (paramaqhi.jdField_b_of_type_Int == 0)
      {
        localahbt.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localahbt.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localahbt.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localahbt.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        localahbt.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        if (paramaqhi.c != 0) {
          break label459;
        }
        paramafqr = paramView.getResources().getColorStateList(2131167047);
        localahbt.jdField_c_of_type_AndroidWidgetTextView.setLinkTextColor(paramafqr);
        localahbt.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafqr);
        localahbt.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafqr);
      }
      for (;;)
      {
        ImmersiveUtils.a(localahbt.jdField_b_of_type_AndroidWidgetTextView, 0.9F);
        ImmersiveUtils.a(localahbt.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
        ImmersiveUtils.a(localahbt.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        ImmersiveUtils.a(localahbt.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        return;
        localahbt.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramaqhi.jdField_b_of_type_Int);
        localahbt.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaqhi.jdField_b_of_type_Int);
        localahbt.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaqhi.jdField_b_of_type_Int);
        localahbt.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaqhi.jdField_b_of_type_Int);
        localahbt.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaqhi.jdField_b_of_type_Int);
        break;
        label459:
        localahbt.jdField_c_of_type_AndroidWidgetTextView.setLinkTextColor(paramaqhi.c);
        localahbt.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaqhi.c);
        localahbt.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaqhi.c);
      }
    }
    if ((paramaqhi.jdField_a_of_type_Int == 0) || (!paramaqhi.a()) || (bdfk.b()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramafqr = paramView.getColorStateList(2131167049);
        if (!paramChatMessage.isSend()) {
          break label580;
        }
      }
      label580:
      for (paramView = paramView.getColorStateList(2131167048);; paramView = paramView.getColorStateList(2131167047))
      {
        ahbt.a(localahbt).a(paramafqr, paramView);
        return;
        paramafqr = paramView.getColorStateList(2131167045);
        break;
      }
    }
    paramafqr = ColorStateList.valueOf(-16777216);
    paramView = paramView.getResources().getColorStateList(2131167047);
    if (paramaqhi.jdField_b_of_type_Int != 0) {
      paramafqr = ColorStateList.valueOf(paramaqhi.jdField_b_of_type_Int);
    }
    if (paramaqhi.c != 0) {
      paramView = ColorStateList.valueOf(paramaqhi.c);
    }
    ahbt.a(localahbt).a(paramafqr, paramView);
  }
  
  public void a(afqr paramafqr, ChatMessage paramChatMessage)
  {
    paramafqr = (ahbt)paramafqr;
    if (ahbt.a(paramafqr) != null) {
      ahbt.a(paramafqr).a(gm.a(paramChatMessage));
    }
    if ((paramafqr.e != -1) && (a(paramafqr)))
    {
      paramChatMessage = gm.a("");
      paramafqr.jdField_c_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
      paramafqr.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
      paramafqr.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
      paramafqr.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
    }
  }
  
  public void a(View paramView)
  {
    paramView = (ahbt)AIOUtils.getHolder(paramView);
    if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
    {
      paramView = (MessageForMixedMsg)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_AndroidContentContext, null);
        localbkzi.a(2131689976, 5);
        localbkzi.c(2131690697);
        localbkzi.a(new ahbs(this, paramView, localbkzi));
        localbkzi.show();
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
    paramView = (ahbt)paramView.getTag();
    int i = BaseChatItemLayout.h;
    if (paramChatMessage.isSend())
    {
      ahbt.a(paramView).setPadding(ahit.f, i, ahit.e, ahit.d);
      return;
    }
    ahbt.a(paramView).setPadding(ahit.e, i, ahit.f, ahit.d);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2003) {}
    label275:
    for (;;)
    {
      return;
      paramView = (ahbt)AIOUtils.getHolder(paramView);
      paramFileMsg = a(paramFileMsg, paramView);
      if (paramFileMsg != null)
      {
        paramInt2 = ahbt.a(paramView).getChildCount();
        paramInt1 = 0;
        Object localObject1;
        Object localObject2;
        if (paramInt1 < paramInt2)
        {
          localObject1 = ahbt.a(paramView).getChildAt(paramInt1);
          if ((localObject1 instanceof ChatThumbView))
          {
            localObject2 = ((ChatThumbView)localObject1).getTag(2131364536);
            if ((!(localObject2 instanceof MessageForPic)) || (((MessageForPic)localObject2).uniseq != paramFileMsg.uniseq) || (((MessageForPic)localObject2).subMsgId != paramFileMsg.subMsgId)) {}
          }
        }
        for (paramView = (ChatThumbView)localObject1;; paramView = null)
        {
          if (paramView == null) {
            break label275;
          }
          localObject1 = new int[2];
          tmp131_129 = localObject1;
          tmp131_129[0] = 0;
          tmp135_131 = tmp131_129;
          tmp135_131[1] = 0;
          tmp135_131;
          localObject2 = ahcj.a(this.jdField_a_of_type_AndroidContentContext, paramFileMsg, paramView, (int[])localObject1);
          String str = ((URLDrawable)localObject2).getURL().getProtocol();
          URL localURL = URLDrawableHelper.getURL(paramFileMsg, 65537);
          boolean bool = ahcj.a(this.jdField_a_of_type_AndroidContentContext, blvp.a(paramFileMsg.imageType), str.equals("chatthumb"), localObject1[0], localObject1[1], localURL);
          paramView.setImageDrawable((Drawable)localObject2);
          if (bool)
          {
            ((URLDrawable)localObject2).setWatermarkDrawable(ahcj.a(), AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            ((URLDrawable)localObject2).setWatermarkVisibility(0);
            return;
            paramInt1 += 1;
            break;
          }
          ((URLDrawable)localObject2).setWatermarkVisibility(4);
          return;
        }
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Object localObject = (ahbt)AIOUtils.getHolder(paramView);
    if ((!paramBoolean) && ((paramView instanceof ChatThumbView))) {
      ((ChatThumbView)paramView).a(paramView, true);
    }
    localObject = ahbt.a((ahbt)localObject).getBackground();
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
  
  public bhjs[] a(View paramView)
  {
    paramView = (ahbt)AIOUtils.getHolder(paramView);
    ChatMessage localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    bhjq localbhjq = new bhjq();
    if (localChatMessage != null)
    {
      if (!localChatMessage.isMultiMsg) {
        break label45;
      }
      a(localbhjq, localChatMessage, null);
    }
    for (;;)
    {
      return localbhjq.a();
      label45:
      b(localbhjq, localChatMessage, paramView);
    }
  }
  
  public bhjq b(bhjq parambhjq, ChatMessage paramChatMessage, afrk paramafrk)
  {
    parambhjq.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691218));
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
        parambhjq.a(2131365307, this.jdField_a_of_type_AndroidContentContext.getString(2131717996), 2130838984);
      }
      parambhjq.a(2131367213, this.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838991);
      a(paramChatMessage, parambhjq);
      a(parambhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramafrk.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      a(parambhjq, paramChatMessage);
      if (AIOUtils.getAIOMsgMenuDpcConfig(5) == 1) {
        parambhjq.a(2131366456, this.jdField_a_of_type_AndroidContentContext.getString(2131692126), 2130838990);
      }
      super.a(parambhjq, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      c(paramChatMessage, parambhjq);
      b(paramChatMessage, parambhjq);
      super.c(parambhjq, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambhjq, this.jdField_a_of_type_AndroidContentContext);
      return parambhjq;
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
 * Qualified Name:     ahbp
 * JD-Core Version:    0.7.0.1
 */