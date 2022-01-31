import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.UUID;

public final class adbp
  implements View.OnClickListener
{
  public adbp(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = new FileManagerReporter.fileAssistantReportData();
      paramView.b = "file_forward";
      paramView.a = 9;
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getCurrentAccountUin(), paramView);
      if (NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity()) == 0)
      {
        TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(2131429788));
        return;
      }
      Object localObject1 = new FileManagerEntity();
      ((FileManagerEntity)localObject1).copyFrom(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      ((FileManagerEntity)localObject1).nSessionId = FileManagerUtil.a().longValue();
      ((FileManagerEntity)localObject1).status = 2;
      paramView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
      if (paramView != null) {
        paramView.a().d((FileManagerEntity)localObject1);
      }
      paramView = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), (FileManagerEntity)localObject1);
      Object localObject2 = new ForwardFileInfo();
      ((ForwardFileInfo)localObject2).b(((FileManagerEntity)localObject1).nSessionId);
      if (!TextUtils.isEmpty(((FileManagerEntity)localObject1).getFilePath())) {
        ((ForwardFileInfo)localObject2).a(paramView.jdField_a_of_type_JavaLangString);
      }
      ((ForwardFileInfo)localObject2).d(paramView.g);
      ((ForwardFileInfo)localObject2).d(paramView.b);
      ((ForwardFileInfo)localObject2).a(((FileManagerEntity)localObject1).TroopUin);
      if (((FileManagerEntity)localObject1).isZipInnerFile)
      {
        ((ForwardFileInfo)localObject2).b(10000);
        ((ForwardFileInfo)localObject2).d(3);
      }
      for (;;)
      {
        ((ForwardFileInfo)localObject2).a(2);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("forward_type", 0);
        ((Bundle)localObject1).putParcelable("fileinfo", (Parcelable)localObject2);
        ((Bundle)localObject1).putBoolean("not_forward", true);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ((Intent)localObject2).putExtra("forward_text", paramView.g);
        ((Intent)localObject2).putExtra("forward_from_troop_file", true);
        ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), (Intent)localObject2, 103);
        return;
        if (paramView.jdField_a_of_type_JavaUtilUUID != null) {
          ((ForwardFileInfo)localObject2).e(paramView.jdField_a_of_type_JavaUtilUUID.toString());
        }
        ((ForwardFileInfo)localObject2).b(10006);
        ((ForwardFileInfo)localObject2).d(4);
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adbp
 * JD-Core Version:    0.7.0.1
 */