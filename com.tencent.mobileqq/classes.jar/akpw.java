import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.chat.QCircleObserver;

public class akpw
  extends QCircleObserver
{
  public akpw(QCircleFrame paramQCircleFrame) {}
  
  public void onUpdateRedPoint(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QCircleFrame", 2, "QCircleObserver onUpdateRedPoint " + paramInt);
    }
    if (QCircleFrame.a(this.a) != null) {
      QCircleFrame.a(this.a).a("mQCircleRedDotObserver");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akpw
 * JD-Core Version:    0.7.0.1
 */