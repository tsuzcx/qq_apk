import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.widget.QQToast;

public class aepl
  extends amwl
{
  public aepl(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void onInsertIntoBlackList(boolean paramBoolean, String paramString)
  {
    this.a.a(2130839630, this.a.getString(2131718430));
  }
  
  protected void onRemoveFromBlackList(boolean paramBoolean, String paramString)
  {
    this.a.a(2130839630, this.a.getString(2131718416));
  }
  
  protected void onSendSystemMsgActionError(String paramString)
  {
    this.a.h();
    paramString = this.a.getString(2131718765);
    QQToast.a(this.a, 1, paramString, 0).b(this.a.getTitleBarHeight());
  }
  
  protected void onSendSystemMsgActionFin(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    long l2 = bcsz.a().b();
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      l1 = Long.parseLong(paramString1);
      if (!paramBoolean)
      {
        this.a.h();
        if (bcta.a(bcsz.a().a(Long.valueOf(l1)), paramInt3, paramString2, paramString4)) {
          this.a.finish();
        }
        return;
      }
      this.a.h();
      this.a.finish();
      bcta.a(bcsz.a().a(Long.valueOf(l1)), paramInt1, paramString2, paramInt2);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aepl
 * JD-Core Version:    0.7.0.1
 */