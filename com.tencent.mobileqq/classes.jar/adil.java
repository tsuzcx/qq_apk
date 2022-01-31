import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLimitChatTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.limitchat.TopicTextView;
import com.tencent.mobileqq.theme.ThemeUtil;

public class adil
  extends acjb
{
  public adil(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected acjc a()
  {
    return new adim();
  }
  
  protected View a(MessageRecord paramMessageRecord, acjc paramacjc, View paramView, LinearLayout paramLinearLayout, acmv paramacmv)
  {
    MessageForLimitChatTopic localMessageForLimitChatTopic = (MessageForLimitChatTopic)paramMessageRecord;
    if ((paramacjc instanceof adim)) {}
    for (paramLinearLayout = (adim)paramacjc;; paramLinearLayout = null)
    {
      if ((paramView == null) || (paramLinearLayout == null))
      {
        paramacmv = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493623, null);
        paramView = new adim();
        paramacmv.setTag(paramView);
        paramLinearLayout = paramView;
      }
      for (;;)
      {
        paramLinearLayout.jdField_a_of_type_ComTencentMobileqqLimitchatTopicTextView = ((TopicTextView)paramacmv.findViewById(2131312553));
        paramLinearLayout.b = paramacmv.findViewById(2131297594);
        paramLinearLayout.jdField_a_of_type_Long = paramMessageRecord.uniseq;
        paramLinearLayout.jdField_a_of_type_ComTencentMobileqqLimitchatTopicTextView.setTopicText(localMessageForLimitChatTopic.msg);
        if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
          paramLinearLayout.b.setBackgroundResource(2130840147);
        }
        for (;;)
        {
          if (e)
          {
            paramacjc.b.append(localMessageForLimitChatTopic.msg);
            paramacmv.setContentDescription(paramacjc.b.toString());
          }
          return paramacmv;
          paramLinearLayout.b.setBackgroundResource(2130840148);
        }
        paramacmv = paramView;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bakj[] a(View paramView)
  {
    return new bakj[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adil
 * JD-Core Version:    0.7.0.1
 */