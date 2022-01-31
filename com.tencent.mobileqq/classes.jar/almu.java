import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ar.view.QRScanEntryView;
import com.tencent.qphone.base.util.QLog;

public class almu
  implements View.OnClickListener
{
  public almu(QRScanEntryView paramQRScanEntryView) {}
  
  public void onClick(View paramView)
  {
    boolean bool2 = false;
    if (QRScanEntryView.a(this.a))
    {
      paramView = alku.a();
      if (!QRScanEntryView.b(this.a))
      {
        bool1 = true;
        if (paramView.a(bool1))
        {
          paramView = this.a;
          if (QRScanEntryView.b(this.a)) {
            break label118;
          }
          bool1 = true;
          QRScanEntryView.a(paramView, bool1);
          paramView = (alkz)this.a.a;
          bool1 = bool2;
          if (!QRScanEntryView.b(this.a)) {
            bool1 = true;
          }
          paramView.a(bool1, 0L);
          QRScanEntryView.a(this.a, true);
          QRScanEntryView.b(this.a, QRScanEntryView.b(this.a));
        }
      }
    }
    label118:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        boolean bool1 = false;
        continue;
        bool1 = false;
      }
    }
    QLog.d("AREngine_QRScanEntryView", 2, "initView click mFlashLightTips when view invisble.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     almu
 * JD-Core Version:    0.7.0.1
 */