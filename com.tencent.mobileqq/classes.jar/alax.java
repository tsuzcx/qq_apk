import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.script.SpriteBridge.1;
import com.tencent.mobileqq.apollo.script.SpriteBridge.2;
import com.tencent.mobileqq.apollo.script.SpriteBridge.3;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class alax
  implements albk
{
  private alba jdField_a_of_type_Alba;
  private albb jdField_a_of_type_Albb;
  private albn jdField_a_of_type_Albn;
  private String jdField_a_of_type_JavaLangString;
  private CopyOnWriteArrayList<WeakReference<albm>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  
  public alax(alba paramalba, albn paramalbn, albb paramalbb)
  {
    this.jdField_a_of_type_Alba = paramalba;
    this.jdField_a_of_type_Albn = paramalbn;
    this.jdField_a_of_type_Albb = paramalbb;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  private String a()
  {
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.jdField_a_of_type_Int = 0;
    localSpriteTaskParam.f = 4;
    localSpriteTaskParam.k = 2;
    localSpriteTaskParam.g = 5;
    localSpriteTaskParam.jdField_a_of_type_Long = 1000000L;
    return this.jdField_a_of_type_Albb.a(localSpriteTaskParam);
  }
  
  private String a(SpriteTaskParam paramSpriteTaskParam)
  {
    Object localObject;
    if (paramSpriteTaskParam == null) {
      localObject = a();
    }
    String str;
    do
    {
      return localObject;
      if (!a(paramSpriteTaskParam.jdField_c_of_type_Int, paramSpriteTaskParam.f))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 1, "[playAction], fail to load script.");
        paramSpriteTaskParam.jdField_b_of_type_Int = 4;
        return a();
      }
      str = this.jdField_a_of_type_Albb.a(paramSpriteTaskParam);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    paramSpriteTaskParam.jdField_b_of_type_Int = 4;
    return a();
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2;
    if ((this.jdField_a_of_type_Alba == null) || (this.jdField_a_of_type_Alba.b == null))
    {
      bool2 = false;
      return bool2;
    }
    Object localObject1 = (QQAppInterface)this.jdField_a_of_type_Alba.b.get();
    if (localObject1 != null)
    {
      Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("apollo_action_random", 0);
      localObject1 = String.valueOf(paramInt);
      if (((SharedPreferences)localObject2).getInt((String)localObject1, -1) > 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1) {
          break;
        }
        localObject2 = ((SharedPreferences)localObject2).edit();
        ((SharedPreferences.Editor)localObject2).putInt((String)localObject1, paramInt);
        ((SharedPreferences.Editor)localObject2).commit();
        return bool1;
      }
    }
    return false;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Alba == null) || (this.jdField_a_of_type_Alba.a() == null)) {
      return false;
    }
    return ((albf)this.jdField_a_of_type_Alba.a().getManager(249)).a().a(paramInt1, paramInt2) != null;
  }
  
  private void c()
  {
    ThreadManager.getUIHandler().post(new SpriteBridge.3(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Albb.a();
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        albm localalbm = (albm)((WeakReference)localIterator.next()).get();
        if (localalbm != null) {
          localalbm.a(paramInt);
        }
      }
    }
  }
  
  public void a(int paramInt, MessageForApollo paramMessageForApollo)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, new Object[] { "[buildSpriteTask], from:", Integer.valueOf(paramInt) });
    }
    if ((paramMessageForApollo == null) || (this.jdField_a_of_type_Alba == null) || (this.jdField_a_of_type_Albn == null)) {
      break label48;
    }
    label48:
    while (!albi.b(this.jdField_a_of_type_Alba.a(), paramMessageForApollo.istroop, paramMessageForApollo.frienduin)) {
      return;
    }
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = ApolloUtil.a(this.jdField_a_of_type_Alba.a(), paramMessageForApollo);
    localSpriteTaskParam.jdField_c_of_type_Int = ApolloUtil.b(this.jdField_a_of_type_Alba.a(), paramMessageForApollo);
    localSpriteTaskParam.h = paramMessageForApollo.istroop;
    localSpriteTaskParam.g = paramInt;
    localSpriteTaskParam.jdField_a_of_type_Boolean = paramMessageForApollo.isSend();
    localSpriteTaskParam.jdField_a_of_type_Long = paramMessageForApollo.uniseq;
    localSpriteTaskParam.i = paramMessageForApollo.audioId;
    localSpriteTaskParam.jdField_a_of_type_Float = paramMessageForApollo.audioStartTime;
    if (paramMessageForApollo.isDoubleAction()) {
      i = 1;
    }
    localSpriteTaskParam.e = i;
    localSpriteTaskParam.jdField_c_of_type_JavaLangString = paramMessageForApollo.inputText;
    localSpriteTaskParam.jdField_b_of_type_Boolean = paramMessageForApollo.isBarrageMode();
    localSpriteTaskParam.jdField_d_of_type_JavaLangString = paramMessageForApollo.extendJson;
    if (localSpriteTaskParam.h == 0) {
      if (paramMessageForApollo.isSend())
      {
        localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramMessageForApollo.selfuin;
        localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramMessageForApollo.frienduin;
      }
    }
    for (;;)
    {
      a(localSpriteTaskParam);
      if (paramInt != 2) {
        break;
      }
      albi.a(this.jdField_a_of_type_Alba.a(), localSpriteTaskParam);
      return;
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramMessageForApollo.frienduin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramMessageForApollo.selfuin;
      continue;
      if ((localSpriteTaskParam.h == 1) || (localSpriteTaskParam.h == 3000))
      {
        localSpriteTaskParam.jdField_b_of_type_JavaLangString = Long.toString(paramMessageForApollo.mApolloMessage.peer_uin);
        localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramMessageForApollo.senderuin;
      }
    }
  }
  
  public void a(alba paramalba)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, "[initSprite]");
    }
    int i = albi.b(0);
    if ((this.jdField_a_of_type_Albb == null) || (paramalba == null) || (!paramalba.c())) {
      alhp.a(i, 300, 160, new Object[] { "glview is not ready" });
    }
    String str;
    alar localalar;
    do
    {
      do
      {
        return;
      } while (!a(0, -1));
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        str = this.jdField_a_of_type_Albb.a();
        QLog.d("CmShowStatUtil", 1, "get spriteJs");
      }
      while (TextUtils.isEmpty(str))
      {
        alhp.a(i, 300, 301, new Object[] { "spriteJs is empty" });
        return;
        str = this.jdField_a_of_type_JavaLangString;
        QLog.d("CmShowStatUtil", 1, "spriteJs from cache");
        this.jdField_a_of_type_JavaLangString = null;
      }
      localalar = albi.a(paramalba.a());
    } while (localalar == null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initSprite('").append(str).append("');");
    alhp.a(i, 350);
    QLog.d("cmshow_scripted_SpriteBridge", 1, "TraceReport CmShowStatUtil commitJS:(initSprite )");
    localalar.a(localStringBuilder.toString());
    ThreadManager.executeOnSubThread(new SpriteBridge.2(this, localalar, paramalba));
  }
  
  public void a(albm paramalbm)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(paramalbm));
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return;
    }
    ThreadManager.excute(new SpriteBridge.1(this, paramSpriteTaskParam), 192, null, true);
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt)
  {
    if ((paramChatMessage == null) || (this.jdField_a_of_type_Alba == null) || (this.jdField_a_of_type_Albn == null)) {}
    while (!albi.b(this.jdField_a_of_type_Alba.a(), paramChatMessage.istroop, paramChatMessage.frienduin)) {
      return;
    }
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = paramInt;
    ApolloActionData localApolloActionData = albi.a(this.jdField_a_of_type_Alba.a(), paramInt);
    if (localApolloActionData != null)
    {
      localSpriteTaskParam.jdField_c_of_type_Int = localApolloActionData.actionType;
      localSpriteTaskParam.e = localApolloActionData.personNum;
    }
    localSpriteTaskParam.h = paramChatMessage.istroop;
    if (paramChatMessage.isSend())
    {
      localSpriteTaskParam.g = 0;
      localSpriteTaskParam.jdField_a_of_type_Boolean = paramChatMessage.isSend();
      localSpriteTaskParam.jdField_a_of_type_Long = paramChatMessage.uniseq;
      if (localSpriteTaskParam.h != 0) {
        break label188;
      }
      if (!paramChatMessage.isSend()) {
        break label169;
      }
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.selfuin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramChatMessage.frienduin;
    }
    for (;;)
    {
      a(localSpriteTaskParam);
      return;
      localSpriteTaskParam.g = 1;
      break;
      label169:
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramChatMessage.selfuin;
      continue;
      label188:
      if ((localSpriteTaskParam.h == 1) || (localSpriteTaskParam.h == 3000)) {
        localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.senderuin;
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage, ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, "[buildSpriteTask]");
    }
    if ((paramChatMessage == null) || (this.jdField_a_of_type_Alba == null) || (this.jdField_a_of_type_Albn == null) || (paramArrayList1 == null) || (paramArrayList1.size() == 0)) {}
    while (!albi.b(this.jdField_a_of_type_Alba.a(), paramChatMessage.istroop, paramChatMessage.frienduin)) {
      return;
    }
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = ((Integer)paramArrayList1.get(0)).intValue();
    localSpriteTaskParam.jdField_d_of_type_Int = 1;
    localSpriteTaskParam.jdField_a_of_type_JavaUtilArrayList = paramArrayList1;
    localSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList = paramArrayList2;
    localSpriteTaskParam.jdField_c_of_type_Int = 1;
    localSpriteTaskParam.h = paramChatMessage.istroop;
    if (paramChatMessage.isSend())
    {
      localSpriteTaskParam.g = 0;
      localSpriteTaskParam.jdField_a_of_type_Boolean = paramChatMessage.isSend();
      localSpriteTaskParam.jdField_a_of_type_Long = paramChatMessage.uniseq;
      if (localSpriteTaskParam.h != 0) {
        break label225;
      }
      if (!paramChatMessage.isSend()) {
        break label204;
      }
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.selfuin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramChatMessage.frienduin;
    }
    for (;;)
    {
      a(localSpriteTaskParam);
      return;
      localSpriteTaskParam.g = 1;
      break;
      label204:
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramChatMessage.selfuin;
      continue;
      label225:
      if ((localSpriteTaskParam.h == 1) || (localSpriteTaskParam.h == 3000)) {
        localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.senderuin;
      }
    }
  }
  
  public void a(MessageForApollo paramMessageForApollo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, new Object[] { "[sendMsg], msg:", paramMessageForApollo });
    }
    try
    {
      if (!a(paramMessageForApollo.actionType, paramMessageForApollo.mApolloMessage.id))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 1, "[sendMsg], fail to load script, actionType:" + paramMessageForApollo.actionType);
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("id", paramMessageForApollo.mApolloMessage.id);
      if (paramMessageForApollo.mApolloMessage.name != null) {
        ((JSONObject)localObject).put("name", albi.a(bdfr.encodeToString(paramMessageForApollo.mApolloMessage.name, 0)));
      }
      if (paramMessageForApollo.mApolloMessage.text != null) {
        ((JSONObject)localObject).put("atText", albi.a(bdfr.encodeToString(paramMessageForApollo.mApolloMessage.text, 0)));
      }
      ((JSONObject)localObject).put("peerUin", paramMessageForApollo.mApolloMessage.peer_uin);
      if (!TextUtils.isEmpty(paramMessageForApollo.mApolloMessage.extStr)) {
        ((JSONObject)localObject).put("extraStr", new JSONObject(paramMessageForApollo.mApolloMessage.extStr));
      }
      ApolloMessage localApolloMessage = paramMessageForApollo.mApolloMessage;
      localApolloMessage.flag |= 0x200;
      ((JSONObject)localObject).put("model", ApolloActionData.getModelString(paramMessageForApollo.mApolloMessage.id));
      ((JSONObject)localObject).put("flag", paramMessageForApollo.mApolloMessage.flag);
      ((JSONObject)localObject).put("senderTS", paramMessageForApollo.mApolloMessage.sender_ts);
      ((JSONObject)localObject).put("peerTS", paramMessageForApollo.mApolloMessage.peer_ts);
      ((JSONObject)localObject).put("senderStatus", paramMessageForApollo.mApolloMessage.sender_status);
      ((JSONObject)localObject).put("peerStatus", paramMessageForApollo.mApolloMessage.peer_status);
      if (8 == paramMessageForApollo.actionType)
      {
        ((JSONObject)localObject).put("actionRootPath", "" + paramMessageForApollo.mApolloMessage.id);
        ((JSONObject)localObject).put("isSend", a(paramMessageForApollo.mApolloMessage.id));
      }
      localJSONObject.put("type", paramMessageForApollo.actionType);
      localJSONObject.put("basicMsg", localObject);
      paramMessageForApollo = albi.a(this.jdField_a_of_type_Alba.a());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendMsg").append("('").append(localJSONObject.toString()).append("');");
      if (paramMessageForApollo != null)
      {
        paramMessageForApollo.a(((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Throwable paramMessageForApollo)
    {
      QLog.e("cmshow_scripted_SpriteBridge", 1, paramMessageForApollo, new Object[0]);
    }
  }
  
  public void a(List<SpriteTaskParam> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (this.jdField_a_of_type_Albb == null) || (this.jdField_a_of_type_Alba == null) || (!this.jdField_a_of_type_Alba.c())) {}
    do
    {
      return;
      localObject = ((albf)this.jdField_a_of_type_Alba.a().getManager(249)).a();
    } while (localObject == null);
    Object localObject = ((albe)localObject).a(0);
    if (localObject == null)
    {
      QLog.w("cmshow_scripted_SpriteBridge", 1, "actionScript == null.");
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)paramList.next();
      try
      {
        localJSONArray.put(new JSONObject(a(localSpriteTaskParam)));
        ((alas)localObject).a(localSpriteTaskParam.jdField_a_of_type_JavaLangString, false);
      }
      catch (Exception localException)
      {
        QLog.e("cmshow_scripted_SpriteBridge", 1, "[playAction] e:", localException);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, "[playAction], ready to play");
    }
    paramList = new StringBuilder();
    paramList.append("playShowAction('").append(localJSONArray.toString()).append("');");
    ((alas)localObject).a(paramList.toString());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
  }
  
  public void b(SpriteTaskParam paramSpriteTaskParam)
  {
    boolean bool = true;
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_Albb == null) || (this.jdField_a_of_type_Alba == null) || (!this.jdField_a_of_type_Alba.c())) {}
    Object localObject1;
    do
    {
      return;
      if ((paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList != null) && (paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList.size() > 0) && (!this.jdField_a_of_type_Alba.e()))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 2, "[playAction], BackgroundSurface is not ready and add now");
        c();
        return;
      }
      this.jdField_a_of_type_Albb.a(paramSpriteTaskParam);
      if (!a(paramSpriteTaskParam.jdField_c_of_type_Int, paramSpriteTaskParam.f))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 1, "[playAction], fail to load script.");
        paramSpriteTaskParam.jdField_b_of_type_Int = 4;
        return;
      }
      localObject2 = this.jdField_a_of_type_Albb.a(paramSpriteTaskParam);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramSpriteTaskParam.jdField_b_of_type_Int = 4;
        return;
      }
      localObject1 = (albf)this.jdField_a_of_type_Alba.a().getManager(249);
      localObject3 = ((albf)localObject1).a();
    } while (localObject3 == null);
    Object localObject3 = ((albe)localObject3).a(paramSpriteTaskParam.jdField_c_of_type_Int);
    if (localObject3 == null)
    {
      QLog.w("cmshow_scripted_SpriteBridge", 1, "actionScript == null.");
      paramSpriteTaskParam.jdField_b_of_type_Int = 4;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, new Object[] { "[playAction], ready to play, actionId:", Integer.valueOf(paramSpriteTaskParam.f) });
    }
    paramSpriteTaskParam.jdField_b_of_type_Int = 2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playAction('").append((String)localObject2).append("');");
    ((alas)localObject3).a(localStringBuilder.toString());
    ((alas)localObject3).a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, false);
    ((alas)localObject3).a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, false);
    Object localObject2 = this.jdField_a_of_type_Alba.a();
    if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)) {}
    for (;;)
    {
      algj.a((QQAppInterface)localObject2, paramSpriteTaskParam, bool, paramSpriteTaskParam.jdField_b_of_type_Boolean);
      localObject1 = ((albf)localObject1).a();
      if ((localObject1 == null) || (albi.a(this.jdField_a_of_type_Alba.a()))) {
        break;
      }
      if ((paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList == null) || (paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
        break label372;
      }
      ((alaw)localObject1).a(paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList);
      return;
      bool = false;
    }
    label372:
    ((alaw)localObject1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alax
 * JD-Core Version:    0.7.0.1
 */