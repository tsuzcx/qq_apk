import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemNewDnaView;

public class agms
  extends GridLayoutManager
{
  public agms(IntimateContentItemNewDnaView paramIntimateContentItemNewDnaView, Context paramContext, int paramInt)
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
 * Qualified Name:     agms
 * JD-Core Version:    0.7.0.1
 */