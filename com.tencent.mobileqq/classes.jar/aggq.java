import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class aggq
  implements AdapterView.OnItemClickListener
{
  aggq(aggp paramaggp) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (akcy)aggp.a(this.a).a.getItem(paramInt - 1);
    aggp.a(this.a, paramAdapterView);
    aggp.a(this.a).dismiss();
    bdla.b(aggp.a(this.a).app, "dc00898", "", "", "0X800A417", "0X800A417", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aggq
 * JD-Core Version:    0.7.0.1
 */