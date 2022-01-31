import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment.SearchArticle;
import com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment;
import com.tencent.mobileqq.util.TroopReportor;

class aivr
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TextView b;
  TextView c;
  
  private aivr(aivq paramaivq) {}
  
  public void onClick(View paramView)
  {
    if ((aivq.a(this.jdField_a_of_type_Aivq) != null) && (aivq.a(this.jdField_a_of_type_Aivq).getActivity() != null))
    {
      paramView = this.jdField_a_of_type_Aivq.a(this.jdField_a_of_type_Int);
      SelectReciteParagraphFragment.a(aivq.a(this.jdField_a_of_type_Aivq).getActivity(), SearchReciteArticleFragment.a(aivq.a(this.jdField_a_of_type_Aivq)), paramView.c, SearchReciteArticleFragment.a(aivq.a(this.jdField_a_of_type_Aivq)));
      TroopReportor.a("Grp_edu", "Grp_recite", "Search_Content_Clk", 0, 0, new String[] { SearchReciteArticleFragment.a(aivq.a(this.jdField_a_of_type_Aivq)), "0", String.valueOf(this.jdField_a_of_type_Int), String.valueOf(paramView.jdField_a_of_type_Int) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aivr
 * JD-Core Version:    0.7.0.1
 */