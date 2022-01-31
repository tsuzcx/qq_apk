import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.HashSet;

public class alku
  implements View.OnClickListener
{
  public alku(ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((ActionSheet.a(this.a)) && ((ActionSheet.a(this.a) == null) || (!ActionSheet.a(this.a).contains(Integer.valueOf(i)))) && (ActionSheet.b(this.a) != -1) && (i != ActionSheet.b(this.a)))
    {
      Object localObject = (View)ActionSheet.a(this.a).get(ActionSheet.b(this.a));
      ((View)localObject).findViewById(2131362794).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(2131362793);
      ActionSheet.a(this.a, (TextView)localObject, false);
      localObject = (View)ActionSheet.a(this.a).get(i);
      ((View)localObject).findViewById(2131362794).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131362793);
      ActionSheet.a(this.a, (TextView)localObject, true);
      ActionSheet.a(this.a, i);
    }
    if (ActionSheet.a(this.a) != null) {
      ActionSheet.a(this.a).OnClick(paramView, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     alku
 * JD-Core Version:    0.7.0.1
 */