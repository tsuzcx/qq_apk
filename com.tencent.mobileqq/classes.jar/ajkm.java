import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.VideoView;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoMusicMixRunnable;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class ajkm
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final aelc jdField_a_of_type_Aelc = new ajkn(this);
  private final ajot jdField_a_of_type_Ajot = new ajko(this);
  private Activity jdField_a_of_type_AndroidAppActivity;
  private DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener;
  private DialogInterface.OnShowListener jdField_a_of_type_AndroidContentDialogInterface$OnShowListener;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private bepp jdField_a_of_type_Bepp;
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  private FixedSizeVideoView jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView;
  private QzoneVerticalVideoTopicInfo jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Dialog> jdField_a_of_type_JavaLangRefWeakReference;
  private xgc jdField_a_of_type_Xgc;
  private boolean jdField_a_of_type_Boolean;
  private long b;
  private long c;
  
  private ajkm(Activity paramActivity, FixedSizeVideoView paramFixedSizeVideoView, ImageButton paramImageButton, QzoneVerticalVideoTopicInfo paramQzoneVerticalVideoTopicInfo)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView = paramFixedSizeVideoView;
    this.jdField_a_of_type_AndroidWidgetImageButton = paramImageButton;
    this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = paramQzoneVerticalVideoTopicInfo;
    this.jdField_a_of_type_Xgc = a();
  }
  
  private long a()
  {
    return this.b - this.jdField_a_of_type_Long;
  }
  
  public static ajkm a(Activity paramActivity, FixedSizeVideoView paramFixedSizeVideoView, QzoneVerticalVideoTopicInfo paramQzoneVerticalVideoTopicInfo, ImageButton paramImageButton)
  {
    return new ajkm(paramActivity, paramFixedSizeVideoView, paramImageButton, paramQzoneVerticalVideoTopicInfo);
  }
  
  private xgc a()
  {
    if ((this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo != null) && (this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.a()))
    {
      xgc localxgc = new xgc();
      localxgc.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.c();
      localxgc.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.d();
      localxgc.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.b();
      localxgc.jdField_b_of_type_Int = 3;
      return localxgc;
    }
    return null;
  }
  
  private void b(boolean paramBoolean)
  {
    float f2 = 0.0F;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView != null) {}
    for (;;)
    {
      try
      {
        Object localObject = VideoView.class.getDeclaredField("mMediaPlayer");
        ((Field)localObject).setAccessible(true);
        localObject = (MediaPlayer)((Field)localObject).get(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView);
        if (localObject != null)
        {
          if (paramBoolean)
          {
            f1 = 0.0F;
            break label100;
            ((MediaPlayer)localObject).setVolume(f1, f2);
          }
        }
        else {
          return;
        }
        float f1 = 1.0F;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        QZLog.e("EditLocalVideoMusicMixe", 2, localNoSuchFieldException, new Object[0]);
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        QZLog.e("EditLocalVideoMusicMixe", 2, localIllegalAccessException, new Object[0]);
        return;
      }
      f2 = 1.0F;
      continue;
      label100:
      if (!paramBoolean) {}
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) {
      if (!paramBoolean) {
        break label49;
      }
    }
    label49:
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b();; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      if (this.jdField_a_of_type_Xgc == null) {
        b(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
      return;
    }
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_Xgc != null) && (a() - this.jdField_a_of_type_Xgc.f > 0L);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aelc);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(3);
    }
    AudioPlayer localAudioPlayer;
    String str;
    if (this.jdField_a_of_type_Xgc != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_Xgc.g)) {
        break label119;
      }
      localAudioPlayer = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
      str = this.jdField_a_of_type_Xgc.g;
      if (this.jdField_a_of_type_Int == 0) {
        break label108;
      }
    }
    label108:
    for (int i = this.jdField_a_of_type_Int;; i = this.jdField_a_of_type_Xgc.jdField_d_of_type_Int)
    {
      localAudioPlayer.a(str, i);
      this.jdField_a_of_type_AndroidAppActivity.sendBroadcast(new Intent("action_music_start"));
      b(true);
      return;
    }
    label119:
    QZLog.e("EditLocalVideoMusicMixe", 2, new Object[] { "startAudioPlayback: music not downloaded " + this.jdField_a_of_type_Xgc.jdField_d_of_type_JavaLangString });
  }
  
  public void a()
  {
    P2VEditMusicDialog localP2VEditMusicDialog = new P2VEditMusicDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Ajot, (int)a(), true);
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener != null) {
      localP2VEditMusicDialog.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    }
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnShowListener != null) {
      localP2VEditMusicDialog.setOnShowListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnShowListener);
    }
    localP2VEditMusicDialog.setCanceledOnTouchOutside(false);
    localP2VEditMusicDialog.show();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localP2VEditMusicDialog);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 - paramInt1 > 0)
    {
      this.jdField_a_of_type_Long = paramInt1;
      this.b = paramInt2;
      Log.d("EditLocalVideoMusicMixe", "updateVideoFrameClippedRange: " + paramInt1 + " " + paramInt2);
      return;
    }
    Log.w("EditLocalVideoMusicMixe", "updateVideoFrameClippedRange: duration less or equal than zero " + paramInt2 + " " + paramInt1);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Xgc != null) {
      new P2VEditMusicDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Ajot, (int)paramLong, true);
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    a(0, (int)paramLong);
    this.c = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(ajkq paramajkq)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new EditLocalVideoMusicMixRunnable(this.jdField_a_of_type_Long, this.b, this.c, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xgc, new ajkp(this, paramajkq)));
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = paramOnDismissListener;
  }
  
  public void a(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnShowListener = paramOnShowListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((Dialog)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isShowing());
  }
  
  public void b()
  {
    c(false);
    f();
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Xgc != null) && ((this.jdField_a_of_type_Xgc.jdField_b_of_type_Int == 0) || (this.jdField_a_of_type_Xgc.jdField_b_of_type_Int == 3) || (this.jdField_a_of_type_Xgc.jdField_b_of_type_Int == 2)) && (!this.jdField_a_of_type_Boolean);
  }
  
  public void c()
  {
    c(false);
  }
  
  public void d()
  {
    c(true);
  }
  
  public void e()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkm
 * JD-Core Version:    0.7.0.1
 */