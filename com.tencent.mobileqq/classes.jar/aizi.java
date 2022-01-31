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

class aizi
  implements BusinessObserver
{
  aizi(aizh paramaizh) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = 0;
    QLog.d("HbSkinLogic", 2, "mObserver type = " + paramInt + " isSuccess = " + paramBoolean + " bundle = " + paramBundle);
    aizh.a(this.a, false);
    if (paramBundle != null) {
      switch (paramInt)
      {
      }
    }
    label241:
    do
    {
      return;
      List localList = aizh.a(this.a).getList();
      localList.clear();
      aizh.a(this.a, localList);
      GetSkinListRsp localGetSkinListRsp = (GetSkinListRsp)paramBundle.getSerializable("rsp");
      QLog.d("HbSkinLogic", 2, "GetSkinListRsp = " + localGetSkinListRsp);
      if (localGetSkinListRsp != null)
      {
        aizh localaizh = this.a;
        if (localGetSkinListRsp.is_hide_list) {}
        for (paramInt = 8;; paramInt = 0)
        {
          localaizh.b(paramInt);
          if (!localGetSkinListRsp.is_hide_list) {
            break label241;
          }
          if (aizh.a(this.a) != -1) {
            break;
          }
          aize.c = aizh.a(this.a, -1);
          return;
        }
        aizh.b(this.a, true);
        aize.c = aizh.a(this.a, aizh.a(this.a));
        return;
        aize.jdField_a_of_type_Boolean = paramBundle.getBoolean("isCache");
        aizh.a(this.a, localGetSkinListRsp.selected_id);
        QLog.d("HbSkinLogic", 2, "rsp size = " + localGetSkinListRsp.skin_list.size() + " serverSkinID = " + aizh.b(this.a));
        aize.c = localGetSkinListRsp.selected_id;
        QLog.d("HbSkinLogic", 2, "select restor: " + aize.c);
        aizh.a(this.a).clear();
        paramInt = i;
        while (paramInt < localGetSkinListRsp.skin_list.size())
        {
          paramBundle = new aize((SkinInfo)localGetSkinListRsp.skin_list.get(paramInt));
          paramBundle.jdField_a_of_type_Int = (paramInt + 1);
          aizh.a(this.a).add(paramBundle);
          paramInt += 1;
        }
        if (!TextUtils.isEmpty(localGetSkinListRsp.more_skin_url)) {
          localList.add(aizg.c(localGetSkinListRsp.more_skin_url));
        }
      }
      aize.a(localList);
      aizh.a(this.a).notifyDataSetChanged();
      aizh.b(this.a, aizh.a(this.a));
      return;
      paramBundle = (SetSelectedSkinRsp)paramBundle.getSerializable("rsp");
    } while (!QLog.isColorLevel());
    QLog.d("HbSkinLogic", 2, "SetSelectedSkinRsp = " + paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizi
 * JD-Core Version:    0.7.0.1
 */