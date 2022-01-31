import android.os.Message;
import com.tencent.mobileqq.search.HistorySearchEntryModel;
import com.tencent.util.MqqWeakReferenceHandler;

public class ahvn
  implements Runnable
{
  public ahvn(HistorySearchEntryModel paramHistorySearchEntryModel) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_JavaUtilList = HistorySearchEntryModel.a(this.a);
    Message localMessage = this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage();
    localMessage.what = 1;
    this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1);
    this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahvn
 * JD-Core Version:    0.7.0.1
 */