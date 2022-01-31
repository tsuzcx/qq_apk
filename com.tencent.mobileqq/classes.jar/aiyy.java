import Wallet.GetRandomHbIdiomRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.observer.BusinessObserver;

public class aiyy
  implements BusinessObserver
{
  public aiyy(WordChainHbFragment paramWordChainHbFragment, aiyz paramaiyz) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 27)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment.a = false;
      paramBundle = (GetRandomHbIdiomRsp)paramBundle.getSerializable("rsp");
      if (QLog.isColorLevel()) {
        QLog.d("WordChainHbFragment", 2, "ReportHBGameRsp reportObserver:" + paramBoolean + "|" + paramBundle);
      }
      if ((!paramBoolean) || (paramBundle == null) || (paramBundle.suggestIdioms == null) || (paramBundle.suggestIdioms.size() <= 0)) {
        break label170;
      }
      WordChainHbFragment.a().clear();
      WordChainHbFragment.a().addAll(paramBundle.suggestIdioms);
      if (QLog.isColorLevel()) {
        QLog.d("WordChainHbFragment", 2, "getIdiomListFromSSO idiomListSize:" + WordChainHbFragment.a().size());
      }
      if (this.jdField_a_of_type_Aiyz != null) {
        this.jdField_a_of_type_Aiyz.a(true, WordChainHbFragment.a());
      }
      WordChainHbFragment.a(System.currentTimeMillis());
    }
    label170:
    while (this.jdField_a_of_type_Aiyz == null) {
      return;
    }
    this.jdField_a_of_type_Aiyz.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyy
 * JD-Core Version:    0.7.0.1
 */