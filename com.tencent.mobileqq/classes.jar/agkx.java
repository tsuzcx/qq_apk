import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class agkx
  extends alkl
{
  agkx(agkt paramagkt) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, Boolean paramBoolean1)
  {
    if (paramBoolean)
    {
      if ((this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume())) {
        agkt.a(this.a);
      }
      do
      {
        do
        {
          return;
        } while (paramBoolean1.booleanValue());
        paramString1 = BaseActivity.sTopActivity;
      } while (paramString1 == null);
      bdcd.a(paramString1, 230, paramString1.getString(2131690004), null, null, paramString1.getString(2131720083), new agky(this, paramString1), null).show();
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, paramInt, 0).b(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkx
 * JD-Core Version:    0.7.0.1
 */