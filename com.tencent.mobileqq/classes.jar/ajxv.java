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

public final class ajxv
  implements affa, ajxz
{
  private static final int jdField_a_of_type_Int = bdoo.b(50.0F);
  private static int jdField_b_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private final WeakReference<Fragment> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d = -1;
  private int e = -1;
  
  public ajxv(Fragment paramFragment)
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
    ajxm localajxm = ajxm.a();
    if ((localajxm.c()) && (!localajxm.a()))
    {
      View localView = localajxm.a();
      if (localView != null)
      {
        localView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
        if (this.jdField_a_of_type_ArrayOfInt[1] + localView.getMeasuredHeight() - localView.getPaddingBottom() >= jdField_a_of_type_Int + ImmersiveUtils.c) {
          break label76;
        }
        localajxm.d();
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
        localajxm.d();
        return;
      }
      localajxm.a(paramView);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramView = new DisplayMetrics();
      paramFragment.getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(paramView);
      localajxm.d(paramView.heightPixels);
      return;
    }
    localajxm.a();
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
          localObject2 = ajxm.a();
          ((ajxm)localObject2).a(this);
          this.jdField_b_of_type_Boolean = true;
        } while ((((ajxm)localObject2).a() == null) || (!((ajxm)localObject2).c()) || (((ajxm)localObject2).a()));
        ((ajxm)localObject2).a((View)localObject1);
        return;
        ajxm.a().b(this);
        this.jdField_b_of_type_Boolean = false;
        return;
        localObject1 = ajxm.a();
      } while (!((ajyd)localObject1).c());
      ((ajyd)localObject1).d();
      return;
      a((View)localObject1, (Fragment)localObject2);
      return;
      localObject1 = ajxm.a();
    } while ((((ajxm)localObject1).a() == null) || (!((ajxm)localObject1).c()) || (!((ajxm)localObject1).a()));
    ((ajxm)localObject1).b();
  }
  
  public void a(@NonNull ajyd paramajyd)
  {
    boolean bool = paramajyd.c();
    paramajyd = (Fragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramajyd instanceof ChatHistoryC2CAllFragment)) {
      paramajyd = ((ChatHistoryC2CAllFragment)paramajyd).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    }
    for (;;)
    {
      if (paramajyd != null) {
        paramajyd.requestDisallowInterceptTouchEvent(bool);
      }
      return;
      if ((paramajyd instanceof ChatHistoryTroopAllFragment)) {
        paramajyd = ((ChatHistoryTroopAllFragment)paramajyd).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      } else if ((paramajyd instanceof ChatHistoryBubbleListForTroopFragment)) {
        paramajyd = ((ChatHistoryBubbleListForTroopFragment)paramajyd).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      } else {
        paramajyd = null;
      }
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    ajxm localajxm = ajxm.a();
    if ((!localajxm.c()) || (!this.jdField_b_of_type_Boolean)) {}
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
            if (!localajxm.a(j, k))
            {
              this.jdField_a_of_type_Boolean = bool;
              this.jdField_a_of_type_Long = localajxm.jdField_a_of_type_Long;
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
      long l = localajxm.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_Long == -1L) || (l == -1L)) {
        break label281;
      }
      if (this.jdField_a_of_type_Long == l) {
        localajxm.d();
      }
    }
    for (;;)
    {
      this.c = 1;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Long = -1L;
      return;
      label281:
      localajxm.d();
    }
  }
  
  public int[] a()
  {
    return new int[] { 4, 8, 10, 14, 12, 13 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxv
 * JD-Core Version:    0.7.0.1
 */