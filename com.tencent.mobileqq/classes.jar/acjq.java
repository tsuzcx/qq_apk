import android.view.animation.Interpolator;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.internal.ViewCompat;

public final class acjq
  implements Runnable
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private acjp jdField_a_of_type_Acjp;
  private final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private int c = -1;
  
  public acjq(PullToRefreshBase paramPullToRefreshBase, int paramInt1, int paramInt2, long paramLong, acjp paramacjp)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = PullToRefreshBase.a(paramPullToRefreshBase);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Acjp = paramacjp;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase.removeCallbacks(this);
  }
  
  public void run()
  {
    if (this.jdField_b_of_type_Long == -1L)
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int == this.c)) {
        break label128;
      }
      ViewCompat.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase, this);
    }
    label128:
    while (this.jdField_a_of_type_Acjp == null)
    {
      return;
      long l = Math.max(Math.min((System.currentTimeMillis() - this.jdField_b_of_type_Long) * 1000L / this.jdField_a_of_type_Long, 1000L), 0L);
      float f = this.jdField_b_of_type_Int - this.jdField_a_of_type_Int;
      int i = Math.round(this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation((float)l / 1000.0F) * f);
      this.c = (this.jdField_b_of_type_Int - i);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase.a(this.c);
      break;
    }
    this.jdField_a_of_type_Acjp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjq
 * JD-Core Version:    0.7.0.1
 */