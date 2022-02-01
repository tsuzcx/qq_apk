import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gdtad.views.halfScreen.GdtBaseHalfScreenFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class actf
  implements View.OnClickListener
{
  public actf(GdtBaseHalfScreenFragment paramGdtBaseHalfScreenFragment) {}
  
  public void onClick(View paramView)
  {
    if ((GdtBaseHalfScreenFragment.a(this.a) != null) && (GdtBaseHalfScreenFragment.a(this.a).canGoBack())) {
      GdtBaseHalfScreenFragment.a(this.a).goBack();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.getActivity() != null) {
        this.a.getActivity().finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actf
 * JD-Core Version:    0.7.0.1
 */