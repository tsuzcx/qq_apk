import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class ahvl
  implements ahvk
{
  private int a(List<PlusPanelAppInfo> paramList)
  {
    if (paramList.size() > 0)
    {
      int i = 0;
      int j = paramList.size();
      while (i < j)
      {
        if (209 == ((PlusPanelAppInfo)paramList.get(i)).getAppID()) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public void a(ahvv paramahvv, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (((paramahvv instanceof ahwd)) && (!((ahwd)paramahvv).a()))
    {
      paramahvv.b(1000000006);
      if (!bdfk.a()) {
        paramahvv.b(219);
      }
      paramQQAppInterface = paramahvv.a();
      paramInt = a(paramQQAppInterface);
      if (paramInt >= 0)
      {
        paramString = (PlusPanelAppInfo)paramQQAppInterface.get(paramInt);
        paramahvv.b(209);
        if (paramQQAppInterface.size() >= 10) {
          break label91;
        }
        paramQQAppInterface.add(paramString);
      }
    }
    return;
    label91:
    paramQQAppInterface.add(10, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahvl
 * JD-Core Version:    0.7.0.1
 */