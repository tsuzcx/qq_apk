import android.graphics.Outline;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class abuk
  extends ViewOutlineProvider
{
  public abuk(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), AIOUtils.dp2px(5.0F, paramView.getResources()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abuk
 * JD-Core Version:    0.7.0.1
 */