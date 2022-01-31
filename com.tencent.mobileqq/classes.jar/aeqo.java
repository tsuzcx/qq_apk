import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.ArraySet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatpieHelper;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class aeqo
  extends bici
  implements bdbc
{
  @Deprecated
  public static long a;
  public aeqp a;
  public afpy a;
  public ajxq a;
  public ajxs a;
  protected Context a;
  protected ArraySet<Long> a;
  public bdbb a;
  protected BaseChatPie a;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected ListView a;
  public Boolean a;
  CharSequence jdField_a_of_type_JavaLangCharSequence = null;
  protected List<ChatMessage> a;
  public boolean a;
  protected long b;
  
  static
  {
    jdField_a_of_type_Long = -1L;
  }
  
  public aeqo(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    this.jdField_a_of_type_AndroidSupportV4UtilArraySet = new ArraySet();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Afpy = new afpy(paramContext, paramQQAppInterface, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Bdbb = new bdbb(paramQQAppInterface);
    this.jdField_a_of_type_Bdbb.a(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (paramBaseChatPie == null) {}
    for (long l = NetConnInfoCenter.getServerTime();; l = paramBaseChatPie.a())
    {
      this.b = l;
      this.jdField_a_of_type_Ajxq = new ajxq(this, paramQQAppInterface);
      this.jdField_a_of_type_Ajxs = new ajxs(paramBaseChatPie);
      this.jdField_a_of_type_Aeqp = new aeqp(this);
      return;
    }
  }
  
  private String a(MessageForText paramMessageForText)
  {
    if (paramMessageForText.sb != null) {
      return paramMessageForText.sb.toString();
    }
    return paramMessageForText.msg;
  }
  
  protected static void a(MessageForStructing paramMessageForStructing, aeqi paramaeqi, View paramView, boolean paramBoolean)
  {
    int i = 2130849443;
    int j = 2130849267;
    int k = 2130838203;
    if ((paramMessageForStructing == null) || (paramMessageForStructing.structingMsg == null)) {
      return;
    }
    switch (paramMessageForStructing.structingMsg.mMsgServiceID)
    {
    default: 
      if (!paramBoolean) {
        break;
      }
    }
    for (i = k;; i = 2130838187)
    {
      paramView.setBackgroundResource(i);
      return;
      paramView.setBackgroundDrawable(null);
      return;
      if (paramMessageForStructing.isSend()) {
        if (!paramBoolean) {}
      }
      for (;;)
      {
        aepi.a(paramaeqi.a, i);
        return;
        i = 2130849444;
        continue;
        if (paramBoolean) {
          i = 2130849267;
        } else {
          i = 2130849268;
        }
      }
      if (!paramMessageForStructing.structingMsg.hasFlag(4))
      {
        if (paramMessageForStructing.isSend())
        {
          if (paramBoolean) {}
          for (;;)
          {
            aepi.a(paramaeqi.a, i);
            return;
            i = 2130849444;
          }
        }
        if (paramBoolean) {}
        for (i = j;; i = 2130849268) {
          break;
        }
      }
      if (paramBoolean) {}
      for (i = 2130838203;; i = 2130838187)
      {
        paramView.setBackgroundResource(i);
        return;
      }
    }
  }
  
  private boolean a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    boolean bool2 = false;
    Object localObject = ((MessageForMarketFace)paramChatMessage1).mMarkFaceMessage;
    MarkFaceMessage localMarkFaceMessage = ((MessageForMarketFace)paramChatMessage2).mMarkFaceMessage;
    if (localObject == null) {
      paramChatMessage1.parse();
    }
    for (paramChatMessage1 = ((MessageForMarketFace)paramChatMessage1).mMarkFaceMessage;; paramChatMessage1 = (ChatMessage)localObject)
    {
      localObject = localMarkFaceMessage;
      if (localMarkFaceMessage == null)
      {
        paramChatMessage2.parse();
        localObject = ((MessageForMarketFace)paramChatMessage2).mMarkFaceMessage;
      }
      boolean bool1 = bool2;
      if (paramChatMessage1 != null)
      {
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (paramChatMessage1.dwTabID == ((MarkFaceMessage)localObject).dwTabID)
          {
            bool1 = bool2;
            if (apmq.a(paramChatMessage1.sbufID, paramChatMessage1.mediaType).equals(apmq.a(((MarkFaceMessage)localObject).sbufID, ((MarkFaceMessage)localObject).mediaType)))
            {
              azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_show_follow", 0, 0, "", paramChatMessage1.dwTabID + "", "", "");
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
  }
  
  private boolean b(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    paramChatMessage1.parse();
    paramChatMessage2.parse();
    return a((MessageForText)paramChatMessage1).equals(a((MessageForText)paramChatMessage2));
  }
  
  public int a(long paramLong)
  {
    int j = getCount();
    int i = 0;
    while (i < j)
    {
      if (getItemId(i) == paramLong) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return -1;
    }
    return this.jdField_a_of_type_JavaUtilList.indexOf(paramChatMessage);
  }
  
  public ArraySet<Long> a()
  {
    return this.jdField_a_of_type_AndroidSupportV4UtilArraySet;
  }
  
  public List<ChatMessage> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Bdbb.a())
    {
      this.jdField_a_of_type_Bdbb.c();
      this.jdField_a_of_type_Bdbb.a();
    }
  }
  
  public void a(ArraySet<Long> paramArraySet)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilArraySet = paramArraySet;
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    this.jdField_a_of_type_Afpy.a(paramChatMessage, this).a(paramView, paramChatMessage, paramInt);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramChatMessage);
    if (i >= 0)
    {
      Object localObject1;
      if ((paramChatMessage instanceof MessageForArkApp))
      {
        localObject1 = (MessageForArkApp)paramChatMessage;
        if (localObject1 != null) {
          ((MessageForArkApp)localObject1).doOnEvent(2);
        }
      }
      if ((paramChatMessage instanceof RecommendCommonMessage))
      {
        localObject1 = (RecommendCommonMessage)paramChatMessage;
        if ((localObject1 != null) && (((RecommendCommonMessage)localObject1).mOldAppInfo.mArkContainer != null)) {
          ((RecommendCommonMessage)localObject1).mOldAppInfo.mArkContainer.doOnEvent(2);
        }
        if (localObject1 != null)
        {
          localObject1 = ((RecommendCommonMessage)localObject1).mContextList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (RecommendCommonMessage.ArkContextInfo)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              localObject2 = ((RecommendCommonMessage.ArkContextInfo)localObject2).contextAppInfoList.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                RecommendCommonMessage.ArkMsgAppInfo localArkMsgAppInfo = (RecommendCommonMessage.ArkMsgAppInfo)((Iterator)localObject2).next();
                if (localArkMsgAppInfo != null) {
                  localArkMsgAppInfo.doOnEvent(2);
                }
              }
            }
          }
        }
      }
      if ((paramChatMessage instanceof MessageForArkFlashChat))
      {
        localObject1 = (MessageForArkFlashChat)paramChatMessage;
        if ((localObject1 != null) && (((MessageForArkFlashChat)localObject1).arkContainer != null)) {
          ((MessageForArkFlashChat)localObject1).arkContainer.doOnEvent(2);
        }
      }
      if ((paramChatMessage instanceof MessageForArkBabyqReply))
      {
        localObject1 = (MessageForArkBabyqReply)paramChatMessage;
        if (localObject1 != null) {
          ((MessageForArkBabyqReply)localObject1).doOnEvent(2);
        }
      }
      this.jdField_a_of_type_JavaUtilList.remove(paramChatMessage);
      c(i, i);
    }
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt)
  {
    if ((paramChatMessage == null) || (this.jdField_a_of_type_ComTencentWidgetListView == null)) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1;
    label22:
    View localView;
    ChatMessage localChatMessage;
    if (i >= 0)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
      localChatMessage = (ChatMessage)localView.getTag(2131364186);
      if (localChatMessage != null) {
        break label61;
      }
    }
    label61:
    while (!localChatMessage.equals(paramChatMessage))
    {
      i -= 1;
      break label22;
      break;
    }
    a(localView, paramChatMessage, paramInt);
  }
  
  public void a(ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
  }
  
  public void a(List<ChatMessage> paramList)
  {
    ChatMessage localChatMessage1;
    int i;
    int j;
    ChatMessage localChatMessage2;
    ChatMessage localChatMessage4;
    if (paramList.size() > 0)
    {
      localChatMessage1 = (ChatMessage)paramList.get(paramList.size() - 1);
      i = 1;
      for (;;)
      {
        if ((azah.a(localChatMessage1.msgtype)) || (abti.j(localChatMessage1.msgtype)))
        {
          i += 1;
          if ((paramList.size() - i >= 0) && (i <= 4))
          {
            localChatMessage1 = (ChatMessage)paramList.get(paramList.size() - i);
          }
          else
          {
            j = 0;
            int k = i + 1;
            if (paramList.size() - k >= 0)
            {
              for (ChatMessage localChatMessage3 = (ChatMessage)paramList.get(paramList.size() - k);; localChatMessage3 = (ChatMessage)paramList.get(paramList.size() - k))
              {
                if (!azah.a(localChatMessage3.msgtype))
                {
                  localChatMessage2 = localChatMessage3;
                  localChatMessage4 = localChatMessage1;
                  i = j;
                  if (!abti.j(localChatMessage3.msgtype)) {
                    break label216;
                  }
                }
                k += 1;
                if (paramList.size() - k < 0) {
                  break;
                }
              }
              i = 0;
              localChatMessage4 = localChatMessage1;
              localChatMessage2 = localChatMessage3;
            }
          }
        }
      }
    }
    for (;;)
    {
      label216:
      if ((i != 0) && (localChatMessage4 != null) && (localChatMessage2 != null))
      {
        localChatMessage4.isFlowMessage = false;
        localChatMessage2.isFlowMessage = false;
        if ((localChatMessage4.istroop == 1) || (localChatMessage4.istroop == 3000))
        {
          if (((localChatMessage4 instanceof MessageForMarketFace)) && ((localChatMessage2 instanceof MessageForMarketFace))) {
            localChatMessage4.isFlowMessage = a(localChatMessage4, localChatMessage2);
          }
          if ((localChatMessage4.istroop == 1) && ((localChatMessage4 instanceof MessageForText)) && ((localChatMessage2 instanceof MessageForText))) {
            localChatMessage4.isFlowMessage = b(localChatMessage4, localChatMessage2);
          }
        }
      }
      return;
      localChatMessage2 = null;
      i = 0;
      localChatMessage4 = localChatMessage1;
      continue;
      j = 1;
      break;
      localChatMessage2 = null;
      localChatMessage4 = null;
      i = 1;
    }
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    a(paramList, paramCharSequence, 0);
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("ChatAdapter1", 2, "create time: " + this.b);
    }
    long l1 = 0L;
    int i = 0;
    label208:
    Object localObject2;
    if (i < paramList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
      boolean bool2 = azah.b(localChatMessage.msgtype);
      if ((bool2) && ((i == 0) || ((localChatMessage.time < this.b) && (localChatMessage.time - l1 > 300L)) || ((localChatMessage.time >= this.b) && (localChatMessage.time - l1 > 300L) && ((localObject1 == null) || (localChatMessage.time - localObject1.time > 60L))) || ((this.jdField_a_of_type_AndroidSupportV4UtilArraySet.contains(Long.valueOf(localChatMessage.uniseq))) && (l1 / 60L != localChatMessage.time / 60L))))
      {
        bool1 = true;
        localChatMessage.mNeedTimeStamp = bool1;
        if (localChatMessage.mNeedTimeStamp)
        {
          long l2 = localChatMessage.time;
          l1 = l2;
          if (localChatMessage.time < this.b)
          {
            aeuk.a(localChatMessage);
            l1 = l2;
          }
        }
        if ((i < 50) && (QLog.isColorLevel()))
        {
          if ((localChatMessage.msg == null) || (localChatMessage.msg.length() <= 0)) {
            break label484;
          }
          localObject2 = localChatMessage.msg.substring(0, 1);
          label300:
          StringBuilder localStringBuilder = new StringBuilder().append("msg: ").append((String)localObject2).append(", type: ").append(localChatMessage.msgtype).append(", mNeedTimeStamp: ").append(localChatMessage.mNeedTimeStamp).append(", time: ").append(localChatMessage.time).append(", lastTimestamp: ").append(l1).append(", last time: ");
          if (localObject1 != null) {
            break label491;
          }
          localObject2 = "null";
          label389:
          QLog.d("ChatAdapter1", 2, localObject2);
        }
        localObject2 = localObject1;
        if (bool2)
        {
          localObject2 = localObject1;
          if (!aspz.a(localChatMessage)) {
            localObject2 = localChatMessage;
          }
        }
        if (i != paramList.size() - 1) {
          localChatMessage.isFlowMessage = false;
        }
        if (i != 0) {
          break label504;
        }
      }
      label484:
      label491:
      label504:
      for (boolean bool1 = true;; bool1 = false)
      {
        localChatMessage.isFirstMsg = bool1;
        i += 1;
        localObject1 = localObject2;
        break;
        bool1 = false;
        break label208;
        localObject2 = "";
        break label300;
        localObject2 = Long.valueOf(localObject1.time);
        break label389;
      }
    }
    if (paramList.size() > 0) {
      this.jdField_a_of_type_AndroidSupportV4UtilArraySet.add(Long.valueOf(((ChatMessage)paramList.get(0)).uniseq));
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramList);
    }
    if (paramCharSequence != null)
    {
      localObject2 = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(0);
      ((ChatMessage)localObject2).mNeedGrayTips = true;
      ((ChatMessage)localObject2).mMessageSource = paramCharSequence;
    }
    if ((localObject1 != null) && (!localObject1.isFlowMessage)) {
      a(paramList);
    }
    paramCharSequence = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (paramCharSequence != null) && (paramCharSequence.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))) {
      ((apjy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(214)).a(paramList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramInt);
    }
    if (BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      this.jdField_a_of_type_JavaUtilList = BaseChatpieHelper.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.i);
    }
    super.notifyDataSetChanged();
    this.jdField_a_of_type_Ajxs.b();
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public int b(long paramLong)
  {
    int j;
    if (paramLong < 0L)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label58;
      }
      j = i;
      if (((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i)).uniseq == paramLong) {
        break;
      }
      i += 1;
    }
    label58:
    return -1;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bdbb.a())
    {
      this.jdField_a_of_type_Bdbb.b();
      notifyDataSetChanged();
    }
  }
  
  public int c(long paramLong)
  {
    int j;
    if (paramLong < 0L)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label70;
      }
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localChatMessage.shmsgseq == paramLong)
      {
        j = i;
        if (!abti.a(localChatMessage)) {
          break;
        }
      }
      i += 1;
    }
    label70:
    return -1;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      label10:
      if (!localIterator.hasNext()) {
        break label295;
      }
      Object localObject1 = (ChatMessage)localIterator.next();
      if (localObject1 != null)
      {
        Object localObject2;
        if ((localObject1 instanceof RecommendCommonMessage))
        {
          localObject1 = (RecommendCommonMessage)localObject1;
          ((RecommendCommonMessage)localObject1).mHasReportShowIconEach = false;
          ((RecommendCommonMessage)localObject1).mHasReportShowUnderlineEach = false;
          if (((RecommendCommonMessage)localObject1).mOldAppInfo.mArkContainer != null) {
            ((RecommendCommonMessage)localObject1).mOldAppInfo.mArkContainer.doOnEvent(2);
          }
          localObject1 = ((RecommendCommonMessage)localObject1).mContextList.iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label10;
            }
            localObject2 = (RecommendCommonMessage.ArkContextInfo)((Iterator)localObject1).next();
            if (localObject2 == null) {
              break;
            }
            localObject2 = ((RecommendCommonMessage.ArkContextInfo)localObject2).contextAppInfoList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              RecommendCommonMessage.ArkMsgAppInfo localArkMsgAppInfo = (RecommendCommonMessage.ArkMsgAppInfo)((Iterator)localObject2).next();
              if (localArkMsgAppInfo != null)
              {
                localArkMsgAppInfo.doOnEvent(2);
                localArkMsgAppInfo.mOpenCardAppInfoList.clear();
              }
            }
          }
        }
        if ((localObject1 instanceof MessageForArkApp))
        {
          localObject1 = (MessageForArkApp)localObject1;
          if (localObject1 != null)
          {
            ((MessageForArkApp)localObject1).doOnEvent(2);
            ((MessageForArkApp)localObject1).mExtendMsgArkAppList.clear();
          }
        }
        else if ((localObject1 instanceof MessageForArkBabyqReply))
        {
          localObject1 = (MessageForArkBabyqReply)localObject1;
          if ((localObject1 != null) && (((MessageForArkBabyqReply)localObject1).mArkBabyqReplyCardList != null))
          {
            localObject1 = ((MessageForArkBabyqReply)localObject1).mArkBabyqReplyCardList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ArkBabyqCardInfo)((Iterator)localObject1).next();
              if (localObject2 != null)
              {
                ((ArkBabyqCardInfo)localObject2).doOnEvent(2);
                if (((ArkBabyqCardInfo)localObject2).mExtendedArkBabyqCardList != null) {
                  ((ArkBabyqCardInfo)localObject2).mExtendedArkBabyqCardList.clear();
                }
              }
            }
          }
        }
        else if ((localObject1 instanceof MessageForPtt))
        {
          localObject1 = (MessageForPtt)localObject1;
          if (localObject1 != null)
          {
            ((MessageForPtt)localObject1).playProgress = 0.0F;
            ((MessageForPtt)localObject1).playSpeedPos = MediaPlayerManager.a;
          }
        }
      }
    }
    label295:
    if (this.jdField_a_of_type_Afpy != null) {
      this.jdField_a_of_type_Afpy.a();
    }
    this.jdField_a_of_type_Bdbb.a(null);
    this.jdField_a_of_type_Bdbb.d();
    if (a()) {
      aeuk.a();
    }
    this.jdField_a_of_type_Ajxs.c();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aeqp.a != null)
    {
      ajyd localajyd = this.jdField_a_of_type_Aeqp.a.a();
      if ((localajyd == null) || (!localajyd.c())) {
        break label41;
      }
      localajyd.d();
    }
    label41:
    while (!this.jdField_a_of_type_Aeqp.a.a()) {
      return;
    }
    this.jdField_a_of_type_Aeqp.a.a();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      l1 = l2;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
        l1 = ((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt)).uniseq;
      }
    }
    return l1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilList.size() - 1) {
      paramInt = this.jdField_a_of_type_JavaUtilList.size() - 1;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localChatMessage != null) {
        localChatMessage.parse();
      }
      return afpy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
      return paramView;
    }
    ChatMessage localChatMessage1 = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    bdnm.a(null, "AIO_ChatAdapter_getView" + " | " + localChatMessage1.getClass().getName());
    aeqy localaeqy = this.jdField_a_of_type_Afpy.a(localChatMessage1, this);
    if (paramInt != 0)
    {
      ChatMessage localChatMessage2 = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
      if ((localChatMessage2 != null) && ((localChatMessage2 instanceof MessageForTroopUnreadTips))) {
        localChatMessage1.mNeedTimeStamp = true;
      }
    }
    paramView = localaeqy.a(paramInt, this.jdField_a_of_type_JavaUtilList.size(), localChatMessage1, paramView, paramViewGroup, this.jdField_a_of_type_Aeqp);
    if (paramView != null)
    {
      paramView.setTag(2131364186, localChatMessage1);
      if (((localaeqy instanceof aepl)) && ((paramView instanceof aiio))) {
        paramViewGroup = (aiio)paramView;
      }
    }
    bdnm.a("AIO_ChatAdapter_getView" + " | " + localChatMessage1.getClass().getName(), null);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 115;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_Bdbb.a())) {
      return;
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeqo
 * JD-Core Version:    0.7.0.1
 */