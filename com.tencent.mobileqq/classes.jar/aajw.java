import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnInfoListener;
import com.tencent.mobileqq.ar.config.SplashPopupWin;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aajw
  implements IMediaPlayer.OnInfoListener
{
  public aajw(SplashPopupWin paramSplashPopupWin, PopupWindow paramPopupWindow, TextureVideoView paramTextureVideoView) {}
  
  public boolean a_(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.w("WorldCupMgr", 1, "SplashPopupWin.onInfo, what[" + paramInt1 + "], extra[" + paramInt2 + "], popupWindow[" + this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing() + "]");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setBackgroundDrawable(null);
    if (this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin.a != null)
    {
      paramIMediaPlayer = (ImageView)SplashPopupWin.a(this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin).getContentView().findViewById(2131364642);
      paramIMediaPlayer.setImageDrawable((Drawable)this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin.a.a.get(Integer.valueOf(1)));
      paramIMediaPlayer.setVisibility(0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aajw
 * JD-Core Version:    0.7.0.1
 */