import android.content.Context;
import android.view.View;

public class acek
  extends acex
{
  protected acek(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    acho.b("GdtMotiveVideoAd", "185V doAnimation " + this.jdField_a_of_type_Acei + " targetMode " + paramInt);
    aceg localaceg;
    if (this.jdField_a_of_type_Acei != null)
    {
      localaceg = (aceg)this.jdField_a_of_type_Acei;
      a();
      if (paramInt == 1)
      {
        a(localaceg.jdField_a_of_type_AndroidViewView, localaceg.jdField_a_of_type_Int, 0);
        a(localaceg.f, localaceg.j, localaceg.k);
      }
    }
    else
    {
      return;
    }
    a(localaceg.jdField_a_of_type_AndroidViewView, -localaceg.jdField_a_of_type_Int, 0);
    a(localaceg.f, -localaceg.j, -localaceg.k);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4)
  {
    aceg localaceg = new aceg();
    localaceg.jdField_a_of_type_AndroidViewView = paramView1;
    localaceg.f = paramView2;
    localaceg.g = paramView3;
    localaceg.jdField_a_of_type_Int = aciv.a(-306, 1334, aciv.e(this.jdField_a_of_type_AndroidContentContext));
    localaceg.j = aciv.a(-406, 1334, aciv.e(this.jdField_a_of_type_AndroidContentContext));
    localaceg.k = aciv.a(125, 750, aciv.f(this.jdField_a_of_type_AndroidContentContext));
    float f = aciv.a(400, 750, aciv.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localaceg.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / aciv.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localaceg.b = localaceg.jdField_a_of_type_Float;
    }
    localaceg.l = aciv.a(50, 750, aciv.f(this.jdField_a_of_type_AndroidContentContext));
    localaceg.m = aciv.a(-100, 1334, aciv.e(this.jdField_a_of_type_AndroidContentContext));
    a(localaceg, paramView4);
    this.jdField_a_of_type_Acei = localaceg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acek
 * JD-Core Version:    0.7.0.1
 */