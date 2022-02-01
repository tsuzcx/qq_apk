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
import com.tencent.mobileqq.data.MessageForMyEnterTroop;
import com.tencent.mobileqq.data.MessageRecord;

public class ahmr
  extends agem
{
  public ahmr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected agen a()
  {
    return new ahms(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    paramLinearLayout = (ahms)paramagen;
    paramagen = paramView;
    if (paramView == null)
    {
      paramagen = LayoutInflater.from(this.a).inflate(2131558887, null);
      paramLinearLayout.b = ((TextView)paramagen.findViewById(2131367669));
    }
    paramLinearLayout.b.setMovementMethod(null);
    paramLinearLayout.b.setGravity(17);
    if ((paramMessageRecord instanceof MessageForMyEnterTroop))
    {
      paramMessageRecord = (MessageForMyEnterTroop)paramMessageRecord;
      paramMessageRecord = this.a.getString(2131696540);
      paramLinearLayout.b.setText(paramMessageRecord);
      paramView = this.a.getResources().getColorStateList(2131165428);
      if (paramView != null) {
        paramLinearLayout.b.setTextColor(paramView);
      }
      paramagen.setContentDescription(paramMessageRecord);
    }
    return paramagen;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bhum[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmr
 * JD-Core Version:    0.7.0.1
 */