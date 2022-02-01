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

public class amcb
  implements amcn
{
  private static final int e = bhtq.b(72.0F);
  private static final int f = bhtq.b(63.0F);
  public int a;
  private amcl jdField_a_of_type_Amcl;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  bhuk jdField_a_of_type_Bhuk;
  private blkc jdField_a_of_type_Blkc;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  public int b;
  private bhuk b;
  private int jdField_c_of_type_Int;
  private bhuk jdField_c_of_type_Bhuk;
  private int d;
  
  private void c()
  {
    if (this.jdField_a_of_type_Amcl == null) {
      throw new IllegalStateException("Delegate has not bound.");
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public amcc a(View paramView, BaseChatPie paramBaseChatPie)
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
      if ((this instanceof ambt)) {
        paramView = ((ambt)this).a;
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
      return new amcc(i, k);
      j = bhtq.b();
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
  public amcl a()
  {
    return this.jdField_a_of_type_Amcl;
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
  
  public void a(@Nullable amcl paramamcl)
  {
    this.jdField_a_of_type_Amcl = paramamcl;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    c();
    bhuk localbhuk;
    if (this.jdField_a_of_type_Amcl.c())
    {
      int i = this.jdField_a_of_type_Amcl.c();
      int j = this.jdField_a_of_type_Amcl.b();
      if (this.jdField_a_of_type_Amcl.a() == i - j) {
        localbhuk = this.b;
      }
    }
    for (;;)
    {
      a(localbhuk, paramView, paramInt1, paramInt2, paramInt3);
      return;
      if (this.jdField_c_of_type_Bhuk != null)
      {
        localbhuk = this.jdField_c_of_type_Bhuk;
      }
      else
      {
        if (this.jdField_a_of_type_Bhuk == null)
        {
          this.jdField_a_of_type_Bhuk = new bhuk();
          this.jdField_a_of_type_Bhuk.a(2131365191, anzj.a(2131701151), 2130838930);
          this.jdField_a_of_type_Bhuk.a(2131377264, anzj.a(2131701149), 2130838948);
          this.jdField_a_of_type_Bhuk.a(2131367078, anzj.a(2131701153), 2130838939);
          this.jdField_a_of_type_Bhuk.a(2131366320, anzj.a(2131701150), 2130838938);
        }
        localbhuk = this.jdField_a_of_type_Bhuk;
        continue;
        localbhuk = this.b;
      }
    }
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, bhuk parambhuk, int paramInt3, boolean paramBoolean)
  {
    a(paramView, paramInt1, paramInt2, parambhuk, paramInt3, paramBoolean, null);
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, bhuk parambhuk, int paramInt3, boolean paramBoolean, Activity paramActivity)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b()))
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(bhkx.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow, paramView.getContext(), parambhuk, this.jdField_a_of_type_AndroidViewView$OnClickListener, true));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(true);
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(2);
    parambhuk = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramInt3 == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      parambhuk.d(paramBoolean);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this.jdField_a_of_type_Blkc);
      paramView.post(new CommonMenuWrapper.1(this, paramActivity, paramView, paramInt1, paramInt2));
      this.jdField_c_of_type_Int = paramInt1;
      this.d = paramInt2;
      return;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, bhuk parambhuk, boolean paramBoolean, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, parambhuk, paramBoolean, paramInt3, null);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, bhuk parambhuk, boolean paramBoolean, int paramInt3, Activity paramActivity)
  {
    this.b = parambhuk;
    this.jdField_c_of_type_Bhuk = null;
    a(paramView, paramInt1, paramInt2, parambhuk, paramInt3, paramBoolean, paramActivity);
  }
  
  void a(bhuk parambhuk, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, parambhuk, paramInt3, false);
  }
  
  public void a(bhuk parambhuk, boolean paramBoolean)
  {
    this.b = parambhuk;
    this.jdField_c_of_type_Bhuk = null;
    Object localObject;
    int i;
    if ((paramBoolean) && (parambhuk != null))
    {
      localObject = parambhuk.a();
      if ((localObject != null) && (localObject.length > 0))
      {
        parambhuk = new ArrayList(Arrays.asList((Object[])localObject));
        i = 0;
        if (i >= localObject.length) {
          break label171;
        }
        if (localObject[i].a() != 2131365191) {}
      }
    }
    for (;;)
    {
      localObject = new bhum();
      ((bhum)localObject).a(2131377264);
      ((bhum)localObject).a(anzj.a(2131701152));
      ((bhum)localObject).b(2130838948);
      parambhuk.add(i + 1, localObject);
      this.jdField_c_of_type_Bhuk = new bhuk();
      parambhuk = parambhuk.iterator();
      for (;;)
      {
        if (parambhuk.hasNext())
        {
          localObject = (bhum)parambhuk.next();
          this.jdField_c_of_type_Bhuk.a((bhum)localObject);
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
  
  public void a(blkc paramblkc)
  {
    this.jdField_a_of_type_Blkc = paramblkc;
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
 * Qualified Name:     amcb
 * JD-Core Version:    0.7.0.1
 */