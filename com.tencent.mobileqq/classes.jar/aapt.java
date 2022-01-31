import android.content.Context;
import android.view.View;

public class aapt
  extends aapz
{
  protected aapt(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    aase.b("GdtMotiveVideoAd", "185V doAnimation " + this.jdField_a_of_type_Aapr + " targetMode " + paramInt);
    aapp localaapp;
    if (this.jdField_a_of_type_Aapr != null)
    {
      localaapp = (aapp)this.jdField_a_of_type_Aapr;
      a();
      if (paramInt == 1)
      {
        a(localaapp.jdField_a_of_type_AndroidViewView, localaapp.jdField_a_of_type_Int, 0);
        a(localaapp.f, localaapp.j, localaapp.k);
      }
    }
    else
    {
      return;
    }
    a(localaapp.jdField_a_of_type_AndroidViewView, -localaapp.jdField_a_of_type_Int, 0);
    a(localaapp.f, -localaapp.j, -localaapp.k);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4)
  {
    aapp localaapp = new aapp();
    localaapp.jdField_a_of_type_AndroidViewView = paramView1;
    localaapp.f = paramView2;
    localaapp.g = paramView3;
    localaapp.jdField_a_of_type_Int = aatp.a(-306, 1334, aatp.e(this.jdField_a_of_type_AndroidContentContext));
    localaapp.j = aatp.a(-406, 1334, aatp.e(this.jdField_a_of_type_AndroidContentContext));
    localaapp.k = aatp.a(125, 750, aatp.f(this.jdField_a_of_type_AndroidContentContext));
    float f = aatp.a(400, 750, aatp.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localaapp.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / aatp.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localaapp.b = localaapp.jdField_a_of_type_Float;
    }
    localaapp.l = aatp.a(50, 750, aatp.f(this.jdField_a_of_type_AndroidContentContext));
    localaapp.m = aatp.a(-100, 1334, aatp.e(this.jdField_a_of_type_AndroidContentContext));
    a(localaapp, paramView4);
    this.jdField_a_of_type_Aapr = localaapp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapt
 * JD-Core Version:    0.7.0.1
 */