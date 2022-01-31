import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.utils.VipUtils;

public class ajhc
  implements DialogInterface.OnClickListener
{
  public ajhc(ApolloGameActivity paramApolloGameActivity, ajob paramajob, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Ajob != null) {
      this.jdField_a_of_type_Ajob.a(1);
    }
    VipUtils.a(null, "cmshow", "Apollo", "sendToDesktopSusessful", 0, 1, new String[] { String.valueOf(this.jdField_a_of_type_Int) });
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajhc
 * JD-Core Version:    0.7.0.1
 */