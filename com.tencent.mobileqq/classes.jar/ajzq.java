import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ajzq
  implements View.OnFocusChangeListener
{
  public ajzq(WordChainHbFragment paramWordChainHbFragment) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_Nmg = new nmg(this.a.jdField_a_of_type_AndroidViewView, new ajzr(this), ImmersiveUtils.getStatusBarHeight(this.a.getActivity()) + 160);
      WordChainHbFragment.a(this.a, 8);
    }
    do
    {
      return;
      WordChainHbFragment.a(this.a, 0);
    } while (this.a.jdField_a_of_type_Nmg == null);
    this.a.jdField_a_of_type_Nmg.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzq
 * JD-Core Version:    0.7.0.1
 */