import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.ar.FaceUIController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

public class aada
  implements DialogInterface.OnClickListener
{
  public aada(FaceUIController paramFaceUIController) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      QQToast.a(this.a.a, 2, 2131430548, 0).a();
      paramDialogInterface.dismiss();
      ReportController.b(null, "dc00898", "", "", "0X8008353", "0X8008353", 0, 0, "", "", "", "");
      return;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aada
 * JD-Core Version:    0.7.0.1
 */