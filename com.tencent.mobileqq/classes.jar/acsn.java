import android.content.Context;
import android.view.View;

public class acsn
  extends acsy
{
  protected acsn(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    acvc.b("GdtMotiveVideoAd", "185V doAnimation " + this.jdField_a_of_type_Acsl + " targetMode " + paramInt);
    acsj localacsj;
    if (this.jdField_a_of_type_Acsl != null)
    {
      localacsj = (acsj)this.jdField_a_of_type_Acsl;
      a();
      if (paramInt == 1)
      {
        a(localacsj.jdField_a_of_type_AndroidViewView, localacsj.jdField_a_of_type_Int, 0);
        a(localacsj.f, localacsj.j, localacsj.k);
      }
    }
    else
    {
      return;
    }
    a(localacsj.jdField_a_of_type_AndroidViewView, -localacsj.jdField_a_of_type_Int, 0);
    a(localacsj.f, -localacsj.j, -localacsj.k);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4)
  {
    acsj localacsj = new acsj();
    localacsj.jdField_a_of_type_AndroidViewView = paramView1;
    localacsj.f = paramView2;
    localacsj.g = paramView3;
    localacsj.jdField_a_of_type_Int = acwn.a(-306, 1334, acwn.e(this.jdField_a_of_type_AndroidContentContext));
    localacsj.j = acwn.a(-406, 1334, acwn.e(this.jdField_a_of_type_AndroidContentContext));
    localacsj.k = acwn.a(125, 750, acwn.f(this.jdField_a_of_type_AndroidContentContext));
    float f = acwn.a(400, 750, acwn.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localacsj.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / acwn.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localacsj.b = localacsj.jdField_a_of_type_Float;
    }
    localacsj.l = acwn.a(50, 750, acwn.f(this.jdField_a_of_type_AndroidContentContext));
    localacsj.m = acwn.a(-100, 1334, acwn.e(this.jdField_a_of_type_AndroidContentContext));
    a(localacsj, paramView4);
    this.jdField_a_of_type_Acsl = localacsj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsn
 * JD-Core Version:    0.7.0.1
 */