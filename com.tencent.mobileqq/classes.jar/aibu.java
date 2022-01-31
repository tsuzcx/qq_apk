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

public class aibu
  implements aicg
{
  private static final int e = bbll.b(72.0F);
  private static final int f = bbll.b(63.0F);
  public int a;
  private aice jdField_a_of_type_Aice;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  bbmf jdField_a_of_type_Bbmf;
  private bfqj jdField_a_of_type_Bfqj;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  public int b;
  private bbmf b;
  private int jdField_c_of_type_Int;
  private bbmf jdField_c_of_type_Bbmf;
  private int d;
  
  private void c()
  {
    if (this.jdField_a_of_type_Aice == null) {
      throw new IllegalStateException("Delegate has not bound.");
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public aibv a(View paramView, BaseChatPie paramBaseChatPie)
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
      if ((this instanceof aibm)) {
        paramView = ((aibm)this).a;
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
      return new aibv(i, k);
      j = bbll.b();
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
  public aice a()
  {
    return this.jdField_a_of_type_Aice;
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
  
  public void a(@Nullable aice paramaice)
  {
    this.jdField_a_of_type_Aice = paramaice;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    c();
    bbmf localbbmf;
    if (this.jdField_a_of_type_Aice.c())
    {
      int i = this.jdField_a_of_type_Aice.c();
      int j = this.jdField_a_of_type_Aice.b();
      if (this.jdField_a_of_type_Aice.a() == i - j) {
        localbbmf = this.b;
      }
    }
    for (;;)
    {
      a(localbbmf, paramView, paramInt1, paramInt2, paramInt3);
      return;
      if (this.jdField_c_of_type_Bbmf != null)
      {
        localbbmf = this.jdField_c_of_type_Bbmf;
      }
      else
      {
        if (this.jdField_a_of_type_Bbmf == null)
        {
          this.jdField_a_of_type_Bbmf = new bbmf();
          this.jdField_a_of_type_Bbmf.a(2131364824, ajya.a(2131702240), 2130838597);
          this.jdField_a_of_type_Bbmf.a(2131375791, ajya.a(2131702238), 2130838615);
          this.jdField_a_of_type_Bbmf.a(2131366632, ajya.a(2131702242), 2130838606);
          this.jdField_a_of_type_Bbmf.a(2131365928, ajya.a(2131702239), 2130838605);
        }
        localbbmf = this.jdField_a_of_type_Bbmf;
        continue;
        localbbmf = this.b;
      }
    }
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, bbmf parambbmf, int paramInt3, boolean paramBoolean)
  {
    a(paramView, paramInt1, paramInt2, parambbmf, paramInt3, paramBoolean, null);
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, bbmf parambbmf, int paramInt3, boolean paramBoolean, Activity paramActivity)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b()))
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(bbcq.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow, paramView.getContext(), parambbmf, this.jdField_a_of_type_AndroidViewView$OnClickListener, true));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(true);
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(2);
    parambbmf = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramInt3 == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      parambbmf.d(paramBoolean);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this.jdField_a_of_type_Bfqj);
      paramView.post(new CommonMenuWrapper.1(this, paramActivity, paramView, paramInt1, paramInt2));
      this.jdField_c_of_type_Int = paramInt1;
      this.d = paramInt2;
      return;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, bbmf parambbmf, boolean paramBoolean, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, parambbmf, paramBoolean, paramInt3, null);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, bbmf parambbmf, boolean paramBoolean, int paramInt3, Activity paramActivity)
  {
    this.b = parambbmf;
    this.jdField_c_of_type_Bbmf = null;
    a(paramView, paramInt1, paramInt2, parambbmf, paramInt3, paramBoolean, paramActivity);
  }
  
  void a(bbmf parambbmf, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, parambbmf, paramInt3, false);
  }
  
  public void a(bbmf parambbmf, boolean paramBoolean)
  {
    this.b = parambbmf;
    this.jdField_c_of_type_Bbmf = null;
    Object localObject;
    int i;
    if ((paramBoolean) && (parambbmf != null))
    {
      localObject = parambbmf.a();
      if ((localObject != null) && (localObject.length > 0))
      {
        parambbmf = new ArrayList(Arrays.asList((Object[])localObject));
        i = 0;
        if (i >= localObject.length) {
          break label171;
        }
        if (localObject[i].a() != 2131364824) {}
      }
    }
    for (;;)
    {
      localObject = new bbmh();
      ((bbmh)localObject).a(2131375791);
      ((bbmh)localObject).a(ajya.a(2131702241));
      ((bbmh)localObject).b(2130838615);
      parambbmf.add(i + 1, localObject);
      this.jdField_c_of_type_Bbmf = new bbmf();
      parambbmf = parambbmf.iterator();
      for (;;)
      {
        if (parambbmf.hasNext())
        {
          localObject = (bbmh)parambbmf.next();
          this.jdField_c_of_type_Bbmf.a((bbmh)localObject);
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
  
  public void a(bfqj parambfqj)
  {
    this.jdField_a_of_type_Bfqj = parambfqj;
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
 * Qualified Name:     aibu
 * JD-Core Version:    0.7.0.1
 */