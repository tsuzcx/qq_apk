import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class alwl
  implements AudioManager.OnAudioFocusChangeListener
{
  alwl(alwf paramalwf) {}
  
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
        alxy localalxy = alvx.a(alwf.a(this.a));
        if ((localalxy == null) || (localalxy.a() == null)) {
          break label104;
        }
        alvx.a().callbackFromRequest(localalxy.a().getLuaState(), 0, "sc.audio_event.local", localJSONObject.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alwl
 * JD-Core Version:    0.7.0.1
 */