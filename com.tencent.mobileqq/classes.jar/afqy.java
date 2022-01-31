import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;

class afqy
  implements DialogInterface.OnClickListener
{
  afqy(afqi paramafqi, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent(this.jdField_a_of_type_Afqi.a, SearchContactsActivity.class);
    paramDialogInterface.putExtra("from_key", 0);
    paramDialogInterface.putExtra("fromType", 13);
    paramDialogInterface.putExtra("start_search_key", this.jdField_a_of_type_JavaLangString);
    paramDialogInterface.putExtra("auto_add_and_prohibit_auto_search", true);
    this.jdField_a_of_type_Afqi.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afqy
 * JD-Core Version:    0.7.0.1
 */