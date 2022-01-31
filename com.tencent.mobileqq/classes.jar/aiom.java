import android.os.SystemClock;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterModule;
import com.tencent.biz.qqstory.takevideo.artfilter.FilterUploadInfo;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.transfile.ArtFilterUploadProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aiom
  implements ITransactionCallback
{
  public aiom(ArtFilterUploadProcessor paramArtFilterUploadProcessor) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    this.a.d = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (this.a.d - this.a.c) + "ms");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a = paramArrayOfByte;
    if (this.a.b != -1) {
      this.a.a(paramInt, "uploadImgError");
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    this.a.d = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (this.a.d - this.a.c) + "ms ,fileSize:" + this.a.q);
    }
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterModule.b.equals(this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterFilterUploadInfo.a))
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterModule.a = this.a.d;
      if (this.a.b != -1) {
        this.a.ao_();
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiom
 * JD-Core Version:    0.7.0.1
 */