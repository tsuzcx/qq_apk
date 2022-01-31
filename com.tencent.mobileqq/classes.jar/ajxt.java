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

public class ajxt
  implements ajyf
{
  private static final int e = bdoo.b(72.0F);
  private static final int f = bdoo.b(63.0F);
  public int a;
  private ajyd jdField_a_of_type_Ajyd;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  bdpi jdField_a_of_type_Bdpi;
  private bhvm jdField_a_of_type_Bhvm;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  public int b;
  private bdpi b;
  private int jdField_c_of_type_Int;
  private bdpi jdField_c_of_type_Bdpi;
  private int d;
  
  private void c()
  {
    if (this.jdField_a_of_type_Ajyd == null) {
      throw new IllegalStateException("Delegate has not bound.");
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public ajxu a(View paramView, BaseChatPie paramBaseChatPie)
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
      if ((this instanceof ajxl)) {
        paramView = ((ajxl)this).a;
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
      return new ajxu(i, k);
      j = bdoo.b();
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
  public ajyd a()
  {
    return this.jdField_a_of_type_Ajyd;
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
  
  public void a(@Nullable ajyd paramajyd)
  {
    this.jdField_a_of_type_Ajyd = paramajyd;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    c();
    bdpi localbdpi;
    if (this.jdField_a_of_type_Ajyd.c())
    {
      int i = this.jdField_a_of_type_Ajyd.c();
      int j = this.jdField_a_of_type_Ajyd.b();
      if (this.jdField_a_of_type_Ajyd.a() == i - j) {
        localbdpi = this.b;
      }
    }
    for (;;)
    {
      a(localbdpi, paramView, paramInt1, paramInt2, paramInt3);
      return;
      if (this.jdField_c_of_type_Bdpi != null)
      {
        localbdpi = this.jdField_c_of_type_Bdpi;
      }
      else
      {
        if (this.jdField_a_of_type_Bdpi == null)
        {
          this.jdField_a_of_type_Bdpi = new bdpi();
          this.jdField_a_of_type_Bdpi.a(2131364912, alud.a(2131702624), 2130838669);
          this.jdField_a_of_type_Bdpi.a(2131376341, alud.a(2131702622), 2130838687);
          this.jdField_a_of_type_Bdpi.a(2131366760, alud.a(2131702626), 2130838678);
          this.jdField_a_of_type_Bdpi.a(2131366017, alud.a(2131702623), 2130838677);
        }
        localbdpi = this.jdField_a_of_type_Bdpi;
        continue;
        localbdpi = this.b;
      }
    }
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, bdpi parambdpi, int paramInt3, boolean paramBoolean)
  {
    a(paramView, paramInt1, paramInt2, parambdpi, paramInt3, paramBoolean, null);
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, bdpi parambdpi, int paramInt3, boolean paramBoolean, Activity paramActivity)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b()))
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(bdft.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow, paramView.getContext(), parambdpi, this.jdField_a_of_type_AndroidViewView$OnClickListener, true));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(true);
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(2);
    parambdpi = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramInt3 == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      parambdpi.d(paramBoolean);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this.jdField_a_of_type_Bhvm);
      paramView.post(new CommonMenuWrapper.1(this, paramActivity, paramView, paramInt1, paramInt2));
      this.jdField_c_of_type_Int = paramInt1;
      this.d = paramInt2;
      return;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, bdpi parambdpi, boolean paramBoolean, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, parambdpi, paramBoolean, paramInt3, null);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, bdpi parambdpi, boolean paramBoolean, int paramInt3, Activity paramActivity)
  {
    this.b = parambdpi;
    this.jdField_c_of_type_Bdpi = null;
    a(paramView, paramInt1, paramInt2, parambdpi, paramInt3, paramBoolean, paramActivity);
  }
  
  void a(bdpi parambdpi, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, parambdpi, paramInt3, false);
  }
  
  public void a(bdpi parambdpi, boolean paramBoolean)
  {
    this.b = parambdpi;
    this.jdField_c_of_type_Bdpi = null;
    Object localObject;
    int i;
    if ((paramBoolean) && (parambdpi != null))
    {
      localObject = parambdpi.a();
      if ((localObject != null) && (localObject.length > 0))
      {
        parambdpi = new ArrayList(Arrays.asList((Object[])localObject));
        i = 0;
        if (i >= localObject.length) {
          break label171;
        }
        if (localObject[i].a() != 2131364912) {}
      }
    }
    for (;;)
    {
      localObject = new bdpk();
      ((bdpk)localObject).a(2131376341);
      ((bdpk)localObject).a(alud.a(2131702625));
      ((bdpk)localObject).b(2130838687);
      parambdpi.add(i + 1, localObject);
      this.jdField_c_of_type_Bdpi = new bdpi();
      parambdpi = parambdpi.iterator();
      for (;;)
      {
        if (parambdpi.hasNext())
        {
          localObject = (bdpk)parambdpi.next();
          this.jdField_c_of_type_Bdpi.a((bdpk)localObject);
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
  
  public void a(bhvm parambhvm)
  {
    this.jdField_a_of_type_Bhvm = parambhvm;
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
 * Qualified Name:     ajxt
 * JD-Core Version:    0.7.0.1
 */