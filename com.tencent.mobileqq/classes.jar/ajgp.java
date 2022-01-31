import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.qphone.base.util.QLog;

final class ajgp
  implements ajfx
{
  ajgp(CmShowRenderView paramCmShowRenderView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.i("CmShowTest", 1, "onViewReady w:" + paramInt1);
    this.a.a("1725000451", "1174992642", 1.0F, 0, null);
    ajgn.a(this.a);
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.i("CmShowTest", 1, "onClick apolloId:" + paramString);
  }
  
  public void a(String paramString)
  {
    QLog.i("CmShowTest", 1, "onLongTouch name:" + paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i("CmShowTest", 1, "onActionStart actionId:" + paramInt1);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    QLog.i("CmShowTest", 1, "onActionComplete actionId:" + paramInt1 + " actionSeqId:" + paramInt2 + " playFragment:" + paramInt3);
    if (paramInt2 == 100)
    {
      ajgn.b(this.a);
      return;
    }
    if (paramInt2 == 101)
    {
      if (ajgn.a() < 3)
      {
        ajgn.b();
        ajgn.b(this.a);
        return;
      }
      ajgn.c(this.a);
      return;
    }
    ajgn.a(0);
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajgp
 * JD-Core Version:    0.7.0.1
 */