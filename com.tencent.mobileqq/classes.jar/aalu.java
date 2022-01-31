import android.content.Context;
import android.content.IntentFilter;

public class aalu
{
  private aalw jdField_a_of_type_Aalw;
  private aalx jdField_a_of_type_Aalx;
  private Context jdField_a_of_type_AndroidContentContext;
  
  public aalu(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aalw = new aalw(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Aalw, localIntentFilter);
  }
  
  public void a(aalx paramaalx)
  {
    this.jdField_a_of_type_Aalx = paramaalx;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Aalw != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Aalw);
      this.jdField_a_of_type_Aalx = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalu
 * JD-Core Version:    0.7.0.1
 */