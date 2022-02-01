import Wallet.GetSkinListRsp;
import Wallet.PopDialog;
import Wallet.SetSelectedSkinRsp;
import Wallet.SkinInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.ArrayList;
import java.util.List;
import mqq.observer.BusinessObserver;

class akvx
  implements BusinessObserver
{
  akvx(akvw paramakvw) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HbSkinLogic", 2, "mObserver type = " + paramInt + " isSuccess = " + paramBoolean + " bundle = " + paramBundle);
    }
    akvw.a(this.a, false);
    if (paramBundle != null) {
      switch (paramInt)
      {
      }
    }
    label215:
    do
    {
      return;
      List localList = akvw.a(this.a).getList();
      localList.clear();
      akvw.a(this.a, localList);
      GetSkinListRsp localGetSkinListRsp = (GetSkinListRsp)paramBundle.getSerializable("rsp");
      if (localGetSkinListRsp != null)
      {
        Object localObject = this.a;
        if (localGetSkinListRsp.is_hide_list) {}
        for (paramInt = 8;; paramInt = 0)
        {
          ((akvw)localObject).b(paramInt);
          if (!localGetSkinListRsp.is_hide_list) {
            break label215;
          }
          if (akvw.a(this.a) != -1) {
            break;
          }
          akvt.c = akvw.a(this.a, -1);
          return;
        }
        akvw.b(this.a, true);
        akvt.c = akvw.a(this.a, akvw.a(this.a));
        return;
        akvt.jdField_a_of_type_Boolean = paramBundle.getBoolean("isCache");
        akvw.a(this.a, localGetSkinListRsp.selected_id);
        if (QLog.isColorLevel()) {
          QLog.d("HbSkinLogic", 2, "rsp size = " + localGetSkinListRsp.skin_list.size() + " serverSkinID = " + akvw.b(this.a));
        }
        akvt.c = localGetSkinListRsp.selected_id;
        if (QLog.isColorLevel()) {
          QLog.d("HbSkinLogic", 2, "select restor: " + akvt.c);
        }
        akvw.a(this.a).clear();
        paramInt = 0;
        while (paramInt < localGetSkinListRsp.skin_list.size())
        {
          localObject = (SkinInfo)localGetSkinListRsp.skin_list.get(paramInt);
          if (QLog.isColorLevel())
          {
            paramBundle = "{}";
            if (((SkinInfo)localObject).pop_dialog != null) {
              paramBundle = String.format("{%s, %s, %s, %s, %s, %s}", new Object[] { ((SkinInfo)localObject).pop_dialog.dialog_tips, ((SkinInfo)localObject).pop_dialog.dialog_title, ((SkinInfo)localObject).pop_dialog.left_tips, ((SkinInfo)localObject).pop_dialog.left_url, ((SkinInfo)localObject).pop_dialog.right_tips, ((SkinInfo)localObject).pop_dialog.right_url });
            }
            QLog.d("HbSkinLogic", 2, "skin_list " + paramInt + " skin_id: " + ((SkinInfo)localObject).skin_id + ", skin_permission_state: " + ((SkinInfo)localObject).skin_permission_state + ", skin_name: " + ((SkinInfo)localObject).skin_name + ", PopDialog: " + paramBundle + ",  is_hide_title: " + ((SkinInfo)localObject).is_hide_title + ", blessing: " + ((SkinInfo)localObject).blessing);
          }
          paramBundle = new akvt((SkinInfo)localObject);
          paramBundle.jdField_a_of_type_Int = (paramInt + 1);
          akvw.a(this.a).add(paramBundle);
          paramInt += 1;
        }
        if (!TextUtils.isEmpty(localGetSkinListRsp.more_skin_url)) {
          localList.add(akvv.c(localGetSkinListRsp.more_skin_url));
        }
      }
      akvt.a(localList);
      akvw.a(this.a).notifyDataSetChanged();
      akvw.b(this.a, akvw.a(this.a));
      return;
      paramBundle = (SetSelectedSkinRsp)paramBundle.getSerializable("rsp");
    } while (!QLog.isColorLevel());
    QLog.d("HbSkinLogic", 2, "SetSelectedSkinRsp = " + paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvx
 * JD-Core Version:    0.7.0.1
 */