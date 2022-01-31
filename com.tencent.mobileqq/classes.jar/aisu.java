import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class aisu
{
  private airu jdField_a_of_type_Airu;
  private aisd jdField_a_of_type_Aisd;
  private aise jdField_a_of_type_Aise;
  private aish jdField_a_of_type_Aish;
  private aist jdField_a_of_type_Aist;
  private aisv jdField_a_of_type_Aisv;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public aisu(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_Aisd = new aisd(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Aisv = new aisv(this.jdField_a_of_type_Aisd);
    this.jdField_a_of_type_Aish = new aish(this.jdField_a_of_type_Aisd, this.jdField_a_of_type_Aisv);
    this.jdField_a_of_type_Aise = new aise(this.jdField_a_of_type_Aisd);
    this.jdField_a_of_type_Aist = new aist(this.jdField_a_of_type_Aisd, this.jdField_a_of_type_Aisv, this.jdField_a_of_type_Aise, this.jdField_a_of_type_Aish);
    this.jdField_a_of_type_Aisd.a(this.jdField_a_of_type_Aise);
    paramQQAppInterface = aisl.a(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this);
    }
  }
  
  public airu a()
  {
    return this.jdField_a_of_type_Airu;
  }
  
  public aisd a()
  {
    return this.jdField_a_of_type_Aisd;
  }
  
  public aist a()
  {
    return this.jdField_a_of_type_Aist;
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
    if (this.jdField_a_of_type_Aist != null) {
      this.jdField_a_of_type_Aist.a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    aijy localaijy = new aijy(paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_Aisd.a(localaijy);
  }
  
  public void a(int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteDrawerInfoManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_Aisd == null) || (this.jdField_a_of_type_Aist == null) || (this.jdField_a_of_type_Aish == null)) {
      return;
    }
    this.jdField_a_of_type_Aisd.c(true);
    int i = aisl.b(this.jdField_a_of_type_Aisd.e);
    this.jdField_a_of_type_Aisd.b(i);
    aixo.a(i, 100, 0, new Object[] { "onSurfaceReady" });
    this.jdField_a_of_type_Aisd.a(-2, paramInt);
    aixo.a(i, 200);
    this.jdField_a_of_type_Aish.a();
    aixo.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Aisd.b(true);
    aixo.a(i, 300);
    this.jdField_a_of_type_Aist.a(this.jdField_a_of_type_Aisd);
    aixo.a(i, 300, 0, new Object[] { "initSprite done" });
    aixo.a(i, 1, 0, new Object[] { "terminal all done" });
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Airu = ((airu)this.jdField_a_of_type_Aish.a(0));
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    airu localairu = a();
    if ((localairu != null) && (paramArrayList != null))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equals(this.jdField_a_of_type_Aisd.jdField_b_of_type_JavaLangString)) {
          localairu.a(paramInt, paramArrayList);
        }
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.jdField_a_of_type_Boolean) {
      aixo.a(aisl.b(this.jdField_a_of_type_Aisd.e), 1, paramInt, 0L, paramVarArgs);
    }
  }
  
  public void a(aiii paramaiii)
  {
    if (paramaiii == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Aisd.a(paramaiii);
      localApolloCmdChannel = ApolloCmdChannel.getChannel(this.jdField_a_of_type_Aisd.a());
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramaiii);
  }
  
  public void a(aiso paramaiso)
  {
    if (paramaiso != null) {
      this.jdField_a_of_type_Aisd.a(paramaiso);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_Aisd.a(paramString);
    this.jdField_a_of_type_Aisd.jdField_b_of_type_Int = aifg.a(a(), paramString);
  }
  
  public void b()
  {
    if (!aisl.d(a())) {
      return;
    }
    if (this.jdField_a_of_type_Airu != null) {
      this.jdField_a_of_type_Airu.c(1);
    }
    this.jdField_a_of_type_Aisd.a(-1);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Aisd != null) {
      this.jdField_a_of_type_Aisd.a(-2, paramInt);
    }
  }
  
  public void c()
  {
    if (!aisl.d(a())) {}
    while (this.jdField_a_of_type_Airu == null) {
      return;
    }
    this.jdField_a_of_type_Airu.c(2);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aise != null) {
      this.jdField_a_of_type_Aise.a();
    }
    Object localObject = this.jdField_a_of_type_Aisd.a();
    if (localObject != null)
    {
      localObject = ((aiii)localObject).getRenderImpl();
      if (localObject != null) {
        ((aigt)localObject).c();
      }
    }
    aixo.a(this.jdField_a_of_type_Aisd.a(), true);
    this.jdField_a_of_type_Aisv.a();
    this.jdField_a_of_type_Aish.b();
    this.jdField_a_of_type_Aisd.c();
    this.jdField_a_of_type_Aist.b();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aisu
 * JD-Core Version:    0.7.0.1
 */