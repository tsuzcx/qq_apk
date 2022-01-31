import com.tencent.mobileqq.activity.aio.doodle.LoadDataJob;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

public class aewb
  implements aewe
{
  public aewb(LoadDataJob paramLoadDataJob, Map paramMap, List paramList) {}
  
  public void a(int paramInt, aewp paramaewp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadDataJob", 2, "unmarshall task finish id:" + paramInt);
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
      this.jdField_a_of_type_JavaUtilMap.notifyAll();
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramaewp);
      if (this.jdField_a_of_type_JavaUtilList.size() == LoadDataJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob)) {
        this.jdField_a_of_type_JavaUtilList.notifyAll();
      }
      return;
      paramaewp = finally;
      throw paramaewp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aewb
 * JD-Core Version:    0.7.0.1
 */