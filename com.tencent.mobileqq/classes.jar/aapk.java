import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment;

public class aapk
  implements View.OnSystemUiVisibilityChangeListener
{
  public aapk(GdtMotiveVideoFragment paramGdtMotiveVideoFragment, View paramView) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0) {
      this.jdField_a_of_type_AndroidViewView.setSystemUiVisibility(7942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapk
 * JD-Core Version:    0.7.0.1
 */