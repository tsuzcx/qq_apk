import android.content.Context;
import android.view.View;

public class abow
  extends abph
{
  protected abow(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    abrl.b("GdtMotiveVideoAd", "185V doAnimation " + this.jdField_a_of_type_Abou + " targetMode " + paramInt);
    abos localabos;
    if (this.jdField_a_of_type_Abou != null)
    {
      localabos = (abos)this.jdField_a_of_type_Abou;
      a();
      if (paramInt == 1)
      {
        a(localabos.jdField_a_of_type_AndroidViewView, localabos.jdField_a_of_type_Int, 0);
        a(localabos.f, localabos.j, localabos.k);
      }
    }
    else
    {
      return;
    }
    a(localabos.jdField_a_of_type_AndroidViewView, -localabos.jdField_a_of_type_Int, 0);
    a(localabos.f, -localabos.j, -localabos.k);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4)
  {
    abos localabos = new abos();
    localabos.jdField_a_of_type_AndroidViewView = paramView1;
    localabos.f = paramView2;
    localabos.g = paramView3;
    localabos.jdField_a_of_type_Int = absw.a(-306, 1334, absw.e(this.jdField_a_of_type_AndroidContentContext));
    localabos.j = absw.a(-406, 1334, absw.e(this.jdField_a_of_type_AndroidContentContext));
    localabos.k = absw.a(125, 750, absw.f(this.jdField_a_of_type_AndroidContentContext));
    float f = absw.a(400, 750, absw.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localabos.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / absw.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localabos.b = localabos.jdField_a_of_type_Float;
    }
    localabos.l = absw.a(50, 750, absw.f(this.jdField_a_of_type_AndroidContentContext));
    localabos.m = absw.a(-100, 1334, absw.e(this.jdField_a_of_type_AndroidContentContext));
    a(localabos, paramView4);
    this.jdField_a_of_type_Abou = localabos;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abow
 * JD-Core Version:    0.7.0.1
 */