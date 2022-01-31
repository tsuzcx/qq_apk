import android.os.Handler;
import android.os.Process;
import com.tencent.mobileqq.nearby.smooth.ItemLoader;
import java.lang.ref.SoftReference;
import java.util.Map;

public final class afmh
  implements Runnable
{
  private final afmf jdField_a_of_type_Afmf;
  private final ItemLoader jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  
  public afmh(ItemLoader paramItemLoader, afmf paramafmf)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader = paramItemLoader;
    this.jdField_a_of_type_Afmf = paramafmf;
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.b.remove(this.jdField_a_of_type_Afmf.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Afmf)) {}
    do
    {
      return;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Afmf.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Afmf.jdField_a_of_type_JavaLangInteger.intValue());
      this.jdField_a_of_type_Afmf.c = new SoftReference(localObject);
    } while ((this.jdField_a_of_type_Afmf.b == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Afmf)));
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a.post(new afme(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader, this.jdField_a_of_type_Afmf, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afmh
 * JD-Core Version:    0.7.0.1
 */