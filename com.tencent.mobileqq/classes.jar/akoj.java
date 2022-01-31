import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView;

public class akoj
  implements AdapterView.OnItemClickListener
{
  public akoj(CmGameDebugView paramCmGameDebugView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    CmGameDebugView.a(this.a, paramInt);
    this.a.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akoj
 * JD-Core Version:    0.7.0.1
 */