import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class acqs
  implements Runnable
{
  public acqs(FileManagerProxy paramFileManagerProxy, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject2 = "select * from ( select * from " + FileManagerEntity.tableName() + " where bDelInFM = 0  and nRelatedSessionId = " + this.jdField_a_of_type_Long + "  order by srvTime desc limit " + 2000 + ") ";
    EntityManager localEntityManager = FileManagerProxy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy).getEntityManagerFactory().createEntityManager();
    localObject2 = localEntityManager.a(FileManagerEntity.class, (String)localObject2, null);
    for (;;)
    {
      synchronized (FileManagerProxy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy))
      {
        FileManagerProxy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy, new HashMap());
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("find ZipList file:");
          if (localObject2 == null)
          {
            i = 0;
            QLog.i("FileManagerProxy<FileAssistant>", 1, i);
          }
        }
        else
        {
          if (localObject2 == null) {
            return;
          }
          localObject2 = ((List)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            return;
          }
          ??? = (FileManagerEntity)((Iterator)localObject2).next();
          if ((this.jdField_a_of_type_JavaLangString == null) || (((FileManagerEntity)???).zipFileId == null) || (((FileManagerEntity)???).zipFileId.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))) {
            break label259;
          }
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.e("FileManagerProxy<FileAssistant>", 1, ((FileManagerEntity)???).fileName + ": fileId is error! continiu");
        }
      }
      int i = ((List)localObject2).size();
      continue;
      label259:
      if (TextUtils.isEmpty(((FileManagerEntity)???).strServerPath))
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("FileManagerProxy<FileAssistant>", 1, ((FileManagerEntity)???).fileName + ": serverPath is empty!");
        }
        ((FileManagerEntity)???).setStatus(1001);
        localObject1.b((Entity)???);
      }
      else if (!FileUtil.b(((FileManagerEntity)???).getFilePath()))
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("FileManagerProxy<FileAssistant>", 1, ((FileManagerEntity)???).fileName + ": file not exist!");
        }
        ((FileManagerEntity)???).setStatus(1001);
        localObject1.b((Entity)???);
      }
      else
      {
        try
        {
          synchronized (FileManagerProxy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy))
          {
            FileManagerProxy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy).put(((FileManagerEntity)???).zipInnerPath, ???);
          }
        }
        catch (Exception localException)
        {
          QLog.e("FileManagerProxy<FileAssistant>", 1, ((FileManagerEntity)???).fileName + " getPath error:" + localException.toString());
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acqs
 * JD-Core Version:    0.7.0.1
 */