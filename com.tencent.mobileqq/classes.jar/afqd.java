import android.view.View;
import com.tencent.mobileqq.nearby.smooth.ItemLoader;
import java.lang.ref.SoftReference;

public final class afqd
  implements Runnable
{
  private final afqe jdField_a_of_type_Afqe;
  private final ItemLoader jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  private final boolean jdField_a_of_type_Boolean;
  
  public afqd(ItemLoader paramItemLoader, afqe paramafqe, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader = paramItemLoader;
    this.jdField_a_of_type_Afqe = paramafqe;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Afqe)) {}
    View localView;
    do
    {
      return;
      if (this.jdField_a_of_type_Afqe.c == null) {
        throw new IllegalStateException("Result should not be null when displaying an item part");
      }
      localView = (View)this.jdField_a_of_type_Afqe.b.get();
    } while (localView == null);
    Object localObject = this.jdField_a_of_type_Afqe.c.get();
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(localView, localObject, this.jdField_a_of_type_Afqe.a.intValue(), this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afqd
 * JD-Core Version:    0.7.0.1
 */