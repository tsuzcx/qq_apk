import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.richstatus.TipsInfo;
import java.util.Iterator;
import java.util.LinkedList;

class ahup
  implements Runnable
{
  ahup(ahuo paramahuo, int paramInt, RichStatus paramRichStatus, TipsInfo paramTipsInfo) {}
  
  public void run()
  {
    if (StatusManager.b(this.jdField_a_of_type_Ahuo.a.a) != null)
    {
      Iterator localIterator = StatusManager.b(this.jdField_a_of_type_Ahuo.a.a).iterator();
      while (localIterator.hasNext()) {
        ((IStatusListener)localIterator.next()).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.jdField_a_of_type_ComTencentMobileqqRichstatusTipsInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahup
 * JD-Core Version:    0.7.0.1
 */