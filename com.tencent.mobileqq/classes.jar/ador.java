import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.lightReply.FacePicDectect.FaceDetectFinishedListener;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager;
import mqq.os.MqqHandler;

public class ador
  implements FacePicDectect.FaceDetectFinishedListener
{
  public ador(LightReplyMenuManager paramLightReplyMenuManager, Context paramContext, boolean paramBoolean, String paramString) {}
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new ados(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ador
 * JD-Core Version:    0.7.0.1
 */