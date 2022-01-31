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

public class adva
  extends BaseBubbleBuilder
  implements acum, acwf
{
  private acxm jdField_a_of_type_Acxm = new acxm();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private bcjb jdField_a_of_type_Bcjb = new advc(this);
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private View.OnClickListener b;
  protected long c;
  
  public adva(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new advb(this);
    this.jdField_a_of_type_Acxm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new avqu(this);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder1, SpannableStringBuilder paramSpannableStringBuilder2, List<MessageRecord> paramList)
  {
    if (paramSpannableStringBuilder1.length() > 0)
    {
      MessageRecord localMessageRecord = axaq.a(-1000);
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
  
  private void a(ArrayList<baid> paramArrayList, ArrayList<TextView> paramArrayList1, MessageRecord paramMessageRecord)
  {
    if (!baic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
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
        localObject2 = (baid)paramArrayList.get(i);
        if ((localObject2 == null) || (((baid)localObject2).jdField_b_of_type_Int == -1))
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
          localStringBuilder.append(((baid)localObject2).b());
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
      if (((baid)localObject2).jdField_b_of_type_Int < localObject1.jdField_b_of_type_Int)
      {
        localObject1 = localObject2;
        j = i;
        continue;
        if (localObject1 != null)
        {
          localObject2 = new baid();
          ((baid)localObject2).jdField_a_of_type_Long = paramMessageRecord.uniseq;
          ((baid)localObject2).jdField_a_of_type_Int = localObject1.jdField_a_of_type_Int;
          ((baid)localObject2).jdField_a_of_type_JavaLangString = localObject1.jdField_a_of_type_JavaLangString;
          ((baid)localObject2).jdField_b_of_type_JavaLangString = localObject1.jdField_b_of_type_JavaLangString;
          ((baid)localObject2).jdField_b_of_type_Int = localObject1.jdField_b_of_type_Int;
          ((baid)localObject2).a(localStringBuilder.toString());
          ((baid)localObject2).c = localObject1.c;
          ((baid)localObject2).d = localObject1.d;
          ((Spannable)((TextView)paramArrayList1.get(j)).getText()).setSpan(new baie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (baid)localObject2), ((baid)localObject2).c, ((baid)localObject2).d, 17);
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
  
  private boolean a(adve paramadve)
  {
    return (paramadve.jdField_b_of_type_AndroidWidgetTextView != null) && (paramadve.jdField_a_of_type_AndroidWidgetTextView != null) && (paramadve.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (paramadve.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public acum a(View paramView)
  {
    if (a(paramView)) {
      return this;
    }
    return null;
  }
  
  public acun a()
  {
    return new adve(this);
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    adve localadve = (adve)paramacun;
    if (paramacun.b == null) {
      paramacun.b = new StringBuilder();
    }
    Object localObject1 = (balw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    if (QLog.isColorLevel()) {
      QLog.i("MixedMsgItemBuilder", 1, "getBubbleView: check is need refresh[" + localadve.jdField_a_of_type_Boolean + "]");
    }
    if ((!e) && (adve.a(localadve) != null) && (adve.a(localadve) == paramChatMessage.uniseq) && (!localadve.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info"))))
    {
      if (((balw)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage))
      {
        localadve.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return paramView;
      }
      localadve.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return paramView;
    }
    Object localObject2;
    Object localObject3;
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      paramBaseChatItemLayout = (MessageForMixedMsg)paramChatMessage;
      if (e)
      {
        if (bbet.a(paramChatMessage.issend)) {
          paramacun.b.append("发出");
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
            paramacun.b.append("图片");
          }
          localObject3 = (MessageForPic)localObject3;
          if (((MessageForPic)localObject3).time != 0L) {
            continue;
          }
          MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject3, paramBaseChatItemLayout);
          continue;
          paramacun.b.append("发来");
          break;
        }
        if ((localObject3 instanceof MessageForReplyText))
        {
          if (((MessageForReplyText)localObject3).time == 0L) {
            MessageForMixedMsg.copyBaseInfoFromMixedToNormal((MessageRecord)localObject3, paramBaseChatItemLayout);
          }
        }
        else if (e) {
          paramacun.b.append(ayla.b(((MessageRecord)localObject3).msg));
        }
      }
      label379:
      paramBaseChatItemLayout = a(paramacun, (MixedMsgLinearLayout)paramView, paramBaseChatItemLayout.msgElemList, paramacxn, paramBaseChatItemLayout);
      adve.a((adve)paramacun, paramChatMessage.uniseq);
      if (((balw)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
        localadve.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      }
    }
    for (;;)
    {
      paramacun = acwd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramacun != null) {
        paramacun.a(paramBaseChatItemLayout, this);
      }
      if (paramBaseChatItemLayout != null) {
        paramBaseChatItemLayout.setTag(localadve);
      }
      paramView = paramBaseChatItemLayout;
      if (localadve.jdField_a_of_type_Aibs == null) {
        break;
      }
      localadve.jdField_a_of_type_Aibs.b(paramChatMessage);
      return paramBaseChatItemLayout;
      localadve.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      continue;
      paramBaseChatItemLayout = paramView;
      if ((paramChatMessage instanceof MessageForLongMsg))
      {
        localObject3 = (MessageForLongMsg)paramChatMessage;
        if (e) {
          paramacun.b.append("说");
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
            paramView = a(paramacun, (MixedMsgLinearLayout)paramView, (List)localObject2, paramacxn, paramChatMessage);
            adve.a((adve)paramacun, paramChatMessage.uniseq);
            paramBaseChatItemLayout = paramView;
            if (e)
            {
              paramacun.b.append(ayla.e(((SpannableStringBuilder)localObject1).toString()));
              paramBaseChatItemLayout = paramView;
            }
          }
        }
      }
    }
  }
  
  public bblr a(bblr parambblr, ChatMessage paramChatMessage, acve paramacve)
  {
    int i = 0;
    parambblr.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691236));
    if ((paramChatMessage instanceof MessageForMixedMsg)) {
      if (((MessageForMixedMsg)paramChatMessage).canSelectable()) {
        break label126;
      }
    }
    for (;;)
    {
      if (i != 0) {
        parambblr.a(2131364825, this.jdField_a_of_type_AndroidContentContext.getString(2131718650), 2130838599);
      }
      parambblr.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692752), 2130838606);
      if (actn.a(5) == 1) {
        parambblr.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131692324), 2130838605);
      }
      return parambblr;
      if ((!(paramChatMessage instanceof MessageForLongMsg)) || (((MessageForLongMsg)paramChatMessage).canSelectable())) {
        label126:
        i = 1;
      }
    }
  }
  
  public MixedMsgLinearLayout a(acun paramacun, MixedMsgLinearLayout paramMixedMsgLinearLayout, List<MessageRecord> paramList, acxn paramacxn, MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList1 = new ArrayList(paramList);
    paramList = paramMixedMsgLinearLayout;
    if (paramMixedMsgLinearLayout == null)
    {
      paramList = new MixedMsgLinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramList.setId(2131364110);
      paramList.setOrientation(1);
      paramList.setFocusable(false);
      paramList.setClickable(true);
      paramList.setMinimumHeight(actn.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramList.setPadding(2131296288, 2131296290, 2131296287, 2131296289);
      paramMixedMsgLinearLayout = new RelativeLayout.LayoutParams(-2, -2);
      paramMixedMsgLinearLayout.addRule(1, 2131367679);
      paramMixedMsgLinearLayout.addRule(3, 2131377044);
      paramMixedMsgLinearLayout.leftMargin = actn.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramMixedMsgLinearLayout.rightMargin = actn.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramList.setLayoutParams(paramMixedMsgLinearLayout);
      paramList.jdField_a_of_type_Bcjb = this.jdField_a_of_type_Bcjb;
      adve.a((adve)paramacun, paramList);
      ((adve)paramacun).jdField_a_of_type_Aibs = new aibs();
      ((adve)paramacun).jdField_a_of_type_Aibs.a(paramList);
      ((adve)paramacun).jdField_a_of_type_Aibs.a(paramacun.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramacun.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
    }
    ((adve)paramacun).e = -1;
    ((adve)paramacun).jdField_a_of_type_Boolean = false;
    paramList.a(localArrayList1, (adve)paramacun);
    if (baic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {}
    for (paramMixedMsgLinearLayout = (baic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262);; paramMixedMsgLinearLayout = null)
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
              ((ViewGroup)localObject2).setId(2131364138);
              ((ViewGroup)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).setOnTouchListener(paramacxn);
              ((ViewGroup)localObject2).setOnLongClickListener(paramacxn);
              ((ViewGroup)localObject2).findViewById(2131370453).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).findViewById(2131368617).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).findViewById(2131377246).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
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
              adyh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ViewGroup)localObject2, ((MessageForReplyText)localObject3).mSourceMsgInfo, this.jdField_a_of_type_Acxm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((MessageForReplyText)localObject3).istroop, (MessageRecord)localObject1, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
              localObject1 = ((ViewGroup)localObject2).findViewById(2131377246);
              if (localObject1 == null) {
                break label1233;
              }
              localObject1 = ((View)localObject1).getTag(2131364125);
              if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
                break label1233;
              }
              bool = ((Boolean)localObject1).booleanValue();
              ((adve)paramacun).jdField_a_of_type_Boolean = bool;
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
          localView.setOnTouchListener(paramacxn);
          localView.setOnLongClickListener(paramacxn);
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
              if (!balw.b(paramMessageRecord)) {
                break;
              }
              balw.a((TextView)localObject2, (MessageRecord)localObject1);
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
            localObject4 = advu.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localObject1, (ChatThumbView)localObject2, (int[])localObject3);
            ((ChatThumbView)localObject2).setTag(2131364124, localObject1);
            ((ChatThumbView)localObject2).setImageDrawable((Drawable)localObject4);
            String str = ((URLDrawable)localObject4).getURL().getProtocol();
            URL localURL = aywk.a((auoa)localObject1, 65537);
            if (advu.a(this.jdField_a_of_type_AndroidContentContext, bgkh.a(((MessageForPic)localObject1).imageType), str.equals("chatthumb"), localObject3[0], localObject3[1], localURL))
            {
              ((URLDrawable)localObject4).setWatermarkDrawable(advu.a(), actn.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actn.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
        paramList.setOnTouchListener(paramacxn);
        paramList.setOnLongClickListener(paramacxn);
        paramList.b = this.jdField_a_of_type_Bcjb;
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
    aaod.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 6, 0, "", "", "", "");
    return;
    super.d(paramChatMessage);
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 7, 0, "", "", "", "");
    return;
    adgb.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 2);
    if (aibp.a().c())
    {
      paramContext = aibp.a().a();
      if (paramContext != null) {
        if (paramContext.length() != aibp.a().a())
        {
          paramInt = 1;
          label265:
          if (paramInt != 0) {
            break label1493;
          }
          paramContext = aibp.a().b();
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
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
      if (paramInt != 0) {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
      }
      while (paramChatMessage.isMultiMsg)
      {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D65", "0X8009D65", 3, 0, "3", "", "", "");
        return;
        paramInt = 0;
        break label265;
        paramInt = 0;
        break label265;
        paramContext = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
        paramInt = 1;
        break label276;
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
      }
      adgb.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 3);
      if (aibp.a().c())
      {
        paramContext = aibp.a().a();
        if (paramContext != null) {
          if (paramContext.length() == aibp.a().a())
          {
            paramInt = 1;
            if (paramInt != 0) {
              break label1490;
            }
            paramContext = aibp.a().b();
          }
        }
      }
      for (;;)
      {
        localObject2 = new Bundle();
        Object localObject3;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext() != null))
        {
          localObject3 = bbjn.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
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
              ((asjs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a.put(Long.valueOf(paramChatMessage.uniseq), paramChatMessage);
              ((Bundle)localObject2).putString("forward_text", paramContext);
              ((Bundle)localObject2).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              ((Bundle)localObject2).putInt("selection_mode", this.jdField_b_of_type_Int);
              paramContext = new Intent();
              paramContext.putExtras((Bundle)localObject2);
              aqbc.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005637", "0X8005637", 0, 0, "", "", "", "");
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
              if (paramInt == 0) {
                break label1017;
              }
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
              if (!paramChatMessage.isMultiMsg) {
                break;
              }
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 9, 0, "9", "", "", "");
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
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
        }
        adgb.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 4);
        if (aibp.a().c())
        {
          paramContext = aibp.a().a();
          if (paramContext != null) {
            if (paramContext.length() == aibp.a().a())
            {
              paramInt = 1;
              if (paramInt != 0) {
                break label1487;
              }
              paramContext = aibp.a().b();
            }
          }
        }
        for (;;)
        {
          label1114:
          if ((paramInt != 0) || (paramContext == null))
          {
            bgpd.b(paramChatMessage).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            bgpr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, 0, paramChatMessage.istroop);
            bgpr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
            if (paramInt == 0) {
              break label1324;
            }
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAC", 4, 0, "", "", "", "");
          }
          while (paramChatMessage.isMultiMsg)
          {
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 9, 0, "9", "", "", "");
            return;
            paramInt = 0;
            break label1103;
            paramInt = 0;
            break label1103;
            paramContext = null;
            paramInt = 1;
            break label1114;
            bgpr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramChatMessage.istroop);
            bgpd.a(null, paramContext).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            break label1165;
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAC", "0X8009AAC", 4, 0, "", "", "", "");
          }
          super.a(paramChatMessage);
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 5, 0, "", "", "", "");
          return;
          aibp.a().a(paramChatMessage);
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAC", "0X8009AAC", 2, 0, "", "", "", "");
          return;
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 3, 0, "", "", "", "");
          b(paramChatMessage);
          return;
        }
      }
    }
  }
  
  public void a(acun paramacun, View paramView, ChatMessage paramChatMessage, ambh paramambh)
  {
    adve localadve = (adve)paramacun;
    if ((localadve.e != -1) && (a(localadve)))
    {
      localadve.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      if ((paramambh.jdField_a_of_type_Int == 0) || (!paramambh.a()) || (axmt.b()))
      {
        paramView = paramView.getResources();
        if (paramChatMessage.isSend())
        {
          paramacun = paramView.getColorStateList(2131166876);
          localadve.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramacun);
          localadve.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramacun);
          localadve.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramacun);
          localadve.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramacun);
          if (!paramChatMessage.isSend()) {
            break label206;
          }
        }
        label206:
        for (paramacun = paramView.getColorStateList(2131166875);; paramacun = paramView.getColorStateList(2131166874))
        {
          localadve.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramacun);
          localadve.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacun);
          localadve.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacun);
          ImmersiveUtils.a(localadve.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
          ImmersiveUtils.a(localadve.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
          ImmersiveUtils.a(localadve.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
          return;
          paramacun = paramView.getColorStateList(2131166872);
          break;
        }
      }
      if (paramambh.jdField_b_of_type_Int == 0)
      {
        localadve.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localadve.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localadve.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        localadve.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        if (paramambh.c != 0) {
          break label404;
        }
        paramacun = paramView.getResources().getColorStateList(2131166874);
        localadve.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramacun);
        localadve.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacun);
        localadve.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacun);
      }
      for (;;)
      {
        ImmersiveUtils.a(localadve.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
        ImmersiveUtils.a(localadve.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        ImmersiveUtils.a(localadve.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        return;
        localadve.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramambh.jdField_b_of_type_Int);
        localadve.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramambh.jdField_b_of_type_Int);
        localadve.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramambh.jdField_b_of_type_Int);
        localadve.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramambh.jdField_b_of_type_Int);
        break;
        label404:
        localadve.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramambh.c);
        localadve.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramambh.c);
        localadve.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramambh.c);
      }
    }
    if ((paramambh.jdField_a_of_type_Int == 0) || (!paramambh.a()) || (axmt.b()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramacun = paramView.getColorStateList(2131166876);
        if (!paramChatMessage.isSend()) {
          break label525;
        }
      }
      label525:
      for (paramView = paramView.getColorStateList(2131166875);; paramView = paramView.getColorStateList(2131166874))
      {
        adve.a(localadve).a(paramacun, paramView);
        return;
        paramacun = paramView.getColorStateList(2131166872);
        break;
      }
    }
    paramacun = ColorStateList.valueOf(-16777216);
    paramView = paramView.getResources().getColorStateList(2131166874);
    if (paramambh.jdField_b_of_type_Int != 0) {
      paramacun = ColorStateList.valueOf(paramambh.jdField_b_of_type_Int);
    }
    if (paramambh.c != 0) {
      paramView = ColorStateList.valueOf(paramambh.c);
    }
    adve.a(localadve).a(paramacun, paramView);
  }
  
  public void a(acun paramacun, ChatMessage paramChatMessage)
  {
    paramacun = (adve)paramacun;
    if (adve.a(paramacun) != null) {
      adve.a(paramacun).a(ia.a(paramChatMessage));
    }
    if ((paramacun.e != -1) && (a(paramacun)))
    {
      paramChatMessage = ia.a("");
      paramacun.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
      paramacun.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
      paramacun.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
      paramacun.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
    }
  }
  
  public void a(View paramView)
  {
    paramView = (adve)actn.a(paramView);
    if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
    {
      paramView = (MessageForMixedMsg)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        bfol localbfol = (bfol)bfoy.a(this.jdField_a_of_type_AndroidContentContext, null);
        localbfol.a(2131689995, 5);
        localbfol.c(2131690596);
        localbfol.a(new advd(this, paramView, localbfol));
        localbfol.show();
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
  
  public void a(View paramView, ayqm paramayqm, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2003) {}
    label68:
    label585:
    label593:
    for (;;)
    {
      return;
      Object localObject1 = (adve)actn.a(paramView);
      paramView = null;
      Object localObject2;
      if ((((adve)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
      {
        paramView = (MessageForMixedMsg)((adve)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if ((adve.a((adve)localObject1) != null) && (paramView != null) && (paramView.msgElemList != null)) {
          for (paramView = paramView.msgElemList.iterator(); paramView.hasNext(); paramView = (MessageForPic)localObject2)
          {
            localObject2 = (MessageRecord)paramView.next();
            if ((localObject2 == null) || (((MessageRecord)localObject2).uniseq != paramayqm.b) || (!(localObject2 instanceof MessageForPic)) || (((MessageForPic)localObject2).subMsgId != paramayqm.c)) {
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
          paramInt2 = adve.a((adve)localObject1).getChildCount();
          paramInt1 = 0;
          label232:
          Object localObject3;
          Object localObject4;
          if (paramInt1 < paramInt2)
          {
            paramayqm = adve.a((adve)localObject1).getChildAt(paramInt1);
            if ((paramayqm instanceof ChatThumbView))
            {
              localObject2 = ((ChatThumbView)paramayqm).getTag(2131364124);
              if (((localObject2 instanceof MessageForPic)) && (((MessageForPic)localObject2).uniseq == paramView.uniseq) && (((MessageForPic)localObject2).subMsgId == paramView.subMsgId))
              {
                paramayqm = (ChatThumbView)paramayqm;
                if (paramayqm == null) {
                  break label577;
                }
                localObject1 = new int[2];
                tmp243_241 = localObject1;
                tmp243_241[0] = 0;
                tmp247_243 = tmp243_241;
                tmp247_243[1] = 0;
                tmp247_243;
                localObject2 = advu.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramayqm, (int[])localObject1);
                localObject3 = ((URLDrawable)localObject2).getURL().getProtocol();
                localObject4 = aywk.a(paramView, 65537);
                boolean bool = advu.a(this.jdField_a_of_type_AndroidContentContext, bgkh.a(paramView.imageType), ((String)localObject3).equals("chatthumb"), localObject1[0], localObject1[1], (URL)localObject4);
                paramayqm.setImageDrawable((Drawable)localObject2);
                if (!bool) {
                  break label567;
                }
                ((URLDrawable)localObject2).setWatermarkDrawable(advu.a(), actn.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actn.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                ((URLDrawable)localObject2).setWatermarkVisibility(0);
                return;
                if (!(((adve)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForLongMsg)) {
                  break label585;
                }
                localObject2 = (MessageForLongMsg)((adve)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
                if (((MessageRecord)localObject3).uniseq != paramayqm.b) {
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
                  if (((localObject4 instanceof MessageForPic)) && (((MessageForPic)localObject4).subMsgId == paramayqm.c))
                  {
                    paramView = (MessageForPic)localObject4;
                    break label478;
                    paramInt1 += 1;
                    break label153;
                    ((URLDrawable)localObject2).setWatermarkVisibility(4);
                    return;
                    paramayqm = null;
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
    paramView = (adve)paramView.getTag();
    int i = BaseChatItemLayout.g;
    if (paramChatMessage.isSend())
    {
      adve.a(paramView).setPadding(aebz.f, i, aebz.e, aebz.d);
      return;
    }
    adve.a(paramView).setPadding(aebz.e, i, aebz.f, aebz.d);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Object localObject = (adve)actn.a(paramView);
    if ((!paramBoolean) && ((paramView instanceof ChatThumbView))) {
      ((ChatThumbView)paramView).a(paramView, true);
    }
    localObject = adve.a((adve)localObject).getBackground();
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
  
  public bblt[] a(View paramView)
  {
    paramView = (adve)actn.a(paramView);
    ChatMessage localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    bblr localbblr = new bblr();
    if (localChatMessage != null)
    {
      if (!localChatMessage.isMultiMsg) {
        break label45;
      }
      a(localbblr, localChatMessage, null);
    }
    for (;;)
    {
      return localbblr.a();
      label45:
      b(localbblr, localChatMessage, paramView);
    }
  }
  
  public bblr b(bblr parambblr, ChatMessage paramChatMessage, acve paramacve)
  {
    parambblr.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691236));
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
        parambblr.a(2131364825, this.jdField_a_of_type_AndroidContentContext.getString(2131718650), 2130838599);
      }
      parambblr.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692752), 2130838606);
      a(paramChatMessage, parambblr);
      a(parambblr, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramacve.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      a(parambblr, paramChatMessage);
      if (actn.a(5) == 1) {
        parambblr.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131692324), 2130838605);
      }
      b(paramChatMessage, parambblr);
      super.c(parambblr, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambblr, this.jdField_a_of_type_AndroidContentContext);
      return parambblr;
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
 * Qualified Name:     adva
 * JD-Core Version:    0.7.0.1
 */