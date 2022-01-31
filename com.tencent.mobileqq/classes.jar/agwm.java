import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class agwm
  implements ThreadExcutor.IThreadListener
{
  agwm(agwj paramagwj, List paramList, Map paramMap, Bundle paramBundle) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      bbwu localbbwu = new bbwu(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilMap, UUID.randomUUID().toString());
      localbbwu.a(this.jdField_a_of_type_AndroidOsBundle);
      if (this.jdField_a_of_type_Agwj.a != null) {
        this.jdField_a_of_type_Agwj.a.a(localbbwu, agwj.a(this.jdField_a_of_type_Agwj), null);
      }
    }
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agwm
 * JD-Core Version:    0.7.0.1
 */