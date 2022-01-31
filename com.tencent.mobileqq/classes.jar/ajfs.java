import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ajfs
{
  private ajes jdField_a_of_type_Ajes;
  private ajfb jdField_a_of_type_Ajfb;
  private ajfc jdField_a_of_type_Ajfc;
  private ajff jdField_a_of_type_Ajff;
  private ajfr jdField_a_of_type_Ajfr;
  private ajft jdField_a_of_type_Ajft;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public ajfs(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_Ajfb = new ajfb(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Ajft = new ajft(this.jdField_a_of_type_Ajfb);
    this.jdField_a_of_type_Ajff = new ajff(this.jdField_a_of_type_Ajfb, this.jdField_a_of_type_Ajft);
    this.jdField_a_of_type_Ajfc = new ajfc(this.jdField_a_of_type_Ajfb);
    this.jdField_a_of_type_Ajfr = new ajfr(this.jdField_a_of_type_Ajfb, this.jdField_a_of_type_Ajft, this.jdField_a_of_type_Ajfc, this.jdField_a_of_type_Ajff);
    this.jdField_a_of_type_Ajfb.a(this.jdField_a_of_type_Ajfc);
    paramQQAppInterface = ajfj.a(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this);
    }
  }
  
  public ajes a()
  {
    return this.jdField_a_of_type_Ajes;
  }
  
  public ajfb a()
  {
    return this.jdField_a_of_type_Ajfb;
  }
  
  public ajfr a()
  {
    return this.jdField_a_of_type_Ajfr;
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
    if (this.jdField_a_of_type_Ajfr != null) {
      this.jdField_a_of_type_Ajfr.a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    aiwr localaiwr = new aiwr(paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_Ajfb.a(localaiwr);
  }
  
  public void a(int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteDrawerInfoManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_Ajfb == null) || (this.jdField_a_of_type_Ajfr == null) || (this.jdField_a_of_type_Ajff == null)) {
      return;
    }
    this.jdField_a_of_type_Ajfb.c(true);
    int i = ajfj.b(this.jdField_a_of_type_Ajfb.e);
    this.jdField_a_of_type_Ajfb.b(i);
    ajlq.a(i, 100, 0, new Object[] { "onSurfaceReady" });
    this.jdField_a_of_type_Ajfb.a(-2, paramInt);
    ajlq.a(i, 200);
    this.jdField_a_of_type_Ajff.a();
    ajlq.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Ajfb.b(true);
    ajlq.a(i, 300);
    this.jdField_a_of_type_Ajfr.a(this.jdField_a_of_type_Ajfb);
    ajlq.a(i, 300, 0, new Object[] { "initSprite done" });
    ajlq.a(i, 1, 0, new Object[] { "terminal all done" });
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ajes = ((ajes)this.jdField_a_of_type_Ajff.a(0));
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    ajes localajes = a();
    if ((localajes != null) && (paramArrayList != null))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equals(this.jdField_a_of_type_Ajfb.jdField_b_of_type_JavaLangString)) {
          localajes.a(paramInt, paramArrayList);
        }
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.jdField_a_of_type_Boolean) {
      ajlq.a(ajfj.b(this.jdField_a_of_type_Ajfb.e), 1, paramInt, 0L, paramVarArgs);
    }
  }
  
  public void a(aivb paramaivb)
  {
    if (paramaivb == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Ajfb.a(paramaivb);
      localApolloCmdChannel = ApolloCmdChannel.getChannel(this.jdField_a_of_type_Ajfb.a());
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramaivb);
  }
  
  public void a(ajfm paramajfm)
  {
    if (paramajfm != null) {
      this.jdField_a_of_type_Ajfb.a(paramajfm);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_Ajfb.a(paramString);
    this.jdField_a_of_type_Ajfb.jdField_b_of_type_Int = airz.a(a(), paramString);
  }
  
  public void b()
  {
    if (!ajfj.d(a())) {
      return;
    }
    if (this.jdField_a_of_type_Ajes != null) {
      this.jdField_a_of_type_Ajes.c(1);
    }
    this.jdField_a_of_type_Ajfb.a(-1);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Ajfb != null) {
      this.jdField_a_of_type_Ajfb.a(-2, paramInt);
    }
  }
  
  public void c()
  {
    if (!ajfj.d(a())) {}
    while (this.jdField_a_of_type_Ajes == null) {
      return;
    }
    this.jdField_a_of_type_Ajes.c(2);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ajfc != null) {
      this.jdField_a_of_type_Ajfc.a();
    }
    Object localObject = this.jdField_a_of_type_Ajfb.a();
    if (localObject != null)
    {
      localObject = ((aivb)localObject).getRenderImpl();
      if (localObject != null) {
        ((aitm)localObject).c();
      }
    }
    ajlq.a(this.jdField_a_of_type_Ajfb.a(), true);
    this.jdField_a_of_type_Ajft.a();
    this.jdField_a_of_type_Ajff.b();
    this.jdField_a_of_type_Ajfb.c();
    this.jdField_a_of_type_Ajfr.b();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajfs
 * JD-Core Version:    0.7.0.1
 */