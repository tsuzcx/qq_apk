import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class akxv
  implements akym, Handler.Callback
{
  private static final int jdField_a_of_type_Int = ViewUtils.dpToPx(30.0F);
  private static final int jdField_b_of_type_Int = ViewUtils.dpToPx(28.0F);
  private static final int c = ViewUtils.dpToPx(72.0F);
  private static final int d = ViewUtils.dpToPx(63.0F);
  protected long a;
  private akyk jdField_a_of_type_Akyk;
  private akyl jdField_a_of_type_Akyl;
  private akyn jdField_a_of_type_Akyn;
  protected akyo a;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private WeakReference<akxy> jdField_a_of_type_JavaLangRefWeakReference;
  private List<WeakReference<akyi>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private akyl jdField_b_of_type_Akyl;
  private boolean jdField_b_of_type_Boolean = true;
  private int e = -1;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  private int k;
  private int l;
  
  private akxv()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public static akxv a()
  {
    return akxx.a;
  }
  
  private void g()
  {
    this.jdField_a_of_type_Akyk.highlightBackgroundColor(this.k);
    this.jdField_a_of_type_Akyk.selectContent(this.e, this.f);
    this.jdField_a_of_type_Akyk.highlightContent();
    this.jdField_a_of_type_Akyl.b(this.l);
    this.jdField_b_of_type_Akyl.b(this.l);
    this.jdField_a_of_type_Akyk.locationByIndex(this.e, this.jdField_a_of_type_ArrayOfInt, true);
    this.jdField_a_of_type_Akyl.b(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], 1);
    this.jdField_a_of_type_Akyk.locationByIndex(this.f, this.jdField_a_of_type_ArrayOfInt, false);
    this.jdField_b_of_type_Akyl.b(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], 2);
  }
  
  private boolean g()
  {
    return this.jdField_a_of_type_Akyk != null;
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_Akyl == null) || (this.jdField_b_of_type_Akyl == null)) {
      throw new IllegalStateException("Has not bound cursors.");
    }
  }
  
  private boolean h()
  {
    return this.jdField_a_of_type_Akyo != null;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Akyn == null) {
      throw new IllegalStateException("Has no magnifier.");
    }
  }
  
  private void j()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      akyi localakyi = (akyi)((WeakReference)localIterator.next()).get();
      if (localakyi != null) {
        localakyi.a(this);
      }
    }
  }
  
  public int a()
  {
    g();
    if (this.jdField_a_of_type_Akyk != null) {
      return this.jdField_a_of_type_Akyk.contentLength();
    }
    return 0;
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (this.jdField_a_of_type_Akyl != null) && (d())) {
      return this.jdField_a_of_type_Akyl.a(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    if ((paramInt1 == 2) && (this.jdField_b_of_type_Akyl != null) && (e())) {
      return this.jdField_b_of_type_Akyl.a(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    return -1;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    g();
    return this.jdField_a_of_type_Akyk.touchIndex(paramInt1, paramInt2);
  }
  
  @Nullable
  akxy a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (akxy)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  @Nullable
  public View a()
  {
    if (this.jdField_a_of_type_Akyk != null) {
      return this.jdField_a_of_type_Akyk.view();
    }
    return null;
  }
  
  @Nullable
  public String a()
  {
    g();
    if (this.jdField_a_of_type_Akyk != null)
    {
      CharSequence localCharSequence = this.jdField_a_of_type_Akyk.content();
      if (localCharSequence != null) {
        return localCharSequence.toString();
      }
      return "";
    }
    return "";
  }
  
  public void a()
  {
    a((View)null);
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == -1) || (paramInt2 == -1))
    {
      this.e = -1;
      this.f = -1;
      this.jdField_a_of_type_Boolean = false;
    }
    label191:
    for (;;)
    {
      g();
      this.jdField_a_of_type_Akyk.selectContent(this.e, this.f);
      this.jdField_a_of_type_Akyk.highlightContent();
      h();
      this.jdField_a_of_type_Akyk.locationByIndex(this.e, this.jdField_a_of_type_ArrayOfInt, true);
      this.jdField_a_of_type_Akyl.b(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], 1);
      this.jdField_a_of_type_Akyk.locationByIndex(this.f, this.jdField_a_of_type_ArrayOfInt, false);
      this.jdField_b_of_type_Akyl.b(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], 2);
      j();
      return;
      if (paramInt1 > paramInt2) {
        this.e = paramInt2;
      }
      for (this.f = paramInt1;; this.f = paramInt2)
      {
        if (this.f - this.e <= 0) {
          break label191;
        }
        this.jdField_a_of_type_Boolean = true;
        break;
        this.e = paramInt1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    g();
    h();
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = Integer.valueOf(paramInt3);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 10L);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    g();
    i();
    if (this.g == -1) {}
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    Message localMessage = Message.obtain();
    if (paramBoolean) {}
    for (int m = 2;; m = 3)
    {
      localMessage.what = m;
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      localMessage.obj = Integer.valueOf(this.g);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 10L);
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.g = paramInt;
    if (!paramBoolean) {
      this.h = paramInt;
    }
  }
  
  void a(@Nullable akxy paramakxy)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramakxy);
  }
  
  public void a(@NonNull akyi paramakyi)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (paramakyi != (akyi)((WeakReference)localIterator.next()).get());
    for (int m = 1;; m = 0)
    {
      if (m == 0) {
        this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramakyi));
      }
      return;
    }
  }
  
  public void a(@NonNull akyk paramakyk)
  {
    this.jdField_a_of_type_Akyk = paramakyk;
  }
  
  public void a(@NonNull akyl paramakyl1, @NonNull akyl paramakyl2)
  {
    this.jdField_a_of_type_Akyl = paramakyl1;
    this.jdField_b_of_type_Akyl = paramakyl2;
  }
  
  public void a(@NonNull akyo paramakyo)
  {
    this.jdField_a_of_type_Akyo = paramakyo;
  }
  
  void a(View paramView)
  {
    if (paramView != null) {
      paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    }
    for (int m = this.jdField_a_of_type_ArrayOfInt[1];; m = ViewUtils.getScreenHeight())
    {
      d(m);
      return;
    }
  }
  
  void a(BaseChatPie paramBaseChatPie)
  {
    BaseChatPie localBaseChatPie = paramBaseChatPie;
    if (paramBaseChatPie == null)
    {
      localBaseChatPie = paramBaseChatPie;
      if ((this.jdField_a_of_type_Akyo instanceof akxu)) {
        localBaseChatPie = ((akxu)this.jdField_a_of_type_Akyo).a;
      }
    }
    if ((localBaseChatPie != null) && (localBaseChatPie.mInputBar != null) && (localBaseChatPie.mInputBar.getVisibility() == 0)) {
      localBaseChatPie.mInputBar.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    }
    for (int m = this.jdField_a_of_type_ArrayOfInt[1];; m = ViewUtils.getScreenHeight())
    {
      d(m);
      return;
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    g();
    this.e = 0;
    this.f = this.jdField_a_of_type_Akyk.contentLength();
    if (this.e >= this.f)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Akyk.highlightBackgroundColor(this.k);
    this.jdField_a_of_type_Akyk.selectContent(this.e, this.f);
    this.jdField_a_of_type_Akyk.highlightContent();
    h();
    this.g = -1;
    this.h = -1;
    this.i = -1;
    this.j = -1;
    this.jdField_a_of_type_Akyl.b(this.l);
    this.jdField_b_of_type_Akyl.b(this.l);
    this.jdField_a_of_type_Akyk.locationByIndex(this.e, this.jdField_a_of_type_ArrayOfInt, true);
    this.jdField_a_of_type_Akyl.b(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], 1);
    this.jdField_a_of_type_Akyk.locationByIndex(this.f, this.jdField_a_of_type_ArrayOfInt, false);
    this.jdField_b_of_type_Akyl.b(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], 2);
    a();
    if (this.jdField_a_of_type_Akyn == null) {
      this.jdField_a_of_type_Akyn = new akyj();
    }
    for (;;)
    {
      j();
      return;
      if (this.jdField_a_of_type_Akyn.a()) {
        this.jdField_a_of_type_Akyn.a();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Akyo != null) {
      return this.jdField_a_of_type_Akyo.a();
    }
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (!c()) {}
    int m;
    int n;
    int i1;
    int i2;
    do
    {
      do
      {
        return false;
      } while (this.jdField_a_of_type_Akyk == null);
      View localView = this.jdField_a_of_type_Akyk.view();
      localView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      m = this.jdField_a_of_type_ArrayOfInt[0];
      n = this.jdField_a_of_type_ArrayOfInt[1];
      i1 = localView.getMeasuredWidth();
      i2 = localView.getMeasuredHeight();
    } while ((paramInt1 < m) || (paramInt1 > i1 + m) || (paramInt2 < n) || (paramInt2 > i2 + n));
    return true;
  }
  
  public int b()
  {
    g();
    return this.e;
  }
  
  @Nullable
  public String b()
  {
    g();
    CharSequence localCharSequence = this.jdField_a_of_type_Akyk.selectContent();
    if (localCharSequence != null) {
      return localCharSequence.toString();
    }
    return null;
  }
  
  public void b()
  {
    h();
    this.jdField_a_of_type_Akyo.a();
  }
  
  public void b(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramInt2;
  }
  
  public void b(@NonNull akyi paramakyi)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    WeakReference localWeakReference;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localWeakReference = (WeakReference)localIterator.next();
    } while (paramakyi != (akyi)localWeakReference.get());
    for (paramakyi = localWeakReference;; paramakyi = null)
    {
      if (paramakyi != null) {
        this.jdField_a_of_type_JavaUtilList.remove(paramakyi);
      }
      return;
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public int c()
  {
    g();
    return this.f;
  }
  
  public String c()
  {
    if ((this.jdField_a_of_type_Akyk instanceof MixedMsgLinearLayout))
    {
      g();
      CharSequence localCharSequence = ((MixedMsgLinearLayout)this.jdField_a_of_type_Akyk).a();
      if (localCharSequence != null) {
        return localCharSequence.toString();
      }
      return null;
    }
    return b();
  }
  
  public void c()
  {
    j();
  }
  
  public void c(int paramInt)
  {
    this.l = paramInt;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int d()
  {
    return this.g;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
    if (this.jdField_a_of_type_Akyn != null)
    {
      if (this.jdField_a_of_type_Akyn.a()) {
        this.jdField_a_of_type_Akyn.a();
      }
      this.jdField_a_of_type_Akyn = null;
    }
    f();
    this.jdField_a_of_type_Akyo = null;
    this.jdField_a_of_type_Boolean = false;
    this.e = -1;
    this.f = -1;
    this.g = -1;
    this.h = -1;
    this.i = -1;
    this.j = -1;
    this.jdField_a_of_type_Long = -1L;
    j();
  }
  
  void d(int paramInt)
  {
    int i2 = 0;
    if (!g()) {}
    while (!h()) {
      return;
    }
    int m;
    int i1;
    label61:
    Object localObject;
    if ((this.jdField_a_of_type_Akyo instanceof akyc))
    {
      m = ((akyc)this.jdField_a_of_type_Akyo).jdField_b_of_type_Int;
      if (!(this.jdField_a_of_type_Akyo instanceof akyc)) {
        break label328;
      }
      i1 = ((akyc)this.jdField_a_of_type_Akyo).jdField_a_of_type_Int;
      localObject = this.jdField_a_of_type_Akyk.view();
      if (((View)localObject).getId() == 2131364441) {
        break label594;
      }
      View localView = ((View)localObject).findViewById(2131364441);
      if (localView == null) {
        break label594;
      }
      localObject = localView;
    }
    label328:
    label594:
    for (;;)
    {
      ((View)localObject).getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      int i3 = this.jdField_a_of_type_ArrayOfInt[1];
      int i4 = this.jdField_a_of_type_ArrayOfInt[1] + ((View)localObject).getHeight();
      int i5 = this.jdField_a_of_type_ArrayOfInt[0];
      int i6 = this.jdField_a_of_type_Akyk.view().getPaddingLeft();
      this.jdField_a_of_type_Akyk.locationByIndex(this.e, this.jdField_a_of_type_ArrayOfInt, true);
      int i7 = this.jdField_a_of_type_ArrayOfInt[0];
      this.jdField_a_of_type_Akyk.locationByIndex(this.f, this.jdField_a_of_type_ArrayOfInt, false);
      int n = this.jdField_a_of_type_ArrayOfInt[0];
      if (this.h == 2) {
        if ((n - m > jdField_a_of_type_Int) || (n - m < 0)) {
          if (n - jdField_a_of_type_Int < i6 + i5)
          {
            label242:
            if (i3 - jdField_b_of_type_Int >= c + ImmersiveUtils.c) {
              break label572;
            }
            if (i4 + 0 >= c + ImmersiveUtils.c) {
              break label443;
            }
            if ((i1 == 0) || (i1 - jdField_b_of_type_Int <= c + ImmersiveUtils.c)) {
              break label388;
            }
            paramInt = jdField_b_of_type_Int;
            n = m;
            paramInt = i1 - paramInt;
            m = i2;
          }
        }
      }
      for (;;)
      {
        a(n, paramInt, m);
        return;
        m = this.jdField_a_of_type_Akyo.a();
        break;
        i1 = this.jdField_a_of_type_Akyo.b();
        break label61;
        n -= jdField_a_of_type_Int;
        break label242;
        n = m;
        break label242;
        if ((m - i7 > jdField_a_of_type_Int) || (m - i7 < 0))
        {
          n = jdField_a_of_type_Int + i7;
          break label242;
        }
        n = m;
        break label242;
        if ((i1 != 0) && (d + i1 - jdField_b_of_type_Int < paramInt))
        {
          paramInt = jdField_b_of_type_Int;
          i2 = 1;
          paramInt = i1 - paramInt;
          n = m;
          m = i2;
        }
        else
        {
          paramInt = c;
          paramInt = ImmersiveUtils.c + paramInt;
          m = i2;
        }
      }
      i2 = i4 + 0;
      if (d + i2 > paramInt) {
        if ((i1 != 0) && (i1 - jdField_b_of_type_Int > c + ImmersiveUtils.c))
        {
          paramInt = jdField_b_of_type_Int;
          i1 -= paramInt;
          paramInt = 0;
          n = m;
          m = i1;
        }
      }
      for (;;)
      {
        i1 = paramInt;
        paramInt = m;
        m = i1;
        break;
        if ((i1 != 0) && (d + i1 - jdField_b_of_type_Int < paramInt))
        {
          paramInt = jdField_b_of_type_Int;
          n = m;
          m = i1 - paramInt;
          paramInt = 1;
        }
        else
        {
          m = c + ImmersiveUtils.c + d + jdField_b_of_type_Int;
          paramInt = 0;
          continue;
          paramInt = 1;
          m = i2;
        }
      }
      if (i3 > paramInt) {}
      for (;;)
      {
        m = i2;
        break;
        paramInt = i3 - jdField_b_of_type_Int;
      }
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Akyl != null) && (this.jdField_a_of_type_Akyl.a(1));
  }
  
  void e()
  {
    g();
    h();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  public boolean e()
  {
    return (this.jdField_b_of_type_Akyl != null) && (this.jdField_b_of_type_Akyl.a(2));
  }
  
  void f()
  {
    if (this.jdField_a_of_type_Akyo != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if (this.jdField_a_of_type_Akyo.a()) {
        this.jdField_a_of_type_Akyo.a();
      }
    }
    if (this.jdField_a_of_type_Akyk != null)
    {
      this.jdField_a_of_type_Akyk.selectContent(-1, -1);
      this.jdField_a_of_type_Akyk.clearHighlightContent();
      this.jdField_a_of_type_Akyk = null;
    }
    if (this.jdField_a_of_type_Akyl != null)
    {
      if (this.jdField_a_of_type_Akyl.a(1)) {
        this.jdField_a_of_type_Akyl.a(1);
      }
      this.jdField_a_of_type_Akyl = null;
    }
    if (this.jdField_b_of_type_Akyl != null)
    {
      if (this.jdField_b_of_type_Akyl.a(2)) {
        this.jdField_b_of_type_Akyl.a(2);
      }
      this.jdField_b_of_type_Akyl = null;
    }
    a(null);
  }
  
  public boolean f()
  {
    return (d()) && (e());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if ((this.jdField_a_of_type_Akyk != null) && (this.jdField_a_of_type_Akyo != null))
      {
        this.jdField_a_of_type_Akyo.a(this.jdField_a_of_type_Akyk.view(), paramMessage.arg1, paramMessage.arg2, ((Integer)paramMessage.obj).intValue());
        if ((this.jdField_a_of_type_Akyn != null) && (this.jdField_a_of_type_Akyn.a())) {
          this.jdField_a_of_type_Akyn.a();
        }
      }
      return true;
    }
    akyl localakyl;
    if (paramMessage.what == 2)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      if (this.jdField_a_of_type_Akyn != null)
      {
        if (((Integer)paramMessage.obj).intValue() != 1) {
          break label192;
        }
        localakyl = this.jdField_a_of_type_Akyl;
        if ((localakyl != null) && (this.jdField_a_of_type_Akyk != null)) {
          this.jdField_a_of_type_Akyn.a(localakyl.a(), paramMessage.arg1, paramMessage.arg2, this.jdField_a_of_type_Akyk.view(), true);
        }
      }
    }
    for (;;)
    {
      return false;
      label192:
      localakyl = this.jdField_b_of_type_Akyl;
      break;
      if (paramMessage.what == 3)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
        if (this.jdField_a_of_type_Akyn != null)
        {
          if (((Integer)paramMessage.obj).intValue() == 1) {}
          for (localakyl = this.jdField_a_of_type_Akyl;; localakyl = this.jdField_b_of_type_Akyl)
          {
            if ((localakyl == null) || (this.jdField_a_of_type_Akyk == null)) {
              break label303;
            }
            this.jdField_a_of_type_Akyn.a(localakyl.a(), paramMessage.arg1, paramMessage.arg2, this.jdField_a_of_type_Akyk.view(), false);
            break;
          }
        }
      }
      else
      {
        label303:
        if (paramMessage.what == 4)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
          if ((this.jdField_a_of_type_Akyk != null) && (this.jdField_a_of_type_Akyl != null) && (this.jdField_b_of_type_Akyl != null))
          {
            g();
            a();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxv
 * JD-Core Version:    0.7.0.1
 */