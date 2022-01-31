import com.tencent.mobileqq.ar.ARRenderModel.GreetingCardRender;
import com.tencent.mobileqq.ar.ARRenderModel.GreetingYUVProgram;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.qphone.base.util.QLog;

public class aaaw
  implements Runnable
{
  public aaaw(GreetingCardRender paramGreetingCardRender, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3) {}
  
  public void run()
  {
    if ((GreetingCardRender.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender) == null) || (this.jdField_a_of_type_Int != GreetingCardRender.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender)) || (this.jdField_b_of_type_Int != GreetingCardRender.c(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender)) || (!GreetingCardRender.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender)))
    {
      if (GreetingCardRender.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender) != null) {
        break label246;
      }
      GreetingCardRender.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender, this.jdField_a_of_type_Int);
      GreetingCardRender.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender, this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      GreetingCardRender.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender, new RenderBuffer(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 33984));
      try
      {
        GreetingCardRender.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender).b();
        GreetingCardRender.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.c);
        GreetingCardRender.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender).a(GreetingCardRender.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender)[0], GreetingCardRender.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender)[1], GreetingCardRender.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender)[2], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        GreetingCardRender.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender).b();
        GreetingCardRender.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender).c();
        if (!GreetingCardRender.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender))
        {
          GreetingCardRender.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender, GreetingCardRender.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender).a());
          GreetingCardRender.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender, true);
          QLog.d("GreetingCardRender", 2, "drawFrame soft decode frame update");
        }
        return;
      }
      catch (Exception localException)
      {
        label246:
        localException.printStackTrace();
        QLog.i("GreetingCardRender", 1, "render error happen");
      }
      if (GreetingCardRender.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender) != null) {
        GreetingCardRender.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender).d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaaw
 * JD-Core Version:    0.7.0.1
 */