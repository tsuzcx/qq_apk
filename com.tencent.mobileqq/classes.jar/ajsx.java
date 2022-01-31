import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ajsx
  implements ajto, Handler.Callback
{
  private static final int jdField_a_of_type_Int = bdkf.b(30.0F);
  private static final int jdField_b_of_type_Int = bdkf.b(72.0F);
  private static final int c = bdkf.b(63.0F);
  protected long a;
  private ajtm jdField_a_of_type_Ajtm;
  private ajtn jdField_a_of_type_Ajtn;
  private ajtp jdField_a_of_type_Ajtp;
  protected ajtq a;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private WeakReference<ajta> jdField_a_of_type_JavaLangRefWeakReference;
  private List<WeakReference<ajtk>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private ajtn jdField_b_of_type_Ajtn;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private int j;
  private int k;
  
  private ajsx()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public static ajsx a()
  {
    return ajsz.a;
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_Ajtm != null;
  }
  
  private boolean e()
  {
    return this.jdField_a_of_type_Ajtq != null;
  }
  
  private void g()
  {
    this.jdField_a_of_type_Ajtm.highlightBackgroundColor(this.j);
    this.jdField_a_of_type_Ajtm.selectContent(this.d, this.e);
    this.jdField_a_of_type_Ajtm.highlightContent();
    this.jdField_a_of_type_Ajtn.b(this.k);
    this.jdField_b_of_type_Ajtn.b(this.k);
    this.jdField_a_of_type_Ajtm.locationByIndex(this.d, this.jdField_a_of_type_ArrayOfInt, true);
    this.jdField_a_of_type_Ajtn.a(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], 1);
    this.jdField_a_of_type_Ajtm.locationByIndex(this.e, this.jdField_a_of_type_ArrayOfInt, false);
    this.jdField_b_of_type_Ajtn.a(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], 2);
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_Ajtn == null) || (this.jdField_b_of_type_Ajtn == null)) {
      throw new IllegalStateException("Has not bound cursors.");
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Ajtp == null) {
      throw new IllegalStateException("Has no magnifier.");
    }
  }
  
  private void j()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ajtk localajtk = (ajtk)((WeakReference)localIterator.next()).get();
      if (localajtk != null) {
        localajtk.a(this);
      }
    }
  }
  
  public int a()
  {
    d();
    if (this.jdField_a_of_type_Ajtm != null) {
      return this.jdField_a_of_type_Ajtm.contentLength();
    }
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    d();
    return this.jdField_a_of_type_Ajtm.touchIndex(paramInt1, paramInt2);
  }
  
  @Nullable
  ajta a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (ajta)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  @Nullable
  View a()
  {
    if (this.jdField_a_of_type_Ajtm != null) {
      return this.jdField_a_of_type_Ajtm.view();
    }
    return null;
  }
  
  @Nullable
  public String a()
  {
    d();
    CharSequence localCharSequence = this.jdField_a_of_type_Ajtm.selectContent();
    if (localCharSequence != null) {
      return localCharSequence.toString();
    }
    return null;
  }
  
  public void a()
  {
    a((View)null);
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == -1) || (paramInt2 == -1))
    {
      this.d = -1;
      this.e = -1;
      this.jdField_a_of_type_Boolean = false;
    }
    label191:
    for (;;)
    {
      d();
      this.jdField_a_of_type_Ajtm.selectContent(this.d, this.e);
      this.jdField_a_of_type_Ajtm.highlightContent();
      h();
      this.jdField_a_of_type_Ajtm.locationByIndex(this.d, this.jdField_a_of_type_ArrayOfInt, true);
      this.jdField_a_of_type_Ajtn.a(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], 1);
      this.jdField_a_of_type_Ajtm.locationByIndex(this.e, this.jdField_a_of_type_ArrayOfInt, false);
      this.jdField_b_of_type_Ajtn.a(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], 2);
      j();
      return;
      if (paramInt1 > paramInt2) {
        this.d = paramInt2;
      }
      for (this.e = paramInt1;; this.e = paramInt2)
      {
        if (this.e - this.d <= 0) {
          break label191;
        }
        this.jdField_a_of_type_Boolean = true;
        break;
        this.d = paramInt1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    d();
    e();
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = Integer.valueOf(paramInt3);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 10L);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    d();
    i();
    if (this.f == -1) {
      return;
    }
    Message localMessage = Message.obtain();
    if (paramBoolean) {}
    for (int m = 2;; m = 3)
    {
      localMessage.what = m;
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      localMessage.obj = Integer.valueOf(this.f);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 10L);
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.f = paramInt;
    if (!paramBoolean) {
      this.g = paramInt;
    }
  }
  
  void a(@Nullable ajta paramajta)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramajta);
  }
  
  public void a(@NonNull ajtk paramajtk)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (paramajtk != (ajtk)((WeakReference)localIterator.next()).get());
    for (int m = 1;; m = 0)
    {
      if (m == 0) {
        this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramajtk));
      }
      return;
    }
  }
  
  public void a(@NonNull ajtm paramajtm)
  {
    this.jdField_a_of_type_Ajtm = paramajtm;
  }
  
  public void a(@NonNull ajtn paramajtn1, @NonNull ajtn paramajtn2)
  {
    this.jdField_a_of_type_Ajtn = paramajtn1;
    this.jdField_b_of_type_Ajtn = paramajtn2;
  }
  
  public void a(@NonNull ajtq paramajtq)
  {
    this.jdField_a_of_type_Ajtq = paramajtq;
  }
  
  void a(View paramView)
  {
    if (paramView != null) {
      paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    }
    for (int m = this.jdField_a_of_type_ArrayOfInt[1];; m = bdkf.b())
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
      if ((this.jdField_a_of_type_Ajtq instanceof ajsw)) {
        localBaseChatPie = ((ajsw)this.jdField_a_of_type_Ajtq).a;
      }
    }
    if ((localBaseChatPie != null) && (localBaseChatPie.a != null) && (localBaseChatPie.a.getVisibility() == 0)) {
      localBaseChatPie.a.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    }
    for (int m = this.jdField_a_of_type_ArrayOfInt[1];; m = bdkf.b())
    {
      d(m);
      return;
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    d();
    this.d = 0;
    this.e = this.jdField_a_of_type_Ajtm.contentLength();
    if (this.d >= this.e)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ajtm.highlightBackgroundColor(this.j);
    this.jdField_a_of_type_Ajtm.selectContent(this.d, this.e);
    this.jdField_a_of_type_Ajtm.highlightContent();
    h();
    this.f = -1;
    this.g = -1;
    this.h = -1;
    this.i = -1;
    this.jdField_a_of_type_Ajtn.b(this.k);
    this.jdField_b_of_type_Ajtn.b(this.k);
    this.jdField_a_of_type_Ajtm.locationByIndex(this.d, this.jdField_a_of_type_ArrayOfInt, true);
    this.jdField_a_of_type_Ajtn.a(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], 1);
    this.jdField_a_of_type_Ajtm.locationByIndex(this.e, this.jdField_a_of_type_ArrayOfInt, false);
    this.jdField_b_of_type_Ajtn.a(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], 2);
    a();
    if (this.jdField_a_of_type_Ajtp == null) {
      this.jdField_a_of_type_Ajtp = new ajtl();
    }
    for (;;)
    {
      j();
      return;
      if (this.jdField_a_of_type_Ajtp.a()) {
        this.jdField_a_of_type_Ajtp.a();
      }
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Ajtq != null) {
      return this.jdField_a_of_type_Ajtq.a();
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
      } while (this.jdField_a_of_type_Ajtm == null);
      View localView = this.jdField_a_of_type_Ajtm.view();
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
    d();
    return this.d;
  }
  
  public String b()
  {
    if ((this.jdField_a_of_type_Ajtm instanceof MixedMsgLinearLayout))
    {
      d();
      CharSequence localCharSequence = ((MixedMsgLinearLayout)this.jdField_a_of_type_Ajtm).a();
      if (localCharSequence != null) {
        return localCharSequence.toString();
      }
      return null;
    }
    return a();
  }
  
  public void b()
  {
    e();
    this.jdField_a_of_type_Ajtq.a();
  }
  
  public void b(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  public void b(@NonNull ajtk paramajtk)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    WeakReference localWeakReference;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localWeakReference = (WeakReference)localIterator.next();
    } while (paramajtk != (ajtk)localWeakReference.get());
    for (paramajtk = localWeakReference;; paramajtk = null)
    {
      if (paramajtk != null) {
        this.jdField_a_of_type_JavaUtilList.remove(paramajtk);
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
    d();
    return this.e;
  }
  
  public void c()
  {
    j();
  }
  
  public void c(int paramInt)
  {
    this.k = paramInt;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int d()
  {
    return this.f;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
    if (this.jdField_a_of_type_Ajtp != null)
    {
      if (this.jdField_a_of_type_Ajtp.a()) {
        this.jdField_a_of_type_Ajtp.a();
      }
      this.jdField_a_of_type_Ajtp = null;
    }
    f();
    this.jdField_a_of_type_Ajtq = null;
    this.jdField_a_of_type_Boolean = false;
    this.d = -1;
    this.e = -1;
    this.f = -1;
    this.g = -1;
    this.h = -1;
    this.i = -1;
    this.jdField_a_of_type_Long = -1L;
    j();
  }
  
  void d(int paramInt)
  {
    int i2 = 0;
    if (!d()) {}
    while (!e()) {
      return;
    }
    int m;
    int i1;
    label61:
    Object localObject;
    if ((this.jdField_a_of_type_Ajtq instanceof ajte))
    {
      m = ((ajte)this.jdField_a_of_type_Ajtq).jdField_b_of_type_Int;
      if (!(this.jdField_a_of_type_Ajtq instanceof ajte)) {
        break label320;
      }
      i1 = ((ajte)this.jdField_a_of_type_Ajtq).jdField_a_of_type_Int;
      localObject = this.jdField_a_of_type_Ajtm.view();
      if (((View)localObject).getId() == 2131364171) {
        break label564;
      }
      View localView = ((View)localObject).findViewById(2131364171);
      if (localView == null) {
        break label564;
      }
      localObject = localView;
    }
    label429:
    label564:
    for (;;)
    {
      ((View)localObject).getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      int i3 = this.jdField_a_of_type_ArrayOfInt[1];
      int i4 = this.jdField_a_of_type_ArrayOfInt[1] + ((View)localObject).getHeight();
      int i5 = this.jdField_a_of_type_ArrayOfInt[0];
      int i6 = this.jdField_a_of_type_Ajtm.view().getPaddingLeft();
      this.jdField_a_of_type_Ajtm.locationByIndex(this.d, this.jdField_a_of_type_ArrayOfInt, true);
      int i7 = this.jdField_a_of_type_ArrayOfInt[0];
      this.jdField_a_of_type_Ajtm.locationByIndex(this.e, this.jdField_a_of_type_ArrayOfInt, false);
      int n = this.jdField_a_of_type_ArrayOfInt[0];
      if (this.g == 2) {
        if ((n - m > jdField_a_of_type_Int) || (n - m < 0)) {
          if (n - jdField_a_of_type_Int < i6 + i5)
          {
            label242:
            if (i3 + 0 >= jdField_b_of_type_Int + ImmersiveUtils.c) {
              break label544;
            }
            if (i4 + 0 >= jdField_b_of_type_Int + ImmersiveUtils.c) {
              break label429;
            }
            if ((i1 == 0) || (i1 + 0 <= jdField_b_of_type_Int + ImmersiveUtils.c)) {
              break label380;
            }
            n = m;
            paramInt = i1 + 0;
            m = i2;
          }
        }
      }
      for (;;)
      {
        a(n, paramInt, m);
        return;
        m = this.jdField_a_of_type_Ajtq.a();
        break;
        label320:
        i1 = this.jdField_a_of_type_Ajtq.b();
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
        label380:
        if ((i1 != 0) && (c + i1 + 0 < paramInt))
        {
          i2 = 1;
          paramInt = i1 + 0;
          n = m;
          m = i2;
        }
        else
        {
          paramInt = jdField_b_of_type_Int;
          paramInt = ImmersiveUtils.c + paramInt;
          m = i2;
        }
      }
      i2 = i4 + 0;
      if (c + i2 > paramInt) {
        if ((i1 != 0) && (i1 + 0 > jdField_b_of_type_Int + ImmersiveUtils.c))
        {
          i1 += 0;
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
        if ((i1 != 0) && (c + i1 + 0 < paramInt))
        {
          n = m;
          m = i1 + 0;
          paramInt = 1;
        }
        else
        {
          m = jdField_b_of_type_Int + ImmersiveUtils.c + c + 0;
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
        paramInt = i3 + 0;
      }
    }
  }
  
  void e()
  {
    d();
    h();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  void f()
  {
    if (this.jdField_a_of_type_Ajtq != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if (this.jdField_a_of_type_Ajtq.a()) {
        this.jdField_a_of_type_Ajtq.a();
      }
    }
    if (this.jdField_a_of_type_Ajtm != null)
    {
      this.jdField_a_of_type_Ajtm.selectContent(-1, -1);
      this.jdField_a_of_type_Ajtm.clearHighlightContent();
      this.jdField_a_of_type_Ajtm = null;
    }
    if (this.jdField_a_of_type_Ajtn != null)
    {
      if (this.jdField_a_of_type_Ajtn.a(1)) {
        this.jdField_a_of_type_Ajtn.a(1);
      }
      this.jdField_a_of_type_Ajtn = null;
    }
    if (this.jdField_b_of_type_Ajtn != null)
    {
      if (this.jdField_b_of_type_Ajtn.a(2)) {
        this.jdField_b_of_type_Ajtn.a(2);
      }
      this.jdField_b_of_type_Ajtn = null;
    }
    a(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if ((this.jdField_a_of_type_Ajtm != null) && (this.jdField_a_of_type_Ajtq != null))
      {
        this.jdField_a_of_type_Ajtq.a(this.jdField_a_of_type_Ajtm.view(), paramMessage.arg1, paramMessage.arg2, ((Integer)paramMessage.obj).intValue());
        if ((this.jdField_a_of_type_Ajtp != null) && (this.jdField_a_of_type_Ajtp.a())) {
          this.jdField_a_of_type_Ajtp.a();
        }
      }
      return true;
    }
    ajtn localajtn;
    if (paramMessage.what == 2)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      if (this.jdField_a_of_type_Ajtp != null)
      {
        if (((Integer)paramMessage.obj).intValue() != 1) {
          break label192;
        }
        localajtn = this.jdField_a_of_type_Ajtn;
        if ((localajtn != null) && (this.jdField_a_of_type_Ajtm != null)) {
          this.jdField_a_of_type_Ajtp.a(localajtn.a(), paramMessage.arg1, paramMessage.arg2, this.jdField_a_of_type_Ajtm.view(), true);
        }
      }
    }
    for (;;)
    {
      return false;
      label192:
      localajtn = this.jdField_b_of_type_Ajtn;
      break;
      if (paramMessage.what == 3)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
        if (this.jdField_a_of_type_Ajtp != null)
        {
          if (((Integer)paramMessage.obj).intValue() == 1) {}
          for (localajtn = this.jdField_a_of_type_Ajtn;; localajtn = this.jdField_b_of_type_Ajtn)
          {
            if ((localajtn == null) || (this.jdField_a_of_type_Ajtm == null)) {
              break label303;
            }
            this.jdField_a_of_type_Ajtp.a(localajtn.a(), paramMessage.arg1, paramMessage.arg2, this.jdField_a_of_type_Ajtm.view(), false);
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
          if ((this.jdField_a_of_type_Ajtm != null) && (this.jdField_a_of_type_Ajtn != null) && (this.jdField_b_of_type_Ajtn != null))
          {
            g();
            a();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsx
 * JD-Core Version:    0.7.0.1
 */