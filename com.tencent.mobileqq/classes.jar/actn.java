import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;

public class actn
  extends FMObserver
{
  public actn(QfileRecentPicFileTabView paramQfileRecentPicFileTabView) {}
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    super.a(paramThumbnailInfo);
    if ((paramThumbnailInfo.b != null) && (paramThumbnailInfo.b.length() > 0)) {
      this.a.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     actn
 * JD-Core Version:    0.7.0.1
 */