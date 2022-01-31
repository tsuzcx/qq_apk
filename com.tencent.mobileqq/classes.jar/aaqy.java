import android.os.AsyncTask;
import android.os.Handler;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageRecord;

class aaqy
  extends AsyncTask<MessageRecord, Object, Object>
{
  aaqy(aaqx paramaaqx) {}
  
  protected Object a(MessageRecord... paramVarArgs)
  {
    if (this.a.a.d) {
      if (this.a.a.jdField_a_of_type_Aumb != null) {
        this.a.a.jdField_a_of_type_Aumb.a(paramVarArgs[0], true);
      }
    }
    for (;;)
    {
      if ((paramVarArgs[0] instanceof MessageForApollo)) {
        ajey.a(this.a.a.app, "chat_history_start_del_msg");
      }
      return null;
      this.a.a.app.a().a(paramVarArgs[0], true);
    }
  }
  
  protected void onPostExecute(Object paramObject)
  {
    super.onPostExecute(paramObject);
    this.a.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if ((this.a.a.jdField_a_of_type_Bcqf != null) && (this.a.a.jdField_a_of_type_Bcqf.isShowing())) {
      this.a.a.jdField_a_of_type_Bcqf.dismiss();
    }
    if (this.a.a.d) {
      this.a.a.a(11, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaqy
 * JD-Core Version:    0.7.0.1
 */