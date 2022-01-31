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

public class ahph<T extends BaseActivity>
  implements View.OnClickListener
{
  private static int jdField_b_of_type_Int = -1;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private ahpa jdField_a_of_type_Ahpa;
  protected ahpe a;
  protected ahpv a;
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
    if (ahox.a().c()) {
      return ahox.a().a();
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
    ahox localahox = ahox.a();
    if ((!localahox.c()) || (!this.jdField_a_of_type_Boolean)) {}
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
              this.jdField_b_of_type_Boolean = bool;
              this.jdField_a_of_type_Long = localahox.jdField_a_of_type_Long;
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
      this.jdField_a_of_type_Int = 1;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Long = -1L;
      return;
      label281:
      localahox.d();
    }
  }
  
  protected void a(bakh parambakh)
  {
    parambakh.a(2131299262, ajjy.a(2131636453), 2130838590);
    parambakh.a(2131301021, ajjy.a(2131636451), 2130838599);
    parambakh.a(2131300328, ajjy.a(2131636452), 2130838598);
  }
  
  public void a(T paramT, ContainerView paramContainerView)
  {
    this.jdField_a_of_type_JavaLangString = paramContainerView.a();
    this.jdField_a_of_type_Ahpv = new ahpv();
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
    paramContainerView.a.setOnTouchListener(new ahpi(this));
    paramContainerView.a.setOnLongClickListener(new ahpj(this, paramContainerView));
  }
  
  protected void a(ContainerView paramContainerView, View paramView)
  {
    if ((paramView instanceof ahpm))
    {
      ahpm localahpm = (ahpm)paramView;
      if (paramView.getContext() != null)
      {
        bakh localbakh = new bakh();
        a(localbakh);
        if (this.jdField_a_of_type_Ahpe == null)
        {
          this.jdField_a_of_type_Ahpe = new ahpu();
          this.jdField_a_of_type_Ahpe.a(this);
        }
        int i = this.jdField_a_of_type_AndroidGraphicsPoint.y - aciy.a(10.0F, paramView.getResources());
        int j = this.jdField_a_of_type_AndroidGraphicsPoint.x - bajq.b(14.0F);
        this.jdField_a_of_type_Ahpe.a(localbakh, false);
        this.jdField_a_of_type_Ahpe.a(j);
        this.jdField_a_of_type_Ahpe.b(i);
        this.jdField_a_of_type_Ahpe.jdField_a_of_type_Int = i;
        this.jdField_a_of_type_Ahpe.jdField_b_of_type_Int = j;
        if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
          com.tencent.qphone.base.util.QLog.d("CommonSelectableMenu", 2, "showMenuView: pointY -> " + i + ", lastShowX -> " + this.jdField_a_of_type_AndroidGraphicsPoint.x);
        }
        if (this.jdField_a_of_type_Ahpa == null) {
          this.jdField_a_of_type_Ahpa = new ahpa();
        }
        this.jdField_a_of_type_Ahpa.a(localahpm);
        this.jdField_a_of_type_Ahpa.a(paramContainerView, paramContainerView);
        this.jdField_a_of_type_Ahpa.a(this.jdField_a_of_type_Ahpe);
        this.jdField_a_of_type_Ahpv.a(paramView, this.jdField_a_of_type_Ahpe);
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
    ahox localahox = ahox.a();
    if ((localahox.c()) && (localahox.a())) {
      localahox.d();
    }
  }
  
  public void b(ContainerView paramContainerView)
  {
    if ((paramContainerView != null) && (paramContainerView.a != null))
    {
      paramContainerView.a.setOnLongClickListener(null);
      paramContainerView.a.setOnClickListener(null);
    }
    if (this.jdField_a_of_type_Ahpa != null)
    {
      this.jdField_a_of_type_Ahpa.d();
      this.jdField_a_of_type_Ahpa = null;
    }
    if (this.jdField_a_of_type_Ahpe != null)
    {
      this.jdField_a_of_type_Ahpe.a(null);
      this.jdField_a_of_type_Ahpe = null;
    }
    this.jdField_a_of_type_Ahpv = null;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahph
 * JD-Core Version:    0.7.0.1
 */