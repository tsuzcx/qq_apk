import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.s2c.msgtype0x210.submsgtype0x94.Submsgtype0x94.MsgBody;

public class acsd
  implements acpi
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    Object localObject1 = new Submsgtype0x94.MsgBody();
    try
    {
      ((Submsgtype0x94.MsgBody)localObject1).mergeFrom(paramMsgType0x210.vProtobuf);
      label88:
      boolean bool5;
      if (((Submsgtype0x94.MsgBody)localObject1).str_folder_msg.has())
      {
        paramMsgType0x210 = ((Submsgtype0x94.MsgBody)localObject1).str_folder_msg.get().trim();
        if (QLog.isColorLevel()) {
          QLog.i("EcShopAssistantActivity", 2, "diy string:" + paramMsgType0x210);
        }
        if (((Submsgtype0x94.MsgBody)localObject1).uint32_discover_reddot_flag.get() != 1) {
          break label419;
        }
        bool4 = true;
        if (((Submsgtype0x94.MsgBody)localObject1).uint32_folder_reddot_flag.get() != 1) {
          break label425;
        }
        bool5 = true;
        label103:
        if (((Submsgtype0x94.MsgBody)localObject1).uint32_discount_reddot_flag.get() != 1) {
          break label431;
        }
        bool2 = true;
        label118:
        if (((Submsgtype0x94.MsgBody)localObject1).uint32_nearby_reddot_flag.get() != 1) {
          break label437;
        }
        bool1 = true;
        label133:
        if (((Submsgtype0x94.MsgBody)localObject1).uint32_mine_reddot_flag.get() != 1) {
          break label443;
        }
      }
      int k;
      int m;
      int n;
      int j;
      int i1;
      String str2;
      String str3;
      String str4;
      String str1;
      int i2;
      label419:
      label425:
      label431:
      label437:
      label443:
      for (bool3 = true;; bool3 = false)
      {
        k = ((Submsgtype0x94.MsgBody)localObject1).uint32_start_ts.get();
        m = ((Submsgtype0x94.MsgBody)localObject1).uint32_end_ts.get();
        n = (int)(System.currentTimeMillis() / 1000L);
        j = ((Submsgtype0x94.MsgBody)localObject1).uint32_period_of_validity.get();
        i1 = ((Submsgtype0x94.MsgBody)localObject1).uint32_task_type.get();
        str2 = ((Submsgtype0x94.MsgBody)localObject1).str_task_info.get();
        str3 = ((Submsgtype0x94.MsgBody)localObject1).str_type_name.get();
        str4 = ((Submsgtype0x94.MsgBody)localObject1).str_type_color.get();
        str1 = ((Submsgtype0x94.MsgBody)localObject1).str_jump_url.get();
        i2 = ((Submsgtype0x94.MsgBody)localObject1).uint32_task_id.get();
        if (QLog.isColorLevel()) {
          QLog.i("EcShopAssistantActivity", 2, "reddot start=" + k + ",end=" + m + ",showtime=" + j + "flags:" + bool5 + "," + bool4 + "," + bool2 + "," + bool1 + "," + bool3 + ",type:" + i1 + ",taskInfo:" + str2 + ",typeName:" + str3 + ",typeColor:" + str4 + ",jumpUrl:" + str1);
        }
        if ((n >= k) && (n <= m)) {
          break label449;
        }
        return;
        paramMsgType0x210 = "";
        break;
        bool4 = false;
        break label88;
        bool5 = false;
        break label103;
        bool2 = false;
        break label118;
        bool1 = false;
        break label133;
      }
      label449:
      int i = j;
      if (j > 172800000) {
        i = 172800000;
      }
      if ((bool4) || (bool2) || (bool1) || (bool3))
      {
        bool5 = true;
        if (!bool5)
        {
          if ((bool4) || (((Submsgtype0x94.MsgBody)localObject1).uint32_only_discover_reddot_flag.get() == 1))
          {
            bool4 = true;
            if ((!bool2) && (((Submsgtype0x94.MsgBody)localObject1).uint32_only_discount_reddot_flag.get() != 1)) {
              break label1268;
            }
            bool2 = true;
            label528:
            if ((!bool1) && (((Submsgtype0x94.MsgBody)localObject1).uint32_only_nearby_reddot_flag.get() != 1)) {
              break label1274;
            }
            bool1 = true;
            label548:
            if ((!bool3) && (((Submsgtype0x94.MsgBody)localObject1).uint32_only_mine_reddot_flag.get() != 1)) {
              break label1280;
            }
            bool3 = true;
            label568:
            bool6 = bool3;
            bool7 = bool4;
            bool8 = bool2;
            bool9 = bool1;
            if (QLog.isColorLevel())
            {
              QLog.i("EcShopAssistantActivity", 2, "new flag:" + bool4 + "," + bool2 + "," + bool1 + "," + bool3);
              bool9 = bool1;
              bool8 = bool2;
              bool7 = bool4;
              bool6 = bool3;
            }
            Object localObject2 = paramQQAppInterface.getCurrentAccountUin();
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = "noLogin";
            }
            localObject2 = paramQQAppInterface.getApp().getSharedPreferences("ecshop_sp" + (String)localObject1, 0);
            localObject1 = ((SharedPreferences)localObject2).edit();
            if ((((SharedPreferences)localObject2).getBoolean("disc_reddot", false)) || (((SharedPreferences)localObject2).getBoolean("welfare_reddot", false)) || (((SharedPreferences)localObject2).getBoolean("nearby_reddot", false)) || (((SharedPreferences)localObject2).getBoolean("mine_reddot", false)) || (((SharedPreferences)localObject2).getBoolean("folder_reddot", false)))
            {
              j = ((SharedPreferences)localObject2).getInt("last_show_time1", 0);
              int i3 = ((SharedPreferences)localObject2).getInt("reddot_start", 0);
              int i4 = ((SharedPreferences)localObject2).getInt("reddot_end", 0);
              int i5 = ((SharedPreferences)localObject2).getInt("max_reddot_time", 0);
              int i6 = (int)(System.currentTimeMillis() / 1000L);
              if ((i6 != 0) && (i3 != 0) && (i4 != 0) && (i5 != 0) && ((i6 < i3) || (i6 > i4) || (i6 - j >= i5)))
              {
                if (QLog.isColorLevel()) {
                  QLog.i("EcShopAssistantActivity", 2, "online push found reddot out of date!");
                }
                ((SharedPreferences.Editor)localObject1).putBoolean("disc_reddot", false);
                ((SharedPreferences.Editor)localObject1).putBoolean("welfare_reddot", false);
                ((SharedPreferences.Editor)localObject1).putBoolean("nearby_reddot", false);
                ((SharedPreferences.Editor)localObject1).putBoolean("mine_reddot", false);
                ((SharedPreferences.Editor)localObject1).putBoolean("folder_reddot", false);
              }
            }
            ((SharedPreferences.Editor)localObject1).putInt("reddot_start", k);
            ((SharedPreferences.Editor)localObject1).putInt("reddot_end", m);
            ((SharedPreferences.Editor)localObject1).putInt("max_reddot_time", i);
            ((SharedPreferences.Editor)localObject1).putString("str_ecshop_diy", paramMsgType0x210);
            ((SharedPreferences.Editor)localObject1).putInt("last_show_time1", n);
            ((SharedPreferences.Editor)localObject1).putInt("PUSH_TASK_TYPE", i1);
            ((SharedPreferences.Editor)localObject1).putString("PUSH_TASK_INFO", str2);
            ((SharedPreferences.Editor)localObject1).putString("PUSH_TYPE_NAME", str3);
            ((SharedPreferences.Editor)localObject1).putString("PUSH_TYPE_COLOR", str4);
            ((SharedPreferences.Editor)localObject1).putLong("PUSH_RECEIVE_TIME", NetConnInfoCenter.getServerTime());
            ((SharedPreferences.Editor)localObject1).putInt("PUSH_TASK_ID", i2);
            if (str1 != null) {
              break label1286;
            }
            paramMsgType0x210 = "";
            label1097:
            ((SharedPreferences.Editor)localObject1).putString("PUSH_JUMP_URL", paramMsgType0x210);
            ((SharedPreferences.Editor)localObject1).putInt("FOLDER_MSG_TYPE", 1);
            ((SharedPreferences.Editor)localObject1).putBoolean("folder_reddot", bool5);
            ((SharedPreferences.Editor)localObject1).putBoolean("disc_reddot", bool7);
            ((SharedPreferences.Editor)localObject1).putBoolean("welfare_reddot", bool8);
            ((SharedPreferences.Editor)localObject1).putBoolean("nearby_reddot", bool9);
            ((SharedPreferences.Editor)localObject1).putBoolean("mine_reddot", bool6);
            ((SharedPreferences.Editor)localObject1).commit();
            if (!bool5) {
              break label1292;
            }
            ((onq)paramQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).a(NetConnInfoCenter.getServerTime(), bool5);
            label1212:
            ((onu)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ECSHOP_HANDLER)).a();
            paramMsgType0x210 = null;
            if (!bool7) {
              break label1315;
            }
            paramMsgType0x210 = "Arrived_shopdiscover_dot";
          }
          for (;;)
          {
            bdla.b(paramQQAppInterface, "dc00898", "", "", "Shop_folder", paramMsgType0x210, 0, 0, "", "", "", "");
            return;
            bool4 = false;
            break;
            label1268:
            bool2 = false;
            break label528;
            label1274:
            bool1 = false;
            break label548;
            label1280:
            bool3 = false;
            break label568;
            label1286:
            paramMsgType0x210 = str1;
            break label1097;
            label1292:
            paramMsgType0x210 = paramQQAppInterface.getHandler(Conversation.class);
            if (paramMsgType0x210 == null) {
              break label1212;
            }
            paramMsgType0x210.sendEmptyMessage(1009);
            break label1212;
            label1315:
            if (bool8) {
              paramMsgType0x210 = "Arrived_shoppreferential_dot";
            } else if (bool9) {
              paramMsgType0x210 = "Arrived_shopnearbynot_dot";
            } else if (bool6) {
              paramMsgType0x210 = "Arrived_shopmynot_dot";
            } else if (bool5) {
              paramMsgType0x210 = "Arrived_folder_dot";
            }
          }
        }
      }
    }
    catch (Throwable paramMsgType0x210)
    {
      for (;;)
      {
        boolean bool4;
        boolean bool2;
        boolean bool1;
        boolean bool3;
        continue;
        boolean bool6 = bool3;
        boolean bool7 = bool4;
        boolean bool8 = bool2;
        boolean bool9 = bool1;
      }
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsd
 * JD-Core Version:    0.7.0.1
 */