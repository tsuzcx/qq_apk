import android.view.View;
import com.tencent.mobileqq.remind.widget.IosTimepicker;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

public class ahge
  implements AdapterView.OnItemSelectedListener
{
  public ahge(IosTimepicker paramIosTimepicker) {}
  
  public void a(AdapterView paramAdapterView) {}
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    IosTimepicker.a(this.a, paramView, 1);
    if (paramView.getTag() != null)
    {
      int i = Integer.parseInt(paramView.getTag().toString());
      int j = paramAdapterView.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        if (i != paramInt) {
          IosTimepicker.a(this.a, paramAdapterView.getChildAt(paramInt), 0);
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahge
 * JD-Core Version:    0.7.0.1
 */