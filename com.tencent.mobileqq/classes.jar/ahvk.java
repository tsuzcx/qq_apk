import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.search.HistorySearchEntryModel;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

public class ahvk
  implements View.OnClickListener
{
  public ahvk(HistorySearchEntryModel paramHistorySearchEntryModel) {}
  
  public void onClick(View paramView)
  {
    long l = ((Long)paramView.getTag(-1)).longValue();
    int i = HistorySearchEntryModel.a(this.a, this.a.a, l);
    if (i == -1) {}
    do
    {
      return;
      paramView = (SearchHistory)((IContactSearchable)this.a.a.get(i)).a();
    } while (paramView == null);
    SearchUtils.a("home_page", "del_history", new String[] { "" + i });
    ThreadManager.postImmediately(new ahvl(this, paramView, l), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahvk
 * JD-Core Version:    0.7.0.1
 */