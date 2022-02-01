import android.content.Context;
import android.content.IntentFilter;

public class actj
{
  private actl jdField_a_of_type_Actl;
  private actm jdField_a_of_type_Actm;
  private Context jdField_a_of_type_AndroidContentContext;
  
  public actj(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Actl = new actl(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Actl, localIntentFilter);
  }
  
  public void a(actm paramactm)
  {
    this.jdField_a_of_type_Actm = paramactm;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Actl != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Actl);
      this.jdField_a_of_type_Actm = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actj
 * JD-Core Version:    0.7.0.1
 */