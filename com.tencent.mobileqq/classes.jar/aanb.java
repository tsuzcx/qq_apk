import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS;

public class aanb
  implements View.OnClickListener
{
  public aanb(GdtInterstitialFragmentForJS paramGdtInterstitialFragmentForJS) {}
  
  public void onClick(View paramView)
  {
    GdtInterstitialFragmentForJS.a(this.a).a = GdtInterstitialFragmentForJS.a(this.a.getActivity());
    if (GdtInterstitialFragmentForJS.a(this.a) == null)
    {
      paramView = "ad is not loaded";
      Toast.makeText(this.a.getActivity().getApplicationContext(), "ad is not loaded", 0).show();
    }
    for (;;)
    {
      Toast.makeText(this.a.getActivity().getApplicationContext(), paramView, 0).show();
      return;
      if (GdtInterstitialFragmentForJS.a(this.a) == null) {
        paramView = "ad is loading";
      } else if (GdtInterstitialFragmentForJS.a(this.a).a() != 0) {
        paramView = GdtInterstitialFragmentForJS.a(this.a).a();
      } else if (GdtInterstitialFragmentForJS.a(this.a).a(this.a.getActivity())) {
        paramView = "正在打开插屏";
      } else {
        paramView = "打开插屏错误";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aanb
 * JD-Core Version:    0.7.0.1
 */