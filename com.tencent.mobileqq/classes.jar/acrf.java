import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileBaseExpandableListAdapter.LocalItemHolder;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

class acrf
  implements View.OnClickListener
{
  acrf(acre paramacre, View paramView) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((paramView instanceof ImageHolder))
    {
      paramView = (FileInfo)((ImageHolder)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_Acre.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity, null);
      localActionSheet.a(" 删除本地文件后将无法找回，是否继续？");
      localActionSheet.a("删除", 3);
      localActionSheet.d("取消");
      localActionSheet.a(new acrg(this, paramView, localActionSheet));
      localActionSheet.show();
    }
    do
    {
      return;
      if ((paramView instanceof QfileLocalFileBaseExpandableListAdapter.LocalItemHolder))
      {
        paramView = (FileInfo)((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)this.jdField_a_of_type_AndroidViewView.getTag()).a;
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(QfileBaseLocalFileTabView.jdField_a_of_type_JavaLangString, 2, "unknow Object");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acrf
 * JD-Core Version:    0.7.0.1
 */