import android.widget.RelativeLayout;
import com.tencent.mobileqq.olympic.activity.ARTipsManager.ARTipsVisibleListener;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class agjj
  implements ARTipsManager.ARTipsVisibleListener
{
  public agjj(ScanTorchActivity paramScanTorchActivity) {}
  
  public void a(boolean paramBoolean)
  {
    int j = 4;
    RelativeLayout localRelativeLayout;
    if (ScanTorchActivity.a(this.a) != null)
    {
      localRelativeLayout = ScanTorchActivity.a(this.a);
      if (paramBoolean)
      {
        i = 4;
        localRelativeLayout.setVisibility(i);
      }
    }
    else if (this.a.b != null)
    {
      localRelativeLayout = this.a.b;
      if (!paramBoolean) {
        break label70;
      }
    }
    label70:
    for (int i = j;; i = 0)
    {
      localRelativeLayout.setVisibility(i);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agjj
 * JD-Core Version:    0.7.0.1
 */