import android.database.DataSetObserver;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LebaListMgrActivity;

public class ablc
  extends DataSetObserver
{
  public ablc(LebaListMgrActivity paramLebaListMgrActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ablc
 * JD-Core Version:    0.7.0.1
 */