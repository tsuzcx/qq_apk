import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.leba.LebaTitleBar;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;

public class adzh
  implements View.OnFocusChangeListener
{
  public adzh(LebaTitleBar paramLebaTitleBar) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.clearFocus();
      UniteSearchActivity.a(LebaTitleBar.a(this.a), null, 21, 0L, (HotWordSearchEntryDataModel.HotSearchItem)LebaTitleBar.a(this.a).getTag(), 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzh
 * JD-Core Version:    0.7.0.1
 */