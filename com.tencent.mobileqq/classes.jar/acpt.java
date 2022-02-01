import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.gdtad.api.banner.rectangle.GdtBannerViewWithRectangleStyle;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acpt
  implements View.OnClickListener
{
  public acpt(GdtBannerViewWithRectangleStyle paramGdtBannerViewWithRectangleStyle) {}
  
  public void onClick(View paramView)
  {
    int i = 8;
    if (!GdtBannerViewWithRectangleStyle.a(this.a)) {
      acvc.d("GdtBannerContainerView", "optionsContainerOnClickListener.OnClickListener error");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (GdtBannerViewWithRectangleStyle.a(this.a).getVisibility() == 8) {
        i = 0;
      }
      GdtBannerViewWithRectangleStyle.a(this.a).setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpt
 * JD-Core Version:    0.7.0.1
 */