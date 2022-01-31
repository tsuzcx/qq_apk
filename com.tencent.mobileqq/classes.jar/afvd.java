import android.app.Activity;
import android.os.Bundle;
import mqq.os.MqqHandler;

class afvd
  extends mxj
{
  afvd(afup paramafup) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((afup.a(this.a).isFinishing()) || (this.a.a)) {
      return;
    }
    this.a.c();
    if (afup.a(this.a) != null) {
      afup.a(this.a).removeCallbacks(afup.b(this.a));
    }
    if (paramInt == 16)
    {
      this.a.d();
      return;
    }
    afup.a(this.a, afup.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvd
 * JD-Core Version:    0.7.0.1
 */