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

public class agaj
  extends aekw
{
  public agaj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected aekx a()
  {
    return new agak(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aekx paramaekx, View paramView, LinearLayout paramLinearLayout, aeov paramaeov)
  {
    if (paramView == null)
    {
      paramaekx = (agak)paramaekx;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558821, null);
      paramLinearLayout = (TextView)paramView.findViewById(2131367282);
      paramaeov = (TextView)paramView.findViewById(2131367627);
      TextView localTextView = (TextView)paramView.findViewById(2131367628);
      paramLinearLayout.setMovementMethod(null);
      paramLinearLayout.setGravity(17);
      paramaekx.b = paramLinearLayout;
      paramaekx.c = paramaeov;
      paramaekx.d = localTextView;
      paramView.setTag(paramaekx);
      label92:
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label208;
      }
      paramaekx.c.setBackgroundResource(2130842174);
      paramaekx.d.setBackgroundResource(2130842174);
      label120:
      if ((paramMessageRecord.istroop != 1) || (!nav.a().a(paramMessageRecord.senderuin))) {
        break label229;
      }
      paramaekx.b.setTextColor(nav.d);
    }
    for (;;)
    {
      if ((paramMessageRecord instanceof MessageForSplitLineTips)) {
        paramMessageRecord = (MessageForSplitLineTips)paramMessageRecord;
      }
      switch (paramMessageRecord.subType)
      {
      default: 
        paramaekx.b.setText(paramMessageRecord.msgContent);
        return paramView;
        paramaekx = (agak)paramView.getTag();
        break label92;
        label208:
        paramaekx.c.setBackgroundResource(2130842173);
        paramaekx.d.setBackgroundResource(2130842173);
        break label120;
        label229:
        paramaekx.b.setTextColor(paramView.getResources().getColorStateList(2131165500));
      }
    }
    paramaekx.b.setText(alpo.a(2131715857));
    return paramView;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bdlb[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agaj
 * JD-Core Version:    0.7.0.1
 */