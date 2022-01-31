import android.text.TextUtils;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.1;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.2;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ajfp
  implements ajfj
{
  private ajez jdField_a_of_type_Ajez;
  private ajfa jdField_a_of_type_Ajfa;
  private ajfd jdField_a_of_type_Ajfd;
  private ajfm jdField_a_of_type_Ajfm;
  private String jdField_a_of_type_JavaLangString;
  
  public ajfp(ajez paramajez, ajfm paramajfm, ajfa paramajfa, ajfd paramajfd)
  {
    this.jdField_a_of_type_Ajez = paramajez;
    this.jdField_a_of_type_Ajfm = paramajfm;
    this.jdField_a_of_type_Ajfa = paramajfa;
    this.jdField_a_of_type_Ajfd = paramajfd;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Ajez == null) || (this.jdField_a_of_type_Ajez.a() == null)) {}
    while (this.jdField_a_of_type_Ajfd.a(paramInt1, paramInt2) == null) {
      return false;
    }
    return true;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Ajfa.a();
  }
  
  public void a(ajez paramajez)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoBridge", 2, "[initSprite]");
    }
    if ((this.jdField_a_of_type_Ajfa == null) || (paramajez == null) || (!paramajez.c())) {
      if (paramajez != null) {
        ajlo.a(paramajez.a(), 300, 160, new Object[] { "glview is not ready" });
      }
    }
    String str;
    ajeq localajeq;
    do
    {
      do
      {
        return;
        if (a(0, -1)) {
          break;
        }
        QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "[initSprite], fail to load script.");
      } while (paramajez.e != 1);
      ThreadManager.getUIHandler().post(new SpriteDrawerInfoBridge.2(this, paramajez));
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        str = this.jdField_a_of_type_Ajfa.a();
        QLog.d("CmShowStatUtil", 1, "drawer get spriteJs");
      }
      while (TextUtils.isEmpty(str))
      {
        ajlo.a(paramajez.a(), 300, 301, new Object[] { "spriteJs is empty" });
        return;
        str = this.jdField_a_of_type_JavaLangString;
        QLog.d("CmShowStatUtil", 1, "drawer spriteJs from cache");
        this.jdField_a_of_type_JavaLangString = null;
      }
      localajeq = (ajeq)this.jdField_a_of_type_Ajfd.a(0);
    } while (localajeq == null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initDrawerInfoSprite('").append(str).append("');");
    ajlo.a(this.jdField_a_of_type_Ajez.a(), 350);
    localajeq.a(localStringBuilder.toString());
    ThreadManager.executeOnSubThread(new SpriteDrawerInfoBridge.3(this, localajeq, paramajez));
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return;
    }
    ThreadManager.excute(new SpriteDrawerInfoBridge.1(this, paramSpriteTaskParam), 192, null, true);
  }
  
  public void b() {}
  
  public void b(SpriteTaskParam paramSpriteTaskParam)
  {
    boolean bool = true;
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_Ajfa == null) || (this.jdField_a_of_type_Ajez == null) || (!this.jdField_a_of_type_Ajez.c())) {
      return;
    }
    this.jdField_a_of_type_Ajfa.a(paramSpriteTaskParam);
    if (!a(paramSpriteTaskParam.jdField_c_of_type_Int, paramSpriteTaskParam.f))
    {
      QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "[playAction], fail to load script.");
      paramSpriteTaskParam.jdField_b_of_type_Int = 4;
      return;
    }
    Object localObject = this.jdField_a_of_type_Ajfa.a(paramSpriteTaskParam);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramSpriteTaskParam.jdField_b_of_type_Int = 4;
      return;
    }
    ajer localajer = this.jdField_a_of_type_Ajfd.a(paramSpriteTaskParam.jdField_c_of_type_Int);
    if (localajer == null)
    {
      QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "actionScript == null.");
      paramSpriteTaskParam.jdField_b_of_type_Int = 4;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoBridge", 2, new Object[] { "[playAction], ready to play, actionId:", Integer.valueOf(paramSpriteTaskParam.f) });
    }
    paramSpriteTaskParam.jdField_b_of_type_Int = 2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playDrawerInfoAction ('").append((String)localObject).append("');");
    localajer.a(localStringBuilder.toString());
    localajer.a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, false);
    localajer.a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, false);
    localObject = this.jdField_a_of_type_Ajez.a();
    if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)) {}
    for (;;)
    {
      ajki.a((QQAppInterface)localObject, paramSpriteTaskParam, bool, paramSpriteTaskParam.jdField_b_of_type_Boolean);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajfp
 * JD-Core Version:    0.7.0.1
 */