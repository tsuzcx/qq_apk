import com.tencent.TMG.sdk.AVAudioCtrl.EnableSpeakerCompleteCallback;
import com.tencent.qphone.base.util.QLog;

class ajkx
  extends AVAudioCtrl.EnableSpeakerCompleteCallback
{
  ajkx(ajks paramajks) {}
  
  public void onComplete(boolean paramBoolean, int paramInt)
  {
    QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + paramInt);
    if (this.a.a != null) {
      this.a.a.b(paramBoolean, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajkx
 * JD-Core Version:    0.7.0.1
 */