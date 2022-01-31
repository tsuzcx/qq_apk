import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class acyk
  extends FMObserver
{
  public acyk(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    super.a(paramInt, paramString1, paramString2);
    this.a.b(false);
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    FileManagerUtil.a(paramLong, paramInteger.intValue(), paramString);
  }
  
  protected void a(String paramString1, boolean paramBoolean, int paramInt1, String paramString2, List paramList, int paramInt2)
  {
    QfileCloudFileTabView.b(this.a, true);
    QfileCloudFileTabView.c(this.a, paramBoolean);
    this.a.jdField_c_of_type_Int = paramInt2;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      paramInt1 = FileManagerUtil.a(localWeiYunFileInfo.jdField_c_of_type_JavaLangString);
      String str;
      if (paramInt1 == 0)
      {
        str = QfileCloudFileTabView.a(this.a).a().a(localWeiYunFileInfo.a, localWeiYunFileInfo.e, 3, localWeiYunFileInfo);
        if (str != null) {
          localWeiYunFileInfo.h = str;
        }
      }
      else if (2 == paramInt1)
      {
        str = QfileCloudFileTabView.b(this.a).a().b(localWeiYunFileInfo.a, localWeiYunFileInfo.e, 2, localWeiYunFileInfo);
        if (str != null) {
          localWeiYunFileInfo.h = str;
        }
      }
    }
    if (!paramString1.equals(this.a.b)) {
      return;
    }
    if (QfileCloudFileTabView.b(this.a)) {
      this.a.a.clear();
    }
    this.a.a.addAll(paramList);
    if (!this.a.b.equalsIgnoreCase("picture")) {
      this.a.setListFooter();
    }
    this.a.jdField_c_of_type_JavaLangString = paramString2;
    this.a.jdField_c_of_type_Boolean = true;
    this.a.g();
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acyk
 * JD-Core Version:    0.7.0.1
 */