import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment.SearchArticle;
import com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment;
import com.tencent.mobileqq.util.TroopReportor;

class ajjv
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TextView b;
  TextView c;
  
  private ajjv(ajju paramajju) {}
  
  public void onClick(View paramView)
  {
    if ((ajju.a(this.jdField_a_of_type_Ajju) != null) && (ajju.a(this.jdField_a_of_type_Ajju).getActivity() != null))
    {
      paramView = this.jdField_a_of_type_Ajju.a(this.jdField_a_of_type_Int);
      SelectReciteParagraphFragment.a(ajju.a(this.jdField_a_of_type_Ajju).getActivity(), SearchReciteArticleFragment.a(ajju.a(this.jdField_a_of_type_Ajju)), paramView.c, SearchReciteArticleFragment.a(ajju.a(this.jdField_a_of_type_Ajju)));
      TroopReportor.a("Grp_edu", "Grp_recite", "Search_Content_Clk", 0, 0, new String[] { SearchReciteArticleFragment.a(ajju.a(this.jdField_a_of_type_Ajju)), "0", String.valueOf(this.jdField_a_of_type_Int), String.valueOf(paramView.jdField_a_of_type_Int) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjv
 * JD-Core Version:    0.7.0.1
 */