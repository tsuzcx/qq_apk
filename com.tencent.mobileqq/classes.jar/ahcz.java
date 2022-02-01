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

public class ahcz
  extends ahed
  implements aunx
{
  private String b;
  
  public ahcz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected agen a()
  {
    return new ahda(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    paramagen = (ahda)paramagen;
    paramMessageRecord = paramView;
    if (paramView == null)
    {
      paramMessageRecord = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560942, null);
      paramagen.b = ((TextView)paramMessageRecord.findViewById(2131367669));
    }
    paramView = paramagen.a.getExtInfoFromExtStr("tim_aio_show");
    this.b = paramagen.a.getExtInfoFromExtStr("tim_aio_tips_type");
    if (!paramView.equalsIgnoreCase("showed"))
    {
      if (!this.b.equalsIgnoreCase("keyword")) {
        break label184;
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009077", "0X8009077", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      paramagen.a.saveExtInfoToExtStr("tim_aio_show", "showed");
      ThreadManager.executeOnSubThread(new FileTimDocGrayTipsItemBuilder.1(this, paramagen));
      paramView = aunj.a(paramagen.a.getExtInfoFromExtStr("tim_aio_file_tips"), paramagen.a.getExtInfoFromExtStr("tim_aio_file_link"), this);
      paramagen.b.setText(paramView);
      paramagen.b.setMovementMethod(LinkMovementMethod.getInstance());
      paramagen.b.setHighlightColor(17170445);
      return paramMessageRecord;
      label184:
      if (this.b.equalsIgnoreCase("precent")) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800907A", "0X800907A", 0, 0, "", "", "", "");
      } else if (this.b.equalsIgnoreCase("text_keyword")) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009071", "0X800907A", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void onClick(View paramView)
  {
    ChatMessage localChatMessage = agej.a(paramView);
    ((bedb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(272)).a(localChatMessage, paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcz
 * JD-Core Version:    0.7.0.1
 */