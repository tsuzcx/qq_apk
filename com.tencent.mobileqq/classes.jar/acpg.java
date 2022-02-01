import android.content.Context;
import android.content.IntentFilter;

public class acpg
{
  private acpi jdField_a_of_type_Acpi;
  private acpj jdField_a_of_type_Acpj;
  private Context jdField_a_of_type_AndroidContentContext;
  
  public acpg(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Acpi = new acpi(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Acpi, localIntentFilter);
  }
  
  public void a(acpj paramacpj)
  {
    this.jdField_a_of_type_Acpj = paramacpj;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Acpi != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Acpi);
      this.jdField_a_of_type_Acpj = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpg
 * JD-Core Version:    0.7.0.1
 */