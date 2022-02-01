import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.1.1;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
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

public class aiai
  extends aved
{
  aiai(aiah paramaiah) {}
  
  protected void a(Object paramObject)
  {
    super.a(paramObject);
    Object localObject;
    if ((paramObject != null) && ((paramObject instanceof JSONObject)))
    {
      QLog.i(aiah.b, 1, "[onGetGameStartPriority] data:" + paramObject.toString());
      try
      {
        paramObject = (JSONObject)paramObject;
        if (paramObject.optString("ret_code") != null)
        {
          localObject = paramObject.optJSONObject("download_info");
          if (localObject != null)
          {
            aiah.a(this.a, ((JSONObject)localObject).optString("pkg_name"));
            aiah.b(this.a, ((JSONObject)localObject).optString("ticket"));
          }
          aiah.a(this.a, paramObject.optInt("open_switch"));
          aiah.c(this.a, paramObject.optString("reserved_str"));
          paramObject = paramObject.optJSONArray("start_priority_list");
          aiah.a(this.a).clear();
          if (paramObject != null)
          {
            int i = 0;
            while (i < paramObject.length())
            {
              localObject = paramObject.optJSONObject(i);
              aias localaias = new aias(null);
              localaias.b = ((JSONObject)localObject).optString("content");
              localaias.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("icon_url");
              aiah.a(this.a).add(localaias);
              i += 1;
            }
          }
        }
        if (aiah.a(this.a)) {
          break label316;
        }
      }
      catch (Exception paramObject)
      {
        QLog.e(aiah.b, 1, paramObject, new Object[0]);
      }
    }
    else if (aiah.a(this.a) != null)
    {
      localObject = aiah.a(this.a).c;
      if (aiah.a(this.a) != 1) {
        break label455;
      }
      paramObject = "1";
      avdu.a((String)localObject, "1", "145", "920", "92005", "207561", paramObject, "", "8", "0");
      aiah.a(this.a, true);
    }
    label316:
    if ((this.a.getApp() != null) && (aiah.a(this.a) != null)) {}
    for (boolean bool = BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0).getBoolean(this.a.getApp().getCurrentUin() + "_game_msg_chatpie_reddot_click_" + aiah.a(this.a).c, false);; bool = false)
    {
      if ((aiah.a(this.a) == 1) && (!bool))
      {
        avdu.a(aiah.a(this.a).c, "1", "145", "920", "92005", "207562", "", "", "8", "0");
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
    QLog.i(aiah.b, 1, "[onGameUsrInfoChangedNotify]");
    for (;;)
    {
      avdr localavdr;
      try
      {
        if ((paramObject instanceof ArrayList))
        {
          paramObject = ((ArrayList)paramObject).iterator();
          if (paramObject.hasNext())
          {
            localavdr = (avdr)paramObject.next();
            if ((TextUtils.isEmpty(localavdr.b)) || (!localavdr.b.equals(this.a.sessionInfo.getFriendRoleId()))) {
              break label178;
            }
            aiah.a(this.a, localavdr);
            aiah.a(this.a, localavdr);
            if (aiah.a(this.a) != null)
            {
              ((avec)this.a.app.getBusinessHandler(BusinessHandlerFactory.GAME_CENTER_UNISSO_HANDLER)).a(aiah.a(this.a).c);
              aiah.c = aiah.a(this.a).c;
            }
            aiah.a(this.a, "onGameUsrInfoChangedNotify");
            QLog.i(aiah.b, 1, "update friend info.");
            continue;
          }
        }
        return;
      }
      catch (Throwable paramObject)
      {
        QLog.e(aiah.b, 1, paramObject.getMessage());
      }
      label178:
      if ((!TextUtils.isEmpty(localavdr.b)) && (localavdr.b.equals(this.a.sessionInfo.getMyRoleId())))
      {
        aiah.b(this.a, localavdr);
        QLog.i(aiah.b, 1, "update my info.");
      }
    }
  }
  
  protected void c(Object paramObject)
  {
    if (paramObject == null) {}
    for (paramObject = "";; paramObject = paramObject.toString()) {
      try
      {
        QLog.i(aiah.b, 1, "[onGetFriendExtInfo], data:" + paramObject);
        aiah.a(this.a).a(this.a.sessionInfo.getFriendRoleId(), paramObject);
        return;
      }
      catch (Throwable paramObject)
      {
        QLog.e(aiah.b, 1, paramObject, new Object[0]);
      }
    }
  }
  
  protected void d(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(aiah.b, 2, "[onGetTopGrayTips], tips:" + paramObject);
    }
    String str = this.a.mActivity.getIntent().getStringExtra("game_msg_top_gray_text");
    if ((TextUtils.isEmpty(str)) && ((paramObject instanceof String))) {}
    for (paramObject = (String)paramObject;; paramObject = str)
    {
      aiah.b(this.a, paramObject);
      return;
    }
  }
  
  protected void e(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof JSONObject))) {
      QLog.i(aiah.b, 1, "[onGetAioPopInfo] data:" + paramObject.toString());
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
          aiar localaiar = new aiar(this.a);
          localaiar.b = localJSONObject.optString("title");
          if (TextUtils.isEmpty(localaiar.b)) {
            break label293;
          }
          localaiar.jdField_a_of_type_JavaLangString = localJSONObject.optString("url");
          localaiar.jdField_a_of_type_Int = localJSONObject.optInt("type");
          localArrayList.add(localaiar);
        }
      }
      catch (JSONException paramObject)
      {
        paramObject.printStackTrace();
        return;
      }
      if (localArrayList.size() == 1)
      {
        aiah.a(this.a, paramObject, str, (aiar)localArrayList.get(0), null);
        return;
      }
      if (localArrayList.size() >= 2)
      {
        aiah.a(this.a, paramObject, str, (aiar)localArrayList.get(0), (aiar)localArrayList.get(1));
        return;
      }
      QLog.i(aiah.b, 1, "[onGetAioPopInfo] no button.");
      label292:
      return;
      label293:
      i += 1;
    }
  }
  
  protected void f(Object paramObject)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(aiah.b, 2, new Object[] { "[onGetGrayTips], data:", paramObject });
      }
      paramObject = (JSONArray)paramObject;
      int i = 0;
      while (i < paramObject.length())
      {
        JSONArray localJSONArray = paramObject.getJSONObject(i).getJSONArray("content");
        ArrayList localArrayList = new ArrayList();
        int j = 0;
        while (j < localJSONArray.length())
        {
          aiau localaiau = new aiau();
          JSONObject localJSONObject = localJSONArray.getJSONObject(j);
          localaiau.jdField_a_of_type_JavaLangString = localJSONObject.optString("title");
          localaiau.jdField_a_of_type_Int = localJSONObject.optInt("type");
          localaiau.b = localJSONObject.optString("url");
          localArrayList.add(localaiau);
          j += 1;
        }
        aiah.a(this.a, localArrayList);
        i += 1;
      }
      return;
    }
    catch (Throwable paramObject)
    {
      QLog.e(aiah.b, 1, paramObject, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiai
 * JD-Core Version:    0.7.0.1
 */