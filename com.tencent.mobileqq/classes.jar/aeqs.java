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
import com.tencent.widget.ListView;
import java.util.Calendar;
import java.util.List;

public class aeqs
  extends aeqo
{
  public int a;
  private aequ jdField_a_of_type_Aequ;
  private aeqv jdField_a_of_type_Aeqv = new aeqv(this, null);
  public Calendar a;
  Context b;
  public Calendar b;
  
  public aeqs(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie, aequ paramaequ)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aequ = paramaequ;
  }
  
  public int a(List<ChatMessage> paramList, int paramInt1, Calendar paramCalendar1, Calendar paramCalendar2, int paramInt2, MessageRecord paramMessageRecord)
  {
    if ((paramList == null) || (paramCalendar1 == null)) {
      return -1;
    }
    if (paramInt1 == 2)
    {
      if ((this.jdField_b_of_type_JavaUtilCalendar != null) && (this.jdField_b_of_type_JavaUtilCalendar.get(1) == paramCalendar1.get(1)) && (this.jdField_b_of_type_JavaUtilCalendar.get(2) == paramCalendar1.get(2)) && (this.jdField_b_of_type_JavaUtilCalendar.get(5) == paramCalendar1.get(5))) {
        return -1;
      }
      this.jdField_b_of_type_JavaUtilCalendar = ((Calendar)paramCalendar1.clone());
      paramInt2 = paramList.size() + 2;
      this.jdField_a_of_type_JavaUtilList.addAll(0, paramList);
    }
    for (;;)
    {
      long l1 = 0L;
      int i = 0;
      paramList = null;
      label113:
      boolean bool1;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        paramCalendar1 = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
        boolean bool2 = azah.b(paramCalendar1.msgtype);
        if ((bool2) && ((i == 0) || ((paramCalendar1.time < this.jdField_b_of_type_Long) && (paramCalendar1.time - l1 > 300L)) || ((paramCalendar1.time >= this.jdField_b_of_type_Long) && (paramCalendar1.time - l1 > 300L) && ((paramList == null) || (paramCalendar1.time - paramList.time > 60L))) || ((this.jdField_a_of_type_AndroidSupportV4UtilArraySet.contains(Long.valueOf(paramCalendar1.uniseq))) && (l1 / 60L != paramCalendar1.time / 60L))))
        {
          bool1 = true;
          label271:
          paramCalendar1.mNeedTimeStamp = bool1;
          if (paramCalendar1.mNeedTimeStamp)
          {
            long l2 = paramCalendar1.time;
            l1 = l2;
            if (paramCalendar1.time < this.jdField_b_of_type_Long)
            {
              aeuk.a(paramCalendar1);
              l1 = l2;
            }
          }
          if ((!bool2) || (((paramCalendar1 instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)paramCalendar1).tipParam.b == 1))) {
            break label864;
          }
          paramList = paramCalendar1;
        }
      }
      label864:
      for (;;)
      {
        if (i != this.jdField_a_of_type_JavaUtilList.size() - 1) {
          paramCalendar1.isFlowMessage = false;
        }
        i += 1;
        break label113;
        if (paramInt1 == 3)
        {
          if ((this.jdField_a_of_type_JavaUtilCalendar != null) && (this.jdField_a_of_type_JavaUtilCalendar.get(1) == paramCalendar1.get(1)) && (this.jdField_a_of_type_JavaUtilCalendar.get(2) == paramCalendar1.get(2)) && (this.jdField_a_of_type_JavaUtilCalendar.get(5) == paramCalendar1.get(5))) {
            return -1;
          }
          this.jdField_a_of_type_JavaUtilCalendar = ((Calendar)paramCalendar1.clone());
          this.jdField_a_of_type_JavaUtilList.addAll(paramList);
          break;
        }
        if ((paramInt1 != 5) && (paramInt1 != 6) && (paramInt1 != 1) && (paramInt1 != 0)) {
          break label867;
        }
        this.jdField_b_of_type_JavaUtilCalendar = ((Calendar)paramCalendar1.clone());
        if (paramCalendar2 != null) {}
        for (this.jdField_a_of_type_JavaUtilCalendar = ((Calendar)paramCalendar2.clone());; this.jdField_a_of_type_JavaUtilCalendar = ((Calendar)paramCalendar1.clone()))
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          paramInt2 = 0;
          this.jdField_a_of_type_JavaUtilList.addAll(paramList);
          break;
        }
        bool1 = false;
        break label271;
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          this.jdField_a_of_type_AndroidSupportV4UtilArraySet.add(Long.valueOf(((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(0)).uniseq));
        }
        i = paramInt2;
        if (paramInt1 == 6)
        {
          i = paramInt2;
          if (paramMessageRecord != null)
          {
            int j = this.jdField_a_of_type_JavaUtilList.size();
            paramInt1 = 0;
            while (paramInt1 < j)
            {
              i = paramInt2;
              if (((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).shmsgseq == paramMessageRecord.shmsgseq)
              {
                if (paramInt1 < j - 1) {}
                for (paramInt2 = paramInt1 + 2;; paramInt2 = paramInt1)
                {
                  i = paramInt2;
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("ChatHistoryC2CAllFragment", 2, "refreshData---> cache id: " + ((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).getId() + ", searchRecord id: " + paramMessageRecord.getId() + ",msgseq:" + ((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).msgseq + ",searchRecord: " + paramMessageRecord.msgseq + ",selection:" + paramInt2 + ",cacheRecords size:" + j + ",msg text:" + ((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).msg + ",search text:" + paramMessageRecord.msg);
                  notifyDataSetChanged();
                  return paramInt2;
                }
              }
              paramInt1 += 1;
              paramInt2 = i;
            }
            i = paramInt2;
          }
        }
        notifyDataSetChanged();
        return i;
      }
      label867:
      paramInt2 = 0;
    }
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
    aeqy localaeqy = this.jdField_a_of_type_Afpy.a(localChatMessage, this);
    paramView = localaeqy.a(paramInt, this.jdField_a_of_type_JavaUtilList.size(), localChatMessage, paramView, paramViewGroup, this.jdField_a_of_type_Aeqv);
    if (paramView != null) {
      paramView.setTag(2131364186, localChatMessage);
    }
    if ((paramView instanceof BaseChatItemLayout)) {
      ((BaseChatItemLayout)paramView).a();
    }
    if ((localChatMessage.msgtype == -2009) || (localChatMessage.msgtype == -2016)) {
      ((aggj)localaeqy).a(false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryAdapterForC2C", 2, "AIOTime getView " + localChatMessage.getClass().getName());
      }
      return paramView;
      if (localChatMessage.msgtype == -2076)
      {
        if ((localaeqy instanceof afuu)) {
          ((afuu)localaeqy).a(false);
        }
      }
      else if (localChatMessage.msgtype == -2039)
      {
        if ((localaeqy instanceof ApolloItemBuilder))
        {
          ((ApolloItemBuilder)localaeqy).a(false);
          paramViewGroup = (afib)aepi.a(paramView);
          if (paramViewGroup != null)
          {
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
            if (paramViewGroup.jdField_a_of_type_AndroidWidgetImageView != null)
            {
              paramViewGroup = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
              if ((paramViewGroup instanceof AnimationDrawable))
              {
                ((AnimationDrawable)paramViewGroup).stop();
                ((AnimationDrawable)paramViewGroup).selectDrawable(0);
              }
            }
          }
        }
        else if ((localaeqy instanceof afhq))
        {
          ((afhq)localaeqy).a(false);
        }
      }
      else if (localChatMessage.msgtype == -2071) {
        ((LightVideoItemBuilder)localaeqy).a((ListView)paramViewGroup);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeqs
 * JD-Core Version:    0.7.0.1
 */