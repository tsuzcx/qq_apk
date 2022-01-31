import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.sdk.CmShowSpriteDrawerInfoBridge.2;
import com.tencent.mobileqq.apollo.sdk.CmShowSpriteDrawerInfoBridge.3;
import com.tencent.mobileqq.apollo.sdk.CmShowSpriteDrawerInfoBridge.5;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class alch
  implements albk
{
  private albn jdField_a_of_type_Albn;
  private alcg jdField_a_of_type_Alcg;
  private alcm jdField_a_of_type_Alcm;
  private alcn jdField_a_of_type_Alcn;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public alch(alcg paramalcg, albn paramalbn, alcm paramalcm, alcn paramalcn)
  {
    this.jdField_a_of_type_Alcg = paramalcg;
    this.jdField_a_of_type_Albn = paramalbn;
    this.jdField_a_of_type_Alcm = paramalcm;
    this.jdField_a_of_type_Alcn = paramalcn;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Alcg == null) {}
    while (this.jdField_a_of_type_Alcn.a(paramInt1, paramInt2) == null) {
      return false;
    }
    return true;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("taskId", paramInt2);
      ((JSONObject)localObject).put("actionId", paramInt1);
      ((JSONObject)localObject).put("stopAll", 1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopAction('").append(((JSONObject)localObject).toString()).append("');");
      localObject = this.jdField_a_of_type_Alcn.a(100);
      if (localObject == null)
      {
        QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "actionScript == null.");
        return;
      }
      ((alce)localObject).a(localStringBuilder.toString());
      this.jdField_a_of_type_Albn.a(paramInt2);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CmShow_SpriteDrawerInfoBridge", 1, "showBubble e:" + localThrowable);
    }
  }
  
  public void a(alcg paramalcg, int paramInt, alby paramalby, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteDrawerInfoBridge", 2, "[initSprite]");
    }
    alhp.a(paramalcg.a());
    alhp.a(paramalcg.a(), 300);
    if ((this.jdField_a_of_type_Alcm == null) || (paramalcg == null) || (!paramalcg.a())) {
      if (paramalcg != null) {
        alhp.a(paramalcg.a(), 300, 160, new Object[] { "glview is not ready" });
      }
    }
    do
    {
      return;
      if (a(100, -1)) {
        break;
      }
      QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "[initSprite], fail to load script.");
      if (paramalcg.jdField_e_of_type_Int == 1) {
        ThreadManager.getUIHandler().post(new CmShowSpriteDrawerInfoBridge.5(this, paramalcg));
      }
    } while (paramalcg == null);
    alhp.a(paramalcg.a(), 300, 200, new Object[] { "script no exit" });
    return;
    Bundle localBundle = new Bundle();
    IPCSpriteContext localIPCSpriteContext = paramalcg.a();
    if (paramBundle != null)
    {
      localIPCSpriteContext.d = paramBundle.getInt("SelfRotate");
      localIPCSpriteContext.jdField_e_of_type_Int = paramBundle.getInt("FriendRotate");
      QLog.i("CmShow_SpriteDrawerInfoBridge", 1, "mSelfRotate:" + localIPCSpriteContext.d + " mFriendRotate:" + localIPCSpriteContext.jdField_e_of_type_Int);
      if (!TextUtils.isEmpty(paramalcg.jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramalcg.jdField_b_of_type_JavaLangString, Integer.valueOf(localIPCSpriteContext.d));
      }
      if (!TextUtils.isEmpty(paramalcg.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramalcg.jdField_a_of_type_JavaLangString, Integer.valueOf(localIPCSpriteContext.jdField_e_of_type_Int));
      }
    }
    localBundle.putParcelable("IPCSpriteContext", localIPCSpriteContext);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_render_view_get_initavatar_js", localBundle, new alck(this, paramalby, paramInt, paramalcg));
  }
  
  public void a(alcg paramalcg, CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    int i = 1;
    if ((paramalcg == null) || (paramPlayActionConfig == null)) {
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = albt.a(paramPlayActionConfig);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      QLog.i("CmShow_SpriteDrawerInfoBridge", 1, "playAction cacheActionJs:" + (String)localObject1);
      localObject2 = new SpriteTaskParam();
      ((SpriteTaskParam)localObject2).f = paramPlayActionConfig.jdField_a_of_type_Int;
      ((SpriteTaskParam)localObject2).jdField_e_of_type_Int = 1;
      ((SpriteTaskParam)localObject2).h = 0;
      ((SpriteTaskParam)localObject2).g = 6;
      ((SpriteTaskParam)localObject2).jdField_a_of_type_Boolean = true;
      if ((!TextUtils.isEmpty(paramalcg.jdField_b_of_type_JavaLangString)) && (!paramalcg.jdField_b_of_type_JavaLangString.equals(paramPlayActionConfig.jdField_a_of_type_JavaLangString)))
      {
        ((SpriteTaskParam)localObject2).jdField_b_of_type_JavaLangString = paramalcg.jdField_b_of_type_JavaLangString;
        ((SpriteTaskParam)localObject2).jdField_a_of_type_JavaLangString = paramalcg.jdField_a_of_type_JavaLangString;
        ((SpriteTaskParam)localObject2).jdField_a_of_type_Int = paramPlayActionConfig.jdField_b_of_type_Int;
        ((SpriteTaskParam)localObject2).l = paramPlayActionConfig.jdField_c_of_type_Int;
        ((SpriteTaskParam)localObject2).jdField_e_of_type_JavaLangString = ((String)localObject1);
        if (!paramPlayActionConfig.jdField_a_of_type_Boolean) {
          break label222;
        }
      }
      for (;;)
      {
        ((SpriteTaskParam)localObject2).m = i;
        ((SpriteTaskParam)localObject2).jdField_a_of_type_Albk = this;
        ((SpriteTaskParam)localObject2).jdField_a_of_type_AndroidOsBundle = paramPlayActionConfig.jdField_a_of_type_AndroidOsBundle;
        a((SpriteTaskParam)localObject2);
        return;
        ((SpriteTaskParam)localObject2).jdField_b_of_type_JavaLangString = paramalcg.jdField_a_of_type_JavaLangString;
        ((SpriteTaskParam)localObject2).jdField_a_of_type_JavaLangString = paramalcg.jdField_b_of_type_JavaLangString;
        break;
        label222:
        i = 0;
      }
    }
    localObject1 = new Bundle();
    Object localObject2 = paramalcg.a();
    if ((!TextUtils.isEmpty(paramalcg.jdField_b_of_type_JavaLangString)) && (!paramalcg.jdField_b_of_type_JavaLangString.equals(paramPlayActionConfig.jdField_a_of_type_JavaLangString)))
    {
      ((IPCSpriteContext)localObject2).jdField_a_of_type_JavaLangString = ((IPCSpriteContext)localObject2).jdField_b_of_type_JavaLangString;
      ((IPCSpriteContext)localObject2).jdField_b_of_type_JavaLangString = paramPlayActionConfig.jdField_a_of_type_JavaLangString;
    }
    ((Bundle)localObject1).putParcelable("IPCSpriteContext", (Parcelable)localObject2);
    ((Bundle)localObject1).putParcelable("PlayActionConfig", paramPlayActionConfig);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_render_view_play_action", (Bundle)localObject1, new alci(this, l, paramPlayActionConfig));
  }
  
  public void a(alcg paramalcg, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteDrawerInfoBridge", 2, "[initSprite]");
    }
    if ((this.jdField_a_of_type_Alcm == null) || (paramalcg == null) || (!paramalcg.a())) {
      if (paramalcg != null) {
        alhp.a(paramalcg.a(), 300, 160, new Object[] { "glview is not ready" });
      }
    }
    do
    {
      return;
      if (a(100, -1)) {
        break;
      }
      QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "[checkfDressChanged], fail to load script.");
    } while (paramalcg.jdField_e_of_type_Int != 1);
    ThreadManager.getUIHandler().post(new CmShowSpriteDrawerInfoBridge.3(this, paramalcg));
    return;
    Bundle localBundle = new Bundle();
    IPCSpriteContext localIPCSpriteContext = paramalcg.a();
    String str1 = localIPCSpriteContext.jdField_b_of_type_JavaLangString;
    String str2 = localIPCSpriteContext.jdField_a_of_type_JavaLangString;
    Integer localInteger;
    if (!TextUtils.isEmpty(paramString2))
    {
      localInteger = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2);
      if (localInteger != null) {
        localIPCSpriteContext.jdField_e_of_type_Int = localInteger.intValue();
      }
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      localInteger = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
      if (localInteger != null) {
        localIPCSpriteContext.d = localInteger.intValue();
      }
    }
    localIPCSpriteContext.jdField_a_of_type_JavaLangString = paramString2;
    localIPCSpriteContext.jdField_b_of_type_JavaLangString = paramString1;
    localBundle.putParcelable("IPCSpriteContext", localIPCSpriteContext);
    localIPCSpriteContext.jdField_a_of_type_JavaLangString = str2;
    localIPCSpriteContext.jdField_b_of_type_JavaLangString = str1;
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_render_view_get_initavatar_js", localBundle, new alcj(this, paramalcg));
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return;
    }
    ThreadManager.excute(new CmShowSpriteDrawerInfoBridge.2(this, paramSpriteTaskParam), 192, null, true);
  }
  
  public void a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("uin", paramString);
      paramString = new StringBuilder();
      paramString.append("removeBubbleAccessory('").append(((JSONObject)localObject).toString()).append("');");
      localObject = this.jdField_a_of_type_Alcn.a(100);
      if (localObject == null)
      {
        QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "actionScript == null.");
        return;
      }
      ((alce)localObject).a(paramString.toString());
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteDrawerInfoBridge", 1, "showBubble e:" + paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("uin", paramString);
        if (paramInt == 1)
        {
          localObject1 = "2D";
          ((JSONObject)localObject2).put("model", localObject1);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("changeSpriteModel('").append(((JSONObject)localObject2).toString()).append("');");
          localObject2 = this.jdField_a_of_type_Alcn.a(100);
          if (localObject2 == null)
          {
            QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "actionScript == null.");
            return;
          }
          ((alce)localObject2).a(((StringBuilder)localObject1).toString());
          albt.a(paramString, paramInt);
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("CmShow_SpriteDrawerInfoBridge", 1, "changeSpriteModel e:" + paramString);
        return;
      }
      Object localObject1 = "3D";
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt3));
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("uin", paramString);
      ((JSONObject)localObject).put("xPos", paramInt1);
      ((JSONObject)localObject).put("yPos", paramInt2);
      ((JSONObject)localObject).put("rotate", paramInt3);
      paramString = new StringBuilder();
      paramString.append("updateSpriteParam('").append(((JSONObject)localObject).toString()).append("');");
      localObject = this.jdField_a_of_type_Alcn.a(100);
      if (localObject == null)
      {
        QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "actionScript == null.");
        return;
      }
      ((alce)localObject).a(paramString.toString());
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteDrawerInfoBridge", 1, "updateAvatarParam e:" + paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("uin", paramString1);
        localJSONObject.put("text", albi.a(bdfr.encodeToString(paramString2.getBytes("utf-8"), 0)));
        localJSONObject.put("direction", paramInt1);
        paramString1 = "";
        if (paramInt2 != 1) {
          break label408;
        }
        Object localObject = albb.a(paramString2, 1);
        if (QLog.isColorLevel()) {
          QLog.d("CmShow_SpriteDrawerInfoBridge", 2, new Object[] { "showBubble, 2d bubbleInfo=", localObject });
        }
        if (localObject == null) {
          break label408;
        }
        paramString1 = (String)((Pair)localObject).first;
        paramInt1 = ((Integer)((Pair)localObject).second).intValue();
        localObject = paramString1;
        if (TextUtils.isEmpty(paramString1))
        {
          ApolloUtil.b("本地无qzone气泡资源，请检查配置是否ok");
          localObject = albb.a(paramString2, 0, 1);
        }
        localJSONObject.put("bubblePath2D", localObject);
        if (paramInt1 != -1) {
          localJSONObject.put("bubbleId2D", paramInt1);
        }
        paramString1 = "";
        if (paramInt2 == 1)
        {
          localObject = albb.a(paramString2, 2);
          if (QLog.isColorLevel()) {
            QLog.d("CmShow_SpriteDrawerInfoBridge", 2, new Object[] { "showBubble, 3d bubbleInfo=", localObject });
          }
          if (localObject != null)
          {
            paramString1 = (String)((Pair)localObject).first;
            paramInt1 = ((Integer)((Pair)localObject).second).intValue();
            localObject = paramString1;
            if (TextUtils.isEmpty(paramString1)) {
              localObject = albb.a(paramString2, 0, 2);
            }
            localJSONObject.put("bubblePath3D", localObject);
            if (paramInt1 != -1) {
              localJSONObject.put("bubbleId3D", paramInt1);
            }
            paramString1 = new StringBuilder();
            paramString1.append("setBubbleAccessory('").append(localJSONObject.toString()).append("');");
            paramString2 = this.jdField_a_of_type_Alcn.a(100);
            if (paramString2 == null)
            {
              QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "actionScript == null.");
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("CmShow_SpriteDrawerInfoBridge", 2, new Object[] { "showBubble, script=", paramString1.toString() });
            }
            paramString2.a(paramString1.toString());
            return;
          }
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("CmShow_SpriteDrawerInfoBridge", 1, "showBubble e:" + paramString1);
        return;
      }
      paramInt1 = -1;
      continue;
      label408:
      paramInt1 = -1;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("uin", paramString);
        if (paramBoolean)
        {
          i = 1;
          ((JSONObject)localObject).put("showOrHide", i);
          paramString = new StringBuilder();
          paramString.append("showOrHideSprite('").append(((JSONObject)localObject).toString()).append("');");
          localObject = this.jdField_a_of_type_Alcn.a(100);
          if (localObject == null)
          {
            QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "actionScript == null.");
            return;
          }
          ((alce)localObject).a(paramString.toString());
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("CmShow_SpriteDrawerInfoBridge", 1, "showOrHideAvatar e:" + paramString);
        return;
      }
      int i = 2;
    }
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    Object localObject;
    try
    {
      localObject = new JSONObject();
      if (paramList == null) {
        break label172;
      }
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localJSONArray.put((String)paramList.next());
      }
      ((JSONObject)localObject).put("uins", localJSONArray);
    }
    catch (Throwable paramList)
    {
      QLog.e("CmShow_SpriteDrawerInfoBridge", 1, "clearAvatar e:" + paramList);
      return;
    }
    for (;;)
    {
      int i;
      ((JSONObject)localObject).put("isClearAll", i);
      paramList = new StringBuilder();
      paramList.append("clearSprite('").append(((JSONObject)localObject).toString()).append("');");
      localObject = this.jdField_a_of_type_Alcn.a(100);
      if (localObject == null)
      {
        QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "actionScript == null.");
        return;
      }
      ((alce)localObject).a(paramList.toString());
      return;
      label172:
      if (paramBoolean) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public void b(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_Alcm == null) || (this.jdField_a_of_type_Alcg == null) || (!this.jdField_a_of_type_Alcg.a())) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_Alcm;
    alcm.a(paramSpriteTaskParam);
    localObject1 = "";
    if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_e_of_type_JavaLangString)) {
      localObject1 = paramSpriteTaskParam.jdField_e_of_type_JavaLangString;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramSpriteTaskParam.jdField_b_of_type_Int = 4;
      return;
    }
    Object localObject3 = this.jdField_a_of_type_Alcn.a(paramSpriteTaskParam.jdField_c_of_type_Int);
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      QLog.i("CmShow_SpriteDrawerInfoBridge", 1, "playAction CmShow_ get sdk basic script");
      localObject3 = this.jdField_a_of_type_Alcn.a(100);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        QLog.w("CmShow_SpriteDrawerInfoBridge", 1, "actionScript == null.");
        paramSpriteTaskParam.jdField_b_of_type_Int = 4;
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteDrawerInfoBridge", 2, new Object[] { "[playAction], ready to play, actionId:", Integer.valueOf(paramSpriteTaskParam.f) });
    }
    paramSpriteTaskParam.jdField_b_of_type_Int = 2;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("playAction('").append((String)localObject1).append("');");
    localObject2.a(((StringBuilder)localObject3).toString());
    localObject2.a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, false);
    localObject2.a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, false);
    localObject1 = ApolloUtil.a();
    if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)) {}
    for (boolean bool = true;; bool = false)
    {
      algj.a((QQAppInterface)localObject1, paramSpriteTaskParam, bool, paramSpriteTaskParam.jdField_b_of_type_Boolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alch
 * JD-Core Version:    0.7.0.1
 */