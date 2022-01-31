import android.content.Context;
import com.tencent.qphone.base.util.QLog;

public class alcp
{
  Context a;
  public aufj a;
  public bbgu a;
  
  public alcp(Context paramContext, aufj paramaufj)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aufj = paramaufj;
    this.jdField_a_of_type_Bbgu = bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230);
    paramContext = new alcq(this);
    this.jdField_a_of_type_Bbgu.setPositiveButton(2131690183, paramContext);
    this.jdField_a_of_type_Bbgu.setNegativeButton(2131690182, paramContext);
    this.jdField_a_of_type_Bbgu.setMessage(2131690185);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Bbgu.isShowing()) {
      this.jdField_a_of_type_Bbgu.show();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceUIController", 2, "doOnClickFeedBack");
    }
    axqy.b(null, "dc00898", "", "", "0X8008352", "0X8008352", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alcp
 * JD-Core Version:    0.7.0.1
 */