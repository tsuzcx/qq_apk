import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.microapp.sdk.OnUpdateListener;

class akcf
  implements OnUpdateListener
{
  akcf(akbx paramakbx, ResultReceiver paramResultReceiver) {}
  
  public void onCheckForUpdate(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidOsResultReceiver != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("action", 0);
      localBundle.putBoolean("res", paramBoolean);
      this.jdField_a_of_type_AndroidOsResultReceiver.send(0, localBundle);
    }
  }
  
  public void onUpdateSucc(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidOsResultReceiver != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("action", 1);
      localBundle.putBoolean("res", paramBoolean);
      this.jdField_a_of_type_AndroidOsResultReceiver.send(0, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akcf
 * JD-Core Version:    0.7.0.1
 */