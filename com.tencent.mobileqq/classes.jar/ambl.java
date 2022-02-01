import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ambl
{
  private amal jdField_a_of_type_Amal;
  private amau jdField_a_of_type_Amau;
  private amav jdField_a_of_type_Amav;
  private amay jdField_a_of_type_Amay;
  private ambk jdField_a_of_type_Ambk;
  private ambm jdField_a_of_type_Ambm;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public ambl(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_Amau = new amau(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Ambm = new ambm(this.jdField_a_of_type_Amau);
    this.jdField_a_of_type_Amay = new amay(this.jdField_a_of_type_Amau, this.jdField_a_of_type_Ambm);
    this.jdField_a_of_type_Amav = new amav(this.jdField_a_of_type_Amau);
    this.jdField_a_of_type_Ambk = new ambk(this.jdField_a_of_type_Amau, this.jdField_a_of_type_Ambm, this.jdField_a_of_type_Amav, this.jdField_a_of_type_Amay);
    this.jdField_a_of_type_Amau.a(this.jdField_a_of_type_Amav);
    paramQQAppInterface = ambc.a(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this);
    }
  }
  
  public amal a()
  {
    return this.jdField_a_of_type_Amal;
  }
  
  public amau a()
  {
    return this.jdField_a_of_type_Amau;
  }
  
  public ambk a()
  {
    return this.jdField_a_of_type_Ambk;
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
    if (this.jdField_a_of_type_Ambk != null) {
      this.jdField_a_of_type_Ambk.a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    alsk localalsk = new alsk(paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_Amau.a(localalsk);
  }
  
  public void a(int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteDrawerInfoManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_Amau == null) || (this.jdField_a_of_type_Ambk == null) || (this.jdField_a_of_type_Amay == null)) {
      return;
    }
    this.jdField_a_of_type_Amau.c(true);
    int i = ambc.b(this.jdField_a_of_type_Amau.e);
    this.jdField_a_of_type_Amau.b(i);
    amhk.a(i, 100, 0, new Object[] { "onSurfaceReady" });
    this.jdField_a_of_type_Amau.a(-2, paramInt);
    amhk.a(i, 200);
    this.jdField_a_of_type_Amay.a();
    amhk.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Amau.b(true);
    amhk.a(i, 300);
    this.jdField_a_of_type_Ambk.a(this.jdField_a_of_type_Amau);
    amhk.a(i, 300, 0, new Object[] { "initSprite done" });
    amhk.a(i, 1, 0, new Object[] { "terminal all done" });
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Amal = ((amal)this.jdField_a_of_type_Amay.a(0));
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    amal localamal = a();
    if ((localamal != null) && (paramArrayList != null))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equals(this.jdField_a_of_type_Amau.jdField_b_of_type_JavaLangString)) {
          localamal.a(paramInt, paramArrayList);
        }
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.jdField_a_of_type_Boolean) {
      amhk.a(ambc.b(this.jdField_a_of_type_Amau.e), 1, paramInt, 0L, paramVarArgs);
    }
  }
  
  public void a(alqu paramalqu)
  {
    if (paramalqu == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Amau.a(paramalqu);
      localApolloCmdChannel = ApolloCmdChannel.getChannel(this.jdField_a_of_type_Amau.a());
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramalqu);
  }
  
  public void a(ambf paramambf)
  {
    if (paramambf != null) {
      this.jdField_a_of_type_Amau.a(paramambf);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_Amau.a(paramString);
    this.jdField_a_of_type_Amau.jdField_b_of_type_Int = alnr.a(a(), paramString);
  }
  
  public void b()
  {
    if (!ambc.d(a())) {
      return;
    }
    if (this.jdField_a_of_type_Amal != null) {
      this.jdField_a_of_type_Amal.c(1);
    }
    this.jdField_a_of_type_Amau.a(-1);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Amau != null) {
      this.jdField_a_of_type_Amau.a(-2, paramInt);
    }
  }
  
  public void c()
  {
    if (!ambc.d(a())) {}
    while (this.jdField_a_of_type_Amal == null) {
      return;
    }
    this.jdField_a_of_type_Amal.c(2);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Amav != null) {
      this.jdField_a_of_type_Amav.a();
    }
    Object localObject = this.jdField_a_of_type_Amau.a();
    if (localObject != null)
    {
      localObject = ((alqu)localObject).getRenderImpl();
      if (localObject != null) {
        ((alpf)localObject).c();
      }
    }
    amhk.a(this.jdField_a_of_type_Amau.a(), true);
    this.jdField_a_of_type_Ambm.a();
    this.jdField_a_of_type_Amay.b();
    this.jdField_a_of_type_Amau.c();
    this.jdField_a_of_type_Ambk.b();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambl
 * JD-Core Version:    0.7.0.1
 */