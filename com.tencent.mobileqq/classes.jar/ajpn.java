import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;

class ajpn
  implements DialogInterface.OnClickListener
{
  ajpn(ajpi paramajpi, ArrayList paramArrayList, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ajpi.a(this.jdField_a_of_type_Ajpi, true);
    ajpi.a(this.jdField_a_of_type_Ajpi).a(1);
    ajpi.a(this.jdField_a_of_type_Ajpi, this.jdField_a_of_type_JavaUtilArrayList.size(), 0.0F);
    if (NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      paramInt = (int)(90.0F / this.jdField_a_of_type_Int);
      ajpi.a(this.jdField_a_of_type_Ajpi).b(paramInt);
    }
    ajpi.a(this.jdField_a_of_type_Ajpi, this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpn
 * JD-Core Version:    0.7.0.1
 */