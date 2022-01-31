import com.tencent.widget.AbsListView;

public class aljy
  implements Runnable
{
  public aljy(AbsListView paramAbsListView) {}
  
  public void run()
  {
    if (this.a.mCachingStarted)
    {
      AbsListView localAbsListView = this.a;
      this.a.mCachingActive = false;
      localAbsListView.mCachingStarted = false;
      AbsListView.access$3000(this.a, false);
      if ((AbsListView.access$3100(this.a) & 0x2) == 0) {
        AbsListView.access$3200(this.a, false);
      }
      if (!this.a.isAlwaysDrawnWithCacheEnabled()) {
        this.a.invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aljy
 * JD-Core Version:    0.7.0.1
 */