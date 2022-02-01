import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alse
  implements View.OnClickListener
{
  public alse(QzoneSlideShowPreparingFragment paramQzoneSlideShowPreparingFragment) {}
  
  public void onClick(View paramView)
  {
    QzoneSlideShowPreparingFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alse
 * JD-Core Version:    0.7.0.1
 */