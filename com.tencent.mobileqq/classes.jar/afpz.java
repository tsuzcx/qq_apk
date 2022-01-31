import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ocr.ui.SearchResultAdapter;
import com.tencent.mobileqq.ocr.ui.SearchResultAdapter.ListItem;
import com.tencent.mobileqq.ocr.ui.SearchResultAdapter.OnResultItemClickedListener;

public class afpz
  implements View.OnClickListener
{
  public afpz(SearchResultAdapter paramSearchResultAdapter) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && ((paramView.getTag() instanceof SearchResultAdapter.ListItem)))
    {
      paramView = (SearchResultAdapter.ListItem)paramView.getTag();
      this.a.a.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afpz
 * JD-Core Version:    0.7.0.1
 */