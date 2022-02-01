import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.device.qfind.BluetoothLeService;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class abfy
  implements ServiceConnection
{
  abfy(abfw paramabfw) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    abfw.a(this.a, ((abmf)paramIBinder).a());
    if ((!abfw.a(this.a).a()) && (QLog.isColorLevel())) {
      QLog.e("DeviceBLE2", 2, "Unable to initialize Bluetooth");
    }
    if (QLog.isColorLevel()) {
      QLog.i("DeviceBLE2", 2, "ServiceConnection onServiceConnected ");
    }
    if (!abfw.a(this.a).isEmpty())
    {
      this.a.a = ((abmk)abfw.a(this.a).get(0));
      abfw.a(this.a).remove(0);
      abfw.a(this.a).a(this.a.a.a, this.a.a.b);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    abfw.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abfy
 * JD-Core Version:    0.7.0.1
 */