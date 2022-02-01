import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

class afzv
  extends anrc
{
  afzv(afzr paramafzr) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, Boolean paramBoolean1)
  {
    if (paramBoolean)
    {
      if ((this.a.mActivity != null) && (this.a.mActivity.isResume())) {
        afzr.a(this.a);
      }
      do
      {
        do
        {
          return;
        } while (paramBoolean1.booleanValue());
        paramString1 = BaseActivity.sTopActivity;
      } while (paramString1 == null);
      bhdj.a(paramString1, 230, paramString1.getString(2131689946), null, null, paramString1.getString(2131718822), new afzw(this, paramString1), null).show();
      return;
    }
    QQToast.a(this.a.mContext, paramInt, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzv
 * JD-Core Version:    0.7.0.1
 */