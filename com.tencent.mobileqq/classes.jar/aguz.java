import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.PhoneContactHelper;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class aguz
  implements AdapterView.OnItemClickListener
{
  public aguz(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = PhoneContactHelper.a(((TextView)paramView.findViewById(2131369901)).getText().toString());
    this.a.a(this.a.getActivity(), paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aguz
 * JD-Core Version:    0.7.0.1
 */