import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol.GetFilePreviewObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.lang.ref.WeakReference;

public class ajen
  extends TroopFileProtocol.GetFilePreviewObserver
{
  public ajen(TroopFileItemOperation paramTroopFileItemOperation, FileManagerEntity paramFileManagerEntity) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, ByteStringMicro paramByteStringMicro1, String paramString4, ByteStringMicro paramByteStringMicro2, Bundle paramBundle)
  {
    paramString2 = FileManagerUtil.a(paramByteStringMicro1);
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipType;
    if (QLog.isColorLevel()) {
      QLog.i("", 2, "doDownloadZipInner," + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipInnerPath);
    }
    paramString1 = "";
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipInnerPath)) {
      paramString1 = URLUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipInnerPath);
    }
    paramString1 = "http://" + paramString3 + ":" + paramInt3 + "/ftn_compress_getfile/rkey=" + paramString2 + "&filetype=" + paramInt1 + "&path=" + paramString1 + "&";
    TroopFileTransferManager.a((QQAppInterface)this.b.get(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.b).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajen
 * JD-Core Version:    0.7.0.1
 */