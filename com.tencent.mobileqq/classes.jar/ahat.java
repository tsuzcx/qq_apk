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

class ahat
  implements BusinessObserver
{
  ahat(ahas paramahas) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = 0;
    QLog.d("HbSkinLogic", 2, "mObserver type = " + paramInt + " isSuccess = " + paramBoolean + " bundle = " + paramBundle);
    ahas.a(this.a, false);
    if (paramBundle != null) {
      switch (paramInt)
      {
      }
    }
    label241:
    do
    {
      return;
      List localList = ahas.a(this.a).getList();
      localList.clear();
      ahas.a(this.a, localList);
      GetSkinListRsp localGetSkinListRsp = (GetSkinListRsp)paramBundle.getSerializable("rsp");
      QLog.d("HbSkinLogic", 2, "GetSkinListRsp = " + localGetSkinListRsp);
      if (localGetSkinListRsp != null)
      {
        ahas localahas = this.a;
        if (localGetSkinListRsp.is_hide_list) {}
        for (paramInt = 8;; paramInt = 0)
        {
          localahas.b(paramInt);
          if (!localGetSkinListRsp.is_hide_list) {
            break label241;
          }
          if (ahas.a(this.a) != -1) {
            break;
          }
          ahap.c = ahas.a(this.a, -1);
          return;
        }
        ahas.b(this.a, true);
        ahap.c = ahas.a(this.a, ahas.a(this.a));
        return;
        ahap.jdField_a_of_type_Boolean = paramBundle.getBoolean("isCache");
        ahas.a(this.a, localGetSkinListRsp.selected_id);
        QLog.d("HbSkinLogic", 2, "rsp size = " + localGetSkinListRsp.skin_list.size() + " serverSkinID = " + ahas.b(this.a));
        ahap.c = localGetSkinListRsp.selected_id;
        QLog.d("HbSkinLogic", 2, "select restor: " + ahap.c);
        ahas.a(this.a).clear();
        paramInt = i;
        while (paramInt < localGetSkinListRsp.skin_list.size())
        {
          paramBundle = new ahap((SkinInfo)localGetSkinListRsp.skin_list.get(paramInt));
          paramBundle.jdField_a_of_type_Int = (paramInt + 1);
          ahas.a(this.a).add(paramBundle);
          paramInt += 1;
        }
        if (!TextUtils.isEmpty(localGetSkinListRsp.more_skin_url)) {
          localList.add(ahar.c(localGetSkinListRsp.more_skin_url));
        }
      }
      ahap.a(localList);
      ahas.a(this.a).notifyDataSetChanged();
      ahas.b(this.a, ahas.a(this.a));
      return;
      paramBundle = (SetSelectedSkinRsp)paramBundle.getSerializable("rsp");
    } while (!QLog.isColorLevel());
    QLog.d("HbSkinLogic", 2, "SetSelectedSkinRsp = " + paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahat
 * JD-Core Version:    0.7.0.1
 */