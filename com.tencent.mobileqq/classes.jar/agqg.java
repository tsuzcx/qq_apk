import android.app.Dialog;
import android.os.Handler;
import java.util.HashMap;

class agqg
  extends bfvh
{
  agqg(agot paramagot) {}
  
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
    this.a.bH();
    if ((agot.a(this.a) != null) && (agot.a(this.a).isShowing())) {
      agot.a(this.a).dismiss();
    }
    this.a.bI();
  }
  
  protected void g(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((!paramBoolean) || (paramHashMap == null)) {
      return;
    }
    this.a.ar = true;
    this.a.aq = ((Boolean)paramHashMap.get("result")).booleanValue();
    this.a.bH();
    this.a.bI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqg
 * JD-Core Version:    0.7.0.1
 */