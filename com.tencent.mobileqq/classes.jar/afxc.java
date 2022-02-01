import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.util.ArraySet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.Calendar;
import java.util.List;

public class afxc
  extends afwy
{
  public int a;
  private afxe jdField_a_of_type_Afxe;
  private afxf jdField_a_of_type_Afxf = new afxf(this, null);
  public Calendar a;
  Context b;
  public Calendar b;
  
  public afxc(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie, afxe paramafxe)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Afxe = paramafxe;
  }
  
  private void e()
  {
    long l1 = 0L;
    int i = 0;
    Object localObject = null;
    ChatMessage localChatMessage;
    boolean bool1;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
      boolean bool2 = bbzj.b(localChatMessage.msgtype);
      if ((bool2) && ((i == 0) || ((localChatMessage.time < this.jdField_b_of_type_Long) && (localChatMessage.time - l1 > 300L)) || ((localChatMessage.time >= this.jdField_b_of_type_Long) && (localChatMessage.time - l1 > 300L) && ((localObject == null) || (localChatMessage.time - localObject.time > 60L))) || ((this.jdField_a_of_type_AndroidSupportV4UtilArraySet.contains(Long.valueOf(localChatMessage.uniseq))) && (l1 / 60L != localChatMessage.time / 60L))))
      {
        bool1 = true;
        label170:
        localChatMessage.mNeedTimeStamp = bool1;
        if (localChatMessage.mNeedTimeStamp)
        {
          long l2 = localChatMessage.time;
          l1 = l2;
          if (localChatMessage.time < this.jdField_b_of_type_Long)
          {
            agau.a(localChatMessage);
            l1 = l2;
          }
        }
        if ((!bool2) || (((localChatMessage instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localChatMessage).tipParam.b == 1))) {
          break label283;
        }
        localObject = localChatMessage;
      }
    }
    label283:
    for (;;)
    {
      if (i != this.jdField_a_of_type_JavaUtilList.size() - 1) {
        localChatMessage.isFlowMessage = false;
      }
      i += 1;
      break;
      bool1 = false;
      break label170;
      return;
    }
  }
  
  public int a(List<ChatMessage> paramList, int paramInt1, Calendar paramCalendar1, Calendar paramCalendar2, int paramInt2, MessageRecord paramMessageRecord)
  {
    if ((paramList == null) || (paramCalendar1 == null)) {
      return -1;
    }
    int i;
    int j;
    if (paramInt1 == 2)
    {
      if ((this.jdField_b_of_type_JavaUtilCalendar != null) && (this.jdField_b_of_type_JavaUtilCalendar.get(1) == paramCalendar1.get(1)) && (this.jdField_b_of_type_JavaUtilCalendar.get(2) == paramCalendar1.get(2)) && (this.jdField_b_of_type_JavaUtilCalendar.get(5) == paramCalendar1.get(5))) {
        return -1;
      }
      this.jdField_b_of_type_JavaUtilCalendar = ((Calendar)paramCalendar1.clone());
      paramInt2 = paramList.size() + 2;
      this.jdField_a_of_type_JavaUtilList.addAll(0, paramList);
      e();
      if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
        this.jdField_a_of_type_AndroidSupportV4UtilArraySet.add(Long.valueOf(((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(0)).uniseq));
      }
      i = paramInt2;
      if (paramInt1 == 6)
      {
        i = paramInt2;
        if (paramMessageRecord != null)
        {
          j = this.jdField_a_of_type_JavaUtilList.size();
          paramInt1 = 0;
        }
      }
    }
    else
    {
      for (;;)
      {
        if (paramInt1 >= j) {
          break label584;
        }
        i = paramInt2;
        if (((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).shmsgseq == paramMessageRecord.shmsgseq)
        {
          if (paramInt1 < j - 1) {}
          for (paramInt2 = paramInt1 + 2;; paramInt2 = paramInt1)
          {
            i = paramInt2;
            if (!QLog.isColorLevel()) {
              break label573;
            }
            QLog.d("ChatHistoryC2CAllFragment", 2, "refreshData---> cache id: " + ((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).getId() + ", searchRecord id: " + paramMessageRecord.getId() + ",msgseq:" + ((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).msgseq + ",searchRecord: " + paramMessageRecord.msgseq + ",selection:" + paramInt2 + ",cacheRecords size:" + j + ",msg text:" + ((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).msg + ",search text:" + paramMessageRecord.msg);
            notifyDataSetChanged();
            return paramInt2;
            if (paramInt1 == 3)
            {
              if ((this.jdField_a_of_type_JavaUtilCalendar != null) && (this.jdField_a_of_type_JavaUtilCalendar.get(1) == paramCalendar1.get(1)) && (this.jdField_a_of_type_JavaUtilCalendar.get(2) == paramCalendar1.get(2)) && (this.jdField_a_of_type_JavaUtilCalendar.get(5) == paramCalendar1.get(5))) {
                return -1;
              }
              this.jdField_a_of_type_JavaUtilCalendar = ((Calendar)paramCalendar1.clone());
              this.jdField_a_of_type_JavaUtilList.addAll(paramList);
              break;
            }
            if ((paramInt1 == 5) || (paramInt1 == 6) || (paramInt1 == 1) || (paramInt1 == 0))
            {
              this.jdField_b_of_type_JavaUtilCalendar = ((Calendar)paramCalendar1.clone());
              if (paramCalendar2 == null) {
                break label553;
              }
            }
            label553:
            for (this.jdField_a_of_type_JavaUtilCalendar = ((Calendar)paramCalendar2.clone());; this.jdField_a_of_type_JavaUtilCalendar = ((Calendar)paramCalendar1.clone()))
            {
              this.jdField_a_of_type_JavaUtilList.clear();
              this.jdField_a_of_type_JavaUtilList.addAll(paramList);
              paramInt2 = 0;
              break;
            }
          }
        }
        label573:
        paramInt1 += 1;
        paramInt2 = i;
      }
      label584:
      i = paramInt2;
    }
    notifyDataSetChanged();
    return i;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void b(List<MessageRecord> paramList)
  {
    if (paramList == null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.jdField_a_of_type_JavaUtilList.removeAll(paramList);
      paramList.clear();
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = this.jdField_a_of_type_Agwz.a(localChatMessage, this);
    View localView = ((afxi)localObject).a(paramInt, this.jdField_a_of_type_JavaUtilList.size(), localChatMessage, paramView, paramViewGroup, this.jdField_a_of_type_Afxf);
    if (localView != null) {
      localView.setTag(2131364392, localChatMessage);
    }
    if ((localView instanceof BaseChatItemLayout)) {
      ((BaseChatItemLayout)localView).b();
    }
    if ((localChatMessage.msgtype == -2009) || (localChatMessage.msgtype == -2016)) {
      ((ahny)localObject).a(false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryAdapterForC2C", 2, "AIOTime getView " + localChatMessage.getClass().getName());
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      if (localChatMessage.msgtype == -2076)
      {
        if ((localObject instanceof ahbv)) {
          ((ahbv)localObject).a(false);
        }
      }
      else if (localChatMessage.msgtype == -2039)
      {
        if ((localObject instanceof ApolloItemBuilder))
        {
          ((ApolloItemBuilder)localObject).a(false);
          localObject = (agpj)afur.a(localView);
          if (localObject != null)
          {
            ((agpj)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
            if (((agpj)localObject).jdField_a_of_type_AndroidWidgetImageView != null)
            {
              localObject = ((agpj)localObject).jdField_a_of_type_AndroidWidgetImageView.getDrawable();
              if ((localObject instanceof AnimationDrawable))
              {
                ((AnimationDrawable)localObject).stop();
                ((AnimationDrawable)localObject).selectDrawable(0);
              }
            }
          }
        }
        else if ((localObject instanceof agoy))
        {
          ((agoy)localObject).a(false);
        }
      }
      else if (localChatMessage.msgtype == -2071) {
        ((LightVideoItemBuilder)localObject).a((ListView)paramViewGroup);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afxc
 * JD-Core Version:    0.7.0.1
 */