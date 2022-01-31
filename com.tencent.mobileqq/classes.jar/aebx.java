import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.lightReply.FacePicDectect.FaceDetectFinishedListener;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager;
import mqq.os.MqqHandler;

public class aebx
  implements FacePicDectect.FaceDetectFinishedListener
{
  public aebx(LightReplyMenuManager paramLightReplyMenuManager, Context paramContext, boolean paramBoolean, String paramString) {}
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new aeby(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebx
 * JD-Core Version:    0.7.0.1
 */