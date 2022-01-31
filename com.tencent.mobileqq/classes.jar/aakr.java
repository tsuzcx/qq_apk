import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;

class aakr
  implements View.OnSystemUiVisibilityChangeListener
{
  aakr(aakp paramaakp, ViewGroup paramViewGroup) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0) {
      this.jdField_a_of_type_AndroidViewViewGroup.setSystemUiVisibility(7942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aakr
 * JD-Core Version:    0.7.0.1
 */