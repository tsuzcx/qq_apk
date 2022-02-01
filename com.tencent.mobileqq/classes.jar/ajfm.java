import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ajfm
  extends BusinessHandler
{
  public ajfm(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null) || (this.app == null)) {}
    ajfn localajfn;
    do
    {
      do
      {
        return;
        localajfn = (ajfn)this.app.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
      } while (localajfn == null);
      paramToServiceMsg = new oidb_0x5eb.RspBody();
    } while (parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg) != 0);
    if (paramToServiceMsg.rpt_msg_uin_data.has()) {}
    for (paramToServiceMsg = paramToServiceMsg.rpt_msg_uin_data.get();; paramToServiceMsg = null)
    {
      paramFromServiceMsg = localajfn.a(paramToServiceMsg);
      if (paramFromServiceMsg != null) {
        localajfn.a(paramFromServiceMsg);
      }
      notifyUI(1, true, new Object[] { paramToServiceMsg });
      return;
    }
  }
  
  private void a(List<Long> paramList)
  {
    if ((paramList.isEmpty()) || (paramList.size() > 70)) {
      return;
    }
    Object localObject = new oidb_0x5eb.ReqBody();
    ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.set(paramList);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_age.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_gender.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_city.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_province.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_country.set(1);
    localObject = makeOIDBPkg("OidbSvc.0x5eb_troopnotifycation", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("uins", paramList);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null) || (this.app == null)) {}
    label19:
    label52:
    do
    {
      do
      {
        do
        {
          break label19;
          do
          {
            return;
          } while (!paramFromServiceMsg.isSuccess());
          paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
          try
          {
            paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
            paramToServiceMsg = paramFromServiceMsg;
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            int k;
            int j;
            int i;
            break label52;
            paramFromServiceMsg.b(paramObject);
            notifyUI(1, true, new Object[] { paramObject });
          }
        } while ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null) || (paramToServiceMsg.uint32_result.get() != 0));
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        k = PkgTools.getShortData(paramToServiceMsg, 0);
      } while (paramToServiceMsg.length != k * 10 + 2);
      paramFromServiceMsg = (ajfn)this.app.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    } while (paramFromServiceMsg == null);
    paramObject = new ArrayList();
    j = 2;
    i = 0;
    while (i < k)
    {
      long l = PkgTools.getLongData(paramToServiceMsg, j);
      paramObject.add(Long.valueOf(l));
      j += 4;
      int m = PkgTools.getShortData(paramToServiceMsg, j);
      j = j + 2 + 4;
      paramFromServiceMsg.a(l, m);
      i += 1;
    }
  }
  
  private void b(List<Long> paramList)
  {
    if ((paramList.isEmpty()) || (paramList.size() > 70)) {}
    do
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        if ((Long)paramList.get(i) == null) {
          paramList.remove(i);
        }
        i += 1;
      }
    } while (paramList.isEmpty());
    short s = (short)paramList.size();
    Object localObject = ByteBuffer.allocate(paramList.size() * 4 + 2);
    ((ByteBuffer)localObject).putShort(s);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((ByteBuffer)localObject).putInt((int)((Long)paramList.next()).longValue());
    }
    paramList = ((ByteBuffer)localObject).array();
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1640);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramList));
    a("OidbSvc.0x668", ((oidb_sso.OIDBSSOPkg)localObject).toByteArray(), null);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramString = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), paramString);
    paramString.putWupBuffer(paramArrayOfByte);
    if (paramBundle != null) {
      paramString.extraData = paramBundle;
    }
    sendPbReq(paramString);
  }
  
  public void a(List<Long> paramList, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {}
    do
    {
      return;
      if (paramString.equals("OidbSvc.0x5eb_troopnotifycation"))
      {
        a(paramList);
        return;
      }
    } while (!paramString.equals("OidbSvc.0x668"));
    b(paramList);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return ajfp.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      QLog.i("TroopNotificationHandler", 2, "TroopNotificationHandler onReceive res == null || req == null");
    }
    String str;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("TroopNotificationHandler", 2, "TroopNotificationHandler onReceive resultCode:" + paramFromServiceMsg.getResultCode() + "errMsg: " + paramFromServiceMsg.getBusinessFailMsg() + "serviceCmd: " + paramToServiceMsg.getServiceCmd());
      }
      str = paramToServiceMsg.getServiceCmd();
      try
      {
        int i = ((oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject)).uint32_result.get();
        if ((i != 0) && (QLog.isColorLevel())) {
          QLog.i("TroopNotificationHandler", 2, "TroopNotificationHandler onReceive return Error result:" + i + "cmd：" + paramToServiceMsg.getServiceCmd());
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("TroopNotificationHandler", 2, "TroopNotificationHandler onReceive exception: " + localInvalidProtocolBufferMicroException.getMessage() + "cmd：" + paramToServiceMsg.getServiceCmd());
          }
        }
      }
      if ("OidbSvc.0x5eb_troopnotifycation".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x668".equals(str));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfm
 * JD-Core Version:    0.7.0.1
 */