import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;

public abstract class ahvo
  implements ahvk
{
  private boolean a(int paramInt, int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void a(ahvv paramahvv, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (bdvn.a())
    {
      paramahvv = paramahvv.a().iterator();
      while (paramahvv.hasNext()) {
        if (!a(((PlusPanelAppInfo)paramahvv.next()).getAppID(), a())) {
          paramahvv.remove();
        }
      }
    }
  }
  
  protected abstract int[] a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahvo
 * JD-Core Version:    0.7.0.1
 */