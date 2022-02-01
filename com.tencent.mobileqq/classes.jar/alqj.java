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

public class alqj
  implements alqv
{
  private static final int e = bgtn.b(72.0F);
  private static final int f = bgtn.b(63.0F);
  public int a;
  private alqt jdField_a_of_type_Alqt;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  bguh jdField_a_of_type_Bguh;
  private bkiz jdField_a_of_type_Bkiz;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  public int b;
  private bguh b;
  private int jdField_c_of_type_Int;
  private bguh jdField_c_of_type_Bguh;
  private int d;
  
  private void c()
  {
    if (this.jdField_a_of_type_Alqt == null) {
      throw new IllegalStateException("Delegate has not bound.");
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public alqk a(View paramView, BaseChatPie paramBaseChatPie)
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
      if ((this instanceof alqb)) {
        paramView = ((alqb)this).a;
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
      return new alqk(i, k);
      j = bgtn.b();
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
  public alqt a()
  {
    return this.jdField_a_of_type_Alqt;
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
  
  public void a(@Nullable alqt paramalqt)
  {
    this.jdField_a_of_type_Alqt = paramalqt;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    c();
    bguh localbguh;
    if (this.jdField_a_of_type_Alqt.c())
    {
      int i = this.jdField_a_of_type_Alqt.c();
      int j = this.jdField_a_of_type_Alqt.b();
      if (this.jdField_a_of_type_Alqt.a() == i - j) {
        localbguh = this.b;
      }
    }
    for (;;)
    {
      a(localbguh, paramView, paramInt1, paramInt2, paramInt3);
      return;
      if (this.jdField_c_of_type_Bguh != null)
      {
        localbguh = this.jdField_c_of_type_Bguh;
      }
      else
      {
        if (this.jdField_a_of_type_Bguh == null)
        {
          this.jdField_a_of_type_Bguh = new bguh();
          this.jdField_a_of_type_Bguh.a(2131365147, anni.a(2131701044), 2130838920);
          this.jdField_a_of_type_Bguh.a(2131377124, anni.a(2131701042), 2130838938);
          this.jdField_a_of_type_Bguh.a(2131367027, anni.a(2131701046), 2130838929);
          this.jdField_a_of_type_Bguh.a(2131366271, anni.a(2131701043), 2130838928);
        }
        localbguh = this.jdField_a_of_type_Bguh;
        continue;
        localbguh = this.b;
      }
    }
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, bguh parambguh, int paramInt3, boolean paramBoolean)
  {
    a(paramView, paramInt1, paramInt2, parambguh, paramInt3, paramBoolean, null);
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, bguh parambguh, int paramInt3, boolean paramBoolean, Activity paramActivity)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b()))
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(bgkw.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow, paramView.getContext(), parambguh, this.jdField_a_of_type_AndroidViewView$OnClickListener, true));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(true);
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(2);
    parambguh = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramInt3 == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      parambguh.d(paramBoolean);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this.jdField_a_of_type_Bkiz);
      paramView.post(new CommonMenuWrapper.1(this, paramActivity, paramView, paramInt1, paramInt2));
      this.jdField_c_of_type_Int = paramInt1;
      this.d = paramInt2;
      return;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, bguh parambguh, boolean paramBoolean, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, parambguh, paramBoolean, paramInt3, null);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, bguh parambguh, boolean paramBoolean, int paramInt3, Activity paramActivity)
  {
    this.b = parambguh;
    this.jdField_c_of_type_Bguh = null;
    a(paramView, paramInt1, paramInt2, parambguh, paramInt3, paramBoolean, paramActivity);
  }
  
  void a(bguh parambguh, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, parambguh, paramInt3, false);
  }
  
  public void a(bguh parambguh, boolean paramBoolean)
  {
    this.b = parambguh;
    this.jdField_c_of_type_Bguh = null;
    Object localObject;
    int i;
    if ((paramBoolean) && (parambguh != null))
    {
      localObject = parambguh.a();
      if ((localObject != null) && (localObject.length > 0))
      {
        parambguh = new ArrayList(Arrays.asList((Object[])localObject));
        i = 0;
        if (i >= localObject.length) {
          break label171;
        }
        if (localObject[i].a() != 2131365147) {}
      }
    }
    for (;;)
    {
      localObject = new bguj();
      ((bguj)localObject).a(2131377124);
      ((bguj)localObject).a(anni.a(2131701045));
      ((bguj)localObject).b(2130838938);
      parambguh.add(i + 1, localObject);
      this.jdField_c_of_type_Bguh = new bguh();
      parambguh = parambguh.iterator();
      for (;;)
      {
        if (parambguh.hasNext())
        {
          localObject = (bguj)parambguh.next();
          this.jdField_c_of_type_Bguh.a((bguj)localObject);
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
  
  public void a(bkiz parambkiz)
  {
    this.jdField_a_of_type_Bkiz = parambkiz;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alqj
 * JD-Core Version:    0.7.0.1
 */