import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.VideoSliceInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class aidm
  implements Runnable
{
  public aidm(ShortVideoUploadProcessor paramShortVideoUploadProcessor, VideoSliceInfo paramVideoSliceInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> submitFollowedSlice");
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor)
    {
      if (ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) != 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> submitFollowedSlice mSwitch != SWITCH_PRE_UPLOAD  mSwitch : " + ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor));
        }
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo == null) {
        return;
      }
    }
    if ((ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) == 1) || (ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) == 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> submitFollowedSlice mVideoPreUpStatus = " + ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) + " mVideoRecordStatus = " + ShortVideoUploadProcessor.c(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor));
      }
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_a_of_type_JavaLangString.length() != 0) && (this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_b_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_b_of_type_JavaLangString.length() != 0))
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_a_of_type_JavaLangString;
      int i = (int)new File((String)localObject2).length();
      int j = this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_b_of_type_Int;
      int k = this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_a_of_type_Int;
      int m = this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.d;
      int n = this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_c_of_type_Int;
      localObject3 = HexUtil.hexStr2Bytes(this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.a((String)localObject2, i, this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_ArrayOfByte, (byte[])localObject3, k, m, n, j);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> submitFollowedSlice  info.mEncodeFinish = " + this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_a_of_type_Boolean + " info.mSendClicked = " + this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_b_of_type_Boolean + " mEncodeFinish = " + this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + " mSendClicked = " + this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + " mVideoPreUpStatus = " + ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) == 0)
      {
        if (!ShortVideoUploadProcessor.jdField_a_of_type_Boolean) {
          break label602;
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo, this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_JavaUtilList);
        ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, 3);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_c_of_type_JavaUtilList.isEmpty()) || (ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) != 0)) {
          break label657;
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo, this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_JavaUtilList);
        ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, 3);
      }
    }
    label602:
    while (ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) != 4)
    {
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_c_of_type_JavaUtilList.isEmpty()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo, this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_JavaUtilList);
      ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, 3);
      break;
    }
    label657:
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    ShortVideoUploadProcessor localShortVideoUploadProcessor2 = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor;
    long l = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.q;
    localShortVideoUploadProcessor2.s = l;
    ((FileMsg)localObject3).e = l;
    ((FileMsg)localObject2).a = l;
    ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_c_of_type_Boolean);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> submitFollowedSlice mNeedSyncStory = " + ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor));
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.d(1007);
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.b(false);
    l = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.get("param_cost_s_store") != null) {
      l = Long.valueOf((String)this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.get("param_cost_s_store")).longValue();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.get("param_cost_s_store") != null) {}
    for (localObject2 = (String)this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.get("param_cost_s_store");; localObject2 = String.valueOf(0))
    {
      ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, true, l, (String)localObject2);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aidm
 * JD-Core Version:    0.7.0.1
 */