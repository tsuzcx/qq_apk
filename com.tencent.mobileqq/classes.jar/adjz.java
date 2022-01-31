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

public class adjz
  extends BaseBubbleBuilder
  implements acjt, aclm
{
  private acmu jdField_a_of_type_Acmu = new acmu();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private bbgb jdField_a_of_type_Bbgb = new adkb(this);
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private View.OnClickListener b;
  protected long c;
  
  public adjz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new adka(this);
    this.jdField_a_of_type_Acmu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aurl(this);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder1, SpannableStringBuilder paramSpannableStringBuilder2, List<MessageRecord> paramList)
  {
    if (paramSpannableStringBuilder1.length() > 0)
    {
      MessageRecord localMessageRecord = awbi.a(-1000);
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
  
  private void a(ArrayList<azha> paramArrayList, ArrayList<TextView> paramArrayList1, MessageRecord paramMessageRecord)
  {
    if (!azgz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
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
        localObject2 = (azha)paramArrayList.get(i);
        if ((localObject2 == null) || (((azha)localObject2).jdField_b_of_type_Int == -1))
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
          localStringBuilder.append(((azha)localObject2).b());
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
      localTextView.setTag(2131300748, "school_troop_span");
      k = j;
      localObject2 = localObject1;
      break label138;
      if (((azha)localObject2).jdField_b_of_type_Int < localObject1.jdField_b_of_type_Int)
      {
        localObject1 = localObject2;
        j = i;
        continue;
        if (localObject1 != null)
        {
          localObject2 = new azha();
          ((azha)localObject2).jdField_a_of_type_Long = paramMessageRecord.uniseq;
          ((azha)localObject2).jdField_a_of_type_Int = localObject1.jdField_a_of_type_Int;
          ((azha)localObject2).jdField_a_of_type_JavaLangString = localObject1.jdField_a_of_type_JavaLangString;
          ((azha)localObject2).jdField_b_of_type_JavaLangString = localObject1.jdField_b_of_type_JavaLangString;
          ((azha)localObject2).jdField_b_of_type_Int = localObject1.jdField_b_of_type_Int;
          ((azha)localObject2).a(localStringBuilder.toString());
          ((azha)localObject2).c = localObject1.c;
          ((azha)localObject2).d = localObject1.d;
          ((Spannable)((TextView)paramArrayList1.get(j)).getText()).setSpan(new azhb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (azha)localObject2), ((azha)localObject2).c, ((azha)localObject2).d, 17);
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
  
  private boolean a(adkd paramadkd)
  {
    return (paramadkd.jdField_b_of_type_AndroidWidgetTextView != null) && (paramadkd.jdField_a_of_type_AndroidWidgetTextView != null) && (paramadkd.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (paramadkd.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public acjt a(View paramView)
  {
    if (a(paramView)) {
      return this;
    }
    return null;
  }
  
  public acju a()
  {
    return new adkd(this);
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    adkd localadkd = (adkd)paramacju;
    if (paramacju.b == null) {
      paramacju.b = new StringBuilder();
    }
    Object localObject1 = (azks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    if (QLog.isColorLevel()) {
      QLog.i("MixedMsgItemBuilder", 1, "getBubbleView: check is need refresh[" + localadkd.jdField_a_of_type_Boolean + "]");
    }
    if ((!e) && (adkd.a(localadkd) != null) && (adkd.a(localadkd) == paramChatMessage.uniseq) && (!localadkd.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info"))))
    {
      if (((azks)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage))
      {
        localadkd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return paramView;
      }
      localadkd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return paramView;
    }
    Object localObject2;
    Object localObject3;
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      paramBaseChatItemLayout = (MessageForMixedMsg)paramChatMessage;
      if (e)
      {
        if (bado.a(paramChatMessage.issend)) {
          paramacju.b.append("发出");
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
            paramacju.b.append("图片");
          }
          localObject3 = (MessageForPic)localObject3;
          if (((MessageForPic)localObject3).time != 0L) {
            continue;
          }
          MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject3, paramBaseChatItemLayout);
          continue;
          paramacju.b.append("发来");
          break;
        }
        if ((localObject3 instanceof MessageForReplyText))
        {
          if (((MessageForReplyText)localObject3).time == 0L) {
            MessageForMixedMsg.copyBaseInfoFromMixedToNormal((MessageRecord)localObject3, paramBaseChatItemLayout);
          }
        }
        else if (e) {
          paramacju.b.append(axku.b(((MessageRecord)localObject3).msg));
        }
      }
      label379:
      paramBaseChatItemLayout = a(paramacju, (MixedMsgLinearLayout)paramView, paramBaseChatItemLayout.msgElemList, paramacmv, paramBaseChatItemLayout);
      adkd.a((adkd)paramacju, paramChatMessage.uniseq);
      if (((azks)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
        localadkd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      }
    }
    for (;;)
    {
      paramacju = aclk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramacju != null) {
        paramacju.a(paramBaseChatItemLayout, this);
      }
      if (paramBaseChatItemLayout != null) {
        paramBaseChatItemLayout.setTag(localadkd);
      }
      paramView = paramBaseChatItemLayout;
      if (localadkd.jdField_a_of_type_Ahpa == null) {
        break;
      }
      localadkd.jdField_a_of_type_Ahpa.b(paramChatMessage);
      return paramBaseChatItemLayout;
      localadkd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      continue;
      paramBaseChatItemLayout = paramView;
      if ((paramChatMessage instanceof MessageForLongMsg))
      {
        localObject3 = (MessageForLongMsg)paramChatMessage;
        if (e) {
          paramacju.b.append("说");
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
            paramView = a(paramacju, (MixedMsgLinearLayout)paramView, (List)localObject2, paramacmv, paramChatMessage);
            adkd.a((adkd)paramacju, paramChatMessage.uniseq);
            paramBaseChatItemLayout = paramView;
            if (e)
            {
              paramacju.b.append(axku.e(((SpannableStringBuilder)localObject1).toString()));
              paramBaseChatItemLayout = paramView;
            }
          }
        }
      }
    }
  }
  
  public bakh a(bakh parambakh, ChatMessage paramChatMessage, ackl paramackl)
  {
    int i = 0;
    parambakh.a(this.jdField_a_of_type_AndroidContentContext.getString(2131625661));
    if ((paramChatMessage instanceof MessageForMixedMsg)) {
      if (((MessageForMixedMsg)paramChatMessage).canSelectable()) {
        break label126;
      }
    }
    for (;;)
    {
      if (i != 0) {
        parambakh.a(2131299262, this.jdField_a_of_type_AndroidContentContext.getString(2131652825), 2130838592);
      }
      parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131627114), 2130838599);
      if (aciy.a(5) == 1) {
        parambakh.a(2131300328, this.jdField_a_of_type_AndroidContentContext.getString(2131626722), 2130838598);
      }
      return parambakh;
      if ((!(paramChatMessage instanceof MessageForLongMsg)) || (((MessageForLongMsg)paramChatMessage).canSelectable())) {
        label126:
        i = 1;
      }
    }
  }
  
  public MixedMsgLinearLayout a(acju paramacju, MixedMsgLinearLayout paramMixedMsgLinearLayout, List<MessageRecord> paramList, acmv paramacmv, MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList1 = new ArrayList(paramList);
    paramList = paramMixedMsgLinearLayout;
    if (paramMixedMsgLinearLayout == null)
    {
      paramList = new MixedMsgLinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramList.setId(2131298552);
      paramList.setOrientation(1);
      paramList.setFocusable(false);
      paramList.setClickable(true);
      paramList.setMinimumHeight(aciy.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramList.setPadding(2131165216, 2131165218, 2131165215, 2131165217);
      paramMixedMsgLinearLayout = new RelativeLayout.LayoutParams(-2, -2);
      paramMixedMsgLinearLayout.addRule(1, 2131302061);
      paramMixedMsgLinearLayout.addRule(3, 2131311234);
      paramMixedMsgLinearLayout.leftMargin = aciy.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramMixedMsgLinearLayout.rightMargin = aciy.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramList.setLayoutParams(paramMixedMsgLinearLayout);
      paramList.jdField_a_of_type_Bbgb = this.jdField_a_of_type_Bbgb;
      adkd.a((adkd)paramacju, paramList);
      ((adkd)paramacju).jdField_a_of_type_Ahpa = new ahpa();
      ((adkd)paramacju).jdField_a_of_type_Ahpa.a(paramList);
      ((adkd)paramacju).jdField_a_of_type_Ahpa.a(paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
    }
    ((adkd)paramacju).e = -1;
    ((adkd)paramacju).jdField_a_of_type_Boolean = false;
    paramList.a(localArrayList1, (adkd)paramacju);
    if (azgz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {}
    for (paramMixedMsgLinearLayout = (azgz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262);; paramMixedMsgLinearLayout = null)
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
              ((ViewGroup)localObject2).setId(2131298580);
              ((ViewGroup)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).setOnTouchListener(paramacmv);
              ((ViewGroup)localObject2).setOnLongClickListener(paramacmv);
              ((ViewGroup)localObject2).findViewById(2131304792).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).findViewById(2131302983).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).findViewById(2131311433).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
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
              adni.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ViewGroup)localObject2, ((MessageForReplyText)localObject3).mSourceMsgInfo, this.jdField_a_of_type_Acmu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((MessageForReplyText)localObject3).istroop, (MessageRecord)localObject1, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
              localObject1 = ((ViewGroup)localObject2).findViewById(2131311433);
              if (localObject1 == null) {
                break label1233;
              }
              localObject1 = ((View)localObject1).getTag(2131298567);
              if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
                break label1233;
              }
              bool = ((Boolean)localObject1).booleanValue();
              ((adkd)paramacju).jdField_a_of_type_Boolean = bool;
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
          localView.setOnTouchListener(paramacmv);
          localView.setOnLongClickListener(paramacmv);
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
              if (!azks.b(paramMessageRecord)) {
                break;
              }
              azks.a((TextView)localObject2, (MessageRecord)localObject1);
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
            localObject4 = adkt.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localObject1, (ChatThumbView)localObject2, (int[])localObject3);
            ((ChatThumbView)localObject2).setTag(2131298566, localObject1);
            ((ChatThumbView)localObject2).setImageDrawable((Drawable)localObject4);
            String str = ((URLDrawable)localObject4).getURL().getProtocol();
            URL localURL = axwd.a((atqc)localObject1, 65537);
            if (adkt.a(this.jdField_a_of_type_AndroidContentContext, bfcq.a(((MessageForPic)localObject1).imageType), str.equals("chatthumb"), localObject3[0], localObject3[1], localURL))
            {
              ((URLDrawable)localObject4).setWatermarkDrawable(adkt.a(), aciy.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aciy.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
        paramList.setOnTouchListener(paramacmv);
        paramList.setOnLongClickListener(paramacmv);
        paramList.b = this.jdField_a_of_type_Bbgb;
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
    aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 6, 0, "", "", "", "");
    return;
    super.d(paramChatMessage);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 7, 0, "", "", "", "");
    return;
    if (ahox.a().c())
    {
      paramContext = ahox.a().a();
      if (paramContext != null) {
        if (paramContext.length() != ahox.a().a())
        {
          paramInt = 1;
          label252:
          if (paramInt != 0) {
            break label1428;
          }
          paramContext = ahox.a().b();
        }
      }
    }
    label263:
    label1422:
    label1425:
    label1428:
    for (;;)
    {
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramContext);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
      if (paramInt != 0) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
      }
      while (paramChatMessage.isMultiMsg)
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D65", "0X8009D65", 3, 0, "3", "", "", "");
        return;
        paramInt = 0;
        break label252;
        paramInt = 0;
        break label252;
        paramContext = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
        paramInt = 1;
        break label263;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
      }
      if (ahox.a().c())
      {
        paramContext = ahox.a().a();
        if (paramContext != null) {
          if (paramContext.length() == ahox.a().a())
          {
            paramInt = 1;
            label492:
            if (paramInt != 0) {
              break label1425;
            }
            paramContext = ahox.a().b();
          }
        }
      }
      for (;;)
      {
        label503:
        localObject2 = new Bundle();
        Object localObject3;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext() != null))
        {
          localObject3 = baig.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
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
                break label979;
              }
              ((Bundle)localObject2).putInt("forward_type", -5);
              ((Bundle)localObject2).putLong("FORWARD_MSG_UNISEQ", paramChatMessage.uniseq);
              ((arno)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a.put(Long.valueOf(paramChatMessage.uniseq), paramChatMessage);
              ((Bundle)localObject2).putString("forward_text", paramContext);
              ((Bundle)localObject2).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              ((Bundle)localObject2).putInt("selection_mode", this.jdField_b_of_type_Int);
              paramContext = new Intent();
              paramContext.putExtras((Bundle)localObject2);
              aphp.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005637", "0X8005637", 0, 0, "", "", "", "");
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
              if (paramInt == 0) {
                break label991;
              }
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
              if (!paramChatMessage.isMultiMsg) {
                break;
              }
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 9, 0, "9", "", "", "");
              return;
              paramInt = 0;
              break label492;
              paramInt = 0;
              break label492;
              paramContext = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString();
              paramInt = 1;
              break label503;
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
          label979:
          ((Bundle)localObject2).putInt("forward_type", -1);
          continue;
          label991:
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
        }
        if (ahox.a().c())
        {
          paramContext = ahox.a().a();
          if (paramContext != null) {
            if (paramContext.length() == ahox.a().a())
            {
              paramInt = 1;
              label1064:
              if (paramInt != 0) {
                break label1422;
              }
              paramContext = ahox.a().b();
            }
          }
        }
        for (;;)
        {
          label1075:
          if ((paramInt != 0) || (paramContext == null))
          {
            bfhl.b(paramChatMessage).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            label1113:
            bfhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
            if (paramInt == 0) {
              break label1259;
            }
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAC", 4, 0, "", "", "", "");
          }
          while (paramChatMessage.isMultiMsg)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 9, 0, "9", "", "", "");
            return;
            paramInt = 0;
            break label1064;
            paramInt = 0;
            break label1064;
            paramContext = null;
            paramInt = 1;
            break label1075;
            bfhl.a(null, paramContext).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            break label1113;
            label1259:
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAC", "0X8009AAC", 4, 0, "", "", "", "");
          }
          super.a(paramChatMessage);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 5, 0, "", "", "", "");
          return;
          ahox.a().a(paramChatMessage);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAC", "0X8009AAC", 2, 0, "", "", "", "");
          return;
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject1, "0X8009AAB", "0X8009AAB", 3, 0, "", "", "", "");
          b(paramChatMessage);
          return;
        }
      }
    }
  }
  
  public void a(acju paramacju, View paramView, ChatMessage paramChatMessage, almt paramalmt)
  {
    adkd localadkd = (adkd)paramacju;
    if ((localadkd.e != -1) && (a(localadkd)))
    {
      localadkd.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      if ((paramalmt.jdField_a_of_type_Int == 0) || (!paramalmt.a()) || (awnu.b()))
      {
        paramView = paramView.getResources();
        if (paramChatMessage.isSend())
        {
          paramacju = paramView.getColorStateList(2131101282);
          localadkd.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramacju);
          localadkd.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramacju);
          localadkd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramacju);
          localadkd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramacju);
          if (!paramChatMessage.isSend()) {
            break label206;
          }
        }
        label206:
        for (paramacju = paramView.getColorStateList(2131101281);; paramacju = paramView.getColorStateList(2131101280))
        {
          localadkd.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramacju);
          localadkd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacju);
          localadkd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacju);
          ImmersiveUtils.a(localadkd.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
          ImmersiveUtils.a(localadkd.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
          ImmersiveUtils.a(localadkd.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
          return;
          paramacju = paramView.getColorStateList(2131101278);
          break;
        }
      }
      if (paramalmt.jdField_b_of_type_Int == 0)
      {
        localadkd.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localadkd.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localadkd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        localadkd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        if (paramalmt.c != 0) {
          break label404;
        }
        paramacju = paramView.getResources().getColorStateList(2131101280);
        localadkd.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramacju);
        localadkd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacju);
        localadkd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacju);
      }
      for (;;)
      {
        ImmersiveUtils.a(localadkd.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
        ImmersiveUtils.a(localadkd.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        ImmersiveUtils.a(localadkd.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        return;
        localadkd.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramalmt.jdField_b_of_type_Int);
        localadkd.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramalmt.jdField_b_of_type_Int);
        localadkd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramalmt.jdField_b_of_type_Int);
        localadkd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramalmt.jdField_b_of_type_Int);
        break;
        label404:
        localadkd.jdField_b_of_type_AndroidWidgetTextView.setLinkTextColor(paramalmt.c);
        localadkd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramalmt.c);
        localadkd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramalmt.c);
      }
    }
    if ((paramalmt.jdField_a_of_type_Int == 0) || (!paramalmt.a()) || (awnu.b()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramacju = paramView.getColorStateList(2131101282);
        if (!paramChatMessage.isSend()) {
          break label525;
        }
      }
      label525:
      for (paramView = paramView.getColorStateList(2131101281);; paramView = paramView.getColorStateList(2131101280))
      {
        adkd.a(localadkd).a(paramacju, paramView);
        return;
        paramacju = paramView.getColorStateList(2131101278);
        break;
      }
    }
    paramacju = ColorStateList.valueOf(-16777216);
    paramView = paramView.getResources().getColorStateList(2131101280);
    if (paramalmt.jdField_b_of_type_Int != 0) {
      paramacju = ColorStateList.valueOf(paramalmt.jdField_b_of_type_Int);
    }
    if (paramalmt.c != 0) {
      paramView = ColorStateList.valueOf(paramalmt.c);
    }
    adkd.a(localadkd).a(paramacju, paramView);
  }
  
  public void a(acju paramacju, ChatMessage paramChatMessage)
  {
    paramacju = (adkd)paramacju;
    if (adkd.a(paramacju) != null) {
      adkd.a(paramacju).a(gh.a(paramChatMessage));
    }
    if ((paramacju.e != -1) && (a(paramacju)))
    {
      paramChatMessage = gh.a("");
      paramacju.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
      paramacju.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
      paramacju.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
      paramacju.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
    }
  }
  
  public void a(View paramView)
  {
    paramView = (adkd)aciy.a(paramView);
    if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
    {
      paramView = (MessageForMixedMsg)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        begr localbegr = (begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null);
        localbegr.a(2131624443, 5);
        localbegr.c(2131625035);
        localbegr.a(new adkc(this, paramView, localbegr));
        localbegr.show();
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
  
  public void a(View paramView, axqf paramaxqf, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2003) {}
    label68:
    label585:
    label593:
    for (;;)
    {
      return;
      Object localObject1 = (adkd)aciy.a(paramView);
      paramView = null;
      Object localObject2;
      if ((((adkd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
      {
        paramView = (MessageForMixedMsg)((adkd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if ((adkd.a((adkd)localObject1) != null) && (paramView != null) && (paramView.msgElemList != null)) {
          for (paramView = paramView.msgElemList.iterator(); paramView.hasNext(); paramView = (MessageForPic)localObject2)
          {
            localObject2 = (MessageRecord)paramView.next();
            if ((localObject2 == null) || (((MessageRecord)localObject2).uniseq != paramaxqf.b) || (!(localObject2 instanceof MessageForPic)) || (((MessageForPic)localObject2).subMsgId != paramaxqf.c)) {
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
          paramInt2 = adkd.a((adkd)localObject1).getChildCount();
          paramInt1 = 0;
          label232:
          Object localObject3;
          Object localObject4;
          if (paramInt1 < paramInt2)
          {
            paramaxqf = adkd.a((adkd)localObject1).getChildAt(paramInt1);
            if ((paramaxqf instanceof ChatThumbView))
            {
              localObject2 = ((ChatThumbView)paramaxqf).getTag(2131298566);
              if (((localObject2 instanceof MessageForPic)) && (((MessageForPic)localObject2).uniseq == paramView.uniseq) && (((MessageForPic)localObject2).subMsgId == paramView.subMsgId))
              {
                paramaxqf = (ChatThumbView)paramaxqf;
                if (paramaxqf == null) {
                  break label577;
                }
                localObject1 = new int[2];
                tmp243_241 = localObject1;
                tmp243_241[0] = 0;
                tmp247_243 = tmp243_241;
                tmp247_243[1] = 0;
                tmp247_243;
                localObject2 = adkt.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramaxqf, (int[])localObject1);
                localObject3 = ((URLDrawable)localObject2).getURL().getProtocol();
                localObject4 = axwd.a(paramView, 65537);
                boolean bool = adkt.a(this.jdField_a_of_type_AndroidContentContext, bfcq.a(paramView.imageType), ((String)localObject3).equals("chatthumb"), localObject1[0], localObject1[1], (URL)localObject4);
                paramaxqf.setImageDrawable((Drawable)localObject2);
                if (!bool) {
                  break label567;
                }
                ((URLDrawable)localObject2).setWatermarkDrawable(adkt.a(), aciy.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aciy.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                ((URLDrawable)localObject2).setWatermarkVisibility(0);
                return;
                if (!(((adkd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForLongMsg)) {
                  break label585;
                }
                localObject2 = (MessageForLongMsg)((adkd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
                if (((MessageRecord)localObject3).uniseq != paramaxqf.b) {
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
                  if (((localObject4 instanceof MessageForPic)) && (((MessageForPic)localObject4).subMsgId == paramaxqf.c))
                  {
                    paramView = (MessageForPic)localObject4;
                    break label478;
                    paramInt1 += 1;
                    break label153;
                    ((URLDrawable)localObject2).setWatermarkVisibility(4);
                    return;
                    paramaxqf = null;
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
    paramView = (adkd)paramView.getTag();
    int i = BaseChatItemLayout.g;
    if (paramChatMessage.isSend())
    {
      adkd.a(paramView).setPadding(adra.f, i, adra.e, adra.d);
      return;
    }
    adkd.a(paramView).setPadding(adra.e, i, adra.f, adra.d);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Object localObject = (adkd)aciy.a(paramView);
    if ((!paramBoolean) && ((paramView instanceof ChatThumbView))) {
      ((ChatThumbView)paramView).a(paramView, true);
    }
    localObject = adkd.a((adkd)localObject).getBackground();
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
  
  public bakj[] a(View paramView)
  {
    paramView = (adkd)aciy.a(paramView);
    ChatMessage localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    bakh localbakh = new bakh();
    if (localChatMessage != null)
    {
      if (!localChatMessage.isMultiMsg) {
        break label45;
      }
      a(localbakh, localChatMessage, null);
    }
    for (;;)
    {
      return localbakh.a();
      label45:
      b(localbakh, localChatMessage, paramView);
    }
  }
  
  public bakh b(bakh parambakh, ChatMessage paramChatMessage, ackl paramackl)
  {
    parambakh.a(this.jdField_a_of_type_AndroidContentContext.getString(2131625661));
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
        parambakh.a(2131299262, this.jdField_a_of_type_AndroidContentContext.getString(2131652825), 2130838592);
      }
      parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131627114), 2130838599);
      a(paramChatMessage, parambakh);
      a(parambakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramackl.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      a(parambakh, paramChatMessage);
      if (aciy.a(5) == 1) {
        parambakh.a(2131300328, this.jdField_a_of_type_AndroidContentContext.getString(2131626722), 2130838598);
      }
      b(paramChatMessage, parambakh);
      super.c(parambakh, this.jdField_a_of_type_AndroidContentContext);
      super.d(parambakh, this.jdField_a_of_type_AndroidContentContext);
      return parambakh;
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
 * Qualified Name:     adjz
 * JD-Core Version:    0.7.0.1
 */