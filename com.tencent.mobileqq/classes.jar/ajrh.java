import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment.SearchArticle;
import com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment;
import com.tencent.mobileqq.util.TroopReportor;

class ajrh
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TextView b;
  TextView c;
  
  private ajrh(ajrg paramajrg) {}
  
  public void onClick(View paramView)
  {
    if ((ajrg.a(this.jdField_a_of_type_Ajrg) != null) && (ajrg.a(this.jdField_a_of_type_Ajrg).getActivity() != null))
    {
      paramView = this.jdField_a_of_type_Ajrg.a(this.jdField_a_of_type_Int);
      SelectReciteParagraphFragment.a(ajrg.a(this.jdField_a_of_type_Ajrg).getActivity(), SearchReciteArticleFragment.a(ajrg.a(this.jdField_a_of_type_Ajrg)), paramView.c, SearchReciteArticleFragment.a(ajrg.a(this.jdField_a_of_type_Ajrg)));
      TroopReportor.a("Grp_edu", "Grp_recite", "Search_Content_Clk", 0, 0, new String[] { SearchReciteArticleFragment.a(ajrg.a(this.jdField_a_of_type_Ajrg)), "0", String.valueOf(this.jdField_a_of_type_Int), String.valueOf(paramView.jdField_a_of_type_Int) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrh
 * JD-Core Version:    0.7.0.1
 */