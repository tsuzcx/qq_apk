import android.app.Activity;
import com.tencent.common.galleryactivity.AbstractAnimationManager;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.AbstractImageListScene;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.mobileqq.campuscircle.CampusCirclePicBrowserActivity;
import com.tencent.mobileqq.campuscircle.CampusCirclePicBrowserGalleryScene;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserModel;

public class abij
  extends GalleryManager
{
  public abij(CampusCirclePicBrowserActivity paramCampusCirclePicBrowserActivity) {}
  
  public AbstractAnimationManager a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return super.a(paramActivity, paramAbstractImageListModel);
  }
  
  public AbstractGalleryScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    this.a.a = new CampusCirclePicBrowserGalleryScene((CampusCirclePicBrowserActivity)paramActivity, paramAbstractImageListModel);
    return this.a.a;
  }
  
  public AbstractImageListModel a(Activity paramActivity)
  {
    paramActivity = new PicBrowserModel(this.a, CampusCirclePicBrowserActivity.a(this.a));
    paramActivity.a(CampusCirclePicBrowserActivity.a(this.a));
    return paramActivity;
  }
  
  public AbstractImageListScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abij
 * JD-Core Version:    0.7.0.1
 */