import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class aeew
  extends BroadcastReceiver
{
  aeew(aeeh paramaeeh) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent.getStringExtra("peerUin");
    paramIntent.getIntExtra("sessionType", -1);
    paramContext = paramIntent.getStringExtra("sessionId");
    if (TextUtils.isEmpty(paramContext)) {}
    while (!paramContext.startsWith("10-")) {
      return;
    }
    this.a.jdField_a_of_type_Asgb.c();
    this.a.l.setEnabled(true);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onBind enter room setSoundDisable");
    }
    this.a.jdField_a_of_type_Asgb.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeew
 * JD-Core Version:    0.7.0.1
 */