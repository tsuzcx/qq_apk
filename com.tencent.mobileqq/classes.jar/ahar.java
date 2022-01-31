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

class ahar
  implements BusinessObserver
{
  ahar(ahaq paramahaq) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = 0;
    QLog.d("HbSkinLogic", 2, "mObserver type = " + paramInt + " isSuccess = " + paramBoolean + " bundle = " + paramBundle);
    ahaq.a(this.a, false);
    if (paramBundle != null) {
      switch (paramInt)
      {
      }
    }
    label241:
    do
    {
      return;
      List localList = ahaq.a(this.a).getList();
      localList.clear();
      ahaq.a(this.a, localList);
      GetSkinListRsp localGetSkinListRsp = (GetSkinListRsp)paramBundle.getSerializable("rsp");
      QLog.d("HbSkinLogic", 2, "GetSkinListRsp = " + localGetSkinListRsp);
      if (localGetSkinListRsp != null)
      {
        ahaq localahaq = this.a;
        if (localGetSkinListRsp.is_hide_list) {}
        for (paramInt = 8;; paramInt = 0)
        {
          localahaq.b(paramInt);
          if (!localGetSkinListRsp.is_hide_list) {
            break label241;
          }
          if (ahaq.a(this.a) != -1) {
            break;
          }
          ahan.c = ahaq.a(this.a, -1);
          return;
        }
        ahaq.b(this.a, true);
        ahan.c = ahaq.a(this.a, ahaq.a(this.a));
        return;
        ahan.jdField_a_of_type_Boolean = paramBundle.getBoolean("isCache");
        ahaq.a(this.a, localGetSkinListRsp.selected_id);
        QLog.d("HbSkinLogic", 2, "rsp size = " + localGetSkinListRsp.skin_list.size() + " serverSkinID = " + ahaq.b(this.a));
        ahan.c = localGetSkinListRsp.selected_id;
        QLog.d("HbSkinLogic", 2, "select restor: " + ahan.c);
        ahaq.a(this.a).clear();
        paramInt = i;
        while (paramInt < localGetSkinListRsp.skin_list.size())
        {
          paramBundle = new ahan((SkinInfo)localGetSkinListRsp.skin_list.get(paramInt));
          paramBundle.jdField_a_of_type_Int = (paramInt + 1);
          ahaq.a(this.a).add(paramBundle);
          paramInt += 1;
        }
        if (!TextUtils.isEmpty(localGetSkinListRsp.more_skin_url)) {
          localList.add(ahap.c(localGetSkinListRsp.more_skin_url));
        }
      }
      ahan.a(localList);
      ahaq.a(this.a).notifyDataSetChanged();
      ahaq.b(this.a, ahaq.a(this.a));
      return;
      paramBundle = (SetSelectedSkinRsp)paramBundle.getSerializable("rsp");
    } while (!QLog.isColorLevel());
    QLog.d("HbSkinLogic", 2, "SetSelectedSkinRsp = " + paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahar
 * JD-Core Version:    0.7.0.1
 */