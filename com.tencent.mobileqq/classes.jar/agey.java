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

public class agey
  extends aepl
{
  public agey(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected aepm a()
  {
    return new agez(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aepm paramaepm, View paramView, LinearLayout paramLinearLayout, aetk paramaetk)
  {
    if (paramView == null)
    {
      paramaepm = (agez)paramaepm;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558820, null);
      paramLinearLayout = (TextView)paramView.findViewById(2131367292);
      paramaetk = (TextView)paramView.findViewById(2131367637);
      TextView localTextView = (TextView)paramView.findViewById(2131367638);
      paramLinearLayout.setMovementMethod(null);
      paramLinearLayout.setGravity(17);
      paramaepm.b = paramLinearLayout;
      paramaepm.c = paramaetk;
      paramaepm.d = localTextView;
      paramView.setTag(paramaepm);
      label92:
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label208;
      }
      paramaepm.c.setBackgroundResource(2130842187);
      paramaepm.d.setBackgroundResource(2130842187);
      label120:
      if ((paramMessageRecord.istroop != 1) || (!nav.a().a(paramMessageRecord.senderuin))) {
        break label229;
      }
      paramaepm.b.setTextColor(nav.d);
    }
    for (;;)
    {
      if ((paramMessageRecord instanceof MessageForSplitLineTips)) {
        paramMessageRecord = (MessageForSplitLineTips)paramMessageRecord;
      }
      switch (paramMessageRecord.subType)
      {
      default: 
        paramaepm.b.setText(paramMessageRecord.msgContent);
        return paramView;
        paramaepm = (agez)paramView.getTag();
        break label92;
        label208:
        paramaepm.c.setBackgroundResource(2130842186);
        paramaepm.d.setBackgroundResource(2130842186);
        break label120;
        label229:
        paramaepm.b.setTextColor(paramView.getResources().getColorStateList(2131165500));
      }
    }
    paramaepm.b.setText(alud.a(2131715869));
    return paramView;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bdpk[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agey
 * JD-Core Version:    0.7.0.1
 */