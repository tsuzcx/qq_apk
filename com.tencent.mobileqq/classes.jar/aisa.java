import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.script.SpriteBridge.1;
import com.tencent.mobileqq.apollo.script.SpriteBridge.2;
import com.tencent.mobileqq.apollo.script.SpriteBridge.3;
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

public class aisa
  implements aisn
{
  private aisd jdField_a_of_type_Aisd;
  private aise jdField_a_of_type_Aise;
  private aisq jdField_a_of_type_Aisq;
  private String jdField_a_of_type_JavaLangString;
  private CopyOnWriteArrayList<WeakReference<aisp>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  
  public aisa(aisd paramaisd, aisq paramaisq, aise paramaise)
  {
    this.jdField_a_of_type_Aisd = paramaisd;
    this.jdField_a_of_type_Aisq = paramaisq;
    this.jdField_a_of_type_Aise = paramaise;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  private String a()
  {
    aisk localaisk = new aisk();
    localaisk.jdField_a_of_type_Int = 0;
    localaisk.f = 4;
    localaisk.k = 2;
    localaisk.g = 5;
    localaisk.jdField_a_of_type_Long = 1000000L;
    return this.jdField_a_of_type_Aise.a(localaisk);
  }
  
  private String a(aisk paramaisk)
  {
    Object localObject;
    if (paramaisk == null) {
      localObject = a();
    }
    String str;
    do
    {
      return localObject;
      if (!a(paramaisk.jdField_c_of_type_Int, paramaisk.f))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 1, "[playAction], fail to load script.");
        paramaisk.jdField_b_of_type_Int = 4;
        return a();
      }
      str = this.jdField_a_of_type_Aise.a(paramaisk);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    paramaisk.jdField_b_of_type_Int = 4;
    return a();
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2;
    if ((this.jdField_a_of_type_Aisd == null) || (this.jdField_a_of_type_Aisd.b == null))
    {
      bool2 = false;
      return bool2;
    }
    Object localObject1 = (QQAppInterface)this.jdField_a_of_type_Aisd.b.get();
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
    if ((this.jdField_a_of_type_Aisd == null) || (this.jdField_a_of_type_Aisd.a() == null)) {
      return false;
    }
    return ((aisi)this.jdField_a_of_type_Aisd.a().getManager(249)).a().a(paramInt1, paramInt2) != null;
  }
  
  private void c()
  {
    ThreadManager.getUIHandler().post(new SpriteBridge.3(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Aise.a();
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
        aisp localaisp = (aisp)((WeakReference)localIterator.next()).get();
        if (localaisp != null) {
          localaisp.a(paramInt);
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
    if ((paramMessageForApollo == null) || (this.jdField_a_of_type_Aisd == null) || (this.jdField_a_of_type_Aisq == null)) {
      break label48;
    }
    label48:
    while (!aisl.b(this.jdField_a_of_type_Aisd.a(), paramMessageForApollo.istroop, paramMessageForApollo.frienduin)) {
      return;
    }
    aisk localaisk = new aisk();
    localaisk.f = ApolloUtil.a(this.jdField_a_of_type_Aisd.a(), paramMessageForApollo);
    localaisk.jdField_c_of_type_Int = ApolloUtil.b(this.jdField_a_of_type_Aisd.a(), paramMessageForApollo);
    localaisk.h = paramMessageForApollo.istroop;
    localaisk.g = paramInt;
    localaisk.jdField_a_of_type_Boolean = paramMessageForApollo.isSend();
    localaisk.jdField_a_of_type_Long = paramMessageForApollo.uniseq;
    localaisk.i = paramMessageForApollo.audioId;
    localaisk.jdField_a_of_type_Float = paramMessageForApollo.audioStartTime;
    if (paramMessageForApollo.isDoubleAction()) {
      i = 1;
    }
    localaisk.e = i;
    localaisk.jdField_c_of_type_JavaLangString = paramMessageForApollo.inputText;
    localaisk.jdField_b_of_type_Boolean = paramMessageForApollo.isBarrageMode();
    localaisk.jdField_d_of_type_JavaLangString = paramMessageForApollo.extendJson;
    if (localaisk.h == 0) {
      if (paramMessageForApollo.isSend())
      {
        localaisk.jdField_a_of_type_JavaLangString = paramMessageForApollo.selfuin;
        localaisk.jdField_b_of_type_JavaLangString = paramMessageForApollo.frienduin;
      }
    }
    for (;;)
    {
      a(localaisk);
      if (paramInt != 2) {
        break;
      }
      aisl.a(this.jdField_a_of_type_Aisd.a(), localaisk);
      return;
      localaisk.jdField_a_of_type_JavaLangString = paramMessageForApollo.frienduin;
      localaisk.jdField_b_of_type_JavaLangString = paramMessageForApollo.selfuin;
      continue;
      if ((localaisk.h == 1) || (localaisk.h == 3000))
      {
        localaisk.jdField_b_of_type_JavaLangString = Long.toString(paramMessageForApollo.mApolloMessage.peer_uin);
        localaisk.jdField_a_of_type_JavaLangString = paramMessageForApollo.senderuin;
      }
    }
  }
  
  public void a(aisd paramaisd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, "[initSprite]");
    }
    int i = aisl.b(0);
    if ((this.jdField_a_of_type_Aise == null) || (paramaisd == null) || (!paramaisd.c())) {
      aixo.a(i, 300, 160, new Object[] { "glview is not ready" });
    }
    String str;
    airu localairu;
    do
    {
      do
      {
        return;
      } while (!a(0, -1));
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        str = this.jdField_a_of_type_Aise.a();
        QLog.d("CmShowStatUtil", 1, "get spriteJs");
      }
      while (TextUtils.isEmpty(str))
      {
        aixo.a(i, 300, 301, new Object[] { "spriteJs is empty" });
        return;
        str = this.jdField_a_of_type_JavaLangString;
        QLog.d("CmShowStatUtil", 1, "spriteJs from cache");
        this.jdField_a_of_type_JavaLangString = null;
      }
      localairu = aisl.a(paramaisd.a());
    } while (localairu == null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initSprite('").append(str).append("');");
    aixo.a(i, 350);
    QLog.d("cmshow_scripted_SpriteBridge", 1, "TraceReport CmShowStatUtil commitJS:(initSprite )");
    localairu.a(localStringBuilder.toString());
    ThreadManager.executeOnSubThread(new SpriteBridge.2(this, localairu, paramaisd));
  }
  
  public void a(aisk paramaisk)
  {
    if (paramaisk == null) {
      return;
    }
    ThreadManager.excute(new SpriteBridge.1(this, paramaisk), 192, null, true);
  }
  
  public void a(aisp paramaisp)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(paramaisp));
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt)
  {
    if ((paramChatMessage == null) || (this.jdField_a_of_type_Aisd == null) || (this.jdField_a_of_type_Aisq == null)) {}
    while (!aisl.b(this.jdField_a_of_type_Aisd.a(), paramChatMessage.istroop, paramChatMessage.frienduin)) {
      return;
    }
    aisk localaisk = new aisk();
    localaisk.f = paramInt;
    ApolloActionData localApolloActionData = aisl.a(this.jdField_a_of_type_Aisd.a(), paramInt);
    if (localApolloActionData != null)
    {
      localaisk.jdField_c_of_type_Int = localApolloActionData.actionType;
      localaisk.e = localApolloActionData.personNum;
    }
    localaisk.h = paramChatMessage.istroop;
    if (paramChatMessage.isSend())
    {
      localaisk.g = 0;
      localaisk.jdField_a_of_type_Boolean = paramChatMessage.isSend();
      localaisk.jdField_a_of_type_Long = paramChatMessage.uniseq;
      if (localaisk.h != 0) {
        break label188;
      }
      if (!paramChatMessage.isSend()) {
        break label169;
      }
      localaisk.jdField_a_of_type_JavaLangString = paramChatMessage.selfuin;
      localaisk.jdField_b_of_type_JavaLangString = paramChatMessage.frienduin;
    }
    for (;;)
    {
      a(localaisk);
      return;
      localaisk.g = 1;
      break;
      label169:
      localaisk.jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
      localaisk.jdField_b_of_type_JavaLangString = paramChatMessage.selfuin;
      continue;
      label188:
      if ((localaisk.h == 1) || (localaisk.h == 3000)) {
        localaisk.jdField_a_of_type_JavaLangString = paramChatMessage.senderuin;
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage, ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, "[buildSpriteTask]");
    }
    if ((paramChatMessage == null) || (this.jdField_a_of_type_Aisd == null) || (this.jdField_a_of_type_Aisq == null) || (paramArrayList1 == null) || (paramArrayList1.size() == 0)) {}
    while (!aisl.b(this.jdField_a_of_type_Aisd.a(), paramChatMessage.istroop, paramChatMessage.frienduin)) {
      return;
    }
    aisk localaisk = new aisk();
    localaisk.f = ((Integer)paramArrayList1.get(0)).intValue();
    localaisk.jdField_d_of_type_Int = 1;
    localaisk.jdField_a_of_type_JavaUtilArrayList = paramArrayList1;
    localaisk.jdField_b_of_type_JavaUtilArrayList = paramArrayList2;
    localaisk.jdField_c_of_type_Int = 1;
    localaisk.h = paramChatMessage.istroop;
    if (paramChatMessage.isSend())
    {
      localaisk.g = 0;
      localaisk.jdField_a_of_type_Boolean = paramChatMessage.isSend();
      localaisk.jdField_a_of_type_Long = paramChatMessage.uniseq;
      if (localaisk.h != 0) {
        break label225;
      }
      if (!paramChatMessage.isSend()) {
        break label204;
      }
      localaisk.jdField_a_of_type_JavaLangString = paramChatMessage.selfuin;
      localaisk.jdField_b_of_type_JavaLangString = paramChatMessage.frienduin;
    }
    for (;;)
    {
      a(localaisk);
      return;
      localaisk.g = 1;
      break;
      label204:
      localaisk.jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
      localaisk.jdField_b_of_type_JavaLangString = paramChatMessage.selfuin;
      continue;
      label225:
      if ((localaisk.h == 1) || (localaisk.h == 3000)) {
        localaisk.jdField_a_of_type_JavaLangString = paramChatMessage.senderuin;
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
        ((JSONObject)localObject).put("name", aisl.a(baaw.encodeToString(paramMessageForApollo.mApolloMessage.name, 0)));
      }
      if (paramMessageForApollo.mApolloMessage.text != null) {
        ((JSONObject)localObject).put("atText", aisl.a(baaw.encodeToString(paramMessageForApollo.mApolloMessage.text, 0)));
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
      paramMessageForApollo = aisl.a(this.jdField_a_of_type_Aisd.a());
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
  
  public void a(List<aisk> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (this.jdField_a_of_type_Aise == null) || (this.jdField_a_of_type_Aisd == null) || (!this.jdField_a_of_type_Aisd.c())) {}
    do
    {
      return;
      localObject = ((aisi)this.jdField_a_of_type_Aisd.a().getManager(249)).a();
    } while (localObject == null);
    Object localObject = ((aish)localObject).a(0);
    if (localObject == null)
    {
      QLog.w("cmshow_scripted_SpriteBridge", 1, "actionScript == null.");
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aisk localaisk = (aisk)paramList.next();
      try
      {
        localJSONArray.put(new JSONObject(a(localaisk)));
        ((airv)localObject).a(localaisk.jdField_a_of_type_JavaLangString, false);
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
    ((airv)localObject).a(paramList.toString());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
  }
  
  public void b(aisk paramaisk)
  {
    boolean bool = true;
    if ((paramaisk == null) || (this.jdField_a_of_type_Aise == null) || (this.jdField_a_of_type_Aisd == null) || (!this.jdField_a_of_type_Aisd.c())) {}
    Object localObject1;
    do
    {
      return;
      if ((paramaisk.jdField_b_of_type_JavaUtilArrayList != null) && (paramaisk.jdField_b_of_type_JavaUtilArrayList.size() > 0) && (!this.jdField_a_of_type_Aisd.e()))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 2, "[playAction], BackgroundSurface is not ready and add now");
        c();
        return;
      }
      this.jdField_a_of_type_Aise.a(paramaisk);
      if (!a(paramaisk.jdField_c_of_type_Int, paramaisk.f))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 1, "[playAction], fail to load script.");
        paramaisk.jdField_b_of_type_Int = 4;
        return;
      }
      localObject2 = this.jdField_a_of_type_Aise.a(paramaisk);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramaisk.jdField_b_of_type_Int = 4;
        return;
      }
      localObject1 = (aisi)this.jdField_a_of_type_Aisd.a().getManager(249);
      localObject3 = ((aisi)localObject1).a();
    } while (localObject3 == null);
    Object localObject3 = ((aish)localObject3).a(paramaisk.jdField_c_of_type_Int);
    if (localObject3 == null)
    {
      QLog.w("cmshow_scripted_SpriteBridge", 1, "actionScript == null.");
      paramaisk.jdField_b_of_type_Int = 4;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, new Object[] { "[playAction], ready to play, actionId:", Integer.valueOf(paramaisk.f) });
    }
    paramaisk.jdField_b_of_type_Int = 2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playAction('").append((String)localObject2).append("');");
    ((airv)localObject3).a(localStringBuilder.toString());
    ((airv)localObject3).a(paramaisk.jdField_a_of_type_JavaLangString, false);
    ((airv)localObject3).a(paramaisk.jdField_b_of_type_JavaLangString, false);
    Object localObject2 = this.jdField_a_of_type_Aisd.a();
    if (!TextUtils.isEmpty(paramaisk.jdField_c_of_type_JavaLangString)) {}
    for (;;)
    {
      aiwi.a((QQAppInterface)localObject2, paramaisk, bool, paramaisk.jdField_b_of_type_Boolean);
      localObject1 = ((aisi)localObject1).a();
      if ((localObject1 == null) || (aisl.a(this.jdField_a_of_type_Aisd.a()))) {
        break;
      }
      if ((paramaisk.jdField_b_of_type_JavaUtilArrayList == null) || (paramaisk.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
        break label372;
      }
      ((airz)localObject1).a(paramaisk.jdField_b_of_type_JavaUtilArrayList);
      return;
      bool = false;
    }
    label372:
    ((airz)localObject1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aisa
 * JD-Core Version:    0.7.0.1
 */