import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerView.VideoInfoListener;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView;
import com.tencent.qphone.base.util.QLog;

public class afdf
  extends Handler
{
  public afdf(VideoPlayerView paramVideoPlayerView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerIVideoView != null)
      {
        int i = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerIVideoView.a();
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView$VideoInfoListener.a(i);
        if (QLog.isColorLevel()) {
          QLog.d("VideoPlayerView", 2, "PROGRESS_MSG :" + i);
        }
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2025, 100L);
      return;
      if ((this.a.jdField_a_of_type_AndroidWidgetImageView != null) && (this.a.jdField_a_of_type_AndroidWidgetImageView.getParent() != null) && (((ViewGroup)this.a.jdField_a_of_type_AndroidWidgetImageView.getParent()).getChildAt(0) != this.a.jdField_a_of_type_AndroidWidgetImageView))
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayerView", 2, "UPDATE_COVER  mPlayer.getCurrentPosition()=" + this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerIVideoView.a());
        }
        ((ViewGroup)this.a.jdField_a_of_type_AndroidWidgetImageView.getParent()).removeView(this.a.jdField_a_of_type_AndroidWidgetImageView);
        VideoPlayerView.a(this.a).addView(this.a.jdField_a_of_type_AndroidWidgetImageView, 0, new RelativeLayout.LayoutParams(-1, -1));
        VideoPlayerView.a(this.a).requestLayout();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("VideoPlayerView", 2, "UPDATE_COVER  2do nothing()=");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afdf
 * JD-Core Version:    0.7.0.1
 */