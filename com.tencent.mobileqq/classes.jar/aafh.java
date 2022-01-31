import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.arcard.ARCardShareHelper;
import mqq.os.MqqHandler;

class aafh
  implements Runnable
{
  aafh(aafe paramaafe) {}
  
  public void run()
  {
    boolean bool = ARCardShareHelper.a(this.a.a);
    String str = ARCardShareHelper.b(this.a.a);
    ThreadManager.getUIHandler().post(new aafi(this, bool, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aafh
 * JD-Core Version:    0.7.0.1
 */