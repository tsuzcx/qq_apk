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

public final class amcd
  implements agvc, amch
{
  private static final int jdField_a_of_type_Int = bhtq.b(50.0F);
  private static int jdField_b_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private final WeakReference<Fragment> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d = -1;
  private int e = -1;
  
  public amcd(Fragment paramFragment)
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
    ambu localambu = ambu.a();
    if ((localambu.c()) && (!localambu.a()))
    {
      View localView = localambu.a();
      if (localView != null)
      {
        localView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
        if (this.jdField_a_of_type_ArrayOfInt[1] + localView.getMeasuredHeight() - localView.getPaddingBottom() >= jdField_a_of_type_Int + ImmersiveUtils.c) {
          break label76;
        }
        localambu.d();
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
        localambu.d();
        return;
      }
      localambu.a(paramView);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramView = new DisplayMetrics();
      paramFragment.getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(paramView);
      localambu.d(paramView.heightPixels);
      return;
    }
    localambu.a();
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
          localObject2 = ambu.a();
          ((ambu)localObject2).a(this);
          this.jdField_b_of_type_Boolean = true;
        } while ((((ambu)localObject2).a() == null) || (!((ambu)localObject2).c()) || (((ambu)localObject2).a()));
        ((ambu)localObject2).a((View)localObject1);
        return;
        ambu.a().b(this);
        this.jdField_b_of_type_Boolean = false;
        return;
        localObject1 = ambu.a();
      } while (!((amcl)localObject1).c());
      ((amcl)localObject1).d();
      return;
      a((View)localObject1, (Fragment)localObject2);
      return;
      localObject1 = ambu.a();
    } while ((((ambu)localObject1).a() == null) || (!((ambu)localObject1).c()) || (!((ambu)localObject1).a()));
    ((ambu)localObject1).b();
  }
  
  public void a(@NonNull amcl paramamcl)
  {
    boolean bool = paramamcl.c();
    paramamcl = (Fragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramamcl instanceof ChatHistoryC2CAllFragment)) {
      paramamcl = ((ChatHistoryC2CAllFragment)paramamcl).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    }
    for (;;)
    {
      if (paramamcl != null) {
        paramamcl.requestDisallowInterceptTouchEvent(bool);
      }
      return;
      if ((paramamcl instanceof ChatHistoryTroopAllFragment)) {
        paramamcl = ((ChatHistoryTroopAllFragment)paramamcl).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      } else if ((paramamcl instanceof ChatHistoryBubbleListForTroopFragment)) {
        paramamcl = ((ChatHistoryBubbleListForTroopFragment)paramamcl).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      } else {
        paramamcl = null;
      }
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    ambu localambu = ambu.a();
    if ((!localambu.c()) || (!this.jdField_b_of_type_Boolean)) {}
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
            if (!localambu.a(j, k))
            {
              this.jdField_a_of_type_Boolean = bool;
              this.jdField_a_of_type_Long = localambu.jdField_a_of_type_Long;
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
      long l = localambu.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_Long == -1L) || (l == -1L)) {
        break label281;
      }
      if (this.jdField_a_of_type_Long == l) {
        localambu.d();
      }
    }
    for (;;)
    {
      this.c = 1;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Long = -1L;
      return;
      label281:
      localambu.d();
    }
  }
  
  public int[] a()
  {
    return new int[] { 5, 9, 12, 16, 14, 15 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amcd
 * JD-Core Version:    0.7.0.1
 */