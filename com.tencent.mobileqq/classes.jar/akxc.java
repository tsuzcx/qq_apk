import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class akxc
{
  private akwc jdField_a_of_type_Akwc;
  private akwl jdField_a_of_type_Akwl;
  private akwm jdField_a_of_type_Akwm;
  private akwp jdField_a_of_type_Akwp;
  private akxb jdField_a_of_type_Akxb;
  private akxd jdField_a_of_type_Akxd;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public akxc(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_Akwl = new akwl(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Akxd = new akxd(this.jdField_a_of_type_Akwl);
    this.jdField_a_of_type_Akwp = new akwp(this.jdField_a_of_type_Akwl, this.jdField_a_of_type_Akxd);
    this.jdField_a_of_type_Akwm = new akwm(this.jdField_a_of_type_Akwl);
    this.jdField_a_of_type_Akxb = new akxb(this.jdField_a_of_type_Akwl, this.jdField_a_of_type_Akxd, this.jdField_a_of_type_Akwm, this.jdField_a_of_type_Akwp);
    this.jdField_a_of_type_Akwl.a(this.jdField_a_of_type_Akwm);
    paramQQAppInterface = akwt.a(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this);
    }
  }
  
  public akwc a()
  {
    return this.jdField_a_of_type_Akwc;
  }
  
  public akwl a()
  {
    return this.jdField_a_of_type_Akwl;
  }
  
  public akxb a()
  {
    return this.jdField_a_of_type_Akxb;
  }
  
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Akxb != null) {
      this.jdField_a_of_type_Akxb.a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    akob localakob = new akob(paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_Akwl.a(localakob);
  }
  
  public void a(int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteDrawerInfoManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_Akwl == null) || (this.jdField_a_of_type_Akxb == null) || (this.jdField_a_of_type_Akwp == null)) {
      return;
    }
    this.jdField_a_of_type_Akwl.c(true);
    int i = akwt.b(this.jdField_a_of_type_Akwl.e);
    this.jdField_a_of_type_Akwl.b(i);
    alda.a(i, 100, 0, new Object[] { "onSurfaceReady" });
    this.jdField_a_of_type_Akwl.a(-2, paramInt);
    alda.a(i, 200);
    this.jdField_a_of_type_Akwp.a();
    alda.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Akwl.b(true);
    alda.a(i, 300);
    this.jdField_a_of_type_Akxb.a(this.jdField_a_of_type_Akwl);
    alda.a(i, 300, 0, new Object[] { "initSprite done" });
    alda.a(i, 1, 0, new Object[] { "terminal all done" });
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Akwc = ((akwc)this.jdField_a_of_type_Akwp.a(0));
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    akwc localakwc = a();
    if ((localakwc != null) && (paramArrayList != null))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equals(this.jdField_a_of_type_Akwl.jdField_b_of_type_JavaLangString)) {
          localakwc.a(paramInt, paramArrayList);
        }
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.jdField_a_of_type_Boolean) {
      alda.a(akwt.b(this.jdField_a_of_type_Akwl.e), 1, paramInt, 0L, paramVarArgs);
    }
  }
  
  public void a(akml paramakml)
  {
    if (paramakml == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Akwl.a(paramakml);
      localApolloCmdChannel = ApolloCmdChannel.getChannel(this.jdField_a_of_type_Akwl.a());
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramakml);
  }
  
  public void a(akww paramakww)
  {
    if (paramakww != null) {
      this.jdField_a_of_type_Akwl.a(paramakww);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_Akwl.a(paramString);
    this.jdField_a_of_type_Akwl.jdField_b_of_type_Int = akji.a(a(), paramString);
  }
  
  public void b()
  {
    if (!akwt.d(a())) {
      return;
    }
    if (this.jdField_a_of_type_Akwc != null) {
      this.jdField_a_of_type_Akwc.c(1);
    }
    this.jdField_a_of_type_Akwl.a(-1);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Akwl != null) {
      this.jdField_a_of_type_Akwl.a(-2, paramInt);
    }
  }
  
  public void c()
  {
    if (!akwt.d(a())) {}
    while (this.jdField_a_of_type_Akwc == null) {
      return;
    }
    this.jdField_a_of_type_Akwc.c(2);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Akwm != null) {
      this.jdField_a_of_type_Akwm.a();
    }
    Object localObject = this.jdField_a_of_type_Akwl.a();
    if (localObject != null)
    {
      localObject = ((akml)localObject).getRenderImpl();
      if (localObject != null) {
        ((akkw)localObject).c();
      }
    }
    alda.a(this.jdField_a_of_type_Akwl.a(), true);
    this.jdField_a_of_type_Akxd.a();
    this.jdField_a_of_type_Akwp.b();
    this.jdField_a_of_type_Akwl.c();
    this.jdField_a_of_type_Akxb.b();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxc
 * JD-Core Version:    0.7.0.1
 */