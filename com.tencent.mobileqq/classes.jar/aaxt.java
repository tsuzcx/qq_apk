import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkActionAppMgr;
import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;
import java.util.ArrayList;

public class aaxt
  extends ArkAppCGI.ArkAppCGICallback
{
  public aaxt(ArkActionAppMgr paramArkActionAppMgr) {}
  
  public void a(boolean paramBoolean, Object paramObject, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    ThreadManager.post(new aaxu(this, paramObject, paramBoolean, paramArrayList1, paramArrayList2), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaxt
 * JD-Core Version:    0.7.0.1
 */