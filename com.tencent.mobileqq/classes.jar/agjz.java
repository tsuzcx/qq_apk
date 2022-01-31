import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class agjz
  implements ThreadExcutor.IThreadListener
{
  agjz(agjw paramagjw, List paramList, Map paramMap, Bundle paramBundle) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      batm localbatm = new batm(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilMap, UUID.randomUUID().toString());
      localbatm.a(this.jdField_a_of_type_AndroidOsBundle);
      if (this.jdField_a_of_type_Agjw.a != null) {
        this.jdField_a_of_type_Agjw.a.a(localbatm, agjw.a(this.jdField_a_of_type_Agjw), null);
      }
    }
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agjz
 * JD-Core Version:    0.7.0.1
 */