import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation585V.1;

public class acso
  extends acsy
{
  private Runnable a;
  
  protected acso(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation585V.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    acvc.b("GdtMotiveVideoAd", "585V doAnimation " + this.jdField_a_of_type_Acsl + " targetMode " + paramInt);
    acsk localacsk;
    if (this.jdField_a_of_type_Acsl != null)
    {
      localacsk = (acsk)this.jdField_a_of_type_Acsl;
      a();
      if (paramInt == 1)
      {
        if (localacsk.jdField_a_of_type_AndroidViewView != null) {
          localacsk.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localacsk.jdField_f_of_type_AndroidViewView, localacsk.j, localacsk.k);
        a(localacsk.jdField_e_of_type_AndroidViewView, localacsk.jdField_g_of_type_Int, localacsk.h);
        a(localacsk.jdField_b_of_type_AndroidViewView, localacsk.jdField_a_of_type_Int, localacsk.jdField_b_of_type_Int);
        a(localacsk.jdField_d_of_type_AndroidViewView, localacsk.jdField_e_of_type_Int, localacsk.jdField_f_of_type_Int);
        a(localacsk.jdField_c_of_type_AndroidViewView, localacsk.jdField_c_of_type_Int, localacsk.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localacsk.jdField_f_of_type_AndroidViewView, -localacsk.j, -localacsk.k);
    a(localacsk.jdField_e_of_type_AndroidViewView, -localacsk.jdField_g_of_type_Int, -localacsk.h);
    a(localacsk.jdField_b_of_type_AndroidViewView, -localacsk.jdField_a_of_type_Int, -localacsk.jdField_b_of_type_Int);
    a(localacsk.jdField_d_of_type_AndroidViewView, -localacsk.jdField_e_of_type_Int, -localacsk.jdField_f_of_type_Int);
    a(localacsk.jdField_c_of_type_AndroidViewView, -localacsk.jdField_c_of_type_Int, -localacsk.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    acsk localacsk = new acsk();
    localacsk.jdField_a_of_type_AndroidViewView = paramView1;
    localacsk.jdField_f_of_type_AndroidViewView = paramView3;
    localacsk.jdField_g_of_type_AndroidViewView = paramView2;
    localacsk.j = acwn.a(-406, 1334, acwn.e(this.jdField_a_of_type_AndroidContentContext));
    localacsk.k = acwn.a(125, 750, acwn.f(this.jdField_a_of_type_AndroidContentContext));
    float f = acwn.a(220, 750, acwn.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localacsk.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / acwn.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localacsk.jdField_b_of_type_Float = localacsk.jdField_a_of_type_Float;
    }
    localacsk.l = acwn.a(50, 750, acwn.f(this.jdField_a_of_type_AndroidContentContext));
    localacsk.m = acwn.a(50, 1334, acwn.e(this.jdField_a_of_type_AndroidContentContext));
    localacsk.jdField_b_of_type_AndroidViewView = paramView4;
    localacsk.jdField_c_of_type_AndroidViewView = paramView5;
    localacsk.jdField_d_of_type_AndroidViewView = paramView6;
    localacsk.jdField_e_of_type_AndroidViewView = paramView7;
    localacsk.jdField_a_of_type_Int = acwn.a(-618, 1334, acwn.e(this.jdField_a_of_type_AndroidContentContext));
    localacsk.jdField_b_of_type_Int = acwn.a(275, 750, acwn.f(this.jdField_a_of_type_AndroidContentContext));
    localacsk.jdField_c_of_type_Int = acwn.a(-457, 1334, acwn.e(this.jdField_a_of_type_AndroidContentContext));
    localacsk.jdField_d_of_type_Int = ((acwn.f(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - acwn.a(196, 750, acwn.f(this.jdField_a_of_type_AndroidContentContext)));
    localacsk.jdField_e_of_type_Int = acwn.a(-451, 1334, acwn.e(this.jdField_a_of_type_AndroidContentContext));
    localacsk.jdField_f_of_type_Int = ((acwn.f(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - acwn.a(196, 750, acwn.f(this.jdField_a_of_type_AndroidContentContext)));
    localacsk.jdField_g_of_type_Int = acwn.a(-440, 1334, acwn.e(this.jdField_a_of_type_AndroidContentContext));
    localacsk.h = ((acwn.f(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - acwn.a(196, 750, acwn.f(this.jdField_a_of_type_AndroidContentContext)));
    a(localacsk, paramView8);
    this.jdField_a_of_type_Acsl = localacsk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acso
 * JD-Core Version:    0.7.0.1
 */