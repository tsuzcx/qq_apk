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

public class ajzs
  implements BusinessObserver
{
  public ajzs(WordChainHbFragment paramWordChainHbFragment, int paramInt, ajzt paramajzt) {}
  
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
      localajzu = new ajzu();
      localajzu.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList(paramBundle.suggestIdioms);
      localajzu.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
      WordChainHbFragment.a().put(Integer.valueOf(this.jdField_a_of_type_Int), localajzu);
      if (QLog.isColorLevel()) {
        QLog.d("WordChainHbFragment", 2, "getIdiomListFromSSO idiomListSize:" + localajzu.jdField_a_of_type_JavaUtilList.size());
      }
      if (this.jdField_a_of_type_Ajzt != null) {
        this.jdField_a_of_type_Ajzt.a(true, localajzu.jdField_a_of_type_JavaUtilList);
      }
    }
    label217:
    while (this.jdField_a_of_type_Ajzt == null)
    {
      ajzu localajzu;
      return;
    }
    this.jdField_a_of_type_Ajzt.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzs
 * JD-Core Version:    0.7.0.1
 */