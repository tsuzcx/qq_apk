import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.fragment.TroopFragment;

public class affu
  extends ajey
{
  public affu(TroopFragment paramTroopFragment) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (paramInt2 == 0)
    {
      this.a.h();
      if (this.a.isResumed()) {
        if (paramInt1 != 0) {
          break label47;
        }
      }
    }
    label47:
    while (!this.a.isResumed())
    {
      bbmy.a(this.a.getActivity(), 2, ajjy.a(2131649592), 0).a();
      do
      {
        return;
      } while (paramInt1 != 1);
      bbmy.a(this.a.getActivity(), 2, ajjy.a(2131649591), 0).a();
      return;
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = this.a.getResources().getString(2131629250);
    }
    bbmy.a(this.a.getActivity(), 1, paramString1, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     affu
 * JD-Core Version:    0.7.0.1
 */