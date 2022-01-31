import android.os.SystemClock;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.richmedia.capture.util.ReportUtil;
import com.tencent.mobileqq.richmedia.capture.view.CommonPatternInfo;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.MaterialStatusRecord;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.VideoFilterList;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.TemplateParser;
import com.tencent.mobileqq.shortvideo.ptvfilter.utils.VideoFilterUtil;
import com.tencent.mobileqq.shortvideo.util.FilterMemory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.cache.ImageMemoryManager;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import java.io.File;
import java.util.List;

public class ahqt
  implements Runnable
{
  public ahqt(EffectsCameraCaptureView paramEffectsCameraCaptureView, String paramString) {}
  
  public void run()
  {
    Object localObject1 = CommonPatternInfo.a(EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView));
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.a((CommonPatternInfo)localObject1)) {
      return;
    }
    label110:
    int i;
    long l;
    boolean bool2;
    boolean[] arrayOfBoolean;
    Object localObject2;
    boolean bool1;
    label229:
    int j;
    if ((this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("")))
    {
      if (localObject1 != null)
      {
        EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView).jdField_b_of_type_Boolean = ((CommonPatternInfo)localObject1).jdField_b_of_type_Boolean;
        EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView).jdField_a_of_type_Boolean = ((CommonPatternInfo)localObject1).c;
        EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView).jdField_a_of_type_Int = ((CommonPatternInfo)localObject1).jdField_b_of_type_Int;
        com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager.jdField_a_of_type_JavaLangString = ((CommonPatternInfo)localObject1).f;
        com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager.b = ((CommonPatternInfo)localObject1).g;
      }
      i = VideoMaterialUtil.TRIGGER_TYPE.UNKNOW.value;
      l = SystemClock.elapsedRealtime();
      FilterMemory.a(1);
      localObject1 = new File(this.jdField_a_of_type_JavaLangString, "paramsback" + ".json");
      bool2 = ((File)localObject1).exists();
      arrayOfBoolean = new boolean[1];
      if ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString))) {
        break label596;
      }
      ReportUtil.g();
      ImageMemoryManager.getInstance().clear();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("parseVideoMaterial back? : ");
        if (FlowCameraConstant.jdField_a_of_type_Int != 2) {
          break label585;
        }
        bool1 = true;
        QLog.d("EffectsCameraCaptureView", 2, bool1);
      }
      if (FlowCameraConstant.jdField_a_of_type_Int != 2) {
        break label591;
      }
      j = 1;
      label254:
      if (j == 0) {
        break label658;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EffectsCameraCaptureView", 2, "parseVideoMaterial file : " + ((File)localObject1).getAbsolutePath());
      }
      if (!bool2) {
        break label658;
      }
    }
    label658:
    for (localObject1 = "paramsback";; localObject1 = "params")
    {
      localObject1 = TemplateParser.a(this.jdField_a_of_type_JavaLangString, (String)localObject1);
      ((QQVideoMaterial)localObject1).setDataPath(this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("EffectsCameraCaptureView", 2, "parseVideoMaterial  tempMaterail type: " + ((QQVideoMaterial)localObject1).getShaderType() + " patternPath=" + this.jdField_a_of_type_JavaLangString);
      }
      if (EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView).jdField_a_of_type_Int == 1) {
        ((QQVideoMaterial)localObject1).jdField_a_of_type_Boolean = false;
      }
      localObject2 = VideoFilterUtil.a((QQVideoMaterial)localObject1);
      if ((QLog.isColorLevel()) && (localObject2 != null) && (((VideoFilterList)localObject2).a() != null)) {
        QLog.d("EffectsCameraCaptureView", 2, "createFilters = " + ((VideoFilterList)localObject2).a().size() + " tempMaterail getShaderType=" + ((QQVideoMaterial)localObject1).getShaderType());
      }
      if (localObject2 != null) {
        i = ((QQVideoMaterial)localObject1).getTriggerType();
      }
      for (;;)
      {
        j = i;
        if (!VideoMaterialUtil.isActionTriggerType(i)) {
          j = ((QQVideoMaterial)localObject1).getTriggerType();
        }
        ReportUtil.jdField_a_of_type_JavaLangString = ((QQVideoMaterial)localObject1).getId();
        for (;;)
        {
          l = (SystemClock.elapsedRealtime() - l) / 1000L;
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[setVideoFilter_parser=" + l / 1000.0D + "ms]");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.a != null) {
            break label611;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.w("PtvFilterUtils", 2, "mQQFilterRenderManager == null");
          return;
          EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView).a();
          break label110;
          label585:
          bool1 = false;
          break label229;
          label591:
          j = 0;
          break label254;
          label596:
          ReportUtil.jdField_a_of_type_JavaLangString = null;
          localObject1 = null;
          localObject2 = null;
          j = i;
        }
        label611:
        QQFilterRenderManager localQQFilterRenderManager = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.a;
        int k = arrayOfBoolean[0];
        EffectsCameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView, new ahqu(this, (QQVideoMaterial)localObject1, localQQFilterRenderManager, (VideoFilterList)localObject2, (QQVideoMaterial)localObject1, bool2, k, j));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahqt
 * JD-Core Version:    0.7.0.1
 */