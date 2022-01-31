import Wallet.GetRandomHbIdiomRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.fragment.IdiomHbFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.observer.BusinessObserver;

public class agzp
  implements BusinessObserver
{
  public agzp(IdiomHbFragment paramIdiomHbFragment, agzq paramagzq) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 27)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentIdiomHbFragment.a = false;
      paramBundle = (GetRandomHbIdiomRsp)paramBundle.getSerializable("rsp");
      if (QLog.isColorLevel()) {
        QLog.d("IdiomHbFragment", 2, "ReportHBGameRsp reportObserver:" + paramBoolean + "|" + paramBundle);
      }
      if ((!paramBoolean) || (paramBundle == null) || (paramBundle.suggestIdioms == null) || (paramBundle.suggestIdioms.size() <= 0)) {
        break label170;
      }
      IdiomHbFragment.a().clear();
      IdiomHbFragment.a().addAll(paramBundle.suggestIdioms);
      if (QLog.isColorLevel()) {
        QLog.d("IdiomHbFragment", 2, "getIdiomListFromSSO idiomListSize:" + IdiomHbFragment.a().size());
      }
      if (this.jdField_a_of_type_Agzq != null) {
        this.jdField_a_of_type_Agzq.a(true, IdiomHbFragment.a());
      }
      IdiomHbFragment.a(System.currentTimeMillis());
    }
    label170:
    while (this.jdField_a_of_type_Agzq == null) {
      return;
    }
    this.jdField_a_of_type_Agzq.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agzp
 * JD-Core Version:    0.7.0.1
 */