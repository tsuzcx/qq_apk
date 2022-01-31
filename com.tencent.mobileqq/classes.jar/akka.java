import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.addfriendverifi.data.AddFriendBlockedInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xd7e.oidb_cmd0xd7e.ReqBody;
import tencent.im.oidb.cmd0xd82.oidb_cmd0xd82.ReqBody;
import tencent.im.oidb.cmd0xd82.oidb_cmd0xd82.RspBody;
import tencent.im.oidb.cmd0xd83.oidb_cmd0xd83.BlockedInfo;
import tencent.im.oidb.cmd0xd83.oidb_cmd0xd83.ReqBody;
import tencent.im.oidb.cmd0xd83.oidb_cmd0xd83.RspBody;
import tencent.im.oidb.cmd0xd86.oidb_cmd0xd86.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class akka
  extends ajtd
{
  private akkb a;
  
  public akka(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = ((akkb)paramQQAppInterface.getManager(332));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.handler", 1, "handleGetAddFriendBlockedRedPoint");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null)) {
      if (this.a != null) {
        this.a.b(true);
      }
    }
    while (this.a == null) {
      return;
    }
    this.a.b(paramFromServiceMsg.isSuccess());
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.handler", 1, "handleGetAddFriendBlockedRedPoint");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null)) {
      if (this.a != null) {
        this.a.a(true, false, false, "");
      }
    }
    label45:
    while (!paramFromServiceMsg.isSuccess()) {
      return;
    }
    for (;;)
    {
      int j;
      long l;
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = new oidb_cmd0xd82.RspBody();
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        int i = paramFromServiceMsg.uint32_entrance.get();
        j = paramFromServiceMsg.uint32_redpoint.get();
        l = paramFromServiceMsg.uint64_blocked_uin.get();
        if (this.a == null) {
          break label45;
        }
        paramToServiceMsg = this.a;
        if (i != 1) {
          break label183;
        }
        bool1 = true;
      }
      catch (Exception paramToServiceMsg) {}
      paramToServiceMsg.a(true, bool1, bool2, String.valueOf(l));
      return;
      if (this.a == null) {
        break;
      }
      this.a.a(true, false, false, "");
      return;
      label183:
      boolean bool1 = false;
      while (j != 1)
      {
        bool2 = false;
        break;
      }
      boolean bool2 = true;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.handler", 1, "handleGetAddFriendBlockedList");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null))
    {
      if (this.a != null)
      {
        this.a.a(false, false, "");
        this.a.a(false, null, "");
      }
      return;
    }
    Object localObject;
    for (;;)
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          break;
        }
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = new oidb_cmd0xd83.RspBody();
        paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramObject = paramToServiceMsg.rpt_block_list.get();
        paramFromServiceMsg = new ArrayList();
        paramObject = paramObject.iterator();
        if (!paramObject.hasNext()) {
          break label369;
        }
        localObject = (oidb_cmd0xd83.BlockedInfo)paramObject.next();
        long l = ((oidb_cmd0xd83.BlockedInfo)localObject).uint64_uin.get();
        AddFriendBlockedInfo localAddFriendBlockedInfo = new AddFriendBlockedInfo();
        localAddFriendBlockedInfo.jdField_a_of_type_JavaLangString = String.valueOf(l);
        localAddFriendBlockedInfo.jdField_b_of_type_JavaLangString = ((oidb_cmd0xd83.BlockedInfo)localObject).bytes_nick.get().toStringUtf8();
        localAddFriendBlockedInfo.jdField_a_of_type_Int = ((oidb_cmd0xd83.BlockedInfo)localObject).uint32_age.get();
        localAddFriendBlockedInfo.jdField_b_of_type_Int = ((oidb_cmd0xd83.BlockedInfo)localObject).uint32_sex.get();
        if (((oidb_cmd0xd83.BlockedInfo)localObject).uint32_has_read.get() != 1) {
          break label363;
        }
        bool = true;
        localAddFriendBlockedInfo.jdField_a_of_type_Boolean = bool;
        localAddFriendBlockedInfo.jdField_c_of_type_JavaLangString = ((oidb_cmd0xd83.BlockedInfo)localObject).bytes_source.get().toStringUtf8();
        localAddFriendBlockedInfo.jdField_a_of_type_Long = ((oidb_cmd0xd83.BlockedInfo)localObject).uint32_time.get();
        localAddFriendBlockedInfo.jdField_c_of_type_Int = ((oidb_cmd0xd83.BlockedInfo)localObject).uint32_comm_frd.get();
        paramFromServiceMsg.add(localAddFriendBlockedInfo);
        if (!QLog.isDebugVersion()) {
          continue;
        }
        QLog.d("NewFriendVerification.handler", 2, " handleGetAddFriendBlockedList()--> blockedInfo =  " + localAddFriendBlockedInfo.toString());
        continue;
        if (this.a == null) {
          break;
        }
      }
      catch (Exception paramToServiceMsg) {}
      this.a.a(false, false, "");
      this.a.a(false, null, "");
      return;
      label363:
      bool = false;
    }
    label369:
    paramObject = paramToServiceMsg.bytes_cookies.get().toStringUtf8();
    int i = paramToServiceMsg.uint32_entrance.get();
    if (paramFromServiceMsg.size() > 0)
    {
      paramToServiceMsg = ((AddFriendBlockedInfo)paramFromServiceMsg.get(0)).jdField_a_of_type_JavaLangString;
      label412:
      if (this.a == null) {
        break label458;
      }
      localObject = this.a;
      if (i != 1) {
        break label460;
      }
    }
    label458:
    label460:
    for (boolean bool = true;; bool = false)
    {
      ((akkb)localObject).a(true, bool, paramToServiceMsg);
      this.a.a(true, paramFromServiceMsg, paramObject);
      return;
      paramToServiceMsg = "";
      break label412;
      break;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.handler", 1, "handleReportAddFriendBlocked");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null)) {
      if (this.a != null) {
        this.a.a(false);
      }
    }
    while (this.a == null) {
      return;
    }
    this.a.a(paramFromServiceMsg.isSuccess());
  }
  
  protected void a(String paramString)
  {
    try
    {
      oidb_cmd0xd7e.ReqBody localReqBody = new oidb_cmd0xd7e.ReqBody();
      localReqBody.uin.set(Long.parseLong(paramString));
      sendPbReq(makeOIDBPkg("OidbSvc.oidb_0xd7e", 3454, 0, localReqBody.toByteArray()));
      return;
    }
    catch (NumberFormatException paramString)
    {
      while (this.a == null) {}
      this.a.b(false);
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      oidb_cmd0xd83.ReqBody localReqBody = new oidb_cmd0xd83.ReqBody();
      localReqBody.uint64_uin.set(Long.parseLong(paramString1));
      localReqBody.uint32_req_num.set(paramInt);
      localReqBody.bytes_cookies.set(ByteStringMicro.copyFromUtf8(paramString2));
      sendPbReq(makeOIDBPkg("OidbSvc.oidb_0xd83", 3459, 0, localReqBody.toByteArray()));
      return;
    }
    catch (NumberFormatException paramString1)
    {
      while (this.a == null) {}
      this.a.a(false, false, "");
      this.a.a(false, null, "");
    }
  }
  
  protected void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    try
    {
      oidb_cmd0xd86.ReqBody localReqBody = new oidb_cmd0xd86.ReqBody();
      localReqBody.uin.set(Long.parseLong(paramString1));
      localReqBody.blocked_uin.set(Long.parseLong(paramString2));
      localReqBody.source_id.set(paramInt1);
      localReqBody.sub_sourceid.set(paramInt2);
      localReqBody.group_uin.set(Long.parseLong(paramString3));
      sendPbReq(makeOIDBPkg("OidbSvc.oidb_0xd86", 3462, 0, localReqBody.toByteArray()));
      return;
    }
    catch (NumberFormatException paramString1)
    {
      while (this.a == null) {}
      this.a.a(false);
    }
  }
  
  protected void b(String paramString)
  {
    try
    {
      oidb_cmd0xd82.ReqBody localReqBody = new oidb_cmd0xd82.ReqBody();
      localReqBody.uin.set(Long.parseLong(paramString));
      sendPbReq(makeOIDBPkg("OidbSvc.oidb_0xd82", 3458, 0, localReqBody.toByteArray()));
      return;
    }
    catch (NumberFormatException paramString)
    {
      while (this.a == null) {}
      this.a.a(false, false, false, "");
    }
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return akke.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.oidb_0xd86".equals(paramFromServiceMsg.getServiceCmd())) {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("OidbSvc.oidb_0xd83".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.oidb_0xd82".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.oidb_0xd7e".equals(paramFromServiceMsg.getServiceCmd()));
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akka
 * JD-Core Version:    0.7.0.1
 */