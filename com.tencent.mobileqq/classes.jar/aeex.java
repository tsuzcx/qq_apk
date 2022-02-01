import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.JumpActivity;

public class aeex
  extends AsyncTask<Object, Void, Uri>
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  
  public aeex(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  protected Uri a(Object... paramVarArgs)
  {
    return aoud.a(paramVarArgs);
  }
  
  protected void a(Uri paramUri)
  {
    this.jdField_a_of_type_AndroidContentIntent.setData(paramUri);
    aupt.a(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aeex
 * JD-Core Version:    0.7.0.1
 */