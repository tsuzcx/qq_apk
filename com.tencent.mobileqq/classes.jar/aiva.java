import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class aiva
  implements ThreadExcutor.IThreadListener
{
  aiva(aiux paramaiux, List paramList, Map paramMap, Bundle paramBundle) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      beae localbeae = new beae(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilMap, UUID.randomUUID().toString());
      localbeae.a(this.jdField_a_of_type_AndroidOsBundle);
      if (this.jdField_a_of_type_Aiux.a != null) {
        this.jdField_a_of_type_Aiux.a.a(localbeae, aiux.a(this.jdField_a_of_type_Aiux), null);
      }
    }
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiva
 * JD-Core Version:    0.7.0.1
 */