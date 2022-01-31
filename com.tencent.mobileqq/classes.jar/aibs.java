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

public final class aibs
  implements adif, aica
{
  private static final int jdField_a_of_type_Int = bbll.b(50.0F);
  private static int jdField_b_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d = -1;
  private int e = -1;
  
  public aibs(BaseChatPie paramBaseChatPie)
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
    aibn localaibn = aibn.a();
    if (localaibn.c()) {
      localaibn.d();
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    aibn localaibn;
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
              localaibn = aibn.a();
              localaibn.a(this);
              this.jdField_b_of_type_Boolean = true;
            } while ((!localaibn.c()) || (localaibn.a()));
            localaibn.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
            return;
            aibn.a().b(this);
            this.jdField_b_of_type_Boolean = false;
            return;
            localaibn = aibn.a();
          } while (!localaibn.c());
          localaibn.d();
          return;
          localaibn = aibn.a();
        } while ((!localaibn.c()) || (localaibn.a()));
        localView = localaibn.a();
      } while (localView == null);
      localView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      if (this.jdField_a_of_type_ArrayOfInt[1] + localView.getMeasuredHeight() - localView.getPaddingBottom() < jdField_a_of_type_Int + ImmersiveUtils.c)
      {
        localaibn.d();
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getVisibility() == 0))
      {
        paramInt = this.jdField_a_of_type_ArrayOfInt[1];
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
        if (paramInt > this.jdField_a_of_type_ArrayOfInt[1])
        {
          localaibn.d();
          return;
        }
        localaibn.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
        return;
      }
      localaibn.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      return;
      localaibn = aibn.a();
    } while ((!localaibn.c()) || (!localaibn.a()));
    localaibn.b();
  }
  
  public void a(@NonNull aice paramaice)
  {
    boolean bool = paramaice.c();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aeqz)) {}
    for (paramaice = ((aeqz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a();; paramaice = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView)
    {
      if (paramaice != null) {
        paramaice.requestDisallowInterceptTouchEvent(bool);
      }
      return;
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    aibn localaibn = aibn.a();
    if ((!localaibn.c()) || (!this.jdField_b_of_type_Boolean)) {}
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
            if (!localaibn.a(j, k))
            {
              this.jdField_a_of_type_Boolean = bool;
              this.jdField_a_of_type_Long = localaibn.jdField_a_of_type_Long;
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
      long l = localaibn.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_Long == -1L) || (l == -1L)) {
        break label281;
      }
      if (this.jdField_a_of_type_Long == l) {
        localaibn.d();
      }
    }
    for (;;)
    {
      this.c = 1;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Long = -1L;
      return;
      label281:
      localaibn.d();
    }
  }
  
  public boolean a()
  {
    if (aibn.a().c())
    {
      aibn.a().d();
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acup != null)
    {
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acup.a.jdField_a_of_type_Int = 1;
      }
    }
    else {
      return;
    }
    if ("2101".equals(ThemeUtil.getCurrentThemeId()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acup.a.jdField_a_of_type_Int = 2;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acup.a.jdField_a_of_type_Int = 0;
  }
  
  public boolean b()
  {
    return aibn.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aibs
 * JD-Core Version:    0.7.0.1
 */