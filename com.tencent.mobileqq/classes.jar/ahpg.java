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

public final class ahpg
  implements acxg, ahpk
{
  private static final int jdField_a_of_type_Int = bajq.b(50.0F);
  private static int jdField_b_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private final WeakReference<Fragment> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d = -1;
  private int e = -1;
  
  public ahpg(Fragment paramFragment)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFragment);
    if (jdField_b_of_type_Int == -1)
    {
      int i = ViewConfiguration.get(paramFragment.getActivity()).getScaledTouchSlop();
      jdField_b_of_type_Int = i * i;
    }
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
      ahox localahox;
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
              localObject2 = ahox.a();
              ((ahox)localObject2).a(this);
              this.jdField_b_of_type_Boolean = true;
            } while ((((ahox)localObject2).a() == null) || (!((ahox)localObject2).c()) || (((ahox)localObject2).a()));
            ((ahox)localObject2).a((View)localObject1);
            return;
            ahox.a().b(this);
            this.jdField_b_of_type_Boolean = false;
            return;
            localObject1 = ahox.a();
          } while (!((ahpo)localObject1).c());
          ((ahpo)localObject1).d();
          return;
          localahox = ahox.a();
        } while ((!localahox.c()) || (localahox.a()));
        localView = localahox.a();
      } while (localView == null);
      localView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      if (this.jdField_a_of_type_ArrayOfInt[1] + localView.getMeasuredHeight() - localView.getPaddingBottom() < jdField_a_of_type_Int + ImmersiveUtils.c)
      {
        localahox.d();
        return;
      }
      if (localObject1 != null)
      {
        paramInt = this.jdField_a_of_type_ArrayOfInt[1];
        ((View)localObject1).getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
        if (paramInt > this.jdField_a_of_type_ArrayOfInt[1])
        {
          localahox.d();
          return;
        }
        localahox.a((View)localObject1);
        return;
      }
      if (Build.VERSION.SDK_INT >= 17)
      {
        localObject1 = new DisplayMetrics();
        ((Fragment)localObject2).getActivity().getWindowManager().getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject1);
        localahox.d(((DisplayMetrics)localObject1).heightPixels);
        return;
      }
      localahox.a();
      return;
      localObject1 = ahox.a();
    } while ((((ahox)localObject1).a() == null) || (!((ahox)localObject1).c()) || (!((ahox)localObject1).a()));
    ((ahox)localObject1).b();
  }
  
  public void a(@NonNull ahpo paramahpo)
  {
    boolean bool = paramahpo.c();
    paramahpo = (Fragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramahpo instanceof ChatHistoryC2CAllFragment)) {
      paramahpo = ((ChatHistoryC2CAllFragment)paramahpo).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    }
    for (;;)
    {
      if (paramahpo != null) {
        paramahpo.requestDisallowInterceptTouchEvent(bool);
      }
      return;
      if ((paramahpo instanceof ChatHistoryTroopAllFragment)) {
        paramahpo = ((ChatHistoryTroopAllFragment)paramahpo).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      } else if ((paramahpo instanceof ChatHistoryBubbleListForTroopFragment)) {
        paramahpo = ((ChatHistoryBubbleListForTroopFragment)paramahpo).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      } else {
        paramahpo = null;
      }
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    ahox localahox = ahox.a();
    if ((!localahox.c()) || (!this.jdField_b_of_type_Boolean)) {}
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
            if (!localahox.a(j, k))
            {
              this.jdField_a_of_type_Boolean = bool;
              this.jdField_a_of_type_Long = localahox.jdField_a_of_type_Long;
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
      long l = localahox.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_Long == -1L) || (l == -1L)) {
        break label281;
      }
      if (this.jdField_a_of_type_Long == l) {
        localahox.d();
      }
    }
    for (;;)
    {
      this.c = 1;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Long = -1L;
      return;
      label281:
      localahox.d();
    }
  }
  
  public int[] a()
  {
    return new int[] { 4, 8, 10, 14, 12, 13 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahpg
 * JD-Core Version:    0.7.0.1
 */