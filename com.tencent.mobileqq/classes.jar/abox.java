import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation585V.1;

public class abox
  extends abph
{
  private Runnable a;
  
  protected abox(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation585V.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    abrl.b("GdtMotiveVideoAd", "585V doAnimation " + this.jdField_a_of_type_Abou + " targetMode " + paramInt);
    abot localabot;
    if (this.jdField_a_of_type_Abou != null)
    {
      localabot = (abot)this.jdField_a_of_type_Abou;
      a();
      if (paramInt == 1)
      {
        if (localabot.jdField_a_of_type_AndroidViewView != null) {
          localabot.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localabot.jdField_f_of_type_AndroidViewView, localabot.j, localabot.k);
        a(localabot.jdField_e_of_type_AndroidViewView, localabot.jdField_g_of_type_Int, localabot.h);
        a(localabot.jdField_b_of_type_AndroidViewView, localabot.jdField_a_of_type_Int, localabot.jdField_b_of_type_Int);
        a(localabot.jdField_d_of_type_AndroidViewView, localabot.jdField_e_of_type_Int, localabot.jdField_f_of_type_Int);
        a(localabot.jdField_c_of_type_AndroidViewView, localabot.jdField_c_of_type_Int, localabot.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localabot.jdField_f_of_type_AndroidViewView, -localabot.j, -localabot.k);
    a(localabot.jdField_e_of_type_AndroidViewView, -localabot.jdField_g_of_type_Int, -localabot.h);
    a(localabot.jdField_b_of_type_AndroidViewView, -localabot.jdField_a_of_type_Int, -localabot.jdField_b_of_type_Int);
    a(localabot.jdField_d_of_type_AndroidViewView, -localabot.jdField_e_of_type_Int, -localabot.jdField_f_of_type_Int);
    a(localabot.jdField_c_of_type_AndroidViewView, -localabot.jdField_c_of_type_Int, -localabot.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    abot localabot = new abot();
    localabot.jdField_a_of_type_AndroidViewView = paramView1;
    localabot.jdField_f_of_type_AndroidViewView = paramView3;
    localabot.jdField_g_of_type_AndroidViewView = paramView2;
    localabot.j = absw.a(-406, 1334, absw.e(this.jdField_a_of_type_AndroidContentContext));
    localabot.k = absw.a(125, 750, absw.f(this.jdField_a_of_type_AndroidContentContext));
    float f = absw.a(220, 750, absw.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localabot.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / absw.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localabot.jdField_b_of_type_Float = localabot.jdField_a_of_type_Float;
    }
    localabot.l = absw.a(50, 750, absw.f(this.jdField_a_of_type_AndroidContentContext));
    localabot.m = absw.a(50, 1334, absw.e(this.jdField_a_of_type_AndroidContentContext));
    localabot.jdField_b_of_type_AndroidViewView = paramView4;
    localabot.jdField_c_of_type_AndroidViewView = paramView5;
    localabot.jdField_d_of_type_AndroidViewView = paramView6;
    localabot.jdField_e_of_type_AndroidViewView = paramView7;
    localabot.jdField_a_of_type_Int = absw.a(-618, 1334, absw.e(this.jdField_a_of_type_AndroidContentContext));
    localabot.jdField_b_of_type_Int = absw.a(275, 750, absw.f(this.jdField_a_of_type_AndroidContentContext));
    localabot.jdField_c_of_type_Int = absw.a(-457, 1334, absw.e(this.jdField_a_of_type_AndroidContentContext));
    localabot.jdField_d_of_type_Int = ((absw.f(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - absw.a(196, 750, absw.f(this.jdField_a_of_type_AndroidContentContext)));
    localabot.jdField_e_of_type_Int = absw.a(-451, 1334, absw.e(this.jdField_a_of_type_AndroidContentContext));
    localabot.jdField_f_of_type_Int = ((absw.f(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - absw.a(196, 750, absw.f(this.jdField_a_of_type_AndroidContentContext)));
    localabot.jdField_g_of_type_Int = absw.a(-440, 1334, absw.e(this.jdField_a_of_type_AndroidContentContext));
    localabot.h = ((absw.f(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - absw.a(196, 750, absw.f(this.jdField_a_of_type_AndroidContentContext)));
    a(localabot, paramView8);
    this.jdField_a_of_type_Abou = localabot;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abox
 * JD-Core Version:    0.7.0.1
 */