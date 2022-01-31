import android.annotation.SuppressLint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ContainerView;
import java.lang.ref.WeakReference;

public class ajxw<T extends BaseActivity>
  implements View.OnClickListener
{
  private static int jdField_b_of_type_Int = -1;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private ajxp jdField_a_of_type_Ajxp;
  protected ajxt a;
  protected ajyk a;
  private Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  public String a;
  protected WeakReference<QQAppInterface> a;
  private boolean jdField_a_of_type_Boolean;
  protected WeakReference<T> b;
  private boolean jdField_b_of_type_Boolean;
  private int c = -1;
  private int d = -1;
  
  protected String a()
  {
    if (ajxm.a().c()) {
      return ajxm.a().a();
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    ajxm localajxm = ajxm.a();
    if ((!localajxm.c()) || (!this.jdField_a_of_type_Boolean)) {}
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
              this.jdField_b_of_type_Boolean = bool;
              this.jdField_a_of_type_Long = localajxm.jdField_a_of_type_Long;
              if (!this.jdField_b_of_type_Boolean) {
                break label102;
              }
              this.c = j;
            }
            for (this.d = k;; this.d = -1)
            {
              this.jdField_a_of_type_Int = 0;
              return;
              bool = false;
              break;
              this.c = -1;
            }
          }
          if (i != 2) {
            break;
          }
        } while ((!this.jdField_b_of_type_Boolean) || (Math.pow(this.c - j, 2.0D) + Math.pow(this.d - k, 2.0D) <= jdField_b_of_type_Int));
        this.jdField_a_of_type_Int = 2;
      } while (!com.tencent.TMG.utils.QLog.isColorLevel());
      com.tencent.TMG.utils.QLog.d("CommonSelectableMenu", 0, "detect scrolling.");
      return;
    } while (((i != 1) && (i != 3)) || (!this.jdField_b_of_type_Boolean));
    if (this.jdField_a_of_type_Int == 0)
    {
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("CommonSelectableMenu", 0, "detect taping.");
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
      this.jdField_a_of_type_Int = 1;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Long = -1L;
      return;
      label281:
      localajxm.d();
    }
  }
  
  protected void a(bdpi parambdpi)
  {
    parambdpi.a(2131364912, alud.a(2131702632), 2130838669);
    parambdpi.a(2131366760, alud.a(2131702630), 2130838678);
    parambdpi.a(2131366017, alud.a(2131702631), 2130838677);
  }
  
  public void a(T paramT, ContainerView paramContainerView)
  {
    this.jdField_a_of_type_JavaLangString = paramContainerView.a();
    this.jdField_a_of_type_Ajyk = new ajyk();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramT.app);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramT);
    a(paramContainerView);
    if (jdField_b_of_type_Int == -1)
    {
      int i = ViewConfiguration.get(paramT).getScaledTouchSlop();
      jdField_b_of_type_Int = i * i;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  protected void a(ContainerView paramContainerView)
  {
    paramContainerView.a.setOnTouchListener(new ajxx(this));
    paramContainerView.a.setOnLongClickListener(new ajxy(this, paramContainerView));
  }
  
  protected void a(ContainerView paramContainerView, View paramView)
  {
    if ((paramView instanceof ajyb))
    {
      ajyb localajyb = (ajyb)paramView;
      if (paramView.getContext() != null)
      {
        bdpi localbdpi = new bdpi();
        a(localbdpi);
        if (this.jdField_a_of_type_Ajxt == null)
        {
          this.jdField_a_of_type_Ajxt = new ajyj();
          this.jdField_a_of_type_Ajxt.a(this);
        }
        int i = this.jdField_a_of_type_AndroidGraphicsPoint.y - aepi.a(10.0F, paramView.getResources());
        int j = this.jdField_a_of_type_AndroidGraphicsPoint.x - bdoo.b(14.0F);
        this.jdField_a_of_type_Ajxt.a(localbdpi, false);
        this.jdField_a_of_type_Ajxt.a(j);
        this.jdField_a_of_type_Ajxt.b(i);
        this.jdField_a_of_type_Ajxt.jdField_a_of_type_Int = i;
        this.jdField_a_of_type_Ajxt.jdField_b_of_type_Int = j;
        if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
          com.tencent.qphone.base.util.QLog.d("CommonSelectableMenu", 2, "showMenuView: pointY -> " + i + ", lastShowX -> " + this.jdField_a_of_type_AndroidGraphicsPoint.x);
        }
        if (this.jdField_a_of_type_Ajxp == null) {
          this.jdField_a_of_type_Ajxp = new ajxp();
        }
        this.jdField_a_of_type_Ajxp.a(localajyb);
        this.jdField_a_of_type_Ajxp.a(paramContainerView, paramContainerView);
        this.jdField_a_of_type_Ajxp.a(this.jdField_a_of_type_Ajxt);
        this.jdField_a_of_type_Ajyk.a(paramView, this.jdField_a_of_type_Ajxt);
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    ajxm localajxm = ajxm.a();
    if ((localajxm.c()) && (localajxm.a())) {
      localajxm.d();
    }
  }
  
  public void b(ContainerView paramContainerView)
  {
    if ((paramContainerView != null) && (paramContainerView.a != null))
    {
      paramContainerView.a.setOnLongClickListener(null);
      paramContainerView.a.setOnClickListener(null);
    }
    if (this.jdField_a_of_type_Ajxp != null)
    {
      this.jdField_a_of_type_Ajxp.d();
      this.jdField_a_of_type_Ajxp = null;
    }
    if (this.jdField_a_of_type_Ajxt != null)
    {
      this.jdField_a_of_type_Ajxt.a(null);
      this.jdField_a_of_type_Ajxt = null;
    }
    this.jdField_a_of_type_Ajyk = null;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxw
 * JD-Core Version:    0.7.0.1
 */