import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class aepv
  extends BroadcastReceiver
{
  aepv(aepg paramaepg) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent.getStringExtra("peerUin");
    paramIntent.getIntExtra("sessionType", -1);
    paramContext = paramIntent.getStringExtra("sessionId");
    if (TextUtils.isEmpty(paramContext)) {}
    while (!paramContext.startsWith("10-")) {
      return;
    }
    this.a.jdField_a_of_type_Atcf.c();
    this.a.l.setEnabled(true);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onBind enter room setSoundDisable");
    }
    this.a.jdField_a_of_type_Atcf.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aepv
 * JD-Core Version:    0.7.0.1
 */