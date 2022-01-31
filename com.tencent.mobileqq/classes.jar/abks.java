import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.Leba.37;

public class abks
  implements DialogInterface.OnClickListener
{
  public abks(Leba.37 param37) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.a.b, true).apply();
    this.a.jdField_a_of_type_Abku.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abks
 * JD-Core Version:    0.7.0.1
 */