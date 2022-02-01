import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.views.halfScreen.GdtBaseHalfScreenFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acte
  implements View.OnClickListener
{
  public acte(GdtBaseHalfScreenFragment paramGdtBaseHalfScreenFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.getActivity() != null) {
      this.a.getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acte
 * JD-Core Version:    0.7.0.1
 */