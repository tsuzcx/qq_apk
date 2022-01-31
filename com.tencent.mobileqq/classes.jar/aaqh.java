import android.widget.PopupWindow;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.config.SplashPopupWin;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aaqh
  implements IMediaPlayer.OnPreparedListener
{
  public aaqh(SplashPopupWin paramSplashPopupWin, PopupWindow paramPopupWindow, TextureVideoView paramTextureVideoView) {}
  
  public void a_(IMediaPlayer paramIMediaPlayer)
  {
    QLog.w("WorldCupMgr", 1, "SplashPopupWin, 视频加载完毕, popupWindow[" + this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing() + "], getDuration[" + paramIMediaPlayer.a() + "]");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.start();
    if (SplashPopupWin.a(this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin) == null) {
      SplashPopupWin.a(this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin, new aaqi(this));
    }
    ThreadManager.getUIHandler().removeCallbacks(SplashPopupWin.a(this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin));
    ThreadManager.getUIHandler().postDelayed(SplashPopupWin.a(this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin), paramIMediaPlayer.a() - 3000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqh
 * JD-Core Version:    0.7.0.1
 */