import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.mobileqq.widget.QQToast;

public class absc
  implements Handler.Callback
{
  public absc(EmoticonFromGroupManager paramEmoticonFromGroupManager) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
      QQToast.a(EmoticonFromGroupManager.a(this.a), 2131428195, 0).b(2131558448);
      return true;
    }
    if (paramMessage.obj != null)
    {
      paramMessage = (EmoticonFromGroupEntity)paramMessage.obj;
      this.a.a(paramMessage);
      return true;
    }
    QQToast.a(EmoticonFromGroupManager.a(this.a), 1, 2131434484, 0).b(2131558448);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     absc
 * JD-Core Version:    0.7.0.1
 */