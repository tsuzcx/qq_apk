import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class ajck
  implements ajop
{
  ajck(ajch paramajch) {}
  
  public void a(int paramInt)
  {
    QLog.i("cmgame_process.CmGameLauncher", 1, "[onSoLoadComplete], ret:" + paramInt);
    ajoo.b(ajch.a(this.a));
    Activity localActivity = this.a.a();
    if (paramInt == 0) {
      if ((localActivity != null) && (!ajch.c(this.a)))
      {
        ajch.a(this.a, true);
        ajch.c(this.a);
      }
    }
    while (localActivity == null) {
      return;
    }
    localActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajck
 * JD-Core Version:    0.7.0.1
 */