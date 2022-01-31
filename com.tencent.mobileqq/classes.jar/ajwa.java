import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.biz.troop.file.TroopFileProtocol.DeleteFileObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.widget.QQToast;

public class ajwa
  extends TroopFileProtocol.DeleteFileObserver
{
  public ajwa(TroopFileManager paramTroopFileManager) {}
  
  protected void a(boolean paramBoolean, int paramInt, Bundle paramBundle, String paramString1, String paramString2)
  {
    if (paramBundle == null) {
      return;
    }
    int i = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131558448);
    paramBundle = paramBundle.getString("fileId");
    TroopFileTransferUtil.Log.c("TroopFileManager", TroopFileTransferUtil.Log.a, "delete onActionResult: fileId:" + paramBundle + " isSuccess:" + paramBoolean + " errorCode:" + paramInt);
    if (paramBoolean)
    {
      this.a.a(paramBundle);
      return;
    }
    switch (paramInt)
    {
    default: 
      QQToast.a(BaseApplicationImpl.getApplication(), "操作失败,请重试", 0).b(i);
      return;
    case -302: 
    case -301: 
    case -103: 
      QQToast.a(BaseApplicationImpl.getApplication(), "删除失败,目标文件不存在", 0).b(i);
      this.a.a(paramBundle);
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), "仅群主管理员和文件所有者可以删除该文件", 0).b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwa
 * JD-Core Version:    0.7.0.1
 */