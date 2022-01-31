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

class agoe
  implements BusinessObserver
{
  agoe(agod paramagod) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = 0;
    QLog.d("HbSkinLogic", 2, "mObserver type = " + paramInt + " isSuccess = " + paramBoolean + " bundle = " + paramBundle);
    agod.a(this.a, false);
    if (paramBundle != null) {
      switch (paramInt)
      {
      }
    }
    label241:
    do
    {
      return;
      List localList = agod.a(this.a).getList();
      localList.clear();
      agod.a(this.a, localList);
      GetSkinListRsp localGetSkinListRsp = (GetSkinListRsp)paramBundle.getSerializable("rsp");
      QLog.d("HbSkinLogic", 2, "GetSkinListRsp = " + localGetSkinListRsp);
      if (localGetSkinListRsp != null)
      {
        agod localagod = this.a;
        if (localGetSkinListRsp.is_hide_list) {}
        for (paramInt = 8;; paramInt = 0)
        {
          localagod.b(paramInt);
          if (!localGetSkinListRsp.is_hide_list) {
            break label241;
          }
          if (agod.a(this.a) != -1) {
            break;
          }
          agoa.c = agod.a(this.a, -1);
          return;
        }
        agod.b(this.a, true);
        agoa.c = agod.a(this.a, agod.a(this.a));
        return;
        agoa.jdField_a_of_type_Boolean = paramBundle.getBoolean("isCache");
        agod.a(this.a, localGetSkinListRsp.selected_id);
        QLog.d("HbSkinLogic", 2, "rsp size = " + localGetSkinListRsp.skin_list.size() + " serverSkinID = " + agod.b(this.a));
        agoa.c = localGetSkinListRsp.selected_id;
        QLog.d("HbSkinLogic", 2, "select restor: " + agoa.c);
        agod.a(this.a).clear();
        paramInt = i;
        while (paramInt < localGetSkinListRsp.skin_list.size())
        {
          paramBundle = new agoa((SkinInfo)localGetSkinListRsp.skin_list.get(paramInt));
          paramBundle.jdField_a_of_type_Int = (paramInt + 1);
          agod.a(this.a).add(paramBundle);
          paramInt += 1;
        }
        if (!TextUtils.isEmpty(localGetSkinListRsp.more_skin_url)) {
          localList.add(agoc.c(localGetSkinListRsp.more_skin_url));
        }
      }
      agoa.a(localList);
      agod.a(this.a).notifyDataSetChanged();
      agod.b(this.a, agod.a(this.a));
      return;
      paramBundle = (SetSelectedSkinRsp)paramBundle.getSerializable("rsp");
    } while (!QLog.isColorLevel());
    QLog.d("HbSkinLogic", 2, "SetSelectedSkinRsp = " + paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agoe
 * JD-Core Version:    0.7.0.1
 */