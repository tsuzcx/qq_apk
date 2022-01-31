import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkActionAppMgr;
import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class aaxr
  extends ArkAppCGI.ArkAppCGICallback
{
  public aaxr(ArkActionAppMgr paramArkActionAppMgr, WeakReference paramWeakReference, QQAppInterface paramQQAppInterface) {}
  
  public void a(boolean paramBoolean, Object paramObject, ArrayList paramArrayList)
  {
    ThreadManager.post(new aaxs(this, paramArrayList), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaxr
 * JD-Core Version:    0.7.0.1
 */