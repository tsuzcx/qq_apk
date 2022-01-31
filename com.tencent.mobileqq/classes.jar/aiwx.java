import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView;

public class aiwx
  implements AdapterView.OnItemClickListener
{
  public aiwx(CmGameDebugView paramCmGameDebugView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    CmGameDebugView.a(this.a, paramInt);
    this.a.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiwx
 * JD-Core Version:    0.7.0.1
 */