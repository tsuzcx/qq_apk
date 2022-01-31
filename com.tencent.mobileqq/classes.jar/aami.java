import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.arcard.ARCardShareHelper;
import mqq.os.MqqHandler;

class aami
  implements Runnable
{
  aami(aamf paramaamf) {}
  
  public void run()
  {
    boolean bool = ARCardShareHelper.a(this.a.a);
    String str = ARCardShareHelper.b(this.a.a);
    ThreadManager.getUIHandler().post(new aamj(this, bool, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aami
 * JD-Core Version:    0.7.0.1
 */