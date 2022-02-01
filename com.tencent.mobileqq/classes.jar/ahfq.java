import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.1.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ahfq
  extends atyo
{
  ahfq(ahfp paramahfp) {}
  
  protected void a(Object paramObject)
  {
    super.a(paramObject);
    Object localObject;
    if ((paramObject != null) && ((paramObject instanceof JSONObject)))
    {
      QLog.i(ahfp.b, 1, "[onGetGameStartPriority] data:" + paramObject.toString());
      try
      {
        paramObject = (JSONObject)paramObject;
        if (paramObject.optString("ret_code") != null)
        {
          localObject = paramObject.optJSONObject("download_info");
          if (localObject != null)
          {
            ahfp.a(this.a, ((JSONObject)localObject).optString("pkg_name"));
            ahfp.b(this.a, ((JSONObject)localObject).optString("ticket"));
          }
          ahfp.a(this.a, paramObject.optInt("open_switch"));
          ahfp.c(this.a, paramObject.optString("reserved_str"));
          paramObject = paramObject.optJSONArray("start_priority_list");
          ahfp.a(this.a).clear();
          if (paramObject != null)
          {
            int i = 0;
            while (i < paramObject.length())
            {
              localObject = paramObject.optJSONObject(i);
              ahga localahga = new ahga(null);
              localahga.b = ((JSONObject)localObject).optString("content");
              localahga.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("icon_url");
              ahfp.a(this.a).add(localahga);
              i += 1;
            }
          }
        }
        if (ahfp.a(this.a)) {
          break label316;
        }
      }
      catch (Exception paramObject)
      {
        QLog.e(ahfp.b, 1, paramObject, new Object[0]);
      }
    }
    else if (ahfp.a(this.a) != null)
    {
      localObject = ahfp.a(this.a).c;
      if (ahfp.a(this.a) != 1) {
        break label455;
      }
      paramObject = "1";
      atyf.a((String)localObject, "1", "145", "920", "92005", "207561", paramObject, "", "8", "0");
      ahfp.a(this.a, true);
    }
    label316:
    if ((this.a.getApp() != null) && (ahfp.a(this.a) != null)) {}
    for (boolean bool = BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0).getBoolean(this.a.getApp().getCurrentUin() + "_game_msg_chatpie_reddot_click_" + ahfp.a(this.a).c, false);; bool = false)
    {
      if ((ahfp.a(this.a) == 1) && (!bool))
      {
        atyf.a(ahfp.a(this.a).c, "1", "145", "920", "92005", "207562", "", "", "8", "0");
        ThreadManagerV2.getUIHandlerV2().post(new GameMsgChatPie.1.1(this));
      }
      return;
      label455:
      paramObject = "0";
      break;
    }
  }
  
  protected void b(Object paramObject)
  {
    QLog.i(ahfp.b, 1, "[onGameUsrInfoChangedNotify]");
    for (;;)
    {
      atyc localatyc;
      try
      {
        if ((paramObject instanceof ArrayList))
        {
          paramObject = ((ArrayList)paramObject).iterator();
          if (paramObject.hasNext())
          {
            localatyc = (atyc)paramObject.next();
            if ((TextUtils.isEmpty(localatyc.b)) || (!localatyc.b.equals(this.a.sessionInfo.getFriendRoleId()))) {
              break label155;
            }
            ahfp.a(this.a, localatyc);
            ahfp.a(this.a, localatyc);
            if (ahfp.a(this.a) != null) {
              ((atyn)this.a.app.getBusinessHandler(175)).a(ahfp.a(this.a).c);
            }
            QLog.i(ahfp.b, 1, "update friend info.");
            continue;
          }
        }
        return;
      }
      catch (Throwable paramObject)
      {
        QLog.e(ahfp.b, 1, paramObject.getMessage());
      }
      label155:
      if ((!TextUtils.isEmpty(localatyc.b)) && (localatyc.b.equals(this.a.sessionInfo.getMyRoleId())))
      {
        ahfp.b(this.a, localatyc);
        QLog.i(ahfp.b, 1, "update my info.");
      }
    }
  }
  
  protected void c(Object paramObject)
  {
    if (paramObject == null) {}
    for (paramObject = "";; paramObject = paramObject.toString()) {
      try
      {
        QLog.i(ahfp.b, 1, "[onGetFriendExtInfo], data:" + paramObject);
        ahfp.a(this.a).a(this.a.sessionInfo.getFriendRoleId(), paramObject);
        return;
      }
      catch (Throwable paramObject)
      {
        QLog.e(ahfp.b, 1, paramObject, new Object[0]);
      }
    }
  }
  
  protected void d(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof JSONObject))) {
      QLog.i(ahfp.b, 1, "[onGetAioPopInfo] data:" + paramObject.toString());
    }
    for (;;)
    {
      String str;
      ArrayList localArrayList;
      int i;
      try
      {
        Object localObject = (JSONObject)paramObject;
        paramObject = ((JSONObject)localObject).optString("title");
        str = ((JSONObject)localObject).optString("content");
        localObject = ((JSONObject)localObject).optJSONArray("buttons");
        if (TextUtils.isEmpty(str)) {
          break label292;
        }
        if (((JSONArray)localObject).length() == 0) {
          return;
        }
        localArrayList = new ArrayList();
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(i);
          ahfz localahfz = new ahfz(this.a);
          localahfz.b = localJSONObject.optString("title");
          if (TextUtils.isEmpty(localahfz.b)) {
            break label293;
          }
          localahfz.jdField_a_of_type_JavaLangString = localJSONObject.optString("url");
          localahfz.jdField_a_of_type_Int = localJSONObject.optInt("type");
          localArrayList.add(localahfz);
        }
      }
      catch (JSONException paramObject)
      {
        paramObject.printStackTrace();
        return;
      }
      if (localArrayList.size() == 1)
      {
        ahfp.a(this.a, paramObject, str, (ahfz)localArrayList.get(0), null);
        return;
      }
      if (localArrayList.size() >= 2)
      {
        ahfp.a(this.a, paramObject, str, (ahfz)localArrayList.get(0), (ahfz)localArrayList.get(1));
        return;
      }
      QLog.i(ahfp.b, 1, "[onGetAioPopInfo] no button.");
      label292:
      return;
      label293:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfq
 * JD-Core Version:    0.7.0.1
 */