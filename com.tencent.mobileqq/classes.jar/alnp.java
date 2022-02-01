import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloGameNormalStartHandler.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class alnp
{
  private long jdField_a_of_type_Long;
  private amlf jdField_a_of_type_Amlf;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private WeakReference<Activity> b;
  
  public alnp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Amlf != null) {
      this.jdField_a_of_type_Amlf.dismiss();
    }
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, int paramInt4, long paramLong, String paramString3, String paramString4, String paramString5)
  {
    if (paramActivity == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localQQAppInterface == null);
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 2000L)
    {
      QLog.e("ApolloGameNormalStartHandler", 1, "current - mLastLuanchGameTime < 2000");
      return;
    }
    this.jdField_a_of_type_Long = l;
    this.b = new WeakReference(paramActivity);
    paramActivity.runOnUiThread(new ApolloGameNormalStartHandler.1(this, paramInt1, paramLong, paramInt2, paramInt3, localQQAppInterface, paramString2, paramInt4, paramString5, paramString1, paramString3, paramString4, paramActivity));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameNormalStartHandler", 2, new Object[] { "startGameFromArkApp, args:", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {}
    JSONObject localJSONObject;
    int k;
    for (;;)
    {
      return;
      try
      {
        localJSONObject = new JSONObject(paramString);
        if (!localJSONObject.optBoolean("isGameApp"))
        {
          int m = localJSONObject.getInt("gameID");
          int n = localJSONObject.getInt("gameMode");
          str2 = localJSONObject.optString("roomId");
          int i1 = localJSONObject.getInt("src");
          String str3 = localJSONObject.optString("gameParam");
          String str4 = localJSONObject.optString("gameName");
          k = 0;
          j = 0;
          str1 = "";
          localObject2 = BaseActivity.sTopActivity;
          localObject1 = localObject2;
          i = k;
          paramString = str1;
          if ((BaseActivity.sTopActivity instanceof FragmentActivity))
          {
            ChatFragment localChatFragment = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
            localObject1 = localObject2;
            i = k;
            paramString = str1;
            if (localChatFragment != null)
            {
              localObject1 = localChatFragment.a();
              i = j;
              paramString = str1;
              if (((BaseChatPie)localObject1).getSessionInfo() != null)
              {
                i = ((BaseChatPie)localObject1).getSessionInfo().curType;
                paramString = ((BaseChatPie)localObject1).getSessionInfo().curFriendUin;
              }
              localObject1 = ((BaseChatPie)localObject1).getActivity();
            }
          }
          str1 = localJSONObject.optString("tempAIOUin");
          localObject2 = localJSONObject.optString("tempAIONickName");
          long l = 0L;
          if (!TextUtils.isEmpty(str2)) {
            l = Long.parseLong(str2);
          }
          a((Activity)localObject1, m, n, str3, i, paramString, i1, l, str1, (String)localObject2, str4);
          if ((i != 1036) || (l <= 0L) || (TextUtils.isEmpty(str1))) {
            continue;
          }
          paramString = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (paramString != null) {
            aluz.b(paramString, str1, i, m, l);
          }
          ahek.c = true;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloGameNormalStartHandler", 1, "startGameFromArkApp, exception=", paramString);
        return;
      }
    }
    paramString = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramString == null)
    {
      QLog.w("ApolloGameNormalStartHandler", 1, "[startGameFromArkApp] app null");
      return;
    }
    Object localObject1 = localJSONObject.optString("appID");
    String str1 = localJSONObject.optString("paramsStr");
    Object localObject2 = localJSONObject.optString("packageName");
    String str2 = localJSONObject.optString("flags");
    localJSONObject.optString("type");
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)))
    {
      QLog.e("ApolloGameNormalStartHandler", 1, "[startGameFromArkApp] game app param error");
      return;
    }
    if (!bfwv.a(BaseActivity.sTopActivity, (String)localObject2))
    {
      paramString = String.format("https://m.gamecenter.qq.com/directout/detail/%s?_wv=2147484679&_wwv=4&ADTAG=limixiuteam&autodownload=1&pf=invite&appid=%s&notShowPub=1&asyncMode=3&appType=1&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0", new Object[] { localObject1, localObject1 });
      localObject1 = new Intent(BaseActivity.sTopActivity, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_zf_lmx");
      VasWebviewUtil.openQQBrowserActivity(BaseActivity.sTopActivity, paramString, -1L, (Intent)localObject1, false, -1);
      return;
    }
    j = 268435456;
    try
    {
      k = Integer.parseInt(str2);
      if ((0x4000000 & k) != 67108864) {
        break label628;
      }
      j = 335544320;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ApolloGameNormalStartHandler", 1, "[startGameFromArkApp] parse flag exception:", localException);
        continue;
        j = 268435456;
      }
    }
    int i = j;
    if ((0x20000000 & k) == 536870912) {
      i = j | 0x20000000;
    }
    j = i;
    if ((k & 0x400000) == 4194304) {
      j = i | 0x400000;
    }
    QLog.d("ApolloGameNormalStartHandler", 1, "[startGameFromArkApp] start game app");
    new bbkb().a(paramString, BaseActivity.sTopActivity, (String)localObject1, str1, (String)localObject2, j);
  }
  
  public void b()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnp
 * JD-Core Version:    0.7.0.1
 */