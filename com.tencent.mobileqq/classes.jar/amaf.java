import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Messenger;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;

class amaf
  implements ServiceConnection
{
  amaf(amad paramamad) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    amad.a(this.a, 2);
    amad.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("UploadPhoto", 2, "onServiceConnected()...");
    }
    this.a.jdField_a_of_type_AndroidOsMessenger = new Messenger(paramIBinder);
    this.a.b = new Messenger(this.a.jdField_a_of_type_AndroidOsHandler);
    amad.b(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UploadPhoto", 2, "onServiceDisconnected()...");
    }
    this.a.jdField_a_of_type_AndroidOsMessenger = null;
    amad.a(this.a, 4);
    this.a.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.a.b = null;
    amad.a(this.a, true);
    if (amad.a(this.a) != null) {
      amad.a(this.a).interrupt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amaf
 * JD-Core Version:    0.7.0.1
 */