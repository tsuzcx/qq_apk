import com.tencent.mobileqq.activity.Leba;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.chat.QCircleObserver;

public class adpc
  extends QCircleObserver
{
  public adpc(Leba paramLeba) {}
  
  public void onUpdateRedPoint(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.lebatab.leba", 2, "QCircleObserver onUpdateRedPoint " + paramInt);
    }
    Leba.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpc
 * JD-Core Version:    0.7.0.1
 */