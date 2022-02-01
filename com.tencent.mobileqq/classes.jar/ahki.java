import android.app.Dialog;
import android.os.Handler;
import java.util.HashMap;

class ahki
  extends binf
{
  ahki(ahiu paramahiu) {}
  
  protected void f(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((!paramBoolean) || (paramHashMap == null))
    {
      this.a.e(2);
      this.a.a.sendEmptyMessageDelayed(10, 3000L);
      return;
    }
    if (((Integer)paramHashMap.get("result")).intValue() == 0)
    {
      this.a.e(1);
      this.a.a.sendEmptyMessageDelayed(10, 3000L);
      return;
    }
    this.a.w = true;
    this.a.q();
    if ((ahiu.a(this.a) != null) && (ahiu.a(this.a).isShowing())) {
      ahiu.a(this.a).dismiss();
    }
    this.a.r();
  }
  
  protected void g(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((!paramBoolean) || (paramHashMap == null)) {
      return;
    }
    this.a.z = true;
    this.a.y = ((Boolean)paramHashMap.get("result")).booleanValue();
    this.a.q();
    this.a.r();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahki
 * JD-Core Version:    0.7.0.1
 */