import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;

public class acgc
  implements View.OnClickListener
{
  public acgc(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (!QfileBaseCloudFileTabView.a(this.a)) {
      return;
    }
    QfileBaseCloudFileTabView.a(this.a);
    this.a.f();
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() > 0) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() - 1);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getAdapter().getCount() - 1);
    QfileBaseCloudFileTabView.a(this.a, false);
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acgc
 * JD-Core Version:    0.7.0.1
 */