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
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public final class acvd
{
  public static Boolean a(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, acxa paramacxa, acxb paramacxb)
  {
    mrd.e(true, true);
    QLog.w("ChatActivityUtils", 1, "startVideoCheck, isPhoneCalling, seq[" + paramLong + "]");
    String str = paramContext.getString(2131695240);
    PopupDialog.a(paramContext, 230, paramContext.getString(2131695219), str, 2131690620, 2131694201, new acve(paramacxa, paramacxb), null);
    mrd.a(paramacxb.jdField_a_of_type_Boolean);
    if (paramacxb.jdField_a_of_type_Int == 1024) {
      bcef.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_phone_calling_false", 0, 0, "", "", "", "");
    }
    return Boolean.valueOf(false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, BaseActivity paramBaseActivity)
  {
    boolean bool = true;
    Intent localIntent = new Intent(paramBaseActivity.getApplicationContext(), AVActivity.class);
    if (paramQQAppInterface.getAVNotifyCenter().f() == 1011) {
      return;
    }
    if ((paramQQAppInterface.isVideoChatting()) && (paramQQAppInterface.getAVNotifyCenter().f() != 1) && (paramQQAppInterface.getAVNotifyCenter().f() != 3000) && (paramQQAppInterface.getAVNotifyCenter().g()) && (paramQQAppInterface.getAVNotifyCenter().f()) && (paramQQAppInterface.getAVNotifyCenter().f() != 1011) && (paramQQAppInterface.getAVNotifyCenter().f() != 21))
    {
      localIntent = new Intent(paramBaseActivity, VideoInviteActivity.class);
      localIntent.addFlags(268435456);
      localIntent.putExtra("uinType", paramQQAppInterface.getAVNotifyCenter().f());
      localIntent.putExtra("peerUin", paramQQAppInterface.getAVNotifyCenter().c());
      localIntent.putExtra("extraUin", paramQQAppInterface.getAVNotifyCenter().d());
      if (paramInt == 1) {}
      for (;;)
      {
        localIntent.putExtra("isAudioMode", bool);
        paramBaseActivity.startActivity(localIntent);
        paramBaseActivity.overridePendingTransition(2130772146, 0);
        return;
        bool = false;
      }
    }
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    if (paramQQAppInterface.getAVNotifyCenter().b(paramQQAppInterface.getAVNotifyCenter().c()))
    {
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("GroupId", paramQQAppInterface.getAVNotifyCenter().c());
      localIntent.putExtra("isDoubleVideoMeeting", true);
      paramBaseActivity.startActivity(localIntent);
      paramBaseActivity.overridePendingTransition(2130772146, 0);
      bcef.b(paramQQAppInterface, "CliOper", "", "", "0X800520A", "0X800520A", 0, 0, "", "", "", "");
      return;
    }
    localIntent.putExtra("sessionType", paramInt);
    localIntent.putExtra("uin", paramQQAppInterface.getAVNotifyCenter().c());
    paramBaseActivity.startActivity(localIntent);
    paramBaseActivity.overridePendingTransition(2130772146, 0);
    bcef.b(paramQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "1", "", "", "");
  }
  
  public static Boolean b(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, acxa paramacxa, acxb paramacxb)
  {
    new lld();
    lld.a();
    int i = lld.f();
    paramLong = lld.d();
    int j = Build.VERSION.SDK_INT;
    if ((i < 3) || (paramLong / 1000L < 800L) || (j < 9))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startVideo old engine!");
      }
      String str;
      if (paramacxb.jdField_a_of_type_JavaUtilMap != null)
      {
        str = (String)paramacxb.jdField_a_of_type_JavaUtilMap.get("chat_type");
        if (paramacxb.jdField_a_of_type_Int != 1011) {
          break label211;
        }
        paramacxb = paramContext.getString(2131695421);
        PopupDialog.a(paramContext, 230, paramContext.getString(2131695219), paramacxb, 2131690620, 2131695151, new acvm(paramacxa), null);
        if (!str.equals("randomc2c")) {
          break label184;
        }
        bcef.b(paramQQAppInterface, "CliOper", "", "", "0X80053B1", "0X80053B1", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        return Boolean.valueOf(false);
        str = "";
        break;
        label184:
        bcef.b(paramQQAppInterface, "CliOper", "", "", "0X80053BD", "0X80053BD", 0, 0, "", "", "", "");
      }
      label211:
      QQToast.a(paramContext, 2131694963, 1).b(paramContext.getResources().getDimensionPixelSize(2131299076));
      if (paramacxb.jdField_a_of_type_Boolean)
      {
        bcef.b(null, "CliOper", "", "", "Two_call", "Judge_tmp_address_false", 0, 0, "", "", "", "");
        if (paramacxb.jdField_a_of_type_Int == 1024) {
          bcef.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_tmp_address_false", 0, 0, "", "", "", "");
        }
      }
      return Boolean.valueOf(true);
    }
    return null;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt, BaseActivity paramBaseActivity)
  {
    long l = paramBaseActivity.app.getAVNotifyCenter().b();
    int j = paramBaseActivity.app.getAVNotifyCenter().a();
    label79:
    Intent localIntent;
    if ((l != 0L) || (paramBaseActivity.app.getAVNotifyCenter().b() > 0))
    {
      int k = paramQQAppInterface.getAVNotifyCenter().b(l);
      if (paramBaseActivity.app.getAVNotifyCenter().b() > 0)
      {
        if (paramQQAppInterface.getAVNotifyCenter().c() == 1) {
          break label79;
        }
        while ((paramQQAppInterface.getAVNotifyCenter().c() == 3) || (!QLog.isColorLevel())) {
          return;
        }
        QLog.e("MultiVideoBar", 2, "status error");
        return;
      }
      int i;
      if (k == 2)
      {
        localIntent = new Intent();
        if (paramQQAppInterface.getAVNotifyCenter().a(j, l) <= 0L) {
          break label342;
        }
        if (!paramQQAppInterface.getAVNotifyCenter().a(j, l)) {
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
        localIntent.putExtra("uinType", mum.c(j));
        localIntent.putExtra("MultiAVType", k);
        if (k != 2) {
          break label429;
        }
        if (paramQQAppInterface.getAVNotifyCenter().c(String.valueOf(l)) != 14) {
          break label347;
        }
        ((auna)paramQQAppInterface.getManager(236)).a(paramBaseActivity, paramQQAppInterface.getCurrentAccountUin(), String.valueOf(l), "2", "openRoom");
        label279:
        paramBaseActivity.overridePendingTransition(2130772146, 0);
        if (j != 2) {
          break label438;
        }
        bcef.b(paramQQAppInterface, "CliOper", "", "", "Multi_call", "Msgtab_back", 0, 0, "", "", "", "");
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
      bkij.a(paramQQAppInterface, paramBaseActivity, localIntent, 1);
      break label279;
      label429:
      paramBaseActivity.startActivity(localIntent);
      break label279;
      label438:
      if (j != 1) {
        break;
      }
      if (paramQQAppInterface.getAVNotifyCenter().b(l) == 10)
      {
        bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8005931", "0X8005931", 0, 0, "", "", "", "");
        return;
      }
      bcef.b(paramQQAppInterface, "CliOper", "", "", "0X80046D8", "0X80046D8", 0, 0, "", "", "", "");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("MultiVideoBar", 2, "status error");
      return;
    }
  }
  
  public static Boolean c(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, acxa paramacxa, acxb paramacxb)
  {
    QLog.w("ChatActivityUtils", 1, "startVideoCheck, !isDAudioEnable, seq[" + paramLong + "]");
    String str = paramContext.getString(2131694899);
    PopupDialog.a(paramContext, 230, paramContext.getString(2131695219), str, 2131690620, 2131695151, new acvn(paramacxa), null);
    if (paramacxb.jdField_a_of_type_Boolean)
    {
      bcef.b(null, "CliOper", "", "", "Two_call", "Judge_language_false", 0, 0, "", "", "", "");
      if (paramacxb.jdField_a_of_type_Int == 1024) {
        bcef.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_language_false", 0, 0, "", "", "", "");
      }
    }
    return Boolean.valueOf(false);
  }
  
  public static Boolean d(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, acxa paramacxa, acxb paramacxb)
  {
    if (!paramQQAppInterface.getNearbyProxy().a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startVideo don't allow date session!");
      }
      paramQQAppInterface = PopupDialog.a(paramContext, 230, null, paramContext.getString(2131695386), 2131694952, 2131694965, new acvo(paramQQAppInterface, paramacxb, paramLong, paramContext, paramacxa), new acvp(paramacxb, paramacxa));
      if (paramQQAppInterface != null) {
        paramQQAppInterface.setOnCancelListener(new acvq(paramacxb, paramacxa));
      }
      return Boolean.valueOf(false);
    }
    return null;
  }
  
  public static Boolean e(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, acxa paramacxa, acxb paramacxb)
  {
    QLog.w("ChatActivityUtils", 1, "startVideoCheck, isMsgShielded, seq[" + paramLong + "]");
    if (paramacxb.jdField_a_of_type_Boolean) {
      bcef.b(null, "CliOper", "", "", "Two_call", "Shield_btn_appear", 0, 0, "", "", "", "");
    }
    String str = paramContext.getString(2131695387);
    paramQQAppInterface = PopupDialog.a(paramContext, 230, paramContext.getString(2131695219), str, 2131694952, 2131694965, new acvr(paramQQAppInterface, paramacxb, paramLong, paramContext, paramacxa), new acvs(paramacxb, paramacxa));
    if (paramQQAppInterface != null) {
      paramQQAppInterface.setOnCancelListener(new acvt(paramacxb, paramacxa));
    }
    return Boolean.valueOf(false);
  }
  
  public static Boolean f(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, acxa paramacxa, acxb paramacxb)
  {
    QLog.w("ChatActivityUtils", 1, "startVideoCheck, !isNetSupport, seq[" + paramLong + "]");
    QQToast.a(paramContext, 2131694035, 0).b(paramContext.getResources().getDimensionPixelSize(2131299076));
    if (paramacxb.jdField_a_of_type_Boolean)
    {
      bcef.b(null, "CliOper", "", "", "Two_call", "Judge_network_false", 0, 0, "1", "", "", "");
      if (paramacxb.jdField_a_of_type_Int == 1024) {
        bcef.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_network_false", 0, 0, "", "", "", "");
      }
    }
    return Boolean.valueOf(true);
  }
  
  public static Boolean g(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, acxa paramacxa, acxb paramacxb)
  {
    QLog.w("ChatActivityUtils", 1, "startVideoCheck, !isWifiConnected, seq[" + paramLong + "]");
    Object localObject1 = VideoController.jdField_b_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin();
    Object localObject2;
    if (paramacxb.jdField_a_of_type_JavaUtilMap != null)
    {
      localObject2 = (String)paramacxb.jdField_a_of_type_JavaUtilMap.get("chat_type");
      if ((localObject2 != null) && ((((String)localObject2).equals("randomc2c")) || (((String)localObject2).equals("randomgroup")))) {
        localObject1 = VideoController.jdField_c_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin();
      }
    }
    for (;;)
    {
      if (VideoController.d((String)localObject1) > 0)
      {
        paramacxb.jdField_b_of_type_Boolean = false;
        paramacxb.jdField_c_of_type_Boolean = false;
        paramacxb.jdField_e_of_type_Boolean = false;
        ChatActivityUtils.a(paramLong, paramQQAppInterface, paramContext, paramacxa, paramacxb);
        return Boolean.valueOf(true);
      }
      localObject1 = null;
      int i = NetworkUtil.getSystemNetwork(paramContext);
      Object localObject3;
      if (i == 2)
      {
        localObject1 = paramContext.getString(2131695219);
        localObject2 = paramContext.getString(2131695215);
        if (!paramacxb.jdField_a_of_type_Boolean) {
          break label492;
        }
        bcef.b(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "1", "", "", "");
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
            localObject1 = paramContext.getString(2131695219);
            if (paramacxb.jdField_a_of_type_Boolean)
            {
              localObject2 = paramContext.getString(2131695217);
              bcef.b(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "2", "", "", "");
              localObject3 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject3;
              continue;
            }
            localObject3 = paramContext.getString(2131695216);
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
        }
        else
        {
          paramQQAppInterface = ChatActivityUtils.a(paramQQAppInterface, paramContext, 230, (String)localObject2, (String)localObject1, 2131694952, 2131694964, new acvf(paramacxb, i, paramLong, paramQQAppInterface, paramContext, paramacxa), new acvg(paramacxb, i, paramacxa));
          if (paramQQAppInterface != null) {
            paramQQAppInterface.setOnCancelListener(new acvh(paramacxb, i, paramacxa));
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
  
  public static Boolean h(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, acxa paramacxa, acxb paramacxb)
  {
    int i = paramQQAppInterface.getAVNotifyCenter().e();
    int j = paramQQAppInterface.getAVNotifyCenter().b();
    int k = paramQQAppInterface.getAVNotifyCenter().c();
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if (paramacxb.jdField_a_of_type_JavaUtilMap != null)
    {
      String str = (String)paramacxb.jdField_a_of_type_JavaUtilMap.get("chat_type");
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
          localObject2 = (String)paramacxb.jdField_a_of_type_JavaUtilMap.get("session_name");
          localObject1 = str;
        }
      }
    }
    if (((k == 1) || (k == 2)) && (j >= 1) && (j <= 5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startVideo is in Double Random Call!");
      }
      if ((localObject2 == null) || (!localObject1.equals("randomc2c")) || (!((String)localObject2).equals(paramQQAppInterface.getAVNotifyCenter().a())))
      {
        QQToast.a(paramContext, 2131695417, 1).b(paramContext.getResources().getDimensionPixelSize(2131299076));
        ChatActivityUtils.a(paramQQAppInterface, paramacxb.jdField_a_of_type_JavaUtilMap);
        return Boolean.valueOf(true);
      }
    }
    else
    {
      if ((paramacxb.jdField_d_of_type_Boolean) && ((k == 3) || (k == 4)) && (j >= 1) && (j <= 5))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo is Multi Random calling!");
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.equals((CharSequence)localObject2, paramQQAppInterface.getAVNotifyCenter().a()))) {
          i = 1;
        }
      }
      while (i == 0)
      {
        PopupDialog.a(paramContext, 230, null, paramContext.getString(2131695050), 2131694952, 2131694964, new acvi(paramacxb, paramLong, paramQQAppInterface, paramContext, paramacxa), new acvj(paramacxa));
        ChatActivityUtils.a(paramQQAppInterface, paramacxb.jdField_a_of_type_JavaUtilMap);
        return Boolean.valueOf(false);
        i = 0;
        continue;
        if (i == 1)
        {
          QLog.w("ChatActivityUtils", 1, "startVideoCheck, TYPE_SESSION_AUDIO, seq[" + paramLong + "]");
          if ((paramacxb.jdField_a_of_type_Boolean) && (((paramacxb.jdField_a_of_type_JavaLangString != null) && (paramacxb.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.getAVNotifyCenter().c()))) || ((paramacxb.jdField_c_of_type_JavaLangString != null) && (paramacxb.jdField_c_of_type_JavaLangString.equals(paramQQAppInterface.getAVNotifyCenter().c()))) || ((paramacxb.jdField_a_of_type_Int == 1006) && (((paramacxb.jdField_a_of_type_JavaLangString != null) && (paramacxb.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.getAVNotifyCenter().d()))) || ((paramacxb.jdField_c_of_type_JavaLangString != null) && (paramacxb.jdField_c_of_type_JavaLangString.equals(paramQQAppInterface.getAVNotifyCenter().d())))))))
          {
            if (paramacxa != null) {
              paramacxa.onBeforeStartActivity();
            }
            if (paramQQAppInterface.getAVNotifyCenter().b(paramQQAppInterface.getAVNotifyCenter().c()))
            {
              paramacxb = new Intent(paramContext, AVActivity.class);
              paramacxb.addFlags(262144);
              paramacxb.addFlags(268435456);
              paramacxb.putExtra("sessionType", 3);
              paramacxb.putExtra("GroupId", paramQQAppInterface.getAVNotifyCenter().c());
              paramacxb.putExtra("isDoubleVideoMeeting", true);
              paramContext.startActivity(paramacxb);
              if (paramacxa != null) {
                paramacxa.onAfterStartActivity();
              }
            }
          }
          for (;;)
          {
            return Boolean.valueOf(true);
            ChatActivityUtils.a(paramQQAppInterface, paramContext, paramacxb.jdField_a_of_type_Int, paramacxb.jdField_a_of_type_JavaLangString, paramacxb.jdField_b_of_type_JavaLangString, paramacxb.jdField_c_of_type_JavaLangString, paramacxb.jdField_a_of_type_Boolean, paramacxb.jdField_d_of_type_JavaLangString, paramacxb.jdField_e_of_type_JavaLangString, paramacxb.jdField_a_of_type_JavaUtilMap, false);
            break;
            QQToast.a(paramContext, 2131695417, 1).b(paramContext.getResources().getDimensionPixelSize(2131299076));
            ChatActivityUtils.a(paramQQAppInterface, paramacxb.jdField_a_of_type_JavaUtilMap);
          }
        }
        if (i == 2)
        {
          QLog.w("ChatActivityUtils", 1, "startVideoCheck, TYPE_SESSION_VIDEO, seq[" + paramLong + "]");
          if ((!paramacxb.jdField_a_of_type_Boolean) && (((paramacxb.jdField_a_of_type_JavaLangString != null) && (paramacxb.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.getAVNotifyCenter().c()))) || ((paramacxb.jdField_c_of_type_JavaLangString != null) && (paramacxb.jdField_c_of_type_JavaLangString.equals(paramQQAppInterface.getAVNotifyCenter().c()))) || ((paramacxb.jdField_a_of_type_Int == 1006) && (((paramacxb.jdField_a_of_type_JavaLangString != null) && (paramacxb.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.getAVNotifyCenter().d()))) || ((paramacxb.jdField_c_of_type_JavaLangString != null) && (paramacxb.jdField_c_of_type_JavaLangString.equals(paramQQAppInterface.getAVNotifyCenter().d())))))))
          {
            if (paramacxa != null) {
              paramacxa.onBeforeStartActivity();
            }
            if (paramQQAppInterface.getAVNotifyCenter().b(paramQQAppInterface.getAVNotifyCenter().c()))
            {
              paramacxb = new Intent(paramContext, AVActivity.class);
              paramacxb.addFlags(262144);
              paramacxb.addFlags(268435456);
              paramacxb.putExtra("sessionType", 3);
              paramacxb.putExtra("GroupId", paramQQAppInterface.getAVNotifyCenter().c());
              paramacxb.putExtra("isDoubleVideoMeeting", true);
              paramContext.startActivity(paramacxb);
              if (paramacxa != null) {
                paramacxa.onAfterStartActivity();
              }
            }
          }
          for (;;)
          {
            return Boolean.valueOf(true);
            ChatActivityUtils.a(paramQQAppInterface, paramContext, paramacxb.jdField_a_of_type_Int, paramacxb.jdField_a_of_type_JavaLangString, paramacxb.jdField_b_of_type_JavaLangString, paramacxb.jdField_c_of_type_JavaLangString, paramacxb.jdField_a_of_type_Boolean, paramacxb.jdField_d_of_type_JavaLangString, paramacxb.jdField_e_of_type_JavaLangString, paramacxb.jdField_a_of_type_JavaUtilMap, false);
            break;
            QQToast.a(paramContext, 2131695417, 1).b(paramContext.getResources().getDimensionPixelSize(2131299076));
            ChatActivityUtils.a(paramQQAppInterface, paramacxb.jdField_a_of_type_JavaUtilMap);
          }
        }
        if ((paramacxb.jdField_d_of_type_Boolean) && ((i == 3) || (i == 4)) && (paramQQAppInterface.getAVNotifyCenter().b() > 0L))
        {
          QLog.w("ChatActivityUtils", 1, "startVideoCheck, 存在多人通话, RelationId[" + paramQQAppInterface.getAVNotifyCenter().b() + "], sessionType[" + i + "], seq[" + paramLong + "]");
          PopupDialog.a(paramContext, 230, null, paramContext.getString(2131695050), 2131694952, 2131694964, new acvk(paramacxb, paramLong, paramQQAppInterface, paramContext, paramacxa), new acvl(paramacxa));
          ChatActivityUtils.a(paramQQAppInterface, paramacxb.jdField_a_of_type_JavaUtilMap);
          return Boolean.valueOf(false);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acvd
 * JD-Core Version:    0.7.0.1
 */