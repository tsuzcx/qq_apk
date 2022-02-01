import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class adqk
  implements DialogInterface.OnClickListener
{
  public adqk(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      ((allt)this.a.app.getBusinessHandler(BusinessHandlerFactory.FILTER_MSG_BOX_HANDLER)).a(Long.parseLong(ChatSettingActivity.a(this.a)));
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e(ChatSettingActivity.c(this.a), 1, "showFilterMsgNoticeDialog(): the uin is not Long");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqk
 * JD-Core Version:    0.7.0.1
 */