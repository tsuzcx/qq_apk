import android.content.Context;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;

public class aais
{
  private aaiu jdField_a_of_type_Aaiu;
  private aajb jdField_a_of_type_Aajb;
  private Context jdField_a_of_type_AndroidContentContext;
  private GdtAdBoxData jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  
  public static aait a(Context paramContext)
  {
    return new aait(paramContext);
  }
  
  public GdtAdBoxData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aaiu = new aaja(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Aaiu.a(this);
    this.jdField_a_of_type_Aaiu.show();
  }
  
  void a(aajb paramaajb)
  {
    this.jdField_a_of_type_Aajb = paramaajb;
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
    if ((this.jdField_a_of_type_Aaiu != null) && (this.jdField_a_of_type_Aaiu.isShowing()))
    {
      this.jdField_a_of_type_Aaiu.dismiss();
      this.jdField_a_of_type_Aaiu = null;
    }
    this.jdField_a_of_type_Aajb = null;
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aajb != null) {
      this.jdField_a_of_type_Aajb.onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aais
 * JD-Core Version:    0.7.0.1
 */