import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.pb.chatbgInfo.chatbgInfo.Bg_Auth_Rst;
import com.tencent.pb.chatbgInfo.chatbgInfo.Bg_CheckAuth_Rsp;
import com.tencent.pb.chatbgInfo.chatbgInfo.Bg_Effect_Auth_Rst;
import com.tencent.pb.chatbgInfo.chatbgInfo.Bg_Rsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;

public class ajtr
  extends ajtd
{
  protected QQAppInterface a;
  
  public ajtr(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  private void a(chatbgInfo.Bg_CheckAuth_Rsp paramBg_CheckAuth_Rsp)
  {
    Object localObject1 = paramBg_CheckAuth_Rsp.AuthEffectRst.get();
    paramBg_CheckAuth_Rsp = new HashMap();
    localObject1 = ((List)localObject1).iterator();
    int i;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (chatbgInfo.Bg_Effect_Auth_Rst)((Iterator)localObject1).next();
      int j = ((chatbgInfo.Bg_Effect_Auth_Rst)localObject2).effectId.get();
      localObject2 = String.valueOf(((chatbgInfo.Bg_Effect_Auth_Rst)localObject2).result.get());
      if ((((String)localObject2).endsWith("001")) || (((String)localObject2).equals("1004"))) {}
      for (i = 0;; i = 1)
      {
        paramBg_CheckAuth_Rsp.put(Integer.valueOf(j), Integer.valueOf(i));
        break;
      }
    }
    localObject1 = ((ChatBackgroundManager)this.a.getManager(63)).e();
    Object localObject2 = this.a.getApplication().getApplicationContext();
    Object localObject3 = this.a.getCurrentAccountUin();
    localObject2 = ((Context)localObject2).getSharedPreferences("chat_background_path_" + (String)localObject3, 0).edit();
    if (localObject1 != null)
    {
      localObject3 = ((HashMap)localObject1).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        i = ((Integer)((HashMap)localObject1).get(str)).intValue();
        if (i > 0) {
          for (;;)
          {
            try
            {
              i = Integer.valueOf(i).intValue();
              if ((!paramBg_CheckAuth_Rsp.containsKey(Integer.valueOf(i))) || (((Integer)paramBg_CheckAuth_Rsp.get(Integer.valueOf(i))).intValue() != 1)) {
                break;
              }
              if (!"_chat_bg_effect".equals(str)) {
                break label366;
              }
              ((SharedPreferences.Editor)localObject2).remove("_chat_bg_effect");
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("ChatBackgroundAuthHandler", 2, "chatBackground auth error: bgEffectId = " + i + " key:" + str);
            }
            catch (Exception localException)
            {
              if (QLog.isColorLevel()) {
                QLog.i("ChatBackgroundAuthHandler", 2, "bgEffectId转化int型出错");
              }
              localException.printStackTrace();
            }
            break;
            label366:
            ((SharedPreferences.Editor)localObject2).remove(localException + "_chat_bg_effect");
          }
        }
      }
      ((SharedPreferences.Editor)localObject2).commit();
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i != 0) {
        paramToServiceMsg = new chatbgInfo.Bg_Rsp();
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.ret.get() != 0L) {
          break label174;
        }
        paramToServiceMsg = (chatbgInfo.Bg_CheckAuth_Rsp)paramToServiceMsg.rspcmd_0x01.get();
        paramObject = paramToServiceMsg.AuthRst.get();
        paramFromServiceMsg = new HashMap();
        paramObject = paramObject.iterator();
        if (!paramObject.hasNext()) {
          break label187;
        }
        Object localObject = (chatbgInfo.Bg_Auth_Rst)paramObject.next();
        j = ((chatbgInfo.Bg_Auth_Rst)localObject).bgId.get();
        localObject = String.valueOf(((chatbgInfo.Bg_Auth_Rst)localObject).result.get());
        if (((String)localObject).endsWith("001")) {
          break label198;
        }
        if (!((String)localObject).equals("1004")) {
          break label181;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        int j;
        paramToServiceMsg.printStackTrace();
      }
      paramFromServiceMsg.put(Integer.valueOf(j), Integer.valueOf(i));
      continue;
      label174:
      return;
      i = 0;
      break;
      label181:
      i = 1;
      continue;
      label187:
      a(paramFromServiceMsg);
      a(paramToServiceMsg);
      return;
      label198:
      i = 0;
    }
  }
  
  public void a(Map<Integer, Integer> paramMap)
  {
    HashMap localHashMap = ((ChatBackgroundManager)this.a.getManager(63)).d();
    SharedPreferences.Editor localEditor = acuv.a(this.a.getApplication().getApplicationContext(), this.a.getCurrentAccountUin(), 0).edit();
    if (localHashMap != null)
    {
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)localHashMap.get(str1);
        if ((str2 != null) && (!str2.equals("null")) && (!str2.equals("custom"))) {
          try
          {
            int i = Integer.valueOf(str2).intValue();
            if ((paramMap.containsKey(Integer.valueOf(i))) && (((Integer)paramMap.get(Integer.valueOf(i))).intValue() == 1))
            {
              localEditor.putString(str1, "null");
              if (QLog.isColorLevel()) {
                QLog.i("ChatBackgroundAuthHandler", 2, "chatBackground auth error: bgId = " + i);
              }
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ChatBackgroundAuthHandler", 2, "背景id转化int型出错");
            }
            localException.printStackTrace();
          }
        }
      }
      localEditor.commit();
    }
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("Background.checkAuth".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatBackgroundAuthHandler", 2, "onReceive called.");
      }
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajtr
 * JD-Core Version:    0.7.0.1
 */