import com.tencent.image.VideoDrawable;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPlayerEndListener;
import com.tencent.qphone.base.util.QLog;

public class aief
  implements Runnable
{
  public aief(ImageViewVideoPlayer paramImageViewVideoPlayer, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_ComTencentImageVideoDrawable != null)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_ComTencentImageVideoDrawable.resetAndPlayAudioOnce();
      if (QLog.isColorLevel()) {
        QLog.i("ImageViewVideoPlayer", 2, "onPlayRepeat: repeatTimes = " + this.jdField_a_of_type_Int + ", costTime = " + (System.currentTimeMillis() - l));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer$IMPlayerEndListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer$IMPlayerEndListener.aa_();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aief
 * JD-Core Version:    0.7.0.1
 */