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

public class aibw
  implements aici
{
  private static final int e = bbkx.b(72.0F);
  private static final int f = bbkx.b(63.0F);
  public int a;
  private aicg jdField_a_of_type_Aicg;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  bblr jdField_a_of_type_Bblr;
  private bfps jdField_a_of_type_Bfps;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  public int b;
  private bblr b;
  private int jdField_c_of_type_Int;
  private bblr jdField_c_of_type_Bblr;
  private int d;
  
  private void c()
  {
    if (this.jdField_a_of_type_Aicg == null) {
      throw new IllegalStateException("Delegate has not bound.");
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public aibx a(View paramView, BaseChatPie paramBaseChatPie)
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
      if ((this instanceof aibo)) {
        paramView = ((aibo)this).a;
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
      return new aibx(i, k);
      j = bbkx.b();
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
  public aicg a()
  {
    return this.jdField_a_of_type_Aicg;
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
  
  public void a(@Nullable aicg paramaicg)
  {
    this.jdField_a_of_type_Aicg = paramaicg;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    c();
    bblr localbblr;
    if (this.jdField_a_of_type_Aicg.c())
    {
      int i = this.jdField_a_of_type_Aicg.c();
      int j = this.jdField_a_of_type_Aicg.b();
      if (this.jdField_a_of_type_Aicg.a() == i - j) {
        localbblr = this.b;
      }
    }
    for (;;)
    {
      a(localbblr, paramView, paramInt1, paramInt2, paramInt3);
      return;
      if (this.jdField_c_of_type_Bblr != null)
      {
        localbblr = this.jdField_c_of_type_Bblr;
      }
      else
      {
        if (this.jdField_a_of_type_Bblr == null)
        {
          this.jdField_a_of_type_Bblr = new bblr();
          this.jdField_a_of_type_Bblr.a(2131364825, ajyc.a(2131702229), 2130838597);
          this.jdField_a_of_type_Bblr.a(2131375789, ajyc.a(2131702227), 2130838615);
          this.jdField_a_of_type_Bblr.a(2131366632, ajyc.a(2131702231), 2130838606);
          this.jdField_a_of_type_Bblr.a(2131365928, ajyc.a(2131702228), 2130838605);
        }
        localbblr = this.jdField_a_of_type_Bblr;
        continue;
        localbblr = this.b;
      }
    }
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, bblr parambblr, int paramInt3, boolean paramBoolean)
  {
    a(paramView, paramInt1, paramInt2, parambblr, paramInt3, paramBoolean, null);
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, bblr parambblr, int paramInt3, boolean paramBoolean, Activity paramActivity)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b()))
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(bbcc.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow, paramView.getContext(), parambblr, this.jdField_a_of_type_AndroidViewView$OnClickListener, true));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(true);
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(2);
    parambblr = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramInt3 == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      parambblr.d(paramBoolean);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this.jdField_a_of_type_Bfps);
      paramView.post(new CommonMenuWrapper.1(this, paramActivity, paramView, paramInt1, paramInt2));
      this.jdField_c_of_type_Int = paramInt1;
      this.d = paramInt2;
      return;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, bblr parambblr, boolean paramBoolean, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, parambblr, paramBoolean, paramInt3, null);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, bblr parambblr, boolean paramBoolean, int paramInt3, Activity paramActivity)
  {
    this.b = parambblr;
    this.jdField_c_of_type_Bblr = null;
    a(paramView, paramInt1, paramInt2, parambblr, paramInt3, paramBoolean, paramActivity);
  }
  
  void a(bblr parambblr, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, parambblr, paramInt3, false);
  }
  
  public void a(bblr parambblr, boolean paramBoolean)
  {
    this.b = parambblr;
    this.jdField_c_of_type_Bblr = null;
    Object localObject;
    int i;
    if ((paramBoolean) && (parambblr != null))
    {
      localObject = parambblr.a();
      if ((localObject != null) && (localObject.length > 0))
      {
        parambblr = new ArrayList(Arrays.asList((Object[])localObject));
        i = 0;
        if (i >= localObject.length) {
          break label171;
        }
        if (localObject[i].a() != 2131364825) {}
      }
    }
    for (;;)
    {
      localObject = new bblt();
      ((bblt)localObject).a(2131375789);
      ((bblt)localObject).a(ajyc.a(2131702230));
      ((bblt)localObject).b(2130838615);
      parambblr.add(i + 1, localObject);
      this.jdField_c_of_type_Bblr = new bblr();
      parambblr = parambblr.iterator();
      for (;;)
      {
        if (parambblr.hasNext())
        {
          localObject = (bblt)parambblr.next();
          this.jdField_c_of_type_Bblr.a((bblt)localObject);
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
  
  public void a(bfps parambfps)
  {
    this.jdField_a_of_type_Bfps = parambfps;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aibw
 * JD-Core Version:    0.7.0.1
 */