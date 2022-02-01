import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class abkz
  extends aodj
{
  abkz(abkw paramabkw) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      if (paramInt == 1)
      {
        asll.a().a(this.a.app, BaseApplicationImpl.getApplication(), this.a.app.getCurrentAccountUin(), true);
        return;
      }
      asll.a().a(this.a.app, BaseApplicationImpl.getApplication(), this.a.app.getCurrentAccountUin(), false);
      return;
    }
    asll.a().a(this.a.app, BaseApplicationImpl.getApplication(), this.a.app.getCurrentAccountUin(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abkz
 * JD-Core Version:    0.7.0.1
 */