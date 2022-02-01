import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class aauf
  extends Handler
{
  aauf(aaud paramaaud) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "MSG_SHOW_WINDOW mTroopNotify = " + this.a.jdField_a_of_type_Bfrq + ", mTroopNotifyAd = " + this.a.jdField_a_of_type_Bfrr);
    }
    if (this.a.jdField_a_of_type_Bfrr != null) {
      this.a.a(this.a.jdField_a_of_type_Bfrr);
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aauf
 * JD-Core Version:    0.7.0.1
 */