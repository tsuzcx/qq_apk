import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.fragment.TroopFragment;
import com.tencent.mobileqq.widget.QQToast;

public class ahpg
  extends alkl
{
  public ahpg(TroopFragment paramTroopFragment) {}
  
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
      QQToast.a(this.a.getActivity(), 2, alpo.a(2131715765), 0).a();
      do
      {
        return;
      } while (paramInt1 != 1);
      QQToast.a(this.a.getActivity(), 2, alpo.a(2131715764), 0).a();
      return;
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = this.a.getResources().getString(2131695085);
    }
    QQToast.a(this.a.getActivity(), 1, paramString1, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpg
 * JD-Core Version:    0.7.0.1
 */