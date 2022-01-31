import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.annotation.DrawableRes;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.ColorNoteController.1;
import com.tencent.mobileqq.colornote.ColorNoteController.2;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class alrv
  implements aluv, alve
{
  private static SparseArrayCompat<altt> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
  private alse jdField_a_of_type_Alse;
  private altx jdField_a_of_type_Altx;
  private alty jdField_a_of_type_Alty;
  private alut jdField_a_of_type_Alut;
  private alvd jdField_a_of_type_Alvd;
  private SwipePostTableLayout jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ColorNoteController.1(this);
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private boolean c = true;
  private boolean d = true;
  
  public alrv(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramBoolean1, paramBoolean2, null);
  }
  
  public alrv(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout)
  {
    this(paramContext, paramBoolean1, paramBoolean2, paramSwipePostTableLayout, false, false, 2131099874);
  }
  
  public alrv(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout, boolean paramBoolean3, boolean paramBoolean4, @DrawableRes int paramInt)
  {
    if (paramBoolean1)
    {
      if (paramSwipePostTableLayout != null) {
        break label116;
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout = new SwipePostTableLayout(paramContext);
      if (paramBoolean3)
      {
        if (alux.a()) {
          break label125;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setBackgroundResource(paramInt);
      }
    }
    for (;;)
    {
      this.c = paramBoolean2;
      if ((paramBoolean2) && (!paramBoolean1)) {
        this.jdField_a_of_type_Altx = new altx();
      }
      this.jdField_a_of_type_Alty = new alty(paramContext);
      alss.a();
      return;
      label116:
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout = paramSwipePostTableLayout;
      break;
      label125:
      paramSwipePostTableLayout = (Activity)paramContext;
      if (!paramBoolean3) {}
      for (paramBoolean3 = bool;; paramBoolean3 = false)
      {
        this.jdField_a_of_type_Alvd = new alvd(paramSwipePostTableLayout, paramBoolean3);
        this.jdField_a_of_type_Alvd.a(this);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setTranslucentConvertor(this.jdField_a_of_type_Alvd);
        if (!paramBoolean4) {
          break label204;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnSwipeListener(this);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setReadyToSlide(false);
        break;
      }
      label204:
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.post(new ColorNoteController.2(this));
    }
  }
  
  public alrv(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, @DrawableRes int paramInt)
  {
    this(paramContext, paramBoolean1, paramBoolean2, null, paramBoolean3, paramBoolean4, paramInt);
  }
  
  public static altt a(ColorNote paramColorNote)
  {
    if (jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat == null) {
      p();
    }
    altt localaltt = (altt)jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramColorNote.getServiceType());
    paramColorNote = localaltt;
    if (localaltt == null) {
      paramColorNote = (altt)jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(65536);
    }
    return paramColorNote;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    alss.a().a(paramQQAppInterface, paramBoolean);
  }
  
  public static boolean a(Context paramContext, ColorNote paramColorNote)
  {
    boolean bool = false;
    Object localObject;
    switch (alsr.a(paramColorNote.getServiceType()))
    {
    default: 
      localObject = null;
      if (localObject != null)
      {
        if (!alsr.b(paramColorNote)) {
          break label252;
        }
        awqx.b(null, "dc00898", "", "", "0X800A8AB", "0X800A8AB", alru.b(alsr.a(paramColorNote.getServiceType())), 0, "", "", "", "");
      }
      break;
    }
    for (;;)
    {
      ((alsv)localObject).a(paramContext, alsr.b(paramColorNote));
      bool = true;
      return bool;
      localObject = new altd();
      break;
      localObject = new altb();
      break;
      localObject = new alsz();
      break;
      localObject = new alsw();
      break;
      localObject = new alsx();
      break;
      localObject = new alta();
      break;
      localObject = new alsu();
      break;
      localObject = new alsy();
      break;
      localObject = new altc();
      break;
      label252:
      awqx.b(null, "dc00898", "", "", "0X800A749", "0X800A749", alru.a(paramColorNote.getServiceType()), 0, "", "", "", "");
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return alss.a().a();
  }
  
  public static void c(boolean paramBoolean)
  {
    alss.a().a(paramBoolean);
  }
  
  private void e(boolean paramBoolean)
  {
    boolean bool = true;
    int i = 0;
    if (this.jdField_a_of_type_Alse != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      localObject = alss.a().a();
      if (localObject != null) {
        this.jdField_a_of_type_Alse.a(((Point)localObject).x, ((Point)localObject).y);
      }
      if ((!c()) && ((this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout == null) || (!this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.f))) {
        break label231;
      }
      if ((this.jdField_a_of_type_Alvd == null) || (this.jdField_a_of_type_Alvd.a())) {
        break label145;
      }
      if (paramBoolean) {
        this.jdField_a_of_type_Alut.onColorNoteAnimFinish();
      }
    }
    else
    {
      return;
    }
    this.b = true;
    this.jdField_a_of_type_Alvd.a();
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    return;
    label145:
    this.b = false;
    Object localObject = this.jdField_a_of_type_Alty.a();
    if (localObject != null)
    {
      localObject = ((alsd)localObject).getColorNote();
      if ((localObject == null) || (((ColorNote)localObject).mServiceType != 16842752)) {}
    }
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localObject = this.jdField_a_of_type_Alse;
      alut localalut = this.jdField_a_of_type_Alut;
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout == null) {}
      for (;;)
      {
        ((alse)localObject).a(localalut, paramBoolean, i);
        return;
        i = this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.getScrollX();
      }
      label231:
      this.jdField_a_of_type_Alut.onColorNoteAnimFinish();
      return;
    }
  }
  
  private static void p()
  {
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(65536, new alts());
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(16908289, new altv());
  }
  
  public ColorNote a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    return new alsl().a(paramInt).a(paramString1).b(paramString2).c(paramString3).d(paramString4).a(paramArrayOfByte).a();
  }
  
  public SwipePostTableLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.a();
    }
    if (this.jdField_a_of_type_Altx != null) {
      this.jdField_a_of_type_Altx.a();
    }
  }
  
  public void a(alry paramalry)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnColorNoteCurdListener(paramalry);
    }
    if (this.jdField_a_of_type_Altx != null) {
      this.jdField_a_of_type_Altx.a(paramalry);
    }
    if (this.jdField_a_of_type_Alty != null) {
      this.jdField_a_of_type_Alty.a(paramalry);
    }
    alss.a().a(paramalry);
  }
  
  public void a(alsd paramalsd)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setServiceInfo(paramalsd);
    }
    if (this.jdField_a_of_type_Altx != null) {
      this.jdField_a_of_type_Altx.a(paramalsd);
    }
    this.jdField_a_of_type_Alty.a(paramalsd);
  }
  
  public void a(alur paramalur)
  {
    alss.a().a(paramalur);
  }
  
  public void a(alut paramalut)
  {
    this.jdField_a_of_type_Alut = paramalut;
  }
  
  public void a(alva paramalva)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnPageSwipeListener(paramalva);
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.a(paramActivity);
    }
    paramActivity = (ViewGroup)paramActivity.getWindow().getDecorView();
    View localView1 = paramActivity.getChildAt(0);
    View localView2 = paramActivity.findViewById(16908290);
    paramActivity = localView2;
    if (localView2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ColorNoteController", 2, "can not find content view");
      }
      paramActivity = localView1;
    }
    this.jdField_a_of_type_Alty.a(paramActivity);
    this.jdField_a_of_type_Alse = new alse(paramActivity);
    this.jdField_a_of_type_Alse.a();
    alss.a().a();
  }
  
  public void a(ColorNote paramColorNote)
  {
    if (this.jdField_a_of_type_Alty != null)
    {
      this.jdField_a_of_type_Alty.a(paramColorNote);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteController", 2, "update color note from share entrance: " + paramColorNote.getServiceType() + ", " + paramColorNote.mSubType + ", " + paramColorNote.mMainTitle);
      }
    }
  }
  
  public void a(String paramString)
  {
    int i = alsr.a(paramString);
    if (alsr.b(i)) {
      d(false);
    }
    while (alsr.a(i))
    {
      g();
      return;
      d(true);
    }
    h();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Alvd != null)) {
      this.jdField_a_of_type_Alvd.a();
    }
  }
  
  public boolean a()
  {
    return alss.a().b();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.b();
    }
    if (this.jdField_a_of_type_Altx != null) {
      this.jdField_a_of_type_Altx.b();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Alty != null) {
      return this.jdField_a_of_type_Alty.a();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.c();
    }
    if (this.jdField_a_of_type_Altx != null) {
      this.jdField_a_of_type_Altx.b(this.d);
    }
    alss.a().b();
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Alty != null) {
      return this.jdField_a_of_type_Alty.b();
    }
    return false;
  }
  
  public void d()
  {
    e(false);
  }
  
  public void d(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      return this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.e;
    }
    return false;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Alty != null)
    {
      this.jdField_a_of_type_Alty.a();
      ColorNote localColorNote = this.jdField_a_of_type_Alty.a().getColorNote();
      if (localColorNote != null)
      {
        alss.a().a(localColorNote.mServiceType, localColorNote.mSubType, true);
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteController", 2, "insert color note from share entrance: " + localColorNote.getServiceType() + ", " + localColorNote.mSubType + ", " + localColorNote.mMainTitle);
        }
      }
    }
  }
  
  public boolean e()
  {
    return this.c;
  }
  
  public void e_(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setReadyToSlide(true);
    }
    if (this.b) {
      d();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Alty != null)
    {
      this.jdField_a_of_type_Alty.b();
      ColorNote localColorNote = this.jdField_a_of_type_Alty.a().getColorNote();
      if (localColorNote != null)
      {
        alss.a().a(localColorNote.mServiceType, localColorNote.mSubType, false);
        if (this.jdField_a_of_type_Boolean)
        {
          BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
          bbmy.a(localBaseApplication, 2, localBaseApplication.getString(2131625293), 2000).a();
        }
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteController", 2, "delete color note from share entrance: " + localColorNote.getServiceType() + ", " + localColorNote.mSubType + ", " + localColorNote.mMainTitle);
        }
      }
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.i();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.j();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Alty != null) {
      this.jdField_a_of_type_Alty.c();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.e();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.f();
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void m()
  {
    alss.a().a();
  }
  
  public void n()
  {
    alss.a().b();
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_Altx != null) {
      this.jdField_a_of_type_Altx.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alrv
 * JD-Core Version:    0.7.0.1
 */