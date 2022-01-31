import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment;
import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment.5.1;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ahtm
  implements ThreadExcutor.IThreadListener
{
  public ahtm(PublicAccountFragment paramPublicAccountFragment) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    ThreadManager.getUIHandler().post(new PublicAccountFragment.5.1(this));
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahtm
 * JD-Core Version:    0.7.0.1
 */