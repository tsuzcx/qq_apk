import android.content.Context;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;

public class abld
{
  private ablf jdField_a_of_type_Ablf;
  private abln jdField_a_of_type_Abln;
  private Context jdField_a_of_type_AndroidContentContext;
  private GdtAdBoxData jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  
  public static able a(Context paramContext)
  {
    return new able(paramContext);
  }
  
  public GdtAdBoxData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ablf = new ablm(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Ablf.a(this);
    this.jdField_a_of_type_Ablf.show();
  }
  
  void a(abln paramabln)
  {
    this.jdField_a_of_type_Abln = paramabln;
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
    if ((this.jdField_a_of_type_Ablf != null) && (this.jdField_a_of_type_Ablf.isShowing()))
    {
      this.jdField_a_of_type_Ablf.dismiss();
      this.jdField_a_of_type_Ablf = null;
    }
    this.jdField_a_of_type_Abln = null;
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Abln != null) {
      this.jdField_a_of_type_Abln.onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abld
 * JD-Core Version:    0.7.0.1
 */