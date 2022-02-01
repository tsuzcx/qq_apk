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

public final class adzv
{
  public static Boolean a(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, aebz paramaebz, aeca paramaeca)
  {
    mru.e(true, true);
    QLog.w("ChatActivityUtils", 1, "startVideoCheck, isPhoneCalling, seq[" + paramLong + "]");
    String str = paramContext.getString(2131695101);
    PopupDialog.a(paramContext, 230, paramContext.getString(2131695081), str, 2131690580, 2131694098, new adzw(paramaebz, paramaeca), null);
    mru.a(paramaeca.jdField_a_of_type_Boolean);
    if (paramaeca.jdField_a_of_type_Int == 1024) {
      bdll.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_phone_calling_false", 0, 0, "", "", "", "");
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
      bdll.b(paramQQAppInterface, "CliOper", "", "", "0X800520A", "0X800520A", 0, 0, "", "", "", "");
      return;
    }
    localIntent.putExtra("sessionType", paramInt);
    localIntent.putExtra("uin", paramQQAppInterface.a().c());
    paramBaseActivity.startActivity(localIntent);
    paramBaseActivity.overridePendingTransition(2130772138, 0);
    bdll.b(paramQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "1", "", "", "");
  }
  
  public static Boolean b(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, aebz paramaebz, aeca paramaeca)
  {
    new llk();
    llk.a();
    int i = llk.f();
    paramLong = llk.d();
    int j = Build.VERSION.SDK_INT;
    if ((i < 3) || (paramLong / 1000L < 800L) || (j < 9))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startVideo old engine!");
      }
      String str;
      if (paramaeca.jdField_a_of_type_JavaUtilMap != null)
      {
        str = (String)paramaeca.jdField_a_of_type_JavaUtilMap.get("chat_type");
        if (paramaeca.jdField_a_of_type_Int != 1011) {
          break label211;
        }
        paramaeca = paramContext.getString(2131695282);
        PopupDialog.a(paramContext, 230, paramContext.getString(2131695081), paramaeca, 2131690580, 2131695013, new aeae(paramaebz), null);
        if (!str.equals("randomc2c")) {
          break label184;
        }
        bdll.b(paramQQAppInterface, "CliOper", "", "", "0X80053B1", "0X80053B1", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        return Boolean.valueOf(false);
        str = "";
        break;
        label184:
        bdll.b(paramQQAppInterface, "CliOper", "", "", "0X80053BD", "0X80053BD", 0, 0, "", "", "", "");
      }
      label211:
      QQToast.a(paramContext, 2131694825, 1).b(paramContext.getResources().getDimensionPixelSize(2131299011));
      if (paramaeca.jdField_a_of_type_Boolean)
      {
        bdll.b(null, "CliOper", "", "", "Two_call", "Judge_tmp_address_false", 0, 0, "", "", "", "");
        if (paramaeca.jdField_a_of_type_Int == 1024) {
          bdll.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_tmp_address_false", 0, 0, "", "", "", "");
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
        localIntent.putExtra("uinType", mvd.c(j));
        localIntent.putExtra("MultiAVType", k);
        if (k != 2) {
          break label429;
        }
        if (paramQQAppInterface.a().c(String.valueOf(l)) != 14) {
          break label347;
        }
        ((awaa)paramQQAppInterface.getManager(236)).a(paramBaseActivity, paramQQAppInterface.getCurrentAccountUin(), String.valueOf(l), "2", "openRoom");
        label279:
        paramBaseActivity.overridePendingTransition(2130772138, 0);
        if (j != 2) {
          break label438;
        }
        bdll.b(paramQQAppInterface, "CliOper", "", "", "Multi_call", "Msgtab_back", 0, 0, "", "", "", "");
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
      bmem.a(paramQQAppInterface, paramBaseActivity, localIntent, 1);
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
        bdll.b(paramQQAppInterface, "CliOper", "", "", "0X8005931", "0X8005931", 0, 0, "", "", "", "");
        return;
      }
      bdll.b(paramQQAppInterface, "CliOper", "", "", "0X80046D8", "0X80046D8", 0, 0, "", "", "", "");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("MultiVideoBar", 2, "status error");
      return;
    }
  }
  
  public static Boolean c(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, aebz paramaebz, aeca paramaeca)
  {
    QLog.w("ChatActivityUtils", 1, "startVideoCheck, !isDAudioEnable, seq[" + paramLong + "]");
    String str = paramContext.getString(2131694761);
    PopupDialog.a(paramContext, 230, paramContext.getString(2131695081), str, 2131690580, 2131695013, new aeaf(paramaebz), null);
    if (paramaeca.jdField_a_of_type_Boolean)
    {
      bdll.b(null, "CliOper", "", "", "Two_call", "Judge_language_false", 0, 0, "", "", "", "");
      if (paramaeca.jdField_a_of_type_Int == 1024) {
        bdll.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_language_false", 0, 0, "", "", "", "");
      }
    }
    return Boolean.valueOf(false);
  }
  
  public static Boolean d(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, aebz paramaebz, aeca paramaeca)
  {
    if (!paramQQAppInterface.a().a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startVideo don't allow date session!");
      }
      paramQQAppInterface = PopupDialog.a(paramContext, 230, null, paramContext.getString(2131695247), 2131694814, 2131694827, new aeag(paramQQAppInterface, paramaeca, paramLong, paramContext, paramaebz), new aeah(paramaeca, paramaebz));
      if (paramQQAppInterface != null) {
        paramQQAppInterface.setOnCancelListener(new aeai(paramaeca, paramaebz));
      }
      return Boolean.valueOf(false);
    }
    return null;
  }
  
  public static Boolean e(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, aebz paramaebz, aeca paramaeca)
  {
    QLog.w("ChatActivityUtils", 1, "startVideoCheck, isMsgShielded, seq[" + paramLong + "]");
    if (paramaeca.jdField_a_of_type_Boolean) {
      bdll.b(null, "CliOper", "", "", "Two_call", "Shield_btn_appear", 0, 0, "", "", "", "");
    }
    String str = paramContext.getString(2131695248);
    paramQQAppInterface = PopupDialog.a(paramContext, 230, paramContext.getString(2131695081), str, 2131694814, 2131694827, new aeaj(paramQQAppInterface, paramaeca, paramLong, paramContext, paramaebz), new aeak(paramaeca, paramaebz));
    if (paramQQAppInterface != null) {
      paramQQAppInterface.setOnCancelListener(new aeal(paramaeca, paramaebz));
    }
    return Boolean.valueOf(false);
  }
  
  public static Boolean f(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, aebz paramaebz, aeca paramaeca)
  {
    QLog.w("ChatActivityUtils", 1, "startVideoCheck, !isNetSupport, seq[" + paramLong + "]");
    QQToast.a(paramContext, 2131693936, 0).b(paramContext.getResources().getDimensionPixelSize(2131299011));
    if (paramaeca.jdField_a_of_type_Boolean)
    {
      bdll.b(null, "CliOper", "", "", "Two_call", "Judge_network_false", 0, 0, "1", "", "", "");
      if (paramaeca.jdField_a_of_type_Int == 1024) {
        bdll.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_network_false", 0, 0, "", "", "", "");
      }
    }
    return Boolean.valueOf(true);
  }
  
  public static Boolean g(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, aebz paramaebz, aeca paramaeca)
  {
    QLog.w("ChatActivityUtils", 1, "startVideoCheck, !isWifiConnected, seq[" + paramLong + "]");
    Object localObject1 = VideoController.jdField_b_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin();
    Object localObject2;
    if (paramaeca.jdField_a_of_type_JavaUtilMap != null)
    {
      localObject2 = (String)paramaeca.jdField_a_of_type_JavaUtilMap.get("chat_type");
      if ((localObject2 != null) && ((((String)localObject2).equals("randomc2c")) || (((String)localObject2).equals("randomgroup")))) {
        localObject1 = VideoController.jdField_c_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin();
      }
    }
    for (;;)
    {
      if (VideoController.d((String)localObject1) > 0)
      {
        paramaeca.jdField_b_of_type_Boolean = false;
        paramaeca.jdField_c_of_type_Boolean = false;
        paramaeca.jdField_e_of_type_Boolean = false;
        ChatActivityUtils.a(paramLong, paramQQAppInterface, paramContext, paramaebz, paramaeca);
        return Boolean.valueOf(true);
      }
      localObject1 = null;
      int i = bhnv.a(paramContext);
      Object localObject3;
      if (i == 2)
      {
        localObject1 = paramContext.getString(2131695081);
        localObject2 = paramContext.getString(2131695077);
        if (!paramaeca.jdField_a_of_type_Boolean) {
          break label492;
        }
        bdll.b(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "1", "", "", "");
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
            localObject1 = paramContext.getString(2131695081);
            if (paramaeca.jdField_a_of_type_Boolean)
            {
              localObject2 = paramContext.getString(2131695079);
              bdll.b(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "2", "", "", "");
              localObject3 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject3;
              continue;
            }
            localObject3 = paramContext.getString(2131695078);
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
        }
        else
        {
          paramQQAppInterface = ChatActivityUtils.a(paramQQAppInterface, paramContext, 230, (String)localObject2, (String)localObject1, 2131694814, 2131694826, new adzx(paramaeca, i, paramLong, paramQQAppInterface, paramContext, paramaebz), new adzy(paramaeca, i, paramaebz));
          if (paramQQAppInterface != null) {
            paramQQAppInterface.setOnCancelListener(new adzz(paramaeca, i, paramaebz));
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
  
  public static Boolean h(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, aebz paramaebz, aeca paramaeca)
  {
    int i = paramQQAppInterface.a().e();
    int j = paramQQAppInterface.a().b();
    int k = paramQQAppInterface.a().c();
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if (paramaeca.jdField_a_of_type_JavaUtilMap != null)
    {
      String str = (String)paramaeca.jdField_a_of_type_JavaUtilMap.get("chat_type");
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
          localObject2 = (String)paramaeca.jdField_a_of_type_JavaUtilMap.get("session_name");
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
        QQToast.a(paramContext, 2131695278, 1).b(paramContext.getResources().getDimensionPixelSize(2131299011));
        ChatActivityUtils.a(paramQQAppInterface, paramaeca.jdField_a_of_type_JavaUtilMap);
        return Boolean.valueOf(true);
      }
    }
    else
    {
      if ((paramaeca.jdField_d_of_type_Boolean) && ((k == 3) || (k == 4)) && (j >= 1) && (j <= 5))
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
        PopupDialog.a(paramContext, 230, null, paramContext.getString(2131694912), 2131694814, 2131694826, new aeaa(paramaeca, paramLong, paramQQAppInterface, paramContext, paramaebz), new aeab(paramaebz));
        ChatActivityUtils.a(paramQQAppInterface, paramaeca.jdField_a_of_type_JavaUtilMap);
        return Boolean.valueOf(false);
        i = 0;
        continue;
        if (i == 1)
        {
          QLog.w("ChatActivityUtils", 1, "startVideoCheck, TYPE_SESSION_AUDIO, seq[" + paramLong + "]");
          if ((paramaeca.jdField_a_of_type_Boolean) && (((paramaeca.jdField_a_of_type_JavaLangString != null) && (paramaeca.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.a().c()))) || ((paramaeca.jdField_c_of_type_JavaLangString != null) && (paramaeca.jdField_c_of_type_JavaLangString.equals(paramQQAppInterface.a().c()))) || ((paramaeca.jdField_a_of_type_Int == 1006) && (((paramaeca.jdField_a_of_type_JavaLangString != null) && (paramaeca.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.a().d()))) || ((paramaeca.jdField_c_of_type_JavaLangString != null) && (paramaeca.jdField_c_of_type_JavaLangString.equals(paramQQAppInterface.a().d())))))))
          {
            if (paramaebz != null) {
              paramaebz.b();
            }
            if (paramQQAppInterface.a().b(paramQQAppInterface.a().c()))
            {
              paramaeca = new Intent(paramContext, AVActivity.class);
              paramaeca.addFlags(262144);
              paramaeca.addFlags(268435456);
              paramaeca.putExtra("sessionType", 3);
              paramaeca.putExtra("GroupId", paramQQAppInterface.a().c());
              paramaeca.putExtra("isDoubleVideoMeeting", true);
              paramContext.startActivity(paramaeca);
              if (paramaebz != null) {
                paramaebz.c();
              }
            }
          }
          for (;;)
          {
            return Boolean.valueOf(true);
            ChatActivityUtils.a(paramQQAppInterface, paramContext, paramaeca.jdField_a_of_type_Int, paramaeca.jdField_a_of_type_JavaLangString, paramaeca.jdField_b_of_type_JavaLangString, paramaeca.jdField_c_of_type_JavaLangString, paramaeca.jdField_a_of_type_Boolean, paramaeca.jdField_d_of_type_JavaLangString, paramaeca.jdField_e_of_type_JavaLangString, paramaeca.jdField_a_of_type_JavaUtilMap, false);
            break;
            QQToast.a(paramContext, 2131695278, 1).b(paramContext.getResources().getDimensionPixelSize(2131299011));
            ChatActivityUtils.a(paramQQAppInterface, paramaeca.jdField_a_of_type_JavaUtilMap);
          }
        }
        if (i == 2)
        {
          QLog.w("ChatActivityUtils", 1, "startVideoCheck, TYPE_SESSION_VIDEO, seq[" + paramLong + "]");
          if ((!paramaeca.jdField_a_of_type_Boolean) && (((paramaeca.jdField_a_of_type_JavaLangString != null) && (paramaeca.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.a().c()))) || ((paramaeca.jdField_c_of_type_JavaLangString != null) && (paramaeca.jdField_c_of_type_JavaLangString.equals(paramQQAppInterface.a().c()))) || ((paramaeca.jdField_a_of_type_Int == 1006) && (((paramaeca.jdField_a_of_type_JavaLangString != null) && (paramaeca.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.a().d()))) || ((paramaeca.jdField_c_of_type_JavaLangString != null) && (paramaeca.jdField_c_of_type_JavaLangString.equals(paramQQAppInterface.a().d())))))))
          {
            if (paramaebz != null) {
              paramaebz.b();
            }
            if (paramQQAppInterface.a().b(paramQQAppInterface.a().c()))
            {
              paramaeca = new Intent(paramContext, AVActivity.class);
              paramaeca.addFlags(262144);
              paramaeca.addFlags(268435456);
              paramaeca.putExtra("sessionType", 3);
              paramaeca.putExtra("GroupId", paramQQAppInterface.a().c());
              paramaeca.putExtra("isDoubleVideoMeeting", true);
              paramContext.startActivity(paramaeca);
              if (paramaebz != null) {
                paramaebz.c();
              }
            }
          }
          for (;;)
          {
            return Boolean.valueOf(true);
            ChatActivityUtils.a(paramQQAppInterface, paramContext, paramaeca.jdField_a_of_type_Int, paramaeca.jdField_a_of_type_JavaLangString, paramaeca.jdField_b_of_type_JavaLangString, paramaeca.jdField_c_of_type_JavaLangString, paramaeca.jdField_a_of_type_Boolean, paramaeca.jdField_d_of_type_JavaLangString, paramaeca.jdField_e_of_type_JavaLangString, paramaeca.jdField_a_of_type_JavaUtilMap, false);
            break;
            QQToast.a(paramContext, 2131695278, 1).b(paramContext.getResources().getDimensionPixelSize(2131299011));
            ChatActivityUtils.a(paramQQAppInterface, paramaeca.jdField_a_of_type_JavaUtilMap);
          }
        }
        if ((paramaeca.jdField_d_of_type_Boolean) && ((i == 3) || (i == 4)) && (paramQQAppInterface.a().b() > 0L))
        {
          QLog.w("ChatActivityUtils", 1, "startVideoCheck, 存在多人通话, RelationId[" + paramQQAppInterface.a().b() + "], sessionType[" + i + "], seq[" + paramLong + "]");
          PopupDialog.a(paramContext, 230, null, paramContext.getString(2131694912), 2131694814, 2131694826, new aeac(paramaeca, paramLong, paramQQAppInterface, paramContext, paramaebz), new aead(paramaebz));
          ChatActivityUtils.a(paramQQAppInterface, paramaeca.jdField_a_of_type_JavaUtilMap);
          return Boolean.valueOf(false);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzv
 * JD-Core Version:    0.7.0.1
 */