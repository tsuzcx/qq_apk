import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation185H.1;

public class aaps
  extends aapz
{
  private Runnable a;
  
  protected aaps(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation185H.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    aase.b("GdtMotiveVideoAd", "185H doAnimation " + this.jdField_a_of_type_Aapr + " targetMode " + paramInt);
    aapo localaapo;
    if (this.jdField_a_of_type_Aapr != null)
    {
      localaapo = (aapo)this.jdField_a_of_type_Aapr;
      a();
      if (paramInt == 1)
      {
        if (localaapo.jdField_a_of_type_AndroidViewView != null) {
          localaapo.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localaapo.jdField_f_of_type_AndroidViewView, localaapo.j, localaapo.k, localaapo.i);
        a(localaapo.jdField_e_of_type_AndroidViewView, localaapo.jdField_g_of_type_Int, localaapo.jdField_h_of_type_Int);
        a(localaapo.jdField_b_of_type_AndroidViewView, localaapo.jdField_a_of_type_Int, localaapo.jdField_b_of_type_Int);
        a(localaapo.jdField_d_of_type_AndroidViewView, localaapo.jdField_e_of_type_Int, localaapo.jdField_f_of_type_Int);
        a(localaapo.jdField_c_of_type_AndroidViewView, localaapo.jdField_c_of_type_Int, localaapo.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localaapo.jdField_f_of_type_AndroidViewView, -localaapo.j, -localaapo.k, -localaapo.i);
    a(localaapo.jdField_e_of_type_AndroidViewView, -localaapo.jdField_g_of_type_Int, -localaapo.jdField_h_of_type_Int);
    a(localaapo.jdField_b_of_type_AndroidViewView, -localaapo.jdField_a_of_type_Int, -localaapo.jdField_b_of_type_Int);
    a(localaapo.jdField_d_of_type_AndroidViewView, -localaapo.jdField_e_of_type_Int, -localaapo.jdField_f_of_type_Int);
    a(localaapo.jdField_c_of_type_AndroidViewView, -localaapo.jdField_c_of_type_Int, -localaapo.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    aapo localaapo = new aapo();
    localaapo.jdField_a_of_type_AndroidViewView = paramView1;
    localaapo.jdField_f_of_type_AndroidViewView = paramView3;
    localaapo.jdField_g_of_type_AndroidViewView = paramView2;
    localaapo.jdField_h_of_type_AndroidViewView = paramView8;
    localaapo.j = aatp.a(-85, 750, aatp.f(this.jdField_a_of_type_AndroidContentContext));
    localaapo.k = aatp.a(-588, 1334, aatp.e(this.jdField_a_of_type_AndroidContentContext));
    localaapo.i = aatp.a(416, 1334, aatp.e(this.jdField_a_of_type_AndroidContentContext));
    paramView1 = (RelativeLayout.LayoutParams)paramView2.getLayoutParams();
    float f = aatp.a(400, 1334, aatp.e(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localaapo.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / aatp.e(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localaapo.jdField_b_of_type_Float = localaapo.jdField_a_of_type_Float;
    }
    localaapo.l = aatp.a(50, 1334, aatp.e(this.jdField_a_of_type_AndroidContentContext));
    localaapo.m = aatp.a(50, 750, aatp.f(this.jdField_a_of_type_AndroidContentContext));
    localaapo.jdField_b_of_type_AndroidViewView = paramView4;
    localaapo.jdField_c_of_type_AndroidViewView = paramView5;
    localaapo.jdField_d_of_type_AndroidViewView = paramView6;
    localaapo.jdField_e_of_type_AndroidViewView = paramView7;
    localaapo.jdField_a_of_type_Int = aatp.a(-436, 750, aatp.f(this.jdField_a_of_type_AndroidContentContext));
    localaapo.jdField_b_of_type_Int = aatp.a(567, 1334, aatp.e(this.jdField_a_of_type_AndroidContentContext));
    localaapo.jdField_c_of_type_Int = aatp.a(-275, 750, aatp.f(this.jdField_a_of_type_AndroidContentContext));
    localaapo.jdField_d_of_type_Int = ((aatp.e(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - aatp.a(196, 1334, aatp.e(this.jdField_a_of_type_AndroidContentContext)));
    localaapo.jdField_e_of_type_Int = aatp.a(-269, 750, aatp.f(this.jdField_a_of_type_AndroidContentContext));
    localaapo.jdField_f_of_type_Int = ((aatp.e(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - aatp.a(196, 1334, aatp.e(this.jdField_a_of_type_AndroidContentContext)));
    localaapo.jdField_g_of_type_Int = aatp.a(-257, 750, aatp.f(this.jdField_a_of_type_AndroidContentContext));
    localaapo.jdField_h_of_type_Int = ((aatp.e(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - aatp.a(196, 1334, aatp.e(this.jdField_a_of_type_AndroidContentContext)));
    a(localaapo, paramView8);
    this.jdField_a_of_type_Aapr = localaapo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaps
 * JD-Core Version:    0.7.0.1
 */