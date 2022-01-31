import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardTroopListFragment;

public class abcw
  extends ajsy
{
  public abcw(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (paramInt2 == 0)
    {
      this.a.a();
      if (this.a.isResumed()) {
        if (paramInt1 != 0) {
          break label47;
        }
      }
    }
    label47:
    while (!this.a.isResumed())
    {
      bcql.a(this.a.getActivity(), 2, ajya.a(2131704849), 0).a();
      do
      {
        return;
      } while (paramInt1 != 1);
      bcql.a(this.a.getActivity(), 2, ajya.a(2131704848), 0).a();
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
 * Qualified Name:     abcw
 * JD-Core Version:    0.7.0.1
 */