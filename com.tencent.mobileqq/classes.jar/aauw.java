import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import msf.msgsvc.msg_ctrl.MsgCtrl;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.cs.group_file_common.group_file_common.FeedsInfo;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DeleteFileReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.MoveFileReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.ReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.ResendReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.CreateFolderReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.DeleteFolderReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.RenameFolderReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.ReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileCountReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileInfoReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileListReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFilePreviewReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetSpaceReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.ReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.CopyToReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.FeedsReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.ReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.TransFileReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aauw
{
  public static bfve a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, boolean paramBoolean1, boolean paramBoolean2, aavn paramaavn)
  {
    if ((paramLong == 0L) || (paramItem == null)) {
      return null;
    }
    int i = aunj.a(auog.a(paramItem.FileName));
    oidb_0x6d6.DownloadFileReqBody localDownloadFileReqBody = new oidb_0x6d6.DownloadFileReqBody();
    localDownloadFileReqBody.uint32_bus_id.set(paramItem.BusId);
    localDownloadFileReqBody.uint32_app_id.set(3);
    localDownloadFileReqBody.uint64_group_code.set(paramLong);
    localDownloadFileReqBody.str_file_id.set(paramItem.FilePath);
    Object localObject = localDownloadFileReqBody.bool_thumbnail_req;
    boolean bool;
    if (paramInt != 0)
    {
      bool = true;
      ((PBBoolField)localObject).set(bool);
      localDownloadFileReqBody.bool_preview_req.set(paramBoolean1);
      if (i == 2)
      {
        if (!paramBoolean2) {
          break label250;
        }
        localDownloadFileReqBody.uint32_src.set(1);
        label127:
        if (paramInt == 0) {
          break label262;
        }
        localDownloadFileReqBody.bool_thumbnail_req.set(false);
        localDownloadFileReqBody.bool_preview_req.set(true);
      }
    }
    for (;;)
    {
      localDownloadFileReqBody.uint32_url_type.set(0);
      localObject = new Bundle();
      ((Bundle)localObject).putString("itemKey", paramItem.Id.toString());
      ((Bundle)localObject).putLong("troopUin", paramLong);
      ((Bundle)localObject).putInt("thumbNail", paramInt);
      ((Bundle)localObject).putBoolean("isPreview", paramBoolean1);
      paramItem = new oidb_0x6d6.ReqBody();
      paramItem.download_file_req.set(localDownloadFileReqBody);
      return a(paramQQAppInterface, paramaavn, paramItem.toByteArray(), "OidbSvc.0x6d6_2", 1750, 2, (Bundle)localObject);
      bool = false;
      break;
      label250:
      localDownloadFileReqBody.uint32_src.set(0);
      break label127;
      label262:
      localDownloadFileReqBody.bool_thumbnail_req.set(false);
      localDownloadFileReqBody.bool_preview_req.set(false);
    }
  }
  
  public static bfve a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileTransferManager.Item paramItem, aavp paramaavp)
  {
    if ((paramLong == 0L) || (paramItem == null)) {
      return null;
    }
    Object localObject = new oidb_0x6d6.ResendReqBody();
    ((oidb_0x6d6.ResendReqBody)localObject).uint32_bus_id.set(paramItem.BusId);
    ((oidb_0x6d6.ResendReqBody)localObject).uint32_app_id.set(3);
    ((oidb_0x6d6.ResendReqBody)localObject).uint64_group_code.set(paramLong);
    ((oidb_0x6d6.ResendReqBody)localObject).str_file_id.set(paramItem.FilePath);
    ((oidb_0x6d6.ResendReqBody)localObject).bytes_sha.set(ByteStringMicro.copyFrom(paramItem.Sha));
    oidb_0x6d6.ReqBody localReqBody = new oidb_0x6d6.ReqBody();
    localReqBody.resend_file_req.set((MessageMicro)localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putString("itemKey", paramItem.Id.toString());
    ((Bundle)localObject).putLong("troopUin", paramLong);
    return a(paramQQAppInterface, paramaavp, localReqBody.toByteArray(), "OidbSvc.0x6d6_1", 1750, 1, (Bundle)localObject);
  }
  
  public static bfve a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileTransferManager.Item paramItem, aavr paramaavr)
  {
    if ((paramLong == 0L) || (paramItem == null)) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("itemKey", paramItem.Id.toString());
    localBundle.putLong("troopUin", paramLong);
    localBundle.putBoolean("bExtfTransfer", paramItem.bExtfTransfer);
    return a(paramQQAppInterface, paramLong, paramItem.FileName, paramItem.LocalFile, paramItem.ProgressTotal, paramItem.isFromAIO, paramItem.Md5, paramItem.Sha, paramItem.Sha3, paramItem.BusId, paramItem.mParentId, localBundle, paramaavr);
  }
  
  public static bfve a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt, aavh paramaavh)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileProtocol", 4, "getFilePreviewList" + paramLong + ",filePath:" + paramString + ",busId:" + paramInt);
    }
    oidb_0x6d8.GetFilePreviewReqBody localGetFilePreviewReqBody = new oidb_0x6d8.GetFilePreviewReqBody();
    localGetFilePreviewReqBody.uint64_group_code.set(paramLong);
    localGetFilePreviewReqBody.uint32_app_id.set(3);
    localGetFilePreviewReqBody.uint32_bus_id.set(paramInt);
    localGetFilePreviewReqBody.str_file_id.set(paramString);
    paramString = new oidb_0x6d8.ReqBody();
    paramString.file_preview_req.set(localGetFilePreviewReqBody);
    return a(paramQQAppInterface, paramaavh, paramString.toByteArray(), "OidbSvc.0x6d8_4", 1752, 4, null);
  }
  
  public static bfve a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString3, int paramInt, String paramString4, Bundle paramBundle, aavr paramaavr)
  {
    oidb_0x6d6.UploadFileReqBody localUploadFileReqBody = new oidb_0x6d6.UploadFileReqBody();
    localUploadFileReqBody.uint32_bus_id.set(paramInt);
    localUploadFileReqBody.uint32_app_id.set(3);
    localUploadFileReqBody.uint64_group_code.set(paramLong1);
    localUploadFileReqBody.bytes_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte1));
    localUploadFileReqBody.bytes_sha.set(ByteStringMicro.copyFrom(paramArrayOfByte2));
    if (paramString3 != null)
    {
      paramArrayOfByte1 = HexUtil.hexStr2Bytes(paramString3);
      localUploadFileReqBody.bytes_sha3.set(ByteStringMicro.copyFrom(paramArrayOfByte1));
    }
    if (TextUtils.isEmpty(paramString4))
    {
      localUploadFileReqBody.str_parent_folder_id.set("/");
      localUploadFileReqBody.str_file_name.set(paramString1);
      localUploadFileReqBody.str_local_path.set(paramString2);
      paramString1 = localUploadFileReqBody.uint32_entrance;
      if (!paramBoolean) {
        break label238;
      }
    }
    label238:
    for (paramInt = 5;; paramInt = 4)
    {
      paramString1.set(paramInt);
      localUploadFileReqBody.uint64_file_size.set(paramLong2);
      paramBoolean = false;
      if (paramBundle != null) {
        paramBoolean = paramBundle.getBoolean("bExtfTransfer", false);
      }
      if (paramBoolean) {
        localUploadFileReqBody.bool_support_multi_upload.set(true);
      }
      paramString1 = new oidb_0x6d6.ReqBody();
      paramString1.upload_file_req.set(localUploadFileReqBody);
      return a(paramQQAppInterface, paramaavr, paramString1.toByteArray(), "OidbSvc.0x6d6_0", 1750, 0, paramBundle);
      localUploadFileReqBody.str_parent_folder_id.set(paramString4);
      break;
    }
  }
  
  public static bfve a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, String paramString3, Bundle paramBundle, aavr paramaavr)
  {
    if (paramLong1 == 0L) {
      return null;
    }
    return a(paramQQAppInterface, paramLong1, paramString1, paramString2, paramLong2, true, paramArrayOfByte1, paramArrayOfByte2, null, paramInt, paramString3, paramBundle, paramaavr);
  }
  
  private static bfve a(QQAppInterface paramQQAppInterface, nkq paramnkq, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localOIDBSSOPkg.str_client_version.set(AppSetting.f());
    paramArrayOfByte = new bfve();
    paramArrayOfByte.jdField_a_of_type_JavaLangString = paramString;
    paramArrayOfByte.jdField_a_of_type_ArrayOfByte = localOIDBSSOPkg.toByteArray();
    paramArrayOfByte.jdField_a_of_type_AndroidOsBundle = paramBundle;
    paramArrayOfByte.jdField_a_of_type_Nkq = paramnkq;
    paramQQAppInterface.getTroopFileProtoReqMgr().a(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  private static String a(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      if (!avqh.a().i())
      {
        if (!QLog.isColorLevel()) {
          break label179;
        }
        QLog.i("IMG_FILE", 1, "choushane false!");
        break label179;
      }
      if (paramItem.strQRUrl != null) {
        return paramItem.strQRUrl;
      }
      Object localObject;
      if (zom.c(paramItem.middleThumbnailFile)) {
        localObject = new File(paramItem.middleThumbnailFile);
      }
      for (String str = "mid";; str = "larg")
      {
        localObject = avpw.a(BaseApplicationImpl.getContext(), (File)localObject);
        if (localObject == null) {
          break label175;
        }
        paramItem.strQRUrl = ((StringBuilder)((Pair)localObject).first).toString();
        if (QLog.isDevelopLevel()) {
          QLog.i("IMG_FILE_QR", 1, "reqFeeds getImageUrl success:" + paramItem.strQRUrl + " use:" + str);
        }
        return paramItem.strQRUrl;
        if (!zom.c(paramItem.largeThumbnailFile)) {
          break;
        }
        localObject = new File(paramItem.largeThumbnailFile);
      }
      return null;
    }
    catch (Throwable paramItem) {}
    label175:
    return "";
    label179:
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString, int paramInt6, long paramLong2, int paramInt7, ByteStringMicro paramByteStringMicro, aavg paramaavg)
  {
    boolean bool;
    oidb_0x6d8.GetFileListReqBody localGetFileListReqBody;
    if (paramInt7 == 0)
    {
      bool = true;
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileProtocol", 4, "getFileList" + paramLong1 + ",reqFor:" + paramInt2 + ",reqFrom:" + paramInt4 + ",count:" + paramInt3 + ",firstPage:" + bool);
      }
      localGetFileListReqBody = new oidb_0x6d8.GetFileListReqBody();
      localGetFileListReqBody.uint32_all_file_count.set(paramInt1);
      localGetFileListReqBody.uint32_file_count.set(paramInt3);
      localGetFileListReqBody.uint32_req_from.set(paramInt4);
      localGetFileListReqBody.uint64_group_code.set(paramLong1);
      localGetFileListReqBody.uint32_app_id.set(3);
      localGetFileListReqBody.str_folder_id.set(paramString);
      localGetFileListReqBody.uint32_sort_by.set(paramInt5);
      localGetFileListReqBody.uint32_filter_code.set(paramInt6);
      localGetFileListReqBody.uint64_uin.set(paramLong2);
      localGetFileListReqBody.uint32_start_index.set(paramInt7);
      if (paramByteStringMicro != null) {
        break label343;
      }
      localGetFileListReqBody.bytes_context.set(ByteStringMicro.copyFromUtf8(""));
      label209:
      if ((paramInt6 != 2) && (paramInt6 != 3)) {
        break label356;
      }
      localGetFileListReqBody.uint32_show_onlinedoc_folder.set(0);
    }
    for (;;)
    {
      paramByteStringMicro = new Bundle();
      paramByteStringMicro.putLong("troopUin", paramLong1);
      paramByteStringMicro.putInt("reqFor", paramInt2);
      paramByteStringMicro.putInt("reqFrom", paramInt4);
      paramByteStringMicro.putBoolean("isFirstPage", bool);
      paramByteStringMicro.putString("parentFileId", paramString);
      paramByteStringMicro.putLong("uin_filter", paramLong2);
      paramString = new oidb_0x6d8.ReqBody();
      paramString.file_list_info_req.set(localGetFileListReqBody);
      nkm.b(paramQQAppInterface, paramaavg, paramString.toByteArray(), "OidbSvc.0x6d8_1", 1752, 1, paramByteStringMicro);
      return;
      bool = false;
      break;
      label343:
      localGetFileListReqBody.bytes_context.set(paramByteStringMicro);
      break label209;
      label356:
      localGetFileListReqBody.uint32_show_onlinedoc_folder.set(1);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, Bundle paramBundle, aavo paramaavo)
  {
    a(paramQQAppInterface, paramLong, paramInt1, paramString, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean, paramBundle, null, paramaavo);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, Bundle paramBundle, msg_ctrl.MsgCtrl paramMsgCtrl, aavo paramaavo)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("TroopFileProtocol", 1, "reqFeeds error.filePath is null ");
      return;
    }
    group_file_common.FeedsInfo localFeedsInfo = new group_file_common.FeedsInfo();
    localFeedsInfo.str_file_id.set(paramString);
    localFeedsInfo.uint32_bus_id.set(paramInt1);
    localFeedsInfo.uint32_msg_random.set(paramInt2);
    if (paramBoolean) {
      localFeedsInfo.uint32_feed_flag.set(1);
    }
    for (;;)
    {
      if (paramMsgCtrl != null) {
        localFeedsInfo.msg_ctrl.set(paramMsgCtrl);
      }
      try
      {
        paramString = new JSONObject();
        if (paramBundle.containsKey("yyb_apk_package_name_key")) {
          paramString.put("yyb_apk_package_name_key", paramBundle.getString("yyb_apk_package_name_key"));
        }
        if (paramBundle.containsKey("yyb_apk_name_key")) {
          paramString.put("yyb_apk_name_key", paramBundle.getString("yyb_apk_name_key"));
        }
        if (paramBundle.containsKey("yyb_apk_icon_url_key")) {
          paramString.put("yyb_apk_icon_url_key", paramBundle.getString("yyb_apk_icon_url_key"));
        }
        if ((paramInt3 != 0) && (paramInt4 != 0))
        {
          paramString.put("width", paramInt3);
          paramString.put("height", paramInt4);
          paramString.put("duration", paramInt5);
        }
        if (paramString.length() > 0) {
          localFeedsInfo.bytes_ext.set(ByteStringMicro.copyFromUtf8(paramString.toString()));
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      paramString = new oidb_0x6d9.FeedsReqBody();
      paramString.uint32_app_id.set(3);
      paramString.uint64_group_code.set(paramLong);
      paramString.rpt_feeds_info_list.add(localFeedsInfo);
      paramMsgCtrl = new oidb_0x6d9.ReqBody();
      paramMsgCtrl.feeds_info_req.set(paramString);
      nkm.b(paramQQAppInterface, paramaavo, paramMsgCtrl.toByteArray(), "OidbSvc.0x6d9_4", 1753, 4, paramBundle);
      return;
      localFeedsInfo.uint32_feed_flag.set(3);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, String paramString, long paramLong2, int paramInt2, Bundle paramBundle, aavm paramaavm)
  {
    oidb_0x6d9.CopyToReqBody localCopyToReqBody = new oidb_0x6d9.CopyToReqBody();
    localCopyToReqBody.uint32_app_id.set(3);
    localCopyToReqBody.uint64_group_code.set(paramLong1);
    localCopyToReqBody.uint64_dst_uin.set(paramLong2);
    localCopyToReqBody.uint32_src_bus_id.set(paramInt1);
    localCopyToReqBody.str_src_file_id.set(paramString);
    localCopyToReqBody.uint32_dst_bus_id.set(paramInt2);
    paramString = new oidb_0x6d9.ReqBody();
    paramString.copy_to_req.set(localCopyToReqBody);
    nkm.b(paramQQAppInterface, paramaavm, paramString.toByteArray(), "OidbSvc.0x6d9_2", 1753, 2, paramBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt, String paramString, aavj paramaavj)
  {
    if ((paramQQAppInterface == null) || (paramLong == 0L) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    oidb_0x6d8.GetFileInfoReqBody localGetFileInfoReqBody = new oidb_0x6d8.GetFileInfoReqBody();
    localGetFileInfoReqBody.uint64_group_code.set(paramLong);
    localGetFileInfoReqBody.uint32_app_id.set(3);
    localGetFileInfoReqBody.uint32_bus_id.set(paramInt);
    localGetFileInfoReqBody.str_file_id.set(paramString);
    paramString = new oidb_0x6d8.ReqBody();
    paramString.file_info_req.set(localGetFileInfoReqBody);
    nkm.b(paramQQAppInterface, paramaavj, paramString.toByteArray(), "OidbSvc.0x6d8_0", 1752, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, aavd paramaavd)
  {
    if ((paramLong == 0L) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Object localObject = new oidb_0x6d6.DeleteFileReqBody();
    ((oidb_0x6d6.DeleteFileReqBody)localObject).uint32_bus_id.set(paramInt1);
    ((oidb_0x6d6.DeleteFileReqBody)localObject).str_file_id.set(paramString1);
    ((oidb_0x6d6.DeleteFileReqBody)localObject).uint32_app_id.set(3);
    ((oidb_0x6d6.DeleteFileReqBody)localObject).uint64_group_code.set(paramLong);
    ((oidb_0x6d6.DeleteFileReqBody)localObject).str_parent_folder_id.set(paramString2);
    if (paramInt2 != 0) {
      ((oidb_0x6d6.DeleteFileReqBody)localObject).uint32_msgdb_seq.set(paramInt2);
    }
    if (paramInt3 != 0) {
      ((oidb_0x6d6.DeleteFileReqBody)localObject).uint32_msg_rand.set(paramInt3);
    }
    paramString2 = new oidb_0x6d6.ReqBody();
    paramString2.delete_file_req.set((MessageMicro)localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putString("fileId", paramString1);
    nkm.b(paramQQAppInterface, paramaavd, paramString2.toByteArray(), "OidbSvc.0x6d6_3", 1750, 3, (Bundle)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, aavk paramaavk)
  {
    if ((paramLong == 0L) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {}
    while (paramString2.equals(paramString3)) {
      return;
    }
    oidb_0x6d6.MoveFileReqBody localMoveFileReqBody = new oidb_0x6d6.MoveFileReqBody();
    localMoveFileReqBody.uint32_bus_id.set(paramInt);
    localMoveFileReqBody.str_file_id.set(paramString1);
    localMoveFileReqBody.uint32_app_id.set(3);
    localMoveFileReqBody.uint64_group_code.set(paramLong);
    localMoveFileReqBody.str_parent_folder_id.set(paramString2);
    localMoveFileReqBody.str_dest_folder_id.set(paramString3);
    paramString1 = new oidb_0x6d6.ReqBody();
    paramString1.move_file_req.set(localMoveFileReqBody);
    nkm.b(paramQQAppInterface, paramaavk, paramString1.toByteArray(), "OidbSvc.0x6d6_5", 1750, 5);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, aavf paramaavf)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileProtocol", 4, "getFileList" + paramLong);
    }
    oidb_0x6d8.GetFileCountReqBody localGetFileCountReqBody = new oidb_0x6d8.GetFileCountReqBody();
    localGetFileCountReqBody.uint64_group_code.set(paramLong);
    localGetFileCountReqBody.uint32_app_id.set(3);
    localGetFileCountReqBody.uint32_bus_id.set(0);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopUin", paramLong);
    oidb_0x6d8.ReqBody localReqBody = new oidb_0x6d8.ReqBody();
    localReqBody.group_file_cnt_req.set(localGetFileCountReqBody);
    nkm.b(paramQQAppInterface, paramaavf, localReqBody.toByteArray(), "OidbSvc.0x6d8_1", 1752, 2, localBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, aavi paramaavi)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileProtocol", 4, "getFileList" + paramLong);
    }
    oidb_0x6d8.GetSpaceReqBody localGetSpaceReqBody = new oidb_0x6d8.GetSpaceReqBody();
    localGetSpaceReqBody.uint64_group_code.set(paramLong);
    localGetSpaceReqBody.uint32_app_id.set(3);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopUin", paramLong);
    oidb_0x6d8.ReqBody localReqBody = new oidb_0x6d8.ReqBody();
    localReqBody.group_space_req.set(localGetSpaceReqBody);
    nkm.a(paramQQAppInterface, paramaavi, localReqBody.toByteArray(), "OidbSvc.0x6d8_3", 1752, 3, localBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, bfrs parambfrs, aavq paramaavq)
  {
    if ((paramLong == 0L) || (parambfrs == null)) {
      return;
    }
    oidb_0x6d9.TransFileReqBody localTransFileReqBody = new oidb_0x6d9.TransFileReqBody();
    localTransFileReqBody.uint32_app_id.set(3);
    localTransFileReqBody.uint64_group_code.set(paramLong);
    localTransFileReqBody.uint32_bus_id.set(parambfrs.a);
    localTransFileReqBody.str_file_id.set(parambfrs.b);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopUin", paramLong);
    localBundle.putString("fileId", parambfrs.b);
    parambfrs = new oidb_0x6d9.ReqBody();
    parambfrs.trans_file_req.set(localTransFileReqBody);
    nkm.b(paramQQAppInterface, paramaavq, parambfrs.toByteArray(), "OidbSvc.0x6d9_0", 1753, 0, localBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileTransferManager.Item paramItem, aavo paramaavo)
  {
    if ((paramLong == 0L) || (paramItem == null)) {
      return;
    }
    QLog.i("TroopFileProtocol", 1, "reqFeeds, waterTest.");
    Bundle localBundle = new Bundle();
    localBundle.putString("itemKey", paramItem.Id.toString());
    localBundle.putLong("troopUin", paramLong);
    localBundle.putString("fileId", paramItem.FilePath);
    QLog.i("TroopFileProtocol", 1, "reqFeeds, waterTest.pkgName[" + paramItem.yybApkPackageName + "]");
    if (!TextUtils.isEmpty(paramItem.yybApkPackageName)) {
      localBundle.putString("yyb_apk_package_name_key", paramItem.yybApkPackageName);
    }
    if (!TextUtils.isEmpty(paramItem.yybApkName)) {
      localBundle.putString("yyb_apk_name_key", paramItem.yybApkName);
    }
    if (!TextUtils.isEmpty(paramItem.yybApkIconUrl)) {
      localBundle.putString("yyb_apk_icon_url_key", paramItem.yybApkIconUrl);
    }
    Object localObject = a(paramItem);
    localObject = avpw.a(paramItem.LocalFile, paramItem.width, paramItem.height, (String)localObject);
    a(paramQQAppInterface, paramLong, paramItem.BusId, paramItem.FilePath, paramItem.RandomNum, paramItem.width, paramItem.height, paramItem.duration, true, localBundle, (msg_ctrl.MsgCtrl)localObject, paramaavo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, aave paramaave)
  {
    if ((paramLong == 0L) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    oidb_0x6d7.DeleteFolderReqBody localDeleteFolderReqBody = new oidb_0x6d7.DeleteFolderReqBody();
    localDeleteFolderReqBody.str_folder_id.set(paramString);
    localDeleteFolderReqBody.uint32_app_id.set(3);
    localDeleteFolderReqBody.uint64_group_code.set(paramLong);
    paramString = new oidb_0x6d7.ReqBody();
    paramString.delete_folder_req.set(localDeleteFolderReqBody);
    nkm.b(paramQQAppInterface, paramaave, paramString.toByteArray(), "OidbSvc.0x6d7_1", 1751, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, aavc paramaavc)
  {
    if ((paramLong == 0L) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    oidb_0x6d7.CreateFolderReqBody localCreateFolderReqBody = new oidb_0x6d7.CreateFolderReqBody();
    localCreateFolderReqBody.str_parent_folder_id.set(paramString1);
    localCreateFolderReqBody.str_folder_name.set(paramString2);
    localCreateFolderReqBody.uint32_app_id.set(3);
    localCreateFolderReqBody.uint64_group_code.set(paramLong);
    paramString1 = new oidb_0x6d7.ReqBody();
    paramString1.create_folder_req.set(localCreateFolderReqBody);
    nkm.b(paramQQAppInterface, paramaavc, paramString1.toByteArray(), "OidbSvc.0x6d7_0", 1751, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, aavl paramaavl)
  {
    if ((paramLong == 0L) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Object localObject = new oidb_0x6d7.RenameFolderReqBody();
    ((oidb_0x6d7.RenameFolderReqBody)localObject).str_folder_id.set(paramString1);
    ((oidb_0x6d7.RenameFolderReqBody)localObject).str_new_folder_name.set(paramString2);
    ((oidb_0x6d7.RenameFolderReqBody)localObject).uint32_app_id.set(3);
    ((oidb_0x6d7.RenameFolderReqBody)localObject).uint64_group_code.set(paramLong);
    oidb_0x6d7.ReqBody localReqBody = new oidb_0x6d7.ReqBody();
    localReqBody.rename_folder_req.set((MessageMicro)localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putString("folderId", paramString1);
    ((Bundle)localObject).putString("folderName", paramString2);
    nkm.b(paramQQAppInterface, paramaavl, localReqBody.toByteArray(), "OidbSvc.0x6d7_2", 1751, 2, (Bundle)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bfve parambfve)
  {
    if ((paramQQAppInterface == null) || (parambfve == null)) {
      return;
    }
    paramQQAppInterface.getTroopFileProtoReqMgr().b(parambfve);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, aauy paramaauy)
  {
    paramString1 = new bgpq("http://" + paramString1 + ":" + paramString2 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + blhn.a(paramString4) + "&", "GET", new aaux(new ArrayList(), paramString4, paramFileManagerEntity, paramQQAppInterface, paramInt, paramaauy), 1000, null);
    paramString2 = new Bundle();
    paramString2.putString("version", bhlo.c());
    paramString2.putString("Cookie", paramString5);
    paramString3 = new HashMap();
    paramString3.put("BUNDLE", paramString2);
    paramString3.put("CONTEXT", paramQQAppInterface.getApp().getApplicationContext());
    paramString1.a(paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, long paramLong1, TroopFileTransferManager.Item paramItem, long paramLong2, long paramLong3, aavm paramaavm)
  {
    if ((paramLong1 == 0L) || (paramItem == null)) {
      return;
    }
    Object localObject = new oidb_0x6d9.CopyToReqBody();
    ((oidb_0x6d9.CopyToReqBody)localObject).uint32_app_id.set(3);
    if (paramBoolean) {
      ((oidb_0x6d9.CopyToReqBody)localObject).uint64_group_code.set(paramLong1);
    }
    for (;;)
    {
      ((oidb_0x6d9.CopyToReqBody)localObject).uint64_dst_uin.set(paramLong2);
      ((oidb_0x6d9.CopyToReqBody)localObject).uint32_src_bus_id.set(paramItem.ForwardBusId);
      if (!TextUtils.isEmpty(paramItem.ForwardPath)) {
        ((oidb_0x6d9.CopyToReqBody)localObject).str_src_file_id.set(paramItem.ForwardPath);
      }
      ((oidb_0x6d9.CopyToReqBody)localObject).uint32_dst_bus_id.set(paramItem.BusId);
      oidb_0x6d9.ReqBody localReqBody = new oidb_0x6d9.ReqBody();
      localReqBody.copy_to_req.set((MessageMicro)localObject);
      localObject = new Bundle();
      ((Bundle)localObject).putLong("troopUin", paramLong1);
      ((Bundle)localObject).putString("itemKey", paramItem.Id.toString());
      ((Bundle)localObject).putLong("sessionId", paramLong3);
      if (paramItem.BusId == 25) {
        bnyz.a();
      }
      nkm.b(paramQQAppInterface, paramaavm, localReqBody.toByteArray(), "OidbSvc.0x6d9_2", 1753, 2, (Bundle)localObject);
      return;
      ((oidb_0x6d9.CopyToReqBody)localObject).uint64_group_code.set(paramItem.ForwardTroopuin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aauw
 * JD-Core Version:    0.7.0.1
 */