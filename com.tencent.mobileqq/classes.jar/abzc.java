import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessMsgListFragment;
import com.tencent.mobileqq.confess.ConfessObserver;

public class abzc
  extends ConfessObserver
{
  public abzc(ConfessMsgListFragment paramConfessMsgListFragment) {}
  
  public void a(ConfessConfig paramConfessConfig)
  {
    ConfessMsgListFragment.a(this.a);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (this.a.isResumed()) {
      this.a.b();
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (this.a.isResumed()) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abzc
 * JD-Core Version:    0.7.0.1
 */