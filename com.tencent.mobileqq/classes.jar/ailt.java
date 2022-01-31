import android.media.MediaPlayer;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.qphone.base.util.QLog;

public class ailt
  implements Runnable
{
  public ailt(VideoSprite paramVideoSprite, String paramString, int paramInt) {}
  
  public void run()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.b == null) || (!this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.b.equals(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.g)) && (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.jdField_a_of_type_AndroidMediaMediaPlayer != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.i = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoWidth();
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.j = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoHeight();
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.jdField_a_of_type_AndroidMediaMediaPlayer.setOnSeekCompleteListener(new ailu(this));
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.b = this.jdField_a_of_type_JavaLangString;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoSprite", 2, "playVideo Exception: " + QLog.getStackTraceString(localException));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailt
 * JD-Core Version:    0.7.0.1
 */