import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class agxo
  implements Manager
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean;
  
  public agxo(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static agxo a(QQAppInterface paramQQAppInterface)
  {
    return (agxo)paramQQAppInterface.getManager(327);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioPanelMiniAppManager", 2, "fetchDrawable: invoked.  url: " + paramString);
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    try
    {
      localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      if (localObject != null)
      {
        ((URLDrawable)localObject).setURLDrawableListener(new agxp(this, paramString));
        ((URLDrawable)localObject).downloadImediatly();
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("AioPanelMiniAppManager", 1, "fetchDrawable: failed. ", paramString);
    }
  }
  
  private boolean a(String paramString)
  {
    paramString = (Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null) {
      return paramString.booleanValue();
    }
    return false;
  }
  
  public Drawable a()
  {
    Object localObject = apyt.a();
    boolean bool1 = bbyp.b();
    boolean bool2 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if (bool1) {
      if (bool2) {
        localObject = ((apys)localObject).f();
      }
    }
    Drawable localDrawable;
    for (;;)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130841306);
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      try
      {
        localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
        return localObject;
      }
      catch (Exception localException) {}
      localObject = ((apys)localObject).e();
      continue;
      if (bool2) {
        localObject = ((apys)localObject).d();
      } else {
        localObject = ((apys)localObject).c();
      }
    }
    return localDrawable;
  }
  
  public void a()
  {
    apys localapys = apyt.a();
    boolean bool = TextUtils.isEmpty(localapys.b());
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if ((localObject != null) && (!bool)) {
        a((QQAppInterface)localObject, localapys);
      }
      return;
    }
  }
  
  public void a(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    MiniAppLauncher.startMiniApp(paramContext, apyt.a().b(), 2053, paramBaseChatPie.createMiniAppEntryModel(), null);
    paramContext = (azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    paramContext.a(paramContext.a("110000"), "");
    this.jdField_a_of_type_Boolean = true;
    bcef.b(null, "dc00898", "", "", "0X800A120", "0X800A120", 0, 0, "", "", "", "");
  }
  
  public void a(QQAppInterface paramQQAppInterface, apys paramapys)
  {
    a(paramQQAppInterface).a(paramapys.c());
    a(paramQQAppInterface).a(paramapys.d());
    a(paramQQAppInterface).a(paramapys.e());
    a(paramQQAppInterface).a(paramapys.f());
  }
  
  public boolean a()
  {
    apys localapys = apyt.a();
    boolean bool1 = TextUtils.isEmpty(localapys.b());
    boolean bool2 = a(localapys.c());
    boolean bool3 = a(localapys.d());
    boolean bool4 = a(localapys.e());
    boolean bool5 = a(localapys.f());
    if (bool1) {}
    while ((!bool2) || (!bool3) || (!bool4) || (!bool5)) {
      return false;
    }
    return true;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a("110000");
    return (localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agxo
 * JD-Core Version:    0.7.0.1
 */