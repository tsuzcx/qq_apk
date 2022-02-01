import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class akly
  implements ThreadExcutor.IThreadListener
{
  akly(aklv paramaklv, List paramList, Map paramMap, Bundle paramBundle) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      bhhf localbhhf = new bhhf(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilMap, UUID.randomUUID().toString());
      localbhhf.a(this.jdField_a_of_type_AndroidOsBundle);
      if (this.jdField_a_of_type_Aklv.a != null) {
        this.jdField_a_of_type_Aklv.a.a(localbhhf, aklv.a(this.jdField_a_of_type_Aklv), null);
      }
    }
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akly
 * JD-Core Version:    0.7.0.1
 */