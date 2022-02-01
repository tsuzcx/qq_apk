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

public class agsl
  extends aexf
{
  public agsl(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected aexg a()
  {
    return new agsm(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aexg paramaexg, View paramView, LinearLayout paramLinearLayout, afce paramafce)
  {
    if (paramView == null)
    {
      paramaexg = (agsm)paramaexg;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558898, null);
      paramLinearLayout = (TextView)paramView.findViewById(2131367701);
      paramafce = (TextView)paramView.findViewById(2131368049);
      TextView localTextView = (TextView)paramView.findViewById(2131368050);
      paramLinearLayout.setMovementMethod(null);
      paramLinearLayout.setGravity(17);
      paramaexg.b = paramLinearLayout;
      paramaexg.c = paramafce;
      paramaexg.d = localTextView;
      paramView.setTag(paramaexg);
      label92:
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label208;
      }
      paramaexg.c.setBackgroundResource(2130842556);
      paramaexg.d.setBackgroundResource(2130842556);
      label120:
      if ((paramMessageRecord.istroop != 1) || (!nmy.a().a(paramMessageRecord.senderuin))) {
        break label229;
      }
      paramaexg.b.setTextColor(nmy.d);
    }
    for (;;)
    {
      if ((paramMessageRecord instanceof MessageForSplitLineTips)) {
        paramMessageRecord = (MessageForSplitLineTips)paramMessageRecord;
      }
      switch (paramMessageRecord.subType)
      {
      default: 
        paramaexg.b.setText(paramMessageRecord.msgContent);
        return paramView;
        paramaexg = (agsm)paramView.getTag();
        break label92;
        label208:
        paramaexg.c.setBackgroundResource(2130842555);
        paramaexg.d.setBackgroundResource(2130842555);
        break label120;
        label229:
        paramaexg.b.setTextColor(paramView.getResources().getColorStateList(2131165545));
      }
    }
    paramaexg.b.setText(amtj.a(2131714491));
    return paramView;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bgbb[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agsl
 * JD-Core Version:    0.7.0.1
 */