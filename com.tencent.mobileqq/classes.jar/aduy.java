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

public class aduy
  extends BaseBubbleBuilder
  implements acui, acwb
{
  private acxi jdField_a_of_type_Acxi = new acxi();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private bcjp jdField_a_of_type_Bcjp = new adva(this);
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private View.OnClickListener b;
  protected long c;
  
  public aduy(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new aduz(this);
    this.jdField_a_of_type_Acxi.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new avqw(this);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder1, SpannableStringBuilder paramSpannableStringBuilder2, List<MessageRecord> paramList)
  {
    if (paramSpannableStringBuilder1.length() > 0)
    {
      MessageRecord localMessageRecord = axas.a(-1000);
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
  
  private void a(ArrayList<bair> paramArrayList, ArrayList<TextView> paramArrayList1, MessageRecord paramMessageRecord)
  {
    if (!baiq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
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
        localObject2 = (bair)paramArrayList.get(i);
        if ((localObject2 == null) || (((bair)localObject2).jdField_b_of_type_Int == -1))
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
          localStringBuilder.append(((bair)localObject2).b());
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
      localTextView.setTag(2131366359, "school_troop_span");
      k = j;
      localObject2 = localObject1;
      break label138;
      if (((bair)localObject2).jdField_b_of_type_Int < localObject1.jdField_b_of_type_Int)
      {
        localObject1 = localObject2;
        j = i;
        continue;
        if (localObject1 != null)
        {
          localObject2 = new bair();
          ((bair)localObject2).jdField_a_of_type_Long = paramMessageRecord.uniseq;
          ((bair)localObject2).jdField_a_of_type_Int = localObject1.jdField_a_of_type_Int;
          ((bair)localObject2).jdField_a_of_type_JavaLangString = localObject1.jdField_a_of_type_JavaLangString;
          ((bair)localObject2).jdField_b_of_type_JavaLangString = localObject1.jdField_b_of_type_JavaLangString;
          ((bair)localObject2).jdField_b_of_type_Int = localObject1.jdField_b_of_type_Int;
          ((bair)localObject2).a(localStringBuilder.toString());
          ((bair)localObject2).c = localObject1.c;
          ((bair)localObject2).d = localObject1.d;
          ((Spannable)((TextView)paramArrayList1.get(j)).getText()).setSpan(new bais(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (bair)localObject2), ((bair)localObject2).c, ((bair)localObject2).d, 17);
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
  
  private boolean a(advc paramadvc)
  {
    return (paramadvc.jdField_b_of_type_AndroidWidgetTextView != null) && (paramadvc.jdField_a_of_type_AndroidWidgetTextView != null) && (paramadvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (paramadvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public acui a(View paramView)
  {
    if (a(paramView)) {
      return this;
    }
    return null;
  }
  
  public acuj a()
  {
    return new advc(this);
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    advc localadvc = (advc)paramacuj;
    if (paramacuj.b == null) {
      paramacuj.b = new StringBuilder();
    }
    Object localObject1 = (bamk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    if (QLog.isColorLevel()) {
      QLog.i("MixedMsgItemBuilder", 1, "getBubbleView: check is need refresh[" + localadvc.jdField_a_of_type_Boolean + "]");
    }
    if ((!e) && (advc.a(localadvc) != null) && (advc.a(localadvc) == paramChatMessage.uniseq) && (!localadvc.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info"))))
    {
      if (((bamk)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage))
      {
        localadvc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return paramView;
      }
      localadvc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return paramView;
    }
    Object localObject2;
    Object localObject3;
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      paramBaseChatItemLayout = (MessageForMixedMsg)paramChatMessage;
      if (e)
      {
        if (bbfh.a(paramChatMessage.issend)) {
          paramacuj.b.append("发出");
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
            paramacuj.b.append("图片");
          }
          localObject3 = (MessageForPic)localObject3;
          if (((MessageForPic)localObject3).time != 0L) {
            continue;
          }
          MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject3, paramBaseChatItemLayout);
          continue;
          paramacuj.b.append("发来");
          break;
        }
        if ((localObject3 instanceof MessageForReplyText))
        {
          if (((MessageForReplyText)localObject3).time == 0L) {
            MessageForMixedMsg.copyBaseInfoFromMixedToNormal((MessageRecord)localObject3, paramBaseChatItemLayout);
          }
        }
        else if (e) {
          paramacuj.b.append(aylc.b(((MessageRecord)localObject3).msg));
        }
      }
      label379:
      paramBaseChatItemLayout = a(paramacuj, (MixedMsgLinearLayout)paramView, paramBaseChatItemLayout.msgElemList, paramacxj, paramBaseChatItemLayout);
      advc.a((advc)paramacuj, paramChatMessage.uniseq);
      if (((bamk)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
        localadvc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      }
    }
    for (;;)
    {
      paramacuj = acvz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramacuj != null) {
        paramacuj.a(paramBaseChatItemLayout, this);
      }
      if (paramBaseChatItemLayout != null) {
        paramBaseChatItemLayout.setTag(localadvc);
      }
      paramView = paramBaseChatItemLayout;
      if (localadvc.jdField_a_of_type_Aibq == null) {
        break;
      }
      localadvc.jdField_a_of_type_Aibq.b(paramChatMessage);
      return paramBaseChatItemLayout;
      localadvc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      continue;
      paramBaseChatItemLayout = paramView;
      if ((paramChatMessage instanceof MessageForLongMsg))
      {
        localObject3 = (MessageForLongMsg)paramChatMessage;
        if (e) {
          paramacuj.b.append("说");
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
            paramView = a(paramacuj, (MixedMsgLinearLayout)paramView, (List)localObject2, paramacxj, paramChatMessage);
            advc.a((advc)paramacuj, paramChatMessage.uniseq);
            paramBaseChatItemLayout = paramView;
            if (e)
            {
              paramacuj.b.append(aylc.e(((SpannableStringBuilder)localObject1).toString()));
              paramBaseChatItemLayout = paramView;
            }
          }
        }
      }
    }
  }
  
  public bbmf a(bbmf parambbmf, ChatMessage paramChatMessage, acva paramacva)
  {
    int i = 0;
    parambbmf.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691236));
    if ((paramChatMessage instanceof MessageForMixedMsg)) {
      if (((MessageForMixedMsg)paramChatMessage).canSelectable()) {
        break label126;
      }
    }
    for (;;)
    {
      if (i != 0) {
        parambbmf.a(2131364824, this.jdField_a_of_type_AndroidContentContext.getString(2131718661), 2130838599);
      }
      parambbmf.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692753), 2130838606);
      if (actj.a(5) == 1) {
        parambbmf.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131692324), 2130838605);
      }
      return parambbmf;
      if ((!(paramChatMessage instanceof MessageForLongMsg)) || (((MessageForLongMsg)paramChatMessage).canSelectable())) {
        label126:
        i = 1;
      }
    }
  }
  
  public MixedMsgLinearLayout a(acuj paramacuj, MixedMsgLinearLayout paramMixedMsgLinearLayout, List<MessageRecord> paramList, acxj paramacxj, MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList1 = new ArrayList(paramList);
    paramList = paramMixedMsgLinearLayout;
    if (paramMixedMsgLinearLayout == null)
    {
      paramList = new MixedMsgLinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramList.setId(2131364109);
      paramList.setOrientation(1);
      paramList.setFocusable(false);
      paramList.setClickable(true);
      paramList.setMinimumHeight(actj.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramList.setPadding(2131296288, 2131296290, 2131296287, 2131296289);
      paramMixedMsgLinearLayout = new RelativeLayout.LayoutParams(-2, -2);
      paramMixedMsgLinearLayout.addRule(1, 2131367679);
      paramMixedMsgLinearLayout.addRule(3, 2131377046);
      paramMixedMsgLinearLayout.leftMargin = actj.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramMixedMsgLinearLayout.rightMargin = actj.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramList.setLayoutParams(paramMixedMsgLinearLayout);
      paramList.jdField_a_of_type_Bcjp = this.jdField_a_of_type_Bcjp;
      advc.a((advc)paramacuj, paramList);
      ((advc)paramacuj).jdField_a_of_type_Aibq = new aibq();
      ((advc)paramacuj).jdField_a_of_type_Aibq.a(paramList);
      ((advc)paramacuj).jdField_a_of_type_Aibq.a(paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
    }
    ((advc)paramacuj).e = -1;
    ((advc)paramacuj).jdField_a_of_type_Boolean = false;
    paramList.a(localArrayList1, (advc)paramacuj);
    if (baiq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {}
    for (paramMixedMsgLinearLayout = (baiq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262);; paramMixedMsgLinearLayout = null)
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
              ((ViewGroup)localObject2).setId(2131364137);
              ((ViewGroup)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).setOnTouchListener(paramacxj);
              ((ViewGroup)localObject2).setOnLongClickListener(paramacxj);
              ((ViewGroup)localObject2).findViewById(2131370452).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).findViewById(2131368616).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).findViewById(2131377248).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
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
              adyf.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ViewGroup)localObject2, ((MessageForReplyText)localObject3).mSourceMsgInfo, this.jdField_a_of_type_Acxi.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((MessageForReplyText)localObject3).istroop, (MessageRecord)localObject1, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
              localObject1 = ((ViewGroup)localObject2).findViewById(2131377248);
              if (localObject1 == null) {
                break label1233;
              }
              localObject1 = ((View)localObject1).getTag(2131364124);
              if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
                break label1233;
              }
              bool = ((Boolean)localObject1).booleanValue();
              ((advc)paramacuj).jdField_a_of_type_Boolean = bool;
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
          localView.setOnTouchListener(paramacxj);
          localView.setOnLongClickListener(paramacxj);
          break;
          label761:
          ((TextView)localObject4).setVisibility(8);
          break label537;
          if ((localObject1 instanceof MessageForText))
          {
            localObject2 = (AnimationTextView)localView;
            ((AnimationTextView)localObject2).setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
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
              if (!bamk.b(paramMessageRecord)) {
                break;
              }
              bamk.a((TextView)localObject2, (MessageRecord)localObject1);
              break;
              ((AnimationTextView)localObject2).setText(((MessageForText)localObject1).sb);
            }
          }
          if ((localObject1 instanceof MessageForPic))
          {
            localObject1 = (MessageForPic)localObject1;
            localObject2 = (ChatThumbView)localView;
            localObject3 = new int[2];
            Object tmp919_917 = localObject3;
            tmp919_917[0] = 0;
            Object tmp923_919 = tmp919_917;
            tmp923_919[1] = 0;
            tmp923_919;
            localObject4 = advs.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localObject1, (ChatThumbView)localObject2, (int[])localObject3);
            ((ChatThumbView)localObject2).setTag(2131364123, localObject1);
            ((ChatThumbView)localObject2).setImageDrawable((Drawable)localObject4);
            String str = ((URLDrawable)localObject4).getURL().getProtocol();
            URL localURL = aywm.a((auoc)localObject1, 65537);
            if (advs.a(this.jdField_a_of_type_AndroidContentContext, bgky.a(((MessageForPic)localObject1).imageType), str.equals("chatthumb"), localObject3[0], localObject3[1], localURL))
            {
              ((URLDrawable)localObject4).setWatermarkDrawable(advs.a(), actj.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
        paramList.setOnTouchListener(paramacxj);
        paramList.setOnLongClickListener(paramacxj);
        paramList.b = this.jdField_a_of_type_Bcjp;
        return paramList;
        label1233:
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
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    }
    for (Object localObject1 = "";; localObject1 = "") {
      switch (paramInt)
      {
      default: 
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
    }
    aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 6, 0, "", "", "", "");
    return;
    super.d(paramChatMessage);
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 7, 0, "", "", "", "");
    return;
    adfy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 2);
    if (aibn.a().c())
    {
      paramContext = aibn.a().a();
      if (paramContext != null) {
        if (paramContext.length() != aibn.a().a())
        {
          paramInt = 1;
          label265:
          if (paramInt != 0) {
            break label1493;
          }
          paramContext = aibn.a().b();
        }
      }
    }
    label276:
    label1103:
    label1490:
    label1493:
    for (;;)
    {
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramContext);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
      if (paramInt != 0) {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
      }
      while (paramChatMessage.isMultiMsg)
      {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D65", "0X8009D65", 3, 0, "3", "", "", "");
        return;
        paramInt = 0;
        break label265;
        paramInt = 0;
        break label265;
        paramContext = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
        paramInt = 1;
        break label276;
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
      }
      adfy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 3);
      if (aibn.a().c())
      {
        paramContext = aibn.a().a();
        if (paramContext != null) {
          if (paramContext.length() == aibn.a().a())
          {
            paramInt = 1;
            if (paramInt != 0) {
              break label1490;
            }
            paramContext = aibn.a().b();
          }
        }
      }
      for (;;)
      {
        localObject2 = new Bundle();
        Object localObject3;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext() != null))
        {
          localObject3 = bbkb.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
          if ((localObject3 != null) && (((String)localObject3).length() > 0))
          {
            localObject3 = ((String)localObject3).split("\\|");
            if ((localObject3 == null) || (localObject3.length <= 0)) {}
          }
        }
        for (;;)
        {
          try
          {
            int i = Integer.parseInt(localObject3[0]);
            if (QLog.isColorLevel()) {
              QLog.d("MixedMsgItemBuilder", 2, "get mixMsgForward switch From config : configSwitch = " + i);
            }
            if (i == 1)
            {
              i = 1;
              if ((paramInt == 0) || (i == 0)) {
                break label1005;
              }
              ((Bundle)localObject2).putInt("forward_type", -5);
              ((Bundle)localObject2).putLong("FORWARD_MSG_UNISEQ", paramChatMessage.uniseq);
              ((asju)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a.put(Long.valueOf(paramChatMessage.uniseq), paramChatMessage);
              ((Bundle)localObject2).putString("forward_text", paramContext);
              ((Bundle)localObject2).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              ((Bundle)localObject2).putInt("selection_mode", this.jdField_b_of_type_Int);
              paramContext = new Intent();
              paramContext.putExtras((Bundle)localObject2);
              aqbe.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005637", "0X8005637", 0, 0, "", "", "", "");
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
              if (paramInt == 0) {
                break label1017;
              }
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
              if (!paramChatMessage.isMultiMsg) {
                break;
              }
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 9, 0, "9", "", "", "");
              return;
              paramInt = 0;
              break label518;
              paramInt = 0;
              break label518;
              paramContext = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString();
              paramInt = 1;
              break label529;
            }
            i = 0;
            continue;
            i = 1;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            if (QLog.isColorLevel()) {
              QLog.e("MixedMsgItemBuilder", 2, "get mixMsgForward switch from config error", localNumberFormatException);
            }
          }
          continue;
          label1005:
          ((Bundle)localObject2).putInt("forward_type", -1);
          continue;
          label1017:
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
        }
        adfy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 4);
        if (aibn.a().c())
        {
          paramContext = aibn.a().a();
          if (paramContext != null) {
            if (paramContext.length() == aibn.a().a())
            {
              paramInt = 1;
              if (paramInt != 0) {
                break label1487;
              }
              paramContext = aibn.a().b();
            }
          }
        }
        for (;;)
        {
          label1114:
          if ((paramInt != 0) || (paramContext == null))
          {
            bgpu.b(paramChatMessage).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            bgqi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, 0, paramChatMessage.istroop);
            bgqi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
            if (paramInt == 0) {
              break label1324;
            }
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAC", 4, 0, "", "", "", "");
          }
          while (paramChatMessage.isMultiMsg)
          {
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 9, 0, "9", "", "", "");
            return;
            paramInt = 0;
            break label1103;
            paramInt = 0;
            break label1103;
            paramContext = null;
            paramInt = 1;
            break label1114;
            bgqi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramChatMessage.istroop);
            bgpu.a(null, paramContext).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            break label1165;
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAC", "0X8009AAC", 4, 0, "", "", "", "");
          }
          super.a(paramChatMessage);
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 5, 0, "", "", "", "");
          return;
          aibn.a().a(paramChatMessage);
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAC", "0X8009AAC", 2, 0, "", "", "", "");
          return;
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 3, 0, "", "", "", "");
          b(paramChatMessage);
          return;
        }
      }
    }
  }
  
  public void a(acuj paramacuj, View paramView, ChatMessage paramChatMessage, ambg paramambg)
  {
    advc localadvc = (advc)paramacuj;
    if ((localadvc.e != -1) && (a(localadvc)))
    {
      localadvc.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      if ((paramambg.jdField_a_of_type_Int == 0) || (!paramambg.a()) || (axmv.b()))
      {
        paramView = paramView.getResources();
        if (paramChatMessage.isSend())
        {
          paramacuj = paramView.getColorStateList(2131166876);
          localadvc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramacuj);
          localadvc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramacuj);
          localadvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramacuj);
          localadvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramacuj);
          if (!paramChatMessage.isSend()) {
            break label206;
          }
        }
        label206:
        for (paramacuj = paramView.getColorStateList(2131166875);; paramacuj = paramView.getColorStateList(2131166874))
        {
          localadvc.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramacuj);
          localadvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacuj);
          localadvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacuj);
          ImmersiveUtils.a(localadvc.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
          ImmersiveUtils.a(localadvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
          ImmersiveUtils.a(localadvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
          return;
          paramacuj = paramView.getColorStateList(2131166872);
          break;
        }
      }
      if (paramambg.jdField_b_of_type_Int == 0)
      {
        localadvc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localadvc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localadvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        localadvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        if (paramambg.c != 0) {
          break label404;
        }
        paramacuj = paramView.getResources().getColorStateList(2131166874);
        localadvc.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramacuj);
        localadvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacuj);
        localadvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacuj);
      }
      for (;;)
      {
        ImmersiveUtils.a(localadvc.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
        ImmersiveUtils.a(localadvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        ImmersiveUtils.a(localadvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        return;
        localadvc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramambg.jdField_b_of_type_Int);
        localadvc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramambg.jdField_b_of_type_Int);
        localadvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramambg.jdField_b_of_type_Int);
        localadvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramambg.jdField_b_of_type_Int);
        break;
        label404:
        localadvc.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramambg.c);
        localadvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramambg.c);
        localadvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramambg.c);
      }
    }
    if ((paramambg.jdField_a_of_type_Int == 0) || (!paramambg.a()) || (axmv.b()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramacuj = paramView.getColorStateList(2131166876);
        if (!paramChatMessage.isSend()) {
          break label525;
        }
      }
      label525:
      for (paramView = paramView.getColorStateList(2131166875);; paramView = paramView.getColorStateList(2131166874))
      {
        advc.a(localadvc).a(paramacuj, paramView);
        return;
        paramacuj = paramView.getColorStateList(2131166872);
        break;
      }
    }
    paramacuj = ColorStateList.valueOf(-16777216);
    paramView = paramView.getResources().getColorStateList(2131166874);
    if (paramambg.jdField_b_of_type_Int != 0) {
      paramacuj = ColorStateList.valueOf(paramambg.jdField_b_of_type_Int);
    }
    if (paramambg.c != 0) {
      paramView = ColorStateList.valueOf(paramambg.c);
    }
    advc.a(localadvc).a(paramacuj, paramView);
  }
  
  public void a(acuj paramacuj, ChatMessage paramChatMessage)
  {
    paramacuj = (advc)paramacuj;
    if (advc.a(paramacuj) != null) {
      advc.a(paramacuj).a(ia.a(paramChatMessage));
    }
    if ((paramacuj.e != -1) && (a(paramacuj)))
    {
      paramChatMessage = ia.a("");
      paramacuj.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
      paramacuj.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
      paramacuj.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
      paramacuj.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
    }
  }
  
  public void a(View paramView)
  {
    paramView = (advc)actj.a(paramView);
    if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
    {
      paramView = (MessageForMixedMsg)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        bfpc localbfpc = (bfpc)bfpp.a(this.jdField_a_of_type_AndroidContentContext, null);
        localbfpc.a(2131689995, 5);
        localbfpc.c(2131690596);
        localbfpc.a(new advb(this, paramView, localbfpc));
        localbfpc.show();
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
  
  public void a(View paramView, ayqo paramayqo, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2003) {}
    label68:
    label585:
    label593:
    for (;;)
    {
      return;
      Object localObject1 = (advc)actj.a(paramView);
      paramView = null;
      Object localObject2;
      if ((((advc)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
      {
        paramView = (MessageForMixedMsg)((advc)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if ((advc.a((advc)localObject1) != null) && (paramView != null) && (paramView.msgElemList != null)) {
          for (paramView = paramView.msgElemList.iterator(); paramView.hasNext(); paramView = (MessageForPic)localObject2)
          {
            localObject2 = (MessageRecord)paramView.next();
            if ((localObject2 == null) || (((MessageRecord)localObject2).uniseq != paramayqo.b) || (!(localObject2 instanceof MessageForPic)) || (((MessageForPic)localObject2).subMsgId != paramayqo.c)) {
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
          paramInt2 = advc.a((advc)localObject1).getChildCount();
          paramInt1 = 0;
          label232:
          Object localObject3;
          Object localObject4;
          if (paramInt1 < paramInt2)
          {
            paramayqo = advc.a((advc)localObject1).getChildAt(paramInt1);
            if ((paramayqo instanceof ChatThumbView))
            {
              localObject2 = ((ChatThumbView)paramayqo).getTag(2131364123);
              if (((localObject2 instanceof MessageForPic)) && (((MessageForPic)localObject2).uniseq == paramView.uniseq) && (((MessageForPic)localObject2).subMsgId == paramView.subMsgId))
              {
                paramayqo = (ChatThumbView)paramayqo;
                if (paramayqo == null) {
                  break label577;
                }
                localObject1 = new int[2];
                tmp243_241 = localObject1;
                tmp243_241[0] = 0;
                tmp247_243 = tmp243_241;
                tmp247_243[1] = 0;
                tmp247_243;
                localObject2 = advs.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramayqo, (int[])localObject1);
                localObject3 = ((URLDrawable)localObject2).getURL().getProtocol();
                localObject4 = aywm.a(paramView, 65537);
                boolean bool = advs.a(this.jdField_a_of_type_AndroidContentContext, bgky.a(paramView.imageType), ((String)localObject3).equals("chatthumb"), localObject1[0], localObject1[1], (URL)localObject4);
                paramayqo.setImageDrawable((Drawable)localObject2);
                if (!bool) {
                  break label567;
                }
                ((URLDrawable)localObject2).setWatermarkDrawable(advs.a(), actj.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                ((URLDrawable)localObject2).setWatermarkVisibility(0);
                return;
                if (!(((advc)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForLongMsg)) {
                  break label585;
                }
                localObject2 = (MessageForLongMsg)((advc)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
                if (((MessageRecord)localObject3).uniseq != paramayqo.b) {
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
                  if (((localObject4 instanceof MessageForPic)) && (((MessageForPic)localObject4).subMsgId == paramayqo.c))
                  {
                    paramView = (MessageForPic)localObject4;
                    break label478;
                    paramInt1 += 1;
                    break label153;
                    ((URLDrawable)localObject2).setWatermarkVisibility(4);
                    return;
                    paramayqo = null;
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
    paramView = (advc)paramView.getTag();
    int i = BaseChatItemLayout.g;
    if (paramChatMessage.isSend())
    {
      advc.a(paramView).setPadding(aebx.f, i, aebx.e, aebx.d);
      return;
    }
    advc.a(paramView).setPadding(aebx.e, i, aebx.f, aebx.d);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Object localObject = (advc)actj.a(paramView);
    if ((!paramBoolean) && ((paramView instanceof ChatThumbView))) {
      ((ChatThumbView)paramView).a(paramView, true);
    }
    localObject = advc.a((advc)localObject).getBackground();
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
  
  public bbmh[] a(View paramView)
  {
    paramView = (advc)actj.a(paramView);
    ChatMessage localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    bbmf localbbmf = new bbmf();
    if (localChatMessage != null)
    {
      if (!localChatMessage.isMultiMsg) {
        break label45;
      }
      a(localbbmf, localChatMessage, null);
    }
    for (;;)
    {
      return localbbmf.a();
      label45:
      b(localbbmf, localChatMessage, paramView);
    }
  }
  
  public bbmf b(bbmf parambbmf, ChatMessage paramChatMessage, acva paramacva)
  {
    parambbmf.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691236));
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
        parambbmf.a(2131364824, this.jdField_a_of_type_AndroidContentContext.getString(2131718661), 2130838599);
      }
      parambbmf.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692753), 2130838606);
      a(paramChatMessage, parambbmf);
      a(parambbmf, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramacva.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      a(parambbmf, paramChatMessage);
      if (actj.a(5) == 1) {
        parambbmf.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131692324), 2130838605);
      }
      b(paramChatMessage, parambbmf);
      super.c(parambbmf, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambbmf, this.jdField_a_of_type_AndroidContentContext);
      return parambbmf;
      if (((paramChatMessage instanceof MessageForLongMsg)) && (!((MessageForLongMsg)paramChatMessage).canSelectable())) {
        i = 0;
      } else {
        label184:
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aduy
 * JD-Core Version:    0.7.0.1
 */