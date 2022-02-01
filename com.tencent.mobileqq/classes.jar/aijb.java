import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

public class aijb
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131691363 };
  private static final int[] b = { 2130839549 };
  private static final int[] c = { 2131370711 };
  Context jdField_a_of_type_AndroidContentContext;
  private bjty jdField_a_of_type_Bjty;
  
  public aijb(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public View a(Context paramContext, int paramInt, bjtz parambjtz)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Bjty.a(paramContext, localView, parambjtz, -1);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298791);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298792);
    int[] arrayOfInt1 = c;
    int[] arrayOfInt2 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt3 = b;
    this.jdField_a_of_type_Bjty = new aijc(this, 1, 2, new int[] { i, j }, -1, arrayOfInt1, arrayOfInt2, arrayOfInt3);
  }
  
  public void a(Context paramContext, View paramView, int paramInt1, Object paramObject, bjtz parambjtz, View.OnClickListener paramOnClickListener, int paramInt2)
  {
    if (this.jdField_a_of_type_Bjty != null) {}
    for (int i = this.jdField_a_of_type_Bjty.a(paramContext, paramView, paramInt1, paramObject, parambjtz, paramOnClickListener);; i = 0)
    {
      if (paramInt2 != -1)
      {
        if (paramInt1 != paramInt2) {
          paramView.scrollTo(0, 0);
        }
      }
      else {
        return;
      }
      paramView.scrollTo(i, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijb
 * JD-Core Version:    0.7.0.1
 */