import Wallet.GetRandomHbIdiomRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment.IdiomHbBundleInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.observer.BusinessObserver;

public class albz
  implements BusinessObserver
{
  public albz(WordChainHbFragment paramWordChainHbFragment, int paramInt, alca paramalca) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    WordChainHbFragment.a().remove(Integer.valueOf(WordChainHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment).currSelectedSubChannel));
    if (paramInt == 27)
    {
      paramBundle = (GetRandomHbIdiomRsp)paramBundle.getSerializable("rsp");
      if (QLog.isColorLevel()) {
        QLog.d("WordChainHbFragment", 2, "ReportHBGameRsp reportObserver:" + paramBoolean + "|" + paramBundle);
      }
      if ((!paramBoolean) || (paramBundle == null) || (paramBundle.suggestIdioms == null) || (paramBundle.suggestIdioms.size() <= 0)) {
        break label217;
      }
      localalcb = new alcb();
      localalcb.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList(paramBundle.suggestIdioms);
      localalcb.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
      WordChainHbFragment.a().put(Integer.valueOf(this.jdField_a_of_type_Int), localalcb);
      if (QLog.isColorLevel()) {
        QLog.d("WordChainHbFragment", 2, "getIdiomListFromSSO idiomListSize:" + localalcb.jdField_a_of_type_JavaUtilList.size());
      }
      if (this.jdField_a_of_type_Alca != null) {
        this.jdField_a_of_type_Alca.a(true, localalcb.jdField_a_of_type_JavaUtilList);
      }
    }
    label217:
    while (this.jdField_a_of_type_Alca == null)
    {
      alcb localalcb;
      return;
    }
    this.jdField_a_of_type_Alca.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albz
 * JD-Core Version:    0.7.0.1
 */