import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.FileTimDocGrayTipsItemBuilder.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;

public class afhy
  extends afjb
  implements arnx
{
  private String b;
  
  public afhy(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected aekx a()
  {
    return new afhz(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aekx paramaekx, View paramView, LinearLayout paramLinearLayout, aeov paramaeov)
  {
    paramaekx = (afhz)paramaekx;
    paramMessageRecord = paramView;
    if (paramView == null)
    {
      paramMessageRecord = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560688, null);
      paramaekx.b = ((TextView)paramMessageRecord.findViewById(2131367282));
    }
    paramView = paramaekx.a.getExtInfoFromExtStr("tim_aio_show");
    this.b = paramaekx.a.getExtInfoFromExtStr("tim_aio_tips_type");
    if (!paramView.equalsIgnoreCase("showed"))
    {
      if (!this.b.equalsIgnoreCase("keyword")) {
        break label184;
      }
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009077", "0X8009077", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      paramaekx.a.saveExtInfoToExtStr("tim_aio_show", "showed");
      ThreadManager.executeOnSubThread(new FileTimDocGrayTipsItemBuilder.1(this, paramaekx));
      paramView = arni.a(paramaekx.a.getExtInfoFromExtStr("tim_aio_file_tips"), paramaekx.a.getExtInfoFromExtStr("tim_aio_file_link"), this);
      paramaekx.b.setText(paramView);
      paramaekx.b.setMovementMethod(LinkMovementMethod.getInstance());
      paramaekx.b.setHighlightColor(17170445);
      return paramMessageRecord;
      label184:
      if (this.b.equalsIgnoreCase("precent")) {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800907A", "0X800907A", 0, 0, "", "", "", "");
      } else if (this.b.equalsIgnoreCase("text_keyword")) {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009071", "0X800907A", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void onClick(View paramView)
  {
    ChatMessage localChatMessage = aekt.a(paramView);
    ((baet)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(272)).a(localChatMessage, paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhy
 * JD-Core Version:    0.7.0.1
 */