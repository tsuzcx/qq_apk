import com.tencent.mobileqq.ar.ARRenderModel.ARBaseRender;
import com.tencent.mobileqq.arcard.ARCardRender;
import java.util.Map;

public class aasy
  implements Runnable
{
  public aasy(ARCardRender paramARCardRender) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null)
    {
      this.a.jdField_a_of_type_JavaUtilMap.remove(this.a.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.a());
      this.a.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.d();
      this.a.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aasy
 * JD-Core Version:    0.7.0.1
 */