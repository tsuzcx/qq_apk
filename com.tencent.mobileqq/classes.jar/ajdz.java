import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

public class ajdz
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131691448 };
  private static final int[] b = { 2130839570 };
  private static final int[] c = { 2131370896 };
  Context jdField_a_of_type_AndroidContentContext;
  private blfk jdField_a_of_type_Blfk;
  
  public ajdz(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public View a(Context paramContext, int paramInt, blfl paramblfl)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Blfk.a(paramContext, localView, paramblfl, -1);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298795);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298796);
    int[] arrayOfInt1 = c;
    int[] arrayOfInt2 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt3 = b;
    this.jdField_a_of_type_Blfk = new ajea(this, 1, 2, new int[] { i, j }, -1, arrayOfInt1, arrayOfInt2, arrayOfInt3);
  }
  
  public void a(Context paramContext, View paramView, int paramInt1, Object paramObject, blfl paramblfl, View.OnClickListener paramOnClickListener, int paramInt2)
  {
    if (this.jdField_a_of_type_Blfk != null) {}
    for (int i = this.jdField_a_of_type_Blfk.a(paramContext, paramView, paramInt1, paramObject, paramblfl, paramOnClickListener);; i = 0)
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
 * Qualified Name:     ajdz
 * JD-Core Version:    0.7.0.1
 */