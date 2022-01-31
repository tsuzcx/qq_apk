import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.nearby.NearbyReportManager;
import com.tencent.mobileqq.nearby.NearbyReportManager.ReportRecord;
import com.tencent.util.LongSparseArray;
import java.util.ArrayList;

public class aevj
  implements Runnable
{
  public aevj(NearbyReportManager paramNearbyReportManager, LongSparseArray paramLongSparseArray, NearbyHandler paramNearbyHandler, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentUtilLongSparseArray.a())
    {
      localArrayList.add((NearbyReportManager.ReportRecord)this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(i));
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler.a(localArrayList, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aevj
 * JD-Core Version:    0.7.0.1
 */