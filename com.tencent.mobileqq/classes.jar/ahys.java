import android.os.AsyncTask;
import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageRecord;

class ahys
  extends AsyncTask<MessageRecord, Object, Object>
{
  ahys(ahyr paramahyr) {}
  
  protected Object a(MessageRecord... paramVarArgs)
  {
    int i;
    if (paramVarArgs[0].time <= this.a.a.jdField_a_of_type_Alxa.a())
    {
      i = ((awhr)this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(201)).a(paramVarArgs[0], true);
      if (i > 0) {
        this.a.a.f = true;
      }
    }
    for (;;)
    {
      if ((paramVarArgs[0] instanceof MessageForApollo)) {
        alaz.a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history_c2c_del_all_msg");
      }
      return null;
      if ((i == 0) && (paramVarArgs[0].time == this.a.a.jdField_a_of_type_Alxa.a()))
      {
        this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramVarArgs[0], true);
        continue;
        this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramVarArgs[0], true);
      }
    }
  }
  
  protected void onPostExecute(Object paramObject)
  {
    super.onPostExecute(paramObject);
    this.a.a.b.removeMessages(1);
    if ((this.a.a.jdField_a_of_type_Bety != null) && (this.a.a.jdField_a_of_type_Bety.isShowing())) {
      this.a.a.jdField_a_of_type_Bety.dismiss();
    }
    if ((this.a.a.f) && (this.a.a.e))
    {
      this.a.a.e = false;
      this.a.a.jdField_a_of_type_Alxa.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahys
 * JD-Core Version:    0.7.0.1
 */