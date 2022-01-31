import android.os.Handler;
import com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipUploadRusult.StoryVideoExtRsp;
import com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipUploadRusult.UploadPicExtInfo;
import com.tencent.mobileqq.arcard.ARRelationShipFileUpload.ARRelationShipFileUploadCallBack;
import com.tencent.mobileqq.arcard.ARVideoPreviewActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;

class aatz
  implements ARRelationShipFileUpload.ARRelationShipFileUploadCallBack
{
  aatz(aatw paramaatw) {}
  
  public void a(int paramInt)
  {
    this.a.a.a(1, paramInt);
  }
  
  public void a(String paramString)
  {
    ARVideoPreviewActivity.a(this.a.a).post(new aaua(this));
  }
  
  public void a(String paramString, ARRelationShipUploadRusult.StoryVideoExtRsp paramStoryVideoExtRsp) {}
  
  public void a(String paramString, ARRelationShipUploadRusult.UploadPicExtInfo paramUploadPicExtInfo)
  {
    paramString = paramUploadPicExtInfo.bytes_download_url.get().toStringUtf8();
    this.a.a.a(1, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aatz
 * JD-Core Version:    0.7.0.1
 */