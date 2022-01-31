import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.TroopShortcutbarFragment;
import com.tencent.mobileqq.app.QQAppInterface;

public class acmw
  extends bafu
{
  TroopShortcutbarFragment a;
  
  public acmw(QQAppInterface paramQQAppInterface, TroopShortcutbarFragment paramTroopShortcutbarFragment)
  {
    super(paramQQAppInterface);
    this.a = paramTroopShortcutbarFragment;
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    if ((paramLong == this.a.jdField_a_of_type_Long) && (paramBoolean)) {
      this.a.a(false);
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if (paramLong == this.a.jdField_a_of_type_Long)
    {
      if (!paramBoolean) {
        bcql.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ajya.a(2131696504), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      }
      TroopShortcutbarFragment localTroopShortcutbarFragment = this.a;
      if (!paramBoolean) {
        bool = true;
      }
      localTroopShortcutbarFragment.a(bool);
    }
  }
  
  protected void a(long paramLong1, boolean paramBoolean, long paramLong2, int paramInt)
  {
    boolean bool = false;
    if ((paramLong1 == this.a.jdField_a_of_type_Long) && (!paramBoolean))
    {
      bcql.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ajya.a(2131696504), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      TroopShortcutbarFragment localTroopShortcutbarFragment = this.a;
      if (!paramBoolean) {
        bool = true;
      }
      localTroopShortcutbarFragment.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acmw
 * JD-Core Version:    0.7.0.1
 */