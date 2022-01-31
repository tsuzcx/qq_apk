import android.os.Bundle;
import com.tencent.common.app.AppInterface;

public abstract class allo
{
  public long a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  
  public allo()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_c_of_type_JavaLangString = "0";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public abstract void a(AppInterface paramAppInterface, Bundle paramBundle);
  
  public final void b(AppInterface paramAppInterface, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.jdField_a_of_type_Long = paramBundle.getLong("RecoglizeMask", 0L);
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("H5Source", "0");
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("version", "0");
    if (!paramBundle.getBoolean("disablecloud", false)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_c_of_type_Boolean = paramBundle.getBoolean("is_from_h5_entry", false);
      this.jdField_b_of_type_Boolean = false;
      a(paramAppInterface, paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     allo
 * JD-Core Version:    0.7.0.1
 */