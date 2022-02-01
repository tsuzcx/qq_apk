import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class ajva
  implements ThreadExcutor.IThreadListener
{
  ajva(ajux paramajux, List paramList, Map paramMap, Bundle paramBundle) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      bgoe localbgoe = new bgoe(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilMap, UUID.randomUUID().toString());
      localbgoe.a(this.jdField_a_of_type_AndroidOsBundle);
      if (this.jdField_a_of_type_Ajux.a != null) {
        this.jdField_a_of_type_Ajux.a.a(localbgoe, ajux.a(this.jdField_a_of_type_Ajux), null);
      }
    }
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajva
 * JD-Core Version:    0.7.0.1
 */