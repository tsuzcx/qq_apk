import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS;
import java.lang.ref.WeakReference;

public class aarp
  implements View.OnClickListener
{
  public aarp(GdtInterstitialFragmentForJS paramGdtInterstitialFragmentForJS) {}
  
  public void onClick(View paramView)
  {
    if (GdtInterstitialFragmentForJS.a(this.a) == null)
    {
      paramView = "loading ad data";
      aamv localaamv = new aamv();
      localaamv.a = GdtInterstitialFragmentForJS.a(this.a);
      GdtInterstitialFragmentForJS.a(this.a, new aamt(localaamv, new WeakReference(GdtInterstitialFragmentForJS.a(this.a))));
      GdtInterstitialFragmentForJS.a(this.a).a(new WeakReference(this.a.getActivity()));
    }
    for (;;)
    {
      Toast.makeText(this.a.getActivity().getApplicationContext(), paramView, 0).show();
      return;
      paramView = "load ad data error";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aarp
 * JD-Core Version:    0.7.0.1
 */