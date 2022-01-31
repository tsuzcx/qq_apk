import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.arcard.ARCardShareHelper;
import mqq.os.MqqHandler;

class aafj
  implements Runnable
{
  aafj(aafe paramaafe, int paramInt) {}
  
  public void run()
  {
    boolean bool = ARCardShareHelper.a(this.jdField_a_of_type_Aafe.a);
    String str = ARCardShareHelper.b(this.jdField_a_of_type_Aafe.a);
    ThreadManager.getUIHandler().post(new aafk(this, bool, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aafj
 * JD-Core Version:    0.7.0.1
 */