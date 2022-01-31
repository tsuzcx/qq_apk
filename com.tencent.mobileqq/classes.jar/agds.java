import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

class agds
  extends mmn
{
  agds(agdp paramagdp) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((agdp.a(this.a).isFinishing()) || (this.a.a)) {
      return;
    }
    this.a.d();
    if (agdp.a(this.a) != null) {
      agdp.a(this.a).removeCallbacks(agdp.b(this.a));
    }
    if (paramInt == 16)
    {
      this.a.e();
      return;
    }
    agdp.a(this.a, agdp.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agds
 * JD-Core Version:    0.7.0.1
 */