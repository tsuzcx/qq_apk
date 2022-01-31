import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.widget.QQToast;

public class ajom
  implements View.OnClickListener
{
  public ajom(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onClick(View paramView)
  {
    if (PublishHomeWorkFragment.a(this.a).a(4) >= 6)
    {
      QQToast.a(this.a.getActivity(), String.format("最多布置%d个作业", new Object[] { Integer.valueOf(6) }), 0).a();
      return;
    }
    SearchReciteArticleFragment.a(this.a.getActivity(), PublishHomeWorkFragment.a(this.a));
    TroopReportor.a("Grp_edu", "Grp_recite", "Assign_Clk", 0, 0, new String[] { PublishHomeWorkFragment.a(this.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajom
 * JD-Core Version:    0.7.0.1
 */