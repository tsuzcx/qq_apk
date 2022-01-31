import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.fragment.TroopFragment;

public class afrp
  extends ajsy
{
  public afrp(TroopFragment paramTroopFragment) {}
  
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
      bcql.a(this.a.getActivity(), 2, ajya.a(2131715393), 0).a();
      do
      {
        return;
      } while (paramInt1 != 1);
      bcql.a(this.a.getActivity(), 2, ajya.a(2131715392), 0).a();
      return;
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = this.a.getResources().getString(2131694928);
    }
    bcql.a(this.a.getActivity(), 1, paramString1, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afrp
 * JD-Core Version:    0.7.0.1
 */