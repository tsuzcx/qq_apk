import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.troop.fragment.TroopMoreDetailFragment;
import com.tencent.mobileqq.troop.widget.ExpandableTextView.OnExpandStateListener;

public class airs
  implements ExpandableTextView.OnExpandStateListener
{
  public airs(TroopMoreDetailFragment paramTroopMoreDetailFragment) {}
  
  public void a(TextView paramTextView, View paramView, boolean paramBoolean)
  {
    paramView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     airs
 * JD-Core Version:    0.7.0.1
 */