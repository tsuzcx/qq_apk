import Wallet.GetSkinListRsp;
import Wallet.SetSelectedSkinRsp;
import Wallet.SkinInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.ArrayList;
import java.util.List;
import mqq.observer.BusinessObserver;

class aiut
  implements BusinessObserver
{
  aiut(aius paramaius) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = 0;
    QLog.d("HbSkinLogic", 2, "mObserver type = " + paramInt + " isSuccess = " + paramBoolean + " bundle = " + paramBundle);
    aius.a(this.a, false);
    if (paramBundle != null) {
      switch (paramInt)
      {
      }
    }
    label241:
    do
    {
      return;
      List localList = aius.a(this.a).getList();
      localList.clear();
      aius.a(this.a, localList);
      GetSkinListRsp localGetSkinListRsp = (GetSkinListRsp)paramBundle.getSerializable("rsp");
      QLog.d("HbSkinLogic", 2, "GetSkinListRsp = " + localGetSkinListRsp);
      if (localGetSkinListRsp != null)
      {
        aius localaius = this.a;
        if (localGetSkinListRsp.is_hide_list) {}
        for (paramInt = 8;; paramInt = 0)
        {
          localaius.b(paramInt);
          if (!localGetSkinListRsp.is_hide_list) {
            break label241;
          }
          if (aius.a(this.a) != -1) {
            break;
          }
          aiup.c = aius.a(this.a, -1);
          return;
        }
        aius.b(this.a, true);
        aiup.c = aius.a(this.a, aius.a(this.a));
        return;
        aiup.jdField_a_of_type_Boolean = paramBundle.getBoolean("isCache");
        aius.a(this.a, localGetSkinListRsp.selected_id);
        QLog.d("HbSkinLogic", 2, "rsp size = " + localGetSkinListRsp.skin_list.size() + " serverSkinID = " + aius.b(this.a));
        aiup.c = localGetSkinListRsp.selected_id;
        QLog.d("HbSkinLogic", 2, "select restor: " + aiup.c);
        aius.a(this.a).clear();
        paramInt = i;
        while (paramInt < localGetSkinListRsp.skin_list.size())
        {
          paramBundle = new aiup((SkinInfo)localGetSkinListRsp.skin_list.get(paramInt));
          paramBundle.jdField_a_of_type_Int = (paramInt + 1);
          aius.a(this.a).add(paramBundle);
          paramInt += 1;
        }
        if (!TextUtils.isEmpty(localGetSkinListRsp.more_skin_url)) {
          localList.add(aiur.c(localGetSkinListRsp.more_skin_url));
        }
      }
      aiup.a(localList);
      aius.a(this.a).notifyDataSetChanged();
      aius.b(this.a, aius.a(this.a));
      return;
      paramBundle = (SetSelectedSkinRsp)paramBundle.getSerializable("rsp");
    } while (!QLog.isColorLevel());
    QLog.d("HbSkinLogic", 2, "SetSelectedSkinRsp = " + paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiut
 * JD-Core Version:    0.7.0.1
 */