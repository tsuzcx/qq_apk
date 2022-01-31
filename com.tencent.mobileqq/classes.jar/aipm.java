import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class aipm
  implements ajan
{
  aipm(aipj paramaipj) {}
  
  public void a(int paramInt)
  {
    QLog.i("cmgame_process.CmGameLauncher", 1, "[onSoLoadComplete], ret:" + paramInt);
    ajam.b(aipj.a(this.a));
    Activity localActivity = this.a.a();
    if (paramInt == 0) {
      if ((localActivity != null) && (!aipj.c(this.a)))
      {
        aipj.a(this.a, true);
        aipj.c(this.a);
      }
    }
    while (localActivity == null) {
      return;
    }
    localActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aipm
 * JD-Core Version:    0.7.0.1
 */