import android.database.DataSetObserver;
import com.tencent.widget.PagerBaseAdapterWrapper;

public class alng
  extends DataSetObserver
{
  public alng(PagerBaseAdapterWrapper paramPagerBaseAdapterWrapper) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     alng
 * JD-Core Version:    0.7.0.1
 */