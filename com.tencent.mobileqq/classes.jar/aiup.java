import Wallet.BroadCastInfo;
import Wallet.GetBroadCastHbIdiomRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import mqq.observer.BusinessObserver;

class aiup
  implements BusinessObserver
{
  aiup(aiuo paramaiuo) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 28)
    {
      paramBundle = (GetBroadCastHbIdiomRsp)paramBundle.getSerializable("rsp");
      if (paramBundle != null) {
        break label21;
      }
    }
    for (;;)
    {
      return;
      label21:
      if (paramBoolean)
      {
        this.a.jdField_a_of_type_Aiul.a = false;
        Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          BroadCastInfo localBroadCastInfo = (BroadCastInfo)paramBundle.sendlistIdiomInfoDict.get(str);
          if ((this.a.jdField_a_of_type_Aiul.a(str) != null) && (localBroadCastInfo != null)) {
            if (localBroadCastInfo.isFinished == 1) {
              this.a.jdField_a_of_type_Aiul.a(str);
            } else {
              this.a.jdField_a_of_type_Aiul.a(str, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localBroadCastInfo.idiomSeq, localBroadCastInfo.hbIdiom, localBroadCastInfo.hbIdiomLastPY);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiup
 * JD-Core Version:    0.7.0.1
 */