import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import java.util.Iterator;
import java.util.List;

public final class acxh
  implements Runnable
{
  public acxh(FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    if (FileUtil.a(this.a.getFilePath())) {}
    PackageInfo localPackageInfo;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((this.a.strApkPackageName == null) || (this.a.strApkPackageName.length() == 0)) {}
        localIterator = FileCategoryUtil.a(BaseApplicationImpl.getContext()).iterator();
      } while (!localIterator.hasNext());
      localPackageInfo = (PackageInfo)localIterator.next();
    } while (!this.a.strApkPackageName.equalsIgnoreCase(localPackageInfo.packageName));
    this.a.setFilePath(localPackageInfo.applicationInfo.publicSourceDir);
    this.a.fileName = FileCategoryUtil.a(this.a.getFilePath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acxh
 * JD-Core Version:    0.7.0.1
 */