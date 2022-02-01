import android.os.Bundle;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.Leba.34.1;
import com.tencent.qphone.base.util.QLog;

public class aevx
  extends axuu
{
  public aevx(Leba paramLeba) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.redpoint", 2, "NearbyEnterUpdateObserver onReceive");
    }
    if (Leba.a(this.a) == null) {
      return;
    }
    this.a.a.post(new Leba.34.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aevx
 * JD-Core Version:    0.7.0.1
 */