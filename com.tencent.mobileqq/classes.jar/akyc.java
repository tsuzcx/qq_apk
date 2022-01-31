import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.ar.config.WorldCup;
import com.tencent.mobileqq.ar.config.WorldCupConfigInfo;
import com.tencent.mobileqq.ar.config.WorldCupShareInfo;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.worldcup.WorldCupShareFragment;
import com.tencent.qphone.base.util.QLog;

public class akyc
  extends ArMapObserver
{
  public akyc(WorldCupShareFragment paramWorldCupShareFragment) {}
  
  public void onSetWorldCupInfo(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WorldCupShareFragment", 2, "WL_DEBUG onSetWorldCupInfo isSuccess = " + paramBoolean + ", shareId = " + paramString);
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      WorldCupShareInfo localWorldCupShareInfo = WorldCup.a(WorldCupShareFragment.a(this.a)).a();
      WorldCupShareFragment.a(this.a, localWorldCupShareInfo.AIOMsgJumpUrl + "?_wv=16777217&shareid=" + paramString);
    }
    if (this.a.getActivity() != null) {
      this.a.getActivity().runOnUiThread(new akyd(this, paramBoolean, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akyc
 * JD-Core Version:    0.7.0.1
 */