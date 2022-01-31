import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation585V.1;

public class aalf
  extends aalk
{
  private Runnable a;
  
  protected aalf(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation585V.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    aanp.b("GdtMotiveVideoAd", "585V doAnimation " + this.jdField_a_of_type_Aalc + " targetMode " + paramInt);
    aalb localaalb;
    if (this.jdField_a_of_type_Aalc != null)
    {
      localaalb = (aalb)this.jdField_a_of_type_Aalc;
      a();
      if (paramInt == 1)
      {
        if (localaalb.jdField_a_of_type_AndroidViewView != null) {
          localaalb.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localaalb.jdField_f_of_type_AndroidViewView, localaalb.j, localaalb.k);
        a(localaalb.jdField_e_of_type_AndroidViewView, localaalb.jdField_g_of_type_Int, localaalb.h);
        a(localaalb.jdField_b_of_type_AndroidViewView, localaalb.jdField_a_of_type_Int, localaalb.jdField_b_of_type_Int);
        a(localaalb.jdField_d_of_type_AndroidViewView, localaalb.jdField_e_of_type_Int, localaalb.jdField_f_of_type_Int);
        a(localaalb.jdField_c_of_type_AndroidViewView, localaalb.jdField_c_of_type_Int, localaalb.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localaalb.jdField_f_of_type_AndroidViewView, -localaalb.j, -localaalb.k);
    a(localaalb.jdField_e_of_type_AndroidViewView, -localaalb.jdField_g_of_type_Int, -localaalb.h);
    a(localaalb.jdField_b_of_type_AndroidViewView, -localaalb.jdField_a_of_type_Int, -localaalb.jdField_b_of_type_Int);
    a(localaalb.jdField_d_of_type_AndroidViewView, -localaalb.jdField_e_of_type_Int, -localaalb.jdField_f_of_type_Int);
    a(localaalb.jdField_c_of_type_AndroidViewView, -localaalb.jdField_c_of_type_Int, -localaalb.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    aalb localaalb = new aalb();
    localaalb.jdField_a_of_type_AndroidViewView = paramView1;
    localaalb.jdField_f_of_type_AndroidViewView = paramView3;
    localaalb.jdField_g_of_type_AndroidViewView = paramView2;
    localaalb.j = aapa.a(-406, 1334, aapa.e(this.jdField_a_of_type_AndroidContentContext));
    localaalb.k = aapa.a(125, 750, aapa.f(this.jdField_a_of_type_AndroidContentContext));
    float f = aapa.a(220, 750, aapa.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localaalb.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / aapa.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localaalb.jdField_b_of_type_Float = localaalb.jdField_a_of_type_Float;
    }
    localaalb.l = aapa.a(50, 750, aapa.f(this.jdField_a_of_type_AndroidContentContext));
    localaalb.m = aapa.a(50, 1334, aapa.e(this.jdField_a_of_type_AndroidContentContext));
    localaalb.jdField_b_of_type_AndroidViewView = paramView4;
    localaalb.jdField_c_of_type_AndroidViewView = paramView5;
    localaalb.jdField_d_of_type_AndroidViewView = paramView6;
    localaalb.jdField_e_of_type_AndroidViewView = paramView7;
    localaalb.jdField_a_of_type_Int = aapa.a(-618, 1334, aapa.e(this.jdField_a_of_type_AndroidContentContext));
    localaalb.jdField_b_of_type_Int = aapa.a(275, 750, aapa.f(this.jdField_a_of_type_AndroidContentContext));
    localaalb.jdField_c_of_type_Int = aapa.a(-457, 1334, aapa.e(this.jdField_a_of_type_AndroidContentContext));
    localaalb.jdField_d_of_type_Int = ((aapa.f(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - aapa.a(196, 750, aapa.f(this.jdField_a_of_type_AndroidContentContext)));
    localaalb.jdField_e_of_type_Int = aapa.a(-451, 1334, aapa.e(this.jdField_a_of_type_AndroidContentContext));
    localaalb.jdField_f_of_type_Int = ((aapa.f(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - aapa.a(196, 750, aapa.f(this.jdField_a_of_type_AndroidContentContext)));
    localaalb.jdField_g_of_type_Int = aapa.a(-440, 1334, aapa.e(this.jdField_a_of_type_AndroidContentContext));
    localaalb.h = ((aapa.f(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - aapa.a(196, 750, aapa.f(this.jdField_a_of_type_AndroidContentContext)));
    a(localaalb, paramView8);
    this.jdField_a_of_type_Aalc = localaalb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalf
 * JD-Core Version:    0.7.0.1
 */