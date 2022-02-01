import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;

public final class akya
  implements afrc, akyi
{
  private static final int jdField_a_of_type_Int = ViewUtils.dpToPx(50.0F);
  private static int jdField_b_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d = -1;
  private int e = -1;
  
  public akya(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    if (jdField_b_of_type_Int == -1)
    {
      int i = ViewConfiguration.get(paramBaseChatPie.mContext).getScaledTouchSlop();
      jdField_b_of_type_Int = i * i;
    }
  }
  
  public void a()
  {
    akxv localakxv = akxv.a();
    if (localakxv.c()) {
      localakxv.d();
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    akxv localakxv;
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
              localakxv = akxv.a();
              localakxv.a(this);
              this.jdField_b_of_type_Boolean = true;
            } while ((!localakxv.c()) || (localakxv.a()));
            localakxv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
            return;
            akxv.a().b(this);
            this.jdField_b_of_type_Boolean = false;
            return;
            localakxv = akxv.a();
          } while (!localakxv.c());
          localakxv.d();
          return;
          localakxv = akxv.a();
        } while ((!localakxv.c()) || (localakxv.a()));
        localView = localakxv.a();
      } while (localView == null);
      localView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      if (this.jdField_a_of_type_ArrayOfInt[1] + localView.getMeasuredHeight() - localView.getPaddingBottom() < jdField_a_of_type_Int + ImmersiveUtils.c)
      {
        localakxv.d();
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.getVisibility() == 0))
      {
        paramInt = this.jdField_a_of_type_ArrayOfInt[1];
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
        if (paramInt > this.jdField_a_of_type_ArrayOfInt[1])
        {
          localakxv.d();
          return;
        }
        localakxv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
        return;
      }
      localakxv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      return;
      localakxv = akxv.a();
    } while ((!localakxv.c()) || (!localakxv.a()));
    localakxv.b();
  }
  
  public void a(@NonNull akym paramakym)
  {
    boolean bool = paramakym.c();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahia)) {}
    for (paramakym = ((ahia)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a();; paramakym = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView)
    {
      if (paramakym != null) {
        paramakym.requestDisallowInterceptTouchEvent(bool);
      }
      return;
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    akxv localakxv = akxv.a();
    if ((!localakxv.c()) || (!this.jdField_b_of_type_Boolean)) {}
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
            if (!localakxv.a(j, k))
            {
              this.jdField_a_of_type_Boolean = bool;
              this.jdField_a_of_type_Long = localakxv.jdField_a_of_type_Long;
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
      long l = localakxv.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_Long == -1L) || (l == -1L)) {
        break label281;
      }
      if (this.jdField_a_of_type_Long == l) {
        localakxv.d();
      }
    }
    for (;;)
    {
      this.c = 1;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Long = -1L;
      return;
      label281:
      localakxv.d();
    }
  }
  
  public boolean a()
  {
    if (akxv.a().c())
    {
      akxv.a().d();
      return true;
    }
    return false;
  }
  
  public int[] a()
  {
    return new int[] { 5, 9, 12, 16, 14, 15 };
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listAdapter != null)
    {
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, false, null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listAdapter.a.jdField_a_of_type_Int = 1;
      }
    }
    else {
      return;
    }
    if ("2101".equals(ThemeUtil.getCurrentThemeId()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listAdapter.a.jdField_a_of_type_Int = 2;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listAdapter.a.jdField_a_of_type_Int = 0;
  }
  
  public boolean b()
  {
    return akxv.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akya
 * JD-Core Version:    0.7.0.1
 */