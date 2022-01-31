import android.os.Bundle;
import com.tencent.biz.troop.file.TroopFileProtocol.OnGetZipFileList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.FileData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class acec
  implements HttpWebCgiAsyncTask.Callback
{
  public acec(TroopFileZipPreviewActivity paramTroopFileZipPreviewActivity, List paramList, String paramString1, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, TroopFileProtocol.OnGetZipFileList paramOnGetZipFileList) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramJSONObject != null) {}
    try
    {
      ZipFilePresenter.FileData localFileData;
      if (!paramJSONObject.isNull("dirs"))
      {
        paramBundle = paramJSONObject.getJSONArray("dirs");
        paramInt = 0;
        while (paramInt < paramBundle.length())
        {
          localFileData = new ZipFilePresenter.FileData();
          localFileData.jdField_a_of_type_Boolean = true;
          localFileData.jdField_a_of_type_JavaLangString = paramBundle.getString(paramInt);
          this.jdField_a_of_type_JavaUtilList.add(localFileData);
          paramInt += 1;
        }
      }
      if ((paramJSONObject != null) && (!paramJSONObject.isNull("files")))
      {
        paramBundle = paramJSONObject.getJSONArray("files");
        paramInt = 0;
        if (paramInt < paramBundle.length())
        {
          localFileData = new ZipFilePresenter.FileData();
          paramJSONObject = paramBundle.getJSONObject(paramInt);
          localFileData.jdField_a_of_type_JavaLangString = paramJSONObject.getString("filename");
          localFileData.jdField_a_of_type_Long = paramJSONObject.getLong("size");
          if (this.jdField_a_of_type_JavaLangString.equals("/")) {}
          for (paramJSONObject = "/" + localFileData.jdField_a_of_type_JavaLangString;; paramJSONObject = this.jdField_a_of_type_JavaLangString + "/" + localFileData.jdField_a_of_type_JavaLangString)
          {
            FileManagerEntity localFileManagerEntity = new FileManagerEntity();
            localFileManagerEntity.fileName = localFileData.jdField_a_of_type_JavaLangString;
            localFileManagerEntity.nRelatedSessionId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
            localFileManagerEntity.fileSize = localFileData.jdField_a_of_type_Long;
            localFileManagerEntity.mContext = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
            localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
            if (this.jdField_a_of_type_Boolean)
            {
              localFileManagerEntity.WeiYunFileId = this.b;
              localFileManagerEntity.mContext = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
              localFileManagerEntity.nRelatedSessionId = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
            }
            localFileManagerEntity.zipFileId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
            if (localFileManagerEntity.mContext == null) {
              QLog.i("IphoneTitleBarActivity", 1, "zip list file content is empty. zipSessionId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] zipIsWeiyunFile[" + this.jdField_a_of_type_Boolean + "] zipCouldType[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType + "] fileSessionId[" + localFileManagerEntity.nSessionId + "]");
            }
            localFileManagerEntity.strServerPath = ("http://" + this.c + ":" + this.d + "/ftn_compress_getfile/rkey=" + this.e + "&filetype=" + this.jdField_a_of_type_Int + "&path=" + URLUtil.a(paramJSONObject) + "&");
            localFileManagerEntity.zipFileId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
            localFileManagerEntity.zipInnerPath = paramJSONObject;
            localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.selfUin;
            localFileManagerEntity.peerUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
            localFileManagerEntity.peerType = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType;
            localFileManagerEntity.busId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.busId;
            localFileManagerEntity.cloudType = 1;
            localFileManagerEntity.isZipInnerFile = true;
            localFileManagerEntity.zipFilePath = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath;
            localFileManagerEntity.zipType = this.jdField_a_of_type_Int;
            localFileManagerEntity.TroopUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin;
            localFileData.b = localFileManagerEntity.nSessionId;
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.app.a().a(localFileManagerEntity);
            this.jdField_a_of_type_JavaUtilList.add(localFileData);
            paramInt += 1;
            break;
          }
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      if (this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$OnGetZipFileList != null) {
        this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$OnGetZipFileList.a(this.jdField_a_of_type_JavaUtilList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acec
 * JD-Core Version:    0.7.0.1
 */