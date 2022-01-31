import android.view.View;
import com.tencent.mobileqq.nearby.smooth.ItemLoader;
import java.lang.ref.SoftReference;

public final class afme
  implements Runnable
{
  private final afmf jdField_a_of_type_Afmf;
  private final ItemLoader jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  private final boolean jdField_a_of_type_Boolean;
  
  public afme(ItemLoader paramItemLoader, afmf paramafmf, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader = paramItemLoader;
    this.jdField_a_of_type_Afmf = paramafmf;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Afmf)) {}
    View localView;
    do
    {
      return;
      if (this.jdField_a_of_type_Afmf.c == null) {
        throw new IllegalStateException("Result should not be null when displaying an item part");
      }
      localView = (View)this.jdField_a_of_type_Afmf.b.get();
    } while (localView == null);
    Object localObject = this.jdField_a_of_type_Afmf.c.get();
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(localView, localObject, this.jdField_a_of_type_Afmf.a.intValue(), this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afme
 * JD-Core Version:    0.7.0.1
 */