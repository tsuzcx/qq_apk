import android.annotation.SuppressLint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ContainerView;
import java.lang.ref.WeakReference;

public class alwb<T extends BaseActivity>
  implements View.OnClickListener
{
  private static int jdField_b_of_type_Int = -1;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private alvu jdField_a_of_type_Alvu;
  protected alvy a;
  protected alwp a;
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
    if (alvr.a().c()) {
      return alvr.a().b();
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
    alvr localalvr = alvr.a();
    if ((!localalvr.c()) || (!this.jdField_a_of_type_Boolean)) {}
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
              this.jdField_b_of_type_Boolean = bool;
              this.jdField_a_of_type_Long = localalvr.jdField_a_of_type_Long;
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
      this.jdField_a_of_type_Int = 1;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Long = -1L;
      return;
      label281:
      localalvr.d();
    }
  }
  
  protected void a(bhjq parambhjq)
  {
    parambhjq.a(2131365307, anvx.a(2131701745), 2130838982);
    parambhjq.a(2131367213, anvx.a(2131701743), 2130838991);
    parambhjq.a(2131366456, anvx.a(2131701744), 2130838990);
  }
  
  public void a(T paramT, ContainerView paramContainerView)
  {
    this.jdField_a_of_type_JavaLangString = paramContainerView.a();
    this.jdField_a_of_type_Alwp = new alwp();
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
    paramContainerView.a.setOnTouchListener(new alwc(this));
    paramContainerView.a.setOnLongClickListener(new alwd(this, paramContainerView));
  }
  
  protected void a(ContainerView paramContainerView, View paramView)
  {
    if ((paramView instanceof alwg))
    {
      alwg localalwg = (alwg)paramView;
      if (paramView.getContext() != null)
      {
        bhjq localbhjq = new bhjq();
        a(localbhjq);
        if (this.jdField_a_of_type_Alvy == null)
        {
          this.jdField_a_of_type_Alvy = new alwo();
          this.jdField_a_of_type_Alvy.a(this);
        }
        int i = this.jdField_a_of_type_AndroidGraphicsPoint.y - AIOUtils.dp2px(10.0F, paramView.getResources());
        int j = this.jdField_a_of_type_AndroidGraphicsPoint.x - ViewUtils.dpToPx(14.0F);
        this.jdField_a_of_type_Alvy.a(localbhjq, false);
        this.jdField_a_of_type_Alvy.a(j);
        this.jdField_a_of_type_Alvy.b(i);
        this.jdField_a_of_type_Alvy.jdField_a_of_type_Int = i;
        this.jdField_a_of_type_Alvy.jdField_b_of_type_Int = j;
        if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
          com.tencent.qphone.base.util.QLog.d("CommonSelectableMenu", 2, "showMenuView: pointY -> " + i + ", lastShowX -> " + this.jdField_a_of_type_AndroidGraphicsPoint.x);
        }
        if (this.jdField_a_of_type_Alvu == null) {
          this.jdField_a_of_type_Alvu = new alvu();
        }
        this.jdField_a_of_type_Alvu.a(localalwg);
        this.jdField_a_of_type_Alvu.a(paramContainerView, paramContainerView);
        this.jdField_a_of_type_Alvu.a(this.jdField_a_of_type_Alvy);
        this.jdField_a_of_type_Alwp.a(paramView, this.jdField_a_of_type_Alvy);
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
    alvr localalvr = alvr.a();
    if ((localalvr.c()) && (localalvr.a())) {
      localalvr.d();
    }
  }
  
  public void b(ContainerView paramContainerView)
  {
    if ((paramContainerView != null) && (paramContainerView.a != null))
    {
      paramContainerView.a.setOnLongClickListener(null);
      paramContainerView.a.setOnClickListener(null);
    }
    if (this.jdField_a_of_type_Alvu != null)
    {
      this.jdField_a_of_type_Alvu.d();
      this.jdField_a_of_type_Alvu = null;
    }
    if (this.jdField_a_of_type_Alvy != null)
    {
      this.jdField_a_of_type_Alvy.a(null);
      this.jdField_a_of_type_Alvy = null;
    }
    this.jdField_a_of_type_Alwp = null;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alwb
 * JD-Core Version:    0.7.0.1
 */