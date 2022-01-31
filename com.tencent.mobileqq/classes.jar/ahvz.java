import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.lang.ref.WeakReference;

public class ahvz
  extends Handler
{
  private WeakReference a;
  
  public ahvz(StructMsgItemVideo paramStructMsgItemVideo)
  {
    this.a = new WeakReference(paramStructMsgItemVideo);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((StructMsgItemVideo)this.a.get() != null) {
      ((AnyScaleTypeImageView)paramMessage.obj).setImageResource(2130842645);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahvz
 * JD-Core Version:    0.7.0.1
 */