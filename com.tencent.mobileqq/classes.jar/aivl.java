import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.widget.LoadMoreXListView;

public class aivl
  implements TextWatcher
{
  public aivl(SearchReciteArticleFragment paramSearchReciteArticleFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() == 0)
    {
      SearchReciteArticleFragment.a(this.a);
      SearchReciteArticleFragment.a(this.a, false);
      return;
    }
    SearchReciteArticleFragment.a(this.a).a();
    SearchReciteArticleFragment.a(this.a).notifyDataSetChanged();
    SearchReciteArticleFragment.a(this.a).a.a(false);
    SearchReciteArticleFragment.a(this.a, 0);
    SearchReciteArticleFragment.a(this.a, true);
    paramEditable = paramEditable.toString();
    SearchReciteArticleFragment.a(this.a, paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aivl
 * JD-Core Version:    0.7.0.1
 */