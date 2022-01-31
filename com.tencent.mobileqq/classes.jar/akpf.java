import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.base.LogUtility;

public final class akpf
  implements Runnable
{
  public akpf(Bundle paramBundle, Activity paramActivity, int paramInt1, ApkUpdateDetail paramApkUpdateDetail, int paramInt2) {}
  
  public void run()
  {
    Object localObject = new akpg(this);
    akph localakph = new akph(this);
    LogUtility.b("DownloadJSApi", "dialog create and show");
    localObject = new AlertDialog.Builder(this.jdField_a_of_type_AndroidAppActivity).setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131428549)).setPositiveButton(2131428546, localakph).setNegativeButton(2131428547, (DialogInterface.OnClickListener)localObject).create();
    ((Dialog)localObject).setCanceledOnTouchOutside(false);
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      ((Dialog)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akpf
 * JD-Core Version:    0.7.0.1
 */