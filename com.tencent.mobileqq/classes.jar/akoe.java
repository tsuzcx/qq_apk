import android.content.Context;
import com.tencent.qphone.base.util.QLog;

public class akoe
{
  Context a;
  public athi a;
  public bafb a;
  
  public akoe(Context paramContext, athi paramathi)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Athi = paramathi;
    this.jdField_a_of_type_Bafb = babr.a(this.jdField_a_of_type_AndroidContentContext, 230);
    paramContext = new akof(this);
    this.jdField_a_of_type_Bafb.setPositiveButton(2131624629, paramContext);
    this.jdField_a_of_type_Bafb.setNegativeButton(2131624628, paramContext);
    this.jdField_a_of_type_Bafb.setMessage(2131624631);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Bafb.isShowing()) {
      this.jdField_a_of_type_Bafb.show();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceUIController", 2, "doOnClickFeedBack");
    }
    awqx.b(null, "dc00898", "", "", "0X8008352", "0X8008352", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akoe
 * JD-Core Version:    0.7.0.1
 */