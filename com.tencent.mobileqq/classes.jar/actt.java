import com.tencent.biz.troop.file.TroopFileProtocol.GetOneFileInfoObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnZipEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;

public class actt
  extends TroopFileProtocol.GetOneFileInfoObserver
{
  public actt(TroopFileModel paramTroopFileModel) {}
  
  protected void a(boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo)
  {
    if (paramFileInfo != null)
    {
      String str = ContactUtils.g(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().TroopUin), paramFileInfo.uint64_uploader_uin.get() + "");
      paramFileInfo = new Date(paramFileInfo.uint32_upload_time.get() * 1000L);
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
      paramFileInfo = " 于" + localSimpleDateFormat.format(paramFileInfo) + "上传";
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener.b(str, paramFileInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     actt
 * JD-Core Version:    0.7.0.1
 */