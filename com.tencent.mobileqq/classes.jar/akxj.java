import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class akxj
  implements ThreadExcutor.IThreadListener
{
  akxj(akxg paramakxg, List paramList, Map paramMap, Bundle paramBundle) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      bihu localbihu = new bihu(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilMap, UUID.randomUUID().toString());
      localbihu.a(this.jdField_a_of_type_AndroidOsBundle);
      if (this.jdField_a_of_type_Akxg.a != null) {
        this.jdField_a_of_type_Akxg.a.a(localbihu, akxg.a(this.jdField_a_of_type_Akxg), null);
      }
    }
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxj
 * JD-Core Version:    0.7.0.1
 */