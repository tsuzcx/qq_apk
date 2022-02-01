import com.tencent.mobileqq.activity.Leba;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.chat.QCircleObserver;

public class aegf
  extends QCircleObserver
{
  public aegf(Leba paramLeba) {}
  
  public void onUpdateRedPoint(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.lebatab.leba", 2, "QCircleObserver onUpdateRedPoint " + paramInt);
    }
    Leba.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aegf
 * JD-Core Version:    0.7.0.1
 */