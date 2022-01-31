import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.arcard.ARCardShareHelper;
import mqq.os.MqqHandler;

class aate
  implements Runnable
{
  aate(aasz paramaasz, int paramInt) {}
  
  public void run()
  {
    boolean bool = ARCardShareHelper.a(this.jdField_a_of_type_Aasz.a);
    String str = ARCardShareHelper.b(this.jdField_a_of_type_Aasz.a);
    ThreadManager.getUIHandler().post(new aatf(this, bool, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aate
 * JD-Core Version:    0.7.0.1
 */