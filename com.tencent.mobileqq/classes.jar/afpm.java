import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class afpm
  implements AdapterView.OnItemClickListener
{
  afpm(afpl paramafpl) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ajhk)afpl.a(this.a).a.getItem(paramInt - 1);
    afpl.a(this.a, paramAdapterView);
    afpl.a(this.a).dismiss();
    bcef.b(afpl.a(this.a).app, "dc00898", "", "", "0X800A417", "0X800A417", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpm
 * JD-Core Version:    0.7.0.1
 */