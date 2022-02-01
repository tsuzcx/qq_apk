import android.content.Context;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;

public class ackr
{
  private ackt jdField_a_of_type_Ackt;
  private acla jdField_a_of_type_Acla;
  private Context jdField_a_of_type_AndroidContentContext;
  private GdtAdBoxData jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  
  public static acks a(Context paramContext)
  {
    return new acks(paramContext);
  }
  
  public GdtAdBoxData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ackt = new ackz(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Ackt.a(this);
    this.jdField_a_of_type_Ackt.show();
  }
  
  void a(acla paramacla)
  {
    this.jdField_a_of_type_Acla = paramacla;
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
    if ((this.jdField_a_of_type_Ackt != null) && (this.jdField_a_of_type_Ackt.isShowing()))
    {
      this.jdField_a_of_type_Ackt.dismiss();
      this.jdField_a_of_type_Ackt = null;
    }
    this.jdField_a_of_type_Acla = null;
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Acla != null) {
      this.jdField_a_of_type_Acla.onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackr
 * JD-Core Version:    0.7.0.1
 */