import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import com.tencent.mobileqq.activity.aio.PanelAdapter;

public class afcf
  extends GridLayoutManager
{
  public afcf(PanelAdapter paramPanelAdapter, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public boolean canScrollHorizontally()
  {
    return false;
  }
  
  public boolean canScrollVertically()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afcf
 * JD-Core Version:    0.7.0.1
 */