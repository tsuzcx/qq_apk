import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class ahgr
  extends BroadcastReceiver
{
  ahgr(ahgc paramahgc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent.getStringExtra("peerUin");
    paramIntent.getIntExtra("sessionType", -1);
    paramContext = paramIntent.getStringExtra("sessionId");
    if (TextUtils.isEmpty(paramContext)) {}
    while (!paramContext.startsWith("10-")) {
      return;
    }
    this.a.jdField_a_of_type_Awkz.c();
    this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, "onBind enter room setSoundDisable");
    }
    this.a.jdField_a_of_type_Awkz.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgr
 * JD-Core Version:    0.7.0.1
 */