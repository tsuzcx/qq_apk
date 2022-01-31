import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.GameUsrAvatarClickLis.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class agqp
  implements View.OnClickListener
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public agqp(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = false;
    this.b = paramBoolean;
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    boolean bool;
    do
    {
      return;
      GameUserInfo localGameUserInfo = ((asmu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(358)).a(paramString);
      if (localGameUserInfo == null)
      {
        QLog.w(agqk.g, 1, "GameUsrAvatarClickLis, usrInfo is null, roleId:" + paramString);
        return;
      }
      if (TextUtils.isEmpty(localGameUserInfo.mFaceUrl))
      {
        QLog.w(agqk.g, 1, "GameUsrAvatarClickLis, faceurl is null, roleId:" + paramString);
        return;
      }
      paramString = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130840085);
      paramString.mFailedDrawable = localDrawable;
      paramString.mLoadingDrawable = localDrawable;
      paramString.mRequestWidth = aepi.a(60.0F, BaseApplicationImpl.getContext().getResources());
      paramString.mRequestHeight = aepi.a(60.0F, BaseApplicationImpl.getContext().getResources());
      URLDrawable.removeMemoryCacheByUrl(localGameUserInfo.mFaceUrl, paramString);
      bool = bdhb.d(baqn.d(localGameUserInfo.mFaceUrl));
    } while (!QLog.isColorLevel());
    QLog.d(agqk.g, 2, "GameUsrAvatarClickLis del ret:" + bool);
  }
  
  public void onClick(View paramView)
  {
    ThreadManager.getSubThreadHandler().post(new GameMsgChatPie.GameUsrAvatarClickLis.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqp
 * JD-Core Version:    0.7.0.1
 */