import android.content.Context;
import android.support.v4.util.ArraySet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class agfy
  extends acut
{
  public final String a;
  
  public agfy(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo, null, null);
    this.jdField_a_of_type_JavaLangString = "MiniPie.MiniChatAdapter";
    this.jdField_a_of_type_Adtg = new agfz(paramContext, paramQQAppInterface, paramSessionInfo, null, null);
    this.jdField_a_of_type_Acuu = null;
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    long l1 = 0L;
    paramInt = 0;
    paramCharSequence = null;
    ChatMessage localChatMessage;
    boolean bool1;
    if (paramInt < paramList.size())
    {
      localChatMessage = (ChatMessage)paramList.get(paramInt);
      boolean bool2 = axas.b(localChatMessage.msgtype);
      if ((bool2) && ((paramInt == 0) || ((localChatMessage.time < this.b) && (localChatMessage.time - l1 > 300L)) || ((localChatMessage.time >= this.b) && (localChatMessage.time - l1 > 300L) && ((paramCharSequence == null) || (localChatMessage.time - paramCharSequence.time > 60L))) || ((this.jdField_a_of_type_AndroidSupportV4UtilArraySet.contains(Long.valueOf(localChatMessage.uniseq))) && (l1 / 60L != localChatMessage.time / 60L))))
      {
        bool1 = true;
        label165:
        localChatMessage.mNeedTimeStamp = bool1;
        if (localChatMessage.mNeedTimeStamp)
        {
          long l2 = localChatMessage.time;
          l1 = l2;
          if (localChatMessage.time < this.b)
          {
            acyl.a(localChatMessage);
            l1 = l2;
          }
        }
        if ((!bool2) || (((localChatMessage instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localChatMessage).tipParam.b == 1))) {
          break label362;
        }
        paramCharSequence = localChatMessage;
      }
    }
    label362:
    for (;;)
    {
      if (paramInt != paramList.size() - 1) {
        localChatMessage.isFlowMessage = false;
      }
      paramInt += 1;
      break;
      bool1 = false;
      break label165;
      if (paramList.size() > 0) {
        this.jdField_a_of_type_AndroidSupportV4UtilArraySet.add(Long.valueOf(((ChatMessage)paramList.get(0)).uniseq));
      }
      this.jdField_a_of_type_JavaUtilList = paramList;
      QLog.d("MiniPie.MiniChatAdapter", 1, "list addr = " + paramList.hashCode() + ",size = " + paramList.size());
      super.notifyDataSetChanged();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ((agfz)this.jdField_a_of_type_Adtg).a(paramBoolean);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void c()
  {
    super.c();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    if ((paramView != null) && ((paramView instanceof agfw)))
    {
      paramViewGroup = (agfw)paramView;
      paramViewGroup.setIsShieldTouchForItem(true);
      paramViewGroup.setFrom(((agfz)this.jdField_a_of_type_Adtg).a);
      if ((paramView instanceof BaseChatItemLayout)) {
        ((BaseChatItemLayout)paramView).c();
      }
    }
    return paramView;
  }
  
  public String toString()
  {
    return "list.addr = " + this.jdField_a_of_type_JavaUtilList.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agfy
 * JD-Core Version:    0.7.0.1
 */