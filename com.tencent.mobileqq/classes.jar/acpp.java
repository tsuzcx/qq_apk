import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class acpp
  extends FMObserver
{
  public acpp(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    if (paramThumbnailInfo == null) {}
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        return;
        if (!(paramThumbnailInfo.a instanceof FileManagerEntity)) {
          break;
        }
        localFileManagerEntity = (FileManagerEntity)paramThumbnailInfo.a;
      } while ((paramThumbnailInfo.b == null) || (paramThumbnailInfo.b.length() <= 0));
      localFileManagerEntity.strThumbPath = paramThumbnailInfo.b;
      QfileBaseCloudFileTabView.j(this.a).a().c(localFileManagerEntity);
      this.a.i();
      return;
    } while (!(paramThumbnailInfo.a instanceof WeiYunFileInfo));
    this.a.i();
  }
  
  protected void a(String paramString1, String paramString2, Integer paramInteger, String paramString3, boolean paramBoolean)
  {
    FMDataCache.a(paramString1);
    FileManagerUtil.a(paramInteger.intValue(), paramString2);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(false);
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = FMDataCache.a(paramString1);
    if ((!this.a.b(paramString2)) && (this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramString2 = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString2.hasNext())
      {
        WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)paramString2.next();
        if (localWeiYunFileInfo.a.equalsIgnoreCase(paramString1) == true) {
          this.a.b(localWeiYunFileInfo);
        }
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseCloudFileTabView.a(this.a, new acpq(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    QfileBaseCloudFileTabView.b(this.a, new acpr(this, paramLong2));
  }
  
  protected void b()
  {
    super.b();
    QfileBaseCloudFileTabView.c(this.a, new acps(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acpp
 * JD-Core Version:    0.7.0.1
 */