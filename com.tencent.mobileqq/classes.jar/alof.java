import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.5;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;

public class alof
  implements DialogInterface.OnClickListener
{
  public alof(ArkAppDownloadModule.5 param5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = false;
    aloa.a(this.a.this$0, true);
    bicp.a().a(this.a.jdField_a_of_type_CooperationWadlIpcWadlParams);
    axqy.a(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "7", "", this.a.jdField_a_of_type_CooperationWadlIpcWadlParams.a, "");
    if ((paramDialogInterface instanceof bbgu))
    {
      if (!((bbgu)paramDialogInterface).getCheckBoxState()) {
        bool = true;
      }
      if (this.a.jdField_a_of_type_AndroidContentSharedPreferences == null) {}
    }
    try
    {
      this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.a.b, bool).apply();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("ark.download.module", 1, "start download sp error : ", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alof
 * JD-Core Version:    0.7.0.1
 */