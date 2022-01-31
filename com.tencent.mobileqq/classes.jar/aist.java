import android.text.TextUtils;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.1;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.2;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aist
  implements aisn
{
  private aisd jdField_a_of_type_Aisd;
  private aise jdField_a_of_type_Aise;
  private aish jdField_a_of_type_Aish;
  private aisq jdField_a_of_type_Aisq;
  private String jdField_a_of_type_JavaLangString;
  
  public aist(aisd paramaisd, aisq paramaisq, aise paramaise, aish paramaish)
  {
    this.jdField_a_of_type_Aisd = paramaisd;
    this.jdField_a_of_type_Aisq = paramaisq;
    this.jdField_a_of_type_Aise = paramaise;
    this.jdField_a_of_type_Aish = paramaish;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Aisd == null) || (this.jdField_a_of_type_Aisd.a() == null)) {}
    while (this.jdField_a_of_type_Aish.a(paramInt1, paramInt2) == null) {
      return false;
    }
    return true;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Aise.a();
  }
  
  public void a(aisd paramaisd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoBridge", 2, "[initSprite]");
    }
    if ((this.jdField_a_of_type_Aise == null) || (paramaisd == null) || (!paramaisd.c())) {
      if (paramaisd != null) {
        aixo.a(paramaisd.a(), 300, 160, new Object[] { "glview is not ready" });
      }
    }
    String str;
    airu localairu;
    do
    {
      do
      {
        return;
        if (a(0, -1)) {
          break;
        }
        QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "[initSprite], fail to load script.");
      } while (paramaisd.e != 1);
      ThreadManager.getUIHandler().post(new SpriteDrawerInfoBridge.2(this, paramaisd));
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        str = this.jdField_a_of_type_Aise.a();
        QLog.d("CmShowStatUtil", 1, "drawer get spriteJs");
      }
      while (TextUtils.isEmpty(str))
      {
        aixo.a(paramaisd.a(), 300, 301, new Object[] { "spriteJs is empty" });
        return;
        str = this.jdField_a_of_type_JavaLangString;
        QLog.d("CmShowStatUtil", 1, "drawer spriteJs from cache");
        this.jdField_a_of_type_JavaLangString = null;
      }
      localairu = (airu)this.jdField_a_of_type_Aish.a(0);
    } while (localairu == null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initDrawerInfoSprite('").append(str).append("');");
    aixo.a(this.jdField_a_of_type_Aisd.a(), 350);
    localairu.a(localStringBuilder.toString());
    ThreadManager.executeOnSubThread(new SpriteDrawerInfoBridge.3(this, localairu, paramaisd));
  }
  
  public void a(aisk paramaisk)
  {
    if (paramaisk == null) {
      return;
    }
    ThreadManager.excute(new SpriteDrawerInfoBridge.1(this, paramaisk), 192, null, true);
  }
  
  public void b() {}
  
  public void b(aisk paramaisk)
  {
    boolean bool = true;
    if ((paramaisk == null) || (this.jdField_a_of_type_Aise == null) || (this.jdField_a_of_type_Aisd == null) || (!this.jdField_a_of_type_Aisd.c())) {
      return;
    }
    this.jdField_a_of_type_Aise.a(paramaisk);
    if (!a(paramaisk.jdField_c_of_type_Int, paramaisk.f))
    {
      QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "[playAction], fail to load script.");
      paramaisk.jdField_b_of_type_Int = 4;
      return;
    }
    Object localObject = this.jdField_a_of_type_Aise.a(paramaisk);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramaisk.jdField_b_of_type_Int = 4;
      return;
    }
    airv localairv = this.jdField_a_of_type_Aish.a(paramaisk.jdField_c_of_type_Int);
    if (localairv == null)
    {
      QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "actionScript == null.");
      paramaisk.jdField_b_of_type_Int = 4;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoBridge", 2, new Object[] { "[playAction], ready to play, actionId:", Integer.valueOf(paramaisk.f) });
    }
    paramaisk.jdField_b_of_type_Int = 2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playDrawerInfoAction ('").append((String)localObject).append("');");
    localairv.a(localStringBuilder.toString());
    localairv.a(paramaisk.jdField_a_of_type_JavaLangString, false);
    localairv.a(paramaisk.jdField_b_of_type_JavaLangString, false);
    localObject = this.jdField_a_of_type_Aisd.a();
    if (!TextUtils.isEmpty(paramaisk.jdField_c_of_type_JavaLangString)) {}
    for (;;)
    {
      aiwi.a((QQAppInterface)localObject, paramaisk, bool, paramaisk.jdField_b_of_type_Boolean);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aist
 * JD-Core Version:    0.7.0.1
 */