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

public class alqm<T extends BaseActivity>
  implements View.OnClickListener
{
  private static int jdField_b_of_type_Int = -1;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private alqf jdField_a_of_type_Alqf;
  protected alqj a;
  protected alra a;
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
    if (alqc.a().c()) {
      return alqc.a().b();
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
    alqc localalqc = alqc.a();
    if ((!localalqc.c()) || (!this.jdField_a_of_type_Boolean)) {}
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
            if (!localalqc.a(j, k))
            {
              this.jdField_b_of_type_Boolean = bool;
              this.jdField_a_of_type_Long = localalqc.jdField_a_of_type_Long;
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
      long l = localalqc.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_Long == -1L) || (l == -1L)) {
        break label281;
      }
      if (this.jdField_a_of_type_Long == l) {
        localalqc.d();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Long = -1L;
      return;
      label281:
      localalqc.d();
    }
  }
  
  protected void a(bguh parambguh)
  {
    parambguh.a(2131365147, anni.a(2131701052), 2130838920);
    parambguh.a(2131367027, anni.a(2131701050), 2130838929);
    parambguh.a(2131366271, anni.a(2131701051), 2130838928);
  }
  
  public void a(T paramT, ContainerView paramContainerView)
  {
    this.jdField_a_of_type_JavaLangString = paramContainerView.a();
    this.jdField_a_of_type_Alra = new alra();
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
    paramContainerView.a.setOnTouchListener(new alqn(this));
    paramContainerView.a.setOnLongClickListener(new alqo(this, paramContainerView));
  }
  
  protected void a(ContainerView paramContainerView, View paramView)
  {
    if ((paramView instanceof alqr))
    {
      alqr localalqr = (alqr)paramView;
      if (paramView.getContext() != null)
      {
        bguh localbguh = new bguh();
        a(localbguh);
        if (this.jdField_a_of_type_Alqj == null)
        {
          this.jdField_a_of_type_Alqj = new alqz();
          this.jdField_a_of_type_Alqj.a(this);
        }
        int i = this.jdField_a_of_type_AndroidGraphicsPoint.y - afur.a(10.0F, paramView.getResources());
        int j = this.jdField_a_of_type_AndroidGraphicsPoint.x - bgtn.b(14.0F);
        this.jdField_a_of_type_Alqj.a(localbguh, false);
        this.jdField_a_of_type_Alqj.a(j);
        this.jdField_a_of_type_Alqj.b(i);
        this.jdField_a_of_type_Alqj.jdField_a_of_type_Int = i;
        this.jdField_a_of_type_Alqj.jdField_b_of_type_Int = j;
        if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
          com.tencent.qphone.base.util.QLog.d("CommonSelectableMenu", 2, "showMenuView: pointY -> " + i + ", lastShowX -> " + this.jdField_a_of_type_AndroidGraphicsPoint.x);
        }
        if (this.jdField_a_of_type_Alqf == null) {
          this.jdField_a_of_type_Alqf = new alqf();
        }
        this.jdField_a_of_type_Alqf.a(localalqr);
        this.jdField_a_of_type_Alqf.a(paramContainerView, paramContainerView);
        this.jdField_a_of_type_Alqf.a(this.jdField_a_of_type_Alqj);
        this.jdField_a_of_type_Alra.a(paramView, this.jdField_a_of_type_Alqj);
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
    alqc localalqc = alqc.a();
    if ((localalqc.c()) && (localalqc.a())) {
      localalqc.d();
    }
  }
  
  public void b(ContainerView paramContainerView)
  {
    if ((paramContainerView != null) && (paramContainerView.a != null))
    {
      paramContainerView.a.setOnLongClickListener(null);
      paramContainerView.a.setOnClickListener(null);
    }
    if (this.jdField_a_of_type_Alqf != null)
    {
      this.jdField_a_of_type_Alqf.d();
      this.jdField_a_of_type_Alqf = null;
    }
    if (this.jdField_a_of_type_Alqj != null)
    {
      this.jdField_a_of_type_Alqj.a(null);
      this.jdField_a_of_type_Alqj = null;
    }
    this.jdField_a_of_type_Alra = null;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alqm
 * JD-Core Version:    0.7.0.1
 */