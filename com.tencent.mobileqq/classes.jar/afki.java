import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;

public class afki
  implements ViewPager.OnPageChangeListener
{
  public afki(TroopChatPie paramTroopChatPie) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.a.reportGiftPanelRedDot(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afki
 * JD-Core Version:    0.7.0.1
 */