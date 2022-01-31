import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.TroopHomeworkHelper.UploadCallback;
import mqq.os.MqqHandler;

public class ajkh
  implements TroopHomeworkHelper.UploadCallback
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
  public ajkh(ImageInfo.UploadMediaSegment paramUploadMediaSegment)
  {
    switch (ImageInfo.UploadMediaSegment.a(paramUploadMediaSegment))
    {
    default: 
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Float = 1.0F;
      return;
    case 1: 
      this.jdField_a_of_type_Int = 10;
      this.jdField_a_of_type_Float = 0.85F;
      return;
    }
    this.jdField_a_of_type_Int = 95;
    this.jdField_a_of_type_Float = 0.05F;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment.isCanceled())
    {
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress cancel. progress=", Integer.valueOf(paramInt) });
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment.onCancel();
    }
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress. mediaType=", Integer.valueOf(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment)), ", info hash=", Integer.valueOf(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment).hashCode()), ", info status=", Integer.valueOf(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment).g), ", progress=", Integer.valueOf(paramInt) });
      }
      l = System.currentTimeMillis();
      paramInt = this.jdField_a_of_type_Int + (int)(this.jdField_a_of_type_Float * paramInt);
    } while ((paramInt >= 100) || (l - this.jdField_a_of_type_Long <= 500L));
    this.jdField_a_of_type_Long = l;
    ThreadManager.getUIHandler().post(new ajkj(this, paramInt));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment.isCanceled())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment.onCancel();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onComplete. mediaType=", Integer.valueOf(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment)), ", info hash=", Integer.valueOf(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment).hashCode()), ", info status=", Integer.valueOf(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment).g) });
    }
    switch (ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment))
    {
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment.isCanceled())
    {
      ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment, ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment));
      return;
      VideoInfo localVideoInfo = (VideoInfo)ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment);
      localVideoInfo.e = paramString;
      ThreadManager.getUIHandler().post(new ajki(this, localVideoInfo));
      continue;
      ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment).b = paramString;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment.onCancel();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e(getClass().getSimpleName(), 2, new Object[] { "upload onError. errorCode=", Integer.valueOf(paramInt), ", info type=", Integer.valueOf(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment).b()), ", mediaType=", Integer.valueOf(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment)) });
    }
    if (ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment) == 2)
    {
      ImageInfo.UploadMediaSegment.b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment, ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment));
      return;
    }
    ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment, new Error("-3"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkh
 * JD-Core Version:    0.7.0.1
 */