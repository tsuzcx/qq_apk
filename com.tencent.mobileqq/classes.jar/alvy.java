import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.selectable.CommonMenuWrapper.1;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class alvy
  implements alwk
{
  private static final int e = ViewUtils.dpToPx(72.0F);
  private static final int f = ViewUtils.dpToPx(63.0F);
  public int a;
  private alwi jdField_a_of_type_Alwi;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  bhjq jdField_a_of_type_Bhjq;
  private blak jdField_a_of_type_Blak;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  public int b;
  private bhjq b;
  private int jdField_c_of_type_Int;
  private bhjq jdField_c_of_type_Bhjq;
  private int d;
  
  private void c()
  {
    if (this.jdField_a_of_type_Alwi == null) {
      throw new IllegalStateException("Delegate has not bound.");
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public alvz a(View paramView, BaseChatPie paramBaseChatPie)
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
      if ((this instanceof alvq)) {
        paramView = ((alvq)this).a;
      }
    }
    int j;
    int k;
    if ((paramView != null) && (paramView.mInputBar != null) && (paramView.mInputBar.getVisibility() == 0))
    {
      paramView.mInputBar.getLocationInWindow(arrayOfInt);
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
      return new alvz(i, k);
      j = ViewUtils.getScreenHeight();
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
  public alwi a()
  {
    return this.jdField_a_of_type_Alwi;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(@Nullable alwi paramalwi)
  {
    this.jdField_a_of_type_Alwi = paramalwi;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    c();
    bhjq localbhjq;
    if (this.jdField_a_of_type_Alwi.c())
    {
      int i = this.jdField_a_of_type_Alwi.c();
      int j = this.jdField_a_of_type_Alwi.b();
      if (this.jdField_a_of_type_Alwi.a() == i - j) {
        localbhjq = this.b;
      }
    }
    for (;;)
    {
      a(localbhjq, paramView, paramInt1, paramInt2, paramInt3);
      return;
      if (this.jdField_c_of_type_Bhjq != null)
      {
        localbhjq = this.jdField_c_of_type_Bhjq;
      }
      else
      {
        if (this.jdField_a_of_type_Bhjq == null)
        {
          this.jdField_a_of_type_Bhjq = new bhjq();
          this.jdField_a_of_type_Bhjq.a(2131365307, anvx.a(2131701737), 2130838982);
          this.jdField_a_of_type_Bhjq.a(2131377287, anvx.a(2131701735), 2130839002);
          this.jdField_a_of_type_Bhjq.a(2131367213, anvx.a(2131701739), 2130838991);
          this.jdField_a_of_type_Bhjq.a(2131366456, anvx.a(2131701736), 2130838990);
        }
        localbhjq = this.jdField_a_of_type_Bhjq;
        continue;
        localbhjq = this.b;
      }
    }
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, bhjq parambhjq, int paramInt3, boolean paramBoolean1, Activity paramActivity, boolean paramBoolean2, Integer paramInteger)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b()))
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    parambhjq = bhcw.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow, paramView.getContext(), parambhjq, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    parambhjq.setIgnoreTouchLocation(paramBoolean2);
    parambhjq.setContainerBottom(paramInteger);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(parambhjq);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(paramBoolean1);
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(true);
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(2);
    parambhjq = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramInt3 == 1) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      parambhjq.d(paramBoolean1);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this.jdField_a_of_type_Blak);
      paramView.post(new CommonMenuWrapper.1(this, paramActivity, paramView, paramInt1, paramInt2));
      this.jdField_c_of_type_Int = paramInt1;
      this.d = paramInt2;
      return;
    }
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, bhjq parambhjq, int paramInt3, boolean paramBoolean, Integer paramInteger)
  {
    a(paramView, paramInt1, paramInt2, parambhjq, paramInt3, paramBoolean, null, true, paramInteger);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, bhjq parambhjq, boolean paramBoolean, int paramInt3, Activity paramActivity)
  {
    this.b = parambhjq;
    this.jdField_c_of_type_Bhjq = null;
    a(paramView, paramInt1, paramInt2, parambhjq, paramInt3, paramBoolean, paramActivity, false, null);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, bhjq parambhjq, boolean paramBoolean, int paramInt3, Integer paramInteger)
  {
    this.b = parambhjq;
    this.jdField_c_of_type_Bhjq = null;
    a(paramView, paramInt1, paramInt2, parambhjq, paramInt3, paramBoolean, null, true, paramInteger);
  }
  
  void a(bhjq parambhjq, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, parambhjq, paramInt3, false, null);
  }
  
  public void a(bhjq parambhjq, boolean paramBoolean)
  {
    this.b = parambhjq;
    this.jdField_c_of_type_Bhjq = null;
    Object localObject;
    int i;
    if ((paramBoolean) && (parambhjq != null))
    {
      localObject = parambhjq.a();
      if ((localObject != null) && (localObject.length > 0))
      {
        parambhjq = new ArrayList(Arrays.asList((Object[])localObject));
        i = 0;
        if (i >= localObject.length) {
          break label161;
        }
        if (localObject[i].a() != 2131365307) {}
      }
    }
    for (;;)
    {
      localObject = new bhjs(2131377287, anvx.a(2131701738));
      ((bhjs)localObject).a(2130839002);
      parambhjq.add(i + 1, localObject);
      this.jdField_c_of_type_Bhjq = new bhjq();
      parambhjq = parambhjq.iterator();
      for (;;)
      {
        if (parambhjq.hasNext())
        {
          localObject = (bhjs)parambhjq.next();
          this.jdField_c_of_type_Bhjq.a((bhjs)localObject);
          continue;
          i += 1;
          break;
        }
      }
      return;
      label161:
      i = 0;
    }
  }
  
  public void a(blak paramblak)
  {
    this.jdField_a_of_type_Blak = paramblak;
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
 * Qualified Name:     alvy
 * JD-Core Version:    0.7.0.1
 */