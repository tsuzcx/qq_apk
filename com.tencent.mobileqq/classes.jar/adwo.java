import QC.UniCheckRsp;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import java.util.ArrayList;

class adwo
  implements bhte
{
  adwo(adwn paramadwn, int paramInt) {}
  
  public void a(boolean paramBoolean, UniCheckRsp paramUniCheckRsp)
  {
    if ((!paramBoolean) && (paramUniCheckRsp != null) && (paramUniCheckRsp.uniBusinessItemList != null) && (paramUniCheckRsp.uniBusinessItemList.size() == 1))
    {
      this.jdField_a_of_type_Adwn.a.j = false;
      this.jdField_a_of_type_Adwn.a.b(false);
      bhtg.a(this.jdField_a_of_type_Adwn.a.getBaseContext());
      return;
    }
    ((VasExtensionHandler)this.jdField_a_of_type_Adwn.a.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(this.jdField_a_of_type_Adwn.a.e, ((ColorClearableEditText)this.jdField_a_of_type_Adwn.a.a).a(), this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Adwn.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwo
 * JD-Core Version:    0.7.0.1
 */