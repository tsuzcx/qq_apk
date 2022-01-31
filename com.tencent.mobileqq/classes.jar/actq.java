import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;

public class actq
  implements QfilePinnedHeaderExpandableListView.OnSelectListener
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public actq(QfileRecentPicFileTabView paramQfileRecentPicFileTabView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -2147483648;
    this.b = 2147483647;
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView.a.getChild(paramInt1, paramInt2);
    if (localFileManagerEntity == null) {}
    do
    {
      return;
      if (!FMDataCache.a(localFileManagerEntity)) {
        bool = true;
      }
      this.jdField_a_of_type_Boolean = bool;
    } while (!QfileRecentPicFileTabView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView, localFileManagerEntity, this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView.g();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 != paramInt3) {
      return;
    }
    paramInt3 = Math.min(paramInt2, paramInt4);
    int i = Math.max(paramInt2, paramInt4);
    if (paramInt4 < paramInt2) {
      this.b = Math.min(paramInt4, this.b);
    }
    for (;;)
    {
      paramInt2 = paramInt3;
      while (paramInt2 <= i)
      {
        QfileRecentPicFileTabView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView, (FileManagerEntity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView.a.getChild(paramInt1, paramInt2), this.jdField_a_of_type_Boolean);
        paramInt2 += 1;
      }
      this.jdField_a_of_type_Int = Math.max(paramInt4, this.jdField_a_of_type_Int);
    }
    paramInt2 = this.b;
    QfileRecentPicFileTabView localQfileRecentPicFileTabView;
    FileManagerEntity localFileManagerEntity;
    boolean bool;
    if (paramInt2 < paramInt3)
    {
      localQfileRecentPicFileTabView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView;
      localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView.a.getChild(paramInt1, paramInt2);
      if (!this.jdField_a_of_type_Boolean) {}
      for (bool = true;; bool = false)
      {
        QfileRecentPicFileTabView.a(localQfileRecentPicFileTabView, localFileManagerEntity, bool);
        paramInt2 += 1;
        break;
      }
    }
    paramInt2 = i + 1;
    if (paramInt2 <= this.jdField_a_of_type_Int)
    {
      localQfileRecentPicFileTabView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView;
      localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView.a.getChild(paramInt1, paramInt2);
      if (!this.jdField_a_of_type_Boolean) {}
      for (bool = true;; bool = false)
      {
        QfileRecentPicFileTabView.a(localQfileRecentPicFileTabView, localFileManagerEntity, bool);
        paramInt2 += 1;
        break;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView.g();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     actq
 * JD-Core Version:    0.7.0.1
 */