import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.apollo.debug.page.CmGameDebugToolFragment;

public class akth
  implements CompoundButton.OnCheckedChangeListener
{
  public akth(CmGameDebugToolFragment paramCmGameDebugToolFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    CmGameDebugToolFragment.a(this.a).edit().putBoolean("game_storage_switch", paramBoolean).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akth
 * JD-Core Version:    0.7.0.1
 */