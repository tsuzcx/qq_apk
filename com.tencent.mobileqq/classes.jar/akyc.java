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

public class akyc
  implements akyo
{
  private static final int e = ViewUtils.dpToPx(72.0F);
  private static final int f = ViewUtils.dpToPx(63.0F);
  public int a;
  private akym jdField_a_of_type_Akym;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  bgaz jdField_a_of_type_Bgaz;
  private bjoy jdField_a_of_type_Bjoy;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  public int b;
  private bgaz b;
  private int jdField_c_of_type_Int;
  private bgaz jdField_c_of_type_Bgaz;
  private int d;
  
  private void c()
  {
    if (this.jdField_a_of_type_Akym == null) {
      throw new IllegalStateException("Delegate has not bound.");
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public akyd a(View paramView, BaseChatPie paramBaseChatPie)
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
      if ((this instanceof akxu)) {
        paramView = ((akxu)this).a;
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
      return new akyd(i, k);
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
  public akym a()
  {
    return this.jdField_a_of_type_Akym;
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
  
  public void a(@Nullable akym paramakym)
  {
    this.jdField_a_of_type_Akym = paramakym;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    c();
    bgaz localbgaz;
    if (this.jdField_a_of_type_Akym.c())
    {
      int i = this.jdField_a_of_type_Akym.c();
      int j = this.jdField_a_of_type_Akym.b();
      if (this.jdField_a_of_type_Akym.a() == i - j) {
        localbgaz = this.b;
      }
    }
    for (;;)
    {
      a(localbgaz, paramView, paramInt1, paramInt2, paramInt3);
      return;
      if (this.jdField_c_of_type_Bgaz != null)
      {
        localbgaz = this.jdField_c_of_type_Bgaz;
      }
      else
      {
        if (this.jdField_a_of_type_Bgaz == null)
        {
          this.jdField_a_of_type_Bgaz = new bgaz();
          this.jdField_a_of_type_Bgaz.a(2131365216, amtj.a(2131701386), 2130838962);
          this.jdField_a_of_type_Bgaz.a(2131377014, amtj.a(2131701384), 2130838982);
          this.jdField_a_of_type_Bgaz.a(2131367094, amtj.a(2131701388), 2130838971);
          this.jdField_a_of_type_Bgaz.a(2131366347, amtj.a(2131701385), 2130838970);
        }
        localbgaz = this.jdField_a_of_type_Bgaz;
        continue;
        localbgaz = this.b;
      }
    }
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, bgaz parambgaz, int paramInt3, boolean paramBoolean1, Activity paramActivity, boolean paramBoolean2, Integer paramInteger)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b()))
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    parambgaz = bfue.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow, paramView.getContext(), parambgaz, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    parambgaz.setIgnoreTouchLocation(paramBoolean2);
    parambgaz.setContainerBottom(paramInteger);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(parambgaz);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(paramBoolean1);
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(true);
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(2);
    parambgaz = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramInt3 == 1) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      parambgaz.d(paramBoolean1);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this.jdField_a_of_type_Bjoy);
      paramView.post(new CommonMenuWrapper.1(this, paramActivity, paramView, paramInt1, paramInt2));
      this.jdField_c_of_type_Int = paramInt1;
      this.d = paramInt2;
      return;
    }
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, bgaz parambgaz, int paramInt3, boolean paramBoolean, Integer paramInteger)
  {
    a(paramView, paramInt1, paramInt2, parambgaz, paramInt3, paramBoolean, null, true, paramInteger);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, bgaz parambgaz, boolean paramBoolean, int paramInt3, Activity paramActivity)
  {
    this.b = parambgaz;
    this.jdField_c_of_type_Bgaz = null;
    a(paramView, paramInt1, paramInt2, parambgaz, paramInt3, paramBoolean, paramActivity, false, null);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, bgaz parambgaz, boolean paramBoolean, int paramInt3, Integer paramInteger)
  {
    this.b = parambgaz;
    this.jdField_c_of_type_Bgaz = null;
    a(paramView, paramInt1, paramInt2, parambgaz, paramInt3, paramBoolean, null, true, paramInteger);
  }
  
  void a(bgaz parambgaz, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, parambgaz, paramInt3, false, null);
  }
  
  public void a(bgaz parambgaz, boolean paramBoolean)
  {
    this.b = parambgaz;
    this.jdField_c_of_type_Bgaz = null;
    Object localObject;
    int i;
    if ((paramBoolean) && (parambgaz != null))
    {
      localObject = parambgaz.a();
      if ((localObject != null) && (localObject.length > 0))
      {
        parambgaz = new ArrayList(Arrays.asList((Object[])localObject));
        i = 0;
        if (i >= localObject.length) {
          break label161;
        }
        if (localObject[i].a() != 2131365216) {}
      }
    }
    for (;;)
    {
      localObject = new bgbb(2131377014, amtj.a(2131701387));
      ((bgbb)localObject).a(2130838982);
      parambgaz.add(i + 1, localObject);
      this.jdField_c_of_type_Bgaz = new bgaz();
      parambgaz = parambgaz.iterator();
      for (;;)
      {
        if (parambgaz.hasNext())
        {
          localObject = (bgbb)parambgaz.next();
          this.jdField_c_of_type_Bgaz.a((bgbb)localObject);
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
  
  public void a(bjoy parambjoy)
  {
    this.jdField_a_of_type_Bjoy = parambjoy;
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
 * Qualified Name:     akyc
 * JD-Core Version:    0.7.0.1
 */