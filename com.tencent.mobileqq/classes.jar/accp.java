import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "visibility", "", "onSystemUiVisibilityChange"}, k=3, mv={1, 1, 16})
final class accp
  implements View.OnSystemUiVisibilityChangeListener
{
  accp(ViewGroup paramViewGroup) {}
  
  public final void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0) {
      this.a.setSystemUiVisibility(7942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     accp
 * JD-Core Version:    0.7.0.1
 */