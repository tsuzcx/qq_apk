import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import java.util.List;

class ajjp
  extends Filter
{
  ajjp(ajjo paramajjo) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjp
 * JD-Core Version:    0.7.0.1
 */