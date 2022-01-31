import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleDiyComu.Bubble_GetDiyText_Req;
import com.tencent.mobileqq.bubble.BubbleDiyComu.Bubble_GetDiyText_Rsp;
import com.tencent.mobileqq.bubble.BubbleDiyComu.Bubble_Req;
import com.tencent.mobileqq.bubble.BubbleDiyComu.Bubble_Req_Comm;
import com.tencent.mobileqq.bubble.BubbleDiyComu.Bubble_Rsp;
import com.tencent.mobileqq.bubble.BubbleDiyComu.UserTextInfo;
import com.tencent.mobileqq.bubble.BubbleDiyEntity;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class ambf
  extends ajtb
{
  public ambf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(List<String> paramList, ajte paramajte)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    BubbleDiyComu.Bubble_Req_Comm localBubble_Req_Comm;
    BubbleDiyComu.Bubble_GetDiyText_Req localBubble_GetDiyText_Req;
    ArrayList localArrayList;
    label252:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyHandler", 2, "try fetchDiyTexts: " + TextUtils.join(",", paramList));
      }
      localBubble_Req_Comm = new BubbleDiyComu.Bubble_Req_Comm();
      localBubble_Req_Comm.platform.set(109L);
      localBubble_Req_Comm.osver.set(Build.VERSION.RELEASE);
      localBubble_Req_Comm.mqqver.set("8.3.0");
      localBubble_GetDiyText_Req = new BubbleDiyComu.Bubble_GetDiyText_Req();
      localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label252;
        }
        Object localObject = (String)localIterator.next();
        BubbleDiyComu.UserTextInfo localUserTextInfo = new BubbleDiyComu.UserTextInfo();
        localObject = ((String)localObject).split("_");
        long l1 = 0L;
        if (localObject.length == 2) {}
        try
        {
          long l2 = Long.parseLong(localObject[0]);
          l1 = l2;
          i = Integer.parseInt(localObject[1]);
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            QLog.e("BubbleDiyHandler", 1, "", localNumberFormatException);
            int i = 0;
          }
        }
        if ((l1 > 0L) && (i > 0))
        {
          localUserTextInfo.text_uin.set(l1);
          localUserTextInfo.text_id.set(i);
          localArrayList.add(localUserTextInfo);
        }
      }
      if (!localArrayList.isEmpty()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("BubbleDiyHandler", 2, "no diy id need request: " + TextUtils.join(",", paramList));
    return;
    localBubble_GetDiyText_Req.user_text_info.set(localArrayList);
    paramList = new BubbleDiyComu.Bubble_Req();
    paramList.cmd.set(1);
    paramList.packet_seq.set(System.currentTimeMillis());
    paramList.comm.set(localBubble_Req_Comm);
    paramList.reqcmd_0x01.set(localBubble_GetDiyText_Req);
    paramajte = super.createToServiceMsg("bubble.1", paramajte);
    paramajte.putWupBuffer(paramList.toByteArray());
    super.sendPbReq(paramajte);
  }
  
  protected Class<? extends ajte> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("bubble.1"))
    {
      bool = paramFromServiceMsg.isSuccess();
      localObject = String.valueOf(paramToServiceMsg.getAttribute("_tag_LOGSTR"));
      if (QLog.isColorLevel()) {
        QLog.d("BubbleDiyHandler", 2, "key_seq=" + (String)localObject + " isSuccess=" + bool + " resultCode=" + paramFromServiceMsg.getResultCode());
      }
      if (bool) {
        paramFromServiceMsg = new BubbleDiyComu.Bubble_Rsp();
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        try
        {
          boolean bool;
          paramFromServiceMsg = (BubbleDiyComu.Bubble_Rsp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
          if (paramFromServiceMsg != null) {
            if (paramFromServiceMsg.ret.get() != 0L)
            {
              if (QLog.isColorLevel()) {
                QLog.d("BubbleDiyHandler", 2, "DiyText...fetch key 回包 sso 成功 ，server 失败，ret = " + paramFromServiceMsg.ret.get());
              }
              super.notifyUI(paramToServiceMsg, 1, false, null);
              return;
            }
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          Object localObject;
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("BubbleDiyHandler", 2, "DiyText bubble_Rsp is null 业务回包 异常");
            }
            paramFromServiceMsg = null;
          }
          if ((paramFromServiceMsg.rspcmd_0x01.has()) && (paramFromServiceMsg.rspcmd_0x01.user_text_info.has()))
          {
            paramObject = paramFromServiceMsg.rspcmd_0x01.user_text_info.get();
            paramFromServiceMsg = new ArrayList();
            if (paramObject != null)
            {
              paramObject = paramObject.iterator();
              while (paramObject.hasNext())
              {
                localObject = (BubbleDiyComu.UserTextInfo)paramObject.next();
                if ((((BubbleDiyComu.UserTextInfo)localObject).text.has()) && (((BubbleDiyComu.UserTextInfo)localObject).text_uin.has()) && (((BubbleDiyComu.UserTextInfo)localObject).text_id.has()))
                {
                  try
                  {
                    JSONObject localJSONObject = new JSONObject(((BubbleDiyComu.UserTextInfo)localObject).text.get());
                    BubbleDiyEntity localBubbleDiyEntity = new BubbleDiyEntity();
                    localBubbleDiyEntity.uinAndDiyId = (((BubbleDiyComu.UserTextInfo)localObject).text_uin.get() + "_" + ((BubbleDiyComu.UserTextInfo)localObject).text_id.get());
                    localBubbleDiyEntity.diyText = localJSONObject.optString("diyText");
                    localBubbleDiyEntity.bottomLeftId = localJSONObject.optString("bl");
                    localBubbleDiyEntity.bottomRightId = localJSONObject.optString("br");
                    localBubbleDiyEntity.topLeftId = localJSONObject.optString("tl");
                    localBubbleDiyEntity.topRightId = localJSONObject.optString("tr");
                    paramFromServiceMsg.add(localBubbleDiyEntity);
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.i("BubbleDiyHandler", 2, "onReceive: uinAndDiyId: " + localBubbleDiyEntity.uinAndDiyId + ",config: " + ((BubbleDiyComu.UserTextInfo)localObject).text.get());
                  }
                  catch (Exception localException) {}
                  if (QLog.isColorLevel()) {
                    QLog.e("BubbleDiyHandler", 2, "", localException);
                  }
                }
              }
            }
            ambe.a().a(this.app, true, paramFromServiceMsg);
            super.notifyUI(paramToServiceMsg, 1, true, paramFromServiceMsg);
            return;
          }
          super.notifyUI(paramToServiceMsg, 1, false, null);
          return;
        }
        super.notifyUI(paramToServiceMsg, 1, false, null);
        return;
        super.notifyUI(paramToServiceMsg, 1, false, null);
      } while (!QLog.isColorLevel());
      QLog.d("BubbleDiyHandler", 2, "DiyText isSuccess is false sso通道  异常");
      return;
    }
    QLog.d("BubbleDiyHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ambf
 * JD-Core Version:    0.7.0.1
 */