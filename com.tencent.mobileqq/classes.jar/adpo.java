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

public class adpo
  extends adqw
  implements apuv
{
  private String b;
  
  public adpo(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected actn a()
  {
    return new adpp(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actn paramactn, View paramView, LinearLayout paramLinearLayout, acxj paramacxj)
  {
    paramactn = (adpp)paramactn;
    paramMessageRecord = paramView;
    if (paramView == null)
    {
      paramMessageRecord = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560512, null);
      paramactn.b = ((TextView)paramMessageRecord.findViewById(2131367153));
    }
    paramView = paramactn.a.getExtInfoFromExtStr("tim_aio_show");
    this.b = paramactn.a.getExtInfoFromExtStr("tim_aio_tips_type");
    if (!paramView.equalsIgnoreCase("showed"))
    {
      if (!this.b.equalsIgnoreCase("keyword")) {
        break label184;
      }
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009077", "0X8009077", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      paramactn.a.saveExtInfoToExtStr("tim_aio_show", "showed");
      ThreadManager.executeOnSubThread(new FileTimDocGrayTipsItemBuilder.1(this, paramactn));
      paramView = apug.a(paramactn.a.getExtInfoFromExtStr("tim_aio_file_tips"), paramactn.a.getExtInfoFromExtStr("tim_aio_file_link"), this);
      paramactn.b.setText(paramView);
      paramactn.b.setMovementMethod(LinkMovementMethod.getInstance());
      paramactn.b.setHighlightColor(17170445);
      return paramMessageRecord;
      label184:
      if (this.b.equalsIgnoreCase("precent")) {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800907A", "0X800907A", 0, 0, "", "", "", "");
      } else if (this.b.equalsIgnoreCase("text_keyword")) {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009071", "0X800907A", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void onClick(View paramView)
  {
    ChatMessage localChatMessage = actj.a(paramView);
    ((aygx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(272)).a(localChatMessage, paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adpo
 * JD-Core Version:    0.7.0.1
 */