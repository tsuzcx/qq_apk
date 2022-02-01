import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.GameUsrAvatarClickLis.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class aikp
  implements View.OnClickListener
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  WeakReference<Context> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public aikp(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = false;
    this.b = paramBoolean;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramContext);
  }
  
  private void a()
  {
    try
    {
      String str = ((avld)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(358)).d();
      Context localContext = (Context)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if ((!TextUtils.isEmpty(str)) && (localContext != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        if (str.contains("?")) {}
        for (str = str + "&roleId=" + URLEncoder.encode(this.jdField_a_of_type_JavaLangString, "utf-8");; str = str + "?roleId=" + URLEncoder.encode(this.jdField_a_of_type_JavaLangString, "utf-8"))
        {
          Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
          localIntent.putExtra("url", str);
          localContext.startActivity(localIntent);
          return;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(aikg.g, 1, localThrowable, new Object[0]);
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    boolean bool;
    do
    {
      return;
      GameUserInfo localGameUserInfo = ((avld)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(358)).a(paramString);
      if (localGameUserInfo == null)
      {
        QLog.w(aikg.g, 1, "GameUsrAvatarClickLis, usrInfo is null, roleId:" + paramString);
        return;
      }
      if (TextUtils.isEmpty(localGameUserInfo.mFaceUrl))
      {
        QLog.w(aikg.g, 1, "GameUsrAvatarClickLis, faceurl is null, roleId:" + paramString);
        return;
      }
      paramString = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130840274);
      paramString.mFailedDrawable = localDrawable;
      paramString.mLoadingDrawable = localDrawable;
      paramString.mRequestWidth = agej.a(60.0F, BaseApplicationImpl.getContext().getResources());
      paramString.mRequestHeight = agej.a(60.0F, BaseApplicationImpl.getContext().getResources());
      URLDrawable.removeMemoryCacheByUrl(localGameUserInfo.mFaceUrl, paramString);
      bool = bhmi.d(beqz.d(localGameUserInfo.mFaceUrl));
    } while (!QLog.isColorLevel());
    QLog.d(aikg.g, 2, "GameUsrAvatarClickLis del ret:" + bool);
  }
  
  public void onClick(View paramView)
  {
    ThreadManager.getSubThreadHandler().post(new GameMsgChatPie.GameUsrAvatarClickLis.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikp
 * JD-Core Version:    0.7.0.1
 */