import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.armap.config.BaseCheckHandler.ItemConfig;
import com.tencent.mobileqq.armap.config.POICheckHander;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.List;

public class abfn
  implements Handler.Callback
{
  public abfn(POICheckHander paramPOICheckHander) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    String str;
    long l;
    switch (paramMessage.what)
    {
    default: 
    case 0: 
      do
      {
        do
        {
          return true;
        } while (!(paramMessage.obj instanceof Object[]));
        paramMessage = (Object[])paramMessage.obj;
      } while (paramMessage.length < 2);
      str = (String)paramMessage[0];
      l = ((Long)paramMessage[1]).longValue();
      paramMessage = str.split("\\?md5=");
      if (paramMessage.length > 1)
      {
        localObject1 = paramMessage[0];
        paramMessage = paramMessage[1];
      }
      break;
    }
    for (;;)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(paramMessage)))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.a.d, 2, "checkPoiModel url or md5 is empty or ");
        return true;
      }
      if (this.a.b.contains(str))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.a.d, 2, "checkPoiModel mCheckingUrl has contains ");
        return true;
      }
      paramMessage = new BaseCheckHandler.ItemConfig(1, 7, paramMessage, (String)localObject1, Long.valueOf(l));
      this.a.b(paramMessage);
      this.a.b.add(str);
      return true;
      if (!(paramMessage.obj instanceof Object[])) {
        break;
      }
      paramMessage = (Object[])paramMessage.obj;
      if (paramMessage.length < 3) {
        break;
      }
      str = (String)paramMessage[0];
      l = ((Long)paramMessage[1]).longValue();
      paramMessage = str.split("\\?md5=");
      if (paramMessage.length > 1) {
        localObject1 = paramMessage[0];
      }
      for (paramMessage = paramMessage[1];; paramMessage = localObject2)
      {
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(paramMessage)))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(this.a.d, 2, "checkLogoRes url or md5 is empty or ");
          return true;
        }
        if (this.a.b.contains(str))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(this.a.d, 2, "checkLogoRes mCheckingUrl has contains ");
          return true;
        }
        paramMessage = new BaseCheckHandler.ItemConfig(1, 8, paramMessage, (String)localObject1, new Pair(str, Long.valueOf(l)));
        this.a.b(paramMessage);
        this.a.b.add(str);
        return true;
        if (!(paramMessage.obj instanceof BaseCheckHandler.ItemConfig)) {
          break;
        }
        localObject1 = (BaseCheckHandler.ItemConfig)paramMessage.obj;
        int i = paramMessage.arg1;
        POICheckHander.a(this.a, (BaseCheckHandler.ItemConfig)localObject1, i);
        return true;
        localObject1 = null;
      }
      localObject2 = null;
      paramMessage = (Message)localObject1;
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abfn
 * JD-Core Version:    0.7.0.1
 */