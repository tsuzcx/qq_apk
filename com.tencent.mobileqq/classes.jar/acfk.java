import android.content.Context;
import android.content.IntentFilter;

public class acfk
{
  private acfm jdField_a_of_type_Acfm;
  private acfn jdField_a_of_type_Acfn;
  private Context jdField_a_of_type_AndroidContentContext;
  
  public acfk(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Acfm = new acfm(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Acfm, localIntentFilter);
  }
  
  public void a(acfn paramacfn)
  {
    this.jdField_a_of_type_Acfn = paramacfn;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Acfm != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Acfm);
      this.jdField_a_of_type_Acfn = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfk
 * JD-Core Version:    0.7.0.1
 */