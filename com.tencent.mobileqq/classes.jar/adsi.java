import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

class adsi
  implements DialogInterface.OnClickListener
{
  adsi(adsh paramadsh, long paramLong, UUID paramUUID, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      TroopFileTransferManager.a(this.jdField_a_of_type_Adsh.a, this.jdField_a_of_type_Long).a(this.jdField_a_of_type_JavaUtilUUID);
      return;
    }
    new aypd(this.jdField_a_of_type_Long, this.jdField_a_of_type_Adsh.a, this.jdField_a_of_type_AndroidAppActivity).b(this.jdField_a_of_type_JavaUtilUUID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adsi
 * JD-Core Version:    0.7.0.1
 */