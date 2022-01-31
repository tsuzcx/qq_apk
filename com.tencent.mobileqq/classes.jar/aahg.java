import android.graphics.Rect;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.mobileqq.ar.ARDebugReport;
import com.tencent.mobileqq.ar.DrawView2.FaceData;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceActInfo;
import com.tencent.mobileqq.ar.arengine.ARFaceDataCollector;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.ARLocalFaceRecogCallback;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.FaceInfo;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecogResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aahg
  implements Handler.Callback
{
  public aahg(ARLocalFaceRecog paramARLocalFaceRecog) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    long l1;
    long l2;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    int i;
    label281:
    Object localObject5;
    Object localObject6;
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return false;
    case 1: 
      l1 = System.currentTimeMillis();
      this.a.jdField_e_of_type_Boolean = true;
      paramMessage = (byte[])paramMessage.obj;
      int j = 0;
      l2 = SystemClock.uptimeMillis();
      ??? = this.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.detectFace(paramMessage, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
      l2 = SystemClock.uptimeMillis() - l2;
      ARFaceDataCollector.b(l2);
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  detectFace[TimeCost] = " + l2);
      }
      if ((??? != null) && (???.length > 0) && (QLog.isColorLevel())) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  detectFaceCount = " + ???.length);
      }
      localObject2 = this.a.a((FaceStatus[])???);
      if ((localObject2 != null) && (localObject2.length > 0) && (!this.a.jdField_c_of_type_Boolean))
      {
        j = localObject2.length;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  detectFaceCount = " + j);
        }
        localObject3 = new float[j][];
        localObject4 = new float[j][];
        ??? = this.a.jdField_a_of_type_JavaLangObject;
        i = 0;
        if (i < j) {}
        try
        {
          if (this.a.a(this.a.jdField_a_of_type_JavaUtilList, localObject2[i])) {
            break;
          }
          localObject5 = new ARLocalFaceRecog.FaceInfo();
          ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_Boolean = true;
          ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_b_of_type_Int = this.a.jdField_f_of_type_Int;
          localObject6 = this.a;
          ((ARLocalFaceRecog)localObject6).jdField_f_of_type_Int += 1;
          ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = localObject2[i];
          this.a.jdField_b_of_type_JavaUtilList.add(localObject5);
          localObject3[i] = localObject2[i].xys;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  add a tempFace ,faceInfo.faceID = " + ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_b_of_type_Int);
        }
        finally {}
        if ((this.a.jdField_b_of_type_AndroidOsHandler != null) && (this.a.jdField_b_of_type_AndroidOsHandler.hasMessages(1))) {
          this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
        }
        paramMessage = Message.obtain(this.a.jdField_b_of_type_AndroidOsHandler, new aahh(this, j, (float[][])localObject3, (float[][])localObject4, paramMessage));
        paramMessage.what = 1;
        i = j;
        if (this.a.jdField_b_of_type_AndroidOsHandler != null)
        {
          this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(paramMessage);
          i = j;
        }
      }
      for (;;)
      {
        l2 = System.currentTimeMillis();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE finish, faceCount = " + i + ",recoverMsgExeCost = " + (l2 - l1));
        break;
        this.a.jdField_e_of_type_Boolean = false;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  detect no face");
          i = j;
        }
      }
    case 3: 
      if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE start");
      }
      l1 = System.currentTimeMillis();
      this.a.jdField_f_of_type_Boolean = true;
      localObject2 = (byte[])paramMessage.obj;
      paramMessage = new ArrayList();
      synchronized (this.a.jdField_a_of_type_JavaLangObject)
      {
        localObject3 = this.a.jdField_a_of_type_JavaUtilList.iterator();
        label685:
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break label1363;
          }
          localObject4 = (ARLocalFaceRecog.FaceInfo)((Iterator)localObject3).next();
          if (!((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_Boolean) {
            break label1243;
          }
          if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE realFace start ");
          }
          l2 = SystemClock.uptimeMillis();
          i = this.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.trackSingleFace2((byte[])localObject2, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus, this.a.jdField_c_of_type_Int);
          l2 = SystemClock.uptimeMillis() - l2;
          if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean))
          {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE realFace,trackSingeFace[TimeCost] = " + l2);
            ARDebugReport.a().e(l2);
          }
          if (i == 0) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Lost realFace  faceInfo.lostCount = " + ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_c_of_type_Int);
          }
          ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_c_of_type_Int += 1;
        } while (((ARLocalFaceRecog.FaceInfo)localObject4).jdField_c_of_type_Int <= 0);
        ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_Boolean = false;
        ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_c_of_type_Int = 0;
        localObject4 = this.a;
        ((ARLocalFaceRecog)localObject4).d += 1;
      }
      ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_c_of_type_Int = 0;
      if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Track realFace success,update");
      }
      localObject5 = new DrawView2.FaceData();
      ((DrawView2.FaceData)localObject5).jdField_a_of_type_ArrayOfFloat = ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys;
      ((DrawView2.FaceData)localObject5).jdField_a_of_type_JavaLangString = ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_JavaLangString;
      ((DrawView2.FaceData)localObject5).jdField_a_of_type_AndroidGraphicsRect = new Rect(((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.x, ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.y, ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.x + ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.width, ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.y + ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.height);
      ((DrawView2.FaceData)localObject5).jdField_a_of_type_AndroidGraphicsRectF = DrawView2.FaceData.a(((DrawView2.FaceData)localObject5).jdField_a_of_type_AndroidGraphicsRect, ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys);
      ((DrawView2.FaceData)localObject5).jdField_a_of_type_Int = ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_b_of_type_Int;
      ((DrawView2.FaceData)localObject5).jdField_c_of_type_JavaLangString = ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_b_of_type_JavaLangString;
      ((DrawView2.FaceData)localObject5).jdField_b_of_type_JavaLangString = ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_c_of_type_JavaLangString;
      ((DrawView2.FaceData)localObject5).g = ((ARLocalFaceRecog.FaceInfo)localObject4).f;
      if (((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_Int != 2) {}
      break;
    }
    for (boolean bool = true;; bool = false)
    {
      ((DrawView2.FaceData)localObject5).jdField_b_of_type_Boolean = bool;
      if (((DrawView2.FaceData)localObject5).jdField_b_of_type_Boolean)
      {
        ((DrawView2.FaceData)localObject5).jdField_c_of_type_Boolean = this.a.a(((DrawView2.FaceData)localObject5).jdField_b_of_type_JavaLangString);
        if (((DrawView2.FaceData)localObject5).jdField_c_of_type_Boolean)
        {
          localObject6 = this.a.a(((DrawView2.FaceData)localObject5).jdField_b_of_type_JavaLangString);
          if (localObject6 != null)
          {
            ((DrawView2.FaceData)localObject5).h = ((ARScanStarFaceActInfo)localObject6).f;
            ((DrawView2.FaceData)localObject5).f = ((ARScanStarFaceActInfo)localObject6).jdField_e_of_type_JavaLangString;
          }
        }
        ((DrawView2.FaceData)localObject5).d = ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_e_of_type_JavaLangString;
        ((DrawView2.FaceData)localObject5).jdField_e_of_type_JavaLangString = ((ARLocalFaceRecog.FaceInfo)localObject4).d;
      }
      ((DrawView2.FaceData)localObject5).jdField_a_of_type_Float = ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_Float;
      paramMessage.add(localObject5);
      break label685;
      label1243:
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Try to recover realFace, isRecovering = " + this.a.jdField_e_of_type_Boolean);
      }
      if ((this.a.jdField_e_of_type_Boolean) || (this.a.jdField_c_of_type_Boolean)) {
        break label685;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Send Recover Msg");
      }
      if (ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
      localObject4 = Message.obtain();
      ((Message)localObject4).what = 1;
      ((Message)localObject4).obj = localObject2;
      ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject4);
      break label685;
      label1363:
      localObject3 = this.a.jdField_b_of_type_JavaUtilList.iterator();
      long l3;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ARLocalFaceRecog.FaceInfo)((Iterator)localObject3).next();
        if (((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_Boolean)
        {
          if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE tmpFace trackSingeFace start");
          }
          l2 = SystemClock.uptimeMillis();
          i = this.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.trackSingleFace2((byte[])localObject2, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus, this.a.jdField_c_of_type_Int);
          l3 = SystemClock.uptimeMillis();
          if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE [TimeCost] tmpFace trackSingeFace = " + (l3 - l2));
          }
          if (i != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Lost tmpFace");
            }
            ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_Boolean = false;
            ((Iterator)localObject3).remove();
          }
          else
          {
            if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
              QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Track tmpFace success,update ,faceInfo.faceID = " + ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_b_of_type_Int);
            }
            localObject5 = new DrawView2.FaceData();
            ((DrawView2.FaceData)localObject5).jdField_a_of_type_ArrayOfFloat = ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys;
            ((DrawView2.FaceData)localObject5).jdField_a_of_type_JavaLangString = ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_JavaLangString;
            ((DrawView2.FaceData)localObject5).jdField_a_of_type_Int = ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_b_of_type_Int;
            ((DrawView2.FaceData)localObject5).jdField_a_of_type_AndroidGraphicsRect = new Rect(((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.x, ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.y, ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.x + ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.width, ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.y + ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.height);
            ((DrawView2.FaceData)localObject5).jdField_a_of_type_AndroidGraphicsRectF = DrawView2.FaceData.a(((DrawView2.FaceData)localObject5).jdField_a_of_type_AndroidGraphicsRect, ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys);
            ((DrawView2.FaceData)localObject5).jdField_e_of_type_Boolean = true;
            paramMessage.add(localObject5);
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE  tmpFace not tracked ,error!");
        }
      }
      l2 = System.currentTimeMillis();
      if ((!this.a.jdField_c_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$ARLocalFaceRecogCallback != null))
      {
        ??? = new ARLocalFaceRecogResult();
        ((ARLocalFaceRecogResult)???).jdField_a_of_type_JavaUtilArrayList = paramMessage;
        ((ARLocalFaceRecogResult)???).jdField_a_of_type_Long = this.a.jdField_b_of_type_Long;
        this.a.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$ARLocalFaceRecogCallback.a((ARLocalFaceRecogResult)???);
        if ((this.a.jdField_c_of_type_Long > 0L) && (paramMessage.size() > 0))
        {
          l3 = System.currentTimeMillis() - this.a.jdField_c_of_type_Long;
          ARFaceDataCollector.a().f = l3;
          ARFaceDataCollector.c();
          this.a.jdField_c_of_type_Long = -1L;
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face] MSG_TRACK_FACE update UI,firstlocalRecogCost = " + l3);
          }
        }
      }
      this.a.jdField_f_of_type_Boolean = false;
      if ((!QLog.isColorLevel()) || (!ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
        break;
      }
      QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE finish, dataSize = " + paramMessage.size() + ",trackMsgExeCost = " + (l2 - l1) + ",curTrackFrameIndex = " + this.a.jdField_b_of_type_Long + ",mIsPause = " + this.a.jdField_c_of_type_Boolean);
      break;
      i += 1;
      break label281;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aahg
 * JD-Core Version:    0.7.0.1
 */