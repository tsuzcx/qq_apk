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

public class aedx
  extends actq
{
  public aedx(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected actr a()
  {
    return new aedy(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actr paramactr, View paramView, LinearLayout paramLinearLayout, acxn paramacxn)
  {
    if (paramView == null)
    {
      paramactr = (aedy)paramactr;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558785, null);
      paramLinearLayout = (TextView)paramView.findViewById(2131367153);
      paramacxn = (TextView)paramView.findViewById(2131367499);
      TextView localTextView = (TextView)paramView.findViewById(2131367500);
      paramLinearLayout.setMovementMethod(null);
      paramLinearLayout.setGravity(17);
      paramactr.b = paramLinearLayout;
      paramactr.c = paramacxn;
      paramactr.d = localTextView;
      paramView.setTag(paramactr);
      label92:
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label208;
      }
      paramactr.c.setBackgroundResource(2130842021);
      paramactr.d.setBackgroundResource(2130842021);
      label120:
      if ((paramMessageRecord.istroop != 1) || (!mye.a().a(paramMessageRecord.senderuin))) {
        break label229;
      }
      paramactr.b.setTextColor(mye.d);
    }
    for (;;)
    {
      if ((paramMessageRecord instanceof MessageForSplitLineTips)) {
        paramMessageRecord = (MessageForSplitLineTips)paramMessageRecord;
      }
      switch (paramMessageRecord.subType)
      {
      default: 
        paramactr.b.setText(paramMessageRecord.msgContent);
        return paramView;
        paramactr = (aedy)paramView.getTag();
        break label92;
        label208:
        paramactr.c.setBackgroundResource(2130842020);
        paramactr.d.setBackgroundResource(2130842020);
        break label120;
        label229:
        paramactr.b.setTextColor(paramView.getResources().getColorStateList(2131165465));
      }
    }
    paramactr.b.setText(ajyc.a(2131715474));
    return paramView;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bblt[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aedx
 * JD-Core Version:    0.7.0.1
 */