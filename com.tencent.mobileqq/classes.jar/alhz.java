import com.tencent.mqp.app.sec.d;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.qqprotect.qsec.QSecLibMgr;
import com.tencent.qqprotect.qsec.QSecLibMgr.LibEventListener;

public class alhz
  implements QSecLibMgr.LibEventListener
{
  public alhz(QSecFramework paramQSecFramework) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (paramInt2 == 1))
    {
      d.e(1, d.x(), null);
      QSecFramework.a(this.a).b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alhz
 * JD-Core Version:    0.7.0.1
 */