import android.os.Bundle;
import com.tencent.common.app.AppInterface;

public abstract class agjr
{
  public long a;
  public boolean a;
  public String g = "0";
  
  agjr()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  abstract void a(AppInterface paramAppInterface, Bundle paramBundle);
  
  public final void b(AppInterface paramAppInterface, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.jdField_a_of_type_Long = paramBundle.getLong("ar_recoglize_mask");
    this.g = paramBundle.getString("H5Source");
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("ar_show_promotion_entry");
    a(paramAppInterface, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agjr
 * JD-Core Version:    0.7.0.1
 */