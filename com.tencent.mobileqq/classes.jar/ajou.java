import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqCopyToObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.IForwardCallBack;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskPool;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskScan;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.ResponseHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.UUID;
import mqq.app.MobileQQ;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyCopyToRspBody;
import tencent.im.cs.cmd0x383.cmd0x383.RspBody;

public class ajou
  extends TroopFileProtocol.ReqCopyToObserver
{
  public ajou(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  private final void a(TroopFileTransferManager.Item paramItem, cmd0x383.RspBody paramRspBody, long paramLong)
  {
    if (paramRspBody == null) {}
    for (;;)
    {
      try
      {
        if (paramItem.mForwardCallback != null)
        {
          paramRspBody = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131429810);
          paramItem.mForwardCallback.a(false, paramLong, 801, paramRspBody, paramItem.Id.toString(), String.valueOf(paramItem.ForwardTroopuin), "");
        }
        return;
      }
      finally {}
      int i = paramRspBody.int32_ret_code.get();
      String str1 = paramRspBody.str_client_wording.get();
      String str2 = paramRspBody.str_ret_msg.get();
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopFileTransferManager", 4, String.format("onRspCopyToOffline -fileName: %s ,- retCode: %d, -retMsg: %s", new Object[] { paramItem.FileName, Integer.valueOf(i), str2 }));
      }
      if (i != 0)
      {
        if (paramItem.mForwardCallback != null) {
          paramItem.mForwardCallback.a(false, paramLong, i, str1, paramItem.Id.toString(), String.valueOf(paramItem.ForwardTroopuin), "");
        }
      }
      else
      {
        paramRspBody = ((cmd0x383.ApplyCopyToRspBody)paramRspBody.msg_copy_to_rsp_body.get()).str_save_file_path.get();
        if (paramItem.mForwardCallback != null) {
          paramItem.mForwardCallback.a(true, paramLong, i, "", paramItem.Id.toString(), String.valueOf(paramItem.ForwardTroopuin), paramRspBody);
        }
      }
    }
  }
  
  public final void a(TroopFileTransferManager.Item paramItem, cmd0x383.RspBody paramRspBody)
  {
    int i = 207;
    if (paramRspBody == null) {}
    try
    {
      paramRspBody = new TroopFileError.SimpleErrorInfo(paramItem.FileName, this.a.f, 5, 207);
      this.a.a(paramItem, 5, paramRspBody);
      return;
    }
    finally {}
    int j = paramRspBody.int32_ret_code.get();
    if (QLog.isDevelopLevel()) {
      QLog.e("TroopFileTransferManager", 4, String.format("onRspCopyToGroup - retCode: %d", new Object[] { Integer.valueOf(j) }));
    }
    if (j < 0)
    {
      paramRspBody = paramRspBody.str_client_wording.get();
      switch (j)
      {
      }
    }
    for (;;)
    {
      paramRspBody = new TroopFileError.SimpleErrorInfo(paramItem.FileName, paramItem.ForwardTroopuin, 5, i, paramRspBody);
      this.a.a(paramItem, 5, paramRspBody);
      paramItem = ((QQAppInterface)this.b.get()).a().a(paramItem.entrySessionID);
      if (paramItem == null) {
        break;
      }
      long l = paramItem.structMsgSeq;
      ((QQAppInterface)this.b.get()).a().b("" + this.a.f, 1, l);
      break;
      i = 202;
      continue;
      i = 600;
      continue;
      i = 701;
      continue;
      i = 706;
      paramRspBody = "转发的群仅允许群主和管理员上传文件";
      continue;
      if (paramItem.BusId == 102)
      {
        paramItem.BusId = 104;
        TroopFileProtocol.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.a.f, paramItem, this.a.f, 0L, TroopFileTransferManager.a(this.a));
        break;
        if ((TextUtils.isEmpty(paramItem.LocalFile)) || (!new File(paramItem.LocalFile).exists())) {
          break label605;
        }
        this.a.a(paramItem, 0);
        paramItem.BusId = 102;
        this.a.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$TaskPool[0].a(new TroopFileTransferManager.TaskScan(this.a, paramItem));
        break;
        new Handler(Looper.getMainLooper()).post(new ajov(this));
        paramRspBody = ((cmd0x383.ApplyCopyToRspBody)paramRspBody.msg_copy_to_rsp_body.get()).str_save_file_path.get();
        paramItem.FilePath = paramRspBody;
        Object localObject = paramItem.getInfo(this.a.f);
        if (localObject != null) {
          ((TroopFileStatusInfo)localObject).e = paramRspBody;
        }
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramItem.entrySessionID);
        if (localObject != null) {
          ((FileManagerEntity)localObject).strTroopFilePath = paramRspBody;
        }
        this.a.a(paramItem, 7, 0);
        this.a.d(paramItem);
        break;
        continue;
      }
      i = 204;
      continue;
      i = -139;
      continue;
      label605:
      i = 603;
      continue;
      i = 705;
    }
  }
  
  public void a(boolean paramBoolean, cmd0x383.RspBody paramRspBody, Bundle paramBundle)
  {
    long l = paramBundle.getLong("troopUin");
    TroopFileTransferManager localTroopFileTransferManager;
    Object localObject;
    try
    {
      localTroopFileTransferManager = (TroopFileTransferManager)TroopFileTransferManager.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l));
      if (localTroopFileTransferManager == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileTransferManager", 4, "bad troopUin" + l);
        }
        return;
      }
      String str = paramBundle.getString("itemKey");
      if (str == null) {
        return;
      }
      localObject = UUID.fromString(str);
      try
      {
        localObject = (TroopFileTransferManager.Item)localTroopFileTransferManager.b.get(localObject);
        if (localObject == null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("TroopFileTransferManager", 4, "bad item key" + str);
          }
          return;
        }
      }
      finally {}
    }
    finally {}
    if ((!paramBoolean) || (paramRspBody == null))
    {
      if (((TroopFileTransferManager.Item)localObject).BusId == 38)
      {
        a((TroopFileTransferManager.Item)localObject, paramRspBody, paramBundle.getLong("sessionId"));
        return;
      }
      if ((((TroopFileTransferManager.Item)localObject).BusId == 3) || (((TroopFileTransferManager.Item)localObject).BusId == 106))
      {
        a((TroopFileTransferManager.Item)localObject, paramRspBody, paramBundle.getLong("sessionId"));
        return;
      }
      if (((TroopFileTransferManager.Item)localObject).BusId == 25)
      {
        b((TroopFileTransferManager.Item)localObject, paramRspBody);
        return;
      }
      if ((((TroopFileTransferManager.Item)localObject).BusId == 102) || (((TroopFileTransferManager.Item)localObject).BusId == 104)) {
        a((TroopFileTransferManager.Item)localObject, paramRspBody);
      }
    }
    else
    {
      l = paramBundle.getLong("sessionId");
      int i = paramRspBody.int32_ret_code.get();
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopFileTransferManager", 4, String.format("onCopyToResult - retCode: %d", new Object[] { Integer.valueOf(i) }));
      }
      if (((TroopFileTransferManager.Item)localObject).BusId == 25)
      {
        b((TroopFileTransferManager.Item)localObject, paramRspBody);
        return;
      }
      if ((((TroopFileTransferManager.Item)localObject).BusId == 102) || (((TroopFileTransferManager.Item)localObject).BusId == 104))
      {
        a((TroopFileTransferManager.Item)localObject, paramRspBody);
        return;
      }
      if ((((TroopFileTransferManager.Item)localObject).BusId == 3) || (((TroopFileTransferManager.Item)localObject).BusId == 106) || (((TroopFileTransferManager.Item)localObject).BusId == 38)) {
        a((TroopFileTransferManager.Item)localObject, paramRspBody, l);
      }
    }
  }
  
  public final void b(TroopFileTransferManager.Item paramItem, cmd0x383.RspBody paramRspBody)
  {
    int j = 702;
    if (paramRspBody == null) {}
    try
    {
      paramRspBody = new TroopFileError.SimpleErrorInfo(paramItem.FileName, this.a.f, 5, 601);
      this.a.a(paramItem, 5, paramRspBody);
      return;
    }
    finally {}
    int k = paramRspBody.int32_ret_code.get();
    paramRspBody = paramRspBody.str_client_wording.get();
    if (QLog.isDevelopLevel()) {
      QLog.e("TroopFileTransferManager", 4, String.format("onRspCopyToWeiyun - retCode: %d", new Object[] { Integer.valueOf(k) }));
    }
    ResponseHandler.a(k);
    int i;
    if (k != 0)
    {
      i = j;
      switch (k)
      {
      }
    }
    for (;;)
    {
      paramRspBody = new TroopFileError.SimpleErrorInfo(paramItem.FileName, this.a.f, 5, i, paramRspBody);
      this.a.a(paramItem, 5, paramRspBody);
      break;
      i = 202;
      continue;
      i = j;
      if (paramItem.BusId == 102)
      {
        paramItem.BusId = 104;
        TroopFileProtocol.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.a.f, paramItem, this.a.f, 0L, TroopFileTransferManager.a(this.a));
        break;
        if (!TextUtils.isEmpty(paramRspBody))
        {
          i = 704;
          continue;
          paramRspBody = new TroopFileError.SimpleErrorInfo(paramItem.FileName, this.a.f, 5, 602);
          this.a.a(paramItem, 5, paramRspBody);
          break;
        }
        i = 601;
        continue;
        i = 703;
        continue;
        i = 701;
        continue;
        i = 705;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajou
 * JD-Core Version:    0.7.0.1
 */