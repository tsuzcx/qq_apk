import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class akyj
  implements alkp
{
  akyj(akyg paramakyg) {}
  
  public void a(int paramInt)
  {
    QLog.i("cmgame_process.CmGameLauncher", 1, "[onSoLoadComplete], ret:" + paramInt);
    alko.b(akyg.a(this.a));
    Activity localActivity = this.a.a();
    if (paramInt == 0) {
      if ((localActivity != null) && (!akyg.c(this.a)))
      {
        akyg.a(this.a, true);
        akyg.c(this.a);
      }
    }
    while (localActivity == null) {
      return;
    }
    localActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyj
 * JD-Core Version:    0.7.0.1
 */