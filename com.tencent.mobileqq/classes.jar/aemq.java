import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.qphone.base.util.QLog;

public class aemq
  implements ConditionSearchManager.IConfigListener
{
  public aemq(NearbyProxy paramNearbyProxy) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.dating", 2, "onGetConfig, resultCode:" + paramInt + ",isSuccess:" + paramBoolean);
    }
    NearbyProxy.a(this.a, 4131, new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aemq
 * JD-Core Version:    0.7.0.1
 */