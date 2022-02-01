import com.tencent.biz.qqcircle.list.bizblocks.QCircleObserver;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.qphone.base.util.QLog;

public class aewa
  extends QCircleObserver
{
  public aewa(Leba paramLeba) {}
  
  public void onUpdateRedPoint(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.lebatab.leba", 2, "QCircleObserver onUpdateRedPoint " + paramInt);
    }
    Leba.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aewa
 * JD-Core Version:    0.7.0.1
 */