import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import java.util.List;

class alsm
  extends Filter
{
  alsm(alsl paramalsl) {}
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    paramCharSequence = new Filter.FilterResults();
    paramCharSequence.values = this.a.a.a;
    paramCharSequence.count = this.a.a.a.size();
    return paramCharSequence;
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    if (paramFilterResults.count > 0)
    {
      this.a.notifyDataSetChanged();
      return;
    }
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alsm
 * JD-Core Version:    0.7.0.1
 */