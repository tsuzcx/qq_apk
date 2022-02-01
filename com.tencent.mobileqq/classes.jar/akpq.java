import com.tencent.mobileqq.activity.photo.album.PhotoPreviewBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicBase;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewAdapter;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewPresent;
import com.tencent.mobileqq.activity.photo.album.preview.PreviewBean;
import com.tencent.mobileqq.utils.AlbumUtil;
import java.io.File;

public class akpq
  extends BasePreviewAdapter
{
  public akpq(PhotoPreviewLogicBase paramPhotoPreviewLogicBase)
  {
    super(paramPhotoPreviewLogicBase);
  }
  
  public BasePreviewPresent generatePreviewPresent(PreviewBean paramPreviewBean)
  {
    if ((this.mPhotoPreviewData.canUseURL) && (AlbumUtil.isNetUrl(paramPreviewBean.getPath()))) {
      return new akps(paramPreviewBean);
    }
    String str = paramPreviewBean.getPath();
    if ((str != null) && (new File(str).exists()) && (paramPreviewBean.mMediaType == 1)) {
      return new akpr(paramPreviewBean);
    }
    return super.generatePreviewPresent(paramPreviewBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akpq
 * JD-Core Version:    0.7.0.1
 */