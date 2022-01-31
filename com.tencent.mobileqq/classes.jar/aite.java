import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;

public class aite
  implements DialogInterface.OnClickListener
{
  public aite(ApolloGameActivity paramApolloGameActivity, ajab paramajab, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Ajab != null) {
      this.jdField_a_of_type_Ajab.a(1);
    }
    bajr.a(null, "cmshow", "Apollo", "sendToDesktopSusessful", 0, 1, new String[] { String.valueOf(this.jdField_a_of_type_Int) });
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aite
 * JD-Core Version:    0.7.0.1
 */