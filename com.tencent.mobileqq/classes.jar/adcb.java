import android.database.DataSetObserver;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LebaListMgrActivity;

public class adcb
  extends DataSetObserver
{
  public adcb(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void onChanged()
  {
    TextView localTextView = LebaListMgrActivity.a(this.a);
    if (LebaListMgrActivity.a(this.a).getCount() > 0) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adcb
 * JD-Core Version:    0.7.0.1
 */