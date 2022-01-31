import com.tencent.mobileqq.richmedia.mediacodec.renderer.FilterFactory;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUDrawPartFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup;

public class ahtk
  implements Runnable
{
  public ahtk(GpuImagePartsFilterGroup paramGpuImagePartsFilterGroup, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    GPUDrawPartFilter localGPUDrawPartFilter1 = null;
    GPUDrawPartFilter localGPUDrawPartFilter2 = GpuImagePartsFilterGroup.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup);
    GpuImagePartsFilterGroup.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup, null);
    if ((GpuImagePartsFilterGroup.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup) == null) || (GpuImagePartsFilterGroup.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).b() != this.jdField_a_of_type_Int))
    {
      localGPUDrawPartFilter1 = GpuImagePartsFilterGroup.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup);
      GpuImagePartsFilterGroup.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup, (GPUDrawPartFilter)FilterFactory.a(this.jdField_a_of_type_Int));
      GpuImagePartsFilterGroup.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a();
      GpuImagePartsFilterGroup.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(this.b, this.c);
    }
    GpuImagePartsFilterGroup.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(false, 0.0F);
    GpuImagePartsFilterGroup.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup, 0.0F);
    if (localGPUDrawPartFilter2 != null) {
      localGPUDrawPartFilter2.d();
    }
    if (localGPUDrawPartFilter1 != null) {
      localGPUDrawPartFilter1.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahtk
 * JD-Core Version:    0.7.0.1
 */