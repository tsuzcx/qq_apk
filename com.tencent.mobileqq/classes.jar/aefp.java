import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class aefp
  implements Handler.Callback
{
  private int jdField_a_of_type_Int = 18;
  private aefo jdField_a_of_type_Aefo;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aefs(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new aeft(this);
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new aefq(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Integer, aefo> jdField_a_of_type_JavaUtilHashMap;
  private int[] jdField_a_of_type_ArrayOfInt = { 2131372953, 2131372953 };
  private Animation.AnimationListener jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = new aefr(this);
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  
  public aefp(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
  }
  
  private int a()
  {
    Object localObject1 = null;
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      View localView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(this.jdField_a_of_type_ArrayOfInt[i]);
      Object localObject2;
      if (localView != null) {
        if (localObject1 == null) {
          localObject2 = localView;
        }
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        localObject2 = localView;
        if (localView.getBottom() <= localObject1.getBottom()) {
          localObject2 = localObject1;
        }
      }
    }
    if (localObject1 != null) {
      return localObject1.getId();
    }
    return -1;
  }
  
  private void a(aefo paramaefo)
  {
    if (paramaefo == null) {
      QLog.d("NavigateBarManager", 1, "show navigate bar, navigateBar == null");
    }
    do
    {
      return;
      this.jdField_a_of_type_Aefo = paramaefo;
      Object localObject1 = paramaefo.a();
      if (localObject1 != null)
      {
        Object localObject2 = ((View)localObject1).getParent();
        if ((localObject2 instanceof ViewGroup)) {
          ((ViewGroup)localObject2).removeView((View)localObject1);
        }
        if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setMinimumHeight(bbkx.b(45.0F));
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11);
          int i = a();
          if (i != -1) {
            ((RelativeLayout.LayoutParams)localObject2).addRule(3, i);
          }
          ((RelativeLayout.LayoutParams)localObject2).topMargin = bbkx.a(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject2);
        }
        if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
        {
          this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
          this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(500L);
          this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        }
        if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null)
        {
          this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
          this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(500L);
          this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener);
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        if (paramaefo.a() > 0L)
        {
          localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
          ((Message)localObject1).arg1 = paramaefo.jdField_a_of_type_Int;
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, paramaefo.a());
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("NavigateBarManager", 2, String.format("show navigate bar: %s", new Object[] { paramaefo }));
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, String.format("hide navigate bar: %s", new Object[] { this.jdField_a_of_type_Aefo }));
    }
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    }
    if (this.jdField_a_of_type_Aefo != null)
    {
      b(this.jdField_a_of_type_Aefo.jdField_a_of_type_Int);
      this.jdField_a_of_type_Aefo = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.entrySet();
    Object localObject1 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      aefo localaefo = (aefo)((Map.Entry)localIterator.next()).getValue();
      Object localObject2;
      if (localObject1 == null) {
        localObject2 = localaefo;
      }
      for (;;)
      {
        localObject1 = localObject2;
        break;
        localObject2 = localaefo;
        if (localaefo.b <= localObject1.b) {
          localObject2 = localObject1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, String.format("refresh navigate bar: %s", new Object[] { localObject1 }));
    }
    if (localObject1 != null) {
      a(localObject1);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if ((paramInt > 0) && (paramInt < 3))
    {
      localObject = null;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        boolean bool = ((aefo)localObject).a();
        if (bool) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(((aefo)localObject).jdField_a_of_type_Int), localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("NavigateBarManager", 2, String.format("addTask, barId: %s, needShow: %s", new Object[] { Integer.valueOf(((aefo)localObject).jdField_a_of_type_Int), Boolean.valueOf(bool) }));
        }
      }
      return;
      localObject = new aefn(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt, 2);
      continue;
      localObject = new aefu(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt, 2);
    }
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_b_of_type_AndroidWidgetRelativeLayout) != -1) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
      if (this.jdField_a_of_type_Aefo != null) {
        this.jdField_a_of_type_Aefo.d();
      }
      this.jdField_a_of_type_Aefo = null;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, "onDestroy");
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, String.format("removeTask, barId: %s", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void d(int paramInt)
  {
    if ((this.jdField_a_of_type_Aefo != null) && (this.jdField_a_of_type_Aefo.jdField_a_of_type_Int == paramInt)) {
      c();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NavigateBarManager", 2, String.format("hide navigate bar id: %s", new Object[] { Integer.valueOf(paramInt) }));
      }
      return;
      b(paramInt);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      int i = paramMessage.arg1;
      if ((this.jdField_a_of_type_Aefo != null) && (i == this.jdField_a_of_type_Aefo.jdField_a_of_type_Int)) {
        c();
      } else {
        QLog.d("NavigateBarManager", 1, "hide bar msg but not found, barId: " + i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aefp
 * JD-Core Version:    0.7.0.1
 */