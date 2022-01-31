import android.os.Handler;
import android.os.Process;
import com.tencent.mobileqq.nearby.smooth.ItemLoader;
import java.lang.ref.SoftReference;
import java.util.Map;

public final class aezb
  implements Runnable
{
  private final aeyz jdField_a_of_type_Aeyz;
  private final ItemLoader jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  
  public aezb(ItemLoader paramItemLoader, aeyz paramaeyz)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader = paramItemLoader;
    this.jdField_a_of_type_Aeyz = paramaeyz;
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.b.remove(this.jdField_a_of_type_Aeyz.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Aeyz)) {}
    do
    {
      return;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Aeyz.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Aeyz.jdField_a_of_type_JavaLangInteger.intValue());
      this.jdField_a_of_type_Aeyz.c = new SoftReference(localObject);
    } while ((this.jdField_a_of_type_Aeyz.b == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Aeyz)));
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a.post(new aeyy(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader, this.jdField_a_of_type_Aeyz, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aezb
 * JD-Core Version:    0.7.0.1
 */