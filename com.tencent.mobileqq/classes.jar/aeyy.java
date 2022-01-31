import android.view.View;
import com.tencent.mobileqq.nearby.smooth.ItemLoader;
import java.lang.ref.SoftReference;

public final class aeyy
  implements Runnable
{
  private final aeyz jdField_a_of_type_Aeyz;
  private final ItemLoader jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  private final boolean jdField_a_of_type_Boolean;
  
  public aeyy(ItemLoader paramItemLoader, aeyz paramaeyz, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader = paramItemLoader;
    this.jdField_a_of_type_Aeyz = paramaeyz;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Aeyz)) {}
    View localView;
    do
    {
      return;
      if (this.jdField_a_of_type_Aeyz.c == null) {
        throw new IllegalStateException("Result should not be null when displaying an item part");
      }
      localView = (View)this.jdField_a_of_type_Aeyz.b.get();
    } while (localView == null);
    Object localObject = this.jdField_a_of_type_Aeyz.c.get();
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(localView, localObject, this.jdField_a_of_type_Aeyz.a.intValue(), this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeyy
 * JD-Core Version:    0.7.0.1
 */