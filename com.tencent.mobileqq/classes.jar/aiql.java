import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class aiql
  implements ThreadExcutor.IThreadListener
{
  aiql(aiqi paramaiqi, List paramList, Map paramMap, Bundle paramBundle) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      bdvv localbdvv = new bdvv(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilMap, UUID.randomUUID().toString());
      localbdvv.a(this.jdField_a_of_type_AndroidOsBundle);
      if (this.jdField_a_of_type_Aiqi.a != null) {
        this.jdField_a_of_type_Aiqi.a.a(localbdvv, aiqi.a(this.jdField_a_of_type_Aiqi), null);
      }
    }
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiql
 * JD-Core Version:    0.7.0.1
 */