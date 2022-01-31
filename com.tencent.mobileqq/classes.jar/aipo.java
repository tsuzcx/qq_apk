import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class aipo
  extends SubAccountBindObserver
{
  public aipo(SubAccountProtocManager paramSubAccountProtocManager) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("SubAccountProtocManager.onGetBindSubAccount() isSucc=").append(paramBoolean).append(" data.mSubUin=");
      if (paramSubAccountBackProtocData == null)
      {
        ??? = "data is null";
        QLog.d("SUB_ACCOUNT", 2, (String)???);
      }
    }
    else
    {
      if (!SubAccountProtocManager.a(this.a).l) {
        break label73;
      }
    }
    for (;;)
    {
      return;
      ??? = paramSubAccountBackProtocData.c;
      break;
      label73:
      if ((!SubAccountProtocManager.a(this.a)) && (ThreadManager.getSubThreadHandler() != null)) {
        ThreadManager.getSubThreadHandler().postDelayed(SubAccountProtocManager.a(this.a), 100L);
      }
      if (paramSubAccountBackProtocData != null)
      {
        if (paramSubAccountBackProtocData.a()) {
          SubAccountControll.a(SubAccountProtocManager.a(this.a), paramSubAccountBackProtocData.a(), 2);
        }
        if (paramSubAccountBackProtocData.b())
        {
          ??? = paramSubAccountBackProtocData.b();
          if (??? != null)
          {
            ??? = ((ArrayList)???).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (String)((Iterator)???).next();
              SubAccountControll.c(SubAccountProtocManager.a(this.a), (String)localObject2);
            }
          }
        }
        paramSubAccountBackProtocData.a();
      }
      synchronized (SubAccountProtocManager.c())
      {
        SubAccountProtocManager.c(this.a, false);
        SubAccountProtocManager.d(this.a, true);
        if ((paramSubAccountBackProtocData == null) || (!paramSubAccountBackProtocData.b)) {
          continue;
        }
        SubAccountControll.a(SubAccountProtocManager.a(this.a), paramSubAccountBackProtocData.c, false);
        return;
      }
    }
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData arg2)
  {
    synchronized ()
    {
      SubAccountProtocManager.a(this.a, false);
      return;
    }
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData arg2)
  {
    synchronized ()
    {
      SubAccountProtocManager.b(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipo
 * JD-Core Version:    0.7.0.1
 */