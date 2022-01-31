import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;

class aeoi
  extends ajta
{
  aeoi(aeoe paramaeoe) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, Boolean paramBoolean1)
  {
    if (paramBoolean)
    {
      if ((this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume())) {
        aeoe.a(this.a);
      }
      do
      {
        do
        {
          return;
        } while (paramBoolean1.booleanValue());
        paramString1 = BaseActivity.sTopActivity;
      } while (paramString1 == null);
      bbcv.a(paramString1, 230, paramString1.getString(2131689957), null, null, paramString1.getString(2131719540), new aeoj(this, paramString1), null).show();
      return;
    }
    bcpw.a(this.a.jdField_a_of_type_AndroidContentContext, paramInt, 0).b(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeoi
 * JD-Core Version:    0.7.0.1
 */