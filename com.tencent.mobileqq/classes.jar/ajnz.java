import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

public class ajnz
  implements DialogInterface.OnClickListener
{
  public ajnz(QzoneSlideShowPreparingFragment paramQzoneSlideShowPreparingFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LpReportInfo_pf00064.allReport(680, 1, 2);
    QzoneSlideShowPreparingFragment.a(this.a).dismiss();
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnz
 * JD-Core Version:    0.7.0.1
 */