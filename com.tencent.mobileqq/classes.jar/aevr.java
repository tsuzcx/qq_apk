import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class aevr
{
  private aevq jdField_a_of_type_Aevq = new aevs(this);
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private StickerBubbleAnimationView jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView;
  private List<WeakReference<aevu>> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private aevq jdField_b_of_type_Aevq = new aevt(this);
  private StickerBubbleAnimationView jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView;
  private List<WeakReference<aevu>> jdField_b_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_b_of_type_Boolean;
  
  public static aevr a()
  {
    return aevv.a();
  }
  
  private void a(View paramView)
  {
    if (paramView.getParent() == null) {
      return;
    }
    ((ViewGroup)paramView.getParent()).removeView(paramView);
  }
  
  private void a(ViewGroup paramViewGroup, View paramView)
  {
    new RelativeLayout.LayoutParams(-1, -1);
    if (paramView.getParent() != null) {
      if (paramView.getParent() != paramViewGroup)
      {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
        paramViewGroup.addView(paramView);
      }
    }
    for (;;)
    {
      paramView.bringToFront();
      return;
      paramViewGroup.addView(paramView);
    }
  }
  
  private void a(List<WeakReference<aevu>> paramList)
  {
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        aevu localaevu = (aevu)((WeakReference)paramList.next()).get();
        if (localaevu != null) {
          localaevu.a();
        }
      }
    }
    finally {}
  }
  
  private void b(List<WeakReference<aevu>> paramList)
  {
    Iterator localIterator = new ArrayList(paramList).iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      aevu localaevu = (aevu)localWeakReference.get();
      if (localaevu != null) {
        localaevu.b();
      } else {
        paramList.remove(localWeakReference);
      }
    }
  }
  
  public StickerBubbleAnimationView a(Context paramContext)
  {
    paramContext = d(paramContext);
    if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleAnimationViewHolder", 2, "hideSendAnimationView: " + paramContext);
      }
      a(paramContext);
      this.jdField_b_of_type_Boolean = false;
    }
    return paramContext;
  }
  
  public StickerBubbleAnimationView a(ViewGroup paramViewGroup, Context paramContext)
  {
    paramContext = d(paramContext);
    if (!this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleAnimationViewHolder", 2, "showSendAnimationView: " + paramContext.getParent() + " / " + paramViewGroup);
      }
      a(paramViewGroup, paramContext);
      this.jdField_b_of_type_Boolean = true;
    }
    return paramContext;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleAnimationViewHolder", 2, "cleanView");
    }
    if (this.jdField_a_of_type_Boolean) {
      b(this.jdField_a_of_type_AndroidContentContext);
    }
    if (this.jdField_b_of_type_Boolean) {
      a(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView = null;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView = null;
  }
  
  public void a(aevu paramaevu)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramaevu));
      return;
    }
    finally
    {
      paramaevu = finally;
      throw paramaevu;
    }
  }
  
  public StickerBubbleAnimationView b(Context paramContext)
  {
    paramContext = c(paramContext);
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleAnimationViewHolder", 2, "hideReceiveAnimationView: " + paramContext);
      }
      a(paramContext);
      this.jdField_a_of_type_Boolean = false;
    }
    return paramContext;
  }
  
  public StickerBubbleAnimationView b(ViewGroup paramViewGroup, Context paramContext)
  {
    paramContext = c(paramContext);
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleAnimationViewHolder", 2, "showReceiveAnimationView: " + paramContext.getParent() + " / " + paramViewGroup);
      }
      a(paramViewGroup, paramContext);
      this.jdField_a_of_type_Boolean = true;
    }
    return paramContext;
  }
  
  public void b(aevu paramaevu)
  {
    try
    {
      this.jdField_b_of_type_JavaUtilList.add(new WeakReference(paramaevu));
      return;
    }
    finally
    {
      paramaevu = finally;
      throw paramaevu;
    }
  }
  
  public StickerBubbleAnimationView c(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView = new StickerBubbleAnimationView(paramContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView.setShowText(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView.setId(2131376511);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView.setAnimationCallback(this.jdField_a_of_type_Aevq);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView;
  }
  
  public StickerBubbleAnimationView d(Context paramContext)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView = new StickerBubbleAnimationView(paramContext);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView.setId(2131376511);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView.setAnimationCallback(this.jdField_b_of_type_Aevq);
    }
    return this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aevr
 * JD-Core Version:    0.7.0.1
 */