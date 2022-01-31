import android.os.Message;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.search.HistorySearchEntryModel;
import com.tencent.util.MqqWeakReferenceHandler;

class ahvl
  implements Runnable
{
  ahvl(ahvk paramahvk, SearchHistory paramSearchHistory, long paramLong) {}
  
  public void run()
  {
    if (HistorySearchEntryModel.a(this.jdField_a_of_type_Ahvk.a, this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory))
    {
      Message localMessage = this.jdField_a_of_type_Ahvk.a.a.obtainMessage();
      localMessage.what = 3;
      localMessage.obj = new Long(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Ahvk.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahvl
 * JD-Core Version:    0.7.0.1
 */