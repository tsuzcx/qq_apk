import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ajas
  implements AudioManager.OnAudioFocusChangeListener
{
  ajas(ajam paramajam) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameAudioPlayer", 2, new Object[] { "[onAudioFocusChange],focusChange:", Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        if (paramInt != 1) {
          break label105;
        }
        localJSONObject.put("event", 2);
        ajcf localajcf = ajac.a(ajam.a(this.a));
        if ((localajcf == null) || (localajcf.a() == null)) {
          break label104;
        }
        ajac.a().callbackFromRequest(localajcf.a().getLuaState(), 0, "sc.audio_event.local", localJSONObject.toString());
        return;
      }
      catch (Throwable localThrowable) {}
      localJSONObject.put("event", 1);
      continue;
      label104:
      return;
      label105:
      if (paramInt != -1) {
        if (paramInt != -2) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajas
 * JD-Core Version:    0.7.0.1
 */