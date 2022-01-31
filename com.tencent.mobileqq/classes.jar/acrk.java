import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class acrk
  extends FMObserver
{
  public acrk(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    super.a(paramInt, paramLong, paramString);
    FileManagerUtil.a(paramLong, paramInt, paramString);
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    super.a(paramLong, paramString1, paramInt, paramString2);
    FileManagerUtil.a(paramLong);
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    if (paramThumbnailInfo == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
      } while (!(paramThumbnailInfo.a instanceof FileManagerEntity));
      localFileManagerEntity = (FileManagerEntity)paramThumbnailInfo.a;
    } while ((paramThumbnailInfo.b == null) || (paramThumbnailInfo.b.length() <= 0));
    localFileManagerEntity.strThumbPath = paramThumbnailInfo.b;
    QfileBaseLocalFileTabView.a(this.a).a().c(localFileManagerEntity);
    this.a.i();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseLocalFileTabView.a(this.a, new acrl(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    QfileBaseLocalFileTabView.b(this.a, new acrm(this, paramLong2, paramBoolean, paramInt2, paramString2));
  }
  
  protected void b()
  {
    super.b();
    QfileBaseLocalFileTabView.c(this.a, new acrn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acrk
 * JD-Core Version:    0.7.0.1
 */