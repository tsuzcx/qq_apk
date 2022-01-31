import android.content.Context;
import android.content.IntentFilter;

public class aaqj
{
  private aaql jdField_a_of_type_Aaql;
  private aaqm jdField_a_of_type_Aaqm;
  private Context jdField_a_of_type_AndroidContentContext;
  
  public aaqj(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aaql = new aaql(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Aaql, localIntentFilter);
  }
  
  public void a(aaqm paramaaqm)
  {
    this.jdField_a_of_type_Aaqm = paramaaqm;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Aaql != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Aaql);
      this.jdField_a_of_type_Aaqm = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqj
 * JD-Core Version:    0.7.0.1
 */