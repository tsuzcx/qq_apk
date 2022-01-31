import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.armap.map.ARMapPOIStarDialog;
import com.tencent.mobileqq.statistics.ReportController;

public class abhd
  implements View.OnClickListener
{
  public abhd(ARMapPOIStarDialog paramARMapPOIStarDialog) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc01440", "", "", "0X80079CC", "0X80079CC", 0, 0, "", "", "", "");
    if (!this.a.c) {
      ReportController.b(null, "dc01440", "", "", "0X80079CC", "0X80079CC", 0, 0, "", "", "", "");
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abhd
 * JD-Core Version:    0.7.0.1
 */