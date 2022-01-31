import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.model.MPcFileModel;
import mqq.app.MobileQQ;

public class adlp
  implements DialogInterface.OnClickListener
{
  public adlp(MPcFileModel paramMPcFileModel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.c();
    this.a.a.removeObserver(MPcFileModel.a(this.a));
    Intent localIntent = new Intent(this.a.a.getApplication(), LiteActivity.class);
    localIntent.addFlags(67108864);
    this.a.a.getApplication().startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adlp
 * JD-Core Version:    0.7.0.1
 */