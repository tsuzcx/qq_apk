import com.tencent.mobileqq.activity.photo.album.PhotoPreviewBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicBase;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewAdapter;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewPresent;
import com.tencent.mobileqq.activity.photo.album.preview.PreviewBean;
import com.tencent.mobileqq.utils.AlbumUtil;
import java.io.File;

public class ajty
  extends BasePreviewAdapter
{
  public ajty(PhotoPreviewLogicBase paramPhotoPreviewLogicBase)
  {
    super(paramPhotoPreviewLogicBase);
  }
  
  public BasePreviewPresent generatePreviewPresent(PreviewBean paramPreviewBean)
  {
    if ((this.mPhotoPreviewData.canUseURL) && (AlbumUtil.isNetUrl(paramPreviewBean.getPath()))) {
      return new ajua(paramPreviewBean);
    }
    String str = paramPreviewBean.getPath();
    if ((str != null) && (new File(str).exists()) && (paramPreviewBean.mMediaType == 1)) {
      return new ajtz(paramPreviewBean);
    }
    return super.generatePreviewPresent(paramPreviewBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajty
 * JD-Core Version:    0.7.0.1
 */