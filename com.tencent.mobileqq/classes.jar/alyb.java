import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class alyb
  implements amkm
{
  alyb(alxy paramalxy) {}
  
  public void a(int paramInt)
  {
    QLog.i("cmgame_process.CmGameLauncher", 1, "[onSoLoadComplete], ret:" + paramInt);
    amkk.b(alxy.a(this.a));
    Activity localActivity = this.a.a();
    if (paramInt == 0) {
      if ((localActivity != null) && (!alxy.c(this.a)))
      {
        alxy.a(this.a, true);
        alxy.c(this.a);
      }
    }
    while (localActivity == null) {
      return;
    }
    localActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alyb
 * JD-Core Version:    0.7.0.1
 */