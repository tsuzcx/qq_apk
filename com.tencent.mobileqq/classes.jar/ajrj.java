import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HWReciteInfo;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONException;

public class ajrj
  implements View.OnClickListener
{
  public ajrj(SelectReciteParagraphFragment paramSelectReciteParagraphFragment) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (!SelectReciteParagraphFragment.a(this.a).isEmpty()) {
        if (SelectReciteParagraphFragment.a(this.a).size() != SelectReciteParagraphFragment.a(this.a).getCount())
        {
          paramView = new ArrayList(SelectReciteParagraphFragment.a(this.a));
          SelectReciteParagraphFragment.a(this.a, HWReciteInfo.a(SelectReciteParagraphFragment.a(this.a), SelectReciteParagraphFragment.a(this.a).title, SelectReciteParagraphFragment.a(this.a).kid, paramView));
          this.a.getActivity().finish();
          TroopReportor.a("Grp_edu", "Grp_recite", "Clk_Success", 0, 0, new String[] { SelectReciteParagraphFragment.a(this.a), String.valueOf(SelectReciteParagraphFragment.a(this.a).type - 1) });
          String str1 = SelectReciteParagraphFragment.a(this.a);
          String str2 = SelectReciteParagraphFragment.a(this.a).title;
          if (paramView != null) {}
          int i;
          for (paramView = String.valueOf(paramView.size());; paramView = String.valueOf(i))
          {
            TroopReportor.a("Grp_edu", "Grp_recite", "Section_Count", 0, 0, new String[] { str1, str2, paramView });
            return;
            i = SelectReciteParagraphFragment.a(this.a).paragraphs.size();
          }
        }
      }
    }
    catch (JSONException paramView)
    {
      while (QLog.isColorLevel())
      {
        QLog.e("SelectReciteParagraphFragment", 2, paramView, new Object[0]);
        return;
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrj
 * JD-Core Version:    0.7.0.1
 */