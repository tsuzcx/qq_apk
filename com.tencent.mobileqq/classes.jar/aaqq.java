import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.biz.webviewplugin.NewerGuidePlugin.PhoneInfo;
import com.tencent.biz.webviewplugin.NewerGuidePlugin.RecommendedListResp;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class aaqq
  extends ascz
{
  public aaqq(NewerGuidePlugin paramNewerGuidePlugin) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == NewerGuidePlugin.a(this.a).key) && ("ipc_newer_guide".equals(paramBundle.getString("cmd")))) {}
    for (;;)
    {
      Object localObject3;
      int i;
      Object localObject4;
      Object localObject5;
      try
      {
        localObject3 = paramBundle.getBundle("request");
        ((Bundle)localObject3).setClassLoader(NewerGuidePlugin.RecommendedListResp.class.getClassLoader());
        paramBundle = ((Bundle)localObject3).getString("key_action");
        if (QLog.isColorLevel()) {
          QLog.d("NewerGuidePlugin", 2, "onResponse action=" + paramBundle);
        }
        if ("uploadContacts".equals(paramBundle))
        {
          paramBundle = new JSONObject();
          paramBundle.put("result", ((Bundle)localObject3).getInt("result"));
          this.a.callJs("respUploadContacts", new String[] { paramBundle.toString() });
          paramBundle = null;
          if ((paramBundle == null) || (localObject1 == null)) {
            break label1139;
          }
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("uin", paramBundle);
          ((JSONObject)localObject2).put("result", 0);
          this.a.callJs((String)localObject1, new String[] { ((JSONObject)localObject2).toString() });
          return;
        }
        if ("getRecommendedList".equals(paramBundle))
        {
          paramBundle = new JSONObject();
          localObject2 = ((Bundle)localObject3).getString("op_result");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            paramBundle.put("result", new JSONArray((String)localObject2));
          }
          this.a.callJs("respRecommend", new String[] { paramBundle.toString() });
          paramBundle = null;
          continue;
        }
        if (!"getRecommendedListNew".equals(paramBundle)) {
          break label552;
        }
        localObject2 = (NewerGuidePlugin.RecommendedListResp)((Bundle)localObject3).getParcelable("result");
        if (localObject2 == null)
        {
          i = -1;
          paramBundle = new JSONObject();
          paramBundle.put("result", i);
          if (i != 0) {
            break label522;
          }
          paramBundle.put("uint32_end", ((NewerGuidePlugin.RecommendedListResp)localObject2).b);
          paramBundle.put("uint32_next_index", ((NewerGuidePlugin.RecommendedListResp)localObject2).jdField_a_of_type_Long);
          localObject4 = ((NewerGuidePlugin.RecommendedListResp)localObject2).jdField_a_of_type_JavaUtilList;
          if ((localObject4 == null) || (((List)localObject4).isEmpty())) {
            break label522;
          }
          localObject2 = new JSONArray();
          localObject4 = ((List)localObject4).iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label513;
          }
          localObject5 = (NewerGuidePlugin.PhoneInfo)((Iterator)localObject4).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("str_phone", ((NewerGuidePlugin.PhoneInfo)localObject5).a);
          localJSONObject.put("str_nick", ((NewerGuidePlugin.PhoneInfo)localObject5).b);
          localJSONObject.put("str_long_nick", ((NewerGuidePlugin.PhoneInfo)localObject5).c);
          localJSONObject.put("str_head_url", ((NewerGuidePlugin.PhoneInfo)localObject5).d);
          ((JSONArray)localObject2).put(localJSONObject);
          continue;
        }
        i = ((NewerGuidePlugin.RecommendedListResp)localObject2).jdField_a_of_type_Int;
      }
      catch (Exception paramBundle)
      {
        QLog.d("NewerGuidePlugin", 1, "mOnRemoteResp fail", paramBundle);
        return;
      }
      continue;
      label513:
      paramBundle.put("phoneAddrBook", localObject2);
      label522:
      this.a.callJs(((Bundle)localObject3).getString("callback"), new String[] { paramBundle.toString() });
      paramBundle = null;
      continue;
      label552:
      if ("sayHi".equals(paramBundle))
      {
        paramBundle = ((Bundle)localObject3).getString("uin");
        localObject1 = ((Bundle)localObject3).getByteArray("sig");
        localObject4 = ((Bundle)localObject3).getString("nick");
        localObject3 = ((Bundle)localObject3).getString("tinyId");
        if ((!TextUtils.isEmpty(paramBundle)) && (localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject4)))
        {
          localObject5 = new Intent(this.a.mRuntime.a(), ChatActivity.class);
          ((Intent)localObject5).addFlags(67108864);
          ((Intent)localObject5).putExtra("uin", paramBundle);
          ((Intent)localObject5).putExtra("uintype", 1001);
          ((Intent)localObject5).putExtra("aio_msg_source", 999);
          ((Intent)localObject5).putExtra("rich_accost_sig", (byte[])localObject1);
          ((Intent)localObject5).putExtra("uinname", (String)localObject4);
          ((Intent)localObject5).putExtra("from_newer_guide", true);
          ((Intent)localObject5).putExtra("tinyId", (String)localObject3);
          this.a.startActivityForResult((Intent)localObject5, (byte)8);
          paramBundle = null;
          localObject1 = localObject2;
        }
        else
        {
          localObject1 = String.valueOf(localObject3);
          paramBundle = "respSayHi";
        }
      }
      else
      {
        if ("joinTroop".equals(paramBundle))
        {
          paramBundle = ((Bundle)localObject3).getString("uin");
          localObject2 = ((Bundle)localObject3).getString("name");
          short s = ((Bundle)localObject3).getShort("option");
          localObject4 = ((Bundle)localObject3).getString("question");
          localObject5 = ((Bundle)localObject3).getString("answer");
          localObject3 = ((Bundle)localObject3).getString("authSig");
          if (s == 0) {
            break label1153;
          }
          paramBundle = AddFriendLogicActivity.a(this.a.mRuntime.a(), paramBundle, (String)localObject2, s, 1, (String)localObject4, (String)localObject5, null, null, (String)localObject3);
          paramBundle.putExtra("from_newer_guide", true);
          this.a.startActivityForResult(paramBundle, (byte)6);
          paramBundle = null;
          continue;
        }
        if ("joinTroopByTap".equals(paramBundle))
        {
          i = ((Bundle)localObject3).getInt("result");
          paramBundle = ((Bundle)localObject3).getString("uin");
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("uin", paramBundle);
          ((JSONObject)localObject2).put("result", i);
          this.a.callJs("respTroopByTap", new String[] { ((JSONObject)localObject2).toString() });
          paramBundle = null;
          continue;
        }
        if ("followPublicAccount".equals(paramBundle))
        {
          i = ((Bundle)localObject3).getInt("result");
          paramBundle = ((Bundle)localObject3).getString("uin");
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("uin", paramBundle);
          ((JSONObject)localObject2).put("result", i);
          this.a.callJs("respFollow", new String[] { ((JSONObject)localObject2).toString() });
          paramBundle = null;
          continue;
        }
        if (!"setAvatar".equals(paramBundle)) {
          break label1161;
        }
        if (((Bundle)localObject3).getInt("result") == 1)
        {
          paramBundle = ((Bundle)localObject3).getString("path");
          NewerGuidePlugin.a(this.a, true, paramBundle);
        }
        while (NewerGuidePlugin.a(this.a) != null)
        {
          NewerGuidePlugin.a(this.a).dismiss();
          break;
          paramBundle = this.a.mRuntime.a();
          i = paramBundle.getResources().getDimensionPixelSize(2131299080);
          QQToast.a(paramBundle, 1, anvx.a(2131706900), 0).b(i);
        }
        label1139:
        return;
      }
      localObject2 = paramBundle;
      paramBundle = (Bundle)localObject1;
      localObject1 = localObject2;
      continue;
      label1153:
      localObject1 = "respTroop";
      continue;
      label1161:
      paramBundle = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqq
 * JD-Core Version:    0.7.0.1
 */