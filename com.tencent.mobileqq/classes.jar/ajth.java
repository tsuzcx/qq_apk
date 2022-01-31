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

public class ajth<T extends BaseActivity>
  implements View.OnClickListener
{
  private static int jdField_b_of_type_Int = -1;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private ajta jdField_a_of_type_Ajta;
  protected ajte a;
  protected ajtv a;
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
    if (ajsx.a().c()) {
      return ajsx.a().a();
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
    ajsx localajsx = ajsx.a();
    if ((!localajsx.c()) || (!this.jdField_a_of_type_Boolean)) {}
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
              this.jdField_b_of_type_Boolean = bool;
              this.jdField_a_of_type_Long = localajsx.jdField_a_of_type_Long;
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
      this.jdField_a_of_type_Int = 1;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Long = -1L;
      return;
      label281:
      localajsx.d();
    }
  }
  
  protected void a(bdkz parambdkz)
  {
    parambdkz.a(2131364910, alpo.a(2131702620), 2130838668);
    parambdkz.a(2131366750, alpo.a(2131702618), 2130838677);
    parambdkz.a(2131366015, alpo.a(2131702619), 2130838676);
  }
  
  public void a(T paramT, ContainerView paramContainerView)
  {
    this.jdField_a_of_type_JavaLangString = paramContainerView.a();
    this.jdField_a_of_type_Ajtv = new ajtv();
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
    paramContainerView.a.setOnTouchListener(new ajti(this));
    paramContainerView.a.setOnLongClickListener(new ajtj(this, paramContainerView));
  }
  
  protected void a(ContainerView paramContainerView, View paramView)
  {
    if ((paramView instanceof ajtm))
    {
      ajtm localajtm = (ajtm)paramView;
      if (paramView.getContext() != null)
      {
        bdkz localbdkz = new bdkz();
        a(localbdkz);
        if (this.jdField_a_of_type_Ajte == null)
        {
          this.jdField_a_of_type_Ajte = new ajtu();
          this.jdField_a_of_type_Ajte.a(this);
        }
        int i = this.jdField_a_of_type_AndroidGraphicsPoint.y - aekt.a(10.0F, paramView.getResources());
        int j = this.jdField_a_of_type_AndroidGraphicsPoint.x - bdkf.b(14.0F);
        this.jdField_a_of_type_Ajte.a(localbdkz, false);
        this.jdField_a_of_type_Ajte.a(j);
        this.jdField_a_of_type_Ajte.b(i);
        this.jdField_a_of_type_Ajte.jdField_a_of_type_Int = i;
        this.jdField_a_of_type_Ajte.jdField_b_of_type_Int = j;
        if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
          com.tencent.qphone.base.util.QLog.d("CommonSelectableMenu", 2, "showMenuView: pointY -> " + i + ", lastShowX -> " + this.jdField_a_of_type_AndroidGraphicsPoint.x);
        }
        if (this.jdField_a_of_type_Ajta == null) {
          this.jdField_a_of_type_Ajta = new ajta();
        }
        this.jdField_a_of_type_Ajta.a(localajtm);
        this.jdField_a_of_type_Ajta.a(paramContainerView, paramContainerView);
        this.jdField_a_of_type_Ajta.a(this.jdField_a_of_type_Ajte);
        this.jdField_a_of_type_Ajtv.a(paramView, this.jdField_a_of_type_Ajte);
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
    ajsx localajsx = ajsx.a();
    if ((localajsx.c()) && (localajsx.a())) {
      localajsx.d();
    }
  }
  
  public void b(ContainerView paramContainerView)
  {
    if ((paramContainerView != null) && (paramContainerView.a != null))
    {
      paramContainerView.a.setOnLongClickListener(null);
      paramContainerView.a.setOnClickListener(null);
    }
    if (this.jdField_a_of_type_Ajta != null)
    {
      this.jdField_a_of_type_Ajta.d();
      this.jdField_a_of_type_Ajta = null;
    }
    if (this.jdField_a_of_type_Ajte != null)
    {
      this.jdField_a_of_type_Ajte.a(null);
      this.jdField_a_of_type_Ajte = null;
    }
    this.jdField_a_of_type_Ajtv = null;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajth
 * JD-Core Version:    0.7.0.1
 */