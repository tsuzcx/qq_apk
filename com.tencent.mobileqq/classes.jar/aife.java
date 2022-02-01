import android.app.Dialog;
import android.os.Handler;
import java.util.HashMap;

class aife
  extends bjha
{
  aife(aidp paramaidp) {}
  
  protected void f(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((!paramBoolean) || (paramHashMap == null))
    {
      this.a.D(2);
      this.a.a.sendEmptyMessageDelayed(10, 3000L);
      return;
    }
    if (((Integer)paramHashMap.get("result")).intValue() == 0)
    {
      this.a.D(1);
      this.a.a.sendEmptyMessageDelayed(10, 3000L);
      return;
    }
    this.a.an = true;
    this.a.bE();
    if ((aidp.a(this.a) != null) && (aidp.a(this.a).isShowing())) {
      aidp.a(this.a).dismiss();
    }
    this.a.bF();
  }
  
  protected void g(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((!paramBoolean) || (paramHashMap == null)) {
      return;
    }
    this.a.aq = true;
    this.a.ap = ((Boolean)paramHashMap.get("result")).booleanValue();
    this.a.bE();
    this.a.bF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aife
 * JD-Core Version:    0.7.0.1
 */