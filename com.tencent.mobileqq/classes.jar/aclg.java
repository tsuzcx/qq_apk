import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopRequestActivity;

public class aclg
  extends akat
{
  public aclg(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void a(String paramString)
  {
    this.a.i();
    paramString = this.a.getString(2131720004);
    bcql.a(this.a, 1, paramString, 0).b(this.a.getTitleBarHeight());
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    this.a.a(2130839315, this.a.getString(2131719543));
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    long l2 = aydd.a().b();
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      l1 = Long.parseLong(paramString1);
      if (!paramBoolean)
      {
        this.a.i();
        if (ayde.a(aydd.a().a(Long.valueOf(l1)), paramInt3, paramString2, paramString4)) {
          this.a.finish();
        }
        return;
      }
      this.a.i();
      this.a.finish();
      ayde.a(aydd.a().a(Long.valueOf(l1)), paramInt1, paramString2, paramInt2);
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
    this.a.a(2130839315, this.a.getString(2131719528));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aclg
 * JD-Core Version:    0.7.0.1
 */