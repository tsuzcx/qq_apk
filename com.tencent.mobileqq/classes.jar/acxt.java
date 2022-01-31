import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.vip.CUKingCardHelper.CUKingDialogListener;

public final class acxt
  implements CUKingCardHelper.CUKingDialogListener
{
  public acxt(FMDialogUtil.FMDialogInterface paramFMDialogInterface) {}
  
  public void callback(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.a.a();
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acxt
 * JD-Core Version:    0.7.0.1
 */