import android.content.Context;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;

public class acov
{
  private acox jdField_a_of_type_Acox;
  private acpe jdField_a_of_type_Acpe;
  private Context jdField_a_of_type_AndroidContentContext;
  private GdtAdBoxData jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  
  public static acow a(Context paramContext)
  {
    return new acow(paramContext);
  }
  
  public GdtAdBoxData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Acox = new acpd(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Acox.a(this);
    this.jdField_a_of_type_Acox.show();
  }
  
  void a(acpe paramacpe)
  {
    this.jdField_a_of_type_Acpe = paramacpe;
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  void a(GdtAdBoxData paramGdtAdBoxData)
  {
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = paramGdtAdBoxData;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Acox != null) && (this.jdField_a_of_type_Acox.isShowing()))
    {
      this.jdField_a_of_type_Acox.dismiss();
      this.jdField_a_of_type_Acox = null;
    }
    this.jdField_a_of_type_Acpe = null;
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Acpe != null) {
      this.jdField_a_of_type_Acpe.onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acov
 * JD-Core Version:    0.7.0.1
 */