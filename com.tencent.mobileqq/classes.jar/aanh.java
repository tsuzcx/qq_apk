import android.content.Context;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;

public class aanh
{
  private aanj jdField_a_of_type_Aanj;
  private aanq jdField_a_of_type_Aanq;
  private Context jdField_a_of_type_AndroidContentContext;
  private GdtAdBoxData jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  
  public static aani a(Context paramContext)
  {
    return new aani(paramContext);
  }
  
  public GdtAdBoxData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aanj = new aanp(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Aanj.a(this);
    this.jdField_a_of_type_Aanj.show();
  }
  
  void a(aanq paramaanq)
  {
    this.jdField_a_of_type_Aanq = paramaanq;
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
    if ((this.jdField_a_of_type_Aanj != null) && (this.jdField_a_of_type_Aanj.isShowing()))
    {
      this.jdField_a_of_type_Aanj.dismiss();
      this.jdField_a_of_type_Aanj = null;
    }
    this.jdField_a_of_type_Aanq = null;
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aanq != null) {
      this.jdField_a_of_type_Aanq.onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aanh
 * JD-Core Version:    0.7.0.1
 */