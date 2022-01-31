import android.os.Handler;
import android.os.Process;
import com.tencent.mobileqq.nearby.smooth.ItemLoader;
import java.lang.ref.SoftReference;
import java.util.Map;

public final class afqg
  implements Runnable
{
  private final afqe jdField_a_of_type_Afqe;
  private final ItemLoader jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  
  public afqg(ItemLoader paramItemLoader, afqe paramafqe)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader = paramItemLoader;
    this.jdField_a_of_type_Afqe = paramafqe;
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.b.remove(this.jdField_a_of_type_Afqe.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Afqe)) {}
    do
    {
      return;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Afqe.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Afqe.jdField_a_of_type_JavaLangInteger.intValue());
      this.jdField_a_of_type_Afqe.c = new SoftReference(localObject);
    } while ((this.jdField_a_of_type_Afqe.b == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Afqe)));
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a.post(new afqd(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader, this.jdField_a_of_type_Afqe, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afqg
 * JD-Core Version:    0.7.0.1
 */