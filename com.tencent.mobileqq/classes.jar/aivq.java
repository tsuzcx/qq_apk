import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment.SearchArticle;
import java.util.ArrayList;
import java.util.List;

public class aivq
  extends BaseAdapter
{
  private SearchReciteArticleFragment jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public aivq(SearchReciteArticleFragment paramSearchReciteArticleFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment = paramSearchReciteArticleFragment;
  }
  
  public SearchReciteArticleFragment.SearchArticle a(int paramInt)
  {
    return (SearchReciteArticleFragment.SearchArticle)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(SearchReciteArticleFragment.SearchArticle paramSearchArticle)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramSearchArticle);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969910, null, false);
      paramViewGroup = new aivr(this, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361926));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131368424));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131361932));
      paramViewGroup.b.setOnClickListener(paramViewGroup);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      SearchReciteArticleFragment.SearchArticle localSearchArticle = a(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(SearchReciteArticleFragment.a(this.jdField_a_of_type_JavaLangString, localSearchArticle.jdField_a_of_type_JavaLangString, Color.parseColor("#00B6F9")));
      paramViewGroup.c.setText(SearchReciteArticleFragment.a(this.jdField_a_of_type_JavaLangString, localSearchArticle.b, Color.parseColor("#00B6F9")));
      paramViewGroup = paramViewGroup.b;
      if (localSearchArticle.jdField_a_of_type_Int != 1) {
        break label175;
      }
    }
    label175:
    for (paramInt = 0;; paramInt = 8)
    {
      paramViewGroup.setVisibility(paramInt);
      return paramView;
      paramViewGroup = (aivr)paramView.getTag();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aivq
 * JD-Core Version:    0.7.0.1
 */