import com.tencent.mobileqq.activity.photo.album.PhotoPreviewBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicBase;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewAdapter;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewPresent;
import com.tencent.mobileqq.activity.photo.album.preview.PreviewBean;
import java.io.File;

public class akwh
  extends BasePreviewAdapter
{
  public akwh(PhotoPreviewLogicBase paramPhotoPreviewLogicBase)
  {
    super(paramPhotoPreviewLogicBase);
  }
  
  public BasePreviewPresent generatePreviewPresent(PreviewBean paramPreviewBean)
  {
    if ((this.mPhotoPreviewData.canUseURL) && (bhkd.isNetUrl(paramPreviewBean.getPath()))) {
      return new akwj(paramPreviewBean);
    }
    String str = paramPreviewBean.getPath();
    if ((str != null) && (new File(str).exists()) && (paramPreviewBean.mMediaType == 1)) {
      return new akwi(paramPreviewBean);
    }
    return super.generatePreviewPresent(paramPreviewBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwh
 * JD-Core Version:    0.7.0.1
 */