import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.gdtad.api.GdtAd;

class aarf
  implements View.OnClickListener
{
  aarf(aard paramaard) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a() == null)
    {
      Toast.makeText(this.a.getActivity().getApplicationContext(), "error", 0).show();
      return;
    }
    if (!this.a.a().isLoaded())
    {
      Toast.makeText(this.a.getActivity().getApplicationContext(), "ad is not loaded", 0).show();
      return;
    }
    if (this.a.a().isInvalidated())
    {
      Toast.makeText(this.a.getActivity().getApplicationContext(), "ad is invalidated", 0).show();
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aarf
 * JD-Core Version:    0.7.0.1
 */