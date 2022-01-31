import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.nearby.now.send.capturepart.StoryLocalPublishPart;

class aevd
  implements Runnable
{
  aevd(aevc paramaevc, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      StoryLocalPublishPart.a(this.jdField_a_of_type_Aevc.jdField_a_of_type_ComTencentMobileqqNearbyNowSendCapturepartStoryLocalPublishPart).setImageDrawable(new BitmapDrawable(this.jdField_a_of_type_Aevc.jdField_a_of_type_AndroidViewView.getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap));
      StoryLocalPublishPart.a(this.jdField_a_of_type_Aevc.jdField_a_of_type_ComTencentMobileqqNearbyNowSendCapturepartStoryLocalPublishPart).setOnClickListener(StoryLocalPublishPart.a(this.jdField_a_of_type_Aevc.jdField_a_of_type_ComTencentMobileqqNearbyNowSendCapturepartStoryLocalPublishPart));
      return;
    }
    SLog.d("story.publish.StoryLocalPublishPart", "queryFirstMediaThumbnail return null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aevd
 * JD-Core Version:    0.7.0.1
 */