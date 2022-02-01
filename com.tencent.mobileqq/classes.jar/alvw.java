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

public final class alvw
  implements agin, alwe
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
  
  public alvw(BaseChatPie paramBaseChatPie)
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
    alvr localalvr = alvr.a();
    if (localalvr.c()) {
      localalvr.d();
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    alvr localalvr;
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
              localalvr = alvr.a();
              localalvr.a(this);
              this.jdField_b_of_type_Boolean = true;
            } while ((!localalvr.c()) || (localalvr.a()));
            localalvr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
            return;
            alvr.a().b(this);
            this.jdField_b_of_type_Boolean = false;
            return;
            localalvr = alvr.a();
          } while (!localalvr.c());
          localalvr.d();
          return;
          localalvr = alvr.a();
        } while ((!localalvr.c()) || (localalvr.a()));
        localView = localalvr.a();
      } while (localView == null);
      localView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      if (this.jdField_a_of_type_ArrayOfInt[1] + localView.getMeasuredHeight() - localView.getPaddingBottom() < jdField_a_of_type_Int + ImmersiveUtils.c)
      {
        localalvr.d();
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.getVisibility() == 0))
      {
        paramInt = this.jdField_a_of_type_ArrayOfInt[1];
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
        if (paramInt > this.jdField_a_of_type_ArrayOfInt[1])
        {
          localalvr.d();
          return;
        }
        localalvr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
        return;
      }
      localalvr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      return;
      localalvr = alvr.a();
    } while ((!localalvr.c()) || (!localalvr.a()));
    localalvr.b();
  }
  
  public void a(@NonNull alwi paramalwi)
  {
    boolean bool = paramalwi.c();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof aict)) {}
    for (paramalwi = ((aict)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a();; paramalwi = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView)
    {
      if (paramalwi != null) {
        paramalwi.requestDisallowInterceptTouchEvent(bool);
      }
      return;
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    alvr localalvr = alvr.a();
    if ((!localalvr.c()) || (!this.jdField_b_of_type_Boolean)) {}
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
            if (!localalvr.a(j, k))
            {
              this.jdField_a_of_type_Boolean = bool;
              this.jdField_a_of_type_Long = localalvr.jdField_a_of_type_Long;
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
      long l = localalvr.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_Long == -1L) || (l == -1L)) {
        break label281;
      }
      if (this.jdField_a_of_type_Long == l) {
        localalvr.d();
      }
    }
    for (;;)
    {
      this.c = 1;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Long = -1L;
      return;
      label281:
      localalvr.d();
    }
  }
  
  public boolean a()
  {
    if (alvr.a().c())
    {
      alvr.a().d();
      return true;
    }
    return false;
  }
  
  public int[] a()
  {
    return new int[] { 6, 10, 13, 17, 15, 16 };
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
    return alvr.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alvw
 * JD-Core Version:    0.7.0.1
 */