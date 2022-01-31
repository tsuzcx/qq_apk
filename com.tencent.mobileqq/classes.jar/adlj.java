import com.tencent.mobileqq.activity.QQBrowserActivity;
import mqq.util.WeakReference;

public class adlj
  implements berl
{
  final WeakReference<QQBrowserActivity> a;
  
  public adlj(QQBrowserActivity paramQQBrowserActivity)
  {
    this.a = new WeakReference(paramQQBrowserActivity);
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    QQBrowserActivity localQQBrowserActivity = (QQBrowserActivity)this.a.get();
    if (localQQBrowserActivity == null) {}
    while (paramInt1 == paramInt2) {
      return;
    }
    QQBrowserActivity.a(paramInt2, localQQBrowserActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adlj
 * JD-Core Version:    0.7.0.1
 */