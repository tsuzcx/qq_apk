import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.selectable.CommonMenuWrapper.1;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ajte
  implements ajtq
{
  private static final int e = bdkf.b(72.0F);
  private static final int f = bdkf.b(63.0F);
  public int a;
  private ajto jdField_a_of_type_Ajto;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  bdkz jdField_a_of_type_Bdkz;
  private bhrf jdField_a_of_type_Bhrf;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  public int b;
  private bdkz b;
  private int jdField_c_of_type_Int;
  private bdkz jdField_c_of_type_Bdkz;
  private int d;
  
  private void c()
  {
    if (this.jdField_a_of_type_Ajto == null) {
      throw new IllegalStateException("Delegate has not bound.");
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public ajtf a(View paramView, BaseChatPie paramBaseChatPie)
  {
    int m = 0;
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    int n = arrayOfInt[1];
    int i = arrayOfInt[1];
    i = paramView.getHeight() + i;
    paramView = paramBaseChatPie;
    if (paramBaseChatPie == null)
    {
      paramView = paramBaseChatPie;
      if ((this instanceof ajsw)) {
        paramView = ((ajsw)this).a;
      }
    }
    int j;
    int k;
    if ((paramView != null) && (paramView.a != null) && (paramView.a.getVisibility() == 0))
    {
      paramView.a.getLocationInWindow(arrayOfInt);
      j = arrayOfInt[1];
      if (n + 0 >= e + ImmersiveUtils.jdField_c_of_type_Int) {
        break label344;
      }
      if (i + 0 >= e + ImmersiveUtils.jdField_c_of_type_Int) {
        break label221;
      }
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int + 0 <= e + ImmersiveUtils.jdField_c_of_type_Int)) {
        break label171;
      }
      i = this.jdField_a_of_type_Int + 0;
      k = m;
    }
    for (;;)
    {
      return new ajtf(i, k);
      j = bdkf.b();
      break;
      label171:
      if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int + f + 0 < j))
      {
        i = this.jdField_a_of_type_Int + 0;
        k = 1;
      }
      else
      {
        i = e + ImmersiveUtils.jdField_c_of_type_Int;
        k = m;
        continue;
        label221:
        i += 0;
        if (f + i > j) {
          if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int + 0 > e + ImmersiveUtils.jdField_c_of_type_Int))
          {
            j = this.jdField_a_of_type_Int + 0;
            i = 0;
          }
        }
        for (;;)
        {
          k = i;
          i = j;
          break;
          if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int + f + 0 < j))
          {
            j = this.jdField_a_of_type_Int + 0;
            i = 1;
          }
          else
          {
            j = e + ImmersiveUtils.jdField_c_of_type_Int + f + 0;
            i = 0;
            continue;
            k = 1;
            j = i;
            i = k;
          }
        }
        label344:
        i = j;
        k = m;
        if (n <= j)
        {
          i = n + 0;
          k = m;
        }
      }
    }
  }
  
  @Nullable
  public ajto a()
  {
    return this.jdField_a_of_type_Ajto;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(@Nullable ajto paramajto)
  {
    this.jdField_a_of_type_Ajto = paramajto;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    c();
    bdkz localbdkz;
    if (this.jdField_a_of_type_Ajto.c())
    {
      int i = this.jdField_a_of_type_Ajto.c();
      int j = this.jdField_a_of_type_Ajto.b();
      if (this.jdField_a_of_type_Ajto.a() == i - j) {
        localbdkz = this.b;
      }
    }
    for (;;)
    {
      a(localbdkz, paramView, paramInt1, paramInt2, paramInt3);
      return;
      if (this.jdField_c_of_type_Bdkz != null)
      {
        localbdkz = this.jdField_c_of_type_Bdkz;
      }
      else
      {
        if (this.jdField_a_of_type_Bdkz == null)
        {
          this.jdField_a_of_type_Bdkz = new bdkz();
          this.jdField_a_of_type_Bdkz.a(2131364910, alpo.a(2131702612), 2130838668);
          this.jdField_a_of_type_Bdkz.a(2131376287, alpo.a(2131702610), 2130838686);
          this.jdField_a_of_type_Bdkz.a(2131366750, alpo.a(2131702614), 2130838677);
          this.jdField_a_of_type_Bdkz.a(2131366015, alpo.a(2131702611), 2130838676);
        }
        localbdkz = this.jdField_a_of_type_Bdkz;
        continue;
        localbdkz = this.b;
      }
    }
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, bdkz parambdkz, int paramInt3, boolean paramBoolean)
  {
    a(paramView, paramInt1, paramInt2, parambdkz, paramInt3, paramBoolean, null);
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, bdkz parambdkz, int paramInt3, boolean paramBoolean, Activity paramActivity)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b()))
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(bdbk.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow, paramView.getContext(), parambdkz, this.jdField_a_of_type_AndroidViewView$OnClickListener, true));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(true);
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(2);
    parambdkz = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramInt3 == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      parambdkz.d(paramBoolean);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this.jdField_a_of_type_Bhrf);
      paramView.post(new CommonMenuWrapper.1(this, paramActivity, paramView, paramInt1, paramInt2));
      this.jdField_c_of_type_Int = paramInt1;
      this.d = paramInt2;
      return;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, bdkz parambdkz, boolean paramBoolean, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, parambdkz, paramBoolean, paramInt3, null);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, bdkz parambdkz, boolean paramBoolean, int paramInt3, Activity paramActivity)
  {
    this.b = parambdkz;
    this.jdField_c_of_type_Bdkz = null;
    a(paramView, paramInt1, paramInt2, parambdkz, paramInt3, paramBoolean, paramActivity);
  }
  
  void a(bdkz parambdkz, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, parambdkz, paramInt3, false);
  }
  
  public void a(bdkz parambdkz, boolean paramBoolean)
  {
    this.b = parambdkz;
    this.jdField_c_of_type_Bdkz = null;
    Object localObject;
    int i;
    if ((paramBoolean) && (parambdkz != null))
    {
      localObject = parambdkz.a();
      if ((localObject != null) && (localObject.length > 0))
      {
        parambdkz = new ArrayList(Arrays.asList((Object[])localObject));
        i = 0;
        if (i >= localObject.length) {
          break label171;
        }
        if (localObject[i].a() != 2131364910) {}
      }
    }
    for (;;)
    {
      localObject = new bdlb();
      ((bdlb)localObject).a(2131376287);
      ((bdlb)localObject).a(alpo.a(2131702613));
      ((bdlb)localObject).b(2130838686);
      parambdkz.add(i + 1, localObject);
      this.jdField_c_of_type_Bdkz = new bdkz();
      parambdkz = parambdkz.iterator();
      for (;;)
      {
        if (parambdkz.hasNext())
        {
          localObject = (bdlb)parambdkz.next();
          this.jdField_c_of_type_Bdkz.a((bdlb)localObject);
          continue;
          i += 1;
          break;
        }
      }
      return;
      label171:
      i = 0;
    }
  }
  
  public void a(bhrf parambhrf)
  {
    this.jdField_a_of_type_Bhrf = parambhrf;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b());
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajte
 * JD-Core Version:    0.7.0.1
 */