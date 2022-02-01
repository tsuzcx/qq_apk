import android.content.Context;
import android.view.View;

public class acol
  extends acov
{
  protected acol(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    acqy.b("GdtMotiveVideoAd", "185V doAnimation " + this.jdField_a_of_type_Acoj + " targetMode " + paramInt);
    acoh localacoh;
    if (this.jdField_a_of_type_Acoj != null)
    {
      localacoh = (acoh)this.jdField_a_of_type_Acoj;
      a();
      if (paramInt == 1)
      {
        a(localacoh.jdField_a_of_type_AndroidViewView, localacoh.jdField_a_of_type_Int, 0);
        a(localacoh.f, localacoh.j, localacoh.k);
      }
    }
    else
    {
      return;
    }
    a(localacoh.jdField_a_of_type_AndroidViewView, -localacoh.jdField_a_of_type_Int, 0);
    a(localacoh.f, -localacoh.j, -localacoh.k);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4)
  {
    acoh localacoh = new acoh();
    localacoh.jdField_a_of_type_AndroidViewView = paramView1;
    localacoh.f = paramView2;
    localacoh.g = paramView3;
    localacoh.jdField_a_of_type_Int = acsj.a(-306, 1334, acsj.e(this.jdField_a_of_type_AndroidContentContext));
    localacoh.j = acsj.a(-406, 1334, acsj.e(this.jdField_a_of_type_AndroidContentContext));
    localacoh.k = acsj.a(125, 750, acsj.f(this.jdField_a_of_type_AndroidContentContext));
    float f = acsj.a(400, 750, acsj.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localacoh.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / acsj.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localacoh.b = localacoh.jdField_a_of_type_Float;
    }
    localacoh.l = acsj.a(50, 750, acsj.f(this.jdField_a_of_type_AndroidContentContext));
    localacoh.m = acsj.a(-100, 1334, acsj.e(this.jdField_a_of_type_AndroidContentContext));
    a(localacoh, paramView4);
    this.jdField_a_of_type_Acoj = localacoh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acol
 * JD-Core Version:    0.7.0.1
 */