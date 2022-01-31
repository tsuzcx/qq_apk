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

public final class aibp
  implements aicg, Handler.Callback
{
  private static final int jdField_a_of_type_Int = bbkx.b(30.0F);
  private static final int jdField_b_of_type_Int = bbkx.b(72.0F);
  private static final int c = bbkx.b(63.0F);
  protected long a;
  private aice jdField_a_of_type_Aice;
  private aicf jdField_a_of_type_Aicf;
  private aich jdField_a_of_type_Aich;
  protected aici a;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private WeakReference<aibs> jdField_a_of_type_JavaLangRefWeakReference;
  private List<WeakReference<aicc>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private aicf jdField_b_of_type_Aicf;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private int j;
  private int k;
  
  private aibp()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public static aibp a()
  {
    return aibr.a;
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_Aice != null;
  }
  
  private boolean e()
  {
    return this.jdField_a_of_type_Aici != null;
  }
  
  private void g()
  {
    this.jdField_a_of_type_Aice.highlightBackgroundColor(this.j);
    this.jdField_a_of_type_Aice.selectContent(this.d, this.e);
    this.jdField_a_of_type_Aice.highlightContent();
    this.jdField_a_of_type_Aicf.b(this.k);
    this.jdField_b_of_type_Aicf.b(this.k);
    this.jdField_a_of_type_Aice.locationByIndex(this.d, this.jdField_a_of_type_ArrayOfInt, true);
    this.jdField_a_of_type_Aicf.a(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], 1);
    this.jdField_a_of_type_Aice.locationByIndex(this.e, this.jdField_a_of_type_ArrayOfInt, false);
    this.jdField_b_of_type_Aicf.a(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], 2);
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_Aicf == null) || (this.jdField_b_of_type_Aicf == null)) {
      throw new IllegalStateException("Has not bound cursors.");
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Aich == null) {
      throw new IllegalStateException("Has no magnifier.");
    }
  }
  
  private void j()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      aicc localaicc = (aicc)((WeakReference)localIterator.next()).get();
      if (localaicc != null) {
        localaicc.a(this);
      }
    }
  }
  
  public int a()
  {
    d();
    if (this.jdField_a_of_type_Aice != null) {
      return this.jdField_a_of_type_Aice.contentLength();
    }
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    d();
    return this.jdField_a_of_type_Aice.touchIndex(paramInt1, paramInt2);
  }
  
  @Nullable
  aibs a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (aibs)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  @Nullable
  View a()
  {
    if (this.jdField_a_of_type_Aice != null) {
      return this.jdField_a_of_type_Aice.view();
    }
    return null;
  }
  
  @Nullable
  public String a()
  {
    d();
    CharSequence localCharSequence = this.jdField_a_of_type_Aice.selectContent();
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
      this.jdField_a_of_type_Aice.selectContent(this.d, this.e);
      this.jdField_a_of_type_Aice.highlightContent();
      h();
      this.jdField_a_of_type_Aice.locationByIndex(this.d, this.jdField_a_of_type_ArrayOfInt, true);
      this.jdField_a_of_type_Aicf.a(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], 1);
      this.jdField_a_of_type_Aice.locationByIndex(this.e, this.jdField_a_of_type_ArrayOfInt, false);
      this.jdField_b_of_type_Aicf.a(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], 2);
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
  
  void a(@Nullable aibs paramaibs)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaibs);
  }
  
  public void a(@NonNull aicc paramaicc)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (paramaicc != (aicc)((WeakReference)localIterator.next()).get());
    for (int m = 1;; m = 0)
    {
      if (m == 0) {
        this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramaicc));
      }
      return;
    }
  }
  
  public void a(@NonNull aice paramaice)
  {
    this.jdField_a_of_type_Aice = paramaice;
  }
  
  public void a(@NonNull aicf paramaicf1, @NonNull aicf paramaicf2)
  {
    this.jdField_a_of_type_Aicf = paramaicf1;
    this.jdField_b_of_type_Aicf = paramaicf2;
  }
  
  public void a(@NonNull aici paramaici)
  {
    this.jdField_a_of_type_Aici = paramaici;
  }
  
  void a(View paramView)
  {
    if (paramView != null) {
      paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    }
    for (int m = this.jdField_a_of_type_ArrayOfInt[1];; m = bbkx.b())
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
      if ((this.jdField_a_of_type_Aici instanceof aibo)) {
        localBaseChatPie = ((aibo)this.jdField_a_of_type_Aici).a;
      }
    }
    if ((localBaseChatPie != null) && (localBaseChatPie.a != null) && (localBaseChatPie.a.getVisibility() == 0)) {
      localBaseChatPie.a.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    }
    for (int m = this.jdField_a_of_type_ArrayOfInt[1];; m = bbkx.b())
    {
      d(m);
      return;
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    d();
    this.d = 0;
    this.e = this.jdField_a_of_type_Aice.contentLength();
    if (this.d >= this.e)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Aice.highlightBackgroundColor(this.j);
    this.jdField_a_of_type_Aice.selectContent(this.d, this.e);
    this.jdField_a_of_type_Aice.highlightContent();
    h();
    this.f = -1;
    this.g = -1;
    this.h = -1;
    this.i = -1;
    this.jdField_a_of_type_Aicf.b(this.k);
    this.jdField_b_of_type_Aicf.b(this.k);
    this.jdField_a_of_type_Aice.locationByIndex(this.d, this.jdField_a_of_type_ArrayOfInt, true);
    this.jdField_a_of_type_Aicf.a(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], 1);
    this.jdField_a_of_type_Aice.locationByIndex(this.e, this.jdField_a_of_type_ArrayOfInt, false);
    this.jdField_b_of_type_Aicf.a(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], 2);
    a();
    if (this.jdField_a_of_type_Aich == null) {
      this.jdField_a_of_type_Aich = new aicd();
    }
    for (;;)
    {
      j();
      return;
      if (this.jdField_a_of_type_Aich.a()) {
        this.jdField_a_of_type_Aich.a();
      }
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Aici != null) {
      return this.jdField_a_of_type_Aici.a();
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
      } while (this.jdField_a_of_type_Aice == null);
      View localView = this.jdField_a_of_type_Aice.view();
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
    if ((this.jdField_a_of_type_Aice instanceof MixedMsgLinearLayout))
    {
      d();
      CharSequence localCharSequence = ((MixedMsgLinearLayout)this.jdField_a_of_type_Aice).a();
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
    this.jdField_a_of_type_Aici.a();
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
  
  public void b(@NonNull aicc paramaicc)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    WeakReference localWeakReference;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localWeakReference = (WeakReference)localIterator.next();
    } while (paramaicc != (aicc)localWeakReference.get());
    for (paramaicc = localWeakReference;; paramaicc = null)
    {
      if (paramaicc != null) {
        this.jdField_a_of_type_JavaUtilList.remove(paramaicc);
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
    if (this.jdField_a_of_type_Aich != null)
    {
      if (this.jdField_a_of_type_Aich.a()) {
        this.jdField_a_of_type_Aich.a();
      }
      this.jdField_a_of_type_Aich = null;
    }
    f();
    this.jdField_a_of_type_Aici = null;
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
    if ((this.jdField_a_of_type_Aici instanceof aibw))
    {
      m = ((aibw)this.jdField_a_of_type_Aici).jdField_b_of_type_Int;
      if (!(this.jdField_a_of_type_Aici instanceof aibw)) {
        break label320;
      }
      i1 = ((aibw)this.jdField_a_of_type_Aici).jdField_a_of_type_Int;
      localObject = this.jdField_a_of_type_Aice.view();
      if (((View)localObject).getId() == 2131364110) {
        break label564;
      }
      View localView = ((View)localObject).findViewById(2131364110);
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
      int i6 = this.jdField_a_of_type_Aice.view().getPaddingLeft();
      this.jdField_a_of_type_Aice.locationByIndex(this.d, this.jdField_a_of_type_ArrayOfInt, true);
      int i7 = this.jdField_a_of_type_ArrayOfInt[0];
      this.jdField_a_of_type_Aice.locationByIndex(this.e, this.jdField_a_of_type_ArrayOfInt, false);
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
        m = this.jdField_a_of_type_Aici.a();
        break;
        label320:
        i1 = this.jdField_a_of_type_Aici.b();
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
    if (this.jdField_a_of_type_Aici != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if (this.jdField_a_of_type_Aici.a()) {
        this.jdField_a_of_type_Aici.a();
      }
    }
    if (this.jdField_a_of_type_Aice != null)
    {
      this.jdField_a_of_type_Aice.selectContent(-1, -1);
      this.jdField_a_of_type_Aice.clearHighlightContent();
      this.jdField_a_of_type_Aice = null;
    }
    if (this.jdField_a_of_type_Aicf != null)
    {
      if (this.jdField_a_of_type_Aicf.a(1)) {
        this.jdField_a_of_type_Aicf.a(1);
      }
      this.jdField_a_of_type_Aicf = null;
    }
    if (this.jdField_b_of_type_Aicf != null)
    {
      if (this.jdField_b_of_type_Aicf.a(2)) {
        this.jdField_b_of_type_Aicf.a(2);
      }
      this.jdField_b_of_type_Aicf = null;
    }
    a(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if ((this.jdField_a_of_type_Aice != null) && (this.jdField_a_of_type_Aici != null))
      {
        this.jdField_a_of_type_Aici.a(this.jdField_a_of_type_Aice.view(), paramMessage.arg1, paramMessage.arg2, ((Integer)paramMessage.obj).intValue());
        if ((this.jdField_a_of_type_Aich != null) && (this.jdField_a_of_type_Aich.a())) {
          this.jdField_a_of_type_Aich.a();
        }
      }
      return true;
    }
    aicf localaicf;
    if (paramMessage.what == 2)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      if (this.jdField_a_of_type_Aich != null)
      {
        if (((Integer)paramMessage.obj).intValue() != 1) {
          break label192;
        }
        localaicf = this.jdField_a_of_type_Aicf;
        if ((localaicf != null) && (this.jdField_a_of_type_Aice != null)) {
          this.jdField_a_of_type_Aich.a(localaicf.a(), paramMessage.arg1, paramMessage.arg2, this.jdField_a_of_type_Aice.view(), true);
        }
      }
    }
    for (;;)
    {
      return false;
      label192:
      localaicf = this.jdField_b_of_type_Aicf;
      break;
      if (paramMessage.what == 3)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
        if (this.jdField_a_of_type_Aich != null)
        {
          if (((Integer)paramMessage.obj).intValue() == 1) {}
          for (localaicf = this.jdField_a_of_type_Aicf;; localaicf = this.jdField_b_of_type_Aicf)
          {
            if ((localaicf == null) || (this.jdField_a_of_type_Aice == null)) {
              break label303;
            }
            this.jdField_a_of_type_Aich.a(localaicf.a(), paramMessage.arg1, paramMessage.arg2, this.jdField_a_of_type_Aice.view(), false);
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
          if ((this.jdField_a_of_type_Aice != null) && (this.jdField_a_of_type_Aicf != null) && (this.jdField_b_of_type_Aicf != null))
          {
            g();
            a();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aibp
 * JD-Core Version:    0.7.0.1
 */