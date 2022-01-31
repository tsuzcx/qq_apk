import android.os.SystemClock;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.MaterialStatusRecord;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.GroupVideoFilterList;
import com.tencent.mobileqq.shortvideo.ptvfilter.VideoFilterList;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.cache.ImageMemoryManager;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import java.util.ArrayList;
import java.util.List;

class ahmc
  implements Runnable
{
  ahmc(ahmb paramahmb, QQVideoMaterial paramQQVideoMaterial1, QQFilterRenderManager paramQQFilterRenderManager, VideoFilterList paramVideoFilterList, QQVideoMaterial paramQQVideoMaterial2, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void run()
  {
    EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a, null);
    EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a, -1);
    long l = SystemClock.elapsedRealtime();
    if (this.jdField_a_of_type_Ahmb.a.i) {
      com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter.jdField_a_of_type_Int = AdvancedProviderView.c();
    }
    label227:
    label358:
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial.b() != null) && (!this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial.b().isEmpty()))
    {
      EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a, new GroupVideoFilterList(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a));
      if ((this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial == null) || (this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial.getShaderType() != 2000)) {
        break label568;
      }
      Object localObject = new ArrayList();
      List localList1 = this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial.getItemList();
      List localList2 = this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial.c();
      if ((localList1 != null) && (localList1.size() > 0)) {
        ((List)localObject).addAll(localList1);
      }
      if ((localList2 != null) && (localList2.size() > 0)) {
        ((List)localObject).addAll(localList2);
      }
      ImageMemoryManager.getInstance().loadAllItemsAppend(this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial, (List)localObject);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.e = this.jdField_a_of_type_Boolean;
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList == null) || (!EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a())) || (!EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a).jdField_b_of_type_Boolean)) {
        break label610;
      }
      EffectsCameraCaptureView.b(this.jdField_a_of_type_Ahmb.a, true);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial.c);
      label307:
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList == null) || (!EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a())) || (!EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a).jdField_a_of_type_Boolean)) {
        break label633;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b(true);
      l = (SystemClock.elapsedRealtime() - l) / 1000L;
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[setVideoFilter_changeFilter=" + l / 1000.0D + "ms]");
      }
      EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a, this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial);
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList == null) || (this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial == null)) {
        break label866;
      }
      localObject = this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial.a;
      if ((!this.jdField_a_of_type_Boolean) || (FlowCameraConstant.jdField_a_of_type_Int == 2)) {
        break label644;
      }
      i = 1;
      label462:
      if ((localObject == null) || (((String)localObject).length() == 0)) {
        break label649;
      }
      EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a, (String)localObject);
      EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a, 2);
      label500:
      if (EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a).jdField_a_of_type_Int != 0) {
        break label764;
      }
      EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a, this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.jdField_a_of_type_Boolean, false, false, 0);
    }
    label568:
    label610:
    label633:
    label764:
    do
    {
      for (;;)
      {
        return;
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList);
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
      break;
      if (EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a).jdField_a_of_type_Boolean)
      {
        ImageMemoryManager.getInstance().loadAllImages(this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial);
        break label227;
      }
      ImageMemoryManager.getInstance().loadAllImages(this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial);
      break label227;
      EffectsCameraCaptureView.b(this.jdField_a_of_type_Ahmb.a, false);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(false);
      break label307;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b(false);
      break label358;
      i = 0;
      break label462;
      if ((i != 0) && (!this.jdField_b_of_type_Boolean))
      {
        EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a, "切换后置摄像头试试");
        EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a, 0);
        break label500;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a, LbsFilterStatusManager.a());
        EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a, 3);
        break label500;
      }
      EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a, EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a, this.jdField_a_of_type_Int));
      EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a, 1);
      break label500;
      if (EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a).jdField_a_of_type_Int == 1)
      {
        EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a, false, false, this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.c, this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.d, 1);
        return;
      }
    } while (EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a).jdField_a_of_type_Int != 2);
    label644:
    label649:
    EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a, this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.c, this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.d, 2);
    return;
    label866:
    EffectsCameraCaptureView.a(this.jdField_a_of_type_Ahmb.a, false, false, false, false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahmc
 * JD-Core Version:    0.7.0.1
 */