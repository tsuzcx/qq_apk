import android.os.Handler;
import android.os.SystemClock;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.mobileqq.ar.ARDebugReport;
import com.tencent.mobileqq.ar.arengine.ARFaceDataCollector;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.FaceInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

class aahh
  implements Runnable
{
  aahh(aahg paramaahg, int paramInt, float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE start ");
    }
    int i = 0;
    if (i < this.jdField_a_of_type_Int)
    {
      if ((this.jdField_a_of_type_Array2dOfFloat[i] != null) && (!this.jdField_a_of_type_Aahg.a.jdField_c_of_type_Boolean))
      {
        long l = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]SUB_MSG_EXTRACT_FACE_FEATRUE  calcuFaceFeature start ");
        }
        this.b[i] = this.jdField_a_of_type_Aahg.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.calcuFaceFeature(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Aahg.a.jdField_a_of_type_Int, this.jdField_a_of_type_Aahg.a.jdField_b_of_type_Int, this.jdField_a_of_type_Array2dOfFloat[i], this.jdField_a_of_type_Aahg.a.jdField_c_of_type_Int);
        l = SystemClock.uptimeMillis() - l;
        ARFaceDataCollector.c(l);
        if (QLog.isColorLevel())
        {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]SUB_MSG_EXTRACT_FACE_FEATRUE  calcuFaceFeature[TimeCost] = " + l);
          ARDebugReport.a().d(l);
          if (this.b[i] != null) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "  calcuFaceFeature feature = " + Arrays.toString(this.b[i]));
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  faceShape is null i = " + i);
        }
      }
    }
    for (;;)
    {
      ARLocalFaceRecog.FaceInfo localFaceInfo1;
      ARLocalFaceRecog.FaceInfo localFaceInfo2;
      synchronized (this.jdField_a_of_type_Aahg.a.jdField_a_of_type_JavaLangObject)
      {
        Object localObject2 = this.jdField_a_of_type_Aahg.a.jdField_a_of_type_JavaUtilList;
        i = ((List)localObject2).size();
        if ((i > 0) && (!this.jdField_a_of_type_Aahg.a.jdField_c_of_type_Boolean))
        {
          if (i != 1) {
            continue;
          }
          localObject2 = (ARLocalFaceRecog.FaceInfo)((List)localObject2).get(0);
          if ((this.jdField_a_of_type_Aahg.a.a((ARLocalFaceRecog.FaceInfo)localObject2, this.b, this.jdField_a_of_type_Array2dOfFloat)) && (ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
            ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          }
        }
        this.jdField_a_of_type_Aahg.a.jdField_b_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_Aahg.a.f = 10;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE end ,clear tmpFace");
        }
        this.jdField_a_of_type_Aahg.a.e = false;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  finish");
        }
        return;
        if (i != 2) {
          continue;
        }
        localFaceInfo1 = (ARLocalFaceRecog.FaceInfo)((List)localObject2).get(0);
        localFaceInfo2 = (ARLocalFaceRecog.FaceInfo)((List)localObject2).get(1);
        if ((!localFaceInfo1.jdField_a_of_type_Boolean) && (localFaceInfo2.jdField_a_of_type_Boolean))
        {
          if ((!this.jdField_a_of_type_Aahg.a.a(localFaceInfo1, this.b, this.jdField_a_of_type_Array2dOfFloat)) || (!ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
            continue;
          }
          ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
      }
      if ((localFaceInfo1.jdField_a_of_type_Boolean) && (!localFaceInfo2.jdField_a_of_type_Boolean))
      {
        if ((this.jdField_a_of_type_Aahg.a.a(localFaceInfo2, this.b, this.jdField_a_of_type_Array2dOfFloat)) && (ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
          ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
      }
      else if ((!localFaceInfo1.jdField_a_of_type_Boolean) && (!localFaceInfo2.jdField_a_of_type_Boolean))
      {
        i = this.jdField_a_of_type_Aahg.a.a(this.b, localFaceInfo1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
        int j = this.jdField_a_of_type_Aahg.a.a(this.b, localFaceInfo2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
        if ((i < 0) && (j < 0)) {}
        for (;;)
        {
          if ((!this.jdField_a_of_type_Aahg.a.a(localList)) || (!ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
            break label1024;
          }
          ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          break;
          if ((i >= 0) && (j < 0))
          {
            localFaceInfo1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[i];
            localFaceInfo1.jdField_a_of_type_Boolean = true;
          }
          else if ((i < 0) && (j >= 0))
          {
            localFaceInfo2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[j];
            localFaceInfo2.jdField_a_of_type_Boolean = true;
          }
          else if (i == j)
          {
            float f1 = this.jdField_a_of_type_Aahg.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.calcuSimilarity(this.b[i], localFaceInfo1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
            float f2 = this.jdField_a_of_type_Aahg.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.calcuSimilarity(this.b[j], localFaceInfo2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  similarity1  = " + f1 + ",similarity2 = " + f2);
            }
            if (f1 > f2)
            {
              localFaceInfo1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[i];
              localFaceInfo1.jdField_a_of_type_Boolean = true;
              this.b[i] = null;
              this.jdField_a_of_type_Aahg.a.a(localFaceInfo2, this.b, this.jdField_a_of_type_Array2dOfFloat);
            }
            else
            {
              localFaceInfo2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[j];
              localFaceInfo2.jdField_a_of_type_Boolean = true;
              this.b[j] = null;
              this.jdField_a_of_type_Aahg.a.a(localFaceInfo1, this.b, this.jdField_a_of_type_Array2dOfFloat);
            }
          }
          else
          {
            localFaceInfo1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[i];
            localFaceInfo1.jdField_a_of_type_Boolean = true;
            localFaceInfo2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[j];
            localFaceInfo2.jdField_a_of_type_Boolean = true;
          }
        }
      }
      else
      {
        label1024:
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  calc error status");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aahh
 * JD-Core Version:    0.7.0.1
 */