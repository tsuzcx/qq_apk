import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.TroopFileProtocol.GetFilePreviewObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnZipEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class addm
  extends TroopFileProtocol.GetFilePreviewObserver
{
  public addm(TroopFileModel paramTroopFileModel) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, ByteStringMicro paramByteStringMicro1, String paramString4, ByteStringMicro paramByteStringMicro2, Bundle paramBundle)
  {
    this.a.e = FileManagerUtil.a(paramByteStringMicro1);
    if ((paramBoolean) && (!TextUtils.isEmpty(this.a.e)))
    {
      QLog.d("TroopFileModel<FileAssistant>", 2, "downURL:" + this.a.e);
      this.a.jdField_a_of_type_JavaLangString = paramString3;
      this.a.b = ("" + paramInt3);
      this.a.c = FileManagerUtil.a(paramByteStringMicro1);
      this.a.d = paramString4;
      this.a.c = FileManagerUtil.a(paramByteStringMicro1);
      TroopFileProtocol.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, "" + paramInt3, this.a.c, FileManagerUtil.c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()), "/", paramString4, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a(), new addn(this));
    }
    do
    {
      return;
      QLog.e("TroopFileModel<FileAssistant>", 1, "get preview url failed for troop, retCode[" + paramInt1 + "], retMeg[" + paramString1 + "]");
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", null, "oper", "pre_arc_fail", 0, 0, "" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().TroopUin, "-1", FileManagerUtil.f(this.a.a()), "1");
    } while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener == null);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener.a(paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     addm
 * JD-Core Version:    0.7.0.1
 */