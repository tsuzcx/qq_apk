import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment.FlowLayoutKeywordsListAdapter;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment.FlowLayoutKeywordsListAdapter.OnItemClickListener;
import com.tencent.mobileqq.util.TroopReportor;

public class ajrc
  implements SearchReciteArticleFragment.FlowLayoutKeywordsListAdapter.OnItemClickListener
{
  public ajrc(SearchReciteArticleFragment paramSearchReciteArticleFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    paramView = SearchReciteArticleFragment.a(this.a).a(paramInt);
    SearchReciteArticleFragment.a(this.a).setText(paramView);
    SearchReciteArticleFragment.a(this.a).setSelection(paramView.length());
    TroopReportor.a("Grp_edu", "Grp_recite", "Recommend_Clk", 0, 0, new String[] { SearchReciteArticleFragment.a(this.a), paramView });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrc
 * JD-Core Version:    0.7.0.1
 */