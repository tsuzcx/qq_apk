import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForSplitLineTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;

public class aedv
  extends actm
{
  public aedv(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected actn a()
  {
    return new aedw(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actn paramactn, View paramView, LinearLayout paramLinearLayout, acxj paramacxj)
  {
    if (paramView == null)
    {
      paramactn = (aedw)paramactn;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558785, null);
      paramLinearLayout = (TextView)paramView.findViewById(2131367153);
      paramacxj = (TextView)paramView.findViewById(2131367499);
      TextView localTextView = (TextView)paramView.findViewById(2131367500);
      paramLinearLayout.setMovementMethod(null);
      paramLinearLayout.setGravity(17);
      paramactn.b = paramLinearLayout;
      paramactn.c = paramacxj;
      paramactn.d = localTextView;
      paramView.setTag(paramactn);
      label92:
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label208;
      }
      paramactn.c.setBackgroundResource(2130842022);
      paramactn.d.setBackgroundResource(2130842022);
      label120:
      if ((paramMessageRecord.istroop != 1) || (!myb.a().a(paramMessageRecord.senderuin))) {
        break label229;
      }
      paramactn.b.setTextColor(myb.d);
    }
    for (;;)
    {
      if ((paramMessageRecord instanceof MessageForSplitLineTips)) {
        paramMessageRecord = (MessageForSplitLineTips)paramMessageRecord;
      }
      switch (paramMessageRecord.subType)
      {
      default: 
        paramactn.b.setText(paramMessageRecord.msgContent);
        return paramView;
        paramactn = (aedw)paramView.getTag();
        break label92;
        label208:
        paramactn.c.setBackgroundResource(2130842021);
        paramactn.d.setBackgroundResource(2130842021);
        break label120;
        label229:
        paramactn.b.setTextColor(paramView.getResources().getColorStateList(2131165465));
      }
    }
    paramactn.b.setText(ajya.a(2131715485));
    return paramView;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bbmh[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aedv
 * JD-Core Version:    0.7.0.1
 */