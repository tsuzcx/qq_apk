import android.app.Activity;
import android.content.Intent;
import com.dataline.core.DirectForwarder;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;

class adam
  implements FMDialogUtil.FMDialogInterface
{
  adam(adal paramadal) {}
  
  public void a()
  {
    DirectForwarder.b(this.a.a.jdField_a_of_type_AndroidAppActivity, 0);
    this.a.a.jdField_a_of_type_AndroidContentIntent.putExtra("NOCANCEL4DATALIN", true);
    this.a.a.jdField_a_of_type_AndroidAppActivity.setResult(0, this.a.a.jdField_a_of_type_AndroidContentIntent);
    this.a.a.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void b()
  {
    this.a.a.jdField_a_of_type_AndroidAppActivity.setResult(0, this.a.a.jdField_a_of_type_AndroidContentIntent);
    this.a.a.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adam
 * JD-Core Version:    0.7.0.1
 */