import com.tencent.mobileqq.binhai.BinHaiMsgDialog;
import com.tencent.mobileqq.binhai.BinHaiMsgDialog.Listener;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class agmi
  implements BinHaiMsgDialog.Listener
{
  public agmi(ScanTorchActivity paramScanTorchActivity) {}
  
  public void a(BinHaiMsgDialog paramBinHaiMsgDialog)
  {
    paramBinHaiMsgDialog.dismiss();
    ScanTorchActivity.n(this.a);
  }
  
  public void b(BinHaiMsgDialog paramBinHaiMsgDialog)
  {
    paramBinHaiMsgDialog.dismiss();
    ScanTorchActivity.n(this.a);
  }
  
  public void c(BinHaiMsgDialog paramBinHaiMsgDialog)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agmi
 * JD-Core Version:    0.7.0.1
 */