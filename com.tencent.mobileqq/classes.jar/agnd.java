import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.binhai.BinHaiHandler;
import com.tencent.mobileqq.binhai.BinHaiOpenRedPackDialog;
import com.tencent.mobileqq.binhai.BinHaiOpenRedPackDialog.Listener;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

class agnd
  implements BinHaiOpenRedPackDialog.Listener
{
  agnd(agnc paramagnc) {}
  
  public void a(BinHaiOpenRedPackDialog paramBinHaiOpenRedPackDialog)
  {
    boolean bool = paramBinHaiOpenRedPackDialog.a();
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "onRedPackDialogBackPress isShowingRank=" + bool);
    }
    if (bool)
    {
      paramBinHaiOpenRedPackDialog.dismiss();
      ScanTorchActivity.w(this.a.a, false);
      this.a.a.finish();
    }
  }
  
  public void a(BinHaiOpenRedPackDialog paramBinHaiOpenRedPackDialog, String paramString1, String paramString2)
  {
    ScanTorchActivity.t(this.a.a, true);
  }
  
  public void b(BinHaiOpenRedPackDialog paramBinHaiOpenRedPackDialog)
  {
    ScanTorchActivity.w(this.a.a, false);
    this.a.a.b.reportClickEvent("dc00898", "", this.a.a.b.getCurrentAccountUin(), "0X8008390", "0X8008390", 0, 0, "", "", paramBinHaiOpenRedPackDialog.h, "");
  }
  
  public void b(BinHaiOpenRedPackDialog paramBinHaiOpenRedPackDialog, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "binhai onOpenRedBag, bill=" + paramString1 + ", actId=" + paramString2);
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1))) {
      ((BinHaiHandler)this.a.a.b.getBusinessHandler(3)).a(paramString2, paramString1);
    }
    this.a.a.b.reportClickEvent("dc00898", "", this.a.a.b.getCurrentAccountUin(), "0X800838F", "0X800838F", 0, 0, "", "", ScanTorchActivity.c(this.a.a), "");
    if (!this.a.a.isFinishing()) {
      ScanTorchActivity.n(this.a.a);
    }
  }
  
  public void c(BinHaiOpenRedPackDialog paramBinHaiOpenRedPackDialog)
  {
    this.a.a.finish();
  }
  
  public void d(BinHaiOpenRedPackDialog paramBinHaiOpenRedPackDialog)
  {
    paramBinHaiOpenRedPackDialog.dismiss();
    ScanTorchActivity.w(this.a.a, false);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agnd
 * JD-Core Version:    0.7.0.1
 */