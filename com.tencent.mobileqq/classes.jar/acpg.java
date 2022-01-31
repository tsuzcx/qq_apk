import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.widget.ExpandableListView.OnGroupExpandListener;

public class acpg
  implements ExpandableListView.OnGroupExpandListener
{
  public acpg(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void a(int paramInt)
  {
    if ((paramInt == this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() - 1) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout != null))
    {
      if (!this.a.a()) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setVisible();
      }
    }
    else {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acpg
 * JD-Core Version:    0.7.0.1
 */