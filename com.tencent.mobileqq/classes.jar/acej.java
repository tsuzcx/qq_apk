import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation185H.1;

public class acej
  extends acex
{
  private Runnable a;
  
  protected acej(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation185H.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    acho.b("GdtMotiveVideoAd", "185H doAnimation " + this.jdField_a_of_type_Acei + " targetMode " + paramInt);
    acef localacef;
    if (this.jdField_a_of_type_Acei != null)
    {
      localacef = (acef)this.jdField_a_of_type_Acei;
      a();
      if (paramInt == 1)
      {
        if (localacef.jdField_a_of_type_AndroidViewView != null) {
          localacef.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localacef.jdField_f_of_type_AndroidViewView, localacef.j, localacef.k, localacef.i);
        a(localacef.jdField_e_of_type_AndroidViewView, localacef.jdField_g_of_type_Int, localacef.jdField_h_of_type_Int);
        a(localacef.jdField_b_of_type_AndroidViewView, localacef.jdField_a_of_type_Int, localacef.jdField_b_of_type_Int);
        a(localacef.jdField_d_of_type_AndroidViewView, localacef.jdField_e_of_type_Int, localacef.jdField_f_of_type_Int);
        a(localacef.jdField_c_of_type_AndroidViewView, localacef.jdField_c_of_type_Int, localacef.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localacef.jdField_f_of_type_AndroidViewView, -localacef.j, -localacef.k, -localacef.i);
    a(localacef.jdField_e_of_type_AndroidViewView, -localacef.jdField_g_of_type_Int, -localacef.jdField_h_of_type_Int);
    a(localacef.jdField_b_of_type_AndroidViewView, -localacef.jdField_a_of_type_Int, -localacef.jdField_b_of_type_Int);
    a(localacef.jdField_d_of_type_AndroidViewView, -localacef.jdField_e_of_type_Int, -localacef.jdField_f_of_type_Int);
    a(localacef.jdField_c_of_type_AndroidViewView, -localacef.jdField_c_of_type_Int, -localacef.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    acef localacef = new acef();
    localacef.jdField_a_of_type_AndroidViewView = paramView1;
    localacef.jdField_f_of_type_AndroidViewView = paramView3;
    localacef.jdField_g_of_type_AndroidViewView = paramView2;
    localacef.jdField_h_of_type_AndroidViewView = paramView8;
    localacef.j = aciv.a(-85, 750, aciv.f(this.jdField_a_of_type_AndroidContentContext));
    localacef.k = aciv.a(-588, 1334, aciv.e(this.jdField_a_of_type_AndroidContentContext));
    localacef.i = aciv.a(416, 1334, aciv.e(this.jdField_a_of_type_AndroidContentContext));
    paramView1 = (RelativeLayout.LayoutParams)paramView2.getLayoutParams();
    float f = aciv.a(400, 1334, aciv.e(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localacef.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / aciv.e(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localacef.jdField_b_of_type_Float = localacef.jdField_a_of_type_Float;
    }
    localacef.l = aciv.a(50, 1334, aciv.e(this.jdField_a_of_type_AndroidContentContext));
    localacef.m = aciv.a(50, 750, aciv.f(this.jdField_a_of_type_AndroidContentContext));
    localacef.jdField_b_of_type_AndroidViewView = paramView4;
    localacef.jdField_c_of_type_AndroidViewView = paramView5;
    localacef.jdField_d_of_type_AndroidViewView = paramView6;
    localacef.jdField_e_of_type_AndroidViewView = paramView7;
    localacef.jdField_a_of_type_Int = aciv.a(-436, 750, aciv.f(this.jdField_a_of_type_AndroidContentContext));
    localacef.jdField_b_of_type_Int = aciv.a(567, 1334, aciv.e(this.jdField_a_of_type_AndroidContentContext));
    localacef.jdField_c_of_type_Int = aciv.a(-275, 750, aciv.f(this.jdField_a_of_type_AndroidContentContext));
    localacef.jdField_d_of_type_Int = ((aciv.e(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - aciv.a(196, 1334, aciv.e(this.jdField_a_of_type_AndroidContentContext)));
    localacef.jdField_e_of_type_Int = aciv.a(-269, 750, aciv.f(this.jdField_a_of_type_AndroidContentContext));
    localacef.jdField_f_of_type_Int = ((aciv.e(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - aciv.a(196, 1334, aciv.e(this.jdField_a_of_type_AndroidContentContext)));
    localacef.jdField_g_of_type_Int = aciv.a(-257, 750, aciv.f(this.jdField_a_of_type_AndroidContentContext));
    localacef.jdField_h_of_type_Int = ((aciv.e(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - aciv.a(196, 1334, aciv.e(this.jdField_a_of_type_AndroidContentContext)));
    a(localacef, paramView8);
    this.jdField_a_of_type_Acei = localacef;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acej
 * JD-Core Version:    0.7.0.1
 */