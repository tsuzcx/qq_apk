import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation585V.1;

public class acel
  extends acex
{
  private Runnable a;
  
  protected acel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation585V.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    acho.b("GdtMotiveVideoAd", "585V doAnimation " + this.jdField_a_of_type_Acei + " targetMode " + paramInt);
    aceh localaceh;
    if (this.jdField_a_of_type_Acei != null)
    {
      localaceh = (aceh)this.jdField_a_of_type_Acei;
      a();
      if (paramInt == 1)
      {
        if (localaceh.jdField_a_of_type_AndroidViewView != null) {
          localaceh.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localaceh.jdField_f_of_type_AndroidViewView, localaceh.j, localaceh.k);
        a(localaceh.jdField_e_of_type_AndroidViewView, localaceh.jdField_g_of_type_Int, localaceh.h);
        a(localaceh.jdField_b_of_type_AndroidViewView, localaceh.jdField_a_of_type_Int, localaceh.jdField_b_of_type_Int);
        a(localaceh.jdField_d_of_type_AndroidViewView, localaceh.jdField_e_of_type_Int, localaceh.jdField_f_of_type_Int);
        a(localaceh.jdField_c_of_type_AndroidViewView, localaceh.jdField_c_of_type_Int, localaceh.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localaceh.jdField_f_of_type_AndroidViewView, -localaceh.j, -localaceh.k);
    a(localaceh.jdField_e_of_type_AndroidViewView, -localaceh.jdField_g_of_type_Int, -localaceh.h);
    a(localaceh.jdField_b_of_type_AndroidViewView, -localaceh.jdField_a_of_type_Int, -localaceh.jdField_b_of_type_Int);
    a(localaceh.jdField_d_of_type_AndroidViewView, -localaceh.jdField_e_of_type_Int, -localaceh.jdField_f_of_type_Int);
    a(localaceh.jdField_c_of_type_AndroidViewView, -localaceh.jdField_c_of_type_Int, -localaceh.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    aceh localaceh = new aceh();
    localaceh.jdField_a_of_type_AndroidViewView = paramView1;
    localaceh.jdField_f_of_type_AndroidViewView = paramView3;
    localaceh.jdField_g_of_type_AndroidViewView = paramView2;
    localaceh.j = aciv.a(-406, 1334, aciv.e(this.jdField_a_of_type_AndroidContentContext));
    localaceh.k = aciv.a(125, 750, aciv.f(this.jdField_a_of_type_AndroidContentContext));
    float f = aciv.a(220, 750, aciv.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localaceh.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / aciv.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localaceh.jdField_b_of_type_Float = localaceh.jdField_a_of_type_Float;
    }
    localaceh.l = aciv.a(50, 750, aciv.f(this.jdField_a_of_type_AndroidContentContext));
    localaceh.m = aciv.a(50, 1334, aciv.e(this.jdField_a_of_type_AndroidContentContext));
    localaceh.jdField_b_of_type_AndroidViewView = paramView4;
    localaceh.jdField_c_of_type_AndroidViewView = paramView5;
    localaceh.jdField_d_of_type_AndroidViewView = paramView6;
    localaceh.jdField_e_of_type_AndroidViewView = paramView7;
    localaceh.jdField_a_of_type_Int = aciv.a(-618, 1334, aciv.e(this.jdField_a_of_type_AndroidContentContext));
    localaceh.jdField_b_of_type_Int = aciv.a(275, 750, aciv.f(this.jdField_a_of_type_AndroidContentContext));
    localaceh.jdField_c_of_type_Int = aciv.a(-457, 1334, aciv.e(this.jdField_a_of_type_AndroidContentContext));
    localaceh.jdField_d_of_type_Int = ((aciv.f(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - aciv.a(196, 750, aciv.f(this.jdField_a_of_type_AndroidContentContext)));
    localaceh.jdField_e_of_type_Int = aciv.a(-451, 1334, aciv.e(this.jdField_a_of_type_AndroidContentContext));
    localaceh.jdField_f_of_type_Int = ((aciv.f(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - aciv.a(196, 750, aciv.f(this.jdField_a_of_type_AndroidContentContext)));
    localaceh.jdField_g_of_type_Int = aciv.a(-440, 1334, aciv.e(this.jdField_a_of_type_AndroidContentContext));
    localaceh.h = ((aciv.f(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - aciv.a(196, 750, aciv.f(this.jdField_a_of_type_AndroidContentContext)));
    a(localaceh, paramView8);
    this.jdField_a_of_type_Acei = localaceh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acel
 * JD-Core Version:    0.7.0.1
 */