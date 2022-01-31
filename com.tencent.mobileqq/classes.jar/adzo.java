import android.graphics.drawable.Drawable;
import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.hotpic.HotPicPageView.MyVideoViewHolder;
import com.tencent.mobileqq.hotpic.HotVideoBlurTaskManager;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.hotpic.HotVideoPreviewDownloader;

public class adzo
  implements Runnable
{
  public adzo(HotVideoBlurTaskManager paramHotVideoBlurTaskManager) {}
  
  public void run()
  {
    HotVideoData localHotVideoData = (HotVideoData)this.a.jdField_a_of_type_AndroidSupportV4UtilArrayMap.keyAt(0);
    HotPicPageView.MyVideoViewHolder localMyVideoViewHolder = (HotPicPageView.MyVideoViewHolder)this.a.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(localHotVideoData);
    if (localMyVideoViewHolder.a(localHotVideoData))
    {
      Drawable localDrawable = HotVideoPreviewDownloader.a(this.a.jdField_a_of_type_AndroidContentContext, localHotVideoData);
      if ((localDrawable != null) && (localMyVideoViewHolder.a(localHotVideoData))) {
        localMyVideoViewHolder.b(localDrawable);
      }
      this.a.a(localHotVideoData);
    }
    for (;;)
    {
      this.a.a();
      return;
      this.a.a(localHotVideoData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzo
 * JD-Core Version:    0.7.0.1
 */