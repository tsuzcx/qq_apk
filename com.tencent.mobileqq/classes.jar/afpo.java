import android.annotation.TargetApi;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class afpo
{
  afpq jdField_a_of_type_Afpq;
  Application jdField_a_of_type_AndroidAppApplication;
  WeakReference<AudioPlayerBase> jdField_a_of_type_MqqUtilWeakReference;
  
  public afpo(Application paramApplication)
  {
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
  }
  
  private AudioPlayerBase a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
      return null;
    }
    return (AudioPlayerBase)this.jdField_a_of_type_MqqUtilWeakReference.get();
  }
  
  @TargetApi(14)
  public int a(String paramString, int paramInt)
  {
    int i = 0;
    if (AudioPlayerBase.b != -1) {
      i = 1;
    }
    BluetoothAdapter localBluetoothAdapter;
    AudioPlayerBase localAudioPlayerBase;
    do
    {
      return i;
      localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      localAudioPlayerBase = a();
    } while (localAudioPlayerBase == null);
    if (localBluetoothAdapter == null)
    {
      AudioPlayerBase.b = 0;
      return 1;
    }
    if ((!localBluetoothAdapter.isEnabled()) || (localBluetoothAdapter.getProfileConnectionState(1) != 2) || (localBluetoothAdapter.getProfileConnectionState(2) == 2))
    {
      AudioPlayerBase.b = 0;
      return 1;
    }
    paramString = new afpp(this, localAudioPlayerBase, paramString, paramInt, localBluetoothAdapter);
    localBluetoothAdapter.getProfileProxy(BaseApplication.getContext(), paramString, 1);
    return 2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Afpq != null) {
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer_SCOHelper", 2, "unregister sco receiver:  " + SystemClock.uptimeMillis());
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_Afpq);
      label51:
      this.jdField_a_of_type_Afpq = null;
      return;
    }
    catch (Exception localException)
    {
      break label51;
    }
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase)
  {
    if ((paramAudioPlayerBase == null) && (QLog.isColorLevel())) {
      QLog.d("AudioPlayer_SCOHelper", 2, "setAudioPlayer audioPlayer is null");
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAudioPlayerBase);
  }
  
  public int b(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppApplication == null) {}
    do
    {
      return 0;
      paramString = new afpq(this, paramString, paramInt, null);
      this.jdField_a_of_type_Afpq = paramString;
      this.jdField_a_of_type_AndroidAppApplication.registerReceiver(paramString, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
      paramString = a();
    } while ((paramString == null) || (paramString.a() == null));
    paramString.a().startBluetoothSco();
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer_SCOHelper", 2, "tryStartBluetoothSCO return: Check_SCO_Result_Check_Access_Need_Return");
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpo
 * JD-Core Version:    0.7.0.1
 */