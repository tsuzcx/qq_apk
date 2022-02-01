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

public class ahmn
  extends afuu
{
  public ahmn(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected afuv a()
  {
    return new ahmo(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afuv paramafuv, View paramView, LinearLayout paramLinearLayout, afzq paramafzq)
  {
    if (paramView == null)
    {
      paramafuv = (ahmo)paramafuv;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558892, null);
      paramLinearLayout = (TextView)paramView.findViewById(2131367600);
      paramafzq = (TextView)paramView.findViewById(2131367944);
      TextView localTextView = (TextView)paramView.findViewById(2131367945);
      paramLinearLayout.setMovementMethod(null);
      paramLinearLayout.setGravity(17);
      paramafuv.b = paramLinearLayout;
      paramafuv.c = paramafzq;
      paramafuv.d = localTextView;
      paramView.setTag(paramafuv);
      label92:
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label208;
      }
      paramafuv.c.setBackgroundResource(2130842497);
      paramafuv.d.setBackgroundResource(2130842497);
      label120:
      if ((paramMessageRecord.istroop != 1) || (!njo.a().a(paramMessageRecord.senderuin))) {
        break label229;
      }
      paramafuv.b.setTextColor(njo.d);
    }
    for (;;)
    {
      if ((paramMessageRecord instanceof MessageForSplitLineTips)) {
        paramMessageRecord = (MessageForSplitLineTips)paramMessageRecord;
      }
      switch (paramMessageRecord.subType)
      {
      default: 
        paramafuv.b.setText(paramMessageRecord.msgContent);
        return paramView;
        paramafuv = (ahmo)paramView.getTag();
        break label92;
        label208:
        paramafuv.c.setBackgroundResource(2130842496);
        paramafuv.d.setBackgroundResource(2130842496);
        break label120;
        label229:
        paramafuv.b.setTextColor(paramView.getResources().getColorStateList(2131165537));
      }
    }
    paramafuv.b.setText(anni.a(2131714150));
    return paramView;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bguj[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmn
 * JD-Core Version:    0.7.0.1
 */