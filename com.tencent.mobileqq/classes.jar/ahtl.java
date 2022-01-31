import com.tencent.mobileqq.richmedia.mediacodec.renderer.FilterFactory;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUDrawPartFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup;

public class ahtl
  implements Runnable
{
  public ahtl(GpuImagePartsFilterGroup paramGpuImagePartsFilterGroup, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    GPUDrawPartFilter localGPUDrawPartFilter2 = null;
    GPUDrawPartFilter localGPUDrawPartFilter1;
    if ((GpuImagePartsFilterGroup.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup) == null) || (GpuImagePartsFilterGroup.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).b() != this.jdField_a_of_type_Int))
    {
      localGPUDrawPartFilter1 = GpuImagePartsFilterGroup.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup);
      GpuImagePartsFilterGroup.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup, (GPUDrawPartFilter)FilterFactory.a(this.jdField_a_of_type_Int));
      GpuImagePartsFilterGroup.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a();
      GpuImagePartsFilterGroup.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(this.b, this.c);
    }
    for (;;)
    {
      if ((GpuImagePartsFilterGroup.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup) == null) || (GpuImagePartsFilterGroup.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).b() != this.d))
      {
        localGPUDrawPartFilter2 = GpuImagePartsFilterGroup.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup);
        GpuImagePartsFilterGroup.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup, (GPUDrawPartFilter)FilterFactory.a(this.d));
        GpuImagePartsFilterGroup.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a();
        GpuImagePartsFilterGroup.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        GpuImagePartsFilterGroup.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(false);
        GpuImagePartsFilterGroup.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(false);
      }
      for (;;)
      {
        GpuImagePartsFilterGroup.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup, this.jdField_a_of_type_Float);
        GpuImagePartsFilterGroup.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(true, 0.1F * 2.0F + this.jdField_a_of_type_Float);
        GpuImagePartsFilterGroup.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(false, this.jdField_a_of_type_Float);
        if (localGPUDrawPartFilter1 != null) {
          localGPUDrawPartFilter1.d();
        }
        if (localGPUDrawPartFilter2 != null) {
          localGPUDrawPartFilter2.d();
        }
        return;
        GpuImagePartsFilterGroup.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(true);
        GpuImagePartsFilterGroup.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(true);
      }
      localGPUDrawPartFilter1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahtl
 * JD-Core Version:    0.7.0.1
 */