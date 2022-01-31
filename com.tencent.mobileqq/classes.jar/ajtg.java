import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;

public final class ajtg
  implements afal, ajtk
{
  private static final int jdField_a_of_type_Int = bdkf.b(50.0F);
  private static int jdField_b_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private final WeakReference<Fragment> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d = -1;
  private int e = -1;
  
  public ajtg(Fragment paramFragment)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFragment);
    if (jdField_b_of_type_Int == -1)
    {
      int i = ViewConfiguration.get(paramFragment.getActivity()).getScaledTouchSlop();
      jdField_b_of_type_Int = i * i;
    }
  }
  
  private void a(View paramView, Fragment paramFragment)
  {
    ajsx localajsx = ajsx.a();
    if ((localajsx.c()) && (!localajsx.a()))
    {
      View localView = localajsx.a();
      if (localView != null)
      {
        localView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
        if (this.jdField_a_of_type_ArrayOfInt[1] + localView.getMeasuredHeight() - localView.getPaddingBottom() >= jdField_a_of_type_Int + ImmersiveUtils.c) {
          break label76;
        }
        localajsx.d();
      }
    }
    return;
    label76:
    if (paramView != null)
    {
      int i = this.jdField_a_of_type_ArrayOfInt[1];
      paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      if (i > this.jdField_a_of_type_ArrayOfInt[1])
      {
        localajsx.d();
        return;
      }
      localajsx.a(paramView);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramView = new DisplayMetrics();
      paramFragment.getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(paramView);
      localajsx.d(paramView.heightPixels);
      return;
    }
    localajsx.a();
  }
  
  public void a(int paramInt)
  {
    Object localObject2 = (Fragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject1 = null;
    if ((localObject2 instanceof ChatHistoryC2CAllFragment)) {
      localObject1 = ((ChatHistoryC2CAllFragment)localObject2).jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistoryTimeLineContainer;
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          localObject2 = ajsx.a();
          ((ajsx)localObject2).a(this);
          this.jdField_b_of_type_Boolean = true;
        } while ((((ajsx)localObject2).a() == null) || (!((ajsx)localObject2).c()) || (((ajsx)localObject2).a()));
        ((ajsx)localObject2).a((View)localObject1);
        return;
        ajsx.a().b(this);
        this.jdField_b_of_type_Boolean = false;
        return;
        localObject1 = ajsx.a();
      } while (!((ajto)localObject1).c());
      ((ajto)localObject1).d();
      return;
      a((View)localObject1, (Fragment)localObject2);
      return;
      localObject1 = ajsx.a();
    } while ((((ajsx)localObject1).a() == null) || (!((ajsx)localObject1).c()) || (!((ajsx)localObject1).a()));
    ((ajsx)localObject1).b();
  }
  
  public void a(@NonNull ajto paramajto)
  {
    boolean bool = paramajto.c();
    paramajto = (Fragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramajto instanceof ChatHistoryC2CAllFragment)) {
      paramajto = ((ChatHistoryC2CAllFragment)paramajto).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    }
    for (;;)
    {
      if (paramajto != null) {
        paramajto.requestDisallowInterceptTouchEvent(bool);
      }
      return;
      if ((paramajto instanceof ChatHistoryTroopAllFragment)) {
        paramajto = ((ChatHistoryTroopAllFragment)paramajto).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      } else if ((paramajto instanceof ChatHistoryBubbleListForTroopFragment)) {
        paramajto = ((ChatHistoryBubbleListForTroopFragment)paramajto).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      } else {
        paramajto = null;
      }
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
  
  public int[] a()
  {
    return new int[] { 4, 8, 10, 14, 12, 13 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtg
 * JD-Core Version:    0.7.0.1
 */