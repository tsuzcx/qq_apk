import android.content.Context;
import com.tencent.qphone.base.util.QLog;

public class alcq
{
  Context a;
  public aufh a;
  public bbgg a;
  
  public alcq(Context paramContext, aufh paramaufh)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aufh = paramaufh;
    this.jdField_a_of_type_Bbgg = bbcv.a(this.jdField_a_of_type_AndroidContentContext, 230);
    paramContext = new alcr(this);
    this.jdField_a_of_type_Bbgg.setPositiveButton(2131690183, paramContext);
    this.jdField_a_of_type_Bbgg.setNegativeButton(2131690182, paramContext);
    this.jdField_a_of_type_Bbgg.setMessage(2131690185);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Bbgg.isShowing()) {
      this.jdField_a_of_type_Bbgg.show();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceUIController", 2, "doOnClickFeedBack");
    }
    axqw.b(null, "dc00898", "", "", "0X8008352", "0X8008352", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alcq
 * JD-Core Version:    0.7.0.1
 */