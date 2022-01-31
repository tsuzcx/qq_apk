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

public class adsy
  extends acjb
{
  public adsy(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected acjc a()
  {
    return new adsz(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, acjc paramacjc, View paramView, LinearLayout paramLinearLayout, acmv paramacmv)
  {
    if (paramView == null)
    {
      paramacjc = (adsz)paramacjc;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493229, null);
      paramLinearLayout = (TextView)paramView.findViewById(2131301543);
      paramacmv = (TextView)paramView.findViewById(2131301882);
      TextView localTextView = (TextView)paramView.findViewById(2131301883);
      paramLinearLayout.setMovementMethod(null);
      paramLinearLayout.setGravity(17);
      paramacjc.b = paramLinearLayout;
      paramacjc.c = paramacmv;
      paramacjc.d = localTextView;
      paramView.setTag(paramacjc);
      label92:
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label208;
      }
      paramacjc.c.setBackgroundResource(2130841928);
      paramacjc.d.setBackgroundResource(2130841928);
      label120:
      if ((paramMessageRecord.istroop != 1) || (!mnf.a().a(paramMessageRecord.senderuin))) {
        break label229;
      }
      paramacjc.b.setTextColor(mnf.d);
    }
    for (;;)
    {
      if ((paramMessageRecord instanceof MessageForSplitLineTips)) {
        paramMessageRecord = (MessageForSplitLineTips)paramMessageRecord;
      }
      switch (paramMessageRecord.subType)
      {
      default: 
        paramacjc.b.setText(paramMessageRecord.msgContent);
        return paramView;
        paramacjc = (adsz)paramView.getTag();
        break label92;
        label208:
        paramacjc.c.setBackgroundResource(2130841927);
        paramacjc.d.setBackgroundResource(2130841927);
        break label120;
        label229:
        paramacjc.b.setTextColor(paramView.getResources().getColorStateList(2131099880));
      }
    }
    paramacjc.b.setText(ajjy.a(2131649684));
    return paramView;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bakj[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adsy
 * JD-Core Version:    0.7.0.1
 */