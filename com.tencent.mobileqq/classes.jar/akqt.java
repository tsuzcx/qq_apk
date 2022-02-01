import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class akqt
  implements ThreadExcutor.IThreadListener
{
  akqt(akqq paramakqq, List paramList, Map paramMap, Bundle paramBundle) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      bhyo localbhyo = new bhyo(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilMap, UUID.randomUUID().toString());
      localbhyo.a(this.jdField_a_of_type_AndroidOsBundle);
      if (this.jdField_a_of_type_Akqq.a != null) {
        this.jdField_a_of_type_Akqq.a.a(localbhyo, akqq.a(this.jdField_a_of_type_Akqq), null);
      }
    }
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akqt
 * JD-Core Version:    0.7.0.1
 */