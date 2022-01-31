import android.os.Handler;
import com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipUploadRusult.StoryVideoExtRsp;
import com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipUploadRusult.UploadPicExtInfo;
import com.tencent.mobileqq.arcard.ARBlessWordFragment;
import com.tencent.mobileqq.arcard.ARRelationShipFileUpload.ARRelationShipFileUploadCallBack;

public class aaee
  implements ARRelationShipFileUpload.ARRelationShipFileUploadCallBack
{
  public aaee(ARBlessWordFragment paramARBlessWordFragment) {}
  
  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void a(String paramString)
  {
    ARBlessWordFragment.a(this.a).post(new aaeg(this));
  }
  
  public void a(String paramString, ARRelationShipUploadRusult.StoryVideoExtRsp paramStoryVideoExtRsp) {}
  
  public void a(String paramString, ARRelationShipUploadRusult.UploadPicExtInfo paramUploadPicExtInfo)
  {
    ARBlessWordFragment.a(this.a).post(new aaef(this, paramUploadPicExtInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aaee
 * JD-Core Version:    0.7.0.1
 */