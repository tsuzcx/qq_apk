import android.view.View;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment.SearchArticle;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HWReciteInfo;
import com.tencent.mobileqq.troop.widget.LoadMoreXListView;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import org.json.JSONException;

public class ajjs
  implements AdapterView.OnItemClickListener
{
  public ajjs(SearchReciteArticleFragment paramSearchReciteArticleFragment) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < SearchReciteArticleFragment.a(this.a).getCount()) {
      paramAdapterView = SearchReciteArticleFragment.a(this.a).a(paramInt);
    }
    try
    {
      TroopReportor.a("Grp_edu", "Grp_recite", "Search_Content_Clk", 0, 0, new String[] { SearchReciteArticleFragment.a(this.a), "1", String.valueOf(paramInt), String.valueOf(paramAdapterView.jdField_a_of_type_Int) });
      TroopReportor.a("Grp_edu", "Grp_recite", "Clk_Success", 0, 0, new String[] { SearchReciteArticleFragment.a(this.a), String.valueOf(paramAdapterView.jdField_a_of_type_Int) });
      SearchReciteArticleFragment.a(this.a, HWReciteInfo.a(SearchReciteArticleFragment.a(this.a), paramAdapterView.jdField_a_of_type_JavaLangString, paramAdapterView.c, null));
      SearchReciteArticleFragment.b(this.a);
      return;
    }
    catch (JSONException paramAdapterView)
    {
      paramAdapterView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjs
 * JD-Core Version:    0.7.0.1
 */