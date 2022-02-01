import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation185H.1;

public class acsm
  extends acsy
{
  private Runnable a;
  
  protected acsm(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation185H.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    acvc.b("GdtMotiveVideoAd", "185H doAnimation " + this.jdField_a_of_type_Acsl + " targetMode " + paramInt);
    acsi localacsi;
    if (this.jdField_a_of_type_Acsl != null)
    {
      localacsi = (acsi)this.jdField_a_of_type_Acsl;
      a();
      if (paramInt == 1)
      {
        if (localacsi.jdField_a_of_type_AndroidViewView != null) {
          localacsi.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localacsi.jdField_f_of_type_AndroidViewView, localacsi.j, localacsi.k, localacsi.i);
        a(localacsi.jdField_e_of_type_AndroidViewView, localacsi.jdField_g_of_type_Int, localacsi.jdField_h_of_type_Int);
        a(localacsi.jdField_b_of_type_AndroidViewView, localacsi.jdField_a_of_type_Int, localacsi.jdField_b_of_type_Int);
        a(localacsi.jdField_d_of_type_AndroidViewView, localacsi.jdField_e_of_type_Int, localacsi.jdField_f_of_type_Int);
        a(localacsi.jdField_c_of_type_AndroidViewView, localacsi.jdField_c_of_type_Int, localacsi.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localacsi.jdField_f_of_type_AndroidViewView, -localacsi.j, -localacsi.k, -localacsi.i);
    a(localacsi.jdField_e_of_type_AndroidViewView, -localacsi.jdField_g_of_type_Int, -localacsi.jdField_h_of_type_Int);
    a(localacsi.jdField_b_of_type_AndroidViewView, -localacsi.jdField_a_of_type_Int, -localacsi.jdField_b_of_type_Int);
    a(localacsi.jdField_d_of_type_AndroidViewView, -localacsi.jdField_e_of_type_Int, -localacsi.jdField_f_of_type_Int);
    a(localacsi.jdField_c_of_type_AndroidViewView, -localacsi.jdField_c_of_type_Int, -localacsi.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    acsi localacsi = new acsi();
    localacsi.jdField_a_of_type_AndroidViewView = paramView1;
    localacsi.jdField_f_of_type_AndroidViewView = paramView3;
    localacsi.jdField_g_of_type_AndroidViewView = paramView2;
    localacsi.jdField_h_of_type_AndroidViewView = paramView8;
    localacsi.j = acwn.a(-85, 750, acwn.f(this.jdField_a_of_type_AndroidContentContext));
    localacsi.k = acwn.a(-588, 1334, acwn.e(this.jdField_a_of_type_AndroidContentContext));
    localacsi.i = acwn.a(416, 1334, acwn.e(this.jdField_a_of_type_AndroidContentContext));
    paramView1 = (RelativeLayout.LayoutParams)paramView2.getLayoutParams();
    float f = acwn.a(400, 1334, acwn.e(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localacsi.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / acwn.e(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localacsi.jdField_b_of_type_Float = localacsi.jdField_a_of_type_Float;
    }
    localacsi.l = acwn.a(50, 1334, acwn.e(this.jdField_a_of_type_AndroidContentContext));
    localacsi.m = acwn.a(50, 750, acwn.f(this.jdField_a_of_type_AndroidContentContext));
    localacsi.jdField_b_of_type_AndroidViewView = paramView4;
    localacsi.jdField_c_of_type_AndroidViewView = paramView5;
    localacsi.jdField_d_of_type_AndroidViewView = paramView6;
    localacsi.jdField_e_of_type_AndroidViewView = paramView7;
    localacsi.jdField_a_of_type_Int = acwn.a(-436, 750, acwn.f(this.jdField_a_of_type_AndroidContentContext));
    localacsi.jdField_b_of_type_Int = acwn.a(567, 1334, acwn.e(this.jdField_a_of_type_AndroidContentContext));
    localacsi.jdField_c_of_type_Int = acwn.a(-275, 750, acwn.f(this.jdField_a_of_type_AndroidContentContext));
    localacsi.jdField_d_of_type_Int = ((acwn.e(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - acwn.a(196, 1334, acwn.e(this.jdField_a_of_type_AndroidContentContext)));
    localacsi.jdField_e_of_type_Int = acwn.a(-269, 750, acwn.f(this.jdField_a_of_type_AndroidContentContext));
    localacsi.jdField_f_of_type_Int = ((acwn.e(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - acwn.a(196, 1334, acwn.e(this.jdField_a_of_type_AndroidContentContext)));
    localacsi.jdField_g_of_type_Int = acwn.a(-257, 750, acwn.f(this.jdField_a_of_type_AndroidContentContext));
    localacsi.jdField_h_of_type_Int = ((acwn.e(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - acwn.a(196, 1334, acwn.e(this.jdField_a_of_type_AndroidContentContext)));
    a(localacsi, paramView8);
    this.jdField_a_of_type_Acsl = localacsi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsm
 * JD-Core Version:    0.7.0.1
 */