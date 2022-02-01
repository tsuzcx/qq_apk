import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;
import com.tencent.gdtad.views.videoimax.GdtImaxData;
import com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment;
import com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment.1.1;

public class ackr
  implements ackg
{
  public ackr(GdtVideoImaxFragment paramGdtVideoImaxFragment) {}
  
  public void a(View paramView)
  {
    GdtVideoImaxFragment.a(this.a).a().b(2);
    if (GdtVideoImaxFragment.a(this.a).getVideoSplicePageStyle() == 1)
    {
      bool = this.a.a(paramView);
      GdtVideoImaxFragment.a(this.a, bool);
      GdtVideoImaxFragment.a(this.a);
    }
    while (GdtVideoImaxFragment.a(this.a).getVideoSplicePageStyle() != 0)
    {
      boolean bool;
      return;
    }
    GdtVideoImaxFragment.a(this.a).g();
    paramView = aciv.a(this.a.getActivity());
    GdtVideoImaxFragment.a(this.a, paramView[1], GdtVideoImaxFragment.a(this.a).getLayoutParams().height, paramView[1]);
  }
  
  public void a(GdtVideoCommonView paramGdtVideoCommonView)
  {
    acho.a("GdtVideoImaxFragment", "onPrepared() called with: v = [" + paramGdtVideoCommonView + "]");
  }
  
  public void b(GdtVideoCommonView paramGdtVideoCommonView)
  {
    acho.a("GdtVideoImaxFragment", "onStart() called with: ");
    if (GdtVideoImaxFragment.a(this.a))
    {
      GdtVideoImaxFragment.a(this.a).removeCallbacks(GdtVideoImaxFragment.a(this.a));
      GdtVideoImaxFragment.a(this.a).postDelayed(new GdtVideoImaxFragment.1.1(this), 75L);
      GdtVideoImaxFragment.a(this.a, false);
    }
  }
  
  public void c(GdtVideoCommonView paramGdtVideoCommonView)
  {
    acho.a("GdtVideoImaxFragment", "onStop() called with: v = [" + paramGdtVideoCommonView + "]");
  }
  
  public void d(GdtVideoCommonView paramGdtVideoCommonView)
  {
    acho.a("GdtVideoImaxFragment", "onComplete() called with: v = [" + paramGdtVideoCommonView + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackr
 * JD-Core Version:    0.7.0.1
 */