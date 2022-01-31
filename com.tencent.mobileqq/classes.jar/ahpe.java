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

public class ahpe
  implements ahpq
{
  private static final int e = bajq.b(72.0F);
  private static final int f = bajq.b(63.0F);
  public int a;
  private ahpo jdField_a_of_type_Ahpo;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  bakh jdField_a_of_type_Bakh;
  private behy jdField_a_of_type_Behy;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  public int b;
  private bakh b;
  private int jdField_c_of_type_Int;
  private bakh jdField_c_of_type_Bakh;
  private int d;
  
  private void c()
  {
    if (this.jdField_a_of_type_Ahpo == null) {
      throw new IllegalStateException("Delegate has not bound.");
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public ahpf a(View paramView, BaseChatPie paramBaseChatPie)
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
      if ((this instanceof ahow)) {
        paramView = ((ahow)this).a;
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
      return new ahpf(i, k);
      j = bajq.b();
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
  public ahpo a()
  {
    return this.jdField_a_of_type_Ahpo;
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
  
  public void a(@Nullable ahpo paramahpo)
  {
    this.jdField_a_of_type_Ahpo = paramahpo;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    c();
    bakh localbakh;
    if (this.jdField_a_of_type_Ahpo.c())
    {
      int i = this.jdField_a_of_type_Ahpo.c();
      int j = this.jdField_a_of_type_Ahpo.b();
      if (this.jdField_a_of_type_Ahpo.a() == i - j) {
        localbakh = this.b;
      }
    }
    for (;;)
    {
      a(localbakh, paramView, paramInt1, paramInt2, paramInt3);
      return;
      if (this.jdField_c_of_type_Bakh != null)
      {
        localbakh = this.jdField_c_of_type_Bakh;
      }
      else
      {
        if (this.jdField_a_of_type_Bakh == null)
        {
          this.jdField_a_of_type_Bakh = new bakh();
          this.jdField_a_of_type_Bakh.a(2131299262, ajjy.a(2131636445), 2130838590);
          this.jdField_a_of_type_Bakh.a(2131310025, ajjy.a(2131636443), 2130838608);
          this.jdField_a_of_type_Bakh.a(2131301021, ajjy.a(2131636447), 2130838599);
          this.jdField_a_of_type_Bakh.a(2131300328, ajjy.a(2131636444), 2130838598);
        }
        localbakh = this.jdField_a_of_type_Bakh;
        continue;
        localbakh = this.b;
      }
    }
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, bakh parambakh, int paramInt3, boolean paramBoolean)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b()))
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(baay.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow, paramView.getContext(), parambakh, this.jdField_a_of_type_AndroidViewView$OnClickListener, true));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(true);
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(2);
    parambakh = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramInt3 == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      parambakh.d(paramBoolean);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this.jdField_a_of_type_Behy);
      paramView.post(new CommonMenuWrapper.1(this, paramView, paramInt1, paramInt2));
      this.jdField_c_of_type_Int = paramInt1;
      this.d = paramInt2;
      return;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, bakh parambakh, boolean paramBoolean, int paramInt3)
  {
    this.b = parambakh;
    this.jdField_c_of_type_Bakh = null;
    a(paramView, paramInt1, paramInt2, parambakh, paramInt3, paramBoolean);
  }
  
  void a(bakh parambakh, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, parambakh, paramInt3, false);
  }
  
  public void a(bakh parambakh, boolean paramBoolean)
  {
    this.b = parambakh;
    this.jdField_c_of_type_Bakh = null;
    Object localObject;
    int i;
    if ((paramBoolean) && (parambakh != null))
    {
      localObject = parambakh.a();
      if ((localObject != null) && (localObject.length > 0))
      {
        parambakh = new ArrayList(Arrays.asList((Object[])localObject));
        i = 0;
        if (i >= localObject.length) {
          break label171;
        }
        if (localObject[i].a() != 2131299262) {}
      }
    }
    for (;;)
    {
      localObject = new bakj();
      ((bakj)localObject).a(2131310025);
      ((bakj)localObject).a(ajjy.a(2131636446));
      ((bakj)localObject).b(2130838608);
      parambakh.add(i + 1, localObject);
      this.jdField_c_of_type_Bakh = new bakh();
      parambakh = parambakh.iterator();
      for (;;)
      {
        if (parambakh.hasNext())
        {
          localObject = (bakj)parambakh.next();
          this.jdField_c_of_type_Bakh.a((bakj)localObject);
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
  
  public void a(behy parambehy)
  {
    this.jdField_a_of_type_Behy = parambehy;
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
 * Qualified Name:     ahpe
 * JD-Core Version:    0.7.0.1
 */