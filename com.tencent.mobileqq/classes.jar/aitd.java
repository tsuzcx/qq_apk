import com.tencent.biz.qqstory.base.videoupload.UploadResult;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject.UploadFinishListener;
import com.tencent.mobileqq.tribe.videoupload.TribeVideoFileObject;
import com.tencent.mobileqq.tribe.videoupload.TribeVideoTaskInfo;
import com.tencent.mobileqq.tribe.videoupload.TribeVideoUploadTask;

public class aitd
  implements UploadObject.UploadFinishListener
{
  public aitd(TribeVideoUploadTask paramTribeVideoUploadTask, TribeVideoTaskInfo paramTribeVideoTaskInfo) {}
  
  public void a(UploadObject paramUploadObject)
  {
    paramUploadObject = (TribeVideoFileObject)paramUploadObject;
    this.jdField_a_of_type_ComTencentMobileqqTribeVideouploadTribeVideoTaskInfo.b = paramUploadObject.a.c;
    this.jdField_a_of_type_ComTencentMobileqqTribeVideouploadTribeVideoTaskInfo.c = paramUploadObject.a.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitd
 * JD-Core Version:    0.7.0.1
 */