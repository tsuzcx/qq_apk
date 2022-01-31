import com.tencent.TMG.sdk.AVAudioCtrl.EnableMicCompleteCallback;
import com.tencent.qphone.base.util.QLog;

class ajkw
  extends AVAudioCtrl.EnableMicCompleteCallback
{
  ajkw(ajks paramajks) {}
  
  public void onComplete(boolean paramBoolean, int paramInt)
  {
    QLog.d("AVEngineWalper", 1, "StartOpenMic.OnComplete. bOpen = " + paramBoolean + ", result = " + paramInt);
    if (this.a.a != null) {
      this.a.a.a(paramBoolean, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajkw
 * JD-Core Version:    0.7.0.1
 */