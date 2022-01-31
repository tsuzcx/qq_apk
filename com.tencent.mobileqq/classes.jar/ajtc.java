import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;

public final class ajtc
  implements afal, ajtk
{
  private static final int jdField_a_of_type_Int = bdkf.b(50.0F);
  private static int jdField_b_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d = -1;
  private int e = -1;
  
  public ajtc(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (jdField_b_of_type_Int == -1)
    {
      int i = ViewConfiguration.get(paramBaseChatPie.jdField_a_of_type_AndroidContentContext).getScaledTouchSlop();
      jdField_b_of_type_Int = i * i;
    }
  }
  
  public void a()
  {
    ajsx localajsx = ajsx.a();
    if (localajsx.c()) {
      localajsx.d();
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    ajsx localajsx;
    do
    {
      View localView;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localajsx = ajsx.a();
              localajsx.a(this);
              this.jdField_b_of_type_Boolean = true;
            } while ((!localajsx.c()) || (localajsx.a()));
            localajsx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
            return;
            ajsx.a().b(this);
            this.jdField_b_of_type_Boolean = false;
            return;
            localajsx = ajsx.a();
          } while (!localajsx.c());
          localajsx.d();
          return;
          localajsx = ajsx.a();
        } while ((!localajsx.c()) || (localajsx.a()));
        localView = localajsx.a();
      } while (localView == null);
      localView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      if (this.jdField_a_of_type_ArrayOfInt[1] + localView.getMeasuredHeight() - localView.getPaddingBottom() < jdField_a_of_type_Int + ImmersiveUtils.c)
      {
        localajsx.d();
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getVisibility() == 0))
      {
        paramInt = this.jdField_a_of_type_ArrayOfInt[1];
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
        if (paramInt > this.jdField_a_of_type_ArrayOfInt[1])
        {
          localajsx.d();
          return;
        }
        localajsx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
        return;
      }
      localajsx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      return;
      localajsx = ajsx.a();
    } while ((!localajsx.c()) || (!localajsx.a()));
    localajsx.b();
  }
  
  public void a(@NonNull ajto paramajto)
  {
    boolean bool = paramajto.c();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agnz)) {}
    for (paramajto = ((agnz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a();; paramajto = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView)
    {
      if (paramajto != null) {
        paramajto.requestDisallowInterceptTouchEvent(bool);
      }
      return;
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    ajsx localajsx = ajsx.a();
    if ((!localajsx.c()) || (!this.jdField_b_of_type_Boolean)) {}
    int i;
    label102:
    do
    {
      do
      {
        int j;
        int k;
        do
        {
          return;
          i = paramMotionEvent.getAction();
          j = (int)paramMotionEvent.getRawX();
          k = (int)paramMotionEvent.getRawY();
          if (i == 0)
          {
            if (!localajsx.a(j, k))
            {
              this.jdField_a_of_type_Boolean = bool;
              this.jdField_a_of_type_Long = localajsx.jdField_a_of_type_Long;
              if (!this.jdField_a_of_type_Boolean) {
                break label102;
              }
              this.d = j;
            }
            for (this.e = k;; this.e = -1)
            {
              this.c = 0;
              return;
              bool = false;
              break;
              this.d = -1;
            }
          }
          if (i != 2) {
            break;
          }
        } while ((!this.jdField_a_of_type_Boolean) || (Math.pow(this.d - j, 2.0D) + Math.pow(this.e - k, 2.0D) <= jdField_b_of_type_Int));
        this.c = 2;
      } while (!QLog.isColorLevel());
      QLog.d("ChatPieSelectableHelper", 0, "detect scrolling.");
      return;
    } while (((i != 1) && (i != 3)) || (!this.jdField_a_of_type_Boolean));
    if (this.c == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatPieSelectableHelper", 0, "detect taping.");
      }
      long l = localajsx.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_Long == -1L) || (l == -1L)) {
        break label281;
      }
      if (this.jdField_a_of_type_Long == l) {
        localajsx.d();
      }
    }
    for (;;)
    {
      this.c = 1;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Long = -1L;
      return;
      label281:
      localajsx.d();
    }
  }
  
  public boolean a()
  {
    if (ajsx.a().c())
    {
      ajsx.a().d();
      return true;
    }
    return false;
  }
  
  public int[] a()
  {
    return new int[] { 4, 8, 10, 14, 12, 13 };
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aelz != null)
    {
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aelz.a.jdField_a_of_type_Int = 1;
      }
    }
    else {
      return;
    }
    if ("2101".equals(ThemeUtil.getCurrentThemeId()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aelz.a.jdField_a_of_type_Int = 2;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aelz.a.jdField_a_of_type_Int = 0;
  }
  
  public boolean b()
  {
    return ajsx.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtc
 * JD-Core Version:    0.7.0.1
 */