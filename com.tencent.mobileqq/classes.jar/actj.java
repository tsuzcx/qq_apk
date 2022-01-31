import com.tencent.mobileqq.activity.aio.doodle.LoadDataJob;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

public class actj
  implements actm
{
  public actj(LoadDataJob paramLoadDataJob, Map paramMap, List paramList) {}
  
  public void a(int paramInt, actx paramactx)
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
      this.jdField_a_of_type_JavaUtilList.add(paramactx);
      if (this.jdField_a_of_type_JavaUtilList.size() == LoadDataJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob)) {
        this.jdField_a_of_type_JavaUtilList.notifyAll();
      }
      return;
      paramactx = finally;
      throw paramactx;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     actj
 * JD-Core Version:    0.7.0.1
 */