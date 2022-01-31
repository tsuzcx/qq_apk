import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class aktu
  implements alga
{
  aktu(aktr paramaktr) {}
  
  public void a(int paramInt)
  {
    QLog.i("cmgame_process.CmGameLauncher", 1, "[onSoLoadComplete], ret:" + paramInt);
    alfz.b(aktr.a(this.a));
    Activity localActivity = this.a.a();
    if (paramInt == 0) {
      if ((localActivity != null) && (!aktr.c(this.a)))
      {
        aktr.a(this.a, true);
        aktr.c(this.a);
      }
    }
    while (localActivity == null) {
      return;
    }
    localActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aktu
 * JD-Core Version:    0.7.0.1
 */