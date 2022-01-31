import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.binhai.BinHaiHandler;
import com.tencent.mobileqq.binhai.BinHaiMsgDialog;
import com.tencent.mobileqq.binhai.BinHaiMsgDialog.Listener;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class agmh
  implements BinHaiMsgDialog.Listener
{
  public agmh(ScanTorchActivity paramScanTorchActivity) {}
  
  public void a(BinHaiMsgDialog paramBinHaiMsgDialog)
  {
    paramBinHaiMsgDialog.dismiss();
    if (paramBinHaiMsgDialog.jdField_a_of_type_Boolean)
    {
      this.a.finish();
      return;
    }
    ScanTorchActivity.a(this.a, true, 0);
    ((BinHaiHandler)this.a.b.getBusinessHandler(3)).b(ScanTorchActivity.c(this.a), paramBinHaiMsgDialog.jdField_a_of_type_Int);
  }
  
  public void b(BinHaiMsgDialog paramBinHaiMsgDialog)
  {
    paramBinHaiMsgDialog.dismiss();
    this.a.finish();
  }
  
  public void c(BinHaiMsgDialog paramBinHaiMsgDialog)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agmh
 * JD-Core Version:    0.7.0.1
 */