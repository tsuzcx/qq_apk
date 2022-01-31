import com.tencent.YTFace.model.FaceStatus;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogRspFaceResult;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogRspFaceResult.StarInfo;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.FaceInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class aach
  implements Runnable
{
  public aach(ARLocalFaceRecog paramARLocalFaceRecog, ARCloudRecogRspFaceResult paramARCloudRecogRspFaceResult, long paramLong) {}
  
  public void run()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.b.clear();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.f = 10;
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult;
      if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult == null) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus == null)) {}
    }
    for (;;)
    {
      int i;
      ARLocalFaceRecog.FaceInfo localFaceInfo;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length > 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult);
          long l1 = System.currentTimeMillis();
          long l2 = this.jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face][ScanStarFace]addFaceCloudRecogResult finish,totalFaceList = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.jdField_a_of_type_JavaUtilList + ",addFaceClouDResultCost = " + (l1 - l2));
          }
          this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.c = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.d = false;
          return;
          localObject2 = finally;
          throw localObject2;
        }
        i = 0;
        if (i >= this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length) {
          continue;
        }
        FaceStatus localFaceStatus = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]addFaceCloudRecogResult faceFeature = " + Arrays.toString(localFaceStatus.feature));
        }
        localFaceInfo = new ARLocalFaceRecog.FaceInfo();
        localFaceInfo.jdField_a_of_type_Int = 1;
        localFaceInfo.jdField_a_of_type_JavaLangString = "";
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult.jdField_a_of_type_JavaUtilArrayList != null)
        {
          Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (localIterator.hasNext())
          {
            ARCloudRecogRspFaceResult.StarInfo localStarInfo = (ARCloudRecogRspFaceResult.StarInfo)localIterator.next();
            if (localStarInfo.jdField_a_of_type_Int != i) {
              continue;
            }
            localFaceInfo.jdField_a_of_type_Int = 2;
            localFaceInfo.jdField_a_of_type_JavaLangString = localStarInfo.jdField_a_of_type_JavaLangString;
            localFaceInfo.jdField_b_of_type_JavaLangString = localStarInfo.jdField_b_of_type_JavaLangString;
            localFaceInfo.c = String.valueOf(localStarInfo.jdField_a_of_type_Long);
            localFaceInfo.d = localStarInfo.c;
            localFaceInfo.e = localStarInfo.d;
            localFaceInfo.f = localStarInfo.e;
            localFaceInfo.jdField_a_of_type_Float = localStarInfo.jdField_a_of_type_Float;
          }
        }
      }
      localFaceInfo.jdField_a_of_type_Boolean = true;
      localFaceInfo.jdField_a_of_type_ComTencentYTFaceModelFaceStatus = localObject3;
      localFaceInfo.jdField_b_of_type_Int = i;
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog.jdField_a_of_type_JavaUtilList.add(localFaceInfo);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aach
 * JD-Core Version:    0.7.0.1
 */