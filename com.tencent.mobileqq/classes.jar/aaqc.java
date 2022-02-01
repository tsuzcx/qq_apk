import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class aaqc
  extends Handler
{
  aaqc(aaqa paramaaqa) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "MSG_SHOW_WINDOW mTroopNotify = " + this.a.jdField_a_of_type_Besj + ", mTroopNotifyAd = " + this.a.jdField_a_of_type_Besk);
    }
    if (this.a.jdField_a_of_type_Besk != null) {
      this.a.a(this.a.jdField_a_of_type_Besk);
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqc
 * JD-Core Version:    0.7.0.1
 */