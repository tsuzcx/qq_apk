import com.tencent.mobileqq.ark.ArkHorizontalListView;
import com.tencent.mobileqq.ark.ArkHorizontalListView.RefreshUiCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aang
  implements Runnable
{
  public aang(ArkHorizontalListView paramArkHorizontalListView) {}
  
  public void run()
  {
    if ((ArkHorizontalListView.a(this.a) != null) && (ArkHorizontalListView.a(this.a).get() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkHorizontalListView", 2, "checkScrollToChild updateHeadBorder");
      }
      ((ArkHorizontalListView.RefreshUiCallback)ArkHorizontalListView.a(this.a).get()).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aang
 * JD-Core Version:    0.7.0.1
 */