import android.app.Dialog;
import android.os.Handler;
import java.util.HashMap;

class aeth
  extends bduv
{
  aeth(aerv paramaerv) {}
  
  protected void f(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((!paramBoolean) || (paramHashMap == null))
    {
      this.a.E(2);
      this.a.a.sendEmptyMessageDelayed(10, 3000L);
      return;
    }
    if (((Integer)paramHashMap.get("result")).intValue() == 0)
    {
      this.a.E(1);
      this.a.a.sendEmptyMessageDelayed(10, 3000L);
      return;
    }
    this.a.ao = true;
    this.a.bE();
    if ((aerv.a(this.a) != null) && (aerv.a(this.a).isShowing())) {
      aerv.a(this.a).dismiss();
    }
    this.a.bF();
  }
  
  protected void g(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((!paramBoolean) || (paramHashMap == null)) {
      return;
    }
    this.a.ar = true;
    this.a.aq = ((Boolean)paramHashMap.get("result")).booleanValue();
    this.a.bE();
    this.a.bF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeth
 * JD-Core Version:    0.7.0.1
 */