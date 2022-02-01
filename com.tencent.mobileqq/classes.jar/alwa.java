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
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;

public final class alwa
  implements agin, alwe
{
  private static final int jdField_a_of_type_Int = ViewUtils.dpToPx(50.0F);
  private static int jdField_b_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private final WeakReference<Fragment> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d = -1;
  private int e = -1;
  
  public alwa(Fragment paramFragment)
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
    alvr localalvr = alvr.a();
    if ((localalvr.c()) && (!localalvr.a()))
    {
      View localView = localalvr.a();
      if (localView != null)
      {
        localView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
        if (this.jdField_a_of_type_ArrayOfInt[1] + localView.getMeasuredHeight() - localView.getPaddingBottom() >= jdField_a_of_type_Int + ImmersiveUtils.c) {
          break label76;
        }
        localalvr.d();
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
        localalvr.d();
        return;
      }
      localalvr.a(paramView);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramView = new DisplayMetrics();
      paramFragment.getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(paramView);
      localalvr.d(paramView.heightPixels);
      return;
    }
    localalvr.a();
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
          localObject2 = alvr.a();
          ((alvr)localObject2).a(this);
          this.jdField_b_of_type_Boolean = true;
        } while ((((alvr)localObject2).a() == null) || (!((alvr)localObject2).c()) || (((alvr)localObject2).a()));
        ((alvr)localObject2).a((View)localObject1);
        return;
        alvr.a().b(this);
        this.jdField_b_of_type_Boolean = false;
        return;
        localObject1 = alvr.a();
      } while (!((alwi)localObject1).c());
      ((alwi)localObject1).d();
      return;
      a((View)localObject1, (Fragment)localObject2);
      return;
      localObject1 = alvr.a();
    } while ((((alvr)localObject1).a() == null) || (!((alvr)localObject1).c()) || (!((alvr)localObject1).a()));
    ((alvr)localObject1).b();
  }
  
  public void a(@NonNull alwi paramalwi)
  {
    boolean bool = paramalwi.c();
    paramalwi = (Fragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramalwi instanceof ChatHistoryC2CAllFragment)) {
      paramalwi = ((ChatHistoryC2CAllFragment)paramalwi).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    }
    for (;;)
    {
      if (paramalwi != null) {
        paramalwi.requestDisallowInterceptTouchEvent(bool);
      }
      return;
      if ((paramalwi instanceof ChatHistoryTroopAllFragment)) {
        paramalwi = ((ChatHistoryTroopAllFragment)paramalwi).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      } else if ((paramalwi instanceof ChatHistoryBubbleListForTroopFragment)) {
        paramalwi = ((ChatHistoryBubbleListForTroopFragment)paramalwi).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      } else {
        paramalwi = null;
      }
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
  
  public int[] a()
  {
    return new int[] { 6, 10, 13, 17, 15, 16 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alwa
 * JD-Core Version:    0.7.0.1
 */