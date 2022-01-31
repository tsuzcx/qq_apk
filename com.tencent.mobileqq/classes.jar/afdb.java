import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopView;

public class afdb
  extends ajey
{
  public afdb(TroopView paramTroopView) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (paramInt2 == 0) {
      this.a.j();
    }
    while (this.a.a()) {
      return;
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = this.a.getResources().getString(2131629250);
    }
    bbmy.a(this.a.a(), 1, paramString1, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afdb
 * JD-Core Version:    0.7.0.1
 */