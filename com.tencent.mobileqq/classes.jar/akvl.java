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

public class akvl
  implements BusinessObserver
{
  public akvl(WordChainHbFragment paramWordChainHbFragment, int paramInt, akvm paramakvm) {}
  
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
      localakvn = new akvn();
      localakvn.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList(paramBundle.suggestIdioms);
      localakvn.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
      WordChainHbFragment.a().put(Integer.valueOf(this.jdField_a_of_type_Int), localakvn);
      if (QLog.isColorLevel()) {
        QLog.d("WordChainHbFragment", 2, "getIdiomListFromSSO idiomListSize:" + localakvn.jdField_a_of_type_JavaUtilList.size());
      }
      if (this.jdField_a_of_type_Akvm != null) {
        this.jdField_a_of_type_Akvm.a(true, localakvn.jdField_a_of_type_JavaUtilList);
      }
    }
    label217:
    while (this.jdField_a_of_type_Akvm == null)
    {
      akvn localakvn;
      return;
    }
    this.jdField_a_of_type_Akvm.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvl
 * JD-Core Version:    0.7.0.1
 */