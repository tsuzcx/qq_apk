import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

public class abyb
  implements HorizontalListView.OnScrollStateChangedListener
{
  public abyb(DoutuManager paramDoutuManager) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 4097) {
      ReportController.b(DoutuManager.a(this.a), "dc00898", "", "", "0X8007FAA", "0X8007FAA", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyb
 * JD-Core Version:    0.7.0.1
 */