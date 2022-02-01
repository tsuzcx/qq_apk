import android.content.Context;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;

public class acat
{
  private acav jdField_a_of_type_Acav;
  private acbd jdField_a_of_type_Acbd;
  private Context jdField_a_of_type_AndroidContentContext;
  private GdtAdBoxData jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  
  public static acau a(Context paramContext)
  {
    return new acau(paramContext);
  }
  
  public GdtAdBoxData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Acav = new acbc(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Acav.a(this);
    this.jdField_a_of_type_Acav.show();
  }
  
  void a(acbd paramacbd)
  {
    this.jdField_a_of_type_Acbd = paramacbd;
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
    if ((this.jdField_a_of_type_Acav != null) && (this.jdField_a_of_type_Acav.isShowing()))
    {
      this.jdField_a_of_type_Acav.dismiss();
      this.jdField_a_of_type_Acav = null;
    }
    this.jdField_a_of_type_Acbd = null;
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Acbd != null) {
      this.jdField_a_of_type_Acbd.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acat
 * JD-Core Version:    0.7.0.1
 */