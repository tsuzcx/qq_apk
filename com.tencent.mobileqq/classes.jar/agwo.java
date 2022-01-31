import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class agwo
  implements ThreadExcutor.IThreadListener
{
  agwo(agwl paramagwl, List paramList, Map paramMap, Bundle paramBundle) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      bbwg localbbwg = new bbwg(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilMap, UUID.randomUUID().toString());
      localbbwg.a(this.jdField_a_of_type_AndroidOsBundle);
      if (this.jdField_a_of_type_Agwl.a != null) {
        this.jdField_a_of_type_Agwl.a.a(localbbwg, agwl.a(this.jdField_a_of_type_Agwl), null);
      }
    }
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agwo
 * JD-Core Version:    0.7.0.1
 */