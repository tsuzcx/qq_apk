import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import com.tencent.mobileqq.hiboom.HiBoomPanelView.HiBoomAdapter;

public class adxq
  extends GridLayoutManager.SpanSizeLookup
{
  public adxq(HiBoomPanelView.HiBoomAdapter paramHiBoomAdapter) {}
  
  public int getSpanSize(int paramInt)
  {
    switch (this.a.getItemViewType(paramInt))
    {
    case 1: 
    default: 
      return 1;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxq
 * JD-Core Version:    0.7.0.1
 */