import android.text.TextUtils;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.1;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.2;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ajfr
  implements ajfl
{
  private ajfb jdField_a_of_type_Ajfb;
  private ajfc jdField_a_of_type_Ajfc;
  private ajff jdField_a_of_type_Ajff;
  private ajfo jdField_a_of_type_Ajfo;
  private String jdField_a_of_type_JavaLangString;
  
  public ajfr(ajfb paramajfb, ajfo paramajfo, ajfc paramajfc, ajff paramajff)
  {
    this.jdField_a_of_type_Ajfb = paramajfb;
    this.jdField_a_of_type_Ajfo = paramajfo;
    this.jdField_a_of_type_Ajfc = paramajfc;
    this.jdField_a_of_type_Ajff = paramajff;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Ajfb == null) || (this.jdField_a_of_type_Ajfb.a() == null)) {}
    while (this.jdField_a_of_type_Ajff.a(paramInt1, paramInt2) == null) {
      return false;
    }
    return true;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Ajfc.a();
  }
  
  public void a(ajfb paramajfb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoBridge", 2, "[initSprite]");
    }
    if ((this.jdField_a_of_type_Ajfc == null) || (paramajfb == null) || (!paramajfb.c())) {
      if (paramajfb != null) {
        ajlq.a(paramajfb.a(), 300, 160, new Object[] { "glview is not ready" });
      }
    }
    String str;
    ajes localajes;
    do
    {
      do
      {
        return;
        if (a(0, -1)) {
          break;
        }
        QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "[initSprite], fail to load script.");
      } while (paramajfb.e != 1);
      ThreadManager.getUIHandler().post(new SpriteDrawerInfoBridge.2(this, paramajfb));
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        str = this.jdField_a_of_type_Ajfc.a();
        QLog.d("CmShowStatUtil", 1, "drawer get spriteJs");
      }
      while (TextUtils.isEmpty(str))
      {
        ajlq.a(paramajfb.a(), 300, 301, new Object[] { "spriteJs is empty" });
        return;
        str = this.jdField_a_of_type_JavaLangString;
        QLog.d("CmShowStatUtil", 1, "drawer spriteJs from cache");
        this.jdField_a_of_type_JavaLangString = null;
      }
      localajes = (ajes)this.jdField_a_of_type_Ajff.a(0);
    } while (localajes == null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initDrawerInfoSprite('").append(str).append("');");
    ajlq.a(this.jdField_a_of_type_Ajfb.a(), 350);
    localajes.a(localStringBuilder.toString());
    ThreadManager.executeOnSubThread(new SpriteDrawerInfoBridge.3(this, localajes, paramajfb));
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
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_Ajfc == null) || (this.jdField_a_of_type_Ajfb == null) || (!this.jdField_a_of_type_Ajfb.c())) {
      return;
    }
    this.jdField_a_of_type_Ajfc.a(paramSpriteTaskParam);
    if (!a(paramSpriteTaskParam.jdField_c_of_type_Int, paramSpriteTaskParam.f))
    {
      QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "[playAction], fail to load script.");
      paramSpriteTaskParam.jdField_b_of_type_Int = 4;
      return;
    }
    Object localObject = this.jdField_a_of_type_Ajfc.a(paramSpriteTaskParam);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramSpriteTaskParam.jdField_b_of_type_Int = 4;
      return;
    }
    ajet localajet = this.jdField_a_of_type_Ajff.a(paramSpriteTaskParam.jdField_c_of_type_Int);
    if (localajet == null)
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
    localajet.a(localStringBuilder.toString());
    localajet.a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, false);
    localajet.a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, false);
    localObject = this.jdField_a_of_type_Ajfb.a();
    if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)) {}
    for (;;)
    {
      ajkk.a((QQAppInterface)localObject, paramSpriteTaskParam, bool, paramSpriteTaskParam.jdField_b_of_type_Boolean);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajfr
 * JD-Core Version:    0.7.0.1
 */