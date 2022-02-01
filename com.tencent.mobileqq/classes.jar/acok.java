import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation185H.1;

public class acok
  extends acov
{
  private Runnable a;
  
  protected acok(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation185H.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    acqy.b("GdtMotiveVideoAd", "185H doAnimation " + this.jdField_a_of_type_Acoj + " targetMode " + paramInt);
    acog localacog;
    if (this.jdField_a_of_type_Acoj != null)
    {
      localacog = (acog)this.jdField_a_of_type_Acoj;
      a();
      if (paramInt == 1)
      {
        if (localacog.jdField_a_of_type_AndroidViewView != null) {
          localacog.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localacog.jdField_f_of_type_AndroidViewView, localacog.j, localacog.k, localacog.i);
        a(localacog.jdField_e_of_type_AndroidViewView, localacog.jdField_g_of_type_Int, localacog.jdField_h_of_type_Int);
        a(localacog.jdField_b_of_type_AndroidViewView, localacog.jdField_a_of_type_Int, localacog.jdField_b_of_type_Int);
        a(localacog.jdField_d_of_type_AndroidViewView, localacog.jdField_e_of_type_Int, localacog.jdField_f_of_type_Int);
        a(localacog.jdField_c_of_type_AndroidViewView, localacog.jdField_c_of_type_Int, localacog.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localacog.jdField_f_of_type_AndroidViewView, -localacog.j, -localacog.k, -localacog.i);
    a(localacog.jdField_e_of_type_AndroidViewView, -localacog.jdField_g_of_type_Int, -localacog.jdField_h_of_type_Int);
    a(localacog.jdField_b_of_type_AndroidViewView, -localacog.jdField_a_of_type_Int, -localacog.jdField_b_of_type_Int);
    a(localacog.jdField_d_of_type_AndroidViewView, -localacog.jdField_e_of_type_Int, -localacog.jdField_f_of_type_Int);
    a(localacog.jdField_c_of_type_AndroidViewView, -localacog.jdField_c_of_type_Int, -localacog.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    acog localacog = new acog();
    localacog.jdField_a_of_type_AndroidViewView = paramView1;
    localacog.jdField_f_of_type_AndroidViewView = paramView3;
    localacog.jdField_g_of_type_AndroidViewView = paramView2;
    localacog.jdField_h_of_type_AndroidViewView = paramView8;
    localacog.j = acsj.a(-85, 750, acsj.f(this.jdField_a_of_type_AndroidContentContext));
    localacog.k = acsj.a(-588, 1334, acsj.e(this.jdField_a_of_type_AndroidContentContext));
    localacog.i = acsj.a(416, 1334, acsj.e(this.jdField_a_of_type_AndroidContentContext));
    paramView1 = (RelativeLayout.LayoutParams)paramView2.getLayoutParams();
    float f = acsj.a(400, 1334, acsj.e(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localacog.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / acsj.e(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localacog.jdField_b_of_type_Float = localacog.jdField_a_of_type_Float;
    }
    localacog.l = acsj.a(50, 1334, acsj.e(this.jdField_a_of_type_AndroidContentContext));
    localacog.m = acsj.a(50, 750, acsj.f(this.jdField_a_of_type_AndroidContentContext));
    localacog.jdField_b_of_type_AndroidViewView = paramView4;
    localacog.jdField_c_of_type_AndroidViewView = paramView5;
    localacog.jdField_d_of_type_AndroidViewView = paramView6;
    localacog.jdField_e_of_type_AndroidViewView = paramView7;
    localacog.jdField_a_of_type_Int = acsj.a(-436, 750, acsj.f(this.jdField_a_of_type_AndroidContentContext));
    localacog.jdField_b_of_type_Int = acsj.a(567, 1334, acsj.e(this.jdField_a_of_type_AndroidContentContext));
    localacog.jdField_c_of_type_Int = acsj.a(-275, 750, acsj.f(this.jdField_a_of_type_AndroidContentContext));
    localacog.jdField_d_of_type_Int = ((acsj.e(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - acsj.a(196, 1334, acsj.e(this.jdField_a_of_type_AndroidContentContext)));
    localacog.jdField_e_of_type_Int = acsj.a(-269, 750, acsj.f(this.jdField_a_of_type_AndroidContentContext));
    localacog.jdField_f_of_type_Int = ((acsj.e(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - acsj.a(196, 1334, acsj.e(this.jdField_a_of_type_AndroidContentContext)));
    localacog.jdField_g_of_type_Int = acsj.a(-257, 750, acsj.f(this.jdField_a_of_type_AndroidContentContext));
    localacog.jdField_h_of_type_Int = ((acsj.e(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - acsj.a(196, 1334, acsj.e(this.jdField_a_of_type_AndroidContentContext)));
    a(localacog, paramView8);
    this.jdField_a_of_type_Acoj = localacog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acok
 * JD-Core Version:    0.7.0.1
 */