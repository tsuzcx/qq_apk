import android.opengl.GLES20;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.mobileqq.ar.ARRenderModel.ARBaseRender;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderManagerImpl;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import java.util.Map;

public class aafo
  implements Runnable
{
  public aafo(ARRenderManagerImpl paramARRenderManagerImpl) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null)
    {
      this.a.jdField_a_of_type_JavaUtilMap.remove(this.a.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.a());
      this.a.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.d();
      this.a.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender = null;
    }
    if (ARRenderManagerImpl.a(this.a) != null)
    {
      GLES20.glDeleteTextures(1, new int[] { ARRenderManagerImpl.a(this.a).a() }, 0);
      ARRenderManagerImpl.a(this.a).d();
      ARRenderManagerImpl.a(this.a, null);
    }
    if (ARRenderManagerImpl.a(this.a) != null)
    {
      ARRenderManagerImpl.a(this.a).a();
      ARRenderManagerImpl.a(this.a, null);
    }
    if (ARRenderManagerImpl.a(this.a) != null) {
      ARRenderManagerImpl.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aafo
 * JD-Core Version:    0.7.0.1
 */