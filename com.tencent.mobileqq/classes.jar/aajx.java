import android.widget.PopupWindow;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.config.SplashPopupWin;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class aajx
  implements IMediaPlayer.OnCompletionListener
{
  public aajx(SplashPopupWin paramSplashPopupWin, PopupWindow paramPopupWindow, QQAppInterface paramQQAppInterface, TextureVideoView paramTextureVideoView) {}
  
  public void a(IMediaPlayer paramIMediaPlayer)
  {
    QLog.w("WorldCupMgr", 1, "SplashPopupWin, 播放结束, popupWindow[" + this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing() + "]");
    if ((AudioHelper.d()) && (AudioHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVisibility(4);
    }
    this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aajx
 * JD-Core Version:    0.7.0.1
 */