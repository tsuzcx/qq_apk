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

public class ahvx
  extends agem
{
  public ahvx(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected agen a()
  {
    return new ahvy(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    if (paramView == null)
    {
      paramagen = (ahvy)paramagen;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558890, null);
      paramLinearLayout = (TextView)paramView.findViewById(2131367669);
      paramagjk = (TextView)paramView.findViewById(2131368014);
      TextView localTextView = (TextView)paramView.findViewById(2131368015);
      paramLinearLayout.setMovementMethod(null);
      paramLinearLayout.setGravity(17);
      paramagen.b = paramLinearLayout;
      paramagen.c = paramagjk;
      paramagen.d = localTextView;
      paramView.setTag(paramagen);
      label92:
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label208;
      }
      paramagen.c.setBackgroundResource(2130842510);
      paramagen.d.setBackgroundResource(2130842510);
      label120:
      if ((paramMessageRecord.istroop != 1) || (!nlj.a().a(paramMessageRecord.senderuin))) {
        break label229;
      }
      paramagen.b.setTextColor(nlj.d);
    }
    for (;;)
    {
      if ((paramMessageRecord instanceof MessageForSplitLineTips)) {
        paramMessageRecord = (MessageForSplitLineTips)paramMessageRecord;
      }
      switch (paramMessageRecord.subType)
      {
      default: 
        paramagen.b.setText(paramMessageRecord.msgContent);
        return paramView;
        paramagen = (ahvy)paramView.getTag();
        break label92;
        label208:
        paramagen.c.setBackgroundResource(2130842509);
        paramagen.d.setBackgroundResource(2130842509);
        break label120;
        label229:
        paramagen.b.setTextColor(paramView.getResources().getColorStateList(2131165537));
      }
    }
    paramagen.b.setText(anzj.a(2131714259));
    return paramView;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bhum[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahvx
 * JD-Core Version:    0.7.0.1
 */