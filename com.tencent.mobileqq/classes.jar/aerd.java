import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.model.QueryTask.Query;
import mqq.os.MqqHandler;

public class aerd
  implements Runnable
{
  public aerd(QueryTask paramQueryTask, Object paramObject) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqModelQueryTask.a.a(this.jdField_a_of_type_JavaLangObject);
    ThreadManager.getUIHandler().post(new aere(this, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aerd
 * JD-Core Version:    0.7.0.1
 */