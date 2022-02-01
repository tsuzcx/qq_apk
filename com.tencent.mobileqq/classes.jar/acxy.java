import android.os.AsyncTask;
import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageRecord;

class acxy
  extends AsyncTask<MessageRecord, Object, Object>
{
  acxy(acxx paramacxx) {}
  
  protected Object a(MessageRecord... paramVarArgs)
  {
    if (this.a.a.d) {
      if (this.a.a.jdField_a_of_type_Aybz != null) {
        this.a.a.jdField_a_of_type_Aybz.a(paramVarArgs[0], true);
      }
    }
    for (;;)
    {
      if ((paramVarArgs[0] instanceof MessageForApollo)) {
        amat.a(this.a.a.app, "chat_history_start_del_msg");
      }
      return null;
      this.a.a.app.getMessageFacade().removeMsgByMessageRecord(paramVarArgs[0], true);
    }
  }
  
  protected void onPostExecute(Object paramObject)
  {
    super.onPostExecute(paramObject);
    this.a.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if ((this.a.a.jdField_a_of_type_Bhht != null) && (this.a.a.jdField_a_of_type_Bhht.isShowing())) {
      this.a.a.jdField_a_of_type_Bhht.dismiss();
    }
    if (this.a.a.d) {
      this.a.a.a(11, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acxy
 * JD-Core Version:    0.7.0.1
 */