import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.util.Pair;

class afpj
  implements DialogInterface.OnClickListener
{
  afpj(afpi paramafpi, bdwt parambdwt, Pair paramPair) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bdwt.a((String)this.jdField_a_of_type_ComTencentUtilPair.first, ((Integer)this.jdField_a_of_type_ComTencentUtilPair.second).intValue(), true);
    if (!bdwt.a(this.jdField_a_of_type_Afpi.a.app))
    {
      this.jdField_a_of_type_Afpi.a.setTitle("");
      bdws.a(this.jdField_a_of_type_Afpi.a.app, this.jdField_a_of_type_Afpi.a, null);
    }
    this.jdField_a_of_type_Afpi.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpj
 * JD-Core Version:    0.7.0.1
 */