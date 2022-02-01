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

class akae
  implements BusinessObserver
{
  akae(akad paramakad) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HbSkinLogic", 2, "mObserver type = " + paramInt + " isSuccess = " + paramBoolean + " bundle = " + paramBundle);
    }
    akad.a(this.a, false);
    if (paramBundle != null) {
      switch (paramInt)
      {
      }
    }
    label215:
    do
    {
      return;
      List localList = akad.a(this.a).getList();
      localList.clear();
      akad.a(this.a, localList);
      GetSkinListRsp localGetSkinListRsp = (GetSkinListRsp)paramBundle.getSerializable("rsp");
      if (localGetSkinListRsp != null)
      {
        Object localObject = this.a;
        if (localGetSkinListRsp.is_hide_list) {}
        for (paramInt = 8;; paramInt = 0)
        {
          ((akad)localObject).b(paramInt);
          if (!localGetSkinListRsp.is_hide_list) {
            break label215;
          }
          if (akad.a(this.a) != -1) {
            break;
          }
          akaa.c = akad.a(this.a, -1);
          return;
        }
        akad.b(this.a, true);
        akaa.c = akad.a(this.a, akad.a(this.a));
        return;
        akaa.jdField_a_of_type_Boolean = paramBundle.getBoolean("isCache");
        akad.a(this.a, localGetSkinListRsp.selected_id);
        if (QLog.isColorLevel()) {
          QLog.d("HbSkinLogic", 2, "rsp size = " + localGetSkinListRsp.skin_list.size() + " serverSkinID = " + akad.b(this.a));
        }
        akaa.c = localGetSkinListRsp.selected_id;
        if (QLog.isColorLevel()) {
          QLog.d("HbSkinLogic", 2, "select restor: " + akaa.c);
        }
        akad.a(this.a).clear();
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
          paramBundle = new akaa((SkinInfo)localObject);
          paramBundle.jdField_a_of_type_Int = (paramInt + 1);
          akad.a(this.a).add(paramBundle);
          paramInt += 1;
        }
        if (!TextUtils.isEmpty(localGetSkinListRsp.more_skin_url)) {
          localList.add(akac.c(localGetSkinListRsp.more_skin_url));
        }
      }
      akaa.a(localList);
      akad.a(this.a).notifyDataSetChanged();
      akad.b(this.a, akad.a(this.a));
      return;
      paramBundle = (SetSelectedSkinRsp)paramBundle.getSerializable("rsp");
    } while (!QLog.isColorLevel());
    QLog.d("HbSkinLogic", 2, "SetSelectedSkinRsp = " + paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akae
 * JD-Core Version:    0.7.0.1
 */