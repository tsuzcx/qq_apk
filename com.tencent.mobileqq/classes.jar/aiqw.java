import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.util.ArraySet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aiqw
  extends afqz
{
  protected aiqy a;
  protected aiqz a;
  public final String a;
  protected SessionInfo b;
  protected QQAppInterface b;
  public boolean b;
  public boolean c;
  
  public aiqw(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo, null, null);
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aiqz = new aiqz(this, null);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  private List<ChatMessage> a(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((localMessageRecord instanceof ChatMessage)) {
        localArrayList.add((ChatMessage)localMessageRecord);
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject;
    label9:
    ChatMessage localChatMessage;
    boolean bool1;
    if (paramInt1 == 0)
    {
      localObject = null;
      long l1 = 0L;
      if (paramInt1 >= paramInt2) {
        break label287;
      }
      localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
      boolean bool2 = bcsc.b(localChatMessage.msgtype);
      if ((!bool2) || ((paramInt1 != 0) && ((localChatMessage.time >= this.jdField_b_of_type_Long) || (localChatMessage.time - l1 <= 300L)) && ((localChatMessage.time < this.jdField_b_of_type_Long) || (localChatMessage.time - l1 <= 300L) || ((localObject != null) && (localChatMessage.time - ((ChatMessage)localObject).time <= 60L))) && ((!this.jdField_a_of_type_AndroidSupportV4UtilArraySet.contains(Long.valueOf(localChatMessage.uniseq))) || (l1 / 60L == localChatMessage.time / 60L)))) {
        break label281;
      }
      bool1 = true;
      label164:
      localChatMessage.mNeedTimeStamp = bool1;
      if (localChatMessage.mNeedTimeStamp)
      {
        long l2 = localChatMessage.time;
        l1 = l2;
        if (localChatMessage.time < this.jdField_b_of_type_Long)
        {
          afum.a(localChatMessage);
          l1 = l2;
        }
      }
      if ((!bool2) || (((localChatMessage instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localChatMessage).tipParam.b == 1))) {
        break label327;
      }
      localObject = localChatMessage;
    }
    label281:
    label287:
    label327:
    for (;;)
    {
      localChatMessage.isFlowMessage = false;
      localChatMessage.isDui = false;
      paramInt1 += 1;
      break label9;
      localObject = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1 - 1);
      break;
      bool1 = false;
      break label164;
      if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
        this.jdField_a_of_type_AndroidSupportV4UtilArraySet.add(Long.valueOf(((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(0)).uniseq));
      }
      return;
    }
  }
  
  public int a(List<MessageRecord> paramList, boolean paramBoolean)
  {
    paramList = a(paramList);
    int i = paramList.size();
    int k = this.jdField_a_of_type_JavaUtilList.size();
    this.jdField_a_of_type_JavaUtilList.addAll(0, paramList);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      int j = this.jdField_a_of_type_JavaUtilList.size();
      if ((k > 0) && (j > 200))
      {
        k = Math.max(paramList.size(), 200);
        this.jdField_a_of_type_JavaUtilList.subList(k, j).clear();
        this.c = true;
      }
      a(0, paramList.size());
      return i;
    }
  }
  
  public void a(aiqy paramaiqy)
  {
    this.jdField_a_of_type_Aiqy = paramaiqy;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_JavaUtilList.remove(paramChatMessage);
  }
  
  public int b(List<MessageRecord> paramList, boolean paramBoolean)
  {
    int j = 0;
    paramList = a(paramList);
    int k = this.jdField_a_of_type_JavaUtilList.size();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.c = paramBoolean;
      int m = this.jdField_a_of_type_JavaUtilList.size();
      int i = j;
      if (k > 0)
      {
        i = j;
        if (m > 200)
        {
          i = Math.min(m - 200, k);
          this.jdField_a_of_type_JavaUtilList.subList(0, i).clear();
          i = -i;
          this.jdField_b_of_type_Boolean = true;
          a(0, 1);
        }
      }
      a(this.jdField_a_of_type_JavaUtilList.size() - paramList.size(), this.jdField_a_of_type_JavaUtilList.size());
      return i;
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = this.jdField_a_of_type_Agvm.a(localChatMessage, this);
    if ((localObject instanceof BaseBubbleBuilder)) {
      ((BaseBubbleBuilder)localObject).c = true;
    }
    View localView = ((afrj)localObject).a(paramInt, this.jdField_a_of_type_JavaUtilList.size(), localChatMessage, paramView, paramViewGroup, this.jdField_a_of_type_Aiqz);
    if (localView != null) {
      localView.setTag(2131364535, localChatMessage);
    }
    if ((localView instanceof BaseChatItemLayout)) {
      ((BaseChatItemLayout)localView).b();
    }
    if ((localChatMessage.msgtype == -2009) || (localChatMessage.msgtype == -2016)) {
      ((ahmu)localObject).a(false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "AIOTime getView " + localChatMessage.getClass().getName());
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      if (localChatMessage.msgtype == -2076)
      {
        if ((localObject instanceof ahak)) {
          ((ahak)localObject).a(false);
        }
      }
      else if ((localChatMessage.msgtype == -2039) && ((localObject instanceof ApolloItemBuilder)))
      {
        ((ApolloItemBuilder)localObject).a(false);
        localObject = (agnq)AIOUtils.getHolder(localView);
        ((agnq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
        if (((agnq)localObject).jdField_a_of_type_AndroidWidgetImageView != null)
        {
          localObject = ((agnq)localObject).jdField_a_of_type_AndroidWidgetImageView.getDrawable();
          if ((localObject != null) && ((localObject instanceof AnimationDrawable)))
          {
            ((AnimationDrawable)localObject).stop();
            ((AnimationDrawable)localObject).selectDrawable(0);
          }
        }
      }
      else if (localChatMessage.msgtype == -2071)
      {
        ((LightVideoItemBuilder)localObject).a((ListView)paramViewGroup);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqw
 * JD-Core Version:    0.7.0.1
 */