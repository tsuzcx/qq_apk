import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.arcard.ARCardShareHelper;
import mqq.os.MqqHandler;

class aamk
  implements Runnable
{
  aamk(aamf paramaamf, int paramInt) {}
  
  public void run()
  {
    boolean bool = ARCardShareHelper.a(this.jdField_a_of_type_Aamf.a);
    String str = ARCardShareHelper.b(this.jdField_a_of_type_Aamf.a);
    ThreadManager.getUIHandler().post(new aaml(this, bool, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamk
 * JD-Core Version:    0.7.0.1
 */