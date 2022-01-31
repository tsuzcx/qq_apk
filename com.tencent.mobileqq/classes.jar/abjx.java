import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class abjx
  implements axod
{
  abjx(abjw paramabjw) {}
  
  public void a()
  {
    QLog.i("JumpAction", 1, "system share.doShare show self dialog grant");
    HashMap localHashMap = new HashMap();
    axrl.a(BaseApplication.getContext()).a("", "noSDPermissionShareSelftGrant", true, 0L, 0L, localHashMap, "");
  }
  
  public void b()
  {
    QLog.i("JumpAction", 1, "system share.doShare show self dialog denied");
    HashMap localHashMap = new HashMap();
    axrl.a(BaseApplication.getContext()).a("", "noSDPermissionShareSelftDeny", true, 0L, 0L, localHashMap, "");
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abjx
 * JD-Core Version:    0.7.0.1
 */