import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.view.logic.VideoInfoListenerImpl;

public class aesd
  implements URLDrawable.URLDrawableListener
{
  public aesd(StoryPlayController paramStoryPlayController, VideoInfoListenerImpl paramVideoInfoListenerImpl) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewLogicVideoInfoListenerImpl != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewLogicVideoInfoListenerImpl.a(paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight(), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aesd
 * JD-Core Version:    0.7.0.1
 */