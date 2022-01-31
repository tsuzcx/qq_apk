import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class acsi
  extends FMObserver
{
  public acsi(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    super.a(paramInt, paramLong, paramString);
    FileManagerUtil.a(paramLong, paramInt, paramString);
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = QfileBaseRecentFileTabView.F(this.a).a().a(paramLong1, paramString, paramInt, paramLong2);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseRecentFileTabView.a, 2, "OnFileCome,but query FileEntity null,uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + "], strUin[" + FileManagerUtil.e(paramString) + "], peerType[" + paramInt + "]");
      }
      return;
    }
    this.a.b(localFileManagerEntity);
    QfileBaseRecentFileTabView.G(this.a).a().c(localFileManagerEntity);
    QfileBaseRecentFileTabView.d(this.a, new acsl(this));
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    super.a(paramLong, paramString1, paramInt, paramString2);
    FileManagerUtil.a(paramLong);
    this.a.i();
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
    QfileBaseRecentFileTabView.B(this.a).a().c(localFileManagerEntity);
    this.a.i();
  }
  
  protected void a(Boolean paramBoolean, List paramList)
  {
    QfileBaseRecentFileTabView.a(this.a, paramBoolean, paramList);
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    QfileBaseRecentFileTabView.e(this.a, new acsm(this));
    FileManagerUtil.a(paramLong, paramInteger.intValue(), paramString);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseRecentFileTabView.b(this.a, new acsj(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    FileManagerEntity localFileManagerEntity = QfileBaseRecentFileTabView.C(this.a).a().a(paramLong1, paramString1, paramInt1, paramLong2);
    if (localFileManagerEntity == null)
    {
      QLog.e(QfileBaseRecentFileTabView.a, 1, "OnFileCome,but query FileEntity null,uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + "], strUin[" + FileManagerUtil.e(paramString1) + "], peerType[" + paramInt1 + "]");
      return;
    }
    if (!paramBoolean)
    {
      localFileManagerEntity.bDelInFM = false;
      FileManagerUtil.a(paramLong2, paramInt2, paramString2);
    }
    for (;;)
    {
      if ((this.a.b == null) || (this.a.b.trim().length() == 0) || (localFileManagerEntity.getCloudType() != 2)) {
        this.a.b(localFileManagerEntity);
      }
      QfileBaseRecentFileTabView.D(this.a).a().c(localFileManagerEntity);
      QfileBaseRecentFileTabView.c(this.a, new acsk(this, paramLong2));
      return;
      paramInt1 = localFileManagerEntity.nOpType;
      if ((paramInt1 == 4) || (paramInt1 == 20) || (paramInt1 == 6)) {
        FileManagerUtil.a(paramLong2);
      }
    }
  }
  
  protected void b()
  {
    super.b();
    QfileBaseRecentFileTabView.f(this.a, new acsn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acsi
 * JD-Core Version:    0.7.0.1
 */