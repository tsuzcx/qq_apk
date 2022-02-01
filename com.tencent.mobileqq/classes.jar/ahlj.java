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

public class ahlj
  extends afor
{
  public ahlj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected afos a()
  {
    return new ahlk(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    if (paramView == null)
    {
      paramafos = (ahlk)paramafos;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558925, null);
      paramLinearLayout = (TextView)paramView.findViewById(2131367837);
      paramaftk = (TextView)paramView.findViewById(2131368184);
      TextView localTextView = (TextView)paramView.findViewById(2131368185);
      paramLinearLayout.setMovementMethod(null);
      paramLinearLayout.setGravity(17);
      paramafos.b = paramLinearLayout;
      paramafos.c = paramaftk;
      paramafos.d = localTextView;
      paramView.setTag(paramafos);
      label92:
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label208;
      }
      paramafos.c.setBackgroundResource(2130842586);
      paramafos.d.setBackgroundResource(2130842586);
      label120:
      if ((paramMessageRecord.istroop != 1) || (!nty.a().a(paramMessageRecord.senderuin))) {
        break label229;
      }
      paramafos.b.setTextColor(nty.d);
    }
    for (;;)
    {
      if ((paramMessageRecord instanceof MessageForSplitLineTips)) {
        paramMessageRecord = (MessageForSplitLineTips)paramMessageRecord;
      }
      switch (paramMessageRecord.subType)
      {
      default: 
        paramafos.b.setText(paramMessageRecord.msgContent);
        return paramView;
        paramafos = (ahlk)paramView.getTag();
        break label92;
        label208:
        paramafos.c.setBackgroundResource(2130842585);
        paramafos.d.setBackgroundResource(2130842585);
        break label120;
        label229:
        paramafos.b.setTextColor(paramView.getResources().getColorStateList(2131165551));
      }
    }
    paramafos.b.setText(anvx.a(2131714838));
    return paramView;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bhjs[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlj
 * JD-Core Version:    0.7.0.1
 */