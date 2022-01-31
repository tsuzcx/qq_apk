import com.tencent.mobileqq.worldcup.ARWorldCupBackConfirmDialog;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager;
import com.tencent.qphone.base.util.QLog;

public class alfj
  implements Runnable
{
  public alfj(ARWorldCupGameLogicManager paramARWorldCupGameLogicManager) {}
  
  public void run()
  {
    boolean bool = true;
    if ((ARWorldCupGameLogicManager.a(this.a) != null) && (ARWorldCupGameLogicManager.a(this.a).isShowing()))
    {
      QLog.d(ARWorldCupGameLogicManager.a, 2, "TryDismissDialog success");
      ARWorldCupGameLogicManager.a(this.a).dismiss();
      return;
    }
    String str = ARWorldCupGameLogicManager.a;
    if ("TryDismissDialog failed " + ARWorldCupGameLogicManager.a(this.a) != null) {}
    for (;;)
    {
      QLog.d(str, 2, new Object[] { Boolean.valueOf(bool) });
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alfj
 * JD-Core Version:    0.7.0.1
 */