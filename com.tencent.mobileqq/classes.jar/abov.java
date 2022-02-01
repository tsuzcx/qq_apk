import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation185H.1;

public class abov
  extends abph
{
  private Runnable a;
  
  protected abov(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation185H.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    abrl.b("GdtMotiveVideoAd", "185H doAnimation " + this.jdField_a_of_type_Abou + " targetMode " + paramInt);
    abor localabor;
    if (this.jdField_a_of_type_Abou != null)
    {
      localabor = (abor)this.jdField_a_of_type_Abou;
      a();
      if (paramInt == 1)
      {
        if (localabor.jdField_a_of_type_AndroidViewView != null) {
          localabor.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localabor.jdField_f_of_type_AndroidViewView, localabor.j, localabor.k, localabor.i);
        a(localabor.jdField_e_of_type_AndroidViewView, localabor.jdField_g_of_type_Int, localabor.jdField_h_of_type_Int);
        a(localabor.jdField_b_of_type_AndroidViewView, localabor.jdField_a_of_type_Int, localabor.jdField_b_of_type_Int);
        a(localabor.jdField_d_of_type_AndroidViewView, localabor.jdField_e_of_type_Int, localabor.jdField_f_of_type_Int);
        a(localabor.jdField_c_of_type_AndroidViewView, localabor.jdField_c_of_type_Int, localabor.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localabor.jdField_f_of_type_AndroidViewView, -localabor.j, -localabor.k, -localabor.i);
    a(localabor.jdField_e_of_type_AndroidViewView, -localabor.jdField_g_of_type_Int, -localabor.jdField_h_of_type_Int);
    a(localabor.jdField_b_of_type_AndroidViewView, -localabor.jdField_a_of_type_Int, -localabor.jdField_b_of_type_Int);
    a(localabor.jdField_d_of_type_AndroidViewView, -localabor.jdField_e_of_type_Int, -localabor.jdField_f_of_type_Int);
    a(localabor.jdField_c_of_type_AndroidViewView, -localabor.jdField_c_of_type_Int, -localabor.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    abor localabor = new abor();
    localabor.jdField_a_of_type_AndroidViewView = paramView1;
    localabor.jdField_f_of_type_AndroidViewView = paramView3;
    localabor.jdField_g_of_type_AndroidViewView = paramView2;
    localabor.jdField_h_of_type_AndroidViewView = paramView8;
    localabor.j = absw.a(-85, 750, absw.f(this.jdField_a_of_type_AndroidContentContext));
    localabor.k = absw.a(-588, 1334, absw.e(this.jdField_a_of_type_AndroidContentContext));
    localabor.i = absw.a(416, 1334, absw.e(this.jdField_a_of_type_AndroidContentContext));
    paramView1 = (RelativeLayout.LayoutParams)paramView2.getLayoutParams();
    float f = absw.a(400, 1334, absw.e(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localabor.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / absw.e(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localabor.jdField_b_of_type_Float = localabor.jdField_a_of_type_Float;
    }
    localabor.l = absw.a(50, 1334, absw.e(this.jdField_a_of_type_AndroidContentContext));
    localabor.m = absw.a(50, 750, absw.f(this.jdField_a_of_type_AndroidContentContext));
    localabor.jdField_b_of_type_AndroidViewView = paramView4;
    localabor.jdField_c_of_type_AndroidViewView = paramView5;
    localabor.jdField_d_of_type_AndroidViewView = paramView6;
    localabor.jdField_e_of_type_AndroidViewView = paramView7;
    localabor.jdField_a_of_type_Int = absw.a(-436, 750, absw.f(this.jdField_a_of_type_AndroidContentContext));
    localabor.jdField_b_of_type_Int = absw.a(567, 1334, absw.e(this.jdField_a_of_type_AndroidContentContext));
    localabor.jdField_c_of_type_Int = absw.a(-275, 750, absw.f(this.jdField_a_of_type_AndroidContentContext));
    localabor.jdField_d_of_type_Int = ((absw.e(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - absw.a(196, 1334, absw.e(this.jdField_a_of_type_AndroidContentContext)));
    localabor.jdField_e_of_type_Int = absw.a(-269, 750, absw.f(this.jdField_a_of_type_AndroidContentContext));
    localabor.jdField_f_of_type_Int = ((absw.e(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - absw.a(196, 1334, absw.e(this.jdField_a_of_type_AndroidContentContext)));
    localabor.jdField_g_of_type_Int = absw.a(-257, 750, absw.f(this.jdField_a_of_type_AndroidContentContext));
    localabor.jdField_h_of_type_Int = ((absw.e(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - absw.a(196, 1334, absw.e(this.jdField_a_of_type_AndroidContentContext)));
    a(localabor, paramView8);
    this.jdField_a_of_type_Abou = localabor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abov
 * JD-Core Version:    0.7.0.1
 */