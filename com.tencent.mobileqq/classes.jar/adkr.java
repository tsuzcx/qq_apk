import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.widget.QQToast;

public class adkr
  extends aodj
{
  public adkr(AuthDevRenameActivity paramAuthDevRenameActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    AuthDevRenameActivity.a(this.a);
    if (!paramBoolean)
    {
      QQToast.a(this.a, this.a.getString(2131691994), 0).b(this.a.getTitleBarHeight());
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adkr
 * JD-Core Version:    0.7.0.1
 */