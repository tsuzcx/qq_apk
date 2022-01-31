import com.tencent.mobileqq.apollo.script.SpriteActionMessage.1;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloSlaveInfo;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class airt
{
  private aisd a;
  
  airt(aisd paramaisd)
  {
    this.a = paramaisd;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new SpriteActionMessage.1(this, paramInt, paramBoolean));
  }
  
  private void a(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {
      QLog.e("cmshow_scripted_SpriteActionMessage", 1, "[tiggerAction] actionData is null,return.");
    }
    aisk localaisk;
    do
    {
      return;
      localaisk = new aisk();
      localaisk.f = paramApolloActionData.actionId;
      localaisk.jdField_c_of_type_Int = 0;
      localaisk.g = 3;
      localaisk.e = paramApolloActionData.personNum;
      localaisk.jdField_a_of_type_Long = -10000L;
      localaisk.jdField_a_of_type_Boolean = true;
      localaisk.b = false;
      localaisk.jdField_c_of_type_JavaLangString = paramApolloActionData.bubbleText;
    } while ((this.a == null) || (this.a.a() == null));
    localaisk.jdField_a_of_type_JavaLangString = String.valueOf(this.a.a().getCurrentAccountUin());
    ((aisi)this.a.a().getManager(249)).a().a(localaisk);
  }
  
  private void a(String paramString)
  {
    airu localairu;
    if ((this.a != null) && (this.a.a() != null))
    {
      localairu = aisl.a(this.a.a());
      if (localairu != null) {}
    }
    else
    {
      return;
    }
    localairu.a("", paramString);
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if ((this.a == null) || (this.a.a() == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = this.a.a();
    ApolloActionData localApolloActionData = ((aiyu)localQQAppInterface.getManager(155)).a(paramInt);
    String str = ajjy.a(2131648516);
    if (localApolloActionData == null)
    {
      a(str);
      return;
    }
    localApolloActionData.bubbleText = str;
    if (!ApolloUtil.a(paramInt, localApolloActionData.personNum))
    {
      ((aifg)localQQAppInterface.getManager(153)).a(localApolloActionData, 4);
      a(str);
      return;
    }
    a(localApolloActionData);
  }
  
  public boolean a(MessageForApollo paramMessageForApollo)
  {
    int k = 2;
    int j = 0;
    if ((paramMessageForApollo.actionType != 5) || (this.a == null) || (this.a.a() == null)) {
      return true;
    }
    QQAppInterface localQQAppInterface = this.a.a();
    String str1 = paramMessageForApollo.extendJson;
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionMessage", 2, new Object[] { "rep data:", str1 });
    }
    for (;;)
    {
      int i;
      boolean bool1;
      boolean bool2;
      try
      {
        paramMessageForApollo = new JSONObject(paramMessageForApollo.extendJson);
        if (!paramMessageForApollo.has("data")) {
          break label332;
        }
        String str2 = localQQAppInterface.getCurrentAccountUin();
        JSONObject localJSONObject = paramMessageForApollo.getJSONObject("data");
        JSONArray localJSONArray = localJSONObject.getJSONArray("slaveInfoList");
        Object localObject = null;
        str1 = null;
        paramMessageForApollo = localObject;
        if (localJSONArray != null)
        {
          paramMessageForApollo = localObject;
          if (localJSONArray.length() > 0)
          {
            i = 0;
            paramMessageForApollo = str1;
            if (i < localJSONArray.length())
            {
              paramMessageForApollo = (ApolloSlaveInfo)azxx.a(localJSONArray.getJSONObject(i), ApolloSlaveInfo.class);
              if (!str2.equals(String.valueOf(paramMessageForApollo.uin))) {
                continue;
              }
            }
          }
        }
        if (paramMessageForApollo == null) {
          break label324;
        }
        i = paramMessageForApollo.slaveTotal;
        if (paramMessageForApollo.isCaptured == 1)
        {
          bool1 = true;
          int m = localJSONObject.optInt("defaultActId");
          a(i, bool1);
          if ((bool1) || (i != 0)) {
            break label318;
          }
          a(m);
          bool2 = false;
          break label343;
          bajr.a(localQQAppInterface, "cmshow", "Apollo", "clickslaveaction", j, i, new String[0]);
          return bool2;
          i += 1;
          continue;
        }
        bool1 = false;
        continue;
        if (i > 0) {
          i = k;
        } else {
          i = 3;
        }
      }
      catch (Exception paramMessageForApollo)
      {
        QLog.i("cmshow_scripted_SpriteActionMessage", 1, "[handleSendMsg] Exception", paramMessageForApollo);
        return true;
      }
      if (i == 0)
      {
        i = 0;
      }
      else
      {
        i = 1;
        break label355;
        label318:
        bool2 = true;
        break label343;
        label324:
        bool1 = false;
        i = 0;
        continue;
        label332:
        bool1 = false;
        i = 0;
        bool2 = true;
        break label355;
        label343:
        if (!bool1) {
          continue;
        }
        if (i < 5) {
          continue;
        }
        i = 1;
      }
      label355:
      if (bool1) {
        j = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     airt
 * JD-Core Version:    0.7.0.1
 */