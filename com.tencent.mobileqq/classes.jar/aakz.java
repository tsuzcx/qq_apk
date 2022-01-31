import com.tencent.mobileqq.ar.FaceUIController;
import com.tencent.mobileqq.ar.ScanningData;
import com.tencent.mobileqq.ar.ScanningSurfaceView;
import com.tencent.mobileqq.olympic.activity.ARTipsManager.BaikeClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class aakz
  implements ARTipsManager.BaikeClickListener
{
  aakz(aaky paramaaky) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanningSurfaceView", 2, "onContentClick subFaceData.wikiurl = " + this.a.b.c);
    }
    ScanningSurfaceView.b(this.a.a, this.a.b.c);
    ReportController.b(null, "dc00898", "", "", "0X8008351", "0X8008351", 0, 0, "", "", "", "");
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanningSurfaceView", 2, "onFeedbackClick subFaceData.wikiurl = " + this.a.b.c);
    }
    this.a.a.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakz
 * JD-Core Version:    0.7.0.1
 */