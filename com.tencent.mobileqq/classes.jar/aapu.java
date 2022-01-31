import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation585V.1;

public class aapu
  extends aapz
{
  private Runnable a;
  
  protected aapu(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation585V.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    aase.b("GdtMotiveVideoAd", "585V doAnimation " + this.jdField_a_of_type_Aapr + " targetMode " + paramInt);
    aapq localaapq;
    if (this.jdField_a_of_type_Aapr != null)
    {
      localaapq = (aapq)this.jdField_a_of_type_Aapr;
      a();
      if (paramInt == 1)
      {
        if (localaapq.jdField_a_of_type_AndroidViewView != null) {
          localaapq.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localaapq.jdField_f_of_type_AndroidViewView, localaapq.j, localaapq.k);
        a(localaapq.jdField_e_of_type_AndroidViewView, localaapq.jdField_g_of_type_Int, localaapq.h);
        a(localaapq.jdField_b_of_type_AndroidViewView, localaapq.jdField_a_of_type_Int, localaapq.jdField_b_of_type_Int);
        a(localaapq.jdField_d_of_type_AndroidViewView, localaapq.jdField_e_of_type_Int, localaapq.jdField_f_of_type_Int);
        a(localaapq.jdField_c_of_type_AndroidViewView, localaapq.jdField_c_of_type_Int, localaapq.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localaapq.jdField_f_of_type_AndroidViewView, -localaapq.j, -localaapq.k);
    a(localaapq.jdField_e_of_type_AndroidViewView, -localaapq.jdField_g_of_type_Int, -localaapq.h);
    a(localaapq.jdField_b_of_type_AndroidViewView, -localaapq.jdField_a_of_type_Int, -localaapq.jdField_b_of_type_Int);
    a(localaapq.jdField_d_of_type_AndroidViewView, -localaapq.jdField_e_of_type_Int, -localaapq.jdField_f_of_type_Int);
    a(localaapq.jdField_c_of_type_AndroidViewView, -localaapq.jdField_c_of_type_Int, -localaapq.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    aapq localaapq = new aapq();
    localaapq.jdField_a_of_type_AndroidViewView = paramView1;
    localaapq.jdField_f_of_type_AndroidViewView = paramView3;
    localaapq.jdField_g_of_type_AndroidViewView = paramView2;
    localaapq.j = aatp.a(-406, 1334, aatp.e(this.jdField_a_of_type_AndroidContentContext));
    localaapq.k = aatp.a(125, 750, aatp.f(this.jdField_a_of_type_AndroidContentContext));
    float f = aatp.a(220, 750, aatp.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localaapq.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / aatp.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localaapq.jdField_b_of_type_Float = localaapq.jdField_a_of_type_Float;
    }
    localaapq.l = aatp.a(50, 750, aatp.f(this.jdField_a_of_type_AndroidContentContext));
    localaapq.m = aatp.a(50, 1334, aatp.e(this.jdField_a_of_type_AndroidContentContext));
    localaapq.jdField_b_of_type_AndroidViewView = paramView4;
    localaapq.jdField_c_of_type_AndroidViewView = paramView5;
    localaapq.jdField_d_of_type_AndroidViewView = paramView6;
    localaapq.jdField_e_of_type_AndroidViewView = paramView7;
    localaapq.jdField_a_of_type_Int = aatp.a(-618, 1334, aatp.e(this.jdField_a_of_type_AndroidContentContext));
    localaapq.jdField_b_of_type_Int = aatp.a(275, 750, aatp.f(this.jdField_a_of_type_AndroidContentContext));
    localaapq.jdField_c_of_type_Int = aatp.a(-457, 1334, aatp.e(this.jdField_a_of_type_AndroidContentContext));
    localaapq.jdField_d_of_type_Int = ((aatp.f(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - aatp.a(196, 750, aatp.f(this.jdField_a_of_type_AndroidContentContext)));
    localaapq.jdField_e_of_type_Int = aatp.a(-451, 1334, aatp.e(this.jdField_a_of_type_AndroidContentContext));
    localaapq.jdField_f_of_type_Int = ((aatp.f(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - aatp.a(196, 750, aatp.f(this.jdField_a_of_type_AndroidContentContext)));
    localaapq.jdField_g_of_type_Int = aatp.a(-440, 1334, aatp.e(this.jdField_a_of_type_AndroidContentContext));
    localaapq.h = ((aatp.f(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - aatp.a(196, 750, aatp.f(this.jdField_a_of_type_AndroidContentContext)));
    a(localaapq, paramView8);
    this.jdField_a_of_type_Aapr = localaapq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapu
 * JD-Core Version:    0.7.0.1
 */