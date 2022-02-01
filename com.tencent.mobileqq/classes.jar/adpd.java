import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.Leba.40;

public class adpd
  implements DialogInterface.OnClickListener
{
  public adpd(Leba.40 param40) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.a.b, true).apply();
    this.a.jdField_a_of_type_Adpg.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpd
 * JD-Core Version:    0.7.0.1
 */