import android.app.Activity;
import android.content.Intent;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

class acdw
  implements acfj
{
  acdw(acdv paramacdv) {}
  
  public Activity a()
  {
    return acdv.a(this.a);
  }
  
  public void a()
  {
    this.a.dismiss();
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (acdv.a(this.a) == null)
    {
      QLog.i("GdtMotiveVideoDialog", 1, "mResultReceiver == null");
      return;
    }
    acdv.a(this.a).send(paramInt, paramIntent.getExtras());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acdw
 * JD-Core Version:    0.7.0.1
 */