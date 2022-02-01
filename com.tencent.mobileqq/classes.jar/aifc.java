import android.app.Dialog;
import android.os.Handler;
import java.util.HashMap;

class aifc
  extends bjyh
{
  aifc(aido paramaido) {}
  
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
    if ((aido.a(this.a) != null) && (aido.a(this.a).isShowing())) {
      aido.a(this.a).dismiss();
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
 * Qualified Name:     aifc
 * JD-Core Version:    0.7.0.1
 */