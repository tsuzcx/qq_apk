import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation585V.1;

public class acom
  extends acov
{
  private Runnable a;
  
  protected acom(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation585V.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    acqy.b("GdtMotiveVideoAd", "585V doAnimation " + this.jdField_a_of_type_Acoj + " targetMode " + paramInt);
    acoi localacoi;
    if (this.jdField_a_of_type_Acoj != null)
    {
      localacoi = (acoi)this.jdField_a_of_type_Acoj;
      a();
      if (paramInt == 1)
      {
        if (localacoi.jdField_a_of_type_AndroidViewView != null) {
          localacoi.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localacoi.jdField_f_of_type_AndroidViewView, localacoi.j, localacoi.k);
        a(localacoi.jdField_e_of_type_AndroidViewView, localacoi.jdField_g_of_type_Int, localacoi.h);
        a(localacoi.jdField_b_of_type_AndroidViewView, localacoi.jdField_a_of_type_Int, localacoi.jdField_b_of_type_Int);
        a(localacoi.jdField_d_of_type_AndroidViewView, localacoi.jdField_e_of_type_Int, localacoi.jdField_f_of_type_Int);
        a(localacoi.jdField_c_of_type_AndroidViewView, localacoi.jdField_c_of_type_Int, localacoi.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localacoi.jdField_f_of_type_AndroidViewView, -localacoi.j, -localacoi.k);
    a(localacoi.jdField_e_of_type_AndroidViewView, -localacoi.jdField_g_of_type_Int, -localacoi.h);
    a(localacoi.jdField_b_of_type_AndroidViewView, -localacoi.jdField_a_of_type_Int, -localacoi.jdField_b_of_type_Int);
    a(localacoi.jdField_d_of_type_AndroidViewView, -localacoi.jdField_e_of_type_Int, -localacoi.jdField_f_of_type_Int);
    a(localacoi.jdField_c_of_type_AndroidViewView, -localacoi.jdField_c_of_type_Int, -localacoi.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    acoi localacoi = new acoi();
    localacoi.jdField_a_of_type_AndroidViewView = paramView1;
    localacoi.jdField_f_of_type_AndroidViewView = paramView3;
    localacoi.jdField_g_of_type_AndroidViewView = paramView2;
    localacoi.j = acsj.a(-406, 1334, acsj.e(this.jdField_a_of_type_AndroidContentContext));
    localacoi.k = acsj.a(125, 750, acsj.f(this.jdField_a_of_type_AndroidContentContext));
    float f = acsj.a(220, 750, acsj.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localacoi.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / acsj.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localacoi.jdField_b_of_type_Float = localacoi.jdField_a_of_type_Float;
    }
    localacoi.l = acsj.a(50, 750, acsj.f(this.jdField_a_of_type_AndroidContentContext));
    localacoi.m = acsj.a(50, 1334, acsj.e(this.jdField_a_of_type_AndroidContentContext));
    localacoi.jdField_b_of_type_AndroidViewView = paramView4;
    localacoi.jdField_c_of_type_AndroidViewView = paramView5;
    localacoi.jdField_d_of_type_AndroidViewView = paramView6;
    localacoi.jdField_e_of_type_AndroidViewView = paramView7;
    localacoi.jdField_a_of_type_Int = acsj.a(-618, 1334, acsj.e(this.jdField_a_of_type_AndroidContentContext));
    localacoi.jdField_b_of_type_Int = acsj.a(275, 750, acsj.f(this.jdField_a_of_type_AndroidContentContext));
    localacoi.jdField_c_of_type_Int = acsj.a(-457, 1334, acsj.e(this.jdField_a_of_type_AndroidContentContext));
    localacoi.jdField_d_of_type_Int = ((acsj.f(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - acsj.a(196, 750, acsj.f(this.jdField_a_of_type_AndroidContentContext)));
    localacoi.jdField_e_of_type_Int = acsj.a(-451, 1334, acsj.e(this.jdField_a_of_type_AndroidContentContext));
    localacoi.jdField_f_of_type_Int = ((acsj.f(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - acsj.a(196, 750, acsj.f(this.jdField_a_of_type_AndroidContentContext)));
    localacoi.jdField_g_of_type_Int = acsj.a(-440, 1334, acsj.e(this.jdField_a_of_type_AndroidContentContext));
    localacoi.h = ((acsj.f(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - acsj.a(196, 750, acsj.f(this.jdField_a_of_type_AndroidContentContext)));
    a(localacoi, paramView8);
    this.jdField_a_of_type_Acoj = localacoi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acom
 * JD-Core Version:    0.7.0.1
 */