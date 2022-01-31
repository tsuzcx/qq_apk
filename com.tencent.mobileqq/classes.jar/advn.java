import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.model.QueryTask.Query;
import mqq.os.MqqHandler;

public class advn
  implements Runnable
{
  public advn(QueryTask paramQueryTask, Object paramObject) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqModelQueryTask.a.a(this.jdField_a_of_type_JavaLangObject);
    ThreadManager.getUIHandler().post(new advo(this, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     advn
 * JD-Core Version:    0.7.0.1
 */