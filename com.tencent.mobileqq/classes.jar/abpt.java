import android.content.Context;
import android.content.IntentFilter;

public class abpt
{
  private abpv jdField_a_of_type_Abpv;
  private abpw jdField_a_of_type_Abpw;
  private Context jdField_a_of_type_AndroidContentContext;
  
  public abpt(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Abpv = new abpv(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Abpv, localIntentFilter);
  }
  
  public void a(abpw paramabpw)
  {
    this.jdField_a_of_type_Abpw = paramabpw;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Abpv != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Abpv);
      this.jdField_a_of_type_Abpw = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abpt
 * JD-Core Version:    0.7.0.1
 */