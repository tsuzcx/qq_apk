import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.UpdateTroop;
import com.tencent.qphone.base.util.QLog;

public class akms
  extends akil
{
  private akms(UpdateTroop paramUpdateTroop) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "updateTroopList:" + paramBoolean);
    }
    if (!paramBoolean)
    {
      this.a.a(6);
      return;
    }
    this.a.a.a.edit().putBoolean("isTrooplistok", true).commit();
    this.a.a.notifyUI(3, true, Integer.valueOf(2));
    this.a.a(7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akms
 * JD-Core Version:    0.7.0.1
 */