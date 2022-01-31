import android.os.Bundle;
import com.tencent.mobileqq.activity.Leba.34.1;
import com.tencent.qphone.base.util.QLog;

public class abax
  extends asde
{
  abax(abai paramabai) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.redpoint", 2, "NearbyEnterUpdateObserver onReceive");
    }
    if (this.a.jdField_a_of_type_Aiba == null) {
      return;
    }
    this.a.jdField_a_of_type_Beez.post(new Leba.34.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abax
 * JD-Core Version:    0.7.0.1
 */