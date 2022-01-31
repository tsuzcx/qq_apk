import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbFullScreenVideoFragment;

public class aguu
  implements View.OnSystemUiVisibilityChangeListener
{
  public aguu(SpringHbFullScreenVideoFragment paramSpringHbFullScreenVideoFragment, ViewGroup paramViewGroup) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0) {
      this.jdField_a_of_type_AndroidViewViewGroup.setSystemUiVisibility(3846);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aguu
 * JD-Core Version:    0.7.0.1
 */