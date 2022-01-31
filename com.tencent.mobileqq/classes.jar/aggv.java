import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.mobileqq.ar.ARScanFragment;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArAwardInfo;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.mobileqq.armap.ItemInfo;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aggv
  extends ArMapObserver
{
  public aggv(ScanTorchActivity paramScanTorchActivity) {}
  
  public void onGetARRedDotInfo(boolean paramBoolean, int paramInt, long paramLong)
  {
    SharedPreferences localSharedPreferences = ArMapUtil.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface);
    long l = localSharedPreferences.getLong("key_ar_act_id", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "onGetARRedDotInfo redSwitch = " + paramInt + ",actID = " + paramLong + ",isSuccess = " + paramBoolean + ",savedActID = " + l);
    }
    localSharedPreferences.edit().putLong("key_ar_act_id", paramLong).commit();
    if (paramInt == 1) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      if (paramLong > l)
      {
        this.a.runOnUiThread(new aggy(this));
        localSharedPreferences.edit().putBoolean("key_show_reddot", true).commit();
        this.a.n = true;
      }
      if (paramLong < l)
      {
        this.a.n = false;
        this.a.runOnUiThread(new aggz(this));
        localSharedPreferences.edit().putBoolean("key_show_reddot", false).commit();
      }
      return;
    }
    this.a.n = false;
    this.a.runOnUiThread(new agha(this));
  }
  
  public void onOpenPOI(boolean paramBoolean1, int paramInt1, ItemInfo paramItemInfo, boolean paramBoolean2, int paramInt2, int paramInt3, boolean paramBoolean3)
  {
    if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(300)) {
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(300);
    }
    if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(297))
    {
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(297);
      if (QLog.isColorLevel()) {
        QLog.i("ScanTorchActivity", 2, "onOpenPoi isSuccess: " + paramBoolean1 + ", resultCode: " + paramInt1 + ", holder: " + paramBoolean2 + ", bussiType: " + paramInt2 + ", mode: " + paramInt3 + ", itemInfo: " + paramItemInfo + ", isServerSuccess:" + paramBoolean3);
      }
      if ((paramBoolean1) && (paramInt1 == 0)) {
        break label403;
      }
      switch (paramInt1)
      {
      default: 
        paramItemInfo = "领奖失败，请稍候再试。";
        paramInt1 = 299;
        l = 2000L;
        this.a.jdField_a_of_type_AndroidOsHandler.post(new aggw(this, paramItemInfo));
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt1, ScanTorchActivity.a(this.a)), l);
        ScanTorchActivity.a(this.a, ScanTorchActivity.a(this.a), false);
      }
    }
    label403:
    while ((paramItemInfo == null) || (paramItemInfo.e <= 0)) {
      for (;;)
      {
        return;
        ScanTorchActivity.o(this.a);
        break;
        paramItemInfo = "领奖失败，请稍候再试。";
        paramInt1 = 298;
        long l = 30000L;
        continue;
        paramItemInfo = "你已经领过这里的奖品了。";
        paramInt1 = 299;
        l = 2000L;
        continue;
        paramItemInfo = "请到达指定地点后再扫描领奖。";
        paramInt1 = 299;
        l = 2000L;
        continue;
        paramItemInfo = "今天领奖次数已达到上限。";
        paramInt1 = 299;
        l = 2000L;
        continue;
        paramItemInfo = "来晚了一步，奖品已经发完了。";
        paramInt1 = 299;
        l = 2000L;
        continue;
        paramItemInfo = "领奖失败，请稍候再试。";
        paramInt1 = 298;
        l = 30000L;
      }
    }
    paramItemInfo.h = ScanTorchActivity.a(this.a).a.c;
    this.a.jdField_a_of_type_AndroidOsHandler.post(new aggx(this, paramItemInfo));
    this.a.jdField_a_of_type_ComTencentMobileqqArARScanFragment.b(true);
    ScanTorchActivity.a(this.a).remove(ScanTorchActivity.a(this.a));
    ScanTorchActivity.a(this.a, ScanTorchActivity.a(this.a), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aggv
 * JD-Core Version:    0.7.0.1
 */