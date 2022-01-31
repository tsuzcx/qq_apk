import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class alar
  extends alas
{
  public alar(int paramInt, alba paramalba)
  {
    super(paramInt, paramalba);
  }
  
  private akrw a(String paramString, ApolloRender paramApolloRender)
  {
    try
    {
      paramString = new JSONObject(paramString);
      float f1 = (float)paramString.optDouble("x");
      float f2 = (float)paramString.optDouble("y");
      float f3 = (float)paramString.optDouble("w");
      float f4 = (float)paramString.optDouble("h");
      float f5 = (float)paramString.optDouble("bX");
      float f6 = (float)paramString.optDouble("bY");
      float f7 = (float)paramString.optDouble("bW");
      float f8 = (float)paramString.optDouble("bH");
      float f9 = (float)paramString.optDouble("gX");
      float f10 = (float)paramString.optDouble("gY");
      float f11 = (float)paramString.optDouble("gW");
      float f12 = (float)paramString.optDouble("gH");
      ApolloRender.AABBCallback(f1, f2, f3, f4, paramString.optString("name"), paramString.optString("extendString"), f5, f6, f7, f8, f9, f10, f11, f12, paramString.optInt("dispose"));
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleBoundingListUpdate exception = " + paramString.toString());
      }
    }
  }
  
  private akrw b()
  {
    akrw localakrw = new akrw();
    localakrw.jdField_b_of_type_Boolean = true;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("is3DBetaTester", albi.a(this.jdField_a_of_type_Alba.a()));
      localakrw.jdField_a_of_type_JavaLangString = localJSONObject.toString();
      return localakrw;
    }
    catch (Exception localException)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, localException, new Object[0]);
    }
    return localakrw;
  }
  
  private akrw d(String paramString)
  {
    try
    {
      QLog.d("cmshow_scripted_SpriteActionScript", 1, new Object[] { "handleJsError mSpriteFrom:", Integer.valueOf(this.jdField_a_of_type_Alba.e) });
      paramString = new JSONObject(paramString).optString("data");
      alhp.a(albi.b(this.jdField_a_of_type_Alba.e), 1000, 50, new Object[] { paramString });
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleJsError:", paramString);
      }
    }
  }
  
  private akrw e(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Alba == null) {
        return null;
      }
      paramString = new JSONObject(paramString);
      alhp.a(paramString.optInt("featureId"), paramString.optString("receiveUin"));
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleTraceBegin:", paramString);
    }
    return null;
  }
  
  private akrw f(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Alba == null) {
        return null;
      }
      int i = new JSONObject(paramString).optInt("featureId");
      if ((i == albi.b(1)) || (i == albi.b(2))) {
        alhp.a(i, null, new int[] { alho.a(i, false, this.jdField_a_of_type_Alba.jdField_b_of_type_Int, -1, true) });
      }
      alhp.b(i);
      if ((i == albi.b(1)) || (i == albi.b(2)))
      {
        alhp.a(albi.b(this.jdField_a_of_type_Alba.e), false);
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleTraceEnd:", paramString);
    }
    return null;
  }
  
  private akrw g(String paramString)
  {
    long l2 = 0L;
    int i = 0;
    try
    {
      if (this.jdField_a_of_type_Alba == null) {
        return null;
      }
      Object localObject = new JSONObject(paramString);
      int k = ((JSONObject)localObject).optInt("featureId");
      int m = ((JSONObject)localObject).optInt("spanId");
      paramString = ((JSONObject)localObject).optString("msg");
      long l3 = ((JSONObject)localObject).optLong("timestamp");
      localObject = ((JSONObject)localObject).optString("spanDesc");
      long l1 = l2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int j = ApolloUtil.g(m);
        i = j;
        l1 = l2;
        if (j > 0)
        {
          l1 = ApolloUtil.b((String)localObject);
          i = j;
        }
      }
      alhp.a(k, null, m, -100, l3, i, l1, new Object[] { paramString });
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleTraceSpanBegin:", paramString);
    }
    return null;
  }
  
  private akrw h(String paramString)
  {
    long l2 = 0L;
    int i = 0;
    try
    {
      if (this.jdField_a_of_type_Alba == null) {
        return null;
      }
      Object localObject = new JSONObject(paramString);
      int k = ((JSONObject)localObject).optInt("featureId");
      int m = ((JSONObject)localObject).optInt("spanId");
      int n = ((JSONObject)localObject).optInt("errCode");
      paramString = ((JSONObject)localObject).optString("msg");
      long l3 = ((JSONObject)localObject).optLong("timestamp");
      localObject = ((JSONObject)localObject).optString("spanDesc");
      long l1 = l2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int j = ApolloUtil.g(m);
        i = j;
        l1 = l2;
        if (j > 0)
        {
          l1 = ApolloUtil.b((String)localObject);
          i = j;
        }
      }
      alhp.a(k, null, m, n, l3, i, l1, new Object[] { paramString });
      if ((n == 57) && (!c()))
      {
        f();
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleTraceSpanEnd:", paramString);
    }
    return null;
  }
  
  private akrw i(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Alba == null) {
        return null;
      }
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("featureId");
      int j = paramString.optInt("spanId");
      String str = paramString.optString("msg");
      alhp.a(i, j, -100, paramString.optLong("timestamp"), new Object[] { str });
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleTraceLog:", paramString);
    }
    return null;
  }
  
  private akrw j(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Alba.e != 0) {
        return null;
      }
      paramString = new JSONObject(paramString).optString("text");
      this.jdField_a_of_type_Albf.a().a(paramString);
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  private akrw k(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("uinList");
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        a(paramString.optString(i), true);
        i += 1;
      }
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
    }
  }
  
  private akrw l(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Alba.e != 0) {
        return null;
      }
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("status");
      int j = paramString.optInt("whiteHeight");
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[handleSpriteStatus], status:", Integer.valueOf(i), ",whiteHeight:", Integer.valueOf(j) });
      }
      this.jdField_a_of_type_Albf.a().a(i, j);
      this.jdField_a_of_type_Albf.a().a(i);
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  private akrw m(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Alba.e != 0) {
        return null;
      }
      int i = new JSONObject(paramString).optInt("status");
      if (this.jdField_a_of_type_Albf != null)
      {
        this.jdField_a_of_type_Albf.a().a(i);
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  private akrw n(String paramString)
  {
    int i;
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      i = paramString.optInt("taskId");
      j = paramString.optInt("status");
      paramString = paramString.optString("uin");
      if (!QLog.isColorLevel()) {
        break label137;
      }
      QLog.d("cmshow_scripted_SpriteActionScript.callback", 2, new Object[] { "taskId:", Integer.valueOf(i), ",status:", Integer.valueOf(j) });
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
      break label164;
    }
    if (this.jdField_a_of_type_Albj != null)
    {
      this.jdField_a_of_type_Albj.a(paramString, i);
      break label164;
      if (this.jdField_a_of_type_Albj != null)
      {
        this.jdField_a_of_type_Albj.a(paramString, i, j);
        break label164;
        label137:
        switch (j)
        {
        }
      }
    }
    label164:
    return null;
  }
  
  private akrw o(String paramString)
  {
    label122:
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        JSONObject localJSONObject = new JSONObject();
        if ("pet".equals(paramString.getString("config_name")))
        {
          paramString = new JSONArray();
          aknx localaknx = (aknx)this.jdField_a_of_type_Alba.a().getManager(153);
          if (localaknx.j == null) {
            break label122;
          }
          paramString = new JSONArray(localaknx.j);
          localJSONObject.put("petConfig", paramString);
          paramString = new akrw();
          paramString.jdField_b_of_type_Boolean = true;
          paramString.jdField_a_of_type_JavaLangString = localJSONObject.toString();
          return paramString;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleGetLocalData error:", paramString);
      }
      return null;
    }
  }
  
  private akrw p(String paramString)
  {
    int i = 0;
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      j = paramString.optInt("from");
      if (!QLog.isColorLevel()) {
        break label182;
      }
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "handlePlayAction from:", Integer.valueOf(j) });
    }
    catch (JSONException paramString)
    {
      label71:
      Object localObject;
      paramString.printStackTrace();
      return null;
    }
    paramString = this.jdField_a_of_type_Alba.a();
    if (paramString != null)
    {
      paramString.a();
      return null;
      if (j == 0)
      {
        paramString = paramString.optString("uinList");
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = new JSONArray(paramString);
          paramString = new ArrayList();
        }
      }
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject).length())
      {
        String str = ((JSONArray)localObject).optString(i);
        if (!TextUtils.isEmpty(str)) {
          paramString.add(str);
        }
      }
      else
      {
        if (paramString.size() != 0)
        {
          localObject = albi.a(a());
          if (localObject != null)
          {
            ((albb)localObject).a(paramString);
            return null;
            label182:
            if (j == 1) {
              break;
            }
            if (j != 2) {
              break label71;
            }
            break;
          }
        }
        return null;
      }
      i += 1;
    }
  }
  
  private akrw q(String paramString)
  {
    int i = 0;
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      j = paramString.optInt("from");
      if (j != 0) {
        break label177;
      }
      localObject = paramString.optString("url");
      if ((this.jdField_a_of_type_Alba == null) || (this.jdField_a_of_type_Alba.a() == null))
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleOnApolloClick mSpriteContent is nil");
        return null;
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label122;
      }
      if (this.jdField_a_of_type_Alba.a().a() == null)
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleOnApolloClick activity is nil");
        return null;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "Exception:", paramString);
      return null;
    }
    ApolloUtil.a(this.jdField_a_of_type_Alba.a().a(), (String)localObject);
    return null;
    label122:
    paramString = paramString.optString("gameId");
    if (!TextUtils.isEmpty(paramString)) {
      i = Integer.parseInt(paramString);
    }
    if (i > 0)
    {
      ApolloGameUtil.a(this.jdField_a_of_type_Alba.a(), i, 333002, "message", 1);
      return null;
    }
    QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleOnApolloClick gameStr is nil");
    return null;
    label177:
    i = paramString.optInt("apolloStatus");
    int k = paramString.optInt("clickPart");
    paramString = paramString.optString("apolloId");
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "handleOnApolloClick", ",from:", Integer.valueOf(j), ",apolloStatus:", Integer.valueOf(i), ",clickPart:", Integer.valueOf(k), "apolloId:", paramString });
    }
    Object localObject = this.jdField_a_of_type_Alba.a();
    if (localObject != null) {
      ((albl)localObject).a(i, k, paramString);
    }
    return null;
  }
  
  public akrw a()
  {
    akrw localakrw;
    label248:
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface = a();
        if (localQQAppInterface == null) {
          return null;
        }
        localakrw = new akrw();
        localakrw.jdField_b_of_type_Boolean = true;
        JSONObject localJSONObject = new JSONObject();
        if ((1 == localQQAppInterface.c()) && (((this.jdField_a_of_type_Alba.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Alba.jdField_a_of_type_Int != 3000)) || (((1 == localQQAppInterface.a()) || (this.jdField_a_of_type_Alba.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Alba.jdField_a_of_type_Int == -2)) && (!localQQAppInterface.k()) && (!localQQAppInterface.l()) && (localQQAppInterface.m()) && (!MediaPlayerManager.a(localQQAppInterface).a()) && ((localQQAppInterface.a() == null) || (!localQQAppInterface.a().k())) && (!localQQAppInterface.c()))))
        {
          if (localQQAppInterface.a() == null) {
            break label248;
          }
          if (!localQQAppInterface.a().l())
          {
            break label248;
            localJSONObject.put("isAllowed", i);
            localakrw.jdField_a_of_type_JavaLangString = localJSONObject.toString();
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "isAllowPlayAudio:", Integer.valueOf(i) });
            break;
          }
        }
        albi.b(localQQAppInterface);
        int i = 0;
        continue;
        i = 1;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, localThrowable, new Object[0]);
        return null;
      }
    }
    return localakrw;
  }
  
  public akrw a(long paramLong, String paramString1, String paramString2)
  {
    akra localakra = a();
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {}
    while ((localakra == null) || (localakra.getLuaState() != paramLong)) {
      return null;
    }
    if ((paramString1.startsWith("apollo_")) && (!paramString1.startsWith("cs.")) && (!paramString1.endsWith(".local")) && (!akru.a(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, "ssoCmdRule, [aio],cmd:" + paramString1);
      }
      ((bdug)localQQAppInterface.a(71)).a(paramString1, paramString2.toString(), paramLong, 4);
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      if ("cs.script_action_status_notify.local".equals(paramString1))
      {
        paramString1 = n(paramString2);
      }
      else if ("cs.script_change_panel_status.local".equals(paramString1))
      {
        paramString1 = m(paramString2);
      }
      else if ("cs.script_get_dress_data.local".equals(paramString1))
      {
        paramString1 = k(paramString2);
      }
      else if ("cs.script_sprite_status_change.local".equals(paramString1))
      {
        paramString1 = l(paramString2);
      }
      else if ("cs.script_get_show_action.local".equals(paramString1))
      {
        paramString1 = a(paramString2);
      }
      else if ("cs.script_is_allow_play_audio.local".equals(paramString1))
      {
        paramString1 = a();
      }
      else if ("cs.script_show_barrage.local".equals(paramString1))
      {
        paramString1 = b(paramString2);
      }
      else if ("cs.script_send_action_msg.local".equals(paramString1))
      {
        paramString1 = c(paramString2);
      }
      else if ("cs.script_show_toast.local".equals(paramString1))
      {
        paramString1 = j(paramString2);
      }
      else if ("cs.script_get_config.local".equals(paramString1))
      {
        paramString1 = o(paramString2);
      }
      else if ("cs.script_play_action.local".equals(paramString1))
      {
        paramString1 = p(paramString2);
      }
      else if ("cs.script_action_apollo_click.local".equals(paramString1))
      {
        paramString1 = q(paramString2);
      }
      else if ("cs.script_update_boundinglist.local".equals(paramString1))
      {
        paramString1 = a(paramString2, localakra.getRenderImpl().a());
      }
      else if ("cs.get_cm3D_state.local".equals(paramString1))
      {
        paramString1 = b();
      }
      else if ("cs.trace_begin.local".equals(paramString1))
      {
        paramString1 = e(paramString2);
      }
      else if ("cs.trace_end.local".equals(paramString1))
      {
        paramString1 = f(paramString2);
      }
      else if ("cs.trace_span_begin.local".equals(paramString1))
      {
        paramString1 = g(paramString2);
      }
      else if ("cs.trace_span_end.local".equals(paramString1))
      {
        paramString1 = h(paramString2);
      }
      else if ("cs.trace_log.local".equals(paramString1))
      {
        paramString1 = i(paramString2);
      }
      else
      {
        if ("cs.script_sprite_model_change_notify.local".equals(paramString1))
        {
          if ((ApolloGameUtil.a(localQQAppInterface) == 2) && (this.jdField_a_of_type_Alba != null) && (this.jdField_a_of_type_Alba.e == 0))
          {
            paramString1 = ((aliw)localQQAppInterface.getManager(155)).c(3000059);
            if (paramString1 != null)
            {
              paramString2 = new SpriteTaskParam();
              paramString2.f = paramString1.actionId;
              paramString2.jdField_c_of_type_Int = 0;
              paramString2.g = 3;
              paramString2.e = paramString1.personNum;
              paramString2.jdField_a_of_type_Long = -10000L;
              paramString2.jdField_a_of_type_Boolean = true;
              paramString2.jdField_b_of_type_Boolean = false;
              paramString2.jdField_c_of_type_JavaLangString = paramString1.bubbleText;
              if (this.jdField_a_of_type_Alba.a() != null)
              {
                paramString2.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Alba.a().getCurrentAccountUin());
                ((albf)this.jdField_a_of_type_Alba.a().getManager(249)).a().a(paramString2);
              }
            }
            paramString1 = null;
          }
        }
        else if ("cs.xy_error_info.local".equals(paramString1))
        {
          paramString1 = d(paramString2);
          continue;
        }
        paramString1 = null;
      }
    }
  }
  
  public akrw a(String paramString)
  {
    akrw localakrw;
    JSONObject localJSONObject1;
    try
    {
      if (this.jdField_a_of_type_Alba.e != 0) {
        return null;
      }
      paramString = new JSONObject(paramString);
      JSONArray localJSONArray1 = new JSONArray(paramString.optString("uinList"));
      JSONArray localJSONArray2 = new JSONArray();
      localakrw = new akrw();
      localakrw.jdField_b_of_type_Boolean = true;
      localJSONObject1 = new JSONObject();
      int j = paramString.optInt("type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[handleGetShowAction] type:", Integer.valueOf(j) });
      }
      albb localalbb = albi.a(a());
      if (localalbb != null)
      {
        int i = 0;
        if (i < localJSONArray1.length())
        {
          JSONObject localJSONObject2 = new JSONObject();
          Object localObject = localJSONArray1.optString(i);
          localJSONObject2.put("uin", localObject);
          if (j == 1) {
            localJSONObject2.put("petPath", localalbb.a(new JSONArray(paramString.optString("actionList"))));
          }
          for (;;)
          {
            localJSONArray2.put(localJSONObject2);
            i += 1;
            break;
            localObject = localalbb.a((String)localObject);
            localJSONObject2.put("path", ((Pair)localObject).first);
            localJSONObject2.put("actionType", ((Pair)localObject).second);
          }
        }
      }
      localJSONObject1.put("path", localJSONArray2);
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
      return null;
    }
    localakrw.jdField_a_of_type_JavaLangString = localJSONObject1.toString();
    return localakrw;
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Alba.e != 0) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyPanelStatusChanged], status:", Integer.valueOf(paramInt) });
        }
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("status", paramInt);
        ApolloCmdChannel.getChannel(this.jdField_a_of_type_Alba.a()).callbackFromRequest(this.jdField_a_of_type_Alba.a().getLuaState(), 0, "sc.script_panel_status_change.local", ((JSONObject)localObject).toString());
        localObject = "";
        if (1 == paramInt)
        {
          localObject = "panel_close_clk";
          VipUtils.a(this.jdField_a_of_type_Alba.a(), "cmshow", "Apollo", (String)localObject, ApolloUtil.b(this.jdField_a_of_type_Alba.jdField_a_of_type_Int), ApolloUtil.h(this.jdField_a_of_type_Alba.jdField_b_of_type_Int), new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifyPanelStatusChanged],", localThrowable);
        return;
      }
      if (2 == paramInt) {
        String str = "panel_open_clk";
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyDrawRectChanged], width:", Integer.valueOf(paramInt1), ",height:", Integer.valueOf(paramInt2) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_Alba.a()).callbackFromRequest(this.jdField_a_of_type_Alba.a().getLuaState(), 0, "sc.script_draw_area_change.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifySpriteVisibility],", localThrowable);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[init], width:", Integer.valueOf(paramInt1), ",height:", Integer.valueOf(paramInt2), ",vHeight:", Integer.valueOf(paramInt3), ",aioType:", Integer.valueOf(paramInt4), "friendUin:", paramString, ",spriteFrom:", Integer.valueOf(paramInt5) });
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Alba == null) {
          return;
        }
        Object localObject1 = this.jdField_a_of_type_Alba.a();
        if (localObject1 == null) {
          break label1016;
        }
        Object localObject2 = ApolloUtil.a();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("platform", "android");
        if (!this.jdField_a_of_type_Alba.jdField_b_of_type_Boolean) {
          break label1017;
        }
        i = 2;
        localJSONObject.put("panelStatus", i);
        if (localObject2 != null)
        {
          localJSONObject.put("phoneModel", alkt.jdField_a_of_type_JavaLangString);
          localJSONObject.put("osVersion", alkt.jdField_b_of_type_JavaLangString);
          localJSONObject.put("cpuType", alkt.jdField_c_of_type_JavaLangString);
          localJSONObject.put("cpuNumber", alkt.jdField_a_of_type_Int);
          localJSONObject.put("cpuFrequency", alkt.jdField_a_of_type_Long);
          localJSONObject.put("freeMemory", ((alkt)localObject2).d);
          localJSONObject.put("totalMemory", ((alkt)localObject2).jdField_c_of_type_Long);
          localJSONObject.put("maxMemory", ((alkt)localObject2).jdField_b_of_type_Long);
        }
        localJSONObject.put("aioType", ApolloGameUtil.a((AppInterface)localObject1, paramInt4, this.jdField_a_of_type_Alba.jdField_a_of_type_JavaLangString));
        localJSONObject.put("friendUin", paramString);
        localJSONObject.put("width", paramInt1);
        localJSONObject.put("height", paramInt2);
        localJSONObject.put("vHeight", paramInt3);
        localJSONObject.put("screenW", bdgk.i());
        localJSONObject.put("screenH", bdgk.j());
        localJSONObject.put("qqVer", "8.3.5");
        localJSONObject.put("uin", this.jdField_a_of_type_Alba.jdField_b_of_type_JavaLangString);
        localJSONObject.put("density", bdgk.a);
        localJSONObject.put("wait", "def/basic/action/1/action/action");
        localJSONObject.put("standup", "def/basic/action/4/action/action");
        localJSONObject.put("think", "def/basic/action/3/action/action");
        localJSONObject.put("sitdown", "def/basic/action/2/action/action");
        if (!albi.a((QQAppInterface)localObject1)) {
          break label1023;
        }
        paramInt2 = 1;
        localJSONObject.put("isHide", paramInt2);
        a(localJSONObject, paramInt5);
        paramString = new JSONArray();
        localObject2 = new int[7];
        Object tmp502_500 = localObject2;
        tmp502_500[0] = 1;
        Object tmp506_502 = tmp502_500;
        tmp506_502[1] = 2;
        Object tmp510_506 = tmp506_502;
        tmp510_506[2] = 3;
        Object tmp514_510 = tmp510_506;
        tmp514_510[3] = 4;
        Object tmp518_514 = tmp514_510;
        tmp518_514[4] = 5;
        Object tmp522_518 = tmp518_514;
        tmp522_518[5] = 6;
        Object tmp527_522 = tmp522_518;
        tmp527_522[6] = 7;
        tmp527_522;
        paramInt4 = localObject2.length;
        paramInt2 = 0;
        if (paramInt2 < paramInt4)
        {
          paramString.put(algj.a(1, Integer.valueOf(localObject2[paramInt2]).intValue()));
          paramInt2 += 1;
          continue;
        }
        localJSONObject.put("defDress", paramString);
        localJSONObject.put("defRole", algj.a(0, 0));
        localJSONObject.put("from", paramInt5);
        if ((algj.a((QQAppInterface)localObject1)) && ((paramInt5 == 1) || (paramInt5 == 2)))
        {
          localJSONObject.put("drawer_up", "def/role/0/drawer/1/action/action");
          localJSONObject.put("drawer_down", "def/role/0/drawer/2/action/action");
          localJSONObject.put("friendcard_up", "def/role/0/friendcard/1/action/action");
          localJSONObject.put("friendcard_down", "def/role/0/friendcard/2/action/action");
          localJSONObject.put("drawer_pet_up", "def/role/0/drawer/3/action/action");
          localJSONObject.put("drawer_pet_down", "def/role/0/drawer/4/action/action");
          paramString = (aknx)((QQAppInterface)localObject1).getManager(153);
          if (paramString != null) {
            localJSONObject.put("drawerGameBoxUser", paramString.e);
          }
        }
        paramString = new File(aliu.i);
        if (!paramString.isDirectory()) {
          break label992;
        }
        paramString = paramString.listFiles();
        if ((paramString != null) && (paramString.length > 0))
        {
          localObject1 = new JSONArray();
          paramInt2 = 0;
          if (paramInt2 < paramString.length)
          {
            ((JSONArray)localObject1).put(paramString[paramInt2].getName());
            if (!QLog.isColorLevel()) {
              break label1028;
            }
            QLog.i("cmshow_scripted_SpriteActionScript", 2, "init shaderCode name:" + paramString[paramInt2].getName());
            break label1028;
          }
          localJSONObject.put("shaderCodes", localObject1);
          if (QLog.isColorLevel()) {
            QLog.i("cmshow_scripted_SpriteActionScript", 1, "commonInit shaderCodes jsonArray:" + localObject1);
          }
          paramString = new StringBuilder();
          paramString.append("if(commonInit){commonInit('").append(localJSONObject.toString()).append("');}");
          QLog.d("cmshow_scripted_SpriteActionScript", 1, "sava TraceReport CmShowStatUtil commitJS:(commonInit)");
          if ((paramInt1 != 0) && (paramInt3 != 0)) {
            break label1004;
          }
          a(paramString.toString(), 0, true);
          if (!QLog.isColorLevel()) {
            break label1016;
          }
          QLog.d("cmshow_scripted_SpriteActionScript", 2, localJSONObject.toString());
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, "[getCommonInit], errInfo->", paramString);
        return;
      }
      QLog.i("cmshow_scripted_SpriteActionScript", 1, "commonInit shaderCodes file no exist");
      continue;
      label992:
      QLog.i("cmshow_scripted_SpriteActionScript", 1, "commonInit shaderCodes dir no exist");
      continue;
      label1004:
      a(paramString.toString());
      continue;
      label1016:
      return;
      label1017:
      int i = 1;
      continue;
      label1023:
      paramInt2 = 0;
      continue;
      label1028:
      paramInt2 += 1;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifySpriteClicked], clickPart:", Integer.valueOf(paramInt), ",url:", paramString1 });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("clickPart", paramInt);
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("url", paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("apolloId", paramString2);
      }
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_Alba.a()).callbackFromRequest(this.jdField_a_of_type_Alba.a().getLuaState(), 0, "sc.script_on_sprite_single_clicked.local", localJSONObject.toString());
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifySpriteClicked],", paramString1);
    }
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    JSONObject localJSONObject;
    try
    {
      QLog.i("cmshow_scripted_SpriteActionScript", 1, "[notifyStatusOrDressChanged], type:" + paramInt);
      localJSONObject = new JSONObject();
      localJSONObject.put("type", paramInt);
      JSONArray localJSONArray = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        if (!TextUtils.isEmpty(str)) {
          localJSONArray.put(str);
        }
      }
      localJSONObject.put("uinList", localJSONArray);
    }
    catch (Throwable paramArrayList)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifySpriteVisibility],", paramArrayList);
      return;
    }
    ApolloCmdChannel.getChannel(this.jdField_a_of_type_Alba.a()).callbackFromRequest(this.jdField_a_of_type_Alba.a().getLuaState(), 0, "sc.script_user_dressOrStatus_changed.local", localJSONObject.toString());
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyScreenSizeChange] screenWidth:", Long.valueOf(paramLong1), ",screenHeight:", Long.valueOf(paramLong2), ",width:", Integer.valueOf(paramInt1), ",height:", Integer.valueOf(paramInt2) });
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if ((paramLong1 > 0L) && (paramLong2 > 0L))
      {
        localJSONObject.put("screenWidth", paramLong1);
        localJSONObject.put("screenHeight", paramLong2);
      }
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        localJSONObject.put("width", paramInt1);
        localJSONObject.put("height", paramInt2);
      }
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_Alba.a()).callbackFromRequest(this.jdField_a_of_type_Alba.a().getLuaState(), 0, "sc.script_notify_screen_size_change.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifyScreenSizeChange] ", localThrowable);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    int i = 0;
    if ((this.jdField_a_of_type_Alba == null) || (this.jdField_a_of_type_Alba.a() == null) || (!this.jdField_a_of_type_Alba.c()) || (!this.jdField_a_of_type_Boolean))
    {
      QLog.w("cmshow_scripted_SpriteActionScript", 1, "[notifyDressReady], surfaceView is destroyed. return");
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        int j = paramArrayOfInt.length;
        paramInt2 = 0;
        if (paramInt2 < j)
        {
          ((StringBuilder)localObject).append(Integer.valueOf(paramArrayOfInt[paramInt2])).append(",");
          paramInt2 += 1;
          continue;
        }
        ((StringBuilder)localObject).append("]");
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyDressReady], uin:", paramString, "dress:", localObject });
        }
        localObject = new JSONObject();
        JSONArray localJSONArray1 = new JSONArray();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("uin", paramString);
        JSONArray localJSONArray2 = new JSONArray();
        j = paramArrayOfInt.length;
        paramInt2 = i;
        if (paramInt2 < j)
        {
          localJSONArray2.put(algj.a(1, Integer.valueOf(paramArrayOfInt[paramInt2]).intValue()));
          paramInt2 += 1;
          continue;
        }
        algj.a(paramString, paramQQAppInterface, localJSONObject);
        localJSONObject.put("dress", localJSONArray2);
        localJSONObject.put("role", algj.a(0, paramInt1));
        paramQQAppInterface = this.jdField_a_of_type_Alba.a();
        if (paramQQAppInterface != null)
        {
          paramArrayOfInt = paramQQAppInterface.a(paramString, this.jdField_a_of_type_Alba, true);
          paramQQAppInterface = paramArrayOfInt;
          if (paramArrayOfInt == null) {
            paramQQAppInterface = new JSONObject();
          }
          localJSONObject.put("pet", paramQQAppInterface);
          localJSONObject.put("nameplate", albb.a(this.jdField_a_of_type_Alba.a(), paramString, paramInt1, true));
          paramQQAppInterface = this.jdField_a_of_type_Alba.jdField_b_of_type_JavaLangString;
          if ((TextUtils.isEmpty(paramQQAppInterface)) || (!paramQQAppInterface.equals(paramString))) {
            break label478;
          }
          paramQQAppInterface = alud.a(2131714699);
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            localJSONObject.put("nickname", albi.a(bdfr.encodeToString(paramQQAppInterface.getBytes("utf-8"), 0)));
          }
        }
        localJSONArray1.put(localJSONObject);
        ((JSONObject)localObject).put("dressInfo", localJSONArray1);
        ApolloCmdChannel.getChannel(this.jdField_a_of_type_Alba.a()).callbackFromRequest(this.jdField_a_of_type_Alba.a().getLuaState(), 0, "sc.script_notify_dress_ready.local", ((JSONObject)localObject).toString());
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifySpriteVisibility],", paramQQAppInterface);
        return;
      }
      label478:
      paramQQAppInterface = albi.a(this.jdField_a_of_type_Alba.a(), this.jdField_a_of_type_Alba.jdField_a_of_type_Int, paramString, this.jdField_a_of_type_Alba.jdField_a_of_type_JavaLangString, true);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyAddBubble],text:", paramString2 });
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("text", new String(albi.a(bdfr.encodeToString(paramString2.getBytes("utf-8"), 0))));
      if (!TextUtils.isEmpty(paramString1))
      {
        localJSONObject.put("uin", paramString1);
        paramString1 = albb.a(paramString2, 0, aknx.a(a(), paramString1));
        if (TextUtils.isEmpty(paramString1))
        {
          QLog.e("cmshow_scripted_SpriteActionScript", 1, "base role 0 is not exit, now check and download");
          algj.a(a(), 11);
        }
        localJSONObject.put("bubble", paramString1);
        ApolloCmdChannel.getChannel(this.jdField_a_of_type_Alba.a()).callbackFromRequest(this.jdField_a_of_type_Alba.a().getLuaState(), 0, "sc.script_add_bubble.local", localJSONObject.toString());
        return;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifyAddBubble] ", paramString1);
      return;
    }
    String str = albb.a(paramString2, 0, 1);
    paramString2 = albb.a(paramString2, 0, 2);
    if (aknx.a(a()) == 1) {}
    for (paramString1 = str;; paramString1 = paramString2)
    {
      localJSONObject.put("bubble2D", str);
      localJSONObject.put("bubble3D", paramString2);
      localJSONObject.put("bubble", paramString1);
      break;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyAddBubble],text:", paramString2 });
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    String str = paramString1;
    try
    {
      if (TextUtils.isEmpty(paramString1))
      {
        str = paramString1;
        if (a() != null) {
          str = a().getCurrentAccountUin();
        }
      }
      paramString1 = new JSONObject();
      paramString1.put("model", algj.a(str, a()));
      paramString1.put("text", paramString2);
      if (!TextUtils.isEmpty(str)) {
        paramString1.put("uin", str);
      }
      paramString1.put("bubble", albb.a(paramString2, 0, paramInt, aknx.a(a(), str)));
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_Alba.a()).callbackFromRequest(this.jdField_a_of_type_Alba.a().getLuaState(), 0, "sc.script_add_bubble.local", paramString1.toString());
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifyAddBubble] ", paramString1);
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt)
  {
    Object localObject2;
    try
    {
      localObject2 = new File(aliu.jdField_c_of_type_JavaLangString + "/def/role/0/3D");
      localObject1 = new File(aliu.jdField_c_of_type_JavaLangString + "/def/role/0/3D/3DConfig.json");
      if (!((File)localObject2).exists())
      {
        QLog.w("cmshow_scripted_SpriteActionScript", 1, "3D dir NOT exist.");
        return;
      }
      if (!((File)localObject1).exists())
      {
        QLog.w("cmshow_scripted_SpriteActionScript", 1, "3DConfig NOT exist.");
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramJSONObject, new Object[0]);
      return;
    }
    Object localObject1 = aliu.u;
    JSONObject localJSONObject = new JSONObject();
    if (new File((File)localObject2, "1/action.bin").exists()) {
      localJSONObject.put("wait", (String)localObject1 + "1");
    }
    if (new File((File)localObject2, "4/action.bin").exists()) {
      localJSONObject.put("standup", (String)localObject1 + "4");
    }
    if (new File((File)localObject2, "3/action.bin").exists()) {
      localJSONObject.put("think", (String)localObject1 + "3");
    }
    if (new File((File)localObject2, "2/action.bin").exists()) {
      localJSONObject.put("sitdown", (String)localObject1 + "2");
    }
    if (new File((File)localObject2, "android/skeleton/skeleton.bin").exists()) {
      localJSONObject.put("defRole", (String)localObject1 + "android/skeleton");
    }
    if (new File((File)localObject2, "transformAction/3to2/action.bin").exists()) {
      localJSONObject.put("3to2DAction", (String)localObject1 + "transformAction/3to2");
    }
    if ((new File((File)localObject2, "transformAction/2to3/action.atlas").exists()) && (new File((File)localObject2, "transformAction/2to3/action.png").exists()) && (new File((File)localObject2, "transformAction/2to3/action.json").exists())) {
      localJSONObject.put("2to3DAction", (String)localObject1 + "transformAction/2to3");
    }
    if ((paramInt == 2) && (new File((File)localObject2, "friendcard/1/action.bin").exists()))
    {
      localJSONObject.put("friendcard_up", (String)localObject1 + "friendcard/1");
      localJSONObject.put("friendcard_down", (String)localObject1 + "friendcard/2");
    }
    if (new File((File)localObject2, "sayhi/1/action.bin").exists()) {
      localJSONObject.put("sayhi", (String)localObject1 + "sayhi/1");
    }
    if (new File((File)localObject2, "bubble").exists()) {
      localJSONObject.put("bubble", (String)localObject1 + "bubble");
    }
    Object localObject3 = new File((File)localObject2, "android/dress");
    int i;
    if (((File)localObject3).exists())
    {
      localObject2 = new JSONArray();
      localObject3 = ((File)localObject3).listFiles();
      i = localObject3.length;
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt < i)
      {
        Object localObject4 = localObject3[paramInt];
        if ((localObject4 != null) && (localObject4.exists()) && (localObject4.isDirectory())) {
          ((JSONArray)localObject2).put((String)localObject1 + "android/dress/" + localObject4.getName());
        }
      }
      else
      {
        localJSONObject.put("defDress", localObject2);
        paramJSONObject.put("3DObject", localJSONObject);
        return;
      }
      paramInt += 1;
    }
  }
  
  public akrw b(String paramString)
  {
    akra localakra;
    try
    {
      localakra = a();
      if (localakra == null) {
        return null;
      }
      paramString = new JSONObject(paramString);
      if (1 == paramString.optInt("isShow"))
      {
        localakra.bulkApolloBarrages("", new String(bdfr.decode(paramString.optString("text").getBytes("utf-8"), 0)), true);
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
      return null;
    }
    localakra.removeAllApolloBarrages(true);
    return null;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Alba != null) && (this.jdField_a_of_type_Alba.a() != null)) {
      a(this.jdField_a_of_type_Alba.a().getWidth(), this.jdField_a_of_type_Alba.a().getInitHeight(), this.jdField_a_of_type_Alba.a().getHeight(), this.jdField_a_of_type_Alba.jdField_a_of_type_Int, this.jdField_a_of_type_Alba.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Alba.e);
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifySpriteVisibility], status:", Integer.valueOf(paramInt) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("isShow", paramInt);
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_Alba.a()).callbackFromRequest(this.jdField_a_of_type_Alba.a().getLuaState(), 0, "sc.script_set_sprite_visibility.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifySpriteVisibility],", localThrowable);
    }
  }
  
  public akrw c(String paramString)
  {
    QQAppInterface localQQAppInterface;
    try
    {
      if (this.jdField_a_of_type_Alba.e != 0) {
        return null;
      }
      paramString = albi.a(paramString, this.jdField_a_of_type_Alba);
      localQQAppInterface = a();
      if ((paramString == null) || (localQQAppInterface == null)) {
        break label129;
      }
      alaq localalaq = this.jdField_a_of_type_Albf.a();
      if ((localalaq != null) && (!localalaq.a(paramString)))
      {
        if (!QLog.isColorLevel()) {
          break label129;
        }
        QLog.d("cmshow_scripted_SpriteActionScript", 2, "Message can't be sent out without any slave.");
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
      return null;
    }
    localQQAppInterface.a().a(paramString, null);
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "send an action msg, actionId:", Integer.valueOf(paramString.mApolloMessage.id) });
    }
    label129:
    return null;
  }
  
  public void c(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyUsrOperation], status:", Integer.valueOf(paramInt) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("status", paramInt);
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_Alba.a()).callbackFromRequest(this.jdField_a_of_type_Alba.a().getLuaState(), 0, "sc.script_notify_user_operation.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifySpriteVisibility],", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alar
 * JD-Core Version:    0.7.0.1
 */