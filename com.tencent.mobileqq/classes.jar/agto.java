import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper;
import mqq.os.MqqHandler;

class agto
  implements Runnable
{
  agto(agtj paramagtj, long paramLong) {}
  
  public void run()
  {
    String str = ShareHelper.a(this.jdField_a_of_type_Agtj.a);
    ThreadManager.getUIHandler().post(new agtp(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agto
 * JD-Core Version:    0.7.0.1
 */