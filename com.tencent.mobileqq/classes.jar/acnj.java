import android.view.View;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

public class acnj
  implements ActionSheet.OnButtonClickListener
{
  public acnj(LocalFileBrowserActivity paramLocalFileBrowserActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.d != -1)
      {
        paramView = (FileInfo)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b.get(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.d);
        if ((!FileUtil.a(paramView.c())) || (FileUtil.c(paramView.c())))
        {
          FileManagerUtil.d(paramView.c());
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b.remove(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.d);
          LocalFileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity);
        }
        else
        {
          FMToastUtil.a(2131428144);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acnj
 * JD-Core Version:    0.7.0.1
 */