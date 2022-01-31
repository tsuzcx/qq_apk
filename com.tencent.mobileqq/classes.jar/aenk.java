import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.BirthdayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneBirthdayFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneGiftMessage;

public class aenk
{
  public static String a()
  {
    try
    {
      Object localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      ((JSONObject)localObject).put("app", "com.tencent.giftmall.greeting");
      ((JSONObject)localObject).put("view", "greeting-0");
      ((JSONObject)localObject).put("ver", "1.0.4.1");
      localJSONObject1.put("greetingData", localJSONObject2);
      ((JSONObject)localObject).put("meta", localJSONObject1);
      QLog.i("BirthdayActivateData", 1, " @arkgif getEmptyErroJson json data =" + ((JSONObject)localObject).toString());
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.e("BirthdayActivateData", 1, "getEmptyErroJson" + localException.toString());
    }
    return null;
  }
  
  public static String a(SubMsgType0x76.BirthdayNotify paramBirthdayNotify, QQAppInterface paramQQAppInterface)
  {
    for (;;)
    {
      JSONObject localJSONObject1;
      JSONObject localJSONObject2;
      JSONObject localJSONObject3;
      String str2;
      Object localObject2;
      String str1;
      int j;
      int m;
      int n;
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONObject2 = new JSONObject();
        localJSONObject3 = new JSONObject();
        localJSONObject1.put("app", "com.tencent.giftmall.greeting");
        localJSONObject3.put("ua", belc.a());
        if (paramBirthdayNotify == null)
        {
          localJSONObject1.put("view", "greeting-0");
          localJSONObject1.put("ver", "1.0.4.1");
          localJSONObject2.put("greetingData", localJSONObject3);
          localJSONObject1.put("meta", localJSONObject2);
          QLog.i("BirthdayActivateData", 1, "@arkgif msg_birthday_info is null  =" + localJSONObject1.toString());
          return localJSONObject1.toString();
        }
        str2 = paramBirthdayNotify.str_extend.get();
        if (!TextUtils.isEmpty(str2))
        {
          localObject1 = new JSONObject(str2);
          localObject2 = ((JSONObject)localObject1).getString("type");
          str1 = ((JSONObject)localObject1).getString("ver");
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label1036;
          }
          localObject1 = localObject2;
          if ("null".equals(localObject2)) {
            break label1036;
          }
          localJSONObject1.put("view", localObject1);
          if (TextUtils.isEmpty(str1)) {
            break label1043;
          }
          localObject1 = str1;
          if ("null".equals(str1)) {
            break label1043;
          }
          localJSONObject1.put("ver", localObject1);
          QLog.i("BirthdayActivateData", 1, "@arkgif strExtend = " + str2);
          localJSONObject3.put("str_extend", str2);
          j = paramBirthdayNotify.rpt_msg_one_friend.get().size();
          localObject1 = new JSONArray();
          i = 0;
          if (i < j)
          {
            long l1 = ((SubMsgType0x76.OneBirthdayFriend)paramBirthdayNotify.rpt_msg_one_friend.get().get(i)).uint64_uin.get();
            boolean bool = ((SubMsgType0x76.OneBirthdayFriend)paramBirthdayNotify.rpt_msg_one_friend.get().get(i)).bool_lunar_birth.get();
            k = ((SubMsgType0x76.OneBirthdayFriend)paramBirthdayNotify.rpt_msg_one_friend.get().get(i)).uint32_birth_month.get();
            m = ((SubMsgType0x76.OneBirthdayFriend)paramBirthdayNotify.rpt_msg_one_friend.get().get(i)).uint32_birth_date.get();
            n = ((SubMsgType0x76.OneBirthdayFriend)paramBirthdayNotify.rpt_msg_one_friend.get().get(i)).uint32_birth_year.get();
            long l2 = ((SubMsgType0x76.OneBirthdayFriend)paramBirthdayNotify.rpt_msg_one_friend.get().get(i)).uint64_msg_send_time.get();
            str1 = bdgc.b(paramQQAppInterface, l1 + "", true);
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("friendUin", l1 + "");
            ((JSONObject)localObject2).put("lunarBirthday", bool);
            ((JSONObject)localObject2).put("birthdayYear", n);
            ((JSONObject)localObject2).put("birthdayMonth", k);
            ((JSONObject)localObject2).put("birthdayDay", m);
            ((JSONObject)localObject2).put("messageSendTime", l2 + "");
            ((JSONObject)localObject2).put("nickName", str1);
            ((JSONArray)localObject1).put(i, localObject2);
            i += 1;
            continue;
          }
        }
        else
        {
          QLog.i("BirthdayActivateData", 1, "@arkgif json data strExtend is null  =");
          localJSONObject1.put("view", "greeting-0");
          localJSONObject1.put("ver", "1.0.4.1");
          continue;
        }
        localJSONObject3.put("friendModels", localObject1);
      }
      catch (Exception paramBirthdayNotify)
      {
        QLog.e("BirthdayActivateData", 1, paramBirthdayNotify.toString());
        return a();
      }
      int k = paramBirthdayNotify.rpt_gift_msg.get().size();
      paramQQAppInterface = new JSONArray();
      int i = 0;
      while (i < k)
      {
        localObject1 = new JSONObject();
        m = ((SubMsgType0x76.OneGiftMessage)paramBirthdayNotify.rpt_gift_msg.get().get(i)).gift_id.get();
        str1 = ((SubMsgType0x76.OneGiftMessage)paramBirthdayNotify.rpt_gift_msg.get().get(i)).gift_name.get();
        n = ((SubMsgType0x76.OneGiftMessage)paramBirthdayNotify.rpt_gift_msg.get().get(i)).type.get();
        localObject2 = ((SubMsgType0x76.OneGiftMessage)paramBirthdayNotify.rpt_gift_msg.get().get(i)).gift_url.get();
        int i1 = ((SubMsgType0x76.OneGiftMessage)paramBirthdayNotify.rpt_gift_msg.get().get(i)).price.get();
        int i2 = ((SubMsgType0x76.OneGiftMessage)paramBirthdayNotify.rpt_gift_msg.get().get(i)).play_cnt.get();
        String str3 = ((SubMsgType0x76.OneGiftMessage)paramBirthdayNotify.rpt_gift_msg.get().get(i)).background_color.get();
        ((JSONObject)localObject1).put("gift_id", m);
        ((JSONObject)localObject1).put("gift_name", str1);
        ((JSONObject)localObject1).put("gift_type", n);
        ((JSONObject)localObject1).put("gift_url", localObject2);
        ((JSONObject)localObject1).put("gift_price", i1);
        ((JSONObject)localObject1).put("play_count", i2);
        ((JSONObject)localObject1).put("bgColorStr", str3);
        paramQQAppInterface.put(i, localObject1);
        i += 1;
      }
      localJSONObject3.put("giftModels", paramQQAppInterface);
      localJSONObject2.put("greetingData", localJSONObject3);
      localJSONObject1.put("meta", localJSONObject2);
      if (QLog.isColorLevel()) {
        QLog.i("BirthdayActivateData", 1, "@arkgif json data friendnum=" + j + "strExtend = " + str2);
      }
      paramBirthdayNotify = localJSONObject1.toString();
      return paramBirthdayNotify;
      label1036:
      Object localObject1 = "greeting-0";
      continue;
      label1043:
      localObject1 = "1.0.4.1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aenk
 * JD-Core Version:    0.7.0.1
 */