import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;

public class acjq
  extends FMObserver
{
  public acjq(QfileRecentPicFileTabView paramQfileRecentPicFileTabView) {}
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    super.a(paramThumbnailInfo);
    if ((paramThumbnailInfo.b != null) && (paramThumbnailInfo.b.length() > 0)) {
      this.a.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acjq
 * JD-Core Version:    0.7.0.1
 */