import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.gdtad.api.GdtAd;

class aamp
  implements View.OnClickListener
{
  aamp(aamo paramaamo) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (this.a.a() != null)
    {
      bool = this.a.a().load(this.a.getActivity());
      if (!bool) {
        break label59;
      }
    }
    label59:
    for (paramView = "loading ad data";; paramView = "load ad data error")
    {
      Toast.makeText(this.a.getActivity().getApplicationContext(), paramView, 0).show();
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamp
 * JD-Core Version:    0.7.0.1
 */