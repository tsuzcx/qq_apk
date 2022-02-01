import com.tencent.mobileqq.activity.recent.msgbox.FilterMessageBoxFragment;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;

public class alls
  implements ThreadExcutor.IThreadListener
{
  public alls(FilterMessageBoxFragment paramFilterMessageBoxFragment) {}
  
  public void onAdded()
  {
    FilterMessageBoxFragment.a(this.a, true);
  }
  
  public void onPostRun()
  {
    FilterMessageBoxFragment.a(this.a, false);
  }
  
  public void onPreRun()
  {
    FilterMessageBoxFragment.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alls
 * JD-Core Version:    0.7.0.1
 */