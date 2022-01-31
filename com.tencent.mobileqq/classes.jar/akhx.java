import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import java.util.Map;

public abstract class akhx
{
  @SuppressLint({"UseSparseArrays"})
  public static Map<Integer, ColorStateList> a;
  protected int a;
  protected akdd a;
  protected akhz a;
  Context jdField_a_of_type_AndroidContentContext;
  protected Drawable a;
  public awbv a;
  protected bhxa a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap(5);
  }
  
  protected akhx(QQAppInterface paramQQAppInterface, Context paramContext, awbv paramawbv)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Awbv = paramawbv;
  }
  
  protected static ColorStateList a(Context paramContext, int paramInt)
  {
    ColorStateList localColorStateList2 = (ColorStateList)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    ColorStateList localColorStateList1 = localColorStateList2;
    if (localColorStateList2 == null)
    {
      localColorStateList1 = paramContext.getResources().getColorStateList(paramInt);
      jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localColorStateList1);
    }
    return localColorStateList1;
  }
  
  protected int a()
  {
    return 1;
  }
  
  protected Drawable a()
  {
    boolean bool = azib.b();
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean != bool)) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {}
    for (;;)
    {
      try
      {
        Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
        if (!bool) {
          continue;
        }
        i = 2130844481;
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localResources.getDrawable(i);
        this.jdField_a_of_type_Boolean = bool;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        int i;
        continue;
      }
      catch (Exception localException)
      {
        continue;
      }
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      i = 2130844480;
    }
  }
  
  public abstract View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener);
  
  protected bhxa a(Context paramContext)
  {
    int i = bdkf.a(152.0F);
    int j = a();
    int k = b();
    paramContext = a();
    int[] arrayOfInt1 = b();
    int[] arrayOfInt2 = c();
    return new akhy(this, j, k, new int[] { i }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  protected void a(int paramInt, bhxc[] paramArrayOfbhxc) {}
  
  public void a(akhz paramakhz)
  {
    this.jdField_a_of_type_Akhz = paramakhz;
  }
  
  public void a(View paramView, int paramInt, akia paramakia, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bhxa != null) {}
    for (int i = this.jdField_a_of_type_Bhxa.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Awbv, paramakia, paramOnClickListener);; i = 0)
    {
      if ((this.jdField_a_of_type_Akdd != null) && (this.jdField_a_of_type_Akdd.jdField_a_of_type_Int != -1))
      {
        if (paramInt != this.jdField_a_of_type_Akdd.jdField_a_of_type_Int) {
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
  
  protected int[] a()
  {
    return null;
  }
  
  protected int b()
  {
    return 1;
  }
  
  protected int[] b()
  {
    return null;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected int[] c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akhx
 * JD-Core Version:    0.7.0.1
 */