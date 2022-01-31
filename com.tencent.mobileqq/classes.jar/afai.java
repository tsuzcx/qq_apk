import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.mobileqq.nearby.now.view.CustomViewPager;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;

public class afai
  implements Runnable
{
  public afai(SmallVideoFragment paramSmallVideoFragment) {}
  
  public void run()
  {
    VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = (VideoPlayerPagerAdapter)this.a.a.getAdapter();
    if ((localVideoPlayerPagerAdapter.a(this.a.a.getCurrentItem()) instanceof ShortVideoCommentsView)) {
      ((ShortVideoCommentsView)localVideoPlayerPagerAdapter.a(this.a.a.getCurrentItem())).m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afai
 * JD-Core Version:    0.7.0.1
 */