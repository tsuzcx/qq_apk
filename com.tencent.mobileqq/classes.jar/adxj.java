import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ChatSettingForTroop.4.1;
import com.tencent.mobileqq.activity.ChatSettingForTroop.4.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class adxj
  extends BroadcastReceiver
{
  public adxj(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    paramContext = paramIntent.getAction();
    int i = j;
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      i = j;
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) {
        i = 1;
      }
    }
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("data");
      paramIntent = paramIntent.getStringExtra("event");
      if ("onHomeworkTroopIdentityChanged".equals(paramIntent)) {
        if (i != 0) {}
      }
    }
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(paramContext)) {
        try
        {
          Object localObject4 = new JSONObject(paramContext);
          paramContext = ((JSONObject)localObject4).optString("groupCode");
          if (TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramContext))
          {
            paramIntent = ((JSONObject)localObject4).optString("content");
            Object localObject1 = ((JSONObject)localObject4).optString("source");
            i = ((JSONObject)localObject4).optInt("rankId", 333);
            String str = ((JSONObject)localObject4).optString("nickName");
            Object localObject2 = ((JSONObject)localObject4).optString("uin");
            Object localObject3 = ((JSONObject)localObject4).optString("course");
            localObject4 = ((JSONObject)localObject4).optString("name");
            if ("troopProfile".equals(localObject1)) {
              ThreadManager.post(new ChatSettingForTroop.4.1(this, (String)localObject2, str, i, (String)localObject3, (String)localObject4), 8, null, false);
            }
            while (QLog.isColorLevel())
            {
              QLog.d("zivonchen", 2, "mHomeworkTroopIdentityChangedReceiver troopUin = " + paramContext + ", content = " + paramIntent + ", source = " + (String)localObject1 + ", rankId = " + i + ", nickName = " + str);
              return;
              if ("join".equals(localObject1))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("wyx", 2, new Object[] { "mHomeworkTroopIdentityChangedReceiver source=join. cGroupOption=", Short.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption), ", joinType=", Integer.valueOf(ChatSettingForTroop.a(this.a)) });
                }
                if (ChatSettingForTroop.a(this.a) == 1) {
                  ChatSettingForTroop.c(this.a);
                } else if (ChatSettingForTroop.a(this.a) == 2) {
                  ChatSettingForTroop.a(this.a, paramIntent);
                }
              }
            }
            if ("bindGames".equals(paramIntent))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.chatopttroop", 2, "receive bind game event, data=" + paramContext);
              }
              try
              {
                paramContext = new JSONObject(paramContext);
                paramIntent = paramContext.getString("groupid");
                if ((!this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin.equals(paramIntent)) || (paramContext.getInt("appid") > 0)) {
                  continue;
                }
                paramContext = (ViewGroup)this.a.jdField_a_of_type_ArrayOfAndroidViewView[28];
                paramContext.setVisibility(8);
                paramContext.removeAllViews();
                ThreadManager.post(new ChatSettingForTroop.4.2(this, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), 5, null, false);
                return;
              }
              catch (JSONException paramContext)
              {
                QLog.e("Q.chatopttroop", 1, "parse bind game event error", paramContext);
                return;
              }
              if ("start_recomend_page".equals(paramContext))
              {
                this.a.finish();
                return;
              }
              if (("com.tencent.mobileqq.actoino.ACTIONO_DEL_TROOP_MEMBER".equals(paramContext)) && (this.a.e != null))
              {
                localObject1 = paramIntent.getStringExtra("troopUin");
                paramContext = paramIntent.getStringArrayListExtra("delMemberUins");
                if ((localObject1 != null) && (((String)localObject1).equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) && (paramContext != null))
                {
                  paramIntent = new HashSet();
                  localObject1 = paramContext.iterator();
                  while (((Iterator)localObject1).hasNext())
                  {
                    str = (String)((Iterator)localObject1).next();
                    localObject2 = this.a.e.iterator();
                    while (((Iterator)localObject2).hasNext())
                    {
                      localObject3 = (oidb_0x899.memberlist)((Iterator)localObject2).next();
                      if (str.equals(((oidb_0x899.memberlist)localObject3).uint64_member_uin.get() + "")) {
                        paramIntent.add(localObject3);
                      }
                    }
                  }
                  paramIntent = paramIntent.iterator();
                  while (paramIntent.hasNext())
                  {
                    localObject1 = (oidb_0x899.memberlist)paramIntent.next();
                    this.a.e.remove(localObject1);
                  }
                  paramIntent = new ArrayList();
                  localObject1 = this.a.e.iterator();
                  while (((Iterator)localObject1).hasNext()) {
                    paramIntent.add(String.valueOf(((oidb_0x899.memberlist)((Iterator)localObject1).next()).uint64_member_uin.get()));
                  }
                  if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.chatopttroop", 2, "onReceive wMemberNumClient:" + this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNumClient + "  wMemberNum:" + this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum + " delMembers.size():" + paramContext.size() + " troopUin:" + this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
                    }
                    localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
                    ((TroopInfo)localObject1).wMemberNumClient -= paramContext.size();
                  }
                  paramContext = bfup.a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, paramIntent);
                  if (!TextUtils.isEmpty(paramContext)) {
                    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.memberListToShow = paramContext;
                  }
                  this.a.a(this.a.e);
                  return;
                }
              }
            }
          }
        }
        catch (JSONException paramContext) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxj
 * JD-Core Version:    0.7.0.1
 */