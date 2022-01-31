import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ajfq
{
  private ajeq jdField_a_of_type_Ajeq;
  private ajez jdField_a_of_type_Ajez;
  private ajfa jdField_a_of_type_Ajfa;
  private ajfd jdField_a_of_type_Ajfd;
  private ajfp jdField_a_of_type_Ajfp;
  private ajfr jdField_a_of_type_Ajfr;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public ajfq(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_Ajez = new ajez(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Ajfr = new ajfr(this.jdField_a_of_type_Ajez);
    this.jdField_a_of_type_Ajfd = new ajfd(this.jdField_a_of_type_Ajez, this.jdField_a_of_type_Ajfr);
    this.jdField_a_of_type_Ajfa = new ajfa(this.jdField_a_of_type_Ajez);
    this.jdField_a_of_type_Ajfp = new ajfp(this.jdField_a_of_type_Ajez, this.jdField_a_of_type_Ajfr, this.jdField_a_of_type_Ajfa, this.jdField_a_of_type_Ajfd);
    this.jdField_a_of_type_Ajez.a(this.jdField_a_of_type_Ajfa);
    paramQQAppInterface = ajfh.a(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this);
    }
  }
  
  public ajeq a()
  {
    return this.jdField_a_of_type_Ajeq;
  }
  
  public ajez a()
  {
    return this.jdField_a_of_type_Ajez;
  }
  
  public ajfp a()
  {
    return this.jdField_a_of_type_Ajfp;
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
    if (this.jdField_a_of_type_Ajfp != null) {
      this.jdField_a_of_type_Ajfp.a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    aiwp localaiwp = new aiwp(paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_Ajez.a(localaiwp);
  }
  
  public void a(int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteDrawerInfoManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_Ajez == null) || (this.jdField_a_of_type_Ajfp == null) || (this.jdField_a_of_type_Ajfd == null)) {
      return;
    }
    this.jdField_a_of_type_Ajez.c(true);
    int i = ajfh.b(this.jdField_a_of_type_Ajez.e);
    this.jdField_a_of_type_Ajez.b(i);
    ajlo.a(i, 100, 0, new Object[] { "onSurfaceReady" });
    this.jdField_a_of_type_Ajez.a(-2, paramInt);
    ajlo.a(i, 200);
    this.jdField_a_of_type_Ajfd.a();
    ajlo.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Ajez.b(true);
    ajlo.a(i, 300);
    this.jdField_a_of_type_Ajfp.a(this.jdField_a_of_type_Ajez);
    ajlo.a(i, 300, 0, new Object[] { "initSprite done" });
    ajlo.a(i, 1, 0, new Object[] { "terminal all done" });
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ajeq = ((ajeq)this.jdField_a_of_type_Ajfd.a(0));
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    ajeq localajeq = a();
    if ((localajeq != null) && (paramArrayList != null))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equals(this.jdField_a_of_type_Ajez.jdField_b_of_type_JavaLangString)) {
          localajeq.a(paramInt, paramArrayList);
        }
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.jdField_a_of_type_Boolean) {
      ajlo.a(ajfh.b(this.jdField_a_of_type_Ajez.e), 1, paramInt, 0L, paramVarArgs);
    }
  }
  
  public void a(aiuz paramaiuz)
  {
    if (paramaiuz == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Ajez.a(paramaiuz);
      localApolloCmdChannel = ApolloCmdChannel.getChannel(this.jdField_a_of_type_Ajez.a());
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramaiuz);
  }
  
  public void a(ajfk paramajfk)
  {
    if (paramajfk != null) {
      this.jdField_a_of_type_Ajez.a(paramajfk);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_Ajez.a(paramString);
    this.jdField_a_of_type_Ajez.jdField_b_of_type_Int = airx.a(a(), paramString);
  }
  
  public void b()
  {
    if (!ajfh.d(a())) {
      return;
    }
    if (this.jdField_a_of_type_Ajeq != null) {
      this.jdField_a_of_type_Ajeq.c(1);
    }
    this.jdField_a_of_type_Ajez.a(-1);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Ajez != null) {
      this.jdField_a_of_type_Ajez.a(-2, paramInt);
    }
  }
  
  public void c()
  {
    if (!ajfh.d(a())) {}
    while (this.jdField_a_of_type_Ajeq == null) {
      return;
    }
    this.jdField_a_of_type_Ajeq.c(2);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ajfa != null) {
      this.jdField_a_of_type_Ajfa.a();
    }
    Object localObject = this.jdField_a_of_type_Ajez.a();
    if (localObject != null)
    {
      localObject = ((aiuz)localObject).getRenderImpl();
      if (localObject != null) {
        ((aitk)localObject).c();
      }
    }
    ajlo.a(this.jdField_a_of_type_Ajez.a(), true);
    this.jdField_a_of_type_Ajfr.a();
    this.jdField_a_of_type_Ajfd.b();
    this.jdField_a_of_type_Ajez.c();
    this.jdField_a_of_type_Ajfp.b();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajfq
 * JD-Core Version:    0.7.0.1
 */