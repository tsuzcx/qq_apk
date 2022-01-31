import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

public class abra
  implements HorizontalListView.OnScrollStateChangedListener
{
  public abra(DoutuManager paramDoutuManager) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 4097) {
      ReportController.b(DoutuManager.a(this.a), "dc00898", "", "", "0X8007FAA", "0X8007FAA", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abra
 * JD-Core Version:    0.7.0.1
 */