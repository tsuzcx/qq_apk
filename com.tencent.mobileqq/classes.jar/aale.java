import android.content.Context;
import android.view.View;

public class aale
  extends aalk
{
  protected aale(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    aanp.b("GdtMotiveVideoAd", "185V doAnimation " + this.jdField_a_of_type_Aalc + " targetMode " + paramInt);
    aala localaala;
    if (this.jdField_a_of_type_Aalc != null)
    {
      localaala = (aala)this.jdField_a_of_type_Aalc;
      a();
      if (paramInt == 1)
      {
        a(localaala.jdField_a_of_type_AndroidViewView, localaala.jdField_a_of_type_Int, 0);
        a(localaala.f, localaala.j, localaala.k);
      }
    }
    else
    {
      return;
    }
    a(localaala.jdField_a_of_type_AndroidViewView, -localaala.jdField_a_of_type_Int, 0);
    a(localaala.f, -localaala.j, -localaala.k);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4)
  {
    aala localaala = new aala();
    localaala.jdField_a_of_type_AndroidViewView = paramView1;
    localaala.f = paramView2;
    localaala.g = paramView3;
    localaala.jdField_a_of_type_Int = aapa.a(-306, 1334, aapa.e(this.jdField_a_of_type_AndroidContentContext));
    localaala.j = aapa.a(-406, 1334, aapa.e(this.jdField_a_of_type_AndroidContentContext));
    localaala.k = aapa.a(125, 750, aapa.f(this.jdField_a_of_type_AndroidContentContext));
    float f = aapa.a(400, 750, aapa.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localaala.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / aapa.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localaala.b = localaala.jdField_a_of_type_Float;
    }
    localaala.l = aapa.a(50, 750, aapa.f(this.jdField_a_of_type_AndroidContentContext));
    localaala.m = aapa.a(-100, 1334, aapa.e(this.jdField_a_of_type_AndroidContentContext));
    a(localaala, paramView4);
    this.jdField_a_of_type_Aalc = localaala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aale
 * JD-Core Version:    0.7.0.1
 */