import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.PopupDialog;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public final class adqu
{
  public static Boolean a(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, adsx paramadsx, adsy paramadsy)
  {
    mqw.e(true, true);
    QLog.w("ChatActivityUtils", 1, "startVideoCheck, isPhoneCalling, seq[" + paramLong + "]");
    String str = paramContext.getString(2131695058);
    PopupDialog.a(paramContext, 230, paramContext.getString(2131695038), str, 2131690582, 2131694081, new adqv(paramadsx, paramadsy), null);
    mqw.a(paramadsy.jdField_a_of_type_Boolean);
    if (paramadsy.jdField_a_of_type_Int == 1024) {
      bcst.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_phone_calling_false", 0, 0, "", "", "", "");
    }
    return Boolean.valueOf(false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, BaseActivity paramBaseActivity)
  {
    boolean bool = true;
    Intent localIntent = new Intent(paramBaseActivity.getApplicationContext(), AVActivity.class);
    if (paramQQAppInterface.a().f() == 1011) {
      return;
    }
    if ((paramQQAppInterface.d()) && (paramQQAppInterface.a().f() != 1) && (paramQQAppInterface.a().f() != 3000) && (paramQQAppInterface.a().g()) && (paramQQAppInterface.a().f()) && (paramQQAppInterface.a().f() != 1011) && (paramQQAppInterface.a().f() != 21))
    {
      localIntent = new Intent(paramBaseActivity, VideoInviteActivity.class);
      localIntent.addFlags(268435456);
      localIntent.putExtra("uinType", paramQQAppInterface.a().f());
      localIntent.putExtra("peerUin", paramQQAppInterface.a().c());
      localIntent.putExtra("extraUin", paramQQAppInterface.a().d());
      if (paramInt == 1) {}
      for (;;)
      {
        localIntent.putExtra("isAudioMode", bool);
        paramBaseActivity.startActivity(localIntent);
        paramBaseActivity.overridePendingTransition(2130772138, 0);
        return;
        bool = false;
      }
    }
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    if (paramQQAppInterface.a().b(paramQQAppInterface.a().c()))
    {
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("GroupId", paramQQAppInterface.a().c());
      localIntent.putExtra("isDoubleVideoMeeting", true);
      paramBaseActivity.startActivity(localIntent);
      paramBaseActivity.overridePendingTransition(2130772138, 0);
      bcst.b(paramQQAppInterface, "CliOper", "", "", "0X800520A", "0X800520A", 0, 0, "", "", "", "");
      return;
    }
    localIntent.putExtra("sessionType", paramInt);
    localIntent.putExtra("uin", paramQQAppInterface.a().c());
    paramBaseActivity.startActivity(localIntent);
    paramBaseActivity.overridePendingTransition(2130772138, 0);
    bcst.b(paramQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "1", "", "", "");
  }
  
  public static Boolean b(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, adsx paramadsx, adsy paramadsy)
  {
    new lkw();
    lkw.a();
    int i = lkw.f();
    paramLong = lkw.d();
    int j = Build.VERSION.SDK_INT;
    if ((i < 3) || (paramLong / 1000L < 800L) || (j < 9))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startVideo old engine!");
      }
      String str;
      if (paramadsy.jdField_a_of_type_JavaUtilMap != null)
      {
        str = (String)paramadsy.jdField_a_of_type_JavaUtilMap.get("chat_type");
        if (paramadsy.jdField_a_of_type_Int != 1011) {
          break label211;
        }
        paramadsy = paramContext.getString(2131695239);
        PopupDialog.a(paramContext, 230, paramContext.getString(2131695038), paramadsy, 2131690582, 2131694970, new adrd(paramadsx), null);
        if (!str.equals("randomc2c")) {
          break label184;
        }
        bcst.b(paramQQAppInterface, "CliOper", "", "", "0X80053B1", "0X80053B1", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        return Boolean.valueOf(false);
        str = "";
        break;
        label184:
        bcst.b(paramQQAppInterface, "CliOper", "", "", "0X80053BD", "0X80053BD", 0, 0, "", "", "", "");
      }
      label211:
      QQToast.a(paramContext, 2131694783, 1).b(paramContext.getResources().getDimensionPixelSize(2131298998));
      if (paramadsy.jdField_a_of_type_Boolean)
      {
        bcst.b(null, "CliOper", "", "", "Two_call", "Judge_tmp_address_false", 0, 0, "", "", "", "");
        if (paramadsy.jdField_a_of_type_Int == 1024) {
          bcst.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_tmp_address_false", 0, 0, "", "", "", "");
        }
      }
      return Boolean.valueOf(true);
    }
    return null;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt, BaseActivity paramBaseActivity)
  {
    long l = paramBaseActivity.app.a().b();
    int j = paramBaseActivity.app.a().a();
    label79:
    Intent localIntent;
    if ((l != 0L) || (paramBaseActivity.app.a().b() > 0))
    {
      int k = paramQQAppInterface.a().b(l);
      if (paramBaseActivity.app.a().b() > 0)
      {
        if (paramQQAppInterface.a().c() == 1) {
          break label79;
        }
        while ((paramQQAppInterface.a().c() == 3) || (!QLog.isColorLevel())) {
          return;
        }
        QLog.e("MultiVideoBar", 2, "status error");
        return;
      }
      int i;
      if (k == 2)
      {
        localIntent = new Intent();
        if (paramQQAppInterface.a().a(j, l) <= 0L) {
          break label342;
        }
        if (!paramQQAppInterface.a().a(j, l)) {
          break label337;
        }
        i = 2;
      }
      for (;;)
      {
        localIntent.addFlags(262144);
        localIntent.addFlags(268435456);
        localIntent.putExtra("GroupId", String.valueOf(l));
        localIntent.putExtra("Type", i);
        localIntent.putExtra("sessionType", paramInt);
        localIntent.putExtra("uinType", mue.c(j));
        localIntent.putExtra("MultiAVType", k);
        if (k != 2) {
          break label429;
        }
        if (paramQQAppInterface.a().c(String.valueOf(l)) != 14) {
          break label347;
        }
        ((avhx)paramQQAppInterface.getManager(236)).a(paramBaseActivity, paramQQAppInterface.getCurrentAccountUin(), String.valueOf(l), "2", "openRoom");
        label279:
        paramBaseActivity.overridePendingTransition(2130772138, 0);
        if (j != 2) {
          break label438;
        }
        bcst.b(paramQQAppInterface, "CliOper", "", "", "Multi_call", "Msgtab_back", 0, 0, "", "", "", "");
        return;
        localIntent = new Intent(paramBaseActivity.getApplicationContext(), AVActivity.class);
        break;
        label337:
        i = 1;
        continue;
        label342:
        i = 0;
      }
      label347:
      TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
      if ((localTroopManager == null) || (localTroopManager.b(l + "") != null)) {
        break label529;
      }
    }
    label529:
    for (boolean bool = false;; bool = true)
    {
      localIntent.putExtra("troopmember", bool);
      localIntent.putExtra("Fromwhere", "SmallScreen");
      bldj.a(paramQQAppInterface, paramBaseActivity, localIntent, 1);
      break label279;
      label429:
      paramBaseActivity.startActivity(localIntent);
      break label279;
      label438:
      if (j != 1) {
        break;
      }
      if (paramQQAppInterface.a().b(l) == 10)
      {
        bcst.b(paramQQAppInterface, "CliOper", "", "", "0X8005931", "0X8005931", 0, 0, "", "", "", "");
        return;
      }
      bcst.b(paramQQAppInterface, "CliOper", "", "", "0X80046D8", "0X80046D8", 0, 0, "", "", "", "");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("MultiVideoBar", 2, "status error");
      return;
    }
  }
  
  public static Boolean c(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, adsx paramadsx, adsy paramadsy)
  {
    QLog.w("ChatActivityUtils", 1, "startVideoCheck, !isDAudioEnable, seq[" + paramLong + "]");
    String str = paramContext.getString(2131694719);
    PopupDialog.a(paramContext, 230, paramContext.getString(2131695038), str, 2131690582, 2131694970, new adre(paramadsx), null);
    if (paramadsy.jdField_a_of_type_Boolean)
    {
      bcst.b(null, "CliOper", "", "", "Two_call", "Judge_language_false", 0, 0, "", "", "", "");
      if (paramadsy.jdField_a_of_type_Int == 1024) {
        bcst.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_language_false", 0, 0, "", "", "", "");
      }
    }
    return Boolean.valueOf(false);
  }
  
  public static Boolean d(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, adsx paramadsx, adsy paramadsy)
  {
    if (!paramQQAppInterface.a().a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startVideo don't allow date session!");
      }
      paramQQAppInterface = PopupDialog.a(paramContext, 230, null, paramContext.getString(2131695204), 2131694772, 2131694785, new adrf(paramQQAppInterface, paramadsy, paramLong, paramContext, paramadsx), new adrg(paramadsy, paramadsx));
      if (paramQQAppInterface != null) {
        paramQQAppInterface.setOnCancelListener(new adrh(paramadsy, paramadsx));
      }
      return Boolean.valueOf(false);
    }
    return null;
  }
  
  public static Boolean e(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, adsx paramadsx, adsy paramadsy)
  {
    QLog.w("ChatActivityUtils", 1, "startVideoCheck, isMsgShielded, seq[" + paramLong + "]");
    if (paramadsy.jdField_a_of_type_Boolean) {
      bcst.b(null, "CliOper", "", "", "Two_call", "Shield_btn_appear", 0, 0, "", "", "", "");
    }
    String str = paramContext.getString(2131695205);
    paramQQAppInterface = PopupDialog.a(paramContext, 230, paramContext.getString(2131695038), str, 2131694772, 2131694785, new adri(paramQQAppInterface, paramadsy, paramLong, paramContext, paramadsx), new adrj(paramadsy, paramadsx));
    if (paramQQAppInterface != null) {
      paramQQAppInterface.setOnCancelListener(new adrk(paramadsy, paramadsx));
    }
    return Boolean.valueOf(false);
  }
  
  public static Boolean f(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, adsx paramadsx, adsy paramadsy)
  {
    QLog.w("ChatActivityUtils", 1, "startVideoCheck, !isNetSupport, seq[" + paramLong + "]");
    QQToast.a(paramContext, 2131693919, 0).b(paramContext.getResources().getDimensionPixelSize(2131298998));
    if (paramadsy.jdField_a_of_type_Boolean)
    {
      bcst.b(null, "CliOper", "", "", "Two_call", "Judge_network_false", 0, 0, "1", "", "", "");
      if (paramadsy.jdField_a_of_type_Int == 1024) {
        bcst.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_network_false", 0, 0, "", "", "", "");
      }
    }
    return Boolean.valueOf(true);
  }
  
  public static Boolean g(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, adsx paramadsx, adsy paramadsy)
  {
    QLog.w("ChatActivityUtils", 1, "startVideoCheck, !isWifiConnected, seq[" + paramLong + "]");
    Object localObject1 = VideoController.jdField_b_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin();
    Object localObject2;
    if (paramadsy.jdField_a_of_type_JavaUtilMap != null)
    {
      localObject2 = (String)paramadsy.jdField_a_of_type_JavaUtilMap.get("chat_type");
      if ((localObject2 != null) && ((((String)localObject2).equals("randomc2c")) || (((String)localObject2).equals("randomgroup")))) {
        localObject1 = VideoController.jdField_c_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin();
      }
    }
    for (;;)
    {
      if (VideoController.d((String)localObject1) > 0)
      {
        paramadsy.jdField_b_of_type_Boolean = false;
        paramadsy.jdField_c_of_type_Boolean = false;
        paramadsy.jdField_e_of_type_Boolean = false;
        ChatActivityUtils.a(paramLong, paramQQAppInterface, paramContext, paramadsx, paramadsy);
        return Boolean.valueOf(true);
      }
      localObject1 = null;
      int i = bgnt.a(paramContext);
      Object localObject3;
      if (i == 2)
      {
        localObject1 = paramContext.getString(2131695038);
        localObject2 = paramContext.getString(2131695034);
        if (!paramadsy.jdField_a_of_type_Boolean) {
          break label492;
        }
        bcst.b(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "1", "", "", "");
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        QLog.w("ChatActivityUtils", 1, "startVideoCheck, netType[" + i + "], seq[" + paramLong + "]");
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
        {
          return Boolean.valueOf(true);
          if ((i == 3) || (i == 4))
          {
            localObject1 = paramContext.getString(2131695038);
            if (paramadsy.jdField_a_of_type_Boolean)
            {
              localObject2 = paramContext.getString(2131695036);
              bcst.b(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "2", "", "", "");
              localObject3 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject3;
              continue;
            }
            localObject3 = paramContext.getString(2131695035);
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
        }
        else
        {
          paramQQAppInterface = ChatActivityUtils.a(paramQQAppInterface, paramContext, 230, (String)localObject2, (String)localObject1, 2131694772, 2131694784, new adqw(paramadsy, i, paramLong, paramQQAppInterface, paramContext, paramadsx), new adqx(paramadsy, i, paramadsx));
          if (paramQQAppInterface != null) {
            paramQQAppInterface.setOnCancelListener(new adqy(paramadsy, i, paramadsx));
          }
          return Boolean.valueOf(false);
        }
        localObject2 = null;
        continue;
        label492:
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
  }
  
  public static Boolean h(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, adsx paramadsx, adsy paramadsy)
  {
    int i = paramQQAppInterface.a().e();
    int j = paramQQAppInterface.a().b();
    int k = paramQQAppInterface.a().c();
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if (paramadsy.jdField_a_of_type_JavaUtilMap != null)
    {
      String str = (String)paramadsy.jdField_a_of_type_JavaUtilMap.get("chat_type");
      localObject1 = str;
      localObject2 = localObject3;
      if (str != null) {
        if (!str.equals("randomgroup"))
        {
          localObject1 = str;
          localObject2 = localObject3;
          if (!str.equals("randomc2c")) {}
        }
        else
        {
          localObject2 = (String)paramadsy.jdField_a_of_type_JavaUtilMap.get("session_name");
          localObject1 = str;
        }
      }
    }
    if (((k == 1) || (k == 2)) && (j >= 1) && (j <= 5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startVideo is in Double Random Call!");
      }
      if ((localObject2 == null) || (!localObject1.equals("randomc2c")) || (!((String)localObject2).equals(paramQQAppInterface.a().a())))
      {
        QQToast.a(paramContext, 2131695235, 1).b(paramContext.getResources().getDimensionPixelSize(2131298998));
        ChatActivityUtils.a(paramQQAppInterface, paramadsy.jdField_a_of_type_JavaUtilMap);
        return Boolean.valueOf(true);
      }
    }
    else
    {
      if ((paramadsy.jdField_d_of_type_Boolean) && ((k == 3) || (k == 4)) && (j >= 1) && (j <= 5))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo is Multi Random calling!");
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.equals((CharSequence)localObject2, paramQQAppInterface.a().a()))) {
          i = 1;
        }
      }
      while (i == 0)
      {
        PopupDialog.a(paramContext, 230, null, paramContext.getString(2131694870), 2131694772, 2131694784, new adqz(paramadsy, paramLong, paramQQAppInterface, paramContext, paramadsx), new adra(paramadsx));
        ChatActivityUtils.a(paramQQAppInterface, paramadsy.jdField_a_of_type_JavaUtilMap);
        return Boolean.valueOf(false);
        i = 0;
        continue;
        if (i == 1)
        {
          QLog.w("ChatActivityUtils", 1, "startVideoCheck, TYPE_SESSION_AUDIO, seq[" + paramLong + "]");
          if ((paramadsy.jdField_a_of_type_Boolean) && (((paramadsy.jdField_a_of_type_JavaLangString != null) && (paramadsy.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.a().c()))) || ((paramadsy.jdField_c_of_type_JavaLangString != null) && (paramadsy.jdField_c_of_type_JavaLangString.equals(paramQQAppInterface.a().c()))) || ((paramadsy.jdField_a_of_type_Int == 1006) && (((paramadsy.jdField_a_of_type_JavaLangString != null) && (paramadsy.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.a().d()))) || ((paramadsy.jdField_c_of_type_JavaLangString != null) && (paramadsy.jdField_c_of_type_JavaLangString.equals(paramQQAppInterface.a().d())))))))
          {
            if (paramadsx != null) {
              paramadsx.b();
            }
            if (paramQQAppInterface.a().b(paramQQAppInterface.a().c()))
            {
              paramadsy = new Intent(paramContext, AVActivity.class);
              paramadsy.addFlags(262144);
              paramadsy.addFlags(268435456);
              paramadsy.putExtra("sessionType", 3);
              paramadsy.putExtra("GroupId", paramQQAppInterface.a().c());
              paramadsy.putExtra("isDoubleVideoMeeting", true);
              paramContext.startActivity(paramadsy);
              if (paramadsx != null) {
                paramadsx.c();
              }
            }
          }
          for (;;)
          {
            return Boolean.valueOf(true);
            ChatActivityUtils.a(paramQQAppInterface, paramContext, paramadsy.jdField_a_of_type_Int, paramadsy.jdField_a_of_type_JavaLangString, paramadsy.jdField_b_of_type_JavaLangString, paramadsy.jdField_c_of_type_JavaLangString, paramadsy.jdField_a_of_type_Boolean, paramadsy.jdField_d_of_type_JavaLangString, paramadsy.jdField_e_of_type_JavaLangString, paramadsy.jdField_a_of_type_JavaUtilMap, false);
            break;
            QQToast.a(paramContext, 2131695235, 1).b(paramContext.getResources().getDimensionPixelSize(2131298998));
            ChatActivityUtils.a(paramQQAppInterface, paramadsy.jdField_a_of_type_JavaUtilMap);
          }
        }
        if (i == 2)
        {
          QLog.w("ChatActivityUtils", 1, "startVideoCheck, TYPE_SESSION_VIDEO, seq[" + paramLong + "]");
          if ((!paramadsy.jdField_a_of_type_Boolean) && (((paramadsy.jdField_a_of_type_JavaLangString != null) && (paramadsy.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.a().c()))) || ((paramadsy.jdField_c_of_type_JavaLangString != null) && (paramadsy.jdField_c_of_type_JavaLangString.equals(paramQQAppInterface.a().c()))) || ((paramadsy.jdField_a_of_type_Int == 1006) && (((paramadsy.jdField_a_of_type_JavaLangString != null) && (paramadsy.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.a().d()))) || ((paramadsy.jdField_c_of_type_JavaLangString != null) && (paramadsy.jdField_c_of_type_JavaLangString.equals(paramQQAppInterface.a().d())))))))
          {
            if (paramadsx != null) {
              paramadsx.b();
            }
            if (paramQQAppInterface.a().b(paramQQAppInterface.a().c()))
            {
              paramadsy = new Intent(paramContext, AVActivity.class);
              paramadsy.addFlags(262144);
              paramadsy.addFlags(268435456);
              paramadsy.putExtra("sessionType", 3);
              paramadsy.putExtra("GroupId", paramQQAppInterface.a().c());
              paramadsy.putExtra("isDoubleVideoMeeting", true);
              paramContext.startActivity(paramadsy);
              if (paramadsx != null) {
                paramadsx.c();
              }
            }
          }
          for (;;)
          {
            return Boolean.valueOf(true);
            ChatActivityUtils.a(paramQQAppInterface, paramContext, paramadsy.jdField_a_of_type_Int, paramadsy.jdField_a_of_type_JavaLangString, paramadsy.jdField_b_of_type_JavaLangString, paramadsy.jdField_c_of_type_JavaLangString, paramadsy.jdField_a_of_type_Boolean, paramadsy.jdField_d_of_type_JavaLangString, paramadsy.jdField_e_of_type_JavaLangString, paramadsy.jdField_a_of_type_JavaUtilMap, false);
            break;
            QQToast.a(paramContext, 2131695235, 1).b(paramContext.getResources().getDimensionPixelSize(2131298998));
            ChatActivityUtils.a(paramQQAppInterface, paramadsy.jdField_a_of_type_JavaUtilMap);
          }
        }
        if ((paramadsy.jdField_d_of_type_Boolean) && ((i == 3) || (i == 4)) && (paramQQAppInterface.a().b() > 0L))
        {
          QLog.w("ChatActivityUtils", 1, "startVideoCheck, 存在多人通话, RelationId[" + paramQQAppInterface.a().b() + "], sessionType[" + i + "], seq[" + paramLong + "]");
          PopupDialog.a(paramContext, 230, null, paramContext.getString(2131694870), 2131694772, 2131694784, new adrb(paramadsy, paramLong, paramQQAppInterface, paramContext, paramadsx), new adrc(paramadsx));
          ChatActivityUtils.a(paramQQAppInterface, paramadsy.jdField_a_of_type_JavaUtilMap);
          return Boolean.valueOf(false);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqu
 * JD-Core Version:    0.7.0.1
 */