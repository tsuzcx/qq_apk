import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class ajci
  implements ajon
{
  ajci(ajcf paramajcf) {}
  
  public void a(int paramInt)
  {
    QLog.i("cmgame_process.CmGameLauncher", 1, "[onSoLoadComplete], ret:" + paramInt);
    ajom.b(ajcf.a(this.a));
    Activity localActivity = this.a.a();
    if (paramInt == 0) {
      if ((localActivity != null) && (!ajcf.c(this.a)))
      {
        ajcf.a(this.a, true);
        ajcf.c(this.a);
      }
    }
    while (localActivity == null) {
      return;
    }
    localActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajci
 * JD-Core Version:    0.7.0.1
 */