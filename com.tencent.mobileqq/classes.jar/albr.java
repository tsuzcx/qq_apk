import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class albr
{
  private alar jdField_a_of_type_Alar;
  private alba jdField_a_of_type_Alba;
  private albb jdField_a_of_type_Albb;
  private albe jdField_a_of_type_Albe;
  private albq jdField_a_of_type_Albq;
  private albs jdField_a_of_type_Albs;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public albr(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_Alba = new alba(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Albs = new albs(this.jdField_a_of_type_Alba);
    this.jdField_a_of_type_Albe = new albe(this.jdField_a_of_type_Alba, this.jdField_a_of_type_Albs);
    this.jdField_a_of_type_Albb = new albb(this.jdField_a_of_type_Alba);
    this.jdField_a_of_type_Albq = new albq(this.jdField_a_of_type_Alba, this.jdField_a_of_type_Albs, this.jdField_a_of_type_Albb, this.jdField_a_of_type_Albe);
    this.jdField_a_of_type_Alba.a(this.jdField_a_of_type_Albb);
    paramQQAppInterface = albi.a(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this);
    }
  }
  
  public alar a()
  {
    return this.jdField_a_of_type_Alar;
  }
  
  public alba a()
  {
    return this.jdField_a_of_type_Alba;
  }
  
  public albq a()
  {
    return this.jdField_a_of_type_Albq;
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
    if (this.jdField_a_of_type_Albq != null) {
      this.jdField_a_of_type_Albq.a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    aksq localaksq = new aksq(paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_Alba.a(localaksq);
  }
  
  public void a(int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteDrawerInfoManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_Alba == null) || (this.jdField_a_of_type_Albq == null) || (this.jdField_a_of_type_Albe == null)) {
      return;
    }
    this.jdField_a_of_type_Alba.c(true);
    int i = albi.b(this.jdField_a_of_type_Alba.e);
    this.jdField_a_of_type_Alba.b(i);
    alhp.a(i, 100, 0, new Object[] { "onSurfaceReady" });
    this.jdField_a_of_type_Alba.a(-2, paramInt);
    alhp.a(i, 200);
    this.jdField_a_of_type_Albe.a();
    alhp.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Alba.b(true);
    alhp.a(i, 300);
    this.jdField_a_of_type_Albq.a(this.jdField_a_of_type_Alba);
    alhp.a(i, 300, 0, new Object[] { "initSprite done" });
    alhp.a(i, 1, 0, new Object[] { "terminal all done" });
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Alar = ((alar)this.jdField_a_of_type_Albe.a(0));
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    alar localalar = a();
    if ((localalar != null) && (paramArrayList != null))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equals(this.jdField_a_of_type_Alba.jdField_b_of_type_JavaLangString)) {
          localalar.a(paramInt, paramArrayList);
        }
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.jdField_a_of_type_Boolean) {
      alhp.a(albi.b(this.jdField_a_of_type_Alba.e), 1, paramInt, 0L, paramVarArgs);
    }
  }
  
  public void a(akra paramakra)
  {
    if (paramakra == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Alba.a(paramakra);
      localApolloCmdChannel = ApolloCmdChannel.getChannel(this.jdField_a_of_type_Alba.a());
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramakra);
  }
  
  public void a(albl paramalbl)
  {
    if (paramalbl != null) {
      this.jdField_a_of_type_Alba.a(paramalbl);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_Alba.a(paramString);
    this.jdField_a_of_type_Alba.jdField_b_of_type_Int = aknx.a(a(), paramString);
  }
  
  public void b()
  {
    if (!albi.d(a())) {
      return;
    }
    if (this.jdField_a_of_type_Alar != null) {
      this.jdField_a_of_type_Alar.c(1);
    }
    this.jdField_a_of_type_Alba.a(-1);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Alba != null) {
      this.jdField_a_of_type_Alba.a(-2, paramInt);
    }
  }
  
  public void c()
  {
    if (!albi.d(a())) {}
    while (this.jdField_a_of_type_Alar == null) {
      return;
    }
    this.jdField_a_of_type_Alar.c(2);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Albb != null) {
      this.jdField_a_of_type_Albb.a();
    }
    Object localObject = this.jdField_a_of_type_Alba.a();
    if (localObject != null)
    {
      localObject = ((akra)localObject).getRenderImpl();
      if (localObject != null) {
        ((akpl)localObject).c();
      }
    }
    alhp.a(this.jdField_a_of_type_Alba.a(), true);
    this.jdField_a_of_type_Albs.a();
    this.jdField_a_of_type_Albe.b();
    this.jdField_a_of_type_Alba.c();
    this.jdField_a_of_type_Albq.b();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albr
 * JD-Core Version:    0.7.0.1
 */