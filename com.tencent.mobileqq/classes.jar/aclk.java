import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopRequestActivity;

public class aclk
  extends akav
{
  public aclk(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void a(String paramString)
  {
    this.a.i();
    paramString = this.a.getString(2131719993);
    bcpw.a(this.a, 1, paramString, 0).b(this.a.getTitleBarHeight());
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    this.a.a(2130839315, this.a.getString(2131719532));
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    long l2 = aydb.a().b();
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      l1 = Long.parseLong(paramString1);
      if (!paramBoolean)
      {
        this.a.i();
        if (aydc.a(aydb.a().a(Long.valueOf(l1)), paramInt3, paramString2, paramString4)) {
          this.a.finish();
        }
        return;
      }
      this.a.i();
      this.a.finish();
      aydc.a(aydb.a().a(Long.valueOf(l1)), paramInt1, paramString2, paramInt2);
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
  
  protected void b(boolean paramBoolean, String paramString)
  {
    this.a.a(2130839315, this.a.getString(2131719517));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aclk
 * JD-Core Version:    0.7.0.1
 */