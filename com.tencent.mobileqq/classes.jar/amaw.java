import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class amaw
  extends bmbt
{
  public amaw(ShortVideoPlayActivity paramShortVideoPlayActivity, Activity paramActivity, bmbv parambmbv, int paramInt1, int paramInt2, AppRuntime paramAppRuntime)
  {
    super(paramActivity, parambmbv, paramInt1, paramInt2, paramAppRuntime);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amaw
 * JD-Core Version:    0.7.0.1
 */