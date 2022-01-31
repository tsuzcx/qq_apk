import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0x95a.cmd0x95a.GetArActivityRedReq;
import tencent.im.oidb.cmd0x95a.cmd0x95a.GetArActivityRedRsp;
import tencent.im.oidb.cmd0x95a.cmd0x95a.ReqBody;
import tencent.im.oidb.cmd0x95a.cmd0x95a.RspBody;
import tencent.im.oidb.cmd0x95a.cmd0x95a.UpdateArCountRsp;

public class alwr
  extends ajtb
{
  public alwr(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArMapHandler", 2, "reqActRedDotInfo,uin :" + paramLong1 + ",actID :" + paramLong2);
    }
    Object localObject = new cmd0x95a.GetArActivityRedReq();
    ((cmd0x95a.GetArActivityRedReq)localObject).uint64_uin.set(paramLong1);
    ((cmd0x95a.GetArActivityRedReq)localObject).uint64_client_activity_id.set(paramLong2);
    cmd0x95a.ReqBody localReqBody = new cmd0x95a.ReqBody();
    localReqBody.msg_get_ar_activity_red_req.set((MessageMicro)localObject);
    localObject = makeOIDBPkg("OidbSvc.0x95a", 2394, 5, localReqBody.toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("subcmd", 5);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = -1;
    boolean bool;
    int j;
    Object localObject;
    if (paramFromServiceMsg == null)
    {
      bool = false;
      j = paramToServiceMsg.extraData.getInt("subcmd", -1);
      localObject = "";
      if (bool)
      {
        localObject = new cmd0x95a.RspBody();
        i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
        paramFromServiceMsg = paramFromServiceMsg.extraData.getString("str_error_msg");
        if (i == 0) {
          switch (j)
          {
          }
        }
      }
    }
    for (;;)
    {
      localObject = paramFromServiceMsg;
      if (QLog.isColorLevel()) {
        QLog.d("ArMapHandler", 2, "handle0x95a errMsg:" + (String)localObject + ",result:" + i + ",isSuc:" + bool + ",subCmd:" + j);
      }
      return;
      bool = paramFromServiceMsg.isSuccess();
      break;
      if (((cmd0x95a.RspBody)localObject).msg_update_ar_count_rsp.has())
      {
        paramToServiceMsg = (cmd0x95a.UpdateArCountRsp)((cmd0x95a.RspBody)localObject).msg_update_ar_count_rsp.get();
        if (paramToServiceMsg.uint64_uin.has()) {}
        for (long l = paramToServiceMsg.uint64_uin.get();; l = -1L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArMapHandler", 2, "handle0x95a report scanQRCode result,uin = " + l);
          }
          localObject = paramFromServiceMsg;
          break;
        }
        a(paramToServiceMsg, bool, i, (cmd0x95a.RspBody)localObject);
      }
    }
  }
  
  void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean, int paramInt, cmd0x95a.RspBody paramRspBody)
  {
    long l2 = 0L;
    long l1;
    if ((paramBoolean) && (paramInt == 0) && (paramRspBody != null))
    {
      if (!paramRspBody.msg_get_ar_activity_red_rsp.has()) {
        break label177;
      }
      paramToServiceMsg = (cmd0x95a.GetArActivityRedRsp)paramRspBody.msg_get_ar_activity_red_rsp.get();
      if (paramToServiceMsg != null)
      {
        if (!paramToServiceMsg.uint64_uin.has()) {
          break label182;
        }
        l1 = paramToServiceMsg.uint64_uin.get();
        label62:
        if (!paramToServiceMsg.uint32_red_switch.has()) {
          break label188;
        }
      }
    }
    label177:
    label182:
    label188:
    for (paramInt = paramToServiceMsg.uint32_red_switch.get();; paramInt = 0)
    {
      if (paramToServiceMsg.uint64_server_activity_id.has()) {
        l2 = paramToServiceMsg.uint64_server_activity_id.get();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArMapHandler", 2, "handleGetARActRedDotInfo uin:" + l1 + ",redSwitch:" + paramInt + ",actId:" + l2);
      }
      notifyUI(20, paramBoolean, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l2) });
      return;
      paramToServiceMsg = null;
      break;
      l1 = 0L;
      break label62;
    }
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x95a");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends ajte> observerClass()
  {
    return alws.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      do
      {
        return;
        str = paramFromServiceMsg.getServiceCmd();
        if (!msgCmdFilter(str)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ArMapHandler", 2, "onReceive, msgCmdFilter is true,cmd  = " + str);
      return;
    } while (!"OidbSvc.0x95a".equals(str));
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alwr
 * JD-Core Version:    0.7.0.1
 */