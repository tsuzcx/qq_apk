import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class adaz
  extends DataLineObserver
{
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public adaz(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  FileManagerEntity a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
      return (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    }
    FileManagerEntity localFileManagerEntity = QfileBaseRecentFileTabView.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView).a().a(paramLong, AppConstants.y, 6000, -1L);
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  protected void a(long paramLong, float paramFloat)
  {
    super.a(paramLong, paramFloat);
    FileManagerEntity localFileManagerEntity = a(paramLong);
    if (localFileManagerEntity == null) {
      return;
    }
    localFileManagerEntity.fProgress = paramFloat;
    QfileBaseRecentFileTabView.l(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView).a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, AppConstants.y, 6000, 16, null, 0, null);
  }
  
  protected void a(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    paramString = a(paramLong1);
    if (paramString == null) {
      return;
    }
    paramString.status = 2;
    QfileBaseRecentFileTabView.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView).a().a(paramString.uniseq, paramString.nSessionId, AppConstants.y, 6000, 10, null, 0, null);
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    Object localObject = a(paramLong);
    if (localObject == null) {
      return;
    }
    long l;
    if (paramBoolean)
    {
      ((FileManagerEntity)localObject).status = 1;
      QfileBaseRecentFileTabView.j(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView).a().c((FileManagerEntity)localObject);
      QLog.e(QfileBaseRecentFileTabView.a, 2, "FMConstants.TYPE_FILE_RECVFILE_SUCCESS in onRecvFile,entity.cloudtype:" + ((FileManagerEntity)localObject).cloudType + ",filepath:" + ((FileManagerEntity)localObject).strFilePath);
      paramString = QfileBaseRecentFileTabView.k(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView).a();
      paramLong = ((FileManagerEntity)localObject).uniseq;
      l = ((FileManagerEntity)localObject).nSessionId;
      localObject = AppConstants.y;
      if (!paramBoolean) {
        break label155;
      }
    }
    label155:
    for (int i = 11;; i = 12)
    {
      paramString.a(paramLong, l, (String)localObject, 6000, i, null, 0, null);
      return;
      ((FileManagerEntity)localObject).status = 0;
      break;
    }
  }
  
  protected void b(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    paramString = a(paramLong1);
    if (paramString == null) {
      return;
    }
    paramString.status = 2;
    QfileBaseRecentFileTabView.g(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView).a().a(paramString.uniseq, paramString.nSessionId, AppConstants.y, 6000, 10, null, 0, null);
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    super.a(paramBoolean, paramLong, paramString);
    Object localObject = a(paramLong);
    if (localObject == null) {
      return;
    }
    long l;
    if (paramBoolean)
    {
      ((FileManagerEntity)localObject).status = 1;
      QfileBaseRecentFileTabView.h(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView).a().c((FileManagerEntity)localObject);
      QLog.e(QfileBaseRecentFileTabView.a, 2, "FMConstants.TYPE_FILE_RECVFILE_SUCCESS in onSendFile,entity.cloudtype:" + ((FileManagerEntity)localObject).cloudType + ",filepath:" + ((FileManagerEntity)localObject).strFilePath);
      paramString = QfileBaseRecentFileTabView.i(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView).a();
      paramLong = ((FileManagerEntity)localObject).uniseq;
      l = ((FileManagerEntity)localObject).nSessionId;
      localObject = AppConstants.y;
      if (!paramBoolean) {
        break label163;
      }
    }
    label163:
    for (int i = 11;; i = 12)
    {
      paramString.a(paramLong, l, (String)localObject, 6000, i, null, 0, null);
      return;
      ((FileManagerEntity)localObject).status = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adaz
 * JD-Core Version:    0.7.0.1
 */