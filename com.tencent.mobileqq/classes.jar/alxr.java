import android.os.Handler;
import android.os.Message;
import com.tencent.qqprotect.qsec.QSecCbMgr.IControlBitChangeListener;
import com.tencent.qqprotect.qsec.QSecLibMgr;
import java.util.List;

public class alxr
  implements QSecCbMgr.IControlBitChangeListener
{
  public alxr(QSecLibMgr paramQSecLibMgr) {}
  
  public void a(List paramList)
  {
    Message localMessage = QSecLibMgr.a(this.a).obtainMessage(2);
    localMessage.obj = paramList;
    QSecLibMgr.a(this.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alxr
 * JD-Core Version:    0.7.0.1
 */