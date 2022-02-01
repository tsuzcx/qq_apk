import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.FileTimDocGrayTipsItemBuilder.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;

public class agsb
  extends agtf
  implements aueo
{
  private String b;
  
  public agsb(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected afos a()
  {
    return new agsc(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    paramafos = (agsc)paramafos;
    paramMessageRecord = paramView;
    if (paramView == null)
    {
      paramMessageRecord = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560882, null);
      paramafos.b = ((TextView)paramMessageRecord.findViewById(2131367837));
    }
    paramView = paramafos.a.getExtInfoFromExtStr("tim_aio_show");
    this.b = paramafos.a.getExtInfoFromExtStr("tim_aio_tips_type");
    if (!paramView.equalsIgnoreCase("showed"))
    {
      if (!this.b.equalsIgnoreCase("keyword")) {
        break label184;
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009077", "0X8009077", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      paramafos.a.saveExtInfoToExtStr("tim_aio_show", "showed");
      ThreadManager.executeOnSubThread(new FileTimDocGrayTipsItemBuilder.1(this, paramafos));
      paramView = auea.a(paramafos.a.getExtInfoFromExtStr("tim_aio_file_tips"), paramafos.a.getExtInfoFromExtStr("tim_aio_file_link"), this);
      paramafos.b.setText(paramView);
      paramafos.b.setMovementMethod(LinkMovementMethod.getInstance());
      paramafos.b.setHighlightColor(17170445);
      return paramMessageRecord;
      label184:
      if (this.b.equalsIgnoreCase("precent")) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800907A", "0X800907A", 0, 0, "", "", "", "");
      } else if (this.b.equalsIgnoreCase("text_keyword")) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009071", "0X800907A", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void onClick(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.getMessage(paramView);
    ((bedr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).a(localChatMessage, paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agsb
 * JD-Core Version:    0.7.0.1
 */