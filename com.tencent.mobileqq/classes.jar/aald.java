import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation185H.1;

public class aald
  extends aalk
{
  private Runnable a;
  
  protected aald(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation185H.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    aanp.b("GdtMotiveVideoAd", "185H doAnimation " + this.jdField_a_of_type_Aalc + " targetMode " + paramInt);
    aakz localaakz;
    if (this.jdField_a_of_type_Aalc != null)
    {
      localaakz = (aakz)this.jdField_a_of_type_Aalc;
      a();
      if (paramInt == 1)
      {
        if (localaakz.jdField_a_of_type_AndroidViewView != null) {
          localaakz.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localaakz.jdField_f_of_type_AndroidViewView, localaakz.j, localaakz.k, localaakz.i);
        a(localaakz.jdField_e_of_type_AndroidViewView, localaakz.jdField_g_of_type_Int, localaakz.jdField_h_of_type_Int);
        a(localaakz.jdField_b_of_type_AndroidViewView, localaakz.jdField_a_of_type_Int, localaakz.jdField_b_of_type_Int);
        a(localaakz.jdField_d_of_type_AndroidViewView, localaakz.jdField_e_of_type_Int, localaakz.jdField_f_of_type_Int);
        a(localaakz.jdField_c_of_type_AndroidViewView, localaakz.jdField_c_of_type_Int, localaakz.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localaakz.jdField_f_of_type_AndroidViewView, -localaakz.j, -localaakz.k, -localaakz.i);
    a(localaakz.jdField_e_of_type_AndroidViewView, -localaakz.jdField_g_of_type_Int, -localaakz.jdField_h_of_type_Int);
    a(localaakz.jdField_b_of_type_AndroidViewView, -localaakz.jdField_a_of_type_Int, -localaakz.jdField_b_of_type_Int);
    a(localaakz.jdField_d_of_type_AndroidViewView, -localaakz.jdField_e_of_type_Int, -localaakz.jdField_f_of_type_Int);
    a(localaakz.jdField_c_of_type_AndroidViewView, -localaakz.jdField_c_of_type_Int, -localaakz.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    aakz localaakz = new aakz();
    localaakz.jdField_a_of_type_AndroidViewView = paramView1;
    localaakz.jdField_f_of_type_AndroidViewView = paramView3;
    localaakz.jdField_g_of_type_AndroidViewView = paramView2;
    localaakz.jdField_h_of_type_AndroidViewView = paramView8;
    localaakz.j = aapa.a(-85, 750, aapa.f(this.jdField_a_of_type_AndroidContentContext));
    localaakz.k = aapa.a(-588, 1334, aapa.e(this.jdField_a_of_type_AndroidContentContext));
    localaakz.i = aapa.a(416, 1334, aapa.e(this.jdField_a_of_type_AndroidContentContext));
    paramView1 = (RelativeLayout.LayoutParams)paramView2.getLayoutParams();
    float f = aapa.a(400, 1334, aapa.e(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localaakz.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / aapa.e(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localaakz.jdField_b_of_type_Float = localaakz.jdField_a_of_type_Float;
    }
    localaakz.l = aapa.a(50, 1334, aapa.e(this.jdField_a_of_type_AndroidContentContext));
    localaakz.m = aapa.a(50, 750, aapa.f(this.jdField_a_of_type_AndroidContentContext));
    localaakz.jdField_b_of_type_AndroidViewView = paramView4;
    localaakz.jdField_c_of_type_AndroidViewView = paramView5;
    localaakz.jdField_d_of_type_AndroidViewView = paramView6;
    localaakz.jdField_e_of_type_AndroidViewView = paramView7;
    localaakz.jdField_a_of_type_Int = aapa.a(-436, 750, aapa.f(this.jdField_a_of_type_AndroidContentContext));
    localaakz.jdField_b_of_type_Int = aapa.a(567, 1334, aapa.e(this.jdField_a_of_type_AndroidContentContext));
    localaakz.jdField_c_of_type_Int = aapa.a(-275, 750, aapa.f(this.jdField_a_of_type_AndroidContentContext));
    localaakz.jdField_d_of_type_Int = ((aapa.e(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - aapa.a(196, 1334, aapa.e(this.jdField_a_of_type_AndroidContentContext)));
    localaakz.jdField_e_of_type_Int = aapa.a(-269, 750, aapa.f(this.jdField_a_of_type_AndroidContentContext));
    localaakz.jdField_f_of_type_Int = ((aapa.e(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - aapa.a(196, 1334, aapa.e(this.jdField_a_of_type_AndroidContentContext)));
    localaakz.jdField_g_of_type_Int = aapa.a(-257, 750, aapa.f(this.jdField_a_of_type_AndroidContentContext));
    localaakz.jdField_h_of_type_Int = ((aapa.e(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - aapa.a(196, 1334, aapa.e(this.jdField_a_of_type_AndroidContentContext)));
    a(localaakz, paramView8);
    this.jdField_a_of_type_Aalc = localaakz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aald
 * JD-Core Version:    0.7.0.1
 */