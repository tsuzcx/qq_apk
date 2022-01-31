import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public final class adbg
  implements View.OnClickListener
{
  public adbg(String paramString, IFileBrowser paramIFileBrowser) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = new adbh(this);
      FileModel localFileModel = FileModel.a(this.jdField_a_of_type_JavaLangString);
      if (localFileModel == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("FileOperaterUtils", 2, "error. get filemodel null, filepath[ " + this.jdField_a_of_type_JavaLangString + "]");
        }
      }
      else
      {
        if (localFileModel.a(false))
        {
          if (!NetworkUtil.e(BaseApplicationImpl.getContext()))
          {
            FMToastUtil.a(2131437312);
            return;
          }
          FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), 2131428241, 2131428238, paramView);
          return;
        }
        paramView.a();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adbg
 * JD-Core Version:    0.7.0.1
 */